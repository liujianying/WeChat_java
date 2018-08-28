package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

class FavoriteSightDetailUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteSightDetailUI jdp;

    FavoriteSightDetailUI$4(FavoriteSightDetailUI favoriteSightDetailUI) {
        this.jdp = favoriteSightDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.jdp.mController.tml, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new 2(this);
        dVar.bXO();
        return true;
    }
}
