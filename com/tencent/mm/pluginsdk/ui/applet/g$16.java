package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.o;

class g$16 implements OnClickListener {
    final /* synthetic */ o qIB;
    final /* synthetic */ a qIz;
    final /* synthetic */ View val$view;

    g$16(a aVar, View view, o oVar) {
        this.qIz = aVar;
        this.val$view = view;
        this.qIB = oVar;
    }

    public final void onClick(View view) {
        if (this.qIz != null) {
            this.qIz.a(true, g.df(this.val$view), g.dg(this.val$view));
        }
        this.qIB.dismiss();
        this.qIB.setFocusable(false);
        this.qIB.setTouchable(false);
    }
}
