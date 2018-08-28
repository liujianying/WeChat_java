package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.widget.a.c$a.b;
import com.tencent.mm.y.g.a;

class SelectConversationUI$9 implements b {
    final /* synthetic */ a fZg;
    final /* synthetic */ SelectConversationUI uEC;

    SelectConversationUI$9(SelectConversationUI selectConversationUI, a aVar) {
        this.uEC = selectConversationUI;
        this.fZg = aVar;
    }

    public final void aMV() {
        String B = p.B(this.fZg.url, "message");
        String B2 = p.B(this.fZg.dwn, "message");
        if (ao.isMobile(this.uEC.mController.tml) ? B2 != null && B2.length() > 0 : B == null || B.length() <= 0) {
            B = B2;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", B);
        intent.putExtra("showShare", false);
        d.b(this.uEC.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
