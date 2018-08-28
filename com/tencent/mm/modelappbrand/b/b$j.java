package com.tencent.mm.modelappbrand.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.modelappbrand.b.b.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class b$j implements h {
    private final WeakReference<ImageView> YB;
    final String aAL;
    private final b dGe;
    boolean dGf;

    /* synthetic */ b$j(ImageView imageView, b bVar, byte b) {
        this(imageView, bVar);
    }

    final ImageView getImageView() {
        return (ImageView) this.YB.get();
    }

    private b$j(ImageView imageView, b bVar) {
        this.dGf = false;
        this.YB = new WeakReference(imageView);
        this.dGe = bVar;
        this.aAL = "ImageView#" + imageView.hashCode();
    }

    private void Kh() {
        if (this.YB.get() != null) {
            b.c(this.dGe).remove(Integer.valueOf(((ImageView) this.YB.get()).hashCode()));
        }
    }

    public void Kc() {
    }

    public final void n(Bitmap bitmap) {
        Kh();
        ImageView imageView = (ImageView) this.YB.get();
        if (imageView != null) {
            if (!ah.isMainThread()) {
                x.k("MicroMsg.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
            }
            imageView.setImageDrawable(new e(imageView.getResources(), bitmap));
        }
        this.dGf = true;
    }

    public final void Kd() {
        Kh();
    }

    public final String Ke() {
        return this.aAL;
    }
}
