package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.bg.d;

class g$54 implements Runnable {
    final /* synthetic */ String jjh;
    final /* synthetic */ g qiK;
    final /* synthetic */ String qjt;
    final /* synthetic */ boolean qju;
    final /* synthetic */ int qjv;

    g$54(g gVar, String str, String str2, boolean z, int i) {
        this.qiK = gVar;
        this.jjh = str;
        this.qjt = str2;
        this.qju = z;
        this.qjv = i;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_ssid", this.jjh);
        intent.putExtra("free_wifi_source", 3);
        intent.putExtra("free_wifi_passowrd", this.qjt);
        intent.putExtra("free_wifi_hide_ssid", this.qju);
        intent.putExtra("free_wifi_encrypt_type", this.qjv);
        intent.addFlags(67108864);
        d.b(g.j(this.qiK), "freewifi", ".ui.FreeWifiEntryUI", intent);
    }
}
