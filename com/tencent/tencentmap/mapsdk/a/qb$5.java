package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.tencentmap.mapsdk.a.tz.j;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;

class qb$5 implements j {
    final /* synthetic */ OnScreenShotListener a;
    final /* synthetic */ qb b;

    qb$5(qb qbVar, OnScreenShotListener onScreenShotListener) {
        this.b = qbVar;
        this.a = onScreenShotListener;
    }

    public void a(Bitmap bitmap) {
        if (this.a != null) {
            this.a.onMapScreenShot(bitmap);
        }
    }
}
