package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

class b$9 implements OnClickListener {
    final /* synthetic */ b olf;

    b$9(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        h.a(this.olf.activity, j.sns_timeline_ui_confirm_del, j.app_tip, j.app_delete, j.app_cancel, new 1(this, view), null);
    }
}
