package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.support.v4.view.m;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.j;
import com.tencent.mm.w.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public abstract class s {
    public static final int tmE = h.actionbar_title_single_text;
    private static byte[] tmH = new byte[]{(byte) 0};
    private static boolean tmo = false;
    private static WakeLock wakeLock = null;
    public int aDx = this.tmy;
    String className;
    public View contentView;
    private o eMS;
    private LayoutInflater eMa;
    AudioManager eoL;
    private int jCR = 0;
    public ActionBar mActionBar;
    public Context mContext;
    public boolean mQO = false;
    protected ag msM = new ag(Looper.getMainLooper());
    private final long oco = 300;
    private long ocp = SystemClock.elapsedRealtime();
    private View ofX;
    private int tgp = 0;
    ImageButton tgq;
    TextView tgs;
    LinkedList<a> tgz = new LinkedList();
    protected boolean tlM = false;
    private View tlW;
    public View tlX;
    View tlY;
    private TextView tlZ;
    private int tmA = 0;
    private boolean tmB = false;
    private c tmC = new c<ry>() {
        {
            this.sFo = ry.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.g.a.ry.a aVar = ((ry) bVar).ccN;
            if (aVar.bHC == 2) {
                String str = aVar.bHF;
                int i = aVar.position;
                x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE callback position[%d] noticeId[%s]", Integer.valueOf(i), str);
                if (i <= 0 || i == s.this.tmA) {
                    s.this.a(aVar.bHE, aVar.YN, aVar.url, aVar.desc, str, i, false);
                } else {
                    x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE callback position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(s.this.tmA));
                }
            }
            return false;
        }
    };
    private int tmD = h.actionbar_title;
    private int tmF = -1;
    public int tmG = 0;
    private a tmI;
    private MenuItem tmJ;
    private Runnable tmK = new Runnable() {
        public final void run() {
            s.this.tml.getWindow().setFlags(1024, 1024);
            if (s.this.mActionBar != null) {
                s.this.mActionBar.hide();
            }
        }
    };
    private Runnable tmL = new Runnable() {
        public final void run() {
            if (s.this.mActionBar != null) {
                s.this.mActionBar.show();
            }
        }
    };
    FrameLayout tma;
    public boolean tmb = true;
    private String tmc = " ";
    private int tmd = 0;
    private int tme = 0;
    private com.tencent.mm.ui.widget.a tmf = null;
    private com.tencent.mm.ui.widget.a tmg = null;
    private com.tencent.mm.ui.widget.a tmh = null;
    private com.tencent.mm.ui.widget.a tmi = null;
    private boolean tmj = false;
    boolean tmk = false;
    public ActionBarActivity tml;
    private boolean tmm;
    private a tmn = new a();
    private ArrayList<Dialog> tmp;
    public TextView tmq;
    private View tmr;
    View tms;
    public ImageView tmt;
    TextView tmu;
    int tmv = 0;
    private ImageView tmw;
    private LayoutParams tmx;
    int tmy;
    private int tmz;

    /* renamed from: com.tencent.mm.ui.s$3 */
    class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ Runnable tmO;
        final /* synthetic */ Runnable tmP;

        AnonymousClass3(Runnable runnable, Runnable runnable2) {
            this.tmO = runnable;
            this.tmP = runnable2;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - s.this.ocp < 300) {
                if (this.tmO != null) {
                    this.tmO.run();
                }
            } else if (this.tmP != null) {
                this.tmP.run();
            }
            s.this.ocp = SystemClock.elapsedRealtime();
        }
    }

    public static final class a {
        boolean YN = true;
        boolean bKe = true;
        OnMenuItemClickListener eOJ;
        OnLongClickListener jcS;
        String text;
        int textColor;
        int tgH = -1;
        int tgI;
        View tgJ;
        View tgK;
        Drawable tmT;
        int tmU = b.tmW;
        boolean tmV = false;
    }

    public enum b {
        ;

        static {
            tmW = 1;
            tmX = 2;
            tmY = 3;
            tmZ = 4;
            tna = 5;
            tnb = 6;
            tnc = 7;
            tnd = 8;
            tne = 9;
            tnf = 10;
            tng = 11;
            tnh = new int[]{tmW, tmX, tmY, tmZ, tna, tnb, tnc, tnd, tne, tnf, tng};
        }
    }

    protected abstract String aYS();

    protected abstract boolean cpZ();

    protected abstract void dealContentView(View view);

    protected abstract String getClassName();

    protected abstract int getLayoutId();

    protected abstract View getLayoutView();

    protected abstract void onCreateBeforeSetContentView();

    public abstract void onKeyboardStateChanged();

    static /* synthetic */ boolean f(s sVar) {
        return (sVar.tml.getWindow().getAttributes().flags & 1024) != 0;
    }

    static /* synthetic */ void g(s sVar) {
        sVar.tmG = 2;
        sVar.onKeyboardStateChanged();
    }

    static /* synthetic */ void h(s sVar) {
        sVar.tmG = 1;
        sVar.onKeyboardStateChanged();
    }

    private void a(int i, final boolean z, final String str, final String str2, final String str3, final int i2, boolean z2) {
        x.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), str3, Integer.valueOf(i2), this.tlY);
        if (!needShowIdcError()) {
            return;
        }
        if (!z && this.tlY == null) {
            return;
        }
        if (this.mActionBar == null || this.mActionBar.isShowing()) {
            if (this.tma == null) {
                this.tma = (FrameLayout) this.contentView.findViewById(g.mm_content_fl);
            }
            if (this.tlY != null) {
                this.tma.removeView(this.tlY);
            }
            int i3 = h.mmnotify_view;
            if (i <= 0) {
                i = i3;
            }
            this.tlY = this.eMa.inflate(i, null);
            this.tlZ = (TextView) this.tlY.findViewById(g.notify_text);
            this.tlY.findViewById(g.notify_btn).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.sdk.b.b ahVar = new ah();
                    ahVar.bHy.type = 1;
                    ahVar.bHy.bHA = str3;
                    ahVar.bHy.position = i2;
                    com.tencent.mm.sdk.b.a.sFg.m(ahVar);
                    s.this.tlY.setVisibility(8);
                }
            });
            this.tlY.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (str != null) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        s.this.mContext.startActivity(intent);
                    }
                }
            });
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.tmB && VERSION.SDK_INT >= 16) {
                layoutParams.setMargins(0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.tml, 48.0f), 0, 0);
                x.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", Integer.valueOf(layoutParams.height), Integer.valueOf(layoutParams.topMargin));
            }
            this.tma.addView(this.tlY, this.tma.getChildCount(), layoutParams);
            if (this.tlY == null) {
                return;
            }
            if (z2) {
                CharSequence str22;
                this.tlY.setVisibility(z ? 0 : 8);
                String string = this.mContext.getString(k.idc_url);
                if (bi.oW(str22)) {
                    str22 = this.mContext.getString(k.disaster_default_tips_default);
                }
                if (str != null) {
                    CharSequence spannableString = new SpannableString(str22 + string);
                    spannableString.setSpan(new ForegroundColorSpan(-10119449), str22.length(), string.length() + str22.length(), 33);
                    this.tlZ.setText(spannableString);
                } else {
                    x.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
                    this.tlZ.setText(str22);
                }
                this.tlY.invalidate();
                this.tma.invalidate();
                return;
            }
            this.tlY.post(new Runnable() {
                public final void run() {
                    s.this.tlY.setVisibility(z ? 0 : 8);
                    String string = s.this.mContext.getString(k.idc_url);
                    CharSequence string2 = bi.oW(str22) ? s.this.mContext.getString(k.disaster_default_tips_default) : str22;
                    if (str != null) {
                        CharSequence spannableString = new SpannableString(string2 + string);
                        spannableString.setSpan(new ForegroundColorSpan(-10119449), string2.length(), string2.length() + string.length(), 33);
                        s.this.tlZ.setText(spannableString);
                    } else {
                        x.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
                        s.this.tlZ.setText(string2);
                    }
                    s.this.tlY.invalidate();
                    s.this.tma.invalidate();
                }
            });
            return;
        }
        x.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
    }

    private View findViewById(int i) {
        View findViewById = this.contentView.findViewById(i);
        return findViewById != null ? findViewById : this.tml.findViewById(i);
    }

    public final void setBackGroundColorResource(int i) {
        if (this.contentView != null) {
            if (this.tma == null) {
                this.tma = (FrameLayout) this.contentView.findViewById(g.mm_content_fl);
            }
            this.tma.setBackgroundResource(i);
            this.tlX.setBackgroundResource(i);
        }
    }

    public final void ak(int i, boolean z) {
        this.tmA = i;
        this.tmB = z;
    }

    public static Locale initLanguage(Context context) {
        return bw(context, w.d(context.getSharedPreferences(ad.chY(), 0)));
    }

    public static Locale bw(Context context, String str) {
        if (str.equals("language_default")) {
            w.a(context, Locale.ENGLISH);
            return Locale.getDefault();
        }
        Locale Wl = w.Wl(str);
        w.a(context, Wl);
        return Wl;
    }

    public ActionBar getSupportActionBar() {
        return this.tml.getSupportActionBar();
    }

    public final void a(Context context, ActionBarActivity actionBarActivity) {
        this.mContext = actionBarActivity;
        this.tml = actionBarActivity;
        boolean z = ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).getBoolean("dark_actionbar_init", false);
        boolean z2 = ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).getBoolean("dark_actionbar", false);
        if (!(z || z2)) {
            ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).edit().putBoolean("dark_actionbar", true).commit();
            ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).edit().putBoolean("dark_actionbar_init", true).commit();
        }
        onCreateBeforeSetContentView();
        this.className = getClass().getName();
        ai.ba(3, this.className);
        initLanguage(context);
        this.eoL = (AudioManager) this.mContext.getSystemService("audio");
        int layoutId = getLayoutId();
        this.eMa = LayoutInflater.from(this.mContext);
        this.contentView = com.tencent.mm.kiss.a.b.EY().a(actionBarActivity, "R.layout.mm_activity", h.mm_activity);
        this.tlW = this.contentView.findViewById(g.mm_trans_layer);
        this.tma = (FrameLayout) this.contentView.findViewById(g.mm_content_fl);
        this.jCR = this.mContext.getResources().getDimensionPixelSize(e.SmallBtnPadding);
        if (layoutId != -1) {
            this.tlX = getLayoutView();
            if (this.tlX == null) {
                this.tlX = this.eMa.inflate(getLayoutId(), null);
            } else if (this.tlX.getParent() != null) {
                ((ViewGroup) this.tlX.getParent()).removeView(this.tlX);
            }
            this.tma.addView(this.tlX, 0);
        }
        dealContentView(this.contentView);
        if (cpZ()) {
            int dimensionPixelSize;
            ak.d(ak.a(this.tml.getWindow(), this.tlX), this.tlX);
            ((ViewGroup) this.tlX.getParent()).removeView(this.tlX);
            ((ViewGroup) this.tml.getWindow().getDecorView()).addView(this.tlX, 0);
            layoutId = com.tencent.mm.bp.a.fromDPToPix(this.mContext, 25);
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.DefaultActionbarHeightLand);
            } else {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.DefaultActionbarHeightPort);
            }
            this.tlX.setPadding(this.tlX.getPaddingLeft(), dimensionPixelSize + (layoutId + this.tlX.getPaddingTop()), this.tlX.getPaddingRight(), this.tlX.getPaddingBottom());
        }
        this.mActionBar = getSupportActionBar();
        x.d("MicroMsg.MMActivityController", "onCreate, before.");
        U(actionBarActivity);
        this.tmy = ap.ae(this.mContext, e.DefaultActionbarHeightPort);
        this.tmz = ap.ae(this.mContext, e.SmallActionbarHeight);
        if (this.tma == null || !(this.tma instanceof LayoutListenerView)) {
            x.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
        } else {
            ((LayoutListenerView) this.tma).setOnResizedListener(new LayoutListenerView.c() {
                private final int tmQ = com.tencent.mm.bp.a.fromDPToPix(s.this.mContext, 100);

                public final void onSizeChanged(int i, int i2, int i3, int i4) {
                    if (!s.f(s.this) && i != 0 && i2 != 0 && i3 != 0 && i4 != 0 && i == i3) {
                        if (i2 > i4 && i2 - i4 > this.tmQ) {
                            s.g(s.this);
                        } else if (i4 > i2 && i4 - i2 > this.tmQ) {
                            s.h(s.this);
                        }
                    }
                }
            });
        }
        com.tencent.mm.sdk.b.b ahVar = new ah();
        ahVar.bHy.type = 2;
        ahVar.bHy.position = this.tmA;
        com.tencent.mm.sdk.b.a.sFg.m(ahVar);
        if (ahVar.bHz.bHC == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = ahVar.bHz.bHF;
            int i = ahVar.bHz.position;
            x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", Integer.valueOf(i), str, bi.cjd());
            if (i <= 0 || i == this.tmA) {
                a(ahVar.bHz.bHE, ahVar.bHz.YN, ahVar.bHz.url, ahVar.bHz.desc, str, i, true);
            } else {
                x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(this.tmA));
            }
            x.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (VERSION.SDK_INT >= 21) {
            if (this.tgp == 0) {
                this.tgp = cqm();
            }
            Window window = actionBarActivity.getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            k(actionBarActivity, this.tgp);
            cqt();
        }
    }

    public boolean noActionBar() {
        return false;
    }

    public final int cqm() {
        boolean z = ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).getBoolean("dark_actionbar", false);
        this.mQO = z;
        if (this.tgp == 0) {
            if (z) {
                this.tgp = this.mContext.getResources().getColor(d.dark_actionbar_color);
            } else {
                this.tgp = this.mContext.getResources().getColor(d.normal_actionbar_color);
            }
        }
        return this.tgp;
    }

    public final void U(Activity activity) {
        if (this.mActionBar != null && !noActionBar()) {
            x.d("MicroMsg.MMActivityController", "onCreate, after");
            if (this.tgp == 0) {
                this.tgp = cqm();
            }
            this.mQO = an.Ec(this.tgp);
            lF(this.tgp);
            this.mActionBar.setLogo(new ColorDrawable(this.tml.getResources().getColor(17170445)));
            this.mActionBar.da();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.cZ();
            this.mActionBar.db();
            this.mActionBar.setIcon(f.transparent_background);
            if (this.tmF == -1) {
                this.mActionBar.setCustomView(y.gq(this.tml).inflate(this.tmD, new LinearLayout(this.tml), false));
            } else {
                this.mActionBar.setCustomView(y.gq(this.tml).inflate(this.tmF, new LinearLayout(this.tml), false));
            }
            this.tmq = (TextView) findViewById(16908308);
            this.tmu = (TextView) findViewById(16908309);
            this.tmr = findViewById(g.title_ll);
            this.tms = findViewById(g.actionbar_up_indicator);
            this.tmt = (ImageView) findViewById(g.actionbar_up_indicator_btn);
            if (this.tmt != null) {
                this.tmt.setContentDescription(this.tml.getString(k.app_back));
            }
            if (this.tmq != null) {
                this.tmq.setText(k.app_name);
            }
            if (activity.getClass().getName() == "WebViewUI") {
                if (this.tmt != null) {
                    this.tmt.setVisibility(0);
                }
                if (this.tms != null) {
                    this.tms.setVisibility(0);
                }
            } else if (activity instanceof MMActivity) {
                if (this.tmt != null) {
                    this.tmt.setVisibility(0);
                }
                if (this.tms != null) {
                    this.tms.setVisibility(0);
                }
                if (this.tmq != null) {
                    this.tmq.setVisibility(0);
                }
            } else {
                if (this.tmt != null) {
                    this.tmt.setVisibility(8);
                }
                if (this.tms != null) {
                    this.tms.setVisibility(8);
                }
            }
            cqs();
        }
    }

    public final void setScreenEnable(boolean z) {
        boolean z2 = true;
        this.tmb = z;
        if (this.tlW == null && this.contentView != null) {
            this.tlW = this.contentView.findViewById(g.mm_trans_layer);
        }
        if (this.tlW == null) {
            x.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
            return;
        }
        this.tlW.setFocusable(!z);
        View view = this.tlW;
        if (z) {
            z2 = false;
        }
        view.setFocusableInTouchMode(z2);
        if (z) {
            synchronized (tmH) {
                if (wakeLock == null || !wakeLock.isHeld()) {
                    x.w("MicroMsg.MMActivityController", "repeatedly release screen off wakelock from object: %s, drop this call.", toString());
                } else {
                    wakeLock.release();
                    x.i("MicroMsg.MMActivityController", "after release screen off wakelock from object: %s, isHeld: %s", toString(), Boolean.valueOf(wakeLock.isHeld()));
                }
            }
            return;
        }
        Context context = this.tml;
        synchronized (tmH) {
            if (wakeLock == null) {
                wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(32, "screen Lock");
            }
            if (wakeLock.isHeld()) {
                x.w("MicroMsg.MMActivityController", "repeatedly acquire screen off wakelock from object: %s, drop this call.", toString());
            } else {
                wakeLock.acquire();
                x.i("MicroMsg.MMActivityController", "after acquire screen off wakelock from object: %s, isHeld: %s", toString(), Boolean.valueOf(wakeLock.isHeld()));
            }
        }
    }

    public static boolean cqn() {
        boolean isHeld;
        synchronized (tmH) {
            isHeld = wakeLock != null ? wakeLock.isHeld() : false;
        }
        return isHeld;
    }

    protected static int getForceOrientation() {
        return -1;
    }

    public final void onStart() {
        this.tlM = this.mContext.getSharedPreferences(ad.chY(), 0).getBoolean("settings_landscape_mode", false);
        if (this.tlM) {
            this.tml.setRequestedOrientation(-1);
        } else {
            this.tml.setRequestedOrientation(1);
        }
    }

    public final boolean getLandscapeMode() {
        return this.tlM;
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || keyEvent.getAction() != 1) {
            return false;
        }
        if (this.tmI == null || !this.tmI.bKe) {
            return true;
        }
        a(this.tmJ, this.tmI);
        return true;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.tencent.mm.compatible.b.f.yD();
        com.tencent.mm.compatible.b.f.yD();
        if (!this.tmm || this.eMS == null || !this.eMS.onKeyDown(i, keyEvent)) {
            return false;
        }
        x.d("MicroMsg.MMActivityController", "match search view on key down");
        if (ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).getBoolean("dark_actionbar", false)) {
            lF(this.tml.getResources().getColor(d.dark_actionbar_color));
        } else {
            lF(this.tml.getResources().getColor(d.normal_actionbar_color));
        }
        return true;
    }

    public boolean needShowIdcError() {
        return true;
    }

    public final void onResume() {
        activateBroadcast(true);
        com.tencent.mm.sdk.b.a.sFg.b(this.tmC);
        com.tencent.mm.sdk.b.b ahVar = new ah();
        ahVar.bHy.type = 2;
        ahVar.bHy.position = this.tmA;
        com.tencent.mm.sdk.b.a.sFg.m(ahVar);
        if (ahVar.bHz.bHC == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = ahVar.bHz.bHF;
            int i = ahVar.bHz.position;
            x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", Integer.valueOf(i), str);
            if (i <= 0 || i == this.tmA) {
                a(ahVar.bHz.bHE, ahVar.bHz.YN, ahVar.bHz.url, ahVar.bHz.desc, str, i, true);
            } else {
                x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(this.tmA));
            }
            x.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final void addDialog(Dialog dialog) {
        if (dialog != null) {
            if (this.tmp == null) {
                this.tmp = new ArrayList();
            }
            this.tmp.add(dialog);
        }
    }

    public final void onDestroy() {
        if (this.tmp != null) {
            int size = this.tmp.size();
            for (int i = 0; i < size; i++) {
                Dialog dialog = (Dialog) this.tmp.get(i);
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
            this.tmp.clear();
            this.tmp = null;
        }
    }

    public final void activateBroadcast(boolean z) {
        if (tmo || !z) {
            com.tencent.mm.ui.base.x.b(z, new Intent().putExtra("classname", getClassName() + aYS()));
        } else {
            com.tencent.mm.ui.base.x.b(z, new Intent().putExtra("classname", getClassName()).putExtra("main_process", false));
        }
    }

    public static void cqb() {
        tmo = true;
    }

    public final void onPause() {
        activateBroadcast(false);
        com.tencent.mm.sdk.b.a.sFg.c(this.tmC);
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", Integer.valueOf(this.tgz.size()));
        if (this.mActionBar == null || this.tgz.size() == 0) {
            x.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", Integer.valueOf(this.tgz.size()));
            return false;
        }
        this.tmI = null;
        this.tmJ = null;
        if (this.mActionBar.getHeight() == 0) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                this.mContext.getResources().getDimensionPixelSize(e.DefaultActionbarHeightLand);
            } else {
                this.mContext.getResources().getDimensionPixelSize(e.DefaultActionbarHeightPort);
            }
        }
        Iterator it = this.tgz.iterator();
        while (it.hasNext()) {
            final a aVar = (a) it.next();
            String str;
            if (aVar.tgH == 16908332) {
                x.v("MicroMsg.MMActivityController", "match back option menu, continue");
            } else if (aVar.tgH == g.menu_search) {
                boolean z;
                str = "MicroMsg.MMActivityController";
                String str2 = "match search menu, enable search view[%B], search view helper is null[%B]";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(this.tmm);
                if (this.eMS == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                x.v(str, str2, objArr);
                if (this.tmm && this.eMS != null) {
                    this.eMS.a(this.tml, menu);
                }
            } else {
                final MenuItem add = menu.add(0, aVar.tgH, 0, aVar.text);
                str = getClass().getName();
                if (add == null) {
                    x.w("MicroMsg.MenuItemUtil", "fixTitleCondensed fail, item is null");
                } else if (add.getTitleCondensed() == null) {
                    x.w("MicroMsg.MenuItemUtil", "%s title condensed is null, fix it", str);
                    add.setTitleCondensed("");
                } else if (!(add.getTitleCondensed() instanceof String)) {
                    x.w("MicroMsg.MenuItemUtil", "%s title condensed is not String type, cur type[%s], cur value[%s], fix it", str, add.getTitleCondensed().getClass().getName(), add.getTitleCondensed());
                    add.setTitleCondensed(add.getTitleCondensed().toString());
                }
                OnClickListener anonymousClass12 = new OnClickListener() {
                    public final void onClick(View view) {
                        s.this.a(add, aVar);
                    }
                };
                OnLongClickListener anonymousClass13 = new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        return s.a(s.this, view, aVar);
                    }
                };
                if (aVar.tgI == 0 && aVar.tmT == null) {
                    if (aVar.tgJ == null) {
                        aVar.tgJ = View.inflate(this.mContext, h.action_option_view, null);
                    }
                    this.tgs = (TextView) aVar.tgJ.findViewById(g.action_option_text);
                    this.tgs.setVisibility(0);
                    if (aVar.tmU == b.tmY || aVar.tmU == b.tnb) {
                        this.tgs.setTextColor(com.tencent.mm.bp.a.ac(this.tml, d.red_text_color_selector));
                    } else if (aVar.tmU == b.tmX || aVar.tmU == b.tnc) {
                        this.tgs.setTextColor(com.tencent.mm.bp.a.ac(this.tml, d.green_text_color_selector));
                    } else {
                        if (aVar.tmU != b.tmZ) {
                            if (aVar.tmU == b.tne) {
                                this.tgs.setTextColor(this.tml.getResources().getColor(d.lucky_money_goldstyle_text_color));
                            } else if (aVar.tmU == b.tnd) {
                                this.tgs.setTextColor(-2601405);
                            } else if (this.tmv != 0) {
                                this.tgs.setTextColor(this.tmv);
                            } else if (this.mQO) {
                                this.tgs.setTextColor(com.tencent.mm.bp.a.ac(this.tml, d.white_text_color_selector));
                            }
                        }
                        this.tgs.setTextColor(com.tencent.mm.bp.a.ac(this.tml, d.black_text_color_selector));
                    }
                    this.tgs.setText(aVar.text);
                    if (aVar.textColor != 0) {
                        this.tgs.setTextColor(aVar.textColor);
                    }
                    this.tgs.setOnClickListener(anonymousClass12);
                    this.tgs.setOnLongClickListener(anonymousClass13);
                    this.tgs.setEnabled(aVar.bKe);
                    m.a(add, aVar.tgJ);
                } else {
                    if (aVar.tgK == null) {
                        aVar.tgK = View.inflate(this.mContext, h.action_option_view, null);
                    }
                    ImageView imageView = (ImageView) aVar.tgK.findViewById(g.divider);
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    this.tgq = (ImageButton) aVar.tgK.findViewById(g.action_option_icon);
                    this.tgq.setVisibility(0);
                    if (aVar.tmT != null) {
                        this.tgq.setImageDrawable(aVar.tmT);
                    } else {
                        this.tgq.setImageResource(aVar.tgI);
                    }
                    if (this.mQO) {
                        if (this.tmv != 0) {
                            this.tgq.getDrawable().setColorFilter(this.tmv, Mode.SRC_ATOP);
                        } else {
                            this.tgq.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
                        }
                    } else if (this.tmv != 0) {
                        this.tgq.getDrawable().setColorFilter(this.tmv, Mode.SRC_ATOP);
                    } else {
                        this.tgq.getDrawable().setColorFilter(-16777216, Mode.SRC_ATOP);
                    }
                    this.tgq.setOnClickListener(anonymousClass12);
                    this.tgq.setEnabled(aVar.bKe);
                    this.tgq.setContentDescription(aVar.text);
                    if (aVar.jcS != null) {
                        this.tgq.setOnLongClickListener(anonymousClass13);
                    }
                    this.tmw = (ImageView) aVar.tgK.findViewById(g.dot_iv);
                    if (this.tmw != null) {
                        if (aVar.tmV) {
                            this.tmw.setVisibility(0);
                        } else {
                            this.tmw.setVisibility(8);
                        }
                    }
                    m.a(add, aVar.tgK);
                }
                add.setEnabled(aVar.bKe);
                add.setVisible(aVar.YN);
                m.a(add, 2);
                if (aVar.tgI == f.mm_title_btn_menu) {
                    this.tmI = aVar;
                    this.tmJ = add;
                }
                x.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", Integer.valueOf(aVar.tgH), aVar.text, Boolean.valueOf(aVar.bKe), Boolean.valueOf(aVar.YN));
            }
        }
        return true;
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        x.d("MicroMsg.MMActivityController", "on prepare option menu");
        if (this.tmm && this.eMS != null) {
            this.eMS.a(this.tml, menu);
        }
        return true;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        x.v("MicroMsg.MMActivityController", "on options item selected");
        if (!this.tmb) {
            x.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
            return true;
        } else if (menuItem.getItemId() == this.tmn.tgH && this.tmn.bKe) {
            a(menuItem, this.tmn);
            return true;
        } else {
            Iterator it = this.tgz.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (menuItem.getItemId() == aVar.tgH) {
                    x.d("MicroMsg.MMActivityController", "on option menu %d click", Integer.valueOf(menuItem.getItemId()));
                    a(menuItem, aVar);
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean callBackMenu() {
        if (this.tmn == null || !this.tmn.bKe) {
            return false;
        }
        a(null, this.tmn);
        return true;
    }

    private void a(MenuItem menuItem, a aVar) {
        if (!this.tmb) {
            x.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
        } else if (aVar.eOJ != null) {
            aVar.eOJ.onMenuItemClick(menuItem);
        }
    }

    public final void fullScreenNoTitleBar(boolean z) {
        if (z) {
            if (this.mActionBar != null) {
                this.mActionBar.hide();
            }
            this.msM.removeCallbacks(this.tmL);
            this.msM.removeCallbacks(this.tmK);
            this.msM.postDelayed(this.tmK, 256);
            return;
        }
        this.tml.getWindow().clearFlags(1024);
        this.msM.removeCallbacks(this.tmK);
        this.msM.removeCallbacks(this.tmL);
        this.msM.postDelayed(this.tmL, 256);
    }

    public final void cqo() {
        if (this.mActionBar != null) {
            this.mActionBar.hide();
        }
        this.msM.removeCallbacks(this.tmL);
        this.msM.removeCallbacks(this.tmK);
        this.msM.postDelayed(this.tmK, 0);
    }

    public final void setTitleVisibility(int i) {
        if (this.mActionBar != null) {
            if (i == 0) {
                this.mActionBar.show();
                k(this.tml, this.tgp);
                return;
            }
            this.mActionBar.hide();
            k(this.tml, this.tml.getResources().getColor(d.black));
        }
    }

    public final void setMMTitle(String str) {
        if (this.mActionBar != null) {
            this.tmc = str;
            if (com.tencent.mm.bp.a.fi(this.tml)) {
                this.tmq.setTextSize(0, ((float) com.tencent.mm.bp.a.ae(this.tml, e.ActionBarTextSize)) * com.tencent.mm.bp.a.fg(this.tml));
            }
            cqr();
            updateDescription(str);
        }
    }

    public final void M(CharSequence charSequence) {
        if (this.mActionBar != null) {
            this.tmc = charSequence.toString();
            this.tmq.setText(charSequence);
            if (com.tencent.mm.bp.a.fi(this.tml)) {
                this.tmq.setTextSize(0, ((float) com.tencent.mm.bp.a.ae(this.tml, e.ActionBarTextSize)) * com.tencent.mm.bp.a.fg(this.tml));
            }
            updateDescription(charSequence.toString());
        }
    }

    protected final void updateDescription(String str) {
        com.tencent.mm.ui.a.a cqX = a.tqS;
        Activity activity = this.tml;
        if (!cqX.cqW() && !bi.oW(str) && activity != null) {
            activity.getWindow().getDecorView().setContentDescription(activity.getString(k.common_enter_activity) + str);
        }
    }

    public final void setMMTitle(int i) {
        setMMTitle(this.mContext.getString(i));
    }

    public final void setMMSubTitle(String str) {
        if (this.mActionBar != null) {
            if (str == null) {
                this.tmu.setVisibility(8);
                return;
            }
            this.tmu.setText(str);
            if (com.tencent.mm.bp.a.fi(this.tml)) {
                this.tmu.setTextSize(1, 14.0f);
                this.tmq.setTextSize(1, 18.0f);
            }
            this.tmu.setVisibility(0);
            updateDescription(str);
        }
    }

    public final void setMMSubTitle(int i) {
        if (this.mActionBar != null) {
            this.tmu.setText(this.mContext.getString(i));
            if (com.tencent.mm.bp.a.fi(this.tml)) {
                this.tmu.setTextSize(1, 14.0f);
                this.tmq.setTextSize(1, 18.0f);
            }
            this.tmu.setVisibility(0);
            updateDescription(this.mContext.getString(i));
        }
    }

    public final void setTitleLogo(int i, int i2) {
        if (this.mActionBar != null) {
            if (i == 0) {
                this.tmd = 0;
                this.tmf = null;
            } else if (this.tmd != i) {
                this.tmd = i;
                this.tmf = eK(this.mContext.getResources().getDimensionPixelSize(e.BigTextSize), this.tmd);
            }
            if (i2 == 0) {
                this.tme = 0;
                this.tmg = null;
            } else if (this.tme != i2) {
                this.tme = i2;
                this.tmg = eK(this.mContext.getResources().getDimensionPixelSize(e.BigTextSize), this.tme);
            }
            cqr();
        }
    }

    public static void cqp() {
    }

    public static void cqq() {
    }

    private com.tencent.mm.ui.widget.a eK(int i, int i2) {
        Drawable drawable = this.mContext.getResources().getDrawable(i2);
        if (this.mQO) {
            drawable = an.ao(this.tml, i2);
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable);
        aVar.uFY = (drawable.getIntrinsicHeight() - i) / 2;
        return aVar;
    }

    final void cqr() {
        int i;
        int i2;
        int i3;
        int i4;
        String str = "%s";
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.ActionBarTextSize);
        if (this.tmd != 0) {
            str = "# " + str;
        }
        if (this.tme != 0) {
            str = str + " #";
            i = 1;
        } else {
            i = 0;
        }
        if (this.tmj) {
            str = str + " #";
            i += 2;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.tmk) {
            str = str + " #";
            i2 += 2;
            i3 = 1;
            i4 = i + 2;
        } else {
            i3 = 0;
            i4 = i;
        }
        CharSequence format = String.format(str, new Object[]{this.tmc});
        x.v("MicroMsg.MMActivityController", "span title format %s", str);
        format = com.tencent.mm.ui.e.c.b.c(format, dimensionPixelSize);
        if (format instanceof SpannableString) {
            int length;
            SpannableString spannableString = (SpannableString) format;
            if (this.tmd != 0) {
                spannableString.setSpan(this.tmf, 0, 1, 33);
            }
            if (this.tme != 0) {
                length = spannableString.length() - i4;
                spannableString.setSpan(this.tmg, length, length + 1, 33);
            }
            if (this.tmj) {
                if (this.tmh == null) {
                    this.tmh = eK(dimensionPixelSize, j.chat_mute_notify_title_icon);
                }
                length = spannableString.length() - i2;
                spannableString.setSpan(this.tmh, length, length + 1, 33);
            }
            if (this.tmk) {
                if (this.tmi == null) {
                    this.tmi = eK(dimensionPixelSize, j.chat_phone_notify_title_icon);
                }
                length = spannableString.length() - i3;
                spannableString.setSpan(this.tmi, length, length + 1, 33);
            }
        }
        this.tmq.setText(format);
    }

    public final void showHomeBtn(boolean z) {
        if (this.mActionBar != null) {
            this.mActionBar.setDisplayHomeAsUpEnabled(z);
            if (this.tms != null) {
                this.tms.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void supportInvalidateOptionsMenu() {
        this.tml.supportInvalidateOptionsMenu();
    }

    public boolean interceptSupportInvalidateOptionsMenu() {
        return false;
    }

    public final void enableBackMenu(boolean z) {
        if (this.tmn != null && this.tmn.bKe != z) {
            this.tmn.bKe = z;
            supportInvalidateOptionsMenu();
        }
    }

    final void c(boolean z, int i, boolean z2) {
        boolean z3;
        boolean z4;
        Iterator it;
        a aVar;
        if (z) {
            it = this.tgz.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.bKe != z2) {
                    aVar.bKe = z2;
                    z4 = true;
                } else {
                    z4 = z3;
                }
                z3 = z4;
            }
        } else {
            it = this.tgz.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.tgH != i || aVar.bKe == z2) {
                    z4 = z3;
                } else {
                    aVar.bKe = z2;
                    z4 = true;
                }
                z3 = z4;
            }
        }
        if (!(this.eMS == null ? false : this.eMS.uBr)) {
            supportInvalidateOptionsMenu();
        }
        x.v("MicroMsg.MMActivityController", "enable option menu, target id %d, changed %B, searching %B", Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    final void d(boolean z, int i, boolean z2) {
        boolean z3;
        boolean z4;
        Iterator it;
        a aVar;
        if (z) {
            it = this.tgz.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.YN != z2) {
                    aVar.YN = z2;
                    z4 = true;
                } else {
                    z4 = z3;
                }
                z3 = z4;
            }
        } else {
            it = this.tgz.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.tgH != i || aVar.YN == z2) {
                    z4 = z3;
                } else {
                    aVar.YN = z2;
                    z4 = true;
                }
                z3 = z4;
            }
        }
        z4 = this.eMS == null ? false : this.eMS.uBr;
        if (z3 && !z4) {
            supportInvalidateOptionsMenu();
        }
        x.i("MicroMsg.MMActivityController", "show option menu, target id %d, changed %B, searching %B", Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    public final void addSearchMenu(boolean z, o oVar) {
        x.v("MicroMsg.MMActivityController", "add search menu");
        a aVar = new a();
        aVar.tgH = g.menu_search;
        aVar.text = this.mContext.getString(k.app_search);
        aVar.tgI = j.actionbar_icon_dark_search;
        aVar.eOJ = null;
        aVar.jcS = null;
        removeOptionMenu(aVar.tgH);
        this.tgz.add(0, aVar);
        this.tmm = z;
        this.eMS = oVar;
        supportInvalidateOptionsMenu();
    }

    public final void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, 0, str, false, onMenuItemClickListener, null, b.tmW);
    }

    public final void addTextOptionMenu$7df2a0ca(int i, String str, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, int i2) {
        a(i, 0, str, false, onMenuItemClickListener, onLongClickListener, i2);
    }

    public final void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i2, "", false, onMenuItemClickListener, null, b.tmW);
    }

    public final void a(int i, String str, Drawable drawable, OnMenuItemClickListener onMenuItemClickListener) {
        int i2 = b.tmW;
        a aVar = new a();
        aVar.tgH = i;
        aVar.tmT = drawable;
        aVar.text = str;
        aVar.eOJ = onMenuItemClickListener;
        aVar.jcS = null;
        aVar.tmU = i2;
        DP(aVar.tgH);
        this.tgz.add(aVar);
        new ag().postDelayed(new Runnable() {
            public final void run() {
                s.this.supportInvalidateOptionsMenu();
            }
        }, 200);
    }

    public final void addIconOptionMenu(int i, String str, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i2, str, false, onMenuItemClickListener, null, b.tmW);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i3, this.mContext.getString(i2), false, onMenuItemClickListener, null, b.tmW);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        a(i, i3, this.mContext.getString(i2), false, onMenuItemClickListener, onLongClickListener, b.tmW);
    }

    public final void updateOptionMenuText(int i, String str) {
        a DQ = DQ(i);
        if (DQ != null && !bi.aG(str, "").equals(DQ.text)) {
            DQ.text = str;
            supportInvalidateOptionsMenu();
        }
    }

    public final void updateOptionMenuListener(int i, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        a DQ = DQ(i);
        if (DQ != null) {
            DQ.eOJ = onMenuItemClickListener;
            DQ.jcS = onLongClickListener;
        }
    }

    public final void setTitleBarDoubleClickListener(final Runnable runnable) {
        if (this.mActionBar != null && runnable != null) {
            this.mActionBar.getCustomView().setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (SystemClock.elapsedRealtime() - s.this.ocp < 300) {
                        runnable.run();
                    }
                    s.this.ocp = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    public final void setBackBtn(final OnMenuItemClickListener onMenuItemClickListener, int i) {
        if (this.mActionBar != null) {
            if (onMenuItemClickListener == null) {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
            } else {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
                if (this.tms != null) {
                    this.tms.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            onMenuItemClickListener.onMenuItemClick(null);
                        }
                    });
                }
            }
            if (i == 0) {
                i = j.actionbar_icon_dark_back;
            }
            if (!(this.tmt == null || i == 0)) {
                this.tmt.setImageResource(i);
            }
            this.tmn.tgH = 16908332;
            this.tmn.eOJ = onMenuItemClickListener;
        }
    }

    public final void removeAllOptionMenu() {
        if (!this.tgz.isEmpty()) {
            this.tgz.clear();
            supportInvalidateOptionsMenu();
        }
    }

    final boolean DP(int i) {
        for (int i2 = 0; i2 < this.tgz.size(); i2++) {
            if (((a) this.tgz.get(i2)).tgH == i) {
                x.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", Integer.valueOf(i));
                this.tgz.remove(i2);
                return true;
            }
        }
        return false;
    }

    public final boolean removeOptionMenu(int i) {
        for (int i2 = 0; i2 < this.tgz.size(); i2++) {
            if (((a) this.tgz.get(i2)).tgH == i) {
                x.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", Integer.valueOf(i));
                this.tgz.remove(i2);
                supportInvalidateOptionsMenu();
                return true;
            }
        }
        return false;
    }

    final void a(int i, int i2, String str, boolean z, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, int i3) {
        a aVar = new a();
        aVar.tgH = i;
        aVar.tgI = i2;
        aVar.text = str;
        aVar.eOJ = onMenuItemClickListener;
        aVar.jcS = onLongClickListener;
        aVar.tmU = i3;
        aVar.tmV = z;
        if (aVar.tgI == f.mm_title_btn_menu && bi.oW(str)) {
            aVar.text = this.mContext.getString(k.app_more);
        }
        DP(aVar.tgH);
        this.tgz.add(aVar);
        supportInvalidateOptionsMenu();
    }

    public final a DQ(int i) {
        Iterator it = this.tgz.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.tgH == i) {
                return aVar;
            }
        }
        return null;
    }

    public final CharSequence getMMTitle() {
        if (this.mActionBar == null) {
            return null;
        }
        return this.tmc != null ? this.tmc : this.mActionBar.getTitle();
    }

    public final void hideTitleView() {
        boolean z = true;
        String str = "MicroMsg.MMActivityController";
        String str2 = "hideTitleView hasTitle:%b";
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        if (this.mActionBar != null) {
            this.mActionBar.hide();
        }
    }

    public final void showTitleView() {
        boolean z = true;
        String str = "MicroMsg.MMActivityController";
        String str2 = "showTitleView hasTitle:%b";
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        if (this.mActionBar != null) {
            this.mActionBar.show();
        }
    }

    public final boolean isTitleShowing() {
        boolean z = true;
        String str = "MicroMsg.MMActivityController";
        String str2 = "isTitleShowing hasTitle:%b";
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        if (this.mActionBar == null) {
            return false;
        }
        return this.mActionBar.isShowing();
    }

    public final int getTitleLocation() {
        if (this.mActionBar == null) {
            return 0;
        }
        return this.mActionBar.getHeight();
    }

    public final void setTitleMuteIconVisibility(int i) {
        this.tmj = i == 0;
        cqr();
    }

    public final boolean hideVKB() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        View currentFocus = this.tml.getCurrentFocus();
        if (currentFocus == null) {
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.MMActivityController", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
        x.v("MicroMsg.MMActivityController", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
        return hideSoftInputFromWindow;
    }

    public final boolean hideVKB(View view) {
        if (view == null) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.MMActivityController", "hide VKB(View) exception %s", e);
            hideSoftInputFromWindow = false;
        }
        return hideSoftInputFromWindow;
    }

    public final void showVKB() {
        Activity activity = this.tml;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }

    final void cqs() {
        if (this.mQO) {
            if (this.tmt != null) {
                this.tmt.setColorFilter(-1, Mode.SRC_ATOP);
                this.tms.setBackgroundResource(f.selected_bg_dark);
            }
            if (this.tmq != null && this.tmq.getVisibility() == 0) {
                this.tmq.setTextColor(this.mContext.getResources().getColor(d.white_text_color));
            }
            if (this.tmu != null && this.tmu.getVisibility() == 0) {
                this.tmu.setTextColor(this.mContext.getResources().getColor(d.white_text_color));
            }
            if (this.tgq == null || this.tgq.getVisibility() != 0) {
                if (this.tgs != null && this.tgs.getVisibility() == 0) {
                    this.tgs.setTextColor(com.tencent.mm.bp.a.ac(this.mContext, d.white_text_color_selector));
                    return;
                }
                return;
            } else if (this.tgq.getDrawable() != null) {
                this.tgq.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
                return;
            } else {
                this.tgq.setColorFilter(-1, Mode.SRC_ATOP);
                return;
            }
        }
        if (this.tmt != null) {
            this.tmt.setColorFilter(-16777216, Mode.SRC_ATOP);
            this.tms.setBackgroundResource(f.actionbar_menu_selector);
        }
        if (this.tmq != null && this.tmq.getVisibility() == 0) {
            this.tmq.setTextColor(this.mContext.getResources().getColor(d.black_text_color));
        }
        if (this.tmu != null && this.tmu.getVisibility() == 0) {
            this.tmu.setTextColor(this.mContext.getResources().getColor(d.black_text_color));
        }
        if (this.tgq == null || this.tgq.getVisibility() != 0) {
            if (this.tgs != null && this.tgs.getVisibility() == 0) {
                this.tgs.setTextColor(com.tencent.mm.bp.a.ac(this.mContext, d.black_text_color_selector));
            }
        } else if (this.tgq.getDrawable() != null) {
            this.tgq.getDrawable().setColorFilter(-16777216, Mode.SRC_ATOP);
        } else {
            this.tgq.setColorFilter(-16777216, Mode.SRC_ATOP);
        }
    }

    final void cqt() {
        if (VERSION.SDK_INT >= 23) {
            View decorView = this.tml.getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            x.d("MicroMsg.MMActivityController", "dancy test actionbar isDark:%s", Boolean.valueOf(this.mQO));
            if (this.mQO) {
                systemUiVisibility &= -8193;
            } else {
                systemUiVisibility |= 8192;
            }
            decorView.setSystemUiVisibility(systemUiVisibility);
        }
    }

    public final void lF(int i) {
        if (this.mActionBar != null) {
            this.tgp = i;
            this.mQO = an.Ec(this.tgp);
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.tgp));
            k(this.tml, this.tgp);
            cqt();
            cqs();
        }
    }

    public final void DR(int i) {
        if (i > this.tmy) {
            i = this.tmy;
        }
        if (i < this.tmz) {
            i = this.tmz;
        }
        this.aDx = i;
        this.ofX = this.tml.getWindow().getDecorView().findViewById(g.action_bar_container);
        if (this.ofX != null) {
            this.tmx = this.ofX.getLayoutParams();
        }
        if (!(this.ofX == null || this.tmx == null)) {
            this.tmx.height = (this.ofX.getPaddingTop() + i) + this.ofX.getPaddingBottom();
            this.ofX.setLayoutParams(this.tmx);
        }
        float min = Math.min(com.tencent.mm.bp.a.fe(this.tml), com.tencent.mm.bp.a.fg(this.tml));
        int ae = (int) (((float) ap.ae(this.mContext, e.SmallTiteSzie)) * min);
        int ae2 = (int) (min * ((float) ap.ae(this.mContext, e.NormalTiteSzie)));
        int fromDPToPix = ap.fromDPToPix(this.mContext, 14);
        float f = ((float) (i - this.tmz)) / ((float) (this.tmy - this.tmz));
        min = (((float) (ae2 - ae)) * f) + ((float) ae);
        aB(f);
        ae = (int) (((float) (fromDPToPix - ap.fromDPToPix(this.mContext, 40))) * (1.0f - f));
        fromDPToPix = (int) ((((float) (this.tmz - this.tmy)) / 2.0f) * (1.0f - f));
        if (this.tmq != null) {
            this.tmq.setTextSize(0, min);
            if (this.tmr != null) {
                this.tmr.setTranslationX((float) ae);
                this.tmr.setTranslationY((float) fromDPToPix);
            }
        }
        if (this.tmt != null) {
            this.tmt.setTranslationY((float) fromDPToPix);
        }
        if (this.tgq != null) {
            this.tgq.setTranslationY((float) fromDPToPix);
        }
    }

    public final void aB(float f) {
        if (this.tms != null) {
            this.tms.setAlpha(f);
            if (f == 0.0f) {
                this.tms.setEnabled(false);
            } else {
                this.tms.setEnabled(true);
            }
        }
        if (this.tgq != null) {
            this.tgq.setAlpha(f);
            if (f == 0.0f) {
                this.tgq.setEnabled(false);
            } else {
                this.tgq.setEnabled(true);
            }
        }
    }

    @TargetApi(21)
    private static void k(Activity activity, int i) {
        if (VERSION.SDK_INT >= 21) {
            if (VERSION.SDK_INT < 23 || com.tencent.mm.compatible.util.h.Af()) {
                i = VERSION.SDK_INT >= 21 ? an.n(activity.getResources().getColor(d.statusbar_fg_drak_color), i) : 0;
            }
            activity.getWindow().setStatusBarColor(i);
        }
    }
}
