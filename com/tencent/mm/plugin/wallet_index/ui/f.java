package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.d.a.a.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.q;
import java.util.ArrayList;

public final class f implements b {
    private d pDM = null;
    private c pDN;
    private c pDc;

    public f(c cVar, c cVar2) {
        this.pDc = cVar;
        this.pDN = cVar2;
        a.sFg.b(this.pDN);
    }

    public final int bRd() {
        return 2;
    }

    public final void a(MMActivity mMActivity, d dVar) {
        x.i("MicroMsg.WeiXinWallet", "[alex] WeiXinWallet launchPay");
        q.cDf();
        this.pDM = dVar;
        if (!this.pDc.pDp) {
            PayInfo payInfo = new PayInfo();
            payInfo.bOd = this.pDc.pCQ.rQl;
            payInfo.partnerId = this.pDc.pCQ.rQm;
            payInfo.cdL = this.pDc.pCQ.rQn;
            payInfo.bVY = 5;
            h.a(mMActivity, payInfo, 1);
        } else if (this.pDc.pCQ != null) {
            g gVar = new g();
            gVar.appId = this.pDc.pCQ.rQo.hva;
            gVar.timeStamp = this.pDc.pCQ.rQo.pnl;
            gVar.nonceStr = this.pDc.pCQ.rQo.hFm;
            gVar.packageExt = this.pDc.pCQ.rQo.sbE;
            gVar.signType = this.pDc.pCQ.rQo.hFk;
            gVar.bVW = this.pDc.pCQ.rQn;
            gVar.bVY = this.pDc.pCQ.bVY;
            h.a(mMActivity, gVar, 1, null);
        } else {
            x.e("MicroMsg.WeiXinWallet", "[alex] mIapData.iapWxPayData is null");
        }
    }

    public final boolean a(MMActivity mMActivity, int i, int i2, Intent intent) {
        x.d("MicroMsg.WeiXinWallet", "onPayEnd payResult : " + i2 + ", data is null : " + (intent == null));
        if (this.pDM != null) {
            com.tencent.mm.plugin.wallet_index.c.a aN;
            if (i2 == -1) {
                if (intent == null || intent.getIntExtra("key_jsapi_pay_err_code", 0) != 0) {
                    aN = com.tencent.mm.plugin.wallet_index.c.a.aN(5, "");
                } else {
                    aN = com.tencent.mm.plugin.wallet_index.c.a.aN(0, "");
                }
            } else if (i2 == 0) {
                aN = com.tencent.mm.plugin.wallet_index.c.a.aN(1, "");
            } else {
                aN = com.tencent.mm.plugin.wallet_index.c.a.aN(6, "");
            }
            x.i("MicroMsg.WeiXinWallet", "wxpay result : ");
            this.pDM.a(aN, new com.tencent.mm.plugin.wallet_index.b.a.c(this.pDc.iiv, this.pDc.pDh, this.pDc.pCK, this.pDc.pCL));
            this.pDM = null;
        }
        return true;
    }

    public final void j(MMActivity mMActivity) {
        a.sFg.c(this.pDN);
    }

    public final void b(MMActivity mMActivity, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("key_err_code", 0);
        intent.putExtra("key_err_msg", "");
        mMActivity.setResult(-1, intent);
        t.finish();
    }

    public final void a(MMActivity mMActivity, ArrayList<String> arrayList, d dVar, boolean z) {
        if (dVar != null) {
            dVar.a(com.tencent.mm.plugin.wallet_index.c.a.aN(0, ""), new com.tencent.mm.plugin.wallet_index.b.a.c(this.pDc.iiv, this.pDc.pDh, this.pDc.pCK, this.pDc.pCL));
        }
    }
}
