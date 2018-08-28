package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class k implements LeadingMarginSpan, f<Boolean>, g<Boolean> {
    private int qsP;
    public boolean qsQ;
    public boolean qsT = false;
    public boolean qsU = false;
    public boolean qsV = false;
    public boolean qsW = false;
    private WeakReference<Drawable> qsX;

    public final /* bridge */ /* synthetic */ Object getValue() {
        return Boolean.TRUE;
    }

    public k(boolean z, int i, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        this.qsP = i;
        if (z2 && z4 && !z3) {
            z5 = true;
        }
        this.qsQ = z5;
        this.qsW = z;
        this.qsT = z3;
        this.qsU = z4;
        this.qsV = z2;
    }

    public int getLeadingMargin(boolean z) {
        return this.qsQ ? 0 : this.qsP;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Spanned spanned = (Spanned) charSequence;
        if (!this.qsQ && spanned.getSpanStart(this) == i6) {
            WeakReference weakReference = this.qsX;
            Drawable drawable = null;
            if (weakReference != null) {
                drawable = (Drawable) weakReference.get();
            }
            if (drawable == null) {
                drawable = this.qsW ? a.f(ad.getContext(), R.g.note_select_press) : a.f(ad.getContext(), R.g.note_select_unpress);
                this.qsX = new WeakReference(drawable);
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                canvas.save();
                FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                canvas.translate(0.0f, (float) (((fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2) - (drawable.getBounds().bottom / 2)));
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    private k caJ() {
        return new k(this.qsW, this.qsP, this.qsV, this.qsT, this.qsU);
    }

    public final void a(TextView textView, Spannable spannable, MotionEvent motionEvent, k kVar) {
        if (motionEvent.getX() > ((float) this.qsP)) {
            x.e("MicroMsg.NoteTodoSpan", "x > mGapWidth");
            return;
        }
        boolean z;
        int spanStart = spannable.getSpanStart(kVar);
        int spanEnd = spannable.getSpanEnd(kVar);
        String str = "MicroMsg.NoteTodoSpan";
        String str2 = "current mIsTodoCheck: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.qsW ? "true" : "false";
        x.i(str, str2, objArr);
        spannable.removeSpan(this);
        if (this.qsW) {
            z = false;
        } else {
            z = true;
        }
        this.qsW = z;
        spannable.setSpan(caJ(), spanStart, spanEnd, 33);
        WXRTEditText wXRTEditText = (WXRTEditText) textView;
        if (wXRTEditText.getEditTextType() == 0) {
            b Bv = c.bZD().Bv(wXRTEditText.getRecyclerItemPosition());
            if (Bv != null && Bv.getType() == 1) {
                ((h) Bv).content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(spannable);
            }
        }
    }
}
