package di

import JVMPlatform
import Platform
import org.koin.dsl.module

actual val platformModule = module {
    factory<Platform> { JVMPlatform() }
}
