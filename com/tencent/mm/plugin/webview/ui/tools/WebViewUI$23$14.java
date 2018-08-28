package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.4;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$23$14 implements Runnable {
    final /* synthetic */ 23 pZM;
    final /* synthetic */ String pZP;
    final /* synthetic */ boolean pZU;

    WebViewUI$23$14(23 23, String str, boolean z) {
        this.pZM = 23;
        this.pZP = str;
        this.pZU = z;
    }

    public final void run() {
        if (this.pZM.pZJ.pNV != null) {
            d dVar = this.pZM.pZJ.pNV;
            String str = this.pZP;
            boolean z = this.pZU;
            if (dVar.qhq) {
                x.i("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange: device id = %s, isBound = %s", new Object[]{str, Boolean.valueOf(z)});
                if (bi.oW(str)) {
                    x.e("MicroMsg.JsApiHandler", "parameter error!!!");
                    return;
                }
                Map hashMap = new HashMap();
                hashMap.put("deviceId", str);
                if (z) {
                    hashMap.put(DownloadInfoColumns.STATE, "bind");
                } else {
                    hashMap.put(DownloadInfoColumns.STATE, "unbind");
                }
                ah.A(new 4(dVar, a.a("onWXDeviceBindStateChange", hashMap, dVar.qhs, dVar.qht)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange fail, not ready");
        }
    }
}
