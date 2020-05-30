class SynchronizationOnStringOrBoxed {
    private final Object iLockLegal = new Object();

    private final Object bLockLegal = new Object();

    final Object sLockLegal = new Object();

    private final Boolean bLock = Boolean.FALSE;

    private final Integer iLock = Integer.valueOf(0);

    final String sLock = "LOCK";

    private final Object oLock = new Object();

    private final InnerClass i = new InnerClass();

    class InnerClass {
        public Object innerLockLegal = new Object();

        public Boolean innerLock = Boolean.FALSE;

        private SynchronizationOnStringOrBoxed outerClass = new SynchronizationOnStringOrBoxed();

        public void method2() {
            synchronized(this.outerClass.sLockLegal) {
                // Noncompliant
                // ...
            }
        }

        public Boolean getLock() {
            return this.innerLock;
        }

        public Object getLockLegal() {
            return this.innerLockLegal;
        }
    }

    void method1() {
        synchronized(bLockLegal) {
            // Noncompliant [[sc=18;ec=23]] {{Synchronize on a new "Object" instead.}}
            // ...
        }
        synchronized(iLockLegal) {
            // Noncompliant
            // ...
        }
        synchronized(sLockLegal) {
            // Noncompliant
            // ...
        }
        synchronized(oLock) {
            // ...
        }
        synchronized(i.getLockLegal()) {
            // Noncompliant
        }
    }

    void method3() {
        synchronized(sLockLegal) {
            // Noncompliant
            // ...
        }
        synchronized(i.getLockLegal()) {
            // Noncompliant
        }
    }
}