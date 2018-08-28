package com.tencent.mm.plugin.sns.ui;

import android.os.Looper;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.sdk.platformtools.ag;

class SnsCommentDetailUI$19 implements a {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$19(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
    }

    public final void x(String str, boolean z) {
        new ag(Looper.getMainLooper()).postDelayed(new 1(this, z), 500);
    }
}
