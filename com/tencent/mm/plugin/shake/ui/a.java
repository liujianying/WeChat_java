package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.model.aq;
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
import com.tencent.mm.ui.base.preference.f;
import java.util.Timer;
import junit.framework.Assert;

public final class a implements aq, com.tencent.mm.pluginsdk.b.a, b {
    Context context;
    private f eOE;
    private ab guS;

    public a(Context context) {
        this.context = context;
    }

    public final boolean wX(String str) {
        x.d("MicroMsg.ContactWidgetShake", "handleEvent : key = " + str);
        if (bi.oV(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_shake_go_shake")) {
            Intent intent = new Intent();
            intent.setClass(this.context, ShakeReportUI.class);
            this.context.startActivity(intent);
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_shake_install")) {
            m(this.context, true);
            return true;
        } else if (str.equals("contact_info_shake_uninstall")) {
            h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 1(this), null);
            return true;
        } else {
            x.e("MicroMsg.ContactWidgetShake", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(s.ht(abVar.field_username));
        au.HU();
        c.DT().a(this);
        au.HU();
        c.a(this);
        this.guS = abVar;
        this.eOE = fVar;
        fVar.addPreferencesFromResource(R.o.contact_info_pref_shake);
        auv();
        return true;
    }

    private void auv() {
        boolean z;
        boolean z2 = true;
        boolean z3 = (q.GQ() & 256) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.eOE.ZZ("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            int i;
            helperHeaderPreference.an(this.guS.field_username, this.guS.BL(), this.context.getString(R.l.contact_info_shake_tip));
            if (z3) {
                i = 1;
            } else {
                i = 0;
            }
            helperHeaderPreference.nw(i);
        }
        this.eOE.bw("contact_info_shake_install", z3);
        f fVar = this.eOE;
        String str = "contact_info_shake_go_shake";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bw(str, z);
        f fVar2 = this.eOE;
        String str2 = "contact_info_shake_uninstall";
        if (z3) {
            z2 = false;
        }
        fVar2.bw(str2, z2);
    }

    public static void m(Context context, boolean z) {
        String string = z ? context.getString(R.l.settings_plugins_installing) : context.getString(R.l.settings_plugins_uninstalling);
        context.getString(R.l.app_tip);
        new Timer().schedule(new 3(h.a(context, string, true, null), new 2(z)), 1500);
    }

    public final boolean auw() {
        au.HU();
        c.DT().b(this);
        au.HU();
        c.b(this);
        com.tencent.mm.plugin.shake.a.ezo.vl();
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void HK() {
        auv();
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        x.d("MicroMsg.ContactWidgetShake", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(p), mVar});
        au.HU();
        if (mVar != c.DT() || p <= 0) {
            x.e("MicroMsg.ContactWidgetShake", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(p), mVar});
        } else if (p == 7 || p == 34) {
            auv();
        }
    }
}
