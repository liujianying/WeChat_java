package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMFlipper.a;

class SelectScanModePanel$1 implements a {
    final /* synthetic */ SelectScanModePanel mMm;

    SelectScanModePanel$1(SelectScanModePanel selectScanModePanel) {
        this.mMm = selectScanModePanel;
    }

    public final void dp(int i, int i2) {
        x.v("MicroMsg.scanner.SelectScanModePanel", "onMeasure width:" + i + " height:" + i2 + " isMeasured:" + SelectScanModePanel.a(this.mMm));
        if (!SelectScanModePanel.a(this.mMm) && i2 != 0 && i != 0) {
            SelectScanModePanel.b(this.mMm);
            SelectScanModePanel.a(this.mMm, i2);
            SelectScanModePanel.b(this.mMm, i);
            SelectScanModePanel.c(this.mMm);
        }
    }
}
