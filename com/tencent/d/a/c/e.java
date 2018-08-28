package com.tencent.d.a.c;

public class e {
    public String Yy;
    public int errCode;

    public e(int i, String str) {
        this(i);
        if (!f.oW(str)) {
            this.Yy = str;
        }
    }

    public e(int i) {
        this.errCode = i;
        switch (this.errCode) {
            case 0:
                this.Yy = "ok";
                return;
            case 2:
                this.Yy = "device not support soter";
                return;
            default:
                this.Yy = "errmsg not specified";
                return;
        }
    }

    public final boolean isSuccess() {
        return this.errCode == 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((e) obj).errCode == this.errCode;
    }

    public String toString() {
        return "SoterCoreResult{errCode=" + this.errCode + ", errMsg='" + this.Yy + '\'' + '}';
    }
}
