import java.util.concurrent.atomic.AtomicInteger;
class MultipleProcessors {
    void foo() {
        AtomicInteger aInt1 = new AtomicInteger(0);
        AtomicInteger aInt2 = new AtomicInteger(0);
        isEqual = aInt1.get() == aInt2.get();// Noncompliant by EqualsOnAtomicClassCheck

    }
}