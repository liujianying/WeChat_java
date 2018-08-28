package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;

class SnsCommentDetailUI$8 implements OnClickListener {
    final /* synthetic */ n nMf;
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$8(SnsCommentDetailUI snsCommentDetailUI, n nVar) {
        this.nUO = snsCommentDetailUI;
        this.nMf = nVar;
    }

    public final void onClick(View view) {
        if (!this.nMf.xb(32)) {
            aj.wz(this.nMf.nJc);
            aj.wx(this.nMf.nJc);
            af.byk().bwX();
            Intent intent = new Intent();
            this.nUO.setResult(-1, intent);
            if (SnsCommentDetailUI.r(this.nUO)) {
                intent.putExtra("sns_gallery_force_finish", true);
            }
            this.nUO.finish();
            this.nUO.finish();
        }
    }
}
