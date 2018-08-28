package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements OnClickListener {
    final /* synthetic */ c jTV;

    c$2(c cVar) {
        this.jTV = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(14217, new Object[]{this.jTV.jMa.field_appId, Integer.valueOf(6), "", this.jTV.jMa.cmE, Integer.valueOf(2)});
        dialogInterface.dismiss();
        x.i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
    }
}
