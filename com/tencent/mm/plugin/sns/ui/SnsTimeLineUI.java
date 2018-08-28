package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcel;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.a.bv;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kiss.WxPresenterActivity;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.a.b.i.5;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$i;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.j.c$a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.bh.1;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.MMPullDownView.f;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.ui.y;
import com.tencent.mm.vending.h.d;
import java.util.HashSet;
import java.util.Set;

public class SnsTimeLineUI extends WxPresenterActivity implements e, ap, a, u {
    private static Handler h = new Handler(odp.getLooper());
    private static final Set<Activity> odo = new HashSet();
    private static HandlerThread odp;
    private long dRd;
    private int dYK;
    private long dkA;
    private String gtX;
    private long hmf;
    private int lBd;
    private ActionBar mActionBar;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean nLS;
    private boolean nNG;
    protected g nUq;
    private com.tencent.matrix.trace.b.a nYi;
    private c nrz;
    private boolean nvh;
    private a ocA;
    private TestTimeForSns ocB;
    private int ocC;
    private boolean ocD;
    private String ocE;
    private com.tencent.mm.plugin.sns.h.a ocF;
    private av ocG;
    private at ocH;
    private String ocI;
    private boolean ocJ;
    private int ocK;
    private bb ocL;
    private Runnable ocM;
    private c ocN;
    private boolean ocO;
    private c ocP;
    private c ocQ;
    private c ocR;
    private c ocS;
    private c ocT;
    private c ocU;
    private c ocV;
    private c ocW;
    private c ocX;
    private c ocY;
    private c ocZ;
    private final long oco = 300;
    private long ocp = SystemClock.elapsedRealtime();
    private b ocr = ((b) t(b.class));
    private com.tencent.mm.plugin.sns.j.a ocs;
    private ax oct;
    private LinearLayout ocu;
    private LinearLayout ocv;
    private QFadeImageView ocw;
    private boolean ocx;
    private boolean ocy;
    private j ocz;
    private c oda;
    private c odb;
    private c odc;
    private View odd;
    private com.tencent.mm.ui.statusbar.c.a ode;
    private long odf;
    boolean odg;
    Runnable odh;
    Runnable odi;
    private Handler odj;
    private Runnable odk;
    private bb.a odl;
    private com.tencent.mm.vending.app.a.b odm;
    boolean odn;
    private OnMenuItemClickListener odq;
    private ImageView odr;
    private View ods;
    private ba odt;
    private OnClickListener odu;
    private boolean odv;

    public SnsTimeLineUI() {
        this.ocs = this.ocr != null ? this.ocr.bFb() : null;
        this.ocx = false;
        this.ocy = false;
        this.nLS = false;
        this.ocC = 0;
        this.ocD = false;
        this.ocE = "";
        this.ocF = new com.tencent.mm.plugin.sns.h.a();
        this.nUq = new g(1);
        this.ocG = new av();
        this.ocH = new at();
        this.ocM = new 1(this);
        this.ocN = new 12(this);
        this.ocO = false;
        this.nvh = false;
        this.ocP = new c<kn>() {
            {
                this.sFo = kn.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (((kn) bVar) instanceof kn) {
                    SnsTimeLineUI.this.ocr.onl.b(SnsTimeLineUI.this.gtX, SnsTimeLineUI.this.ocJ, SnsTimeLineUI.this.nNG, SnsTimeLineUI.this.ocK);
                    SnsTimeLineUI.this.oct.notifyDataSetChanged();
                }
                return false;
            }
        };
        this.ocQ = new 34(this);
        this.ocR = new 45(this);
        this.ocS = new 53(this);
        this.ocT = new 54(this);
        this.ocU = new 55(this);
        this.ocV = new 56(this);
        this.ocW = new 2(this);
        this.ocX = new 3(this);
        this.nrz = new 4(this);
        this.ocY = new 5(this);
        this.ocZ = new 6(this);
        this.oda = new 7(this);
        this.odb = new 8(this);
        this.odc = new 9(this);
        this.odf = 0;
        this.odg = false;
        this.lBd = 0;
        this.odh = new 16(this);
        this.odi = new 17(this);
        this.odj = ((com.tencent.mm.vending.h.b) d.uRD.uRJ).mHandler;
        this.odk = new 18(this);
        this.odl = new 19(this);
        this.odm = new 20(this);
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.odn = true;
        this.hmf = 0;
        this.dkA = 0;
        this.dRd = 0;
        this.nYi = new 25(this);
        this.odq = new 40(this);
        this.odt = null;
        this.odu = new 46(this);
        this.odv = false;
    }

