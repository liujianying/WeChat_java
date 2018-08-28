package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.g.a.fg;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.ab;

class ExtControlProviderSNS$2 implements Runnable {
    final /* synthetic */ ab hMD;
    final /* synthetic */ b heb;
    final /* synthetic */ ExtControlProviderSNS iKx;

    ExtControlProviderSNS$2(ExtControlProviderSNS extControlProviderSNS, ab abVar, b bVar) {
        this.iKx = extControlProviderSNS;
        this.hMD = abVar;
        this.heb = bVar;
    }

    public final void run() {
        fg fgVar = new fg();
        fgVar.bNs.type = 1;
        fgVar.bNs.username = this.hMD.field_username;
        fgVar.bNs.bNt = ExtControlProviderSNS.a(this.iKx);
        fgVar.bNs.bNu = ExtControlProviderSNS.b(this.iKx);
        fgVar.bNs.bNv = ExtControlProviderSNS.c(this.iKx);
        fgVar.bNs.bNw = new 1(this);
        a.sFg.m(fgVar);
    }
}
