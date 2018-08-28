package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.6;
import com.tencent.mm.plugin.location.ui.l.7;
import com.tencent.mm.plugin.map.a;
import com.tencent.mm.ui.base.h;

class g$7 implements OnClickListener {
    final /* synthetic */ g kJY;

    g$7(g gVar) {
        this.kJY = gVar;
    }

    public final void onClick(View view) {
        l lVar = this.kJY.kJN;
        h.a(lVar.mContext, lVar.mResources.getString(a.h.location_sharing_end_tips), "", lVar.mResources.getString(a.h.app_endshare), lVar.mResources.getString(a.h.app_cancel), new 6(lVar), new 7(lVar));
    }
}
