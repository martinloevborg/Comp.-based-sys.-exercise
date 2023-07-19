package dk.sdu.mmmi.osgiplayer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        context.registerService(IGamePluginService.class.getName(), new PlayerControlSystem(), null);
    }

    public void stop(BundleContext context) throws Exception {
        
    }

}
