import javax.ejb.embeddable.EJBContainer;
import javax.ejb.embeddable.EJBContainer;
public class GetClassLoader {
    ClassLoader d = Thread.currentThread().getContextClassLoader();// Noncompliant


    public void case1() {
        ClassLoader c = Thread.currentThread().getContextClassLoader();// Noncompliant

    }

    public void case2() throws ClassNotFoundException {
        Thread.currentThread().getContextClassLoader().loadClass("anotherclass");// Noncompliant

    }

    abstract class InnerClass {
        ClassLoader f = Thread.currentThread().getContextClassLoader();// Noncompliant


        public void hello() {
            Thread.currentThread().getContextClassLoader();
        }
    }

    public void usingEJB() {
        EJBContainer container = new EJBContainer();
    }
}