package com.tencent.mm.plugin.record.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.w$b;
import com.tencent.mm.platformtools.w.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

final class j implements w {
    private int height;
    private String iYM;
    private String url;
    private int width;

    public j(String str, String str2, int i, int i2) {
        this.iYM = str;
        this.url = str2;
        this.width = i;
        this.height = i2;
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        File file = new File(stringBuilder.append(c.Gm()).append("web/").toString());
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final String Vv() {
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        return stringBuilder.append(c.Gm()).append("web/").append(g.u(this.url.getBytes())).toString();
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
        return BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.nosdcard_headimg);
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        Throwable e;
        if (a.evZ == aVar) {
            try {
                x.v("MicroMsg.FavGetPicStrategy", "handlerBitmap get from net url:%s", new Object[]{this.url});
                if (this.width > 0 && this.height > 0) {
                    bitmap = com.tencent.mm.sdk.platformtools.c.a(bitmap, this.width, this.height, true);
                }
                File file = new File(Vv());
                file.createNewFile();
                FileOutputStream fileOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            x.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return bitmap;
                        } catch (Throwable th) {
                            e = th;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw e;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = null;
                    x.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return bitmap;
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
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

    public final w$b Vu() {
        return null;
    }
}
