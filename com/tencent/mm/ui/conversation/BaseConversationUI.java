package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBar;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.b;
import com.tencent.mm.ui.b.c;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.chatting.aa;
import com.tencent.mm.ui.chatting.y;
import com.tencent.mm.ui.n;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.g;

public class BaseConversationUI extends MMFragmentActivity {
    private static final String LAST_RESTORE_TALKER = "last_restore_talker";
    static final String TAG = "MicroMsg.BaseConversationUI";
    private OnLayoutChangedLinearLayout chattingFragmentView;
    private y chattingFragmet;
    private int chattingID = -1;
    private n chattingUIProxy;
    private TestTimeForChatting chattingView;
    private long chattinguiResumeTime = 0;
    public b conversationFm;
    private boolean isAnimating;
    private String lastRestoreTalker;
    private a launcherUIStatus = a.unr;
    private ActionBar mActionBar;
    private b mActionBarHelper;
    public boolean mChattingClosed = true;
    private Animation mChattingInAnim;
    private Animation mChattingOutAnim;
    private boolean mNeedChattingAnim = false;
    private Bitmap mPrepareBitmap;
    private a onChattingLayoutChangedListener = new a() {
        long start = 0;

        public final void cqO() {
            if (BaseConversationUI.this.mChattingInAnim == null) {
                BaseConversationUI.this.mChattingInAnim = AnimationUtils.loadAnimation(BaseConversationUI.this, MMFragmentActivity.a.tnC);
                BaseConversationUI.this.mChattingInAnim.setAnimationListener(new 1(this));
            }
            if (BaseConversationUI.this.mNeedChattingAnim) {
                BaseConversationUI.this.chattingView.setOndispatchDraw(new 2(this));
                BaseConversationUI.this.mNeedChattingAnim = false;
            } else {
                BaseConversationUI.this.doJobOnChattingAnimStart();
                BaseConversationUI.this.doJobOnChattingAnimEnd();
            }
            BaseConversationUI.this.chattingFragmentView.tAR = null;
            x.i(BaseConversationUI.TAG, "klem CHATTING ONLAYOUT ");
        }
    };
    Bundle pendingBundle;
    String pendingUser;
    private c selectImageJob = new c(this, (byte) 0);
    Runnable startChattingRunnable = new 8(this);
    private String title;

    public void onCreate(Bundle bundle) {
        getWindow().setFormat(-2);
        e.N(this);
        super.onCreate(bundle);
        getWindow().setCallback(new c(getWindow().getCallback(), this));
        this.mActionBar = getSupportActionBar();
        initNavigationSwipeBack();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        x.i(TAG, "onNewIntent");
        setIntent(intent);
    }

