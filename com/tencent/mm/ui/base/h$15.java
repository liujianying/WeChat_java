package com.tencent.mm.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import java.lang.ref.WeakReference;

class h$15 implements OnCancelListener {
    final /* synthetic */ WeakReference ttC;

    h$15(WeakReference weakReference) {
        this.ttC = weakReference;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        OnCancelListener onCancelListener = (OnCancelListener) this.ttC.get();
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
        x.b(false, null);
    }
}
