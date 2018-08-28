package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.d;

class ExdeviceProfileUI$6 implements d {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$6(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final boolean aCh() {
        if (ExdeviceProfileUI.z(this.iEx).getFirstVisiblePosition() == 0) {
            View childAt = ExdeviceProfileUI.z(this.iEx).getChildAt(ExdeviceProfileUI.z(this.iEx).getFirstVisiblePosition());
            if (childAt != null && childAt.getTop() >= 0) {
                return true;
            }
        }
        return false;
    }
}
