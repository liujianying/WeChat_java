package com.tencent.mm.ui.widget.b;

import android.view.View;
import android.view.View.OnClickListener;

class a$4 implements OnClickListener {
    final /* synthetic */ int hW;
    final /* synthetic */ a uKZ;

    a$4(a aVar, int i) {
        this.uKZ = aVar;
        this.hW = i;
    }

    public final void onClick(View view) {
        if (a.b(this.uKZ) != null) {
            a.b(this.uKZ).onMMMenuItemSelected(a.a(this.uKZ).getItem(this.hW), this.hW);
        }
        a.d(this.uKZ).dismiss();
    }
}
