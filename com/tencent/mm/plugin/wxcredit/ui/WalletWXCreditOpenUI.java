package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletWXCreditOpenUI extends WalletBaseUI {
    private Button eWk;
    private Bankcard pdJ;

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.wallet_wxcredit_open_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pdJ = (Bankcard) this.sy.getParcelable("key_bankcard");
        initView();
    }

    protected final void initView() {
        setMMTitle(i.wallet_wxcredit_open_title);
        ((CheckBox) findViewById(f.agree_wx_cb)).setOnCheckedChangeListener(new 1(this));
        findViewById(f.agree_btn).setOnClickListener(new 2(this));
        this.eWk = (Button) findViewById(f.next_btn);
        this.eWk.setOnClickListener(new 3(this));
    }
}
