package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class MMPreference$2 implements OnItemClickListener {
    final /* synthetic */ MMPreference tCP;

    MMPreference$2(MMPreference mMPreference) {
        this.tCP = mMPreference;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Preference preference = (Preference) adapterView.getAdapter().getItem(i);
        if (preference != null && preference.isEnabled() && preference.tDp && !(preference instanceof CheckBoxPreference)) {
            if (preference instanceof DialogPreference) {
                DialogPreference dialogPreference = (DialogPreference) preference;
                dialogPreference.showDialog();
                dialogPreference.tBN = new 1(this, dialogPreference, preference);
            }
            if (preference instanceof EditPreference) {
                EditPreference editPreference = (EditPreference) preference;
                editPreference.showDialog();
                editPreference.tBP = new 2(this, editPreference, preference);
            }
            if (preference.mKey != null) {
                this.tCP.a(MMPreference.d(this.tCP), preference);
            }
        }
    }
}
