package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditChangeAmountResultUI extends WalletBaseUI {
    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.wallet_wxcredit_change_amount_result_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        ((TextView) findViewById(f.wallet_wxcredit_amount)).setText(e.B(this.sy.getDouble("key_credit_amount")));
        showHomeBtn(false);
        enableBackMenu(false);
        addTextOptionMenu(0, getString(i.app_finish), new 1(this));
    }
}
