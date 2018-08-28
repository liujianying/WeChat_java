package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.dynamic.a.b;
import com.tencent.mm.protocal.c.cdj;
import com.tencent.mm.protocal.c.cdk;
import com.tencent.mm.sdk.platformtools.x;

class a$b$1 implements Runnable {
    final /* synthetic */ c dmx;
    final /* synthetic */ c fuh;
    final /* synthetic */ b fuj;
    final /* synthetic */ String sk;

    a$b$1(b bVar, c cVar, String str, c cVar2) {
        this.fuj = bVar;
        this.fuh = cVar;
        this.sk = str;
        this.dmx = cVar2;
    }

    public final void run() {
        c cVar = this.fuh;
        x.i("MicroMsg.DynamicPageViewIPCProxy", "detach(%s)", new Object[]{cVar.doU});
        cVar.Sx = false;
        cVar.cleanup();
        cVar.doR = null;
        cVar.fut = null;
        cVar.doU = null;
        cVar.fmS = null;
        k.sB(this.sk);
        this.dmx.at(null);
        f aeS = f.aeS();
        String str = this.sk;
        if (aeS.fuI.containsKey(str)) {
            f.b bVar = (f.b) aeS.fuI.get(str);
            x.i("MicroMsg.DynamicPageViewStateMonitor", "OnDettach ready to report keyList[%s]", new Object[]{bVar.fuM.toString()});
            if (bVar.fuM.size() > 0) {
                a aVar = new a();
                aVar.dIF = 2653;
                aVar.uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_widgetalarm";
                cdj cdj = new cdj();
                cdj.bPS = bVar.appId;
                cdj.id = bVar.dCn;
                cdj.syU = bVar.fuM;
                cdj.bWm = bVar.bWm;
                aVar.dIG = cdj;
                aVar.dIH = new cdk();
                com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.KT(), aeS.fuJ);
                return;
            }
            return;
        }
        x.w("MicroMsg.DynamicPageViewStateMonitor", "OnDettach but no keylist found, widgetId[%s]", new Object[]{str});
    }
}
