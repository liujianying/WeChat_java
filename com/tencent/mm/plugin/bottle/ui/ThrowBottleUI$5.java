package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class ThrowBottleUI$5 implements a {
    final /* synthetic */ ThrowBottleUI hnD;

    ThrowBottleUI$5(ThrowBottleUI throwBottleUI) {
        this.hnD = throwBottleUI;
    }

    public final boolean vD() {
        int i = 0;
        if (ThrowBottleUI.r(this.hnD) == null) {
            x.w("MM.Bottle.ThrowBottleUI", "bottle recder is null");
            return false;
        }
        int maxAmplitude = ThrowBottleUI.r(this.hnD).getMaxAmplitude();
        while (i < ThrowBottleUI.auI().length) {
            if (maxAmplitude >= ThrowBottleUI.auJ()[i] && maxAmplitude < ThrowBottleUI.auJ()[i + 1]) {
                ThrowBottleUI.s(this.hnD).setBackgroundDrawable(com.tencent.mm.bp.a.f(ThrowBottleUI.h(this.hnD), ThrowBottleUI.auI()[i]));
                break;
            }
            i++;
        }
        return true;
    }
}
