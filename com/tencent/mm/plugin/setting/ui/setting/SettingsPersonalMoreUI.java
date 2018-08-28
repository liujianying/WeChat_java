package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.DialogPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPersonalMoreUI extends MMPreference implements b {
    private f eOE;
    private int sex = -1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final int Ys() {
        return k.settings_pref_personal_info_more;
    }

    protected final void initView() {
        setMMTitle(i.settings_personal_more_info);
        this.eOE = this.tCL;
        ((DialogPreference) this.eOE.ZZ("settings_sex")).tBK = new 1(this);
        setBackBtn(new 2(this));
    }

    protected void onResume() {
        boolean z;
        boolean z2 = true;
        super.onResume();
        DialogPreference dialogPreference = (DialogPreference) this.eOE.ZZ("settings_sex");
        switch (bi.a((Integer) g.Ei().DT().get(12290, null), 0)) {
            case 1:
                dialogPreference.setValue("male");
                break;
            case 2:
                dialogPreference.setValue("female");
                break;
            default:
                dialogPreference.setValue("unknown");
                break;
        }
        bl IC = bl.IC();
        this.eOE.ZZ("settings_district").setSummary(r.gV(bi.oV(IC.getProvince())) + " " + bi.oV(IC.getCity()));
        btR();
        if ((q.GQ() & 16777216) == 0) {
            z = true;
        } else {
            z = false;
        }
        String value = com.tencent.mm.k.g.AT().getValue("LinkedinPluginClose");
        int i = (bi.oW(value) || Integer.valueOf(value).intValue() == 0) ? true : 0;
        if (!z || i == 0) {
            this.eOE.bw("settings_linkedin", true);
            return;
        }
        Preference ZZ = this.eOE.ZZ("settings_linkedin");
        if (bi.oW((String) g.Ei().DT().get(286721, null))) {
            z2 = false;
        }
        if (!z2) {
            ZZ.setSummary(getString(i.settings_linkedin_open_not_bind));
        } else if ((q.GJ() & 4194304) == 0) {
            ZZ.setSummary(getString(i.settings_linkedin_open_not_set));
        } else {
            ZZ.setSummary(getString(i.settings_linkedin_open_set));
        }
    }

    public void onPause() {
        super.onPause();
        bl IC = bl.IC();
        if (this.sex != -1) {
            IC.sex = this.sex;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FQ().b(new a(1, bl.a(IC)));
    }

    private void btR() {
        Preference ZZ = this.eOE.ZZ("settings_signature");
        CharSequence oV = bi.oV((String) g.Ei().DT().get(12291, null));
        if (oV.length() <= 0) {
            oV = getString(i.settings_signature_empty);
        }
        ZZ.setSummary(j.a(this, oV));
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        if (str.equals("settings_district")) {
            com.tencent.mm.plugin.setting.b.ezn.b(new Intent(), this.mController.tml);
            return true;
        } else if (str.equals("settings_signature")) {
            startActivity(new Intent(this, EditSignatureUI.class));
            return true;
        } else if (!str.equals("settings_linkedin")) {
            return false;
        } else {
            Intent intent = new Intent(this, BindLinkedInUI.class);
            intent.putExtra("oversea_entry", true);
            startActivity(intent);
            return true;
        }
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        x.d("SettingsPersonalMoreUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(p), mVar});
        if (mVar != g.Ei().DT() || p <= 0) {
            x.e("SettingsPersonalMoreUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(p), mVar});
        } else if (12291 == p) {
            btR();
        }
    }
}
