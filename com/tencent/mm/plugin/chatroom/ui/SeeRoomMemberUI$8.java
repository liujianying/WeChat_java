package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class SeeRoomMemberUI$8 implements OnItemLongClickListener {
    final /* synthetic */ SeeRoomMemberUI hOM;

    SeeRoomMemberUI$8(SeeRoomMemberUI seeRoomMemberUI) {
        this.hOM = seeRoomMemberUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (SeeRoomMemberUI.j(this.hOM)) {
            ai aiVar = SeeRoomMemberUI.c(this.hOM).oi(i).guS;
            if (aiVar != null) {
                if (!SeeRoomMemberUI.f(this.hOM).field_roomowner.equals(aiVar.field_username)) {
                    h.a(this.hOM, this.hOM.getString(R.l.room_del_this_member_tip), "", new 1(this, i), new 2(this));
                }
            }
        } else {
            x.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
        }
        return true;
    }
}
