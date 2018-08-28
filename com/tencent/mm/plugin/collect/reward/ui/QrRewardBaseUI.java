package com.tencent.mm.plugin.collect.reward.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class QrRewardBaseUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cqh();
        setBackBtn(new 1(this), a$h.actionbar_icon_dark_back);
    }
}
