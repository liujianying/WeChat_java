package com.tencent.matrix.resource.c.a;

public final class a {
    public final int bsa;
    public final b bsb;
    public final Object bsc;

    public a(int i, b bVar, Object obj) {
        this.bsa = i;
        this.bsb = bVar;
        this.bsc = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.bsa != aVar.bsa) {
            return false;
        }
        if (!this.bsb.equals(aVar.bsb)) {
            return false;
        }
        if ((this.bsc == null || this.bsc.equals(aVar.bsc)) && (aVar.bsc == null || aVar.bsc.equals(this.bsc))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.bsb.hashCode() << 31) + this.bsa;
    }
}
