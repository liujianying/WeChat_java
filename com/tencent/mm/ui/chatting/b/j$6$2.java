package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.j.6;
import java.util.HashSet;

class j$6$2 implements a {
    final /* synthetic */ bd dAs;
    final /* synthetic */ 6 tOX;
    final /* synthetic */ HashSet tOY;

    j$6$2(6 6, bd bdVar, HashSet hashSet) {
        this.tOX = 6;
        this.dAs = bdVar;
        this.tOY = hashSet;
    }

    public final void a(a.a aVar) {
        if (this.dAs.field_imgPath.equals(aVar.fileName)) {
            r nW = t.nW(aVar.fileName);
            if (nW == null || !nW.Tp()) {
                x.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[]{Long.valueOf(this.dAs.field_msgId), aVar.fileName});
            } else {
                x.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[]{Long.valueOf(this.dAs.field_msgId), aVar.fileName});
            }
            o.Ta().a(this);
            this.tOY.remove(Long.valueOf(this.dAs.field_msgId));
            6.a(this.tOX, this.tOY);
        }
    }
}
