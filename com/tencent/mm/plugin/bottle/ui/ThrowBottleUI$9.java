package com.tencent.mm.plugin.bottle.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.i.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class ThrowBottleUI$9 implements a {
    final /* synthetic */ ThrowBottleUI hnD;

    ThrowBottleUI$9(ThrowBottleUI throwBottleUI) {
        this.hnD = throwBottleUI;
    }

    public final void onError() {
        ThrowBottleUI.r(this.hnD).reset();
        ThrowBottleUI.z(this.hnD).SO();
        ThrowBottleUI.A(this.hnD).SO();
        af.Wq("keep_app_silent");
        ThrowBottleUI.x(this.hnD);
        x.v("MM.Bottle.ThrowBottleUI", "bottle record stop on error");
        Toast.makeText(ThrowBottleUI.h(this.hnD), ThrowBottleUI.h(this.hnD).getString(R.l.chatting_rcd_err), 0).show();
    }
}
