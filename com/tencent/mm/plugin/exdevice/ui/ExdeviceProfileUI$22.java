package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.sport.ui.SportChartView;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class ExdeviceProfileUI$22 implements a {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$22(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final void cf(boolean z) {
        if (ExdeviceProfileUI.F(this.iEx) != null) {
            if (z) {
                ExdeviceProfileUI.G(this.iEx).xT(SportChartView.a.opN);
            } else {
                ExdeviceProfileUI.G(this.iEx).xT(SportChartView.a.opM);
            }
        }
        ExdeviceProfileUI.G(this.iEx).cy(ExdeviceProfileUI.F(this.iEx));
    }
}
