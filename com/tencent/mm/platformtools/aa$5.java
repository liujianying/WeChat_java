package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a;

class aa$5 implements OnClickListener {
    final /* synthetic */ a ewv;
    final /* synthetic */ int ms;
    final /* synthetic */ Context val$context;

    aa$5(Context context, a aVar, int i) {
        this.val$context = context;
        this.ewv = aVar;
        this.ms = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.b(this.val$context, this.ewv.url, this.ms, false);
    }
}
