package com.tencent.mm.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.LauncherUI.a;
import com.tencent.mm.ui.LauncherUI.b;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.aa;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.y;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.i;

public final class ac implements a {
    boolean isAnimating = false;
    boolean mChattingClosed = true;
    Animation mChattingInAnim;
    Animation mChattingOutAnim;
    boolean mNeedChattingAnim;
    Bitmap mPrepareBitmap;
    MMFragmentActivity nfG;
    OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a() {
        long start = 0;

        public final void cqO() {
            if (ac.this.mChattingInAnim == null) {
                ac.this.mChattingInAnim = AnimationUtils.loadAnimation(ac.this.nfG, MMFragmentActivity.a.tnC);
                ac.this.mChattingInAnim.setAnimationListener(new 1(this));
            }
            if (ac.this.mNeedChattingAnim) {
                ac.this.tpg.setOndispatchDraw(new 2(this));
                ac.this.mNeedChattingAnim = false;
            } else {
                ac.a(ac.this);
                ac.b(ac.this);
            }
            ac.this.tpj.tAR = null;
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem CHATTING ONLAYOUT ");
        }
    };
    b tpe;
    long tpf = 0;
    TestTimeForChatting tpg;
    private int tph;
    IdleHandler tpi;
    OnLayoutChangedLinearLayout tpj;
    String tpk;
    String tpl;
    Bundle tpm;
    e tpn;
    n tpo;
    a tpp = new a(this, (byte) 0);
    Runnable tpq = new 4(this);

    static /* synthetic */ void a(ac acVar) {
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[doJobOnChattingAnimStart]");
        acVar.isAnimating = true;
        if (acVar.tpg != null) {
            acVar.tpg.setTranslationX(0.0f);
            acVar.tpg.dtL = 0;
        }
    }

