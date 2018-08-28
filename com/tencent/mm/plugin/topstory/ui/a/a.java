package com.tencent.mm.plugin.topstory.ui.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.topstory.ui.b.h;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.c.bay;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class a implements com.tencent.mm.pluginsdk.b.a, b {
    private Context context;
    private f eOE;
    private ab guS;
    private CheckBoxPreference opR;

    public a(Context context) {
        this.context = context;
    }

    public final boolean a(f fVar, ab abVar, boolean z, int i) {
        this.eOE = fVar;
        this.guS = abVar;
        fVar.addPreferencesFromResource(h.contact_info_pref_top_story);
        g.Ei().DT().a(this);
        this.opR = (CheckBoxPreference) fVar.ZZ("contact_info_top_story_not_disturb");
        auv();
        return true;
    }

    public final boolean auw() {
        g.Ei().DT().b(this);
        return true;
    }

    public final boolean wX(String str) {
        if ("contact_info_go_to_top_story".equals(str)) {
            d.N(this.context, 0);
        } else if ("contact_info_top_story_install".equals(str)) {
            hh(true);
        } else if ("contact_info_top_story_uninstall".equals(str)) {
            com.tencent.mm.ui.base.h.a(this.context, this.context.getString(com.tencent.mm.plugin.topstory.ui.b.g.settings_plugins_uninstall_hint), "", this.context.getString(com.tencent.mm.plugin.topstory.ui.b.g.app_clear), this.context.getString(com.tencent.mm.plugin.topstory.ui.b.g.app_cancel), new 1(this), null);
        } else if ("contact_info_top_story_not_disturb".equals(str)) {
            int GL = q.GL();
            if (this.opR.isChecked()) {
                GL &= -16777217;
            } else {
                GL |= 16777216;
            }
            g.Ei().DT().set(40, Integer.valueOf(GL));
            xt xtVar = new xt();
            xtVar.rDz = 55;
            if (this.opR.isChecked()) {
                GL = 2;
            } else {
                GL = 1;
            }
            xtVar.rDA = GL;
            ((i) g.l(i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(55, xtVar));
        }
        return false;
    }

    final void hh(boolean z) {
        int GQ = q.GQ();
        if (z) {
            GQ &= -67108865;
        } else {
            GQ |= 67108864;
        }
        g.Ei().DT().set(34, Integer.valueOf(GQ));
        bay bay = new bay();
        bay.raB = 67108864;
        bay.sdm = z ? 0 : 1;
        ((i) g.l(i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(39, bay));
        auv();
        if (!z) {
            ((i) g.l(i.class)).FW().Yp("topstoryapp");
        } else if (((i) g.l(i.class)).FW().Yq("topstoryapp") == null) {
            ai aiVar = new ai();
            aiVar.setUsername("topstoryapp");
            aiVar.setContent(this.context.getString(com.tencent.mm.plugin.topstory.ui.b.g.contact_info_top_story_switch_tip));
            aiVar.as(bi.VF());
            aiVar.eX(0);
            aiVar.eV(0);
            ((i) g.l(i.class)).FW().d(aiVar);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    private void auv() {
        boolean z;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.eOE.ZZ("contact_info_header_helper");
        helperHeaderPreference.an(this.guS.field_username, this.guS.BL(), this.context.getString(com.tencent.mm.plugin.topstory.ui.b.g.contact_info_top_story_switch_tip));
        if ((q.GQ() & 67108864) == 0) {
            helperHeaderPreference.nw(1);
            this.eOE.bw("contact_info_top_story_install", true);
            this.eOE.bw("contact_info_top_story_uninstall", false);
            this.eOE.bw("contact_info_go_to_top_story", false);
            this.eOE.bw("contact_info_top_story_not_disturb", false);
        } else {
            helperHeaderPreference.nw(0);
            this.eOE.bw("contact_info_top_story_install", false);
            this.eOE.bw("contact_info_top_story_uninstall", true);
            this.eOE.bw("contact_info_go_to_top_story", true);
            this.eOE.bw("contact_info_top_story_not_disturb", true);
        }
        if ((q.GL() & 16777216) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.opR.qpJ = true;
        } else {
            this.opR.qpJ = false;
        }
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        if (mVar == g.Ei().DT() && p > 0) {
            if (p == 40 || p == 34 || p == 7) {
                auv();
            }
        }
    }
}
