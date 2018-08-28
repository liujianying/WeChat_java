package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsSingleTextViewUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SnsSingleTextViewUI obr;

    SnsSingleTextViewUI$4(SnsSingleTextViewUI snsSingleTextViewUI) {
        this.obr = snsSingleTextViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.obr.finish();
        return true;
    }
}
