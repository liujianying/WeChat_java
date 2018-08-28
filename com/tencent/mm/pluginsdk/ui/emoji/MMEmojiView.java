package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.gif.f;
import com.tencent.mm.plugin.n.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

public class MMEmojiView extends MMAnimateView {
    private EmojiInfo ild;
    private int mScreenWidth;
    private int qNU;
    private int qNV;
    private boolean qNW;
    public boolean qNX;

    public MMEmojiView(Context context) {
        this(context, null);
        init(context);
    }

    public MMEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        init(context);
    }

    public MMEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qNW = false;
        this.qNX = false;
        init(context);
    }

    private void init(Context context) {
        this.qNU = context.getResources().getDimensionPixelSize(c.emoji_view_image_size);
        this.qNV = context.getResources().getDimensionPixelSize(c.emoji_view_image_min_size);
        this.mScreenWidth = a.fk(context);
    }

    public final void a(EmojiInfo emojiInfo, String str) {
        this.ild = emojiInfo;
        String cnF = emojiInfo.cnF();
        if ((emojiInfo.field_reserved4 & EmojiInfo.tcW) != EmojiInfo.tcW) {
            dk(cnF, str);
        } else if (b.aVQ().EA(str) != null) {
            setImageDrawable(b.aVQ().EA(str));
        } else {
            a(this.ild, ((PluginEmoji) g.n(PluginEmoji.class)).getProvider().a(this.ild), str);
        }
    }

    public final void a(EmojiInfo emojiInfo, byte[] bArr, String str) {
        this.ild = emojiInfo;
        try {
            if (!bi.bC(bArr)) {
                Drawable fVar;
                if (bi.oW(str)) {
                    if (o.bx(bArr) && ((PluginEmoji) g.n(PluginEmoji.class)).getProvider().aEa()) {
                        fVar = new f(bArr);
                        this.qNX = true;
                    } else {
                        x.v("MicroMsg.emoji.MMEmojiView", "set with gif");
                        fVar = new com.tencent.mm.plugin.gif.c(bArr);
                    }
                    if (!fVar.isRunning()) {
                        fVar.reset();
                    }
                } else {
                    setCacheKey(str);
                    fVar = b.aVQ().q(getCacheKey(), bArr);
                }
                setImageDrawable(fVar);
                return;
            }
        } catch (MMGIFException e) {
            a(e);
            if (e.getErrorCode() == s$l.AppCompatTheme_checkedTextViewStyle) {
                x.d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
                Bitmap bs = com.tencent.mm.sdk.platformtools.c.bs(bArr);
                if (bs != null) {
                    bs.setDensity(getEmojiDensity());
                    setImageBitmap(bs);
                    return;
                }
                x.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[]{bArr.toString()});
                if (this.ild != null) {
                    this.ild.cnw();
                    x.i("MicroMsg.emoji.MMEmojiView", "delete file.");
                }
                init();
                return;
            }
            x.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[]{e.toString()});
            if (this.ild != null) {
                this.ild.cnw();
                x.i("MicroMsg.emoji.MMEmojiView", "delete file.");
            }
        } catch (IOException e2) {
            x.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[]{e2.toString()});
        } catch (NullPointerException e3) {
            x.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[]{e3.toString()});
        }
        if (this.ild != null) {
            this.ild.cnw();
            x.i("MicroMsg.emoji.MMEmojiView", "delete file.");
        }
        init();
    }

    protected void onMeasure(int i, int i2) {
        float f;
        super.onMeasure(i, i2);
        int intrinsicWidth = getIntrinsicWidth();
        int intrinsicHeight = getIntrinsicHeight();
        if (this.ild != null && intrinsicWidth == 0 && intrinsicHeight == 0) {
            intrinsicWidth = (int) (((float) this.ild.field_width) * getEmojiDensityScale());
            intrinsicHeight = (int) (((float) this.ild.field_height) * getEmojiDensityScale());
        }
        if (intrinsicHeight < this.qNV || intrinsicWidth < this.qNV) {
            if (intrinsicWidth < intrinsicHeight) {
                f = ((float) this.qNV) / ((float) intrinsicWidth);
                intrinsicWidth = this.qNV;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            } else if (intrinsicHeight < intrinsicWidth) {
                f = ((float) this.qNV) / ((float) intrinsicHeight);
                intrinsicHeight = this.qNV;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            } else {
                intrinsicHeight = this.qNV;
                intrinsicWidth = this.qNV;
            }
        }
        if (this.qNW) {
            if (intrinsicWidth > this.qNU || intrinsicHeight > this.qNU) {
                if (intrinsicWidth > intrinsicHeight) {
                    f = ((float) this.qNU) / ((float) intrinsicWidth);
                    intrinsicWidth = this.qNU;
                    intrinsicHeight = (int) (((float) intrinsicHeight) * f);
                } else if (intrinsicHeight > intrinsicWidth) {
                    f = ((float) this.qNU) / ((float) intrinsicHeight);
                    intrinsicHeight = this.qNU;
                    intrinsicWidth = (int) (((float) intrinsicWidth) * f);
                } else {
                    intrinsicWidth = this.qNU;
                    intrinsicHeight = this.qNU;
                }
            }
        } else if (intrinsicWidth > this.mScreenWidth || intrinsicHeight > this.mScreenWidth) {
            if (intrinsicWidth > intrinsicHeight) {
                f = ((float) this.mScreenWidth) / ((float) intrinsicWidth);
                intrinsicWidth = this.mScreenWidth;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            } else if (intrinsicHeight > intrinsicWidth) {
                f = ((float) this.mScreenWidth) / ((float) intrinsicHeight);
                intrinsicHeight = this.mScreenWidth;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            } else {
                intrinsicWidth = this.mScreenWidth;
                intrinsicHeight = this.mScreenWidth;
            }
        }
        setMeasuredDimension(intrinsicWidth, intrinsicHeight);
    }

    public void setIsMaxSizeLimit(boolean z) {
        this.qNW = z;
    }

    public void setMaxSize(int i) {
        this.qNU = i;
    }
}
