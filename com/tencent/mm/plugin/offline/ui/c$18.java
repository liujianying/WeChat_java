package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.x;

class c$18 implements OnClickListener {
    final /* synthetic */ c lLe;

    c$18(c cVar) {
        this.lLe = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.aa(this.lLe.mActivity, 0);
        x.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
    }
}
