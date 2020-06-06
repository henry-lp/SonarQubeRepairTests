// Test for rule s2204
// Tests from https://github.com/SonarSource/sonar-java/blob/master/java-checks-test-sources/src/main/java/checks/EqualsOnAtomicClassCheck.java

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class EqualsOnAtomicClass {

	void method() {
		boolean isEqual = false;

		AtomicBoolean abool1 = new AtomicBoolean(true);
		AtomicBoolean abool2 = new AtomicBoolean(true);
		isEqual = abool1.get() == abool2.get(); // Noncompliant {{Use ".get()" to retrieve the value and compare it instead.}}

		AtomicInteger aInt1 = new AtomicInteger(0);
		AtomicInteger aInt2 = new AtomicInteger(0);
		isEqual = aInt1.equals(aInt2); // Noncompliant

		AtomicLong aLong1 = new AtomicLong(0);
		AtomicLong aLong2 = new AtomicLong(0);
		isEqual = aLong1.equals(aLong2); // Noncompliant

		Integer int1 = new Integer(0);
		Integer int2 = new Integer(0);
		isEqual = int1.equals(int2);
	}

}
