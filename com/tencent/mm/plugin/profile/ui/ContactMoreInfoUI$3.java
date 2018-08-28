package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bi;

class ContactMoreInfoUI$3 implements OnClickListener {
    final /* synthetic */ ContactMoreInfoUI lVo;

    ContactMoreInfoUI$3(ContactMoreInfoUI contactMoreInfoUI) {
        this.lVo = contactMoreInfoUI;
    }

    public final void onClick(View view) {
        if (bi.oW(ContactMoreInfoUI.a(this.lVo))) {
            ContactMoreInfoUI.a(this.lVo, ContactMoreInfoUI.b(this.lVo).csX);
        }
        if (!bi.oW(ContactMoreInfoUI.a(this.lVo))) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", ContactMoreInfoUI.a(this.lVo));
            intent.putExtra("geta8key_username", q.GF());
            d.b(this.lVo, "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
