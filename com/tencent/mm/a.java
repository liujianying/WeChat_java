package com.tencent.mm;

import android.content.Context;
import com.tencent.mm.api.b;
import com.tencent.mm.api.j;
import com.tencent.mm.api.k;
import com.tencent.mm.api.m;
import com.tencent.mm.api.m.c;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.ArtistCacheManager.1;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends m {
    private com.tencent.mm.view.a bvS;
    private k bvT;

    public final b aQ(Context context) {
        if (this.bvS == null) {
            if (this.bwU.bwW == c.bxb) {
                this.bvS = new com.tencent.mm.view.c(context, this.bwU);
            } else if (this.bwU.bwW == c.bxc) {
                this.bvS = new com.tencent.mm.view.b(context, this.bwU);
            }
        }
        return this.bvS;
    }

    public final void a(j jVar) {
        this.bvS.getPresenter().a(jVar, !tX().uj());
    }

    public final boolean tW() {
        return this.bvS.getPresenter().tW();
    }

    public final void a(com.tencent.mm.api.m.a aVar) {
        super.a(aVar);
        ArtistCacheManager yn = ArtistCacheManager.yn();
        String aG = bi.aG(this.bwU.path, "MicroMsg.MMPhotoEditorImpl");
        yn.dae = aG;
        if (!ArtistCacheManager.dac.containsKey(aG)) {
            ArtistCacheManager.dac.put(aG, new a());
        }
    }

    public final void onDestroy() {
        if (!this.bwU.bwX) {
            ArtistCacheManager yn = ArtistCacheManager.yn();
            String aG = bi.aG(this.bwU.path, "MicroMsg.MMPhotoEditorImpl");
            yn.dae = null;
            if (ArtistCacheManager.dac.containsKey(aG)) {
                ((a) ArtistCacheManager.dac.get(aG)).clearAll();
                ArtistCacheManager.dac.remove(aG);
            }
            e.cjw();
            e.post(new 1(yn), "MicroMsg.ArtistCacheManager[clearAllCache]");
        }
        if (this.bvS != null) {
            this.bvS.getPresenter().onDestroy();
        }
        try {
            this.bvS.getChatFooterPanel().destroy();
        } catch (Exception e) {
            x.e("MicroMsg.MMPhotoEditorImpl", "[onDestroy] may be has destory!");
        }
    }

    public final k tX() {
        if (this.bvT == null) {
            this.bvT = new com.tencent.mm.bn.a(this.bvS.getPresenter());
        }
        return this.bvT;
    }
}
