package com.tencent.mm.plugin.wenote.model.nativenote.c;

public final class b {
    public float fto = -1.0f;
    public float ftp = -1.0f;
    public int hER = 0;
    public float qrP = -1.0f;
    public float qrQ = -1.0f;
    public int qrR = -1;
    public float qrS = -1.0f;
    public float qrT = -1.0f;
    public float qrU = -1.0f;
    public float qrV = -1.0f;
    public int qrW = -1;

    public final void a(int i, float f, float f2, float f3, float f4, int i2) {
        this.hER = i;
        this.qrP = f;
        this.qrQ = f2;
        this.fto = f3;
        this.ftp = f4;
        if (this.hER == 1) {
            this.qrR = i2;
        } else {
            this.qrR = 0;
        }
    }

    public final void reset() {
        this.hER = 0;
        this.qrP = -1.0f;
        this.qrQ = -1.0f;
        this.fto = -1.0f;
        this.ftp = -1.0f;
        this.qrR = -1;
        this.qrS = -1.0f;
        this.qrT = -1.0f;
        this.qrU = -1.0f;
        this.qrV = -1.0f;
        this.qrW = -1;
    }

    public final int getType() {
        int i;
        int i2 = 0;
        if (this.qrP < 0.0f || this.qrQ < 0.0f || this.fto < 0.0f || this.ftp < 0.0f || this.qrR < 0) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return 0;
        }
        if (this.qrS >= 0.0f && this.qrT >= 0.0f && this.qrU >= 0.0f && this.qrV >= 0.0f && this.qrW >= 0) {
            i2 = 1;
        }
        if (i2 == 0) {
            return 1;
        }
        i2 = Math.abs((int) (this.fto - this.qrU));
        int abs = Math.abs((int) (this.ftp - this.qrV));
        if (i2 > 30 || abs > 30 || this.qrR != this.qrW) {
            return 3;
        }
        return 2;
    }
}
