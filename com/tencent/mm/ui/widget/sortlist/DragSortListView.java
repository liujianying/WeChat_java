package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.bw.a.k;
import com.tencent.smtt.sdk.WebView;

public class DragSortListView extends ListView {
    private int Cu = 0;
    private int fmL;
    private int fmM;
    private int god;
    private int goe;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int uNA;
    private int uNB;
    private b uNC;
    private h uND;
    private l uNE;
    boolean uNF = true;
    private int uNG = 1;
    private int uNH;
    private int uNI;
    private int uNJ = 0;
    private View[] uNK = new View[1];
    private d uNL;
    private float uNM = 0.33333334f;
    private float uNN = 0.33333334f;
    private int uNO;
    private int uNP;
    private float uNQ;
    private float uNR;
    private float uNS;
    private float uNT;
    private float uNU = 0.5f;
    private c uNV = new 1(this);
    private int uNW;
    private int uNX = 0;
    private boolean uNY = false;
    boolean uNZ = false;
    private View uNo;
    private Point uNp = new Point();
    private Point uNq = new Point();
    private int uNr;
    private boolean uNs = false;
    private float uNt = 1.0f;
    private float uNu = 1.0f;
    private int uNv;
    private int uNw;
    private int uNx;
    private boolean uNy = false;
    private int uNz;
    i uOa = null;
    private MotionEvent uOb;
    private int uOc = 0;
    private float uOd = 0.25f;
    private float uOe = 0.0f;
    private a uOf;
    private boolean uOg = false;
    private f uOh;
    private boolean uOi = false;
    private boolean uOj = false;
    private j uOk = new j(this, (byte) 0);
    private k uOl;
    private g uOm;
    boolean uOn;
    private float uOo = 0.0f;
    boolean uOp = false;
    private boolean uOq = false;

    private class m implements Runnable {
        boolean Ju;
        private float mAlpha;
        protected long mStartTime;
        private float uOR;
        private float uOS;
        private float uOT;
        private float uOU;
        private float uOV;

        /* synthetic */ m(DragSortListView dragSortListView, int i, byte b) {
            this(i);
        }

        private m(int i) {
            this.mAlpha = 0.5f;
            this.uOR = (float) i;
            float f = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.uOV = f;
            this.uOS = f;
            this.uOT = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.uOU = 1.0f / (1.0f - this.mAlpha);
        }

        public final void start() {
            this.mStartTime = SystemClock.uptimeMillis();
            this.Ju = false;
            onStart();
            DragSortListView.this.post(this);
        }

        public void onStart() {
        }

        public void aG(float f) {
        }

        public void onStop() {
        }

