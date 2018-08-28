package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.c;
import com.tencent.mm.sdk.platformtools.x;

class UnfamiliarContactDetailUI$c$2 implements OnClickListener {
    final /* synthetic */ UnfamiliarContactDetailUI mVg;
    final /* synthetic */ c mVh;

    UnfamiliarContactDetailUI$c$2(c cVar, UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.mVh = cVar;
        this.mVg = unfamiliarContactDetailUI;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        x.i("MicroMsg.UnfamiliarContactUI", "position:%s", new Object[]{Integer.valueOf(intValue), UnfamiliarContactDetailUI.e(this.mVh.mUT).vS(intValue).daA});
        c.a(this.mVh, r1, intValue);
    }
}
