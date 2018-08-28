package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.setting.a.i;

class UnfamiliarContactDetailUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ UnfamiliarContactDetailUI mUT;

    UnfamiliarContactDetailUI$1(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.mUT = unfamiliarContactDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        UnfamiliarContactDetailUI.a(this.mUT, !UnfamiliarContactDetailUI.a(this.mUT));
        UnfamiliarContactDetailUI.b(this.mUT).clear();
        UnfamiliarContactDetailUI.b(this.mUT, UnfamiliarContactDetailUI.a(this.mUT));
        if (UnfamiliarContactDetailUI.a(this.mUT)) {
            UnfamiliarContactDetailUI.c(this.mUT).setEnabled(false);
            UnfamiliarContactDetailUI.d(this.mUT).setEnabled(false);
            this.mUT.updateOptionMenuText(1, this.mUT.getString(i.unfamiliar_cancel_contact_member_multi_select));
        } else {
            this.mUT.updateOptionMenuText(1, this.mUT.getString(i.unfamiliar_contact_member_multi_select));
        }
        if (UnfamiliarContactDetailUI.e(this.mUT) != null) {
            UnfamiliarContactDetailUI.e(this.mUT).RR.notifyChanged();
        }
        return true;
    }
}
