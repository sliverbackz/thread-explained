// This example shows two situations:
// 1. When the main thread crashes → the whole program stops.
// 2. When a custom thread crashes → only that thread stops, but the main continues.
// If you want to test Case 2, you can comment line 7 and 8.

fun main() {
    println("=== Case 1: Main thread crashes ===")
    mainThreadCrashes()

    println("\n=== Case 2: Custom thread crashes ===")
    customThreadCrashes()
}

// ------------------------------------------------------------
// Case 1: MAIN THREAD CRASHES
// ------------------------------------------------------------
fun mainThreadCrashes() {
    println("Main thread is running...")

    // This line throws an exception in the main thread.
    // When it crashes, the whole JVM process stops immediately.
    // Nothing after this line will run.
    println(10 / 0)

    // This line will never be reached.
    println("This never prints because main has crashed!")
}

// ------------------------------------------------------------
// Case 2: CUSTOM THREAD CRASHES
// ------------------------------------------------------------
class FailingThread : Thread() {
    override fun run() {
        println("Custom thread started...")
        // This will throw an exception inside this custom thread only.
        "abc".toInt()   // NumberFormatException
        println("This will never be printed.")
    }
}

fun customThreadCrashes() {
    val t = FailingThread()
    t.start()
    t.join()  // Wait for custom thread to finish (even if it crashed)

    // The main thread is still alive even though the custom thread failed.
    println("Main thread continues normally after custom thread failure.")
}


