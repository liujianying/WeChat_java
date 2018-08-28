package com.tencent.mm.plugin.offline;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.offline.h.1;
import com.tencent.mm.ui.MMActivity;

class h$1$3 implements OnClickListener {
    final /* synthetic */ MMActivity gdk;
    final /* synthetic */ 1 lJc;

    h$1$3(1 1, MMActivity mMActivity) {
        this.lJc = 1;
        this.gdk = mMActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lJc.lJb.a(this.gdk, 0, h.n(this.lJc.lJb));
    }
}
