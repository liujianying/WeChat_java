package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;

public final class g extends l implements b {
    public final /* bridge */ /* synthetic */ void a(int i, m mVar, Object obj) {
        super.a(i, mVar, obj);
    }

    public final /* bridge */ /* synthetic */ boolean a(f fVar, ab abVar, boolean z, int i) {
        return super.a(fVar, abVar, z, i);
    }

    public final /* bridge */ /* synthetic */ boolean auw() {
        return super.auw();
    }

    public final /* bridge */ /* synthetic */ void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public g(Context context) {
        super(context, new q(context));
        a.sFg.m(new ht());
    }

    public static void acV() {
        au.HU();
        c.FT().GK("feedsapp");
        au.HU();
        c.FW().Yp("feedsapp");
    }

    protected final void clear() {
        acV();
    }

    protected final void hb(boolean z) {
        Context context = this.context;
        String string = z ? context.getString(R.l.settings_plugins_installing) : context.getString(R.l.settings_plugins_uninstalling);
        context.getString(R.l.app_tip);
        new al(new 1(z, h.a(context, string, true, null)), false).J(1500, 1500);
    }

    protected final boolean bnv() {
        return (q.GQ() & 32768) == 0;
    }

    protected final int Ys() {
        return R.o.contact_info_pref_feedsapp;
    }

    public final boolean wX(String str) {
        Intent intent;
        if ("contact_info_plugin_view".equals(str)) {
            intent = new Intent();
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            d.b(this.context, "sns", ".ui.SnsTimeLineUI", intent);
            return true;
        }
        if ("contact_info_plugin_outsize".equals(str)) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4);
            d.b(this.context, "sns", ".ui.SnsBlackDetailUI", intent);
        }
        if ("contact_info_plugin_black".equals(str)) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 5);
            d.b(this.context, "sns", ".ui.SnsTagDetailUI", intent);
        }
        if (!str.equals("contact_info_plugin_uninstall")) {
            return super.wX(str);
        }
        h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint_by_sns), "", this.context.getString(R.l.app_stop), this.context.getString(R.l.app_cancel), new 2(this), null);
        return true;
    }
}
