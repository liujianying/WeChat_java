package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import com.tencent.mm.bl.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

public final class m implements a {
    private Bitmap hqv = null;
    aa<String, Bitmap> kDC = new aa(20);

    public m() {
        try {
            this.hqv = b.a(ad.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bp.a.getDensity(null));
            this.hqv = c.a(this.hqv, false, (float) (this.hqv.getWidth() >> 1));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TrackAvatarCacheService", e, "", new Object[0]);
        }
    }

    public final Bitmap FK(String str) {
        if (bi.oW(str)) {
            return null;
        }
        x.d("MicroMsg.TrackAvatarCacheService", "getAvatar, tag = %s, cacheSize = %d", new Object[]{str, Integer.valueOf(this.kDC.size())});
        Bitmap bitmap = (Bitmap) this.kDC.get(str);
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public final void p(String str, Bitmap bitmap) {
        if (this.kDC.get(str) != null) {
            Bitmap bitmap2 = (Bitmap) this.kDC.get(str);
            if (!bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            this.kDC.remove(str);
        }
        this.kDC.put(str, bitmap);
        x.d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", new Object[]{str, Integer.valueOf(this.kDC.size())});
    }
}
