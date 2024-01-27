import android.app.Application
import org.kodein.di.DI
import org.kodein.di.DIAware

class ApplicationStarter: Application(), DIAware {
    override val di = DI{
        import(appGeneralModule)
    }


    private val appGeneralModule = DI.Module(name = "appGeneralModule"){

    }
}