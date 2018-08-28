package com.tencent.weui.base.preference;

import android.preference.Preference;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class WeUIPreference$2 implements OnItemClickListener {
    final /* synthetic */ WeUIPreference vzA;

    WeUIPreference$2(WeUIPreference weUIPreference) {
        this.vzA = weUIPreference;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Preference preference = (Preference) adapterView.getAdapter().getItem(i);
        if (preference != null && preference.isEnabled() && preference.isSelectable() && !(preference instanceof CheckBoxPreference)) {
            preference.getKey();
        }
    }
}
