package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.gridviewheaders.c.b;
import com.tencent.mm.ui.gridviewheaders.c.d;
import java.util.ArrayList;
import java.util.List;

public class GridHeadersGridView extends GridView implements OnScrollListener, OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener {
    private OnItemSelectedListener DT;
    private OnItemClickListener UD;
    protected int VS;
    private int fW;
    private int if;
    private ag mHandler;
    private int mNumColumns;
    private OnScrollListener omy;
    private OnItemLongClickListener tDJ;
    protected boolean tsK;
    private int tsr;
    private int tss;
    private Runnable txo;
    public a uub;
    public b uuc;
    private boolean uud;
    private final Rect uue;
    private boolean uuf;
    private boolean uug;
    private int uuh;
    private long uui;
    private int uuj;
    private float uuk;
    private boolean uul;
    private int uum;
    c uun;
    d uuo;
    private e uup;
    private View uuq;
    protected c uur;
    protected int uus;
    private boolean uut;
    private DataSetObserver yY;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new 1();
        boolean uuy;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.uuy = parcel.readByte() != (byte) 0;
        }

        public String toString() {
            return "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.uuy + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte((byte) (this.uuy ? 1 : 0));
        }
    }

    private class f {
        private int txu;

        private f() {
        }

        /* synthetic */ f(GridHeadersGridView gridHeadersGridView, byte b) {
            this();
        }

        public final void czn() {
            this.txu = GridHeadersGridView.this.getWindowAttachCount();
        }

        public final boolean czo() {
            return GridHeadersGridView.this.hasWindowFocus() && GridHeadersGridView.this.getWindowAttachCount() == this.txu;
        }
    }

    static /* synthetic */ long a(GridHeadersGridView gridHeadersGridView, int i) {
        return i == -2 ? gridHeadersGridView.uui : gridHeadersGridView.uur.oo(gridHeadersGridView.getFirstVisiblePosition() + i);
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842865);
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new ag();
        this.uud = true;
        this.uue = new Rect();
        this.uui = -1;
        this.yY = new 1(this);
        this.uum = 1;
        this.if = 0;
        this.uut = true;
        super.setOnScrollListener(this);
        setVerticalFadingEdgeEnabled(false);
        if (!this.uul) {
            this.mNumColumns = -1;
        }
        this.fW = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public final View Ga(int i) {
        if (i == -2) {
            return this.uuq;
        }
        try {
            return (View) getChildAt(i).getTag();
        } catch (Exception e) {
            return null;
        }
    }

    public View getStickiedHeader() {
        return this.uuq;
    }

    public boolean getStickyHeaderIsTranscluent() {
        return !this.uut;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.UD.onItemClick(adapterView, view, this.uur.FZ(i).mPosition, j);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return this.tDJ.onItemLongClick(adapterView, view, this.uur.FZ(i).mPosition, j);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.DT.onItemSelected(adapterView, view, this.uur.FZ(i).mPosition, j);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        this.DT.onNothingSelected(adapterView);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.uud = savedState.uuy;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.uuy = this.uud;
        return savedState;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.omy != null) {
            this.omy.onScroll(absListView, i, i2, i3);
        }
        if (VERSION.SDK_INT >= 8) {
            Gb(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.omy != null) {
            this.omy.onScrollStateChanged(absListView, i);
        }
        this.if = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r11) {
        /*
        r10 = this;
        r1 = -2;
        r4 = 1;
        r2 = 0;
        r3 = -1;
        r0 = r11.getAction();
        r0 = r0 & 255;
        switch(r0) {
            case 0: goto L_0x0011;
            case 1: goto L_0x00b4;
            case 2: goto L_0x0082;
            default: goto L_0x000d;
        };
    L_0x000d:
        r0 = r2;
    L_0x000e:
        if (r0 == 0) goto L_0x013a;
    L_0x0010:
        return r2;
    L_0x0011:
        r0 = r10.uuc;
        if (r0 != 0) goto L_0x001c;
    L_0x0015:
        r0 = new com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$b;
        r0.<init>(r10);
        r10.uuc = r0;
    L_0x001c:
        r0 = r10.mHandler;
        r4 = r10.uub;
        r5 = android.view.ViewConfiguration.getTapTimeout();
        r6 = (long) r5;
        r0.postDelayed(r4, r6);
        r0 = r11.getY();
        r0 = (int) r0;
        r4 = (float) r0;
        r10.uuk = r4;
        r4 = (float) r0;
        r0 = r10.uuq;
        if (r0 == 0) goto L_0x004e;
    L_0x0035:
        r0 = r10.uuq;
        r0 = r0.getBottom();
        r0 = (float) r0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x004e;
    L_0x0040:
        r10.uus = r1;
        r0 = r10.uus;
        if (r0 == r3) goto L_0x000d;
    L_0x0046:
        r0 = r10.if;
        r1 = 2;
        if (r0 == r1) goto L_0x000d;
    L_0x004b:
        r10.VS = r2;
        goto L_0x000d;
    L_0x004e:
        r0 = r10.getFirstVisiblePosition();
        r1 = r2;
    L_0x0053:
        r5 = r10.getLastVisiblePosition();
        if (r0 > r5) goto L_0x0080;
    L_0x0059:
        r6 = r10.getItemIdAtPosition(r0);
        r8 = -1;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 != 0) goto L_0x0079;
    L_0x0063:
        r5 = r10.getChildAt(r1);
        r6 = r5.getBottom();
        r5 = r5.getTop();
        r6 = (float) r6;
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 > 0) goto L_0x0079;
    L_0x0074:
        r5 = (float) r5;
        r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r5 >= 0) goto L_0x0040;
    L_0x0079:
        r5 = r10.uum;
        r0 = r0 + r5;
        r5 = r10.uum;
        r1 = r1 + r5;
        goto L_0x0053;
    L_0x0080:
        r1 = r3;
        goto L_0x0040;
    L_0x0082:
        r0 = r10.uus;
        if (r0 == r3) goto L_0x000d;
    L_0x0086:
        r0 = r11.getY();
        r1 = r10.uuk;
        r0 = r0 - r1;
        r0 = java.lang.Math.abs(r0);
        r1 = r10.fW;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x000d;
    L_0x0098:
        r10.VS = r3;
        r0 = r10.uus;
        r0 = r10.Ga(r0);
        if (r0 == 0) goto L_0x00a5;
    L_0x00a2:
        r0.setPressed(r2);
    L_0x00a5:
        r0 = r10.uub;
        if (r0 == 0) goto L_0x00b0;
    L_0x00a9:
        r0 = r10.mHandler;
        r1 = r10.uub;
        r0.removeCallbacks(r1);
    L_0x00b0:
        r10.uus = r3;
        goto L_0x000d;
    L_0x00b4:
        r0 = r10.VS;
        if (r0 == r1) goto L_0x000d;
    L_0x00b8:
        r0 = r10.VS;
        if (r0 == r3) goto L_0x000d;
    L_0x00bc:
        r0 = r10.uus;
        if (r0 == r3) goto L_0x000d;
    L_0x00c0:
        r0 = r10.uus;
        r1 = r10.Ga(r0);
        if (r1 == 0) goto L_0x012c;
    L_0x00c8:
        r0 = r1.hasFocusable();
        if (r0 != 0) goto L_0x012c;
    L_0x00ce:
        r0 = r10.VS;
        if (r0 == 0) goto L_0x00d5;
    L_0x00d2:
        r1.setPressed(r2);
    L_0x00d5:
        r0 = r10.uup;
        if (r0 != 0) goto L_0x00e0;
    L_0x00d9:
        r0 = new com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$e;
        r0.<init>(r10, r2);
        r10.uup = r0;
    L_0x00e0:
        r5 = r10.uup;
        r0 = r10.uus;
        r5.uux = r0;
        r5.czn();
        r0 = r10.VS;
        if (r0 != 0) goto L_0x00f1;
    L_0x00ed:
        r0 = r10.VS;
        if (r0 == r4) goto L_0x0130;
    L_0x00f1:
        r6 = r10.mHandler;
        r0 = r10.VS;
        if (r0 != 0) goto L_0x0127;
    L_0x00f7:
        r0 = r10.uuc;
    L_0x00f9:
        r6.removeCallbacks(r0);
        r0 = r10.tsK;
        if (r0 != 0) goto L_0x012a;
    L_0x0100:
        r10.VS = r4;
        r1.setPressed(r4);
        r10.setPressed(r4);
        r0 = r10.txo;
        if (r0 == 0) goto L_0x0111;
    L_0x010c:
        r0 = r10.txo;
        r10.removeCallbacks(r0);
    L_0x0111:
        r0 = new com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$2;
        r0.<init>(r10, r1, r5);
        r10.txo = r0;
        r0 = r10.mHandler;
        r1 = r10.txo;
        r3 = android.view.ViewConfiguration.getPressedStateDuration();
        r6 = (long) r3;
        r0.postDelayed(r1, r6);
        r0 = r4;
        goto L_0x000e;
    L_0x0127:
        r0 = r10.uub;
        goto L_0x00f9;
    L_0x012a:
        r10.VS = r3;
    L_0x012c:
        r10.VS = r3;
        goto L_0x000d;
    L_0x0130:
        r0 = r10.tsK;
        if (r0 != 0) goto L_0x012c;
    L_0x0134:
        r5.run();
        r0 = r4;
        goto L_0x000e;
    L_0x013a:
        r2 = super.dispatchTouchEvent(r11);
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAdapter(ListAdapter listAdapter) {
        b bVar;
        if (!(this.uur == null || this.yY == null)) {
            this.uur.unregisterDataSetObserver(this.yY);
        }
        if (!this.uug) {
            this.uuf = true;
        }
        if (listAdapter instanceof b) {
            bVar = (b) listAdapter;
        } else if (listAdapter instanceof e) {
            bVar = new f((e) listAdapter);
        } else {
            bVar = new d(listAdapter);
        }
        this.uur = new c(getContext(), this, bVar);
        this.uur.registerDataSetObserver(this.yY);
        reset();
        super.setAdapter(this.uur);
    }

    public void setAreHeadersSticky(boolean z) {
        if (z != this.uud) {
            this.uud = z;
            requestLayout();
        }
    }

    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.uuf = z;
        this.uug = true;
    }

    public void setColumnWidth(int i) {
        super.setColumnWidth(i);
        this.uuh = i;
    }

    public void setHorizontalSpacing(int i) {
        super.setHorizontalSpacing(i);
        this.tsr = i;
    }

    public void setNumColumns(int i) {
        super.setNumColumns(i);
        this.uul = true;
        this.mNumColumns = i;
        if (i != -1 && this.uur != null) {
            this.uur.setNumColumns(i);
        }
    }

    public void setOnHeaderClickListener(c cVar) {
        this.uun = cVar;
    }

    public void setOnHeaderLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.uuo = dVar;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.UD = onItemClickListener;
        super.setOnItemClickListener(this);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.tDJ = onItemLongClickListener;
        super.setOnItemLongClickListener(this);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.DT = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.omy = onScrollListener;
    }

    public void setStickyHeaderIsTranscluent(boolean z) {
        this.uut = !z;
    }

    public void setVerticalSpacing(int i) {
        super.setVerticalSpacing(i);
        this.tss = i;
    }

    private int getHeaderHeight() {
        if (this.uuq != null) {
            return this.uuq.getMeasuredHeight();
        }
        return 0;
    }

    private void czl() {
        if (this.uuq != null) {
            int makeMeasureSpec;
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
            LayoutParams layoutParams = this.uuq.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            this.uuq.measure(makeMeasureSpec2, makeMeasureSpec);
            this.uuq.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.uuq.getMeasuredHeight());
        }
    }

    private void reset() {
        this.uuj = 0;
        this.uuq = null;
        this.uui = Long.MIN_VALUE;
    }

    private void Gb(int i) {
        if (this.uur != null && this.uur.getCount() != 0 && this.uud && ((d) getChildAt(0)) != null) {
            long oo;
            int i2;
            int childCount;
            int i3 = i - this.uum;
            if (i3 < 0) {
                i3 = i;
            }
            int i4 = this.uum + i;
            if (i4 >= this.uur.getCount()) {
                i4 = i;
            }
            if (this.tss != 0) {
                if (this.tss < 0) {
                    this.uur.oo(i);
                    if (getChildAt(this.uum).getTop() <= 0) {
                        oo = this.uur.oo(i4);
                        i2 = i4;
                    } else {
                        oo = this.uur.oo(i);
                        i2 = i;
                    }
                } else {
                    i4 = getChildAt(0).getTop();
                    if (i4 > 0 && i4 < this.tss) {
                        oo = this.uur.oo(i3);
                        i2 = i3;
                    }
                }
                if (this.uui != oo) {
                    this.uuq = this.uur.a(i2, this.uuq, this);
                    czl();
                    this.uui = oo;
                }
                childCount = getChildCount();
                if (childCount != 0) {
                    View view = null;
                    int i5 = 99999;
                    i2 = 0;
                    while (i2 < childCount) {
                        d dVar = (d) super.getChildAt(i2);
                        if (this.uuf) {
                            i4 = dVar.getTop() - getPaddingTop();
                        } else {
                            i4 = dVar.getTop();
                        }
                        if (i4 < 0 || !(dVar.getView() instanceof b) || i4 >= i5) {
                            i4 = i5;
                            dVar = view;
                        }
                        i2 += this.uum;
                        i5 = i4;
                        view = dVar;
                    }
                    i3 = getHeaderHeight();
                    if (view == null) {
                        this.uuj = i3;
                        if (this.uuf) {
                            this.uuj += getPaddingTop();
                        }
                    } else if (i == 0 && super.getChildAt(0).getTop() > 0 && !this.uuf) {
                        this.uuj = 0;
                    } else if (this.uuf) {
                        this.uuj = Math.min(view.getTop(), getPaddingTop() + i3);
                        this.uuj = this.uuj < getPaddingTop() ? i3 + getPaddingTop() : this.uuj;
                    } else {
                        this.uuj = Math.min(view.getTop(), i3);
                        if (this.uuj >= 0) {
                            i3 = this.uuj;
                        }
                        this.uuj = i3;
                    }
                }
            }
            oo = this.uur.oo(i);
            i2 = i;
            if (this.uui != oo) {
                this.uuq = this.uur.a(i2, this.uuq, this);
                czl();
                this.uui = oo;
            }
            childCount = getChildCount();
            if (childCount != 0) {
                View view2 = null;
                int i52 = 99999;
                i2 = 0;
                while (i2 < childCount) {
                    d dVar2 = (d) super.getChildAt(i2);
                    if (this.uuf) {
                        i4 = dVar2.getTop() - getPaddingTop();
                    } else {
                        i4 = dVar2.getTop();
                    }
                    if (i4 < 0 || !(dVar2.getView() instanceof b) || i4 >= i52) {
                        i4 = i52;
                        dVar2 = view2;
                    }
                    i2 += this.uum;
                    i52 = i4;
                    view2 = dVar2;
                }
                i3 = getHeaderHeight();
                if (view2 == null) {
                    this.uuj = i3;
                    if (this.uuf) {
                        this.uuj += getPaddingTop();
                    }
                } else if (i == 0 && super.getChildAt(0).getTop() > 0 && !this.uuf) {
                    this.uuj = 0;
                } else if (this.uuf) {
                    this.uuj = Math.min(view2.getTop(), getPaddingTop() + i3);
                    this.uuj = this.uuj < getPaddingTop() ? i3 + getPaddingTop() : this.uuj;
                } else {
                    this.uuj = Math.min(view2.getTop(), i3);
                    if (this.uuj >= 0) {
                        i3 = this.uuj;
                    }
                    this.uuj = i3;
                }
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        Object obj;
        if (VERSION.SDK_INT < 8) {
            Gb(getFirstVisiblePosition());
        }
        if (this.uuq != null && this.uud && this.uuq.getVisibility() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        int headerHeight = getHeaderHeight();
        int i = this.uuj - headerHeight;
        if (obj != null && this.uut) {
            this.uue.left = getPaddingLeft();
            this.uue.right = getWidth() - getPaddingRight();
            this.uue.top = this.uuj;
            this.uue.bottom = getHeight();
            canvas.save();
            canvas.clipRect(this.uue);
        }
        super.dispatchDraw(canvas);
        List arrayList = new ArrayList();
        int i2 = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                arrayList.add(Integer.valueOf(i2));
            }
            firstVisiblePosition += this.uum;
            i2 += this.uum;
        }
        firstVisiblePosition = 0;
        while (true) {
            int i3 = firstVisiblePosition;
            if (i3 < arrayList.size()) {
                d dVar = (d) getChildAt(((Integer) arrayList.get(i3)).intValue());
                try {
                    View view = (View) dVar.getTag();
                    Object obj2 = (((long) ((b) dVar.getChildAt(0)).getHeaderId()) == this.uui && dVar.getTop() < 0 && this.uud) ? 1 : null;
                    if (view.getVisibility() == 0 && obj2 == null) {
                        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), (1073741824 - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
                        view.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), dVar.getHeight());
                        this.uue.left = getPaddingLeft();
                        this.uue.right = getWidth() - getPaddingRight();
                        this.uue.bottom = dVar.getBottom();
                        this.uue.top = dVar.getTop();
                        canvas.save();
                        canvas.clipRect(this.uue);
                        canvas.translate((float) getPaddingLeft(), (float) dVar.getTop());
                        view.draw(canvas);
                        canvas.restore();
                    }
                    firstVisiblePosition = i3 + 1;
                } catch (Exception e) {
                    return;
                }
            }
            if (obj != null && this.uut) {
                canvas.restore();
            } else if (obj == null) {
                return;
            }
            if (this.uuq.getWidth() != (getWidth() - getPaddingLeft()) - getPaddingRight()) {
                this.uuq.measure(MeasureSpec.makeMeasureSpec(getWidth(), (1073741824 - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
                this.uuq.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.uuq.getHeight());
            }
            this.uue.left = getPaddingLeft();
            this.uue.right = getWidth() - getPaddingRight();
            this.uue.bottom = i + headerHeight;
            if (this.uuf) {
                this.uue.top = getPaddingTop();
            } else {
                this.uue.top = 0;
            }
            canvas.save();
            canvas.clipRect(this.uue);
            canvas.translate((float) getPaddingLeft(), (float) i);
            canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (int) ((255.0f * ((float) this.uuj)) / ((float) headerHeight)), 4);
            this.uuq.draw(canvas);
            canvas.restore();
            canvas.restore();
            return;
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        if (this.mNumColumns == -1) {
            if (this.uuh > 0) {
                int max = Math.max((MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight(), 0);
                int i4 = max / this.uuh;
                if (i4 > 0) {
                    while (i4 != 1 && (this.uuh * i4) + ((i4 - 1) * this.tsr) > max) {
                        i4--;
                    }
                    i3 = i4;
                }
            } else {
                i3 = 2;
            }
            this.uum = i3;
        } else {
            this.uum = this.mNumColumns;
        }
        if (this.uur != null) {
            this.uur.setNumColumns(this.uum);
        }
        czl();
        super.onMeasure(i, i2);
    }
}
