package com.tencent.mm.plugin.music.model.notification;

import android.graphics.Bitmap;
import com.tencent.mm.ak.a.c.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.an.a;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements c {
    final /* synthetic */ a lxY;
    final /* synthetic */ a lzj;
    final /* synthetic */ String lzk;

    a$3(a aVar, a aVar2, String str) {
        this.lzj = aVar;
        this.lxY = aVar2;
        this.lzk = str;
    }

    public final void a(boolean z, Object... objArr) {
        x.i("MicroMsg.Music.MMMusicNotification", "music.field_songAlbumUrl:%s, success:%b", new Object[]{this.lxY.field_songAlbumUrl, Boolean.valueOf(z)});
        if (z) {
            Bitmap decodeFile = com.tencent.mm.sdk.platformtools.c.decodeFile(this.lzk, null);
            if (decodeFile == null) {
                x.e("MicroMsg.Music.MMMusicNotification", "bitmap is null, return");
                return;
            }
            o.Pj().j(this.lxY.field_songAlbumUrl, decodeFile);
            this.lzj.lzf.refresh();
        }
    }
}
