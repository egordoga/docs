package ua.docs_task.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.docs_task.service.ServiceDB;

import javax.annotation.PostConstruct;

@Component
public class StaticContextInit {

    private final ServiceDB serviceDB;

    @Autowired
    public StaticContextInit(ServiceDB serviceDB) {
        this.serviceDB = serviceDB;
    }

    @PostConstruct
    public void unit() {
        StaticUtils.setServiceDB(serviceDB);
    }
}
