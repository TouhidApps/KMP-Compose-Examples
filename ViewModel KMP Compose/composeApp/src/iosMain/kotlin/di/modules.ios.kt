package di

import IOSPlatform
import Platform
import org.koin.dsl.module

actual val platformModule = module {
    factory<Platform> { IOSPlatform() }
}
