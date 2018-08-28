package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.q.a;

class m$3 extends a {
    final /* synthetic */ m gmG;
    final /* synthetic */ Context val$context;

    m$3(m mVar, Context context) {
        this.gmG = mVar;
        this.val$context = context;
    }

    public final void onActivityPaused(Activity activity) {
        if (activity == this.val$context) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            if (this.gmG.gmE != null && this.gmG.gmE.isShowing()) {
                this.gmG.gmE.bzW();
            }
        }
    }
}
