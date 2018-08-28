package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.s.j;

class q$5 implements Runnable {
    final /* synthetic */ q ftZ;

    q$5(q qVar) {
        this.ftZ = qVar;
    }

    public final void run() {
        if (q.e(this.ftZ).aex()) {
            q.f(this.ftZ).setImageResource(f.app_brand_remote_debug_normal_dot);
            q.g(this.ftZ).setText(this.ftZ.getContext().getString(j.app_brand_remote_debug_connect_hit_break_point));
        } else if (q.e(this.ftZ).hv()) {
            q.f(this.ftZ).setImageResource(f.app_brand_remote_debug_normal_dot);
            q.g(this.ftZ).setText(this.ftZ.getContext().getString(j.app_brand_remote_debug_connect_normal));
        } else {
            q.f(this.ftZ).setImageResource(f.app_brand_remote_debug_abnormal_dot);
            q.g(this.ftZ).setText(this.ftZ.getContext().getString(j.app_brand_remote_debug_connect_abnormal));
        }
        q.h(this.ftZ);
    }
}
