package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.7;
import com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.8;
import com.tencent.mm.sdk.platformtools.x;

class SnsStrangerCommentDetailUI$7$1 implements Runnable {
    final /* synthetic */ 7 obD;

    SnsStrangerCommentDetailUI$7$1(7 7) {
        this.obD = 7;
    }

    public final void run() {
        x.v("MicroMsg.SnsStrangerCommentDetailUI", "comment notify");
        SnsStrangerCommentDetailUI.d(this.obD.obC).a(null, null);
        if (SnsStrangerCommentDetailUI.e(this.obD.obC)) {
            SnsStrangerCommentDetailUI.a(this.obD.obC, false);
            af.aRu().postDelayed(new 8(this.obD.obC), 10);
        }
    }
}
