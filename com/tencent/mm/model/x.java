package com.tencent.mm.model;

public class x {
    public final boolean bKe;
    private final String bWI;
    private final String dBm;
    private boolean dBn;
    private final String name;
    private final String type;

    public x() {
        this.type = "";
        this.name = "";
        this.bWI = "";
        this.dBm = "";
        this.bKe = true;
    }

    public x(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        this.type = str;
        this.name = str2;
        this.bWI = str3;
        this.dBm = str4;
        this.bKe = z;
        this.dBn = z2;
    }

    public final String getType() {
        return this.type == null ? "" : this.type;
    }

    public final String BK() {
        return this.bWI == null ? "" : this.bWI;
    }

    public final String Hz() {
        return this.dBm == null ? "" : this.dBm;
    }
}
