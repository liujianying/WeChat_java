package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;

class FavoriteFileDetailUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteFileDetailUI jcx;

    FavoriteFileDetailUI$8(FavoriteFileDetailUI favoriteFileDetailUI) {
        this.jcx = favoriteFileDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        m.a(a.iWn, FavoriteFileDetailUI.b(this.jcx));
        this.jcx.finish();
        return true;
    }
}
