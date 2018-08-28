package com.tencent.mm.aq;

import android.content.ContentValues;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mm.a.f;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.openim.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.protocal.c.ayo;
import com.tencent.mm.protocal.c.ayq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class p implements e, g {
    boolean dGS = false;
    long dHc = 0;
    f<Integer, Integer> dSK = new f(m.CTRL_INDEX);
    private final int dSP = 500;
    al dSR = new al(com.tencent.mm.kernel.g.Em().lnJ.getLooper(), new 1(this), false);
    i ecp;

    public p(i iVar) {
        this.ecp = iVar;
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(681, this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(806, this);
    }

    public final void b(b bVar) {
        if (bVar != null) {
            String str = "MicroMsg.OplogService";
            String str2 = "summeroplog dealWith option cmdId= %d, buf len:%d, stack=%s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bVar.getCmdId());
            objArr[1] = Integer.valueOf(bVar.getBuffer() == null ? -1 : bVar.getBuffer().length);
            objArr[2] = bi.cjd();
            x.i(str, str2, objArr);
            bVar.dSH = bi.VF();
            i iVar = this.ecp;
            if (bVar != null) {
                bVar.bWA = -1;
                ContentValues contentValues = new ContentValues();
                if ((bVar.bWA & 2) != 0) {
                    contentValues.put("inserTime", Long.valueOf(bVar.dSH));
                }
                if ((bVar.bWA & 4) != 0) {
                    contentValues.put("cmdId", Integer.valueOf(bVar.getCmdId()));
                }
                if ((bVar.bWA & 8) != 0) {
                    contentValues.put("buffer", bVar.getBuffer());
                }
                if ((bVar.bWA & 16) != 0) {
                    contentValues.put("reserved1", Integer.valueOf(bVar.lcD));
                }
                if ((bVar.bWA & 32) != 0) {
                    contentValues.put("reserved2", Long.valueOf(bVar.lcE));
                }
                if ((bVar.bWA & 64) != 0) {
                    contentValues.put("reserved3", bVar.lcF);
                }
                if ((bVar.bWA & MapRouteSectionWithName.kMaxRoadNameLength) != 0) {
                    contentValues.put("reserved4", bVar.lcG);
                }
                int insert = (int) iVar.dCZ.insert("oplog2", SlookAirButtonFrequentContactAdapter.ID, contentValues);
                if (insert > 0) {
                    bVar.id = insert;
                }
            }
        } else {
            x.i("MicroMsg.OplogService", "summeroplog dealWith option null");
        }
        this.dSR.J(0, 0);
    }

    public final void c(b bVar) {
        com.tencent.mm.kernel.g.Ek();
        long dO = com.tencent.mm.kernel.g.Ei().dqq.dO(Thread.currentThread().getId());
        this.ecp.a(bVar);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Ei().dqq.gp(dO);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.OplogService", "oplog onsceneEnd errType:%d,errCode:%d,errMsg:%s, sceneType", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(lVar.getType())});
        if (lVar.getType() == 806) {
            if (i == 0 || i2 == 0) {
                x.i("MicroMsg.OplogService", "openim op success, type:%d", new Object[]{Integer.valueOf(((d) lVar).euu.lcD)});
                this.ecp.a(r0);
            }
        } else if (lVar.getType() != 681) {
        } else {
            if (i == 0 && i2 == 0 && ((a) lVar).ebV != null) {
                ayq ayq = ((a) lVar).ebV.ebY.eca;
                if (ayq.rfn != 0 || ayq.sbu == null || ayq.sbu.rHd == null) {
                    x.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[]{Integer.valueOf(ayq.rfn)});
                    this.dGS = false;
                    return;
                }
                ll llVar = new ll();
                llVar.bVN.ret = ((Integer) ayq.sbu.rHd.getLast()).intValue();
                LinkedList linkedList = ayq.sbu.sbv;
                llVar.bVN.bVO = linkedList.isEmpty() ? "" : ((ayo) linkedList.getLast()).bHD;
                llVar.bVN.bVP = linkedList.isEmpty() ? "" : ((ayo) linkedList.getLast()).jSA;
                a.sFg.m(llVar);
                new a(this, ((a) lVar).ebW, ayq.sbu.rHd).J(50, 50);
                return;
            }
            x.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ((a) lVar).ebV.toString()});
            this.dGS = false;
        }
    }
}
