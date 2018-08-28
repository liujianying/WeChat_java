package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;

class NormalUserFooterPreference$a$2 implements OnClickListener {
    final /* synthetic */ a lXy;

    NormalUserFooterPreference$a$2(a aVar) {
        this.lXy = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        rn rnVar = new rn();
        rnVar.ccn.ccq = true;
        com.tencent.mm.sdk.b.a.sFg.m(rnVar);
        this.lXy.bnD();
        dialogInterface.dismiss();
    }
}
