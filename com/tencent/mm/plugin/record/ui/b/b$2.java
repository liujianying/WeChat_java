package com.tencent.mm.plugin.record.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import java.io.File;

class b$2 implements OnClickListener {
    final /* synthetic */ b mtF;

    b$2(b bVar) {
        this.mtF = bVar;
    }

    public final void onClick(View view) {
        if (f.zZ()) {
            b bVar = (b) view.getTag();
            vz vzVar = bVar.bOz.rAi.rAJ;
            if (b.e(bVar.bOz)) {
                x.i("MicroMsg.OtherViewWrapper", "same song, do release");
                com.tencent.mm.an.b.PW();
                if (!this.mtF.mtD) {
                    this.mtF.handler.sendMessageAtFrontOfQueue(this.mtF.handler.obtainMessage(1));
                    return;
                }
                return;
            }
            String absolutePath;
            this.mtF.mtD = true;
            File file = new File(h.f(bVar.bOz, bVar.bJC));
            if (file.exists()) {
                absolutePath = file.getAbsolutePath();
            } else if (bVar.bOz.bJv == null) {
                absolutePath = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                au.HU();
                file = new File(stringBuilder.append(c.Gm()).append("web/").append(g.u(bVar.bOz.bJv.getBytes())).toString());
                absolutePath = file.exists() ? file.getAbsolutePath() : "";
            }
            vx vxVar = bVar.bOz;
            com.tencent.mm.an.a.b bVar2 = (com.tencent.mm.an.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.an.a.b.class);
            String str = vxVar.title;
            String str2 = vxVar.desc;
            String str3 = vxVar.rzv;
            String str4 = vxVar.rzz;
            String str5 = vxVar.rzx;
            String str6 = vxVar.jdM;
            StringBuilder stringBuilder2 = new StringBuilder();
            au.HU();
            com.tencent.mm.an.b.b(bVar2.a(6, null, str, str2, str3, str4, str5, str6, stringBuilder2.append(c.Gm()).append("web/").toString(), absolutePath, "", vzVar.appId));
            return;
        }
        s.gH(view.getContext());
    }
}
