package com.tencent.mm.storage;

public final class ao {
    public String bKk;
    public String ioy;
    public int taU;
    private boolean taV;
    public int taW;
    public int taX;
    public String taY;

    public ao() {
        this.taV = false;
        this.taU = -1;
    }

    public ao(String str) {
        this.taV = false;
        this.bKk = str;
        this.taU = -1;
    }

    public final void Dl(int i) {
        if (!(this.taU == -1 || this.taU == i || i != 7)) {
            this.taV = true;
        }
        this.taU = i;
    }
}
