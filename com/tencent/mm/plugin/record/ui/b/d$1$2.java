package com.tencent.mm.plugin.record.ui.b;

import android.content.ClipboardManager;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.ui.b.d.1;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

class d$1$2 implements d {
    final /* synthetic */ TextView hNx;
    final /* synthetic */ 1 mtJ;

    d$1$2(1 1, TextView textView) {
        this.mtJ = 1;
        this.hNx = textView;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (i == 0) {
            ((ClipboardManager) this.mtJ.mtI.context.getSystemService("clipboard")).setText(this.hNx.getText());
            h.bz(this.mtJ.mtI.context, this.mtJ.mtI.context.getString(R.l.app_copy_ok));
        }
    }
}
