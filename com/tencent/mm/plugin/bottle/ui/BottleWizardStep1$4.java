package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class BottleWizardStep1$4 implements c {
    final /* synthetic */ BottleWizardStep1 hlz;

    BottleWizardStep1$4(BottleWizardStep1 bottleWizardStep1) {
        this.hlz = bottleWizardStep1;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                x.i("MicroMsg.BottleWizardStep1", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(this.hlz.mController.tml, "android.permission.CAMERA", 16, "", "")), bi.cjd(), this.hlz.mController.tml});
                if (a.a(this.hlz.mController.tml, "android.permission.CAMERA", 16, "", "")) {
                    BottleWizardStep1.b(this.hlz);
                    return;
                }
                return;
            case 1:
                l.a(this.hlz, 2, null);
                return;
            default:
                return;
        }
    }
}
