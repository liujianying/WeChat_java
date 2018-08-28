package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.websearch.api.ac.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.IconPreference;

class h$3 implements Runnable {
    final /* synthetic */ h tiG;
    final /* synthetic */ IconPreference tiH;
    final /* synthetic */ a tiI;

    h$3(h hVar, IconPreference iconPreference, a aVar) {
        this.tiG = hVar;
        this.tiH = iconPreference;
        this.tiI = aVar;
    }

    public final void run() {
        if (this.tiH != null) {
            if (this.tiI == null) {
                this.tiH.Et(8);
                return;
            }
            if (this.tiI.isValid()) {
                x.i("MicroMsg.FindMoreFriendsUI", "show red %s", new Object[]{this.tiH.getTitle()});
                Bitmap jz;
                switch (this.tiI.type) {
                    case 1:
                        this.tiH.Et(0);
                        this.tiH.Es(8);
                        break;
                    case 2:
                        this.tiH.Et(8);
                        this.tiH.Es(0);
                        this.tiH.ao(this.tiI.text, -1, Color.parseColor("#8c8c8c"));
                        this.tiH.lN(true);
                        this.tiH.Ew(8);
                        break;
                    case 3:
                        this.tiH.Ew(0);
                        this.tiH.Ev(0);
                        this.tiH.Ex(0);
                        this.tiH.lN(false);
                        o.Pe();
                        jz = c.jz(this.tiI.bWP);
                        if (jz == null) {
                            o.Pi().a(this.tiI.bWP, this.tiG.tiF);
                            h.a(this.tiG, this.tiI.bWP);
                            break;
                        }
                        h.a(this.tiG, null);
                        this.tiH.V(jz);
                        break;
                    case 4:
                        this.tiH.Ew(0);
                        this.tiH.Ev(0);
                        this.tiH.Ex(0);
                        this.tiH.Es(0);
                        this.tiH.lN(false);
                        this.tiH.ao(this.tiI.text, -1, Color.parseColor("#8c8c8c"));
                        o.Pe();
                        jz = c.jz(this.tiI.bWP);
                        if (jz == null) {
                            o.Pi().a(this.tiI.bWP, this.tiG.tiF);
                            h.a(this.tiG, this.tiI.bWP);
                            break;
                        }
                        h.a(this.tiG, null);
                        this.tiH.V(jz);
                        break;
                    default:
                        x.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", new Object[]{Integer.valueOf(this.tiI.type)});
                        break;
                }
            }
            x.i("MicroMsg.FindMoreFriendsUI", "hide red %s", new Object[]{this.tiH.getTitle()});
            this.tiH.Et(8);
            this.tiH.Es(8);
            this.tiH.Ew(8);
            h.a(this.tiG).notifyDataSetChanged();
        }
    }
}
