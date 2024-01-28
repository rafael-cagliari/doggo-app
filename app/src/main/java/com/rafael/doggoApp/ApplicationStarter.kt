package com.rafael.doggoApp;

import android.app.Application;
import com.rafael.commons.data.network.commonsDataNetworkModule
import org.kodein.di.DI
import org.kodein.di.DIAware

public class ApplicationStarter :Application(), DIAware {

    private val appGeneralModule = DI.Module(name = "appGeneralModule") {
        import(commonsDataNetworkModule)
        import(testModule)
    }

    override val di by DI.lazy {
        import(appGeneralModule)
    }
}
