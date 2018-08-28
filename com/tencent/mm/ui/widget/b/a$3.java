package com.tencent.mm.ui.widget.b;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class a$3 implements OnItemClickListener {
    final /* synthetic */ a uKZ;

    a$3(a aVar) {
        this.uKZ = aVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (a.b(this.uKZ) != null) {
            a.b(this.uKZ).onMMMenuItemSelected(a.a(this.uKZ).getItem(i), i);
        }
        if (a.c(this.uKZ) != null && a.c(this.uKZ).eZB.isShowing()) {
            a.c(this.uKZ).dismiss();
        }
    }
}
