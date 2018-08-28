package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.applet.s.2;
import com.tencent.mm.pluginsdk.ui.applet.s.5;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.storage.ab;

class s$2$1 implements a {
    final /* synthetic */ 2 qJN;

    s$2$1(2 2) {
        this.qJN = 2;
    }

    public final boolean vD() {
        if (this.qJN.qJM.eIU != null) {
            s sVar = this.qJN.qJM;
            String trim = this.qJN.qJM.meN.getText().toString().trim();
            Context context = sVar.context;
            sVar.context.getString(h.app_tip);
            sVar.tipDialog = com.tencent.mm.ui.base.h.a(context, sVar.context.getString(h.sendrequest_sending), true, new 5(sVar));
            sVar.content = trim;
            if (sVar.qJJ.size() == 1 && ab.XR((String) sVar.qJJ.getFirst())) {
                sVar.cdY();
            } else {
                g.Eh().dpP.a(new m(2, sVar.qJJ, sVar.mjw, trim, ""), 0);
            }
        }
        return false;
    }
}
