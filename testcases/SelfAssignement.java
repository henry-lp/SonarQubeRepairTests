class SelfAssignement {
    int a;

    int c = 0;

    int[] b = new int[]{ 0 };

    int h = 0;

    int[] g = 0;

    SelfAssignementCheckB checkB = new SelfAssignementCheckB();

    void method(int e, int h) {
        int d = 0;
        int[] g = new int[]{ 0 };
        this.g[fun()] = g[fun()];// Noncompliant

        this.h = h;// Noncompliant

    }

    int fun() {
        return 0;
    }

    class SelfAssignementCheckB {
        int b;

        int foo;

        void setFoo(int foo) {
            this.foo = foo;
        }

        int getFoo() {
            return this.foo;
        }

        SelfAssignementCheckB getSelf() {
            return this;
        }

        SelfAssignementCheckB(SelfAssignementCheckB bInstance) {
            foo = bInstance.foo;
        }

        SelfAssignementCheckB() {
        }
    }
}