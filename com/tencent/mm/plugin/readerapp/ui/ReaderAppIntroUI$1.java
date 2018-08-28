package com.tencent.mm.plugin.readerapp.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ReaderAppIntroUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ReaderAppIntroUI mnD;

    ReaderAppIntroUI$1(ReaderAppIntroUI readerAppIntroUI) {
        this.mnD = readerAppIntroUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mnD.finish();
        return true;
    }
}
