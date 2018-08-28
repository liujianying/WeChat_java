package com.tencent.mm.plugin.facedetect.ui;

import android.support.v4.view.ViewPager;
import android.support.v4.view.u;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.tencent.mm.plugin.facedetect.a$a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;

public final class b {
    u hF;
    Button iQh;
    Animation iQl;
    a iRV;
    View ido;
    ViewPager vp;

    public b() {
        this.ido = null;
        this.iQl = null;
        this.iQl = AnimationUtils.loadAnimation(ad.getContext(), a$a.alpha_out);
        this.iQl.setDuration(500);
    }

    public final void dismiss() {
        if (this.ido.getVisibility() == 0) {
            ah.A(new 3(this));
        }
    }
}
