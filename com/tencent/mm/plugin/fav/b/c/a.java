package com.tencent.mm.plugin.fav.b.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ns;
import com.tencent.mm.protocal.c.nt;
import com.tencent.mm.protocal.c.nu;
import com.tencent.mm.protocal.c.wd;
import com.tencent.mm.protocal.c.wo;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a extends l implements k {
    private b dZf;
    private e diJ = null;

    public a(List<wd> list) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new ns();
        aVar.dIH = new nt();
        aVar.uri = "/cgi-bin/micromsg-bin/checkfavitem";
        aVar.dIF = 405;
        aVar.dII = 196;
        aVar.dIJ = 1000000196;
        this.dZf = aVar.KT();
        ns nsVar = (ns) this.dZf.dID.dIL;
        nsVar.rrQ = new LinkedList();
        nsVar.rrQ.addAll(list);
        nsVar.otY = 1;
        x.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_OBJECT %s", new Object[]{Integer.valueOf(list.size())});
    }

    public a(wo woVar) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new ns();
        aVar.dIH = new nt();
        aVar.uri = "/cgi-bin/micromsg-bin/checkfavitem";
        aVar.dIF = 405;
        aVar.dII = 196;
        aVar.dIJ = 1000000196;
        this.dZf = aVar.KT();
        ns nsVar = (ns) this.dZf.dID.dIL;
        nsVar.rrR = woVar;
        nsVar.otY = 2;
        x.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_DATA %s", new Object[]{Integer.valueOf(woVar.rbY)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Fav.NetSceneCheckFavItem", "netId %d errType %d errCode %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        nt ntVar = (nt) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0) {
            Iterator it = ntVar.rrS.iterator();
            while (it.hasNext()) {
                nu nuVar = (nu) it.next();
                x.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem, onGYNetEnd,favid: %d, ret: %d", new Object[]{Integer.valueOf(nuVar.rbY), Integer.valueOf(nuVar.rfn)});
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        x.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem,cgi return error,errcode:%d,errType:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
        this.diJ.a(i2, i3, str, this);
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return 10;
    }

    public final int getType() {
        return 405;
    }
}
