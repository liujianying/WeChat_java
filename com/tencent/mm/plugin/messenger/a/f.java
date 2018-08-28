package com.tencent.mm.plugin.messenger.a;

import com.tencent.mm.aa.j;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.protocal.c.biz;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class f extends l implements k {
    private final b diG;
    private e diJ;
    public final boolean lbK;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i) {
        this(str, i, (byte) 0);
    }

    private f(String str, int i, byte b) {
        this(str, 1, i, false);
    }

    public f(String str, int i, int i2, boolean z) {
        this.lbK = z;
        a aVar = new a();
        aVar.dIG = new biz();
        aVar.dIH = new bja();
        aVar.uri = "/cgi-bin/micromsg-bin/searchcontact";
        aVar.dIF = s$l.AppCompatTheme_ratingBarStyle;
        aVar.dII = 34;
        aVar.dIJ = 1000000034;
        this.diG = aVar.KT();
        x.d("MicroMsg.NetSceneSearchContact", "search username [%s]", new Object[]{str});
        biz biz = (biz) this.diG.dID.dIL;
        biz.rvi = new bhz().VO(str);
        biz.sdG = i;
        biz.sjk = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return s$l.AppCompatTheme_ratingBarStyle;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        j jVar;
        bja bja = (bja) this.diG.dIE.dIL;
        if (bja != null && bja.rHb > 0) {
            Iterator it = bja.rHc.iterator();
            while (it.hasNext()) {
                biy biy = (biy) it.next();
                x.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", new Object[]{biy.rvi});
                j jVar2 = new j();
                jVar2.username = ab.a(biy.rvi);
                jVar2.dHR = biy.rqZ;
                jVar2.dHQ = biy.rra;
                jVar2.bWA = -1;
                x.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[]{jVar2.getUsername(), jVar2.Kx(), jVar2.Ky()});
                jVar2.csA = 3;
                jVar2.by(true);
                com.tencent.mm.aa.q.KH().a(jVar2);
            }
        } else if (!(bja == null || bi.oW(ab.a(bja.rvi)))) {
            String a = ab.a(bja.rvi);
            jVar = new j();
            jVar.username = a;
            jVar.dHR = bja.rqZ;
            jVar.dHQ = bja.rra;
            jVar.bWA = -1;
            x.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[]{jVar.getUsername(), jVar.Kx(), jVar.Ky()});
            jVar.csA = 3;
            jVar.by(true);
            com.tencent.mm.aa.q.KH().a(jVar);
        }
        if (bja != null) {
            Iterator it2 = bja.sjp.iterator();
            while (it2.hasNext()) {
                bjp bjp = (bjp) it2.next();
                jVar = new j();
                jVar.username = bjp.hbL;
                jVar.dHR = bjp.rqZ;
                jVar.dHQ = bjp.rra;
                jVar.bWA = -1;
                x.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[]{jVar.getUsername(), jVar.Kx(), jVar.Ky()});
                jVar.csA = 3;
                jVar.by(true);
                com.tencent.mm.aa.q.KH().a(jVar);
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final bja bcS() {
        bja bja = (bja) this.diG.dIE.dIL;
        if (bja != null) {
            Iterator it = bja.rHc.iterator();
            while (it.hasNext()) {
                biy biy = (biy) it.next();
                com.tencent.mm.plugin.d.a.ZN().Gw().fX(biy.rvi.siM, biy.rEJ);
            }
        }
        return bja;
    }
}
