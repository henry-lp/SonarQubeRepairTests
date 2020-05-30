/* Test for rule s2164 */
class MathOnFloat {
    // Tests from https://github.com/SonarSource/sonar-java/blob/master/java-checks-test-sources/src/main/java/checks/MathOnFloatCheck.java
    void myMethod() {
        float a = 1.6777216E7F;
        float b = 1.0F;
        double d1 = a + b;// Noncompliant ; addition is still between 2 floats

        int i = 16777216;
        int j = 1;
        System.out.println(("[Max time to retrieve connection:" + ((a / 1000.0F) / 1000.0F)) + " ms.");
        System.out.println("[Max time to retrieve connection:" + ((a / 1000.0F) / 1000.0F));
    }
}