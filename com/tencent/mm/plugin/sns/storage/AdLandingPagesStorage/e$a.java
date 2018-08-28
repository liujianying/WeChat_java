package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

class e$a {
    int nIu;
    int nIv;
    int nIw;

    private e$a() {
    }

    /* synthetic */ e$a(byte b) {
        this();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e$a)) {
            return false;
        }
        e$a e_a = (e$a) obj;
        if (e_a.nIu == this.nIu && e_a.nIv == this.nIv && e_a.nIw == this.nIw) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.nIu + this.nIv) + this.nIw;
    }

    public final String toString() {
        return "[nodeType=" + this.nIu + ",compType=" + this.nIv + ",subCompType=" + this.nIw + "]";
    }
}
