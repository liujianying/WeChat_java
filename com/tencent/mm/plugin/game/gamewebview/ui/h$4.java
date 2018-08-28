package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.xweb.b;

class h$4 implements OnMenuItemClickListener {
    final /* synthetic */ String gdf;
    final /* synthetic */ h jKm;

    h$4(h hVar, String str) {
        this.jKm = hVar;
        this.gdf = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        s.a(h.b(this.jKm), this.gdf, b.cIi().getCookie(this.gdf), f.zZ(), new 1(this));
        return true;
    }
}
