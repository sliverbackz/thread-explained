import kotlin.concurrent.thread
import kotlin.text.toInt


//If main thread is encountered an exception, custom threads won't reach its execution.
fun main() {
    mainDoesNotAffectedByCustomThread()
    customThreadNeverWork()
}

//Main failed cases
//Process finished with exit code 1 (error)
fun customThreadNeverWork() {
    val mainThread = Thread.currentThread()
    println("Hello from the main ${mainThread.name}")
    print(2 / 0)
    //below code block will never work coz of main is in exception
    val t1 = thread(block = {
        println("Hello from the a custom thread!")
    })
    println("Print custom thread name ${t1.name}")
    println("Bye from the main ${mainThread.name}")
}

// program will be terminated
fun divideByZeroCaughtInMainThread() {
    println(2 / 0)
    println("I'm printed after being terminated!") // this will never be printed
    //The code 1 means that the process was finished with an error.
}


//If custom threads are encountered an exception, main thread does affect at all.
class CustomThread : Thread() {
    override fun run() {
        "s".toInt()
    }
}

fun divideByZeroCaughtInCustomThread() {
    val thread = CustomThread()
    thread.start()
    thread.join() // wait for the thread with an exception to terminate
    println("I'm printed!") // this can still be printed
    //The code 0 means that the process is successfully finished.
}

fun mainDoesNotAffectedByCustomThread() {
    val t = CustomThread()
    t.start()
    t.join()
    println("I'm ${Thread.currentThread().name}")
}


