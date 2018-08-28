package com.tencent.mm.ak.a;

import android.view.View;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public final class c {
    public WeakReference<ImageView> dWX;
    public int height = 0;
    private String url = "";
    public int width = 0;

    public c(ImageView imageView, String str) {
        this.dWX = new WeakReference(imageView);
        this.url = str;
    }

    public final ImageView getImageView() {
        if (this.dWX != null) {
            ImageView imageView = (ImageView) this.dWX.get();
            if (imageView != null) {
                return imageView;
            }
        }
        return null;
    }

    public final int Pr() {
        Object obj = null;
        if (this.dWX != null) {
            obj = (View) this.dWX.get();
        }
        return obj == null ? super.hashCode() : obj.hashCode();
    }
}
