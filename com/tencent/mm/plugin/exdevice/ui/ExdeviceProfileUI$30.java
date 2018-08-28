package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class ExdeviceProfileUI$30 implements c {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$30(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final void a(l lVar) {
        if (ExdeviceProfileUI.x(this.iEx)) {
            lVar.e(1, this.iEx.getString(R.l.exdevice_profile_already_like_cover));
        } else {
            lVar.e(4, this.iEx.getString(R.l.exdevice_profile_like_cover));
        }
    }
}
