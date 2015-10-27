package org.smurve.hsr2015.collateral;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * demonstrates the workings of a JDK Dynamic Proxy as one approach to AOP
 */
public class JdkProxyDemo {

    /** the original implementation of the MyInterface */
    private MyInterface original = new MyClass();

    private void run() {

        /**
         * this handler determines that any call to method hello must be preceded by a chatty phrase "advising..."
         */
        InvocationHandler handler = (proxy, method, args) -> {

            /** This is the actual advice */
            System.out.println("Advising...");

            /** call the original method and... */
            String ret = (String) method.invoke(original, args);

            /** return an "enhanced" value */
            return "Enhanced-" + ret;
        };


        /**
         * create the proxy - just another instance of MyInterface
         */
        MyInterface myAdvisedInstance = (MyInterface) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),   // the classloader to host the proxy
                new Class[]{MyInterface.class},     // the interfaces that the proxy is supposed to implement
                handler);                           // the actual advice.

        String result = myAdvisedInstance.hello("Wolfie");
        System.out.println("Result: " + result);
    }


    /**
     * the interface that the proxy will automatically implement
     */
    public interface MyInterface {
         String hello ( String name );
    }


    /**
     * the original implementation of the MyInterface.
     * We're going to "advise" this class
     */
    public static class MyClass implements MyInterface {

        @Override
        public String hello(String name) {
            System.out.println("Hello " + name);
            return "OK";
        }
    }

    /** just run this */
    public static void main (String [] args ) { new JdkProxyDemo().run();}
}
