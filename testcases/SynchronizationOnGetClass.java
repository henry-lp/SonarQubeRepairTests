class SynchronizationOnGetClass {
    final class MemberSelect {
        public void memberSelectOnUnknownSymbol() {
            synchronized(this.getClass()) {
                // Compliant
            }
        }
    }

    class Coverage {
        public void unrelatedSynchronizedExpr() {
            Object monitor = new Object();
            synchronized(monitor) {
                // Compliant
            }
        }
    }

    class InnerClass {
        public Object getObject() {
            Object o = new Object();
            return o;
        }
    }

    public void method1() {
        synchronized(Object.class) {
            // Noncompliant - object's modifier is unknown, assume non-final nor enum
        }
    }

    public void method2() {
        synchronized(SynchronizationOnGetClass.class) {
            // Noncompliant
        }
    }
}