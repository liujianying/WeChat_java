package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.subapp.c.a;
import com.tencent.mm.ui.chatting.viewitems.ak.4.1;

class ak$4$1$2 implements OnCancelListener {
    final /* synthetic */ 1 ueX;
    final /* synthetic */ a ueY;

    ak$4$1$2(1 1, a aVar) {
        this.ueX = 1;
        this.ueY = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.ueY);
        au.DF().b(331, ak.b(this.ueX.ueW.ueT));
        ak.a(this.ueX.ueW.ueT, null);
        if (ak.c(this.ueX.ueW.ueT) != null) {
            ak.c(this.ueX.ueW.ueT).dismiss();
        }
    }
}
