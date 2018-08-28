package com.tencent.mm.plugin.readerapp.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ReaderAppUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ ReaderAppUI mnQ;

    ReaderAppUI$7(ReaderAppUI readerAppUI) {
        this.mnQ = readerAppUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mnQ.finish();
        return true;
    }
}
