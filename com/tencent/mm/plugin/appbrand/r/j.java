package com.tencent.mm.plugin.appbrand.r;

public final class j implements l {
    final l gBL;
    int gBM = 0;
    int gBN = -1;
    int gBO = -1;
    Object gBP = null;

    public j(l lVar) {
        this.gBL = lVar;
    }

    public final void aoz() {
        if (this.gBM != 0) {
            switch (this.gBM) {
                case 1:
                    this.gBL.bR(this.gBN, this.gBO);
                    break;
                case 2:
                    this.gBL.bS(this.gBN, this.gBO);
                    break;
                case 3:
                    this.gBL.d(this.gBN, this.gBO, this.gBP);
                    break;
            }
            this.gBP = null;
            this.gBM = 0;
        }
    }

    public final void bR(int i, int i2) {
        if (this.gBM != 1 || i < this.gBN || i > this.gBN + this.gBO) {
            aoz();
            this.gBN = i;
            this.gBO = i2;
            this.gBM = 1;
            return;
        }
        this.gBO += i2;
        this.gBN = Math.min(i, this.gBN);
    }

    public final void bS(int i, int i2) {
        if (this.gBM != 2 || this.gBN < i || this.gBN > i + i2) {
            aoz();
            this.gBN = i;
            this.gBO = i2;
            this.gBM = 2;
            return;
        }
        this.gBO += i2;
        this.gBN = i;
    }

    public final void bT(int i, int i2) {
        aoz();
        this.gBL.bT(i, i2);
    }

    public final void d(int i, int i2, Object obj) {
        if (this.gBM != 3 || i > this.gBN + this.gBO || i + i2 < this.gBN || this.gBP != obj) {
            aoz();
            this.gBN = i;
            this.gBO = i2;
            this.gBP = obj;
            this.gBM = 3;
            return;
        }
        int i3 = this.gBN + this.gBO;
        this.gBN = Math.min(i, this.gBN);
        this.gBO = Math.max(i3, i + i2) - this.gBN;
    }
}
