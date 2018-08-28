package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.readerapp.b.a;

class ReaderAppIntroUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ReaderAppIntroUI mnD;

    ReaderAppIntroUI$2(ReaderAppIntroUI readerAppIntroUI) {
        this.mnD = readerAppIntroUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        a.ezn.d(new Intent().putExtra("Contact_User", bi.he(ReaderAppIntroUI.a(this.mnD))), this.mnD);
        this.mnD.finish();
        return true;
    }
}
