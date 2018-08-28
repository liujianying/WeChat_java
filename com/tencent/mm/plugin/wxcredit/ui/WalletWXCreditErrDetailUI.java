package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletWXCreditErrDetailUI extends WalletBaseUI {
    private Bankcard paI;
    private String qxr;
    private TextView qxs;
    private TextView qxt;

    protected final int getLayoutId() {
        return g.wallet_wxcredit_err_detail_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.wallet_bankcard_detail_title);
        initView();
    }

    protected final void initView() {
        this.paI = (Bankcard) this.sy.getParcelable("key_bankcard");
        this.qxr = this.sy.getString("key_repayment_url");
        if (this.paI != null) {
            this.qxs = (TextView) findViewById(f.wallet_bankcard_detail_repayment);
            this.qxs.setOnClickListener(new 1(this));
            this.qxt = (TextView) findViewById(f.wallet_bankcard_detail_unbind);
            this.qxt.setOnClickListener(new 2(this));
            this.qxt.setVisibility(this.sy.getBoolean("key_can_unbind", true) ? 0 : 8);
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }
}
