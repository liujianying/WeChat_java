package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavoriteVoiceDetailUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteVoiceDetailUI jdS;

    FavoriteVoiceDetailUI$1(FavoriteVoiceDetailUI favoriteVoiceDetailUI) {
        this.jdS = favoriteVoiceDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jdS.finish();
        return true;
    }
}
