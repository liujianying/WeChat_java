package com.google.android.gms.c;

public final class b$a extends ay<b$a> {
    private static volatile b$a[] aVZ;
    public String aWa;
    public b$a[] aWb;
    public b$a[] aWc;
    public b$a[] aWd;
    public String aWe;
    public String aWf;
    public long aWg;
    public boolean aWh;
    public b$a[] aWi;
    public int[] aWj;
    public boolean aWk;
    public int type;

    public b$a() {
        this.type = 1;
        this.aWa = "";
        this.aWb = pT();
        this.aWc = pT();
        this.aWd = pT();
        this.aWe = "";
        this.aWf = "";
        this.aWg = 0;
        this.aWh = false;
        this.aWi = pT();
        this.aWj = bh.bal;
        this.aWk = false;
        this.aZY = null;
        this.baj = -1;
    }

    private static b$a[] pT() {
        if (aVZ == null) {
            synchronized (bc.bai) {
                if (aVZ == null) {
                    aVZ = new b$a[0];
                }
            }
        }
        return aVZ;
    }

    public final void a(ax axVar) {
        int i = 0;
        axVar.az(1, this.type);
        if (!this.aWa.equals("")) {
            axVar.e(2, this.aWa);
        }
        if (this.aWb != null && this.aWb.length > 0) {
            for (be beVar : this.aWb) {
                if (beVar != null) {
                    axVar.a(3, beVar);
                }
            }
        }
        if (this.aWc != null && this.aWc.length > 0) {
            for (be beVar2 : this.aWc) {
                if (beVar2 != null) {
                    axVar.a(4, beVar2);
                }
            }
        }
        if (this.aWd != null && this.aWd.length > 0) {
            for (be beVar22 : this.aWd) {
                if (beVar22 != null) {
                    axVar.a(5, beVar22);
                }
            }
        }
        if (!this.aWe.equals("")) {
            axVar.e(6, this.aWe);
        }
        if (!this.aWf.equals("")) {
            axVar.e(7, this.aWf);
        }
        if (this.aWg != 0) {
            axVar.g(8, this.aWg);
        }
        if (this.aWk) {
            axVar.s(9, this.aWk);
        }
        if (this.aWj != null && this.aWj.length > 0) {
            for (int az : this.aWj) {
                axVar.az(10, az);
            }
        }
        if (this.aWi != null && this.aWi.length > 0) {
            while (i < this.aWi.length) {
                be beVar3 = this.aWi[i];
                if (beVar3 != null) {
                    axVar.a(11, beVar3);
                }
                i++;
            }
        }
        if (this.aWh) {
            axVar.s(12, this.aWh);
        }
        super.a(axVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b$a)) {
            return false;
        }
        b$a b_a = (b$a) obj;
        if (this.type != b_a.type) {
            return false;
        }
        if (this.aWa == null) {
            if (b_a.aWa != null) {
                return false;
            }
        } else if (!this.aWa.equals(b_a.aWa)) {
            return false;
        }
        if (!bc.equals(this.aWb, b_a.aWb) || !bc.equals(this.aWc, b_a.aWc) || !bc.equals(this.aWd, b_a.aWd)) {
            return false;
        }
        if (this.aWe == null) {
            if (b_a.aWe != null) {
                return false;
            }
        } else if (!this.aWe.equals(b_a.aWe)) {
            return false;
        }
        if (this.aWf == null) {
            if (b_a.aWf != null) {
                return false;
            }
        } else if (!this.aWf.equals(b_a.aWf)) {
            return false;
        }
        return (this.aWg == b_a.aWg && this.aWh == b_a.aWh && bc.equals(this.aWi, b_a.aWi) && bc.equals(this.aWj, b_a.aWj) && this.aWk == b_a.aWk) ? a((ay) b_a) : false;
    }

    public final int hashCode() {
        int i = 1231;
        int i2 = 0;
        int hashCode = ((this.aWe == null ? 0 : this.aWe.hashCode()) + (((((((((this.aWa == null ? 0 : this.aWa.hashCode()) + ((this.type + 527) * 31)) * 31) + bc.hashCode(this.aWb)) * 31) + bc.hashCode(this.aWc)) * 31) + bc.hashCode(this.aWd)) * 31)) * 31;
        if (this.aWf != null) {
            i2 = this.aWf.hashCode();
        }
        hashCode = ((((((this.aWh ? 1231 : 1237) + ((((hashCode + i2) * 31) + ((int) (this.aWg ^ (this.aWg >>> 32)))) * 31)) * 31) + bc.hashCode(this.aWi)) * 31) + bc.hashCode(this.aWj)) * 31;
        if (!this.aWk) {
            i = 1237;
        }
        return ((hashCode + i) * 31) + qF();
    }

    protected final int pU() {
        int i;
        int i2;
        be beVar;
        int i3 = 0;
        int pU = super.pU() + ax.aA(1, this.type);
        if (!this.aWa.equals("")) {
            pU += ax.f(2, this.aWa);
        }
        if (this.aWb != null && this.aWb.length > 0) {
            i = 0;
            while (true) {
                i2 = pU;
                if (i >= this.aWb.length) {
                    break;
                }
                beVar = this.aWb[i];
                if (beVar != null) {
                    i2 += ax.b(3, beVar);
                }
                pU = i + 1;
            }
            pU = i2;
        }
        if (this.aWc != null && this.aWc.length > 0) {
            i = 0;
            while (true) {
                i2 = pU;
                if (i >= this.aWc.length) {
                    break;
                }
                beVar = this.aWc[i];
                if (beVar != null) {
                    i2 += ax.b(4, beVar);
                }
                pU = i + 1;
            }
            pU = i2;
        }
        if (this.aWd != null && this.aWd.length > 0) {
            i = 0;
            while (true) {
                i2 = pU;
                if (i >= this.aWd.length) {
                    break;
                }
                beVar = this.aWd[i];
                if (beVar != null) {
                    i2 += ax.b(5, beVar);
                }
                pU = i + 1;
            }
            pU = i2;
        }
        if (!this.aWe.equals("")) {
            pU += ax.f(6, this.aWe);
        }
        if (!this.aWf.equals("")) {
            pU += ax.f(7, this.aWf);
        }
        if (this.aWg != 0) {
            pU += ax.h(8, this.aWg);
        }
        if (this.aWk) {
            pU += ax.dI(9) + 1;
        }
        if (this.aWj != null && this.aWj.length > 0) {
            i2 = 0;
            for (int dG : this.aWj) {
                i2 += ax.dG(dG);
            }
            pU = (pU + i2) + (this.aWj.length * 1);
        }
        if (this.aWi != null && this.aWi.length > 0) {
            while (i3 < this.aWi.length) {
                be beVar2 = this.aWi[i3];
                if (beVar2 != null) {
                    pU += ax.b(11, beVar2);
                }
                i3++;
            }
        }
        return this.aWh ? pU + (ax.dI(12) + 1) : pU;
    }
}
