package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b;

class e$4 implements OnMenuItemClickListener {
    final /* synthetic */ e gdb;
    final /* synthetic */ String gdf;

    e$4(e eVar, String str) {
        this.gdb = eVar;
        this.gdf = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = e.h(this.gdb).isSDCardAvailable();
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        try {
            s.a(e.f(this.gdb), this.gdf, b.cIi().getCookie(this.gdf), isSDCardAvailable);
        } catch (Exception e2) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "save to sdcard failed : %s", new Object[]{e2.getMessage()});
        }
        return true;
    }
}
