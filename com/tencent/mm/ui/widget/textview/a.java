package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.c;

public final class a {
    public boolean ccw = true;
    TextView ih;
    Context mContext;
    OnScrollChangedListener uOY;
    public b uOZ;
    public b uPa;
    d uPb = new d(this);
    public c uPc;
    Spannable uPd;
    com.tencent.mm.ui.widget.b.a uPe;
    int uPf;
    int uPg;
    private int uPh;
    int uPi;
    int uPj;
    private c uPk;
    boolean uPl;
    OnPreDrawListener uPm;
    private int[] uPn = new int[2];
    final Runnable uPo = new 1(this);

    static /* synthetic */ b a(a aVar, boolean z) {
        return b.b(aVar.uOZ) == z ? aVar.uOZ : aVar.uPa;
    }

    public a(a aVar) {
        this.ih = aVar.ih;
        this.uPe = aVar.uPq;
        this.mContext = this.ih.getContext();
        this.uPh = aVar.uPh;
        this.uPi = aVar.uPi;
        this.uPj = ap.fromDPToPix(this.mContext, aVar.uPr);
        this.ih.setText(this.ih.getText(), BufferType.SPANNABLE);
        this.ih.setOnLongClickListener(new 2(this));
        this.ih.setOnTouchListener(new 3(this));
        this.ih.setOnClickListener(new 4(this));
        this.ih.addOnAttachStateChangeListener(new 5(this));
        this.uPm = new 6(this);
        this.ih.getViewTreeObserver().addOnPreDrawListener(this.uPm);
        this.uOY = new 7(this);
        this.ih.getViewTreeObserver().addOnScrollChangedListener(this.uOY);
    }

    public final void cBn() {
        this.ccw = true;
        if (this.uOZ != null) {
            this.uOZ.uPs.dismiss();
        }
        if (this.uPa != null) {
            this.uPa.uPs.dismiss();
        }
        if (this.uPe != null) {
            this.uPe.ctb();
        }
    }

    public final void cBo() {
        this.uPb.uPz = null;
        if (this.uPd != null && this.uPk != null) {
            this.uPd.removeSpan(this.uPk);
            this.uPk = null;
        }
    }

    public final void a(b bVar) {
        int lineBaseline;
        int i;
        Layout layout = this.ih.getLayout();
        int i2 = b.b(bVar) ? this.uPb.Tw : this.uPb.tK;
        if (layout != null) {
            lineBaseline = ((int) layout.getPaint().getFontMetrics().descent) + layout.getLineBaseline(layout.getLineForOffset(i2));
            i2 = (int) layout.getPrimaryHorizontal(i2);
        } else {
            i2 = 0;
            lineBaseline = 0;
        }
        bVar.uPp.ih.getLocationInWindow(bVar.uPy);
        if (bVar.uPt) {
            i = bVar.mWidth;
        } else {
            i = 0;
        }
        if (!bVar.uPt) {
            int[] fq = bVar.fq(i2, lineBaseline);
            i2 = fq[0];
            lineBaseline = fq[1];
        }
        bVar.uPs.showAtLocation(bVar.uPp.ih, 0, (i2 - i) + bVar.getExtraX(), lineBaseline + bVar.getExtraY());
    }

    public final void cBp() {
        int i = 16;
        if (this.uPe != null) {
            this.ih.getLocationInWindow(this.uPn);
            Layout layout = this.ih.getLayout();
            int primaryHorizontal = ((int) layout.getPrimaryHorizontal(this.uPb.Tw)) + this.uPn[0];
            int lineTop = (layout.getLineTop(layout.getLineForOffset(this.uPb.Tw)) + this.uPn[1]) - 16;
            if (primaryHorizontal <= 0) {
                primaryHorizontal = 16;
            }
            if (lineTop >= 0) {
                i = lineTop;
            }
            if (primaryHorizontal > b.getScreenWidth(this.mContext)) {
                lineTop = b.getScreenWidth(this.mContext) - 16;
            } else {
                lineTop = primaryHorizontal;
            }
            this.uPe.bU(lineTop, i);
        }
    }

    public final void fp(int i, int i2) {
        if (i != -1) {
            this.uPb.Tw = i;
        }
        if (i2 != -1) {
            this.uPb.tK = i2;
        }
        if (this.uPb.Tw > this.uPb.tK) {
            int i3 = this.uPb.Tw;
            this.uPb.Tw = this.uPb.tK;
            this.uPb.tK = i3;
        }
        if (this.uPd != null) {
            this.uPb.uPz = this.uPd.subSequence(this.uPb.Tw, this.uPb.tK).toString();
            if (this.uPk == null) {
                this.uPk = new c(this.ih, this.mContext.getResources().getColor(this.uPh), this.uPb.Tw, this.uPb.tK);
            }
            if (this.uPk != null) {
                c cVar = this.uPk;
                int i4 = this.uPb.Tw;
                int i5 = this.uPb.tK;
                cVar.start = i4;
                cVar.end = i5;
            }
            Layout layout = this.ih.getLayout();
            this.uPd.setSpan(this.uPk, layout.getLineStart(layout.getLineForOffset(this.uPb.Tw)), this.uPb.tK, 17);
            if (this.uPc != null) {
                this.uPc.O(this.uPb.uPz);
            }
        }
    }
}
