package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.akb;
import com.tencent.mm.protocal.c.akc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.IOException;

public final class g extends l implements k {
    private b diG = null;
    private e diJ;
    private akb krs = null;
    public akc krt = null;

    public g(int i) {
        a aVar = new a();
        aVar.dIG = new akb();
        aVar.dIH = new akc();
        aVar.dIF = 257;
        aVar.uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.krs = (akb) this.diG.dID.dIL;
        this.krs.otY = i;
        akb akb = this.krs;
        au.HU();
        akb.rMF = ((Integer) c.DT().get(aa.a.sRm, Integer.valueOf(0))).intValue();
        akb = this.krs;
        au.HU();
        akb.rMG = ((Integer) c.DT().get(aa.a.sRa, Integer.valueOf(0))).intValue();
        x.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", new Object[]{Integer.valueOf(this.krs.otY), Integer.valueOf(this.krs.rMF), Integer.valueOf(this.krs.rMG)});
    }

    public final int getType() {
        return 257;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.krt = (akc) ((b) qVar).dIE.dIL;
        if ((i2 == 0 || i3 == 0) && i2 == 0 && i3 == 0) {
            akc akc = this.krt;
            if (akc != null) {
                x.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", new Object[]{akc.rMK, akc.rML, akc.rMH, akc.ksB, akc.bHD, akc.jOS, akc.rMI, akc.rMJ, akc.rMM, akc.rMS});
                try {
                    au.HU();
                    c.DT().a(aa.a.sSg, bi.bE(akc.toByteArray()));
                } catch (IOException e) {
                    x.i("MicroMsg.IPCallUtil", "[royle]save exception:%s", new Object[]{e.getMessage()});
                }
            }
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
