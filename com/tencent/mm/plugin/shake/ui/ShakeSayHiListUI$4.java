package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView$c;

class ShakeSayHiListUI$4 implements MMSlideDelView$c {
    final /* synthetic */ ShakeSayHiListUI nbq;

    ShakeSayHiListUI$4(ShakeSayHiListUI shakeSayHiListUI) {
        this.nbq = shakeSayHiListUI;
    }

    public final int cl(View view) {
        return ShakeSayHiListUI.d(this.nbq).getPositionForView(view);
    }
}
