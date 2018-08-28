package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
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
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Timer;
import junit.framework.Assert;

public final class j implements a, b {
    private static boolean isDeleteCancel = false;
    private Context context;
    private f eOE;
    private ab guS;

    static /* synthetic */ void dZ(Context context) {
        isDeleteCancel = false;
        context.getString(R.l.app_tip);
        bd.a("medianote", new 7(h.a(context, context.getString(R.l.app_waiting), true, new 6())));
        au.HU();
        c.FW().Yp("medianote");
    }

    public j(Context context) {
        this.context = context;
    }

    public final boolean wX(String str) {
        x.d("MicroMsg.ContactWidgetMediaNote", "handleEvent : key = " + str);
        if (bi.oV(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_medianote_view")) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", "medianote");
            com.tencent.mm.plugin.profile.a.ezn.e(intent, this.context);
            com.tencent.mm.plugin.profile.a.ezo.vl();
            return true;
        } else if (str.equals("contact_info_medianote_sync_to_qqmail")) {
            if (q.Hm()) {
                hc(((CheckBoxPreference) this.eOE.ZZ(str)).isChecked());
            } else {
                h.a(this.context, R.l.contact_info_medianote_sync_to_qqmail_alert_tip, R.l.contact_info_medianote_sync_to_qqmail, new 1(this), null);
                auv();
            }
            return true;
        } else if (str.equals("contact_info_medianote_clear_data")) {
            h.a(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 2(this), null);
            return true;
        } else if (str.equals("contact_info_medianote_install")) {
            m(this.context, true);
            return true;
        } else if (str.equals("contact_info_medianote_uninstall")) {
            h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 3(this), null);
            return true;
        } else {
            x.e("MicroMsg.ContactWidgetMediaNote", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(s.hu(abVar.field_username));
        au.HU();
        c.DT().a(this);
        this.guS = abVar;
        this.eOE = fVar;
        fVar.addPreferencesFromResource(R.o.contact_info_pref_medianote);
        auv();
        return true;
    }

    private void auv() {
        boolean z;
        int i;
        boolean z2;
        boolean z3 = true;
        boolean z4 = (q.GQ() & 16) == 0;
        int GJ = q.GJ();
        if (q.Hm()) {
            z = (GJ & 16384) != 0;
        } else {
            if ((GJ & 16384) != 0) {
                GJ &= -16385;
                au.HU();
                c.DT().set(7, Integer.valueOf(GJ));
            }
            z = false;
        }
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.eOE.ZZ("contact_info_header_helper");
        helperHeaderPreference.an(this.guS.field_username, this.guS.BL(), this.context.getString(R.l.contact_info_medianote_tip));
        if (z4) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.nw(i);
        this.eOE.bw("contact_info_medianote_install", z4);
        f fVar = this.eOE;
        String str = "contact_info_medianote_view";
        if (z4) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.bw(str, z2);
        if (!z4 || q.Hm()) {
            z2 = z4;
        } else {
            if (bi.getInt(g.AT().getValue("BindQQSwitch"), 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            x.i("MicroMsg.ContactWidgetMediaNote", "summerqq BindQQSwitch off");
        }
        fVar = this.eOE;
        str = "contact_info_medianote_sync_to_qqmail";
        if (z2) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.bw(str, z2);
        fVar = this.eOE;
        str = "contact_info_medianote_clear_data";
        if (z4) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.bw(str, z2);
        f fVar2 = this.eOE;
        String str2 = "contact_info_medianote_uninstall";
        if (z4) {
            z3 = false;
        }
        fVar2.bw(str2, z3);
        ((CheckBoxPreference) this.eOE.ZZ("contact_info_medianote_sync_to_qqmail")).qpJ = z;
    }

    public static void m(Context context, boolean z) {
        String string = z ? context.getString(R.l.settings_plugins_installing) : context.getString(R.l.settings_plugins_uninstalling);
        context.getString(R.l.app_tip);
        new Timer().schedule(new 5(h.a(context, string, true, null), new 4(z, context)), 1500);
    }

    public final boolean auw() {
        au.HU();
        c.DT().b(this);
        com.tencent.mm.plugin.profile.a.ezo.vl();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        x.d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(p), mVar});
        au.HU();
        if (mVar != c.DT() || p <= 0) {
            x.e("MicroMsg.ContactWidgetMediaNote", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(p), mVar});
        } else if (p == 40 || p == 34 || p == 7) {
            auv();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    static void hc(boolean z) {
        int GJ = q.GJ();
        if (z) {
            GJ |= 16384;
        } else {
            GJ &= -16385;
        }
        au.HU();
        c.DT().set(7, Integer.valueOf(GJ));
        GJ = z ? 1 : 2;
        au.HU();
        c.FQ().b(new com.tencent.mm.aq.g(13, GJ));
    }
}
