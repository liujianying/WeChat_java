package com.tencent.mm.plugin.bottle.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ThrowBottleUI$6 implements a {
    int count = 0;
    final /* synthetic */ ThrowBottleUI hnD;

    ThrowBottleUI$6(ThrowBottleUI throwBottleUI) {
        this.hnD = throwBottleUI;
    }

    public final boolean vD() {
        if (ThrowBottleUI.t(this.hnD) == -1) {
            ThrowBottleUI.a(this.hnD, bi.VG());
        }
        if (this.count % 3 == 2) {
            ThrowBottleUI.u(this.hnD).setWidth(ThrowBottleUI.u(this.hnD).getWidth() + 1);
        }
        this.count++;
        this.count %= 3;
        long bI = bi.bI(ThrowBottleUI.t(this.hnD));
        if (bI >= 50000 && bI <= 60000) {
            int i;
            if (ThrowBottleUI.v(this.hnD) == null) {
                i = (int) ((60000 - bI) / 1000);
                ThrowBottleUI.a(this.hnD, Toast.makeText(ThrowBottleUI.h(this.hnD), ThrowBottleUI.h(this.hnD).getResources().getQuantityString(R.j.chatting_rcd_time_limit, i, new Object[]{Integer.valueOf(i)}), 0));
            } else {
                i = (int) ((60000 - bI) / 1000);
                ThrowBottleUI.v(this.hnD).setText(ThrowBottleUI.h(this.hnD).getResources().getQuantityString(R.j.chatting_rcd_time_limit, i, new Object[]{Integer.valueOf(i)}));
            }
            ThrowBottleUI.v(this.hnD).show();
        }
        if (bI < 60000) {
            return true;
        }
        x.v("MM.Bottle.ThrowBottleUI", "bottle record stop on countdown");
        ThrowBottleUI.w(this.hnD);
        this.hnD.auH();
        ThrowBottleUI.x(this.hnD);
        as.I(ThrowBottleUI.h(this.hnD), R.l.time_limit);
        return false;
    }
}
