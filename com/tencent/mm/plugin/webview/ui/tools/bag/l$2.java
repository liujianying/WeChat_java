package com.tencent.mm.plugin.webview.ui.tools.bag;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class l$2 implements e {
    final /* synthetic */ l qcG;

    l$2(l lVar) {
        this.qcG = lVar;
    }

    public final void onAnimationEnd() {
        x.i("MicroMsg.WebViewUIBagHelper", "bag transformation onAnimationEnd");
        l.a(this.qcG).getIntent().putExtra("MMActivity.OverrideExitAnimation", 0);
        l.a(this.qcG).getIntent().putExtra("MMActivity.OverrideEnterAnimation", 0);
        l.a(this.qcG).finish();
        l.b(this.qcG, 1);
    }

    public final void bWQ() {
        x.i("MicroMsg.WebViewUIBagHelper", "bag transformation onAnimationCancel do default");
        l.a(this.qcG).getIntent().putExtra("MMActivity.OverrideExitAnimation", R.a.pop_out);
        l.a(this.qcG).getIntent().putExtra("MMActivity.OverrideEnterAnimation", R.a.anim_not_change);
        l.a(this.qcG).finish();
        ah.i(new 1(this), 500);
    }
}
