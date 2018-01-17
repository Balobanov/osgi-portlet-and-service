package osgi.simple.service.impl;

import org.osgi.service.component.annotations.Component;
import osgi.simple.service.SimpleService;

@Component(
        immediate = true,
        property = {},
        service = SimpleService.class
)
public class SimpleServiceImpl implements SimpleService {

    public String doSome() {
        return "Some work was done.";
    }
}
