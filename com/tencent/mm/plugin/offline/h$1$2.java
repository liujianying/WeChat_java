package com.tencent.mm.plugin.offline;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.offline.h.1;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.ui.MMActivity;

class h$1$2 implements OnClickListener {
    final /* synthetic */ MMActivity gdk;
    final /* synthetic */ 1 lJc;
    final /* synthetic */ int lJd;

    h$1$2(1 1, MMActivity mMActivity, int i) {
        this.lJc = 1;
        this.gdk = mMActivity;
        this.lJd = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.aa(this.gdk, this.lJd);
        this.lJc.lJb.a(this.gdk, 0, h.m(this.lJc.lJb));
    }
}
