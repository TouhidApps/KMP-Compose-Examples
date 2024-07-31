class Greeting(
    private val platform: Platform
): Greeter {
//    private val platform = getPlatform() // This is injected in the Greeting constractor param

    override fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}

interface Greeter {
    fun greet(): String
}
