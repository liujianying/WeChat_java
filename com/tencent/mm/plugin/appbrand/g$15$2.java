package com.tencent.mm.plugin.appbrand;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.g.15;
import com.tencent.mm.plugin.appbrand.g.17;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.x;

class g$15$2 implements Runnable {
    final /* synthetic */ 15 fdj;

    g$15$2(15 15) {
        this.fdj = 15;
    }

    public final void run() {
        x.d("MicroMsg.AppBrandRuntime", "AppBrandPrepareTask done. runOnUiThread");
        g gVar = this.fdj.fdd;
        boolean l = j.l(gVar.fcq);
        if (gVar.aaq() && l) {
            Toast makeText = Toast.makeText(gVar.fcq, s.j.appbrand_game_multi_window_not_supported, 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
            gVar.fcq.finish();
        } else {
            gVar.a(new 17(gVar));
        }
        this.fdj.fdd.fcU = true;
        this.fdj.fdd.aat();
    }
}
