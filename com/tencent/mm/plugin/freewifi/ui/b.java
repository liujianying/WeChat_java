package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bi;

public final class b {
    Activity activity;
    String bIQ;
    int bVU;
    Intent intent;

    public b(Activity activity, String str, int i) {
        if (activity == null || bi.oW(str)) {
            throw new IllegalArgumentException("acitvity or apKey cannot be null.");
        }
        this.activity = activity;
        this.intent = activity.getIntent();
        this.bIQ = str;
        this.bVU = i;
    }

    final void Ci(String str) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.setClass(this.activity, FreeWifiErrorUI.class);
        this.activity.finish();
        this.activity.startActivity(intent);
    }
}
