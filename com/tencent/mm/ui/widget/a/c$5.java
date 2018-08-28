package com.tencent.mm.ui.widget.a;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;

class c$5 implements OnClickListener {
    final /* synthetic */ c uJJ;
    final /* synthetic */ DialogInterface.OnClickListener uJM;
    final /* synthetic */ boolean uJN;

    c$5(c cVar, DialogInterface.OnClickListener onClickListener, boolean z) {
        this.uJJ = cVar;
        this.uJM = onClickListener;
        this.uJN = z;
    }

    public final void onClick(View view) {
        if (this.uJM != null) {
            this.uJM.onClick(this.uJJ, -2);
        }
        if (this.uJN) {
            this.uJJ.cancel();
        }
    }
}
