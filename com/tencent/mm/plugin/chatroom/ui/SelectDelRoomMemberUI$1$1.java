package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.chatroom.ui.SelectDelRoomMemberUI.1;
import com.tencent.mm.sdk.platformtools.bi;

class SelectDelRoomMemberUI$1$1 implements OnClickListener {
    final /* synthetic */ 1 hPb;

    SelectDelRoomMemberUI$1$1(1 1) {
        this.hPb = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("Select_Contact", bi.c(SelectDelRoomMemberUI.a(this.hPb.hPa), ","));
        this.hPb.hPa.setResult(-1, intent);
        this.hPb.hPa.finish();
    }
}
