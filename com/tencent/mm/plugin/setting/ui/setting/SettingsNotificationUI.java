package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.model.k;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class SettingsNotificationUI extends MMPreference {
    private HashMap<Integer, Integer> eGU = new HashMap();
    private f eOE;
    private int status;

    static /* synthetic */ void vQ(int i) {
        if (i == 1 || i == 0) {
            g.Ei().DT().set(8200, Boolean.valueOf(true));
            if (i == 1) {
                g.Ei().DT().set(8201, Integer.valueOf(22));
                g.Ei().DT().set(8208, Integer.valueOf(8));
                ((i) g.l(i.class)).FQ().b(new k(true, 22, 8));
                return;
            }
            g.Ei().DT().set(8201, Integer.valueOf(0));
            g.Ei().DT().set(8208, Integer.valueOf(0));
            ((i) g.l(i.class)).FQ().b(new k(true, 0, 0));
            return;
        }
        g.Ei().DT().set(8200, Boolean.valueOf(false));
        ((i) g.l(i.class)).FQ().b(new k());
    }

    public final int Ys() {
        return a.k.settings_pref_notification;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.status = q.GJ();
        initView();
    }

    protected final void initView() {
        setMMTitle(a.i.settings_notification);
        this.eOE = this.tCL;
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(a.k.settings_pref_notification);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_new_msg_notification");
        if (com.tencent.mm.k.f.Aj()) {
            checkBoxPreference.qpJ = true;
        }
        hB(checkBoxPreference.isChecked());
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.eOE.ZZ("settings_new_voip_msg_notification");
        if (com.tencent.mm.k.f.Ak()) {
            checkBoxPreference2.qpJ = true;
        }
        if (checkBoxPreference.isChecked()) {
            checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_sound");
            if (com.tencent.mm.k.f.Am()) {
                checkBoxPreference.qpJ = true;
                btQ();
            } else {
                this.eOE.aaa("settings_notification_ringtone");
            }
            checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_shake");
            if (com.tencent.mm.k.f.Ao()) {
                checkBoxPreference.qpJ = true;
            }
            checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_show_detail");
            if (com.tencent.mm.k.f.Al()) {
                checkBoxPreference.qpJ = true;
            }
        } else {
            this.eOE.aaa("settings_show_detail");
            this.eOE.aaa("settings_sound");
            this.eOE.aaa("settings_notification_ringtone");
            this.eOE.aaa("settings_shake");
            this.eOE.aaa("settings_active_time");
        }
        setBackBtn(new 1(this));
    }

    protected void onPause() {
        super.onPause();
        g.Ei().DT().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.eGU.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            xt xtVar = new xt();
            xtVar.rDz = intValue;
            xtVar.rDA = intValue2;
            ((i) g.l(i.class)).FQ().b(new h.a(23, xtVar));
            x.d("MicroMsg.SettingsNotificationUI", "switch  " + intValue + " " + intValue2);
        }
        this.eGU.clear();
    }

    public void onResume() {
        super.onResume();
        btQ();
    }

    private void btQ() {
        Preference ZZ = this.eOE.ZZ("settings_notification_ringtone");
        if (ZZ != null) {
            ZZ.setSummary(this.duR.getString("settings.ringtone.name", getString(a.i.settings_notification_ringtone_sys)));
        }
        this.eOE.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        boolean isChecked;
        if (str.equals("settings_new_msg_notification")) {
            com.tencent.mm.k.f.bg(((CheckBoxPreference) preference).isChecked());
            initView();
            if (((CheckBoxPreference) preference).isChecked()) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(500, 0, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.mEJ.a(500, 1, 1, false);
            }
            hB(((CheckBoxPreference) preference).isChecked());
            as.j(true, false);
            return true;
        } else if (str.equals("settings_new_voip_msg_notification")) {
            if (((CheckBoxPreference) preference).isChecked()) {
                com.tencent.mm.k.f.bh(true);
                com.tencent.mm.plugin.report.service.h.mEJ.a(500, 2, 1, false);
                as.j(false, true);
            } else {
                com.tencent.mm.ui.base.h.a(this.mController.tml, false, this.mController.tml.getString(a.i.settings_new_voip_msg_close_tips), "", this.mController.tml.getString(a.i.settings_new_voip_msg_close_confirm), this.mController.tml.getString(a.i.settings_logout_option_cancel), new 2(this), new 3(this), c.alert_btn_color_warn, 0);
            }
            initView();
            return true;
        } else if (str.equals("settings_voip_notification_sound")) {
            isChecked = ((CheckBoxPreference) preference).isChecked();
            g.Ei().DT().set(73217, Boolean.valueOf(isChecked));
            g.Ei().DT().set(73218, Boolean.valueOf(isChecked));
            com.tencent.mm.plugin.report.service.h.mEJ.a(500, isChecked ? 8 : 9, 1, false);
            x.i("MicroMsg.SettingsNotificationUI", "void sound checkbox %b", Boolean.valueOf(isChecked));
            return true;
        } else if (str.equals("settings_sound")) {
            com.tencent.mm.k.f.bk(((CheckBoxPreference) preference).isChecked());
            initView();
            if (((CheckBoxPreference) preference).isChecked()) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(500, 10, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.mEJ.a(500, 11, 1, false);
            }
            return true;
        } else if (str.equals("settings_shake")) {
            com.tencent.mm.k.f.bl(((CheckBoxPreference) preference).isChecked());
            if (((CheckBoxPreference) preference).isChecked()) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(500, 16, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.mEJ.a(500, 17, 1, false);
            }
            bi.t((Context) this, ((CheckBoxPreference) preference).isChecked());
            return true;
        } else if (str.equals("settings_show_detail")) {
            isChecked = ((CheckBoxPreference) preference).isChecked();
            com.tencent.mm.k.f.bi(isChecked);
            isChecked = !isChecked;
            x.d("MicroMsg.SettingsNotificationUI", "switch change : open = " + isChecked + " item value = 2048 functionId = 10");
            if (isChecked) {
                this.status |= 2048;
            } else {
                this.status &= -2049;
            }
            this.eGU.put(Integer.valueOf(10), Integer.valueOf(isChecked ? 1 : 2));
            return true;
        } else if (str.equals("settings_notification_ringtone")) {
            startActivity(new Intent(this.mController.tml, SettingsRingtoneUI.class));
            return true;
        } else if (str.equals("settings_active_time")) {
            startActivity(new Intent(this, SettingsActiveTimeUI.class));
            return true;
        } else {
            if (str.equals("settings_plugings_notify")) {
                List linkedList = new LinkedList();
                linkedList.add(getString(a.i.settings_plugings_disturb_on));
                linkedList.add(getString(a.i.settings_plugings_disturb_on_night));
                linkedList.add(getString(a.i.settings_plugings_disturb_off));
                Boolean valueOf = Boolean.valueOf(q.Hb());
                int Hj = q.Hj();
                int Hk = q.Hk();
                int i = valueOf.booleanValue() ? Hj == Hk ? 0 : 1 : 2;
                x.d("MicroMsg.SettingsNotificationUI", valueOf + "st " + Hj + " ed " + Hk + "  state " + i);
                Context context = this.mController.tml;
                String string = getString(a.i.settings_plugings_disturb_title);
                getString(a.i.settings_plugings_disturb_time_tip);
                com.tencent.mm.ui.base.h.a(context, string, linkedList, i, new 4(this, i));
            }
            return false;
        }
    }

    private boolean hB(boolean z) {
        Preference ZZ = this.eOE.ZZ("settings_sound");
        Preference ZZ2 = this.eOE.ZZ("settings_shake");
        Preference ZZ3 = this.eOE.ZZ("settings_show_detail");
        if (ZZ != null) {
            ZZ.setEnabled(z);
        }
        if (ZZ2 != null) {
            ZZ2.setEnabled(z);
        }
        if (ZZ3 != null) {
            ZZ3.setEnabled(z);
        }
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        as.ha(3);
    }
}
