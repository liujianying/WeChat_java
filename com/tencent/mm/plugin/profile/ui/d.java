package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class d implements a {
    private final Context context;
    private f eOE;

    public d(Context context) {
        this.context = context;
    }

    public final boolean wX(String str) {
        return true;
    }

    public final boolean a(f fVar, ab abVar, boolean z, int i) {
        Assert.assertTrue(abVar != null);
        Assert.assertTrue(bi.oV(abVar.field_username).length() > 0);
        Assert.assertTrue(fVar != null);
        auw();
        this.eOE = fVar;
        fVar.removeAll();
        fVar.addPreferencesFromResource(R.o.contact_info_pref_bottlecontact);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) fVar.ZZ("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.qPo = "ContactWidgetBottleContact";
            normalUserHeaderPreference.a(abVar, 0, null);
        }
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) fVar.ZZ("contact_info_footer_normal");
        boolean booleanExtra = ((Activity) this.context).getIntent().getBooleanExtra("Contact_FMessageCard", false);
        if (normalUserFooterPreference != null) {
            if (!normalUserFooterPreference.a(abVar, "", z, false, true, 25, 0, booleanExtra, false, 0, "")) {
                fVar.c(normalUserFooterPreference);
            }
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) fVar.ZZ("contact_info_signature");
        if (abVar.signature == null || abVar.signature.trim().equals("")) {
            fVar.c(keyValuePreference);
        } else if (keyValuePreference != null) {
            keyValuePreference.tCA = false;
            keyValuePreference.setTitle(this.context.getString(R.l.contact_info_signature));
            keyValuePreference.setSummary(j.a(this.context, abVar.signature));
            keyValuePreference.lO(false);
        }
        return true;
    }

    public final boolean auw() {
        if (this.eOE != null) {
            FriendPreference friendPreference = (FriendPreference) this.eOE.ZZ("contact_info_friend");
            if (friendPreference != null) {
                friendPreference.auw();
            }
            NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.eOE.ZZ("contact_info_header_normal");
            if (normalUserHeaderPreference != null) {
                normalUserHeaderPreference.onDetach();
            }
            NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.eOE.ZZ("contact_info_footer_normal");
            if (normalUserFooterPreference != null) {
                normalUserFooterPreference.auw();
            }
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
