package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.R;
import com.tencent.mm.aa.p;
import com.tencent.mm.ac.f;
import com.tencent.mm.app.b;
import com.tencent.mm.app.m;
import com.tencent.mm.ay.d;
import com.tencent.mm.blink.FirstScreenFrameLayout;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.is;
import com.tencent.mm.kernel.b.3;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.account.ui.WelcomeSelectView;
import com.tencent.mm.plugin.account.ui.WelcomeView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.g.a.a.o;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.HomeUI.1;
import com.tencent.mm.ui.HomeUI.12;
import com.tencent.mm.ui.HomeUI.14;
import com.tencent.mm.ui.HomeUI.15;
import com.tencent.mm.ui.HomeUI.16;
import com.tencent.mm.ui.HomeUI.17;
import com.tencent.mm.ui.HomeUI.19;
import com.tencent.mm.ui.HomeUI.20;
import com.tencent.mm.ui.HomeUI.22;
import com.tencent.mm.ui.HomeUI.23;
import com.tencent.mm.ui.HomeUI.25;
import com.tencent.mm.ui.HomeUI.5;
import com.tencent.mm.ui.HomeUI.9;
import com.tencent.mm.ui.MMAppMgr.10;
import com.tencent.mm.ui.MMAppMgr.11;
import com.tencent.mm.ui.aa.7;
import com.tencent.mm.ui.ac.2;
import com.tencent.mm.ui.b.c;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.conversation.j;
import com.tencent.mm.ui.j.6;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.xlog.app.XLogSetup;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public class LauncherUI extends MMFragmentActivity {
    private static ArrayList<LauncherUI> tkk = new ArrayList();
    private static boolean tkl = true;
    public static long tkm;
    private static boolean tkv = false;
    private Intent bSk = null;
    public HomeUI tkn = new HomeUI();
    private ac tko = new ac(this.tkn);
    private p tkp = new p();
    public boolean tkq = false;
    boolean tkr = false;
    private boolean tks = false;
    private WelcomeView tkt;
    private r tku = new r("MicroMsg.LauncherUI");
    private boolean tkw = false;
    private boolean tkx = false;
    private ag tky = new ag();
    private Runnable tkz = new 4(this);

    interface a {
        boolean cpW();
    }

    public static LauncherUI cpQ() {
        if (!tkk.isEmpty()) {
            return (LauncherUI) tkk.get(0);
        }
        x.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", new Object[]{bi.cjd()});
        return null;
    }

    public static int cpR() {
        if (cpQ() == null || cpQ().tkn == null || cpQ().tkn.tjF == null) {
            return -1;
        }
        return cpQ().tkn.tjF.iUy;
    }

    private void cpS() {
        int indexOf = tkk.indexOf(this);
        if (indexOf >= 0) {
            tkk.remove(indexOf);
        }
        x.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", new Object[]{Integer.valueOf(indexOf), Integer.valueOf(tkk.size()), Integer.valueOf(hashCode())});
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        com.tencent.mm.blink.a.aC(h.Eo().drg);
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bi.fV(this)});
        super.onCreate(bundle);
        long currentTimeMillis2 = System.currentTimeMillis();
        int taskId = getTaskId();
        String packageName = getPackageName();
        Intent intent = getIntent();
        boolean z = false;
        if (intent != null && s.a(intent, "absolutely_exit", false)) {
            z = true;
            x.i("MicroMsg.LauncherUI", "checktask checkInstance isWantToRestart");
        }
        RunningTaskInfo runningTaskInfo = null;
        if (!z) {
            Iterator it = tkk.iterator();
            while (it.hasNext()) {
                LauncherUI launcherUI = (LauncherUI) it.next();
                if (launcherUI.getTaskId() != taskId) {
                    x.i("MicroMsg.LauncherUI", "checktask checkInstance 0x%x diff taskid taskid %d, nowtaskid:%d", new Object[]{Integer.valueOf(launcherUI.hashCode()), Integer.valueOf(launcherUI.getTaskId()), Integer.valueOf(taskId)});
                    runningTaskInfo = bi.am(this, taskId);
                    if (runningTaskInfo == null) {
                        x.e("MicroMsg.LauncherUI", "checktask cannot found curren taskinfo %d", new Object[]{Integer.valueOf(taskId)});
                        finish();
                        obj = null;
                        break;
                    }
                    x.i("MicroMsg.LauncherUI", "checktask task diff id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[]{Integer.valueOf(runningTaskInfo.id), runningTaskInfo.topActivity.getClassName(), runningTaskInfo.baseActivity.getClassName(), Integer.valueOf(runningTaskInfo.numActivities), Integer.valueOf(runningTaskInfo.numRunning)});
                    if (runningTaskInfo.baseActivity.getPackageName().equals(packageName)) {
                        launcherUI.finish();
                        tkk.remove(launcherUI);
                    } else {
                        x.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + runningTaskInfo.baseActivity.getPackageName());
                        finish();
                        if (bi.am(this, launcherUI.getTaskId()) != null) {
                            x.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
                            Intent intent2 = new Intent(this, LauncherUI.class);
                            intent2.addFlags(268435456);
                            startActivity(intent2);
                        }
                        obj = null;
                    }
                }
                runningTaskInfo = runningTaskInfo;
            }
        }
        if (!tkk.isEmpty()) {
            if (runningTaskInfo == null) {
                runningTaskInfo = bi.am(this, taskId);
            }
            if (runningTaskInfo != null) {
                x.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[]{Integer.valueOf(runningTaskInfo.id), runningTaskInfo.baseActivity.getClassName(), runningTaskInfo.baseActivity.getClassName(), Integer.valueOf(runningTaskInfo.numActivities), Integer.valueOf(runningTaskInfo.numRunning)});
                packageName = getComponentName().getClassName();
                if (runningTaskInfo.numActivities > 1 && packageName.equals(r0) && packageName.equals(r3)) {
                    finish();
                    x.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", new Object[]{Integer.valueOf(tkk.size())});
                    obj = null;
                    if (obj != null) {
                        x.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
                    }
                    x.i("MicroMsg.LauncherUI", "onCreate normally");
                    this.tkn = new HomeUI();
                    this.tko = new ac(this.tkn);
                    HomeUI homeUI = this.tkn;
                    ac acVar = this.tko;
                    homeUI.tiY = this;
                    homeUI.tjD = acVar;
                    z zVar = homeUI.tjF;
                    zVar.tiY = this;
                    zVar.tod = homeUI;
                    aa aaVar = zVar.toc;
                    aaVar.tiY = this;
                    aaVar.tov = homeUI;
                    homeUI.tjE = new j(this, homeUI);
                    NotifyReceiver.xz();
                    e.N(homeUI.tiY);
                    homeUI.mActionBar = getSupportActionBar();
                    if (homeUI.mActionBar != null) {
                        if (VERSION.SDK_INT < 11) {
                            homeUI.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.actionbar_bg_color)));
                        }
                        homeUI.mActionBar.hide();
                    }
                    setRequestedOrientation(1);
                    String I = at.dBv.I("login_user_name", "");
                    this.bSk = getIntent();
                    this.tku.qym = this.bSk.getBooleanExtra("splash-hack-activity-recreate", false);
                    x.i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", new Object[]{r1.mTag, Boolean.valueOf(r1.qym)});
                    x.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", new Object[]{I, Boolean.valueOf(au.HW()), Boolean.valueOf(tkl)});
                    if (tkl || (!au.HW() && I.equals(""))) {
                        tkm = currentTimeMillis;
                        x.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - b.bya));
                        setRequestedOrientation(1);
                        obj = (au.HW() || !at.dBv.I("login_user_name", "").equals("")) ? null : 1;
                        if (obj == null) {
                            com.tencent.mm.sdk.platformtools.e.sFD = false;
                        } else {
                            z = false;
                            if (com.tencent.mm.sdk.platformtools.e.sFE) {
                                z = MMAppMgr.a(this, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        LauncherUI.this.lA(true);
                                    }
                                });
                            } else {
                                MMAppMgr.go(this);
                            }
                            if (!z) {
                                lA(true);
                            }
                            o.atx();
                            g.vw(8);
                            WelcomeSelectView welcomeSelectView = new WelcomeSelectView(this);
                            setContentView(welcomeSelectView);
                            this.tkt = welcomeSelectView;
                            x.i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", new Object[]{Integer.valueOf(hashCode())});
                            ah.M(this.tkz);
                            ah.i(this.tkz, 2000);
                        }
                    } else {
                        tkm = currentTimeMillis;
                        x.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - b.bya));
                    }
                    if (cpV()) {
                        x.i("MicroMsg.LauncherUI", "handleExitIntent return");
                        return;
                    } else {
                        cpT();
                        return;
                    }
                }
                x.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", new Object[]{Integer.valueOf(tkk.size()), Boolean.valueOf(r2)});
                tkk.clear();
            } else {
                x.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", new Object[]{Integer.valueOf(taskId), Integer.valueOf(tkk.size())});
                tkk.clear();
            }
        }
        tkk.add(this);
        x.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d, use time %d", new Object[]{Integer.valueOf(tkk.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        obj = 1;
        if (obj != null) {
            x.i("MicroMsg.LauncherUI", "onCreate normally");
            this.tkn = new HomeUI();
            this.tko = new ac(this.tkn);
            HomeUI homeUI2 = this.tkn;
            ac acVar2 = this.tko;
            homeUI2.tiY = this;
            homeUI2.tjD = acVar2;
            z zVar2 = homeUI2.tjF;
            zVar2.tiY = this;
            zVar2.tod = homeUI2;
            aa aaVar2 = zVar2.toc;
            aaVar2.tiY = this;
            aaVar2.tov = homeUI2;
            homeUI2.tjE = new j(this, homeUI2);
            NotifyReceiver.xz();
            e.N(homeUI2.tiY);
            homeUI2.mActionBar = getSupportActionBar();
            if (homeUI2.mActionBar != null) {
                if (VERSION.SDK_INT < 11) {
                    homeUI2.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.actionbar_bg_color)));
                }
                homeUI2.mActionBar.hide();
            }
            setRequestedOrientation(1);
            String I2 = at.dBv.I("login_user_name", "");
            this.bSk = getIntent();
            this.tku.qym = this.bSk.getBooleanExtra("splash-hack-activity-recreate", false);
            x.i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", new Object[]{r1.mTag, Boolean.valueOf(r1.qym)});
            x.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", new Object[]{I2, Boolean.valueOf(au.HW()), Boolean.valueOf(tkl)});
            if (tkl || (!au.HW() && I2.equals(""))) {
                tkm = currentTimeMillis;
                x.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - b.bya));
                setRequestedOrientation(1);
                obj = (au.HW() || !at.dBv.I("login_user_name", "").equals("")) ? null : 1;
                if (obj == null) {
                    com.tencent.mm.sdk.platformtools.e.sFD = false;
                } else {
                    z = false;
                    if (com.tencent.mm.sdk.platformtools.e.sFE) {
                        z = MMAppMgr.a(this, /* anonymous class already generated */);
                    } else {
                        MMAppMgr.go(this);
                    }
                    if (!z) {
                        lA(true);
                    }
                    o.atx();
                    g.vw(8);
                    WelcomeSelectView welcomeSelectView2 = new WelcomeSelectView(this);
                    setContentView(welcomeSelectView2);
                    this.tkt = welcomeSelectView2;
                    x.i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", new Object[]{Integer.valueOf(hashCode())});
                    ah.M(this.tkz);
                    ah.i(this.tkz, 2000);
                }
            } else {
                tkm = currentTimeMillis;
                x.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - b.bya));
            }
            if (cpV()) {
                x.i("MicroMsg.LauncherUI", "handleExitIntent return");
                return;
            } else {
                cpT();
                return;
            }
        }
        x.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
    }

    private void cpT() {
        if (tkv) {
            x.i("MicroMsg.LauncherUI", "whatnew has been started.");
            return;
        }
        tkv = true;
        if (!com.tencent.mm.kernel.g.Eg().Dx()) {
            com.tencent.mm.kernel.g.Eg();
            if (com.tencent.mm.kernel.a.Dw()) {
                x.i("MicroMsg.LauncherUI", "account not initiate, skip whatsnew");
                return;
            }
            this.tkw = true;
            tkv = false;
        } else if (!cpU()) {
            x.i("MicroMsg.LauncherUI", "notSwitchOrHold is false, skip whatsnew");
        } else if (!s.a(getIntent(), "LauncherUI.enter_from_reg", false) && com.tencent.mm.pluginsdk.f.e.qBn != null) {
            com.tencent.mm.pluginsdk.f.e.qBn.vx();
        }
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", new Object[]{Integer.valueOf(hashCode()), bi.fV(this)});
        this.bSk = intent;
        super.onNewIntent(intent);
        setIntent(intent);
        if (cpV()) {
            x.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
        } else if (this.bSk == null || !s.a(this.bSk, "Intro_Need_Clear_Top ", false)) {
            if ((intent.getFlags() & 67108864) == 67108864) {
                closeChatting(false);
            }
            z zVar = this.tkn.tjF;
            if ((intent.getFlags() & 67108864) == 67108864) {
                zVar.toe = true;
            }
            if (this.tkq) {
                x.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
                at(intent);
            }
        } else {
            x.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
            finish();
            gm(this);
        }
    }

    private void lA(boolean z) {
        boolean z2 = true;
        if (z) {
            if (this.tkp.c(this, new 2(this))) {
                z2 = false;
            }
            this.tkx = z2;
        } else if (!this.tkx) {
            int i;
            if (this.tkp.eLU) {
                x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", ""))});
                if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "")) {
                    x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_PHONE_STATE", 97, "", ""))});
                    if (!com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_PHONE_STATE", 97, "", "")) {
                        i = 0;
                    }
                } else {
                    i = 0;
                }
                if (i != 0) {
                    z2 = false;
                }
                this.tkx = z2;
            }
            boolean i2 = true;
            if (i2 != 0) {
                z2 = false;
            }
            this.tkx = z2;
        }
    }

    public void onResume() {
        super.onResume();
        if (this.tku.cE("onResume")) {
            x.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onResume");
            return;
        }
        x.i("MicroMsg.LauncherUI", "not skip this onResume");
        tkl = false;
        SharedPreferences sharedPreferences;
        boolean cpW;
        String j;
        boolean a;
        String wL;
        Intent intent;
        if (cpU()) {
            HomeUI homeUI;
            j jVar;
            long currentTimeMillis;
            long currentTimeMillis2;
            j jVar2;
            LauncherUI cpQ;
            x.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", new Object[]{Boolean.valueOf(this.tkq)});
            if (!this.tkq) {
                this.tkq = true;
                homeUI = this.tkn;
                jVar = homeUI.tjE;
                com.tencent.mm.sdk.b.a.sFg.b(jVar.tjd);
                com.tencent.mm.sdk.b.a.sFg.b(jVar.tje);
                getWindow().setCallback(new c(getWindow().getCallback(), this));
                sharedPreferences = homeUI.tiY.getSharedPreferences("system_config_prefs", 4);
                if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
                    sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
                    XLogSetup.realSetupXlog();
                }
                homeUI.tjx = new ae(this);
                homeUI.tjr = true;
                NotifyReceiver.xA();
                au.getNotification().fr(1);
                x.d("MicroMsg.LauncherUI.HomeUI", "on main tab create");
                currentTimeMillis = System.currentTimeMillis();
                if (au.HX()) {
                    currentTimeMillis2 = System.currentTimeMillis();
                    MMActivity.initLanguage(homeUI.tiY);
                    try {
                        Set hashSet = new HashSet();
                        String[] split = homeUI.getString(R.l.country_others).split(";");
                        hashSet.add(split[0]);
                        hashSet.add(split[1]);
                        com.tencent.mm.model.r.d(hashSet);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e, "", new Object[0]);
                    }
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Em().H(new 5(homeUI));
                    x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - currentTimeMillis2));
                    homeUI.eMa = (LayoutInflater) homeUI.tiY.getSystemService("layout_inflater");
                    currentTimeMillis2 = System.currentTimeMillis();
                    homeUI.contentView = com.tencent.mm.kiss.a.b.EY().a(homeUI.tiY, "R.layout.main_tab", R.i.main_tab);
                    com.tencent.mm.blink.b.xi().xj();
                    ((FirstScreenFrameLayout) homeUI.contentView.findViewById(R.h.first_screen_layout)).cWt = new 1(homeUI);
                    ao.cbX();
                    x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - currentTimeMillis2));
                    homeUI.tiY.setContentView(homeUI.contentView);
                    Looper.myQueue().addIdleHandler(homeUI.tjO);
                    homeUI.tjs = true;
                    x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - currentTimeMillis2));
                    x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - System.currentTimeMillis()));
                    x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - System.currentTimeMillis()));
                    homeUI.initActionBar();
                    homeUI.mActionBar.show();
                    homeUI.contentView.post(new 12(homeUI));
                    x.v("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - currentTimeMillis));
                    ah.i(new 19(homeUI), 2000);
                    homeUI.contentView.addOnLayoutChangeListener(homeUI.tjG);
                    e.a(homeUI.tiY, homeUI.contentView);
                    homeUI.contentView.postDelayed(new 20(homeUI), 20);
                } else {
                    x.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready, finish launcherui");
                    homeUI.tiY.finish();
                }
                z zVar = homeUI.tjF;
                zVar.tog = (CustomViewPager) zVar.tiY.findViewById(R.h.pager);
                zVar.tog.setOffscreenPageLimit(4);
                zVar.tog.setCanSlide(true);
                zVar.tog.setCanSlideBySide(false);
                zVar.toh = new com.tencent.mm.ui.z.a(zVar, zVar.tiY, zVar.tog);
                zVar.DV(0);
                aa aaVar = zVar.toc;
                ViewGroup viewGroup = (ViewGroup) zVar.tog.getParent();
                com.tencent.mm.ui.z.a aVar = zVar.toh;
                c cVar = aaVar.tow;
                if (aaVar.tow != null) {
                    aaVar.tow.setOnTabClickListener(null);
                    ((View) aaVar.tow).setVisibility(8);
                    if (viewGroup != null) {
                        viewGroup.removeView((View) aaVar.tow);
                    }
                }
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                LauncherUIBottomTabView launcherUIBottomTabView = new LauncherUIBottomTabView(aaVar.tiY);
                if (viewGroup != null) {
                    viewGroup.addView(launcherUIBottomTabView, layoutParams);
                }
                aaVar.tow = launcherUIBottomTabView;
                ((View) aaVar.tow).setVisibility(0);
                aaVar.tow.setOnTabClickListener(aVar);
                if (!(cVar == null || cVar == aaVar.tow)) {
                    aaVar.tow.ls(cVar.getShowFriendPoint());
                    aaVar.tow.lt(cVar.getSettingsPoint());
                    aaVar.tow.DD(cVar.getMainTabUnread());
                    aaVar.tow.DE(cVar.getContactTabUnread());
                    aaVar.tow.DF(cVar.getFriendTabUnread());
                    aaVar.tow.DG(cVar.getSettingsTabUnread());
                    aaVar.tow.setTo(cVar.getCurIdx());
                }
                this.tko.nfG = this;
                at(getIntent());
            }
            homeUI = this.tkn;
            currentTimeMillis = ai.VF();
            z zVar2 = homeUI.tjF;
            x.i("MicroMsg.LauncherUI.MainTabUI", "onResume start :%d", new Object[]{Integer.valueOf(zVar2.iUy)});
            if (zVar2.ton.size() != 0) {
                ((o) ((x) zVar2.ton.get(Integer.valueOf(zVar2.iUy)))).coI();
            }
            if (zVar2.toe && zVar2.tiY.getIntent().hasExtra("isScrollFirst") && zVar2.tiY.getIntent().hasExtra("isShowHeader")) {
                jVar2 = (j) zVar2.ton.get(Integer.valueOf(0));
                if (jVar2 != null) {
                    jVar2.i(zVar2.tiY.getIntent().getBooleanExtra("isShowHeader", false), zVar2.tiY.getIntent().getBooleanExtra("isShowHeaderWithAnim", false), zVar2.tiY.getIntent().getBooleanExtra("isScrollFirst", true));
                }
            }
            if (zVar2.toe) {
                zVar2.toe = false;
                zVar2.ZS("tab_main");
            }
            jVar2 = (j) zVar2.ton.get(Integer.valueOf(0));
            if (jVar2 != null) {
                jVar2.cxZ();
                jVar2.cyZ();
            }
            if (zVar2.iUy == 0) {
                au.getNotification().aR(true);
            } else {
                au.getNotification().aR(false);
            }
            o oVar = (o) zVar2.DW(zVar2.iUy);
            if (oVar != null) {
                oVar.coJ();
            }
            zVar2.toe = false;
            int a2 = s.a(zVar2.tiY.getIntent(), "preferred_tab", 0);
            x.d("MicroMsg.LauncherUI.MainTabUI", "doOnResume, tabIdx = %d", new Object[]{Integer.valueOf(a2)});
            if (a2 != 0) {
                zVar2.DV(a2);
                zVar2.tiY.getIntent().putExtra("preferred_tab", 0);
            }
            com.tencent.mm.sdk.b.a.sFg.b(zVar2.tol);
            aa aaVar2 = zVar2.toc;
            if (aaVar2.tow != null) {
                aaVar2.tow.coM();
            }
            au.HU();
            com.tencent.mm.model.c.DT().a(aaVar2.toA);
            com.tencent.mm.s.c.Cp().a(aaVar2.toz);
            au.HU();
            com.tencent.mm.model.c.FW().a(aaVar2);
            com.tencent.mm.sdk.b.a.sFg.b(aaVar2.tiz);
            com.tencent.mm.sdk.b.a.sFg.b(aaVar2.toB);
            com.tencent.mm.sdk.b.a.sFg.b(aaVar2.tiy);
            com.tencent.mm.blink.b.xi().g(new 7(aaVar2));
            jVar = homeUI.tjE;
            aw awVar = new aw();
            com.tencent.mm.sdk.b.a.sFg.m(awVar);
            if (awVar.bIp.bIq && !ai.oW(awVar.bIp.bIr)) {
                x.d("MicroMsg.LauncherUI.GlobalAlertMgr", "  now show msg:%s", new Object[]{awVar.bIp.bIr});
                com.tencent.mm.ui.base.h.b(jVar.tiY, awVar.bIp.bIr, awVar.bIp.title, true);
            }
            if (!jVar.a(jVar.tja)) {
                au.Em().h(new 6(jVar), 500);
            }
            jVar.tja = null;
            com.tencent.mm.sdk.a.b.bB(true);
            cpW = homeUI.tjD.cpW();
            if (!cpW && au.HX()) {
                com.tencent.mm.blink.b.xi().g(new 22(homeUI));
                if (!(d.eli == null || d.elh == null || ai.oW(d.elh.SC()))) {
                    x.i("MicroMsg.LauncherUI.HomeUI", "launcher onResume end track %s", new Object[]{d.eli.SD()});
                    er erVar = new er();
                    erVar.bMv.username = d.eli.SD();
                    com.tencent.mm.sdk.b.a.sFg.m(erVar);
                }
            }
            if (!cpW) {
                k.a(homeUI.tiY, 3, homeUI.tjF.iUy, "directReport_onResume");
            }
            com.tencent.mm.ui.widget.g.b(homeUI.tiY);
            homeUI.tiY.onSwipe(1.0f);
            homeUI.tjC = com.tencent.mm.ui.HomeUI.a.tjY;
            if (homeUI.tjt) {
                homeUI.tjt = false;
                homeUI.tjt = false;
            }
            p.KB();
            currentTimeMillis2 = System.currentTimeMillis();
            x.w("MicroMsg.LauncherUI.HomeUI", "[Launching Application]");
            k.j(homeUI.tiY, false);
            k.k(homeUI.tiY, false);
            long currentTimeMillis3 = System.currentTimeMillis();
            if (homeUI.tiY.getSharedPreferences(ad.chY(), 0).getBoolean("settings_landscape_mode", false)) {
                homeUI.tiY.setRequestedOrientation(-1);
            } else {
                homeUI.tiY.setRequestedOrientation(1);
            }
            long currentTimeMillis4 = System.currentTimeMillis();
            if (cpQ() != null) {
                com.tencent.mm.blink.b.xi().xl();
                ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().a("showprivacypolicy", homeUI.tjR);
                homeUI.lz(false);
                com.tencent.mm.sdk.b.a.sFg.b(homeUI.tjN);
                x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - currentTimeMillis4));
            }
            x.v("MicroMsg.LauncherUI.HomeUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - currentTimeMillis3));
            x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - currentTimeMillis2));
            x.i("MicroMsg.LauncherUI.HomeUI", "initView " + (System.currentTimeMillis() - currentTimeMillis));
            if (homeUI.tjt) {
                homeUI.tjt = false;
                homeUI.tjt = false;
            }
            m vc = m.vc();
            vc.byZ = true;
            vc.bza.removeMessages(-1999);
            vc.bza.removeMessages(-2999);
            x.i("MicroMsg.LauncherUI.HomeUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - currentTimeMillis));
            if (q.Hn().booleanValue()) {
                homeUI.cpw();
            }
            com.tencent.mm.blink.b.xi().g(new 23(homeUI));
            ac acVar = this.tko;
            acVar.tpf = ai.VE();
            if (acVar.bWY()) {
                acVar.tpi = new ac.1(acVar);
                ah.i(new 2(acVar), 500);
            }
            if (acVar.cpW()) {
                acVar.kB(3);
                if (acVar.tpn != null && acVar.tpn.isSupportNavigationSwipeBack()) {
                    acVar.tpn.getSwipeBackLayout().setEnableGesture(true);
                }
            }
            x.i("MicroMsg.LauncherUI", "resumeNormalJump");
            com.tencent.mm.ui.MMFragmentActivity.a.cqv();
            if ("pushcontent_notification".equals(s.j(getIntent(), "nofification_type")) && !bi.oW(s.j(getIntent(), "Main_FromUserName"))) {
                x.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + s.j(getIntent(), "Main_FromUserName") + s.a(getIntent(), "MainUI_User_Last_Msg_Type", 0));
                com.tencent.mm.plugin.report.service.h.mEJ.h(10856, new Object[]{Integer.valueOf(r1), j, Integer.valueOf(0)});
            }
            j = s.j(getIntent(), "LauncherUI.Shortcut.LaunchType");
            if (j != null) {
                if (j.equals("launch_type_voip")) {
                    x.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
                    startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip"));
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11034, new Object[]{Integer.valueOf(2), Integer.valueOf(0)});
                } else if (j.equals("launch_type_voip_audio")) {
                    x.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
                    startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio"));
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11034, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
                }
            }
            j = s.j(getIntent(), "LauncherUI.switch.tab");
            if (!bi.oW(j)) {
                this.tkn.tjF.ZS(j);
                getIntent().putExtra("LauncherUI.switch.tab", "");
            }
            if (s.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false) || this.tks) {
                this.tks = false;
                cpQ = cpQ();
                if (cpQ != null) {
                    cpQ.tkn.cpz();
                }
                getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
                getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
            }
            a = s.a(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
            if (a) {
                j = s.j(getIntent(), "LauncherUI.Shortcut.Username");
            } else {
                a = s.a(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
                j = getIntent().getAction();
            }
            if (a) {
                x.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = " + j);
                if (!bi.oW(j)) {
                    wL = com.tencent.mm.plugin.base.model.b.wL(j);
                    if (!bi.oW(wL)) {
                        if (com.tencent.mm.model.s.he(wL)) {
                            x.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                            if (!f.kK(wL)) {
                                cpQ = cpQ();
                                if (cpQ != null) {
                                    cpQ.startChatting(wL, null, false);
                                }
                            } else if (f.eZ(wL)) {
                                intent = new Intent();
                                intent.setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                                intent.putExtra("Contact_User", wL);
                                intent.putExtra("biz_chat_from_scene", 9);
                                intent.addFlags(67108864);
                                startActivity(intent);
                            } else if (f.kM(wL)) {
                                intent = new Intent();
                                intent.setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
                                intent.putExtra("enterprise_biz_name", wL);
                                intent.putExtra("enterprise_biz_display_name", com.tencent.mm.model.r.gT(wL));
                                startActivity(intent);
                            } else if (f.kN(wL)) {
                                com.tencent.mm.ac.d kH = f.kH(wL);
                                j = kH == null ? null : kH.Mc();
                                if (j == null) {
                                    j = "";
                                }
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", j);
                                intent2.putExtra("useJs", true);
                                intent2.putExtra("srcUsername", wL);
                                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                                intent2.addFlags(67108864);
                                com.tencent.mm.bg.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
                            } else {
                                cpQ = cpQ();
                                Bundle bundle = new Bundle();
                                bundle.putInt("chat_from_scene", 3);
                                cpQ.startChatting(wL, bundle, false);
                            }
                        }
                        getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
                        getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
                    }
                }
            }
            this.tkr = true;
        } else {
            x.i("MicroMsg.LauncherUI", "resumeLogoutJump");
            com.tencent.mm.ui.MMFragmentActivity.a.cqv();
            j = at.dBv.I("login_user_name", "");
            if (au.HW() || !j.equals("")) {
                g.vw(8);
                com.tencent.mm.kernel.b Eh = com.tencent.mm.kernel.g.Eh();
                Eh.dpP.a(new bg(new 3(Eh), "reset accinfo"), 0);
                x.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", new Object[]{Boolean.valueOf(this.tkq), Boolean.valueOf((this.bSk.getFlags() & 67108864) == 67108864), Boolean.valueOf(s.a(this.bSk, "Intro_Notify", false)), Boolean.valueOf(au.Dr())});
                x.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump hasCfgDefaultUin[%b]", new Object[]{Boolean.valueOf(au.HW())});
                if (s.a(this.bSk, "key_transit_to_switch_account", false)) {
                    x.i("MicroMsg.LauncherUI", "transit to fake switch account");
                    this.bSk.removeExtra("key_transit_to_switch_account");
                    sharedPreferences = ad.getContext().getSharedPreferences("switch_account_preferences", 0);
                    wL = sharedPreferences.getString("last_switch_account_to_wx_username", "");
                    sharedPreferences.edit().putBoolean("transit_to_switch_account", true).commit();
                    intent = new Intent();
                    String I = at.dBv.I("login_weixin_username", "");
                    intent.putParcelableArrayListExtra("key_switch_account_users", this.bSk.getParcelableArrayListExtra("key_switch_account_users"));
                    intent.putExtra("key_switch_from_wx_username", I);
                    intent.putExtra("key_switch_to_wx_username", wL);
                    intent.putExtra("key_langauage_code", w.d(getSharedPreferences(ad.chY(), 0)));
                    x.i("MicroMsg.LauncherUI", "mm pid %d", new Object[]{Integer.valueOf(Process.myPid())});
                    intent.putExtra("key_mm_process_pid", Process.myPid());
                    intent.setClassName(this, "com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI");
                    startActivity(intent);
                    com.tencent.mm.ui.base.b.gG(this);
                    ah.i(new 3(this), 500);
                } else {
                    au.hold();
                    com.tencent.mm.sdk.b.a.sFg.m(new com.tencent.mm.g.a.w());
                    com.tencent.mm.kernel.g.Ek().gi("[" + this.tkq + " " + cpW + " " + a + "]");
                    if (s.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
                        this.tks = true;
                    }
                    gl(this);
                    au.unhold();
                }
            } else {
                if (this.tkt != null) {
                    this.tkt.Zt();
                }
                x.i("MicroMsg.LauncherUI", "resumeLogoutJump but has not login and ret");
                ah.M(this.tkz);
                ah.i(this.tkz, 2000);
            }
        }
        com.tencent.mm.blink.a.fm(5);
        lA(false);
        cpT();
        com.tencent.mm.blink.a.ey("LauncherUI");
    }

    private boolean cpU() {
        if (this.bSk == null || s.a(this.bSk, "Intro_Switch", false) || !au.HW() || au.Dr()) {
            return false;
        }
        return true;
    }

    private boolean cpV() {
        if (this.bSk != null && (s.a(this.bSk, "absolutely_exit", false) || s.a(this.bSk, "absolutely_exit_pid", 0) == Process.myPid())) {
            x.w("MicroMsg.LauncherUI", "resumeLogoutJump launcherOnResume exit absolutely!!! hashCode[%d]", new Object[]{Integer.valueOf(hashCode())});
            finish();
            g.vw(8);
            MMAppMgr.lE(s.a(this.bSk, "kill_service", true));
            System.exit(0);
            return true;
        } else if (this.bSk == null || !s.a(this.bSk, "can_finish", false)) {
            return false;
        } else {
            x.i("MicroMsg.LauncherUI", "resumeLogoutJump exit obviously");
            au.DF().bA(true);
            if (k.bA(getApplicationContext())) {
                Context applicationContext = getApplicationContext();
                applicationContext.stopService(new Intent(applicationContext, CoreService.class));
            }
            g.vw(8);
            sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), "com.tencent.mm.permission.MM_MESSAGE");
            finish();
            com.tencent.mm.ui.base.b.gF(this);
            return true;
        }
    }

    private void at(Intent intent) {
        x.i("MicroMsg.LauncherUI", "handleJump");
        if (au.HX()) {
            is isVar = new is();
            isVar.bSj.bSk = this.bSk;
            com.tencent.mm.sdk.b.a.sFg.m(isVar);
            String j;
            Intent className;
            if ("talkroom_notification".equals(s.j(intent, "nofification_type"))) {
                j = s.j(intent, "enter_chat_usrname");
                if (!bi.oW(j)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("enter_room_username", j);
                    intent2.setFlags(268435456);
                    com.tencent.mm.bg.d.b((Context) this, "talkroom", ".ui.TalkRoomUI", intent2);
                    return;
                }
                return;
            } else if ("back_to_pcmgr_notification".equals(intent.getStringExtra("nofification_type"))) {
                if (intent.getBooleanExtra("newPCBackup", true)) {
                    x.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BackupPcUI");
                    className = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
                } else {
                    x.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BakToPcUI");
                    className = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI");
                }
                className.setFlags(268435456);
                MMWizardActivity.D(this, className);
                return;
            } else if ("back_to_pcmgr_error_notification".equals(intent.getStringExtra("nofification_type"))) {
                className = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
                className.setFlags(268435456);
                MMWizardActivity.D(this, className);
                return;
            } else if ("backup_move_notification".equals(intent.getStringExtra("nofification_type"))) {
                className = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
                className.setFlags(268435456);
                MMWizardActivity.D(this, className);
                return;
            } else {
                int a;
                if (s.a(intent, "show_update_dialog", false)) {
                    a = s.a(intent, "update_type", -1);
                    if (a == -1) {
                        x.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
                    } else {
                        com.tencent.mm.plugin.report.service.h.mEJ.a(405, 28, 1, true);
                        if (com.tencent.mm.plugin.y.d.bfB() != null) {
                            com.tencent.mm.plugin.y.a a2 = com.tencent.mm.plugin.y.d.bfB().a(this, null);
                            if (a2 != null) {
                                com.tencent.mm.plugin.report.service.h.mEJ.a(405, a == 2 ? 29 : 30, 1, true);
                                a2.update(a);
                            }
                        }
                    }
                }
                String j2 = s.j(intent, "Main_User");
                if (j2 == null || j2.equals("")) {
                    a = 0;
                } else {
                    au.HU();
                    com.tencent.mm.storage.ai Yq = com.tencent.mm.model.c.FW().Yq(j2);
                    if (Yq != null) {
                        a = Yq.field_unReadCount;
                    } else {
                        a = 0;
                    }
                    x.i("MicroMsg.LauncherUI", "[oneliang] user:%s, conversation :%s, unReadCount:%s", new Object[]{j2, Yq, Integer.valueOf(a)});
                }
                if (a == 0) {
                    a = s.a(intent, "pushcontent_unread_count", 0);
                }
                MMAppMgr.vo();
                com.tencent.mm.sdk.b.a.sFg.m(new ab());
                boolean a3 = s.a(intent, "Intro_Is_Muti_Talker", true);
                x.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", new Object[]{Boolean.valueOf(a3), Integer.valueOf(a)});
                if (!a3 && a > 0 && s.a(intent, "Intro_Bottle_unread_count", 0) > 0) {
                    x.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", new Object[]{Integer.valueOf(s.a(intent, "Intro_Bottle_unread_count", 0))});
                    com.tencent.mm.bg.d.A(this, "bottle", ".ui.BottleConversationUI");
                }
                LauncherUI cpQ;
                Bundle bundle;
                if (a3 || a <= 0) {
                    if (s.a(intent, "From_fail_notify", false)) {
                        if (!bi.oW(j2)) {
                            cpQ = cpQ();
                            if (cpQ != null) {
                                bundle = new Bundle();
                                bundle.putBoolean("Chat_Mode", s.a(intent, "resend_fail_messages", false));
                                if (f.eZ(j2)) {
                                    intent.putExtra("Contact_User", j2);
                                    intent.addFlags(67108864);
                                    intent.putExtra("biz_chat_from_scene", 4);
                                    com.tencent.mm.bg.d.e(this, ".ui.bizchat.BizChatConversationUI", intent);
                                } else {
                                    cpQ.startChatting(j2, bundle, false);
                                }
                            }
                        } else if (s.a(intent, "jump_sns_from_notify", false)) {
                            className = new Intent();
                            className.addFlags(67108864);
                            className.putExtra("is_need_resend_sns", intent.getBooleanExtra("is_need_resend_sns", false));
                            className.putExtra("sns_resume_state", intent.getBooleanExtra("sns_resume_state", false));
                            className.putExtra("sns_timeline_NeedFirstLoadint", intent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
                            com.tencent.mm.bg.d.b((Context) this, "sns", ".ui.SnsTimeLineUI", className);
                        }
                    } else if (s.a(intent, "biz_chat_need_to_jump_to_chatting_ui", false) && cpQ() != null && f.eZ(j2)) {
                        intent.putExtra("Contact_User", j2);
                        intent.addFlags(67108864);
                        com.tencent.mm.bg.d.e(this, ".ui.bizchat.BizChatConversationUI", intent);
                    }
                } else if (com.tencent.mm.model.s.hv(j2)) {
                    x.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
                    className = new Intent();
                    className.addFlags(67108864);
                    className.putExtra("type", 20);
                    com.tencent.mm.bg.d.b((Context) this, "readerapp", ".ui.ReaderAppUI", className);
                } else if (com.tencent.mm.model.s.hD(j2)) {
                    x.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
                    className = new Intent();
                    className.addFlags(67108864);
                    className.putExtra("type", 11);
                    com.tencent.mm.bg.d.b((Context) this, "readerapp", ".ui.ReaderAppUI", className);
                } else {
                    if (intent.getIntExtra("MainUI_User_Last_Msg_Type", 34) == 34) {
                        a = 2;
                    } else {
                        a = 1;
                    }
                    bundle = new Bundle();
                    bundle.putInt("Chat_Mode", a);
                    if ("new_msg_nofification".equals(s.j(intent, "nofification_type"))) {
                        bundle.putInt("chat_from_scene", 1);
                    }
                    cpQ = cpQ();
                    if (cpQ != null) {
                        if (f.eZ(j2)) {
                            intent.putExtra("Contact_User", j2);
                            intent.addFlags(67108864);
                            intent.putExtra("biz_chat_from_scene", 4);
                            com.tencent.mm.bg.d.e(this, ".ui.bizchat.BizChatConversationUI", intent);
                        } else if (f.kN(j2)) {
                            com.tencent.mm.ac.d kH = f.kH(j2);
                            j = kH == null ? null : kH.Mc();
                            if (j == null) {
                                j = "";
                            }
                            intent.putExtra("rawUrl", j);
                            intent.putExtra("useJs", true);
                            intent.putExtra("srcUsername", j2);
                            intent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                            intent.addFlags(67108864);
                            com.tencent.mm.bg.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                        } else if (com.tencent.mm.storage.ab.gr(j2)) {
                            intent.putExtra("Contact_User", j2);
                            intent.addFlags(67108864);
                            intent.putExtra("app_brand_conversation_from_scene", 3);
                            intent.putExtra("finish_direct", true);
                            intent.putExtra("key_need_send_video", false);
                            com.tencent.mm.bg.d.e(this, ".ui.conversation.AppBrandServiceConversationUI", intent);
                        } else {
                            cpQ.startChatting(j2, bundle, false);
                        }
                    }
                }
                if (s.a(intent, "kstyle_show_bind_mobile_afterauth", 0) > 0) {
                    className = new Intent();
                    className.setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMobileUI");
                    className.putExtra("kstyle_bind_recommend_show", intent.getIntExtra("kstyle_bind_recommend_show", 0));
                    className.putExtra("kstyle_bind_wording", intent.getParcelableExtra("kstyle_bind_wording"));
                    MMWizardActivity.D(this, className);
                    return;
                }
                return;
            }
        }
        x.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
        startActivity(new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864));
        finish();
    }

    private void gl(Context context) {
        Intent intent;
        if (s.a(this.bSk, "LauncherUI.jump_switch_account", false)) {
            x.i("MicroMsg.LauncherUI", "launcher to switch account");
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("switch_account_preferences", 0);
            String string = sharedPreferences.getString("last_switch_account_to_wx_username", "");
            x.i("MicroMsg.LauncherUI", "switch to wxid %s", new Object[]{string});
            sharedPreferences.edit().putBoolean("transit_to_switch_account", false).commit();
            intent = new Intent();
            intent.setClass(this, SettingsSwitchAccountUI.class);
            intent.addFlags(536870912);
            intent.putExtra("key_scene", 1);
            startActivity(intent);
            com.tencent.mm.ui.base.b.gG(this);
            this.bSk.removeExtra("LauncherUI.jump_switch_account");
        } else if (s.a(this.bSk, "Intro_Switch", false) || (au.Dr() && this.tkq)) {
            com.tencent.mrs.a.onDestroy();
            BaseEvent.onSingalCrash(0);
            x.i("MicroMsg.LauncherUI", "switch users count %d", new Object[]{Integer.valueOf(bt.dDs.IH().size())});
            x.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
            x.chR();
            au.unhold();
            finish();
            if (!ad.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("transit_to_switch_account", false)) {
                intent = new Intent(context, LauncherUI.class);
                intent.addFlags(67108864);
                context.startActivity(intent);
            }
            x.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[]{Integer.valueOf(Process.myPid())});
            Process.killProcess(Process.myPid());
        } else if (!s.a(this.bSk, "LauncherUI.jump_switch_account", false)) {
            x.i("MicroMsg.LauncherUI", "jumpToLogin %s", new Object[]{at.dBv.I("login_user_name", "")});
            if (!bi.oW(at.dBv.I("login_user_name", ""))) {
                x.i("MicroMsg.LauncherUI", "switchAccount %s", new Object[]{Boolean.valueOf(ad.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false))});
                if (ad.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false)) {
                    intent = new Intent(this, SettingsSwitchAccountUI.class);
                    intent.addFlags(67108864);
                    intent.putExtra("key_scene", 2);
                    startActivity(intent);
                } else {
                    int WU = bi.WU(at.dBv.I("last_login_use_voice", ""));
                    x.i("MicroMsg.LauncherUI", "pluginSwitch  " + WU);
                    if ((WU & 131072) != 0) {
                        startActivity(new Intent().setClassName(this, "com.tencent.mm.plugin.account.ui.LoginVoiceUI"));
                    } else {
                        startActivity(new Intent().setClassName(this, "com.tencent.mm.plugin.account.ui.LoginPasswordUI"));
                    }
                }
                com.tencent.mm.ui.base.b.gD(this);
            } else if (this.tkt == null) {
                this.tkt = new WelcomeSelectView(this);
                setContentView(this.tkt);
                this.tkt.Zt();
            }
            g.vw(8);
            ah.M(this.tkz);
            ah.i(this.tkz, 2000);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Object obj;
        super.onActivityResult(i, i2, intent);
        x.v("MicroMsg.LauncherUI", "edw on activity result");
        ac acVar = this.tko;
        if (i == 2001 && acVar.tpn != null) {
            acVar.tpn.onActivityResult(i, i2, intent);
        }
        x.w("MicroMsg.LauncherUI.NewChattingTabUI", "check request code %d", new Object[]{Integer.valueOf(65535 & i)});
        switch (65535 & i) {
            case 217:
            case 218:
            case 226:
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj == null || acVar.tpn != null) {
            obj = null;
        } else {
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
            ah.M(acVar.tpp);
            acVar.tpp.tpz = 0;
            acVar.tpp.bRZ = i;
            acVar.tpp.bjW = i2;
            acVar.tpp.bSa = intent;
            ah.A(acVar.tpp);
            obj = 1;
        }
        if (obj == null) {
            HomeUI homeUI = this.tkn;
            if (!homeUI.tjr) {
                return;
            }
            if (i == 1) {
                au.HU();
                if (!ai.d((Boolean) com.tencent.mm.model.c.DT().get(12323, null))) {
                    aa.showAddrBookUploadConfirm(homeUI.tiY, null, false, 3);
                    return;
                }
                return;
            }
            Bundle bundle;
            if (i == 22722) {
                x.i("MicroMsg.LauncherUI.HomeUI", "showAgreements %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                bundle = null;
                if (intent != null) {
                    bundle = intent.getBundleExtra("result_data");
                }
                if (bundle == null || !bundle.getString("go_next", "").equals("agree_privacy")) {
                    x.i("MicroMsg.LauncherUI.HomeUI", "disagree privacy policy");
                    com.tencent.mm.kernel.g.DF().a(new com.tencent.mm.plugin.account.model.e(2), 0);
                    com.tencent.mm.plugin.report.service.h.mEJ.a(712, 5, 1, false);
                } else {
                    x.i("MicroMsg.LauncherUI.HomeUI", "agree privacy policy");
                    com.tencent.mm.plugin.report.service.h.mEJ.a(712, 4, 1, false);
                    com.tencent.mm.kernel.g.DF().a(new com.tencent.mm.plugin.account.model.e(1), 0);
                    if (com.tencent.mm.al.b.ml((String) com.tencent.mm.kernel.g.Ei().DT().get(274436, null)) && com.tencent.mm.kernel.g.Ei().DT().getBoolean(com.tencent.mm.storage.aa.a.sZR, false)) {
                        x.i("MicroMsg.LauncherUI.HomeUI", "needbirthday true");
                        String string = homeUI.tiY.getString(com.tencent.mm.plugin.account.a.j.gdpr_login_verifybirthday_url, new Object[]{w.chP()});
                        if (com.tencent.mm.kernel.g.Ei().DT().getBoolean(com.tencent.mm.storage.aa.a.sZT, false)) {
                            homeUI.z(string, 22723, homeUI.tiY.getString(R.l.gdpr_warn_privacy_url, new Object[]{w.chP()}));
                        } else {
                            x.i("MicroMsg.LauncherUI.HomeUI", "needconfirm false");
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("close_dialog_msg", homeUI.tju);
                            bundle2.putString("close_dialog_cancel", homeUI.tjw);
                            bundle2.putString("close_dialog_ok", homeUI.tjv);
                            bundle2.putBoolean("close_dialog_ok_close", false);
                            homeUI.g(string, 22723, bundle2);
                        }
                        com.tencent.mm.ui.base.b.gG(homeUI.tiY);
                    }
                }
            } else if (i == 22723) {
                bundle = null;
                if (intent != null) {
                    bundle = intent.getBundleExtra("result_data");
                }
                if (bundle != null) {
                    if (bundle.getString("go_next", "").equals("birthdayComfirmOK")) {
                        x.i("MicroMsg.LauncherUI.HomeUI", "verify birthday ok");
                        com.tencent.mm.kernel.g.Ei().DT().a(com.tencent.mm.storage.aa.a.sZR, Boolean.valueOf(false));
                    } else if (bundle.getString("go_next", "").equals("gdpr_confirm_logout")) {
                        x.i("MicroMsg.LauncherUI.HomeUI", "quit verify birthday after H5-warnning");
                        com.tencent.mm.kernel.g.DF().a(new com.tencent.mm.plugin.account.model.e(2), 0);
                        com.tencent.mm.plugin.report.service.h.mEJ.a(712, 5, 1, false);
                    }
                }
            }
            if (i == 65534 && i2 == -1) {
                af.Wq("welcome_page_show");
                k.j(homeUI.tiY, true);
                MMAppMgr.vo();
                MMAppMgr.h(homeUI.tiY, true);
                homeUI.tiY.finish();
            }
        }
    }

    protected void onPause() {
        x.d("MicroMsg.LauncherUI", "onPause, chatting is show ");
        super.onPause();
        r rVar = this.tku;
        boolean cE = rVar.cE("onPause");
        if (cE) {
            rVar.qym = false;
        }
        if (cE) {
            x.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onPause");
            return;
        }
        com.tencent.mm.blink.a.xe();
        x.i("MicroMsg.LauncherUI", "not skip this onPause");
        x currentFragmet = getCurrentFragmet();
        this.tky.removeCallbacksAndMessages(null);
        HomeUI homeUI = this.tkn;
        z zVar = homeUI.tjF;
        x.v("MicroMsg.LauncherUI.MainTabUI", "doOnPause %d, mainTabHasCreate:%b", new Object[]{Integer.valueOf(zVar.iUy), Boolean.valueOf(homeUI.tjr)});
        if (homeUI.tjr) {
            zVar.cqy();
        }
        aa aaVar = zVar.toc;
        if (au.HX()) {
            au.HU();
            com.tencent.mm.model.c.DT().b(aaVar.toA);
            au.HU();
            com.tencent.mm.model.c.FW().b(aaVar);
            com.tencent.mm.s.c.Cp().b(aaVar.toz);
            com.tencent.mm.sdk.b.a.sFg.c(aaVar.toB);
            com.tencent.mm.sdk.b.a.sFg.c(aaVar.tiz);
            com.tencent.mm.sdk.b.a.sFg.c(aaVar.tiy);
        }
        j jVar = homeUI.tjE;
        if (jVar.tjb != null) {
            au.DF().b(255, jVar.tjb);
            au.DF().b(384, jVar.tjb);
            jVar.tjb = null;
        }
        com.tencent.mm.sdk.a.b.bB(false);
        homeUI.tjC = com.tencent.mm.ui.HomeUI.a.tjZ;
        if (!au.HM()) {
            au.getNotification().aR(false);
        }
        boolean cpW = homeUI.tjD.cpW();
        x.i("MicroMsg.LauncherUI.HomeUI", "edw onPause, chatting is show " + cpW);
        if (!cpW) {
            k.a(homeUI.tiY, 4, homeUI.tjF.iUy, "directReport_onPause");
        }
        if (!homeUI.tiY.isFinishing()) {
            com.tencent.mm.ui.widget.g.a(homeUI.tiY);
        }
        if (homeUI.tjr) {
            x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onMainTabPause");
            com.tencent.mm.blink.b.xi().xk();
            if (au.HX()) {
                com.tencent.mm.sdk.b.a.sFg.c(homeUI.tjN);
            }
        }
        if (homeUI.tjx != null && homeUI.tjx.isShowing()) {
            homeUI.tjx.dismiss();
        }
        ac acVar = this.tko;
        if (acVar.cpW()) {
            acVar.kB(4);
            if (acVar.tpn != null && acVar.tpn.isSupportNavigationSwipeBack()) {
                acVar.tpn.getSwipeBackLayout().setEnableGesture(false);
            }
        }
        if (currentFragmet == null) {
            this.tkr = false;
        }
    }

    protected void onStop() {
        x.i("MicroMsg.LauncherUI", "onStop");
        com.tencent.mm.blink.a.xe();
        ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().b("showprivacypolicy", this.tkn.tjR);
        super.onStop();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.tkx = false;
        if (!this.tkp.a(this, i, strArr, iArr)) {
            HomeUI homeUI = this.tkn;
            switch (i) {
                case 16:
                case i$l.AppCompatTheme_panelMenuListTheme /*80*/:
                    int i2 = i == 80 ? R.l.permission_microphone_request_again_msg : R.l.permission_camera_request_again_msg;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(homeUI.tiY, homeUI.getString(i2), homeUI.getString(R.l.permission_tips_title), homeUI.getString(R.l.jump_to_settings), homeUI.getString(R.l.cancel), false, new 14(homeUI), new 15(homeUI));
                        break;
                    }
                    break;
                case i$l.AppCompatTheme_textAppearanceSearchResultTitle /*65*/:
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(homeUI.tiY, homeUI.getString(R.l.permission_location_request_again_msg), homeUI.getString(R.l.permission_tips_title), homeUI.getString(R.l.jump_to_settings), homeUI.getString(R.l.cancel), false, new 16(homeUI), null);
                        break;
                    } else {
                        homeUI.cpy();
                        break;
                    }
                case i$l.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(homeUI.tiY, homeUI.getString(R.l.permission_location_request_again_msg), homeUI.getString(R.l.permission_tips_title), homeUI.getString(R.l.jump_to_settings), homeUI.getString(R.l.cancel), false, new 17(homeUI), null);
                        break;
                    }
                    x cqx = homeUI.tjF.cqx();
                    if (cqx instanceof h) {
                        ((h) cqx).cpl();
                        break;
                    }
                    break;
            }
            ac acVar = this.tko;
            if (acVar.tpn != null) {
                acVar.tpn.onRequestPermissionsResult(i, strArr, iArr);
            }
        }
    }

    protected void onDestroy() {
        com.tencent.mm.blink.a.xe();
        super.onDestroy();
        HomeUI homeUI = this.tkn;
        z zVar = homeUI.tjF;
        com.tencent.mm.sdk.b.a.sFg.c(zVar.tol);
        zVar.ton.clear();
        if (homeUI.tjE != null) {
            j jVar = homeUI.tjE;
            com.tencent.mm.sdk.b.a.sFg.c(jVar.tjd);
            com.tencent.mm.sdk.b.a.sFg.c(jVar.tje);
        }
        if (homeUI.tjr) {
            Looper.myQueue().removeIdleHandler(homeUI.tjO);
        }
        ac acVar = this.tko;
        if (!(acVar.mPrepareBitmap == null || acVar.mPrepareBitmap.isRecycled())) {
            acVar.mPrepareBitmap.recycle();
        }
        ah.M(acVar.tpq);
        Looper.myQueue().removeIdleHandler(acVar.tpi);
        cpS();
        x.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bi.fV(this), Integer.valueOf(tkk.size())});
    }

    public void finish() {
        super.finish();
        cpS();
        x.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(tkk.size()), bi.cjd()});
    }

    public void onSwipe(float f) {
        int i = 1;
        if (this.tkq) {
            ac acVar = this.tko;
            x.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::on swipe %f, duration %d, resumeStatus %b", new Object[]{Float.valueOf(f), Long.valueOf(220), Boolean.valueOf(acVar.tpe.cpA())});
            if (acVar.bWY()) {
                ImageView imageView;
                boolean z;
                if (f == 0.0f && !acVar.mChattingClosed) {
                    imageView = (ImageView) acVar.nfG.getWindow().getDecorView().findViewById(R.h.prepare_imageview);
                    if (imageView != null) {
                        ViewGroup viewGroup = (ViewGroup) imageView.getTag();
                        if (viewGroup != null) {
                            Bitmap magicDrawingCache = acVar.getMagicDrawingCache(viewGroup);
                            if (magicDrawingCache != null) {
                                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView VISIBLE");
                                imageView.setVisibility(0);
                                imageView.setImageBitmap(magicDrawingCache);
                                viewGroup.setVisibility(8);
                            } else {
                                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE no cache!");
                                viewGroup.setVisibility(0);
                                imageView.setVisibility(8);
                                imageView.setImageDrawable(null);
                            }
                        }
                    }
                    if (acVar.mChattingInAnim != null) {
                        acVar.mChattingInAnim.cancel();
                    }
                } else if (f == 1.0f && !acVar.mChattingClosed && acVar.bWY()) {
                    acVar.nfG.getWindow().setBackgroundDrawableResource(R.e.room_info_comment_layout_bg);
                    imageView = (ImageView) acVar.nfG.getWindow().getDecorView().findViewById(R.h.prepare_imageview);
                    if (!(imageView == null || imageView.getVisibility() != 0 || imageView.getTag() == null)) {
                        ((View) imageView.getTag()).setVisibility(0);
                        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
                        imageView.setVisibility(8);
                    }
                }
                if (acVar.tpe.cpA()) {
                    z = true;
                } else if (Float.compare(1.0f, f) > 0) {
                    x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] return! consumedSuperCall:%s", new Object[]{Boolean.valueOf(false)});
                    i = 0;
                } else {
                    z = false;
                }
                View findViewById = acVar.nfG.findViewById(R.h.launcher_container);
                imageView = (ImageView) acVar.nfG.findViewById(R.h.prepare_imageview);
                if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null || acVar.mChattingClosed || f == 1.0f || f == 0.0f)) {
                    imageView.setVisibility(0);
                    x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                }
                if (Float.compare(1.0f, f) <= 0) {
                    i.n(findViewById, 0.0f);
                    i.n(imageView, 0.0f);
                } else if (imageView == null || imageView.getDrawable() == null) {
                    i.n(findViewById, ((((float) findViewById.getWidth()) / 2.5f) * (1.0f - f)) * -1.0f);
                } else {
                    i.n(imageView, ((((float) imageView.getWidth()) / 2.5f) * (1.0f - f)) * -1.0f);
                }
                boolean i2 = z;
            }
            if (i2 == 0) {
                super.onSwipe(f);
            }
        }
    }

    public void onSettle(boolean z, int i) {
        if (this.tkq && !this.tko.v(z, i)) {
            super.onSettle(z, i);
        }
    }

    public boolean forceRemoveNoMatchOnPath() {
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        int i;
        if (this.tko.cpW()) {
            ac acVar = this.tko;
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
                ah.M(acVar.tpq);
            }
            if (acVar.isAnimating) {
                z = true;
            } else {
                z = acVar.tpn.onKeyDown(keyEvent.getKeyCode(), keyEvent);
            }
            if (z) {
                return true;
            }
        }
        HomeUI homeUI = this.tkn;
        x.i("MicroMsg.LauncherUI.HomeUI", "ui group onKeyDown, code:%d action:%d", new Object[]{Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction())});
        com.tencent.mm.compatible.b.f.yD();
        com.tencent.mm.compatible.b.f.yD();
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && homeUI.tjx != null && homeUI.tjx.isShowing()) {
            homeUI.tjx.dismiss();
            i = 1;
        } else if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1) {
            homeUI.cpx();
            i = 1;
        } else {
            x cqx = homeUI.tjF.cqx();
            if (cqx == null || !cqx.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
                if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
                    if (au.HX() && com.tencent.mm.kernel.g.Eg().dpD && com.tencent.mm.sdk.platformtools.ao.isWap(homeUI.tiY)) {
                        MMFragmentActivity mMFragmentActivity = homeUI.tiY;
                        9 9 = new 9(homeUI);
                        if (au.HX()) {
                            au.HU();
                            int intValue = ((Integer) com.tencent.mm.model.c.DT().get(65, Integer.valueOf(0))).intValue();
                            if (intValue >= 5) {
                                z = false;
                            } else if (af.Wp("show_wap_adviser")) {
                                View inflate = View.inflate(mMFragmentActivity, R.i.network_tips, null);
                                ((TextView) inflate.findViewById(R.h.network_tips_content)).setText(R.l.network_use_net);
                                com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(mMFragmentActivity);
                                aVar.Gq(R.l.app_tip);
                                aVar.dR(inflate);
                                aVar.Gt(R.l.app_ok).a(new 10(intValue));
                                aVar.mF(false);
                                aVar.Gu(R.l.network_do_not_remind).b(new 11());
                                aVar.a(new MMAppMgr.12(9));
                                aVar.anj().show();
                                z = true;
                            } else {
                                z = false;
                            }
                        } else {
                            z = false;
                        }
                        if (z) {
                            i = 1;
                        }
                    }
                    int backgroundLimitType = com.tencent.mm.sdk.platformtools.ao.getBackgroundLimitType(homeUI.tiY);
                    if (au.HX() && com.tencent.mm.kernel.g.Eg().dpD && com.tencent.mm.sdk.platformtools.ao.isLimited(backgroundLimitType)) {
                        au.HU();
                        if (ai.c((Boolean) com.tencent.mm.model.c.DT().get(16385, null)) && MMAppMgr.a(homeUI.tiY, backgroundLimitType, new HomeUI.10(homeUI, backgroundLimitType), new HomeUI.11(homeUI))) {
                            i = 1;
                        }
                    }
                    homeUI.coF();
                }
                z = false;
            } else {
                i = 1;
            }
        }
        if (i != 0) {
            return true;
        }
        try {
            return super.dispatchKeyEvent(keyEvent);
        } catch (Throwable e) {
            x.w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.LauncherUI", e, "", new Object[0]);
            return false;
        }
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.tko.tpk = bundle.getString("last_restore_talker");
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "onRestoreInstanceState:%s", new Object[]{r0.tpk});
    }

    protected void onSaveInstanceState(Bundle bundle) {
        ac acVar = this.tko;
        if (acVar.tpn != null) {
            String talkerUserName = acVar.tpn.bAG.getTalkerUserName();
            if (!ai.oW(talkerUserName)) {
                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "onSaveInstanceState:%s", new Object[]{talkerUserName});
                bundle.putString("last_restore_talker", talkerUserName);
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z = false;
        HomeUI homeUI = this.tkn;
        x currentFragmet = homeUI.tiY.getCurrentFragmet();
        if ((currentFragmet == null || !currentFragmet.isShowing()) && !homeUI.tjD.cpW()) {
            if (menuItem.getItemId() == 2) {
                com.tencent.mm.plugin.report.service.h.mEJ.k(10919, "0");
                homeUI.cpx();
            } else if (menuItem.getItemId() == 1) {
                homeUI.cpy();
            }
            z = true;
        }
        if (z) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.tko.cpW()) {
            return false;
        }
        HomeUI homeUI = this.tkn;
        if (homeUI.tjD == null || homeUI.tjD.cpW()) {
            return false;
        }
        int dimensionPixelSize;
        int height = homeUI.tiY.getSupportActionBar().getHeight();
        if (height == 0) {
            DisplayMetrics displayMetrics = homeUI.tiY.getResources().getDisplayMetrics();
            dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? homeUI.tiY.getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand) : homeUI.tiY.getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
        } else {
            dimensionPixelSize = height;
        }
        homeUI.tjL = menu.add(0, 1, 0, R.l.top_item_desc_search);
        homeUI.tjL.setIcon(R.k.actionbar_icon_dark_search);
        if (homeUI.mQO) {
            homeUI.tjL.setIcon(R.k.actionbar_icon_light_search);
        }
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(homeUI.tiY, 68);
        homeUI.tjM = menu.add(0, 2, 0, R.l.top_item_desc_more);
        if (homeUI.tjI == null) {
            LayoutParams layoutParams = new LayoutParams(fromDPToPix, dimensionPixelSize);
            homeUI.tjI = com.tencent.mm.kiss.a.b.EY().a(homeUI.tiY, "R.layout.actionview_with_dot_tips", R.i.actionview_with_dot_tips);
            homeUI.tjJ = (ImageView) homeUI.tjI.findViewById(R.h.icon);
            homeUI.tjK = homeUI.tjI.findViewById(R.h.tips);
            homeUI.tjI.setLayoutParams(layoutParams);
            homeUI.tjI.setBackgroundResource(R.g.actionbar_menu_selector);
            homeUI.tjI.setMinimumHeight(dimensionPixelSize);
            homeUI.tjI.setMinimumWidth(fromDPToPix);
            homeUI.tjJ.setImageResource(R.k.actionbar_icon_dark_add);
            homeUI.tjI.setContentDescription(homeUI.getString(R.l.top_item_desc_more));
            homeUI.tjI.setOnClickListener(new 25(homeUI));
            homeUI.tjI.post(new HomeUI$2(homeUI));
        }
        if (homeUI.mQO && homeUI.tjJ != null) {
            homeUI.tjJ.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
        }
        com.tencent.mm.blink.b.xi().g(new HomeUI.3(homeUI));
        android.support.v4.view.m.a(homeUI.tjM, homeUI.tjI);
        if (homeUI.tjL != null) {
            android.support.v4.view.m.a(homeUI.tjL, 2);
            homeUI.tjL.setVisible(true);
        }
        if (homeUI.tjM != null) {
            android.support.v4.view.m.a(homeUI.tjM, 2);
            homeUI.tjM.setVisible(true);
        }
        homeUI.tjI.getLayoutParams().width = fromDPToPix;
        homeUI.tjI.getLayoutParams().height = dimensionPixelSize;
        x.v("MicroMsg.LauncherUI.HomeUI", "onCreateOptionsMenu");
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        HomeUI homeUI = this.tkn;
        e.a(homeUI.tiY, homeUI.contentView);
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        ActionMode actionMode = null;
        ac acVar = this.tko;
        if (!(acVar.tpn == null || acVar.tpn.csU() == null || !acVar.tpn.isSupportCustomActionBar() || com.tencent.mm.compatible.util.d.fT(22))) {
            ActionMode startActionMode = acVar.tpn.csU().startActionMode(callback);
            if (startActionMode != null) {
                actionMode = startActionMode;
            }
        }
        if (actionMode == null) {
            return super.onWindowStartingActionMode(callback);
        }
        return actionMode;
    }

    public x getCurrentFragmet() {
        ac acVar = this.tko;
        x xVar = !acVar.mChattingClosed ? acVar.tpn : null;
        if (xVar == null) {
            return super.getCurrentFragmet();
        }
        return xVar;
    }

    public static void gm(Context context) {
        Intent intent = new Intent(context, LauncherUI.class);
        intent.addFlags(67108864);
        context.startActivity(intent);
    }

    public final void startChatting(String str, Bundle bundle, boolean z) {
        HomeUI homeUI = this.tkn;
        if (q.Hn().booleanValue() && (HomeUI.tjy.booleanValue() || HomeUI.tjz.booleanValue())) {
            homeUI.c(Boolean.valueOf(false), Boolean.valueOf(false));
        }
        homeUI.tjF.cqz();
        this.tko.startChatting(str, bundle, z);
    }

    public final void closeChatting(boolean z) {
        boolean z2;
        5 5 = new 5(this);
        ac acVar = this.tko;
        String str = "MicroMsg.LauncherUI.NewChattingTabUI";
        String str2 = "try closeChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(acVar.tpg == null ? false : acVar.tpg.isShown());
        x.i(str, str2, objArr);
        if (!(acVar.tpn == null || acVar.tpn.getView() == null)) {
            acVar.tpn.getView().setImportantForAccessibility(4);
        }
        if (acVar.tpg == null || acVar.tpg.getVisibility() == 8 || acVar.tpn == null || acVar.nfG == null) {
            z2 = false;
        } else {
            if (acVar.tpn != null && acVar.tpn.isSupportNavigationSwipeBack()) {
                com.tencent.mm.ui.widget.g.b(acVar.nfG);
            }
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] needAnim:%b", new Object[]{Boolean.valueOf(z)});
            acVar.kB(4);
            acVar.mChattingClosed = true;
            if (acVar.mChattingOutAnim == null) {
                acVar.mChattingOutAnim = AnimationUtils.loadAnimation(acVar.nfG, com.tencent.mm.ui.MMFragmentActivity.a.tnF);
                acVar.mChattingOutAnim.setAnimationListener(new ac.6(acVar, 5));
            }
            com.tencent.mm.ui.base.x.b(true, new Intent().putExtra("classname", "mainui").putExtra("main_process", false));
            if (acVar.tpn.isSupportCustomActionBar()) {
                ImageView imageView = (ImageView) acVar.nfG.getWindow().getDecorView().findViewById(R.h.prepare_imageview);
                if (imageView != null && imageView.getVisibility() == 0) {
                    imageView.setVisibility(8);
                    x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] prepareView GONE");
                    if (imageView.getTag() != null) {
                        ((View) imageView.getTag()).setVisibility(0);
                    }
                }
            }
            if (z) {
                acVar.tpo.cpO();
                acVar.tpo.cpP();
                acVar.tpg.startAnimation(acVar.mChattingOutAnim);
            } else {
                acVar.tpo.cpO();
                acVar.tpo.cpP();
                acVar.tpg.setVisibility(8);
                acVar.nfG.onSwipe(1.0f);
                acVar.tryResetChattingSwipeStatus();
            }
            z2 = true;
        }
        if (z2) {
            HomeUI homeUI = this.tkn;
            if (!this.tko.tpn.isSupportCustomActionBar()) {
                homeUI.initActionBar();
            }
            homeUI.tiY.supportInvalidateOptionsMenu();
            if (q.Hn().booleanValue()) {
                homeUI.cpw();
            }
            z zVar = homeUI.tjF;
            if (zVar.iUy == 0 && com.tencent.mm.kernel.g.Eh().dpP.foreground) {
                au.getNotification().aR(true);
            } else {
                au.getNotification().aR(false);
            }
            ViewGroup viewGroup = (ViewGroup) zVar.tiY.findViewById(R.h.launcher_container);
            if (viewGroup != null) {
                viewGroup.setImportantForAccessibility(1);
            }
            zVar.cpC();
            k.a(zVar.tiY, 3, zVar.iUy, "prepareCloseChatting");
            j jVar = (j) zVar.ton.get(Integer.valueOf(0));
            if (jVar != null) {
                jVar.getContentView();
                if (jVar.mController != null) {
                    jVar.mController.onResume();
                }
                jVar.onHiddenChanged(false);
            }
        }
    }
}
