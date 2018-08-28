package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.tencentmap.mapsdk.a.ac.p;
import com.tencent.tencentmap.mapsdk.map.TencentMap$OnScreenShotListener;

class qn$6 implements p {
    final /* synthetic */ TencentMap$OnScreenShotListener a;
    final /* synthetic */ qn b;

    qn$6(qn qnVar, TencentMap$OnScreenShotListener tencentMap$OnScreenShotListener) {
        this.b = qnVar;
        this.a = tencentMap$OnScreenShotListener;
    }

    public void a(Bitmap bitmap) {
        if (this.a != null) {
            this.a.onMapScreenShot(bitmap);
        }
    }
}
