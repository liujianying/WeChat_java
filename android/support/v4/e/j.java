package android.support.v4.e;

import java.util.Map;

public class j<K, V> {
    static Object[] tO;
    static int tP;
    static Object[] tQ;
    static int tR;
    int fi;
    int[] tS;
    Object[] tT;

    private int indexOf(Object obj, int i) {
        int i2 = this.fi;
        if (i2 == 0) {
            return -1;
        }
        int a = b.a(this.tS, i2, i);
        if (a < 0 || obj.equals(this.tT[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.tS[i3] == i) {
            if (obj.equals(this.tT[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.tS[a] == i) {
            if (obj.equals(this.tT[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    private int bX() {
        int i = this.fi;
        if (i == 0) {
            return -1;
        }
        int a = b.a(this.tS, i, 0);
        if (a < 0 || this.tT[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.tS[i2] == 0) {
            if (this.tT[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.tS[a] == 0) {
            if (this.tT[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    final void aj(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (a.class) {
                if (tQ != null) {
                    objArr = tQ;
                    this.tT = objArr;
                    tQ = (Object[]) objArr[0];
                    this.tS = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    tR--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                if (tO != null) {
                    objArr = tO;
                    this.tT = objArr;
                    tO = (Object[]) objArr[0];
                    this.tS = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    tP--;
                    return;
                }
            }
        }
        this.tS = new int[i];
        this.tT = new Object[(i << 1)];
    }

    static void a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (tR < 10) {
                    objArr[0] = tQ;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    tQ = objArr;
                    tR++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (tP < 10) {
                    objArr[0] = tO;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    tO = objArr;
                    tP++;
                }
            }
        }
    }

    public j() {
        this.tS = b.tx;
        this.tT = b.tz;
        this.fi = 0;
    }

    public j(int i) {
        if (i == 0) {
            this.tS = b.tx;
            this.tT = b.tz;
        } else {
            aj(i);
        }
        this.fi = 0;
    }

    public void clear() {
        if (this.fi != 0) {
            a(this.tS, this.tT, this.fi);
            this.tS = b.tx;
            this.tT = b.tz;
            this.fi = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public final int indexOfKey(Object obj) {
        return obj == null ? bX() : indexOf(obj, obj.hashCode());
    }

    final int indexOfValue(Object obj) {
        int i = 1;
        int i2 = this.fi * 2;
        Object[] objArr = this.tT;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public V get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? this.tT[(indexOfKey << 1) + 1] : null;
    }

    public final K keyAt(int i) {
        return this.tT[i << 1];
    }

    public final V valueAt(int i) {
        return this.tT[(i << 1) + 1];
    }

    public final V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.tT[i2];
        this.tT[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.fi <= 0;
    }

    public V put(K k, V v) {
        int bX;
        int i;
        int i2 = 8;
        if (k == null) {
            bX = bX();
            i = 0;
        } else {
            i = k.hashCode();
            bX = indexOf(k, i);
        }
        if (bX >= 0) {
            int i3 = (bX << 1) + 1;
            V v2 = this.tT[i3];
            this.tT[i3] = v;
            return v2;
        }
        bX ^= -1;
        if (this.fi >= this.tS.length) {
            if (this.fi >= 8) {
                i2 = this.fi + (this.fi >> 1);
            } else if (this.fi < 4) {
                i2 = 4;
            }
            Object obj = this.tS;
            Object obj2 = this.tT;
            aj(i2);
            if (this.tS.length > 0) {
                System.arraycopy(obj, 0, this.tS, 0, obj.length);
                System.arraycopy(obj2, 0, this.tT, 0, obj2.length);
            }
            a(obj, obj2, this.fi);
        }
        if (bX < this.fi) {
            System.arraycopy(this.tS, bX, this.tS, bX + 1, this.fi - bX);
            System.arraycopy(this.tT, bX << 1, this.tT, (bX + 1) << 1, (this.fi - bX) << 1);
        }
        this.tS[bX] = i;
        this.tT[bX << 1] = k;
        this.tT[(bX << 1) + 1] = v;
        this.fi++;
        return null;
    }

    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public final V removeAt(int i) {
        int i2 = 8;
        V v = this.tT[(i << 1) + 1];
        if (this.fi <= 1) {
            a(this.tS, this.tT, this.fi);
            this.tS = b.tx;
            this.tT = b.tz;
            this.fi = 0;
        } else if (this.tS.length <= 8 || this.fi >= this.tS.length / 3) {
            this.fi--;
            if (i < this.fi) {
                System.arraycopy(this.tS, i + 1, this.tS, i, this.fi - i);
                System.arraycopy(this.tT, (i + 1) << 1, this.tT, i << 1, (this.fi - i) << 1);
            }
            this.tT[this.fi << 1] = null;
            this.tT[(this.fi << 1) + 1] = null;
        } else {
            if (this.fi > 8) {
                i2 = this.fi + (this.fi >> 1);
            }
            Object obj = this.tS;
            Object obj2 = this.tT;
            aj(i2);
            this.fi--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.tS, 0, i);
                System.arraycopy(obj2, 0, this.tT, 0, i << 1);
            }
            if (i < this.fi) {
                System.arraycopy(obj, i + 1, this.tS, i, this.fi - i);
                System.arraycopy(obj2, (i + 1) << 1, this.tT, i << 1, (this.fi - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.fi;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.fi) {
            try {
                Object keyAt = keyAt(i);
                Object valueAt = valueAt(i);
                Object obj2 = map.get(keyAt);
                if (valueAt == null) {
                    if (obj2 != null || !map.containsKey(keyAt)) {
                        return false;
                    }
                } else if (!valueAt.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.tS;
        Object[] objArr = this.tT;
        int i = this.fi;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.fi * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.fi; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            j keyAt = keyAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            keyAt = valueAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
