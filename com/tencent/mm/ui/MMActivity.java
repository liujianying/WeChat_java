package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.s.AnonymousClass3;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.tools.o;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;

@com.tencent.mm.ui.base.a(0)
public abstract class MMActivity extends MMFragmentActivity {
    private static String tlR;
    String className;
    public a geJ = null;
    public s mController = new s() {
        protected final int getLayoutId() {
            return MMActivity.this.getLayoutId();
        }

        protected final void dealContentView(View view) {
            MMActivity.this.dealContentView(view);
        }

        protected final String aYS() {
            return MMActivity.this.aYS();
        }

        protected final View getLayoutView() {
            return MMActivity.getLayoutView();
        }

        public final void onKeyboardStateChanged() {
            MMActivity.this.onKeyboardStateChanged();
        }

        protected final void onCreateBeforeSetContentView() {
            MMActivity.this.onCreateBeforeSetContentView();
        }

        protected final String getClassName() {
            return MMActivity.this.getClass().getName();
        }

        protected final boolean cpZ() {
            return MMActivity.this.cpZ();
        }

        public final boolean noActionBar() {
            return MMActivity.this.noActionBar();
        }

        public final boolean needShowIdcError() {
            return MMActivity.this.needShowIdcError();
        }
    };
    public boolean tlM = false;
    public boolean tlN = false;
    private ViewGroup tlO = null;
    public boolean tlP = false;
    private View tlQ;
    private long tlS = 0;
    private long tlT = 0;
    private long tlU = 0;

    public interface a {
        void b(int i, int i2, Intent intent);
    }

    public abstract int getLayoutId();

    @Deprecated
    public void initView() {
    }

    public final void setBackGroundColorResource(int i) {
        this.mController.setBackGroundColorResource(i);
    }

    public static Locale initLanguage(Context context) {
        return s.initLanguage(context);
    }

    public void onCreateBeforeSetContentView() {
    }

    public boolean cpZ() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.a(getApplicationContext(), (ActionBarActivity) this);
        x.i("MicroMsg.MMActivity", "checktask onCreate:%s#0x%x, taskid:%d, task:%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bi.fV(this));
        initNavigationSwipeBack();
    }

    public void dealContentView(View view) {
        setContentView(view);
    }

    public boolean noActionBar() {
        return false;
    }

