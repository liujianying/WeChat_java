package com.tencent.mm.plugin.sight.decode.ui;

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
import com.tencent.mm.plugin.ak.a.d;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.plugin.sight.decode.a.b.i;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class SightPlayImageView extends QPictureView implements a {
    private int ndA;
    private int ndB;
    private int ndC;
    public f.a ndD;
    public boolean ndE;
    private boolean ndF;
    public boolean ndG;
    public b ndx;
    private int ndz;

    public final void bvU() {
        this.ndG = true;
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ndE = true;
        this.ndF = false;
        this.ndG = false;
        this.ndx = new a(this);
        x.i("MicroMsg.SightPlayImageView", "mController %s", bi.cjd().toString());
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SightPlayImageView(Context context) {
        this(context, null, 0);
    }

    public String getVideoPath() {
        return this.ndx.nck;
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (!this.ndG) {
            int height = bitmap == null ? this.ndA == 0 ? 240 : this.ndA : bitmap.getHeight();
            int width = bitmap == null ? this.ndz == 0 ? 320 : this.ndz : bitmap.getWidth();
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams.height != ((int) (((float) (this.ndz * height)) / ((float) width)))) {
                layoutParams.width = this.ndz;
                layoutParams.height = (int) ((((float) height) * ((float) this.ndz)) / ((float) width));
                setLayoutParams(layoutParams);
            }
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (!this.ndG) {
            int intrinsicHeight = drawable == null ? this.ndA == 0 ? 240 : this.ndA : drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable == null ? this.ndz == 0 ? 320 : this.ndz : drawable.getIntrinsicWidth();
            if (intrinsicHeight != 0 && intrinsicWidth != 0) {
                LayoutParams layoutParams = getLayoutParams();
                if (layoutParams.height != ((int) ((((float) this.ndz) * ((float) intrinsicHeight)) / ((float) intrinsicWidth)))) {
                    layoutParams.width = this.ndz;
                    layoutParams.height = (int) ((((float) intrinsicHeight) * ((float) this.ndz)) / ((float) intrinsicWidth));
                    setLayoutParams(layoutParams);
                }
            }
        }
    }

    public final void F(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public final void clear() {
        this.ndx.clear();
    }

    public final void aO(String str, boolean z) {
        this.ndx.aO(str, z);
    }

    public final boolean bvF() {
        return this.ndx.bvI();
    }

    public void setPosition(int i) {
        this.ndx.position = i;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.ndx.clear();
        com.tencent.mm.sdk.b.a.sFg.c(this.ndx.bvK());
    }

    protected void onAttachedToWindow() {
        x.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.sFg.b(this.ndx.bvK());
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

    public final void bvE() {
        setImageBitmap(null);
        setImageResource(d.nosdcard_chatting_bg);
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

    public void dt(int i, int i2) {
        this.ndE = false;
        LayoutParams layoutParams = getLayoutParams();
        this.ndz = i;
        this.ndA = (this.ndz * i2) / i;
        layoutParams.width = this.ndz;
        layoutParams.height = this.ndA;
        setLayoutParams(layoutParams);
        postInvalidate();
    }

    public void setCanPlay(boolean z) {
        this.ndx.ncF = z;
    }

    public void setOnCompletionListener(e eVar) {
        this.ndx.ncQ = eVar;
    }

    public void setOnSightCompletionAction(g gVar) {
        this.ndx.ncS = gVar;
    }

    public void setOnDecodeDurationListener(b.f fVar) {
        this.ndx.ncR = fVar;
    }

    public void setThumbBgView(View view) {
        this.ndx.setThumbBgView(view);
    }

    public void setIsWhatsNew(boolean z) {
        this.ndx.ncI = z;
    }

    public void setSightInfoView(TextView textView) {
        this.ndx.setSightInfoView(textView);
    }

    public final void hK(boolean z) {
        b bVar = this.ndx;
        x.i("MicroMsg.SightPlayController", "configure: need sound %B", Boolean.valueOf(z));
        if (!z) {
            if (bVar.ncz != null) {
                bVar.ncz.type = 0;
                o.d(bVar.ncz, 0);
            }
            bVar.ncz = null;
        } else if (bVar.ncz == null) {
            bVar.ncz = new i(bVar, (byte) 0);
        }
    }

    public void setForceRecordState(boolean z) {
    }

    public b getController() {
        return this.ndx;
    }

    public int getDuration() {
        if (this.ndx == null) {
            return 0;
        }
        return (int) this.ndx.bvL();
    }

    public void setLoopImp(boolean z) {
        if (this.ndx != null) {
            this.ndx.kpl = z;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
