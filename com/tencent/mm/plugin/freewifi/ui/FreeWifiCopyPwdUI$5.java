package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class FreeWifiCopyPwdUI$5 implements OnClickListener {
    final /* synthetic */ FreeWifiCopyPwdUI jmF;
    final /* synthetic */ String jmG;

    FreeWifiCopyPwdUI$5(FreeWifiCopyPwdUI freeWifiCopyPwdUI, String str) {
        this.jmF = freeWifiCopyPwdUI;
        this.jmG = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_show_detail_error", 1);
        intent.putExtra("free_wifi_error_ui_error_msg", this.jmF.getString(R.l.free_wifi_connect_fail_msg));
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", this.jmG);
        intent.setClass(this.jmF, FreeWifiErrorUI.class);
        this.jmF.startActivity(intent);
    }
}
