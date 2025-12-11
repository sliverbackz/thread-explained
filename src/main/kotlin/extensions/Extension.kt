package extensions

fun Thread.printAll() {
    println("Name: ${name}")
    println("ID: ${id}")
    println("Alive: ${isAlive}")
    println("Priority: ${priority}")
    println("Daemon: ${isDaemon}")
}