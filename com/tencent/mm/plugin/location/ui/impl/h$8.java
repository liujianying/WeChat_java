package com.tencent.mm.plugin.location.ui.impl;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ax.g;
import com.tencent.mm.ay.d;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.3;
import com.tencent.mm.plugin.map.a$h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.h;

class h$8 implements OnClickListener {
    final /* synthetic */ h kKh;

    h$8(h hVar) {
        this.kKh = hVar;
    }

    public final void onClick(View view) {
        boolean z = d.elh != null && d.elh.nt(this.kKh.kDN);
        boolean z2;
        if (g.elf == null || !g.elf.nq(this.kKh.kDN)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z || !z2) {
            l lVar = this.kKh.kJN;
            if (!l.rQ(67589)) {
                h.a(lVar.mContext, lVar.mResources.getString(a$h.location_sharing_first_start_tips), "", false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (l.this.kGO != null) {
                            l.this.kGO.gi(true);
                        }
                    }
                }, new 3(lVar));
                l.rR(67589);
                return;
            } else if (lVar.kGO != null) {
                lVar.kGO.gi(false);
                return;
            } else {
                return;
            }
        }
        rn rnVar = new rn();
        rnVar.ccn.ccp = true;
        a.sFg.m(rnVar);
        if (this.kKh.kDN.equals(rnVar.cco.ccr)) {
            h.a(this.kKh.activity, this.kKh.getString(a$h.enter_track_myself_talking_err), "", this.kKh.getString(a$h.i_know_it), false, new 1(this));
        } else {
            h.a(this.kKh.activity, this.kKh.getString(a$h.enter_track_other_talking_err), "", this.kKh.getString(a$h.i_know_it), false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }
}