    static /* synthetic */ void a(ac acVar, Intent intent, boolean z) {
        boolean z2;
        long currentTimeMillis = System.currentTimeMillis();
        if (acVar.tpn == null) {
            acVar.tpn = new y();
            acVar.tpo = new aa(acVar.nfG, acVar.tpn);
            z2 = true;
        } else {
            z2 = false;
        }
        final int[] iArr;
        View cqN;
        final ViewGroup viewGroup;
        int i;
        if (acVar.tpg == null) {
            if (acVar.tpn.isSupportCustomActionBar()) {
                iArr = new int[2];
                acVar.nfG.getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                TestTimeForChatting testTimeForChatting = new TestTimeForChatting(acVar.nfG);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                testTimeForChatting.setId(R.h.chatting_custom_container);
                acVar.tph = testTimeForChatting.getId();
                testTimeForChatting.setOrientation(1);
                testTimeForChatting.setLayoutParams(layoutParams);
                final FitSystemWindowLayoutView fitSystemWindowLayoutView = new FitSystemWindowLayoutView(acVar.nfG);
                fitSystemWindowLayoutView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                cqN = acVar.cqN();
                if (cqN == null) {
                    cqN = ((ViewGroup) acVar.nfG.getWindow().getDecorView()).getChildAt(0);
                }
                View imageView = new ImageView(acVar.nfG);
                imageView.setId(R.h.prepare_imageview);
                imageView.setLayoutParams(testTimeForChatting.getLayoutParams());
                imageView.setVisibility(8);
                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[createChattingView] prepareView GONE");
                viewGroup = (ViewGroup) cqN;
                ((ViewGroup) acVar.nfG.getWindow().getDecorView()).removeView(cqN);
                cqN.setId(R.h.launcher_container);
                fitSystemWindowLayoutView.addView(cqN);
                fitSystemWindowLayoutView.addView(imageView);
                fitSystemWindowLayoutView.addView(testTimeForChatting);
                ((ViewGroup) acVar.nfG.getWindow().getDecorView()).addView(fitSystemWindowLayoutView);
                acVar.nfG.getWindow().getDecorView().requestFitSystemWindows();
                i = iArr[1];
                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::fitSystemWindows. statusBarHeight:%d", new Object[]{Integer.valueOf(i)});
                if (i > 0) {
                    acVar.tpe.a(fitSystemWindowLayoutView, new Rect(0, i, 0, 0), viewGroup);
                } else {
                    acVar.nfG.getSupportActionBar().getCustomView().post(new Runnable() {
                        public final void run() {
                            ac.this.nfG.getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                            int i = iArr[1];
                            if (i > 0) {
                                ac.this.tpe.a(fitSystemWindowLayoutView, new Rect(0, i, 0, 0), viewGroup);
                            } else if (d.fR(20)) {
                                fitSystemWindowLayoutView.setOnApplyWindowInsetsListener(new 1(this));
                            }
                        }
                    });
                }
                acVar.tpg = (TestTimeForChatting) acVar.nfG.findViewById(acVar.tph);
                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment init chattingView, top %s", new Object[]{Integer.valueOf(iArr[1])});
            } else {
                x.w("MicroMsg.LauncherUI.NewChattingTabUI", "[createChattingView] is not SupportCustomActionBar %s", new Object[]{Boolean.valueOf(com.tencent.mm.compatible.i.a.zX())});
                acVar.tpg = (TestTimeForChatting) acVar.nfG.findViewById(R.h.chatting_area);
                acVar.tph = acVar.tpg.getId();
            }
        } else if (acVar.tpn.isSupportCustomActionBar()) {
            iArr = new int[2];
            acVar.tpg.getLocationInWindow(iArr);
            if (iArr[1] == 0) {
                viewGroup = (ViewGroup) acVar.nfG.getWindow().getDecorView();
                i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= viewGroup.getChildCount()) {
                        break;
                    }
                    cqN = ((ViewGroup) acVar.nfG.getWindow().getDecorView()).getChildAt(i2);
                    if (cqN instanceof FitSystemWindowLayoutView) {
                        acVar.nfG.getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                        FitSystemWindowLayoutView fitSystemWindowLayoutView2 = (FitSystemWindowLayoutView) cqN;
                        ViewGroup viewGroup2 = (ViewGroup) acVar.nfG.findViewById(R.h.launcher_container);
                        i2 = viewGroup2.getPaddingTop();
                        int ap = s.ap(acVar.nfG, -1);
                        Rect rect = new Rect();
                        Window window = acVar.nfG.getWindow();
                        window.getDecorView().getWindowVisibleDisplayFrame(rect);
                        int height = window.getDecorView().getHeight();
                        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "rootLayout2 fitSystemWindows detect: ActionBar's CustomView location[1]:%d, paddingTop:%d getStatusBarHeight():%d, heightFromSysR:%d, rectangle.top:%d, rectangle.height:%d, DecorHeight:%d, cacheInsetsTop:%d", new Object[]{Integer.valueOf(iArr[1]), Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.pluginsdk.e.eL(acVar.nfG)), Integer.valueOf(ap), Integer.valueOf(rect.top), Integer.valueOf(rect.height()), Integer.valueOf(height), Integer.valueOf(fitSystemWindowLayoutView2.getCacheInsetsTop())});
                        fitSystemWindowLayoutView2.fitSystemWindows(new Rect(0, fitSystemWindowLayoutView2.getCacheInsetsTop(), 0, 0));
                        ImageView imageView2 = (ImageView) fitSystemWindowLayoutView2.findViewById(R.h.prepare_imageview);
                        imageView2.setTag(viewGroup2);
                        imageView2.setLayoutParams(viewGroup2.getLayoutParams());
                        Bitmap magicDrawingCache = acVar.getMagicDrawingCache(viewGroup2);
                        if (magicDrawingCache != null) {
                            imageView2.setImageBitmap(magicDrawingCache);
                            viewGroup2.setVisibility(8);
                            imageView2.setVisibility(0);
                            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[prepareChattingFragment] prepareView VISIBLE");
                        } else {
                            viewGroup2.setVisibility(0);
                            imageView2.setVisibility(8);
                            imageView2.setImageDrawable(null);
                            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[prepareChattingFragment] prepareView GONE");
                        }
                    } else {
                        ImageView imageView3 = (ImageView) cqN.findViewById(R.h.prepare_imageview);
                        if (imageView3 != null) {
                            imageView3.setImageDrawable(null);
                        }
                        String str = "MicroMsg.LauncherUI.NewChattingTabUI";
                        String str2 = "on position %d, rootLayout not found! prepareView is null?%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(i2);
                        objArr[1] = Boolean.valueOf(imageView3 == null);
                        x.e(str, str2, objArr);
                        i = i2 + 1;
                    }
                }
            }
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment has chattingView, top %s", new Object[]{Integer.valueOf(iArr[1])});
        }
        if (intent != null) {
            acVar.tpn.getArguments().putAll(com.tencent.mm.sdk.platformtools.s.aq(intent));
        }
        if (z2) {
            acVar.tpo.aj(acVar.tph, z);
            acVar.tpj = (OnLayoutChangedLinearLayout) acVar.tpn.getView().findViewById(R.h.chatting_bg_ll);
        } else {
            acVar.tpo.cpM();
        }
        if (acVar.tpn.isSupportNavigationSwipeBack()) {
            acVar.tpn.getSwipeBackLayout().setNeedRequestActivityTranslucent(false);
        }
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z2), intent});
    }

    static /* synthetic */ void b(ac acVar) {
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[doJobOnChattingAnimEnd]");
        acVar.isAnimating = false;
        if (acVar.tpg != null) {
            acVar.tpg.postDelayed(new 7(acVar), 60);
        }
    }

    public ac(b bVar) {
        this.tpe = bVar;
    }

    public final void startChatting(String str, Bundle bundle, boolean z) {
        String str2 = "MicroMsg.LauncherUI.NewChattingTabUI";
        String str3 = "try startChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.tpg == null ? false : this.tpg.isShown());
        x.i(str2, str3, objArr);
        if (!(this.tpn == null || this.tpn.getView() == null)) {
            this.tpn.getView().setImportantForAccessibility(1);
        }
        au.getNotification().aR(false);
        this.tpm = bundle;
        this.tpl = str;
        this.mNeedChattingAnim = z;
        au.Em().cii();
        ah.Db(-8);
        ah.A(this.tpq);
    }

    private ViewGroup cqN() {
        ViewParent parent = this.nfG.getSupportActionBar().getCustomView().getParent();
        ViewParent viewParent = null;
        ViewParent decorView = this.nfG.getWindow().getDecorView();
        while (parent != decorView && parent != null) {
            viewParent = parent;
            parent = parent.getParent();
        }
        return (ViewGroup) viewParent;
    }

    public final boolean cpW() {
        return this.tpn == null ? false : this.tpn.bAG.eaR;
    }

    final boolean bWY() {
        if (d.fR(19) && com.tencent.mm.compatible.i.a.zX() && !com.tencent.mm.compatible.f.b.bt(this.nfG)) {
            return true;
        }
        return false;
    }

    final void kB(int i) {
        if (this.tpn != null) {
            com.tencent.mm.modelstat.d.b(i, "ChattingUI" + getIdentityString(), hashCode());
            if (i == 4) {
                com.tencent.mm.modelstat.d.h("ChattingUI" + getIdentityString(), this.tpf, ai.VE());
            }
        }
    }

    public final Bitmap getMagicDrawingCache(View view) {
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
            x.e("MicroMsg.LauncherUI.NewChattingTabUI", "viewWidth:%s viewHeight:%s", new Object[]{Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)});
            return null;
        } else if (this.tpn.getView() == null) {
            return null;
        } else {
            if (this.tpn != null) {
                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "getBottom:%s keyboardState:%s", new Object[]{Integer.valueOf(this.tpn.getView().getBottom()), Integer.valueOf(this.tpn.keyboardState())});
            }
            if (this.tpn == null || this.tpn.getView().getBottom() <= 0 || (this.tpn.keyboardState() != 1 && this.tpn.getView().getBottom() >= (this.nfG.getResources().getDisplayMetrics().heightPixels * 2) / 3)) {
                if (this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled() || this.mPrepareBitmap.getWidth() != measuredWidth || this.mPrepareBitmap.getHeight() != measuredHeight) {
                    if (!(this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled())) {
                        this.mPrepareBitmap.recycle();
                    }
                    try {
                        this.mPrepareBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_4444);
                    } catch (OutOfMemoryError e) {
                        x.e("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] e:%s", new Object[]{e});
                        return null;
                    }
                }
                this.mPrepareBitmap.eraseColor(0);
                Canvas canvas = new Canvas(this.mPrepareBitmap);
                width = (int) this.nfG.getResources().getDimension(R.f.wechat_abc_action_bar_default_height);
                int dimension = (int) this.nfG.getResources().getDimension(R.f.DefaultTabbarHeight);
                Paint paint = new Paint();
                paint.setColor(-1);
                canvas.drawRect(0.0f, (float) width, (float) measuredWidth, (float) (measuredHeight - dimension), paint);
                view.draw(canvas);
                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] cost%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                return this.mPrepareBitmap;
            }
            x.e("MicroMsg.LauncherUI.NewChattingTabUI", "hardKeyboardHidden:%s", new Object[]{Integer.valueOf(this.tpn.keyboardState())});
            this.nfG.getWindow().setBackgroundDrawableResource(R.e.room_info_comment_layout_bg);
            return null;
        }
    }

    final void tryResetChattingSwipeStatus() {
        boolean z = true;
        if (bWY()) {
            String str = "MicroMsg.LauncherUI.NewChattingTabUI";
            String str2 = "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.tpn != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (this.tpn != null) {
                this.tpn.getSwipeBackLayout().uIg = false;
            }
        }
    }

    public final boolean v(boolean z, int i) {
        long j = 110;
        x.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(this.tpe.cpA())});
        if (!bWY()) {
            return true;
        }
        if (!this.tpe.cpA()) {
            return false;
        }
        View findViewById = this.nfG.findViewById(R.h.launcher_container);
        if (findViewById == null) {
            x.e("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] null == container");
            return true;
        }
        ImageView imageView = (ImageView) this.nfG.findViewById(R.h.prepare_imageview);
        if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null)) {
            imageView.setVisibility(0);
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] prepareView VISIBLE");
            findViewById.setVisibility(8);
        }
        if (imageView == null || imageView.getVisibility() != 0) {
            int width = findViewById.getWidth() == 0 ? this.nfG.getResources().getDisplayMetrics().widthPixels : findViewById.getWidth();
            if (z) {
                if (i <= 0) {
                    j = 220;
                }
                i.a(findViewById, j, 0.0f, 0.125f);
            } else {
                if (i <= 0) {
                    j = 220;
                }
                i.a(findViewById, j, ((float) (width * -1)) / 2.5f, 0.75f);
            }
        } else {
            int width2 = imageView.getWidth() == 0 ? this.nfG.getResources().getDisplayMetrics().widthPixels : imageView.getWidth();
            if (z) {
                if (i <= 0) {
                    j = 220;
                }
                i.a(imageView, j, 0.0f, 0.125f);
            } else {
                if (i <= 0) {
                    j = 220;
                }
                i.a(imageView, j, ((float) (width2 * -1)) / 2.5f, 0.75f);
            }
        }
        return true;
    }

    private String getIdentityString() {
        if (this.tpn != null) {
            return this.tpn.getIdentityString();
        }
        return "";
    }
}
