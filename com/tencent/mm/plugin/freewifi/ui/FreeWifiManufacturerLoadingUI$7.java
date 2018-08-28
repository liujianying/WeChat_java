package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.ad;

class FreeWifiManufacturerLoadingUI$7 implements Runnable {
    final /* synthetic */ FreeWifiManufacturerLoadingUI jnE;
    final /* synthetic */ String jnI;

    FreeWifiManufacturerLoadingUI$7(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, String str) {
        this.jnE = freeWifiManufacturerLoadingUI;
        this.jnI = str;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.jnI);
        intent.putExtra("show_bottom", false);
        intent.putExtra("allow_wx_schema_url", true);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("stastic_scene", 7);
        intent.putExtra("neverBlockLocalRequest", true);
        if (FreeWifiManufacturerLoadingUI.g(this.jnE)) {
            d.b(ad.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
