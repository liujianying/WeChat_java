package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.masssend.a.f;

class b$5 implements OnCancelListener {
    final /* synthetic */ b laG;
    final /* synthetic */ f laH;

    b$5(b bVar, f fVar) {
        this.laG = bVar;
        this.laH = fVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.laH);
        if (this.laG.tipDialog != null) {
            this.laG.tipDialog.dismiss();
            this.laG.tipDialog = null;
        }
    }
}
