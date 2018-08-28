package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class ExdeviceBindDeviceGuideUI$2 implements OnClickListener {
    final /* synthetic */ ExdeviceBindDeviceGuideUI iAN;

    ExdeviceBindDeviceGuideUI$2(ExdeviceBindDeviceGuideUI exdeviceBindDeviceGuideUI) {
        this.iAN = exdeviceBindDeviceGuideUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.a(this.iAN));
        intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.b(this.iAN));
        intent.putExtra("device_id", ExdeviceBindDeviceGuideUI.c(this.iAN));
        intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.d(this.iAN));
        intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.e(this.iAN));
        intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.f(this.iAN));
        intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.g(this.iAN));
        intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.h(this.iAN));
        intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.i(this.iAN));
        intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.j(this.iAN));
        intent.putExtra("device_ble_simple_proto", ExdeviceBindDeviceGuideUI.k(this.iAN));
        intent.putExtra("encryptKey", ExdeviceBindDeviceGuideUI.l(this.iAN));
        intent.putExtra("jumpToBindDevice", true);
        if (ExdeviceBindDeviceGuideUI.m(this.iAN) && !ExdeviceBindDeviceGuideUI.n(this.iAN)) {
            d.b(this.iAN.mController.tml, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
        } else if (ExdeviceBindDeviceGuideUI.n(this.iAN) && !ExdeviceBindDeviceGuideUI.m(this.iAN)) {
            intent.putExtra("exdevice_airkiss_open_type", 2);
            d.b(this.iAN.mController.tml, "exdevice", ".ui.ExdeviceConnectWifiUI", intent);
        }
    }
}
