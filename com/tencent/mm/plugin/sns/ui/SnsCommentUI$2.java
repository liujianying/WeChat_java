package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.k.b;
import com.tencent.mm.ui.tools.a.c;

class SnsCommentUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SnsCommentUI nVX;

    SnsCommentUI$2(SnsCommentUI snsCommentUI) {
        this.nVX = snsCommentUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        int i;
        if (SnsCommentUI.a(this.nVX) == 0) {
            b.Aw();
        }
        if (SnsCommentUI.a(this.nVX) == 2) {
            i = 200;
        } else {
            i = b.Av();
        }
        c Gi = c.d(SnsCommentUI.b(this.nVX)).Gi(i);
        Gi.uCR = true;
        Gi.a(new 1(this));
        return false;
    }
}
