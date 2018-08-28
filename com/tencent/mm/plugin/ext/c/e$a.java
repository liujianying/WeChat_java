package com.tencent.mm.plugin.ext.c;

public class e$a {
    public int iKW;
    private boolean iKX;
    public int type;
    public String url;

    public e$a(int i, String str, int i2) {
        this.iKX = false;
        this.type = i;
        this.url = str;
        this.iKX = false;
        this.iKW = i2;
    }

    public e$a() {
        this.iKX = false;
        this.iKX = true;
    }

    public final String toString() {
        return "QrCodeModel{type=" + this.type + ", url='" + this.url + '\'' + ", flagTimeout=" + this.iKX + '}';
    }
}
