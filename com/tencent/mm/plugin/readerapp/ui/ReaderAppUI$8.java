package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.readerapp.b.a;

class ReaderAppUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ ReaderAppUI mnQ;

    ReaderAppUI$8(ReaderAppUI readerAppUI) {
        this.mnQ = readerAppUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        a.ezn.d(new Intent().putExtra("Contact_User", ReaderAppUI.f(this.mnQ)), this.mnQ);
        return true;
    }
}
