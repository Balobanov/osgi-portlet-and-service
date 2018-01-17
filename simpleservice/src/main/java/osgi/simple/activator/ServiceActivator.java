package osgi.simple.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import osgi.simple.service.SimpleService;
import osgi.simple.service.impl.AnotherSimpleService;
import osgi.simple.service.impl.SimpleServiceImpl;

public class ServiceActivator implements BundleActivator {

    private ServiceRegistration registration;

    @Override
    public void start(BundleContext context) throws Exception {

        registration = context.registerService(SimpleService.class.getName(), new SimpleServiceImpl(), null);
        registration = context.registerService(AnotherSimpleService.class.getName(), new AnotherSimpleService(), null);
        System.out.println("###########Service Registered Successfully##############");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        registration.unregister();
        System.out.println("###########Service Unregistered##############");

    }

}