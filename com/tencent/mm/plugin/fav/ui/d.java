package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.w$b;
import com.tencent.mm.platformtools.w.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.e;
import java.io.FileNotFoundException;

public final class d implements w {
    private int height;
    private String iYM;
    private String url;
    private int width;

    public d(String str, String str2, int i, int i2) {
        this.iYM = str;
        this.url = str2;
        this.width = i;
        this.height = i2;
    }

    public final w$b Vu() {
        return null;
    }

    public final String Vv() {
        return b.aKO() + g.u(this.url.getBytes());
    }

    public final String Vw() {
        return this.url;
    }

    public final String Vx() {
        return this.iYM;
    }

    public final String getCacheKey() {
        return this.iYM;
    }

    public final boolean Vy() {
        return true;
    }

    public final boolean Vz() {
        return false;
    }

    public final Bitmap VA() {
        return BitmapFactory.decodeResource(ad.getContext().getResources(), com.tencent.mm.plugin.fav.ui.m.d.nosdcard_headimg);
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        Throwable e;
        if (a.evZ == aVar) {
            try {
                x.v("MicroMsg.FavGetPicStrategy", "handlerBitmap get from net url:%s", new Object[]{this.url});
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(b.aKO());
                if (!bVar.exists()) {
                    bVar.mkdirs();
                }
                if (this.width > 0 && this.height > 0) {
                    bitmap = c.a(bitmap, this.width, this.height, true);
                }
                com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(Vv());
                bVar2.createNewFile();
                e eVar;
                try {
                    eVar = new e(bVar2);
                    try {
                        bitmap.compress(CompressFormat.PNG, 100, eVar);
                        eVar.flush();
                        eVar.close();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            x.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                            if (eVar != null) {
                                eVar.close();
                            }
                            return bitmap;
                        } catch (Throwable th) {
                            e = th;
                            if (eVar != null) {
                                eVar.close();
                            }
                            throw e;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    eVar = null;
                    x.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                    if (eVar != null) {
                        eVar.close();
                    }
                    return bitmap;
                } catch (Throwable th2) {
                    e = th2;
                    eVar = null;
                    if (eVar != null) {
                        eVar.close();
                    }
                    throw e;
                }
            } catch (Throwable e4) {
                x.printErrStackTrace("MicroMsg.FavGetPicStrategy", e4, "", new Object[0]);
            }
        }
        return bitmap;
    }

    public final void VB() {
    }

    public final void P(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }
}
