package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b;

class e$5 implements OnMenuItemClickListener {
    final /* synthetic */ e gdb;
    final /* synthetic */ String gdf;

    e$5(e eVar, String str) {
        this.gdb = eVar;
        this.gdf = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        try {
            boolean isSDCardAvailable = e.h(this.gdb).isSDCardAvailable();
            String replaceAll = this.gdf.replaceAll("tp=webp", "");
            s.a(e.f(this.gdb), replaceAll, b.cIi().getCookie(replaceAll), isSDCardAvailable, new 1(this));
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
        }
        return true;
    }
}
