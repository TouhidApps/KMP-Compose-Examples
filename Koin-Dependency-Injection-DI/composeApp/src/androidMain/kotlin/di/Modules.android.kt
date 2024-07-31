package di

import AndroidPlatform
import Platform
import org.koin.dsl.module

actual val platformModule = module {
    factory<Platform> { AndroidPlatform() }
//    single<Platform> { AndroidPlatform() } // when singleton required
}

