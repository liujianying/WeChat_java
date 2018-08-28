package com.tencent.mm.plugin.game;

import android.content.Context;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.game.a.a;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements a {
    public final boolean aSd() {
        try {
            boolean z;
            h aTL = h.aTL();
            if (aTL.jLN != null) {
                z = aTL.jLN.jRm;
            } else {
                aTL.Zy();
                x.i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", new Object[]{w.d(ad.getContext().getSharedPreferences(ad.chY(), 0))});
                x.i("MicroMsg.GameConfigManager", "hide game center:[%s]", new Object[]{bi.aG(g.AT().getValue("HideGameCenter"), "zh_CN".equals(w.d(ad.getContext().getSharedPreferences(ad.chY(), 0))) ? "0" : "1")});
                z = r0.equalsIgnoreCase("0");
            }
            x.i("MicroMsg.GameConfigManager", "getShowEntrance : " + z);
            return z;
        } catch (Exception e) {
            return true;
        }
    }

    public final void a(String str, String str2, int i, int i2, String str3, int i3) {
        an.a(str, str2, i, i2, str3, i3);
    }

    public final void a(Context context, String str, String str2, String str3, int i, String str4, int i2) {
        an.a(context, str, str2, str3, i, str4, i2);
    }

    public final void a(String str, String str2, int i, int i2, String str3, long j) {
        an.a(str, str2, i, i2, str3, j);
    }

    public final void S(String str, int i, int i2) {
        an.T(str, i, i2);
    }

    public final void P(String str, String str2, String str3) {
        an.P(str, str2, str3);
    }

    public final void q(Context context, String str, String str2) {
        an.q(context, str, str2);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5) {
        an.a(context, str, str2, str3, i, i2, i3, str4, 0, str5);
    }

    public final void dn(Context context) {
        f.dn(context);
    }
}
