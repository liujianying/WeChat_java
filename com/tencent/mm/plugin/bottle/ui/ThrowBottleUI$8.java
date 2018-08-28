package com.tencent.mm.plugin.bottle.ui;

import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.ag;

class ThrowBottleUI$8 extends ag {
    final /* synthetic */ ThrowBottleUI hnD;

    ThrowBottleUI$8(ThrowBottleUI throwBottleUI) {
        this.hnD = throwBottleUI;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        ThrowBottleUI.f(this.hnD).setBackgroundDrawable(a.f(ThrowBottleUI.h(this.hnD), R.g.record_shape_normal));
        ThrowBottleUI.f(this.hnD).setEnabled(true);
    }
}
