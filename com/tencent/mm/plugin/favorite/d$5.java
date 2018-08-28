package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.ui.widget.a.c.a.b;

class d$5 implements b {
    final /* synthetic */ we jfW;
    final /* synthetic */ Context val$context;

    d$5(we weVar, Context context) {
        this.jfW = weVar;
        this.val$context = context;
    }

    public final void aMV() {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 1);
        intent.putExtra("kwebmap_slat", this.jfW.lat);
        intent.putExtra("kwebmap_lng", this.jfW.lng);
        intent.putExtra("Kwebmap_locaion", this.jfW.label);
        intent.putExtra("kShowshare", false);
        d.b(this.val$context, "location", ".ui.RedirectUI", intent);
    }
}
