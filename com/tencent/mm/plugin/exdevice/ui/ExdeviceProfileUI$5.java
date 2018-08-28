package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.c;

class ExdeviceProfileUI$5 implements c {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$5(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final boolean aCi() {
        View childAt = ExdeviceProfileUI.z(this.iEx).getChildAt(ExdeviceProfileUI.z(this.iEx).getChildCount() - 1);
        int count = ExdeviceProfileUI.z(this.iEx).getAdapter().getCount();
        if (count <= 0 || childAt == null || childAt.getBottom() > ExdeviceProfileUI.z(this.iEx).getHeight() || ExdeviceProfileUI.z(this.iEx).getLastVisiblePosition() < count - 1) {
            return false;
        }
        return true;
    }
}
