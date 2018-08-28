package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.b.a, b {
    Context context;
    private f eOE;
    private Map<String, Preference> eQe = new HashMap();
    private ab guS;

    public a(Context context) {
        this.context = context;
    }

    public final boolean wX(String str) {
        x.d("MicroMsg.ContactWidgetMassSend", "handleEvent : key = " + str);
        if (bi.oV(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_masssend_view")) {
            this.context.startActivity(new Intent(this.context, MassSendHistoryUI.class));
            return true;
        } else if (str.equals("contact_info_masssend_clear_data")) {
            h.a(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 1(this), null);
            return true;
        } else if (str.equals("contact_info_masssend_install")) {
            m(this.context, true);
            return true;
        } else if (str.equals("contact_info_masssend_uninstall")) {
            h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 2(this), null);
            return true;
        } else {
            x.e("MicroMsg.ContactWidgetMassSend", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(s.ho(abVar.field_username));
        au.HU();
        c.DT().a(this);
        this.guS = abVar;
        this.eOE = fVar;
        fVar.addPreferencesFromResource(R.o.contact_info_pref_masssend);
        auv();
        return true;
    }

    private void auv() {
        int i;
        boolean z;
        boolean z2 = true;
        boolean z3 = (q.GQ() & 65536) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.eOE.ZZ("contact_info_masssend_header_helper");
        helperHeaderPreference.an(this.guS.field_username, this.guS.BL(), this.context.getString(R.l.contact_info_masssend_tip));
        if (z3) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.nw(i);
        this.eOE.bw("contact_info_masssend_install", z3);
        f fVar = this.eOE;
        String str = "contact_info_masssend_view";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bw(str, z);
        fVar = this.eOE;
        str = "contact_info_masssend_clear_data";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bw(str, z);
        f fVar2 = this.eOE;
        String str2 = "contact_info_masssend_uninstall";
        if (z3) {
            z2 = false;
        }
        fVar2.bw(str2, z2);
    }

    public static void m(Context context, boolean z) {
        String string = z ? context.getString(R.l.settings_plugins_installing) : context.getString(R.l.settings_plugins_uninstalling);
        context.getString(R.l.app_tip);
        final p a = h.a(context, string, true, null);
        final 3 3 = new 3(z);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    3.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public static void acV() {
        com.tencent.mm.plugin.masssend.a.b bco = com.tencent.mm.plugin.masssend.a.h.bco();
        if (bco.dCZ.fV("massendinfo", "delete from massendinfo")) {
            bco.doNotify();
        }
        au.HU();
        c.FW().Yp("masssendapp");
    }

    public final boolean auw() {
        au.HU();
        c.DT().b(this);
        com.tencent.mm.plugin.masssend.a.ezo.vl();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        x.d("MicroMsg.ContactWidgetMassSend", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(p), mVar});
        au.HU();
        if (mVar != c.DT() || p <= 0) {
            x.e("MicroMsg.ContactWidgetMassSend", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(p), mVar});
        } else if (p == 40 || p == 34 || p == 7) {
            auv();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
