package di

import WasmPlatform
import Platform
import org.koin.dsl.module

actual val platformModule = module {
    factory<Platform> { WasmPlatform() }
}
