package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.plugin.sns.ui.g.b;

class ArtistUI$2 extends b {
    final /* synthetic */ ArtistUI nLn;

    ArtistUI$2(ArtistUI artistUI) {
        this.nLn = artistUI;
    }

    public final void xf(int i) {
        Intent intent = new Intent();
        intent.putExtra("sns_gallery_is_artist", true);
        intent.putExtra("sns_gallery_position", i);
        intent.putExtra("sns_gallery_artist_lan", ArtistUI.a(this.nLn));
        intent.putExtra("sns_gallery_showtype", 2);
        intent.setClass(this.nLn, ArtistBrowseUI.class);
        this.nLn.startActivity(intent);
    }
}
