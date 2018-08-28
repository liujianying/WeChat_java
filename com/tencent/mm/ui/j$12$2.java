package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.ui.j.12;

class j$12$2 implements OnCancelListener {
    final /* synthetic */ ab eJf;
    final /* synthetic */ 12 tjp;

    j$12$2(12 12, ab abVar) {
        this.tjp = 12;
        this.eJf = abVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().b(384, this.tjp.tjf.tjb);
        this.tjp.tjf.tjb = null;
        au.DF().c(this.eJf);
    }
}
