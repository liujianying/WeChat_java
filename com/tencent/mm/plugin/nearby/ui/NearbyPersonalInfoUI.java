package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.nearby.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class NearbyPersonalInfoUI extends MMPreference {
    private f eOE;
    private int sex = -1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.nearby_personal_info);
        this.eOE = this.tCL;
        ((KeyValuePreference) this.eOE.ZZ("settings_signature")).tCA = false;
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.app_nextstep), new 2(this));
        ((ChoicePreference) this.eOE.ZZ("settings_sex")).tBK = new 3(this);
        au.HU();
        int a = bi.a((Integer) c.DT().get(12290, null), 0);
        ChoicePreference choicePreference = (ChoicePreference) this.eOE.ZZ("settings_sex");
        choicePreference.setTitle(Html.fromHtml(getString(R.l.settings_sex) + "<font color='red'>*</font>"));
        switch (a) {
            case 1:
                choicePreference.setValue("male");
                return;
            case 2:
                choicePreference.setValue("female");
                return;
            default:
                choicePreference.setValue("unknown");
                return;
        }
    }

    public void onResume() {
        bl IC = bl.IC();
        String province = IC.getProvince();
        String city = IC.getCity();
        Preference ZZ = this.eOE.ZZ("settings_district");
        ZZ.setSummary(r.gV(province) + " " + city);
        ZZ.setTitle(Html.fromHtml(getString(R.l.settings_district) + "<font color='red'>*</font>"));
        Preference ZZ2 = this.eOE.ZZ("settings_signature");
        au.HU();
        CharSequence oV = bi.oV((String) c.DT().get(12291, null));
        if (oV.length() <= 0) {
            oV = getString(R.l.settings_signature_empty);
        }
        ZZ2.setSummary(j.a((Context) this, oV));
        super.onResume();
    }

    public final int Ys() {
        return R.o.nearby_personal_info;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        if ("settings_district".equals(str)) {
            a.ezn.b(null, this);
            return true;
        } else if (!"settings_signature".equals(str)) {
            return false;
        } else {
            a.ezn.c(null, this);
            overridePendingTransition(R.a.push_up_in, R.a.push_empty_out);
            return true;
        }
    }
}
