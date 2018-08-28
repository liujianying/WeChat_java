package com.tencent.mm.plugin.sport;

import com.tencent.mm.booter.MMReceivers.ExdeviceProcessReceiver;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.sport.c.g;
import com.tencent.mm.plugin.sport.c.h;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.j;
import com.tencent.mm.plugin.sport.c.l;
import com.tencent.mm.plugin.sport.c.m;
import java.util.HashMap;

public class PluginSport extends f implements b, a, c, a {
    public static HashMap<Integer, d> cVM;
    private com.tencent.mm.plugin.sport.c.a ooA;
    private com.tencent.mm.plugin.sport.c.b ooB;
    private l ooC;
    private m ooD;
    private g.a ooE = new 1(this);
    private h ooy;
    private com.tencent.mm.plugin.sport.b.b ooz;

    public void configure(com.tencent.mm.kernel.b.g gVar) {
        ExdeviceProcessReceiver.a(new j());
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
        if (this.ooy == null) {
            this.ooy = i.bFN();
        }
        if (gVar.ES()) {
            this.ooz = new c();
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sport.b.b.class, new e(this.ooz));
        }
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        this.ooA = new com.tencent.mm.plugin.sport.c.a();
        this.ooB = new com.tencent.mm.plugin.sport.c.b();
        this.ooD = new m();
        this.ooC = new l();
        g.a(this.ooE);
        this.ooE.bFt();
    }

    public h getSportFileStorage() {
        if (this.ooy == null) {
            this.ooy = i.bFN();
        }
        return this.ooy;
    }

    public com.tencent.mm.plugin.sport.c.a getDeviceStepManager() {
        return this.ooA;
    }

    public com.tencent.mm.plugin.sport.c.b getExtApiStepManager() {
        return this.ooB;
    }

    public l getSportStepManager() {
        return this.ooC;
    }

    public m getSportStepStorage() {
        return this.ooD;
    }

    public void onAccountRelease() {
        g.a(null);
        if (this.ooA != null) {
            com.tencent.mm.plugin.sport.c.a aVar = this.ooA;
            aVar.ooJ.dead();
            if (aVar.ooK != null) {
                com.tencent.mm.kernel.g.DF().c(aVar.ooK);
            }
            this.ooA = null;
        }
        if (this.ooB != null) {
            com.tencent.mm.plugin.sport.c.b bVar = this.ooB;
            bVar.ooQ.dead();
            bVar.ooJ.dead();
            if (bVar.ooK != null) {
                com.tencent.mm.kernel.g.DF().c(bVar.ooK);
            }
            this.ooB = null;
        }
    }

    public void parallelsDependency() {
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).aN(com.tencent.mm.kernel.g.n(o.class));
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("SPORTSTEP_TABLE".hashCode()), new 2());
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        return cVM;
    }
}
