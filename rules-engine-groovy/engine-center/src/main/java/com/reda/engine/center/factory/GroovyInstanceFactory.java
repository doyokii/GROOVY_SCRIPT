package com.reda.engine.center.factory;

import com.reda.engine.center.component.GroovyScript;
import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GroovyInstanceFactory {
    @Autowired
    private Binding groovyBinding;
    private static GroovyShell groovyShell;
    @Autowired
    private static AutowireCapableBeanFactory beanFactory;
    @Autowired
    static DefaultListableBeanFactory defaultListableBeanFactory;


    @PostConstruct
    public void init() {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(this.getClass().getClassLoader());
        CompilerConfiguration compilerConfiguration = new CompilerConfiguration();
        compilerConfiguration.setSourceEncoding("utf-8");
        compilerConfiguration.setScriptBaseClass(GroovyScript.class.getName());
        groovyShell = new GroovyShell(groovyClassLoader, groovyBinding, compilerConfiguration);
    }

    public static String registerRule(String scriptContent, String ruleName) {
        Script groovy = groovyShell.parse(scriptContent);
        defaultListableBeanFactory.registerSingleton(ruleName, groovy);
        beanFactory.autowireBean(groovy);
        return "success";
    }

    public static void execute(String ruleName) {
        Script rule = (Script) defaultListableBeanFactory.getSingleton(ruleName);
        rule.run();
    }

    public static void destroyBean(String ruleName) {
        defaultListableBeanFactory.destroySingleton(ruleName);
    }

}
