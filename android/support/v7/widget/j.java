package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.v4.b.a.c;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class j {
    private static final int[] HN = new int[]{16843067, 16843068};
    private final ProgressBar MJ;
    Bitmap MK;
    final h Mb;

    j(ProgressBar progressBar, h hVar) {
        this.MJ = progressBar;
        this.Mb = hVar;
    }

    void b(AttributeSet attributeSet, int i) {
        ap a = ap.a(this.MJ.getContext(), attributeSet, HN, i);
        Drawable bP = a.bP(0);
        if (bP != null) {
            ProgressBar progressBar = this.MJ;
            if (bP instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) bP;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                Drawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i2 = 0; i2 < numberOfFrames; i2++) {
                    Drawable b = b(animationDrawable.getFrame(i2), true);
                    b.setLevel(10000);
                    animationDrawable2.addFrame(b, animationDrawable.getDuration(i2));
                }
                animationDrawable2.setLevel(10000);
                bP = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(bP);
        }
        bP = a.bP(1);
        if (bP != null) {
            this.MJ.setProgressDrawable(b(bP, false));
        }
        a.Ww.recycle();
    }

    private Drawable b(Drawable drawable, boolean z) {
        int i = 0;
        Drawable bD;
        if (drawable instanceof c) {
            bD = ((c) drawable).bD();
            if (bD == null) {
                return drawable;
            }
            ((c) drawable).j(b(bD, z));
            return drawable;
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                boolean z2;
                int id = layerDrawable.getId(i2);
                Drawable drawable2 = layerDrawable.getDrawable(i2);
                if (id == 16908301 || id == 16908303) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawableArr[i2] = b(drawable2, z2);
            }
            bD = new LayerDrawable(drawableArr);
            while (i < numberOfLayers) {
                bD.setId(i, layerDrawable.getId(i));
                i++;
            }
            return bD;
        } else if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        } else {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.MK == null) {
                this.MK = bitmap;
            }
            bD = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            bD.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            bD.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(bD, 3, 1) : bD;
        }
    }
}
