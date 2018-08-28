package android.support.v4.e;

public final class k<E> implements Cloneable {
    private static final Object tA = new Object();
    private int fi;
    private boolean tB;
    private Object[] tD;
    private int[] tU;

    public k() {
        this(10);
    }

    public k(int i) {
        this.tB = false;
        if (i == 0) {
            this.tU = b.tx;
            this.tD = b.tz;
        } else {
            int ad = b.ad(i);
            this.tU = new int[ad];
            this.tD = new Object[ad];
        }
        this.fi = 0;
    }

    private k<E> bY() {
        try {
            k<E> kVar = (k) super.clone();
            try {
                kVar.tU = (int[]) this.tU.clone();
                kVar.tD = (Object[]) this.tD.clone();
                return kVar;
            } catch (CloneNotSupportedException e) {
                return kVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final E get(int i) {
        int a = b.a(this.tU, this.fi, i);
        return (a < 0 || this.tD[a] == tA) ? null : this.tD[a];
    }

    public final void remove(int i) {
        int a = b.a(this.tU, this.fi, i);
        if (a >= 0 && this.tD[a] != tA) {
            this.tD[a] = tA;
            this.tB = true;
        }
    }

    public final void removeAt(int i) {
        if (this.tD[i] != tA) {
            this.tD[i] = tA;
            this.tB = true;
        }
    }

    private void gc() {
        int i = this.fi;
        int[] iArr = this.tU;
        Object[] objArr = this.tD;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != tA) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.tB = false;
        this.fi = i2;
    }

    public final void put(int i, E e) {
        int a = b.a(this.tU, this.fi, i);
        if (a >= 0) {
            this.tD[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.fi || this.tD[a] != tA) {
            if (this.tB && this.fi >= this.tU.length) {
                gc();
                a = b.a(this.tU, this.fi, i) ^ -1;
            }
            if (this.fi >= this.tU.length) {
                int ad = b.ad(this.fi + 1);
                Object obj = new int[ad];
                Object obj2 = new Object[ad];
                System.arraycopy(this.tU, 0, obj, 0, this.tU.length);
                System.arraycopy(this.tD, 0, obj2, 0, this.tD.length);
                this.tU = obj;
                this.tD = obj2;
            }
            if (this.fi - a != 0) {
                System.arraycopy(this.tU, a, this.tU, a + 1, this.fi - a);
                System.arraycopy(this.tD, a, this.tD, a + 1, this.fi - a);
            }
            this.tU[a] = i;
            this.tD[a] = e;
            this.fi++;
            return;
        }
        this.tU[a] = i;
        this.tD[a] = e;
    }

    public final int size() {
        if (this.tB) {
            gc();
        }
        return this.fi;
    }

    public final int keyAt(int i) {
        if (this.tB) {
            gc();
        }
        return this.tU[i];
    }

    public final E valueAt(int i) {
        if (this.tB) {
            gc();
        }
        return this.tD[i];
    }

    public final int indexOfKey(int i) {
        if (this.tB) {
            gc();
        }
        return b.a(this.tU, this.fi, i);
    }

    public final void clear() {
        int i = this.fi;
        Object[] objArr = this.tD;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.fi = 0;
        this.tB = false;
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
            k valueAt = valueAt(i);
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
