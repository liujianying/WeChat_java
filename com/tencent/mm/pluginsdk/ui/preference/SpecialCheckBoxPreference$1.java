package com.tencent.mm.pluginsdk.ui.preference;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.R;

class SpecialCheckBoxPreference$1 implements OnCheckedChangeListener {
    final /* synthetic */ SpecialCheckBoxPreference qPE;

    SpecialCheckBoxPreference$1(SpecialCheckBoxPreference specialCheckBoxPreference) {
        this.qPE = specialCheckBoxPreference;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (id == R.h.room_placed_to_the_top) {
            SpecialCheckBoxPreference.a(this.qPE);
        } else if (id == R.h.room_notify_new_msg) {
            SpecialCheckBoxPreference.b(this.qPE);
        } else if (id == R.h.room_save_to_contact) {
            SpecialCheckBoxPreference.c(this.qPE);
        }
    }
}
