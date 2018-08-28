package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;

class FreeWifiActivateStateUI$6 implements OnClickListener {
    final /* synthetic */ FreeWifiActivateStateUI jmf;

    FreeWifiActivateStateUI$6(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        this.jmf = freeWifiActivateStateUI;
    }

    public final void onClick(View view) {
        String string = this.jmf.getString(R.l.free_wifi_faq_doc);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.jmf.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
