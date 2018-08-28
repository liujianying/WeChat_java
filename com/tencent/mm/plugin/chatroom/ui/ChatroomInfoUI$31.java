package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class ChatroomInfoUI$31 implements a {
    final /* synthetic */ String dhm;
    final /* synthetic */ ChatroomInfoUI hLX;
    int hMm = 0;

    ChatroomInfoUI$31(ChatroomInfoUI chatroomInfoUI, String str) {
        this.hLX = chatroomInfoUI;
        this.dhm = str;
    }

    public final boolean vD() {
        if (ChatroomInfoUI.f(this.hLX) == null || this.hMm > 50) {
            return false;
        }
        int height;
        View childAt = this.hLX.kww.getChildAt(ChatroomInfoUI.f(this.hLX).aab(this.dhm) - this.hLX.kww.getFirstVisiblePosition());
        if (childAt != null) {
            height = childAt.getHeight();
        } else {
            height = 0;
        }
        if (height == 0) {
            this.hMm++;
            return true;
        }
        x.d("MicroMsg.ChatroomInfoUI", "show cover view get y[%f] height [%d] index[%d] [%d %d]", new Object[]{Float.valueOf(childAt.getY()), Integer.valueOf(height), Integer.valueOf(r3), Integer.valueOf(this.hLX.kww.getFirstVisiblePosition()), Integer.valueOf(this.hLX.kww.getLastVisiblePosition())});
        int y = (int) childAt.getY();
        if (y < 0) {
            height += y;
            y = 0;
        }
        ChatroomInfoUI.a(this.hLX, y, height);
        return false;
    }
}
