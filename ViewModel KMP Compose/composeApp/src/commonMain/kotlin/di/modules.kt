package di

import Greeter
import Greeting
import MyViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    /**
     * single: To make singleton to make object alive full lifecycle of the app
     * ex use: network, db instances etc.
     *
     * factory: Dependency object will create on request
     */
//    single<Greeter> { Greeting(get()) }
    factory<Greeter> { Greeting(get()) }

    singleOf(::MyViewModel)
    factoryOf(::MyViewModel)
//    factory { MyViewModel(get()) } // same as factoryOf(::MyViewModel)

}
expect val platformModule: Module
