package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;

class FreeWifiActivateAuthStateUI$1 implements OnClickListener {
    final /* synthetic */ FreeWifiActivateAuthStateUI jlP;

    FreeWifiActivateAuthStateUI$1(FreeWifiActivateAuthStateUI freeWifiActivateAuthStateUI) {
        this.jlP = freeWifiActivateAuthStateUI;
    }

    public final void onClick(View view) {
        String string = this.jlP.getString(R.l.free_wifi_faq_doc);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.jlP, "webview", ".ui.tools.WebViewUI", intent);
    }
}
