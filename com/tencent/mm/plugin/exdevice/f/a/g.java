package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.protocal.c.xj;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g extends a<bw, bx> {
    List<String> gZA;
    private final WeakReference<b<g>> isV;
    public ArrayList<xj> ixu;

    protected final /* synthetic */ com.tencent.mm.bk.a aGw() {
        return new bw();
    }

    protected final /* synthetic */ com.tencent.mm.bk.a aGx() {
        return new bx();
    }

    protected final /* synthetic */ void g(com.tencent.mm.bk.a aVar) {
        bw bwVar = (bw) aVar;
        for (String add : this.gZA) {
            bwVar.ebM.add(add);
        }
    }

    public g(List<String> list, b<g> bVar) {
        this.gZA = list;
        this.isV = new WeakReference(bVar);
    }

    public final int getType() {
        return 1777;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneAddFollow", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            bx bxVar = (bx) asj();
            this.ixu = new ArrayList();
            if (bxVar.rch != null) {
                Iterator it = bxVar.rch.iterator();
                while (it.hasNext()) {
                    x.d("MicroMsg.NetSceneAddFollow", "follow: index:%s step: %s username: %s", new Object[]{Integer.valueOf(r1.index), Integer.valueOf(r1.fHo), ((xj) it.next()).username});
                    this.ixu.add(r1);
                }
                x.d("MicroMsg.NetSceneAddFollow", "follows: %s, %d", new Object[]{this.ixu.toString(), Integer.valueOf(bxVar.rch.size())});
            }
            ad.aHg().a(this.ixu, "hardcode_rank_id", "hardcode_app_name");
        }
        super.a(i, i2, i3, str, qVar, bArr);
        b bVar = (b) this.isV.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/addfollow";
    }
}
