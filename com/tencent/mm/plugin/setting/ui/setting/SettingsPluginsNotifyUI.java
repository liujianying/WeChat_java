package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPluginsNotifyUI extends MMPreference {
    private f eOE;
    private int state;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        super.onResume();
        btS();
    }

    public final int Ys() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        if (str.equals("settings_plugings_disturb_on")) {
            vR(0);
        }
        if (str.equals("settings_plugings_disturb_on_night")) {
            vR(1);
        }
        if (str.equals("settings_plugings_disturb_off")) {
            vR(2);
        }
        return false;
    }

    private void btS() {
        this.eOE.removeAll();
        Preference preference = new Preference(this);
        preference.setTitle(i.settings_plugings_disturb_on);
        preference.setKey("settings_plugings_disturb_on");
        preference.setLayoutResource(g.mm_preference);
        if (this.state == 0) {
            preference.setWidgetLayoutResource(g.mm_preference_radio_checked);
        } else {
            preference.setWidgetLayoutResource(g.mm_preference_radio_unchecked);
        }
        this.eOE.a(preference);
        preference = new Preference(this);
        preference.setTitle(i.settings_plugings_disturb_on_night);
        preference.setKey("settings_plugings_disturb_on_night");
        preference.setLayoutResource(g.mm_preference);
        if (this.state == 1) {
            preference.setWidgetLayoutResource(g.mm_preference_radio_checked);
        } else {
            preference.setWidgetLayoutResource(g.mm_preference_radio_unchecked);
        }
        this.eOE.a(preference);
        preference = new Preference(this);
        preference.setTitle(i.settings_plugings_disturb_off);
        preference.setKey("settings_plugings_disturb_off");
        preference.setLayoutResource(g.mm_preference);
        if (this.state == 2) {
            preference.setWidgetLayoutResource(g.mm_preference_radio_checked);
        } else {
            preference.setWidgetLayoutResource(g.mm_preference_radio_unchecked);
        }
        this.eOE.a(preference);
        preference = new Preference(this);
        preference.setTitle(i.settings_plugings_disturb_time_tip);
        preference.setLayoutResource(g.mm_preference_info);
        this.eOE.a(preference);
        this.eOE.notifyDataSetChanged();
    }

    private void vR(int i) {
        this.state = i;
        if (this.state == 1 || this.state == 0) {
            com.tencent.mm.kernel.g.Ei().DT().set(8200, Boolean.valueOf(true));
            if (this.state == 1) {
                com.tencent.mm.kernel.g.Ei().DT().set(8201, Integer.valueOf(22));
                com.tencent.mm.kernel.g.Ei().DT().set(8208, Integer.valueOf(8));
                ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FQ().b(new k(true, 22, 8));
            } else {
                com.tencent.mm.kernel.g.Ei().DT().set(8201, Integer.valueOf(0));
                com.tencent.mm.kernel.g.Ei().DT().set(8208, Integer.valueOf(0));
                ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FQ().b(new k(true, 0, 0));
            }
        } else {
            com.tencent.mm.kernel.g.Ei().DT().set(8200, Boolean.valueOf(false));
            ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FQ().b(new k());
        }
        btS();
    }

    protected final void initView() {
        Boolean valueOf = Boolean.valueOf(q.Hb());
        int Hj = q.Hj();
        int Hk = q.Hk();
        if (valueOf.booleanValue()) {
            this.state = Hj == Hk ? 0 : 1;
        } else {
            this.state = 2;
        }
        x.d("ui.settings.SettingsPlugingsNotify", valueOf + "st " + Hj + " ed " + Hk + "  state " + this.state);
        this.state = this.state;
        this.eOE = this.tCL;
        setMMTitle(i.settings_plugings_disturb_title);
        setBackBtn(new 1(this));
    }
}
