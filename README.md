# Custom JUnit Annotation [![CircleCI](https://circleci.com/gh/markwhitaker/CustomJUnitAnnotation.svg?style=shield)](https://circleci.com/gh/markwhitaker/CustomJUnitAnnotation)

## Description

A custom JUnit annotation and test runner to document which requirement (e.g. JIRA ticket, requirement IDs, etc.) a test relates to.

## Rationale

This could be useful to introduce traceability from a requirement to a unit test that validates that requirement.

You could just include the ticket name in the test name (especially with Kotlin backtick-style function names), e.g.

```kotlin
fun `test a feature (JIRA-123)`() {
}

```

But this has some drawbacks:

1. A test may be modified by subsequent tickets, and hence need to be linked to several tickets, and the function names could quickly get out of hand.
2. That's a very hard-coded approach. If there's a later requirement to report on the ticket-to-test links in a different format (not necessarily in the test output report), it would be really difficult to implement.

Introducing a test annotation and test runner lets you mark up individual unit tests in a nice, decoupled way. The test runner currently appends the ticket names to the end of the test name in the test report, but could easily be adapted to produce output in a different format.

## Usage

1. Add `@RunWith(RequirementTrackingTestRunner::class)` to your test class
2. Add `@TestsRequirements` to a unit test to annotate which tickets it tests

## Example

```kotlin
@RunWith(RequirementTrackingTestRunner::class)
class ExampleUnitTest {
    @Test
    @TestsRequirements("JIRA-001", "JIRA-002")
    fun `test addition is correct`() {
        assertEquals(4, 2 + 2)
    }

    @Test
    @TestsRequirements("JIRA-003")
    fun `test division is correct`() {
        assertEquals(2, 4 / 2)
    }
}
```

## Output

Run

```
gradlew testDebug
```

then look at the test output HTML in `app/build/reports/tests`.
