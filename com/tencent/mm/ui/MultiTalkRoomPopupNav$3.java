package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.sdk.platformtools.x;

class MultiTalkRoomPopupNav$3 implements OnClickListener {
    final /* synthetic */ String ltX;
    final /* synthetic */ MultiTalkRoomPopupNav toY;

    MultiTalkRoomPopupNav$3(MultiTalkRoomPopupNav multiTalkRoomPopupNav, String str) {
        this.toY = multiTalkRoomPopupNav;
        this.ltX = str;
    }

    public final void onClick(View view) {
        int i = 1;
        x.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
        if (MultiTalkRoomPopupNav.d(this.toY) == MultiTalkRoomPopupNav$b.tpa) {
            x.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
            boolean HG = a.qyi.HG(this.ltX);
            a.qyi.HH(this.ltX);
            h hVar = h.mEJ;
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(3);
            objArr[1] = Integer.valueOf(1);
            objArr[2] = Integer.valueOf(0);
            if (HG) {
                i = 0;
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = MultiTalkRoomPopupNav.b(this.toY);
            objArr[5] = Integer.valueOf(MultiTalkRoomPopupNav.c(this.toY).field_roomId);
            objArr[6] = Long.valueOf(MultiTalkRoomPopupNav.c(this.toY).field_roomKey);
            hVar.h(13945, objArr);
        } else {
            h.mEJ.h(13945, new Object[]{Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.b(this.toY), Integer.valueOf(MultiTalkRoomPopupNav.c(this.toY).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(this.toY).field_roomKey)});
        }
        MultiTalkRoomPopupNav.e(this.toY).toZ.setVisibility(8);
        MultiTalkRoomPopupNav.f(this.toY).setVisibility(0);
        MultiTalkRoomPopupNav.g(this.toY).setVisibility(0);
        MultiTalkRoomPopupNav.h(this.toY).setVisibility(8);
    }
}
