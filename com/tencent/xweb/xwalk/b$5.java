package com.tencent.xweb.xwalk;

class b$5 implements Runnable {
    final /* synthetic */ String ges;
    final /* synthetic */ Object uRm;
    final /* synthetic */ b vEH;

    b$5(b bVar, Object obj, String str) {
        this.vEH = bVar;
        this.uRm = obj;
        this.ges = str;
    }

    public final void run() {
        if (this.vEH.vED != null) {
            XWAppBrandEngine xWAppBrandEngine = this.vEH.vED;
            xWAppBrandEngine.addJsInterface(xWAppBrandEngine.mInstance, this.uRm, this.ges);
        }
    }
}
