package com.tencent.mm.plugin.wear.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class WearYoUI$1 implements OnClickListener {
    final /* synthetic */ WearYoUI pKt;

    WearYoUI$1(WearYoUI wearYoUI) {
        this.pKt = wearYoUI;
    }

    public final void onClick(View view) {
        a.bSl();
        x.i("MicroMsg.wear.WearYoLogic", "click avatarIV %s", new Object[]{WearYoUI.a(this.pKt)});
        Intent intent = new Intent();
        intent.putExtra("Main_User", r0);
        intent.putExtra("From_fail_notify", true);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        d.e(ad.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
        this.pKt.finish();
    }
}
