package uk.co.mainwave.customjunitannotation

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith

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
