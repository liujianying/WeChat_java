package com.tencent.mm.plugin.sns.model;

import android.content.SharedPreferences.Editor;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.an;

class af$11 extends c<lw> {
    final /* synthetic */ af nqT;

    af$11(af afVar) {
        this.nqT = afVar;
        this.sFo = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = true;
        int i = g.AT().getInt("SnsHEVCSwitch", 0);
        int i2 = g.AT().getInt("SnsWXPCSwitch", 0);
        boolean z2 = i == 1;
        if (i2 != 1) {
            z = false;
        }
        Editor edit = an.m(ad.getContext(), "sp_sns_dynswitch_stg", 4).edit();
        edit.putBoolean("sw_use_vcodec_img", z2);
        edit.putBoolean("sw_use_wxpc_img", z);
        edit.commit();
        return false;
    }
}
