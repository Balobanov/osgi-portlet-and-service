package osgi.simple.service.impl;

import osgi.simple.service.SimpleService;

public class AnotherSimpleService implements SimpleService{
    @Override
    public String doSome() {
        return "Another cool work!";
    }
}
