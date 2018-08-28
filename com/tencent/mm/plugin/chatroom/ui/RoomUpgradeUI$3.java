package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

class RoomUpgradeUI$3 implements OnClickListener {
    final /* synthetic */ RoomUpgradeUI hOi;

    RoomUpgradeUI$3(RoomUpgradeUI roomUpgradeUI) {
        this.hOi = roomUpgradeUI;
    }

    public final void onClick(View view) {
        if (RoomUpgradeUI.e(this.hOi).getVisibility() == 0) {
            Intent intent = new Intent();
            RoomUpgradeUI.a(this.hOi, this.hOi.getString(R.l.chatroom_how_to_upgrade, new Object[]{w.chP()}));
            intent.putExtra("rawUrl", RoomUpgradeUI.f(this.hOi));
            intent.putExtra("geta8key_username", q.GF());
            intent.putExtra("showShare", false);
            d.b(this.hOi, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, TbsListener$ErrorCode.INFO_CODE_MINIQB);
        }
    }
}
