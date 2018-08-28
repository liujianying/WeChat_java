package com.tencent.mm.plugin.location.ui.impl;

class i$6 implements Runnable {
    final /* synthetic */ i kKy;

    i$6(i iVar) {
        this.kKy = iVar;
    }

    public final void run() {
        if (this.kKy.kHV) {
            if (this.kKy.eHw != null) {
                this.kKy.eHw.dismiss();
            }
            this.kKy.bam();
        }
        this.kKy.kHV = false;
    }
}
