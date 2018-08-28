package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.an.b;
import com.tencent.mm.an.b.7;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.plugin.scanner.ui.MusicPreference.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class ProductUI$4 implements a {
    final /* synthetic */ ProductUI mJt;

    ProductUI$4(ProductUI productUI) {
        this.mJt = productUI;
    }

    public final void d(MusicPreference musicPreference) {
        if (musicPreference == null) {
            x.e("MicroMsg.scanner.ProductUI", "onMusicPrefClick, musicPref == null");
        } else if (bi.oW(musicPreference.mFv) && bi.oW(musicPreference.mFw)) {
            x.w("MicroMsg.scanner.ProductUI", "wifiurl = null,  wapurl = null");
            if (!bi.oW(musicPreference.mFx)) {
                ProductUI.a(this.mJt, musicPreference.mFx);
            }
        } else {
            if (ProductUI.KO(String.format("%s_cd_%s", new Object[]{musicPreference.mFv, musicPreference.mKey}))) {
                b.PW();
                x.d("MicroMsg.scanner.ProductUI", "isTheSameId, playMusicId : [%s]", new Object[]{r1});
            } else if (musicPreference.getTitle() == null) {
                x.e("MicroMsg.scanner.ProductUI", "onPlayBtnClick, getTitle() == null");
                return;
            } else {
                String str;
                int i = -1;
                if (ProductUI.m(this.mJt) == null) {
                    str = null;
                } else {
                    str = ProductUI.m(this.mJt).Vv();
                }
                String format = String.format("%s_cd_%s", new Object[]{musicPreference.mFv, musicPreference.mKey});
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                for (MusicPreference musicPreference2 : ProductUI.n(this.mJt)) {
                    int i3;
                    String format2 = String.format("%s_cd_%s", new Object[]{musicPreference2.mFv, musicPreference2.mKey});
                    if (format.equals(format2)) {
                        i3 = i2;
                    } else {
                        i3 = i;
                    }
                    ArrayList arrayList2 = arrayList;
                    arrayList2.add(((com.tencent.mm.an.a.b) g.l(com.tencent.mm.an.a.b.class)).a(5, str, musicPreference2.getTitle().toString(), "", musicPreference2.mFx, musicPreference2.mFw, musicPreference2.mFv, format2, c.Gq(), str, "", "wx482a4001c37e2b74"));
                    i2++;
                    i = i3;
                }
                if (i >= 0) {
                    ah.A(new 7(arrayList, i));
                } else {
                    return;
                }
            }
            ProductUI.o(this.mJt);
        }
    }
}
