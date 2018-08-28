package com.tencent.mm.ui.base;

class MMTagPanelScrollView$a implements Runnable {
    public MMTagPanel tyj;

    private MMTagPanelScrollView$a() {
    }

    /* synthetic */ MMTagPanelScrollView$a(byte b) {
        this();
    }

    public final void run() {
        if (this.tyj != null) {
            this.tyj.crO();
        }
        this.tyj = null;
    }
}
