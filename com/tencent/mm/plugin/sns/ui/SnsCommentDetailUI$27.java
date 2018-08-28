package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.n;

class SnsCommentDetailUI$27 implements OnClickListener {
    final /* synthetic */ n nMf;
    final /* synthetic */ SnsCommentDetailUI nUO;
    final /* synthetic */ int nUZ;

    SnsCommentDetailUI$27(SnsCommentDetailUI snsCommentDetailUI, int i, n nVar) {
        this.nUO = snsCommentDetailUI;
        this.nUZ = i;
        this.nMf = nVar;
    }

    public final void onClick(View view) {
        if (SnsCommentDetailUI.A(this.nUO) != null && this.nUZ > 0) {
            SnsCommentDetailUI.A(this.nUO).eA(this.nMf.field_snsId);
        }
        SnsCommentDetailUI.x(this.nUO).olb.onClick(view);
    }
}
