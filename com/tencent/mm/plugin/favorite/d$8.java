package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.ui.widget.a.c.a.b;

class d$8 implements b {
    final /* synthetic */ g iVw;
    final /* synthetic */ vx iVx;
    final /* synthetic */ Context val$context;

    d$8(g gVar, vx vxVar, Context context) {
        this.iVw = gVar;
        this.iVx = vxVar;
        this.val$context = context;
    }

    public final void aMV() {
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", this.iVw.field_localId);
        intent.putExtra("key_detail_data_id", this.iVx.jdM);
        intent.putExtra("show_share", false);
        com.tencent.mm.plugin.fav.a.b.a(this.val$context, ".ui.FavImgGalleryUI", intent);
    }
}
