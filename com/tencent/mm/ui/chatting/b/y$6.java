package com.tencent.mm.ui.chatting.b;

import android.os.Looper;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class y$6 implements a {
    final /* synthetic */ bd dAs;
    final /* synthetic */ y tQV;

    y$6(y yVar, bd bdVar) {
        this.tQV = yVar;
        this.dAs = bdVar;
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, l lVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, l lVar) {
        boolean z = i3 == 0 && i4 == 0;
        x.i("MicroMsg.ChattingUI.MessBoxComponent", "oreh downloadImgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[]{Boolean.valueOf(z), Long.valueOf(this.dAs.field_msgId), Integer.valueOf(i3), Integer.valueOf(i4)});
        new ag(Looper.getMainLooper()).post(new 1(this));
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        x.i("MicroMsg.ChattingUI.MessBoxComponent", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[]{Long.valueOf(this.dAs.field_msgId)});
    }
}
