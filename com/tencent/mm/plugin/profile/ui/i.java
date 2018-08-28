package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class i implements a, b {
    Context context;
    private f eOE;
    private ab guS;
    private HelperHeaderPreference.a lWg;

    public i(Context context) {
        this.context = context;
        this.lWg = new r(context);
    }

    public final boolean wX(String str) {
        x.d("MicroMsg.ContactWidgetLinkedIn", "handleEvent : key = " + str);
        if (bi.oV(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_linkedin_install")) {
            m(this.context, true);
            return true;
        } else if (str.equals("contact_info_linkedin_uninstall")) {
            h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    i.m(i.this.context, false);
                }
            }, null);
            return true;
        } else {
            if (str.equals("contact_info_linkedin_account")) {
                ((Activity) this.context).startActivityForResult(new Intent(this.context, BindLinkedInUI.class), 1);
            }
            x.e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(s.hA(abVar.field_username));
        au.HU();
        c.DT().a(this);
        this.guS = abVar;
        this.eOE = fVar;
        auv();
        return true;
    }

    private void auv() {
        boolean z = (q.GQ() & 16777216) == 0;
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(R.o.contact_info_pref_linkedin);
        ((HelperHeaderPreference) this.eOE.ZZ("contact_info_header_helper")).a(this.guS, this.lWg);
        if (z) {
            this.eOE.bw("contact_info_linkedin_account", false);
            this.eOE.aaa("contact_info_linkedin_install");
            return;
        }
        this.eOE.bw("contact_info_linkedin_account", true);
        this.eOE.aaa("contact_info_linkedin_uninstall");
    }

    public static void m(Context context, boolean z) {
        String string = z ? context.getString(R.l.settings_plugins_installing) : context.getString(R.l.settings_plugins_uninstalling);
        context.getString(R.l.app_tip);
        new al(new 2(h.a(context, string, true, null), z), false).J(1500, 1500);
    }

    public final boolean auw() {
        au.HU();
        c.DT().b(this);
        this.eOE.ZZ("contact_info_header_helper");
        com.tencent.mm.plugin.profile.a.ezo.vl();
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            auv();
        }
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 40 || intValue == 34) {
                auv();
            }
        }
    }
}
