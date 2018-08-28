package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.b;

class SettingsTrustFriendUI$2 implements OnCancelListener {
    final /* synthetic */ SettingsTrustFriendUI mUl;
    final /* synthetic */ b mUm;

    SettingsTrustFriendUI$2(SettingsTrustFriendUI settingsTrustFriendUI, b bVar) {
        this.mUl = settingsTrustFriendUI;
        this.mUm = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.mUm);
    }
}
