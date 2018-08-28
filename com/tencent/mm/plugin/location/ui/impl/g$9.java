package com.tencent.mm.plugin.location.ui.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.location.ui.k;

class g$9 implements OnClickListener {
    final /* synthetic */ g kJY;

    g$9(g gVar) {
        this.kJY = gVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.kJY.kJL.gk(false);
        this.kJY.kJM.stop();
        this.kJY.kJM.rP(2);
        k.aZL();
        this.kJY.activity.finish();
    }
}
