package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import junit.framework.Assert;

public final class f implements a, b {
    Context context;
    private com.tencent.mm.ui.base.preference.f eOE;
    private Map<String, Preference> eQe = new HashMap();
    private ab guS;
    private HelperHeaderPreference.a lWa;

    public f(Context context) {
        this.context = context;
        this.lWa = new p(context);
        au.HU();
        c.FW().Ys("facebookapp");
    }

    public final boolean wX(String str) {
        x.d("MicroMsg.ContactWidgetFacebookapp", "handleEvent : key = " + str);
        if (bi.oV(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_facebookapp_install")) {
            m(this.context, true);
            return true;
        } else if (str.equals("contact_info_facebookapp_uninstall")) {
            h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 1(this), null);
            return true;
        } else if (str.equals("contact_info_facebookapp_listfriend")) {
            this.context.startActivity(new Intent(this.context, FacebookFriendUI.class));
            return true;
        } else if (str.equals("contact_info_facebookapp_connect")) {
            d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
            return true;
        } else if (str.equals("contact_info_facebookapp_addr")) {
            d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
            return true;
        } else {
            x.e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, ab abVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (abVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.hn(abVar.field_username));
        au.HU();
        c.DT().a(this);
        this.guS = abVar;
        this.eOE = fVar;
        fVar.addPreferencesFromResource(R.o.contact_info_pref_facebookapp);
        Preference ZZ = fVar.ZZ("contact_info_header_helper");
        if (ZZ != null) {
            this.eQe.put("contact_info_header_helper", ZZ);
        }
        ZZ = fVar.ZZ("contact_info_facebookapp_listfriend");
        if (ZZ != null) {
            this.eQe.put("contact_info_facebookapp_listfriend", ZZ);
        }
        ZZ = fVar.ZZ("contact_info_facebookapp_connect");
        if (ZZ != null) {
            this.eQe.put("contact_info_facebookapp_connect", ZZ);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) fVar.ZZ("contact_info_facebookapp_cat");
        if (preferenceCategory != null) {
            this.eQe.put("contact_info_facebookapp_cat", preferenceCategory);
        }
        ZZ = fVar.ZZ("contact_info_facebookapp_addr");
        if (ZZ != null) {
            this.eQe.put("contact_info_facebookapp_addr", ZZ);
        }
        preferenceCategory = (PreferenceCategory) fVar.ZZ("contact_info_facebookapp_cat2");
        if (preferenceCategory != null) {
            this.eQe.put("contact_info_facebookapp_cat2", preferenceCategory);
        }
        ZZ = fVar.ZZ("contact_info_facebookapp_install");
        if (ZZ != null) {
            this.eQe.put("contact_info_facebookapp_install", ZZ);
        }
        ZZ = fVar.ZZ("contact_info_facebookapp_uninstall");
        if (ZZ != null) {
            this.eQe.put("contact_info_facebookapp_uninstall", ZZ);
        }
        auv();
        return true;
    }

    private void auv() {
        this.eOE.removeAll();
        if (this.eQe.containsKey("contact_info_header_helper")) {
            HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.eQe.get("contact_info_header_helper");
            helperHeaderPreference.a(this.guS, this.lWa);
            this.eOE.a(helperHeaderPreference);
        }
        if (this.eQe.containsKey("contact_info_facebookapp_cat")) {
            this.eOE.a((Preference) this.eQe.get("contact_info_facebookapp_cat"));
        }
        if (((q.GQ() & 8192) == 0 ? 1 : null) != null) {
            if (q.Hg()) {
                if (this.eQe.containsKey("contact_info_facebookapp_addr")) {
                    this.eOE.a((Preference) this.eQe.get("contact_info_facebookapp_addr"));
                    Preference preference = (Preference) this.eQe.get("contact_info_facebookapp_addr");
                    au.HU();
                    preference.setSummary((String) c.DT().get(65826, null));
                }
            } else if (this.eQe.containsKey("contact_info_facebookapp_connect")) {
                this.eOE.a((Preference) this.eQe.get("contact_info_facebookapp_connect"));
            }
            if (this.eQe.containsKey("contact_info_facebookapp_cat2")) {
                this.eOE.a((Preference) this.eQe.get("contact_info_facebookapp_cat2"));
            }
            if (this.eQe.containsKey("contact_info_facebookapp_uninstall")) {
                this.eOE.a((Preference) this.eQe.get("contact_info_facebookapp_uninstall"));
            }
        } else if (this.eQe.containsKey("contact_info_facebookapp_install")) {
            this.eOE.a((Preference) this.eQe.get("contact_info_facebookapp_install"));
        }
    }

    public static void m(Context context, boolean z) {
        String string = z ? context.getString(R.l.settings_plugins_installing) : context.getString(R.l.settings_plugins_uninstalling);
        context.getString(R.l.app_tip);
        new Timer().schedule(new 3(h.a(context, string, true, null), new 2(z)), 1500);
    }

    public final boolean auw() {
        au.HU();
        c.DT().b(this);
        this.eQe.get("contact_info_header_helper");
        com.tencent.mm.plugin.profile.a.ezo.vl();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        x.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(p), mVar});
        au.HU();
        if (mVar != c.DT() || p <= 0) {
            x.e("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(p), mVar});
        } else if (p == 40 || p == 34 || p == 65825) {
            auv();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
