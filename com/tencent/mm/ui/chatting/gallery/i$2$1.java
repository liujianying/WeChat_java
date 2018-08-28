package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.chatting.gallery.i.2;

class i$2$1 implements OnClickListener {
    final /* synthetic */ 2 tWM;

    i$2$1(2 2) {
        this.tWM = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.cancel();
        }
        ah.A(new 1(this));
    }
}
