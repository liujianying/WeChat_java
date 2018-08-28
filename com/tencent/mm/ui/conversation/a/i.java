package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.k.g;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;

public final class i extends b {
    int csE;
    private c tiA;
    View usj;

    public i(Context context) {
        super(context);
        this.usj = View.inflate(context, R.i.invite_friend_view_in_chat, null);
        if (this.usj != null) {
            this.csE = ai.getInt(g.AT().getValue("InviteFriendsControlFlags"), 0);
            this.usj.setVisibility(8);
            this.usj.setPadding(0, -a.fromDPToPix(context, R.f.NormalListHeight), 0, 0);
            if ((this.csE & 1) > 0) {
                this.usj.setVisibility(0);
                this.usj.setPadding(0, 0, 0, 0);
            }
            this.usj.setOnClickListener(new 1(this, context));
            this.tiA = new 2(this);
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean anR() {
        com.tencent.mm.sdk.b.a.sFg.b(this.tiA);
        return this.usj != null && this.usj.getVisibility() == 0;
    }

    public final void release() {
        com.tencent.mm.sdk.b.a.sFg.c(this.tiA);
    }

    public final void destroy() {
    }

    public final View getView() {
        return this.usj;
    }
}
