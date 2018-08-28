package com.tencent.mm.plugin.account.security.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class MySafeDeviceListUI$3 extends ag {
    final /* synthetic */ MySafeDeviceListUI eOK;

    MySafeDeviceListUI$3(MySafeDeviceListUI mySafeDeviceListUI) {
        this.eOK = mySafeDeviceListUI;
    }

    public final void handleMessage(Message message) {
        MySafeDeviceListUI.b(this.eOK).notifyDataSetChanged();
        super.handleMessage(message);
    }
}
