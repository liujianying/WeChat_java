package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;

class ContactMoreInfoUI$2 implements OnClickListener {
    final /* synthetic */ ContactMoreInfoUI lVo;

    ContactMoreInfoUI$2(ContactMoreInfoUI contactMoreInfoUI) {
        this.lVo = contactMoreInfoUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.lVo.lVn);
        intent.putExtra("geta8key_username", q.GF());
        d.b(this.lVo, "webview", ".ui.tools.WebViewUI", intent);
    }
}
