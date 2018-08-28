package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.x;

class c$5 implements OnClickListener {
    final /* synthetic */ c lLe;

    c$5(c cVar) {
        this.lLe = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        a.A(this.lLe.mActivity);
        x.i("MicroMsg.OfflineLogicMgr", "doFreezeOffline");
    }
}
