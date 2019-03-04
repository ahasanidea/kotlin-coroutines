import kotlinx.coroutines.*

fun main(){
 exampleBlockingDispatcher()
}

suspend fun printlnDelayed(message:String){
    //Complex calculation
    delay(2000)
    println(message)
}
//This is synchronous blocking example
fun exampleBlocking()= runBlocking{
    println("One")
    printlnDelayed("Two")
    println("Three")
}
// Running on another thread but still blocking the main thread
fun exampleBlockingDispatcher(){
    runBlocking(Dispatchers.Default) {
        println("one - from thread ${Thread.currentThread().name}")
        printlnDelayed("two - from thread ${Thread.currentThread().name}")
    }
    // Outside of runBlocking to show that it's running in the blocked main thread
    println("three - from thread ${Thread.currentThread().name}")
    // It still runs only after the runBlocking is fully executed.
}
