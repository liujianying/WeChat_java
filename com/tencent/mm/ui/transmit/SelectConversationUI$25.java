package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.mm.modelappbrand.g;

class SelectConversationUI$25 implements OnDismissListener {
    final /* synthetic */ String fwt;
    final /* synthetic */ SelectConversationUI uEC;
    final /* synthetic */ View val$view;

    SelectConversationUI$25(SelectConversationUI selectConversationUI, String str, View view) {
        this.uEC = selectConversationUI;
        this.fwt = str;
        this.val$view = view;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        ((g) com.tencent.mm.kernel.g.l(g.class)).a(this.fwt, this.val$view);
    }
}
