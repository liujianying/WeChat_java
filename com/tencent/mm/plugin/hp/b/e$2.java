package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.hp.tinker.g;

class e$2 implements OnClickListener {
    final /* synthetic */ e kmH;
    final /* synthetic */ Context val$context;

    e$2(e eVar, Context context) {
        this.kmH = eVar;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.as(this.val$context, this.kmH.kmF.knj);
    }
}
