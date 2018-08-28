package com.tencent.mm.plugin.luckymoney.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class LuckyMoneyBusiReceiveUI$3 implements OnClickListener {
    final /* synthetic */ LuckyMoneyBusiReceiveUI kUO;

    LuckyMoneyBusiReceiveUI$3(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        this.kUO = luckyMoneyBusiReceiveUI;
    }

    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
        bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
        if (LuckyMoneyBusiReceiveUI.d(this.kUO) == null || !LuckyMoneyBusiReceiveUI.d(this.kUO).a(this.kUO, bundle, null, true)) {
            this.kUO.finish();
        } else {
            LuckyMoneyBusiReceiveUI.e(this.kUO);
        }
    }
}
