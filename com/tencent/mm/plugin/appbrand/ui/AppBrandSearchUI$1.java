package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class AppBrandSearchUI$1 implements OnClickListener {
    final /* synthetic */ AppBrandSearchUI gvD;

    AppBrandSearchUI$1(AppBrandSearchUI appBrandSearchUI) {
        this.gvD = appBrandSearchUI;
    }

    public final void onClick(View view) {
        if (!TextUtils.isEmpty(AppBrandSearchUI.a(this.gvD))) {
            Intent intent = new Intent();
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", AppBrandSearchUI.a(this.gvD));
            intent.putExtra("geta8key_scene", 41);
            intent.putExtra("show_long_click_popup_menu", false);
            d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
