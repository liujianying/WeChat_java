package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.ad;

class LuckyMoneyReceiveUI$6 implements OnClickListener {
    final /* synthetic */ ad kWl;
    final /* synthetic */ LuckyMoneyReceiveUI kXr;

    LuckyMoneyReceiveUI$6(LuckyMoneyReceiveUI luckyMoneyReceiveUI, ad adVar) {
        this.kXr = luckyMoneyReceiveUI;
        this.kWl = adVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        if (this.kWl.kMP != null) {
            intent.putExtra("key_realname_guide_helper", this.kWl.kMP);
        }
        intent.setClass(this.kXr.mController.tml, LuckyMoneyDetailUI.class);
        intent.putExtra("key_native_url", this.kWl.ceR);
        intent.putExtra("key_sendid", this.kWl.kLZ);
        this.kXr.startActivity(intent);
        this.kXr.finish();
    }
}
