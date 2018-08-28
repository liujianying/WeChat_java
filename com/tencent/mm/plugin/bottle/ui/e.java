package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import junit.framework.Assert;

public final class e implements a, b {
    private boolean bKe;
    final Context context;
    private f eOE;
    private final Map<String, Preference> eQe = new HashMap();
    private ab guS;
    private int status;

    public e(Context context) {
        this.context = context;
    }

    public final boolean wX(String str) {
        x.d("MicroMsg.ContactWidgetFloatBottle", "handleEvent : key = " + str);
        if (bi.oV(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_goto_floatbottle")) {
            bl IC = bl.IC();
            if (bi.a(Integer.valueOf(IC.sex), 0) <= 0 || bi.oW(IC.getProvince())) {
                this.context.startActivity(new Intent(this.context, BottleWizardStep1.class));
            } else {
                this.context.startActivity(new Intent(this.context, BottleBeachUI.class));
            }
            return true;
        } else if (str.equals("contact_info_floatbottle_clear_data")) {
            h.a(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 1(this), null);
            return true;
        } else if (str.equals("contact_info_floatbottle_install")) {
            m(this.context, true);
            return true;
        } else if (str.equals("contact_info_floatbottle_uninstall")) {
            h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 2(this), null);
            return true;
        } else {
            x.e("MicroMsg.ContactWidgetFloatBottle", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, ab abVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (abVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.hl(abVar.field_username));
        au.HU();
        c.DT().a(this);
        this.guS = abVar;
        this.eOE = fVar;
        fVar.addPreferencesFromResource(R.o.contact_info_pref_floatbottle);
        Preference ZZ = fVar.ZZ("contact_info_header_helper");
        if (ZZ != null) {
            this.eQe.put("contact_info_header_helper", ZZ);
        }
        ZZ = fVar.ZZ("contact_info_goto_floatbottle");
        if (ZZ != null) {
            this.eQe.put("contact_info_goto_floatbottle", ZZ);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) fVar.ZZ("contact_info_floatbottle_hide_cat");
        if (preferenceCategory != null) {
            this.eQe.put("contact_info_floatbottle_hide_cat", preferenceCategory);
        }
        ZZ = fVar.ZZ("contact_info_floatbottle_clear_data");
        if (ZZ != null) {
            this.eQe.put("contact_info_floatbottle_clear_data", ZZ);
        }
        preferenceCategory = (PreferenceCategory) fVar.ZZ("contact_info_floatbottle_hide_cat2");
        if (preferenceCategory != null) {
            this.eQe.put("contact_info_floatbottle_hide_cat2", preferenceCategory);
        }
        preferenceCategory = (PreferenceCategory) fVar.ZZ("contact_info_floatbottle_hide_cat3");
        if (preferenceCategory != null) {
            this.eQe.put("contact_info_floatbottle_hide_cat3", preferenceCategory);
        }
        ZZ = fVar.ZZ("contact_info_floatbottle_install");
        if (ZZ != null) {
            this.eQe.put("contact_info_floatbottle_install", ZZ);
        }
        ZZ = fVar.ZZ("contact_info_floatbottle_uninstall");
        if (ZZ != null) {
            this.eQe.put("contact_info_floatbottle_uninstall", ZZ);
        }
        auv();
        return true;
    }

    private void auv() {
        int i = 1;
        this.status = q.GJ();
        this.bKe = (q.GQ() & 64) == 0;
        this.eOE.removeAll();
        if (this.eQe.containsKey("contact_info_header_helper")) {
            this.eOE.a((HelperHeaderPreference) this.eQe.get("contact_info_header_helper"));
            HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.eOE.ZZ("contact_info_header_helper");
            helperHeaderPreference.an(this.guS.field_username, this.guS.BL(), this.context.getString(R.l.contact_info_floatbottle_tip));
            if (!this.bKe) {
                i = 0;
            }
            helperHeaderPreference.nw(i);
        }
        if (this.eQe.containsKey("contact_info_floatbottle_hide_cat")) {
            this.eOE.a((Preference) this.eQe.get("contact_info_floatbottle_hide_cat"));
        }
        if (this.bKe) {
            if (this.eQe.containsKey("contact_info_goto_floatbottle")) {
                this.eOE.a((Preference) this.eQe.get("contact_info_goto_floatbottle"));
            }
            if (this.eQe.containsKey("contact_info_floatbottle_clear_data")) {
                this.eOE.a((Preference) this.eQe.get("contact_info_floatbottle_clear_data"));
            }
            if (this.eQe.containsKey("contact_info_floatbottle_hide_cat2")) {
                this.eOE.a((Preference) this.eQe.get("contact_info_floatbottle_hide_cat2"));
            }
            if (this.eQe.containsKey("contact_info_floatbottle_uninstall")) {
                this.eOE.a((Preference) this.eQe.get("contact_info_floatbottle_uninstall"));
            }
        } else if (this.eQe.containsKey("contact_info_floatbottle_install")) {
            this.eOE.a((Preference) this.eQe.get("contact_info_floatbottle_install"));
        }
    }

    public static void m(Context context, boolean z) {
        String string = z ? context.getString(R.l.settings_plugins_installing) : context.getString(R.l.settings_plugins_uninstalling);
        context.getString(R.l.app_tip);
        new Timer().schedule(new 4(h.a(context, string, true, null), new 3(z)), 1500);
    }

    public final boolean auw() {
        au.HU();
        c.DT().b(this);
        com.tencent.mm.plugin.bottle.a.ezo.vl();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        x.d("MicroMsg.ContactWidgetFloatBottle", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(p), mVar});
        au.HU();
        if (mVar != c.DT() || p <= 0) {
            x.e("MicroMsg.ContactWidgetFloatBottle", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(p), mVar});
        } else if (p == 40 || p == 34 || p == 7) {
            auv();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
