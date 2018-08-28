package com.tencent.mm.plugin.fav.ui.widget;

import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.d;

class FavVideoView$a implements p, c {
    final /* synthetic */ FavVideoView jfS;

    private FavVideoView$a(FavVideoView favVideoView) {
        this.jfS = favVideoView;
    }

    /* synthetic */ FavVideoView$a(FavVideoView favVideoView, byte b) {
        this(favVideoView);
    }

    public final void d(com.tencent.mm.plugin.fav.a.c cVar) {
        if (cVar != null && cVar.field_dataId.equals(FavVideoView.f(this.jfS))) {
            a(cVar.field_status, cVar.field_path, cVar.field_offset, cVar.field_totalLen);
        }
    }

    public final void a(int i, f fVar) {
        if (fVar != null && fVar.field_dataId.equals(FavVideoView.f(this.jfS))) {
            a(fVar.field_status, fVar.field_path, fVar.field_offset, fVar.field_totalLen);
        }
    }

    private void a(int i, String str, int i2, int i3) {
        if ((i == 3 || i == 2) && d.cn(str)) {
            FavVideoView.a(this.jfS).stop();
            FavVideoView.g(this.jfS);
            FavVideoView.a(this.jfS, str);
            ah.A(new 1(this));
            return;
        }
        FavVideoView.a(this.jfS, i2, i3);
    }
}
