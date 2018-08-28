package com.tencent.mm.wallet_core.c;

public final class c {
    public String Yy;
    public int errCode;
    public int errType;
    public int uWZ;

    public c(int i, int i2, String str) {
        this.uWZ = 0;
        e(i, i2, str, 0);
    }

    public final void e(int i, int i2, String str, int i3) {
        this.errType = i;
        this.errCode = i2;
        this.Yy = str;
        this.uWZ = i3;
    }

    public c() {
        this.uWZ = 0;
        this.errType = 0;
        this.errCode = 0;
        this.Yy = "";
        this.uWZ = 0;
    }
}
