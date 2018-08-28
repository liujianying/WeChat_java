package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.c;

class UnfamiliarContactDetailUI$c$1 implements OnClickListener {
    final /* synthetic */ UnfamiliarContactDetailUI mVg;
    final /* synthetic */ c mVh;

    UnfamiliarContactDetailUI$c$1(c cVar, UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.mVh = cVar;
        this.mVg = unfamiliarContactDetailUI;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        this.mVh.jBR.setChecked(!this.mVh.jBR.isChecked());
        if (this.mVh.jBR.isChecked()) {
            UnfamiliarContactDetailUI.b(this.mVh.mUT).add(Integer.valueOf(intValue));
        } else {
            UnfamiliarContactDetailUI.b(this.mVh.mUT).remove(Integer.valueOf(intValue));
        }
        if (UnfamiliarContactDetailUI.b(this.mVh.mUT).size() == 0) {
            UnfamiliarContactDetailUI.d(this.mVh.mUT).setEnabled(false);
            UnfamiliarContactDetailUI.c(this.mVh.mUT).setEnabled(false);
            return;
        }
        UnfamiliarContactDetailUI.d(this.mVh.mUT).setEnabled(true);
        UnfamiliarContactDetailUI.c(this.mVh.mUT).setEnabled(true);
    }
}
