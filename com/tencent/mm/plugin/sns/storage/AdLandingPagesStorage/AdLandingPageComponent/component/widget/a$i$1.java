package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.i;
import com.tencent.mm.sdk.platformtools.x;

class a$i$1 implements OnErrorListener {
    final /* synthetic */ i nGH;

    a$i$1(i iVar) {
        this.nGH = iVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[]{a.a(this.nGH.nGD), Integer.valueOf(i), Integer.valueOf(i2)});
        this.nGH.nGD.clear();
        if (a.b(this.nGH.nGD) != null) {
            a.b(this.nGH.nGD).wS(-1);
        }
        return true;
    }
}
