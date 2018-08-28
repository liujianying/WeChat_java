package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.bi;

class c$a {
    long mEndTime = -1;
    long mStartTime = -1;
    long noj;
    d nuu;
    int nuv = 0;
    int nuw = 0;
    String nux = "";
    String nuy = "";
    String nuz;

    public c$a(long j, long j2, String str, d dVar) {
        this.nuu = dVar;
        this.mStartTime = j;
        this.noj = j2;
        this.nuz = str;
    }

    public final void dv(int i, int i2) {
        this.nuv = i;
        this.nuw = i2;
    }

    public final void t(int i, int i2, int i3, int i4) {
        if (i != -1 && i2 != -1) {
            String str = i + ":" + i2 + ":" + i3 + ":" + i4;
            String str2 = i + ":" + i2;
            if (!str.equals(this.nux)) {
                if (!this.nux.startsWith(str2) || i3 != 0 || i4 != 0) {
                    this.nux = str;
                    str = i + ":" + i2 + ":" + i3 + ":" + i4;
                    if (!bi.oW(this.nuy)) {
                        this.nuy += "|";
                    }
                    this.nuy += str;
                }
            }
        }
    }
}
