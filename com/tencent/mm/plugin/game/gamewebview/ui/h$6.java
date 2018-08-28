package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.xweb.b;

class h$6 implements OnMenuItemClickListener {
    final /* synthetic */ String gdf;
    final /* synthetic */ h jKm;

    h$6(h hVar, String str) {
        this.jKm = hVar;
        this.gdf = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String replaceAll = this.gdf.replaceAll("tp=webp", "");
        s.a(h.b(this.jKm), replaceAll, b.cIi().getCookie(replaceAll), f.zZ(), new 1(this));
        return true;
    }
}
