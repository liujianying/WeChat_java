package com.tencent.mm.ui.base.preference;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.bp.a;

public final class e {
    Bitmap bitmap = null;
    int jxE = -1;

    public final void e(ImageView imageView) {
        if (imageView != null) {
            if (this.jxE != -1) {
                imageView.setImageDrawable(a.f(imageView.getContext(), this.jxE));
            }
            if (this.bitmap != null) {
                imageView.setImageBitmap(this.bitmap);
            }
        }
    }
}
