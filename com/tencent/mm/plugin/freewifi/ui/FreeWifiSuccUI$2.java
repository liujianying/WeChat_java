package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.bi;

class FreeWifiSuccUI$2 implements OnClickListener {
    final /* synthetic */ FreeWifiSuccUI jol;

    FreeWifiSuccUI$2(FreeWifiSuccUI freeWifiSuccUI) {
        this.jol = freeWifiSuccUI;
    }

    public final void onClick(View view) {
        if (!bi.oW(FreeWifiSuccUI.b(this.jol))) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", FreeWifiSuccUI.b(this.jol));
            d.b(this.jol, "profile", ".ui.ContactInfoUI", intent);
        }
    }
}
