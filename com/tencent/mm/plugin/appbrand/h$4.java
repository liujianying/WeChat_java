package com.tencent.mm.plugin.appbrand;

class h$4 implements Runnable {
    final /* synthetic */ h fdt;
    final /* synthetic */ g fdu;

    h$4(h hVar, g gVar) {
        this.fdt = hVar;
        this.fdu = gVar;
    }

    public final void run() {
        h hVar = this.fdt;
        g gVar = this.fdu;
        if (gVar != null) {
            gVar.cleanup();
            hVar.fcA.removeView(gVar.fcA);
            hVar.fdo.remove(gVar.mAppId);
            hVar.fdn.remove(gVar);
        }
    }
}
