package di

import AndroidPlatform
import MyViewModel
import Platform
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

actual val platformModule = module {
    factory<Platform> { AndroidPlatform() }
//    single<Platform> { AndroidPlatform() } // when singleton required

//    viewModelOf(::MyViewModel)
}

