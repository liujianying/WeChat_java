package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class g$17 implements OnClickListener {
    final /* synthetic */ a qIz;
    final /* synthetic */ View val$view;

    g$17(a aVar, View view) {
        this.qIz = aVar;
        this.val$view = view;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.qIz != null) {
            this.qIz.a(true, g.df(this.val$view), g.dg(this.val$view));
        }
    }
}
