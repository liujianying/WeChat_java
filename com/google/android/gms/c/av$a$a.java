package com.google.android.gms.c;

import java.util.Arrays;

public final class av$a$a extends ay<av$a$a> {
    private static volatile av$a$a[] aZy;
    public a aZz;
    public int type;

    public static final class a extends ay<a> {
        public byte[] aZA;
        public String aZB;
        public double aZC;
        public float aZD;
        public long aZE;
        public int aZF;
        public int aZG;
        public boolean aZH;
        public com.google.android.gms.c.av.a[] aZI;
        public av$a$a[] aZJ;
        public String[] aZK;
        public long[] aZL;
        public float[] aZM;
        public long aZN;

        public a() {
            this.aZA = bh.bas;
            this.aZB = "";
            this.aZC = 0.0d;
            this.aZD = 0.0f;
            this.aZE = 0;
            this.aZF = 0;
            this.aZG = 0;
            this.aZH = false;
            this.aZI = com.google.android.gms.c.av.a.qu();
            this.aZJ = av$a$a.qv();
            this.aZK = bh.baq;
            this.aZL = bh.bam;
            this.aZM = bh.ban;
            this.aZN = 0;
            this.aZY = null;
            this.baj = -1;
        }

        public final void a(ax axVar) {
            int i;
            int i2 = 0;
            if (!Arrays.equals(this.aZA, bh.bas)) {
                byte[] bArr = this.aZA;
                axVar.aB(1, 2);
                axVar.dJ(bArr.length);
                axVar.m(bArr);
            }
            if (!this.aZB.equals("")) {
                axVar.e(2, this.aZB);
            }
            if (Double.doubleToLongBits(this.aZC) != Double.doubleToLongBits(0.0d)) {
                double d = this.aZC;
                axVar.aB(3, 1);
                long doubleToLongBits = Double.doubleToLongBits(d);
                axVar.dH(((int) doubleToLongBits) & 255);
                axVar.dH(((int) (doubleToLongBits >> 8)) & 255);
                axVar.dH(((int) (doubleToLongBits >> 16)) & 255);
                axVar.dH(((int) (doubleToLongBits >> 24)) & 255);
                axVar.dH(((int) (doubleToLongBits >> 32)) & 255);
                axVar.dH(((int) (doubleToLongBits >> 40)) & 255);
                axVar.dH(((int) (doubleToLongBits >> 48)) & 255);
                axVar.dH(((int) (doubleToLongBits >> 56)) & 255);
            }
            if (Float.floatToIntBits(this.aZD) != Float.floatToIntBits(0.0f)) {
                axVar.d(4, this.aZD);
            }
            if (this.aZE != 0) {
                axVar.g(5, this.aZE);
            }
            if (this.aZF != 0) {
                axVar.az(6, this.aZF);
            }
            if (this.aZG != 0) {
                i = this.aZG;
                axVar.aB(7, 0);
                axVar.dJ(ax.dL(i));
            }
            if (this.aZH) {
                axVar.s(8, this.aZH);
            }
            if (this.aZI != null && this.aZI.length > 0) {
                for (be beVar : this.aZI) {
                    if (beVar != null) {
                        axVar.a(9, beVar);
                    }
                }
            }
            if (this.aZJ != null && this.aZJ.length > 0) {
                for (be beVar2 : this.aZJ) {
                    if (beVar2 != null) {
                        axVar.a(10, beVar2);
                    }
                }
            }
            if (this.aZK != null && this.aZK.length > 0) {
                for (String str : this.aZK) {
                    if (str != null) {
                        axVar.e(11, str);
                    }
                }
            }
            if (this.aZL != null && this.aZL.length > 0) {
                for (long g : this.aZL) {
                    axVar.g(12, g);
                }
            }
            if (this.aZN != 0) {
                axVar.g(13, this.aZN);
            }
            if (this.aZM != null && this.aZM.length > 0) {
                while (i2 < this.aZM.length) {
                    axVar.d(14, this.aZM[i2]);
                    i2++;
                }
            }
            super.a(axVar);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!Arrays.equals(this.aZA, aVar.aZA)) {
                return false;
            }
            if (this.aZB == null) {
                if (aVar.aZB != null) {
                    return false;
                }
            } else if (!this.aZB.equals(aVar.aZB)) {
                return false;
            }
            return (Double.doubleToLongBits(this.aZC) == Double.doubleToLongBits(aVar.aZC) && Float.floatToIntBits(this.aZD) == Float.floatToIntBits(aVar.aZD) && this.aZE == aVar.aZE && this.aZF == aVar.aZF && this.aZG == aVar.aZG && this.aZH == aVar.aZH && bc.equals(this.aZI, aVar.aZI) && bc.equals(this.aZJ, aVar.aZJ) && bc.equals(this.aZK, aVar.aZK) && bc.equals(this.aZL, aVar.aZL) && bc.equals(this.aZM, aVar.aZM) && this.aZN == aVar.aZN) ? a(aVar) : false;
        }

