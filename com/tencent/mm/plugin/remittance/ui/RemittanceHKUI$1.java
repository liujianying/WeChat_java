package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class RemittanceHKUI$1 implements OnClickListener {
    final /* synthetic */ RemittanceHKUI mCP;

    RemittanceHKUI$1(RemittanceHKUI remittanceHKUI) {
        this.mCP = remittanceHKUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.RemittanceHKUI", "hy: on click banner");
        if (!bi.oW(RemittanceHKUI.a(this.mCP))) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", RemittanceHKUI.a(this.mCP));
            intent.putExtra("showShare", false);
            d.b(this.mCP.mController.tml, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }
}
