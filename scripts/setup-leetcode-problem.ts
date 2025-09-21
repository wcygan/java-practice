#!/usr/bin/env -S deno run --allow-net --allow-read --allow-write

/**
 * Script to fetch LeetCode problem and set up directory structure with Solution.java
 * Usage: deno run --allow-net --allow-read --allow-write scripts/setup-leetcode-problem.ts <leetcode-url>
 * Example: deno run --allow-net --allow-read --allow-write scripts/setup-leetcode-problem.ts https://leetcode.com/problems/path-sum/description/
 */

import { ensureDir } from "jsr:@std/fs";
import { join } from "jsr:@std/path";

interface ProblemInfo {
  number: number;
  title: string;
  titleSlug: string;
  difficulty: "Easy" | "Medium" | "Hard";
  description: string;
  url: string;
  javaCode: string;
}

function extractProblemSlug(url: string): string {
  const match = url.match(/\/problems\/([^\/]+)/);
  if (!match) {
    throw new Error(`Invalid LeetCode URL: ${url}`);
  }
  return match[1];
}

async function fetchProblemInfo(problemSlug: string): Promise<ProblemInfo> {
  const query = `
    query questionData($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        questionId
        title
        titleSlug
        difficulty
        content
        codeSnippets {
          lang
          code
        }
      }
    }
  `;

  const response = await fetch("https://leetcode.com/graphql", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "User-Agent": "Mozilla/5.0 (compatible; LeetCode Problem Fetcher)",
    },
    body: JSON.stringify({
      query,
      variables: { titleSlug: problemSlug },
    }),
  });

  if (!response.ok) {
    throw new Error(`Failed to fetch problem: ${response.statusText}`);
  }

  const data = await response.json();
  
  if (!data.data?.question) {
    throw new Error(`Problem not found: ${problemSlug}`);
  }

  const question = data.data.question;
  const javaSnippet = question.codeSnippets?.find((snippet: any) => snippet.lang === "Java");
  
  return {
    number: parseInt(question.questionId),
    title: question.title,
    titleSlug: question.titleSlug,
    difficulty: question.difficulty,
    description: question.content,
    url: `https://leetcode.com/problems/${problemSlug}/`,
    javaCode: javaSnippet?.code || "",
  };
}

function formatTitle(title: string): string {
  return title
    .replace(/[^\w\s]/g, "") // Remove special characters
    .replace(/\s+/g, "") // Remove spaces
    .replace(/^./, (c) => c.toUpperCase()); // Capitalize first letter
}

function formatDescription(description: string): string {
  // Basic HTML to text conversion for comments
  return description
    .replace(/<[^>]*>/g, "") // Remove HTML tags
    .replace(/&lt;/g, "<")
    .replace(/&gt;/g, ">")
    .replace(/&amp;/g, "&")
    .replace(/&quot;/g, '"')
    .replace(/&#39;/g, "'")
    .split("\n")
    .map(line => line.trim())
    .filter(line => line.length > 0)
    .map(line => ` * ${line}`)
    .join("\n");
}

function needsTreeNodeImport(javaCode: string): boolean {
  return javaCode.includes("TreeNode");
}

function needsListNodeImport(javaCode: string): boolean {
  return javaCode.includes("ListNode");
}

function generateSolutionJava(problemInfo: ProblemInfo): string {
  const { number, title, difficulty, description, url, javaCode } = problemInfo;
  const formattedTitle = formatTitle(title);
  const difficultyLower = difficulty.toLowerCase();
  const packageName = `io.wcygan.questions.leetcode.${difficultyLower}.q${number}${formattedTitle}`;
  
  // Generate imports
  const imports = [];
  if (needsTreeNodeImport(javaCode)) {
    imports.push("import io.wcygan.questions.leetcode.TreeNode;");
  }
  if (needsListNodeImport(javaCode)) {
    imports.push("import io.wcygan.questions.leetcode.ListNode;");
  }
  
  const importSection = imports.length > 0 ? `\n${imports.join("\n")}\n` : "";
  
  // Clean and format the Java code
  const cleanedJavaCode = javaCode
    .replace(/^public class Solution \{/, "class Solution {")  // Remove public modifier
    .replace(/^\s*\/\*\*[\s\S]*?\*\/\s*/m, "")  // Remove the data structure definition comment
    .trim();
  
  return `package ${packageName};${importSection}
/**
 * ${number}. ${title}
 * 
 * Difficulty: ${difficulty}
 * URL: ${url}
 * 
${formatDescription(description)}
 */
${cleanedJavaCode}
`;
}

async function setupProblem(url: string): Promise<void> {
  console.log(`🔍 Fetching problem from: ${url}`);
  
  const problemSlug = extractProblemSlug(url);
  const problemInfo = await fetchProblemInfo(problemSlug);
  
  console.log(`📝 Found: ${problemInfo.number}. ${problemInfo.title} (${problemInfo.difficulty})`);
  
  const formattedTitle = formatTitle(problemInfo.title);
  const difficultyLower = problemInfo.difficulty.toLowerCase();
  const directoryName = `q${problemInfo.number}${formattedTitle}`;
  
  // Create directory path
  const baseDir = "src/main/java/io/wcygan/questions/leetcode";
  const problemDir = join(baseDir, difficultyLower, directoryName);
  
  console.log(`📁 Creating directory: ${problemDir}`);
  await ensureDir(problemDir);
  
  // Generate Solution.java
  const solutionPath = join(problemDir, "Solution.java");
  const solutionContent = generateSolutionJava(problemInfo);
  
  console.log(`📄 Creating: ${solutionPath}`);
  await Deno.writeTextFile(solutionPath, solutionContent);
  
  // Check if test directory exists and create test file
  const testBaseDir = "src/test/java/io/wcygan/questions/leetcode";
  const testDir = join(testBaseDir, difficultyLower, directoryName);
  const testPath = join(testDir, "SolutionTest.java");
  
  try {
    await Deno.stat(testBaseDir);
    await ensureDir(testDir);
    
    const testContent = generateTestJava(problemInfo);
    console.log(`🧪 Creating test: ${testPath}`);
    await Deno.writeTextFile(testPath, testContent);
  } catch {
    console.log(`⚠️  Test directory not found, skipping test creation`);
  }
  
  console.log(`✅ Successfully set up: ${problemInfo.number}. ${problemInfo.title}`);
  console.log(`📂 Location: ${problemDir}`);
}

function generateTestJava(problemInfo: ProblemInfo): string {
  const { number, title, difficulty } = problemInfo;
  const formattedTitle = formatTitle(title);
  const difficultyLower = difficulty.toLowerCase();
  const packageName = `io.wcygan.questions.leetcode.${difficultyLower}.q${number}${formattedTitle}`;
  
  return `package ${packageName};

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testExample1() {
        // TODO: Add test cases
    }
}
`;
}

// Main execution
if (import.meta.main) {
  const args = Deno.args;
  
  if (args.length !== 1) {
    console.error("Usage: deno run --allow-net --allow-read --allow-write scripts/setup-leetcode-problem.ts <leetcode-url>");
    console.error("Example: deno run --allow-net --allow-read --allow-write scripts/setup-leetcode-problem.ts https://leetcode.com/problems/path-sum/description/");
    Deno.exit(1);
  }
  
  const url = args[0];
  
  try {
    await setupProblem(url);
  } catch (error) {
    console.error(`❌ Error: ${error.message}`);
    Deno.exit(1);
  }
}