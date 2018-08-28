package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class aj$4 implements OnClickListener {
    final /* synthetic */ aj tSJ;

    aj$4(aj ajVar) {
        this.tSJ = ajVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(10997, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        dialogInterface.dismiss();
    }
}
