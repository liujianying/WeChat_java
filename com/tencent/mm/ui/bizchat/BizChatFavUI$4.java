package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.w;
import com.tencent.mm.ac.z;

class BizChatFavUI$4 implements OnCancelListener {
    final /* synthetic */ BizChatFavUI tEG;
    final /* synthetic */ w tEH;

    BizChatFavUI$4(BizChatFavUI bizChatFavUI, w wVar) {
        this.tEG = bizChatFavUI;
        this.tEH = wVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        z.Ng();
        h.f(this.tEH);
    }
}
