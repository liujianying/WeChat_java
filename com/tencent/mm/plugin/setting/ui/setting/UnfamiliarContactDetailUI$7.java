package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.base.h;

class UnfamiliarContactDetailUI$7 implements OnClickListener {
    final /* synthetic */ UnfamiliarContactDetailUI mUT;

    UnfamiliarContactDetailUI$7(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.mUT = unfamiliarContactDetailUI;
    }

    public final void onClick(View view) {
        h.a(this.mUT.mController.tml, true, this.mUT.mController.tml.getString(i.unfamiliar_delete_contact_tip), this.mUT.mController.tml.getString(i.contact_info_delete_contact), this.mUT.mController.tml.getString(i.app_delete), this.mUT.mController.tml.getString(i.app_cancel), new 1(this), null, c.alert_btn_color_warn, 0);
    }
}
