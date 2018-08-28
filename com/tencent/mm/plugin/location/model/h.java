package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.location.ui.impl.f;
import com.tencent.mm.protocal.c.afu;
import com.tencent.mm.protocal.c.afv;
import com.tencent.mm.protocal.c.ays;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h extends l implements k {
    public String Yy;
    public int bNI;
    public final b diG;
    private e diJ;
    private Runnable egq;
    public int errCode;
    public int errType;
    public String fuu;
    public boolean hxu = false;
    public byte[] kCI;
    public byte[] kCJ = null;
    public String kCK = "";
    public int kCL;
    public List<f> list = new ArrayList();

    public h(byte[] bArr, double d, double d2, int i, int i2, double d3, double d4, String str, String str2) {
        a aVar = new a();
        aVar.dIG = new afu();
        aVar.dIH = new afv();
        aVar.dIH = new afv();
        aVar.uri = "/cgi-bin/micromsg-bin/getpoilist";
        aVar.dIF = 457;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        afu afu = (afu) this.diG.dID.dIL;
        afu.rIW = bArr == null ? new bhy() : new bhy().bq(bArr);
        afu.rDH = str2;
        afu.rjj = d;
        afu.rji = d2;
        afu.otY = i;
        afu.qZc = i2;
        afu.rJH = d4;
        afu.rJG = d3;
        afu.rIY = 1;
        this.bNI = afu.qZc;
        this.kCK = str;
        this.kCI = bArr;
        x.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f" + bArr, new Object[]{Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d4), Double.valueOf(d3)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGetPoiList", "scene done");
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 457;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + "errMsg:" + str);
        this.errType = i2;
        this.errCode = i3;
        this.Yy = str;
        afv afv = (afv) this.diG.dIE.dIL;
        this.list.clear();
        x.d("MicroMsg.NetSceneGetPoiList", "url " + afv.rJf + " " + afv.rBM + " " + afv.jPK + " " + afv.rlo);
        x.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", new Object[]{Integer.valueOf(afv.rJg)});
        this.fuu = afv.rlo;
        this.kCL = afv.rJg;
        if (afv.rJJ != null) {
            x.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", new Object[]{Integer.valueOf(afv.rJJ.size())});
            if (afv.rJJ.size() > 0) {
                x.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", new Object[]{((ays) afv.rJJ.get(0)).sbw, ((ays) afv.rJJ.get(0)).eJI, ((ays) afv.rJJ.get(0)).ruZ, ((ays) afv.rJJ.get(0)).eJJ});
            }
            Iterator it = afv.rJJ.iterator();
            while (it.hasNext()) {
                this.list.add(new f((ays) it.next(), this.fuu));
            }
        }
        if (afv.rIW != null) {
            this.kCJ = ab.a(afv.rIW);
        }
        this.hxu = afv.rJK == 1;
        this.diJ.a(i2, i3, str, this);
        if (this.egq != null) {
            this.egq.run();
        }
    }

    public final boolean isFirst() {
        return this.kCI == null;
    }
}
