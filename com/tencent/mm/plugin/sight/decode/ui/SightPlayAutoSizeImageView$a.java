package com.tencent.mm.plugin.sight.decode.ui;

import android.graphics.Bitmap;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

final class SightPlayAutoSizeImageView$a extends b {
    private WeakReference<SightPlayAutoSizeImageView> ndy;

    protected final int bvG() {
        return R.a.sight_loop;
    }

    public SightPlayAutoSizeImageView$a(SightPlayAutoSizeImageView sightPlayAutoSizeImageView) {
        super(0, sightPlayAutoSizeImageView);
        this.ndy = new WeakReference(sightPlayAutoSizeImageView);
    }

    public final void cl(int i, int i2) {
    }

    public final void E(Bitmap bitmap) {
        SightPlayAutoSizeImageView sightPlayAutoSizeImageView = (SightPlayAutoSizeImageView) this.ndy.get();
        if (sightPlayAutoSizeImageView == null) {
            x.e("MicroMsg.SightPlayAutoSizeImageView", "onGetFrameBmp, imageView is null, do clear");
            clear();
            return;
        }
        sightPlayAutoSizeImageView.setScaleType(ScaleType.CENTER_CROP);
        sightPlayAutoSizeImageView.setImageBitmap(bitmap);
    }
}
