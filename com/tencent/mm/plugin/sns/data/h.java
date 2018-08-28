package com.tencent.mm.plugin.sns.data;

public final class h {
    public String bOX = "";
    public String desc = "";
    public int fileSize = 0;
    public int height = -1;
    public int nkW = 0;
    public int nkX;
    public int nkY;
    public int nkZ;
    public String nla = "";
    public String nlb = "";
    public String nlc = "";
    public boolean nld = false;
    public String path = "";
    public int type;
    public int width = -1;

    public h(String str, int i) {
        this.path = str;
        this.type = i;
        this.nkZ = -1;
    }

    public h(int i, int i2) {
        this.nkZ = i;
        this.type = i2;
        this.path = "";
    }
}
