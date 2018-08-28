package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.setting.b;

class GetQRCodeInfoUI$1 implements a {
    final /* synthetic */ GetQRCodeInfoUI mPA;

    GetQRCodeInfoUI$1(GetQRCodeInfoUI getQRCodeInfoUI) {
        this.mPA = getQRCodeInfoUI;
    }

    public final void a(e eVar) {
        if (eVar == null) {
            this.mPA.finish();
        } else if (!g.Eg().Dx() || com.tencent.mm.kernel.a.Dr()) {
            b.ezn.q(new Intent(), this.mPA);
            this.mPA.finish();
        } else {
            GetQRCodeInfoUI.a(this.mPA, this.mPA.getIntent().getDataString());
        }
    }
}
