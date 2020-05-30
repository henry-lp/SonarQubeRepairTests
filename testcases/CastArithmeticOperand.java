import java.util.Date;
class CastArithmeticOperand {
    // Tests from https://rules.sonarsource.com/java/type/Bug/RSPEC-2184
    float twoThirds = (float) 2 / 3;// Noncompliant; int division. Yields 0.0


    long millisInYear = (((long) 1000 * 3600) * 24) * 365;// Noncompliant; int multiplication. Yields 1471228928


    long bigNum = (long) Integer.MAX_VALUE + 2;// Noncompliant. Yields -2147483647


    long bigNegNum = (long) Integer.MIN_VALUE - 1;// Noncompliant, gives a positive result instead of a negative one.


    int seconds;

    Date myDate = new Date((long) seconds * 1000);// Noncompliant, won't produce the expected result if seconds > 2_147_483


    public long compute(int factor) {
        return (long) factor * 10000;// Noncompliant, won't produce the expected result if factor > 214_748

    }

    public float compute2(long factor) {
        return (float) factor / 123;// Noncompliant, will be rounded to closest long integer

    }

    // Tests from https://github.com/SonarSource/sonar-java/blob/master/java-checks/src/test/files/checks/CastArithmeticOperandCheck.java
    CastArithmeticOperand(int a, long l) {
    }

    void foo() {
        CastArithmeticOperand a = new CastArithmeticOperand(1 + 2, (long) 1 + 2);// Noncompliant {{Cast one of the operands of this addition operation to a "long".}}

        long l1 = (((long) 1000 * 3600) * 24) * 365;// Noncompliant {{Cast one of the operands of this multiplication operation to a "long".}}

        l1 += 10 + 2;
        long l2 = ((1000L * 3600) * 24) * 365;
        float f = (float) 4L / 3;// Noncompliant {{Cast one of the operands of this division operation to a "float".}}

        float f1 = (float) 2 / 3;// Noncompliant {{Cast one of the operands of this division operation to a "float".}}

        float f2 = 2.0F / 3;
        float f3 = (((float) 1 / 2) / 2) * 0.5F;// Noncompliant

        l2 = (((long) 1000 * 3600) * 24) * 365;// Noncompliant {{Cast one of the operands of this multiplication operation to a "long".}}

        l2 = ((1000L * 3600) * 24) * 365;// compliant

        double d = (double) 2 / 3;// Noncompliant {{Cast one of the operands of this division operation to a "double".}}

        long l3 = (long) 2 + Integer.MAX_VALUE;// Noncompliant {{Cast one of the operands of this addition operation to a "long".}}

        l3 = (long) 2 - Integer.MIN_VALUE;// Noncompliant {{Cast one of the operands of this subtraction operation to a "long".}}

        longMethod(1 + 2, (long) 1 + 2);// Noncompliant {{Cast one of the operands of this addition operation to a "long".}}

        longMethod(1 + 2, 1 + 2L);// Compliant

        doubleMethod(1 + 2, (double) 1 + 2);// Noncompliant {{Cast one of the operands of this addition operation to a "double".}}

        doubleMethod(1 + 2, 1 + 2.0);// Compliant

        floatMethod(1 + 2, (float) 1 + 2);// Noncompliant {{Cast one of the operands of this addition operation to a "float".}}

        floatMethod(1 + 2, 1 + 2.0F);// Compliant

        foo();// Compliant

        double tst = 1 | 2;// Compliant

        unknownMethod(1 + 2);// Compliant

        longMethod(12 / 7, 12 / 7);// Compliant dividing two ints into and widening into a long can't cause any harm

        double d2 = (((double) 1 / 2) / 2) * 0.5;// Noncompliant

    }

    void longMethod(int a, long l) {
    }

    void doubleMethod(int a, double d) {
    }

    void floatMethod(int a, float f) {
    }

    long l() {
        if (true) {
            return 1 + 2L;// compliant

        } else {
            return (long) 1 + 2;// Noncompliant {{Cast one of the operands of this addition operation to a "long".}}

        }
    }

    double d() {
        if (true) {
            return 1 + 2.0;// compliant

        } else {
            return (double) 1 + 2;// Noncompliant {{Cast one of the operands of this addition operation to a "double".}}

        }
    }

    float f() {
        if (true) {
            return 1 + 2.0F;// compliant

        } else {
            return (float) 1 + 2;// Noncompliant {{Cast one of the operands of this addition operation to a "float".}}

        }
    }

    void test_int_division() {
        double a = ((double) 1 / 2) * 5.0;// Noncompliant {{Cast one of the operands of this integer division to a "double".}}

        double b = (1 + 3) / 5.0;// Compliant

        double c = ((((double) 1 + 0) / 2) + 0) / 5.0;// Noncompliant {{Cast one of the operands of this integer division to a "double".}}

    }

    void test_constructors() {
        Date date1 = new Date((long) 2 + 1);// Noncompliant {{Cast one of the operands of this addition operation to a "long".}}

        Date date2 = new Date("today");// Compliant

    }
}