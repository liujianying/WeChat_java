package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.w;

public final class a extends DialogFragment {
    private OnCancelListener aJE = null;
    private Dialog nt = null;

    public static a a(Dialog dialog, OnCancelListener onCancelListener) {
        a aVar = new a();
        Dialog dialog2 = (Dialog) w.j(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        aVar.nt = dialog2;
        if (onCancelListener != null) {
            aVar.aJE = onCancelListener;
        }
        return aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.aJE != null) {
            this.aJE.onCancel(dialogInterface);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        if (this.nt == null) {
            setShowsDialog(false);
        }
        return this.nt;
    }

    public final void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
