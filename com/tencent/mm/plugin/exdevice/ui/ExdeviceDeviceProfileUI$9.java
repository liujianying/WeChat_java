package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ExdeviceDeviceProfileUI$9 implements OnClickListener {
    final /* synthetic */ ExdeviceDeviceProfileUI iCP;

    ExdeviceDeviceProfileUI$9(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.iCP = exdeviceDeviceProfileUI;
    }

    public final void onClick(View view) {
        h.a(this.iCP, this.iCP.getString(R.l.exdevice_edit_remark_name_title), ExdeviceDeviceProfileUI.d(this.iCP), "", 50, ExdeviceDeviceProfileUI.e(this.iCP));
    }
}
