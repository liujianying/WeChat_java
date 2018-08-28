package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

abstract class l implements a, b {
    protected Context context;
    protected f eOE;
    protected ab guS;
    protected HelperHeaderPreference$a lWG;

    protected abstract int Ys();

    protected abstract boolean bnv();

    protected abstract void clear();

    protected abstract void hb(boolean z);

    public l(Context context, HelperHeaderPreference$a helperHeaderPreference$a) {
        this.context = context;
        this.lWG = helperHeaderPreference$a;
    }

    public void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        x.d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(p), mVar});
        au.HU();
        if (mVar != c.DT() || p <= 0) {
            x.e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(p), mVar});
        } else if (p == 40 || p == 34 || p == 7) {
            auv();
        }
    }

    public boolean a(f fVar, ab abVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        Assert.assertTrue(abVar != null);
        if (bi.oV(abVar.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (fVar != null) {
            z3 = true;
        }
        Assert.assertTrue(z3);
        au.HU();
        c.DT().a(this);
        this.guS = abVar;
        this.eOE = fVar;
        auv();
        return true;
    }

    public boolean auw() {
        au.HU();
        c.DT().b(this);
        this.eOE.ZZ("contact_info_header_helper");
        return true;
    }

    public boolean wX(String str) {
        if ("contact_info_plugin_clear_data".equals(str)) {
            h.a(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 1(this), null);
            return true;
        } else if (str.equals("contact_info_plugin_install")) {
            hb(true);
            return true;
        } else if (str.equals("contact_info_plugin_uninstall")) {
            h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 2(this), null);
            return true;
        } else {
            x.e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = " + str);
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    private void auv() {
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(Ys());
        boolean bnv = bnv();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.eOE.ZZ("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            helperHeaderPreference.a(this.guS, this.lWG);
        }
        if (bnv) {
            this.eOE.aaa("contact_info_plugin_install");
            return;
        }
        this.eOE.aaa("contact_info_plugin_view");
        this.eOE.aaa("contact_info_plugin_clear_data");
        this.eOE.aaa("contact_info_plugin_uninstall");
    }
}
