package com.tencent.mm.plugin.appbrand.debugger;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.2;
import com.tencent.mm.plugin.appbrand.s$g;

class q$3 implements OnClickListener {
    final /* synthetic */ q ftZ;

    q$3(q qVar) {
        this.ftZ = qVar;
    }

    public final void onClick(View view) {
        q qVar = this.ftZ;
        if (view.getId() == s$g.app_brand_remote_debug_expand_tv) {
            qVar.ftW = true;
            qVar.show();
            RemoteDebugMoveView remoteDebugMoveView = qVar.ftK;
            remoteDebugMoveView.postDelayed(new 2(remoteDebugMoveView), 50);
        } else if (view.getId() == s$g.app_brand_remote_debug_collapse_tv) {
            qVar.ftW = false;
            qVar.show();
        } else if (view.getId() == s$g.app_brand_remote_debug_quit_tv) {
            qVar.aeL();
        }
    }
}
