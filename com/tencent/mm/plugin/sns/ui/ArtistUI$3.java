package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.g.a;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.x;

class ArtistUI$3 implements a {
    final /* synthetic */ ArtistUI nLn;

    ArtistUI$3(ArtistUI artistUI) {
        this.nLn = artistUI;
    }

    public final void a(dx dxVar) {
        if (ArtistUI.b(this.nLn) != null) {
            ArtistUI.b(this.nLn).setVisibility(0);
            ArtistUI.b(this.nLn).setUserName(dxVar);
            String str = dxVar.jPe;
            if (!(str == null || str.equals(""))) {
                ArtistUI.c(this.nLn).edit().putString("artist_name", str).commit();
            }
            if (ArtistUI.d(this.nLn) != null) {
                ArtistUI.d(this.nLn).notifyDataSetChanged();
            }
        }
        ArtistUI.e(this.nLn).dismiss();
    }

    public final void bBK() {
        if (ArtistUI.f(this.nLn) == null && ArtistUI.e(this.nLn) != null) {
            x.d("MicroMsg.ArtistUI", "onNothingBgGet");
            com.tencent.mm.plugin.sns.c.a.ezo.aG(true);
        }
    }
}
