package com.tencent.mm.plugin.voip.model;

class r$4 implements Runnable {
    final /* synthetic */ String jcA;
    final /* synthetic */ r oNq;

    r$4(r rVar, String str) {
        this.oNq = rVar;
        this.jcA = str;
    }

    public final void run() {
        if (this.oNq.oNb != null) {
            o oVar = this.oNq.oNb;
            String str = this.jcA;
            if (oVar.oLN != null) {
                oVar.oMr = str;
                oVar.oLN.OH(str);
            }
        }
    }
}
