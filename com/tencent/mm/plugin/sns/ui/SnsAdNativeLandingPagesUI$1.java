package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b;
import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingPagesUI$1 extends BroadcastReceiver {
    final /* synthetic */ SnsAdNativeLandingPagesUI nSR;

    SnsAdNativeLandingPagesUI$1(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.nSR = snsAdNativeLandingPagesUI;
    }

    public final void onReceive(Context context, Intent intent) {
        boolean z = true;
        b bVar = (b) ((o) SnsAdNativeLandingPagesUI.a(this.nSR).getAdapter()).V(SnsAdNativeLandingPagesUI.a(this.nSR).getCurrentItem());
        x.d("MicroMsg.SnsAdNativeLandingPagesUI", "recv videoProgressbarStatusChangeReceiver show %d", new Object[]{Integer.valueOf(intent.getIntExtra("show", 0))});
        if (intent.getIntExtra("show", 0) != 1) {
            z = false;
        }
        bVar.nHq = z;
        if (!bVar.bAx() || z) {
            bVar.bAv();
        } else {
            bVar.bAw();
        }
    }
}