    static /* synthetic */ void G(SnsTimeLineUI snsTimeLineUI) {
        int i = 1;
        if (snsTimeLineUI.ocC <= 3) {
            int firstVisiblePosition = snsTimeLineUI.ocL.kww.getFirstVisiblePosition();
            if (System.currentTimeMillis() - snsTimeLineUI.odf > 1000 || firstVisiblePosition > snsTimeLineUI.lBd) {
                snsTimeLineUI.odf = 0;
                snsTimeLineUI.lBd = snsTimeLineUI.ocL.kww.getFirstVisiblePosition();
            }
            snsTimeLineUI.odf = System.currentTimeMillis();
            if (snsTimeLineUI.lBd - firstVisiblePosition >= 10 && firstVisiblePosition > 10) {
                x.i("MicroMsg.SnsTimeLineUI", "showTopTip %d", new Object[]{Integer.valueOf(snsTimeLineUI.ocC)});
                if (snsTimeLineUI.ocC <= 3) {
                    s sVar = snsTimeLineUI.mController;
                    if (sVar.mActionBar == null || sVar.mActionBar.getCustomView() == null || sVar.mActionBar.getCustomView().findViewById(com.tencent.mm.w.a.g.action_bar_single_title) == null) {
                        i = 0;
                    }
                    if (i == 0) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(snsTimeLineUI.mController.tml, i.a.push_down_in);
                        CharSequence string = snsTimeLineUI.getString(i$j.sns_come_to_top);
                        s sVar2 = snsTimeLineUI.mController;
                        if (sVar2.mActionBar != null) {
                            sVar2.mActionBar.setCustomView(s.tmE);
                            TextView textView = (TextView) sVar2.mActionBar.getCustomView().findViewById(com.tencent.mm.w.a.g.action_bar_single_title);
                            if (textView != null) {
                                if (sVar2.mQO) {
                                    textView.setTextColor(sVar2.mContext.getResources().getColor(com.tencent.mm.w.a.d.white_text_color));
                                }
                                textView.clearAnimation();
                                if (loadAnimation != null) {
                                    textView.startAnimation(loadAnimation);
                                }
                                if (!bi.oW(string)) {
                                    textView.setText(string);
                                }
                            }
                        }
                        snsTimeLineUI.mController.removeAllOptionMenu();
                        snsTimeLineUI.removeOptionMenu(16908332);
                        snsTimeLineUI.setTitleBarDoubleClickListener(new 39(snsTimeLineUI));
                        snsTimeLineUI.ocC++;
                        af.aRu().removeCallbacks(snsTimeLineUI.odk);
                        af.aRu().postDelayed(snsTimeLineUI.odk, 4000);
                    }
                }
            }
        }
    }

    static /* synthetic */ void I(SnsTimeLineUI snsTimeLineUI) {
        x.i("MicroMsg.SnsTimeLineUI", "double click， first visible：%s", new Object[]{Integer.valueOf(snsTimeLineUI.ocL.kww.getFirstVisiblePosition())});
        BackwardSupportUtil.c.a(snsTimeLineUI.ocL.kww);
        snsTimeLineUI.ocw.setVisibility(0);
        if (snsTimeLineUI.ocL.kww.getFirstVisiblePosition() != 0) {
            snsTimeLineUI.odk.run();
        }
        snsTimeLineUI.ocz.bBQ();
        snsTimeLineUI.bCa();
        new ag().postDelayed(new 47(snsTimeLineUI), 300);
    }

    static /* synthetic */ void z(SnsTimeLineUI snsTimeLineUI) {
        com.tencent.mm.kernel.g.Ek();
        String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sQL, null);
        if (!bi.oW(str)) {
            byte[] WP = bi.WP(str);
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(WP, 0, WP.length);
            obtain.setDataPosition(0);
            try {
                Intent intent = (Intent) Intent.CREATOR.createFromParcel(obtain);
                intent.addFlags(268435456);
                intent.setClass(snsTimeLineUI, SnsUploadUI.class);
                snsTimeLineUI.startActivity(intent);
                return;
            } catch (Exception e) {
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sQL, "");
            }
        }
        if (snsTimeLineUI.ods != null) {
            snsTimeLineUI.ods.setVisibility(8);
        }
        if (!(snsTimeLineUI.ocz == null || snsTimeLineUI.ocz.nLK == null)) {
            snsTimeLineUI.ocz.nLK.nrb.hW(true);
        }
        com.tencent.mm.modelsns.b io = com.tencent.mm.modelsns.b.io(705);
        io.is(io.egR).nc(System.currentTimeMillis()).is(io.egS).is(1);
        snsTimeLineUI.odt = new ba(snsTimeLineUI);
        snsTimeLineUI.odt.ofp = new 43(snsTimeLineUI);
        snsTimeLineUI.odt.c(3, snsTimeLineUI.mController.tml.getString(i$j.app_field_pic_video));
        snsTimeLineUI.odt.ofq = new 44(snsTimeLineUI, io);
        snsTimeLineUI.odt.bEo();
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
        this.odj.removeCallbacks(this.ocM);
        com.tencent.mm.vending.g.g.cBK().d(new 11(this, str)).f(new 10(this, z2, z));
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
        this.odj.removeCallbacks(this.ocM);
        com.tencent.mm.vending.g.g.cBK().d(new 14(this, str)).f(new 13(this, z));
    }

    public final void lF(int i) {
        super.lF(i);
        if (VERSION.SDK_INT >= 21 && this.odd != null) {
            this.odd.setBackgroundColor(getWindow().getStatusBarColor());
            com.tencent.mm.ui.statusbar.d.a(getWindow());
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        x.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", new Object[]{keyEvent.toString()});
        int i2 = this.mController.tmG;
        j jVar = this.ocz;
        if (keyEvent.getKeyCode() == 4 && jVar.nLN.getVisibility() == 0) {
            jVar.nLN.setVisibility(8);
            i = 1;
        }
        if (i == 0 || i2 != 2) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public void onCreate(Bundle bundle) {
        int i = 1;
        if (this.mController != null) {
            this.mController.ak(2, true);
        }
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        com.tencent.mm.pluginsdk.e.k(this);
        super.onCreate(bundle);
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            this.odd = findViewById(i$f.action_bar_container);
            if (this.odd != null && com.tencent.mm.ui.statusbar.c.uuT) {
                com.tencent.mm.ui.statusbar.c ab = com.tencent.mm.ui.statusbar.c.ab(this);
                15 15 = new 15(this);
                this.ode = 15;
                ab.a(15);
                getWindow().getDecorView().requestApplyInsets();
                com.tencent.mm.ui.statusbar.d.a(getWindow());
            }
            getWindow().getDecorView().setSystemUiVisibility(1280);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a(this);
            this.mController.addIconOptionMenu(0, i$j.sns_action_bar_take_photo_btn_desc, i$i.common_icons_camera, new 21(this), new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    if (!(SnsTimeLineUI.this.ocz == null || SnsTimeLineUI.this.ocz.nLK == null)) {
                        SnsTimeLineUI.this.ocz.nLK.nrb.hW(true);
                    }
                    com.tencent.mm.kernel.g.Ek();
                    boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.Ei().DT().get(7490, Boolean.valueOf(true))).booleanValue();
                    com.tencent.mm.kernel.g.Ek();
                    String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sQM, null);
                    if (!bi.oW(str)) {
                        byte[] WP = bi.WP(str);
                        Parcel obtain = Parcel.obtain();
                        obtain.unmarshall(WP, 0, WP.length);
                        obtain.setDataPosition(0);
                        try {
                            SnsTimeLineUI.this.startActivityForResult((Intent) Intent.CREATOR.createFromParcel(obtain), 9);
                        } catch (Exception e) {
                            com.tencent.mm.kernel.g.Ek();
                            com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sQM, "");
                        }
                        return true;
                    }
                    if (booleanValue) {
                        SnsTimeLineUI.this.startActivity(new Intent().setClass(SnsTimeLineUI.this, SnsLongMsgUI.class));
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Ei().DT().set(7490, Boolean.valueOf(false));
                    } else {
                        Intent intent = new Intent();
                        intent.setClass(SnsTimeLineUI.this, SnsUploadUI.class);
                        intent.putExtra("KSnsPostManu", true);
                        intent.putExtra("KTouchCameraTime", bi.VE());
                        intent.putExtra("sns_comment_type", 1);
                        intent.putExtra("Ksnsupload_type", 9);
                        com.tencent.mm.modelsns.b io = com.tencent.mm.modelsns.b.io(705);
                        io.is(io.egR).nc(System.currentTimeMillis()).is(io.egS).is(1);
                        io = com.tencent.mm.plugin.sns.h.e.nxO.b(io);
                        io.RD();
                        io.b(intent, "intent_key_StatisticsOplog");
                        SnsTimeLineUI.this.startActivityForResult(intent, 9);
                    }
                    return true;
                }
            });
            lF(this.mController.tml.getResources().getColor(i.c.transparent));
            aA(0.0f);
            cqh();
            this.mActionBar = getSupportActionBar();
            int da = com.tencent.mm.model.c.c.Jy().da("Sns_Private_Recent_Setting_Guide", 0);
            x.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = " + da);
            if (da == 1) {
                com.tencent.mm.kernel.g.Ek();
                if (!com.tencent.mm.kernel.g.Ei().DT().getBoolean(aa.a.sVJ, false)) {
                    Intent intent = getIntent();
                    intent.setClass(this.mController.tml, SnsSettingIntroduceUI.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    finish();
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sVJ, Boolean.valueOf(true));
                }
            }
            com.tencent.mm.bv.b.cou();
            this.ocs.a(com.tencent.mm.plugin.sns.j.c.b.class, this.odm);
            this.ocs.a(this);
            c$a c_a = (c$a) this.ocs.P(c$a.class);
            this.gtX = c_a.gtX;
            this.ocI = c_a.ocI;
            this.ocJ = c_a.ocJ;
            this.nNG = c_a.nNG;
            this.ocK = c_a.ocK;
            String str = c_a.eWQ;
            String str2 = c_a.ogj;
            this.ocL = new bb(this);
            this.ocL.ofW = this.odl;
            this.ocL.ofX = this.mActionBar.getCustomView();
            ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().fr(2);
            com.tencent.mm.plugin.sns.ui.widget.d.bEY().ona = 0;
            com.tencent.mm.plugin.sns.ui.widget.b.bEX().ona = 0;
            com.tencent.mm.modelsns.c cVar = com.tencent.mm.modelsns.c.ehc;
            com.tencent.mm.modelsns.c.RE();
            this.ocz = new j(this, getIntent().getBooleanExtra("is_sns_notify_open", true) ? 1 : 0, bi.aG(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0));
            this.nLS = getIntent().getBooleanExtra("sns_resume_state", true);
            if (af.bxX()) {
                this.nLS = false;
            } else if (this.nLS) {
                this.nLS = af.byv().bCB();
            }
            this.ocx = this.nLS;
            this.ocL.a(this.ocI, this.gtX, str, str2, this.ocJ, this.nNG, this.ocK);
            this.ocL.onCreate();
            af.byf().init();
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(213, this);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(682, this);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(218, this);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(211, this);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(683, this);
            initView();
            com.tencent.mm.plugin.sns.f.c byf = af.byf();
            ListView listView = this.ocL.kww;
            av avVar = this.oct.oef;
            byf.nub = listView;
            byf.nuc = avVar;
            byf = af.byf();
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(com.tencent.mm.plugin.appbrand.jsapi.audio.d.CTRL_INDEX, byf);
            this.ocy = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
            this.ocz.jdw = (ClipboardManager) getSystemService("clipboard");
            if (af.bxX()) {
                this.nLS = false;
            } else if (this.nLS) {
                this.nLS = af.byv().bCB();
            }
            com.tencent.mm.plugin.sns.j.a aVar2 = this.ocs;
            aVar2.oeg = this.oct.oeg;
            aVar2.uPG.keep(aVar2.oeg);
            if (this.nLS) {
                this.ocy = false;
                da = af.byv().position;
                aw awVar = this.oct.oeg;
                String str3 = af.byv().iKw;
                synchronized (awVar.oea) {
                    awVar.iKw = str3;
                }
                this.oct.oeg.nQU = af.byv().nQU;
                this.oct.oeg.odZ = true;
                this.oct.kS();
                if (da >= this.oct.getCount()) {
                    da = this.oct.getCount() - 1;
                    x.e("MicroMsg.SnsTimeLineUI", "error position %s", new Object[]{Integer.valueOf(this.oct.getCount())});
                }
                this.ocL.kww.setAdapter(this.oct);
                x.d("MicroMsg.SnsTimeLineUI", "resume position %s", new Object[]{Integer.valueOf(af.byv().nQV)});
                this.ocL.kww.setSelectionFromTop(da, af.byv().nQV);
                this.ocw.setVisibility(4);
            } else {
                this.ocL.kww.setAdapter(this.oct);
                this.ocw.setVisibility(0);
                this.oct.kS();
            }
            int count = this.oct.getCount();
            da = this.ocL.kww.getFirstVisiblePosition();
            if (da < count) {
                this.ocE = com.tencent.mm.plugin.sns.data.i.g(this.oct.xi(da));
            }
            com.tencent.mm.kernel.g.Ek();
            this.ocC = ((Integer) com.tencent.mm.kernel.g.Ei().DT().get(327776, Integer.valueOf(0))).intValue();
            this.ocz.nLU = new bh(this, this.oct.oef, this.ocz.ntx);
            this.ocz.nLW = new com.tencent.mm.plugin.sns.f.b(this, this.oct.oef.ntw, this.ocz.ntx);
            this.ocz.nLV = new c(this, this.oct.oef.ntw, this.ocz.ntx, this.ocz.nLW);
            if (this.ocH != null) {
                this.ocH.a(this.ocz.nLW);
            }
            if (count > 0) {
                n xi = this.oct.xi(0);
                if (!(this.ocz.nLK == null || this.ocz.nLK.nrb == null)) {
                    this.ocz.nLK.nrb.nvC = xi.field_snsId;
                }
                com.tencent.mm.plugin.sns.h.d dVar = com.tencent.mm.plugin.sns.h.d.nxJ;
                if (dVar.dlT != 0) {
                    if (dVar.nxK.isEmpty()) {
                        dVar.cXI.setLong(2, bi.VE());
                        dVar.nxL.clear();
                    }
                    x.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", new Object[]{Integer.valueOf(dVar.nxK.size())});
                }
            }
            h.mEJ.k(13312, "1," + bi.VF());
            com.tencent.mm.sdk.b.a.sFg.b(this.ocN);
            if (getIntent().getBooleanExtra("is_need_resend_sns", false)) {
                ah.i(new 24(this), 500);
                getIntent().putExtra("is_need_resend_sns", false);
            }
            com.tencent.mm.kernel.g.Ek();
            if (com.tencent.mm.kernel.g.Eg().Dx()) {
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Ei().DT().set(589825, Boolean.valueOf(false));
            }
            this.ocz.nLJ = this.nUq;
            g gVar = this.nUq;
            count = this.ocL.nig;
            View customView = this.mActionBar.getCustomView();
            gVar.nig = count;
            gVar.niZ = customView;
            gVar.activity = this;
            com.tencent.mm.sdk.b.a.sFg.b(this.ocR);
            com.tencent.mm.sdk.b.a.sFg.b(this.ocS);
            com.tencent.mm.sdk.b.a.sFg.b(this.ocT);
            com.tencent.mm.sdk.b.a.sFg.b(this.ocU);
            com.tencent.mm.sdk.b.a.sFg.b(this.ocV);
            com.tencent.mm.sdk.b.a.sFg.b(this.ocX);
            com.tencent.mm.sdk.b.a.sFg.b(this.ocW);
            com.tencent.mm.sdk.b.a.sFg.b(this.nrz);
            com.tencent.mm.sdk.b.a.sFg.b(this.ocY);
            com.tencent.mm.sdk.b.a.sFg.b(this.ocZ);
            com.tencent.mm.sdk.b.a.sFg.b(this.odb);
            com.tencent.mm.sdk.b.a.sFg.b(this.oda);
            com.tencent.mm.sdk.b.a.sFg.b(this.odc);
            com.tencent.mm.plugin.sns.abtest.c.bwI();
            com.tencent.mm.plugin.sns.abtest.a.d(this, this.ocz.ntx);
            if (this.ocF != null) {
                com.tencent.mm.plugin.sns.h.a aVar3 = this.ocF;
                listView = this.ocL.kww;
                SnsHeader snsHeader = this.ocL.nvg;
                aVar3.eZb = listView;
                aVar3.nvg = snsHeader;
            }
            if (!(this.ocz == null || this.ocz.nLK == null)) {
                com.tencent.mm.plugin.sns.h.b bVar = this.ocz.nLK.nrb;
                x.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
                bVar.nvB = true;
                bVar.nxy = System.currentTimeMillis();
            }
            boolean booleanExtra = getIntent().getBooleanExtra("enter_by_red", false);
            if (!(this.ocz == null || this.ocz.nLK == null)) {
                com.tencent.mm.plugin.sns.h.b bVar2 = this.ocz.nLK.nrb;
                if (!booleanExtra) {
                    i = 0;
                }
                bVar2.nvO = i;
            }
            af.byl().nnc.clear();
            return;
        }
        finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
        com.tencent.mm.sdk.b.a.sFg.m(new bv());
        com.tencent.mm.plugin.sns.ui.widget.d.bEY().ona = 0;
        com.tencent.mm.plugin.sns.ui.widget.b.bEX().ona = 0;
        com.tencent.mm.kiss.widget.textview.c.dtC.EZ();
        this.oct.oef.bDO();
        this.oct.oeg.resolvedClear();
    }

    public void onDestroy() {
        long j;
        int i;
        int i2;
        this.ocD = true;
        x.i("MicroMsg.SnsTimeLineUI", "timeline on destroy");
        com.tencent.mm.sdk.b.a.sFg.c(this.ocR);
        com.tencent.mm.sdk.b.a.sFg.c(this.ocS);
        com.tencent.mm.sdk.b.a.sFg.c(this.ocT);
        com.tencent.mm.sdk.b.a.sFg.c(this.ocU);
        com.tencent.mm.sdk.b.a.sFg.c(this.ocV);
        com.tencent.mm.sdk.b.a.sFg.c(this.ocX);
        com.tencent.mm.sdk.b.a.sFg.c(this.ocW);
        com.tencent.mm.sdk.b.a.sFg.c(this.nrz);
        com.tencent.mm.sdk.b.a.sFg.c(this.ocY);
        com.tencent.mm.sdk.b.a.sFg.c(this.ocZ);
        com.tencent.mm.sdk.b.a.sFg.c(this.oda);
        com.tencent.mm.sdk.b.a.sFg.c(this.odb);
        com.tencent.mm.sdk.b.a.sFg.c(this.odc);
        if (!(this.ocz == null || this.ocz.nLK == null)) {
            this.ocz.nLK.nrb.nvP = this.ocO ? 1 : 0;
        }
        com.tencent.mm.plugin.sns.h.d dVar = com.tencent.mm.plugin.sns.h.d.nxJ;
        if (dVar.dlT != 0) {
            x.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d, exposureAppIdSize %d", new Object[]{Integer.valueOf(dVar.nxK.size()), Integer.valueOf(dVar.nxL.size())});
            j = dVar.cXI.getLong(2, 0);
            if (dVar.nxK.isEmpty() || (dVar.nxK.size() <= dVar.nxM && bi.bG(j) <= ((long) dVar.nxN))) {
                dVar.cXI.set(3, dVar.nxK);
                dVar.cXI.set(4, dVar.nxL);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                i = 0;
                for (String str : dVar.nxK.keySet()) {
                    String str2 = (String) dVar.nxL.get(str);
                    if (bi.oW(str2)) {
                        str2 = "";
                    } else {
                        i = 1;
                    }
                    stringBuffer.append(str + "#" + dVar.nxK.get(str) + "#" + str2 + "|");
                }
                stringBuffer.append("," + j + "," + bi.VE() + ",1," + i);
                x.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", new Object[]{Integer.valueOf(13226), stringBuffer});
                h.mEJ.k(13226, stringBuffer.toString());
                dVar.cXI.set(3, null);
                dVar.cXI.set(4, null);
                dVar.nxK.clear();
                dVar.nxL.clear();
                dVar.cXI.setLong(2, bi.VE());
            }
        }
        com.tencent.mm.kernel.g.Ek();
        String str3 = (String) com.tencent.mm.kernel.g.Ei().DT().get(68377, null);
        int count = this.oct.getCount();
        String str4 = "";
        n nVar = null;
        if (count > 0) {
            nVar = this.oct.xi(count - 1);
            str4 = com.tencent.mm.plugin.sns.data.i.g(nVar);
        }
        if (!(this.ocz == null || this.ocz.nLK == null)) {
            com.tencent.mm.plugin.sns.h.b bVar = this.ocz.nLK.nrb;
            i2 = nVar == null ? -1 : nVar.field_createTime;
            x.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
            j = System.currentTimeMillis() - bVar.nxy;
            bVar.nvD += j;
            x.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + j + " BrowseTime: " + bVar.nvD + "BackgroundTime: " + bVar.nwm);
            com.tencent.mm.sdk.f.e.b(new b$2(bVar, i2), "onTimelineDestroy_report", 1);
            bVar.nvB = false;
        }
        com.tencent.mm.modelsns.b io = com.tencent.mm.modelsns.b.io(704);
        if (io.Rz()) {
            io.bP(this.ocO);
            io.bP(!bi.oW(str3));
            io.nb(this.ocE);
            io.nb(str4);
            io.nb(str4);
            io.ir(this.ocL.ofV);
            io.nb("");
            com.tencent.mm.modelsns.b.RC();
            io.RD();
        }
        AdListView adListView = (AdListView) this.ocL.bDZ();
        this.ocH.nrS.clear();
        af.byf().clean();
        af.byb().post(new 5(af.byi()));
        adListView.nKo.clear();
        adListView.nKo = null;
        adListView.nKp.bxB();
        adListView.nKp = null;
        u.bxJ();
        if (!af.bxX()) {
            this.odj.removeCallbacks(this.ocM);
        }
        com.tencent.mm.kernel.g.Ek();
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.b(213, this);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.b(682, this);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.b(218, this);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.b(211, this);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.b(683, this);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Ei().DT().set(327776, Integer.valueOf(this.ocC));
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Ei().DT().set(589825, Boolean.valueOf(false));
        }
        if (this.ocz != null) {
            j jVar = this.ocz;
            jVar.nLX.aEI();
            if (jVar.nLN != null) {
                jVar.nLN.bbE();
            }
            com.tencent.mm.sdk.b.a.sFg.c(jVar.nLZ);
        }
        af.aRu().removeCallbacks(this.odk);
        if (this.oct != null) {
            int i3;
            i = this.ocL.kww.getFirstVisiblePosition();
            i2 = 0;
            for (i3 = 0; i3 < this.ocL.kww.getCount(); i3++) {
                View childAt = this.ocL.kww.getChildAt(i3);
                if (childAt != null && this.ocL.kww.getPositionForView(childAt) == i) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    x.d("MicroMsg.SnsTimeLineUI", "this is the pos for view %d x %d y %d", new Object[]{Integer.valueOf(r4), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])});
                    i2 = iArr[1];
                }
            }
            i3 = BackwardSupportUtil.b.b(this, 50.0f);
            if (!(af.bxX() || this.ocs.bye() == null)) {
                aj byv = af.byv();
                String str5 = this.oct.oeg.iKw;
                String str6 = this.oct.oeg.nQU;
                long j2 = this.ocs.bye().nro;
                int i4 = i2 - i3;
                byv.nQT = bi.VG();
                byv.iKw = str5;
                byv.nQU = str6;
                byv.nro = j2;
                byv.position = i;
                byv.nQV = i4;
                x.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", new Object[]{Long.valueOf(byv.nQT), str5, str6, Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(byv.nQV)});
            }
            x.d("MicroMsg.SnsTimeLineUI", "top h %d", new Object[]{Integer.valueOf(i2 - i3)});
            com.tencent.mm.sdk.b.a.sFg.c(this.oct.oef.fIu);
            if (af.bxX()) {
                x.e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
            } else {
                af.byl();
            }
            av avVar = this.oct.oef;
            if (avVar.nUh != null) {
                avVar.nUh.activity = null;
            }
            com.tencent.mm.sdk.b.a.sFg.c(this.oct.oef.fIu);
            this.oct.oef.bDR();
        }
        az.clean();
        com.tencent.mm.sdk.b.a.sFg.c(this.ocN);
        com.tencent.mm.kernel.g.Ek();
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            af.byl().nnc.clear();
        }
        this.oct = null;
        this.ocz = null;
        ax.bEm();
        com.tencent.mm.plugin.sns.abtest.c.bwJ();
        com.tencent.mm.plugin.sns.f.c byf = af.byf();
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(com.tencent.mm.plugin.appbrand.jsapi.audio.d.CTRL_INDEX, byf);
        com.tencent.mm.plugin.sns.abtest.a.clean();
        this.ocL.onDestroy();
        super.onDestroy();
        com.tencent.mm.kiss.widget.textview.c.dtC.EZ();
    }

    static {
        HandlerThread handlerThread = new HandlerThread("sns");
        odp = handlerThread;
        handlerThread.start();
    }

    public void onResume() {
        int count;
        this.dRd = bi.VE();
        ((com.tencent.matrix.trace.a) com.tencent.matrix.a.tg().g(com.tencent.matrix.trace.a.class)).bsV.a(this.nYi);
        if (com.tencent.mm.sdk.a.b.chp() && com.tencent.mm.sdk.a.b.chn()) {
            odo.add(this);
        }
        bb.onResume();
        super.onResume();
        this.hmf = bi.VE();
        if (this.odn) {
            this.odn = false;
            count = this.oct.getCount();
            if (getIntent().getBooleanExtra("is_from_find_more", false)) {
                com.tencent.mm.modelsns.b c = com.tencent.mm.modelsns.b.c(getIntent(), "enter_log");
                if (c != null) {
                    if (count > 0) {
                        String str;
                        n xi = this.oct.xi(0);
                        if (xi == null) {
                            str = "0";
                        } else {
                            str = com.tencent.mm.plugin.sns.data.i.eF(xi.field_snsId);
                        }
                        c.nb(str);
                        if (xi == null) {
                            str = "0";
                        } else {
                            str = xi.field_createTime;
                        }
                        c.nb(str);
                        c.nb(String.valueOf(count));
                    } else {
                        c.nb("");
                        c.nb("");
                        c.nb("0");
                    }
                    c.RD();
                }
            }
        }
        if (this.mScreenWidth == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mScreenHeight = displayMetrics.heightPixels;
            com.tencent.mm.plugin.sns.h.a aVar = this.ocF;
            count = this.mScreenWidth;
            int i = this.mScreenHeight;
            aVar.mScreenWidth = count;
            aVar.mScreenHeight = i;
        }
        if (af.bxX()) {
            finish();
        }
        af.byl().nne = this.oct.oef;
        EW().Q(com.tencent.mm.plugin.sns.j.c.b.class);
        u.a(this);
        if (this.ocy) {
            this.ocw.post(new 26(this));
        } else {
            a aVar2 = this.ocA;
            if (aVar2.odw.ocw.getVisibility() == 0) {
                aVar2.init();
                LayoutParams layoutParams = (LayoutParams) aVar2.odw.ocw.getLayoutParams();
                layoutParams.y = (int) aVar2.odM;
                aVar2.odw.ocw.setLayoutParams(layoutParams);
                aVar2.odw.ocw.invalidate();
            }
        }
        rz rzVar = new rz();
        rzVar.ccO.ccP = this.ocL.kww.getFirstVisiblePosition();
        rzVar.ccO.ccQ = this.ocL.kww.getLastVisiblePosition();
        rzVar.ccO.ccR = this.ocL.kww.getHeaderViewsCount();
        rzVar.ccO.type = 0;
        com.tencent.mm.sdk.b.a.sFg.m(rzVar);
        if (!(this.ocz == null || this.ocz.nLJ == null)) {
            this.ocz.nLJ.onResume();
        }
        if (this.oct != null) {
            av avVar = this.oct.oef;
            com.tencent.mm.sdk.b.a.sFg.b(avVar.nUA);
            com.tencent.mm.sdk.b.a.sFg.b(avVar.nUz);
            com.tencent.mm.sdk.b.a.sFg.b(avVar.nUB);
        }
        if (!(this.ocz == null || this.ocz.nLK == null)) {
            this.ocz.nLK.nrb.hS(true);
            this.ocz.nLK.nrb.hT(false);
            this.ocz.nLK.nrb.hU(false);
            this.ocz.nLK.nrb.hV(false);
            this.ocz.nLK.nrb.if(false);
            com.tencent.mm.plugin.sns.h.b bVar = this.ocz.nLK.nrb;
            bVar.id(false);
            bVar.ie(false);
            bVar.hX(false);
            bVar.ic(false);
            bVar.ia(false);
            bVar.ic(false);
            bVar.ig(false);
            bVar.ib(false);
            bVar.ic(false);
            bVar.hY(false);
            bVar.hZ(false);
        }
        com.tencent.mm.plugin.sns.model.g byl = af.byl();
        byl.nnf = 0;
        byl.nng = 0;
        com.tencent.mm.sdk.b.a.sFg.b(this.ocQ);
        com.tencent.mm.sdk.b.a.sFg.b(this.ocP);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onPause() {
        this.ocw.clearAnimation();
        HardCoderJNI.stopPerformace(HardCoderJNI.hcSNSScrollEnable, this.dYK);
        this.dYK = 0;
        u.b(this);
        af.byl().nne = null;
        rz rzVar = new rz();
        rzVar.ccO.type = 1;
        com.tencent.mm.sdk.b.a.sFg.m(rzVar);
        if (this.oct != null) {
            av avVar = this.oct.oef;
            com.tencent.mm.sdk.b.a.sFg.c(avVar.nUA);
            com.tencent.mm.sdk.b.a.sFg.c(avVar.nUz);
            com.tencent.mm.sdk.b.a.sFg.c(avVar.nUB);
        }
        if (!(this.ocz == null || this.ocz.nLJ == null)) {
            this.ocz.nLJ.onPause();
        }
        if (!(this.ocz == null || this.ocz.nLK == null)) {
            this.ocz.nLK.nrb.hS(false);
        }
        com.tencent.mm.modelstat.d.h("SnsTimeLineUI", this.hmf, bi.VE());
        bb.onPause();
        super.onPause();
        com.tencent.mm.sdk.b.a.sFg.c(this.ocQ);
        com.tencent.mm.sdk.b.a.sFg.c(this.ocP);
        ((com.tencent.matrix.trace.a) com.tencent.matrix.a.tg().g(com.tencent.matrix.trace.a.class)).bsV.b(this.nYi);
        this.dRd = bi.VE() > this.dRd ? bi.VE() - this.dRd : 1;
        HardCoderJNI.reportFPS(701, HardCoderJNI.hcSNSScrollAction, 1, this.dkA, this.dRd);
        this.dkA = 0;
        this.dRd = 0;
    }

    protected final int getLayoutId() {
        return i$g.sns_timeline_ui;
    }

    protected final void initView() {
        this.ocL.nvg.setDrawingCacheEnabled(false);
        this.ocz.ntx = (FrameLayout) findViewById(i$f.timeline_root);
        setMMTitle(i$j.sns_timeline_ui_title);
        int i = af.byv().position;
        AdListView adListView = (AdListView) this.ocL.bDZ();
        adListView.nKo = this.nUq;
        adListView.setTimelineStat(this.ocG);
        adListView.setTimelineEvent(this.ocH);
        this.ocH.a(af.byf());
        x.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.nLS, new Object[]{Integer.valueOf(i)});
        this.ocw = (QFadeImageView) findViewById(i$f.sns_refresh_iv);
        this.ocw.setImageResource(i$i.friendactivity_refresh);
        this.ocA = new a(this, this.ocL.bDZ());
        this.ocA.setInterpolator(new LinearInterpolator());
        this.ocA.setAnimationListener(new 27(this));
        this.oct = new ax(this, this.ocL.bDZ(), this.ocz.nLX, this.ocz, this.ocI);
        this.ocz.nLX.olc = new av.a() {
            public final boolean bDV() {
                SnsTimeLineUI.this.EW().Q(com.tencent.mm.plugin.sns.j.c.b.class);
                return false;
            }
        };
        this.ocz.nuc = this.oct.oef;
        this.oct.oeg.uPD = new com.tencent.mm.vending.a.b.a() {
            public final void bEg() {
                com.tencent.mm.plugin.report.service.g.vu(14);
            }

            public final void bEh() {
                com.tencent.mm.plugin.report.service.g.vv(14);
            }
        };
        this.ocB = (TestTimeForSns) this.ocz.ntx;
        this.ocB.setListener(new 30(this));
        this.ocL.kww.setOnTouchListener(new 31(this));
        this.ocL.kww.post(new 32(this));
        this.ocL.lbd.setOnSrcollDistance(new f() {
            public final void av(float f) {
                SnsTimeLineUI.G(SnsTimeLineUI.this);
                if (SnsTimeLineUI.this.ocL.nvg.getTop() >= SnsTimeLineUI.this.ocA.odQ || f > 0.0f) {
                    a D = SnsTimeLineUI.this.ocA;
                    if (D.kww != null) {
                        if (D.kww.getFirstVisiblePosition() == 0) {
                            D.odw.ocw.setVisibility(0);
                        } else {
                            D.odw.ocw.setVisibility(8);
                        }
                    }
                    if (D.odw.ocw.getVisibility() == 0) {
                        D.odw.ocw.clearAnimation();
                        D.init();
                        D.odN -= f / 2.0f;
                        float f2 = D.odN;
                        if (f2 < D.odM) {
                            f2 = D.odM;
                            D.odN = D.odM;
                        }
                        float f3 = f2 > D.odL ? D.odL : f2;
                        f2 = f3 == D.odL ? f * 2.0f : 5.0f * f;
                        D.odw.ocw.setScaleType(QImageView.a.uHL);
                        D.odw.ocw.getImageMatrix().postRotate(f2, D.odJ, D.odK);
                        D.odw.ocw.setImageResource(i$i.friendactivity_refresh);
                        LayoutParams layoutParams = (LayoutParams) D.odw.ocw.getLayoutParams();
                        layoutParams.y = (int) f3;
                        D.odw.ocw.setLayoutParams(layoutParams);
                        D.odw.ocw.invalidate();
                    }
                }
                SnsTimeLineUI.this.ocz.bBQ();
                SnsTimeLineUI.this.bCa();
                SnsTimeLineUI.this.ocz.nLO.bEG();
            }

            public final void bEi() {
                SnsTimeLineUI.this.ocA.bEk();
            }
        });
        this.ocz.nLN = (SnsCommentFooter) findViewById(i$f.comment_footer);
        this.ocz.nLN.post(new 35(this));
        this.ocz.nLO = new bi(this.ocL.kww, this.ocz.nLN);
        this.ocu = (LinearLayout) this.ocL.nvg.findViewById(i$f.sns_notify_list);
        this.ocu.findViewById(i$f.sns_notify_for_click).setOnClickListener(new 36(this));
        this.ocv = (LinearLayout) this.ocL.nvg.findViewById(i$f.sns_notify_media_content_collapse);
        this.ocL.nvg.setAvatarOnClickListener(new 37(this));
        this.ocz.nLP = new ao(this);
        bDW();
    }

    public final void onKeyboardStateChanged() {
        super.onKeyboardStateChanged();
        ah.A(new Runnable() {
            public final void run() {
                SnsTimeLineUI.this.bCa();
            }
        });
        if (this.mController.tmG == 2) {
            if (this.ocz != null && this.ocz.nLN != null && !this.ocz.nLN.bDk()) {
                x.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
            }
        } else if (this.mController.tmG == 1 && this.ocz != null) {
            j jVar = this.ocz;
            if (jVar.nLL) {
                jVar.nLL = false;
                jVar.nLO.bEF();
            }
        }
    }

    public boolean supportNavigationSwipeBack() {
        return super.supportNavigationSwipeBack();
    }

    private void bDW() {
        b(new 41(this), new 42(this));
        setBackBtn(this.odq, i$i.actionbar_icon_dark_back);
    }

    private void bDX() {
        if (!com.tencent.mm.p.a.bw(this)) {
            x.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 18, "", "")), bi.cjd(), this});
            if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 18, "", "")) {
                x.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")), bi.cjd(), this});
                if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")) {
                    x.i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", new Object[]{bi.VF() + "_" + bi.Dc(5)});
                    h.mEJ.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(2), r0, Long.valueOf(bi.VE())});
                    l.b(this.mController.tml, new Intent(), r0);
                }
            }
        }
    }

    public final boolean cK(View view) {
        this.ocz.nLV.bzf();
        bh bhVar = this.ocz.nLU;
        if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
            com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
            String str = cVar.bKW;
            if (bhVar.ohM != null) {
                if (bhVar.ohM.getTag() instanceof bh.a) {
                    bh.a aVar = (bh.a) bhVar.ohM.getTag();
                    if (aVar.ntR.equals(str)) {
                        bhVar.cM(aVar.nid);
                        return true;
                    }
                    bhVar.bCa();
                }
                bhVar.ohM = null;
            }
            bhVar.ohM = new SnsCommentShowAbLayout(bhVar.mContext);
            k.bD(bhVar.ohM);
            bhVar.ohM.setId(i$f.address);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            bhVar.ntx.addView(bhVar.ohM);
            int b = BackwardSupportUtil.b.b(bhVar.mContext, 192.0f);
            int b2 = BackwardSupportUtil.b.b(bhVar.mContext, 76.0f);
            BackwardSupportUtil.b.b(bhVar.mContext, 20.0f);
            int b3 = BackwardSupportUtil.b.b(bhVar.mContext, 12.0f);
            int b4 = BackwardSupportUtil.b.b(bhVar.mContext, 40.0f);
            View inflate = y.gq(bhVar.mContext).inflate(i$g.sns_comment_button, null);
            Rect rect = new Rect();
            int[] iArr = new int[2];
            com.tencent.mm.pluginsdk.e.eK(bhVar.mContext);
            int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(bhVar.mContext, 2);
            view.getLocationInWindow(iArr);
            bhVar.njc = com.tencent.mm.pluginsdk.e.eL(bhVar.mContext);
            x.d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + iArr[0] + "  " + iArr[1] + " height: " + fromDPToPix + " height_hardcode:" + b2 + " statusBarHeight: " + bhVar.njc);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2, (iArr[0] - b) + b3, (iArr[1] - fromDPToPix) - ((b4 / 2) - (view.getMeasuredHeight() / 2)));
            bhVar.ohM.setTag(new bh.a(bhVar, str, inflate));
            bhVar.ohM.addView(inflate, layoutParams2);
            if (cVar.hER == 11) {
                inflate.findViewById(i$f.album_comment_container).setBackgroundResource(i.e.friendactivity_comment_frame_bg_golden);
            }
            inflate.setVisibility(8);
            new ag().post(new 1(bhVar, view, inflate));
            return true;
        }
        x.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
        return false;
    }

    public final boolean bCa() {
        if (this.ocz == null || this.ocz.nLU == null) {
            return false;
        }
        if (!(this.ocz == null || this.ocz.nLV == null)) {
            this.ocz.nLV.bzf();
        }
        com.tencent.mm.plugin.sns.abtest.a.bwC();
        return this.ocz.nLU.bCa();
    }

    public final void HG() {
        EW().Q(com.tencent.mm.plugin.sns.j.c.b.class);
    }

    public final void HH() {
    }

    public final void HI() {
        if (!this.odv) {
            x.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
            this.odv = true;
            af.aRu().postDelayed(new 48(this), 1000);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + lVar.getType());
        if (lVar.getType() == 218) {
            r rVar = (r) lVar;
            if ((rVar.type == 1 || rVar.type == 6 || rVar.type == 4) && this.ocz.nLY != null) {
                this.ocz.nLY.dismiss();
            }
            if (rVar.type == 11) {
                if (this.ocL.tipDialog != null) {
                    this.ocL.tipDialog.dismiss();
                }
                if (this.odr != null) {
                    this.odr.setImageResource(i$i.common_icons_camera);
                }
            }
        }
        if (this.oct != null) {
            this.oct.oeg.notifyVendingDataChange();
        }
        if (lVar.getType() == 211) {
            com.tencent.mm.plugin.sns.model.y yVar = (com.tencent.mm.plugin.sns.model.y) lVar;
            com.tencent.mm.modelsns.b io;
            if (yVar.nnR) {
                io = com.tencent.mm.modelsns.b.io(727);
                io.ir(this.oct.getCount()).ir(yVar.Ma);
                io.RD();
            } else {
                io = com.tencent.mm.modelsns.b.io(728);
                io.ir(this.oct.getCount()).ir(yVar.Ma).ir(0);
                io.RD();
            }
            if (this.ocA != null) {
                this.ocy = false;
                a aVar = this.ocA;
                x.i("MicroMsg.SnsTimeLineUI", "play end vis: %d, sumY %f MAX_Y %f", new Object[]{Integer.valueOf(aVar.odw.ocw.getVisibility()), Float.valueOf(aVar.odN), Float.valueOf(aVar.odL)});
                if (aVar.odw.ocw.getVisibility() == 0) {
                    aVar.init();
                    if (aVar.odN >= aVar.odL) {
                        aVar.odw.ocw.clearAnimation();
                        aVar.odw.ocw.startAnimation(aVar);
                        aVar.setDuration(1200);
                        aVar.odP = false;
                    }
                }
            }
        }
    }

    protected void finalize() {
        x.d("MicroMsg.SnsTimeLineUI", "finalize");
        super.finalize();
    }

    public final void HJ() {
        EW().Q(com.tencent.mm.plugin.sns.j.c.b.class);
    }

    public void onBackPressed() {
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 15) {
            if (this.ocz != null && this.ocz.nLX != null && this.ocz.nLX.okv != null) {
                this.ocz.nLX.okv.onActivityResult(i, i2, intent);
                ah.i(new 50(this), 300);
            }
        } else if (i == 16) {
            x.i("MicroMsg.SnsTimeLineUI", "REQUEST_CODE_FOR_FULLSCREEN");
        } else {
            super.onActivityResult(i, i2, intent);
            this.ocL.onActivityResult(i, i2, intent);
            if (i == 11) {
                this.ocr.onl.b(this.gtX, this.ocJ, this.nNG, this.ocK);
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.SnsTimeLineUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 18:
                if (iArr[0] == 0) {
                    bDX();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? i$j.permission_camera_request_again_msg : i$j.permission_microphone_request_again_msg;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this, getString(i2), getString(i$j.permission_tips_title), getString(i$j.jump_to_settings), getString(i$j.app_cancel), false, new 51(this), new 52(this));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onDrag() {
        super.onDrag();
        cqg();
    }
}
