package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.e.a;

public class CdnImageView extends MMImageView implements a {
    private static final String pAL = (e.bnE + "wallet/images/");
    private ag handler;
    private int kGn;
    private int kGo;
    private String qIm;
    private boolean qIn;
    private boolean qIo;
    private String url;

    public CdnImageView(Context context) {
        this(context, null);
    }

    public CdnImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CdnImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.url = null;
        this.qIo = false;
        this.handler = new 1(this);
    }

    public void setImageBitmapCompleted(Bitmap bitmap) {
    }

    public void setUseSdcardCache(boolean z) {
        this.qIo = z;
    }

    public void setImgSavedPath(String str) {
        this.qIm = str;
    }

    public void setUrl(String str) {
        i(str, 0, 0, -1);
    }

    public final void cS(String str, int i) {
        i(str, 0, 0, i);
    }

    public final void ag(String str, int i, int i2) {
        i(str, i, i2, -1);
    }

    public final void fC(String str, String str2) {
        c(str, -1, 0, 0, str2);
    }

    public final void i(String str, int i, int i2, int i3) {
        c(str, i, i2, i3, null);
    }

    private void c(String str, int i, int i2, int i3, String str2) {
        Bitmap Wb;
        this.url = str;
        this.kGn = i;
        this.kGo = i2;
        this.qIm = str2;
        if (!bi.oW(this.qIm)) {
            Wb = c.Wb(this.qIm);
            if (Wb != null && Wb.getWidth() > 0 && Wb.getHeight() > 0) {
                setImageBitmap(Wb);
                setImageBitmapCompleted(Wb);
                return;
            }
        }
        if (str == null || str.length() == 0) {
            setVisibility(8);
        } else if (str.startsWith("http")) {
            o.Pe();
            Wb = com.tencent.mm.ak.c.jz(str);
            if (Wb != null) {
                if (this.kGn > 0 && this.kGo > 0) {
                    Wb = c.a(Wb, this.kGn, this.kGo, true, false);
                }
                if (this.qIn && Wb != null) {
                    Wb = c.a(Wb, false, ((float) Wb.getWidth()) * 0.5f);
                }
                setImageBitmap(Wb);
                setImageBitmapCompleted(Wb);
            } else if (!this.qIo || !cdM()) {
                if (i3 > 0) {
                    setImageResource(i3);
                } else {
                    setImageBitmap(null);
                }
                com.tencent.mm.sdk.f.e.post(new a(str, this.handler), "CdnImageView_download");
            }
        } else if (com.tencent.mm.a.e.cn(str)) {
            Wb = (this.kGn <= 0 || this.kGo <= 0) ? c.Wb(str) : c.e(str, this.kGn, this.kGo, true);
            if (Wb == null) {
                setVisibility(8);
                return;
            }
            if (this.qIn && Wb != null) {
                Wb = c.a(Wb, false, ((float) Wb.getWidth()) * 0.5f);
            }
            setImageBitmap(Wb);
            setImageBitmapCompleted(Wb);
        } else {
            setVisibility(8);
        }
    }

    private String getCacheFilePath() {
        if (!bi.oW(this.qIm)) {
            return this.qIm;
        }
        FileOp.mL(pAL);
        return pAL + g.u(this.url.getBytes());
    }

    public void setRoundCorner(boolean z) {
        this.qIn = z;
    }

    private boolean cdM() {
        try {
            String cacheFilePath = getCacheFilePath();
            x.d("MicroMsg.CdnImageView", "useSdcardCache, path: %s", new Object[]{cacheFilePath});
            if (FileOp.cn(cacheFilePath)) {
                Bitmap Wb = c.Wb(cacheFilePath);
                x.d("MicroMsg.CdnImageView", "get bitmap from cache path: %s", new Object[]{Wb});
                if (Wb != null) {
                    if (this.kGn > 0 && this.kGo > 0) {
                        Wb = c.a(Wb, this.kGo, this.kGn, true, false);
                    }
                    if (this.qIn && Wb != null) {
                        Wb = c.a(Wb, false, ((float) Wb.getWidth()) * 0.5f);
                    }
                    setImageBitmap(Wb);
                    setImageBitmapCompleted(Wb);
                    return true;
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CdnImageView", e, "setBitmapFromLocalCache error: %s", new Object[]{e.getMessage()});
        }
        return false;
    }
}
