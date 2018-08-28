package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class HoneyPayCardManagerUI$4 implements OnClickListener {
    final /* synthetic */ HoneyPayCardManagerUI kkT;

    HoneyPayCardManagerUI$4(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        this.kkT = honeyPayCardManagerUI;
    }

    public final void onClick(View view) {
        x.d(this.kkT.TAG, "click pay way");
        HoneyPayCardManagerUI.f(this.kkT);
    }
}
