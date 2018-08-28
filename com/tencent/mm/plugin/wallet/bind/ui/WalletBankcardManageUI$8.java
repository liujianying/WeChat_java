package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Date;

class WalletBankcardManageUI$8 implements OnClickListener {
    final /* synthetic */ WalletBankcardManageUI pdm;
    final int pdp = BaseReportManager.MAX_READ_COUNT;

    WalletBankcardManageUI$8(WalletBankcardManageUI walletBankcardManageUI) {
        this.pdm = walletBankcardManageUI;
    }

    public final void onClick(View view) {
        Intent intent;
        if (view.getId() == f.wallet_entrance_add_bankcard) {
            g bOA = g.bOA();
            if (bOA.aKp()) {
                h.b(this.pdm, bOA.lMX, this.pdm.getString(i.app_tip), true);
                return;
            }
            e.He(19);
            this.pdm.bNj();
            com.tencent.mm.plugin.report.service.h.mEJ.h(14422, new Object[]{Integer.valueOf(2)});
        } else if (view.getId() == f.wallet_entrance_loan) {
            Object tag = view.getTag();
            long time = new Date().getTime();
            view.setTag(Long.valueOf(time));
            if (tag == null || time - ((Long) tag).longValue() >= 1000) {
                intent = new Intent();
                intent.putExtra("rawUrl", WalletBankcardManageUI.a(this.pdm).field_loan_jump_url);
                d.b(this.pdm, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Ei().DT().a(a.sRJ, Integer.valueOf(WalletBankcardManageUI.a(this.pdm).field_red_dot_index));
                e.He(6);
            }
        } else if (view.getId() == f.bank_card_help) {
            intent = new Intent();
            intent.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
            d.b(this.pdm, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            com.tencent.mm.plugin.report.service.h.mEJ.h(14422, new Object[]{Integer.valueOf(3)});
        }
    }
}
