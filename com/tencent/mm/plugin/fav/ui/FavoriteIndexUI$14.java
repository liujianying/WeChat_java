package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class FavoriteIndexUI$14 implements Runnable {
    final /* synthetic */ FavoriteIndexUI jbh;

    FavoriteIndexUI$14(FavoriteIndexUI favoriteIndexUI) {
        this.jbh = favoriteIndexUI;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        List aLG = ((ae) g.n(ae.class)).getFavItemInfoStorage().aLG();
        if (aLG != null) {
            x.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem getInvalid favitems , size = %d,start time = %s", new Object[]{Integer.valueOf(aLG.size()), Long.valueOf(currentTimeMillis)});
            if (aLG.size() != 0) {
                int size = aLG.size();
                for (int i = 0; i < size; i++) {
                    ((ae) g.n(ae.class)).getFavItemInfoStorage().z((com.tencent.mm.plugin.fav.a.g) aLG.get(i));
                }
                x.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem  cost time = %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        }
    }
}
