package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.o;

class g$6 implements OnClickListener {
    final /* synthetic */ o qIB;
    final /* synthetic */ q$a qIz;

    g$6(q$a q_a, o oVar) {
        this.qIz = q_a;
        this.qIB = oVar;
    }

    public final void onClick(View view) {
        if (this.qIz != null) {
            this.qIz.a(false, null, 0);
        }
        this.qIB.dismiss();
        this.qIB.setFocusable(false);
        this.qIB.setTouchable(false);
    }
}
