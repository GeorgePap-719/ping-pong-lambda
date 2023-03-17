import kotlin.experimental.ExperimentalTypeInference

class Lambda<out T>(private val block: LambdaCollector<T>.() -> Unit) {
    fun collect(collector: LambdaCollector<T>) {
        collector.block()
    }
}

@OptIn(ExperimentalTypeInference::class)
fun <T> lambdaBuilder(@BuilderInference block: LambdaCollector<T>.() -> Unit): Lambda<T> {
    return Lambda(block)
}

fun interface LambdaCollector<in T> {
    fun emit(value: T)
}