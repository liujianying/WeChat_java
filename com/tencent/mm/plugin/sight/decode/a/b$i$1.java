package com.tencent.mm.plugin.sight.decode.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.plugin.sight.decode.a.b.i;
import com.tencent.mm.sdk.platformtools.x;

class b$i$1 implements OnErrorListener {
    final /* synthetic */ i ndd;

    b$i$1(i iVar) {
        this.ndd = iVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[]{b.a(this.ndd.ncT), Integer.valueOf(i), Integer.valueOf(i2)});
        this.ndd.ncT.clear();
        if (b.b(this.ndd.ncT) != null) {
            b.b(this.ndd.ncT).d(this.ndd.ncT, -1);
        }
        return true;
    }
}
