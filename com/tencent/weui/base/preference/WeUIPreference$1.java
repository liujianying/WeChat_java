package com.tencent.weui.base.preference;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;

class WeUIPreference$1 implements OnPreferenceChangeListener {
    final /* synthetic */ WeUIPreference vzA;

    WeUIPreference$1(WeUIPreference weUIPreference) {
        this.vzA = weUIPreference;
    }

    public final boolean onPreferenceChange(Preference preference, Object obj) {
        if (!WeUIPreference.a(this.vzA) && preference.isEnabled() && preference.isSelectable()) {
            boolean z;
            WeUIPreference.a(this.vzA, true);
            if (preference instanceof CheckBoxPreference) {
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                checkBoxPreference.qpJ = checkBoxPreference.isChecked();
                if (checkBoxPreference.isPersistent()) {
                    WeUIPreference.b(this.vzA).edit().putBoolean(preference.getKey(), checkBoxPreference.isChecked()).commit();
                }
                WeUIPreference.c(this.vzA);
                z = true;
            } else {
                z = false;
            }
            preference.getKey();
            if (z) {
                WeUIPreference.d(this.vzA).notifyDataSetChanged();
            }
            WeUIPreference.a(this.vzA, false);
            if (z) {
                return true;
            }
        }
        return false;
    }
}
