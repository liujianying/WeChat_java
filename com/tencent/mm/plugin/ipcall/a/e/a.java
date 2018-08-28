package com.tencent.mm.plugin.ipcall.a.e;

public class a {
    public boolean bTv = false;

    public void start() {
        reset();
        this.bTv = true;
    }

    public void reset() {
    }

    protected void aXS() {
    }

    public final void finish() {
        if (this.bTv) {
            aXS();
            this.bTv = false;
        }
    }
}
