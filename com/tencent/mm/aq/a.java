package com.tencent.mm.aq;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class a extends l implements k {
    private e diJ;
    public a ebV;
    public final List<b> ebW = new ArrayList();

    public a(List<b> list) {
        this.ebW.addAll(list);
        this.ebV = new a();
        ((b) this.ebV.KV()).ebZ.rZv = P(list);
    }

    private static pn P(List<b> list) {
        pn pnVar = new pn();
        for (b bVar : list) {
            byte[] buffer = bVar.getBuffer();
            pm pmVar = new pm();
            pmVar.rtM = bVar.getCmdId();
            pmVar.rtN = new bhy().bq(buffer);
            pnVar.hbG.add(pmVar);
        }
        pnVar.hbF = list.size();
        x.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + list.size());
        return pnVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        for (b cmdId : this.ebW) {
            if (cmdId.getCmdId() == 1) {
                ad.getContext().getSharedPreferences(ad.chY(), 0).edit().putBoolean(q.GF() + "_has_mod_userinfo", true).commit();
                break;
            }
        }
        this.diJ = eVar2;
        return a(eVar, this.ebV, this);
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return 5;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 681;
    }
}
