package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.d;

public class t$l extends d {
    public t$l(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, bd bdVar) {
        h.a(aVar.tTq.getContext(), aVar.tTq.getMMResources().getString(R.l.emoji_chatting_reward_tips_disable_msg), "", aVar.tTq.getMMResources().getString(R.l.emoji_chatting_reward_tips_enable), aVar.tTq.getMMResources().getString(R.l.emoji_chatting_reward_tips_disable), new 1(this), new 2(this));
    }
}
