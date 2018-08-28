package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.e;

class SettingsPrivacyUI$2 implements OnClickListener {
    final /* synthetic */ LinearLayout mRl;
    final /* synthetic */ SettingsPrivacyUI mTv;

    SettingsPrivacyUI$2(SettingsPrivacyUI settingsPrivacyUI, LinearLayout linearLayout) {
        this.mTv = settingsPrivacyUI;
        this.mRl = linearLayout;
    }

    public final void onClick(View view) {
        for (int i = 0; i < this.mRl.getChildCount(); i++) {
            TextView textView = (TextView) this.mRl.getChildAt(i);
            if (f.tips_tv != textView.getId()) {
                textView.setCompoundDrawablesWithIntrinsicBounds(h.radio_off, 0, 0, 0);
            }
        }
        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(h.radio_on, 0, 0, 0);
        bqd bqd = new bqd();
        if (n.nky != null) {
            bqd = n.nky.Lv(SettingsPrivacyUI.b(this.mTv));
        }
        if (bqd == null) {
            x.e("MicroMsg.SettingPrivacy", "userinfo is null");
            return;
        }
        int intValue = ((Integer) view.getTag()).intValue();
        x.d("MicroMsg.SettingPrivacy", "settings_silence_update_mode choice: %d", new Object[]{Integer.valueOf(intValue)});
        bqd b;
        if (intValue == 0) {
            if (SettingsPrivacyUI.c(this.mTv) == e.thw) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14090, new Object[]{Integer.valueOf(4)});
            }
            SettingsPrivacyUI.a(this.mTv, false);
            SettingsPrivacyUI.b(this.mTv, true);
            SettingsPrivacyUI.d(this.mTv);
            if (n.nky != null) {
                n.nky.a(SettingsPrivacyUI.b(this.mTv), SettingsPrivacyUI.e(this.mTv), SettingsPrivacyUI.f(this.mTv), SettingsPrivacyUI.g(this.mTv));
            }
            if (n.nky != null) {
                b = n.nky.b(SettingsPrivacyUI.b(this.mTv), SettingsPrivacyUI.e(this.mTv), SettingsPrivacyUI.f(this.mTv), SettingsPrivacyUI.g(this.mTv));
                n.nky.a(SettingsPrivacyUI.b(this.mTv), b);
                if (b == null) {
                    x.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                    return;
                } else {
                    x.d("MicroMsg.SettingPrivacy", "dancy userinfo " + b.toString());
                    ((i) g.l(i.class)).FQ().b(new a(51, b));
                }
            }
        } else if (intValue == 1) {
            if (SettingsPrivacyUI.c(this.mTv) == e.thw) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14090, new Object[]{Integer.valueOf(5)});
            }
            SettingsPrivacyUI.a(this.mTv, true);
            SettingsPrivacyUI.b(this.mTv, false);
            SettingsPrivacyUI.d(this.mTv);
            if (n.nky != null) {
                n.nky.a(SettingsPrivacyUI.b(this.mTv), SettingsPrivacyUI.e(this.mTv), SettingsPrivacyUI.f(this.mTv), SettingsPrivacyUI.g(this.mTv));
            }
            if (n.nky != null) {
                b = n.nky.b(SettingsPrivacyUI.b(this.mTv), SettingsPrivacyUI.e(this.mTv), SettingsPrivacyUI.f(this.mTv), SettingsPrivacyUI.g(this.mTv));
                n.nky.a(SettingsPrivacyUI.b(this.mTv), b);
                if (b == null) {
                    x.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                    return;
                } else {
                    x.d("MicroMsg.SettingPrivacy", "dancy userinfo " + b.toString());
                    ((i) g.l(i.class)).FQ().b(new a(51, b));
                }
            }
        } else {
            if (SettingsPrivacyUI.c(this.mTv) == e.thw) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14090, new Object[]{Integer.valueOf(6)});
            }
            SettingsPrivacyUI.a(this.mTv, false);
            SettingsPrivacyUI.b(this.mTv, false);
            SettingsPrivacyUI.d(this.mTv);
            if (n.nky != null) {
                n.nky.a(SettingsPrivacyUI.b(this.mTv), SettingsPrivacyUI.e(this.mTv), SettingsPrivacyUI.f(this.mTv), SettingsPrivacyUI.g(this.mTv));
            }
            if (n.nky != null) {
                b = n.nky.b(SettingsPrivacyUI.b(this.mTv), SettingsPrivacyUI.e(this.mTv), SettingsPrivacyUI.f(this.mTv), SettingsPrivacyUI.g(this.mTv));
                n.nky.a(SettingsPrivacyUI.b(this.mTv), b);
                if (b == null) {
                    x.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                    return;
                } else {
                    x.d("MicroMsg.SettingPrivacy", "dancy userinfo " + b.toString());
                    ((i) g.l(i.class)).FQ().b(new a(51, b));
                }
            }
        }
        view.post(new 1(this));
    }
}
