package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

public class MMHorList extends AdapterView<ListAdapter> {
    private boolean lAt = false;
    private int offset;
    private boolean tvA = false;
    private boolean tvB = false;
    protected Scroller tvC;
    private GestureDetector tvD;
    private OnItemSelectedListener tvE;
    private OnItemClickListener tvF;
    private ListAdapter tvG;
    private Runnable tvH = new 1(this);
    private boolean tvI = false;
    private boolean tvJ = false;
    private int tvK = 0;
    private int tvL = 0;
    private boolean tvM = false;
    private DataSetObserver tvN = new 2(this);
    private OnGestureListener tvO = new 3(this);
    private a tvt;
    private int tvu;
    private int tvv;
    private int tvw;
    private int tvx;
    private int tvy = 536870912;
    private Queue<View> tvz = new LinkedList();

    public interface a {
        void bHl();

        void bHm();

        void bbm();
    }

    public void setHorListLitener(a aVar) {
        this.tvt = aVar;
    }

    public void setCenterInParent(boolean z) {
        this.tvI = z;
    }

    public void setOverScrollEnabled(boolean z) {
        this.tvJ = z;
    }

    public void setItemWidth(int i) {
        this.tvK = i;
    }

    private void init() {
        this.tvC = new Scroller(getContext());
        this.tvu = -1;
        this.tvv = 0;
        this.offset = 0;
        this.tvw = 0;
        this.tvx = 0;
        this.tvA = false;
        this.tvy = 536870912;
        this.tvD = new GestureDetector(getContext(), this.tvO);
    }

