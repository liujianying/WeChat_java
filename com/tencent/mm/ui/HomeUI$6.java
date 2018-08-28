package com.tencent.mm.ui;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.ak.n;
import com.tencent.mm.booter.o;
import com.tencent.mm.booter.y;
import com.tencent.mm.booter.y.1;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class HomeUI$6 implements IdleHandler {
    final /* synthetic */ HomeUI tjS;

    HomeUI$6(HomeUI homeUI) {
        this.tjS = homeUI;
    }

    public final boolean queueIdle() {
        au.HU();
        if (ai.f((Integer) c.DT().get(15, null)) == 0) {
            x.e("MicroMsg.LauncherUI.HomeUI", "not init finish , do not post sync task");
        } else {
            String I = at.dBv.I("login_user_name", "");
            if (au.HW() || !I.equals("")) {
                au.DF().a(new bg(new 1(this), "launch normal"), 0);
            }
            e.post(new 1(new y(HomeUI.d(this.tjS))), "StartupReport_report");
            o.onCreate(true);
            HomeUI.cpE();
            f.brR();
            n.c cVar = n.OW().dVU;
            if (cVar.dWj.size() <= 0 && cVar.dWi.size() <= 0) {
                I = (String) g.Ei().DT().get(348177, "");
                String str = (String) g.Ei().DT().get(348176, "");
                if (!bi.oW(I)) {
                    synchronized (cVar) {
                        for (String lT : I.split("-")) {
                            n$b lT2 = n.c.lT(lT);
                            if (lT2 != null) {
                                cVar.dWj.add(lT2);
                            }
                        }
                    }
                }
                if (!bi.oW(str)) {
                    synchronized (cVar) {
                        for (String lS : str.split("-")) {
                            n$b lS2 = n.c.lS(lS);
                            if (lS2 != null) {
                                cVar.dWi.add(lS2);
                            }
                        }
                    }
                }
                x.i("MicroMsg.SendImgSpeeder", "Image pool bigfile pool size %d, thumbfile size %d ", new Object[]{Integer.valueOf(cVar.dWi.size()), Integer.valueOf(cVar.dWj.size())});
            }
            cVar.OZ();
            Looper.myQueue().removeIdleHandler(this.tjS.tjO);
        }
        return false;
    }
}
