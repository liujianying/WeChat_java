package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.view.View.OnClickListener;

class c$8 implements OnClickListener {
    final /* synthetic */ c uJJ;
    final /* synthetic */ a uJO;

    c$8(c cVar, a aVar) {
        this.uJJ = cVar;
        this.uJO = aVar;
    }

    public final void onClick(View view) {
        if (this.uJO.uJe != null) {
            this.uJO.uJe.onClick(this.uJJ, -3);
        }
        this.uJJ.dismiss();
    }
}
