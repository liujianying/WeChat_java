package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;

public abstract class ab {
    protected final h QG;
    int QH;

    /* renamed from: android.support.v7.widget.ab$1 */
    static class AnonymousClass1 extends ab {
        AnonymousClass1(h hVar) {
            super(hVar, (byte) 0);
        }

        public final int ft() {
            return this.QG.mWidth - this.QG.getPaddingRight();
        }

        public final int getEnd() {
            return this.QG.mWidth;
        }

        public final void bj(int i) {
            this.QG.bp(i);
        }

        public final int fs() {
            return this.QG.getPaddingLeft();
        }

        public final int aW(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + (h.bf(view) + layoutParams.leftMargin);
        }

        public final int aX(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + (h.bg(view) + layoutParams.topMargin);
        }

        public final int aV(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + h.bj(view);
        }

        public final int aU(View view) {
            return h.bh(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
        }

        public final int fu() {
            return (this.QG.mWidth - this.QG.getPaddingLeft()) - this.QG.getPaddingRight();
        }

        public final int getEndPadding() {
            return this.QG.getPaddingRight();
        }

        public final int getMode() {
            return this.QG.Sf;
        }

        public final int fv() {
            return this.QG.Sg;
        }
    }

    public abstract int aU(View view);

    public abstract int aV(View view);

    public abstract int aW(View view);

    public abstract int aX(View view);

    public abstract void bj(int i);

    public abstract int fs();

    public abstract int ft();

    public abstract int fu();

    public abstract int fv();

    public abstract int getEnd();

    public abstract int getEndPadding();

    public abstract int getMode();

    /* synthetic */ ab(h hVar, byte b) {
        this(hVar);
    }

    private ab(h hVar) {
        this.QH = Integer.MIN_VALUE;
        this.QG = hVar;
    }

    public final int fr() {
        return Integer.MIN_VALUE == this.QH ? 0 : fu() - this.QH;
    }
}
