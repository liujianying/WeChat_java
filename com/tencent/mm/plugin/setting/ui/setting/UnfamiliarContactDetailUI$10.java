package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.VerticalScrollBar.a;

class UnfamiliarContactDetailUI$10 implements a {
    final /* synthetic */ UnfamiliarContactDetailUI mUT;

    UnfamiliarContactDetailUI$10(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.mUT = unfamiliarContactDetailUI;
    }

    public final void ys(String str) {
        UnfamiliarContactDetailUI unfamiliarContactDetailUI = this.mUT;
        int intValue = (unfamiliarContactDetailUI.mUL == null || !unfamiliarContactDetailUI.mUL.containsKey(str)) ? -1 : ((Integer) unfamiliarContactDetailUI.mUL.get(str)).intValue();
        x.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", new Object[]{str, Integer.valueOf(intValue)});
        if (intValue != -1) {
            UnfamiliarContactDetailUI.j(this.mUT).bg(intValue);
        }
    }
}
