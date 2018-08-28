package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.e;

class SettingsTrustFriendUI$5 implements OnCancelListener {
    final /* synthetic */ SettingsTrustFriendUI mUl;
    final /* synthetic */ e mUn;

    SettingsTrustFriendUI$5(SettingsTrustFriendUI settingsTrustFriendUI, e eVar) {
        this.mUl = settingsTrustFriendUI;
        this.mUn = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.mUn);
    }
}
