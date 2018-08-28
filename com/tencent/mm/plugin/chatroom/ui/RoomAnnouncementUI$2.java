package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

class RoomAnnouncementUI$2 extends p {
    final /* synthetic */ RoomAnnouncementUI hNd;

    RoomAnnouncementUI$2(RoomAnnouncementUI roomAnnouncementUI) {
        this.hNd = roomAnnouncementUI;
    }

    public final boolean b(WebView webView, String str) {
        if (!str.equals("weixin://chatroom/upgradeagree")) {
            return false;
        }
        a.a(this.hNd, RoomAnnouncementUI.b(this.hNd), RoomAnnouncementUI.c(this.hNd));
        return true;
    }
}
