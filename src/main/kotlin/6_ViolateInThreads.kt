

//Test Code (without @Volatile) – this may never stop
@Volatile
var running = true

fun main() {
    val printer = Printer()
    printer.start()

    Thread.sleep(1000)
    println("Main: setting running = false")
    running = false
    printer.join()
    println("Main thread finished")
}

class Printer : Thread() {
    override fun run() {
        while (running) {
            // empty loop → fast → cached values used
        }
        println("Printer thread stopped")
    }
}
