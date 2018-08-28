package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.TestTimeForSns.a;
import com.tencent.mm.sdk.platformtools.x;

class SnsTimeLineUI$30 implements a {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$30(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void aRL() {
        x.i("MicroMsg.SnsTimeLineUI", "sns has drawed");
        SnsTimeLineUI.y(this.odw).post(new 1(this));
    }
}
