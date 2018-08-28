package com.tencent.mm.ui.widget.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class e$2 implements OnClickListener {
    final /* synthetic */ e$b uKs;

    e$2(e$b e_b) {
        this.uKs = e_b;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.uKs != null) {
            this.uKs.b(false, null);
        }
    }
}
