package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.text.Html;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.f;

public final class c {
    private MMActivity bGc;
    private f eOE;

    public c(MMActivity mMActivity, f fVar) {
        this.bGc = mMActivity;
        this.eOE = fVar;
        ChoicePreference choicePreference = (ChoicePreference) this.eOE.ZZ("settings_sex");
        choicePreference.tBK = new 1(this);
        choicePreference.setTitle(Html.fromHtml(this.bGc.getString(R.l.settings_sex) + "<font color='red'>*</font>"));
        ((KeyValuePreference) this.eOE.ZZ("settings_district")).setTitle(Html.fromHtml(this.bGc.getString(R.l.settings_district) + "<font color='red'>*</font>"));
    }

    public static void auq() {
        bl IC = bl.IC();
        au.HU();
        com.tencent.mm.model.c.FQ().b(new a(1, bl.a(IC)));
        com.tencent.mm.plugin.bottle.a.ezo.vl();
    }

    public final void update() {
        au.HU();
        ChoicePreference choicePreference = (ChoicePreference) this.eOE.ZZ("settings_sex");
        switch (bi.a((Integer) com.tencent.mm.model.c.DT().get(12290, null), 0)) {
            case 1:
                choicePreference.setValue("male");
                break;
            case 2:
                choicePreference.setValue("female");
                break;
            default:
                choicePreference.setValue("unknown");
                break;
        }
        bl IC = bl.IC();
        String province = IC.getProvince();
        this.eOE.ZZ("settings_district").setSummary(r.gV(province) + " " + IC.getCity());
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.eOE.ZZ("settings_signature");
        keyValuePreference.tCA = false;
        au.HU();
        CharSequence oV = bi.oV((String) com.tencent.mm.model.c.DT().get(12291, null));
        MMActivity mMActivity = this.bGc;
        if (oV.length() <= 0) {
            oV = this.bGc.getString(R.l.settings_signature_empty);
        }
        keyValuePreference.setSummary(j.a(mMActivity, oV));
        this.eOE.notifyDataSetChanged();
    }

    public final boolean aur() {
        Intent intent = new Intent();
        intent.putExtra("persist_signature", false);
        com.tencent.mm.plugin.bottle.a.ezn.c(intent, this.bGc);
        return true;
    }

    public final boolean aus() {
        com.tencent.mm.plugin.bottle.a.ezn.b(new Intent(), this.bGc);
        return true;
    }
}
