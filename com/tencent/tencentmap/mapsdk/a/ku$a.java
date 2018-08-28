package com.tencent.tencentmap.mapsdk.a;

import java.lang.ref.WeakReference;

class ku$a extends Thread {
    private final WeakReference<ku> a;

    public ku$a(ku kuVar) {
        this.a = new WeakReference(kuVar);
    }

    public void run() {
        if (this.a != null && this.a.get() != null) {
            ku kuVar = (ku) this.a.get();
            ku.a(true);
            ku.a(kuVar, 0);
            int a = ku.a(kuVar);
            ku.b(kuVar);
            ku.a(kuVar, "rtt_config.json", a);
            ku.a(kuVar, "closedroadstyle_normalmode", ku.c(kuVar));
            ku.a(kuVar, "closedroadstyle_trafficmode", ku.d(kuVar));
            ku.a(kuVar, "indoormap_config", ku.e(kuVar));
            ku.a(kuVar, "indoorpoi_icon", ku.f(kuVar));
            ku.a(false);
        }
    }
}
