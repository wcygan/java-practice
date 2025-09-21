# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java practice repository focused on data structures, algorithms, concurrency, and LeetCode problems. The codebase is organized into distinct packages for different types of implementations and includes comprehensive testing with both traditional JUnit tests and property-based testing.

## Build System & Commands

This project uses Gradle with the wrapper included.

### Core Development Commands

```bash
# Run all tests
./gradlew test

# Run specific test class
./gradlew test --tests <TestClassName>

# Run specific test method
./gradlew test --tests io.wcygan.package.ClassName.methodName

# Format code (Palantir Java Format)
./gradlew formatApply

# Build fat jar with all dependencies
./gradlew shadowJar

# Build jar with only application classes
./gradlew jar

# Run JMH benchmarks
./gradlew jmh

# Setup new LeetCode problem
deno task setup-leetcode <leetcode-url>
```

### Testing Strategy

- Uses JUnit 5 with parallel test execution (half of available processors)
- Property-based testing with JUnit-Quickcheck for algorithm verification
- Tests are organized in `src/test/java` mirroring the main source structure
- Example property-based test: `SortingQuickCheckTest.java`

## Code Architecture

### Package Structure

- **`io.wcygan.algorithms`** - Core algorithms (sorting, graph traversal, dynamic programming)
- **`io.wcygan.collections`** - Custom data structure implementations (trees, graphs, caches, queues)
- **`io.wcygan.concurrent`** - Thread-safe collections and concurrency examples
- **`io.wcygan.questions.leetcode`** - LeetCode problem solutions organized by difficulty
- **`io.wcygan.modern`** - Modern Java features and utilities
- **`io.wcygan.common`** - Shared utilities and helper classes

### Key Implementation Patterns

- **Interface-based design** - Most collections implement common interfaces (e.g., `SearchTree`, `Queue`, `Cache`)
- **Test-driven development** - Comprehensive test coverage including edge cases
- **Concurrent collections** - Lock-free and thread-safe implementations using atomic operations
- **Generic implementations** - Heavy use of Java generics for type safety

### Notable Implementations

- **Lock-free data structures** in `concurrent.collections` package
- **Red-Black Tree** with detailed balancing logic
- **Graph algorithms** with pluggable implementations
- **JMH benchmarks** in `src/jmh` for performance testing
- **Property-based tests** for algorithm correctness verification

## Dependencies

- **Guava** - Google's core libraries
- **Apache Commons Lang** - String and utility functions
- **ParseQ** - LinkedIn's framework for building parallel async tasks
- **AssertJ** - Fluent assertions for tests
- **JUnit-Quickcheck** - Property-based testing framework
- **SLF4J** - Logging facade

## Development Notes

- Code is automatically formatted using Palantir Java Format
- Tests run in parallel by default for faster feedback
- JMH benchmarks configured for statistical significance (50 warmup iterations, 50 test iterations)
- Property-based tests use `@Property` annotation with configurable trial counts

## LeetCode Problem Setup

The project includes a Deno TypeScript script that automatically fetches LeetCode problems and sets up the proper directory structure:

- **Fetches problem metadata** from LeetCode's GraphQL API
- **Creates directory structure** following the pattern: `{difficulty}/q{number}{FormattedTitle}/`
- **Generates Solution.java** with proper package, imports (TreeNode/ListNode), and method signatures
- **Creates corresponding test file** with JUnit 5 + AssertJ setup
- **Handles both TreeNode and ListNode** problems with appropriate imports

Example: `deno task setup-leetcode https://leetcode.com/problems/path-sum/description/`