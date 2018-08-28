package com.tencent.mm.ui.chatting.g;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.i;
import java.util.List;
import java.util.Set;

class e$5 implements OnClickListener {
    final /* synthetic */ List gco;
    final /* synthetic */ Set tUO;
    final /* synthetic */ e tYu;

    e$5(e eVar, Set set, List list) {
        this.tYu = eVar;
        this.tUO = set;
        this.gco = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "delete message");
        i.a(e.b(this.tYu), this.tUO, new 1(this));
    }
}
