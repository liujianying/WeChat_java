package com.davemorrissey.labs.subscaleview.a;

public final class c {
    public String Yy;
    public int errCode;

    public c(int i, String str) {
        this.errCode = i;
        this.Yy = str;
    }

    public final String toString() {
        return String.format("ImageDecodeResult{errCode: %d, errMsg: %s}", new Object[]{Integer.valueOf(this.errCode), this.Yy});
    }
}
