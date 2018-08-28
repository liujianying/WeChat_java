package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b mBJ;

    b$1(b bVar) {
        this.mBJ = bVar;
    }

    public final void onClick(View view) {
        if (b.a(this.mBJ) != null) {
            b.a(this.mBJ).onClick(view);
            this.mBJ.dismiss();
        }
    }
}
