package uk.co.mainwave.customjunitannotation

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(TicketTestRunner::class)
class ExampleUnitTest {
    @Test
    @TestsTickets("JIRA-001", "JIRA-002")
    fun `test addition is correct`() {
        assertEquals(4, 2 + 2)
    }

    @Test
    @TestsTickets("JIRA-003")
    fun `test division is correct`() {
        assertEquals(2, 4 / 2)
    }
}
