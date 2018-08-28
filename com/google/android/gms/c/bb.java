package com.google.android.gms.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class bb implements Cloneable {
    private az<?, ?> baf;
    private Object bag;
    List<bg> bah = new ArrayList();

    bb() {
    }

    private byte[] toByteArray() {
        byte[] bArr = new byte[pU()];
        a(ax.p(bArr, bArr.length));
        return bArr;
    }

    final void a(ax axVar) {
        if (this.bag != null) {
            this.baf.a(this.bag, axVar);
            return;
        }
        for (bg bgVar : this.bah) {
            axVar.dJ(bgVar.tag);
            axVar.m(bgVar.bak);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bb)) {
            return false;
        }
        bb bbVar = (bb) obj;
        if (this.bag != null && bbVar.bag != null) {
            return this.baf == bbVar.baf ? !this.baf.aZZ.isArray() ? this.bag.equals(bbVar.bag) : this.bag instanceof byte[] ? Arrays.equals((byte[]) this.bag, (byte[]) bbVar.bag) : this.bag instanceof int[] ? Arrays.equals((int[]) this.bag, (int[]) bbVar.bag) : this.bag instanceof long[] ? Arrays.equals((long[]) this.bag, (long[]) bbVar.bag) : this.bag instanceof float[] ? Arrays.equals((float[]) this.bag, (float[]) bbVar.bag) : this.bag instanceof double[] ? Arrays.equals((double[]) this.bag, (double[]) bbVar.bag) : this.bag instanceof boolean[] ? Arrays.equals((boolean[]) this.bag, (boolean[]) bbVar.bag) : Arrays.deepEquals((Object[]) this.bag, (Object[]) bbVar.bag) : false;
        } else {
            if (this.bah != null && bbVar.bah != null) {
                return this.bah.equals(bbVar.bah);
            }
            try {
                return Arrays.equals(toByteArray(), bbVar.toByteArray());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    final int pU() {
        int i = 0;
        if (this.bag != null) {
            return this.baf.al(this.bag);
        }
        Iterator it = this.bah.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            bg bgVar = (bg) it.next();
            i = (bgVar.bak.length + (ax.dK(bgVar.tag) + 0)) + i2;
        }
    }

    /* renamed from: qJ */
    public final bb clone() {
        int i = 0;
        bb bbVar = new bb();
        try {
            bbVar.baf = this.baf;
            if (this.bah == null) {
                bbVar.bah = null;
            } else {
                bbVar.bah.addAll(this.bah);
            }
            if (this.bag != null) {
                if (this.bag instanceof be) {
                    bbVar.bag = ((be) this.bag).clone();
                } else if (this.bag instanceof byte[]) {
                    bbVar.bag = ((byte[]) this.bag).clone();
                } else if (this.bag instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.bag;
                    Object obj = new byte[bArr.length][];
                    bbVar.bag = obj;
                    while (true) {
                        int i2 = i;
                        if (i2 >= bArr.length) {
                            break;
                        }
                        obj[i2] = (byte[]) bArr[i2].clone();
                        i = i2 + 1;
                    }
                } else if (this.bag instanceof boolean[]) {
                    bbVar.bag = ((boolean[]) this.bag).clone();
                } else if (this.bag instanceof int[]) {
                    bbVar.bag = ((int[]) this.bag).clone();
                } else if (this.bag instanceof long[]) {
                    bbVar.bag = ((long[]) this.bag).clone();
                } else if (this.bag instanceof float[]) {
                    bbVar.bag = ((float[]) this.bag).clone();
                } else if (this.bag instanceof double[]) {
                    bbVar.bag = ((double[]) this.bag).clone();
                } else if (this.bag instanceof be[]) {
                    be[] beVarArr = (be[]) this.bag;
                    Object obj2 = new be[beVarArr.length];
                    bbVar.bag = obj2;
                    while (i < beVarArr.length) {
                        obj2[i] = beVarArr[i].clone();
                        i++;
                    }
                }
            }
            return bbVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
