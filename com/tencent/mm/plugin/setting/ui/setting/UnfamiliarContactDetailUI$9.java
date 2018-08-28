package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.plugin.setting.a.f;

class UnfamiliarContactDetailUI$9 implements OnClickListener {
    final /* synthetic */ UnfamiliarContactDetailUI mUT;

    UnfamiliarContactDetailUI$9(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.mUT = unfamiliarContactDetailUI;
    }

    public final void onClick(View view) {
        boolean z;
        CheckBox checkBox = (CheckBox) UnfamiliarContactDetailUI.i(this.mUT).findViewById(f.checkbox);
        if (checkBox.isChecked()) {
            z = false;
        } else {
            z = true;
        }
        checkBox.setChecked(z);
        if (checkBox.isChecked()) {
            for (int i = 0; i < UnfamiliarContactDetailUI.f(this.mUT).size(); i++) {
                UnfamiliarContactDetailUI.b(this.mUT).add(Integer.valueOf(i));
            }
        } else {
            UnfamiliarContactDetailUI.b(this.mUT).clear();
        }
        if (UnfamiliarContactDetailUI.b(this.mUT).size() > 0) {
            UnfamiliarContactDetailUI.d(this.mUT).setEnabled(true);
            UnfamiliarContactDetailUI.c(this.mUT).setEnabled(true);
        } else {
            UnfamiliarContactDetailUI.d(this.mUT).setEnabled(false);
            UnfamiliarContactDetailUI.c(this.mUT).setEnabled(false);
        }
        UnfamiliarContactDetailUI.j(this.mUT).post(new Runnable() {
            public final void run() {
                UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI$9.this.mUT).RR.notifyChanged();
            }
        });
    }
}
