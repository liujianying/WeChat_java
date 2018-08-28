package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.z;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListViewV2 extends AdapterView<ListAdapter> {
    protected ListAdapter Do;
    private Drawable OZ = null;
    private int Pa = 0;
    private Rect cO = new Rect();
    private GestureDetector gbw;
    private OnClickListener mOnClickListener;
    protected int tsC;
    protected int tsD;
    private int tsE = Integer.MAX_VALUE;
    private int tsF;
    private boolean tsK = false;
    protected Scroller tsO = new Scroller(getContext());
    private final a tsP = new a(this, (byte) 0);
    private List<Queue<View>> tsQ = new ArrayList();
    private View tsR = null;
    private Integer tsS = null;
    private int tsT;
    private int tsU;
    private int tsV;
    private e tsW = null;
    private int tsX = 0;
    private boolean tsY = false;
    private d tsZ = null;
    private int tta = a.ttj;
    private i ttb;
    private i ttc;
    private int ttd;
    private boolean tte = false;
    private boolean ttf = false;
    private DataSetObserver ttg = new 2(this);
    private Runnable tth = new 3(this);

    static /* synthetic */ void b(HorizontalListViewV2 horizontalListViewV2, int i) {
        if (horizontalListViewV2.ttb != null && horizontalListViewV2.ttc != null) {
            int i2 = horizontalListViewV2.tsC + i;
            if (horizontalListViewV2.tsO != null && !horizontalListViewV2.tsO.isFinished()) {
                return;
            }
            if (i2 < 0) {
                horizontalListViewV2.ttb.A(((float) Math.abs(i)) / ((float) horizontalListViewV2.getRenderWidth()));
                if (!horizontalListViewV2.ttc.isFinished()) {
                    horizontalListViewV2.ttc.cI();
                }
            } else if (i2 > horizontalListViewV2.tsE) {
                horizontalListViewV2.ttc.A(((float) Math.abs(i)) / ((float) horizontalListViewV2.getRenderWidth()));
                if (!horizontalListViewV2.ttb.isFinished()) {
                    horizontalListViewV2.ttb.cI();
                }
            }
        }
    }

    public HorizontalListViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ttb = new i(context);
        this.ttc = new i(context);
        this.gbw = new GestureDetector(context, this.tsP);
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return HorizontalListViewV2.this.gbw.onTouchEvent(motionEvent);
            }
        });
        initView();
        setWillNotDraw(false);
        if (VERSION.SDK_INT >= 11) {
            b.a(this.tsO);
        }
    }

    private void i(Boolean bool) {
        if (this.ttf != bool.booleanValue()) {
            View view = this;
            while (view.getParent() instanceof View) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.ttf = bool.booleanValue();
                    return;
                }
                view = (View) view.getParent();
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", this.tsC);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.tsS = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
    }

    public void setDivider(Drawable drawable) {
        this.OZ = drawable;
        if (drawable != null) {
            setDividerWidth(drawable.getIntrinsicWidth());
        } else {
            setDividerWidth(0);
        }
    }

    public void setDividerWidth(int i) {
        this.Pa = i;
        requestLayout();
        invalidate();
    }

    private void initView() {
        this.tsT = -1;
        this.tsU = -1;
        this.tsF = 0;
        this.tsC = 0;
        this.tsD = 0;
        this.tsE = Integer.MAX_VALUE;
        setCurrentScrollState$7f9485c6(a.ttj);
    }

    private void reset() {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    public void setSelection(int i) {
        this.tsV = i;
    }

    public View getSelectedView() {
        int i = this.tsV;
        return (i < this.tsT || i > this.tsU) ? null : getChildAt(i - this.tsT);
    }

    public void setAdapter(ListAdapter listAdapter) {
        int i = 0;
        if (this.Do != null) {
            this.Do.unregisterDataSetObserver(this.ttg);
        }
        if (listAdapter != null) {
            this.tsY = false;
            this.Do = listAdapter;
            this.Do.registerDataSetObserver(this.ttg);
        }
        if (this.Do != null) {
            int viewTypeCount = this.Do.getViewTypeCount();
            this.tsQ.clear();
            while (i < viewTypeCount) {
                this.tsQ.add(new LinkedList());
                i++;
            }
        }
        reset();
    }

    public ListAdapter getAdapter() {
        return this.Do;
    }

    private View Ee(int i) {
        int itemViewType = this.Do.getItemViewType(i);
        if (Ef(itemViewType)) {
            return (View) ((Queue) this.tsQ.get(itemViewType)).poll();
        }
        return null;
    }

    private void i(int i, View view) {
        int itemViewType = this.Do.getItemViewType(i);
        if (Ef(itemViewType)) {
            ((Queue) this.tsQ.get(itemViewType)).offer(view);
        }
    }

    private boolean Ef(int i) {
        return i < this.tsQ.size();
    }

    private void K(View view, int i) {
        addViewInLayout(view, i, dm(view), true);
        LayoutParams dm = dm(view);
        view.measure(dm.width > 0 ? MeasureSpec.makeMeasureSpec(dm.width, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0), ViewGroup.getChildMeasureSpec(this.ttd, getPaddingTop() + getPaddingBottom(), dm.height));
    }

    private static LayoutParams dm(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return new LayoutParams(-2, -1);
        }
        return layoutParams;
    }

    @SuppressLint({"WrongCall"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = false;
        super.onLayout(z, i, i2, i3, i4);
        if (this.Do != null) {
            int i5;
            int i6;
            View rightmostChild;
            View view;
            int i7;
            invalidate();
            if (this.tsK) {
                i5 = this.tsC;
                initView();
                removeAllViewsInLayout();
                this.tsD = i5;
                this.tsK = false;
            }
            if (this.tsS != null) {
                this.tsD = this.tsS.intValue();
                this.tsS = null;
            }
            if (this.tsO.computeScrollOffset()) {
                this.tsD = this.tsO.getCurrX();
            }
            if (this.tsD < 0) {
                this.tsD = 0;
                if (this.ttb.isFinished()) {
                    this.ttb.at((int) crh());
                }
                this.tsO.forceFinished(true);
                setCurrentScrollState$7f9485c6(a.ttj);
            } else if (this.tsD > this.tsE) {
                this.tsD = this.tsE;
                if (this.ttc.isFinished()) {
                    this.ttc.at((int) crh());
                }
                this.tsO.forceFinished(true);
                setCurrentScrollState$7f9485c6(a.ttj);
            }
            int i8 = this.tsC - this.tsD;
            View leftmostChild = getLeftmostChild();
            while (leftmostChild != null && leftmostChild.getRight() + i8 <= 0) {
                i6 = this.tsF;
                if (Eg(this.tsT)) {
                    i5 = leftmostChild.getMeasuredWidth();
                } else {
                    i5 = this.Pa + leftmostChild.getMeasuredWidth();
                }
                this.tsF = i5 + i6;
                i(this.tsT, leftmostChild);
                removeViewInLayout(leftmostChild);
                this.tsT++;
                leftmostChild = getLeftmostChild();
            }
            while (true) {
                rightmostChild = getRightmostChild();
                if (rightmostChild == null || rightmostChild.getLeft() + i8 < getWidth()) {
                    rightmostChild = getRightmostChild();
                } else {
                    i(this.tsU, rightmostChild);
                    removeViewInLayout(rightmostChild);
                    this.tsU--;
                }
            }
            rightmostChild = getRightmostChild();
            i5 = rightmostChild != null ? rightmostChild.getRight() : 0;
            while ((i5 + i8) + this.Pa < getWidth() && this.tsU + 1 < this.Do.getCount()) {
                this.tsU++;
                if (this.tsT < 0) {
                    this.tsT = this.tsU;
                }
                view = this.Do.getView(this.tsU, Ee(this.tsU), this);
                K(view, -1);
                i5 += (this.tsU == 0 ? 0 : this.Pa) + view.getMeasuredWidth();
                if (!(this.tsW == null || this.Do == null || this.Do.getCount() - (this.tsU + 1) >= this.tsX || this.tsY)) {
                    this.tsY = true;
                }
            }
            rightmostChild = getLeftmostChild();
            i5 = rightmostChild != null ? rightmostChild.getLeft() : 0;
            while ((i5 + i8) - this.Pa > 0 && this.tsT > 0) {
                this.tsT--;
                view = this.Do.getView(this.tsT, Ee(this.tsT), this);
                K(view, 0);
                i5 -= this.tsT == 0 ? view.getMeasuredWidth() : this.Pa + view.getMeasuredWidth();
                this.tsF -= i5 + i8 == 0 ? view.getMeasuredWidth() : this.Pa + view.getMeasuredWidth();
            }
            i6 = getChildCount();
            if (i6 > 0) {
                this.tsF += i8;
                i7 = this.tsF;
                for (i5 = 0; i5 < i6; i5++) {
                    View childAt = getChildAt(i5);
                    int paddingLeft = getPaddingLeft() + i7;
                    int paddingTop = getPaddingTop();
                    childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                    i7 += childAt.getMeasuredWidth() + this.Pa;
                }
            }
            this.tsC = this.tsD;
            if (Eg(this.tsU)) {
                rightmostChild = getRightmostChild();
                if (rightmostChild != null) {
                    i7 = this.tsE;
                    this.tsE = ((rightmostChild.getRight() - getPaddingLeft()) + this.tsC) - getRenderWidth();
                    if (this.tsE < 0) {
                        this.tsE = 0;
                    }
                    if (this.tsE != i7) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                onLayout(z, i, i2, i3, i4);
            } else if (!this.tsO.isFinished()) {
                z.a(this, this.tth);
            } else if (this.tta == a.ttl) {
                setCurrentScrollState$7f9485c6(a.ttj);
            }
        }
    }

    protected float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.tsC == 0) {
            return 0.0f;
        }
        if (this.tsC < horizontalFadingEdgeLength) {
            return ((float) this.tsC) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.tsC == this.tsE) {
            return 0.0f;
        }
        if (this.tsE - this.tsC < horizontalFadingEdgeLength) {
            return ((float) (this.tsE - this.tsC)) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    private float crh() {
        if (VERSION.SDK_INT >= 14) {
            return c.b(this.tsO);
        }
        return 30.0f;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.ttd = i2;
    }

    private View getLeftmostChild() {
        return getChildAt(0);
    }

    private View getRightmostChild() {
        return getChildAt(getChildCount() - 1);
    }

    private int eP(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).getHitRect(this.cO);
            if (this.cO.contains(i, i2)) {
                return i3;
            }
        }
        return -1;
    }

    private boolean Eg(int i) {
        return i == this.Do.getCount() + -1;
    }

    private int getRenderHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getRenderWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public final void Eh(int i) {
        this.tsO.startScroll(this.tsD, 0, i - this.tsD, 0);
        setCurrentScrollState$7f9485c6(a.ttl);
        requestLayout();
    }

    public int getFirstVisiblePosition() {
        return this.tsT;
    }

    public int getLastVisiblePosition() {
        return this.tsU;
    }

    private void a(Canvas canvas, Rect rect) {
        if (this.OZ != null) {
            this.OZ.setBounds(rect);
            this.OZ.draw(canvas);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int childCount = getChildCount();
        Rect rect = this.cO;
        this.cO.top = getPaddingTop();
        this.cO.bottom = this.cO.top + getRenderHeight();
        for (int i = 0; i < childCount; i++) {
            if (i != childCount - 1 || !Eg(this.tsU)) {
                View childAt = getChildAt(i);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.Pa;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                a(canvas, rect);
                if (i == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    a(canvas, rect);
                }
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    protected void dispatchSetPressed(boolean z) {
    }

    protected final boolean aC(float f) {
        this.tsO.fling(this.tsD, 0, (int) (-f), 0, 0, this.tsE, 0, 0);
        setCurrentScrollState$7f9485c6(a.ttl);
        requestLayout();
        return true;
    }

    protected final boolean onDown(MotionEvent motionEvent) {
        this.tte = !this.tsO.isFinished();
        this.tsO.forceFinished(true);
        setCurrentScrollState$7f9485c6(a.ttj);
        cri();
        if (!this.tte) {
            int eP = eP((int) motionEvent.getX(), (int) motionEvent.getY());
            if (eP >= 0) {
                this.tsR = getChildAt(eP);
                if (this.tsR != null) {
                    this.tsR.setPressed(true);
                    refreshDrawableState();
                }
            }
        }
        return true;
    }

    private void cri() {
        if (this.tsR != null) {
            this.tsR.setPressed(false);
            refreshDrawableState();
            this.tsR = null;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.tsO == null || this.tsO.isFinished()) {
                setCurrentScrollState$7f9485c6(a.ttj);
            }
            i(Boolean.valueOf(false));
            crj();
        } else if (motionEvent.getAction() == 3) {
            cri();
            crj();
            i(Boolean.valueOf(false));
        }
        return super.onTouchEvent(motionEvent);
    }

    private void crj() {
        if (this.ttb != null) {
            this.ttb.cI();
        }
        if (this.ttc != null) {
            this.ttc.cI();
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnScrollStateChangedListener(d dVar) {
        this.tsZ = dVar;
    }

    private void setCurrentScrollState$7f9485c6(int i) {
        if (!(this.tta == i || this.tsZ == null)) {
            this.tsZ.sa(i);
        }
        this.tta = i;
    }
}
