package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.mm.az.d;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.x;

class NormalUserFooterPreference$c$3 implements a {
    final /* synthetic */ c lXI;

    NormalUserFooterPreference$c$3(c cVar) {
        this.lXI = cVar;
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        if (z) {
            this.lXI.lXw.dHn.ci("hide_btn");
            this.lXI.lXw.dHn.doNotify();
            NormalUserFooterPreference.v(this.lXI.lXw);
            c.a(this.lXI);
        } else if (z2) {
            d.SF().db(str, 2);
        } else {
            x.e("MicroMsg.NormalUserFooterPreference", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = " + str);
        }
        if (z || z2) {
            Intent intent = NormalUserFooterPreference.b(this.lXI.lXw).getIntent();
            int intExtra = intent.getIntExtra("search_kvstat_scene", 0);
            int intExtra2 = intent.getIntExtra("search_kvstat_position", 0);
            if (intExtra > 0 && intExtra2 > 0) {
                h.mEJ.h(10991, new Object[]{Integer.valueOf(intExtra), Integer.valueOf(6), Integer.valueOf(intExtra2)});
            }
        }
    }
}
