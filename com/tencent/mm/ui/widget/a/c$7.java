package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.view.View.OnClickListener;

class c$7 implements OnClickListener {
    final /* synthetic */ c uJJ;
    final /* synthetic */ a uJO;

    c$7(c cVar, a aVar) {
        this.uJJ = cVar;
        this.uJO = aVar;
    }

    public final void onClick(View view) {
        if (this.uJO.uJd != null) {
            this.uJO.uJd.onClick(this.uJJ, -2);
        }
        this.uJJ.dismiss();
    }
}
