package com.tencent.mm.ui.chatting.b;

import android.view.ViewStub;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter$c;

class ao$2 implements ChatFooter$c {
    final /* synthetic */ ao tTj;

    ao$2(ao aoVar) {
        this.tTj = aoVar;
    }

    public final void h(Boolean bool) {
        if (bool.booleanValue()) {
            if (ao.a(this.tTj) == null) {
                ao.a(this.tTj, ((ViewStub) this.tTj.bAG.findViewById(R.h.viewstub_voiceinput_mask_view)).inflate());
            }
            ao.a(this.tTj).setVisibility(0);
        } else if (ao.a(this.tTj) != null && ao.a(this.tTj).getVisibility() == 0) {
            ao.a(this.tTj).setVisibility(8);
        }
    }
}
