package android.support.v4.e;

public class i$b<T> implements i$a<T> {
    private final Object[] tM;
    private int tN;

    public i$b(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.tM = new Object[i];
    }

    public T bW() {
        if (this.tN <= 0) {
            return null;
        }
        int i = this.tN - 1;
        T t = this.tM[i];
        this.tM[i] = null;
        this.tN--;
        return t;
    }

    public boolean j(T t) {
        boolean z;
        for (int i = 0; i < this.tN; i++) {
            if (this.tM[i] == t) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            throw new IllegalStateException("Already in the pool!");
        } else if (this.tN >= this.tM.length) {
            return false;
        } else {
            this.tM[this.tN] = t;
            this.tN++;
            return true;
        }
    }
}
