package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.c.k;
import com.tencent.mm.plugin.wallet_core.c.n;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.az;
import com.tencent.mm.protocal.c.bdr;
import com.tencent.mm.protocal.c.zq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoNewUI extends WalletOrderInfoUI {
    private String gtX = null;
    private String lJJ;
    private c lLY = new c<tb>() {
        {
            this.sFo = tb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            tb tbVar = (tb) bVar;
            if (!(tbVar instanceof tb)) {
                return false;
            }
            if (!tbVar.ceA.ceB.lKP) {
                x.i("MicroMsg.WalletOrderInfoNewUI", "block pass");
                return true;
            } else if (!"1".equals(tbVar.ceA.ceB.ced) && !"2".equals(tbVar.ceA.ceB.ced)) {
                return false;
            } else {
                RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.a(tbVar.ceA.ceB.ced, tbVar.ceA.ceB.cee, tbVar.ceA.ceB.cef, tbVar.ceA.ceB.ceg, tbVar.ceA.ceB.ceh, WalletOrderInfoNewUI.this.mCn == null ? 0 : WalletOrderInfoNewUI.this.mCn.bVY);
                x.i("MicroMsg.WalletOrderInfoNewUI", "receive guide");
                WalletOrderInfoNewUI.this.sy.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                return false;
            }
        }
    };
    private String lPn = null;
    private d.a.a.c mAh;
    private WalletSuccPageAwardWidget mAi;
    private ViewGroup mAn;
    private ViewGroup mAo;
    private ViewGroup mAp;
    private String mAppId = "";
    private TextView mAq;
    private String mBW;
    private PayInfo mCn;
    private TextView mDd;
    private Orders pfb;
    private int poM;
    private boolean ptd = false;
    private String pte;
    private String ptf;
    private b pth;
    private HashMap<String, a> pti = new HashMap();
    private String ptj;
    private String ptl = "-1";
    private Button ptm;
    private ImageView ptn;
    private ViewGroup pto;
    private CdnImageView ptp;
    private TextView ptq;
    private TextView ptr;
    private View pts;
    private Button ptt;
    private ViewGroup ptu;
    private boolean ptv = false;
    private boolean ptw = false;
    private boolean ptx = false;
    private com.tencent.mm.wallet_core.c pty;
    public Set<String> pvK = null;
    private List<Commodity> pvL = null;
    private RecommendTinyAppInfo pvM;
    private String pvN;
    private Promotions pvO = null;
    private TextView pvP;
    private TextView pvQ;
    private WalletTextView pvR;
    private ViewGroup pvS;
    private ViewGroup pvT;
    private ViewGroup pvU;
    private ViewGroup pvV;
    private ViewGroup pvW;
    private ViewGroup pvX;
    private TextView pvY;
    private CheckBox pvZ;
    private ViewGroup pwa;
    private CdnImageView pwb;
    private TextView pwc;
    private TextView pwd;
    private Button pwe;
    private boolean pwf = false;
    private c pwg = new 9(this);

    static class a {
        public String bSc;
        public String bWP;
        public String paD;
        public String paE;
        public String poI;
        public String poJ;
        public String poK;
        public String poL;
        public String pwk;
        public int pwl;
        public String title;
        public String url;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("activity_change_info");
                if (optJSONObject != null) {
                    this.url = optJSONObject.optString("url");
                    this.bSc = optJSONObject.optString("wording");
                    this.bWP = optJSONObject.optString("icon");
                    this.pwk = optJSONObject.optString("btn_text");
                    this.title = optJSONObject.optString("title");
                    this.poI = optJSONObject.optString("tinyapp_name");
                    this.poJ = optJSONObject.optString("tinyapp_logo");
                    this.poK = optJSONObject.optString("tinyapp_desc");
                    this.paD = optJSONObject.optString("tinyapp_username");
                    this.paE = optJSONObject.optString("tinyapp_path");
                    this.poL = optJSONObject.optString("activity_tinyapp_btn_text");
                }
            }
        }

        public a(bdr bdr) {
            if (bdr != null && bdr.sfR != null) {
                az azVar = bdr.sfR;
                this.url = azVar.url;
                this.bSc = azVar.bSc;
                this.bWP = azVar.bWP;
                this.pwk = azVar.pwk;
                this.title = azVar.title;
                this.paD = azVar.paD;
                this.paE = azVar.paE;
                this.pwl = azVar.pwl;
                this.poI = this.title;
                this.poJ = this.bWP;
                this.poK = this.bSc;
                this.poL = this.pwk;
            }
        }

        public final String toString() {
            return this.url + " , " + this.bSc + " , " + this.bWP + " , " + this.pwk + " , " + this.title;
        }
    }

    static /* synthetic */ void p(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        String str = "MicroMsg.WalletOrderInfoNewUI";
        String str2 = "onClickActivity, activityId: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(walletOrderInfoNewUI.pvO != null ? walletOrderInfoNewUI.pvO.pji : 0);
        x.i(str, str2, objArr);
        if (walletOrderInfoNewUI.pvO != null && walletOrderInfoNewUI.pvO.pji > 0) {
            walletOrderInfoNewUI.ptw = true;
            if (walletOrderInfoNewUI.ptl.equals("-1") || walletOrderInfoNewUI.ptl.equals("3")) {
                h.mEJ.h(13472, new Object[]{walletOrderInfoNewUI.mBW, Integer.valueOf(walletOrderInfoNewUI.pvO.ppT), Integer.valueOf(1), Long.valueOf(walletOrderInfoNewUI.pvO.pji), Long.valueOf(walletOrderInfoNewUI.pvO.poF)});
                h.mEJ.h(13033, new Object[]{Integer.valueOf(2), "", walletOrderInfoNewUI.pvO.url, walletOrderInfoNewUI.pvO.name, ""});
                if (!bi.oW(walletOrderInfoNewUI.pvO.ppW) && !bi.oW(walletOrderInfoNewUI.pvO.ppX)) {
                    x.i("MicroMsg.WalletOrderInfoNewUI", "promotion jump tiny app, username: %s, path: %s, version: %s", new Object[]{walletOrderInfoNewUI.pvO.ppW, walletOrderInfoNewUI.pvO.ppX, Integer.valueOf(walletOrderInfoNewUI.pvO.ppY)});
                    walletOrderInfoNewUI.pth = new b(walletOrderInfoNewUI.pvO.pji, walletOrderInfoNewUI.pvO.ppU, walletOrderInfoNewUI.pvO.poD, walletOrderInfoNewUI.pvO.poE, walletOrderInfoNewUI.bNs(), walletOrderInfoNewUI.mBW, walletOrderInfoNewUI.pvO.poF, walletOrderInfoNewUI.pvO.pqa);
                    qu quVar = new qu();
                    quVar.cbq.userName = walletOrderInfoNewUI.pvO.ppW;
                    quVar.cbq.cbs = bi.aG(walletOrderInfoNewUI.pvO.ppX, "");
                    quVar.cbq.scene = 1060;
                    quVar.cbq.bGG = walletOrderInfoNewUI.lJJ;
                    quVar.cbq.cbt = 0;
                    if (walletOrderInfoNewUI.pvO.ppY > 0) {
                        quVar.cbq.cbu = walletOrderInfoNewUI.pvO.ppY;
                    }
                    quVar.cbq.context = walletOrderInfoNewUI;
                    com.tencent.mm.sdk.b.a.sFg.m(quVar);
                    h.mEJ.h(14118, new Object[]{walletOrderInfoNewUI.lJJ, walletOrderInfoNewUI.bNs(), Integer.valueOf(2)});
                } else if (walletOrderInfoNewUI.pvO.ppT == 1) {
                    Promotions promotions = walletOrderInfoNewUI.pvO;
                    x.i("MicroMsg.WalletOrderInfoNewUI", "doSceneSendPayAward, getAwardParams==null: %s, %s", new Object[]{Boolean.valueOf(bi.oW(promotions.ppZ)), promotions.ppZ});
                    if (bi.oW(promotions.ppZ)) {
                        walletOrderInfoNewUI.a(new n(promotions, walletOrderInfoNewUI.bNs(), walletOrderInfoNewUI.lJJ, promotions.poF), true, false);
                    } else {
                        walletOrderInfoNewUI.a(new com.tencent.mm.plugin.wallet_core.c.h(promotions.ppZ, promotions.pji), true, false);
                    }
                } else if (walletOrderInfoNewUI.pvO.ppT != 2 || bi.oW(walletOrderInfoNewUI.pvO.url)) {
                    x.e("MicroMsg.WalletOrderInfoNewUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                } else if (walletOrderInfoNewUI.pti.containsKey(walletOrderInfoNewUI.pvO.pji)) {
                    a aVar = (a) walletOrderInfoNewUI.pti.get(walletOrderInfoNewUI.pvO.pji);
                    x.i("MicroMsg.WalletOrderInfoNewUI", "go to new url %s", new Object[]{aVar.url});
                    if (bi.oW(aVar.url)) {
                        walletOrderInfoNewUI.Ps(walletOrderInfoNewUI.pvO.url);
                    } else {
                        walletOrderInfoNewUI.Ps(aVar.url);
                    }
                } else {
                    walletOrderInfoNewUI.ptj = walletOrderInfoNewUI.pvO.url;
                    String str3 = walletOrderInfoNewUI.pvO.url;
                    b bVar = new b(walletOrderInfoNewUI.pvO.pji, walletOrderInfoNewUI.pvO.ppU, walletOrderInfoNewUI.pvO.poD, walletOrderInfoNewUI.pvO.poE, walletOrderInfoNewUI.bNs(), walletOrderInfoNewUI.mBW, walletOrderInfoNewUI.pvO.poF, walletOrderInfoNewUI.pvO.pqa);
                    x.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", new Object[]{str3});
                    walletOrderInfoNewUI.bQb();
                    walletOrderInfoNewUI.pth = bVar;
                    e.r(walletOrderInfoNewUI, str3, 1);
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        if (d.fR(21)) {
            if (d.fR(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        ux(4);
        this.pvK = new HashSet();
        com.tencent.mm.wallet_core.c af = com.tencent.mm.wallet_core.a.af(this);
        this.mCn = (PayInfo) this.sy.getParcelable("key_pay_info");
        this.lJJ = this.sy.getString("key_trans_id");
        this.sy.getInt("key_pay_type", -1);
        x.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", new Object[]{this.lJJ});
        this.pfb = bQo();
        if (this.pfb != null) {
            ux(0);
            b(this.pfb);
            if (!(af == null || this.pfb == null || this.mCn == null)) {
                int i2;
                boolean z;
                int i3;
                this.mAppId = this.mCn.appId;
                boolean cCT = af.cCT();
                com.tencent.mm.plugin.wallet_core.e.c.b(this, this.sy, 7);
                if (this.sy.getInt("key_support_bankcard", 1) == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                h hVar = h.mEJ;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.mCn.bVY);
                if (this.mCn.bVY == 3) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                if (cCT) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                objArr[2] = Integer.valueOf(i3);
                objArr[3] = Integer.valueOf(q.cDg());
                objArr[4] = Integer.valueOf((int) (this.pfb.mBj * 100.0d));
                objArr[5] = this.pfb.lNV;
                objArr[6] = Integer.valueOf(i2);
                hVar.h(10691, objArr);
            }
            if (!((o.bOW().bPs() || af == null || !af.cCT()) && com.tencent.mm.model.q.GO())) {
                com.tencent.mm.model.q.GP();
            }
            if (this.pfb == null || this.pfb.ppf == null || this.pfb.ppf.size() <= 0) {
                x.l("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
                com.tencent.mm.ui.base.h.a(this.mController.tml, i.wallet_order_info_err, 0, new 16(this));
            } else {
                this.pvL = this.pfb.ppf;
                x.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", new Object[]{Integer.valueOf(this.pvL.size())});
                this.lJJ = ((Commodity) this.pvL.get(0)).bOe;
                this.mBW = ((Commodity) this.pvL.get(0)).bOe;
                if (!(this.mCn == null || af == null || (!af.cCS() && !af.cCT()))) {
                    a(new y(bNs(), 21), true, true);
                }
            }
            if (this.lJJ == null) {
                boolean booleanValue;
                Object obj = g.Ei().DT().get(com.tencent.mm.storage.aa.a.sQv, Boolean.valueOf(false));
                if (obj != null) {
                    booleanValue = ((Boolean) obj).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (booleanValue) {
                    x.i("MicroMsg.WalletOrderInfoNewUI", "has show the finger print auth guide!");
                } else {
                    com.tencent.mm.wallet_core.c af2 = com.tencent.mm.wallet_core.a.af(this);
                    Bundle bundle2 = new Bundle();
                    if (af2 != null) {
                        bundle2 = af2.jfZ;
                    }
                    if (TextUtils.isEmpty(bundle2.getString("key_pwd1"))) {
                        x.i("MicroMsg.WalletOrderInfoNewUI", "pwd is empty, not show the finger print auth guide!");
                    } else if (af2 != null) {
                        af2.a((Activity) this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle2);
                    }
                }
            }
        } else {
            x.l("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
            com.tencent.mm.ui.base.h.a(this.mController.tml, i.wallet_order_info_err, 0, new 17(this));
        }
        initView();
        this.pty = cDK();
        bPZ();
        jr(1979);
        jr(2948);
        jr(2710);
        com.tencent.mm.sdk.b.a.sFg.b(this.pwg);
        com.tencent.mm.sdk.b.a.sFg.b(this.lLY);
        this.ptx = true;
        if (this.mCn != null) {
            i = this.mCn.bVY;
        }
        u.d(i, this.mCn == null ? "" : this.mCn.bOd, 16, "");
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", new Object[]{Boolean.valueOf(this.ptx), this.pvO, Boolean.valueOf(this.ptv), Boolean.valueOf(this.ptw), this.pvM, this.mAh});
        if (WalletSuccPageAwardWidget.a(this.mAh)) {
            this.mAi.onResume();
        } else if (this.ptx) {
            this.ptx = false;
        } else if (this.pvO != null && this.ptw) {
            x.i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s %s, isCallQueryPayAward: %s", new Object[]{Boolean.valueOf(bi.oW(this.pvO.pqa)), this.pvO.pqa, Boolean.valueOf(this.pwf)});
            if (!this.pwf) {
                this.pwf = true;
                if (bi.oW(this.pvO.pqa)) {
                    a(new aa(this.pvO.pji, this.pvO.ppU, this.pvO.poD, this.pvO.poE, bNs(), this.mBW, this.pvO.poF), true, true);
                } else {
                    a(new k(this.pvO.pqa, this.pvO.pji), true, true);
                }
            }
        } else if (this.ptv && this.pvM != null) {
            a(new aa(this.pvM.pqc, this.pvM.pqe, this.pvM.pqf, this.pvM.pqg, bNs(), this.mBW, this.pvM.pqh), true, true);
        }
    }

    protected final void initView() {
        Commodity commodity;
        Commodity commodity2;
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.ptn = (ImageView) findViewById(f.wxpay_logo_iv);
        this.mDd = (TextView) findViewById(f.pay_succ_wording);
        this.pvP = (TextView) findViewById(f.brand_tv);
        this.pvQ = (TextView) findViewById(f.fee_unit_tv);
        this.pvR = (WalletTextView) findViewById(f.total_fee_tv);
        this.mAq = (TextView) findViewById(f.origin_fee_tv);
        this.ptm = (Button) findViewById(f.pay_finish_button);
        showHomeBtn(false);
        enableBackMenu(false);
        CharSequence string = getString(i.app_finish);
        if (this.mCn == null || this.mCn.bVY != 2) {
            if (!(this.pfb == null || bi.oW(this.pfb.ppq))) {
                string = this.pfb.ppq;
            }
        } else if (this.pfb != null && !bi.oW(this.pfb.ppq)) {
            string = this.pfb.ppq;
        } else if (!bi.oW(this.mCn.pCO)) {
            string = getString(i.app_back) + this.mCn.pCO;
        } else if (!(bi.oW(this.mCn.appId) || bi.oW(com.tencent.mm.pluginsdk.model.app.g.q(this, this.mCn.appId)))) {
            string = getString(i.app_back) + com.tencent.mm.pluginsdk.model.app.g.q(this, this.mCn.appId);
        }
        this.ptm.setText(string);
        this.ptm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletOrderInfoNewUI.this.done();
            }
        });
        this.pvS = (ViewGroup) findViewById(f.discount_info_layout);
        this.mAo = (ViewGroup) findViewById(f.discount_desc_list_layout);
        this.ptu = (ViewGroup) findViewById(f.wallet_order_info_bottom_layout);
        this.mAn = (ViewGroup) findViewById(f.discount_info_list_layout);
        this.mAp = (ViewGroup) findViewById(f.original_feeinfo_layout);
        this.pvT = (ViewGroup) findViewById(f.local_feeinfo_layout);
        this.pvU = (ViewGroup) findViewById(f.discount_rateinfo_layout);
        this.pvW = (ViewGroup) findViewById(f.show_info_container);
        this.pvV = (ViewGroup) findViewById(f.remark_layout);
        this.pto = (ViewGroup) findViewById(f.tinyapp_info_layout);
        this.ptp = (CdnImageView) findViewById(f.tinyapp_logo_iv);
        this.ptp.setUseSdcardCache(true);
        this.ptq = (TextView) findViewById(f.tinyapp_desc_tv);
        this.ptr = (TextView) findViewById(f.tinyapp_name_tv);
        this.ptt = (Button) findViewById(f.tinyapp_button);
        this.pts = findViewById(f.tinyapp_info_touch_mask);
        this.pvX = (ViewGroup) findViewById(f.subscribe_biz_layout);
        this.pvY = (TextView) findViewById(f.biz_name_tv);
        this.pvZ = (CheckBox) findViewById(f.subscribe_biz_checkbox);
        this.pwa = (ViewGroup) findViewById(f.activity_layout);
        this.pwb = (CdnImageView) findViewById(f.activity_logo_iv);
        this.pwb.setUseSdcardCache(true);
        this.pwd = (TextView) findViewById(f.activity_name_tv);
        this.pwc = (TextView) findViewById(f.activity_desc_tv);
        this.pwe = (Button) findViewById(f.activity_button);
        this.ptu.setVisibility(4);
        this.mAi = (WalletSuccPageAwardWidget) findViewById(f.award_widget);
        bPZ();
        if (!(this.pfb == null || this.pvL == null || this.pvL.size() <= 0)) {
            commodity = (Commodity) this.pvL.get(0);
            this.pvP.setText(commodity.lNK);
            this.pvQ.setText(e.abW(commodity.lNV));
            this.pvR.setText(String.format("%.2f", new Object[]{Double.valueOf(commodity.hUL)}));
        }
        String str = "MicroMsg.WalletOrderInfoNewUI";
        String str2 = "is_use_show_info: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.pfb == null ? 0 : this.pfb.ppr);
        x.i(str, str2, objArr);
        if (this.pfb == null || this.pfb.ppr != 1) {
            bQk();
            if (!(this.pfb == null || this.pvL == null || this.pvL.size() <= 0)) {
                commodity = (Commodity) this.pvL.get(0);
                if (commodity.ppE != null) {
                    TextView textView = (TextView) this.pvV.findViewById(f.remark_info_desc);
                    ((TextView) this.pvV.findViewById(f.remark_info_title)).setText(commodity.ppE.pqi);
                    textView.setText(commodity.ppE.pqj);
                    this.pvV.setVisibility(0);
                    this.pvS.setVisibility(0);
                }
            }
            this.pvU.setVisibility(8);
            this.pvT.setVisibility(8);
            if (!(this.pfb == null || this.pvL == null || this.pvL.size() <= 0)) {
                commodity = (Commodity) this.pvL.get(0);
                if (!bi.oW(commodity.ppC)) {
                    ((TextView) findViewById(f.local_feeinfo_tv)).setText(commodity.ppC);
                    this.pvT.setVisibility(0);
                    this.pvS.setVisibility(0);
                }
                if (!bi.oW(commodity.ppA)) {
                    ((TextView) findViewById(f.discount_rateinfo_tv)).setText(commodity.ppA);
                    this.pvU.setVisibility(0);
                    this.pvS.setVisibility(0);
                }
            }
        } else {
            this.pvT.setVisibility(8);
            this.pvU.setVisibility(8);
            this.mAp.setVisibility(8);
            this.mAn.setVisibility(8);
            this.pvV.setVisibility(8);
            bQm();
        }
        bQl();
        if (this.pvL == null || this.pvL.size() <= 0) {
            commodity2 = null;
        } else {
            commodity = (Commodity) this.pvL.get(0);
            if (!(commodity == null || commodity.ppF == null || commodity.ppF.size() <= 0)) {
                for (Promotions promotions : commodity.ppF) {
                    if (promotions.pqb != null && promotions.ppT == 5) {
                        this.mAh = promotions.pqb;
                        x.i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", new Object[]{this.mAh, Integer.valueOf(promotions.ppT)});
                        commodity2 = commodity;
                        break;
                    }
                }
            }
            commodity2 = commodity;
        }
        if (WalletSuccPageAwardWidget.a(this.mAh)) {
            if (commodity2 != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.mAi.getLayoutParams();
                List list = commodity2.ppz;
                if ((commodity2.ppw < 0.0d || commodity2.hUL >= commodity2.ppw) && (list == null || list.size() <= 0)) {
                    marginLayoutParams.topMargin = com.tencent.mm.bp.a.fromDPToPix(this, 50);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
                this.mAi.setLayoutParams(marginLayoutParams);
            }
            this.mAi.a(this, this.mAh, this.lJJ, false, (ImageView) findViewById(f.background));
            this.mAi.init();
            this.mAi.setVisibility(0);
            ImageView imageView = (ImageView) findViewById(f.background);
            imageView.post(new 14(this, imageView));
        } else {
            jx(true);
            this.mAi.setVisibility(8);
        }
        bPY();
    }

    private void bPY() {
        int i;
        int i2 = 0;
        if (this.pto.getVisibility() == 0) {
            i2 = 1;
        }
        if (this.pvS.getVisibility() == 0) {
            i2++;
        }
        if (this.pvX.getVisibility() == 0) {
            i2++;
        }
        if (this.pwa.getVisibility() == 0) {
            i = i2 + 1;
        } else {
            i = i2;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.ptn.getLayoutParams();
        MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) this.pvP.getLayoutParams();
        if (i >= 3) {
            i = com.tencent.mm.bp.a.fromDPToPix(this, 40);
            marginLayoutParams.topMargin = i;
            marginLayoutParams2.topMargin = i;
        } else {
            i = com.tencent.mm.bp.a.fromDPToPix(this, 70);
            marginLayoutParams.topMargin = i;
            marginLayoutParams2.topMargin = i;
        }
        this.ptn.setLayoutParams(marginLayoutParams);
        this.pvP.setLayoutParams(marginLayoutParams2);
        this.ptu.post(new 15(this));
    }

    private void bPZ() {
        if (this.pfb != null && this.pvL != null && this.pvL.size() > 0) {
            int i;
            for (Commodity commodity : this.pvL) {
                if ("1".equals(commodity.lNO)) {
                    i = 0;
                    break;
                }
            }
            i = 1;
            this.mDd.setVisibility(0);
            if (i == 0) {
                this.mDd.setText(i.wallet_order_info_result_wait);
            } else if (!bi.oW(this.pfb.poY) && !bi.oW(this.pfb.poY.trim())) {
                this.mDd.setText(this.pfb.poY);
            } else if (this.pfb.pjA != 1) {
                this.mDd.setText(i.wallet_order_info_result_success_international);
            } else {
                this.mDd.setText(i.wallet_order_info_result_success);
            }
        }
    }

    private void bQk() {
        this.pvS.setVisibility(8);
        this.mAo.setVisibility(8);
        this.mAn.setVisibility(8);
        this.mAp.setVisibility(8);
        if (this.pfb != null && this.pvL != null && this.pvL.size() > 0) {
            Commodity commodity = (Commodity) this.pvL.get(0);
            List list = commodity.ppz;
            String str = "MicroMsg.WalletOrderInfoNewUI";
            String str2 = "discountInfoList: %s, size: %s";
            Object[] objArr = new Object[2];
            objArr[0] = list;
            objArr[1] = Integer.valueOf(list != null ? list.size() : 0);
            x.i(str, str2, objArr);
            if (list != null && list.size() > 0) {
                this.mAo.removeAllViews();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    DiscountInfo discountInfo = (DiscountInfo) list.get(i2);
                    View textView = new TextView(this.mController.tml);
                    textView.setLayoutParams(new LayoutParams(-2, -2));
                    textView.setTextSize(1, 12.0f);
                    textView.setTextColor(Color.parseColor("#FA962A"));
                    if (discountInfo.ppR > 0.0d) {
                        textView.setText(discountInfo.mwP + e.e(discountInfo.ppR / 100.0d, this.pfb.lNV));
                    } else {
                        textView.setText(discountInfo.mwP);
                    }
                    this.mAo.addView(textView);
                    i = i2 + 1;
                }
                this.mAo.setVisibility(0);
                this.pvS.setVisibility(0);
                this.mAn.setVisibility(0);
            }
            if (commodity.ppw >= 0.0d && commodity.hUL < commodity.ppw) {
                this.mAq.setText(e.e(commodity.ppw, commodity.lNV));
                this.mAq.getPaint().setFlags(16);
                this.mAp.setVisibility(0);
                this.pvS.setVisibility(0);
            }
        }
    }

    private void bQl() {
        this.pvX.setVisibility(8);
        if (this.pfb != null) {
            b(this.pfb);
            if (this.pvL != null && this.pvL.size() > 0) {
                Commodity commodity = (Commodity) this.pvL.get(0);
                x.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", new Object[]{Boolean.valueOf(commodity.ppG)});
                if (commodity.ppG && commodity.ppF != null && commodity.ppF.size() > 0) {
                    for (Promotions promotions : commodity.ppF) {
                        if (promotions.type == Orders.ppu) {
                            break;
                        }
                    }
                    Promotions promotions2 = null;
                    x.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", new Object[]{promotions2});
                    if (promotions2 != null && !bi.oW(promotions2.lNW)) {
                        this.mBW = commodity.bOe;
                        h.mEJ.h(13033, new Object[]{Integer.valueOf(1), promotions2.lNW, promotions2.url, promotions2.name, this.mBW});
                        this.pvY.setText(promotions2.name);
                        this.pvN = promotions2.lNW;
                        this.pvZ.setVisibility(0);
                        if (this.pvK.contains(promotions2.lNW)) {
                            this.pvZ.setChecked(true);
                        } else {
                            this.pvZ.setChecked(false);
                        }
                        this.pvX.setOnClickListener(new 18(this));
                        this.pvX.setVisibility(0);
                    }
                }
            }
        }
    }

    private void bQm() {
        this.pvW.setVisibility(8);
        this.pvW.removeAllViews();
        if (this.pfb != null && this.pfb.ppr == 1 && this.pfb.ppt != null && this.pfb.ppt.size() > 0) {
            x.i("MicroMsg.WalletOrderInfoNewUI", "orders.showInfoList: %s %s", new Object[]{this.pfb.ppt, Integer.valueOf(this.pfb.ppt.size())});
            Iterator it = this.pfb.ppt.iterator();
            while (it.hasNext()) {
                ShowInfo showInfo = (ShowInfo) it.next();
                x.i("MicroMsg.WalletOrderInfoNewUI", "showInfo: %s", new Object[]{showInfo});
                LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(com.tencent.mm.plugin.wxpay.a.g.wallet_order_info_show_info_layout, this.pvW, false);
                TextView textView = (TextView) linearLayout.findViewById(f.left_tv);
                TextView textView2 = (TextView) linearLayout.findViewById(f.right_tv);
                if (!bi.oW(showInfo.name)) {
                    textView.setText(showInfo.name);
                }
                if (!bi.oW(showInfo.jLs)) {
                    try {
                        textView.setTextColor(Color.parseColor(showInfo.jLs));
                    } catch (Exception e) {
                    }
                }
                if (!bi.oW(showInfo.value)) {
                    textView2.setText(showInfo.value);
                }
                if (showInfo.pqp == 1) {
                    textView2.getPaint().setFlags(16);
                }
                if (!bi.oW(showInfo.pqk)) {
                    try {
                        textView2.setTextColor(Color.parseColor(showInfo.pqk));
                    } catch (Exception e2) {
                    }
                }
                if (showInfo.pql == 1) {
                    if (!bi.oW(showInfo.pqo)) {
                        linearLayout.setOnClickListener(new 19(this, showInfo));
                    }
                } else if (showInfo.pql == 2 && !bi.oW(showInfo.pqm)) {
                    linearLayout.setOnClickListener(new 2(this, showInfo));
                }
                this.pvW.addView(linearLayout);
            }
            this.pvS.setVisibility(0);
            this.pvW.setVisibility(0);
        }
    }

    private void jx(boolean z) {
        this.pto.setVisibility(8);
        this.ptw = false;
        this.ptv = false;
        if (this.pfb != null) {
            if (this.pvL != null && this.pvL.size() > 0) {
                Commodity commodity = (Commodity) this.pvL.get(0);
                if (commodity != null) {
                    Promotions promotions;
                    x.i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", new Object[]{Boolean.valueOf(commodity.ppG)});
                    if (commodity.ppF != null && commodity.ppF.size() > 0) {
                        for (Promotions promotions2 : commodity.ppF) {
                            if (promotions2.type == Orders.ppv) {
                                promotions = promotions2;
                                break;
                            }
                        }
                    }
                    promotions = null;
                    x.i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", new Object[]{promotions});
                    a aVar;
                    MarginLayoutParams marginLayoutParams;
                    List list;
                    if (promotions != null && promotions.pji > 0 && !bi.oW(promotions.poG)) {
                        this.pvO = promotions;
                        this.pts.setVisibility(8);
                        this.ptp.setRoundCorner(true);
                        this.ptt.setEnabled(true);
                        this.ptt.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.btn_solid_green);
                        this.ptr.setCompoundDrawables(null, null, null, null);
                        aVar = (a) this.pti.get(promotions.pji);
                        if (aVar != null) {
                            if (!bi.oW(aVar.bWP)) {
                                this.ptp.setUrl(aVar.bWP);
                            }
                            if (!bi.oW(aVar.bSc)) {
                                this.ptq.setText(aVar.bSc);
                            }
                            if (!bi.oW(aVar.pwk)) {
                                this.ptt.setText(aVar.pwk);
                                this.ptt.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.wallet_order_info_solid_green_disabled);
                            }
                            if (!bi.oW(aVar.paD)) {
                                this.pvO.ppW = aVar.paD;
                            }
                            if (!bi.oW(aVar.paE)) {
                                this.pvO.ppX = aVar.paE;
                            }
                            if (aVar.pwl > 0) {
                                this.pvO.ppY = aVar.pwl;
                            }
                        } else {
                            this.ptp.setUrl(promotions.lRX);
                            this.ptq.setText(promotions.name);
                            this.ptt.setText(promotions.poG);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ptr.getLayoutParams();
                        if (aVar != null && !bi.oW(aVar.title)) {
                            this.ptr.setText(aVar.title);
                            layoutParams.addRule(15, 0);
                        } else if (bi.oW(promotions.title)) {
                            this.ptr.setVisibility(8);
                            layoutParams.addRule(15, -1);
                        } else {
                            this.ptr.setText(promotions.title);
                            layoutParams.addRule(15, 0);
                        }
                        this.ptr.setLayoutParams(layoutParams);
                        this.ptt.setVisibility(0);
                        this.ptt.setOnClickListener(new 3(this));
                        if (promotions.ppT != 1) {
                            this.pto.setOnClickListener(new 4(this));
                        }
                        String str = this.ptl;
                        boolean z2 = true;
                        switch (str.hashCode()) {
                            case 48:
                                if (str.equals("0")) {
                                    z2 = false;
                                    break;
                                }
                                break;
                            case 49:
                                if (str.equals("1")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 50:
                                if (str.equals("2")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 51:
                                if (str.equals("3")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 52:
                                if (str.equals("4")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 1444:
                                if (str.equals("-1")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                        }
                        switch (z2) {
                            case false:
                                this.ptt.setEnabled(false);
                                break;
                        }
                        marginLayoutParams = (MarginLayoutParams) this.pto.getLayoutParams();
                        list = commodity.ppz;
                        if ((commodity.ppw < 0.0d || commodity.hUL >= commodity.ppw) && (list == null || list.size() <= 0)) {
                            marginLayoutParams.topMargin = com.tencent.mm.bp.a.fromDPToPix(this, 50);
                        } else {
                            marginLayoutParams.topMargin = 0;
                        }
                        this.pto.setLayoutParams(marginLayoutParams);
                        this.pto.setVisibility(0);
                        if (z) {
                            h hVar = h.mEJ;
                            Object[] objArr = new Object[6];
                            objArr[0] = this.mBW;
                            objArr[1] = Integer.valueOf(1);
                            objArr[2] = Integer.valueOf(promotions.ppT);
                            objArr[3] = this.ptl.equals("-1") ? Integer.valueOf(5) : this.ptl;
                            objArr[4] = Long.valueOf(promotions.pji);
                            objArr[5] = Long.valueOf(promotions.poF);
                            hVar.h(13471, objArr);
                        }
                    } else if (!(commodity.ppD == null || bi.oW(commodity.ppD.paD))) {
                        this.pte = commodity.ppD.paD;
                        this.ptf = commodity.ppD.paE;
                        this.poM = commodity.ppD.poM;
                        this.pvM = commodity.ppD;
                        this.ptp.setUrl(commodity.ppD.poJ);
                        this.ptq.setText(commodity.ppD.poK);
                        this.ptr.setText(getString(i.wallet_app_brand_entrance));
                        this.ptr.setVisibility(0);
                        this.ptp.setRoundCorner(true);
                        this.ptt.setEnabled(true);
                        this.ptt.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.btn_solid_green);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ptr.getLayoutParams();
                        layoutParams2.addRule(15, 0);
                        this.ptr.setLayoutParams(layoutParams2);
                        if (commodity.ppD.pqc > 0) {
                            if (!bi.oW(commodity.ppD.poL)) {
                                this.ptt.setVisibility(0);
                                this.ptt.setText(commodity.ppD.poL);
                                this.pts.setVisibility(8);
                            }
                            aVar = (a) this.pti.get(commodity.ppD.pqc);
                            if (aVar != null) {
                                if (!bi.oW(aVar.poJ)) {
                                    this.ptp.setUrl(aVar.poJ);
                                }
                                if (!bi.oW(aVar.poK)) {
                                    this.ptq.setText(aVar.poK);
                                }
                                if (!bi.oW(aVar.poL)) {
                                    this.ptt.setText(aVar.poL);
                                    this.ptt.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.wallet_order_info_solid_green_disabled);
                                }
                                if (!bi.oW(aVar.paD)) {
                                    this.pte = aVar.paD;
                                }
                                if (!bi.oW(aVar.paE)) {
                                    this.ptf = aVar.paE;
                                }
                                if (aVar.pwl > 0) {
                                    this.poM = aVar.pwl;
                                }
                            }
                        } else {
                            this.ptt.setVisibility(8);
                            this.pts.setVisibility(8);
                        }
                        5 5 = new 5(this, commodity);
                        this.pto.setOnClickListener(5);
                        this.ptt.setOnClickListener(5);
                        marginLayoutParams = (MarginLayoutParams) this.pto.getLayoutParams();
                        list = commodity.ppz;
                        if ((commodity.ppw < 0.0d || commodity.hUL >= commodity.ppw) && (list == null || list.size() <= 0)) {
                            marginLayoutParams.topMargin = com.tencent.mm.bp.a.fromDPToPix(this, 50);
                        } else {
                            marginLayoutParams.topMargin = 0;
                        }
                        this.pto.setLayoutParams(marginLayoutParams);
                        this.pto.setVisibility(0);
                    }
                }
            }
            if (this.ptq.getVisibility() == 0) {
                this.ptq.setSingleLine();
                this.ptq.post(new 6(this));
            }
        }
    }

    protected final void Ps(String str) {
        x.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", new Object[]{str});
        bQb();
        e.l(this, str, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletOrderInfoNewUI", "onActivityResult %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            x.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", new Object[]{Boolean.valueOf(bi.oW(this.pth.pwq)), Boolean.valueOf(this.pwf)});
            if (!this.pwf) {
                this.pwf = true;
                if (bi.oW(this.pth.pwq)) {
                    a(new aa(this.pth.pjF, this.pth.pwm, this.pth.pwn, this.pth.pwo, this.pth.bQa, this.pth.myq, this.pth.pqh), true, true);
                } else {
                    a(new k(this.pth.pwq, this.pth.pjF), true, true);
                }
            }
        }
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return com.tencent.mm.ui.base.h.a(this.mController.tml, getString(i.wallet_order_info_phone), getResources().getStringArray(com.tencent.mm.plugin.wxpay.a.b.wallet_phone_call), "", new 7(this));
    }

    protected final boolean brH() {
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.wallet_order_info_ui_new;
    }

    private void b(Orders orders) {
        this.pvK.clear();
        if (orders == null || orders.ppf == null) {
            x.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
            return;
        }
        for (Commodity commodity : orders.ppf) {
            if (commodity.poW == 2 && !bi.oW(commodity.ppx)) {
                x.i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
                this.pvK.add(commodity.ppx);
            }
        }
    }

    public void done() {
        if (this.sy.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.sy.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoNewUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean b = realnameGuideHelper.b(this, bundle, new 8(this));
                boolean a = realnameGuideHelper.a(this, bundle, new 10(this));
                this.sy.remove("key_realname_guide_helper");
                if (!b && !a) {
                    bQn();
                    return;
                }
                return;
            }
            return;
        }
        bQn();
    }

    public final void bQn() {
        bQb();
        al alVar = new al();
        alVar.bHN.bHO = true;
        com.tencent.mm.sdk.b.a.sFg.m(alVar);
        gg ggVar = new gg();
        ggVar.bPt.bPu = "ok";
        com.tencent.mm.sdk.b.a.sFg.m(ggVar);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.sy.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.sy.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.sy.getBoolean("intent_pay_end"));
        x.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + this.sy.getInt("intent_pay_end_errcode"));
        for (String str : this.pvK) {
            if (!bi.oW(str)) {
                x.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[]{str});
                if (this.pfb == null || this.mCn == null) {
                    g.Eh().dpP.a(new j(str), 0);
                } else {
                    g.Eh().dpP.a(new j(str, this.pfb.bOd, this.pfb.ppf.size() > 0 ? ((Commodity) this.pfb.ppf.get(0)).bOe : "", this.mCn.bVY, this.mCn.bVU, this.pfb.poW), 0);
                }
            }
            h.mEJ.h(13033, new Object[]{Integer.valueOf(2), str, "", "", ""});
        }
        if (this.pty != null) {
            this.pty.a((Activity) this, 0, bundle);
        }
        if (this.pfb != null && !bi.oW(this.pfb.ixy)) {
            String e = e(this.pfb.ixy, this.pfb.bOd, this.pfb.ppf.size() > 0 ? ((Commodity) this.pfb.ppf.get(0)).bOe : "", this.mCn.hvl, this.mCn.fky);
            x.d("MicroMsg.WalletOrderInfoNewUI", "url = " + e);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", e);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", com.tencent.mm.model.q.GF());
            intent.putExtra("stastic_scene", 8);
            com.tencent.mm.bg.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        done();
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.sFg.c(this.pwg);
        com.tencent.mm.sdk.b.a.sFg.c(this.lLY);
        js(1979);
        js(2948);
        js(2710);
        if (WalletSuccPageAwardWidget.a(this.mAh)) {
            this.mAi.onDestroy();
        }
    }

    public void bQb() {
        int i = 0;
        if (!this.ptd) {
            io ioVar = new io();
            ioVar.bRY.bRZ = 4;
            com.tencent.mm.g.a.io.a aVar = ioVar.bRY;
            if (this.sy.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            aVar.bjW = i;
            ioVar.bRY.bSa = new Intent();
            if (this.pfb != null) {
                ioVar.bRY.bSa.putExtra("key_jsapi_close_page_after_pay", this.pfb.pps);
            }
            com.tencent.mm.sdk.b.a.sFg.m(ioVar);
            this.ptd = true;
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), lVar});
        if (WalletSuccPageAwardWidget.a(this.mAh) && this.mAi.d(i, i2, str, lVar)) {
            return true;
        }
        CharSequence string;
        if (lVar instanceof aa) {
            if (i == 0 && i2 == 0) {
                aa aaVar = (aa) lVar;
                a aVar = new a(aaVar.fFc);
                if (this.pth != null) {
                    this.pti.put(aaVar.pjF, aVar);
                    jx(false);
                    bPY();
                } else if (this.ptv) {
                    this.pti.put(aaVar.pjF, aVar);
                    jx(false);
                    bPY();
                }
            }
            this.pwf = false;
        } else if (lVar instanceof k) {
            if (i == 0 && i2 == 0) {
                k kVar = (k) lVar;
                bdr bdr = kVar.pjo;
                if (bdr.hwV == 0) {
                    a aVar2 = new a(bdr);
                    if (this.pth != null) {
                        this.pti.put(kVar.oqH, aVar2);
                        jx(false);
                        bPY();
                    } else if (this.ptv) {
                        this.pti.put(kVar.oqH, aVar2);
                        jx(false);
                        bPY();
                    }
                }
            }
            this.pwf = false;
        } else if (lVar instanceof n) {
            if (i == 0 && i2 == 0) {
                n nVar = (n) lVar;
                String str2 = nVar.pjp;
                if (this.pvO != null && this.pvO.pji == nVar.pjs.pji) {
                    x.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[]{this.pvO});
                    this.ptl = str2;
                    x.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[]{nVar.pjs.poG});
                    jx(false);
                    bPY();
                    if (!(bi.oW(nVar.hKX) || "3".equals(str2))) {
                        this.ptt.setText(nVar.hKX);
                    }
                }
                if (!"-1".equals(str2) && !"0".equals(str2) && !bi.oW(nVar.pjq)) {
                    com.tencent.mm.ui.base.h.b(this, nVar.pjq, "", true);
                } else if ("0".equals(str2)) {
                    if (bi.oW(nVar.pjq)) {
                        string = getString(i.wallet_pay_award_got);
                    } else {
                        string = nVar.pjq;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                return true;
            }
            if (bi.oW(str)) {
                str = getString(i.wallet_unknown_err);
            }
            com.tencent.mm.ui.base.h.a(this, str, null, false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        } else if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.h) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_core.c.h hVar = (com.tencent.mm.plugin.wallet_core.c.h) lVar;
                zq zqVar = hVar.pjh;
                if (zqVar.hwV == 0) {
                    String str3 = zqVar.rFw;
                    if (this.pvO != null && this.pvO.pji == hVar.pji) {
                        x.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[]{this.pvO});
                        this.ptl = str3;
                        x.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[]{zqVar.rFy});
                        jx(false);
                        bPY();
                        if (!(bi.oW(zqVar.rFy) || "3".equals(str3))) {
                            this.ptt.setText(zqVar.rFy);
                        }
                    }
                    if (!"-1".equals(str3) && !"0".equals(str3) && !bi.oW(zqVar.rFx)) {
                        com.tencent.mm.ui.base.h.b(this, zqVar.rFx, "", true);
                    } else if ("0".equals(str3)) {
                        if (bi.oW(zqVar.rFx)) {
                            string = getString(i.wallet_pay_award_got);
                        } else {
                            string = zqVar.rFx;
                        }
                        Toast.makeText(this, string, 0).show();
                    }
                }
                return true;
            }
            if (bi.oW(str)) {
                str = getString(i.wallet_unknown_err);
            }
            com.tencent.mm.ui.base.h.a(this, str, null, false, new 12(this));
            return true;
        }
        return false;
    }

    public final void ux(int i) {
        this.mController.contentView.setVisibility(i);
    }
}
