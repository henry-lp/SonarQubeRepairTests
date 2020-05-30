/* Test for rule s2164 */
class MathOnFloat {
    // Tests from https://github.com/SonarSource/sonar-java/blob/master/java-checks-test-sources/src/main/java/checks/MathOnFloatCheck.java
    void myMethod() {
        float a = 1.6777216E7F;
        float b = 1.0F;
        float c = (double) a + (double) b;// Noncompliant {{Use a "double" or "BigDecimal" instead.}} yields 1.6777216E7 not 1.6777217E7

        double d1 = (double) a + (double) b;// Noncompliant ; addition is still between 2 floats

        double d2 = (double) a - (double) b;// Noncompliant

        double d3 = (double) a * (double) b;// Noncompliant

        double d4 = (double) a / (double) b;// Noncompliant

        double d5 = ((double) a / (double) b) + b;// Noncompliant, only one issue should be reported

        double d6 = a + d1;
        int i = 16777216;
        int j = 1;
        int k = i + j;
        System.out.println(("[Max time to retrieve connection:" + ((a / 1000.0F) / 1000.0F)) + " ms.");
        System.out.println("[Max time to retrieve connection:" + ((a / 1000.0F) / 1000.0F));
        float foo = 12 + (((double) a / (double) 1000.0F) / 1000.0F);// Noncompliant

    }
}