package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class g$2 implements OnClickListener {
    final /* synthetic */ a qIz;

    g$2(a aVar) {
        this.qIz = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.qIz != null) {
            this.qIz.a(false, null, 0);
        }
    }
}
