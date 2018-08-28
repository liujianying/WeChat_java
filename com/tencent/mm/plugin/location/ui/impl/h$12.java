package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class h$12 implements OnClickListener {
    final /* synthetic */ h kKh;

    h$12(h hVar) {
        this.kKh = hVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.TrackMapUI", "newpoi my position ", new Object[]{this.kKh.kJJ});
        this.kKh.kJL.a(this.kKh.kHR.kEZ);
    }
}
