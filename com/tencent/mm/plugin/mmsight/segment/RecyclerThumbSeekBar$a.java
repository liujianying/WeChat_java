package com.tencent.mm.plugin.mmsight.segment;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.b;
import com.tencent.mm.sdk.platformtools.x;

class RecyclerThumbSeekBar$a implements Runnable {
    private ImageView bOA;
    private Bitmap bitmap;
    final /* synthetic */ RecyclerThumbSeekBar llX;
    private b llZ;

    RecyclerThumbSeekBar$a(RecyclerThumbSeekBar recyclerThumbSeekBar, Bitmap bitmap, ImageView imageView, b bVar) {
        this.llX = recyclerThumbSeekBar;
        this.bitmap = bitmap;
        this.bOA = imageView;
        this.llZ = bVar;
    }

    public final void run() {
        boolean z = true;
        if (this.bitmap == null || this.bitmap.isRecycled()) {
            String str = "RecyclerThumbSeekBar";
            String str2 = "bitmap is null %b in DrawBitmapOnViewTask";
            Object[] objArr = new Object[1];
            if (this.bitmap != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
        } else if (this.llZ == null || this.llZ.dZm || this.bOA == null) {
            x.i("RecyclerThumbSeekBar", "bitmap in DrawBitmapOnViewTask");
        } else {
            ImageView imageView = this.bOA;
            imageView.setTag(null);
            ObjectAnimator.ofInt(imageView, "imageAlpha", new int[]{50, 255}).setDuration(200).start();
            imageView.setImageBitmap(this.bitmap);
        }
    }
}
