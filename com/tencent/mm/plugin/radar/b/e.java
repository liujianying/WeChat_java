package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import b.i;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.c.ben;
import com.tencent.mm.protocal.c.beo;
import com.tencent.mm.protocal.c.bep;
import com.tencent.mm.protocal.c.beq;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public final class e implements com.tencent.mm.ab.e {
    private static final String TAG = TAG;
    private static final int mki = mki;
    private static final int mkj = 5000;
    private static final int mkk = 1;
    public static final b mkl = new b((byte) 0);
    private String bLe;
    public final a cXs = ((a) new i(this));
    private final Context context;
    private boolean dJO;
    public c dMm;
    private final LinkedList<beq> ebU = new LinkedList();
    private Location mjW;
    private b mjX;
    private f mjY = f.mkx;
    public LinkedList<beo> mjZ;
    public Map<String, String> mka = new LinkedHashMap();
    private Map<String, com.tencent.mm.plugin.radar.b.c.e> mkb = new LinkedHashMap();
    private Map<String, com.tencent.mm.plugin.radar.b.c.e> mkc = new LinkedHashMap();
    public Map<Long, c> mkd = new LinkedHashMap();
    public Map<String, a> mke = new LinkedHashMap();
    private final al mkf = new al((al.a) new h(this), false);
    private final g mkg = new g();
    private final d mkh;

    public e(d dVar, Context context) {
        b.c.b.e.i((Object) dVar, "delegate");
        b.c.b.e.i((Object) context, "context");
        this.mkh = dVar;
        this.context = context;
    }

    public static final /* synthetic */ void bpv() {
    }

    public final void bps() {
        bpt();
        this.dJO = false;
        this.mjW = null;
        this.mjY = f.mkx;
        this.mkf.SO();
        x.d(TAG, "start radar");
        if (this.dMm == null) {
            this.dMm = c.OB();
        }
        this.mjY = f.mky;
        c cVar = this.dMm;
        if (cVar != null) {
            cVar.b(this.cXs);
        }
        x.d(TAG, "status: %s", new Object[]{this.mjY});
    }

    public final void bpt() {
        switch (f.mkC[this.mjY.ordinal()]) {
            case 1:
                return;
            case 2:
                f();
                break;
            case 3:
                if (this.mjX != null) {
                    f();
                    g.DF().c((l) this.mjX);
                    bpu();
                    break;
                }
                break;
            case 4:
                f();
                bpu();
                break;
        }
        x.d(TAG, "stop radar");
    }

    private final void bpu() {
        this.mkg.sendEmptyMessageDelayed(mkk, (long) mkj);
    }

    /* renamed from: stop */
    public final void f() {
        this.dJO = true;
        this.mjY = f.mkx;
        this.mkf.SO();
    }

    private final void a(int i, int i2, LinkedList<beq> linkedList) {
        this.mkh.a(i, i2, linkedList);
    }

    private final void b(int i, int i2, LinkedList<ben> linkedList) {
        this.mkh.b(i, i2, linkedList);
    }

    public final void a(int i, int i2, String str, l lVar) {
        LinkedList linkedList = null;
        b.c.b.e.i((Object) lVar, "scene");
        switch (lVar.getType()) {
            case 425:
                if (this.mjX != lVar) {
                    return;
                }
                if (((b) lVar).bNI == 1) {
                    this.mjY = f.mkA;
                    if (i == 0 && i2 == 0) {
                        x.d(TAG, "rader members count: %s ticket: %s", new Object[]{Integer.valueOf(((b) lVar).bpq()), this.bLe});
                        this.mkf.fZ((long) mki);
                        b bVar = ((b) lVar).diG;
                        bes bes = (bes) (bVar != null ? bVar.KO() : null);
                        if (bes != null) {
                            linkedList = bes.rbQ;
                        }
                        if (linkedList != null) {
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                beq beq = (beq) it.next();
                                com.tencent.mm.plugin.d.a ZN = com.tencent.mm.plugin.d.a.ZN();
                                b.c.b.e.h(ZN, "PinAntispam.instance()");
                                ZN.Gw().fX(beq.hbL, beq.rEJ);
                            }
                        }
                        if (linkedList != null) {
                            this.ebU.clear();
                            this.ebU.addAll(linkedList);
                        }
                        LinkedList linkedList2 = this.ebU;
                        ((b) lVar).bpq();
                        a(i, i2, linkedList2);
                        x.d(TAG, "status: %s", new Object[]{this.mjY});
                        return;
                    }
                    f();
                    a(i, i2, null);
                    return;
                }
                a(i, i2, null);
                return;
            case 602:
                x.d(TAG, " MMFunc_MMRadarRelationChain ");
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.bk.a KO = ((a) lVar).diG.KO();
                    if (KO == null) {
                        throw new i("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarRelationChainResponse");
                    }
                    bep bep = (bep) KO;
                    this.bLe = bep.rwj;
                    if (bep.hLg > 0) {
                        linkedList = bep.rbQ;
                        int i3 = bep.hLg;
                        b(i, i2, linkedList);
                        return;
                    }
                    b(i, i2, null);
                    return;
                }
                b(i, i2, null);
                return;
            default:
                return;
        }
    }

    public final void a(String str, com.tencent.mm.plugin.radar.b.c.e eVar) {
        Object obj = (com.tencent.mm.plugin.radar.b.c.e) this.mkb.get(str);
        if (obj != null && (b.c.b.e.i(obj, (Object) eVar) ^ 1) != 0) {
            this.mkc.put(str, obj);
        }
    }

    public final void b(String str, com.tencent.mm.plugin.radar.b.c.e eVar) {
        b.c.b.e.i((Object) str, "username");
        b.c.b.e.i((Object) eVar, "state");
        if (!b.f.a.U(str)) {
            a(str, eVar);
            this.mkb.put(str, eVar);
        }
    }

    public final com.tencent.mm.plugin.radar.b.c.e a(beq beq, boolean z) {
        b.c.b.e.i((Object) beq, "member");
        String str = beq.hbL;
        b.c.b.e.h(str, "member.UserName");
        com.tencent.mm.plugin.radar.b.c.e aL = aL(str, z);
        if (aL != null) {
            return aL;
        }
        str = beq.ryZ;
        b.c.b.e.h(str, "member.EncodeUserName");
        return aL(str, z);
    }

    public final com.tencent.mm.plugin.radar.b.c.e Kj(String str) {
        b.c.b.e.i((Object) str, "username");
        return aL(str, false);
    }

    private final com.tencent.mm.plugin.radar.b.c.e aL(String str, boolean z) {
        if (z) {
            return (com.tencent.mm.plugin.radar.b.c.e) this.mkc.get(str);
        }
        return (com.tencent.mm.plugin.radar.b.c.e) this.mkb.get(str);
    }

    public final void a(beq beq) {
        if (beq != null) {
            com.tencent.mm.plugin.radar.ui.g gVar = com.tencent.mm.plugin.radar.ui.g.mmr;
            String b = com.tencent.mm.plugin.radar.ui.g.b(beq);
            if (this.mke.containsKey(b)) {
                this.mke.remove(b);
            } else {
                this.mke.put(b, a.mkm);
            }
        }
    }
}
