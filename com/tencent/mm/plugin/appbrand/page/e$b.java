package com.tencent.mm.plugin.appbrand.page;

abstract class e$b implements Runnable {
    boolean Ju;
    private boolean gmB;

    public abstract void alI();

    private e$b() {
        this.gmB = false;
        this.Ju = false;
    }

    /* synthetic */ e$b(byte b) {
        this();
    }

    public void run() {
        boolean z = (this.gmB || this.Ju) ? false : true;
        if (z) {
            this.gmB = true;
            alI();
        }
    }
}
