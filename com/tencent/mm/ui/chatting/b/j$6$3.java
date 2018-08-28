package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ab.l;
import com.tencent.mm.ak.d$a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.j.6;
import java.util.HashSet;

class j$6$3 implements d$a {
    final /* synthetic */ bd dAs;
    final /* synthetic */ 6 tOX;
    final /* synthetic */ HashSet tOY;

    j$6$3(6 6, bd bdVar, HashSet hashSet) {
        this.tOX = 6;
        this.dAs = bdVar;
        this.tOY = hashSet;
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, l lVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, l lVar) {
        boolean z = i3 == 0 && i4 == 0;
        x.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[]{Boolean.valueOf(z), Long.valueOf(this.dAs.field_msgId), Integer.valueOf(i3), Integer.valueOf(i4)});
        this.tOY.remove(Long.valueOf(this.dAs.field_msgId));
        6.a(this.tOX, this.tOY);
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        x.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[]{Long.valueOf(this.dAs.field_msgId)});
        this.tOY.remove(Long.valueOf(this.dAs.field_msgId));
        6.a(this.tOX, this.tOY);
    }
}
