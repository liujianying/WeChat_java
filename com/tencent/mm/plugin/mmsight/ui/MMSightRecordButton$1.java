package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a;
import com.tencent.mm.sdk.platformtools.x;

class MMSightRecordButton$1 implements a {
    final /* synthetic */ a loI;
    final /* synthetic */ MMSightRecordButton loJ;

    MMSightRecordButton$1(MMSightRecordButton mMSightRecordButton, a aVar) {
        this.loJ = mMSightRecordButton;
        this.loI = aVar;
    }

    public final void bfd() {
        x.l("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
        this.loJ.bfe();
        MMSightRecordButton.a(this.loJ, new 1(this));
    }
}
