package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.api.d;
import com.tencent.mm.bd.a.g;
import com.tencent.mm.bi.b;

public final class c extends a {
    private Bitmap uVt;
    private Bitmap uVu;

    protected final void cCi() {
        super.cCi();
        this.uVt = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(g.crop_video_unselected));
        this.uVu = com.tencent.mm.sdk.platformtools.c.s(getResources().getDrawable(g.crop_video_selected));
    }

    protected final Bitmap a(d dVar, boolean z) {
        if (dVar == d.bwS) {
            return z ? this.uVu : this.uVt;
        } else {
            return null;
        }
    }

    public c(Context context, b bVar) {
        super(context, bVar);
    }

    protected final boolean GU(int i) {
        boolean GU = super.GU(i);
        switch (1.qVw[GT(i).ordinal()]) {
            case 1:
                return false;
            default:
                return GU;
        }
    }
}
