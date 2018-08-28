package com.google.android.gms.c;

public final class av$a extends ay<av$a> {
    private static volatile av$a[] aZw;
    public a aZx;
    public String name;

    public av$a() {
        this.name = "";
        this.aZx = null;
        this.aZY = null;
        this.baj = -1;
    }

    public static av$a[] qu() {
        if (aZw == null) {
            synchronized (bc.bai) {
                if (aZw == null) {
                    aZw = new av$a[0];
                }
            }
        }
        return aZw;
    }

    public final void a(ax axVar) {
        axVar.e(1, this.name);
        if (this.aZx != null) {
            axVar.a(2, this.aZx);
        }
        super.a(axVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof av$a)) {
            return false;
        }
        av$a av_a = (av$a) obj;
        if (this.name == null) {
            if (av_a.name != null) {
                return false;
            }
        } else if (!this.name.equals(av_a.name)) {
            return false;
        }
        if (this.aZx == null) {
            if (av_a.aZx != null) {
                return false;
            }
        } else if (!this.aZx.equals(av_a.aZx)) {
            return false;
        }
        return a(av_a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
        if (this.aZx != null) {
            i = this.aZx.hashCode();
        }
        return ((hashCode + i) * 31) + qF();
    }

    protected final int pU() {
        int pU = super.pU() + ax.f(1, this.name);
        return this.aZx != null ? pU + ax.b(2, this.aZx) : pU;
    }
}
