package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.g;
import com.tencent.mm.plugin.exdevice.f.a.h;
import com.tencent.mm.plugin.exdevice.f.a.i;
import com.tencent.mm.plugin.exdevice.f.a.k;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.e;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.sport.ui.SportChartView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bre;
import com.tencent.mm.protocal.c.cig;
import com.tencent.mm.protocal.c.kc;
import com.tencent.mm.protocal.c.xj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import junit.framework.Assert;

public class ExdeviceProfileUI extends MMActivity implements e, c {
    private static int iEp = 0;
    private boolean En = false;
    private TextPaint dG = new TextPaint(1);
    private int duy = 0;
    private String gaG;
    private String gtX;
    private p iBL = null;
    private List<kc> iDB;
    private String iDS;
    private a iDT;
    private ArrayList<String> iDU;
    private cig iDV;
    private ExdeviceProfileAffectedUserView iDW;
    private ImageView iDX;
    private ListView iDY;
    private ExdeviceProfileListHeader iDZ;
    private boolean iDw;
    private boolean iDx;
    private int iDy;
    private MMSwitchBtn iEa;
    private SportChartView iEb;
    private a iEc;
    private View iEd;
    private volatile boolean iEe;
    private String iEf;
    private String iEg;
    private List<com.tencent.mm.plugin.sport.b.e> iEh;
    private ArrayList<c> iEi;
    private List<xj> iEj;
    private int iEk;
    private b<i> iEl = new 1(this);
    private d iEm = new 29(this);
    private b<h> iEn = new 31(this);
    private b<g> iEo = new b<g>() {
        public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
            x.i("MicroMsg.Sport.ExdeviceProfileUI", "on NetSceneAddFollow end,errType:" + i + "  errCode:" + i2 + "  errMsg:" + str);
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.this.finish();
            }
        }
    };
    private Runnable iEq = new Runnable() {
        public final void run() {
            BackwardSupportUtil.c.a(ExdeviceProfileUI.this.iDY);
            if (ExdeviceProfileUI.this.iDY.getCount() > 0) {
                BackwardSupportUtil.c.b(ExdeviceProfileUI.this.iDY, ExdeviceProfileUI.this.iDY.getCount() - 1);
            }
        }
    };
    private b<g> iEr = new 15(this);
    private List<String> iEs;
    private b<k> iEt = new 17(this);
    private com.tencent.mm.sdk.b.c<ll> iEu = new com.tencent.mm.sdk.b.c<ll>() {
        {
            this.sFo = ll.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ll llVar = (ll) bVar;
            x.i("MicroMsg.Sport.ExdeviceProfileUI", "count: %d ret: %s title: %s content: %s", new Object[]{Integer.valueOf(llVar.bVN.count), Integer.valueOf(llVar.bVN.ret), llVar.bVN.bVO, llVar.bVN.bVP});
            if (ExdeviceProfileUI.this.iBL != null && ExdeviceProfileUI.this.iBL.isShowing()) {
                ExdeviceProfileUI.this.iBL.dismiss();
            }
            ExdeviceProfileUI.this.iEu.dead();
            Intent intent = new Intent();
            intent.putExtra("KeyNeedUpdateRank", true);
            ExdeviceProfileUI.this.setResult(-1, intent);
            ExdeviceProfileUI.this.finish();
            return false;
        }
    };
    private GestureDetector iEv;
    private MMPullDownView.a iEw = new MMPullDownView.a() {
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ExdeviceProfileUI.this.iEv.onTouchEvent(motionEvent);
        }
    };
    private boolean ixI;
    private List<String> ixY;
    private List<String> ixZ;
    private String ixv;
    private String mAppName;
    private Context mContext;

    static /* synthetic */ void A(ExdeviceProfileUI exdeviceProfileUI) {
        if (VERSION.SDK_INT >= 11) {
            View childAt = exdeviceProfileUI.iDY.getChildAt(0);
            int[] iArr = new int[2];
            if (childAt != null && exdeviceProfileUI.iDY.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (iEp == 0) {
                    iEp = iArr[1];
                }
                int i = iArr[1];
                if (i > (-iEp) / 2) {
                    exdeviceProfileUI.iDW.setAlpha(i > 0 ? ((float) (i * 2)) / (((float) iEp) * 2.0f) : ((float) i) / ((float) iEp));
                    exdeviceProfileUI.iDW.setVisibility(0);
                    return;
                }
                exdeviceProfileUI.iDW.setAlpha(0.0f);
                exdeviceProfileUI.iDW.setVisibility(8);
            }
        }
    }

    static /* synthetic */ void B(ExdeviceProfileUI exdeviceProfileUI) {
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(exdeviceProfileUI.mController.tml, 1, false);
        dVar.ofp = new 30(exdeviceProfileUI);
        dVar.ofq = exdeviceProfileUI.iEm;
        dVar.bXO();
    }

    static /* synthetic */ void E(ExdeviceProfileUI exdeviceProfileUI) {
        Intent intent = new Intent();
        String c = bi.c(exdeviceProfileUI.iEs, ",");
        intent.putExtra("wechat_sport_contact", bi.c(exdeviceProfileUI.ixY, ","));
        intent.putExtra("wechat_sport_recent_like", c);
        c = bi.c(exdeviceProfileUI.ixZ, ",");
        intent.putExtra("titile", exdeviceProfileUI.getString(R.l.exdevice_add_follower));
        intent.putExtra("list_type", 12);
        intent.putExtra("max_limit_num", 10);
        intent.putExtra("too_many_member_tip_string", exdeviceProfileUI.getString(R.l.exdevice_add_follower_too_many_contact, new Object[]{Integer.valueOf(10)}));
        intent.putExtra("list_attr", s.s(new int[]{2, 4, 1, 131072, 128, 64, 16384}));
        intent.putExtra("always_select_contact", c);
        com.tencent.mm.bg.d.b(exdeviceProfileUI, ".ui.contact.SelectContactUI", intent, 3);
    }

    static /* synthetic */ List aT(List list) {
        List arrayList = new ArrayList();
        for (bre bre : list) {
            com.tencent.mm.plugin.sport.b.e eVar = new com.tencent.mm.plugin.sport.b.e();
            eVar.field_step = bre.fHo;
            eVar.field_timestamp = ((long) bre.timestamp) * 1000;
            eVar.field_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(eVar.field_timestamp));
            arrayList.add(eVar);
        }
        return arrayList;
    }

    static /* synthetic */ void g(ExdeviceProfileUI exdeviceProfileUI) {
        exdeviceProfileUI.mController.removeAllOptionMenu();
        if (q.GF().equals(exdeviceProfileUI.gtX)) {
            exdeviceProfileUI.addIconOptionMenu(0, R.g.mm_title_btn_menu, new 12(exdeviceProfileUI));
            return;
        }
        au.HU();
        boolean Yc = com.tencent.mm.model.c.FR().Yc(exdeviceProfileUI.gtX);
        au.HU();
        boolean BB = com.tencent.mm.model.c.FR().Yg(exdeviceProfileUI.gtX).BB();
        if (exdeviceProfileUI.iDx && Yc) {
            exdeviceProfileUI.addIconOptionMenu(0, R.g.mm_title_btn_menu, new 23(exdeviceProfileUI));
        } else if (!BB) {
            exdeviceProfileUI.addIconOptionMenu(0, R.g.mm_title_btn_menu, new 26(exdeviceProfileUI));
        }
    }

    static /* synthetic */ void k(ExdeviceProfileUI exdeviceProfileUI) {
        if (exdeviceProfileUI.iEb == null) {
            exdeviceProfileUI.iEb = (SportChartView) exdeviceProfileUI.findViewById(R.h.exdevice_rank_step_chart);
        }
        if (exdeviceProfileUI.iEa == null) {
            exdeviceProfileUI.iEa = (MMSwitchBtn) exdeviceProfileUI.findViewById(R.h.exdevice_step_chart_switch_btn);
        }
        if (exdeviceProfileUI.iEh == null || exdeviceProfileUI.iEh.size() <= 0) {
            exdeviceProfileUI.iEb.setHasSwitchBtn(false);
            exdeviceProfileUI.iEa.setVisibility(8);
            exdeviceProfileUI.iEb.cy(null);
            return;
        }
        if (exdeviceProfileUI.iDw) {
            exdeviceProfileUI.iEb.setHasSwitchBtn(true);
            exdeviceProfileUI.iEa.setVisibility(0);
            exdeviceProfileUI.iEa.setSwitchListener(new 22(exdeviceProfileUI));
        } else {
            exdeviceProfileUI.iEb.setHasSwitchBtn(false);
            exdeviceProfileUI.iEa.setVisibility(8);
            exdeviceProfileUI.iEb.xT(SportChartView.a.opM);
            exdeviceProfileUI.iEb.cy(exdeviceProfileUI.iEh);
        }
        exdeviceProfileUI.iEb.setTodayStep(((com.tencent.mm.plugin.sport.b.e) exdeviceProfileUI.iEh.get(exdeviceProfileUI.iEh.size() - 1)).field_step);
        exdeviceProfileUI.iEb.cy(exdeviceProfileUI.iEh);
        com.tencent.mm.plugin.sport.b.e bFy = ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.sport.b.b.class)).bFy();
        Calendar instance = Calendar.getInstance();
        instance.add(5, -1);
        instance.set(10, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        long timeInMillis = instance.getTimeInMillis();
        instance.add(5, -120);
        instance.set(10, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis2 = instance.getTimeInMillis();
        if (bFy != null) {
            instance.setTimeInMillis(bFy.field_timestamp);
            instance.add(5, 2);
            if (instance.getTimeInMillis() > timeInMillis) {
                exdeviceProfileUI.r(timeInMillis2, timeInMillis);
                return;
            }
        }
        ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.sport.b.b.class)).a(timeInMillis2, timeInMillis, new 24(exdeviceProfileUI, timeInMillis2, timeInMillis));
    }

    static /* synthetic */ void r(ExdeviceProfileUI exdeviceProfileUI) {
        ac acVar = new ac();
        String valueOf = String.valueOf(exdeviceProfileUI.iEk);
        String str = "0";
        if (exdeviceProfileUI.iDV != null) {
            str = String.valueOf(exdeviceProfileUI.iDV.score);
        }
        acVar.a(exdeviceProfileUI, valueOf, str, exdeviceProfileUI.gaG, new 19(exdeviceProfileUI));
    }

    static /* synthetic */ void s(ExdeviceProfileUI exdeviceProfileUI) {
        String valueOf = String.valueOf(exdeviceProfileUI.iEk);
        String str = "0";
        if (exdeviceProfileUI.iDV != null) {
            str = String.valueOf(exdeviceProfileUI.iDV.score);
        }
        new ac().a(exdeviceProfileUI, valueOf, str, exdeviceProfileUI.gaG, new ac.a() {
            public final void zZ(String str) {
                ExdeviceProfileUI.d(ExdeviceProfileUI.this, str);
            }
        });
    }

    static /* synthetic */ void t(ExdeviceProfileUI exdeviceProfileUI) {
        x.i("MicroMsg.Sport.ExdeviceProfileUI", "ap: start to del: %s", new Object[]{exdeviceProfileUI.gtX});
        au.DF().a(new h(exdeviceProfileUI.gtX, exdeviceProfileUI.iEn), 0);
    }

    public void onCreate(Bundle bundle) {
        CharSequence string;
        super.onCreate(bundle);
        this.mContext = this.mController.tml;
        Intent intent = getIntent();
        aHV();
        this.gtX = intent.getStringExtra("username");
        this.iDS = intent.getStringExtra("usernickname");
        String GF = q.GF();
        if (GF != null) {
            this.iDw = GF.equals(this.gtX);
        }
        this.mAppName = getIntent().getStringExtra("app_username");
        this.iDx = ad.aHg().Af(this.gtX);
        x.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", new Object[]{Boolean.valueOf(this.iDx)});
        Assert.assertTrue(!bi.oW(this.gtX));
        this.iDT = ad.aHi().Ah(this.gtX);
        this.iDU = getIntent().getStringArrayListExtra("key_affected_semi");
        getString(R.l.app_tip);
        this.iBL = com.tencent.mm.ui.base.h.b(this, getString(R.l.loading_tips), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (ExdeviceProfileUI.this.iBL != null) {
                    ExdeviceProfileUI.this.iBL.dismiss();
                    ExdeviceProfileUI.this.iBL = null;
                }
                ExdeviceProfileUI.this.finish();
            }
        });
        this.iDW = (ExdeviceProfileAffectedUserView) findViewById(R.h.exdevice_affected_view);
        this.iDX = (ImageView) findViewById(R.h.exdevice_bg_iv);
        this.iDY = (ListView) findViewById(R.h.exdevice_profile_lv);
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(R.h.pull_down_view);
        this.iDW.setAffectedUserInfo(this.iDU);
        aHZ();
        this.iEd = findViewById(R.h.setCoverV);
        this.iEv = new GestureDetector(this.mController.tml, new a(this, (byte) 0));
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setTopViewVisible(false);
        mMPullDownView.setBottomViewVisible(false);
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setIsTopShowAll(false);
        mMPullDownView.setCanOverScrool(true);
        mMPullDownView.setOnInterceptTouchEventListener(this.iEw);
        mMPullDownView.setAtBottomCallBack(new 5(this));
        mMPullDownView.setAtTopCallBack(new 6(this));
        mMPullDownView.setOnBottomLoadDataListener(new 7(this));
        mMPullDownView.setOnScrollChangedListener(new 8(this));
        ExdeviceProfileListHeader exdeviceProfileListHeader = new ExdeviceProfileListHeader(this);
        int B = com.tencent.mm.plugin.exdevice.j.b.B(this, getResources().getDimensionPixelSize(R.f.ExdeviceDefaultStatusBarHeight));
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand) : getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.ExdeviceProfileAvatarSize);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.f.ExdeviceProfileAvatarRoundStrokeWidth);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        dimensionPixelSize2 = ((((defaultDisplay.getHeight() / 2) - B) - dimensionPixelSize) - (dimensionPixelSize2 / 2)) - dimensionPixelSize3;
        if (defaultDisplay.getHeight() <= 0 || dimensionPixelSize2 <= 0) {
            dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.ExdeviceChangeCoverClickAreaHeight);
        }
        exdeviceProfileListHeader.setMinimumHeight(dimensionPixelSize2);
        exdeviceProfileListHeader.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceProfileListHeader.setTag(Integer.valueOf(((defaultDisplay.getHeight() / 2) - B) - dimensionPixelSize));
        this.iDZ = exdeviceProfileListHeader;
        this.iDY.addHeaderView(this.iDZ, null, false);
        this.iEc = new a(this.mController.tml, this.mAppName, this.iDw, this.gtX);
        this.iEc.iDv = this;
        this.iDY.setAdapter(this.iEc);
        this.iDY.setOnScrollListener(new 9(this));
        this.iDW.setUsername(this.gtX);
        this.iEd.setOnClickListener(new 10(this));
        mMPullDownView.setCanOverScrool(false);
        this.iDX.setLayoutParams(new LayoutParams(com.tencent.mm.bp.a.fk(this), ((Integer) this.iDZ.getTag()).intValue()));
        aHY();
        ad.aHn().a(this);
        au.DF().a(new i(this.gtX, bi.oV(this.mAppName), this.iEl), 0);
        try {
            this.duy = getResources().getDimensionPixelSize(R.f.ExdeviceUserNameWidth);
            if (this.duy <= 0) {
                this.duy = 60;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", e, "", new Object[0]);
            if (this.duy <= 0) {
                this.duy = 60;
            }
        } catch (Throwable th) {
            if (this.duy <= 0) {
                this.duy = 60;
            }
        }
        x.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", new Object[]{Integer.valueOf(this.duy)});
        if (this.iDw) {
            string = getString(R.l.exdevice_profile_my_title);
        } else {
            dimensionPixelSize = R.l.exdevice_profile_title;
            Object[] objArr = new Object[1];
            GF = this.gtX;
            int i = this.duy;
            CharSequence gT = r.gT(GF);
            string = (!GF.equalsIgnoreCase(gT) || bi.oW(this.iDS)) ? j.a(this.mController.tml, gT) : j.a(this.mController.tml, this.iDS);
            x.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", new Object[]{Integer.valueOf(i), string, TextUtils.ellipsize(string, this.dG, (float) i, TruncateAt.END)});
            objArr[0] = gT;
            string = j.a(this, getString(dimensionPixelSize, objArr));
        }
        M(string);
        setBackBtn(new 28(this));
        x.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.gtX);
        if (q.GF().equals(this.gtX)) {
            qt qtVar = new qt();
            qtVar.cbp.action = 3;
            com.tencent.mm.sdk.b.a.sFg.a(qtVar, Looper.getMainLooper());
        }
    }

    private void aHV() {
        this.iEi = ad.aHg().aHs();
        if (this.iEi != null) {
            x.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow size:%s, %s", new Object[]{Integer.valueOf(this.iEi.size()), this.iEi.toString()});
        } else {
            x.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow is null");
        }
        if (bi.cX(this.iEi)) {
            this.iDy = 0;
        } else {
            this.iDy = this.iEi.size();
        }
    }

    private void aHW() {
        runOnUiThread(new 27(this));
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        x.v("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
        aHV();
        aHW();
        if (!this.iDw) {
            ad.aHg().Af(this.gtX);
            aHX();
        }
    }

    private void aHX() {
        runOnUiThread(new 3(this));
    }

    protected void onDestroy() {
        this.iEu.dead();
        this.En = true;
        super.onDestroy();
        ad.aHn().b(this);
    }

    private void aHY() {
        String GF = q.GF();
        if (this.iEd != null) {
            this.iEd.setVisibility(8);
        }
        if (!bi.oW(GF) && GF.equals(this.gtX)) {
            if (!(this.iDT == null || !bi.oW(this.iDT.field_championUrl) || this.iEd == null)) {
                this.iEd.setVisibility(0);
            }
            if (this.iDZ != null) {
                this.iDZ.setOnClickListener(new 11(this));
            }
        } else if (this.iDT != null && !bi.oW(this.iDT.field_championUrl) && this.iDZ != null) {
            this.iDZ.setOnClickListener(new 13(this));
        }
    }

    private void aHZ() {
        if (this.iDT == null) {
            this.iDX.setImageResource(R.e.darkgrey);
            this.gaG = null;
        } else if (this.gaG == this.iDT.field_championUrl) {
        } else {
            if (this.gaG == null || !this.gaG.equals(this.iDT.field_championUrl)) {
                com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.iDX, this.iDT.field_championUrl, R.e.darkgrey);
                this.gaG = this.iDT.field_championUrl;
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!com.tencent.mm.plugin.exdevice.f.a.e.a(this, i, i2, intent, this.mAppName)) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        String str;
                        if (intent == null) {
                            str = null;
                        } else {
                            str = intent.getStringExtra("Select_Conv_User");
                        }
                        String dc = ac.dc(this);
                        if (str == null || str.length() == 0) {
                            x.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
                            return;
                        }
                        ac.a(this, str, dc, intent.getStringExtra("custom_send_text"), this.iEg);
                        com.tencent.mm.ui.base.h.bA(this.mController.tml, getResources().getString(R.l.app_shared));
                        return;
                    }
                    return;
                case 2:
                    if (i2 == -1) {
                        Toast.makeText(this, R.l.share_ok, 1).show();
                        return;
                    }
                    return;
                case 3:
                    if (i2 == -1) {
                        List F = bi.F(intent.getStringExtra("Select_Contact").split(","));
                        if (F != null) {
                            if (this.iBL != null) {
                                this.iBL.show();
                            }
                            au.DF().a(new g(F, this.iEr), 0);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.exdevice_profile_ui;
    }

    public final void b(String str, com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        if ("HardDeviceChampionInfo".equals(str) && this.gtX.equals(dVar.username)) {
            x.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
            this.iDT = ad.aHi().Ah(this.gtX);
            runOnUiThread(new Runnable() {
                public final void run() {
                    ExdeviceProfileUI.this.aHY();
                    ExdeviceProfileUI.this.iEc.notifyDataSetChanged();
                    ExdeviceProfileUI.this.aHZ();
                }
            });
        }
    }

    public final void aIa() {
        runOnUiThread(new 18(this));
        au.DF().a(new k(this.iEt), 0);
    }

    public final void aIb() {
        com.tencent.mm.plugin.sport.b.d.kB(17);
        List arrayList = new ArrayList();
        arrayList.add(this.gtX);
        au.DF().a(new g(arrayList, this.iEo), 0);
    }

    private void r(long j, long j2) {
        List<com.tencent.mm.plugin.sport.b.e> B = ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.sport.b.b.class)).B(j, j2);
        HashSet hashSet = new HashSet();
        List arrayList = new ArrayList();
        if (this.iEh != null) {
            for (com.tencent.mm.plugin.sport.b.e eVar : this.iEh) {
                if (hashSet.add(eVar.field_date)) {
                    arrayList.add(eVar);
                }
            }
        }
        for (com.tencent.mm.plugin.sport.b.e eVar2 : B) {
            if (hashSet.add(eVar2.field_date)) {
                arrayList.add(eVar2);
            }
        }
        Collections.sort(arrayList);
        this.iEh = arrayList;
        this.iEb.cy(this.iEh);
    }
}
