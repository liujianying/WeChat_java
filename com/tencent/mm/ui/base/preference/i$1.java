package com.tencent.mm.ui.base.preference;

import com.tencent.mm.ui.base.preference.Preference.a;

class i$1 implements a {
    final /* synthetic */ i tDe;

    i$1(i iVar) {
        this.tDe = iVar;
    }

    public final boolean a(Preference preference, Object obj) {
        if (!i.a(this.tDe) && preference.isEnabled() && preference.tDp) {
            boolean z;
            i.a(this.tDe, true);
            if (preference instanceof CheckBoxPreference) {
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                checkBoxPreference.qpJ = checkBoxPreference.isChecked();
                if (checkBoxPreference.tDr) {
                    i.b(this.tDe).edit().putBoolean(preference.mKey, checkBoxPreference.isChecked()).commit();
                }
                i.c(this.tDe);
                z = true;
            } else {
                z = false;
            }
            if (preference.mKey != null) {
                this.tDe.a(i.d(this.tDe), preference);
            }
            if (z) {
                i.d(this.tDe).notifyDataSetChanged();
            }
            i.a(this.tDe, false);
            if (z) {
                return true;
            }
        }
        return false;
    }
}
