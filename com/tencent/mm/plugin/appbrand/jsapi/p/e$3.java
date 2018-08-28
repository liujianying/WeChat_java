package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b;

class e$3 implements OnMenuItemClickListener {
    final /* synthetic */ e gdb;
    final /* synthetic */ String gdf;

    e$3(e eVar, String str) {
        this.gdb = eVar;
        this.gdf = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        try {
            s.a(e.f(this.gdb), this.gdf, b.cIi().getCookie(this.gdf), e.h(this.gdb).isSDCardAvailable(), new 1(this));
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
        }
        return true;
    }
}
