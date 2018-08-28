package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.chatroom.ui.SelectDelRoomMemberUI.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;

class SelectDelRoomMemberUI$4 implements OnItemClickListener {
    final /* synthetic */ SelectDelRoomMemberUI hPa;

    SelectDelRoomMemberUI$4(SelectDelRoomMemberUI selectDelRoomMemberUI) {
        this.hPa = selectDelRoomMemberUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        SelectDelRoomMemberUI.b(this.hPa);
        ab oj = a.oj(i);
        if (oj != null) {
            SelectDelRoomMemberUI.a(this.hPa, oj.field_username);
            String str = oj.field_nickname;
            String b = SelectDelRoomMemberUI.b(SelectDelRoomMemberUI.c(this.hPa), SelectDelRoomMemberUI.d(this.hPa));
            if (bi.oW(b)) {
                SelectDelRoomMemberUI.b(this.hPa, oj.BL());
            } else {
                SelectDelRoomMemberUI.b(this.hPa, b);
            }
            SelectDelRoomMemberUI.a(this.hPa, SelectDelRoomMemberUI.d(this.hPa), SelectDelRoomMemberUI.e(this.hPa), str);
        }
    }
}