    protected void onResume() {
        super.onResume();
        g.b(this);
        onSwipe(1.0f);
        this.launcherUIStatus = a.uns;
        final boolean z = this.chattingView != null && this.chattingView.isShown();
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                d.b(3, z ? "ChattingUI" + BaseConversationUI.this.getIdentityString() : BaseConversationUI.this.getLocalClassName(), z ? BaseConversationUI.this.chattingFragmet.hashCode() : BaseConversationUI.this.hashCode());
            }
        }, "directReport_onResume");
        if (!z) {
            this.chattinguiResumeTime = bi.VE();
        }
        if (com.tencent.mm.compatible.util.d.fR(19) && com.tencent.mm.compatible.i.a.zX()) {
            if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
                this.chattingFragmet.getSwipeBackLayout().setEnableGesture(true);
            }
            Looper.myQueue().addIdleHandler(new 3(this));
        }
        initActionBar();
        this.mActionBar.show();
    }

    protected void onPause() {
        x.i(TAG, "on pause");
        super.onPause();
        if (!isFinishing()) {
            g.a(this);
        }
        this.launcherUIStatus = a.unt;
        boolean z = this.chattingView != null && this.chattingView.isShown();
        com.tencent.mm.sdk.f.e.post(new 4(this, z), "directReport_onPause");
        if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
            this.chattingFragmet.getSwipeBackLayout().setEnableGesture(false);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!(this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled())) {
            this.mPrepareBitmap.recycle();
        }
        this.chattingFragmet = null;
        this.chattingFragmentView = null;
        this.chattingView = null;
        this.conversationFm = null;
        this.mActionBarHelper = null;
        this.mChattingInAnim = null;
        this.mChattingOutAnim = null;
    }

    public void onSwipe(float f) {
        x.v(TAG, "ashutest::on swipe %f, duration %d, status %s", new Object[]{Float.valueOf(f), Long.valueOf(220), this.launcherUIStatus});
        if (com.tencent.mm.compatible.util.d.fR(19) && com.tencent.mm.compatible.i.a.zX()) {
            ImageView imageView;
            if (f == 0.0f && !this.mChattingClosed) {
                imageView = (ImageView) getWindow().getDecorView().findViewById(R.h.prepare_imageview);
                if (imageView != null) {
                    ViewGroup viewGroup = (ViewGroup) imageView.getTag();
                    if (viewGroup != null) {
                        Bitmap magicDrawingCache = getMagicDrawingCache(viewGroup);
                        if (magicDrawingCache != null) {
                            x.i(TAG, "[onSwipe] prepareView VISIBLE");
                            imageView.setVisibility(0);
                            imageView.setImageBitmap(magicDrawingCache);
                            viewGroup.setVisibility(8);
                        } else {
                            x.i(TAG, "[onSwipe] prepareView GONE");
                            viewGroup.setVisibility(0);
                            imageView.setVisibility(8);
                            imageView.setImageDrawable(null);
                        }
                    }
                }
                if (this.mChattingInAnim != null) {
                    this.mChattingInAnim.cancel();
                }
            } else if (f == 1.0f && !this.mChattingClosed && !this.mChattingClosed && this.chattingFragmet.isSupportNavigationSwipeBack()) {
                getWindow().setBackgroundDrawableResource(R.e.room_info_comment_layout_bg);
                imageView = (ImageView) getWindow().getDecorView().findViewById(R.h.prepare_imageview);
                if (!(imageView == null || imageView.getVisibility() != 0 || imageView.getTag() == null)) {
                    ((View) imageView.getTag()).setVisibility(0);
                    x.i(TAG, "[onSwipe] prepareView GONE");
                    imageView.setVisibility(8);
                }
            }
            if (a.uns == this.launcherUIStatus || Float.compare(1.0f, f) <= 0) {
                View findViewById = findViewById(R.h.launcher_container);
                imageView = (ImageView) findViewById(R.h.prepare_imageview);
                if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null || this.mChattingClosed || f == 1.0f || f == 0.0f)) {
                    imageView.setVisibility(0);
                    x.i(TAG, "[onSwipe] !1 && !0 prepareView VISIBLE");
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                }
                resetViewTranX(findViewById, imageView, f);
                return;
            }
            x.i(TAG, "[onSwipe] return! consumedSuperCall:%s", new Object[]{Float.valueOf(f)});
        }
    }

    private void resetViewTranX(View view, ImageView imageView, float f) {
        if (Float.compare(1.0f, f) <= 0) {
            i.n(view, 0.0f);
            i.n(imageView, 0.0f);
        } else if (imageView == null || imageView.getDrawable() == null) {
            i.n(view, (((float) (view.getWidth() / 4)) * (1.0f - f)) * -1.0f);
        } else {
            i.n(imageView, (((float) (imageView.getWidth() / 4)) * (1.0f - f)) * -1.0f);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.conversationFm != null) {
            this.conversationFm.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            if (i == 2001 && this.chattingFragmet != null) {
                this.chattingFragmet.onActivityResult(i, i2, intent);
            }
            if (acceptRequestCode(i) && this.chattingFragmet == null) {
                x.i(TAG, "on select image ActivityResult. the chattingUI maybe kill in the background.");
                ah.M(this.selectImageJob);
                this.selectImageJob.tpz = 0;
                this.selectImageJob.bRZ = i;
                this.selectImageJob.bjW = i2;
                this.selectImageJob.bSa = intent;
                ah.A(this.selectImageJob);
            }
        }
    }

    private void doJobOnChattingAnimStart() {
        this.chattingView.setTranslationX(0.0f);
        this.chattingView.dtL = 0;
    }

    private void doJobOnChattingAnimEnd() {
        ah.i(new Runnable() {
            public final void run() {
                au.Em().cik();
                ah.Db(0);
                BaseConversationUI.this.onSwipe(1.0f);
                if (!(BaseConversationUI.this.chattingView == null || BaseConversationUI.this.chattingFragmet == null)) {
                    BaseConversationUI.this.chattingView.czV();
                }
                BaseConversationUI.this.chattingUIProxy.cpN();
                BaseConversationUI.this.tryResetChattingSwipeStatus();
            }

            public final String toString() {
                return super.toString() + "|chattingView_onAnimationEnd";
            }
        }, 60);
    }

    private void tryResetChattingSwipeStatus() {
        boolean z = true;
        if (com.tencent.mm.compatible.util.d.fR(19) && com.tencent.mm.compatible.i.a.zX()) {
            String str = TAG;
            String str2 = "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.chattingFragmet != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (this.chattingFragmet != null) {
                this.chattingFragmet.getSwipeBackLayout().uIg = false;
            }
        }
    }

    public void startChatting(String str) {
        startChatting(str, null, false);
    }

    public void startChatting(String str, Bundle bundle, boolean z) {
        String str2 = TAG;
        String str3 = "try startChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.chattingView == null ? false : this.chattingView.isShown());
        x.i(str2, str3, objArr);
        this.pendingBundle = bundle;
        this.pendingUser = str;
        this.mNeedChattingAnim = z;
        au.Em().cii();
        ah.Db(-8);
        ah.A(this.startChattingRunnable);
    }

    @TargetApi(19)
    private void prepareChattingFragment(Intent intent, boolean z) {
        boolean z2;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.chattingFragmet == null) {
            this.chattingFragmet = getChattingUIFragment();
            this.chattingUIProxy = new aa(this, this.chattingFragmet);
            z2 = true;
        } else {
            z2 = false;
        }
        createChattingView();
        if (intent != null) {
            this.chattingFragmet.getArguments().putAll(s.aq(intent));
        }
        if (z2) {
            this.chattingUIProxy.aj(this.chattingID, z);
            this.chattingFragmentView = (OnLayoutChangedLinearLayout) this.chattingFragmet.getView().findViewById(R.h.chatting_bg_ll);
        } else {
            this.chattingUIProxy.cpM();
        }
        if (this.chattingFragmet.isSupportNavigationSwipeBack()) {
            this.chattingFragmet.getSwipeBackLayout().setNeedRequestActivityTranslucent(false);
        }
        x.i(TAG, "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z2), intent});
    }

    private void createChattingView() {
        int[] iArr;
        View findRootContainer;
        if (this.chattingView == null) {
            if (this.chattingFragmet.isSupportCustomActionBar()) {
                ViewGroup viewGroup;
                iArr = new int[2];
                getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                View testTimeForChatting = new TestTimeForChatting(this);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                testTimeForChatting.setId(R.h.chatting_custom_container);
                this.chattingID = testTimeForChatting.getId();
                testTimeForChatting.setOrientation(1);
                testTimeForChatting.setLayoutParams(layoutParams);
                FitSystemWindowLayoutView fitSystemWindowLayoutView = new FitSystemWindowLayoutView(this);
                fitSystemWindowLayoutView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                findRootContainer = findRootContainer();
                if (findRootContainer == null) {
                    findRootContainer = ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
                }
                if (findRootContainer instanceof SwipeBackLayout) {
                    viewGroup = (ViewGroup) ((ViewGroup) findRootContainer).getChildAt(0);
                } else {
                    viewGroup = (ViewGroup) findRootContainer;
                }
                View imageView = new ImageView(this);
                imageView.setId(R.h.prepare_imageview);
                imageView.setLayoutParams(testTimeForChatting.getLayoutParams());
                imageView.setVisibility(8);
                ((ViewGroup) getWindow().getDecorView()).removeView(findRootContainer);
                findRootContainer.setId(R.h.launcher_container);
                fitSystemWindowLayoutView.addView(findRootContainer);
                fitSystemWindowLayoutView.addView(imageView);
                fitSystemWindowLayoutView.addView(testTimeForChatting);
                ((ViewGroup) getWindow().getDecorView()).addView(fitSystemWindowLayoutView);
                getWindow().getDecorView().requestFitSystemWindows();
                int i = iArr[1];
                if (i > 0) {
                    updateRootViewSystemWindowsInsets(fitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), viewGroup);
                } else {
                    getSupportActionBar().getCustomView().post(new 7(this, iArr, fitSystemWindowLayoutView, viewGroup));
                }
                this.chattingView = (TestTimeForChatting) findViewById(this.chattingID);
                x.i(TAG, "ashu::prepareChattingFragment init chattingView, top %s", new Object[]{Integer.valueOf(iArr[1])});
                return;
            }
            this.chattingView = (TestTimeForChatting) findViewById(R.h.chatting_area);
            this.chattingID = this.chattingView.getId();
        } else if (this.chattingFragmet.isSupportCustomActionBar()) {
            iArr = new int[2];
            this.chattingView.getLocationInWindow(iArr);
            if (iArr[1] == 0) {
                ViewGroup viewGroup2 = (ViewGroup) getWindow().getDecorView();
                int i2 = 0;
                while (i2 < viewGroup2.getChildCount()) {
                    findRootContainer = ((ViewGroup) getWindow().getDecorView()).getChildAt(i2);
                    if (findRootContainer instanceof FitSystemWindowLayoutView) {
                        getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                        FitSystemWindowLayoutView fitSystemWindowLayoutView2 = (FitSystemWindowLayoutView) findRootContainer;
                        fitSystemWindowLayoutView2.fitSystemWindows(new Rect(0, fitSystemWindowLayoutView2.getCacheInsetsTop(), 0, 0));
                        x.i(TAG, "rootLayout2 fitSystemWindows, top %s", new Object[]{Integer.valueOf(iArr[1])});
                        viewGroup2 = (ViewGroup) viewGroup2.findViewById(R.h.launcher_container);
                        ImageView imageView2 = (ImageView) fitSystemWindowLayoutView2.findViewById(R.h.prepare_imageview);
                        imageView2.setTag(viewGroup2);
                        imageView2.setLayoutParams(viewGroup2.getLayoutParams());
                        Bitmap magicDrawingCache = getMagicDrawingCache(viewGroup2);
                        if (magicDrawingCache != null) {
                            imageView2.setImageBitmap(magicDrawingCache);
                            viewGroup2.setVisibility(8);
                            imageView2.setVisibility(0);
                            x.i(TAG, "[prepareChattingFragment] prepareView VISIBLE");
                        } else {
                            imageView2.setImageBitmap(null);
                        }
                    } else {
                        x.e(TAG, "on position %d, rootLayout not found!", new Object[]{Integer.valueOf(i2)});
                        i2++;
                    }
                }
            }
            x.i(TAG, "ashu::prepareChattingFragment has chattingView, top %s", new Object[]{Integer.valueOf(iArr[1])});
        }
    }

    public Bitmap getMagicDrawingCache(View view) {
        int measuredWidth;
        int measuredHeight;
        long currentTimeMillis = System.currentTimeMillis();
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0) {
            measuredWidth = view.getMeasuredWidth();
        } else {
            measuredWidth = width;
        }
        if (height <= 0) {
            measuredHeight = view.getMeasuredHeight();
        } else {
            measuredHeight = height;
        }
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            x.e(TAG, "viewWidth:%s viewHeight:%s", new Object[]{Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)});
            return null;
        }
        if (this.chattingFragmet != null) {
            x.i(TAG, "getBottom:%s keyboardState:%s", new Object[]{Integer.valueOf(this.chattingFragmet.getView().getBottom()), Integer.valueOf(this.chattingFragmet.keyboardState())});
        }
        if (this.chattingFragmet != null && this.chattingFragmet.getView().getBottom() > 0 && (this.chattingFragmet.keyboardState() == 1 || this.chattingFragmet.getView().getBottom() < (getResources().getDisplayMetrics().heightPixels * 2) / 3)) {
            x.e(TAG, "hardKeyboardHidden:%s", new Object[]{Integer.valueOf(this.chattingFragmet.keyboardState())});
            return null;
        } else if (this.chattingFragmet == null || this.chattingFragmet.keyboardState() != 1) {
            if (this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled() || this.mPrepareBitmap.getWidth() != measuredWidth || this.mPrepareBitmap.getHeight() != measuredHeight) {
                if (!(this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled())) {
                    this.mPrepareBitmap.recycle();
                }
                try {
                    this.mPrepareBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_4444);
                } catch (OutOfMemoryError e) {
                    x.e(TAG, "[getMagicDrawingCache] e:%s", new Object[]{e});
                    return null;
                }
            }
            this.mPrepareBitmap.eraseColor(0);
            Canvas canvas = new Canvas(this.mPrepareBitmap);
            width = (int) getResources().getDimension(R.f.wechat_abc_action_bar_default_height);
            int dimension = (int) getResources().getDimension(R.f.DefaultTabbarHeight);
            Paint paint = new Paint();
            paint.setColor(-1);
            canvas.drawRect(0.0f, (float) width, (float) measuredWidth, (float) (measuredHeight - dimension), paint);
            view.draw(canvas);
            x.i(TAG, "[getMagicDrawingCache] cost%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            return this.mPrepareBitmap;
        } else {
            x.e(TAG, "hardKeyboardHidden:%s", new Object[]{Integer.valueOf(this.chattingFragmet.keyboardState())});
            return null;
        }
    }

    private void updateRootViewSystemWindowsInsets(FitSystemWindowLayoutView fitSystemWindowLayoutView, int i, Rect rect, ViewGroup viewGroup) {
        int i2;
        int bottom = getWindow().getDecorView().getBottom();
        int bottom2 = getSupportActionBar().getCustomView().getBottom();
        if (this.conversationFm == null || this.conversationFm.getView() == null) {
            i2 = 0;
        } else {
            i2 = bottom - ((i + bottom2) + this.conversationFm.getView().getBottom());
        }
        x.i(TAG, "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", new Object[]{Integer.valueOf(bottom), Integer.valueOf(i), Integer.valueOf(bottom2), Integer.valueOf(i2)});
        fitSystemWindowLayoutView.setActionBarContainer(viewGroup);
        fitSystemWindowLayoutView.fitSystemWindows(rect);
    }

    private ViewGroup findRootContainer() {
        ViewParent parent = this.mActionBar.getCustomView().getParent();
        ViewParent viewParent = null;
        ViewParent viewParent2 = (ViewGroup) getWindow().getDecorView();
        while (parent != viewParent2 && parent != null) {
            viewParent = parent;
            parent = parent.getParent();
        }
        return (ViewGroup) viewParent;
    }

    public void pauseMainFragment() {
        if (this.conversationFm != null && !this.conversationFm.isSupportNavigationSwipeBack()) {
            this.conversationFm.showOptionMenu(false);
        }
    }

    public void resumeMainFragment() {
        if (this.conversationFm != null) {
            this.conversationFm.onResume();
            if (!this.conversationFm.isSupportNavigationSwipeBack()) {
                this.conversationFm.showOptionMenu(true);
            }
        }
    }

    public void closeChatting(boolean z) {
        String str = TAG;
        String str2 = "try closeChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.chattingView == null ? false : this.chattingView.isShown());
        x.i(str, str2, objArr);
        if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
            g.b(this);
        }
        if (this.chattingView != null && this.chattingView.getVisibility() != 8 && this.chattingFragmet != null) {
            x.i(TAG, "[closeChatting] needAnim:%s", new Object[]{Boolean.valueOf(z)});
            this.chattingView.setVisibility(8);
            this.mChattingClosed = true;
            if (this.mChattingOutAnim == null) {
                this.mChattingOutAnim = AnimationUtils.loadAnimation(this, MMFragmentActivity.a.tnF);
                this.mChattingOutAnim.setAnimationListener(new 9(this));
            }
            if (this.chattingFragmet.isSupportCustomActionBar()) {
                ImageView imageView = (ImageView) getWindow().getDecorView().findViewById(R.h.prepare_imageview);
                if (imageView != null && imageView.getVisibility() == 0) {
                    imageView.setVisibility(8);
                    x.i(TAG, "[closeChatting] prepareView GONE");
                    if (imageView.getTag() != null) {
                        ((View) imageView.getTag()).setVisibility(0);
                    }
                }
            }
            if (z) {
                this.chattingUIProxy.cpO();
                this.chattingUIProxy.cpP();
                this.chattingView.startAnimation(this.mChattingOutAnim);
            } else {
                this.chattingUIProxy.cpO();
                this.chattingUIProxy.cpP();
                this.chattingView.setVisibility(8);
                onSwipe(1.0f);
                tryResetChattingSwipeStatus();
            }
            if (!this.chattingFragmet.isSupportCustomActionBar()) {
                initActionBar();
            }
            supportInvalidateOptionsMenu();
            resumeMainFragment();
            com.tencent.mm.sdk.f.e.post(new 10(this), "directReport_closeChatting");
        }
    }

    private void initActionBar() {
        if (this.chattingFragmet == null || !this.chattingFragmet.bAG.eaR) {
            x.w(TAG, "[initActionBar] isChattingForeground False!");
            View inflate = com.tencent.mm.ui.y.gq(this).inflate(R.i.actionbar_custom_area, null);
            this.mActionBarHelper = new b(inflate);
            this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
            this.mActionBar.da();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.cZ();
            this.mActionBar.db();
            this.mActionBar.setCustomView(inflate);
            updateTitle();
            this.mActionBarHelper.b(new OnClickListener() {
                public final void onClick(View view) {
                    if (!BaseConversationUI.this.isAnimating) {
                        ah.M(BaseConversationUI.this.startChattingRunnable);
                        BaseConversationUI.this.finish();
                    }
                }
            });
            boolean z = ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).getBoolean("dark_actionbar", false);
            if (this.mActionBar.getCustomView() != null) {
                ImageView imageView = (ImageView) this.mActionBar.getCustomView().findViewById(R.h.arrow_area_btn);
                if (z) {
                    imageView.setColorFilter(-1, Mode.SRC_ATOP);
                }
                TextView textView = (TextView) this.mActionBar.getCustomView().findViewById(R.h.title_area);
                if (z) {
                    textView.setTextColor(getResources().getColor(R.e.white_text_color));
                    return;
                } else {
                    textView.setTextColor(getResources().getColor(R.e.black_text_color));
                    return;
                }
            }
            return;
        }
        x.w(TAG, "[initActionBar] isChattingForeground True!");
    }

    public void updateTitle() {
        if (this.mActionBarHelper != null) {
            this.mActionBarHelper.setTitle(r.gT(this.title));
        }
    }

    public void setTitle(String str) {
        this.title = str;
        if (this.mActionBarHelper != null) {
            updateTitle();
        }
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        if (this.chattingFragmet == null || this.chattingFragmet.csU() == null || !this.chattingFragmet.isSupportCustomActionBar() || com.tencent.mm.compatible.util.d.fT(22)) {
            return null;
        }
        ActionMode startActionMode = this.chattingFragmet.csU().startActionMode(callback);
        if (startActionMode != null) {
            return startActionMode;
        }
        return null;
    }

    private boolean acceptRequestCode(int i) {
        x.w(TAG, "check request code %d", new Object[]{Integer.valueOf(65535 & i)});
        switch (65535 & i) {
            case 217:
            case 218:
                return true;
            default:
                return false;
        }
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.lastRestoreTalker = bundle.getString(LAST_RESTORE_TALKER);
        x.d(TAG, "onRestoreInstantceState:%s", new Object[]{this.lastRestoreTalker});
    }

    protected void onSaveInstanceState(Bundle bundle) {
        if (this.chattingFragmet != null && !bi.oW(this.chattingFragmet.bAG.getTalkerUserName())) {
            x.d(TAG, "onSaveInstanceState:%s", new Object[]{this.chattingFragmet.bAG.getTalkerUserName()});
            bundle.putString(LAST_RESTORE_TALKER, this.chattingFragmet.bAG.getTalkerUserName());
        }
    }

    public void onSettle(boolean z, int i) {
        long j = 110;
        x.v(TAG, "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), this.launcherUIStatus});
        if (com.tencent.mm.compatible.util.d.fR(19) && com.tencent.mm.compatible.i.a.zX()) {
            View findViewById = findViewById(R.h.launcher_container);
            if (findViewById == null) {
                x.e(TAG, "[onSettle] null == container");
                return;
            }
            ImageView imageView = (ImageView) findViewById(R.h.prepare_imageview);
            if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null)) {
                imageView.setVisibility(0);
                x.i(TAG, "[onSettle] prepareView VISIBLE");
                findViewById.setVisibility(8);
            }
            if (imageView == null || imageView.getVisibility() != 0) {
                if (z) {
                    if (i <= 0) {
                        j = 220;
                    }
                    i.a(findViewById, j, 0.0f, 0.125f);
                    return;
                }
                if (i <= 0) {
                    j = 220;
                }
                i.a(findViewById, j, (float) ((findViewById.getWidth() * -1) / 4), 0.75f);
            } else if (z) {
                if (i <= 0) {
                    j = 220;
                }
                i.a(imageView, j, 0.0f, 0.125f);
            } else {
                if (i <= 0) {
                    j = 220;
                }
                i.a(imageView, j, (float) ((imageView.getWidth() * -1) / 4), 0.75f);
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        x.d(TAG, "chatting ui dispatch key event %s", new Object[]{keyEvent});
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ah.M(this.startChattingRunnable);
        }
        if (this.isAnimating) {
            return true;
        }
        if (this.chattingFragmet == null || !this.chattingFragmet.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    protected y getChattingUIFragment() {
        return new y();
    }

    private String getIdentityString() {
        if (this.chattingFragmet != null) {
            return this.chattingFragmet.getIdentityString();
        }
        return "";
    }
}
