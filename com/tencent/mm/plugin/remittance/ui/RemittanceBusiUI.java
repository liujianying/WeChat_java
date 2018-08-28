package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.am;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.g;
import com.tencent.mm.plugin.remittance.model.k;
import com.tencent.mm.plugin.remittance.model.l;
import com.tencent.mm.plugin.remittance.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.protocal.c.jc;
import com.tencent.mm.protocal.c.ji;
import com.tencent.mm.protocal.c.xb;
import com.tencent.mm.protocal.c.xc;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.picker.d$a;
import com.tencent.mm.ui.widget.picker.d.2;
import com.tencent.mm.ui.widget.picker.d.3;
import com.tencent.mm.wallet_core.d.c;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RemittanceBusiUI extends WalletBaseUI {
    private int kTw;
    private ScrollView klj;
    private String lJJ;
    private TextView mAA;
    private View mAB;
    private CdnImageView mAC;
    private WalletFormView mAD;
    private Button mAE;
    private LinearLayout mAF;
    private LinearLayout mAG;
    private TextView mAH;
    private View mAI;
    private TextView mAJ;
    private String mAK;
    private double mAL;
    private String mAM;
    private String mAN;
    private String mAO;
    private String mAP;
    private String mAQ;
    private int mAR;
    private String mAS;
    private boolean mAT;
    private String mAU;
    private int mAV;
    private int mAW;
    private String mAX;
    private btd mAY;
    private String mAZ;
    private String mAa;
    private BusiRemittanceResp mAe;
    private TextView mAu;
    private TextView mAv;
    private TextView mAw;
    private TextView mAx;
    private TextView mAy;
    private TextView mAz;
    private int mBa = 0;
    private int mBb = 0;
    private int mBc = 0;
    private int mBd = 0;
    private String mBe;
    private a mBf = new a();
    private String mBg = "";
    private String mBh = "";
    boolean mBi = false;
    private double mBj = -1.0d;
    private boolean mBk = false;
    g mBl = null;
    private a mBm;
    private a mBn;
    private Runnable mBo = new Runnable() {
        public final void run() {
            RemittanceBusiUI.B(RemittanceBusiUI.this);
        }
    };
    private c<l> mBp = new c<l>() {
        public final /* bridge */ /* synthetic */ boolean a(int i, int i2, d dVar) {
            return RemittanceBusiUI.a(RemittanceBusiUI.this, i, i2, (l) dVar);
        }

        public final void a(d dVar) {
            if (dVar instanceof l) {
                RemittanceBusiUI.this.hp(true);
            }
        }
    };
    private b mBq = new b(this);
    private com.tencent.mm.sdk.b.c mBr = new 19(this);
    private com.tencent.mm.sdk.b.c mBs = new 20(this);
    private String myR;
    private int myU;
    private String mzV;
    private String mzW;
    private LinearLayout mzg;
    private String mzp;
    private boolean mzs = false;
    private boolean mzt;
    private boolean mzw;
    private com.tencent.mm.sdk.b.c mzx = new 18(this);

    static /* synthetic */ void B(RemittanceBusiUI remittanceBusiUI) {
        boolean z = true;
        if (remittanceBusiUI.mAe == null) {
            x.e("MicroMsg.RemittanceBusiUI", "busi_resp is null");
            if (remittanceBusiUI.mBl != null) {
                remittanceBusiUI.mBl.mxg = true;
                return;
            }
            return;
        }
        remittanceBusiUI.mAL = remittanceBusiUI.brx();
        x.i("MicroMsg.RemittanceBusiUI", "update updateBilling %s", new Object[]{Integer.valueOf((int) Math.round(remittanceBusiUI.mAL * 100.0d))});
        if (((int) Math.round(remittanceBusiUI.mAL * 100.0d)) <= 0) {
            remittanceBusiUI.mBl.mxg = true;
            remittanceBusiUI.mBf.brh();
            remittanceBusiUI.mAA.setTextColor(-7829368);
            remittanceBusiUI.mAA.setText(remittanceBusiUI.mAe.mwP);
            if (remittanceBusiUI.mBl != null) {
                remittanceBusiUI.mBl.mxg = true;
                return;
            }
            return;
        }
        remittanceBusiUI.mAA.setText(i.remittance_busi_favor_get_ing);
        com.tencent.mm.ab.l lVar = remittanceBusiUI.mBl;
        if (remittanceBusiUI.mBl.mxc == null) {
            z = false;
        }
        remittanceBusiUI.a(lVar, z, false);
    }

    static /* synthetic */ boolean a(RemittanceBusiUI remittanceBusiUI, int i, int i2, l lVar) {
        long j = 0;
        if (remittanceBusiUI.mBb == 0) {
            return false;
        }
        if (remittanceBusiUI.mBd >= remittanceBusiUI.mBb) {
            x.i("MicroMsg.RemittanceBusiUI", "mZero_start_time %s >= mZero_try_time %s say bye bye", new Object[]{Integer.valueOf(remittanceBusiUI.mBd), Integer.valueOf(remittanceBusiUI.mBb)});
            return false;
        }
        remittanceBusiUI.mBq.mBH = lVar;
        b bVar;
        if (i != 0 || i2 != 0) {
            remittanceBusiUI.mBd++;
            x.i("MicroMsg.RemittanceBusiUI", "mZero_try_interval_ms  mZero_start_time %s mZero_try_interval_ms %s", new Object[]{Integer.valueOf(remittanceBusiUI.mBd), Integer.valueOf(remittanceBusiUI.mBc)});
            ah.M(remittanceBusiUI.mBq);
            bVar = remittanceBusiUI.mBq;
            if (remittanceBusiUI.mBc >= 0) {
                j = (long) remittanceBusiUI.mBc;
            }
            ah.i(bVar, j);
            return true;
        } else if (lVar.mxo.hwV == 0) {
            return false;
        } else {
            if (lVar.mxo.hwV == 0 || !lVar.iMC) {
                return false;
            }
            remittanceBusiUI.mBd++;
            x.i("MicroMsg.RemittanceBusiUI", "mZero_try_interval_ms  mZero_start_time %s mZero_try_interval_ms %s", new Object[]{Integer.valueOf(remittanceBusiUI.mBd), Integer.valueOf(remittanceBusiUI.mBc)});
            ah.M(remittanceBusiUI.mBq);
            bVar = remittanceBusiUI.mBq;
            if (remittanceBusiUI.mBc >= 0) {
                j = (long) remittanceBusiUI.mBc;
            }
            ah.i(bVar, j);
            return true;
        }
    }

    static /* synthetic */ void e(RemittanceBusiUI remittanceBusiUI) {
        x.i("MicroMsg.RemittanceBusiUI", "do cancel pay");
        remittanceBusiUI.a(new t(remittanceBusiUI.mAM, remittanceBusiUI.mAK, remittanceBusiUI.mAQ, remittanceBusiUI.mzp), false, false);
    }

    static /* synthetic */ void l(RemittanceBusiUI remittanceBusiUI) {
        if (bi.oW(remittanceBusiUI.mzW)) {
            remittanceBusiUI.mAy.setText("");
            remittanceBusiUI.mAz.setText(i.remittance_busi_add_desc);
            return;
        }
        remittanceBusiUI.mAy.setText(remittanceBusiUI.getString(i.remittance_busi_pay_desc_dot, new Object[]{remittanceBusiUI.mzW}));
        remittanceBusiUI.mAz.setText(i.remittance_edit_desc_link);
    }

    static /* synthetic */ void o(RemittanceBusiUI remittanceBusiUI) {
        x.i("MicroMsg.RemittanceBusiUI", "do place order");
        if (remittanceBusiUI.mAe == null) {
            x.e("MicroMsg.RemittanceBusiUI", "doPlaceOrder busi_resp is null");
            return;
        }
        if (!remittanceBusiUI.mAT) {
            remittanceBusiUI.Wq();
        }
        int round = (int) Math.round(remittanceBusiUI.mAL * 100.0d);
        jc jcVar = remittanceBusiUI.mBf.myI;
        remittanceBusiUI.a(new com.tencent.mm.plugin.remittance.model.i(remittanceBusiUI.mzp, remittanceBusiUI.mAK, remittanceBusiUI.myU, remittanceBusiUI.mAP, remittanceBusiUI.mzW, round, remittanceBusiUI.kTw, remittanceBusiUI.mAQ, remittanceBusiUI.mAU, remittanceBusiUI.mAW, remittanceBusiUI.mAV, remittanceBusiUI.mAM, remittanceBusiUI.mBf.myH, jcVar == null ? "" : jcVar.rkw, remittanceBusiUI.mAe.mwQ, "", remittanceBusiUI.myR, "", remittanceBusiUI.mAN), true, false);
    }

    static /* synthetic */ void y(RemittanceBusiUI remittanceBusiUI) {
        List list = null;
        if (remittanceBusiUI.myU == 33) {
            if (remittanceBusiUI.mAe.mwU != null) {
                list = remittanceBusiUI.mAe.mwU.rkt;
            }
        } else if (remittanceBusiUI.mBf.brj()) {
            list = remittanceBusiUI.mBf.bri();
            if (list.size() == 0) {
                x.i("MicroMsg.RemittanceBusiUI", "can not find favor %s", new Object[]{Integer.valueOf(list.size())});
                return;
            }
        } else {
            list = remittanceBusiUI.mAe.mwT;
        }
        remittanceBusiUI.mAL = remittanceBusiUI.brx();
        if (((int) Math.round(remittanceBusiUI.mAL * 100.0d)) <= 0) {
            remittanceBusiUI.bX(list);
        } else if (!remittanceBusiUI.mBf.brj()) {
            remittanceBusiUI.a(new 4(remittanceBusiUI), new 5(remittanceBusiUI), 0);
        } else if (remittanceBusiUI.mBl == null) {
            remittanceBusiUI.bX(list);
        } else if (remittanceBusiUI.mBl.mxe) {
            remittanceBusiUI.bX(list);
        } else {
            remittanceBusiUI.mBl.mxc = new com.tencent.mm.plugin.remittance.model.c() {
                public final void bW(List<xc> list) {
                    RemittanceBusiUI.this.bX(list);
                }
            };
        }
    }

    private double brx() {
        if (this.mAT || this.myU == 33) {
            return this.mAL;
        }
        this.mAL = bi.getDouble(this.mAD.getText(), 0.0d);
        return this.mAL;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.mEJ.h(15235, new Object[]{Integer.valueOf(1)});
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.remittance_busi_common_bg)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(a.c.black));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(a.c.remittance_busi_common_bg));
        }
        if (com.tencent.mm.compatible.util.d.fR(21)) {
            if (com.tencent.mm.compatible.util.d.fR(23)) {
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        setBackBtn(new 12(this), a.h.actionbar_icon_dark_back);
        jr(1633);
        jr(1241);
        jr(2677);
        jr(2504);
        jr(2702);
        jr(2682);
        c cVar = this.mBp;
        com.tencent.mm.wallet_core.d.i iVar = this.uYO;
        cVar.rtType = 2682;
        cVar.uXI = iVar;
        iVar.uXO.put(Integer.valueOf(2682), cVar);
        setMMTitle(i.remittance_busi_pay);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RemittanceBusiUI.e(RemittanceBusiUI.this);
                RemittanceBusiUI.this.finish();
                return false;
            }
        });
        this.myU = getIntent().getIntExtra("pay_scene", 31);
        this.mAK = getIntent().getStringExtra("scan_remittance_id");
        this.mAL = getIntent().getDoubleExtra("fee", 0.0d);
        this.mAM = getIntent().getStringExtra("receiver_name");
        this.mAN = getIntent().getStringExtra("receiver_true_name");
        this.mAO = getIntent().getStringExtra("receiver_true_name_busi");
        this.kTw = getIntent().getIntExtra("pay_channel", 0);
        this.mAP = getIntent().getStringExtra("desc");
        this.mAR = getIntent().getIntExtra("busi_type", 0);
        this.myR = getIntent().getStringExtra("mch_name");
        this.mAU = getIntent().getStringExtra("mch_type");
        this.mAW = getIntent().getIntExtra("mch_time", 0);
        this.mAS = getIntent().getStringExtra("mch_info");
        this.mAV = getIntent().getIntExtra("get_pay_wifi", 0);
        this.mzp = getIntent().getStringExtra("rcvr_open_id");
        this.mAQ = getIntent().getStringExtra("rcvr_ticket");
        this.mBe = getIntent().getStringExtra("receiver_tips");
        this.mAe = (BusiRemittanceResp) getIntent().getParcelableExtra("BusiRemittanceResp");
        if (this.mAe != null) {
            boolean z = this.myU == 32 && (this.mAe.mwV == 1 || (this.mAe != null && this.mAe.mwT.size() > 0));
            this.mBi = z;
        }
        if (this.mAL > 0.0d) {
            this.mAT = true;
        } else {
            this.mAT = false;
        }
        if (this.mAR == 0) {
            x.w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
            finish();
        }
        h.mEJ.h(15386, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
        this.mBm = new a(this, 28, 28, 2.0f);
        this.mBn = new a(this, 50, 50, 8.0f);
        initView();
    }

    protected final void initView() {
        this.klj = (ScrollView) findViewById(f.root_view);
        this.mAu = (TextView) findViewById(f.remittance_busi_name);
        this.mAv = (TextView) findViewById(f.remittance_busi_nick_name);
        this.mAw = (TextView) findViewById(f.remittance_busi_fixed_title);
        this.mAx = (TextView) findViewById(f.remittance_busi_fixed_money);
        this.mAy = (TextView) findViewById(f.remittance_busi_desc);
        this.mAz = (TextView) findViewById(f.remittance_busi_add_desc);
        this.mAC = (CdnImageView) findViewById(f.remittance_busi_logo);
        this.mAD = (WalletFormView) findViewById(f.remittance_busi_money_et);
        this.mAE = (Button) findViewById(f.remittance_busi_pay_btn);
        this.mAF = (LinearLayout) findViewById(f.remittance_busi_fixed_money_layout);
        this.mzg = (LinearLayout) findViewById(f.remittance_busi_edit_money_layout);
        this.mAG = (LinearLayout) findViewById(f.remittance_busi_desc_container);
        this.mAA = (TextView) findViewById(f.favor_title_desc);
        this.mAB = findViewById(f.remittance_busi_favor_layout);
        this.mAH = (TextView) findViewById(f.remittance_busi_fixed_currency);
        this.mAI = findViewById(f.final_remittance_layout);
        this.mAJ = (TextView) findViewById(f.final_remittance_busi_fixed_money);
        if (this.mAT) {
            if (!bi.oW(this.mAP)) {
                this.mAw.setText(j.a(this, this.mAP, this.mAw.getTextSize()));
            }
            this.mAx.setText(e.A(this.mAL));
            this.mAF.setVisibility(0);
            this.mzg.setVisibility(8);
        } else {
            boolean z;
            if (this.mAe != null) {
                boolean z2;
                if (this.mAe.mwT.size() > 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                z = (this.mAe.mwU == null || this.mAe.mwU.rkt.size() <= 0) ? z2 : false;
            } else {
                z = true;
            }
            a(this.mAD, 2, false, z, true);
            this.mAD.a(new 21(this));
            this.mAF.setVisibility(8);
            this.mzg.setVisibility(0);
        }
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            com.tencent.mm.kernel.g.Ek();
            ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(this.mAM);
            if (Yg == null || ((int) Yg.dhP) == 0) {
                am.a.dBr.a(this.mAM, "", new 22(this));
            }
        }
        bru();
        this.mAG.setOnClickListener(new 23(this));
        this.mAE.setOnClickListener(new 24(this));
        this.klj.setOnTouchListener(new 25(this));
        this.kTx = new com.tencent.mm.wallet_core.ui.a() {
            public final void fI(boolean z) {
                RemittanceBusiUI.this.mBk = z;
                if (z) {
                    RemittanceBusiUI.this.a(RemittanceBusiUI.this.klj, RemittanceBusiUI.this.mAE, 30);
                    return;
                }
                RemittanceBusiUI.this.klj.scrollTo(0, 0);
                if (RemittanceBusiUI.this.mAD != null && RemittanceBusiUI.this.mAD.getVisibility() == 0) {
                    RemittanceBusiUI.this.mAD.setFocusable(false);
                    RemittanceBusiUI.this.mAD.setFocusable(true);
                }
            }
        };
        if (!(this.mAe == null || this.mAe.mwU == null)) {
            this.mBf.myI = this.mAe.mwU;
            this.mBf.KA(this.mAe.mwU.rkv);
        }
        if (bry()) {
            h.mEJ.h(15235, new Object[]{Integer.valueOf(2)});
        }
    }

    private void bru() {
        ah.A(new 27(this));
    }

    private boolean bry() {
        if (this.mAB == null || this.mAe == null) {
            return false;
        }
        boolean z;
        x.i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
        if (this.mAe.mwU == null || this.mAe.mwU.rku.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (this.mAe.mwT.size() > 0) {
            z = true;
        }
        if (this.mBf.bri().size() > 0) {
            z = true;
        }
        if (z) {
            this.mAI.setVisibility(0);
            this.mBm.update();
            this.mAB.setVisibility(0);
            this.mAA.setText(this.mAe.mwP);
            this.mAA.setTextColor(-7829368);
            this.mAJ.setText(e.A(brx()));
            xb xbVar = this.mBf.myH;
            if (xbVar != null) {
                this.mAA.setTextColor(-30434);
                this.mAA.setText(xbVar.mwP);
                this.mAJ.setText(e.A(((double) xbVar.rCu) / 100.0d));
            } else {
                a aVar = this.mBf;
                CharSequence charSequence = aVar.myI == null ? "" : aVar.myI.rkx;
                if (!bi.oW(charSequence)) {
                    this.mAA.setTextColor(-7829368);
                    this.mAA.setText(charSequence);
                }
            }
            findViewById(f.favor_layout_ll).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    h.mEJ.h(15235, new Object[]{Integer.valueOf(3)});
                    RemittanceBusiUI.y(RemittanceBusiUI.this);
                }
            });
            return true;
        }
        this.mAB.setVisibility(8);
        this.mBn.update();
        this.mAI.setVisibility(8);
        return false;
    }

    private void bX(final List<xc> list) {
        final com.tencent.mm.ui.widget.picker.d dVar = new com.tencent.mm.ui.widget.picker.d(this);
        ArrayList arrayList = new ArrayList();
        xb xbVar = this.mBf.myH;
        HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        if (this.mBf.brk() && xbVar != null) {
            Iterator it = xbVar.rkt.iterator();
            while (it.hasNext()) {
                hashSet.add(Long.valueOf(((xc) it.next()).rCB));
            }
        }
        int i = 0;
        for (xc xcVar : list) {
            if (hashSet.contains(Long.valueOf(xcVar.rCB))) {
                arrayList.add(Integer.valueOf(i));
            }
            i++;
        }
        CharSequence string = getString(i.remittance_f2f_favor_select);
        if (string != null && string.length() > 0) {
            dVar.uLr.setVisibility(0);
            dVar.uLs.setText(string);
        }
        dVar.uLt = arrayList;
        dVar.ofp = new 6(this, list, hashSet2);
        dVar.ofq = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                if (!hashSet2.contains(Integer.valueOf(i)) && i < list.size()) {
                    boolean z;
                    int intValue;
                    h.mEJ.h(15235, new Object[]{Integer.valueOf(4)});
                    xc xcVar = (xc) list.get(i);
                    com.tencent.mm.ui.widget.picker.d dVar = dVar;
                    List<Integer> cAR = dVar.uLu != null ? dVar.uLu.cAR() : new ArrayList();
                    boolean contains = cAR.contains(Integer.valueOf(i));
                    if (contains) {
                        z = false;
                    } else {
                        z = true;
                    }
                    List linkedList = new LinkedList();
                    for (Integer intValue2 : cAR) {
                        intValue = intValue2.intValue();
                        if (intValue < list.size() && (z || i != intValue)) {
                            linkedList.add((xc) list.get(intValue));
                        }
                    }
                    if (z) {
                        linkedList.add(xcVar);
                    }
                    a z2 = RemittanceBusiUI.this.mBf;
                    if (!z) {
                        xcVar = null;
                    }
                    z2.a(linkedList, xcVar);
                    xb xbVar = RemittanceBusiUI.this.mBf.myH;
                    HashSet hashSet = new HashSet();
                    if (xbVar != null) {
                        Iterator it = xbVar.rkt.iterator();
                        while (it.hasNext()) {
                            hashSet.add(Long.valueOf(((xc) it.next()).rCB));
                        }
                    }
                    HashMap hashMap = new HashMap();
                    intValue = 0;
                    for (xc xcVar2 : list) {
                        if (hashSet.contains(Long.valueOf(xcVar2.rCB))) {
                            hashMap.put(Integer.valueOf(intValue), Boolean.valueOf(true));
                        } else {
                            hashMap.put(Integer.valueOf(intValue), Boolean.valueOf(false));
                        }
                        if (intValue == i) {
                            hashMap.put(Integer.valueOf(intValue), Boolean.valueOf(contains));
                        }
                        intValue++;
                    }
                    com.tencent.mm.ui.widget.picker.d dVar2 = dVar;
                    if (dVar2.uLu != null) {
                        dVar2.uLu.uLx = hashMap;
                        dVar2.uLu.notifyDataSetChanged();
                    }
                }
            }
        };
        dVar.uLv = new 8(this);
        if (dVar.ofp != null) {
            dVar.ofp.a(dVar.ofr);
        }
        dVar.uLu = new d$a(dVar, dVar.mContext);
        dVar.uLu.cAQ();
        dVar.uLq.setAdapter(dVar.uLu);
        dVar.eGn.setOnClickListener(new 2(dVar));
        dVar.haQ.setOnClickListener(new 3(dVar));
        if (dVar.tYZ != null) {
            if (dVar.ofr != null && dVar.ofr.size() > 3) {
                LayoutParams layoutParams = (LayoutParams) dVar.ilW.getLayoutParams();
                layoutParams.height = dVar.tZa;
                dVar.ilW.setLayoutParams(layoutParams);
            }
            dVar.tYZ.show();
        }
    }

    private void a(com.tencent.mm.plugin.remittance.model.c cVar, com.tencent.mm.plugin.remittance.model.d dVar, int i) {
        if (this.mBi) {
            this.mAJ.setText(e.A(brx()));
            ah.M(this.mBo);
            this.mAL = brx();
            long round = Math.round(this.mAL * 100.0d);
            if (round <= 0) {
                this.mBf.brh();
                this.mAA.setTextColor(-7829368);
                this.mAA.setText(this.mAe.mwP);
                if (this.mBl != null) {
                    this.mBl.mxg = true;
                    return;
                }
                return;
            }
            this.mBl = new g((int) round, this.kTw, this.mAe.mwQ, this.mAP, this.myR, this.mAe.mwR, this.mzp, this.mAM, this.mAe.mwS, cVar == null ? 0 : 1, cVar, dVar);
            ah.i(this.mBo, (long) i);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.sFg.c(this.mzx);
        com.tencent.mm.sdk.b.a.sFg.c(this.mBs);
        this.mBr.dead();
        js(1633);
        js(1241);
        js(2677);
        js(2504);
        js(2702);
        js(2682);
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        boolean z = true;
        if (lVar instanceof com.tencent.mm.plugin.remittance.model.i) {
            com.tencent.mm.plugin.remittance.model.i iVar = (com.tencent.mm.plugin.remittance.model.i) lVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.RemittanceBusiUI", "net error: %s", new Object[]{lVar});
            } else if (iVar.mxj.hwV == 0) {
                this.mzV = iVar.mxj.rcD;
                this.lJJ = iVar.mxj.rcE;
                this.mAa = iVar.mxj.rcF;
                this.mBg = iVar.mxj.rkN;
                this.mBh = iVar.mxj.rkM;
                this.mAX = iVar.mxj.rkS;
                this.mAY = iVar.mxj.rkR;
                this.mBa = iVar.mxj.rkV;
                this.mBb = iVar.mxj.rkT;
                this.mBc = iVar.mxj.rkU;
                x.i("MicroMsg.RemittanceBusiUI", "touch_challenge %s need_change_auth_key %s", new Object[]{iVar.mxj.rkW, Integer.valueOf(iVar.mxj.rkX)});
                if (iVar.mxj.rkW != null) {
                    s.pqR.jgX = iVar.mxj.rkW.cfV();
                }
                s sVar = s.pqR;
                if (iVar.mxj.rkX != 1) {
                    z = false;
                }
                sVar.jgY = z;
                if (!a(iVar)) {
                    b(iVar);
                }
            } else {
                x.e("MicroMsg.RemittanceBusiUI", "place order response: %s, %s", new Object[]{Integer.valueOf(iVar.mxj.hwV), iVar.mxj.hwW});
                if (iVar.mxj.rkL == null || bi.oW(iVar.mxj.rkL.kRu)) {
                    Toast.makeText(this, iVar.mxj.hwW, 1).show();
                } else {
                    a(iVar);
                }
                if (iVar.mxj.rkO == 1) {
                    a(null, null, 0);
                }
            }
        } else if (lVar instanceof com.tencent.mm.plugin.remittance.model.h) {
            x.i("MicroMsg.RemittanceBusiUI", "pay check callback");
            return true;
        } else if (lVar instanceof g) {
            x.i("MicroMsg.RemittanceBusiUI", "onSceneEnd %s errType %s errCode %s", new Object[]{lVar, Integer.valueOf(i), Integer.valueOf(i2)});
            g gVar = (g) lVar;
            if (!gVar.mxf.equals(this.mBl.mxf) || gVar.mxg) {
                gVar.mxe = true;
                x.e("MicroMsg.RemittanceBusiUI", "ignore this getFavor new coming soon %s", new Object[]{Boolean.valueOf(gVar.mxg)});
                return true;
            }
            com.tencent.mm.plugin.remittance.model.d dVar;
            if (i != 0 || i2 != 0) {
                this.mBf.brh();
                if (!(this.mAe == null || bi.oW(this.mAe.mwP))) {
                    this.mAA.setText(this.mAe.mwP);
                }
                this.mAA.setTextColor(-7829368);
                this.mAA.setText(getString(i.remittance_busi_favor_get_error_default));
                dVar = gVar.mxd;
                if (dVar != null) {
                    dVar.a(i, i2, gVar);
                }
            } else if (gVar.mxb.hwV == 0) {
                this.mBf.myI = gVar.mxb.mwU;
                this.mBf.KA(gVar.mxb.mwU.rkv);
                bry();
                com.tencent.mm.plugin.remittance.model.c cVar = gVar.mxc;
                x.i("MicroMsg.RemittanceBusiUI", "GetFavorAfterAction %s", new Object[]{cVar});
                if (cVar != null) {
                    cVar.bW(this.mBf.bri());
                }
            } else {
                this.mBf.brh();
                this.mAA.setTextColor(-7829368);
                this.mAA.setText(gVar.mxb.hwW);
                dVar = gVar.mxd;
                if (dVar != null) {
                    dVar.a(i, i2, gVar);
                }
            }
            gVar.mxe = true;
            return true;
        } else if (lVar instanceof l) {
            l lVar2 = (l) lVar;
            x.i("MicroMsg.RemittanceBusiUI", "NetSceneBusiF2fZeroCallback getHasRetried %s", new Object[]{Boolean.valueOf(lVar2.mxp)});
            if (i != 0 || i2 != 0) {
                com.tencent.mm.ui.base.h.a(this, getString(i.wallet_unknown_err), null, false, new 11(this));
            } else if (lVar2.mxo.hwV == 0) {
                brA();
            } else {
                brz();
                com.tencent.mm.ui.base.h.a(this, lVar2.mxo.hwW, null, false, new 10(this));
            }
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        x.i("MicroMsg.RemittanceBusiUI", "onActivityResult requestCode %s resultCode %s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent});
        if (i == 3) {
            if (i2 != -1) {
                z = false;
            }
            a(z, intent);
        } else if (i == 1) {
            if (i2 != -1) {
                z = false;
            }
            a(z, intent);
        } else if (i == 2) {
            if (i2 == -1) {
                this.mAZ = intent.getStringExtra("INTENT_RESULT_TOKEN");
                this.mBj = 0.0d;
                x.i("MicroMsg.RemittanceBusiUI", "onActivityResult _result_token: %s", new Object[]{r2});
                hp(false);
            } else {
                brz();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    private void a(boolean z, Intent intent) {
        if (z) {
            String stringExtra = intent.getStringExtra("key_trans_id");
            double doubleExtra = intent.getDoubleExtra("key_total_fee", -1.0d);
            x.i("MicroMsg.RemittanceBusiUI", "onActivityResult _transId: %s _totalFee: %s", new Object[]{stringExtra, Double.valueOf(doubleExtra)});
            if (bi.oW(this.lJJ)) {
                this.lJJ = stringExtra;
            }
            if (doubleExtra >= 0.0d) {
                this.mBj = doubleExtra;
            }
            if (this.mzs) {
                h.mEJ.h(15386, new Object[]{Integer.valueOf(3), Integer.valueOf(2)});
            }
            brA();
            x.i("MicroMsg.RemittanceBusiUI", "do pay check");
            int round = (int) Math.round(this.mAL * 100.0d);
            ch chVar = new ch();
            chVar.bVU = this.kTw;
            chVar.rcD = this.mzV;
            chVar.rcE = this.lJJ;
            chVar.mwQ = this.mAe.mwQ;
            chVar.scene = this.myU;
            chVar.rcF = this.mAa;
            chVar.rcG = this.mBf.myH;
            chVar.rcH = this.mAM;
            chVar.myl = this.mzp;
            chVar.rcI = round;
            a(new com.tencent.mm.plugin.remittance.model.h(chVar, this.mBg), false, false);
            return;
        }
        x.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
        brz();
    }

    private void hp(boolean z) {
        x.i("MicroMsg.RemittanceBusiUI", "doBusiZeroCallback %s", new Object[]{Boolean.valueOf(z)});
        xb xbVar = this.mBf.myH;
        int round = (int) Math.round(this.mAL * 100.0d);
        ch chVar = new ch();
        chVar.bVU = this.kTw;
        chVar.rcD = this.mzV;
        chVar.rcE = this.lJJ;
        chVar.mwQ = this.mAe.mwQ;
        chVar.scene = this.myU;
        chVar.rcF = this.mAa;
        chVar.rcG = xbVar;
        chVar.rcH = this.mAM;
        chVar.myl = this.mzp;
        chVar.rcI = round;
        com.tencent.mm.ab.l lVar = new l(this.mAY, chVar, this.mAX, z ? 1 : 0, this.mAZ);
        if (z) {
            lVar.mxp = true;
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(lVar, 0);
            return;
        }
        this.mBd = 0;
        a(lVar, true, false);
    }

    private void brz() {
        x.i("MicroMsg.RemittanceBusiUI", "unLockFavorimp");
        xb xbVar = this.mBf.myH;
        if (xbVar == null) {
            x.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo is null");
            return;
        }
        int round = (int) Math.round(this.mAL * 100.0d);
        ch chVar = new ch();
        chVar.bVU = this.kTw;
        chVar.rcD = this.mzV;
        chVar.rcE = this.lJJ;
        chVar.mwQ = this.mAe.mwQ;
        chVar.scene = this.myU;
        chVar.rcF = this.mAa;
        chVar.rcG = xbVar;
        chVar.rcH = this.mAM;
        chVar.myl = this.mzp;
        chVar.rcI = round;
        a(new k(chVar, this.mBg), false, false);
    }

    protected final int getLayoutId() {
        return a.g.remittance_busi_ui;
    }

    private void brA() {
        x.i("MicroMsg.RemittanceBusiUI", "goto busi result");
        Intent intent = new Intent(this, RemittanceBusiResultUI.class);
        intent.putExtra("key_pay_desc", this.mzW);
        intent.putExtra("key_rcv_desc", this.mAP);
        if (this.mAe != null) {
            intent.putExtra("BusiRemittanceResp", this.mAe);
        }
        intent.putExtra("key_mch_name", this.myR);
        intent.putExtra("key_rcver_name", this.mAM);
        intent.putExtra("key_rcver_true_name", this.mAN);
        if (this.mBj >= 0.0d) {
            intent.putExtra("key_money", this.mBj);
        } else {
            intent.putExtra("key_money", this.mAL);
        }
        intent.putExtra("key_f2f_id", this.mzV);
        intent.putExtra("key_trans_id", this.lJJ);
        intent.putExtra("key_check_sign", this.mAa);
        intent.putExtra("key_rcvr_open_id", this.mzp);
        intent.putExtra("key_channel", this.kTw);
        if (this.mAe != null) {
            intent.putExtra("key_succ_show_avatar_type", this.mAe.mwW);
            intent.putExtra("key_succ_show_avatar_show", this.mAe.mwN);
            intent.putExtra("key_succ_show_avatar_url", this.mAe.mwO);
        }
        if (this.mAe != null) {
            intent.putExtra("key_scan_sceen", this.mAe.mwQ);
        }
        intent.putExtra("key_succ_page_extend", this.mBh);
        xb xbVar = this.mBf.myH;
        int round = (int) Math.round(this.mAL * 100.0d);
        ch chVar = new ch();
        chVar.bVU = this.kTw;
        chVar.rcD = this.mzV;
        chVar.rcE = this.lJJ;
        chVar.mwQ = this.mAe.mwQ;
        chVar.scene = this.myU;
        chVar.rcF = this.mAa;
        chVar.rcG = xbVar;
        chVar.rcH = this.mAM;
        chVar.myl = this.mzp;
        chVar.rcI = round;
        try {
            intent.putExtra("AfterPlaceOrderCommReq", chVar.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.RemittanceBusiUI", e, "", new Object[0]);
        }
        startActivity(intent);
        finish();
    }

    private boolean a(final com.tencent.mm.plugin.remittance.model.i iVar) {
        boolean z;
        if (this.mzt) {
            z = false;
        } else if (bi.oW(iVar.mxj.rkK)) {
            z = false;
        } else {
            this.mzt = true;
            com.tencent.mm.ui.base.h.a(this, iVar.mxj.rkK, getString(i.app_remind), getString(i.remittance_busi_continue_text), getString(i.app_cancel), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (RemittanceBusiUI.this.a(iVar)) {
                        RemittanceBusiUI.this.brz();
                    } else {
                        RemittanceBusiUI.this.b(iVar);
                    }
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    RemittanceBusiUI.this.brz();
                }
            });
            z = true;
        }
        if (z) {
            return z;
        }
        if (iVar.mxj.rkL == null) {
            return false;
        }
        this.mzw = true;
        com.tencent.mm.ui.base.h.a(this, iVar.mxj.hwW, "", iVar.mxj.rkL.kRv, iVar.mxj.rkL.kRu, new 16(this, iVar), new 17(this));
        return true;
    }

    protected void onNewIntent(Intent intent) {
        x.v("MicroMsg.RemittanceBusiUI", "onNewIntent");
    }

    private void b(com.tencent.mm.plugin.remittance.model.i iVar) {
        x.i("MicroMsg.RemittanceBusiUI", "do start pay zero_pay_flag: %s", new Object[]{Integer.valueOf(iVar.mxj.rkP)});
        Bundle bundle;
        if (iVar.mxj.rkP == 1) {
            ji jiVar = iVar.mxj;
            x.i("MicroMsg.RemittanceBusiUI", "resp.payer_need_auth_flag %s", new Object[]{Integer.valueOf(jiVar.rkQ)});
            if (jiVar.rkQ == 1) {
                bundle = new Bundle();
                com.tencent.mm.sdk.b.a.sFg.b(this.mBs);
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceBusiUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                bundle.putInt("real_name_verify_mode", 0);
                bundle.putInt("entry_scene", this.myU);
                com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
                return;
            }
            String str;
            Intent intent = new Intent();
            String str2 = "";
            if (bi.oW(this.mBe)) {
                String string = getString(i.wallet_pwd_dialog_remittance_desc_txt);
                if (bi.oW(this.mAM)) {
                    x.e("MicroMsg.RemittanceBusiUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                    str = str2;
                } else {
                    com.tencent.mm.kernel.g.Ek();
                    ab Ye = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(this.mAM);
                    if (Ye != null) {
                        Object[] objArr = new Object[1];
                        objArr[0] = e.acg(Ye.BL()) + (bi.oW(this.mAN) ? "" : "(" + this.mAN + ")");
                        str = bi.q(string, objArr);
                    } else {
                        x.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.mAM);
                        str = str2;
                    }
                }
            } else {
                str = this.mBe;
            }
            intent.putExtra("INTENT_TITLE", str);
            intent.putExtra("INTENT_CAN_TOUCH", this.mBa);
            intent.putExtra("INTENT_PAYFEE", e.A(0.0d));
            try {
                intent.putExtra("INTENT_TOKENMESS", jiVar.rkR.toByteArray());
                com.tencent.mm.bg.d.b(this.mController.tml, "wallet", "com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI", intent, 2);
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.RemittanceBusiUI", e, "", new Object[0]);
                return;
            }
        }
        PayInfo payInfo = new PayInfo();
        payInfo.bOd = iVar.mxj.bQa;
        payInfo.bVY = this.myU;
        if (this.kTw > 0) {
            payInfo.bVU = this.kTw;
        }
        bundle = new Bundle();
        bundle.putString("extinfo_key_1", this.mAM);
        bundle.putString("extinfo_key_2", this.mAN);
        bundle.putString("extinfo_key_3", this.mAP);
        bundle.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
        bundle.putString("extinfo_key_7", this.mzW);
        bundle.putString("extinfo_key_19", iVar.mxj.mxZ);
        payInfo.qUL = bundle;
        payInfo.myh = 1;
        Intent intent2 = new Intent();
        if (iVar.mxj.mxW == 1) {
            bundle.putInt("extinfo_key_15", iVar.mxj.rkY);
            bundle.putString("extinfo_key_17", iVar.mxj.mxX);
            bundle.putString("extinfo_key_18", iVar.mxj.mxY);
            intent2.putExtra("key_pay_info", payInfo);
            intent2.putExtra("from_patch_ui", true);
            intent2.putExtra("key_rcvr_open_id", this.mzp);
            intent2.putExtra("key_mch_info", this.mAS);
            intent2.putExtra("key_mch_photo", this.mAe.mwO);
            intent2.putExtra("key_transfer_qrcode_id", this.mAK);
            intent2.putExtra("get_dynamic_code_sign", iVar.mxj.mxX);
            intent2.putExtra("get_dynamic_code_extend", iVar.mxj.mxY);
            intent2.putExtra("dynamic_code_spam_wording", iVar.mxj.mya);
            intent2.putExtra("dynamic_code_amount", iVar.mxj.rkY);
            intent2.putExtra("show_paying_wording", iVar.mxj.mxZ);
            intent2.putExtra("show_avatar_type", this.mAe.mwW == 1);
            h.mEJ.h(15386, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
            com.tencent.mm.sdk.b.a.sFg.a(this.mzx);
            this.mBr.cht();
            com.tencent.mm.bg.d.b(this, "wallet_payu", ".create.ui.WalletPayUVerifyCodeUI", intent2, 3);
            return;
        }
        if (bi.oW(iVar.mxk)) {
            this.mzs = false;
        } else {
            this.mzs = true;
        }
        if (iVar.mxl == null || iVar.mxl.bNX.bOb == null) {
            com.tencent.mm.pluginsdk.wallet.h.a(this, false, "", payInfo, this.mAN, intent2, 1);
        } else {
            com.tencent.mm.pluginsdk.wallet.h.a(iVar.mxl.bNX.bOb, false, "", payInfo, this.mAN, intent2, iVar.mxl.bNX.bNZ);
        }
    }
}
