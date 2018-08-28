package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.ui.base.h;
import com.tencent.xweb.WebView;
import com.tencent.xweb.f;
import com.tencent.xweb.j;

class RoomAnnouncementUI$1 extends j {
    final /* synthetic */ RoomAnnouncementUI hNd;

    RoomAnnouncementUI$1(RoomAnnouncementUI roomAnnouncementUI) {
        this.hNd = roomAnnouncementUI;
    }

    public final boolean a(WebView webView, String str, String str2, f fVar) {
        h.a(this.hNd, str2, null, new 1(this));
        fVar.cancel();
        return true;
    }
}
