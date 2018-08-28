package com.tencent.mm.view.a;

import com.tencent.mm.ak.a.c.e;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.emotion.EmojiInfo;

class c$1 implements e {
    final /* synthetic */ c uTM;

    c$1(c cVar) {
        this.uTM = cVar;
    }

    public final void g(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            Object obj = objArr[0];
            if (obj != null && (obj instanceof EmojiInfo)) {
                cp cpVar = new cp();
                cpVar.bKa.scene = 1;
                cpVar.bKa.bKb = (EmojiInfo) obj;
                cpVar.bKa.context = this.uTM.mContext;
                a.sFg.m(cpVar);
            }
        }
    }
}
