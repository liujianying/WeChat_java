package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.i;
import android.support.v4.app.m;
import com.google.android.gms.common.internal.w;

public final class f extends i {
    private OnCancelListener aJE = null;
    private Dialog nt = null;

    public static f b(Dialog dialog, OnCancelListener onCancelListener) {
        f fVar = new f();
        Dialog dialog2 = (Dialog) w.j(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        fVar.nt = dialog2;
        if (onCancelListener != null) {
            fVar.aJE = onCancelListener;
        }
        return fVar;
    }

    public final void a(m mVar, String str) {
        super.a(mVar, str);
    }

    public final Dialog bg() {
        if (this.nt == null) {
            this.nr = false;
        }
        return this.nt;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.aJE != null) {
            this.aJE.onCancel(dialogInterface);
        }
    }
}
