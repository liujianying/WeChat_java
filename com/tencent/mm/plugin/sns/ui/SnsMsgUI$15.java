package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r.a;

class SnsMsgUI$15 implements a {
    final /* synthetic */ SnsMsgUI nYl;

    SnsMsgUI$15(SnsMsgUI snsMsgUI) {
        this.nYl = snsMsgUI;
    }

    public final void Xa() {
    }

    public final void Xb() {
        x.v("MicroMsg.SnsMsgUI", "total count:" + SnsMsgUI.e(this.nYl).edl + " unread:" + af.byt().axd() + "  showcount:" + SnsMsgUI.e(this.nYl).hFO);
        if (SnsMsgUI.e(this.nYl).getCount() == 0) {
            SnsMsgUI.c(this.nYl).setVisibility(8);
            SnsMsgUI.d(this.nYl).setVisibility(0);
            this.nYl.enableOptionMenu(false);
        } else {
            SnsMsgUI.c(this.nYl).setVisibility(0);
            SnsMsgUI.d(this.nYl).setVisibility(8);
            this.nYl.enableOptionMenu(true);
        }
        if ((SnsMsgUI.e(this.nYl).ayQ() && af.byt().axd() == 0) || af.byt().axd() == af.byt().bAQ()) {
            SnsMsgUI.f(this.nYl).setVisibility(8);
        }
    }
}
