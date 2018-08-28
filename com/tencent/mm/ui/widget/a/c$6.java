package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.view.View.OnClickListener;

class c$6 implements OnClickListener {
    final /* synthetic */ c uJJ;
    final /* synthetic */ a uJO;

    c$6(c cVar, a aVar) {
        this.uJJ = cVar;
        this.uJO = aVar;
    }

    public final void onClick(View view) {
        if (this.uJO.uJc != null) {
            this.uJO.uJc.onClick(this.uJJ, -1);
        }
        this.uJJ.dismiss();
    }
}
