package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.ui.applet.q.b;

class g$4 implements OnClickListener {
    final /* synthetic */ b qIA;

    g$4(b bVar) {
        this.qIA = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.qIA != null) {
            this.qIA.gb(false);
        }
    }
}
