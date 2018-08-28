package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.protocal.c.btf;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.IconPreference;

class h$2 implements Runnable {
    final /* synthetic */ h tiG;
    final /* synthetic */ IconPreference tiH;

    h$2(h hVar, IconPreference iconPreference) {
        this.tiG = hVar;
        this.tiH = iconPreference;
    }

    public final void run() {
        if (this.tiH != null) {
            if (((b) g.n(b.class)).getRedDotMgr().bHt()) {
                if (LauncherUI.cpR() == 2) {
                    ((b) g.n(b.class)).getRedDotMgr().bHx();
                }
                btf bHw = ((b) g.n(b.class)).getRedDotMgr().bHw();
                Bitmap jz;
                switch (bHw.type) {
                    case 1:
                        this.tiH.Et(0);
                        this.tiH.Es(8);
                        return;
                    case 2:
                        this.tiH.Et(8);
                        this.tiH.Es(0);
                        this.tiH.ao(bHw.text, -1, Color.parseColor("#8c8c8c"));
                        this.tiH.lN(true);
                        this.tiH.Ew(8);
                        return;
                    case 3:
                        this.tiH.Et(8);
                        this.tiH.Ew(0);
                        this.tiH.Ev(0);
                        this.tiH.Ex(0);
                        this.tiH.lN(false);
                        o.Pe();
                        jz = c.jz(bHw.bWP);
                        if (jz != null) {
                            h.a(this.tiG, null);
                            this.tiH.V(jz);
                            return;
                        }
                        o.Pi().a(bHw.bWP, this.tiG.tiF);
                        h.a(this.tiG, bHw.bWP);
                        return;
                    case 4:
                        this.tiH.Et(8);
                        this.tiH.Ew(0);
                        this.tiH.Ev(0);
                        this.tiH.Ex(0);
                        this.tiH.Es(0);
                        this.tiH.lN(false);
                        this.tiH.ao(bHw.text, -1, Color.parseColor("#8c8c8c"));
                        o.Pe();
                        jz = c.jz(bHw.bWP);
                        if (jz != null) {
                            h.a(this.tiG, null);
                            this.tiH.V(jz);
                            return;
                        }
                        o.Pi().a(bHw.bWP, this.tiG.tiF);
                        h.a(this.tiG, bHw.bWP);
                        return;
                    default:
                        x.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", new Object[]{Integer.valueOf(bHw.type)});
                        return;
                }
            }
            this.tiH.Et(8);
            this.tiH.Es(8);
            this.tiH.Ew(8);
        }
    }
}
