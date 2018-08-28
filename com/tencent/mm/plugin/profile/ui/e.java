package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.al.b;
import com.tencent.mm.aq.g;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class e implements a {
    Context context;
    private f eOE;
    private ab guS;
    boolean isDeleteCancel = false;
    private boolean lUD;
    private HelperHeaderPreference.a lVY;
    private int status;
    p tipDialog = null;

    public e(Context context) {
        this.context = context;
        this.lVY = new o(context);
        this.status = -1;
    }

    public final boolean wX(String str) {
        boolean z = false;
        x.d("MicroMsg.ContactWidgetFMessage", "handlerEvent : key = " + str);
        if (bi.oV(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_recommend_qqfriends_to_me")) {
            boolean z2;
            if (((CheckBoxPreference) this.eOE.ZZ("contact_info_recommend_qqfriends_to_me")).isChecked()) {
                z2 = false;
            } else {
                z2 = true;
            }
            b(z2, 128, 6);
            return true;
        } else if (str.equals("contact_info_recommend_mobilefriends_to_me")) {
            if (!((CheckBoxPreference) this.eOE.ZZ("contact_info_recommend_mobilefriends_to_me")).isChecked()) {
                z = true;
            }
            b(z, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.CTRL_BYTE, 7);
            return true;
        } else if (str.equals("contact_info_recommend_fbfriends_to_me")) {
            z = ((CheckBoxPreference) this.eOE.ZZ("contact_info_recommend_fbfriends_to_me")).isChecked();
            x.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + z + " item value = 4 functionId = 18");
            int GL = q.GL();
            GL = z ? GL | 4 : GL & -5;
            au.HU();
            c.DT().set(40, Integer.valueOf(GL));
            GL = z ? 1 : 2;
            au.HU();
            c.FQ().b(new g(18, GL));
            return true;
        } else if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent();
            if (this.lUD) {
                intent.putExtra("Chat_User", this.guS.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
                ((Activity) this.context).finish();
                return true;
            }
            intent.putExtra("Chat_User", this.guS.field_username);
            intent.putExtra("Chat_Mode", 1);
            intent.addFlags(67108864);
            com.tencent.mm.plugin.profile.a.ezn.e(intent, this.context);
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_bind_mobile_entry")) {
            com.tencent.mm.plugin.profile.a.ezn.g(new Intent(), this.context);
            return true;
        } else if (str.equals("contact_info_bind_qq_entry")) {
            com.tencent.mm.plugin.profile.a.ezn.h(new Intent(), this.context);
            return true;
        } else if (str.equals("contact_info_bind_fb_entry")) {
            d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
            return true;
        } else if (str.equals("contact_info_fmessage_clear_data")) {
            h.a(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    e eVar = e.this;
                    eVar.isDeleteCancel = false;
                    Context context = eVar.context;
                    eVar.context.getString(R.l.app_tip);
                    eVar.tipDialog = h.a(context, eVar.context.getString(R.l.app_waiting), true, new 2(eVar));
                    bd.a("fmessage", new 3(eVar));
                    au.HU();
                    c.FW().Yp("fmessage");
                }
            }, null);
            return true;
        } else {
            x.e("MicroMsg.ContactWidgetFMessage", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    private void b(boolean z, int i, int i2) {
        x.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        au.HU();
        c.DT().set(7, Integer.valueOf(this.status));
        int i3 = z ? 1 : 2;
        au.HU();
        c.FQ().b(new g(i2, i3));
    }

    public final boolean a(f fVar, ab abVar, boolean z, int i) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        Assert.assertTrue(fVar != null);
        if (abVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.hj(abVar.field_username));
        this.eOE = fVar;
        this.lUD = z;
        this.guS = abVar;
        if (this.status == -1) {
            this.status = q.GJ();
        }
        fVar.addPreferencesFromResource(R.o.contact_info_pref_fmessage);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.ZZ("contact_info_recommend_qqfriends_to_me");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) fVar.ZZ("contact_info_recommend_mobilefriends_to_me");
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) fVar.ZZ("contact_info_recommend_fbfriends_to_me");
        checkBoxPreference2.qpJ = !uL(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.CTRL_BYTE);
        if (uL(128)) {
            z3 = false;
        } else {
            z3 = true;
        }
        checkBoxPreference.qpJ = z3;
        if ((q.GL() & 4) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        checkBoxPreference3.qpJ = z3;
        ((HelperHeaderPreference) fVar.ZZ("contact_info_header_helper")).a(abVar, this.lVY);
        au.HU();
        if (bi.f((Integer) c.DT().get(9, null)) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            fVar.c(fVar.ZZ("contact_info_bind_qq_entry"));
            fVar.c(fVar.ZZ("contact_info_bind_qq_entry_tip"));
        } else {
            fVar.c(checkBoxPreference);
            if (!b.PB()) {
                fVar.c(fVar.ZZ("contact_info_bind_qq_entry"));
                fVar.c(fVar.ZZ("contact_info_bind_qq_entry_tip"));
            }
        }
        if (l.XC() == l.a.eKt) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            fVar.c(fVar.ZZ("contact_info_bind_mobile_entry"));
            fVar.c(fVar.ZZ("contact_info_bind_mobile_entry_tip"));
        } else {
            fVar.c(checkBoxPreference2);
            fVar.ZZ("contact_info_bind_mobile_entry").setSummary(R.l.settings_bind_qq_unbind);
        }
        if ((q.GQ() & 8192) == 0) {
            z4 = true;
        }
        if (z4) {
            z2 = q.Hg();
            fVar.c(checkBoxPreference3);
            if (z2) {
                fVar.ZZ("contact_info_bind_fb_entry").setSummary(R.l.contact_info_facebookapp_bind_success);
            } else {
                fVar.ZZ("contact_info_bind_fb_entry").setSummary(R.l.settings_bind_qq_unbind);
            }
        } else {
            fVar.c(fVar.ZZ("contact_info_bind_fb_entry"));
            fVar.c(fVar.ZZ("contact_info_bind_fb_entry_tip"));
            fVar.c(checkBoxPreference3);
        }
        return true;
    }

    private boolean uL(int i) {
        return (this.status & i) != 0;
    }

    public final boolean auw() {
        com.tencent.mm.plugin.profile.a.ezo.vl();
        this.eOE.ZZ("contact_info_header_helper");
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
