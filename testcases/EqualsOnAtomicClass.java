import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
class EqualsOnAtomicClass {
    void method() {
        boolean isEqual = false;
        AtomicBoolean abool1 = new AtomicBoolean(true);
        AtomicBoolean abool2 = new AtomicBoolean(true);
        AtomicInteger aInt1 = new AtomicInteger(0);
        AtomicInteger aInt2 = new AtomicInteger(0);
        AtomicLong aLong1 = new AtomicLong(0);
        AtomicLong aLong2 = new AtomicLong(0);
        Integer int1 = new Integer(0);
        Integer int2 = new Integer(0);
    }
}