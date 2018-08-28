package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.design.widget.u.2;
import android.support.v4.view.z;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class TabLayout$c extends LinearLayout {
    final /* synthetic */ TabLayout hJ;
    private int hK;
    private final Paint hL;
    int hM = -1;
    float hN;
    private int hO = -1;
    private int hP = -1;
    u hQ;

    TabLayout$c(TabLayout tabLayout, Context context) {
        this.hJ = tabLayout;
        super(context);
        setWillNotDraw(false);
        this.hL = new Paint();
    }

    final void L(int i) {
        if (this.hL.getColor() != i) {
            this.hL.setColor(i);
            z.E(this);
        }
    }

    final void M(int i) {
        if (this.hK != i) {
            this.hK = i;
            z.E(this);
        }
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (MeasureSpec.getMode(i) == 1073741824 && TabLayout.j(this.hJ) == 1 && TabLayout.m(this.hJ) == 1) {
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (i3 < childCount) {
                int max;
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    max = Math.max(i4, childAt.getMeasuredWidth());
                } else {
                    max = i4;
                }
                i3++;
                i4 = max;
            }
            if (i4 > 0) {
                Object obj;
                if (i4 * childCount <= getMeasuredWidth() - (TabLayout.a(this.hJ, 16) * 2)) {
                    int i5 = 0;
                    obj = null;
                    while (i5 < childCount) {
                        Object obj2;
                        LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                        if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                            obj2 = obj;
                        } else {
                            layoutParams.width = i4;
                            layoutParams.weight = 0.0f;
                            obj2 = 1;
                        }
                        i5++;
                        obj = obj2;
                    }
                } else {
                    TabLayout.n(this.hJ);
                    TabLayout.o(this.hJ);
                    obj = 1;
                }
                if (obj != null) {
                    super.onMeasure(i, i2);
                }
            }
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.hQ == null || !this.hQ.iO.isRunning()) {
            aJ();
            return;
        }
        this.hQ.iO.cancel();
        h(this.hM, Math.round(((float) this.hQ.iO.getDuration()) * (1.0f - this.hQ.iO.getAnimatedFraction())));
    }

    final void aJ() {
        int i;
        int i2;
        View childAt = getChildAt(this.hM);
        if (childAt == null || childAt.getWidth() <= 0) {
            i = -1;
            i2 = -1;
        } else {
            i = childAt.getLeft();
            int right = childAt.getRight();
            if (this.hN <= 0.0f || this.hM >= getChildCount() - 1) {
                i2 = right;
            } else {
                View childAt2 = getChildAt(this.hM + 1);
                i = (int) ((((float) i) * (1.0f - this.hN)) + (this.hN * ((float) childAt2.getLeft())));
                i2 = (int) ((((float) right) * (1.0f - this.hN)) + (((float) childAt2.getRight()) * this.hN));
            }
        }
        g(i, i2);
    }

    private void g(int i, int i2) {
        if (i != this.hO || i2 != this.hP) {
            this.hO = i;
            this.hP = i2;
            z.E(this);
        }
    }

    final void h(int i, int i2) {
        if (this.hQ != null && this.hQ.iO.isRunning()) {
            this.hQ.iO.cancel();
        }
        Object obj = z.I(this) == 1 ? 1 : null;
        View childAt = getChildAt(i);
        if (childAt == null) {
            aJ();
            return;
        }
        int i3;
        int i4;
        int left = childAt.getLeft();
        int right = childAt.getRight();
        int i5;
        if (Math.abs(i - this.hM) <= 1) {
            i5 = this.hO;
            i3 = this.hP;
            i4 = i5;
        } else {
            int a = TabLayout.a(this.hJ, 24);
            if (i < this.hM) {
                if (obj == null) {
                    i5 = right + a;
                    i3 = i5;
                    i4 = i5;
                }
            } else if (obj != null) {
                i5 = right + a;
                i3 = i5;
                i4 = i5;
            }
            i5 = left - a;
            i3 = i5;
            i4 = i5;
        }
        if (i4 != left || i3 != right) {
            u aP = aa.aP();
            this.hQ = aP;
            aP.setInterpolator(a.bM);
            aP.setDuration(i2);
            aP.p(0.0f, 1.0f);
            aP.a(new 1(this, i4, left, i3, right));
            aP.iO.a(new 2(aP, new 2(this, i)));
            aP.iO.start();
        }
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.hO >= 0 && this.hP > this.hO) {
            canvas.drawRect((float) this.hO, (float) (getHeight() - this.hK), (float) this.hP, (float) getHeight(), this.hL);
        }
    }
}
