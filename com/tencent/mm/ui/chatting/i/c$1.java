package com.tencent.mm.ui.chatting.i;

import android.view.View;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.ui.chatting.i.a.b;
import java.util.LinkedList;

class c$1 extends a {
    final /* synthetic */ LinkedList mPh;
    final /* synthetic */ c tYT;

    c$1(c cVar, LinkedList linkedList) {
        this.tYT = cVar;
        this.mPh = linkedList;
    }

    public final void onClickImp(View view) {
        c cVar = this.tYT;
        LinkedList linkedList = this.mPh;
        if (cVar.tYP != null && cVar.tYP.get() != null) {
            ((b) cVar.tYP.get()).ay(linkedList);
        }
    }
}
