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

public class HorizontalListView extends AdapterView<ListAdapter> {
    protected ListAdapter Do;
    private a qNk;
    private int tsA = -1;
    private int tsB = 0;
    protected int tsC;
    protected int tsD;
    private int tsE = Integer.MAX_VALUE;
    private int tsF = 0;
    private GestureDetector tsG;
    private Queue<View> tsH = new LinkedList();
    private OnItemSelectedListener tsI;
    private OnItemClickListener tsJ;
    private boolean tsK = false;
    private DataSetObserver tsL = new 1(this);
    private OnGestureListener tsM = new 3(this);
    public boolean tsz = true;
    protected Scroller wf;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private synchronized void initView() {
        this.tsA = -1;
        this.tsB = 0;
        this.tsF = 0;
        this.tsC = 0;
        this.tsD = 0;
        this.tsE = Integer.MAX_VALUE;
        this.wf = new Scroller(getContext());
        this.tsG = new GestureDetector(getContext(), this.tsM);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.tsI = onItemSelectedListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.tsJ = onItemClickListener;
    }

    public ListAdapter getAdapter() {
        return this.Do;
    }

    public View getSelectedView() {
        return null;
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.Do != null) {
            this.Do.unregisterDataSetObserver(this.tsL);
        }
        this.Do = listAdapter;
        this.Do.registerDataSetObserver(this.tsL);
        reset();
    }

    private synchronized void reset() {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    public void setSelection(int i) {
    }

    private void K(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected synchronized void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        /*
        r7 = this;
        r1 = 0;
        monitor-enter(r7);
        super.onLayout(r8, r9, r10, r11, r12);	 Catch:{ all -> 0x00a0 }
        r0 = r7.Do;	 Catch:{ all -> 0x00a0 }
        if (r0 != 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r7);
        return;
    L_0x000b:
        r0 = r7.tsK;	 Catch:{ all -> 0x00a0 }
        if (r0 == 0) goto L_0x001c;
    L_0x000f:
        r0 = r7.tsC;	 Catch:{ all -> 0x00a0 }
        r7.initView();	 Catch:{ all -> 0x00a0 }
        r7.removeAllViewsInLayout();	 Catch:{ all -> 0x00a0 }
        r7.tsD = r0;	 Catch:{ all -> 0x00a0 }
        r0 = 0;
        r7.tsK = r0;	 Catch:{ all -> 0x00a0 }
    L_0x001c:
        r0 = r7.wf;	 Catch:{ all -> 0x00a0 }
        r0 = r0.computeScrollOffset();	 Catch:{ all -> 0x00a0 }
        if (r0 == 0) goto L_0x002c;
    L_0x0024:
        r0 = r7.wf;	 Catch:{ all -> 0x00a0 }
        r0 = r0.getCurrX();	 Catch:{ all -> 0x00a0 }
        r7.tsD = r0;	 Catch:{ all -> 0x00a0 }
    L_0x002c:
        r0 = r7.tsD;	 Catch:{ all -> 0x00a0 }
        if (r0 > 0) goto L_0x0039;
    L_0x0030:
        r0 = 0;
        r7.tsD = r0;	 Catch:{ all -> 0x00a0 }
        r0 = r7.wf;	 Catch:{ all -> 0x00a0 }
        r2 = 1;
        r0.forceFinished(r2);	 Catch:{ all -> 0x00a0 }
    L_0x0039:
        r0 = r7.tsD;	 Catch:{ all -> 0x00a0 }
        r2 = r7.tsE;	 Catch:{ all -> 0x00a0 }
        if (r0 < r2) goto L_0x0049;
    L_0x003f:
        r0 = r7.tsE;	 Catch:{ all -> 0x00a0 }
        r7.tsD = r0;	 Catch:{ all -> 0x00a0 }
        r0 = r7.wf;	 Catch:{ all -> 0x00a0 }
        r2 = 1;
        r0.forceFinished(r2);	 Catch:{ all -> 0x00a0 }
    L_0x0049:
        r0 = r7.tsC;	 Catch:{ all -> 0x00a0 }
        r2 = r7.tsD;	 Catch:{ all -> 0x00a0 }
        r3 = r0 - r2;
        r0 = 0;
        r0 = r7.getChildAt(r0);	 Catch:{ all -> 0x00a0 }
    L_0x0054:
        if (r0 == 0) goto L_0x007a;
    L_0x0056:
        r2 = r0.getRight();	 Catch:{ all -> 0x00a0 }
        r2 = r2 + r3;
        if (r2 > 0) goto L_0x007a;
    L_0x005d:
        r2 = r7.tsF;	 Catch:{ all -> 0x00a0 }
        r4 = r0.getMeasuredWidth();	 Catch:{ all -> 0x00a0 }
        r2 = r2 + r4;
        r7.tsF = r2;	 Catch:{ all -> 0x00a0 }
        r2 = r7.tsH;	 Catch:{ all -> 0x00a0 }
        r2.offer(r0);	 Catch:{ all -> 0x00a0 }
        r7.removeViewInLayout(r0);	 Catch:{ all -> 0x00a0 }
        r0 = r7.tsA;	 Catch:{ all -> 0x00a0 }
        r0 = r0 + 1;
        r7.tsA = r0;	 Catch:{ all -> 0x00a0 }
        r0 = 0;
        r0 = r7.getChildAt(r0);	 Catch:{ all -> 0x00a0 }
        goto L_0x0054;
    L_0x007a:
        r0 = r7.getChildCount();	 Catch:{ all -> 0x00a0 }
        r0 = r0 + -1;
        r0 = r7.getChildAt(r0);	 Catch:{ all -> 0x00a0 }
        if (r0 == 0) goto L_0x00a3;
    L_0x0086:
        r2 = r0.getLeft();	 Catch:{ all -> 0x00a0 }
        r2 = r2 + r3;
        r4 = r7.getWidth();	 Catch:{ all -> 0x00a0 }
        if (r2 < r4) goto L_0x00a3;
    L_0x0091:
        r2 = r7.tsH;	 Catch:{ all -> 0x00a0 }
        r2.offer(r0);	 Catch:{ all -> 0x00a0 }
        r7.removeViewInLayout(r0);	 Catch:{ all -> 0x00a0 }
        r0 = r7.tsB;	 Catch:{ all -> 0x00a0 }
        r0 = r0 + -1;
        r7.tsB = r0;	 Catch:{ all -> 0x00a0 }
        goto L_0x007a;
    L_0x00a0:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x00a3:
        r0 = r7.getChildCount();	 Catch:{ all -> 0x00a0 }
        r0 = r0 + -1;
        r0 = r7.getChildAt(r0);	 Catch:{ all -> 0x00a0 }
        if (r0 == 0) goto L_0x0184;
    L_0x00af:
        r0 = r0.getRight();	 Catch:{ all -> 0x00a0 }
    L_0x00b3:
        r2 = r0;
    L_0x00b4:
        r0 = r2 + r3;
        r4 = r7.getWidth();	 Catch:{ all -> 0x00a0 }
        if (r0 >= r4) goto L_0x0104;
    L_0x00bc:
        r0 = r7.tsB;	 Catch:{ all -> 0x00a0 }
        r4 = r7.Do;	 Catch:{ all -> 0x00a0 }
        r4 = r4.getCount();	 Catch:{ all -> 0x00a0 }
        if (r0 >= r4) goto L_0x0104;
    L_0x00c6:
        r4 = r7.Do;	 Catch:{ all -> 0x00a0 }
        r5 = r7.tsB;	 Catch:{ all -> 0x00a0 }
        r0 = r7.tsH;	 Catch:{ all -> 0x00a0 }
        r0 = r0.poll();	 Catch:{ all -> 0x00a0 }
        r0 = (android.view.View) r0;	 Catch:{ all -> 0x00a0 }
        r0 = r4.getView(r5, r0, r7);	 Catch:{ all -> 0x00a0 }
        r4 = -1;
        r7.K(r0, r4);	 Catch:{ all -> 0x00a0 }
        r0 = r0.getMeasuredWidth();	 Catch:{ all -> 0x00a0 }
        r0 = r0 + r2;
        r2 = r7.tsB;	 Catch:{ all -> 0x00a0 }
        r4 = r7.Do;	 Catch:{ all -> 0x00a0 }
        r4 = r4.getCount();	 Catch:{ all -> 0x00a0 }
        r4 = r4 + -1;
        if (r2 != r4) goto L_0x00f5;
    L_0x00eb:
        r2 = r7.tsC;	 Catch:{ all -> 0x00a0 }
        r2 = r2 + r0;
        r4 = r7.getWidth();	 Catch:{ all -> 0x00a0 }
        r2 = r2 - r4;
        r7.tsE = r2;	 Catch:{ all -> 0x00a0 }
    L_0x00f5:
        r2 = r7.tsE;	 Catch:{ all -> 0x00a0 }
        if (r2 >= 0) goto L_0x00fc;
    L_0x00f9:
        r2 = 0;
        r7.tsE = r2;	 Catch:{ all -> 0x00a0 }
    L_0x00fc:
        r2 = r7.tsB;	 Catch:{ all -> 0x00a0 }
        r2 = r2 + 1;
        r7.tsB = r2;	 Catch:{ all -> 0x00a0 }
        r2 = r0;
        goto L_0x00b4;
    L_0x0104:
        r0 = 0;
        r0 = r7.getChildAt(r0);	 Catch:{ all -> 0x00a0 }
        if (r0 == 0) goto L_0x0182;
    L_0x010b:
        r0 = r0.getLeft();	 Catch:{ all -> 0x00a0 }
    L_0x010f:
        r2 = r0;
    L_0x0110:
        r0 = r2 + r3;
        if (r0 <= 0) goto L_0x0143;
    L_0x0114:
        r0 = r7.tsA;	 Catch:{ all -> 0x00a0 }
        if (r0 < 0) goto L_0x0143;
    L_0x0118:
        r4 = r7.Do;	 Catch:{ all -> 0x00a0 }
        r5 = r7.tsA;	 Catch:{ all -> 0x00a0 }
        r0 = r7.tsH;	 Catch:{ all -> 0x00a0 }
        r0 = r0.poll();	 Catch:{ all -> 0x00a0 }
        r0 = (android.view.View) r0;	 Catch:{ all -> 0x00a0 }
        r4 = r4.getView(r5, r0, r7);	 Catch:{ all -> 0x00a0 }
        r0 = 0;
        r7.K(r4, r0);	 Catch:{ all -> 0x00a0 }
        r0 = r4.getMeasuredWidth();	 Catch:{ all -> 0x00a0 }
        r0 = r2 - r0;
        r2 = r7.tsA;	 Catch:{ all -> 0x00a0 }
        r2 = r2 + -1;
        r7.tsA = r2;	 Catch:{ all -> 0x00a0 }
        r2 = r7.tsF;	 Catch:{ all -> 0x00a0 }
        r4 = r4.getMeasuredWidth();	 Catch:{ all -> 0x00a0 }
        r2 = r2 - r4;
        r7.tsF = r2;	 Catch:{ all -> 0x00a0 }
        r2 = r0;
        goto L_0x0110;
    L_0x0143:
        r0 = r7.getChildCount();	 Catch:{ all -> 0x00a0 }
        if (r0 <= 0) goto L_0x016c;
    L_0x0149:
        r0 = r7.tsF;	 Catch:{ all -> 0x00a0 }
        r0 = r0 + r3;
        r7.tsF = r0;	 Catch:{ all -> 0x00a0 }
        r0 = r7.tsF;	 Catch:{ all -> 0x00a0 }
    L_0x0150:
        r2 = r7.getChildCount();	 Catch:{ all -> 0x00a0 }
        if (r1 >= r2) goto L_0x016c;
    L_0x0156:
        r2 = r7.getChildAt(r1);	 Catch:{ all -> 0x00a0 }
        r3 = r2.getMeasuredWidth();	 Catch:{ all -> 0x00a0 }
        r4 = 0;
        r5 = r0 + r3;
        r6 = r2.getMeasuredHeight();	 Catch:{ all -> 0x00a0 }
        r2.layout(r0, r4, r5, r6);	 Catch:{ all -> 0x00a0 }
        r0 = r0 + r3;
        r1 = r1 + 1;
        goto L_0x0150;
    L_0x016c:
        r0 = r7.tsD;	 Catch:{ all -> 0x00a0 }
        r7.tsC = r0;	 Catch:{ all -> 0x00a0 }
        r0 = r7.wf;	 Catch:{ all -> 0x00a0 }
        r0 = r0.isFinished();	 Catch:{ all -> 0x00a0 }
        if (r0 != 0) goto L_0x0009;
    L_0x0178:
        r0 = new com.tencent.mm.ui.base.HorizontalListView$2;	 Catch:{ all -> 0x00a0 }
        r0.<init>(r7);	 Catch:{ all -> 0x00a0 }
        r7.post(r0);	 Catch:{ all -> 0x00a0 }
        goto L_0x0009;
    L_0x0182:
        r0 = r1;
        goto L_0x010f;
    L_0x0184:
        r0 = r1;
        goto L_0x00b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.base.HorizontalListView.onLayout(boolean, int, int, int, int):void");
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.qNk != null) {
            this.qNk.q(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent) | this.tsG.onTouchEvent(motionEvent);
    }

    protected final boolean aC(float f) {
        synchronized (this) {
            this.wf.fling(this.tsD, 0, (int) (-f), 0, 0, this.tsE, 0, 0);
        }
        requestLayout();
        return true;
    }

    protected final boolean crg() {
        this.wf.forceFinished(true);
        return true;
    }

    public void setDispatchTouchListener(a aVar) {
        this.qNk = aVar;
    }
}
