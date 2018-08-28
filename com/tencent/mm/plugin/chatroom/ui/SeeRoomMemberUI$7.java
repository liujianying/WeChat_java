package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.plugin.chatroom.ui.SeeRoomMemberUI.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SeeRoomMemberUI$7 implements OnItemClickListener {
    final /* synthetic */ SeeRoomMemberUI hOM;

    SeeRoomMemberUI$7(SeeRoomMemberUI seeRoomMemberUI) {
        this.hOM = seeRoomMemberUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a oi = SeeRoomMemberUI.c(this.hOM).oi(i);
        if (oi.type == 2) {
            x.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
            h.mEJ.a(219, 6, 1, true);
            SeeRoomMemberUI.d(this.hOM);
        } else if (oi.type == 3) {
            x.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
            SeeRoomMemberUI.e(this.hOM);
        } else if (oi.type == 1) {
            ai aiVar = SeeRoomMemberUI.c(this.hOM).oi(i).guS;
            if (aiVar == null) {
                x.e("MicroMsg.SeeRoomMemberUI", "cont is null");
                return;
            }
            SeeRoomMemberUI.a(this.hOM, aiVar.field_username);
            String str = aiVar.field_nickname;
            String a = SeeRoomMemberUI.a(SeeRoomMemberUI.f(this.hOM), SeeRoomMemberUI.g(this.hOM));
            if (bi.oW(a)) {
                SeeRoomMemberUI.b(this.hOM, aiVar.BL());
            } else {
                SeeRoomMemberUI.b(this.hOM, a);
            }
            com.tencent.mm.ui.contact.x.n(SeeRoomMemberUI.h(this.hOM).getText().toString(), 1, 6, i + 1);
            SeeRoomMemberUI.a(this.hOM, SeeRoomMemberUI.g(this.hOM), SeeRoomMemberUI.i(this.hOM), str);
        }
    }
}
