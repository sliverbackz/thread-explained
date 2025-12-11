

fun main() {
    val t = Thread.currentThread()
    //you can change its properties
    t.name = "My-thread"
    println("Name: ${t.name}")
    println("ID: ${t.id}")
    println("Alive: ${t.isAlive}")
    println("Priority: ${t.priority}")
    println("Daemon: ${t.isDaemon}")
    println(Thread.MAX_PRIORITY)
    println(Thread.MIN_PRIORITY)
}