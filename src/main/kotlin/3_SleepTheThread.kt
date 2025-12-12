/**
 * A simple worker thread that prints a message repeatedly at one–second intervals.
 *
 * @property message The text to be printed each time the thread runs a cycle.
 * @property time The number of times the message will be printed.
 *
 * When the thread is started, it executes independently of the main thread.
 * The `run()` function loops for the specified count, printing the message and
 * pausing for one second (`sleep(1000)`) on each iteration. This allows timed
 * notifications without blocking the caller.
 */

class MessageNotifier(private val message: String, private val time: Int) : Thread() { // implement the constructor
    override fun run() {
        repeat(time) {
            println(message)
            sleep(1000) // message will print and it will sleep for 1 second
        }
    }
}

fun main() {
    val messageNotifier = MessageNotifier("Hi, I'm Zaine", 30)
    messageNotifier.start()
}