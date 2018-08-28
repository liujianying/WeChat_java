package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.n;

class SnsCommentDetailUI$28 implements OnClickListener {
    final /* synthetic */ n nMf;
    final /* synthetic */ SnsCommentDetailUI nUO;
    final /* synthetic */ boolean nje;

    SnsCommentDetailUI$28(SnsCommentDetailUI snsCommentDetailUI, boolean z, n nVar) {
        this.nUO = snsCommentDetailUI;
        this.nje = z;
        this.nMf = nVar;
    }

    public final void onClick(View view) {
        if (SnsCommentDetailUI.A(this.nUO) != null && this.nje) {
            SnsCommentDetailUI.A(this.nUO).eA(this.nMf.field_snsId);
        }
        SnsCommentDetailUI.x(this.nUO).olb.onClick(view);
    }
}
