package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.R;
import com.tencent.mm.ac.m;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.plugin.bottle.ui.PickBottleUI.1;
import com.tencent.mm.sdk.platformtools.x;

class PickBottleUI$1$1 implements a {
    final /* synthetic */ 1 hmq;

    PickBottleUI$1$1(1 1) {
        this.hmq = 1;
    }

    public final void ci(int i, int i2) {
        if (PickBottleUI.a(this.hmq.hmp) != null && PickBottleUI.b(this.hmq.hmp) != null) {
            PickBottleUI.a(this.hmq.hmp).stop();
            if (i2 == -2002) {
                PickBottleUI.a(this.hmq.hmp, null);
                PickBottleUI.c(this.hmq.hmp).nm(0);
                PickBottleUI.c(this.hmq.hmp).nl(R.l.bottle_banby_expose);
            }
            if (PickBottleUI.d(this.hmq.hmp) == null) {
                return;
            }
            if (i == 0 && i2 == 0 && PickBottleUI.d(this.hmq.hmp).hjQ != -10001) {
                if (19990 == PickBottleUI.d(this.hmq.hmp).hjQ) {
                    m.d(PickBottleUI.d(this.hmq.hmp).hkb, PickBottleUI.d(this.hmq.hmp).iconUrl, R.g.nosdcard_headimg);
                }
                x.i("PickBottle", "bottleInfo:" + PickBottleUI.d(this.hmq.hmp).hjV + " real:" + PickBottleUI.d(this.hmq.hmp).hkb);
                PickBottleUI.b(this.hmq.hmp).setBottleTalker(PickBottleUI.d(this.hmq.hmp).hjV);
                PickBottleUI.b(this.hmq.hmp).setRealUserName(PickBottleUI.d(this.hmq.hmp).hkb);
                PickBottleUI.b(this.hmq.hmp).setIconUrl(PickBottleUI.d(this.hmq.hmp).iconUrl);
                PickBottleUI.b(this.hmq.hmp).setDensity(PickBottleUI.g(this.hmq.hmp));
                PickBottleUI.b(this.hmq.hmp).show(PickBottleUI.d(this.hmq.hmp).hjQ);
                PickBottleUI.h(this.hmq.hmp).setVisibility(0);
                PickBottleUI.a(this.hmq.hmp, null);
                return;
            }
            PickBottleUI.b(this.hmq.hmp).setBottleTalker(null);
            PickBottleUI.b(this.hmq.hmp).show(-10001);
            PickBottleUI.f(this.hmq.hmp).postDelayed(PickBottleUI.e(this.hmq.hmp), 2000);
        }
    }
}
