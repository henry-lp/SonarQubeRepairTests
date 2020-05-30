import javax.ejb.embeddable.EJBContainer;
public class GetClassLoader {
    ClassLoader d = this.getClass().getClassLoader();// Noncompliant


    public void case1() {
    }

    public void case2() throws ClassNotFoundException {
        Dummy.class.getClassLoader().loadClass("anotherclass");// Noncompliant

    }

    abstract class InnerClass {
        ClassLoader f = this.getClass().getClassLoader();// Noncompliant


        public void hello() {
            this.getClass().getClassLoader();// Noncompliant

        }
    }

    public void usingEJB() {
    }
}