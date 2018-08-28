package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class m implements a, b {
    private boolean bKe;
    Context context;
    private f eOE;
    private ab guS;

    public m(Context context) {
        this.context = context;
    }

    public final boolean wX(String str) {
        if (bi.oV(str).length() <= 0) {
            return false;
        }
        if ("contact_info_go_to_sync".equals(str)) {
            if (p.r(this.context, "com.tencent.qqpim")) {
                Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
                launchIntentForPackage.addFlags(268435456);
                this.context.startActivity(launchIntentForPackage);
            } else {
                h.a(this.context, R.l.contact_info_qqsync_download, R.l.app_tip, R.l.app_download, R.l.app_cancel, new 2(this), null);
            }
            return true;
        } else if ("contact_info_remind_me_syncing".equals(str)) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_info_remind_me_syncing");
            au.HU();
            c.DT().set(65792, Boolean.valueOf(checkBoxPreference.isChecked()));
            br.r(6, checkBoxPreference.isChecked() ? "1" : "2");
            return true;
        } else if (str.equals("contact_info_qqsync_install")) {
            p(this.context, true);
            return true;
        } else if (!str.equals("contact_info_qqsync_uninstall")) {
            return false;
        } else {
            h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 1(this), null);
            return true;
        }
    }

    final void p(Context context, boolean z) {
        String string = z ? context.getString(R.l.settings_plugins_installing) : context.getString(R.l.settings_plugins_uninstalling);
        context.getString(R.l.app_tip);
        au.Em().H(new 3(this, z, h.a(context, string, true, null)));
    }

    public final boolean a(f fVar, ab abVar, boolean z, int i) {
        au.HU();
        c.DT().a(this);
        this.eOE = fVar;
        this.guS = abVar;
        fVar.addPreferencesFromResource(R.o.contact_info_pref_qqsync);
        auv();
        return true;
    }

    public final boolean auw() {
        au.HU();
        c.DT().b(this);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (this.bKe != q.Ha()) {
            auv();
        }
    }

    private void auv() {
        boolean z;
        boolean z2 = true;
        this.bKe = q.Ha();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.eOE.ZZ("contact_info_header_helper");
        helperHeaderPreference.an(this.guS.field_username, this.guS.BL(), this.context.getString(R.l.contact_info_qqsync_switch_tip));
        helperHeaderPreference.nw(this.bKe ? 1 : 0);
        f fVar = this.eOE;
        String str = "contact_info_go_to_sync";
        if (this.bKe) {
            z = false;
        } else {
            z = true;
        }
        fVar.bw(str, z);
        fVar = this.eOE;
        str = "contact_info_remind_me_syncing_tip";
        if (this.bKe) {
            z = false;
        } else {
            z = true;
        }
        fVar.bw(str, z);
        this.eOE.bw("contact_info_qqsync_install", this.bKe);
        f fVar2 = this.eOE;
        String str2 = "contact_info_qqsync_uninstall";
        if (this.bKe) {
            z2 = false;
        }
        fVar2.bw(str2, z2);
    }
}
