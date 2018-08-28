package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

class FavoriteVoiceDetailUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteVoiceDetailUI jdS;

    FavoriteVoiceDetailUI$2(FavoriteVoiceDetailUI favoriteVoiceDetailUI) {
        this.jdS = favoriteVoiceDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.jdS.mController.tml, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new 2(this);
        dVar.bXO();
        return true;
    }
}
