package com.tencent.mm.plugin.radar.b;

import b.i;
import com.tencent.mm.aa.j;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bk.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.radar.ui.g;
import com.tencent.mm.protocal.c.beq;
import com.tencent.mm.protocal.c.ber;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;

public final class b extends l implements k {
    private static final String TAG = TAG;
    public static final a mjo = new a((byte) 0);
    final int bNI;
    private final float bSx;
    private final float bUg;
    private final int bUh;
    private final int bUi;
    private final String bUj;
    private final String bUk;
    com.tencent.mm.ab.b diG;
    private e diJ;

    public /* synthetic */ b() {
        this(2, 0.0f, 0.0f, 0, 0, "", "");
    }

    public b(int i, float f, float f2, int i2, int i3, String str, String str2) {
        b.c.b.e.i((Object) str, "macAddr");
        b.c.b.e.i((Object) str2, "cellId");
        this.bNI = i;
        this.bSx = f;
        this.bUg = f2;
        this.bUh = i2;
        this.bUi = i3;
        this.bUj = str;
        this.bUk = str2;
        if (this.bNI == 0) {
            x.e(TAG, "opcode is wrong!");
        }
    }

    public final int bpq() {
        com.tencent.mm.ab.b bVar = this.diG;
        bes bes = (bes) (bVar != null ? bVar.KO() : null);
        return bes != null ? bes.hLg : 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d(TAG, "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (this.bNI == 1 && i2 == 0) {
            ArrayList arrayList = new ArrayList();
            com.tencent.mm.ab.b bVar = this.diG;
            a KO = bVar != null ? bVar.KO() : null;
            if (!(KO instanceof bes)) {
                KO = null;
            }
            bes bes = (bes) KO;
            if (bes != null) {
                LinkedList<beq> linkedList = bes.rbQ;
                if (linkedList != null) {
                    for (beq beq : linkedList) {
                        j jVar = new j();
                        g gVar = g.mmr;
                        b.c.b.e.h(beq, "member");
                        jVar.setUsername(g.b(beq));
                        jVar.kb(beq.rwN);
                        jVar.by(true);
                        arrayList.add(jVar);
                    }
                }
            }
            com.tencent.mm.aa.q.KH().L(arrayList);
        }
        e eVar = this.diJ;
        if (eVar != null) {
            eVar.a(i2, i3, str, (l) this);
        }
    }

    public final int getType() {
        return 425;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        b.c.b.e.i((Object) eVar, "dispatcher");
        b.c.b.e.i((Object) eVar2, "callback");
        this.diJ = eVar2;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.a((a) new ber());
        aVar.b((a) new bes());
        aVar.ke("/cgi-bin/micromsg-bin/mmradarsearch");
        aVar.KQ();
        aVar.KR();
        aVar.KS();
        this.diG = aVar.KT();
        com.tencent.mm.ab.b bVar = this.diG;
        if (bVar == null) {
            b.c.b.e.cJM();
        }
        a KN = bVar.KN();
        if (KN == null) {
            throw new i("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
        }
        ber ber = (ber) KN;
        ber.qZc = this.bNI;
        ber.ryX = this.bUk;
        ber.ryY = this.bUi;
        ber.rms = this.bSx;
        ber.rmr = this.bUg;
        ber.ryW = this.bUj;
        ber.ryV = this.bUh;
        return a(eVar, (q) this.diG, (k) this);
    }
}
