package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.ui.i.a;

class i$a$1 implements OnClickListener {
    final /* synthetic */ a kyX;

    i$a$1(a aVar) {
        this.kyX = aVar;
    }

    public final void onClick(View view) {
        if (a.a(this.kyX) != null) {
            a.a(this.kyX).onClick(view);
        }
    }
}
