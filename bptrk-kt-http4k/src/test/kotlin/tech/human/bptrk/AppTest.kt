package tech.human.bptrk

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AppTest {

	@Test
	fun appTestBasic() {
		println("Running TEST")
		val app = App();
		assertEquals("FAIL", app.greeting)
	}
}