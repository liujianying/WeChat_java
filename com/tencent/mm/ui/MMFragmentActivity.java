package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.m;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.w.a.h;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MMFragmentActivity extends ActionBarActivity implements com.tencent.mm.ui.widget.SwipeBackLayout.a, com.tencent.mm.ui.widget.g.a, com.tencent.mm.vending.e.b {
    public static final long DURATION = 220;
    private static final String TAG = "MicroMsg.MMFragmentActivity";
    String className;
    private a mActivityAnimStyle = new a();
    private View mContentViewForSwipeBack = null;
    private boolean mIsPaused;
    private com.tencent.mm.vending.a.a mLifeCycleKeeper = new com.tencent.mm.vending.a.a();
    private b mNfcFilterHelper;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean mSwiping;
    ArrayList<WeakReference<x>> record = new ArrayList();

    public static class a {
        public static int tnC;
        public static int tnD;
        public static int tnE;
        public static int tnF;
        public static int tnG = tnC;
        public static int tnH = tnD;
        public static int tnI = tnE;
        public static int tnJ = tnF;

        static {
            int i;
            int zX = com.tencent.mm.compatible.i.a.zX() & d.fR(19);
            tnC = zX != 0 ? com.tencent.mm.w.a.a.slide_right_in : com.tencent.mm.w.a.a.pop_in;
            tnD = zX != 0 ? com.tencent.mm.w.a.a.slide_left_out : com.tencent.mm.w.a.a.anim_not_change;
            tnE = zX != 0 ? com.tencent.mm.w.a.a.slide_left_in : com.tencent.mm.w.a.a.anim_not_change;
            if (zX != 0) {
                i = com.tencent.mm.w.a.a.slide_right_out;
            } else {
                i = com.tencent.mm.w.a.a.pop_out;
            }
            tnF = i;
        }

        public static void cqv() {
            u uVar = q.deR;
            boolean zP = u.zP();
            x.i(MMFragmentActivity.TAG, "lm: setAnimationStyle swipbackType = " + zP);
            if (zP) {
                boolean zX = com.tencent.mm.compatible.i.a.zX() & d.fR(19);
                x.i(MMFragmentActivity.TAG, "lm: setAnimationStyle supportSwipe = " + zX);
                tnC = zX ? com.tencent.mm.w.a.a.slide_right_in : com.tencent.mm.w.a.a.pop_in;
                tnD = zX ? com.tencent.mm.w.a.a.slide_left_out : com.tencent.mm.w.a.a.anim_not_change;
                tnE = zX ? com.tencent.mm.w.a.a.slide_left_in : com.tencent.mm.w.a.a.anim_not_change;
                tnF = zX ? com.tencent.mm.w.a.a.slide_right_out : com.tencent.mm.w.a.a.pop_out;
                tnG = tnC;
                tnH = tnD;
                tnI = tnE;
                tnJ = tnF;
            }
        }
    }

    private final class b {
        PendingIntent aJD;
        NfcAdapter tnK;
        IntentFilter[] tnL;
        String[][] tnM;

        private b() {
        }

        /* synthetic */ b(MMFragmentActivity mMFragmentActivity, byte b) {
            this();
        }

        final void init() {
            Intent intent = new Intent();
            intent.setClassName(ad.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            this.aJD = PendingIntent.getActivity(MMFragmentActivity.this, 0, intent, 0);
            try {
                new IntentFilter("android.nfc.action.NDEF_DISCOVERED").addDataType("*/*");
                new IntentFilter("android.nfc.action.TECH_DISCOVERED").addDataScheme("vnd.android.nfc");
                this.tnL = new IntentFilter[]{r0, r1, new IntentFilter("android.nfc.action.TAG_DISCOVERED")};
                String[][] strArr = new String[1][];
                strArr[0] = new String[]{NfcA.class.getName(), IsoDep.class.getName()};
                this.tnM = strArr;
            } catch (Throwable e) {
                throw new RuntimeException("fail", e);
            }
        }
    }

    public void keep(com.tencent.mm.vending.e.a aVar) {
        this.mLifeCycleKeeper.uPA.keep(aVar);
    }

    protected com.tencent.mm.vending.e.b theCreate() {
        return this.mLifeCycleKeeper.uPA;
    }

    protected com.tencent.mm.vending.e.b theResume() {
        return this.mLifeCycleKeeper.uPB;
    }

    protected com.tencent.mm.vending.e.b theStart() {
        return this.mLifeCycleKeeper.uPB;
    }

    public void onCreate(Bundle bundle) {
        this.className = getClass().getName();
        ai.ba(3, this.className);
        super.onCreate(bundle);
        this.mNfcFilterHelper = new b(this, (byte) 0);
        b bVar = this.mNfcFilterHelper;
        bVar.tnK = NfcAdapter.getDefaultAdapter(bVar.tnB);
        bVar.init();
    }

    public void onDestroy() {
        this.mLifeCycleKeeper.uPA.dead();
        super.onDestroy();
    }

    public void onStop() {
        this.mLifeCycleKeeper.uPC.dead();
        super.onStop();
    }

    public void onStart() {
        super.onStart();
    }

    public void onPause() {
        ai.ba(2, this.className);
        this.mIsPaused = true;
        super.onPause();
        if (isSupportNavigationSwipeBack()) {
            if (getSwipeBackLayout() != null) {
                getSwipeBackLayout().setEnableGesture(false);
            }
            if (!isFinishing()) {
                g.a(this);
            }
        }
        if (this.mNfcFilterHelper != null) {
            b bVar = this.mNfcFilterHelper;
            if (bVar.tnK != null) {
                try {
                    bVar.tnK.disableForegroundDispatch(bVar.tnB);
                } catch (IllegalStateException e) {
                    x.e(TAG, "lo-nfc-onPause: exp:" + e.getLocalizedMessage());
                }
            }
        }
        this.mLifeCycleKeeper.uPB.dead();
    }

    public void onResume() {
        ai.ba(1, this.className);
        this.mIsPaused = false;
        super.onResume();
        if (isSupportNavigationSwipeBack()) {
            g.b(this);
            onSwipe(1.0f);
            if (getSwipeBackLayout() != null) {
                getSwipeBackLayout().setEnableGesture(true);
                getSwipeBackLayout().uIg = false;
            }
        }
        if (this.mNfcFilterHelper != null) {
            b bVar = this.mNfcFilterHelper;
            if (bVar.tnK != null) {
                if (bVar.aJD == null || bVar.tnL == null || bVar.tnM == null) {
                    bVar.init();
                }
                try {
                    bVar.tnK.enableForegroundDispatch(bVar.tnB, bVar.aJD, bVar.tnL, bVar.tnM);
                } catch (IllegalStateException e) {
                    x.e(TAG, "lo-nfc-onResume: exp:" + e.getLocalizedMessage());
                }
            }
        }
    }

    public void switchFragmentInternalWithoutAnim(Fragment fragment) {
        if (fragment != null) {
            switchFragmentInternalWithoutAnim(fragment, fragment.getId());
        }
    }

    public void switchFragmentInternalWithoutAnim(Fragment fragment, int i) {
        switchFragment(fragment, i, false, false, 0, 0);
    }

    public void switchFragmentInternalFarwardWithAnim(Fragment fragment) {
        if (fragment != null) {
            switchFragmentInternalFarwardWithAnim(fragment, fragment.getId());
        }
    }

    public void switchFragmentInternalFarwardWithAnim(Fragment fragment, int i) {
        switchFragment(fragment, i, false, true, com.tencent.mm.w.a.a.slide_right_in, com.tencent.mm.w.a.a.slide_left_out);
    }

    public void switchFragmentInternalBackwardWithAnim(Fragment fragment) {
        switchFragmentInternalBackwardWithAnim(fragment, fragment.getId());
    }

    public void switchFragmentInternalBackwardWithAnim(Fragment fragment, int i) {
        switchFragment(fragment, i, false, true, com.tencent.mm.w.a.a.slide_left_in, com.tencent.mm.w.a.a.slide_right_out);
    }

    public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment fragment, View view) {
        if (fragment != null) {
            switchFragmentInternalBackwardWithAnimLeftSelfView(fragment, fragment.getId(), view);
        }
    }

    public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment fragment, int i, View view) {
        switchFragment(fragment, i, false, true, 0, com.tencent.mm.w.a.a.slide_right_out);
        if (view != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, com.tencent.mm.w.a.a.slide_left_in);
            if (loadAnimation != null) {
                view.startAnimation(loadAnimation);
            }
            view.setVisibility(0);
        }
    }

    public void switchFragmentActivity(Fragment fragment) {
        if (fragment != null) {
            switchFragmentActivity(fragment, fragment.getId());
        }
    }

    public void switchFragmentActivity(Fragment fragment, int i) {
        switchFragment(fragment, i, true, true, com.tencent.mm.w.a.a.pop_in, com.tencent.mm.w.a.a.pop_out);
        this.record.add(new WeakReference((x) fragment));
    }

    public boolean popBackStackImmediate() {
        if (this.record.size() == 0) {
            return false;
        }
        this.record.remove(this.record.size() - 1);
        return getSupportFragmentManager().popBackStackImmediate();
    }

    public void switchFragment(Fragment fragment, int i, boolean z, boolean z2, int i2, int i3) {
        if (fragment != null && i != 0) {
            m supportFragmentManager = getSupportFragmentManager();
            android.support.v4.app.q bk = supportFragmentManager.bk();
            if (z2) {
                bk.l(i2, i3);
            }
            if (supportFragmentManager.R(i) == null) {
                bk.a(i, fragment, fragment.getTag());
            } else if (fragment.isHidden()) {
                bk.b(fragment);
            }
            if (z) {
                bk.G(null);
            }
            bk.commit();
            supportFragmentManager.executePendingTransactions();
        }
    }

    public x getCurrentFragmet() {
        int size = this.record.size();
        if (size == 0) {
            return null;
        }
        x xVar = (x) ((WeakReference) this.record.get(size - 1)).get();
        if (xVar == null || !xVar.isShowing()) {
            return null;
        }
        return xVar;
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (VERSION.SDK_INT < 11) {
            super.onSaveInstanceState(bundle);
        }
    }

    public void putActivityOpenAnimation(int i, int i2) {
        if (enableActivityAnimation()) {
            a.tnG = i;
            a.tnH = i2;
        }
        super.overridePendingTransition(i, i2);
    }

    public void putActivityCloseAnimation(int i, int i2) {
        if (enableActivityAnimation()) {
            a.tnI = i;
            a.tnJ = i2;
        }
        super.overridePendingTransition(i, i2);
    }

    public final boolean enableActivityAnimation() {
        return true;
    }

    public void initActivityOpenAnimation(Intent intent) {
        if (enableActivityAnimation()) {
            ComponentName component = intent == null ? null : intent.getComponent();
            if (component != null) {
                Object obj;
                String className = component.getClassName().startsWith(component.getPackageName()) ? component.getClassName() : component.getPackageName() + component.getClassName();
                if ((com.tencent.mm.ui.base.b.ZX(className) & 2) == 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    super.overridePendingTransition(a.tnG, a.tnH);
                    return;
                }
                Object obj2;
                if ((com.tencent.mm.ui.base.b.ZX(className) & 4) != 0) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 == null) {
                    com.tencent.mm.ui.base.b.gD(this);
                } else {
                    com.tencent.mm.ui.base.b.gG(this);
                }
            }
        }
    }

    public void initActivityCloseAnimation() {
        Object obj = 1;
        if (enableActivityAnimation()) {
            if (((com.tencent.mm.ui.base.b.M(getClass()) & 2) == 0 ? 1 : null) != null) {
                super.overridePendingTransition(a.tnI, a.tnJ);
                return;
            }
            if ((com.tencent.mm.ui.base.b.M(getClass()) & 4) == 0) {
                obj = null;
            }
            if (obj == null) {
                com.tencent.mm.ui.base.b.gF(this);
            } else {
                com.tencent.mm.ui.base.b.gG(this);
            }
        }
    }

    public void finish() {
        super.finish();
        initActivityCloseAnimation();
    }

    @TargetApi(16)
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        if (!d.a(this, this.mIsPaused, intentArr, bundle)) {
            super.startActivities(intentArr, bundle);
            initActivityOpenAnimation(null);
        }
    }

    @TargetApi(11)
    public void startActivities(Intent[] intentArr) {
        super.startActivities(intentArr);
        initActivityOpenAnimation(null);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        initActivityOpenAnimation(intent);
    }

    @TargetApi(16)
    public void startActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
        initActivityOpenAnimation(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
        initActivityOpenAnimation(intent);
    }

    @TargetApi(16)
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!d.a(this, this.mIsPaused, new Intent[]{intent}, Integer.valueOf(i), bundle)) {
            super.startActivityForResult(intent, i, bundle);
            initActivityOpenAnimation(intent);
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        super.startActivityFromFragment(fragment, intent, i);
        initActivityOpenAnimation(intent);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (!d.a(this, this.mIsPaused, new Intent[]{intent}, fragment, Integer.valueOf(i))) {
            super.startActivityFromFragment(fragment, intent, i, bundle);
        }
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.mSwipeBackLayout;
    }

    public boolean isSwiping() {
        return this.mSwiping;
    }

    public final boolean isSupportNavigationSwipeBack() {
        if (d.fR(19) && com.tencent.mm.compatible.i.a.zX() && supportNavigationSwipeBack() && com.tencent.mm.ui.base.b.N(getClass())) {
            return true;
        }
        return false;
    }

    public boolean supportNavigationSwipeBack() {
        return true;
    }

    public boolean convertActivityFromTranslucent() {
        return true;
    }

    public boolean initNavigationSwipeBack() {
        if (d.fR(19)) {
            if (com.tencent.mm.ui.base.b.N(getClass()) && convertActivityFromTranslucent()) {
                ah.A(new Runnable() {
                    public final void run() {
                        com.tencent.mm.ui.base.b.Y(MMFragmentActivity.this);
                    }
                });
            } else {
                boolean z;
                if ((com.tencent.mm.ui.base.b.M(getClass()) & 16) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    ah.A(new Runnable() {
                        public final void run() {
                            com.tencent.mm.ui.base.b.Y(MMFragmentActivity.this);
                        }
                    });
                }
            }
        }
        if (!isSupportNavigationSwipeBack()) {
            return false;
        }
        initSwipeBack();
        return true;
    }

    public void initSwipeBack() {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        this.mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(this).inflate(h.swipeback_layout, viewGroup, false);
        this.mSwipeBackLayout.init();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setBackgroundDrawable(null);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(com.tencent.mm.w.a.d.transparent);
        viewGroup.removeView(viewGroup2);
        this.mSwipeBackLayout.addView(viewGroup2);
        this.mSwipeBackLayout.setContentView(viewGroup2);
        viewGroup.addView(this.mSwipeBackLayout);
        this.mSwipeBackLayout.setSwipeGestureDelegate(this);
    }

    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        if ("layout_inflater".equals(str)) {
            return y.b((LayoutInflater) systemService);
        }
        return systemService;
    }

    public Resources getResources() {
        if (getAssets() == null || ad.getResources() == null) {
            return super.getResources();
        }
        return ad.getResources();
    }

    public void onSwipe(float f) {
        x.v("ashutest", "ashutest::on swipe %f, duration %d", Float.valueOf(f), Long.valueOf(220));
        if (this.mContentViewForSwipeBack == null) {
            this.mContentViewForSwipeBack = ak.a(getWindow(), getSupportActionBar() != null ? getSupportActionBar().getCustomView() : null);
        }
        View view = this.mContentViewForSwipeBack;
        if (Float.compare(1.0f, f) <= 0) {
            i.n(view, 0.0f);
        } else {
            i.n(view, ((((float) view.getWidth()) / 2.5f) * (1.0f - f)) * -1.0f);
        }
    }

    public void onSettle(boolean z, int i) {
        long j = 110;
        x.v("ashutest", "ashutest:: on settle %B, speed %d", Boolean.valueOf(z), Integer.valueOf(i));
        if (this.mContentViewForSwipeBack == null) {
            this.mContentViewForSwipeBack = ak.a(getWindow(), getSupportActionBar().getCustomView());
        }
        View view = this.mContentViewForSwipeBack;
        if (z) {
            if (i <= 0) {
                j = 220;
            }
            i.a(view, j, 0.0f, null);
            return;
        }
        if (i <= 0) {
            j = 220;
        }
        i.a(view, j, ((float) (view.getWidth() * -1)) / 2.5f, null);
    }

    public void onSwipeBack() {
        if (!isFinishing()) {
            finish();
        }
        getWindow().getDecorView().setVisibility(8);
        overridePendingTransition(0, 0);
        this.mSwiping = false;
    }

    public void onCancel() {
        this.mSwiping = false;
    }

    public void onDrag() {
        this.mSwiping = true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isSupportNavigationSwipeBack() || keyEvent.getKeyCode() != 4 || !getSwipeBackLayout().ceH()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event");
        return true;
    }

    public boolean forceRemoveNoMatchOnPath() {
        return false;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getSupportActionBar() != null) {
            ViewGroup viewGroup = (ViewGroup) findViewById(com.tencent.mm.w.a.g.decor_content_parent);
            if (viewGroup != null) {
                View findViewById = viewGroup.findViewById(com.tencent.mm.w.a.g.action_bar);
                if (findViewById != null && (findViewById instanceof Toolbar)) {
                    Toolbar toolbar = (Toolbar) findViewById;
                    LayoutParams layoutParams = toolbar.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = com.tencent.mm.compatible.util.a.i(this);
                    }
                    toolbar.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void supportInvalidateOptionsMenu() {
        if (getCurrentFragmet() == null || !getCurrentFragmet().interceptSupportInvalidateOptionsMenu()) {
            super.supportInvalidateOptionsMenu();
        }
    }
}
