package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;

class b$13 implements OnClickListener {
    final /* synthetic */ String dhh;
    final /* synthetic */ PBool unC;
    final /* synthetic */ boolean unF;
    final /* synthetic */ boolean unG;
    final /* synthetic */ Context val$context;

    b$13(PBool pBool, Context context, boolean z, String str, boolean z2) {
        this.unC = pBool;
        this.val$context = context;
        this.unF = z;
        this.dhh = str;
        this.unG = z2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.unC.value = true;
        b.c(this.val$context, this.unF, this.dhh);
        if (this.unG) {
            h.mEJ.h(14553, new Object[]{Integer.valueOf(0), Integer.valueOf(4), this.dhh});
        }
    }
}
