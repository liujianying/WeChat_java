package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery.f;

class SnsInfoFlip$1 implements f {
    final /* synthetic */ SnsInfoFlip nXg;
    final /* synthetic */ Context val$context;

    SnsInfoFlip$1(SnsInfoFlip snsInfoFlip, Context context) {
        this.nXg = snsInfoFlip;
        this.val$context = context;
    }

    public final void ayI() {
        if (this.val$context instanceof SnsBrowseUI) {
            ((SnsBrowseUI) this.val$context).ayH();
        } else if (SnsInfoFlip.a(this.nXg)) {
            ((MMActivity) this.val$context).finish();
        } else {
            SnsInfoFlip.c(this.nXg).post(new 1(this));
        }
    }
}
