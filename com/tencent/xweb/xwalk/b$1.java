package com.tencent.xweb.xwalk;

class b$1 implements Runnable {
    final /* synthetic */ b vEH;

    b$1(b bVar) {
        this.vEH = bVar;
    }

    public final void run() {
        if (this.vEH.vED == null) {
            this.vEH.vED = new XWAppBrandEngine();
        }
    }
}
