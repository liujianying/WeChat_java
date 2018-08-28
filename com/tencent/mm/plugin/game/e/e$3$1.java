package com.tencent.mm.plugin.game.e;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.game.e.e.3;

class e$3$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ 3 kdw;

    e$3$1(3 3, Bitmap bitmap) {
        this.kdw = 3;
        this.abc = bitmap;
    }

    public final void run() {
        this.kdw.ixr.setImageBitmap(this.abc);
        LayoutParams layoutParams = this.kdw.ixr.getLayoutParams();
        float f = ((float) this.kdw.aEe) / ((float) this.kdw.aEd);
        layoutParams.width = this.kdw.kdv;
        layoutParams.height = (int) (f * ((float) this.kdw.kdv));
        this.kdw.ixr.setLayoutParams(layoutParams);
        this.kdw.ixr.setScaleType(ScaleType.FIT_XY);
    }
}
