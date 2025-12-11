
/**
1.The first application always outputs the text in the same order

2.In the first application, threads t1, t2, t3 may work in parallel ✅

3.The second application always outputs the text in the same order ✅

4.In both applications, the main thread waits for t1, t2, t3 ✅

5.In the second application, threads t1, t2, t3 may work in parallel
 **/

fun main(){
    Application2().startWork()
}


class Worker(val line: String) : Thread() {
    override fun run() {
        println(line)
    }
}

class Application1 {
    fun startWork() {
        //t1,t2,t3 are gonna in parallel, Main thread will wait until they have done.
        val t1 = Worker("Hello from t1")
        val t2 = Worker("Hello from t2")
        val t3 = Worker("Hello from t3")
        t1.start()
        t2.start()
        t3.start()

        t1.join()
        t2.join()
        t3.join()
        println(Thread.currentThread().name)

    }
}

class Application2 {
    fun startWork() {
        //t1,t2,t3 are gonna in series, Main thread will wait until they have done.
        val t1 = Worker("Hello from t1")
        val t2 = Worker("Hello from t2")
        val t3 = Worker("Hello from t3")

        t1.start()
        t1.join()

        t2.start()
        t2.join()

        t3.start()
        t3.join()

        println(Thread.currentThread().name)
    }
}