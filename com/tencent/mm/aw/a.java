package com.tencent.mm.aw;

import com.tencent.mm.a.g;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bwe;
import com.tencent.mm.protocal.c.bwf;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    al dHa;
    private b diG;
    e diJ;
    private String ehf;
    private int ehg;
    private int ehh;
    int ehi;
    private int ehj;
    private String filemd5;
    String filename;
    private int sampleRate;

    public a(String str, int i, int i2, int i3, int i4) {
        this.ehf = null;
        this.filemd5 = null;
        this.filename = null;
        this.sampleRate = 0;
        this.ehg = 0;
        this.ehh = 0;
        this.ehi = 0;
        this.ehj = 5;
        this.dHa = new al(new 1(this), true);
        this.ehf = bi.VF();
        this.filename = str;
        this.ehj = i;
        this.sampleRate = i2;
        this.ehg = i3;
        this.ehh = i4;
        this.filemd5 = g.u(com.tencent.mm.a.e.e(this.filename, 0, com.tencent.mm.a.e.cm(this.filename)));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 3960;
        this.diJ = eVar2;
        int cm = com.tencent.mm.a.e.cm(this.filename);
        x.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.Ac() + " read file:" + this.filename + " filelen:" + cm + " oldoff:" + this.ehi + "this.filemd5 " + this.filemd5);
        if (cm <= 0) {
            x.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
            return -1;
        }
        int i2 = cm - this.ehi;
        if (i2 <= 3960) {
            i = i2;
        }
        x.i("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.Ac() + " read file:" + this.filename + " filelen:" + cm + " oldoff:" + this.ehi + "  canReadLen " + i);
        byte[] e = com.tencent.mm.a.e.e(this.filename, this.ehi, i);
        if (e == null) {
            x.e("MicroMsg.NetSceneUploadMedia", "read data error");
            return -1;
        }
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bwe();
        aVar.dIH = new bwf();
        aVar.uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
        aVar.dIF = 240;
        aVar.dII = 111;
        aVar.dIJ = 1000000111;
        this.diG = aVar.KT();
        bwe bwe = (bwe) this.diG.dID.dIL;
        bwe.ssv = new bhz().VO(this.ehf);
        bwe.rtW = new bhy().bq(e);
        bwe.rdX = e.length;
        bwe.ssw = new bhz().VO(this.filemd5);
        bwe.rdV = cm;
        bwe.rdW = this.ehi;
        bwe.jSO = this.ehj;
        bwe.ssx = 1;
        bwe.ssy = this.sampleRate;
        bwe.ssz = this.ehg;
        bwe.ssA = this.ehh;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 240;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.Ac() + " onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        bwe bwe = (bwe) ((b) qVar).dID.dIL;
        String str2 = ((bwf) ((b) qVar).dIE.dIL).rvP;
        x.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", new Object[]{this.filename, str2, Integer.valueOf(bwe.rdV), Integer.valueOf(bwe.rdX), Integer.valueOf(bwe.rdW)});
        if (i2 != 0 || i3 != 0) {
            x.e("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.Ac() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
            this.diJ.a(i2, i3, str, this);
        } else if (bwe.rdV > bwe.rdX + bwe.rdW || str2 == null || str2.equals("0")) {
            this.ehi = bwe.rtW.siI + bwe.rdW;
            x.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
            this.dHa.J(500, 500);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return 60;
    }
}
