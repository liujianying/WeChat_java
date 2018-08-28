package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

class FavoriteTextDetailUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteTextDetailUI jdz;

    FavoriteTextDetailUI$2(FavoriteTextDetailUI favoriteTextDetailUI) {
        this.jdz = favoriteTextDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.jdz.mController.tml, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new 2(this);
        dVar.bXO();
        return true;
    }
}
