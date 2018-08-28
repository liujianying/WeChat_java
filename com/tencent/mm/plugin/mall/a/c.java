package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.azs;
import com.tencent.mm.protocal.c.ccr;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

public final class c extends l implements k {
    private b diG;
    private e diJ;
    public ccr kYf;

    public c() {
        boolean booleanValue;
        a aVar = new a();
        aVar.dIG = new azr();
        aVar.dIH = new azs();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
        aVar.dIF = 1577;
        this.diG = aVar.KT();
        azr azr = (azr) this.diG.dID.dIL;
        g.Ek();
        Object obj = g.Ei().DT().get(aa.a.sSo, Boolean.valueOf(false));
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        azr.scg = booleanValue ? 1 : 0;
        azr.aem = w.chP();
        azr.scj = VERSION.RELEASE;
        azr.sci = com.tencent.mm.sdk.platformtools.e.aj(null, d.qVN);
        azr.sck = Build.MANUFACTURER;
        x.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", new Object[]{Integer.valueOf(azr.scg), azr.aem, azr.scj, azr.sci, azr.sck});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            azs azs = (azs) ((b) qVar).dIE.dIL;
            if (azs.scn == null || azs.sco == null) {
                x.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + azs.kYc);
            } else {
                x.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd wallet_region : %s wallet_gray_area: %s wallet_threepoint_area size: %s", new Object[]{Integer.valueOf(azs.kYc), Integer.valueOf(azs.scn.rFB.size()), Integer.valueOf(azs.sco.rFB.size())});
                if (azs.scr != null) {
                    this.kYf = azs.scr;
                    x.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "wallet_key_info flag %s wallet_key_info.url %s", new Object[]{Integer.valueOf(azs.scr.syt), azs.scr.url});
                }
            }
            g.Ek();
            g.Ei().DT().a(aa.a.sTs, Integer.valueOf(azs.kYc));
            o.bPc().a(azs.kYc, azs);
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final String bbI() {
        if (this.kYf == null) {
            return "";
        }
        return this.kYf.url;
    }

    public final int getType() {
        return 1577;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
