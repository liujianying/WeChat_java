package com.tencent.mm.plugin.wallet.balance.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(3)
public class WalletBalanceFetchPwdInputUI extends WalletBaseUI {
    private String cZH = "";
    private String oZC = "";
    private o oZD;

    public void onCreate(Bundle bundle) {
        int i = 1;
        super.onCreate(bundle);
        ux(4);
        this.cZH = this.sy.getString("key_pwd_cash_title");
        this.oZC = this.sy.getString("key_pwd_cash_money");
        x.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: money : %s, title : %s", new Object[]{bi.oV(this.oZC), bi.oV(this.cZH)});
        if (bi.oW(this.cZH) || bi.oW(this.oZC)) {
            i = 0;
        }
        if (i == 0) {
            h.a(this.mController.tml, i.wallet_order_info_err, 0, new 1(this));
        } else {
            showDialog();
        }
    }

    private void showDialog() {
        if (this.oZD != null && this.oZD.isShowing()) {
            this.oZD.dismiss();
        }
        String str = "";
        if (((Orders) this.sy.getParcelable("key_orders")).mxE > 0.0d) {
            str = getResources().getString(i.wallet_balance_additional_deduction_fee_tips_2, new Object[]{e.e(r0.mxE, r0.lNV)});
        }
        if (this.oZD == null) {
            this.oZD = o.a(this, this.cZH, this.oZC, str, new 2(this), new 3(this), new 4(this));
            return;
        }
        this.oZD.bqn();
        this.oZD.show();
    }

    public final void rj(int i) {
        if (i == 0) {
            finish();
        } else if (i == 1) {
            showDialog();
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
