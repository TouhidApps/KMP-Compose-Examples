import depend.DBClient

interface MyRepository {
    fun helloWorld(): String
}

class MyRepositoryImpl(
    private val dbClient: DBClient
): MyRepository {

    override fun helloWorld(): String {
        return "Hello from repository!"
    }

}