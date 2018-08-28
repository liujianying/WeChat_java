package com.tencent.mm.app;

import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.d.a.4;
import com.tencent.mm.model.d.b;
import com.tencent.mm.model.d.b.1;
import com.tencent.mm.model.d.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.conversation.j;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.z;

public final class m {
    public static m byY;
    public boolean byZ;
    public ag bza = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            LauncherUI cpQ;
            if (message.what == -1999) {
                if (!m.this.byZ) {
                    cpQ = LauncherUI.cpQ();
                    if (cpQ != null && cpQ.tkq) {
                        cpQ.tkn.tjF.ZS("tab_main");
                        HomeUI homeUI = cpQ.tkn;
                        if (homeUI.tjr) {
                            homeUI.tjt = true;
                        }
                        f fVar = n.nkx;
                        if (fVar != null) {
                            fVar.bwU();
                        }
                        for (Fragment fragment : cpQ.tkn.tjF.ton.values()) {
                            if (!(fragment instanceof j)) {
                                ((o) fragment).coH();
                            }
                        }
                    }
                    System.gc();
                }
            } else if (message.what == -2999 && !m.this.byZ) {
                cpQ = LauncherUI.cpQ();
                if (cpQ != null) {
                    z zVar = cpQ.tkn.tjF;
                    if (zVar.ton.containsKey(Integer.valueOf(0))) {
                        ((o) zVar.ton.get(Integer.valueOf(0))).coH();
                    }
                }
                if (g.Eg().Dx()) {
                    au.HN();
                    ar iK = bs.iK("plugin.emoji");
                    if (iK != null) {
                        iK.gi(0);
                    }
                    au.HN();
                    if (((com.tencent.mm.ak.o) bs.iK(com.tencent.mm.ak.o.class.getName())) != null) {
                        com.tencent.mm.ak.o.Pl();
                    }
                    b JG = b.JG();
                    a JA = a.JA();
                    c JI = c.JI();
                    au.Em().H(new 1(JG));
                    au.Em().H(new 4(JA));
                    JI.a(JG);
                    JI.a(JA);
                    au.Em().H(new c.1(JI));
                }
                System.gc();
            }
        }
    };

    public static m vc() {
        if (byY == null) {
            byY = new m();
        }
        return byY;
    }
}
