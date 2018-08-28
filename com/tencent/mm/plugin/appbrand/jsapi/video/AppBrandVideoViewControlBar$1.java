package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.view.View.OnClickListener;

class AppBrandVideoViewControlBar$1 implements OnClickListener {
    final /* synthetic */ AppBrandVideoViewControlBar$a gbb;
    final /* synthetic */ AppBrandVideoViewControlBar gbc;

    AppBrandVideoViewControlBar$1(AppBrandVideoViewControlBar appBrandVideoViewControlBar, AppBrandVideoViewControlBar$a appBrandVideoViewControlBar$a) {
        this.gbc = appBrandVideoViewControlBar;
        this.gbb = appBrandVideoViewControlBar$a;
    }

    public final void onClick(View view) {
        AppBrandVideoViewControlBar.a(this.gbc);
        if (this.gbb != null) {
            this.gbb.cW(AppBrandVideoViewControlBar.b(this.gbc));
        }
    }
}
