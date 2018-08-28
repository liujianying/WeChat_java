package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.mm.a.e;
import com.tencent.mm.bp.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.plugin.n.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class MMAnimateView extends AppCompatImageView {
    private String idw;
    private int khA;
    private int khB;
    private boolean khC;
    private float mDensity;

    public MMAnimateView(Context context) {
        this(context, null);
    }

    public MMAnimateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMAnimateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.khA = d.emoji_download_icon;
        this.khB = d.nosdcard_pic;
        this.khC = true;
        this.mDensity = 0.0f;
        if (com.tencent.mm.compatible.util.d.fR(26)) {
            setLayerType(1, null);
        }
    }

    public void setImageResource(int i) {
        a(getResources(), i, true);
    }

    public void setBackgroundResource(int i) {
        a(getResources(), i, false);
    }

    public void setImageFilePath(String str) {
        dl(str, null);
    }

    public final void dk(String str, String str2) {
        dl(str, str2);
    }

    public final void g(byte[] bArr, String str) {
        if (bArr == null) {
            try {
                x.e("MicroMsg.GIF.MMGIFImageView", "[setMMGIFFileByteArray] bytes is null! src:%s cacheKey:%s", new Object[]{Boolean.valueOf(true), str});
                return;
            } catch (MMGIFException e) {
                a(e);
                if (e.getErrorCode() == 103) {
                    Bitmap bs = c.bs(bArr);
                    if (bs != null) {
                        bs.setDensity(getEmojiDensity());
                        setImageBitmap(bs);
                        return;
                    }
                    x.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[]{bArr.toString()});
                    init();
                    return;
                }
                x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[]{e.toString()});
            } catch (IOException e2) {
                x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[]{e2.toString()});
            }
        } else {
            Drawable fVar;
            if (bi.oW(str)) {
                fVar = o.bx(bArr) ? new f(bArr) : new c(bArr);
                fVar.start();
            } else {
                setCacheKey(str);
                fVar = b.aVQ().q(getCacheKey(), bArr);
            }
            setImageDrawable(fVar);
            return;
        }
        init();
    }

    public final void a(InputStream inputStream, String str) {
        Drawable drawable = null;
        try {
            if (bi.oW(str)) {
                drawable = new c(inputStream);
            } else {
                setCacheKey(str);
                b aVQ = b.aVQ();
                String cacheKey = getCacheKey();
                if (inputStream != null) {
                    x.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "stream key:%s", new Object[]{cacheKey});
                    if (aVQ.khy.get(cacheKey) != null) {
                        drawable = (a) ((WeakReference) aVQ.khy.get(cacheKey)).get();
                    }
                    if (drawable == null) {
                        drawable = new c(inputStream);
                        aVQ.khy.put(cacheKey, new WeakReference(drawable));
                    }
                }
            }
            setImageDrawable(drawable);
            return;
        } catch (MMGIFException e) {
            a(e);
            if (e.getErrorCode() == 103) {
                Bitmap decodeStream = c.decodeStream(inputStream);
                if (decodeStream != null) {
                    decodeStream.setDensity(getEmojiDensity());
                    setImageBitmap(decodeStream);
                    return;
                }
                x.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failedbitmap is null. bytes %s");
                init();
                return;
            }
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[]{e.toString()});
        } catch (IOException e2) {
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[]{e2.toString()});
        }
        init();
    }

    public void setDefaultImageResource(int i) {
        this.khA = i;
    }

    public void setDefaultBackgroundResource(int i) {
        this.khA = i;
    }

    public float getEmojiDensityScale() {
        if (this.mDensity == 0.0f) {
            this.mDensity = a.getDensity(ad.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        return this.mDensity;
    }

    public int getEmojiDensity() {
        return 320;
    }

    public String getCacheKey() {
        return this.idw;
    }

    public void setCacheKey(String str) {
        this.idw = str;
    }

    private void a(Resources resources, int i, boolean z) {
        Drawable drawable = null;
        try {
            if (bi.oW(null)) {
                drawable = new c(resources, i);
            } else {
                setCacheKey(null);
                b aVQ = b.aVQ();
                if (aVQ.khy.get(null) != null) {
                    drawable = (a) ((WeakReference) aVQ.khy.get(null)).get();
                }
                if (drawable == null) {
                    drawable = new c(resources, i);
                    aVQ.khy.put(null, new WeakReference(drawable));
                }
            }
            if (z) {
                setImageDrawable(drawable);
            } else {
                setBackgroundDrawable(drawable);
            }
        } catch (IOException e) {
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s" + e.toString());
            if (z) {
                super.setImageResource(i);
            } else {
                super.setBackgroundResource(i);
            }
        }
    }

    public final void a(String str, h hVar) {
        try {
            c cVar = new c(str);
            setImageDrawable(cVar);
            cVar.khV = Integer.MAX_VALUE;
            cVar.khX = hVar;
            return;
        } catch (MMGIFException e) {
            try {
                a(e);
                if (e.getErrorCode() == 103) {
                    Bitmap decodeStream = c.decodeStream(new FileInputStream(str));
                    if (decodeStream != null) {
                        decodeStream.setDensity(getEmojiDensity());
                        setImageBitmap(decodeStream);
                        return;
                    }
                    x.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed bitmap is null. show default and delete file. path:%s", new Object[]{str});
                    init();
                    e.deleteFile(str);
                    return;
                }
            } catch (FileNotFoundException e2) {
                x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e2.toString());
            }
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e.toString());
        } catch (IOException e3) {
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e3.toString());
        }
        init();
    }

    private void dl(String str, String str2) {
        try {
            if (o.Wg(str)) {
                f fVar = new f(e.e(str, 0, e.cm(str)));
                fVar.start();
                setImageDrawable(fVar);
                return;
            }
            Drawable cVar;
            if (bi.oW(str2)) {
                cVar = new c(str);
            } else {
                setCacheKey(str2);
                cVar = b.aVQ().dj(getCacheKey(), str);
            }
            setImageDrawable(cVar);
        } catch (MMGIFException e) {
            try {
                a(e);
                if (e.getErrorCode() == 103) {
                    try {
                        Bitmap decodeFile = c.decodeFile(str, null);
                        if (decodeFile != null) {
                            decodeFile.setDensity(getEmojiDensity());
                            setImageBitmap(decodeFile);
                            return;
                        }
                        x.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failedbitmap is null. show default and delete file. path %s", new Object[]{str});
                        init();
                        e.deleteFile(str);
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.GIF.MMGIFImageView", e2, "setMMGIFFilePath failed, oom happened. show default. path %s", new Object[]{str});
                        init();
                    }
                }
            } catch (Throwable e22) {
                x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed1. %s", new Object[]{bi.i(e22)});
            }
        } catch (Throwable e222) {
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed3. %s", new Object[]{bi.i(e222)});
            e.deleteFile(str);
            init();
        } catch (NullPointerException e3) {
            init();
        }
    }

    public final void init() {
        this.khC = f.zZ();
        if (this.khC) {
            if (this.khA > 0) {
                super.setImageResource(this.khA);
            }
        } else if (this.khB > 0) {
            super.setImageResource(this.khB);
        }
    }

    public int getIntrinsicWidth() {
        return getDrawable() == null ? 0 : getDrawable().getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return getDrawable() == null ? 0 : getDrawable().getIntrinsicHeight();
    }

    public final void resume() {
        if (getDrawable() != null && (getDrawable() instanceof c)) {
            c cVar = (c) getDrawable();
            if (!cVar.khD) {
                cVar.mIsRunning = true;
                cVar.f(cVar.khZ, 0);
            }
        }
    }

    public static void a(MMGIFException mMGIFException) {
        hy hyVar = new hy();
        hyVar.bRu.errorCode = mMGIFException.getErrorCode();
        com.tencent.mm.sdk.b.a.sFg.m(hyVar);
    }

    public final void recycle() {
        if (getDrawable() != null && (getDrawable() instanceof c)) {
            ((c) getDrawable()).recycle();
        }
    }
}
