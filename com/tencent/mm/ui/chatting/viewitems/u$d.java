package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class u$d extends a {
    ProgressBar mgA;
    ImageView uai;
    RTChattingEmojiView ubd;
    ImageView ube;
    ViewStub ucP;

    u$d() {
    }

    public final a q(View view, boolean z) {
        super.dx(view);
        this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
        this.ubd = (RTChattingEmojiView) view.findViewById(R.h.chatting_content_iv);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        if (z) {
            this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
        } else {
            this.mgA = (ProgressBar) view.findViewById(R.h.uploading_pb);
            this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
            this.tZv = (ImageView) view.findViewById(R.h.chatting_state_iv);
            this.uai = (ImageView) view.findViewById(R.h.chatting_status_tick);
        }
        if (this.ube != null) {
            ((ViewGroup) this.ube.getParent()).setBackgroundDrawable(null);
        }
        this.ucP = (ViewStub) view.findViewById(R.h.chatting_reward_tips);
        return this;
    }
}
