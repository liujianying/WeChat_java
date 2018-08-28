package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b;

class h$5 implements OnMenuItemClickListener {
    final /* synthetic */ String gdf;
    final /* synthetic */ h jKm;

    h$5(h hVar, String str) {
        this.jKm = hVar;
        this.gdf = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        try {
            s.a(h.b(this.jKm), this.gdf, b.cIi().getCookie(this.gdf), f.zZ());
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewMenuListHelper", "save to sdcard failed : %s", new Object[]{e.getMessage()});
        }
        return true;
    }
}