    public MMHorList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.tvE = onItemSelectedListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.tvF = onItemClickListener;
    }

    public MMHorList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ListAdapter getAdapter() {
        return this.tvG;
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.tvG == null) {
            listAdapter.registerDataSetObserver(this.tvN);
        }
        this.tvG = listAdapter;
        reset();
    }

    private int getChildViewTotalWidth() {
        return this.tvG.getCount() * this.tvK;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.tvG != null) {
            int i5;
            int i6;
            this.tvB = true;
            if (this.tvA) {
                i5 = this.tvw;
                init();
                removeAllViewsInLayout();
                this.tvx = i5;
                if (this.tvI) {
                    this.tvL = Math.max(0, (getWidth() - getChildViewTotalWidth()) / 2);
                    this.offset = this.tvL;
                }
                this.tvA = false;
            }
            if (this.tvC.computeScrollOffset()) {
                this.tvx = this.tvC.getCurrX();
            }
            if (!this.tvJ) {
                if (this.tvx < 0) {
                    this.tvx = 0;
                    this.tvC.forceFinished(true);
                }
                if (this.tvx > this.tvy) {
                    this.tvx = this.tvy;
                    this.tvC.forceFinished(true);
                }
            } else if (getChildViewTotalWidth() > getWidth()) {
                if (this.tvx < getWidth() * -1) {
                    this.tvx = (getWidth() * -1) + 1;
                    this.tvC.forceFinished(true);
                }
                if (this.tvx > this.tvy + getWidth()) {
                    this.tvx = (this.tvy + getWidth()) - 1;
                    this.tvC.forceFinished(true);
                }
            } else {
                if (this.tvx < (getWidth() * -1) + this.tvL) {
                    this.tvx = ((getWidth() * -1) + this.tvL) + 1;
                    this.tvC.forceFinished(true);
                }
                if (this.tvx > getWidth() - this.tvL) {
                    this.tvx = (getWidth() - this.tvL) - 1;
                    this.tvC.forceFinished(true);
                }
            }
            int i7 = this.tvw - this.tvx;
            View childAt = getChildAt(0);
            while (childAt != null && childAt.getRight() + i7 <= 0) {
                this.offset += childAt.getMeasuredWidth();
                this.tvz.offer(childAt);
                removeViewInLayout(childAt);
                this.tvu++;
                childAt = getChildAt(0);
                this.tvB = true;
            }
            childAt = getChildAt(getChildCount() - 1);
            while (childAt != null && childAt.getLeft() + i7 >= getWidth()) {
                this.tvz.offer(childAt);
                removeViewInLayout(childAt);
                this.tvv--;
                childAt = getChildAt(getChildCount() - 1);
                this.tvB = true;
            }
            childAt = getChildAt(getChildCount() - 1);
            i5 = childAt != null ? childAt.getRight() : 0;
            while (true) {
                i6 = i5;
                if (i6 + i7 >= getWidth() || this.tvv >= this.tvG.getCount()) {
                    childAt = getChildAt(0);
                } else {
                    childAt = this.tvG.getView(this.tvv, (View) this.tvz.poll(), this);
                    K(childAt, -1);
                    i5 = childAt.getMeasuredWidth() + i6;
                    if (this.tvv == this.tvG.getCount() - 1) {
                        this.tvy = (this.tvw + i5) - getWidth();
                    }
                    this.tvv++;
                }
            }
            childAt = getChildAt(0);
            i5 = childAt != null ? childAt.getLeft() : 0;
            while (true) {
                i6 = i5;
                if (i6 + i7 > 0 && this.tvu >= 0) {
                    View view = this.tvG.getView(this.tvu, (View) this.tvz.poll(), this);
                    K(view, 0);
                    i5 = i6 - view.getMeasuredWidth();
                    this.tvu--;
                    this.offset -= view.getMeasuredWidth();
                }
            }
            if (getChildCount() > 0 && this.tvB) {
                this.offset += i7;
                i6 = this.offset;
                for (i5 = 0; i5 < getChildCount(); i5++) {
                    View childAt2 = getChildAt(i5);
                    int measuredWidth = childAt2.getMeasuredWidth();
                    childAt2.layout(i6, 0, i6 + measuredWidth, childAt2.getMeasuredHeight());
                    i6 += measuredWidth;
                }
            }
            this.tvw = this.tvx;
            if (!this.tvC.isFinished()) {
                post(this.tvH);
            } else if (this.tvt != null && this.tvM) {
                this.tvt.bbm();
                this.tvM = false;
            }
        }
    }

    private void K(View view, int i) {
        this.tvB = true;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    public View getSelectedView() {
        return null;
    }

    public void setSelection(int i) {
    }

    protected void onMeasure(int i, int i2) {
        if (this.tvG != null && this.tvG.getCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                super.onMeasure(i, MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), Integer.MIN_VALUE));
                return;
            }
        }
        super.onMeasure(i, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.tvD.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.lAt = true;
            if (this.tvt != null) {
                this.tvt.bHl();
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            if (this.tvJ) {
                if (getChildViewTotalWidth() > getWidth()) {
                    if (this.tvw < 0) {
                        this.tvC.forceFinished(true);
                        this.tvC.startScroll(this.tvw, 0, 0 - this.tvw, 0);
                        requestLayout();
                    } else if (this.tvw > this.tvy) {
                        this.tvC.forceFinished(true);
                        this.tvC.startScroll(this.tvw, 0, this.tvy - this.tvw, 0);
                        requestLayout();
                    }
                } else if (this.tvw != this.tvL * -1) {
                    this.tvC.forceFinished(true);
                    this.tvC.startScroll(this.tvw, 0, 0 - this.tvw, 0);
                    requestLayout();
                }
            }
            this.lAt = false;
            if (this.tvt != null) {
                this.tvt.bHm();
            }
        }
        return onTouchEvent;
    }

    protected final boolean crg() {
        this.tvC.forceFinished(true);
        return true;
    }

    public final void En(int i) {
        this.tvC.forceFinished(true);
        this.tvC.startScroll(this.tvw, 0, i - this.tvw, 0);
        this.tvM = true;
        requestLayout();
    }

    public int getCurrentPosition() {
        return this.tvw;
    }

    public boolean getIsTouching() {
        return this.lAt;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    protected final boolean aC(float f) {
        this.tvC.fling(this.tvx, 0, (int) (-f), 0, 0, this.tvy, 0, 0);
        requestLayout();
        return true;
    }

    private void reset() {
        init();
        removeAllViewsInLayout();
        requestLayout();
    }
}
