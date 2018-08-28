package com.tencent.mm.plugin.exdevice.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ExdeviceConnectWifiUI$12 implements OnTouchListener {
    final /* synthetic */ ExdeviceConnectWifiUI iCh;

    ExdeviceConnectWifiUI$12(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.iCh = exdeviceConnectWifiUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        ExdeviceConnectWifiUI.c(this.iCh).clearFocus();
        this.iCh.YC();
        return false;
    }
}
