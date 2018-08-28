package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;

class AAQueryListUI$7 implements a$a {
    final /* synthetic */ AAQueryListUI eCd;

    AAQueryListUI$7(AAQueryListUI aAQueryListUI) {
        this.eCd = aAQueryListUI;
    }

    public final void We() {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", AAQueryListUI.m(this.eCd));
        d.b(this.eCd, "webview", ".ui.tools.WebViewUI", intent);
    }
}
