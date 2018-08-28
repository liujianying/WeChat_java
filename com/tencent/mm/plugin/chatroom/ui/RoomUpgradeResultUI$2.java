package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.w;

class RoomUpgradeResultUI$2 implements OnClickListener {
    final /* synthetic */ RoomUpgradeResultUI hNY;

    RoomUpgradeResultUI$2(RoomUpgradeResultUI roomUpgradeResultUI) {
        this.hNY = roomUpgradeResultUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.hNY.getString(R.l.chatroom_how_to_upgrade, new Object[]{w.chP()}));
        intent.putExtra("geta8key_username", q.GF());
        d.c(this.hNY, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", 0);
    }
}
