package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.base.h;

class SettingsModifyEmailAddrUI$22 implements OnClickListener {
    final /* synthetic */ SettingsModifyEmailAddrUI mSQ;

    SettingsModifyEmailAddrUI$22(SettingsModifyEmailAddrUI settingsModifyEmailAddrUI) {
        this.mSQ = settingsModifyEmailAddrUI;
    }

    public final void onClick(View view) {
        g.DF().a(new y(y.eKS), 0);
        SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = this.mSQ;
        Context context = this.mSQ;
        this.mSQ.getString(i.app_tip);
        SettingsModifyEmailAddrUI.a(settingsModifyEmailAddrUI, h.a(context, this.mSQ.getString(i.settings_unbinding), true, new 1(this)));
        this.mSQ.YC();
    }
}
