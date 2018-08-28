package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

final class AdlandingSightPlayImageView$a extends a {
    private WeakReference<AdlandingSightPlayImageView> ndy;

    protected final int bvG() {
        return a.sight_loop;
    }

    public AdlandingSightPlayImageView$a(AdlandingSightPlayImageView adlandingSightPlayImageView) {
        super(adlandingSightPlayImageView);
        this.ndy = new WeakReference(adlandingSightPlayImageView);
    }

    public final void cl(int i, int i2) {
        AdlandingSightPlayImageView adlandingSightPlayImageView = (AdlandingSightPlayImageView) this.ndy.get();
        if (adlandingSightPlayImageView == null) {
            x.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
            clear();
        } else if (!AdlandingSightPlayImageView.a(adlandingSightPlayImageView)) {
            AdlandingSightPlayImageView.a(adlandingSightPlayImageView, i);
            AdlandingSightPlayImageView.b(adlandingSightPlayImageView, i2);
            if (adlandingSightPlayImageView.ndD != null) {
                adlandingSightPlayImageView.ndD.cl(i, i2);
            }
            if (AdlandingSightPlayImageView.b(adlandingSightPlayImageView)) {
                if (AdlandingSightPlayImageView.c(adlandingSightPlayImageView) >= AdlandingSightPlayImageView.d(adlandingSightPlayImageView)) {
                    AdlandingSightPlayImageView.c(adlandingSightPlayImageView, com.tencent.mm.bp.a.fromDPToPix(adlandingSightPlayImageView.getContext(), 150));
                } else {
                    AdlandingSightPlayImageView.c(adlandingSightPlayImageView, com.tencent.mm.bp.a.fromDPToPix(adlandingSightPlayImageView.getContext(), 85));
                }
            }
            if (AdlandingSightPlayImageView.e(adlandingSightPlayImageView) > 0) {
                LayoutParams layoutParams = adlandingSightPlayImageView.getLayoutParams();
                if (!(layoutParams.width == AdlandingSightPlayImageView.e(adlandingSightPlayImageView) && layoutParams.height == (AdlandingSightPlayImageView.e(adlandingSightPlayImageView) * i2) / i)) {
                    layoutParams.width = AdlandingSightPlayImageView.e(adlandingSightPlayImageView);
                    layoutParams.height = (AdlandingSightPlayImageView.e(adlandingSightPlayImageView) * i2) / i;
                    ah.A(new 1(this, adlandingSightPlayImageView, layoutParams));
                    adlandingSightPlayImageView.postInvalidate();
                }
                x.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
            }
            x.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[]{Integer.valueOf(AdlandingSightPlayImageView.e(adlandingSightPlayImageView)), Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public final void E(Bitmap bitmap) {
        AdlandingSightPlayImageView adlandingSightPlayImageView = (AdlandingSightPlayImageView) this.ndy.get();
        if (adlandingSightPlayImageView == null) {
            x.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
            clear();
            return;
        }
        adlandingSightPlayImageView.setImageBitmap(bitmap);
    }
}
