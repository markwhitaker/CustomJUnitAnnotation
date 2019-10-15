package uk.co.mainwave.customjunitannotation

import org.junit.runner.Description
import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runners.model.FrameworkMethod

class RequirementTrackingTestRunner(c: Class<*>) : BlockJUnit4ClassRunner(c) {
    override fun describeChild(method: FrameworkMethod?): Description {
        val testsTicketsAnnotation = method?.getAnnotation(TestsRequirements::class.java)
        return if (testsTicketsAnnotation == null) {
            super.describeChild(method)
        } else {
            // Return the test name with the ticket names appended in brackets
            val methodName = method.name
            val ticketList = testsTicketsAnnotation.tickets.joinToString(", ")
            Description.createTestDescription(
                method.method.declaringClass,
                "$methodName ($ticketList)"
            )
        }
    }
}
