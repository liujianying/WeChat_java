package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.b.c;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bor;
import com.tencent.mm.protocal.c.bos;
import com.tencent.mm.sdk.platformtools.x;
import java.io.OutputStream;

public final class p extends l implements k {
    private OutputStream dHY = null;
    private b diG;
    public e diJ;
    private String filename;
    String mediaId = "";
    private String nnX;
    private int nnY = -1;
    int nnZ = -1;
    private boolean noa = true;
    private String nob = null;
    private ate noc;

    public p(ate ate, String str, String str2, int i, boolean z, int i2, String str3) {
        this.mediaId = str;
        this.noc = ate;
        this.noa = z;
        this.nnY = i;
        this.nnZ = i2;
        this.nob = str3;
        this.nnX = an.s(af.getAccSnsPath(), str);
        a aVar = new a();
        aVar.dIG = new bor();
        aVar.dIH = new bos();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
        aVar.dIF = 208;
        aVar.dII = 96;
        aVar.dIJ = 1000000096;
        this.diG = aVar.KT();
        bor bor = (bor) this.diG.dID.dIL;
        r NA = af.byd().NA(str);
        if (NA == null) {
            NA = new r();
        }
        NA.nJL = str;
        NA.offset = 0;
        af.byd().a(str, NA);
        if (z) {
            this.filename = i.n(ate);
        } else {
            this.filename = i.m(ate);
        }
        FileOp.mL(this.nnX);
        FileOp.deleteFile(an.s(af.getAccSnsPath(), str) + this.filename);
        bor.smD = str2;
        bor.smE = 0;
        bor.rdW = 0;
        bor.rdV = 0;
        bor.hcE = this.nnY;
        x.d("MicroMsg.NetSceneSnsDownload", "requestKey " + str3);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsDownload", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bos bos = (bos) ((b) qVar).dIE.dIL;
        if (((c) qVar.Id()).qWB != 0) {
            this.diJ.a(i2, i3, str, this);
            af.byj().LW(this.nob);
            return;
        }
        r NA = af.byd().NA(this.mediaId);
        if (bos.rdV <= 0) {
            x.e("MicroMsg.NetSceneSnsDownload", "error 1");
            onError();
        } else if (bos.rfy == null) {
            x.e("MicroMsg.NetSceneSnsDownload", "error 2");
            onError();
        } else if (bos.rdW < 0 || bos.rdW + bos.rfy.siK.lR.length > bos.rdV) {
            x.e("MicroMsg.NetSceneSnsDownload", "error 3");
            onError();
        } else if (bos.rdW != NA.offset) {
            x.e("MicroMsg.NetSceneSnsDownload", "error 4");
            onError();
        } else {
            int H = H(bos.rfy.siK.toByteArray());
            if (H < 0) {
                x.e("MicroMsg.NetSceneSnsDownload", "error 5");
                onError();
                return;
            }
            NA.offset += H;
            NA.nJH = bos.rdV;
            x.d("MicroMsg.NetSceneSnsDownload", "byteLen " + H + "  totalLen " + bos.rdV);
            af.byd().a(this.mediaId, NA);
            Object obj = (NA.offset != NA.nJH || NA.nJH == 0) ? null : 1;
            if (obj != null) {
                x.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
                String e = this.nnZ == 1 ? i.e(this.noc) : i.l(this.noc);
                String s = an.s(af.getAccSnsPath(), this.mediaId);
                FileOp.deleteFile(s + e);
                FileOp.i(s, this.filename, e);
                if (this.noa) {
                    s.b(s, e, i.f(this.noc), (float) af.byw());
                } else {
                    String e2 = i.e(this.noc);
                    if (!FileOp.cn(s + e2)) {
                        s.a(s, e, e2, (float) af.byx());
                    }
                    e2 = i.f(this.noc);
                    if (!FileOp.cn(s + e2)) {
                        s.b(s, e, e2, (float) af.byw());
                    }
                }
                af.byj().LW(this.nob);
                this.diJ.a(i2, i3, str, this);
                return;
            }
            a(this.dIX, this.diJ);
        }
    }

    private void onError() {
        af.byj().LW(this.nob);
    }

    public final int getType() {
        return 208;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return 100;
    }

    private int H(byte[] bArr) {
        if (!i.LM(af.Gq())) {
            return 0;
        }
        try {
            if (this.dHY == null) {
                FileOp.mL(this.nnX);
                this.dHY = FileOp.jx(this.nnX + this.filename);
            }
            x.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + bArr.length);
            this.dHY.write(bArr);
            return bArr.length;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSnsDownload", e, "appendBuf failed: " + this.filename, new Object[0]);
            return -1;
        } finally {
            KA();
        }
    }

    private void KA() {
        try {
            if (this.dHY != null) {
                this.dHY.flush();
                this.dHY.close();
                this.dHY = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSnsDownload", e, "", new Object[0]);
        }
    }
}
