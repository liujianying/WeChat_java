package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.18;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class SnsAdNativeLandingPagesUI$18$1 implements c {
    final /* synthetic */ 18 nTa;

    SnsAdNativeLandingPagesUI$18$1(18 18) {
        this.nTa = 18;
    }

    public final void a(l lVar) {
        if (SnsAdNativeLandingPagesUI.s(this.nTa.nSR) == 0 || (SnsAdNativeLandingPagesUI.s(this.nTa.nSR) & 2) == 0) {
            lVar.a(1, this.nTa.nSR.getString(j.retransmits), i.bottomsheet_icon_transmit);
        }
        if (SnsAdNativeLandingPagesUI.s(this.nTa.nSR) == 0 || (SnsAdNativeLandingPagesUI.s(this.nTa.nSR) & 1) == 0) {
            lVar.a(2, this.nTa.nSR.getString(j.sns_ad_video_right_menu_share_sns), i.bottomsheet_icon_moment);
        }
        if ((SnsAdNativeLandingPagesUI.s(this.nTa.nSR) == 0 || (SnsAdNativeLandingPagesUI.s(this.nTa.nSR) & 4) == 0) && SnsAdNativeLandingPagesUI.t(this.nTa.nSR) != 7) {
            lVar.a(3, this.nTa.nSR.getString(j.chatting_fav), i.bottomsheet_icon_fav);
        }
        if ((SnsAdNativeLandingPagesUI.s(this.nTa.nSR) == 0 || SnsAdNativeLandingPagesUI.u(this.nTa.nSR)) && SnsAdNativeLandingPagesUI.v(this.nTa.nSR) == 2 && SnsAdNativeLandingPagesUI.w(this.nTa.nSR)) {
            lVar.a(4, SnsAdNativeLandingPagesUI.x(this.nTa.nSR) != null ? SnsAdNativeLandingPagesUI.x(this.nTa.nSR) : "", 0);
        }
    }
}
