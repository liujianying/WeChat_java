package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bi;

class BindLinkedInUI$6 implements OnClickListener {
    final /* synthetic */ BindLinkedInUI eFM;

    BindLinkedInUI$6(BindLinkedInUI bindLinkedInUI) {
        this.eFM = bindLinkedInUI;
    }

    public final void onClick(View view) {
        String str = (String) g.Ei().DT().get(286723, null);
        if (!bi.oW(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("geta8key_username", q.GF());
            d.b(this.eFM, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }
}
