package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.ui.base.n.b;

class i$2 implements b {
    final /* synthetic */ i jKv;

    i$2(i iVar) {
        this.jKv = iVar;
    }

    public final void a(TextView textView, MenuItem menuItem) {
        CharSequence charSequence = menuItem.getTitle();
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
