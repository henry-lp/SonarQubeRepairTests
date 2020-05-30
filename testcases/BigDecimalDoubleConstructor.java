import java.math.MathContext;
public class BigDecimalDoubleConstructor {
    // Tests from https://rules.sonarsource.com/java/type/Bug/RSPEC-2111
    public void main(String[] args) {
        double d = 1.1;
    }

    // Tests from https://github.com/SonarSource/sonar-java/blob/master/java-checks-test-sources/src/main/java/checks/BigDecimalDoubleConstructorCheck.java
    public void main2(String[] args) {
        MathContext mc;
    }

    // Aditional tests
    public void foo(String[] args) {
        double d = 1.1;
        float f = 2.2;
        float f1 = 2.0F;
    }
}