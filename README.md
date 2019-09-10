# Custom JUnit Annotation

## Usage

Add `@TestsTickets` to a unit test to annotate which tickets it tests, e.g.

```kotlin
    @Test
    @TestsTickets("JIRA-001", "JIRA-002")
    fun `test addition is correct`() {
        assertEquals(4, 2 + 2)
    }
```

## Output

Run

```
gradlew testDebug
```

then look at the test output HTML in `app/build/reports/tests`.
