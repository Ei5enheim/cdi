package com.jee.cdi.producers;

import com.jee.cdi.producers.BookService;
import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.log4j.BasicConfigurator;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import java.util.Set;

class Main {

    static int i;

    public static void main(String[] args) throws  Exception {
        // Set up a simple configuration that logs on the console.
        BasicConfigurator.configure();
        System.out.println("Starting my fourth container");
        String classpathStr = System.getProperty("java.class.path");
        System.out.print(classpathStr);
        CdiContainer cont = CdiContainerLoader.getCdiContainer();
        cont.boot();

        BeanManager bmanager = cont.getBeanManager();

        Set<Bean<?>> beans = bmanager.getBeans(BookService.class);
        System.out.println("beans lenght " + beans.size());

        Bean<?> bean = bmanager.resolve(beans);
        System.out.println("beans " + bean);

        BookService bservice = (BookService) bmanager.getReference(bean, BookService.class, bmanager.createCreationalContext(bean));

        System.out.println("created book " + bservice.createBook("A Shot at History"));
        Thread.sleep(5000);
        cont.shutdown();
        System.out.println("i is set to " + i);
    }
}