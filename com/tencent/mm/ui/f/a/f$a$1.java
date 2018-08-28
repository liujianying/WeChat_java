package com.tencent.mm.ui.f.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.ui.f.a.f.a;

class f$a$1 implements OnDismissListener {
    final /* synthetic */ a utG;

    f$a$1(a aVar) {
        this.utG = aVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.utG.utF && this.utG.utE != null) {
            f.a(this.utG.utE).onCancel();
            this.utG.utE.dismiss();
        }
    }
}