        public void run() {
            if (!this.Ju) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.uOR;
                if (uptimeMillis >= 1.0f) {
                    aG(1.0f);
                    onStop();
                    return;
                }
                if (uptimeMillis < this.mAlpha) {
                    uptimeMillis *= this.uOS * uptimeMillis;
                } else if (uptimeMillis < 1.0f - this.mAlpha) {
                    uptimeMillis = (uptimeMillis * this.uOU) + this.uOT;
                } else {
                    uptimeMillis = 1.0f - ((uptimeMillis - 1.0f) * (this.uOV * (uptimeMillis - 1.0f)));
                }
                aG(uptimeMillis);
                DragSortListView.this.post(this);
            }
        }
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = 150;
        int i2 = 150;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.DragSortListView, 0, 0);
            this.uNG = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(k.DragSortListView_collapsed_height, 1));
            this.uOg = obtainStyledAttributes.getBoolean(k.DragSortListView_track_drag_sort, false);
            if (this.uOg) {
                this.uOh = new f(this);
            }
            this.uNt = obtainStyledAttributes.getFloat(k.DragSortListView_float_alpha, this.uNt);
            this.uNu = this.uNt;
            this.uNF = obtainStyledAttributes.getBoolean(k.DragSortListView_drag_enabled, this.uNF);
            this.uOd = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(k.DragSortListView_slide_shuffle_speed, 0.75f)));
            this.uNy = this.uOd > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(k.DragSortListView_drag_scroll_start, this.uNM));
            this.uNU = obtainStyledAttributes.getFloat(k.DragSortListView_max_drag_scroll_speed, this.uNU);
            int i3 = obtainStyledAttributes.getInt(k.DragSortListView_remove_animation_duration, 150);
            int i4 = obtainStyledAttributes.getInt(k.DragSortListView_drop_animation_duration, 150);
            if (obtainStyledAttributes.getBoolean(k.DragSortListView_use_default_controller, true)) {
                boolean z = obtainStyledAttributes.getBoolean(k.DragSortListView_remove_enabled, false);
                int i5 = obtainStyledAttributes.getInt(k.DragSortListView_remove_mode, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(k.DragSortListView_sort_enabled, true);
                int i6 = obtainStyledAttributes.getInt(k.DragSortListView_drag_start_mode, 0);
                int resourceId = obtainStyledAttributes.getResourceId(k.DragSortListView_drag_handle_id, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(k.DragSortListView_fling_handle_id, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(k.DragSortListView_click_remove_id, 0);
                int color = obtainStyledAttributes.getColor(k.DragSortListView_float_background_color, WebView.NIGHT_MODE_COLOR);
                a aVar = new a(this, resourceId, i6, i5, resourceId3, resourceId2);
                aVar.uMV = z;
                aVar.uMU = z2;
                aVar.uOX = color;
                this.uOa = aVar;
                setOnTouchListener(aVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i4;
            i = i3;
        }
        this.uNL = new d(this);
        if (i > 0) {
            this.uOl = new k(this, i, (byte) 0);
        }
        if (i2 > 0) {
            this.uOm = new g(this, i2, (byte) 0);
        }
        this.uOb = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.mObserver = new DataSetObserver() {
            private void cancel() {
                if (DragSortListView.this.Cu == 4) {
                    DragSortListView.this.cBb();
                }
            }

            public final void onChanged() {
                cancel();
            }

            public final void onInvalidated() {
                cancel();
            }
        };
    }

    public float getFloatAlpha() {
        return this.uNu;
    }

    public void setFloatAlpha(float f) {
        this.uNu = f;
    }

    public void setMaxScrollSpeed(float f) {
        this.uNU = f;
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.uOf = new a(this, listAdapter, (byte) 0);
            listAdapter.registerDataSetObserver(this.mObserver);
            if (listAdapter instanceof h) {
                setDropListener((h) listAdapter);
            }
            if (listAdapter instanceof b) {
                setDragListener((b) listAdapter);
            }
            if (listAdapter instanceof l) {
                setRemoveListener((l) listAdapter);
            }
        } else {
            this.uOf = null;
        }
        super.setAdapter(this.uOf);
    }

    public ListAdapter getInputAdapter() {
        if (this.uOf == null) {
            return null;
        }
        return this.uOf.Do;
    }

    private void a(int i, Canvas canvas) {
        Drawable divider = getDivider();
        int dividerHeight = getDividerHeight();
        if (divider != null && dividerHeight != 0) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(i - getFirstVisiblePosition());
            if (viewGroup != null) {
                int i2;
                int paddingLeft = getPaddingLeft();
                int width = getWidth() - getPaddingRight();
                int height = viewGroup.getChildAt(0).getHeight();
                if (i > this.uNz) {
                    height += viewGroup.getTop();
                    i2 = height + dividerHeight;
                } else {
                    i2 = viewGroup.getBottom() - height;
                    height = i2 - dividerHeight;
                }
                canvas.save();
                canvas.clipRect(paddingLeft, height, width, i2);
                divider.setBounds(paddingLeft, height, width, i2);
                divider.draw(canvas);
                canvas.restore();
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.Cu != 0) {
            if (this.uNw != this.uNz) {
                a(this.uNw, canvas);
            }
            if (!(this.uNx == this.uNw || this.uNx == this.uNz)) {
                a(this.uNx, canvas);
            }
        }
        if (this.uNo != null) {
            float f;
            int width = this.uNo.getWidth();
            int height = this.uNo.getHeight();
            int i = this.uNp.x;
            int width2 = getWidth();
            if (i < 0) {
                i = -i;
            }
            if (i < width2) {
                f = ((float) (width2 - i)) / ((float) width2);
                f *= f;
            } else {
                f = 0.0f;
            }
            int i2 = (int) (f * (255.0f * this.uNu));
            canvas.save();
            canvas.translate((float) this.uNp.x, (float) this.uNp.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, (float) width, (float) height, i2, 31);
            this.uNo.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    private int GG(int i) {
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt != null) {
            return childAt.getHeight();
        }
        return fo(i, GI(i));
    }

    private int fn(int i, int i2) {
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        if (i <= headerViewsCount || i >= getCount() - footerViewsCount) {
            return i2;
        }
        headerViewsCount = getDividerHeight();
        footerViewsCount = this.uNH - this.uNG;
        int GI = GI(i);
        int GG = GG(i);
        if (this.uNx <= this.uNz) {
            if (i != this.uNx || this.uNw == this.uNx) {
                if (i > this.uNx && i <= this.uNz) {
                    i2 -= footerViewsCount;
                }
            } else if (i == this.uNz) {
                i2 = (i2 + GG) - this.uNH;
            } else {
                i2 = ((GG - GI) + i2) - footerViewsCount;
            }
        } else if (i > this.uNz && i <= this.uNw) {
            i2 += footerViewsCount;
        } else if (i == this.uNx && this.uNw != this.uNx) {
            i2 += GG - GI;
        }
        if (i <= this.uNz) {
            return (((this.uNH - headerViewsCount) - GI(i - 1)) / 2) + i2;
        }
        return (((GI - headerViewsCount) - this.uNH) / 2) + i2;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.uOg) {
            f fVar = this.uOh;
            if (fVar.uOE) {
                int i;
                fVar.mBuilder.append("<DSLVState>\n");
                int childCount = fVar.uOr.getChildCount();
                int firstVisiblePosition = fVar.uOr.getFirstVisiblePosition();
                fVar.mBuilder.append("    <Positions>");
                for (i = 0; i < childCount; i++) {
                    fVar.mBuilder.append(firstVisiblePosition + i).append(",");
                }
                fVar.mBuilder.append("</Positions>\n");
                fVar.mBuilder.append("    <Tops>");
                for (i = 0; i < childCount; i++) {
                    fVar.mBuilder.append(fVar.uOr.getChildAt(i).getTop()).append(",");
                }
                fVar.mBuilder.append("</Tops>\n");
                fVar.mBuilder.append("    <Bottoms>");
                for (i = 0; i < childCount; i++) {
                    fVar.mBuilder.append(fVar.uOr.getChildAt(i).getBottom()).append(",");
                }
                fVar.mBuilder.append("</Bottoms>\n");
                fVar.mBuilder.append("    <FirstExpPos>").append(fVar.uOr.uNw).append("</FirstExpPos>\n");
                fVar.mBuilder.append("    <FirstExpBlankHeight>").append(fVar.uOr.GG(fVar.uOr.uNw) - fVar.uOr.GI(fVar.uOr.uNw)).append("</FirstExpBlankHeight>\n");
                fVar.mBuilder.append("    <SecondExpPos>").append(fVar.uOr.uNx).append("</SecondExpPos>\n");
                fVar.mBuilder.append("    <SecondExpBlankHeight>").append(fVar.uOr.GG(fVar.uOr.uNx) - fVar.uOr.GI(fVar.uOr.uNx)).append("</SecondExpBlankHeight>\n");
                fVar.mBuilder.append("    <SrcPos>").append(fVar.uOr.uNz).append("</SrcPos>\n");
                fVar.mBuilder.append("    <SrcHeight>").append(fVar.uOr.uNH + fVar.uOr.getDividerHeight()).append("</SrcHeight>\n");
                fVar.mBuilder.append("    <ViewHeight>").append(fVar.uOr.getHeight()).append("</ViewHeight>\n");
                fVar.mBuilder.append("    <LastY>").append(fVar.uOr.goe).append("</LastY>\n");
                fVar.mBuilder.append("    <FloatY>").append(fVar.uOr.uNr).append("</FloatY>\n");
                fVar.mBuilder.append("    <ShuffleEdges>");
                for (i = 0; i < childCount; i++) {
                    fVar.mBuilder.append(fVar.uOr.fn(firstVisiblePosition + i, fVar.uOr.getChildAt(i).getTop())).append(",");
                }
                fVar.mBuilder.append("</ShuffleEdges>\n");
                fVar.mBuilder.append("</DSLVState>\n");
                fVar.uOC++;
                if (fVar.uOC > 1000) {
                    fVar.flush();
                    fVar.uOC = 0;
                }
            }
        }
    }

    public final void k(int i, float f) {
        if (this.Cu == 0 || this.Cu == 4) {
            if (this.Cu == 0) {
                this.uNz = getHeaderViewsCount() + i;
                this.uNw = this.uNz;
                this.uNx = this.uNz;
                this.uNv = this.uNz;
                View childAt = getChildAt(this.uNz - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.Cu = 1;
            this.uOo = f;
            if (this.uNZ) {
                switch (this.uOc) {
                    case 1:
                        super.onTouchEvent(this.uOb);
                        break;
                    case 2:
                        super.onInterceptTouchEvent(this.uOb);
                        break;
                }
            }
            if (this.uOl != null) {
                this.uOl.start();
            } else {
                GH(i);
            }
        }
    }

    public final void cBb() {
        if (this.Cu == 4) {
            this.uNL.cBl();
            cBk();
            cBc();
            cBh();
            if (this.uNZ) {
                this.Cu = 3;
            } else {
                this.Cu = 0;
            }
        }
    }

    private void cBc() {
        this.uNz = -1;
        this.uNw = -1;
        this.uNx = -1;
        this.uNv = -1;
    }

    private void cBd() {
        this.Cu = 2;
        if (this.uND != null && this.uNv >= 0 && this.uNv < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.uND.cu(this.uNz - headerViewsCount, this.uNv - headerViewsCount);
        }
        cBk();
        cBe();
        cBc();
        cBh();
        if (this.uNZ) {
            this.Cu = 3;
        } else {
            this.Cu = 0;
        }
    }

    private void GH(int i) {
        this.Cu = 1;
        if (this.uNE != null) {
            this.uNE.remove(i);
        }
        cBk();
        cBe();
        cBc();
        if (this.uNZ) {
            this.Cu = 3;
        } else {
            this.Cu = 0;
        }
    }

    private void cBe() {
        int i = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.uNz < firstVisiblePosition) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                i = childAt.getTop();
            }
            setSelectionFromTop(firstVisiblePosition - 1, i - getPaddingTop());
        }
    }

    public final boolean aE(float f) {
        this.uOn = true;
        return b(true, f);
    }

    private boolean b(boolean z, float f) {
        if (this.uNo == null) {
            return false;
        }
        this.uNL.cBl();
        if (z) {
            k(this.uNz - getHeaderViewsCount(), f);
        } else if (this.uOm != null) {
            this.uOm.start();
        } else {
            cBd();
        }
        if (this.uOg) {
            f fVar = this.uOh;
            if (fVar.uOE) {
                fVar.mBuilder.append("</DSLVStates>\n");
                fVar.flush();
                fVar.uOE = false;
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.uOj) {
            this.uOj = false;
            return false;
        } else if (!this.uNF) {
            return super.onTouchEvent(motionEvent);
        } else {
            boolean z = this.uNY;
            this.uNY = false;
            if (!z) {
                Q(motionEvent);
            }
            if (this.Cu != 4) {
                if (this.Cu == 0 && super.onTouchEvent(motionEvent)) {
                    z = true;
                } else {
                    z = false;
                }
                switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
                    case 1:
                    case 3:
                        cBf();
                        break;
                    default:
                        if (z) {
                            this.uOc = 1;
                            break;
                        }
                        break;
                }
            }
            switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
                case 1:
                    if (this.Cu == 4) {
                        this.uOn = false;
                        b(false, 0.0f);
                    }
                    cBf();
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    this.uNp.x = ((int) motionEvent.getX()) - this.uNA;
                    this.uNp.y = y - this.uNB;
                    cBj();
                    int min = Math.min(y, this.uNr + this.uNI);
                    y = Math.max(y, this.uNr - this.uNI);
                    d dVar = this.uNL;
                    int i = dVar.uIg ? dVar.uOA : -1;
                    if (min <= this.goe || min <= this.uNP || i == 1) {
                        if (y >= this.goe || y >= this.uNO || i == 0) {
                            if (y >= this.uNO && min <= this.uNP && this.uNL.uIg) {
                                this.uNL.cBl();
                                break;
                            }
                        }
                        if (i != -1) {
                            this.uNL.cBl();
                        }
                        this.uNL.GJ(0);
                        break;
                    }
                    if (i != -1) {
                        this.uNL.cBl();
                    }
                    this.uNL.GJ(1);
                    break;
                    break;
                case 3:
                    if (this.Cu == 4) {
                        cBb();
                    }
                    cBf();
                    break;
            }
            z = true;
            return z;
        }
    }

    private void cBf() {
        this.uOc = 0;
        this.uNZ = false;
        if (this.Cu == 3) {
            this.Cu = 0;
        }
        this.uNu = this.uNt;
        this.uOp = false;
        j jVar = this.uOk;
        jVar.uOJ.clear();
        jVar.uOK.clear();
    }

    private void Q(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA;
        if (action != 0) {
            this.god = this.fmL;
            this.goe = this.fmM;
        }
        this.fmL = (int) motionEvent.getX();
        this.fmM = (int) motionEvent.getY();
        if (action == 0) {
            this.god = this.fmL;
            this.goe = this.fmM;
        }
        this.mOffsetX = ((int) motionEvent.getRawX()) - this.fmL;
        this.mOffsetY = ((int) motionEvent.getRawY()) - this.fmM;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.uNF) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        boolean z;
        Q(motionEvent);
        this.uNY = true;
        int action = motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA;
        if (action == 0) {
            if (this.Cu != 0) {
                this.uOj = true;
                return true;
            }
            this.uNZ = true;
        }
        if (this.uNo == null) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                this.uOp = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    cBf();
                    break;
                default:
                    if (!z) {
                        this.uOc = 2;
                        break;
                    }
                    this.uOc = 1;
                    break;
            }
        }
        z = true;
        if (action == 1 || action == 3) {
            this.uNZ = false;
        }
        return z;
    }

    public void setDragScrollStart(float f) {
        if (f > 0.5f) {
            this.uNN = 0.5f;
        } else {
            this.uNN = f;
        }
        if (f > 0.5f) {
            this.uNM = 0.5f;
        } else {
            this.uNM = f;
        }
        if (getHeight() != 0) {
            cBg();
        }
    }

    private void cBg() {
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        float f = (float) height;
        this.uNR = ((float) paddingTop) + (this.uNM * f);
        this.uNQ = (f * (1.0f - this.uNN)) + ((float) paddingTop);
        this.uNO = (int) this.uNR;
        this.uNP = (int) this.uNQ;
        this.uNS = this.uNR - ((float) paddingTop);
        this.uNT = ((float) (paddingTop + height)) - this.uNQ;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cBg();
    }

    private void cBh() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        lastVisiblePosition = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); max <= lastVisiblePosition; max++) {
            View childAt = getChildAt(max);
            if (childAt != null) {
                a(firstVisiblePosition + max, childAt, false);
            }
        }
    }

    private void a(int i, View view, boolean z) {
        int fo;
        LayoutParams layoutParams = view.getLayoutParams();
        if (i == this.uNz || i == this.uNw || i == this.uNx) {
            fo = fo(i, b(i, view, z));
        } else {
            fo = -2;
        }
        if (fo != layoutParams.height) {
            layoutParams.height = fo;
            view.setLayoutParams(layoutParams);
        }
        if (i == this.uNw || i == this.uNx) {
            if (i < this.uNz) {
                ((b) view).setGravity(80);
            } else if (i > this.uNz) {
                ((b) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        fo = 0;
        if (i == this.uNz && this.uNo != null) {
            fo = 4;
        }
        if (fo != visibility) {
            view.setVisibility(fo);
        }
    }

    private int GI(int i) {
        if (i == this.uNz) {
            return 0;
        }
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt != null) {
            return b(i, childAt, false);
        }
        int i2 = this.uOk.uOJ.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        ListAdapter adapter = getAdapter();
        int itemViewType = adapter.getItemViewType(i);
        int viewTypeCount = adapter.getViewTypeCount();
        if (viewTypeCount != this.uNK.length) {
            this.uNK = new View[viewTypeCount];
        }
        if (itemViewType < 0) {
            childAt = adapter.getView(i, null, this);
        } else if (this.uNK[itemViewType] == null) {
            childAt = adapter.getView(i, null, this);
            this.uNK[itemViewType] = childAt;
        } else {
            childAt = adapter.getView(i, this.uNK[itemViewType], this);
        }
        itemViewType = b(i, childAt, true);
        j jVar = this.uOk;
        i2 = jVar.uOJ.get(i, -1);
        if (i2 != itemViewType) {
            if (i2 != -1) {
                jVar.uOK.remove(Integer.valueOf(i));
            } else if (jVar.uOJ.size() == jVar.sKa) {
                jVar.uOJ.delete(((Integer) jVar.uOK.remove(0)).intValue());
            }
            jVar.uOJ.put(i, itemViewType);
            jVar.uOK.add(Integer.valueOf(i));
        }
        return itemViewType;
    }

    private int b(int i, View view, boolean z) {
        if (i == this.uNz) {
            return 0;
        }
        if (i >= getHeaderViewsCount() && i < getCount() - getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.height > 0) {
            return layoutParams.height;
        }
        int height = view.getHeight();
        if (height != 0 && !z) {
            return height;
        }
        dU(view);
        return view.getMeasuredHeight();
    }

    private int fo(int i, int i2) {
        Object obj = (!this.uNy || this.uNw == this.uNx) ? null : 1;
        int i3 = this.uNH - this.uNG;
        int i4 = (int) (this.uOe * ((float) i3));
        if (i == this.uNz) {
            if (this.uNz == this.uNw) {
                if (obj != null) {
                    return i4 + this.uNG;
                }
                return this.uNH;
            } else if (this.uNz == this.uNx) {
                return this.uNH - i4;
            } else {
                return this.uNG;
            }
        } else if (i == this.uNw) {
            if (obj != null) {
                return i2 + i4;
            }
            return i2 + i3;
        } else if (i == this.uNx) {
            return (i2 + i3) - i4;
        } else {
            return i2;
        }
    }

    public void requestLayout() {
        if (!this.uOi) {
            super.requestLayout();
        }
    }

    private void dU(View view) {
        int makeMeasureSpec;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.uNJ, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        if (layoutParams.height > 0) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void cBi() {
        if (this.uNo != null) {
            dU(this.uNo);
            this.uNH = this.uNo.getMeasuredHeight();
            this.uNI = this.uNH / 2;
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.uNo != null) {
            if (this.uNo.isLayoutRequested()) {
                cBi();
            }
            this.uNs = true;
        }
        this.uNJ = i;
    }

    protected void layoutChildren() {
        super.layoutChildren();
        if (this.uNo != null) {
            if (this.uNo.isLayoutRequested() && !this.uNs) {
                cBi();
            }
            this.uNo.layout(0, 0, this.uNo.getMeasuredWidth(), this.uNo.getMeasuredHeight());
            this.uNs = false;
        }
    }

    public final boolean a(int i, View view, int i2, int i3, int i4) {
        if (this.Cu != 0 || !this.uNZ || this.uNo != null || view == null || !this.uNF) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int headerViewsCount = getHeaderViewsCount() + i;
        this.uNw = headerViewsCount;
        this.uNx = headerViewsCount;
        this.uNz = headerViewsCount;
        this.uNv = headerViewsCount;
        this.Cu = 4;
        this.uNX = 0;
        this.uNX |= i2;
        this.uNo = view;
        cBi();
        this.uNA = i3;
        this.uNB = i4;
        this.uNW = this.fmM;
        this.uNp.x = this.fmL - this.uNA;
        this.uNp.y = this.fmM - this.uNB;
        View childAt = getChildAt(this.uNz - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setVisibility(4);
        }
        if (this.uOg) {
            f fVar = this.uOh;
            fVar.mBuilder.append("<DSLVStates>\n");
            fVar.uOD = 0;
            fVar.uOE = true;
        }
        switch (this.uOc) {
            case 1:
                super.onTouchEvent(this.uOb);
                break;
            case 2:
                super.onInterceptTouchEvent(this.uOb);
                break;
        }
        requestLayout();
        return true;
    }

    private void cBj() {
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt != null) {
            c(firstVisiblePosition, childAt, true);
        }
    }

    private void c(int i, View view, boolean z) {
        int count;
        Object obj;
        Object obj2;
        this.uOi = true;
        if (this.uOa != null) {
            this.uNq.set(this.fmL, this.fmM);
            this.uOa.i(this.uNp);
        }
        int i2 = this.uNp.x;
        int i3 = this.uNp.y;
        int paddingLeft = getPaddingLeft();
        if ((this.uNX & 1) == 0 && i2 > paddingLeft) {
            this.uNp.x = paddingLeft;
        } else if ((this.uNX & 2) == 0 && i2 < paddingLeft) {
            this.uNp.x = paddingLeft;
        }
        paddingLeft = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        i2 = getPaddingTop();
        if (firstVisiblePosition < paddingLeft) {
            i2 = getChildAt((paddingLeft - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.uNX & 8) == 0 && firstVisiblePosition <= this.uNz) {
            i2 = Math.max(getChildAt(this.uNz - firstVisiblePosition).getTop(), i2);
        }
        paddingLeft = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            paddingLeft = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.uNX & 4) == 0 && lastVisiblePosition >= this.uNz) {
            paddingLeft = Math.min(getChildAt(this.uNz - firstVisiblePosition).getBottom(), paddingLeft);
        }
        if (i3 < i2) {
            this.uNp.y = i2;
        } else if (this.uNH + i3 > paddingLeft) {
            this.uNp.y = paddingLeft - this.uNH;
        }
        this.uNr = this.uNp.y + this.uNI;
        int i4 = this.uNw;
        int i5 = this.uNx;
        i3 = getFirstVisiblePosition();
        paddingLeft = this.uNw;
        View childAt = getChildAt(paddingLeft - i3);
        if (childAt == null) {
            paddingLeft = i3 + (getChildCount() / 2);
            childAt = getChildAt(paddingLeft - i3);
        }
        int top = childAt.getTop();
        lastVisiblePosition = childAt.getHeight();
        footerViewsCount = fn(paddingLeft, top);
        int dividerHeight = getDividerHeight();
        if (this.uNr < footerViewsCount) {
            i2 = paddingLeft;
            i3 = footerViewsCount;
            firstVisiblePosition = footerViewsCount;
            while (i2 >= 0) {
                i2--;
                paddingLeft = GG(i2);
                if (i2 != 0) {
                    top -= paddingLeft + dividerHeight;
                    footerViewsCount = fn(i2, top);
                    if (this.uNr >= footerViewsCount) {
                        paddingLeft = i3;
                        break;
                    } else {
                        i3 = footerViewsCount;
                        firstVisiblePosition = footerViewsCount;
                    }
                } else {
                    footerViewsCount = (top - dividerHeight) - paddingLeft;
                    paddingLeft = i3;
                    break;
                }
            }
            paddingLeft = i3;
            footerViewsCount = firstVisiblePosition;
        } else {
            count = getCount();
            i2 = paddingLeft;
            i3 = footerViewsCount;
            firstVisiblePosition = footerViewsCount;
            while (i2 < count) {
                if (i2 != count - 1) {
                    top += dividerHeight + lastVisiblePosition;
                    paddingLeft = GG(i2 + 1);
                    footerViewsCount = fn(i2 + 1, top);
                    if (this.uNr < footerViewsCount) {
                        paddingLeft = i3;
                        break;
                    }
                    i2++;
                    i3 = footerViewsCount;
                    firstVisiblePosition = footerViewsCount;
                    lastVisiblePosition = paddingLeft;
                } else {
                    footerViewsCount = (top + dividerHeight) + lastVisiblePosition;
                    paddingLeft = i3;
                    break;
                }
            }
            paddingLeft = i3;
            footerViewsCount = firstVisiblePosition;
        }
        lastVisiblePosition = getHeaderViewsCount();
        dividerHeight = getFooterViewsCount();
        count = this.uNw;
        int i6 = this.uNx;
        float f = this.uOe;
        if (this.uNy) {
            int abs = Math.abs(footerViewsCount - paddingLeft);
            if (this.uNr < footerViewsCount) {
                i3 = footerViewsCount;
                firstVisiblePosition = paddingLeft;
            } else {
                i3 = paddingLeft;
                firstVisiblePosition = footerViewsCount;
            }
            paddingLeft = (int) ((0.5f * this.uOd) * ((float) abs));
            float f2 = (float) paddingLeft;
            firstVisiblePosition += paddingLeft;
            paddingLeft = i3 - paddingLeft;
            if (this.uNr < firstVisiblePosition) {
                this.uNw = i2 - 1;
                this.uNx = i2;
                this.uOe = (0.5f * ((float) (firstVisiblePosition - this.uNr))) / f2;
            } else if (this.uNr >= paddingLeft) {
                this.uNw = i2;
                this.uNx = i2 + 1;
                this.uOe = 0.5f * ((((float) (i3 - this.uNr)) / f2) + 1.0f);
            }
            if (this.uNw < lastVisiblePosition) {
                this.uNw = lastVisiblePosition;
                this.uNx = lastVisiblePosition;
                i2 = lastVisiblePosition;
            } else if (this.uNx >= getCount() - dividerHeight) {
                i2 = (getCount() - dividerHeight) - 1;
                this.uNw = i2;
                this.uNx = i2;
            }
            if (this.uNw == count || this.uNx != i6 || Math.abs(this.uOe - f) > 0.0f) {
                obj = 1;
            } else {
                obj = null;
            }
            if (i2 == this.uNv) {
                this.uNv = i2;
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            if (obj2 != null) {
                cBh();
                i3 = GI(i);
                paddingLeft = view.getHeight();
                footerViewsCount = fo(i, i3);
                if (i != this.uNz) {
                    i2 = paddingLeft - i3;
                    i3 = footerViewsCount - i3;
                } else {
                    i2 = paddingLeft;
                    i3 = footerViewsCount;
                }
                lastVisiblePosition = this.uNH;
                if (!(this.uNz == this.uNw || this.uNz == this.uNx)) {
                    lastVisiblePosition -= this.uNG;
                }
                if (i <= i4) {
                    if (i > this.uNw) {
                        i2 = (lastVisiblePosition - i3) + 0;
                    }
                    i2 = 0;
                } else if (i == i5) {
                    i2 = i <= this.uNw ? (i2 - lastVisiblePosition) + 0 : i == this.uNx ? (paddingLeft - footerViewsCount) + 0 : i2 + 0;
                } else if (i <= this.uNw) {
                    i2 = 0 - lastVisiblePosition;
                } else {
                    if (i == this.uNx) {
                        i2 = 0 - i3;
                    }
                    i2 = 0;
                }
                setSelectionFromTop(i, (i2 + view.getTop()) - getPaddingTop());
                layoutChildren();
            }
            if (obj2 != null || z) {
                invalidate();
            }
            this.uOi = false;
        }
        this.uNw = i2;
        this.uNx = i2;
        if (this.uNw < lastVisiblePosition) {
            this.uNw = lastVisiblePosition;
            this.uNx = lastVisiblePosition;
            i2 = lastVisiblePosition;
        } else if (this.uNx >= getCount() - dividerHeight) {
            i2 = (getCount() - dividerHeight) - 1;
            this.uNw = i2;
            this.uNx = i2;
        }
        if (this.uNw == count) {
        }
        obj = 1;
        if (i2 == this.uNv) {
            obj2 = obj;
        } else {
            this.uNv = i2;
            obj2 = 1;
        }
        if (obj2 != null) {
            cBh();
            i3 = GI(i);
            paddingLeft = view.getHeight();
            footerViewsCount = fo(i, i3);
            if (i != this.uNz) {
                i2 = paddingLeft - i3;
                i3 = footerViewsCount - i3;
            } else {
                i2 = paddingLeft;
                i3 = footerViewsCount;
            }
            lastVisiblePosition = this.uNH;
            if (!(this.uNz == this.uNw || this.uNz == this.uNx)) {
                lastVisiblePosition -= this.uNG;
            }
            if (i <= i4) {
                if (i > this.uNw) {
                    i2 = (lastVisiblePosition - i3) + 0;
                }
                i2 = 0;
            } else if (i == i5) {
                i2 = i <= this.uNw ? (i2 - lastVisiblePosition) + 0 : i == this.uNx ? (paddingLeft - footerViewsCount) + 0 : i2 + 0;
            } else if (i <= this.uNw) {
                i2 = 0 - lastVisiblePosition;
            } else {
                if (i == this.uNx) {
                    i2 = 0 - i3;
                }
                i2 = 0;
            }
            setSelectionFromTop(i, (i2 + view.getTop()) - getPaddingTop());
            layoutChildren();
        }
        invalidate();
        this.uOi = false;
    }

    private void cBk() {
        if (this.uNo != null) {
            this.uNo.setVisibility(8);
            if (this.uOa != null) {
                this.uOa.dV(this.uNo);
            }
            this.uNo = null;
            invalidate();
        }
    }

    public void setFloatViewManager(i iVar) {
        this.uOa = iVar;
    }

    public void setDragListener(b bVar) {
        this.uNC = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.uNF = z;
    }

    public void setDropListener(h hVar) {
        this.uND = hVar;
    }

    public void setRemoveListener(l lVar) {
        this.uNE = lVar;
    }

    public void setDragSortListener(e eVar) {
        setDropListener(eVar);
        setDragListener(eVar);
        setRemoveListener(eVar);
    }

    public void setDragScrollProfile(c cVar) {
        if (cVar != null) {
            this.uNV = cVar;
        }
    }
}
