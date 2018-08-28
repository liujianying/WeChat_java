package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;

class Updater$1 implements OnCancelListener {
    final /* synthetic */ Updater sEt;
    final /* synthetic */ OnCancelListener sEu;

    Updater$1(Updater updater, OnCancelListener onCancelListener) {
        this.sEt = updater;
        this.sEu = onCancelListener;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.getNotification().cancel(99);
        h.mEJ.a(405, 47, 1, true);
        Updater.CU(2);
        this.sEt.onStop();
        if (!Updater.a(this.sEt) && this.sEu != null) {
            this.sEu.onCancel(dialogInterface);
        }
    }
}
