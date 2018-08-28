package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.f;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class UnfamiliarContactDetailUI$6 implements g {
    final /* synthetic */ UnfamiliarContactDetailUI mUT;

    UnfamiliarContactDetailUI$6(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.mUT = unfamiliarContactDetailUI;
    }

    public final void ds(int i, int i2) {
        f.mVr += i;
        UnfamiliarContactDetailUI.c(this.mUT, false);
        UnfamiliarContactDetailUI.g(this.mUT).setText(this.mUT.getString(i.unfamiliar_contact_member_list) + "(" + UnfamiliarContactDetailUI.f(this.mUT).size() + ")");
        if (UnfamiliarContactDetailUI.e(this.mUT) != null) {
            UnfamiliarContactDetailUI.e(this.mUT).RR.notifyChanged();
        }
        if (i2 < i) {
            x.w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
            h.b(this.mUT.mController.tml, this.mUT.getString(i.unfamiliar_contact_delete_err, new Object[]{Integer.valueOf(i - i2)}), "", true);
        }
    }

    public final void buj() {
        UnfamiliarContactDetailUI.c(this.mUT, true);
    }
}
