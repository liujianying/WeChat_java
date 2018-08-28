package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;

class qn$5 implements ac$p {
    final /* synthetic */ OnScreenShotListener a;
    final /* synthetic */ qn b;

    qn$5(qn qnVar, OnScreenShotListener onScreenShotListener) {
        this.b = qnVar;
        this.a = onScreenShotListener;
    }

    public void a(Bitmap bitmap) {
        if (this.a != null) {
            this.a.onMapScreenShot(bitmap);
        }
    }
}