    public void onKeyboardStateChanged() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (VERSION.SDK_INT < 11) {
            super.onSaveInstanceState(bundle);
        }
    }

    public final void setScreenEnable(boolean z) {
        this.mController.setScreenEnable(z);
    }

    public void ux(int i) {
        this.mController.contentView.setVisibility(i);
        if (i == 0) {
            this.mController.showTitleView();
        } else {
            this.mController.hideTitleView();
        }
    }

    public void onSwipeBack() {
        if (!Xf()) {
            this.mController.callBackMenu();
        }
        super.onSwipeBack();
    }

    public void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            if (this.tlN) {
                this.tlO = new b(this);
            } else {
                this.tlO = new FrameLayout(this);
            }
            this.tlO.addView(childAt, new LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.tlO);
            getSwipeBackLayout().setContentView(this.tlO);
        }
    }

    public boolean Xf() {
        return false;
    }

    public int getForceOrientation() {
        return -1;
    }

    public void ahy() {
        if (getForceOrientation() == -1) {
            this.tlM = getSharedPreferences(ad.chY(), 0).getBoolean("settings_landscape_mode", false);
            if (this.tlM) {
                setRequestedOrientation(-1);
                return;
            } else {
                setRequestedOrientation(1);
                return;
            }
        }
        setRequestedOrientation(getForceOrientation());
    }

    public void onStart() {
        ahy();
        super.onStart();
    }

    @TargetApi(17)
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.mController.onKeyUp(i, keyEvent)) {
            return z;
        }
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMActivity", e, "java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState", new Object[0]);
            return z;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mController.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean needShowIdcError() {
        return true;
    }

    public void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        ai.ba(1, this.className);
        super.onResume();
        x.v("MicroMsg.INIT", "KEVIN MMActivity super.onResume " + (System.currentTimeMillis() - currentTimeMillis));
        this.mController.onResume();
        x.v("MicroMsg.INIT", "KEVIN MMActivity onResume :%dms, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(hashCode()));
        if (this.tlT > this.tlS) {
            this.tlU += this.tlT - this.tlS;
        }
        this.tlS = bi.VG();
        this.tlT = 0;
    }

    public final void addDialog(Dialog dialog) {
        this.mController.addDialog(dialog);
    }

    public final ActionBarActivity cqa() {
        return this.mController.tml;
    }

    public void onDestroy() {
        x.i("MicroMsg.MMActivity", "checktask onDestroy:%s#0x%x task:%s ", getClass().getSimpleName(), Integer.valueOf(hashCode()), bi.fV(this));
        super.onDestroy();
        this.mController.onDestroy();
        this.tlP = true;
    }

    public static void cqb() {
        s.cqb();
    }

    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        ai.ba(2, this.className);
        super.onPause();
        this.mController.onPause();
        boolean isFinishing = isFinishing();
        x.v("MicroMsg.INIT", "KEVIN MMActivity onPause: %d ms, isFinishing %B, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(isFinishing), Integer.valueOf(hashCode()));
        this.tlT = bi.VG();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.mController.onCreateOptionsMenu(menu)) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.mController.onPrepareOptionsMenu(menu);
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mController.onOptionsItemSelected(menuItem);
    }

    public String aYS() {
        return "";
    }

    protected static View getLayoutView() {
        return null;
    }

    public final void fullScreenNoTitleBar(boolean z) {
        this.mController.fullScreenNoTitleBar(z);
    }

    public final void setTitleVisibility(int i) {
        this.mController.setTitleVisibility(i);
    }

    public void nS(int i) {
        s sVar = this.mController;
        if (sVar.mActionBar != null) {
            sVar.tmq.setTextColor(i);
        }
    }

    public void setMMTitle(String str) {
        this.mController.setMMTitle(str);
    }

    public final void M(CharSequence charSequence) {
        this.mController.M(charSequence);
    }

    public void setMMTitle(int i) {
        this.mController.setMMTitle(i);
    }

    public void setMMSubTitle(String str) {
        this.mController.setMMSubTitle(str);
    }

    public final void setMMSubTitle(int i) {
        this.mController.setMMSubTitle(i);
    }

    public final void DL(int i) {
        this.mController.tmq.setVisibility(i);
    }

    public final void cqc() {
        s sVar = this.mController;
        if (VERSION.SDK_INT >= 23) {
            View decorView = sVar.tml.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
        }
    }

    public final void DM(int i) {
        this.mController.setTitleLogo(0, i);
    }

    public final void showHomeBtn(boolean z) {
        this.mController.showHomeBtn(z);
    }

    public final void enableBackMenu(boolean z) {
        this.mController.enableBackMenu(z);
    }

    public final void enableOptionMenu(boolean z) {
        this.mController.c(true, -1, z);
    }

    public final void enableOptionMenu(int i, boolean z) {
        this.mController.c(false, i, z);
    }

    public final void showOptionMenu(boolean z) {
        this.mController.d(true, -1, z);
    }

    public final void showOptionMenu(int i, boolean z) {
        this.mController.d(false, i, z);
    }

    public final boolean cqd() {
        Iterator it = this.mController.tgz.iterator();
        while (it.hasNext()) {
            com.tencent.mm.ui.s.a aVar = (com.tencent.mm.ui.s.a) it.next();
            if (aVar.tgH == 0) {
                return aVar.bKe;
            }
        }
        return false;
    }

    public final boolean cqe() {
        Iterator it = this.mController.tgz.iterator();
        while (it.hasNext()) {
            com.tencent.mm.ui.s.a aVar = (com.tencent.mm.ui.s.a) it.next();
            if (aVar.tgH == 0) {
                return aVar.YN;
            }
        }
        return false;
    }

    public final void a(o oVar) {
        this.mController.addSearchMenu(true, oVar);
    }

    public void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addTextOptionMenu(i, str, onMenuItemClickListener);
    }

    public final void a(int i, String str, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        s sVar = this.mController;
        int i3 = s.b.tmW;
        com.tencent.mm.ui.s.a aVar = new com.tencent.mm.ui.s.a();
        aVar.tgH = i;
        aVar.text = str;
        aVar.textColor = i2;
        aVar.eOJ = onMenuItemClickListener;
        aVar.jcS = null;
        aVar.tmU = i3;
        sVar.DP(aVar.tgH);
        sVar.tgz.add(aVar);
        new ag().postDelayed(new Runnable() {
            public final void run() {
                s.this.supportInvalidateOptionsMenu();
            }
        }, 200);
    }

    public final void a(int i, String str, OnMenuItemClickListener onMenuItemClickListener, int i2) {
        this.mController.addTextOptionMenu$7df2a0ca(i, str, onMenuItemClickListener, null, i2);
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, onMenuItemClickListener);
    }

    public final void a(int i, String str, Drawable drawable, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.a(i, str, drawable, onMenuItemClickListener);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, i3, onMenuItemClickListener);
    }

    public final void updateOptionMenuText(int i, String str) {
        this.mController.updateOptionMenuText(i, str);
    }

    public final void a(OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.updateOptionMenuListener(1, onMenuItemClickListener, null);
    }

    public final void setTitleBarDoubleClickListener(Runnable runnable) {
        this.mController.setTitleBarDoubleClickListener(runnable);
    }

    public final void b(Runnable runnable, Runnable runnable2) {
        s sVar = this.mController;
        if (sVar.mActionBar != null) {
            sVar.mActionBar.getCustomView().setOnClickListener(new AnonymousClass3(runnable, runnable2));
        }
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.setBackBtn(onMenuItemClickListener, 0);
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener, int i) {
        this.mController.setBackBtn(onMenuItemClickListener, i);
    }

    public final void cqf() {
        s sVar = this.mController;
        if (sVar.tmt != null) {
            sVar.tmt.getDrawable().setColorFilter(-16777216, Mode.SRC_ATOP);
        }
    }

    public void lF(int i) {
        this.mController.lF(i);
        if (this.tlN && VERSION.SDK_INT >= 21 && getWindow() != null) {
            com.tencent.mm.ui.statusbar.a.c(this.mController.contentView, getWindow().getStatusBarColor(), d.c(getWindow()));
        }
    }

    public final void cqg() {
        s sVar = this.mController;
        if (sVar.aDx < sVar.tmy) {
            ValueAnimator duration = ValueAnimator.ofInt(new int[]{sVar.aDx, sVar.tmy}).setDuration(200);
            duration.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    s.this.DR(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            duration.start();
        }
    }

    public final void lC(boolean z) {
        s sVar = this.mController;
        sVar.mQO = z;
        sVar.cqt();
        sVar.cqs();
    }

    public final void DN(int i) {
        s sVar = this.mController;
        sVar.tmv = i;
        if (sVar.tmt != null) {
            sVar.tmt.setColorFilter(i, Mode.SRC_ATOP);
        }
        if (sVar.tmq != null && sVar.tmq.getVisibility() == 0) {
            sVar.tmq.setTextColor(i);
        }
        if (sVar.tmu != null && sVar.tmu.getVisibility() == 0) {
            sVar.tmu.setTextColor(i);
        }
        if (sVar.tgq != null && sVar.tgq.getVisibility() == 0) {
            sVar.tgq.getDrawable().setColorFilter(i, Mode.SRC_ATOP);
        } else if (sVar.tgs != null && sVar.tgs.getVisibility() == 0) {
            sVar.tgs.setTextColor(i);
        }
    }

    public final void aA(float f) {
        s sVar = this.mController;
        if (sVar.tmq != null) {
            sVar.tmq.setAlpha(f);
        }
    }

    public final void cqh() {
        s sVar = this.mController;
        if (VERSION.SDK_INT >= 21) {
            sVar.getSupportActionBar().setElevation(0.0f);
        }
    }

    public final void lD(boolean z) {
        s sVar = this.mController;
        if (sVar.tmt == null) {
            return;
        }
        if (z) {
            sVar.tmt.setVisibility(0);
        } else {
            sVar.tmt.setVisibility(8);
        }
    }

    public final boolean removeOptionMenu(int i) {
        return this.mController.removeOptionMenu(i);
    }

    public final void setTitleMuteIconVisibility(int i) {
        this.mController.setTitleMuteIconVisibility(i);
    }

    public void YC() {
        this.mController.hideVKB();
    }

    public void hideVKB(View view) {
        this.mController.hideVKB(view);
    }

    public void showVKB() {
        this.mController.showVKB();
    }

    public static void showVKB(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void finish() {
        super.finish();
        int a = s.a(getIntent(), x.FLAG_OVERRIDE_ENTER_ANIMATION, -1);
        int a2 = s.a(getIntent(), x.FLAG_OVERRIDE_EXIT_ANIMATION, -1);
        if (a != -1) {
            super.overridePendingTransition(a, a2);
        }
    }

    public final void L(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }

    public final void a(Class<?> cls, Intent intent) {
        intent.setClass(this, cls);
        startActivity(intent);
    }

    public final void b(a aVar, Intent intent, int i) {
        this.geJ = aVar;
        startActivityForResult(intent, i);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.geJ != null) {
            this.geJ.b(i, i2, intent);
        }
        this.geJ = null;
    }

    public final void cqi() {
        s sVar = this.mController;
        sVar.tmt.setVisibility(8);
        sVar.tms.setVisibility(8);
    }

    public final void cqj() {
        int i = 0;
        if (gn(this.mController.tml)) {
            int i2;
            if (this.tlQ == null) {
                this.tlQ = new View(this.mController.tml);
                ((ViewGroup) getWindow().getDecorView()).addView(this.tlQ);
            }
            Context context = this.mController.tml;
            Resources resources = context.getResources();
            if (resources.getConfiguration().orientation == 1) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (VERSION.SDK_INT >= 14 && gn(context)) {
                i2 = resources.getIdentifier(i2 != 0 ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", "android");
                if (i2 > 0) {
                    i = resources.getDimensionPixelSize(i2);
                }
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, i);
            layoutParams.gravity = 80;
            this.tlQ.setLayoutParams(layoutParams);
            this.tlQ.setBackgroundColor(-637534208);
            this.tlQ.setVisibility(8);
            return;
        }
        x.w("MicroMsg.MMActivity", "has not NavigationBar!");
    }

    public final void DO(int i) {
        if (this.tlQ != null) {
            this.tlQ.setVisibility(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                tlR = (String) declaredMethod.invoke(null, new Object[]{"qemu.hw.mainkeys"});
            } catch (Throwable th) {
                tlR = null;
            }
        }
    }

    public static boolean gn(Context context) {
        Resources resources = context.getResources();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            if ("1".equals(tlR)) {
                z = false;
            } else if ("0".equals(tlR)) {
                z = true;
            }
            if (!z || deviceHasKey || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                return false;
            }
            return true;
        } else if (ViewConfiguration.get(context).hasPermanentMenuKey() || deviceHasKey) {
            return false;
        } else {
            return true;
        }
    }

    public final String cqk() {
        String str = "";
        ComponentName callingActivity = getCallingActivity();
        if (callingActivity != null) {
            str = callingActivity.getPackageName();
            x.i("MicroMsg.MMActivity", "get calling activity, %s", str);
        }
        String str2 = str;
        if (bi.oW(str2) && VERSION.SDK_INT >= 22) {
            try {
                Object obj = new c(this, "mReferrer", null).get();
                if (obj != null) {
                    str = (String) obj;
                } else {
                    str = str2;
                }
                str2 = str;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMActivity", e, "get mReferrer error", new Object[0]);
            }
        }
        if (!bi.oW(str2) || VERSION.SDK_INT < 22) {
            return str2;
        }
        Uri referrer = getReferrer();
        if (referrer == null) {
            return str2;
        }
        x.i("MicroMsg.MMActivity", "get referrer, %s", referrer.getAuthority());
        return referrer.getAuthority();
    }

    public final long cql() {
        long j;
        if (this.tlT != 0) {
            j = (this.tlT - this.tlS) + this.tlU;
        } else {
            j = (bi.VG() - this.tlS) + this.tlU;
        }
        if (j < 0) {
            x.w("MicroMsg.MMActivity", "%d get activity browse time is error, may be something warn here.[%d %d %d %d]", Integer.valueOf(hashCode()), Long.valueOf(j), Long.valueOf(this.tlS), Long.valueOf(this.tlT), Long.valueOf(this.tlU));
        }
        x.v("MicroMsg.MMActivity", "%d get activity browse time [%d]", Integer.valueOf(hashCode()), Long.valueOf(j));
        return j;
    }
}
