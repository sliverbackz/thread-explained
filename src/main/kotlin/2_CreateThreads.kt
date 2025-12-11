import extensions.printAll
import kotlin.concurrent.thread


//By extending Thread class
class HelloThread : Thread() {
    override fun run() {
        val helloMsg = "Hello, i'm $name"
        println(helloMsg)
    }
}

fun spawnHelloThread() {
    val helloThread = HelloThread()
    helloThread.printAll()
}

//By implementing Runnable interface
class HelloRunnable : Runnable {
    override fun run() {
        val threadName = Thread.currentThread().name
        val helloMsg = "Hello, i'm $threadName"
        println(helloMsg)
    }
}

fun spawnHelloRunnable() {
    val helloRunnable = Thread(HelloRunnable(), "my-thread")
    helloRunnable.printAll()
}

//Kotlin’s SAM-conversion + lambda syntax
fun spawnInLambdaWay() {
    Thread { println("Hello, i'm ${Thread.currentThread().name}") }.start()
}

//kotlin way using thread fun from kotlin.concurrent.thread
fun spawnKotlinWay() {
    //default start = true and will run thread immediately
    val t1 = thread(start = false, name = "Thread 1", block = {
        println("Hello, I'm ${Thread.currentThread().name}")
    })
    t1.start()
}


fun main() {
    spawnHelloThread()
    spawnHelloRunnable()
    spawnInLambdaWay()
    spawnKotlinWay()
    println("Finished")
}

