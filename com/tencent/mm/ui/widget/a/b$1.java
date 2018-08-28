package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b uJr;

    b$1(b bVar) {
        this.uJr = bVar;
    }

    public final void onClick(View view) {
        if (this.uJr.isShowing()) {
            this.uJr.cancel();
        }
    }
}
