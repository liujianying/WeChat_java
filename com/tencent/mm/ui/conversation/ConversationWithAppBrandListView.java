package com.tencent.mm.ui.conversation;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Vibrator;
import android.support.v4.view.ae;
import android.support.v4.view.o;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ListView.FixedViewInfo;
import com.tencent.mm.R;
import com.tencent.mm.g.a.if;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ag;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.appbrand.GyroView;
import com.tencent.mm.ui.y;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationWithAppBrandListView extends ListView implements OnScrollListener, b {
    private int Rs = -1;
    private int Rt;
    private int Ru;
    boolean bPd;
    private ValueAnimator bwg;
    private int fW;
    private View gQd;
    private Vibrator hXL;
    private boolean hasInit = false;
    private boolean huc = true;
    private float inM;
    private float inN;
    private boolean jwE = false;
    private OnScrollListener kLU;
    private float trr;
    private LinkedList<FixedViewInfo> uoV = new LinkedList();
    private View uoW;
    View uoX;
    AppBrandRecentView uoY;
    private boolean uoZ = false;
    private Paint upa;
    private Paint upb;
    private com.tencent.mm.plugin.appbrand.widget.recentview.b upc;
    private String upd;
    private float upe;
    private int upf = 0;
    boolean upg = false;
    final c<if> uph = new 15(this);
    private View upi;
    private a upj = new a(this);
    private int upk = 0;
    private float upl;
    private float upm;
    private float upn = 0.0f;
    private float upo = 0.0f;
    private boolean upp;
    private boolean upq = false;
    private boolean upr;
    private boolean ups = false;
    private boolean upt = false;
    private Runnable upu;
    private Runnable upv = new 14(this);
    private boolean upw = false;
    private boolean upx = false;
    private int upy;

    public ConversationWithAppBrandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setAdapter(ListAdapter listAdapter) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[init] ");
        this.uph.cht();
        this.hXL = (Vibrator) getContext().getSystemService("vibrator");
        this.fW = ae.a(ViewConfiguration.get(getContext()));
        this.upa = new Paint(1);
        this.upb = new Paint(1);
        this.upa.setColor(getResources().getColor(R.e.app_brand_recent_view_default_bg));
        this.upb.setColor(-16777216);
        this.upb.setAlpha(0);
        this.upb.setTextSize(getResources().getDimension(R.f.SmallestTextSize));
        mr(false);
        if (g.l(d.class) != null) {
            this.upc = ((d) g.l(d.class)).aoY();
        }
        this.trr = 100.0f * getResources().getDisplayMetrics().density;
        this.upd = getResources().getString(R.l.conversation_app_brand_recentview_tip);
        this.upe = this.upb.measureText(this.upd);
        super.setOnScrollListener(this);
        listAdapter.registerDataSetObserver(new 1(this, listAdapter));
        cyM();
        addFooterView(getEmptyFooter());
        super.setAdapter(listAdapter);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!z || !mr(true)) {
            return;
        }
        if (this.huc) {
            a(true);
            post(new 12(this));
            this.upf = i4;
            this.huc = false;
        } else if (!this.bPd && this.upf != i4) {
            x.i("MicroMsg.ConversationWithAppBrandListView", "[onLayout] mLastBottom:" + this.upf + " b:" + i4);
            a(true);
            this.upf = i4;
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.ConversationWithAppBrandListView", "[onConfigurationChanged] orientation:%s", new Object[]{Integer.valueOf(configuration.orientation)});
        this.upg = true;
        a(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getFirstVisiblePosition() != 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int d = o.d(motionEvent);
        int e = o.e(motionEvent);
        switch (d) {
            case 0:
                this.Rs = o.c(motionEvent, 0);
                this.Rt = (int) (motionEvent.getX() + 0.5f);
                this.Ru = (int) (motionEvent.getY() + 0.5f);
                return super.onInterceptTouchEvent(motionEvent);
            case 2:
                d = o.b(motionEvent, this.Rs);
                if (d < 0) {
                    return false;
                }
                boolean z;
                e = (int) (o.d(motionEvent, d) + 0.5f);
                e -= this.Rt;
                d = ((int) (o.e(motionEvent, d) + 0.5f)) - this.Ru;
                if (Math.abs(d) <= this.fW || Math.abs(d) < Math.abs(e)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z && super.onInterceptTouchEvent(motionEvent)) {
                    return true;
                }
                return false;
            case 5:
                this.Rs = o.c(motionEvent, e);
                this.Rt = (int) (o.d(motionEvent, e) + 0.5f);
                this.Ru = (int) (o.e(motionEvent, e) + 0.5f);
                return super.onInterceptTouchEvent(motionEvent);
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        FixedViewInfo fixedViewInfo = new FixedViewInfo(this);
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.uoV.add(fixedViewInfo);
        if (getAdapter() != null) {
            super.addHeaderView(fixedViewInfo.view, fixedViewInfo.data, fixedViewInfo.isSelectable);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(new 16(this, onItemClickListener));
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        super.setOnItemLongClickListener(new 17(this, onItemLongClickListener));
    }

    public final void coE() {
        if (getFirstVisiblePosition() > getFirstHeaderVisible() + 16) {
            setSelection(getFirstHeaderVisible() + 16);
        }
        post(new 18(this));
    }

    public final void B(long j, int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[hideAppBrandRecentView] delay:%s", new Object[]{Long.valueOf(j)});
        if (mr(true)) {
            if (getFirstVisiblePosition() == 0) {
                if (!(this.upc == null || this.uoY == null)) {
                    this.upc.cc(Math.max(0, this.uoY.getCount() - 1), i);
                }
                if (j > 0) {
                    postDelayed(new Runnable() {
                        public final void run() {
                            if (ConversationWithAppBrandListView.this.uoY != null) {
                                ConversationWithAppBrandListView.this.uoY.smoothScrollToPosition(0);
                            }
                            View childAt = ConversationWithAppBrandListView.this.getChildAt(0);
                            int bottom = childAt == null ? 0 : childAt.getBottom();
                            if (bottom != 0) {
                                ConversationWithAppBrandListView.this.smoothScrollBy(bottom, 0);
                            }
                            ConversationWithAppBrandListView.this.setSelection(0);
                        }
                    }, j);
                } else {
                    if (this.uoY != null) {
                        this.uoY.smoothScrollToPosition(0);
                    }
                    setSelection(0);
                }
                cyN();
            }
        } else if (this.uoX != null) {
            this.uoX.setVisibility(8);
        }
    }

    public final void mq(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[onDone] size:%s isAppBrandHeaderEnable:%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.uoZ)});
        if (mr(true)) {
            if (i == 1 && this.uoX != null) {
                setEmptyViewVisible(true);
            } else if (i > 1 && this.uoX != null) {
                setEmptyViewVisible(false);
            }
            if (this.uoX != null && this.uoX.getVisibility() == 8) {
                this.uoX.setVisibility(0);
                setSelection(getFirstVisiblePosition());
                return;
            }
            return;
        }
        x.w("MicroMsg.ConversationWithAppBrandListView", "[onDone] is disable!");
        if (this.uoX != null) {
            this.uoX.setVisibility(8);
        }
    }

    private View getEmptyFooter() {
        View linearLayout = new LinearLayout(getContext());
        this.upi = new View(getContext());
        this.upi.setLayoutParams(new LayoutParams(-1, 0));
        linearLayout.addView(this.upi);
        linearLayout.setBackgroundColor(getContext().getResources().getColor(R.e.white));
        return linearLayout;
    }

    /* renamed from: mn */
    final void a(boolean z) {
        if (this.upi != null && mr(true)) {
            if (z) {
                postDelayed(new 20(this), 0);
            } else {
                cyL();
            }
        }
    }

    private void cyL() {
        boolean z;
        int firstHeaderVisible = getFirstHeaderVisible();
        LayoutParams layoutParams = (LayoutParams) this.upi.getLayoutParams();
        int i = layoutParams.height;
        float FS = FS(getAdapter() == null ? 0 : getAdapter().getCount());
        if (FS < 0.0f) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.ConversationWithAppBrandListView", "[checkEmptyFooter] isRealFull:" + z + " extraHeight:" + FS);
        if (z) {
            layoutParams.height = 0;
        } else {
            layoutParams.height = (int) FS;
            if (this.huc) {
                post(new 21(this));
            }
        }
        if (i != layoutParams.height) {
            this.upi.setLayoutParams(layoutParams);
            if (!this.huc) {
                super.setSelection(firstHeaderVisible);
            }
        }
    }

    private void mo(boolean z) {
        if (z) {
            ah.M(this.upj);
            return;
        }
        ah.M(this.upj);
        ah.i(this.upj, 1000);
    }

    private void setEmptyViewVisible(boolean z) {
        int i = 0;
        x.i("MicroMsg.ConversationWithAppBrandListView", "[setEmptyViewVisible] isShow:%s", new Object[]{Boolean.valueOf(z)});
        if (this.gQd != null) {
            this.gQd.setVisibility(z ? 0 : 8);
        }
        if (this.uoX != null) {
            View findViewById = this.uoX.findViewById(R.h.appbrand_preview_view);
            if (findViewById != null) {
                if (z) {
                    i = 4;
                }
                findViewById.setVisibility(i);
            }
        }
    }

    private void cyM() {
        this.uoW = y.gq(getContext()).inflate(R.i.appbrand_preview_container, null);
        this.uoX = this.uoW.findViewById(R.h.appbrand_preview_layout);
        this.uoX.setVisibility(8);
        this.gQd = this.uoX.findViewById(R.h.empty_tip);
        this.uoW.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        ViewGroup viewGroup = (ViewGroup) this.uoW.findViewById(R.h.appbrand_preview_view);
        if (g.l(d.class) != null) {
            this.uoY = ((d) g.l(d.class)).z(getContext(), d.b.gPA);
            this.upk = this.uoY.getLayoutParams().height;
            this.uoY.setRefreshListener(this);
            this.uoY.refresh();
            viewGroup.addView(this.uoY);
            viewGroup.setTranslationY(-(this.trr - (((float) this.upk) - getResources().getDimension(R.f.app_brand_recent_text_view_padding_top))));
            this.uoY.getAdapter().a(new 2(this));
            this.uoY.setOnItemClickListener(new 3(this));
            this.uoY.a(new 4(this));
            this.uoV.remove(this.uoW);
            FixedViewInfo fixedViewInfo = new FixedViewInfo(this);
            fixedViewInfo.view = this.uoW;
            fixedViewInfo.data = null;
            fixedViewInfo.isSelectable = true;
            this.uoV.addFirst(fixedViewInfo);
            Iterator it = this.uoV.iterator();
            while (it.hasNext()) {
                fixedViewInfo = (FixedViewInfo) it.next();
                super.addHeaderView(fixedViewInfo.view, fixedViewInfo.data, fixedViewInfo.isSelectable);
            }
            return;
        }
        this.uoZ = false;
        x.e("MicroMsg.ConversationWithAppBrandListView", "MMKernel.service(IAppBrandRecentViewService.class) is null!");
    }

    public void setSelection(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[setSelection] position:%s", new Object[]{Integer.valueOf(i)});
        if (i == 0 && mr(true)) {
            super.setSelection(getFirstHeaderVisible());
            if (this.upc != null) {
                this.upc.cc(Math.max(0, this.uoY.getCount() - 1), 7);
                return;
            }
            return;
        }
        super.setSelection(i);
    }

    public void smoothScrollToPosition(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPosition] position:%s", new Object[]{Integer.valueOf(i)});
        if (i == 0 && mr(true)) {
            super.smoothScrollToPosition(getFirstHeaderVisible());
        } else {
            super.smoothScrollToPosition(i);
        }
    }

    public void smoothScrollToPositionFromTop(int i, int i2) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && mr(true)) {
            super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), i2);
        } else {
            super.smoothScrollToPositionFromTop(i, i2);
        }
    }

    public void smoothScrollToPositionFromTop(int i, int i2, int i3) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i == 0 && mr(true)) {
            super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), i2, i3);
        } else {
            super.smoothScrollToPositionFromTop(i, i2, i3);
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.kLU = onScrollListener;
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        if (!mr(true) || getFirstVisiblePosition() != 0 || i2 >= 0) {
            return super.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }
        iArr[1] = (int) (((float) i2) / 3.0f);
        super.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                float x = motionEvent.getX();
                this.inM = x;
                this.upl = x;
                x = motionEvent.getY();
                this.inN = x;
                this.upm = x;
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            return dispatchTouchEvent;
        } finally {
            this.inM = motionEvent.getX();
            this.inN = motionEvent.getY();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!mr(true)) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            if (getFirstVisiblePosition() != 0) {
                this.upw = true;
            }
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && getFirstVisiblePosition() == 0) {
            View childAt = getChildAt(0);
            if (childAt == null) {
                return true;
            }
            if (Math.abs(motionEvent.getX() - this.inM) < 3.0f && Math.abs(motionEvent.getY() - this.inN) < 3.0f) {
                super.onTouchEvent(motionEvent);
            }
            if (getChildTranslationY() < 60.0f * getResources().getDisplayMetrics().density) {
                float abs = Math.abs(motionEvent.getX() - this.upl) - Math.abs(motionEvent.getY() - this.upm);
                if ((motionEvent.getY() - this.upm < 0.0f && abs < 0.0f && getFirstVisiblePosition() == 0) || (childAt.getBottom() > 0 && ((float) childAt.getBottom()) < this.trr)) {
                    FR(4);
                } else if (((float) childAt.getBottom()) >= this.trr && motionEvent.getY() - this.upm > 0.0f) {
                    FQ(ag.CTRL_BYTE);
                }
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            mo(true);
            this.upp = false;
            if (getChildTranslationY() > 0.0f) {
                FQ(ag.CTRL_BYTE);
            }
        }
        if (!M(motionEvent)) {
            if (this.upp && motionEvent.getAction() == 2) {
                motionEvent.setAction(0);
                super.onTouchEvent(motionEvent);
                motionEvent.setAction(2);
                this.upp = false;
            }
            return super.onTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 0) {
            super.onTouchEvent(motionEvent);
            return true;
        } else if (motionEvent.getAction() == 2 && !this.upp && Math.abs(motionEvent.getY() - this.inN) > 2.0f) {
            motionEvent.setAction(3);
            super.onTouchEvent(motionEvent);
            this.upp = true;
            return true;
        } else if (this.upp) {
            return true;
        } else {
            super.onTouchEvent(motionEvent);
            return true;
        }
    }

    private boolean M(MotionEvent motionEvent) {
        int i = 0;
        if (!cyO()) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.upo = motionEvent.getY();
            if (this.bwg != null) {
                this.bwg.cancel();
            }
        } else if (motionEvent.getActionMasked() == 5) {
            this.upo = motionEvent.getY();
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.uoW.getTop() == 0 && getChildTranslationY() != 0.0f) {
            mp(true);
            this.upq = false;
            x.d("MicroMsg.ConversationWithAppBrandListView", "[animationChild] offset:%s delay:%s duration%s", new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(180)});
            if (cyO()) {
                if (this.bwg != null) {
                    this.bwg.cancel();
                }
                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{getChildTranslationY() + 0.0f, 0.0f});
                PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("headerDeltaY", new float[]{getHeaderY() + 0.0f, 0.0f});
                this.bwg = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2});
                this.bwg.setDuration(180);
                this.bwg.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue("headerDeltaY")).floatValue();
                        for (int i = 0; i < ConversationWithAppBrandListView.this.getChildCount(); i++) {
                            if (i == 0) {
                                ConversationWithAppBrandListView.this.getChildAt(i).setTranslationY(floatValue2);
                            } else {
                                ConversationWithAppBrandListView.this.getChildAt(i).setTranslationY(floatValue);
                            }
                            ConversationWithAppBrandListView.this.upn = floatValue;
                        }
                        ConversationWithAppBrandListView.this.invalidate();
                    }
                });
                this.bwg.addListener(new 7(this));
                this.bwg.setStartDelay(0);
                this.bwg.start();
            }
        }
        try {
            if (!(motionEvent.getAction() == 2 && Math.abs(motionEvent.getY() - this.inN) > 2.0f && getFirstVisiblePosition() == 0 && this.uoW.getTop() == 0) && getChildTranslationY() == 0.0f) {
                this.upo = motionEvent.getY();
                return false;
            }
            mo(true);
            if (((float) ((getHeight() - this.upk) / 2)) <= this.upn) {
                mp(false);
            } else {
                mp(true);
            }
            float height = (float) (getHeight() - this.upk);
            this.upn = ((motionEvent.getY() - this.upo) * 0.4f) + this.upn;
            if (this.upn < 0.0f) {
                this.upn = 0.0f;
                cyN();
                invalidate();
                return false;
            }
            if (height < this.upn) {
                this.upn = height;
            }
            while (i < getChildCount()) {
                if (i == 0) {
                    getChildAt(i).setTranslationY(this.upn * 0.5f);
                } else {
                    getChildAt(i).setTranslationY(this.upn);
                }
                i++;
            }
            invalidate();
            this.upo = motionEvent.getY();
            return true;
        } finally {
            this.upo = motionEvent.getY();
        }
    }

    private void FQ(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[openAppBrandRecentView] isOpenAppBrandRecentView:%s isHeadsetPluged:%s", new Object[]{Boolean.valueOf(this.upr), Boolean.valueOf(au.HV().yK())});
        if (!this.upr) {
            as.a(getContext(), R.l.app_brand_recent_view_down_sound_path, as.b.sIh, 3, null);
            if (!(this.upc == null || this.uoY == null)) {
                com.tencent.mm.plugin.appbrand.widget.recentview.b bVar = this.upc;
                int max = Math.max(0, this.uoY.getCount() - 1);
                bVar.gOW = System.currentTimeMillis() / 1000;
                bVar.gOX = max;
            }
        }
        if (this.upg && this.uoY != null) {
            this.uoY.getAdapter().RR.notifyChanged();
            this.upg = true;
        }
        super.smoothScrollToPositionFromTop(0, 0, i);
        mo(true);
        setOpenAppBrandRecentView(true);
    }

    private void FR(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[closeAppBrandRecentView] isOpenAppBrandRecentView:%s type:%s", new Object[]{Boolean.valueOf(this.upr), Integer.valueOf(i)});
        if (!(!this.upr || getChildAt(0) == null || this.upc == null || this.uoY == null)) {
            this.upc.cc(Math.max(0, this.uoY.getCount() - 1), i);
        }
        if (getFirstVisiblePosition() == 0) {
            View childAt = getChildAt(0);
            if ((childAt == null ? 0 : childAt.getBottom()) != 0) {
                smoothScrollToPositionFromTop(getFirstHeaderVisible(), 0, 150);
            }
        }
        cyN();
        mo(true);
        setOpenAppBrandRecentView(false);
    }

    private void setOpenAppBrandRecentView(boolean z) {
        this.upr = z;
    }

    private float getChildTranslationY() {
        View childAt = getChildAt(1);
        return childAt == null ? 0.0f : childAt.getTranslationY();
    }

    private float getHeaderY() {
        View childAt = getChildAt(0);
        return childAt == null ? 0.0f : childAt.getTranslationY();
    }

    private void cyN() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setTranslationY(0.0f);
        }
        this.upn = 0.0f;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getFirstVisiblePosition() == 0 && this.uoW != null) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), ((float) this.uoW.getBottom()) + this.upn, this.upa);
            if (getChildAt(1) != null) {
                int i = (getHeight() == 0 || !this.upt) ? 0 : 1;
                if (i != 0) {
                    canvas.drawText(this.upd, (((float) getWidth()) - this.upe) / 2.0f, (((float) this.uoW.getBottom()) + this.upn) - getResources().getDimension(R.f.ListPadding), this.upb);
                }
            }
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kLU != null) {
            this.kLU.onScrollStateChanged(absListView, i);
        }
        if (getFirstVisiblePosition() != 0 && i == 2 && !this.ups) {
            this.jwE = true;
        }
    }

    private void mp(boolean z) {
        if (z && this.upu != null) {
            ah.M(this.upu);
            this.upu = null;
            if (this.upt) {
                mq(false);
            }
        } else if (!z && this.upu == null) {
            Runnable anonymousClass8 = new Runnable() {
                public final void run() {
                    x.i("MicroMsg.ConversationWithAppBrandListView", "[CheckShowTipTask]");
                    ConversationWithAppBrandListView.this.mq(true);
                }
            };
            this.upu = anonymousClass8;
            ah.i(anonymousClass8, 3000);
        }
    }

    private void mq(boolean z) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[showTipWithAnim] isShow:%s", new Object[]{Boolean.valueOf(z)});
        PropertyValuesHolder ofInt;
        ValueAnimator ofPropertyValuesHolder;
        if (z) {
            this.upt = true;
            ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{0, 77});
            ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt});
            ofPropertyValuesHolder.setDuration(200);
            ofPropertyValuesHolder.addUpdateListener(new 9(this));
            ofPropertyValuesHolder.start();
            if (this.upc != null) {
                com.tencent.mm.plugin.appbrand.widget.recentview.b bVar = this.upc;
                bVar.gPc++;
                return;
            }
            return;
        }
        ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{77, 0});
        ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt});
        ofPropertyValuesHolder.setDuration(200);
        ofPropertyValuesHolder.addUpdateListener(new 10(this));
        ofPropertyValuesHolder.addListener(new 11(this));
        ofPropertyValuesHolder.start();
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.kLU != null) {
            this.kLU.onScroll(absListView, i, i2, i3);
        }
        if (mr(true)) {
            float bottom;
            if (i == 0) {
                mo(false);
                View childAt = absListView.getChildAt(0);
                if (childAt != null && childAt.getId() == R.h.appbrand_preview_container) {
                    View findViewById = childAt.findViewById(R.h.appbrand_preview_layout);
                    if (findViewById != null && findViewById.getVisibility() != 8) {
                        View findViewById2 = childAt.findViewById(R.h.appbrand_preview_view);
                        GyroView gyroView = (GyroView) childAt.findViewById(R.h.gyroView);
                        float dimension = this.trr - (((float) this.upk) - getResources().getDimension(R.f.app_brand_recent_text_view_padding_top));
                        float dimension2 = (this.trr - (((float) this.upk) - getResources().getDimension(R.f.app_brand_recent_text_view_padding_top))) - getResources().getDimension(R.f.HugeTextSize);
                        if (childAt.getBottom() <= 3) {
                            findViewById2.setTranslationY(-dimension);
                            this.gQd.setTranslationY(-dimension2);
                            if (gyroView.getVisibility() == 0) {
                                gyroView.setVerticalScroll(0.0f);
                                gyroView.setVisibility(8);
                            }
                            this.upx = false;
                        }
                        if (childAt.getBottom() > 3 && ((float) childAt.getBottom()) <= this.trr && findViewById2.getTranslationY() != 0.0f) {
                            if (gyroView.getVisibility() == 8) {
                                gyroView.setVisibility(0);
                            }
                            gyroView.setAlpha(1.0f);
                            gyroView.setTranslationY((float) (((-childAt.getBottom()) / 2) + (gyroView.getHeight() / 2)));
                            gyroView.setVerticalScroll((float) childAt.getBottom());
                        } else if (((float) childAt.getBottom()) > this.trr && findViewById2.getTranslationY() != 0.0f) {
                            bottom = (float) ((1.0d * ((double) (((float) childAt.getBottom()) - this.trr))) / ((double) (((float) this.upk) - this.trr)));
                            findViewById2.setTranslationY((-dimension) * (1.0f - bottom));
                            this.gQd.setTranslationY((-dimension2) * (1.0f - bottom));
                            gyroView.setTranslationY((((-this.trr) / 2.0f) + ((float) (gyroView.getHeight() / 2))) + (((this.trr / 2.0f) + ((float) gyroView.getHeight())) * bottom));
                            gyroView.setAlpha(1.0f - (2.0f * bottom));
                            if (!(this.upx || 1.0f == bottom)) {
                                this.hXL.vibrate(10);
                                this.upx = true;
                            }
                            mo(true);
                        }
                    } else {
                        return;
                    }
                }
            }
            if (this.uoW != null) {
                ViewGroup viewGroup = (ViewGroup) this.uoW.findViewById(R.h.appbrand_preview_view);
                bottom = this.trr - (((float) this.upk) - getResources().getDimension(R.f.app_brand_recent_text_view_padding_top));
                float dimension3 = (this.trr - (((float) this.upk) - getResources().getDimension(R.f.app_brand_recent_text_view_padding_top))) - getResources().getDimension(R.f.HugeTextSize);
                if (!(viewGroup == null || viewGroup.getTranslationY() == bottom)) {
                    viewGroup.setTranslationY(-bottom);
                }
                this.gQd.setTranslationY(-dimension3);
            }
            if (this.upy == 0 && i != 0) {
                FR(4);
                mp(true);
                mo(true);
            }
            this.upy = i;
            if (this.upw && this.jwE && i == 0) {
                x.e("MicroMsg.ConversationWithAppBrandListView", "[Stop fling!]");
                smoothScrollBy(0, 0);
                post(new 22(this));
                this.upw = false;
            }
            ah.M(this.upv);
            ah.i(this.upv, 50);
        }
    }

    final float FS(int i) {
        x.d("MicroMsg.ConversationWithAppBrandListView", "[isFull] totalItemCount:" + i + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount());
        x.i("MicroMsg.ConversationWithAppBrandListView", "[isFull] height:%s rawCount:%s extraHeight:%s", new Object[]{Integer.valueOf(getHeight()), Integer.valueOf((i - getHeaderViewsCount()) - getFooterViewsCount()), Float.valueOf((float) (getMeasuredHeight() - (((int) getResources().getDimension(R.f.NormalListHeight)) * ((i - getHeaderViewsCount()) - getFooterViewsCount()))))});
        return (float) (getMeasuredHeight() - (((int) getResources().getDimension(R.f.NormalListHeight)) * ((i - getHeaderViewsCount()) - getFooterViewsCount())));
    }

    public int getFirstHeaderVisible() {
        Iterator it = this.uoV.iterator();
        int i = 0;
        while (it.hasNext()) {
            FixedViewInfo fixedViewInfo = (FixedViewInfo) it.next();
            if (fixedViewInfo.view == this.uoW) {
                i++;
            } else {
                if (fixedViewInfo.view != null && (fixedViewInfo.view instanceof ViewGroup)) {
                    View childAt = ((ViewGroup) fixedViewInfo.view).getChildAt(0);
                    if (childAt != null && childAt.getVisibility() == 0) {
                        x.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", new Object[]{Integer.valueOf(i)});
                        break;
                    }
                }
                i++;
            }
        }
        x.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", new Object[]{Integer.valueOf(i)});
        return i;
    }

    final boolean mr(boolean z) {
        if (!((this.hasInit && z) || g.l(d.class) == null)) {
            g.l(d.class);
            this.uoZ = true;
            x.i("MicroMsg.ConversationWithAppBrandListView", "[isAppBrandHeaderEnable] :%s", new Object[]{Boolean.valueOf(this.uoZ)});
            this.hasInit = true;
        }
        return this.uoZ;
    }

    private boolean cyO() {
        if (this.uoX == null) {
            return false;
        }
        if (mr(true) && this.uoX.getVisibility() == 0) {
            return true;
        }
        return false;
    }
}
