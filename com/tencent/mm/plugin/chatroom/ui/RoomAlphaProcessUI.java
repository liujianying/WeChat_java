package com.tencent.mm.plugin.chatroom.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.chatroom.d.o;
import com.tencent.mm.plugin.chatroom.ui.a.1;
import com.tencent.mm.plugin.chatroom.ui.a.2;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
@Deprecated
public class RoomAlphaProcessUI extends MMActivity implements a$a {
    private String chatroomName;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
        o oVar = new o(this.chatroomName);
        au.DF().a(482, new 2(h.a(this, getString(R.l.loading_tips), false, new 1()), this, this));
        au.DF().a(oVar, 0);
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
    }

    public final int getLayoutId() {
        return -1;
    }

    private static void w(Runnable runnable) {
        new ag().postDelayed(runnable, 200);
    }

    public final void h(boolean z, int i) {
        if (z) {
            h.bA(this, getString(R.l.room_upgrade_success));
            w(new 1(this, z, i));
            return;
        }
        h.a(this, getString(R.l.room_upgrade_result_failed), "", null);
        w(new 2(this, z));
    }
}
