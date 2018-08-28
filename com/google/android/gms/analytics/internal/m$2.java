package com.google.android.gms.analytics.internal;

class m$2 implements Runnable {
    final /* synthetic */ m aFL;
    final /* synthetic */ String aFM;
    final /* synthetic */ Runnable aFN;

    public m$2(m mVar, String str, Runnable runnable) {
        this.aFL = mVar;
        this.aFM = str;
        this.aFN = runnable;
    }

    public final void run() {
        this.aFL.aFJ.aX(this.aFM);
        if (this.aFN != null) {
            this.aFN.run();
        }
    }
}
