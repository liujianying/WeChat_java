package com.tencent.mm.svg.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import com.tencent.mm.svg.b.b;

public final class c extends b {
    private a tfa;

    public static class a extends ConstantState {
        protected int oFj;
        protected Picture tfb;
        protected Bitmap tfc;

        public a(Picture picture, int i) {
            this.tfb = picture;
            this.oFj = i;
        }

        public final Drawable newDrawable() {
            return new c(this.tfb, this.oFj);
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    public c(Picture picture, int i) {
        int i2 = 0;
        int width = picture != null ? picture.getWidth() : 0;
        if (picture != null) {
            i2 = picture.getHeight();
        }
        super(width, i2, i);
        this.tfa = new a(picture, i);
        coh();
    }

    public final ConstantState getConstantState() {
        return this.tfa;
    }

    public final void draw(Canvas canvas) {
        Object obj = 1;
        Object obj2 = null;
        long coo = b.coo();
        try {
            if (canvas.isHardwareAccelerated()) {
                if (this.tfa.tfb == null) {
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "Must not go here! %s", Integer.valueOf(this.teS));
                } else {
                    long nanoTime = System.nanoTime();
                    if (this.tfa.tfc == null || this.tfa.tfc.isRecycled()) {
                        if (getIntrinsicWidth() > 2048 || getIntrinsicHeight() > 2048) {
                            com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "This drawable is too big. %s", Integer.valueOf(this.teS));
                        } else if (getIntrinsicWidth() <= 0 || getIntrinsicHeight() <= 0) {
                            com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "width and height must > 0.", new Object[0]);
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap);
                            this.tfa.tfb.draw(canvas2);
                            this.tfa.tfc = createBitmap;
                            b.gq(nanoTime);
                            j(canvas2);
                        }
                    }
                }
                if (this.tfa.tfc == null || this.tfa.tfc.isRecycled()) {
                    obj = null;
                } else {
                    coi();
                    canvas.drawBitmap(this.tfa.tfc, null, this.rD, this.teU);
                }
                obj2 = obj;
            } else if (!(this.tfa.tfc == null || this.tfa.tfc.isRecycled())) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "recycle bitmap:%s", this.tfa.tfc.toString());
                this.tfa.tfc.recycle();
                this.tfa.tfc = null;
            }
            if (this.iUA == null) {
                this.iUA = a.t(this);
            }
            a.b(this.iUA, this.teU);
            if (obj2 == null) {
                if (!canvas.isHardwareAccelerated() || VERSION.SDK_INT >= 16) {
                    Picture picture = this.tfa.tfb;
                    if (picture != null) {
                        coi();
                        canvas.save();
                        canvas.drawPicture(picture, this.rD);
                        canvas.restore();
                    }
                } else {
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "Skip this draw.", new Object[0]);
                    return;
                }
            }
            this.mDuration = b.gq(coo);
            j(canvas);
        } finally {
            this.mDuration = b.gq(coo);
            j(canvas);
        }
    }
}
