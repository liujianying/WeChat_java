package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class MMSightEditUI$3 implements a {
    final /* synthetic */ MMSightEditUI llg;

    MMSightEditUI$3(MMSightEditUI mMSightEditUI) {
        this.llg = mMSightEditUI;
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.MMSightEditUI", "%d on error what %d extra %d", new Object[]{Integer.valueOf(this.llg.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void iy() {
        if (MMSightEditUI.h(this.llg) != null) {
            MMSightEditUI.h(this.llg).start();
            MMSightEditUI.h(this.llg).setLoop(true);
            MMSightEditUI.h(this.llg).setAlpha(1.0f);
            ah.i(new 1(this), 300);
        }
    }

    public final void wd() {
        MMSightEditUI.h(this.llg).d(0.0d, true);
    }

    public final int ck(int i, int i2) {
        return 0;
    }

    public final void cl(int i, int i2) {
    }
}
