package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.n.b;

class am$2 implements b {
    final /* synthetic */ Context val$context;

    am$2(Context context) {
        this.val$context = context;
    }

    public final void a(TextView textView, MenuItem menuItem) {
        if (textView != null) {
            au.HU();
            ab Yg = c.FR().Yg(menuItem.getTitle());
            if (Yg == null || ((int) Yg.dhP) <= 0) {
                textView.setText(menuItem.getTitle());
            } else {
                textView.setText(j.a(this.val$context, Yg.BK(), textView.getTextSize()));
            }
        }
    }
}
