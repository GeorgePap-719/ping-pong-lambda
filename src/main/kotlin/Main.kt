fun main(args: Array<String>) {
    val lambda = lambdaBuilder {
        for (i in 1..10) emit(i)
    }

    lambda.collect {
        println(it)
    }
}