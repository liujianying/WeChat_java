package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.model.q;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.l.2;
import com.tencent.mm.plugin.location.ui.l.9;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.map.a$h;
import com.tencent.mm.ui.base.h;

class h$7 implements a {
    final /* synthetic */ h kKh;

    h$7(h hVar) {
        this.kKh = hVar;
    }

    public final void gi(boolean z) {
        if (l.aZj().az(this.kKh.kDN, q.GF()) || z || this.kKh.d(this.kKh.kHP)) {
            h.a(this.kKh);
            return;
        }
        com.tencent.mm.plugin.location.ui.l lVar = this.kKh.kJN;
        if (lVar.ftY == null) {
            lVar.ftY = h.a(lVar.mContext, lVar.mResources.getString(a$h.location_diff_track_point_confirm_tips), "", false, new 9(lVar), new 2(lVar));
        }
    }

    public final void aZN() {
    }

    public final void rS(int i) {
    }

    public final void aZO() {
    }

    public final void aZP() {
        h.a(this.kKh);
    }
}
