

open module house.com {
    requires spring.core;

    requires spring.context;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.boot.starter.jdbc;
    requires java.sql;

    // MVC
        requires spring.web;
        requires java.annotation;
        requires  spring.boot.starter.web;
        requires spring.webmvc;
        requires java.validation;
        requires  tomcat.embed.core;






}
