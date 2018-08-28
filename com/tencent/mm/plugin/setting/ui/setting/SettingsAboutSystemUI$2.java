package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.sdk.platformtools.x;

class SettingsAboutSystemUI$2 implements OnClickListener {
    final /* synthetic */ SettingsAboutSystemUI mRk;
    final /* synthetic */ LinearLayout mRl;
    final /* synthetic */ int mRm;

    SettingsAboutSystemUI$2(SettingsAboutSystemUI settingsAboutSystemUI, LinearLayout linearLayout, int i) {
        this.mRk = settingsAboutSystemUI;
        this.mRl = linearLayout;
        this.mRm = i;
    }

    public final void onClick(View view) {
        for (int i = 0; i < this.mRl.getChildCount(); i++) {
            TextView textView = (TextView) this.mRl.getChildAt(i);
            if (f.tips_tv != textView.getId()) {
                textView.setCompoundDrawablesWithIntrinsicBounds(h.radio_off, 0, 0, 0);
            }
        }
        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(h.radio_on, 0, 0, 0);
        int intValue = ((Integer) view.getTag()).intValue();
        x.i("MicroMsg.SettingsAboutSystemUI", "choice: %d, %d", new Object[]{Integer.valueOf(this.mRm), Integer.valueOf(intValue)});
        if (this.mRm != intValue) {
            view.post(new 1(this, intValue));
        }
    }
}
