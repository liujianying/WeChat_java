package com.tencent.mm.sdk.e;

public final class l {
    public String bHA;
    public int fBN;
    public Object obj;
    public j sKL;

    public l() {
        this.bHA = null;
        this.sKL = null;
        this.fBN = -1;
        this.obj = null;
    }

    public l(String str) {
        this.bHA = str;
        this.sKL = null;
        this.fBN = -1;
        this.obj = null;
    }

    public final String toString() {
        return "MStorageEventData [event=" + this.bHA + ", eventId=" + this.fBN + ", stg=" + this.sKL + ", obj=" + this.obj + "]";
    }
}
