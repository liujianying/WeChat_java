package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class SettingDeleteAccountAgreementUI$1 implements OnClickListener {
    final /* synthetic */ SettingDeleteAccountAgreementUI mQJ;

    SettingDeleteAccountAgreementUI$1(SettingDeleteAccountAgreementUI settingDeleteAccountAgreementUI) {
        this.mQJ = settingDeleteAccountAgreementUI;
    }

    public final void onClick(View view) {
        this.mQJ.startActivity(new Intent(this.mQJ, SettingDeleteAccountInputPassUI.class));
    }
}
