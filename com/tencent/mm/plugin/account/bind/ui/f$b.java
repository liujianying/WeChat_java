package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.ui.applet.SecurityImage.b;

class f$b extends b {
    final /* synthetic */ f eJe;

    f$b(f fVar) {
        this.eJe = fVar;
    }

    public final void Xe() {
        this.eJe.FC();
        g.DF().a(new ab(5, this.eJe.eIY, this.eJe.eIX.getSecImgSid(), this.eJe.eIX.getSecImgCode(), this.eJe.eIX.getSecImgEncryptKey(), true, 1), 0);
    }
}
