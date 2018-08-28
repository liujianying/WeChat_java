package com.tencent.mm.booter.cache;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends com.tencent.mm.cache.f.a {
    public static a cYg;
    private final f<String, Bitmap> cYh;

    private a() {
        Context context = ad.getContext();
        String str = "BACKGROUND_BITMAP_CACHE_LIMIT";
        if (com.tencent.mm.platformtools.a.a.values == null) {
            try {
                com.tencent.mm.platformtools.a.a.values = q.Wi(bi.convertStreamToString(context.getAssets().open("profile.ini")));
            } catch (Throwable e) {
                x.e("MicroMsg.ProfileUtil", "exception:%s", new Object[]{bi.i(e)});
            }
        }
        this.cYh = new f(bi.getInt(com.tencent.mm.platformtools.a.a.values == null ? null : (String) com.tencent.mm.platformtools.a.a.values.get(str), 2000));
    }

    public static void prepare() {
        if (cYg == null) {
            cYg = new a();
        }
    }

    public static void destroy() {
        if (cYg != null) {
            cYg.cYh.clear();
        }
    }

    public final Bitmap getBitmap(String str) {
        x.v("MicroMsg.MMCacheImpl", "getting bitmap: %s", new Object[]{str});
        return (Bitmap) this.cYh.get(str);
    }

    public final MCacheItem eH(String str) {
        x.v("MicroMsg.MMCacheImpl", "getting cache item: %s", new Object[]{str});
        return null;
    }

    public final void c(String str, Bitmap bitmap) {
        x.v("MicroMsg.MMCacheImpl", "setting bitmap: %s", new Object[]{str});
        this.cYh.m(str, bitmap);
    }

    public final void eI(String str) {
        x.v("MicroMsg.MMCacheImpl", "setting cache item: %s", new Object[]{str});
    }
}
