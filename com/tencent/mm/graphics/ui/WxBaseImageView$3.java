package com.tencent.mm.graphics.ui;

import android.graphics.Bitmap;
import com.davemorrissey.labs.subscaleview.a.c;
import com.tencent.mm.graphics.a.b;
import com.tencent.mm.sdk.platformtools.x;

class WxBaseImageView$3 implements b {
    final /* synthetic */ WxBaseImageView djS;
    final /* synthetic */ b djT;

    WxBaseImageView$3(WxBaseImageView wxBaseImageView, b bVar) {
        this.djS = wxBaseImageView;
        this.djT = bVar;
    }

    public final void hO() {
        WxBaseImageView.d(this.djS);
        if (this.djT != null) {
            this.djT.hO();
        }
    }

    public final void f(Bitmap bitmap) {
        WxBaseImageView.e(this.djS);
        if (this.djT != null) {
            this.djT.f(bitmap);
        }
    }

    public final void a(c cVar) {
        WxBaseImageView.a(this.djS, cVar);
        if (this.djT != null) {
            this.djT.a(cVar);
        }
    }

    public final void b(c cVar) {
        WxBaseImageView.b(this.djS, cVar);
        if (this.djT != null) {
            this.djT.b(cVar);
        }
    }

    public final void c(c cVar) {
        WxBaseImageView.b(this.djS, cVar);
        if (this.djT != null) {
            this.djT.c(cVar);
        }
    }

    public final void hP() {
        x.i("MicroMsg.WxBaseImageView", "alvinluo onPreviewReleased");
        if (this.djT != null) {
            this.djT.hP();
        }
    }
}
