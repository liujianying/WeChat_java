package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;

public class TencentMapInitializer implements IInitializer {
    private static volatile TencentMapInitializer b;
    private IInitializer a;

    private TencentMapInitializer(Context context) {
        this.a = b.a(context);
    }

    public static TencentMapInitializer getInstance(Context context) {
        if (b == null) {
            synchronized (TencentMapInitializer.class) {
                if (b == null) {
                    b = new TencentMapInitializer(context);
                }
            }
        }
        return b;
    }

    public void downLoadVectorMapResource() {
        if (this.a != null) {
            this.a.downLoadVectorMapResource();
        }
    }
}
