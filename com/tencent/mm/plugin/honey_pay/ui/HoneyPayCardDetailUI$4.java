package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class HoneyPayCardDetailUI$4 implements OnClickListener {
    final /* synthetic */ HoneyPayCardDetailUI kks;

    HoneyPayCardDetailUI$4(HoneyPayCardDetailUI honeyPayCardDetailUI) {
        this.kks = honeyPayCardDetailUI;
    }

    public final void onClick(View view) {
        x.d(this.kks.TAG, "click oper btn: %s", new Object[]{HoneyPayCardDetailUI.b(this.kks).url});
        if (!bi.oW(HoneyPayCardDetailUI.b(this.kks).url)) {
            e.l(this.kks.mController.tml, HoneyPayCardDetailUI.b(this.kks).url, false);
        }
    }
}
