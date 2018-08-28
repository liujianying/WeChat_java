package com.tencent.mm.plugin.wallet_index.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.a.te;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.tenpay.model.k;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class h extends c<te> implements e {
    int pCR;
    int pCS;
    gw pCT;
    lo pCU;
    long pCV;
    public c pCW;
    public c<lo> pCX;

    public h() {
        this.pCS = 0;
        this.pCW = new 1(this);
        this.pCX = new 2(this);
        this.sFo = te.class.getName().hashCode();
    }

    static /* synthetic */ void a(h hVar, lo loVar) {
        hVar.pCU = loVar;
        String str = loVar.bVS.url;
        int i = loVar.bVS.scene;
        int i2 = loVar.bVS.bVU;
        int i3 = loVar.bVS.bJt;
        String str2 = loVar.bVS.bhd == null ? "" : loVar.bVS.bhd;
        hVar.pCR = 1;
        x.d("MicroMsg.WalletGetA8KeyRedirectListener", "auth native, url: %s, a8key_scene: %d, channel: %d, sourceType: %d, source: %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2});
        k kVar = new k(str, i, hVar.pCR, i2, i3, str2);
        g.Ek();
        g.Eh().dpP.a(385, hVar);
        g.Ek();
        g.Eh().dpP.a(kVar, 0);
    }

    public final /* synthetic */ boolean a(b bVar) {
        te teVar = (te) bVar;
        q.cDf();
        if (teVar instanceof te) {
            x.d("MicroMsg.WalletGetA8KeyRedirectListener", "onPayEnd, isOk = " + (teVar.ceH.result == -1));
            a.sFg.c(this);
            if (teVar.ceH.result != -1) {
                return true;
            }
            Intent intent = new Intent();
            intent.addFlags(67108864);
            if (teVar.ceH.intent == null || teVar.ceH.intent.getIntExtra("pay_channel", 0) != 13) {
                d.e(ad.getContext(), ".ui.LauncherUI", intent);
                return true;
            }
            x.i("MicroMsg.WalletGetA8KeyRedirectListener", "channel is MMPAY_CHANNEL_SCAN_QRCODE_IMAGE_CHANNEL ，return org page");
            return true;
        }
        x.f("MicroMsg.WalletGetA8KeyRedirectListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.modelsimple.h) {
            long currentTimeMillis = System.currentTimeMillis() - this.pCV;
            com.tencent.mm.plugin.report.service.h.mEJ.h(11170, new Object[]{Integer.valueOf(233), Integer.valueOf(0), Long.valueOf(currentTimeMillis), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(ao.getNetType(ad.getContext())), ""});
            i(i, i2, currentTimeMillis);
            x.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
            g.Ek();
            g.Eh().dpP.b(233, this);
            if (i == 0 && i2 == 0) {
                cs(((com.tencent.mm.modelsimple.h) lVar).QL(), this.pCS);
                return;
            }
            if (bi.oW(str)) {
                str = this.pCT.bQd.context.getString(i.wallet_unknown_err);
            }
            com.tencent.mm.ui.base.h.a(this.pCT.bQd.context, str, "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (h.this.pCT.bJX != null) {
                        h.this.pCT.bQe.ret = 1;
                        h.this.pCT.bJX.run();
                    }
                }
            });
        } else if (lVar instanceof k) {
            x.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            g.Ek();
            g.Eh().dpP.b(385, this);
            if (i == 0 && i2 == 0 && "0".equals(((k) lVar).uYk)) {
                u.j(this.pCR, ((k) lVar).bOd, i2);
                k kVar = (k) lVar;
                PayInfo payInfo = new PayInfo();
                payInfo.bVY = this.pCR;
                payInfo.bOd = kVar.bOd;
                payInfo.appId = kVar.appId;
                payInfo.pCO = kVar.pCO;
                payInfo.bKk = kVar.bKk;
                payInfo.bVU = kVar.bVU;
                x.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", new Object[]{payInfo.toString()});
                com.tencent.mm.pluginsdk.wallet.h.a(this.pCU.bVS.context, payInfo, 0);
                if (this.pCU.bJX != null) {
                    this.pCU.bVT.ret = 1;
                    this.pCU.bJX.run();
                    return;
                }
                return;
            }
            if (bi.oW(str)) {
                if (bi.oW(((k) lVar).fFG)) {
                    str = this.pCU.bVS.context.getString(i.wallet_unknown_err);
                } else {
                    str = ((k) lVar).fFG;
                }
            }
            u.j(this.pCR, "", i2);
            com.tencent.mm.ui.base.h.a(this.pCU.bVS.context, str, "", new 4(this));
        } else {
            x.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
        }
    }

    private void cs(String str, int i) {
        x.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = " + str);
        PayInfo payInfo = new PayInfo();
        payInfo.bVY = this.pCR;
        String str2 = null;
        Object obj = null;
        for (String str3 : str.replace("http://p.qq.com?", "").split("&")) {
            if (str3.startsWith("errcode=")) {
                obj = str3.replace("errcode=", "");
            } else if (str3.startsWith("errmsg=")) {
                str2 = str3.replace("errmsg=", "");
            } else if (str3.startsWith("reqkey=")) {
                payInfo.bOd = str3.replace("reqkey=", "");
            } else if (str3.startsWith("uuid=")) {
                payInfo.fMk = str3.replace("uuid=", "");
            } else if (str3.startsWith("appid=")) {
                payInfo.appId = str3.replace("appid=", "");
            } else if (str3.startsWith("appsource=")) {
                payInfo.pCO = str3.replace("appsource=", "");
            } else if (str3.startsWith("productid=")) {
                payInfo.bKk = str3.replace("productid=", "");
            }
        }
        payInfo.bVU = i;
        if ("0".equals(obj)) {
            com.tencent.mm.pluginsdk.wallet.h.a(this.pCT.bQd.context, payInfo, 0);
            if (this.pCT.bJX != null) {
                this.pCT.bQe.ret = 1;
                this.pCT.bJX.run();
            }
        } else {
            if (bi.oW(str2)) {
                str2 = this.pCT.bQd.context.getString(i.wallet_unknown_err);
            }
            com.tencent.mm.ui.base.h.a(this.pCT.bQd.context, str2, "", new 5(this));
        }
        if (!TextUtils.isEmpty(obj) && Pattern.compile("[0-9]*").matcher(obj).matches()) {
            i(0, Integer.valueOf(obj).intValue(), 0);
        }
    }

    private void i(int i, int i2, long j) {
        IDKey iDKey;
        int i3 = 132;
        if (this.pCR == 1) {
            i3 = 163;
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i3);
        iDKey2.SetValue(1);
        iDKey2.SetKey(26);
        arrayList.add(iDKey2);
        if (!(i == 0 && i2 == 0)) {
            iDKey2 = new IDKey();
            iDKey2.SetID(i3);
            iDKey2.SetValue(1);
            iDKey = new IDKey();
            iDKey.SetID(i3);
            iDKey.SetValue(1);
            iDKey2.SetKey(8);
            if (i2 < 0) {
                iDKey.SetKey(9);
            } else if (i2 > 0) {
                iDKey.SetKey(10);
            }
        }
        if (this.pCR == 4 && j > 0) {
            iDKey2 = new IDKey();
            iDKey2.SetID(i3);
            iDKey2.SetValue(1);
            iDKey = new IDKey();
            iDKey.SetID(i3);
            iDKey.SetValue(1);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(i3);
            iDKey3.SetValue((long) ((int) j));
            iDKey2.SetKey(0);
            if (j <= 1000) {
                iDKey.SetKey(1);
                iDKey3.SetKey(4);
            } else if (j > 1000 && j <= 3000) {
                iDKey.SetKey(2);
                iDKey3.SetKey(5);
            } else if (j > 3000) {
                iDKey.SetKey(3);
                iDKey3.SetKey(6);
            }
            arrayList.add(iDKey2);
            arrayList.add(iDKey);
            arrayList.add(iDKey3);
        }
        com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, true);
    }
}
