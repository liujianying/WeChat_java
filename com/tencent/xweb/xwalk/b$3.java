package com.tencent.xweb.xwalk;

class b$3 implements Runnable {
    final /* synthetic */ b vEH;

    b$3(b bVar) {
        this.vEH = bVar;
    }

    public final void run() {
        if (this.vEH.vED != null) {
            XWAppBrandEngine xWAppBrandEngine = this.vEH.vED;
            xWAppBrandEngine.nativeFinalize(xWAppBrandEngine.mInstance);
            this.vEH.vED = null;
            this.vEH.vEE.getLooper().quit();
            this.vEH.vEE = null;
        }
    }
}
