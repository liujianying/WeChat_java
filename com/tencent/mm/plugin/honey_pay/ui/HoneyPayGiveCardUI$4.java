package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class HoneyPayGiveCardUI$4 implements OnClickListener {
    final /* synthetic */ HoneyPayGiveCardUI kls;

    HoneyPayGiveCardUI$4(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        this.kls = honeyPayGiveCardUI;
    }

    public final void onClick(View view) {
        x.d(this.kls.TAG, "click give btn");
        if (HoneyPayGiveCardUI.a(this.kls)) {
            this.kls.Wq();
            HoneyPayGiveCardUI.d(this.kls);
            return;
        }
        x.w(this.kls.TAG, "over limit when click");
    }
}
