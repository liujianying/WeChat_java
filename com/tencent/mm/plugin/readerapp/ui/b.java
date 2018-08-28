package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.readerapp.c.c;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Timer;
import junit.framework.Assert;

public final class b implements a, com.tencent.mm.sdk.e.m.b {
    Context context;
    private f eOE;
    private ab guS;

    public b(Context context) {
        this.context = context;
    }

    static void hm(boolean z) {
        int GL = q.GL();
        if (z) {
            GL &= -1025;
        } else {
            GL |= 1024;
        }
        g.Ei().DT().set(40, Integer.valueOf(GL));
        ((i) g.l(i.class)).FQ().b(new com.tencent.mm.aq.g(26, z ? 2 : 1));
    }

    public final boolean wX(String str) {
        boolean z = false;
        x.d("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : key = " + str);
        if (bi.oV(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_readerappnews_view")) {
            Intent intent = new Intent(this.context, ReaderAppUI.class);
            intent.putExtra("type", 20);
            this.context.startActivity(intent);
            com.tencent.mm.plugin.readerapp.b.a.ezo.vl();
            return true;
        } else if (str.equals("contact_info_readerappnews_subscribe")) {
            this.context.startActivity(new Intent(this.context, ReaderAppSubscribeUI.class));
            return true;
        } else if (str.equals("contact_info_readerappnews_clear_data")) {
            h.a(this.context, this.context.getString(com.tencent.mm.plugin.readerapp.a.g.contact_info_clear_data_alert), "", this.context.getString(com.tencent.mm.plugin.readerapp.a.g.app_clear), this.context.getString(com.tencent.mm.plugin.readerapp.a.g.app_cancel), new 1(this), null);
            return true;
        } else if (str.equals("contact_info_readerappnews_recv_remind")) {
            boolean z2;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ(str);
            boolean bpR = c.bpR();
            if (bpR) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(15413, new Object[]{Integer.valueOf(6), "", ""});
            } else {
                com.tencent.mm.plugin.report.service.h.mEJ.h(15413, new Object[]{Integer.valueOf(7), "", ""});
            }
            if (bpR) {
                z2 = false;
            } else {
                z2 = true;
            }
            checkBoxPreference.qpJ = z2;
            if (!bpR) {
                z = true;
            }
            hm(z);
            return true;
        } else if (str.equals("contact_info_readerappnews_install")) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(15413, new Object[]{Integer.valueOf(5), "", ""});
            m(this.context, true);
            return true;
        } else if (str.equals("contact_info_readerappnews_uninstall")) {
            h.a(this.context, this.context.getString(com.tencent.mm.plugin.readerapp.a.g.settings_plugins_uninstall_hint), "", this.context.getString(com.tencent.mm.plugin.readerapp.a.g.app_clear), this.context.getString(com.tencent.mm.plugin.readerapp.a.g.app_cancel), new 2(this), null);
            return true;
        } else {
            x.e("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(s.hv(abVar.field_username));
        g.Ei().DT().a(this);
        this.guS = abVar;
        this.eOE = fVar;
        auv();
        return true;
    }

    private void auv() {
        int i = 1;
        int i2 = (q.GQ() & 524288) == 0 ? 1 : 0;
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(com.tencent.mm.plugin.readerapp.a.h.contact_info_pref_readerappnews);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.eOE.ZZ("contact_info_header_helper");
        helperHeaderPreference.an(this.guS.field_username, this.guS.BL(), this.context.getString(com.tencent.mm.plugin.readerapp.a.g.contact_info_readerappnews_tip));
        if (i2 == 0) {
            i = 0;
        }
        helperHeaderPreference.nw(i);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_info_readerappnews_recv_remind");
        boolean bpR = c.bpR();
        x.d("MicroMsg.ContactWidgetReaderAppNews", "wantToReceiveNews = " + bpR);
        checkBoxPreference.qpJ = bpR;
        if (i2 != 0) {
            this.eOE.aaa("contact_info_readerappnews_install");
            return;
        }
        this.eOE.aaa("contact_info_readerappnews_subscribe");
        this.eOE.aaa("contact_info_readerappnews_view");
        this.eOE.aaa("contact_info_readerappnews_clear_data");
        this.eOE.aaa("contact_info_readerappnews_uninstall");
        this.eOE.aaa("contact_info_readerappnews_recv_remind");
    }

    public static void m(Context context, boolean z) {
        String string = z ? context.getString(com.tencent.mm.plugin.readerapp.a.g.settings_plugins_installing) : context.getString(com.tencent.mm.plugin.readerapp.a.g.settings_plugins_uninstalling);
        context.getString(com.tencent.mm.plugin.readerapp.a.g.app_tip);
        new Timer().schedule(new 4(h.a(context, string, true, null), new 3(z, context)), 5000);
    }

    public final boolean auw() {
        g.Ei().DT().b(this);
        com.tencent.mm.plugin.readerapp.b.a.ezo.vl();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        x.d("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(p), mVar});
        if (mVar != g.Ei().DT() || p <= 0) {
            x.e("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(p), mVar});
        } else if (p == 40 || p == 34 || p == 7) {
            auv();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
