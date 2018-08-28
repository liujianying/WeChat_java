package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI;
import com.tencent.mm.plugin.wallet_payu.a.d;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.j;
import java.util.ArrayList;

public class WalletPayUOrderInfoUI extends WalletOrderInfoOldUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(1554);
    }

    protected final void bQp() {
        a(new a(), true, true);
    }

    protected final void Pt(String str) {
        a(new c(str, 1), true, true);
    }

    public void onDestroy() {
        js(1554);
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a) {
            return true;
        }
        if (lVar instanceof c) {
            c cVar = (c) lVar;
            if (cVar.mCZ.ppf == null || cVar.mCZ.ppf.size() <= 0) {
                x.w("MicroMsg.WalletPayUOrderInfoUI", "hy: no commodity. show alert");
                h.a(this, i.wallet_payu_show_order_error, i.app_tip, new 1(this));
            } else {
                Commodity commodity = (Commodity) cVar.mCZ.ppf.get(0);
                x.d("MicroMsg.WalletPayUOrderInfoUI", "Coomdity:" + commodity);
                d.bRk().pEW = null;
                if (commodity != null) {
                    this.pvL = new ArrayList();
                    this.pvL.add(commodity);
                    g.Ek();
                    ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(commodity.lNW);
                    if (Yg == null || ((int) Yg.dhP) == 0) {
                        am.a.dBr.a(commodity.lNW, "", this.pwB);
                    } else {
                        M(Yg);
                    }
                    this.pwu.notifyDataSetChanged();
                    bQq();
                }
            }
        }
        return super.d(i, i2, str, lVar);
    }

    public final void done() {
        String str;
        bQb();
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.sy.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.sy.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.sy.getBoolean("intent_pay_end"));
        x.i("MicroMsg.WalletPayUOrderInfoUI", "pay done...feedbackData errCode:" + this.sy.getInt("intent_pay_end_errcode"));
        for (String str2 : this.pvK) {
            if (!bi.oW(str2)) {
                x.d("MicroMsg.WalletPayUOrderInfoUI", "hy: doing netscene subscribe...appName: %s", new Object[]{str2});
                a(new j(str2), false, false);
            }
        }
        com.tencent.mm.wallet_core.a.j(this, bundle);
        if (this.pfb != null && !bi.oW(this.pfb.ixy)) {
            str2 = this.pfb.ppf.size() > 0 ? ((Commodity) this.pfb.ppf.get(0)).bOe : "";
            str2 = String.format("%sreqkey=%s&transid=%s", new Object[]{this.pfb.ixy, this.pfb.bOd, str2});
            x.d("MicroMsg.WalletPayUOrderInfoUI", "url = " + str2);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", q.GF());
            com.tencent.mm.bg.d.b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }
}
