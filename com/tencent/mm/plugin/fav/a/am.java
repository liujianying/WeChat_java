package com.tencent.mm.plugin.fav.a;

import android.util.SparseArray;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bne;
import com.tencent.mm.protocal.c.bnf;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class am extends l implements k {
    private final b diG;
    private e diJ = null;
    private List<Integer> iXg;
    private a iXh = null;
    private SparseArray<String> iXi = new SparseArray();
    private int scene;
    private String toUser;

    public am(String str, List<Integer> list, a aVar) {
        a aVar2 = new a();
        aVar2.dIG = new bne();
        aVar2.dIH = new bnf();
        aVar2.uri = "/cgi-bin/micromsg-bin/sharefav";
        aVar2.dIF = 608;
        aVar2.dII = 246;
        aVar2.dIJ = 1000000246;
        this.diG = aVar2.KT();
        this.toUser = str;
        this.scene = 2;
        this.iXg = list;
        this.iXh = aVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneShareFavItem", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.iXi.clear();
        if (i2 == 0 && i3 == 0) {
            bnf bnf = (bnf) ((b) qVar).dIE.dIL;
            if (bnf.rLA != this.iXg.size()) {
                x.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", new Object[]{Integer.valueOf(this.iXg.size()), Integer.valueOf(bnf.rLA)});
            }
            int i4 = 0;
            while (i4 < bnf.slh.size() && i4 < this.iXg.size()) {
                x.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", new Object[]{this.iXg.get(i4), bnf.slh.get(i4)});
                this.iXi.put(((Integer) this.iXg.get(i4)).intValue(), ((bhz) bnf.slh.get(i4)).siM);
                i4++;
            }
        }
        this.diJ.a(i2, i3, str, this);
        if (this.iXh != null) {
            this.iXh.c(this.iXi);
        }
    }

    public final int getType() {
        return 608;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        bne bne = (bne) this.diG.dID.dIL;
        bne.slg = this.toUser;
        bne.otY = this.scene;
        bne.rgy = new LinkedList(this.iXg);
        bne.hbF = bne.rgy.size();
        x.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", new Object[]{bne.slg, Integer.valueOf(bne.otY), bne.rgy, Integer.valueOf(bne.hbF)});
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
