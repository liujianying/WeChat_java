package com.google.android.gms.c;

public final class av extends ay<av> {
    public a[] aZv;

    public av() {
        this.aZv = a.qu();
        this.aZY = null;
        this.baj = -1;
    }

    public final void a(ax axVar) {
        if (this.aZv != null && this.aZv.length > 0) {
            for (be beVar : this.aZv) {
                if (beVar != null) {
                    axVar.a(1, beVar);
                }
            }
        }
        super.a(axVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof av)) {
            return false;
        }
        av avVar = (av) obj;
        return bc.equals(this.aZv, avVar.aZv) ? a((ay) avVar) : false;
    }

    public final int hashCode() {
        return ((bc.hashCode(this.aZv) + 527) * 31) + qF();
    }

    protected final int pU() {
        int pU = super.pU();
        if (this.aZv != null && this.aZv.length > 0) {
            for (be beVar : this.aZv) {
                if (beVar != null) {
                    pU += ax.b(1, beVar);
                }
            }
        }
        return pU;
    }
}
