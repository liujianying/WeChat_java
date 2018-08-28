package com.tencent.mm.plugin.music.model.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.source.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

class a$d implements a {
    final /* synthetic */ a lyY;

    private a$d(a aVar) {
        this.lyY = aVar;
    }

    /* synthetic */ a$d(a aVar, byte b) {
        this(aVar);
    }

    public final void a(i iVar, Format format, IOException iOException) {
        a.a(this.lyY, "loadError", iOException);
        if (!(iVar == null || format == null)) {
            x.e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", new Object[]{iVar.uri, format.toString()});
        }
        this.lyY.cX(-4004, -40);
    }

    public final void ku() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
    }

    public final void kv() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
        this.lyY.auM = true;
    }
}
