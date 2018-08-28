package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.protocal.c.fp;
import com.tencent.mm.protocal.c.re;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ag extends l implements k {
    private final b diG;
    private e diJ = null;
    private LinkedList<Integer> iWK;
    private int iWL = 0;

    public ag(LinkedList<Integer> linkedList) {
        a aVar = new a();
        aVar.dIG = new fo();
        aVar.dIH = new fp();
        aVar.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
        aVar.dIF = 403;
        aVar.dII = 194;
        aVar.dIJ = 1000000194;
        this.diG = aVar.KT();
        this.iWK = linkedList;
    }

    private boolean aLK() {
        boolean z;
        if (this.iWK == null || this.iWL >= this.iWK.size()) {
            z = false;
        } else {
            z = true;
        }
        x.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.iWK == null || this.iWK.isEmpty() || this.iWL >= this.iWK.size()) {
            x.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", new Object[]{Integer.valueOf(this.iWL)});
            return -1;
        }
        int i;
        this.diJ = eVar2;
        x.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[]{Integer.valueOf(this.iWK.size()), Integer.valueOf(this.iWL), this.iWK});
        fo foVar = (fo) this.diG.dID.dIL;
        foVar.rgy.clear();
        int i2 = this.iWL;
        int i3 = 0;
        while (true) {
            i = i2;
            if (i >= this.iWK.size()) {
                break;
            }
            i2 = ((Integer) this.iWK.get(i)).intValue();
            if (i2 > 0) {
                foVar.rgy.add(Integer.valueOf(i2));
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i3 = 20;
            if (i2 >= 20) {
                break;
            }
            i++;
        }
        this.iWL = i + 1;
        foVar.hbF = foVar.rgy.size();
        x.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", new Object[]{Integer.valueOf(foVar.hbF), foVar.rgy});
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.iWL), Integer.valueOf(this.iWK.size()), str});
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((fp) ((b) qVar).dIE.dIL).hbG;
            if (linkedList == null || linkedList.size() == 0) {
                x.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
                if (aLK()) {
                    a(this.dIX, this.diJ);
                    return;
                } else {
                    this.diJ.a(i2, i3, str, this);
                    return;
                }
            }
            List arrayList = new ArrayList();
            x.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet respList size:%d", new Object[]{Integer.valueOf(linkedList.size())});
            for (int i4 = 0; i4 < linkedList.size(); i4++) {
                re reVar = (re) linkedList.get(i4);
                if (reVar.rfn < 0) {
                    x.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", new Object[]{Integer.valueOf(reVar.rbY)});
                } else {
                    arrayList.add(Integer.valueOf(reVar.rbY));
                    x.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", new Object[]{Integer.valueOf(reVar.rbY)});
                }
            }
            b.ba(arrayList);
            if (aLK()) {
                a(this.dIX, this.diJ);
            } else {
                this.diJ.a(i2, i3, str, this);
            }
        } else if (aLK()) {
            a(this.dIX, this.diJ);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return 10;
    }

    public final int getType() {
        return 403;
    }
}
