package android.support.v4.e;

public final class e<E> implements Cloneable {
    public static final Object tA = new Object();
    public int fi;
    public boolean tB;
    public long[] tC;
    public Object[] tD;

    public e() {
        this((byte) 0);
    }

    private e(byte b) {
        this.tB = false;
        int ae = b.ae(10);
        this.tC = new long[ae];
        this.tD = new Object[ae];
        this.fi = 0;
    }

    private e<E> bV() {
        try {
            e<E> eVar = (e) super.clone();
            try {
                eVar.tC = (long[]) this.tC.clone();
                eVar.tD = (Object[]) this.tD.clone();
                return eVar;
            } catch (CloneNotSupportedException e) {
                return eVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final E get(long j) {
        int a = b.a(this.tC, this.fi, j);
        return (a < 0 || this.tD[a] == tA) ? null : this.tD[a];
    }

    private void gc() {
        int i = this.fi;
        long[] jArr = this.tC;
        Object[] objArr = this.tD;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != tA) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.tB = false;
        this.fi = i2;
    }

    public final void put(long j, E e) {
        int a = b.a(this.tC, this.fi, j);
        if (a >= 0) {
            this.tD[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.fi || this.tD[a] != tA) {
            if (this.tB && this.fi >= this.tC.length) {
                gc();
                a = b.a(this.tC, this.fi, j) ^ -1;
            }
            if (this.fi >= this.tC.length) {
                int ae = b.ae(this.fi + 1);
                Object obj = new long[ae];
                Object obj2 = new Object[ae];
                System.arraycopy(this.tC, 0, obj, 0, this.tC.length);
                System.arraycopy(this.tD, 0, obj2, 0, this.tD.length);
                this.tC = obj;
                this.tD = obj2;
            }
            if (this.fi - a != 0) {
                System.arraycopy(this.tC, a, this.tC, a + 1, this.fi - a);
                System.arraycopy(this.tD, a, this.tD, a + 1, this.fi - a);
            }
            this.tC[a] = j;
            this.tD[a] = e;
            this.fi++;
            return;
        }
        this.tC[a] = j;
        this.tD[a] = e;
    }

    public final int size() {
        if (this.tB) {
            gc();
        }
        return this.fi;
    }

    private long keyAt(int i) {
        if (this.tB) {
            gc();
        }
        return this.tC[i];
    }

    public final E valueAt(int i) {
        if (this.tB) {
            gc();
        }
        return this.tD[i];
    }

    public final String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.fi * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.fi; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(keyAt(i));
            stringBuilder.append('=');
            e valueAt = valueAt(i);
            if (valueAt != this) {
                stringBuilder.append(valueAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
