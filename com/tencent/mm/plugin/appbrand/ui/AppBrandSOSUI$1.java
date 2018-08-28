package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class AppBrandSOSUI$1 implements OnClickListener {
    final /* synthetic */ AppBrandSOSUI gvC;

    AppBrandSOSUI$1(AppBrandSOSUI appBrandSOSUI) {
        this.gvC = appBrandSOSUI;
    }

    public final void onClick(View view) {
        if (!TextUtils.isEmpty(AppBrandSOSUI.a(this.gvC))) {
            Intent intent = new Intent();
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", AppBrandSOSUI.a(this.gvC));
            intent.putExtra("geta8key_scene", 41);
            intent.putExtra("show_long_click_popup_menu", false);
            d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
