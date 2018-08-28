package com.tencent.mm.ui.chatting.b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.k;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.b.b.w;

@a(cwo = k.class)
public class n extends a implements k {
    @TargetApi(11)
    public final void cuY() {
        if (VERSION.SDK_INT < 11) {
            x.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
            return;
        }
        if (this.bAG.getListView() != null) {
            this.bAG.getListView().setOnDragListener(null);
        }
        ChatFooter cvb = ((m) this.bAG.O(m.class)).cvb();
        if (cvb != null) {
            cvb.setOnDragListener(null);
            cvb.setEditTextOnDragListener(null);
        }
    }

    @TargetApi(11)
    public final void cuZ() {
        boolean cvQ = ((w) this.bAG.O(w.class)).cvQ();
        boolean cvR = ((w) this.bAG.O(w.class)).cvR();
        if (!cvQ && !cvR) {
            if (VERSION.SDK_INT < 11) {
                x.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
            } else {
                new 1(this).run();
            }
        }
    }

    public final void cpG() {
        cuZ();
    }

    public final void cpK() {
        cuY();
    }
}
