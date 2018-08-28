package com.tencent.mm.ui.conversation.a;

import com.tencent.mm.g.a.im;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class o$1 extends c<im> {
    final /* synthetic */ o usZ;

    o$1(o oVar) {
        this.usZ = oVar;
        this.sFo = im.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((im) bVar).bRX.bQA) {
            this.usZ.usX = false;
            this.usZ.anR();
        } else {
            x.i("MicroMsg.TryNewInitBanner", "summerinit onSceneEnd -1 show tryNewInitBanner[%s]", new Object[]{this.usZ});
            this.usZ.usX = true;
            this.usZ.anR();
        }
        return false;
    }
}
