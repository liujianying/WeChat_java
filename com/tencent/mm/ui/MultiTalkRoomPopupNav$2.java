package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MultiTalkRoomPopupNav.b;
import com.tencent.mm.ui.base.h;
import java.util.List;

class MultiTalkRoomPopupNav$2 implements OnClickListener {
    final /* synthetic */ String ltX;
    final /* synthetic */ MultiTalkRoomPopupNav toY;

    MultiTalkRoomPopupNav$2(MultiTalkRoomPopupNav multiTalkRoomPopupNav, String str) {
        this.toY = multiTalkRoomPopupNav;
        this.ltX = str;
    }

    public final void onClick(View view) {
        int i = 0;
        x.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
        if (this.ltX != null) {
            if (a.qyi.bgA()) {
                x.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
                h.b(this.toY.getContext(), ad.getContext().getString(R.l.multitalk_is_talking_cannot_enter), null, true);
                return;
            }
            List HE = a.qyi.HE(MultiTalkRoomPopupNav.b(this.toY));
            if (HE.size() == 1) {
                MultiTalkRoomPopupNav.ZT(this.ltX);
                com.tencent.mm.plugin.report.service.h.mEJ.h(13945, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(this.toY), Integer.valueOf(MultiTalkRoomPopupNav.c(this.toY).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(this.toY).field_roomKey)});
            } else if (HE.size() >= 9) {
                x.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + HE.size());
                h.b(this.toY.getContext(), ad.getContext().getString(R.l.multitalk_members_reach_max_limit, new Object[]{Integer.valueOf(9)}), null, true);
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(1);
                if (MultiTalkRoomPopupNav.d(this.toY) == b.tpa) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                objArr[2] = Integer.valueOf(1);
                objArr[3] = Integer.valueOf(1);
                objArr[4] = MultiTalkRoomPopupNav.b(this.toY);
                objArr[5] = Integer.valueOf(MultiTalkRoomPopupNav.c(this.toY).field_roomId);
                objArr[6] = Long.valueOf(MultiTalkRoomPopupNav.c(this.toY).field_roomKey);
                hVar.h(13945, objArr);
                return;
            } else if (a.qyi.bgz()) {
                x.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
                h.b(this.toY.getContext(), ad.getContext().getString(R.l.multitalk_inviting_in_another_group), null, true);
                com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.mEJ;
                Object[] objArr2 = new Object[7];
                objArr2[0] = Integer.valueOf(1);
                objArr2[1] = Integer.valueOf(MultiTalkRoomPopupNav.d(this.toY) == b.tpa ? 1 : 0);
                objArr2[2] = Integer.valueOf(0);
                objArr2[3] = Integer.valueOf(1);
                objArr2[4] = MultiTalkRoomPopupNav.b(this.toY);
                objArr2[5] = Integer.valueOf(MultiTalkRoomPopupNav.c(this.toY).field_roomId);
                objArr2[6] = Long.valueOf(MultiTalkRoomPopupNav.c(this.toY).field_roomKey);
                hVar2.h(13945, objArr2);
                return;
            } else {
                MultiTalkRoomPopupNav.a(this.toY, this.ltX);
            }
        }
        MultiTalkRoomPopupNav.a.a(MultiTalkRoomPopupNav.e(this.toY));
        MultiTalkRoomPopupNav.f(this.toY).setVisibility(0);
        MultiTalkRoomPopupNav.g(this.toY).setVisibility(0);
        MultiTalkRoomPopupNav.h(this.toY).setVisibility(8);
    }
}
