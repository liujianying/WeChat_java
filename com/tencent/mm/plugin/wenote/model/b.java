package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.wj;
import com.tencent.mm.protocal.c.wp;
import com.tencent.mm.protocal.c.wq;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b extends l implements k {
    private final com.tencent.mm.ab.b diG;
    private e diJ = null;
    public int qnu = 1;
    private String qnv = "";
    private wj qnw = null;
    private LinkedList<wj> qnx = new LinkedList();
    public int qny = 0;

    public b(int i, int i2, String str, LinkedList<wj> linkedList, wj wjVar) {
        this.qnx = linkedList;
        this.qnw = wjVar;
        this.qnv = str;
        this.qnu = i2;
        this.qny = i;
        a aVar = new a();
        aVar.dIG = new wp();
        aVar.dIH = new wq();
        aVar.uri = "/cgi-bin/micromsg-bin/favsecurity ";
        aVar.dIF = 921;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        wp wpVar = (wp) this.diG.dID.dIL;
        wpVar.jRb = this.qnu;
        wpVar.rBO = this.qnw;
        wpVar.rBN = this.qnx;
        wpVar.rBM = this.qnv;
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckNoteSecurity", "netId %d errType %d errCode %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        wq wqVar = (wq) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
        if (i2 != 0) {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,errType:%d,fail", new Object[]{Integer.valueOf(i2)});
            this.diJ.a(i2, -1, str, this);
        } else if (wqVar == null || wqVar.six == null) {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,response == null,ok");
            this.diJ.a(i2, 0, str, this);
        } else if (wqVar.six.rfn != 0) {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,baseresponse.ret != 0,ok");
            this.diJ.a(i2, 0, str, this);
        } else if (wqVar.rBP > 0) {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult > 0,fail");
            this.diJ.a(i2, -1, str, this);
        } else {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult = 0,fail");
            this.diJ.a(i2, 0, str, this);
        }
    }

    protected final int a(q qVar) {
        return com.tencent.mm.ab.l.b.dJm;
    }

    public final int getType() {
        return 921;
    }
}
