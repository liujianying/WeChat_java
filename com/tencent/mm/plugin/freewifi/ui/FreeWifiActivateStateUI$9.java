package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiActivateStateUI$9 implements Runnable {
    final /* synthetic */ FreeWifiActivateStateUI jmf;
    final /* synthetic */ c jmg;

    FreeWifiActivateStateUI$9(FreeWifiActivateStateUI freeWifiActivateStateUI, c cVar) {
        this.jmf = freeWifiActivateStateUI;
        this.jmg = cVar;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.jmg.field_showUrl + "&lang=" + w.d(this.jmf.getSharedPreferences(ad.chY(), 0)));
        intent.putExtra("show_bottom", false);
        intent.putExtra("stastic_scene", 7);
        d.b(this.jmf, "webview", ".ui.tools.WebViewUI", intent);
        x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "jump to ad page after auth success, url is : %s", new Object[]{intent.getStringExtra("rawUrl")});
        this.jmf.finish();
    }
}
