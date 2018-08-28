package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.memory.a.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class PictureView extends ImageView {
    private boolean DEBUG = false;
    private i dvx = null;
    private boolean dvy = false;
    private Runnable dvz = new 1(this);

    static /* synthetic */ void a(PictureView pictureView) {
        aV(pictureView.dvx);
        pictureView.dvx = null;
        super.setImageDrawable(null);
    }

    public PictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private static String aT(Object obj) {
        if (obj == null) {
            return "NULL";
        }
        if (obj instanceof a) {
            return obj + " hashcode " + obj.hashCode() + " " + ((a) obj).FB() + " " + ((a) obj).FB().hashCode();
        }
        return String.valueOf(obj);
    }

    public void setReleasableBitmap(n nVar) {
        if (nVar != null && !nVar.equals(this.dvx)) {
            setImageBitmap(nVar.Fx());
            this.dvx = nVar;
            aU(this.dvx);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        removeCallbacks(this.dvz);
        if (drawable != null && !drawable.equals(this.dvx)) {
            if (this.DEBUG) {
                x.i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + aT(this.dvx) + " new:" + aT(drawable) + " " + bi.cjd().toString());
            }
            aV(this.dvx);
            if (drawable instanceof i) {
                this.dvx = (i) drawable;
            } else {
                this.dvx = null;
            }
            aU(drawable);
            super.setImageDrawable(drawable);
        }
    }

    private static void aU(Object obj) {
        if (obj != null && (obj instanceof i)) {
            ((i) obj).Fs();
        }
    }

    private static void aV(Object obj) {
        if (obj != null && (obj instanceof i)) {
            ((i) obj).Ft();
        }
    }

    private void FC() {
        removeCallbacks(this.dvz);
        if (this.DEBUG) {
            x.i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + bi.cjd().toString());
        }
        if (!this.dvy) {
            this.dvy = true;
        }
    }

    private void onDetach() {
        if (this.DEBUG) {
            x.i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + bi.cjd().toString());
        }
        if (this.dvy) {
            this.dvy = false;
            removeCallbacks(this.dvz);
            postDelayed(this.dvz, 500);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        FC();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDetach();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        onDetach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        FC();
    }
}
