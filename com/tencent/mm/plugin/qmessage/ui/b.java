package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.aq.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.r;
import java.util.Timer;
import junit.framework.Assert;

public final class b implements a, com.tencent.mm.sdk.e.m.b {
    Context context;
    private f eOE;
    private ab guS;
    private boolean lUD;

    public b(Context context) {
        this.context = context;
    }

    public final boolean wX(String str) {
        x.d("MicroMsg.ContactWidgetQMessage", "handleEvent : key = " + str);
        if (bi.oV(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent(this.context, QConversationUI.class);
            if (this.lUD) {
                ((Activity) this.context).setResult(-1, intent);
            } else {
                this.context.startActivity(intent);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qmessage_recv_offline_msg")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ(str);
            if (checkBoxPreference.isChecked()) {
                e(64, true, 5);
            } else if (uS(8192)) {
                h.a(this.context, R.l.contact_info_qmessage_close_weixin_online_tip, R.l.app_tip, new 1(this), new 2(this, checkBoxPreference));
            } else {
                e(64, false, 5);
                return true;
            }
            return true;
        } else if (str.equals("contact_info_qmessage_display_weixin_online")) {
            e(8192, ((CheckBoxPreference) this.eOE.ZZ(str)).isChecked(), 12);
            return true;
        } else if (str.equals("contact_info_qmessage_clear_data")) {
            h.a(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 3(this), null);
            return true;
        } else if (str.equals("contact_info_qmessage_install")) {
            au.HU();
            if (bi.f((Integer) c.DT().get(9, null)) == 0) {
                h.b(this.context, R.l.settings_weibo_notice, R.l.app_tip, new 4(this), new 5(this));
                return true;
            }
            m(this.context, true);
            return true;
        } else if (str.equals("contact_info_qmessage_uninstall")) {
            h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 6(this), null);
            return true;
        } else {
            x.e("MicroMsg.ContactWidgetQMessage", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public static void m(Context context, final boolean z) {
        String string = z ? context.getString(R.l.settings_plugins_installing) : context.getString(R.l.settings_plugins_uninstalling);
        context.getString(R.l.app_tip);
        new Timer().schedule(new 8(h.a(context, string, true, null), new ag() {
            final /* synthetic */ r hlE = null;

            public final void handleMessage(Message message) {
                int i;
                b.e(64, z, 5);
                b.e(8192, z, 12);
                int GQ = q.GQ();
                if (z) {
                    i = GQ & -33;
                } else {
                    i = GQ | 32;
                }
                au.HU();
                c.DT().set(34, Integer.valueOf(i));
                au.HU();
                c.FQ().b(new l("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    g.boe();
                }
                if (this.hlE != null) {
                    this.hlE.a(null, null);
                }
            }
        }), 5000);
    }

    private static boolean uS(int i) {
        return (q.GJ() & i) != 0;
    }

    public final boolean a(f fVar, ab abVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(abVar != null);
        Assert.assertTrue(s.hm(abVar.field_username));
        if (fVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        au.HU();
        c.DT().a(this);
        this.guS = abVar;
        this.lUD = z;
        this.eOE = fVar;
        auv();
        return true;
    }

    final void auv() {
        int i = 1;
        int i2 = (q.GQ() & 32) == 0 ? 1 : 0;
        boolean uS = uS(64);
        uS(8192);
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(R.o.contact_info_pref_qmessage);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.eOE.ZZ("contact_info_header_helper");
        helperHeaderPreference.an(this.guS.field_username, this.guS.BL(), this.context.getString(R.l.contact_info_qmessage_tip));
        if (i2 == 0) {
            i = 0;
        }
        helperHeaderPreference.nw(i);
        if (i2 == 0) {
            this.eOE.aaa("contact_info_view_message");
            this.eOE.aaa("contact_info_qmessage_recv_offline_msg");
            this.eOE.aaa("contact_info_qmessage_uninstall");
            this.eOE.aaa("contact_info_qmessage_clear_data");
            return;
        }
        this.eOE.aaa("contact_info_qmessage_install");
        ((CheckBoxPreference) this.eOE.ZZ("contact_info_qmessage_recv_offline_msg")).qpJ = uS;
    }

    static void e(int i, boolean z, int i2) {
        int GJ = q.GJ();
        if (z) {
            GJ |= i;
        } else {
            GJ &= i ^ -1;
        }
        au.HU();
        c.DT().set(7, Integer.valueOf(GJ));
        GJ = z ? 1 : 2;
        au.HU();
        c.FQ().b(new com.tencent.mm.aq.g(i2, GJ));
    }

    public final boolean auw() {
        au.HU();
        c.DT().b(this);
        com.tencent.mm.plugin.qmessage.a.mbs.vl();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        au.HU();
        if (mVar == c.DT()) {
            auv();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
