package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.TextView;

class SettingDeleteAccountAgreementUI$2 implements OnClickListener {
    final /* synthetic */ SettingDeleteAccountAgreementUI mQJ;
    final /* synthetic */ TextView mQK;
    final /* synthetic */ CheckedTextView mQL;

    SettingDeleteAccountAgreementUI$2(SettingDeleteAccountAgreementUI settingDeleteAccountAgreementUI, TextView textView, CheckedTextView checkedTextView) {
        this.mQJ = settingDeleteAccountAgreementUI;
        this.mQK = textView;
        this.mQL = checkedTextView;
    }

    public final void onClick(View view) {
        this.mQK.setEnabled(this.mQL.isChecked());
    }
}
