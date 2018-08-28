package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class HoneyPayBaseUI extends WalletBaseUI {
    protected final String TAG = ("MicroMsg." + getClass().getSimpleName());
    protected int kjV = c.white;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aWd();
        setBackBtn(new 1(this));
    }

    protected void aWd() {
        lF(getResources().getColor(this.kjV));
        cqh();
    }
}
