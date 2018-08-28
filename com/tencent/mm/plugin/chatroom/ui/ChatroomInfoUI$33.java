package com.tencent.mm.plugin.chatroom.ui;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.x;

class ChatroomInfoUI$33 implements AnimationListener {
    final /* synthetic */ ChatroomInfoUI hLX;
    final /* synthetic */ LinearLayout hMo;

    ChatroomInfoUI$33(ChatroomInfoUI chatroomInfoUI, LinearLayout linearLayout) {
        this.hLX = chatroomInfoUI;
        this.hMo = linearLayout;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        boolean z = true;
        ViewGroup viewGroup = (ViewGroup) this.hLX.getWindow().findViewById(16908290);
        String str = "MicroMsg.ChatroomInfoUI";
        String str2 = "remove cover view now. contentView is null [%b]";
        Object[] objArr = new Object[1];
        if (viewGroup != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (viewGroup != null) {
            viewGroup.removeView(this.hMo);
        }
        this.hLX.kww.setTranscriptMode(ChatroomInfoUI.E(this.hLX));
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
