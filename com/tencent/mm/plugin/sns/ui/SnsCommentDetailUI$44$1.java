package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.44;

class SnsCommentDetailUI$44$1 implements OnCancelListener {
    final /* synthetic */ r nVq;
    final /* synthetic */ 44 nVr;

    SnsCommentDetailUI$44$1(44 44, r rVar) {
        this.nVr = 44;
        this.nVq = rVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Ek();
        g.Eh().dpP.c(this.nVq);
    }
}
