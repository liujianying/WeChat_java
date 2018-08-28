package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.y;
import com.tencent.mm.ui.base.h;

class b$3 implements OnClickListener {
    final /* synthetic */ b mgt;
    final /* synthetic */ y mgu;
    final /* synthetic */ LinearLayout mgv;

    b$3(b bVar, y yVar, LinearLayout linearLayout) {
        this.mgt = bVar;
        this.mgu = yVar;
        this.mgv = linearLayout;
    }

    public final void onClick(View view) {
        h.a(this.mgt.mgk, R.l.plugin_qqmail_attachment_delete_confirm, R.l.app_tip, new 1(this), null);
    }
}
