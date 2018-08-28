package com.tencent.mm.plugin.report.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class d {
    public String bKg;
    public long mEn;
    public long mEo;
    public String mEp;
    public boolean mEq;
    public String value;

    public d(long j, String str, long j2, boolean z) {
        this.mEn = j;
        this.value = str;
        this.mEo = j2;
        this.mEq = z;
        this.mEp = new SimpleDateFormat("[yy-MM-dd HH:mm:ss:SSS]").format(new Date(j2));
    }

    public final String toString() {
        return this.mEp + ":" + this.value;
    }
}
