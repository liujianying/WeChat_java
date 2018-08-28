package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ServiceNotifySettingsUI.a;
import com.tencent.mm.ui.ServiceNotifySettingsUI.a.1;

class ServiceNotifySettingsUI$a$1$1 implements OnClickListener {
    final /* synthetic */ String dhF;
    final /* synthetic */ 1 tqm;

    ServiceNotifySettingsUI$a$1$1(1 1, String str) {
        this.tqm = 1;
        this.dhF = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = 0;
        while (i2 < a.a(this.tqm.tql).size()) {
            a.a aVar = (a.a) a.a(this.tqm.tql).get(i2);
            if (aVar == null || !this.dhF.equals(aVar.username)) {
                i2++;
            } else {
                a.b(this.tqm.tql).add(a.a(this.tqm.tql).remove(i2));
                this.tqm.tql.notifyDataSetChanged();
                WxaAttributes rR = ((c) g.l(c.class)).rR(this.dhF);
                String str = rR == null ? "" : rR.field_appId;
                if (this.tqm.tqk == 1) {
                    x.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", new Object[]{Integer.valueOf(13798), Integer.valueOf(4), str, a.c(this.tqm.tql)});
                    h.mEJ.h(13798, new Object[]{Integer.valueOf(4), str, Integer.valueOf(0), a.c(this.tqm.tql), Long.valueOf(bi.VE())});
                    return;
                }
                h.mEJ.h(13796, new Object[]{Integer.valueOf(12), str, "", Integer.valueOf(0), Long.valueOf(bi.VE())});
                return;
            }
        }
    }
}
