package com.tencent.xweb.xwalk;

class g$4 implements Runnable {
    final /* synthetic */ String ges;
    final /* synthetic */ Object uRm;
    final /* synthetic */ g vEV;

    g$4(g gVar, Object obj, String str) {
        this.vEV = gVar;
        this.uRm = obj;
        this.ges = str;
    }

    public final void run() {
        if (this.vEV.vET != null) {
            this.vEV.vET.addJavascriptInterface(this.uRm, this.ges);
        }
    }
}
