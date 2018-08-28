package com.tencent.mm.ui.widget.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class e$1 implements OnClickListener {
    final /* synthetic */ c qIC;
    final /* synthetic */ e$b uKr;

    e$1(e$b e_b, c cVar) {
        this.uKr = e_b;
        this.qIC = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.uKr != null) {
            this.uKr.b(true, this.qIC.cAJ());
        }
    }
}
