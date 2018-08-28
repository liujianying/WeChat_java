package com.tencent.mm.plugin.luckymoney.a;

import android.text.TextUtils;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.luckymoney.b.aj;
import com.tencent.mm.plugin.luckymoney.b.b;
import com.tencent.mm.plugin.luckymoney.b.c;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.g;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class a implements ar {
    private com.tencent.mm.model.bv.a hTD = new com.tencent.mm.model.bv.a() {
        public final void a(com.tencent.mm.ab.d.a aVar) {
            Map z = bl.z(ab.a(aVar.dIN.rcl), "sysmsg");
            x.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
            if (z == null) {
                x.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
                return;
            }
            if ("14".equals((String) z.get(".sysmsg.paymsg.PayMsgType"))) {
                String decode = URLDecoder.decode((String) z.get(".sysmsg.paymsg.appmsgcontent"));
                if (TextUtils.isEmpty(decode)) {
                    x.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
                    return;
                }
                Map z2 = bl.z(decode, "msg");
                if (z2 == null) {
                    x.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
                    return;
                }
                String str = (String) z2.get(".msg.appmsg.wcpayinfo.paymsgid");
                if (bi.oW(str)) {
                    x.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
                    return;
                }
                String str2 = (String) z.get(".sysmsg.paymsg.tousername");
                if (bi.oW(decode) || bi.oW(str2)) {
                    x.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                } else if (a.this.baw().Gb(str)) {
                    x.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
                    if (!o.C(decode, str2, 1)) {
                        a.this.baw().Gc(str);
                    }
                }
            }
        }
    };
    private e kKF;
    private g kKG;
    private c kKH = new c();
    private aj kKI;
    private com.tencent.mm.sdk.b.c<tm> kKJ = new 2(this);

    public static a bat() {
        return (a) p.v(a.class);
    }

    public a() {
        File file = new File(bav());
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(com.tencent.mm.compatible.util.e.dgu);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        ap ccb = ap.ccb();
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            com.tencent.mm.plugin.ac.a.bmi().a(4, ccb);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(1060, ccb);
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().a("paymsg", this.hTD, true);
        boolean z2 = false;
        com.tencent.mm.kernel.g.Ek();
        if (System.currentTimeMillis() - com.tencent.mm.kernel.g.Ei().DT().Dj(352276) >= 43200000) {
            z2 = true;
        }
        x.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + z2 + ", isUpdate=" + z);
        if (z || z2) {
            x.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
            ap.ccb().eT(ad.getContext());
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.kKH);
        com.tencent.mm.sdk.b.a.sFg.b(this.kKJ);
        this.kKI = new aj();
        b.init();
    }

    public final void onAccountRelease() {
        ap ccb = ap.ccb();
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            com.tencent.mm.plugin.ac.a.bmi().b(4, ccb);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.b(1060, ccb);
            ccb.qAT = false;
            ccb.qAU = false;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().b("paymsg", this.hTD, true);
        synchronized (this) {
            this.kKG = null;
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.kKH);
        com.tencent.mm.sdk.b.a.sFg.c(this.kKJ);
        if (this.kKI != null) {
            aj ajVar = this.kKI;
            com.tencent.mm.sdk.b.a.sFg.c(ajVar.kRJ);
            if (ajVar.kRG != null) {
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Eh().dpP.c(ajVar.kRG);
                ajVar.kRG = null;
            }
            if (ajVar.kRH != null) {
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Eh().dpP.c(ajVar.kRH);
                ajVar.kRH = null;
            }
        }
        b.Wa();
    }

    public static e bau() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bat().kKF == null) {
            bat().kKF = new e();
        }
        return bat().kKF;
    }

    public static String bav() {
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            return com.tencent.mm.plugin.p.c.Gb() + "luckymoney";
        }
        return "";
    }

    public final synchronized g baw() {
        if (this.kKG == null) {
            this.kKG = new g();
        }
        return this.kKG;
    }
}
