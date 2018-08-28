package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.s;

class k$2 implements OnClickListener {
    final /* synthetic */ int bpX;
    final /* synthetic */ int tiP;
    final /* synthetic */ k usq;

    k$2(k kVar, int i, int i2) {
        this.usq = kVar;
        this.bpX = i;
        this.tiP = i2;
    }

    public final void onClick(View view) {
        bc.Ig().ba(this.bpX, this.tiP);
        Context context = (Context) this.usq.qJS.get();
        if (context != null) {
            au.HU();
            if (c.isSDCardAvailable()) {
                Intent intent = new Intent();
                intent.putExtra("intent_set_avatar", true);
                intent.putExtra("KEnterFromBanner", true);
                d.b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
                h.mEJ.h(11002, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
                return;
            }
            s.gH(context);
        }
    }
}
