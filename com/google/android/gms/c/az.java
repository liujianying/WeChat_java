package com.google.android.gms.c;

import java.lang.reflect.Array;

public final class az<M extends ay<M>, T> {
    protected final Class<T> aZZ;
    protected final boolean baa;
    public final int tag;
    protected final int type;

    private int am(Object obj) {
        int dP = bh.dP(this.tag);
        switch (this.type) {
            case 10:
                return (ax.dI(dP) * 2) + ((be) obj).qS();
            case 11:
                return ax.b(dP, (be) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    private void b(Object obj, ax axVar) {
        try {
            axVar.dJ(this.tag);
            switch (this.type) {
                case 10:
                    be beVar = (be) obj;
                    int dP = bh.dP(this.tag);
                    beVar.a(axVar);
                    axVar.aB(dP, 4);
                    return;
                case 11:
                    axVar.b((be) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    final void a(Object obj, ax axVar) {
        if (this.baa) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                Object obj2 = Array.get(obj, i);
                if (obj2 != null) {
                    b(obj2, axVar);
                }
            }
            return;
        }
        b(obj, axVar);
    }

    final int al(Object obj) {
        if (!this.baa) {
            return am(obj);
        }
        int length = Array.getLength(obj);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += am(Array.get(obj, i2));
            }
        }
        return i;
    }
}
