package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.am.a;
import com.tencent.mm.plugin.sns.ui.bg.9;

class bg$9$2 implements OnCancelListener {
    final /* synthetic */ 9 ohK;
    final /* synthetic */ bd ohL;

    bg$9$2(9 9, bd bdVar) {
        this.ohK = 9;
        this.ohL = bdVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a.dBr.iw(this.ohL.ohf);
    }
}
