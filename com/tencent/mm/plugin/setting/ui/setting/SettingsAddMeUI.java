package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import java.util.HashMap;
import java.util.Map.Entry;

public class SettingsAddMeUI extends MMPreference {
    private HashMap<Integer, Integer> eGU = new HashMap();
    private f eOE;
    private long hXx;
    private int mRK;
    private int status;

    public final h a(SharedPreferences sharedPreferences) {
        return new a(this, sharedPreferences);
    }

    public final int Ys() {
        return k.settings_add_me;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eOE = this.tCL;
        this.mRK = q.GL();
        this.status = q.GJ();
        this.hXx = q.GK();
        initView();
    }

    public void onPause() {
        super.onPause();
        x.d("MicroMsg.SettingsAddMeUI", "plug:" + this.mRK + ",status:" + this.status + ",extstatus:" + this.hXx);
        g.Ei().DT().set(7, Integer.valueOf(this.status));
        g.Ei().DT().set(40, Integer.valueOf(this.mRK));
        g.Ei().DT().set(147457, Long.valueOf(this.hXx));
        for (Entry entry : this.eGU.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            xt xtVar = new xt();
            xtVar.rDz = intValue;
            xtVar.rDA = intValue2;
            ((i) g.l(i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(23, xtVar));
            x.d("MicroMsg.SettingsAddMeUI", "switch  " + intValue + " " + intValue2);
        }
        this.eGU.clear();
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.mKey;
        x.i("MicroMsg.SettingsAddMeUI", str + " item has been clicked!");
        if (str.equals("settings_find_me_by_QQ")) {
            boolean z2 = !((CheckBoxPreference) fVar.ZZ("settings_find_me_by_QQ")).isChecked();
            b(z2, 8, 2);
            b(z2, 16, 3);
            return true;
        } else if (str.equals("settings_find_me_by_weixin")) {
            if (!((CheckBoxPreference) fVar.ZZ("settings_find_me_by_weixin")).isChecked()) {
                z = true;
            }
            x.d("MicroMsg.SettingsAddMeUI", "switch plug change : open = " + z + " item value = 512 functionId = 25");
            if (z) {
                this.mRK |= 512;
            } else {
                this.mRK &= -513;
            }
            this.eGU.put(Integer.valueOf(25), Integer.valueOf(z ? 1 : 2));
            return true;
        } else if (str.equals("settings_find_me_by_mobile")) {
            if (!((CheckBoxPreference) fVar.ZZ("settings_find_me_by_mobile")).isChecked()) {
                z = true;
            }
            b(z, 512, 8);
            return true;
        } else if (str.equals("settings_find_me_by_google")) {
            if (!((CheckBoxPreference) fVar.ZZ("settings_find_me_by_google")).isChecked()) {
                z = true;
            }
            b(z, 524288, 30);
            return true;
        } else if (str.equals("settings_add_me_by_chatroom")) {
            if (!((CheckBoxPreference) fVar.ZZ("settings_add_me_by_chatroom")).isChecked()) {
                z = true;
            }
            c(z, 1, 38);
            return true;
        } else if (str.equals("settings_add_me_by_qrcode")) {
            if (!((CheckBoxPreference) fVar.ZZ("settings_add_me_by_qrcode")).isChecked()) {
                z = true;
            }
            c(z, 2, 39);
            return true;
        } else if (!str.equals("settings_add_me_by_namecard")) {
            return false;
        } else {
            if (!((CheckBoxPreference) fVar.ZZ("settings_add_me_by_namecard")).isChecked()) {
                z = true;
            }
            c(z, 4, 40);
            return true;
        }
    }

    private void b(boolean z, int i, int i2) {
        x.d("MicroMsg.SettingsAddMeUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.eGU.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
    }

    private void c(boolean z, int i, int i2) {
        x.d("MicroMsg.SettingsAddMeUI", "switch ext change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.hXx |= (long) i;
        } else {
            this.hXx &= (long) (i ^ -1);
        }
        this.eGU.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
    }

    protected final void initView() {
        boolean z;
        boolean z2;
        setMMTitle(com.tencent.mm.plugin.setting.a.i.settings_add_me_way);
        setBackBtn(new 1(this));
        x.d("MicroMsg.SettingsAddMeUI", "plug:" + this.mRK + ",status:" + this.status + ",extstatus:" + this.hXx);
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(k.settings_add_me);
        Integer num = (Integer) g.Ei().DT().get(9, null);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_find_me_by_QQ");
        checkBoxPreference.tDr = false;
        if (num == null || num.intValue() == 0) {
            this.eOE.c(checkBoxPreference);
        } else {
            z = (uL(8) && uL(16)) ? false : true;
            checkBoxPreference.qpJ = z;
        }
        String str = (String) g.Ei().DT().get(6, null);
        checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_find_me_by_mobile");
        checkBoxPreference.tDr = false;
        if (str == null || str.length() <= 0) {
            this.eOE.c(checkBoxPreference);
        } else {
            if (uL(512)) {
                z = false;
            } else {
                z = true;
            }
            checkBoxPreference.qpJ = z;
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.eOE.ZZ("settings_find_me_by_weixin");
        checkBoxPreference2.tDr = false;
        if ((this.mRK & 512) != 0) {
            checkBoxPreference2.qpJ = false;
        } else {
            checkBoxPreference2.qpJ = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.eOE.ZZ("settings_find_me_by_google");
        if (uL(524288)) {
            z2 = false;
        } else {
            z2 = true;
        }
        checkBoxPreference2.qpJ = z2;
        checkBoxPreference2.tDr = false;
        String str2 = (String) g.Ei().DT().get(208903, null);
        if (!bi.fU(this) || TextUtils.isEmpty(str2)) {
            this.eOE.c(checkBoxPreference2);
        }
        checkBoxPreference2 = (CheckBoxPreference) this.eOE.ZZ("settings_add_me_by_chatroom");
        checkBoxPreference2.tDr = false;
        if ((this.hXx & 1) != 0) {
            checkBoxPreference2.qpJ = false;
        } else {
            checkBoxPreference2.qpJ = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.eOE.ZZ("settings_add_me_by_qrcode");
        checkBoxPreference2.tDr = false;
        if ((this.hXx & 2) != 0) {
            checkBoxPreference2.qpJ = false;
        } else {
            checkBoxPreference2.qpJ = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.eOE.ZZ("settings_add_me_by_namecard");
        checkBoxPreference2.tDr = false;
        if ((this.hXx & 4) != 0) {
            checkBoxPreference2.qpJ = false;
        } else {
            checkBoxPreference2.qpJ = true;
        }
        this.eOE.notifyDataSetChanged();
    }

    private boolean uL(int i) {
        return (this.status & i) != 0;
    }
}
