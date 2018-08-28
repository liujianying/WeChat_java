package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ArtistBrowseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ArtistBrowseUI nLc;

    ArtistBrowseUI$1(ArtistBrowseUI artistBrowseUI) {
        this.nLc = artistBrowseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nLc.nTr.bBY();
        return true;
    }
}
