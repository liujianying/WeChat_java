package com.tencent.mm.plugin.setting.ui.setting;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.bi;

class SettingsAliasUI$1 implements TextWatcher {
    final /* synthetic */ SettingsAliasUI mRV;

    SettingsAliasUI$1(SettingsAliasUI settingsAliasUI) {
        this.mRV = settingsAliasUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        SettingsAliasUI settingsAliasUI = this.mRV;
        a aVar = new a();
        if (charSequence.length() < 6 || charSequence.length() > 20) {
            aVar.Yy = settingsAliasUI.getString(i.verify_account_tip);
            aVar.bLm = false;
        } else if (bi.o(charSequence.charAt(0))) {
            int length = charSequence.length() - 1;
            while (length > 0) {
                char charAt = charSequence.charAt(length);
                if (bi.o(charAt) || charAt == '-' || charAt == '_' || bi.p(charAt)) {
                    length--;
                } else if (Character.isSpace(charAt)) {
                    aVar.Yy = settingsAliasUI.getString(i.verify_account_err_space);
                    aVar.bLm = false;
                } else if (bi.n(charAt)) {
                    aVar.Yy = settingsAliasUI.getString(i.verify_account_err_chinese);
                    aVar.bLm = false;
                } else {
                    aVar.Yy = settingsAliasUI.getString(i.verify_account_tip);
                    aVar.bLm = false;
                }
            }
            aVar.Yy = settingsAliasUI.getString(i.modify_username_detail);
            aVar.bLm = true;
        } else {
            aVar.Yy = settingsAliasUI.getString(i.verify_account_err_start);
            aVar.bLm = false;
        }
        if (aVar.bLm) {
            this.mRV.enableOptionMenu(true);
            SettingsAliasUI.a(this.mRV).setTextColor(this.mRV.getResources().getColorStateList(c.hint_text_color));
        } else {
            this.mRV.enableOptionMenu(false);
            SettingsAliasUI.a(this.mRV).setTextColor(this.mRV.getResources().getColorStateList(c.settings_alias_warning));
        }
        SettingsAliasUI.a(this.mRV).setText(aVar.Yy);
        SettingsAliasUI.b(this.mRV).setText(this.mRV.getString(i.app_account, new Object[]{charSequence}));
    }

    public final void afterTextChanged(Editable editable) {
    }
}
