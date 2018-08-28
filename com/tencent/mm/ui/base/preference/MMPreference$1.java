package com.tencent.mm.ui.base.preference;

import com.tencent.mm.ui.base.preference.Preference.a;

class MMPreference$1 implements a {
    final /* synthetic */ MMPreference tCP;

    MMPreference$1(MMPreference mMPreference) {
        this.tCP = mMPreference;
    }

    public final boolean a(Preference preference, Object obj) {
        if (!MMPreference.a(this.tCP) && preference.isEnabled() && preference.tDp) {
            boolean z;
            MMPreference.a(this.tCP, true);
            if (preference instanceof CheckBoxPreference) {
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                checkBoxPreference.qpJ = checkBoxPreference.isChecked();
                if (checkBoxPreference.tDr) {
                    MMPreference.b(this.tCP).edit().putBoolean(preference.mKey, checkBoxPreference.isChecked()).commit();
                }
                MMPreference.c(this.tCP);
                z = true;
            } else {
                z = false;
            }
            if (preference.mKey != null) {
                this.tCP.a(MMPreference.d(this.tCP), preference);
            }
            if (z) {
                MMPreference.d(this.tCP).notifyDataSetChanged();
            }
            MMPreference.a(this.tCP, false);
            if (z) {
                return true;
            }
        }
        return false;
    }
}
