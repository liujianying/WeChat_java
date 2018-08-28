package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.ws;
import com.tencent.mm.protocal.c.wt;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class aj extends l implements k {
    final b diG;
    e diJ = null;
    private a iWU = new a(this);
    long iWV = -1;
    public boolean iWW = false;
    private int selector = 1;

    public aj() {
        x.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync");
        a aVar = new a();
        aVar.dIG = new ws();
        aVar.dIH = new wt();
        aVar.uri = "/cgi-bin/micromsg-bin/favsync";
        aVar.dIF = 400;
        aVar.dII = 195;
        aVar.dIJ = 1000000195;
        aVar.dIK = false;
        this.diG = aVar.KT();
    }

    public aj(int i) {
        x.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync %d", new Object[]{Integer.valueOf(i)});
        a aVar = new a();
        aVar.dIG = new ws();
        aVar.dIH = new wt();
        aVar.uri = "/cgi-bin/micromsg-bin/favsync";
        aVar.dIF = 400;
        aVar.dII = 195;
        aVar.dIJ = 1000000195;
        aVar.dIK = false;
        this.diG = aVar.KT();
        this.selector = i;
    }

    public final boolean KX() {
        return true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        ws wsVar = (ws) this.diG.dID.dIL;
        wsVar.rnx = this.selector;
        byte[] aLx = ((ae) g.n(ae.class)).getFavConfigStorage().aLx();
        if (this.selector == 2) {
            aLx = new byte[0];
        }
        wsVar.rny = ab.O(aLx);
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Fav.NetSceneFavSync", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (((ae) g.n(ae.class)).getSendService().TM()) {
            x.w("MicroMsg.Fav.NetSceneFavSync", "sending item, skip sync onGYNetEnd");
            this.diJ.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            wt wtVar = (wt) ((b) qVar).dIE.dIL;
            LinkedList linkedList = wtVar.rnB.hbG;
            if (linkedList == null || linkedList.size() <= 0) {
                if (wtVar.rny.siK != null) {
                    byte[] g = z.g(((ws) ((b) qVar).dID.dIL).rny.siK.toByteArray(), wtVar.rny.siK.toByteArray());
                    if (g != null && g.length > 0) {
                        ((ae) g.n(ae.class)).getFavConfigStorage().aw(g);
                    }
                } else {
                    x.e("MicroMsg.Fav.NetSceneFavSync", "merge key should not be null");
                }
                g.Ei().DT().set(8217, Integer.valueOf(1));
                this.diJ.a(i2, i3, str, this);
                return;
            }
            x.i("MicroMsg.Fav.NetSceneFavSync", "cmdList size:" + linkedList.size());
            if (this.selector != 2) {
                a aVar = this.iWU;
                aVar.iWX = linkedList;
                if (aVar.iWX != null && aVar.iWX.size() > 0) {
                    g.DF().a(new ak(), 0);
                }
                aVar.iWY.sendEmptyMessage(0);
                return;
            }
            this.diJ.a(i2, i3, str, this);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }

    protected final int Cc() {
        return 50;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    public final int getType() {
        return 400;
    }
}
