package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.c;
import com.tencent.mm.bt.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.wear.model.e.e;
import com.tencent.mm.plugin.wear.model.e.f;
import com.tencent.mm.plugin.wear.model.e.g;
import com.tencent.mm.plugin.wear.model.e.k;
import com.tencent.mm.plugin.wear.model.e.l;
import com.tencent.mm.plugin.wear.model.e.m;
import com.tencent.mm.plugin.wear.model.e.n;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g.b;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class a implements ar {
    q pIK;
    public r pIL;
    public d pIM;
    private e pIN;
    public g pIO;
    public b pIP;
    private WearMessageLogic pIQ;
    private i pIR;
    public j pIS;
    public com.tencent.mm.plugin.wear.model.g.a pIT;
    private d pIU;

    public a() {
        x.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", new Object[]{getClass().getClassLoader()});
    }

    public final HashMap<Integer, h.d> Ci() {
        return null;
    }

    public static a bSl() {
        au.HN();
        a aVar = (a) bs.iK("plugin.wear");
        if (aVar != null) {
            return aVar;
        }
        aVar = new a();
        au.HN().a("plugin.wear", aVar);
        return aVar;
    }

    public final void gi(int i) {
        x.i("MicroMsg.Wear.SubCoreWear", "clearPluginData, pluginFlag=%d", new Object[]{Integer.valueOf(i)});
    }

    public final void bn(boolean z) {
        o.h.qyk = new c();
        x.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", new Object[]{Boolean.valueOf(z)});
        this.pIK = new q();
        this.pIL = new r();
        this.pIS = new j();
        this.pIN = new e();
        this.pIO = new g();
        this.pIP = new b();
        this.pIM = new d();
        this.pIQ = new WearMessageLogic();
        this.pIR = new i();
        this.pIT = new com.tencent.mm.plugin.wear.model.g.a();
        this.pIU = new b();
        c.a(Integer.valueOf(63), this.pIU);
        this.pIK.a(this.pIM.pJc);
        this.pIK.a(this.pIM.pJd);
        this.pIK.a(this.pIM.pJe);
        this.pIK.a(new com.tencent.mm.plugin.wear.model.e.h());
        this.pIK.a(new g());
        this.pIK.a(new com.tencent.mm.plugin.wear.model.e.d());
        this.pIK.a(new com.tencent.mm.plugin.wear.model.e.c());
        this.pIK.a(new e());
        this.pIK.a(new f());
        this.pIK.a(new k());
        this.pIK.a(new m());
        this.pIK.a(new com.tencent.mm.plugin.wear.model.e.o());
        this.pIK.a(new n());
        this.pIK.a(new l());
        this.pIS.a(new 1(this));
        j jVar = this.pIS;
        2 2 = new 2(this);
        if (jVar.giD != null) {
            jVar.giD.sendMessageDelayed(jVar.giD.obtainMessage(0, 2), 5000);
        }
    }

    public final void bo(boolean z) {
        x.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", new Object[]{Boolean.valueOf(z)});
    }

    public final void onAccountRelease() {
        c.b(Integer.valueOf(63), this.pIU);
        this.pIU = null;
        x.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
        this.pIK.pKf.clear();
        this.pIK = null;
        this.pIL = null;
        e eVar = this.pIN;
        eVar.eOf.SO();
        eVar.ocR.dead();
        eVar.pJi.dead();
        eVar.pJj.dead();
        eVar.pJk.dead();
        eVar.pJl.dead();
        eVar.pJm.dead();
        eVar.pJn.dead();
        eVar.cYt.dead();
        eVar.kRJ.dead();
        au.HU();
        com.tencent.mm.model.c.FT().a(eVar.iJe);
        this.pIN = null;
        this.pIO = null;
        b bVar = this.pIP;
        com.tencent.mm.sdk.b.a.sFg.c(bVar.pIX);
        au.HU();
        com.tencent.mm.model.c.FR().b(bVar.jtB);
        bVar.pIY.SO();
        this.pIP = null;
        d dVar = this.pIM;
        dVar.pJb.finish();
        dVar.pJf.reset();
        this.pIM = null;
        ad.getContext().unregisterReceiver(this.pIQ);
        this.pIQ = null;
        j jVar = this.pIS;
        if (jVar.handlerThread != null) {
            jVar.handlerThread.quit();
        }
        this.pIS = null;
        i iVar = this.pIR;
        iVar.daT = null;
        iVar.bSs();
        ad.getContext().unregisterReceiver(iVar.pJG);
        this.pIR = null;
    }
}
