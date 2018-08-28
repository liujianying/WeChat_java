package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.8;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class UnfamiliarContactDetailUI$8$1 implements c {
    final /* synthetic */ 8 mUX;

    UnfamiliarContactDetailUI$8$1(8 8) {
        this.mUX = 8;
    }

    public final void a(l lVar) {
        lVar.a(0, this.mUX.mUT.getString(i.not_receive_her_sns_title), this.mUX.mUT.getString(i.setting_sns_desc), this.mUX.mUT.getResources().getDrawable(h.circle_notreceive), false);
        lVar.a(1, this.mUX.mUT.getString(i.not_visible_my_sns_title), this.mUX.mUT.getString(i.setting_sns_desc), this.mUX.mUT.getResources().getDrawable(h.circle_notvisible), false);
    }
}
