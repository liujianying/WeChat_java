package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.ui.widget.a.c$a;
import com.tencent.mm.wallet_core.c;

class WalletVerifyCodeUI$5 implements OnClickListener {
    final /* synthetic */ Bankcard oZt;
    final /* synthetic */ WalletVerifyCodeUI pyT;

    WalletVerifyCodeUI$5(WalletVerifyCodeUI walletVerifyCodeUI, Bankcard bankcard) {
        this.pyT = walletVerifyCodeUI;
        this.oZt = bankcard;
    }

    public final void onClick(View view) {
        c cDK = this.pyT.cDK();
        if (!WalletVerifyCodeUI.a(this.pyT) || (cDK instanceof b)) {
            this.pyT.bQE();
            return;
        }
        int i;
        if (this.oZt == null) {
            i = 0;
        } else if (this.oZt.bOs()) {
            i = 1;
        } else if (this.oZt.bOt()) {
            i = 3;
        } else {
            i = 2;
        }
        c$a c_a = new c$a(this.pyT.mController.tml);
        c_a.Gq(a$i.wallet_verify_code_comfirm_title);
        c_a.abu(this.pyT.getString(a$i.wallet_verify_code_comfirm_text, new Object[]{this.pyT.bQD()}));
        c_a.mF(true);
        c_a.Gt(a$i.wallet_verify_code_comfirm_ok_btn);
        c_a.Gu(a$i.wallet_verify_code_comfirm_cancel_btn);
        c_a.a(new 1(this, i));
        c_a.b(new 2(this, i));
        c_a.anj().show();
        h.mEJ.h(15443, new Object[]{Integer.valueOf(1)});
        WalletVerifyCodeUI.b(this.pyT);
    }
}
