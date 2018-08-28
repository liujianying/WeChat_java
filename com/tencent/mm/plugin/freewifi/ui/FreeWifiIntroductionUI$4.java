package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;

class FreeWifiIntroductionUI$4 implements OnClickListener {
    final /* synthetic */ FreeWifiIntroductionUI jnu;

    FreeWifiIntroductionUI$4(FreeWifiIntroductionUI freeWifiIntroductionUI) {
        this.jnu = freeWifiIntroductionUI;
    }

    public final void onClick(View view) {
        String string;
        if (FreeWifiIntroductionUI.b(this.jnu) == 3) {
            string = this.jnu.getString(R.l.mig_free_wifi_service_term_doc);
        } else {
            string = this.jnu.getString(R.l.free_wifi_service_term_doc);
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.jnu, "webview", ".ui.tools.WebViewUI", intent);
    }
}
