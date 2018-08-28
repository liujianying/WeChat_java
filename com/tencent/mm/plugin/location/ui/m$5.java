package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.plugin.location.model.i.a;
import com.tencent.mm.sdk.platformtools.x;

class m$5 implements a {
    final /* synthetic */ m kHj;

    m$5(m mVar) {
        this.kHj = mVar;
    }

    public final void u(double d) {
        if (m.d(this.kHj) != null) {
            x.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", new Object[]{Double.valueOf(d)});
            m.d(this.kHj).v(d);
        }
    }
}
