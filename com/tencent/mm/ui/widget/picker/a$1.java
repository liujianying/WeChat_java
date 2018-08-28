package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ a uLf;

    a$1(a aVar) {
        this.uLf = aVar;
    }

    public final void onClick(View view) {
        a.a(this.uLf, true, a.a(this.uLf).getYear(), a.a(this.uLf).getMonth(), a.a(this.uLf).getDayOfMonth());
        this.uLf.hide();
    }
}
