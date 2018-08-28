package com.tencent.mm.openim;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.s;
import com.tencent.mm.openim.b.j;
import com.tencent.mm.openim.c.h;
import com.tencent.mm.openim.d.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class PluginOpenIM extends f implements a, c {
    public static HashMap<Integer, d> cVM;
    private com.tencent.mm.sdk.b.c eud = new 1(this);
    private com.tencent.mm.openim.d.d eue;
    private b euf;
    private com.tencent.mm.openim.d.f eug;

    public com.tencent.mm.openim.d.d getAppIdInfoStg() {
        g.Eg().Ds();
        if (this.euf == null) {
            g.Ek();
            this.eue = new com.tencent.mm.openim.d.d(g.Ei().dqq);
        }
        return this.eue;
    }

    public b getAccTypeInfoStg() {
        g.Eg().Ds();
        if (this.euf == null) {
            g.Ek();
            this.euf = new b(g.Ei().dqq);
        }
        return this.euf;
    }

    public com.tencent.mm.openim.d.f getWordingInfoStg() {
        g.Eg().Ds();
        if (this.eug == null) {
            g.Ek();
            this.eug = new com.tencent.mm.openim.d.f(g.Ei().dqq);
        }
        return this.eug;
    }

    public void onAccountInitialized(e.c cVar) {
        x.i("MicroMsg.PluginOpenIM", "onAccountInitialized");
        com.tencent.mm.sdk.b.a.sFg.a(this.eud);
        g.Ek();
        g.a(com.tencent.mm.openim.a.b.class, new j());
        g.Ek();
        g.a(com.tencent.mm.openim.a.a.class, new h());
        s.a((ag) g.l(com.tencent.mm.openim.a.a.class));
        g.Ek();
        g.Eh().dpP.a(453, (com.tencent.mm.ab.e) g.l(com.tencent.mm.openim.a.b.class));
    }

    public void onAccountRelease() {
        x.i("MicroMsg.PluginOpenIM", "onAccountRelease");
        com.tencent.mm.sdk.b.a.sFg.c(this.eud);
        g.Ek();
        g.Eh().dpP.b(453, (com.tencent.mm.ab.e) g.l(com.tencent.mm.openim.a.b.class));
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public void configure(com.tencent.mm.kernel.b.g gVar) {
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("OpenIMAccTypeInfo_TABLE".hashCode()), new 2());
        cVM.put(Integer.valueOf("OpenIMAppIdInfo_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return com.tencent.mm.openim.d.d.diD;
            }
        });
        cVM.put(Integer.valueOf("OpenIMWordingInfo_TABLE".hashCode()), new 4());
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        return cVM;
    }
}
