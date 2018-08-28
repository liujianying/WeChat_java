package com.tencent.mm.pluginsdk.ui;

import android.widget.Toast;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.MMGestureGallery.c;

class GetHdHeadImageGalleryView$b implements c {
    final /* synthetic */ GetHdHeadImageGalleryView qFk;

    private GetHdHeadImageGalleryView$b(GetHdHeadImageGalleryView getHdHeadImageGalleryView) {
        this.qFk = getHdHeadImageGalleryView;
    }

    /* synthetic */ GetHdHeadImageGalleryView$b(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b) {
        this(getHdHeadImageGalleryView);
    }

    public final void aMl() {
        if (GetHdHeadImageGalleryView.b(this.qFk) != null && GetHdHeadImageGalleryView.c(this.qFk) != null) {
            h.a(this.qFk.getContext(), null, this.qFk.getContext().getResources().getStringArray(a.get_hd_head_img_alert), "", new h.c() {
                public final void ju(int i) {
                    switch (i) {
                        case 0:
                            String str = e.dgl + "hdImg_" + g.u(GetHdHeadImageGalleryView.c(GetHdHeadImageGalleryView$b.this.qFk).getBytes()) + System.currentTimeMillis() + ".jpg";
                            FileOp.deleteFile(str);
                            FileOp.y(GetHdHeadImageGalleryView.b(GetHdHeadImageGalleryView$b.this.qFk), str);
                            r.a(str, GetHdHeadImageGalleryView$b.this.qFk.getContext());
                            Toast.makeText(GetHdHeadImageGalleryView$b.this.qFk.getContext(), GetHdHeadImageGalleryView$b.this.qFk.getContext().getString(com.tencent.mm.plugin.comm.a.h.get_hd_head_img_save_tips, new Object[]{e.dgl}), 1).show();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }
}
