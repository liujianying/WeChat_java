package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import com.tencent.mm.plugin.sns.i$d;
import com.tencent.mm.plugin.sns.i.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DynamicGridView extends WrappingGridView {
    private int cF = -1;
    boolean iDm = false;
    private List<Long> idList = new ArrayList();
    private int if = 0;
    private BitmapDrawable olM;
    private Rect olN;
    private Rect olO;
    private Rect olP;
    private int olQ = 0;
    private int olR = 0;
    private int olS = -1;
    private int olT = -1;
    private int olU = -1;
    private int olV = -1;
    private int olW;
    private long olX = -1;
    private boolean olY = false;
    private boolean olZ;
    private int oma = 0;
    private boolean omb = false;
    private List<ObjectAnimator> omc = new LinkedList();
    boolean omd;
    boolean ome;
    boolean omf = true;
    private boolean omg = true;
    private OnScrollListener omh;
    private f omi;
    private e omj;
    private g omk;
    private OnItemClickListener oml;
    private OnItemClickListener omm = new 1(this);
    private boolean omn;
    private Stack<a> omo;
    private a omp;
    private h omq;
    private View omr;
    d oms = new d(this, (byte) 0);
    int omt = -1;
    float omu;
    float omv;
    private float omw;
    private float omx;
    private OnScrollListener omy = new 2(this);

    private static class a {
        List<Pair<Integer, Integer>> omF = new Stack();

        a() {
        }

        public final void dI(int i, int i2) {
            this.omF.add(new Pair(Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    private class c implements j {
        int yA;
        int yz;

        private class a implements OnPreDrawListener {
            static final /* synthetic */ boolean $assertionsDisabled = (!DynamicGridView.class.desiredAssertionStatus());
            private final int Sv;
            private final int omH;

            a(int i, int i2) {
                this.omH = i;
                this.Sv = i2;
            }

            public final boolean onPreDraw() {
                DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                DynamicGridView.this.olQ = DynamicGridView.this.olQ + c.this.yA;
                DynamicGridView.this.olR = DynamicGridView.this.olR + c.this.yz;
                DynamicGridView.a(DynamicGridView.this, this.omH, this.Sv);
                new StringBuilder("id ").append(DynamicGridView.this.fq(DynamicGridView.this.olX));
                if (!(DynamicGridView.this.omr == null || DynamicGridView.this.omr == null)) {
                    if ($assertionsDisabled || DynamicGridView.this.omr != null) {
                        DynamicGridView.this.omr.setVisibility(0);
                        DynamicGridView.this.omr = DynamicGridView.this.fr(DynamicGridView.this.olX);
                        if (DynamicGridView.this.omr != null) {
                            if ($assertionsDisabled || DynamicGridView.this.omr != null) {
                                DynamicGridView.this.omr.setVisibility(4);
                            } else {
                                throw new AssertionError();
                            }
                        }
                    }
                    throw new AssertionError();
                }
                return true;
            }
        }

        public c(int i, int i2) {
            this.yz = i;
            this.yA = i2;
        }

        public final void dJ(int i, int i2) {
            DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(i, i2));
        }
    }

    public interface h {
    }

    static /* synthetic */ void a(DynamicGridView dynamicGridView, int i, int i2) {
        Object obj = i2 > i ? 1 : null;
        Collection linkedList = new LinkedList();
        int min;
        View fr;
        if (obj != null) {
            for (min = Math.min(i, i2); min < Math.max(i, i2); min++) {
                fr = dynamicGridView.fr(dynamicGridView.xM(min));
                if ((min + 1) % dynamicGridView.getColumnCount() == 0) {
                    linkedList.add(d(fr, (float) ((-fr.getWidth()) * (dynamicGridView.getColumnCount() - 1)), (float) fr.getHeight()));
                } else {
                    linkedList.add(d(fr, (float) fr.getWidth(), 0.0f));
                }
            }
        } else {
            for (min = Math.max(i, i2); min > Math.min(i, i2); min--) {
                fr = dynamicGridView.fr(dynamicGridView.xM(min));
                if ((dynamicGridView.getColumnCount() + min) % dynamicGridView.getColumnCount() == 0) {
                    linkedList.add(d(fr, (float) (fr.getWidth() * (dynamicGridView.getColumnCount() - 1)), (float) (-fr.getHeight())));
                } else {
                    linkedList.add(d(fr, (float) (-fr.getWidth()), 0.0f));
                }
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(linkedList);
        animatorSet.setDuration(300);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new 10(dynamicGridView));
        animatorSet.start();
    }

    static /* synthetic */ void b(DynamicGridView dynamicGridView) {
        boolean z = (dynamicGridView.omd || dynamicGridView.ome) ? false : true;
        dynamicGridView.setEnabled(z);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.omh = onScrollListener;
    }

    public void setOnDropListener(f fVar) {
        this.omi = fVar;
    }

    public void setOnDragListener(e eVar) {
        this.omj = eVar;
    }

    public final void xK(int i) {
        if (this.omg) {
            requestDisallowInterceptTouchEvent(true);
            if (bES() && this.omf) {
                bEO();
            }
            if (i != -1) {
                this.iDm = xL(i);
                if (this.iDm) {
                    this.olY = true;
                }
            }
        }
    }

    public void setEditModeEnabled(boolean z) {
        this.omg = z;
    }

    public void setOnEditModeChangeListener(g gVar) {
        this.omk = gVar;
    }

    public void setWobbleInEditMode(boolean z) {
        this.omf = z;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.oml = onItemClickListener;
        super.setOnItemClickListener(this.omm);
    }

    public void setUndoSupportEnabled(boolean z) {
        if (this.omn != z) {
            if (z) {
                this.omo = new Stack();
            } else {
                this.omo = null;
            }
        }
        this.omn = z;
    }

    public void setOnSelectedItemBitmapCreationListener(h hVar) {
        this.omq = hVar;
    }

    @TargetApi(11)
    private void bEO() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!(childAt == null || Boolean.TRUE == childAt.getTag(f.dgv_wobble_tag))) {
                if (i % 2 == 0) {
                    cR(childAt);
                } else {
                    cS(childAt);
                }
                childAt.setTag(f.dgv_wobble_tag, Boolean.valueOf(true));
            }
        }
    }

    @TargetApi(11)
    final void iu(boolean z) {
        for (Animator cancel : this.omc) {
            cancel.cancel();
        }
        this.omc.clear();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                if (z) {
                    childAt.setRotation(0.0f);
                }
                childAt.setTag(f.dgv_wobble_tag, Boolean.valueOf(false));
            }
        }
    }

    private void init(Context context) {
        super.setOnScrollListener(this.omy);
        this.oma = (int) ((context.getResources().getDisplayMetrics().density * 8.0f) + 0.5f);
        this.olW = getResources().getDimensionPixelSize(i$d.dgv_overlap_if_switch_straight_line);
    }

    @TargetApi(11)
    private void cR(View view) {
        ObjectAnimator cT = cT(view);
        cT.setFloatValues(new float[]{-2.0f, 2.0f});
        cT.start();
        this.omc.add(cT);
    }

    @TargetApi(11)
    private void cS(View view) {
        ObjectAnimator cT = cT(view);
        cT.setFloatValues(new float[]{2.0f, -2.0f});
        cT.start();
        this.omc.add(cT);
    }

    @TargetApi(11)
    private ObjectAnimator cT(View view) {
        if (!bET()) {
            view.setLayerType(1, null);
        }
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setDuration(180);
        objectAnimator.setRepeatMode(2);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setPropertyName("rotation");
        objectAnimator.setTarget(view);
        objectAnimator.addListener(new 3(this, view));
        return objectAnimator;
    }

    private void dH(int i, int i2) {
        getAdapterInterface().dG(i, i2);
    }

    private int getColumnCount() {
        return getAdapterInterface().getColumnCount();
    }

    private d getAdapterInterface() {
        return (d) getAdapter();
    }

    private void fp(long j) {
        this.idList.clear();
        int fq = fq(j);
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (fq != firstVisiblePosition && getAdapterInterface().xG(firstVisiblePosition)) {
                this.idList.add(Long.valueOf(xM(firstVisiblePosition)));
            }
            firstVisiblePosition++;
        }
    }

    public final int fq(long j) {
        View fr = fr(j);
        if (fr == null) {
            return -1;
        }
        return getPositionForView(fr);
    }

    public final View fr(long j) {
        int firstVisiblePosition = getFirstVisiblePosition();
        ListAdapter adapter = getAdapter();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (adapter.getItemId(firstVisiblePosition + i) == j) {
                return childAt;
            }
        }
        return null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        new StringBuilder("onInterceptTouchEvent ").append(motionEvent.getAction()).append(" ").append(onInterceptTouchEvent);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex = motionEvent.findPointerIndex(this.cF);
        new StringBuilder("onTouchEvent ").append(motionEvent.getAction());
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.omu = motionEvent.getX();
                this.omv = motionEvent.getY();
                this.omt = f.a(this, motionEvent.getX(), motionEvent.getY());
                new StringBuilder("onTouchEvent ").append(motionEvent.getAction()).append(",downPos ").append(this.omt);
                if (!this.omd && this.omt >= 0) {
                    d dVar = this.oms;
                    dVar.removeMessages(1);
                    dVar.sendEmptyMessageDelayed(1, 300);
                }
                this.olU = -1;
                this.olV = -1;
                this.olS = (int) motionEvent.getX();
                this.olT = (int) motionEvent.getY();
                this.cF = motionEvent.getPointerId(0);
                if (this.iDm && isEnabled()) {
                    layoutChildren();
                    xL(pointToPosition(this.olS, this.olT));
                    break;
                } else if (!isEnabled()) {
                    return false;
                }
                break;
            case 1:
                bER();
                if (this.omn && this.omp != null) {
                    a aVar = this.omp;
                    Collections.reverse(aVar.omF);
                    if (!aVar.omF.isEmpty()) {
                        this.omo.push(this.omp);
                        this.omp = new a();
                        break;
                    }
                }
                break;
            case 2:
                this.omu = motionEvent.getX();
                this.omv = motionEvent.getY();
                if (this.olY && this.cF != -1) {
                    if (this.olV == -1 && this.olU == -1) {
                        this.olU = (int) motionEvent.getY(findPointerIndex);
                        this.olV = (int) motionEvent.getX(findPointerIndex);
                        this.olS = this.olV;
                        this.olT = this.olU;
                        break;
                    }
                    this.omw = motionEvent.getRawX();
                    this.omx = motionEvent.getRawY();
                    this.olU = (int) motionEvent.getY(findPointerIndex);
                    this.olV = (int) motionEvent.getX(findPointerIndex);
                    int i = this.olV - this.olS;
                    this.olN.offsetTo((i + this.olP.left) + this.olR, ((this.olU - this.olT) + this.olP.top) + this.olQ);
                    if (this.olM != null) {
                        this.olM.setBounds(this.olN);
                    }
                    invalidate();
                    bEV();
                    this.olZ = false;
                    bEQ();
                    if (this.omj == null) {
                        return false;
                    }
                    Rect rect = new Rect(this.olN);
                    rect.offset(0, this.olN.height() >>> 1);
                    this.omj.k(rect);
                    return false;
                }
                break;
            case 3:
                bEU();
                bER();
                break;
            case 6:
                if (motionEvent.getPointerId((motionEvent.getAction() & 65280) >> 8) == this.cF) {
                    bER();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean bEP() {
        int fq = fq(this.olX);
        if (fq == -1) {
            return false;
        }
        this.omj.xJ(fq);
        if (this.omr == null) {
            return false;
        }
        j bVar;
        int positionForView = getPositionForView(this.omr);
        int childCount = getChildCount() - 1;
        new StringBuilder("switch ").append(positionForView).append(",").append(childCount);
        dH(positionForView, childCount);
        if (this.omn) {
            this.omp.dI(positionForView, childCount);
        }
        this.olT = this.olU;
        this.olS = this.olV;
        if (bES() && bET()) {
            bVar = new b(this, 0, 0);
        } else if (bET()) {
            bVar = new i(this, 0, 0);
        } else {
            bVar = new c(0, 0);
        }
        fp(this.olX);
        bVar.dJ(positionForView, childCount);
        return true;
    }

    private boolean xL(int i) {
        if (!getAdapterInterface().xF(i)) {
            return false;
        }
        this.olQ = 0;
        this.olR = 0;
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt == null) {
            return false;
        }
        this.olX = getAdapter().getItemId(i);
        int width = childAt.getWidth();
        int height = childAt.getHeight();
        int top = childAt.getTop();
        int left = childAt.getLeft();
        Bitmap createBitmap = Bitmap.createBitmap(childAt.getWidth(), childAt.getHeight(), Config.ARGB_8888);
        childAt.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), createBitmap);
        this.olO = new Rect(left, top, left + width, top + height);
        this.olN = new Rect(this.olO.left - ((int) (((float) width) * 0.05f)), this.olO.top - ((int) (((float) height) * 0.05f)), ((int) (((float) width) * 0.05f)) + this.olO.right, ((int) (((float) height) * 0.05f)) + this.olO.bottom);
        this.olP = new Rect(this.olN);
        bitmapDrawable.setBounds(this.olO);
        this.olM = bitmapDrawable;
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.olM, "bounds", new 4(this), new Object[]{this.olN});
        ofObject.addUpdateListener(new 5(this));
        ofObject.addListener(new 6(this));
        ofObject.setDuration(10);
        ofObject.start();
        if (bES()) {
            childAt.setVisibility(4);
        }
        fp(this.olX);
        if (this.omj != null) {
            this.omj.xI(i);
        }
        return true;
    }

    private void bEQ() {
        boolean z = true;
        Rect rect = this.olN;
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int height = getHeight();
        int computeVerticalScrollExtent = computeVerticalScrollExtent();
        int computeVerticalScrollRange = computeVerticalScrollRange();
        int i = rect.top;
        int height2 = rect.height();
        if (i <= 0 && computeVerticalScrollOffset > 0) {
            smoothScrollBy(-this.oma, 0);
        } else if (height2 + i < height || computeVerticalScrollOffset + computeVerticalScrollExtent >= computeVerticalScrollRange) {
            z = false;
        } else {
            smoothScrollBy(this.oma, 0);
        }
        this.olZ = z;
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
    }

    private void bER() {
        this.oms.removeMessages(1);
        final View fr = fr(this.olX);
        Rect rect;
        if (this.olN != null) {
            rect = new Rect(this.olN);
            rect.offset(0, this.olN.height() >>> 1);
        } else {
            rect = null;
        }
        if (this.omj != null && this.omj.l(rect) && bEP()) {
            this.olM = null;
            bEU();
            if (this.omi != null) {
                this.omi.bEN();
            }
        } else if (fr == null || !(this.olY || this.omb)) {
            bEU();
        } else {
            this.olY = false;
            this.omb = false;
            this.olZ = false;
            this.cF = -1;
            this.olN.set(fr.getLeft(), fr.getTop(), fr.getRight(), fr.getBottom());
            new StringBuilder("animating to  ").append(this.olN);
            if (VERSION.SDK_INT > 11) {
                ObjectAnimator ofObject = ObjectAnimator.ofObject(this.olM, "bounds", new 7(this), new Object[]{this.olN});
                ofObject.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        DynamicGridView.this.invalidate();
                    }
                });
                ofObject.addListener(new AnimatorListenerAdapter() {
                    public final void onAnimationStart(Animator animator) {
                        DynamicGridView.this.omd = true;
                        DynamicGridView.b(DynamicGridView.this);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        DynamicGridView.this.omd = false;
                        DynamicGridView.b(DynamicGridView.this);
                        if (!(DynamicGridView.this.olM == null || DynamicGridView.this.omi == null)) {
                            DynamicGridView.this.omi.bEN();
                        }
                        DynamicGridView.this.cU(fr);
                    }
                });
                ofObject.setDuration(200);
                ofObject.start();
            } else {
                this.olM.setBounds(this.olN);
                invalidate();
                cU(fr);
            }
        }
        if (this.omj != null) {
            this.omj.bEM();
        }
    }

    private void cU(View view) {
        this.idList.clear();
        this.olX = -1;
        view.setVisibility(0);
        this.olM = null;
        if (bES() && this.omf) {
            if (this.iDm) {
                iu(false);
                bEO();
            } else {
                iu(true);
            }
        }
        for (int i = 0; i < getLastVisiblePosition() - getFirstVisiblePosition(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.setVisibility(0);
            }
        }
        invalidate();
    }

    static boolean bES() {
        return VERSION.SDK_INT >= 11;
    }

    private static boolean bET() {
        return VERSION.SDK_INT < 21;
    }

    private void bEU() {
        View fr = fr(this.olX);
        if (fr != null) {
            if (this.olY) {
                cU(fr);
            }
            this.olY = false;
            this.olZ = false;
            this.cF = -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bEV() {
        /*
        r14 = this;
        r0 = r14.olU;
        r1 = r14.olT;
        r6 = r0 - r1;
        r0 = r14.olV;
        r1 = r14.olS;
        r7 = r0 - r1;
        r0 = r14.olO;
        r0 = r0.centerY();
        r1 = r14.olQ;
        r0 = r0 + r1;
        r8 = r0 + r6;
        r0 = r14.olO;
        r0 = r0.centerX();
        r1 = r14.olR;
        r0 = r0 + r1;
        r9 = r0 + r7;
        r0 = r14.olX;
        r0 = r14.fr(r0);
        r14.omr = r0;
        r0 = r14.omr;
        if (r0 != 0) goto L_0x002f;
    L_0x002e:
        return;
    L_0x002f:
        r4 = 0;
        r2 = 0;
        r1 = 0;
        r0 = r14.omr;
        r10 = r14.cV(r0);
        r0 = r14.idList;
        r11 = r0.iterator();
    L_0x003e:
        r0 = r11.hasNext();
        if (r0 == 0) goto L_0x0164;
    L_0x0044:
        r0 = r11.next();
        r0 = (java.lang.Long) r0;
        r12 = r0.longValue();
        r5 = r14.fr(r12);
        if (r5 == 0) goto L_0x01e1;
    L_0x0054:
        r3 = r14.cV(r5);
        r0 = r3.y;
        r12 = r10.y;
        if (r0 >= r12) goto L_0x014f;
    L_0x005e:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 <= r12) goto L_0x014f;
    L_0x0064:
        r0 = 1;
    L_0x0065:
        if (r0 == 0) goto L_0x0073;
    L_0x0067:
        r0 = r5.getBottom();
        if (r8 >= r0) goto L_0x0073;
    L_0x006d:
        r0 = r5.getLeft();
        if (r9 > r0) goto L_0x0124;
    L_0x0073:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 >= r12) goto L_0x0152;
    L_0x0079:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 >= r12) goto L_0x0152;
    L_0x007f:
        r0 = 1;
    L_0x0080:
        if (r0 == 0) goto L_0x008e;
    L_0x0082:
        r0 = r5.getBottom();
        if (r8 >= r0) goto L_0x008e;
    L_0x0088:
        r0 = r5.getRight();
        if (r9 < r0) goto L_0x0124;
    L_0x008e:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 <= r12) goto L_0x0155;
    L_0x0094:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 <= r12) goto L_0x0155;
    L_0x009a:
        r0 = 1;
    L_0x009b:
        if (r0 == 0) goto L_0x00a9;
    L_0x009d:
        r0 = r5.getTop();
        if (r8 <= r0) goto L_0x00a9;
    L_0x00a3:
        r0 = r5.getLeft();
        if (r9 > r0) goto L_0x0124;
    L_0x00a9:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 <= r12) goto L_0x0158;
    L_0x00af:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 >= r12) goto L_0x0158;
    L_0x00b5:
        r0 = 1;
    L_0x00b6:
        if (r0 == 0) goto L_0x00c4;
    L_0x00b8:
        r0 = r5.getTop();
        if (r8 <= r0) goto L_0x00c4;
    L_0x00be:
        r0 = r5.getRight();
        if (r9 < r0) goto L_0x0124;
    L_0x00c4:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 >= r12) goto L_0x015b;
    L_0x00ca:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 != r12) goto L_0x015b;
    L_0x00d0:
        r0 = 1;
    L_0x00d1:
        if (r0 == 0) goto L_0x00dc;
    L_0x00d3:
        r0 = r5.getBottom();
        r12 = r14.olW;
        r0 = r0 - r12;
        if (r8 < r0) goto L_0x0124;
    L_0x00dc:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 <= r12) goto L_0x015e;
    L_0x00e2:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 != r12) goto L_0x015e;
    L_0x00e8:
        r0 = 1;
    L_0x00e9:
        if (r0 == 0) goto L_0x00f4;
    L_0x00eb:
        r0 = r5.getTop();
        r12 = r14.olW;
        r0 = r0 + r12;
        if (r8 > r0) goto L_0x0124;
    L_0x00f4:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 != r12) goto L_0x0160;
    L_0x00fa:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 <= r12) goto L_0x0160;
    L_0x0100:
        r0 = 1;
    L_0x0101:
        if (r0 == 0) goto L_0x010c;
    L_0x0103:
        r0 = r5.getLeft();
        r12 = r14.olW;
        r0 = r0 + r12;
        if (r9 > r0) goto L_0x0124;
    L_0x010c:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 != r12) goto L_0x0162;
    L_0x0112:
        r0 = r3.x;
        r3 = r10.x;
        if (r0 >= r3) goto L_0x0162;
    L_0x0118:
        r0 = 1;
    L_0x0119:
        if (r0 == 0) goto L_0x01e1;
    L_0x011b:
        r0 = r5.getRight();
        r3 = r14.olW;
        r0 = r0 - r3;
        if (r9 >= r0) goto L_0x01e1;
    L_0x0124:
        r0 = com.tencent.mm.plugin.sns.ui.previewimageview.f.cP(r5);
        r3 = r14.omr;
        r3 = com.tencent.mm.plugin.sns.ui.previewimageview.f.cP(r3);
        r0 = r0 - r3;
        r3 = java.lang.Math.abs(r0);
        r0 = com.tencent.mm.plugin.sns.ui.previewimageview.f.cQ(r5);
        r12 = r14.omr;
        r12 = com.tencent.mm.plugin.sns.ui.previewimageview.f.cQ(r12);
        r0 = r0 - r12;
        r0 = java.lang.Math.abs(r0);
        r12 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1));
        if (r12 < 0) goto L_0x01e1;
    L_0x0146:
        r12 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r12 < 0) goto L_0x01e1;
    L_0x014a:
        r2 = r3;
        r4 = r5;
    L_0x014c:
        r1 = r0;
        goto L_0x003e;
    L_0x014f:
        r0 = 0;
        goto L_0x0065;
    L_0x0152:
        r0 = 0;
        goto L_0x0080;
    L_0x0155:
        r0 = 0;
        goto L_0x009b;
    L_0x0158:
        r0 = 0;
        goto L_0x00b6;
    L_0x015b:
        r0 = 0;
        goto L_0x00d1;
    L_0x015e:
        r0 = 0;
        goto L_0x00e9;
    L_0x0160:
        r0 = 0;
        goto L_0x0101;
    L_0x0162:
        r0 = 0;
        goto L_0x0119;
    L_0x0164:
        if (r4 == 0) goto L_0x002e;
    L_0x0166:
        r0 = r14.omr;
        r1 = r14.getPositionForView(r0);
        r2 = r14.getPositionForView(r4);
        r0 = new java.lang.StringBuilder;
        r3 = "switch ";
        r0.<init>(r3);
        r0 = r0.append(r1);
        r3 = ",";
        r0 = r0.append(r3);
        r0.append(r2);
        r0 = r14.getAdapterInterface();
        r3 = -1;
        if (r2 == r3) goto L_0x0199;
    L_0x018d:
        r3 = r0.xG(r1);
        if (r3 == 0) goto L_0x0199;
    L_0x0193:
        r0 = r0.xG(r2);
        if (r0 != 0) goto L_0x01a0;
    L_0x0199:
        r0 = r14.olX;
        r14.fp(r0);
        goto L_0x002e;
    L_0x01a0:
        r14.dH(r1, r2);
        r0 = r14.omn;
        if (r0 == 0) goto L_0x01ac;
    L_0x01a7:
        r0 = r14.omp;
        r0.dI(r1, r2);
    L_0x01ac:
        r0 = r14.olU;
        r14.olT = r0;
        r0 = r14.olV;
        r14.olS = r0;
        r0 = bES();
        if (r0 == 0) goto L_0x01cf;
    L_0x01ba:
        r0 = bET();
        if (r0 == 0) goto L_0x01cf;
    L_0x01c0:
        r0 = new com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$b;
        r0.<init>(r14, r7, r6);
    L_0x01c5:
        r4 = r14.olX;
        r14.fp(r4);
        r0.dJ(r1, r2);
        goto L_0x002e;
    L_0x01cf:
        r0 = bET();
        if (r0 == 0) goto L_0x01db;
    L_0x01d5:
        r0 = new com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$i;
        r0.<init>(r14, r7, r6);
        goto L_0x01c5;
    L_0x01db:
        r0 = new com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$c;
        r0.<init>(r7, r6);
        goto L_0x01c5;
    L_0x01e1:
        r0 = r1;
        goto L_0x014c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.bEV():void");
    }

    private Point cV(View view) {
        int positionForView = getPositionForView(view);
        int columnCount = getColumnCount();
        return new Point(positionForView % columnCount, positionForView / columnCount);
    }

    private long xM(int i) {
        return getAdapter().getItemId(i);
    }

    @TargetApi(11)
    private static AnimatorSet d(View view, float f, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", new float[]{f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", new float[]{f2, 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        return animatorSet;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.olM != null) {
            this.olM.draw(canvas);
        }
    }
}
