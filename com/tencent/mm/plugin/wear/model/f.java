package com.tencent.mm.plugin.wear.model;

public final class f {
    public String bKg = "";
    public int id = 0;
    public int pJw = 0;
    a pJx;
    public String talker = "";

    protected final Object clone() {
        f fVar = new f();
        fVar.id = this.id;
        fVar.talker = this.talker;
        fVar.bKg = this.bKg;
        fVar.pJw = this.pJw;
        fVar.pJx = this.pJx;
        return fVar;
    }

    public final String toString() {
        return "WearNotification [talker=" + this.talker + ", id=" + this.id + ", md5=" + this.bKg + ", ignoreInWatch=" + this.pJw + ", status=" + this.pJx + "]";
    }
}
