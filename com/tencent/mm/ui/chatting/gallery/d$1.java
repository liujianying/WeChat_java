package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.davemorrissey.labs.subscaleview.a.c;
import com.tencent.mm.graphics.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class d$1 implements b {
    final /* synthetic */ bd dAs;
    final /* synthetic */ int hW;
    final /* synthetic */ j tTK;
    final /* synthetic */ String tUV;
    final /* synthetic */ d tUW;

    d$1(d dVar, String str, int i, j jVar, bd bdVar) {
        this.tUW = dVar;
        this.tUV = str;
        this.hW = i;
        this.tTK = jVar;
        this.dAs = bdVar;
    }

    public final void hO() {
        x.i("MicroMsg.ImageGalleryHolderImage", "alvinluo SubsamplingImageView onPreviewLoaded");
    }

    public final void f(Bitmap bitmap) {
        if (!(bitmap == null || this.tUW.tUQ == null)) {
            x.i("MicroMsg.ImageGalleryHolderImage", "alvinluo onImageLoaded cache bitmap, cacheImagePath: %s", new Object[]{this.tUV});
            this.tUW.tUQ.b(this.hW > 0 ? this.hW : this.tTK.mPosition, bitmap);
        }
        d.a(this.tTK);
    }

    public final void a(c cVar) {
        x.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onPreviewLoadError errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(cVar.errCode), cVar.Yy});
    }

    public final void b(c cVar) {
        x.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onImageLoadError errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(cVar.errCode), cVar.Yy});
        d.a(this.dAs, this.tTK);
    }

    public final void c(c cVar) {
        x.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onTileLoadError errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(cVar.errCode), cVar.Yy});
        d.a(this.dAs, this.tTK);
    }

    public final void hP() {
    }
}
