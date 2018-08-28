package com.tencent.mm.plugin.backup.a;

public class f$b implements Cloneable, Comparable<f$b> {
    public String gRI;
    public long gRJ = 0;
    public long gRK = 0;
    public long gRL = -1;
    public long gRM = -1;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        f$b f_b = (f$b) obj;
        if (this.gRL < f_b.gRL) {
            return 1;
        }
        return this.gRL > f_b.gRL ? -1 : 0;
    }

    /* renamed from: aqY */
    public final f$b clone() {
        f$b f_b = new f$b();
        f_b.gRI = this.gRI;
        f_b.gRJ = this.gRJ;
        f_b.gRK = this.gRK;
        f_b.gRL = this.gRL;
        f_b.gRM = this.gRM;
        return f_b;
    }
}
