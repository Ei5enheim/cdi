package com.jee.cdi.plainQualifiersImpl;

import com.jee.cdi.plainQualifiersImpl.service.BookService;
import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import java.util.Set;

class Main {


    public static void main(String[] args) {
        System.out.println("Starting my first container");
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
        cont.shutdown();
    }
}