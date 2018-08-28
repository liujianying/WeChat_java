package com.tencent.mm.plugin.qmessage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qmessage.a.b;

class a$2 implements OnCancelListener {
    final /* synthetic */ b mbG;
    final /* synthetic */ a mbH;

    a$2(a aVar, b bVar) {
        this.mbH = aVar;
        this.mbG = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.mbG);
    }
}
