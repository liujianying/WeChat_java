package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class g$82 implements Runnable {
    final /* synthetic */ String dMs;
    final /* synthetic */ g qiK;
    final /* synthetic */ String qjH;
    final /* synthetic */ String qjI;
    final /* synthetic */ String qjJ;

    g$82(g gVar, String str, String str2, String str3, String str4) {
        this.qiK = gVar;
        this.qjH = str;
        this.qjI = str2;
        this.dMs = str3;
        this.qjJ = str4;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_jsapi_param_type", this.qjH);
        intent.putExtra("free_wifi_ap_key", this.qjI);
        intent.putExtra("free_wifi_jsapi_param_username", this.dMs);
        intent.putExtra("free_wifi_sessionkey", this.qjJ);
        intent.putExtra("free_wifi_source", 4);
        intent.addFlags(67108864);
        if (!(bi.oW(this.qjH) || !this.qjH.equalsIgnoreCase("2") || bi.oW(this.qjI))) {
            Uri parse = Uri.parse(this.qjI);
            String host = parse.getHost();
            String query = parse.getQuery();
            if (!bi.oW(host) && "connectToFreeWifi".equals(host) && !bi.oW(query) && query.startsWith("apKey=")) {
                host = parse.getQueryParameter("apKey");
                x.i("[MicroMsg.FreeWifi.MsgHandler]", "apKey value = %s", new Object[]{host});
                query = parse.getQueryParameter("ticket");
                if (!bi.oW(host) && host.length() < 1024) {
                    intent.putExtra("free_wifi_schema_uri", parse.toString());
                    intent.putExtra("free_wifi_ap_key", host);
                    intent.putExtra("free_wifi_source", 5);
                    intent.putExtra("free_wifi_threeone_startup_type", 4);
                    if (!bi.oW(query)) {
                        intent.putExtra("free_wifi_schema_ticket", query);
                    }
                }
            }
        }
        d.b(g.j(this.qiK), "freewifi", ".ui.FreeWifiEntryUI", intent);
    }
}