        public final int hashCode() {
            int hashCode = (this.aZB == null ? 0 : this.aZB.hashCode()) + ((Arrays.hashCode(this.aZA) + 527) * 31);
            long doubleToLongBits = Double.doubleToLongBits(this.aZC);
            return (((((((((((((((this.aZH ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.aZD)) * 31) + ((int) (this.aZE ^ (this.aZE >>> 32)))) * 31) + this.aZF) * 31) + this.aZG) * 31)) * 31) + bc.hashCode(this.aZI)) * 31) + bc.hashCode(this.aZJ)) * 31) + bc.hashCode(this.aZK)) * 31) + bc.hashCode(this.aZL)) * 31) + bc.hashCode(this.aZM)) * 31) + ((int) (this.aZN ^ (this.aZN >>> 32)))) * 31) + qF();
        }

        protected final int pU() {
            int i;
            int i2;
            be beVar;
            int i3 = 0;
            int pU = super.pU();
            if (!Arrays.equals(this.aZA, bh.bas)) {
                byte[] bArr = this.aZA;
                pU += (bArr.length + ax.dK(bArr.length)) + ax.dI(1);
            }
            if (!this.aZB.equals("")) {
                pU += ax.f(2, this.aZB);
            }
            if (Double.doubleToLongBits(this.aZC) != Double.doubleToLongBits(0.0d)) {
                pU += ax.dI(3) + 8;
            }
            if (Float.floatToIntBits(this.aZD) != Float.floatToIntBits(0.0f)) {
                pU += ax.dI(4) + 4;
            }
            if (this.aZE != 0) {
                pU += ax.h(5, this.aZE);
            }
            if (this.aZF != 0) {
                pU += ax.aA(6, this.aZF);
            }
            if (this.aZG != 0) {
                pU += ax.dK(ax.dL(this.aZG)) + ax.dI(7);
            }
            if (this.aZH) {
                pU += ax.dI(8) + 1;
            }
            if (this.aZI != null && this.aZI.length > 0) {
                i = 0;
                while (true) {
                    i2 = pU;
                    if (i >= this.aZI.length) {
                        break;
                    }
                    beVar = this.aZI[i];
                    if (beVar != null) {
                        i2 += ax.b(9, beVar);
                    }
                    pU = i + 1;
                }
                pU = i2;
            }
            if (this.aZJ != null && this.aZJ.length > 0) {
                i = 0;
                while (true) {
                    i2 = pU;
                    if (i >= this.aZJ.length) {
                        break;
                    }
                    beVar = this.aZJ[i];
                    if (beVar != null) {
                        i2 += ax.b(10, beVar);
                    }
                    pU = i + 1;
                }
                pU = i2;
            }
            if (this.aZK != null && this.aZK.length > 0) {
                i2 = 0;
                int i4 = 0;
                for (String str : this.aZK) {
                    if (str != null) {
                        i4++;
                        i2 += ax.bu(str);
                    }
                }
                pU = (pU + i2) + (i4 * 1);
            }
            if (this.aZL != null && this.aZL.length > 0) {
                i = 0;
                while (true) {
                    i2 = i3;
                    if (i >= this.aZL.length) {
                        break;
                    }
                    i2 += ax.ad(this.aZL[i]);
                    i3 = i + 1;
                }
                pU = (pU + i2) + (this.aZL.length * 1);
            }
            if (this.aZN != 0) {
                pU += ax.h(13, this.aZN);
            }
            return (this.aZM == null || this.aZM.length <= 0) ? pU : (pU + (this.aZM.length * 4)) + (this.aZM.length * 1);
        }
    }

    public av$a$a() {
        this.type = 1;
        this.aZz = null;
        this.aZY = null;
        this.baj = -1;
    }

    public static av$a$a[] qv() {
        if (aZy == null) {
            synchronized (bc.bai) {
                if (aZy == null) {
                    aZy = new av$a$a[0];
                }
            }
        }
        return aZy;
    }

    public final void a(ax axVar) {
        axVar.az(1, this.type);
        if (this.aZz != null) {
            axVar.a(2, this.aZz);
        }
        super.a(axVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof av$a$a)) {
            return false;
        }
        av$a$a av_a_a = (av$a$a) obj;
        if (this.type != av_a_a.type) {
            return false;
        }
        if (this.aZz == null) {
            if (av_a_a.aZz != null) {
                return false;
            }
        } else if (!this.aZz.equals(av_a_a.aZz)) {
            return false;
        }
        return a(av_a_a);
    }

    public final int hashCode() {
        return (((this.aZz == null ? 0 : this.aZz.hashCode()) + ((this.type + 527) * 31)) * 31) + qF();
    }

    protected final int pU() {
        int pU = super.pU() + ax.aA(1, this.type);
        return this.aZz != null ? pU + ax.b(2, this.aZz) : pU;
    }
}
