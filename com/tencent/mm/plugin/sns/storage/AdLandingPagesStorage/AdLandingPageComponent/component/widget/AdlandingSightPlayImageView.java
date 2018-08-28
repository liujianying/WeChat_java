package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.i;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class AdlandingSightPlayImageView extends QPictureView {
    a nGJ;
    private int ndA;
    private int ndB;
    private int ndC;
    public a ndD;
    public boolean ndE;
    private boolean ndF;
    private boolean ndG;
    private int ndz;

    public AdlandingSightPlayImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ndE = true;
        this.ndF = false;
        this.ndG = false;
        this.nGJ = new a(this);
        x.i("MicroMsg.SightPlayImageView", "mController %s", new Object[]{bi.cjd().toString()});
    }

    public AdlandingSightPlayImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public String getVideoPath() {
        return this.nGJ.nck;
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (!this.ndG) {
            int i;
            if (bitmap == null) {
                i = this.ndA == 0 ? aq.CTRL_BYTE : this.ndA;
            } else {
                i = bitmap.getHeight();
            }
            int width = bitmap == null ? this.ndz == 0 ? 320 : this.ndz : bitmap.getWidth();
            LayoutParams layoutParams = getLayoutParams();
            if (((float) layoutParams.height) != ((float) (this.ndz * i)) / ((float) width)) {
                layoutParams.width = this.ndz;
                layoutParams.height = (int) ((((float) i) * ((float) this.ndz)) / ((float) width));
                setLayoutParams(layoutParams);
            }
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (!this.ndG) {
            int i;
            if (drawable == null) {
                i = this.ndA == 0 ? aq.CTRL_BYTE : this.ndA;
            } else {
                i = drawable.getIntrinsicHeight();
            }
            int intrinsicWidth = drawable == null ? this.ndz == 0 ? 320 : this.ndz : drawable.getIntrinsicWidth();
            if (i != 0 && intrinsicWidth != 0) {
                LayoutParams layoutParams = getLayoutParams();
                if (((float) layoutParams.height) != (((float) this.ndz) * ((float) i)) / ((float) intrinsicWidth)) {
                    layoutParams.width = this.ndz;
                    layoutParams.height = (int) ((((float) i) * ((float) this.ndz)) / ((float) intrinsicWidth));
                    setLayoutParams(layoutParams);
                }
            }
        }
    }

    public final void F(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public final void aO(String str, boolean z) {
        a aVar = this.nGJ;
        x.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[]{Integer.valueOf(aVar.hashCode()), str, aVar.nck, Boolean.valueOf(z), Integer.valueOf(aVar.ncm), Boolean.valueOf(aVar.ncO), Boolean.valueOf(aVar.ncF)});
        if (aVar.ncO) {
            aVar.hJ(false);
        } else if (aVar.bvI()) {
            x.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            aVar.clear();
        } else if (!aVar.ncF) {
            aVar.clear();
        } else if (z) {
            aVar.ncl = str;
            aVar.hJ(false);
        } else if (aVar.nck.equals(str)) {
            aVar.ncl = "ERROR#PATH";
            aVar.hJ(false);
            aVar.restart();
        } else {
            aVar.clear();
            if (str == null) {
                str = "";
            }
            aVar.nck = str;
            if (bi.oW(aVar.nck)) {
                x.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                aVar.bAm();
            } else if (a.Lp(aVar.nck)) {
                aVar.nGs = new a$h(aVar, (byte) 0);
                o.d(aVar.nGs, 0);
            } else {
                x.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                aVar.clear();
            }
        }
    }

    public void setPosition(int i) {
        this.nGJ.position = i;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[]{Integer.valueOf(hashCode())});
        this.nGJ.clear();
        com.tencent.mm.sdk.b.a.sFg.c(this.nGJ.bvK());
    }

    protected void onAttachedToWindow() {
        x.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[]{Integer.valueOf(hashCode())});
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.sFg.b(this.nGJ.bvK());
    }

    public void setDrawableWidth(int i) {
        this.ndE = false;
        this.ndz = i;
        if (this.ndB > 0 && this.ndC > 0) {
            LayoutParams layoutParams = getLayoutParams();
            this.ndA = (this.ndz * this.ndC) / this.ndB;
            if (layoutParams.width != this.ndz || layoutParams.height != this.ndA) {
                layoutParams.width = this.ndz;
                layoutParams.height = this.ndA;
                setLayoutParams(layoutParams);
            }
        }
    }

    public void setThumbBmp(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

    public void setMaskID(int i) {
    }

    public void setTagObject(Object obj) {
        setTag(obj);
    }

    public Object getTagObject() {
        return getTag();
    }

    public Context getUIContext() {
        return getContext();
    }

    public void setCanPlay(boolean z) {
        this.nGJ.ncF = z;
    }

    public void setOnCompletionListener(a$e a_e) {
        this.nGJ.nGA = a_e;
    }

    public void setOnSightCompletionAction(g gVar) {
        this.nGJ.nGC = gVar;
    }

    public void setOnDecodeDurationListener(a$f a_f) {
        this.nGJ.nGB = a_f;
    }

    public void setThumbBgView(View view) {
        this.nGJ.ncr = new WeakReference(view);
    }

    public void setIsWhatsNew(boolean z) {
        this.nGJ.ncI = z;
    }

    public void setSightInfoView(TextView textView) {
        this.nGJ.ncs = new WeakReference(textView);
    }

    public final void hK(boolean z) {
        a aVar = this.nGJ;
        x.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[]{Boolean.valueOf(z)});
        if (!z) {
            if (aVar.nGu != null) {
                aVar.nGu.type = 0;
                o.d(aVar.nGu, 0);
            }
            aVar.nGu = null;
        } else if (aVar.nGu == null) {
            aVar.nGu = new i(aVar, (byte) 0);
        }
    }

    public void setForceRecordState(boolean z) {
    }

    public a getController() {
        return this.nGJ;
    }

    public int getDuration() {
        if (this.nGJ == null) {
            return 0;
        }
        a aVar = this.nGJ;
        return (int) (aVar.ncm == -1 ? 0.0d : SightVideoJNI.getVideoDuration(aVar.ncm));
    }

    public void setLoopImp(boolean z) {
        if (this.nGJ != null) {
            this.nGJ.kpl = z;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
