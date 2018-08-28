package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.io$a;
import com.tencent.mm.plugin.wallet_core.c.m;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.n.b;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

@a(3)
public class WalletBindCardResultUI extends WalletBaseUI {
    private c lLY = new 1(this);
    private String lPn = null;
    private String mBW;
    private PayInfo mCn;
    private TextView mDd;
    private int poM;
    private BindCardOrder ptc;
    private boolean ptd = false;
    private String pte;
    private String ptf;
    private b ptg;
    private WalletOrderInfoNewUI.b pth;
    private HashMap<String, WalletOrderInfoNewUI.a> pti = new HashMap();
    private String ptj;
    private BindCardOrder ptk = null;
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

    static /* synthetic */ void b(WalletBindCardResultUI walletBindCardResultUI) {
        String str = "MicroMsg.WalletBindCardResultUI";
        String str2 = "onClickActivity, activityId: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(walletBindCardResultUI.ptk != null ? walletBindCardResultUI.ptk.pmM.pji : 0);
        x.i(str, str2, objArr);
        if (walletBindCardResultUI.ptk != null && walletBindCardResultUI.ptk.pmM.pji > 0) {
            walletBindCardResultUI.gP(2);
            walletBindCardResultUI.ptw = true;
            if (!walletBindCardResultUI.ptl.equals("-1") && !walletBindCardResultUI.ptl.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                return;
            }
            if (walletBindCardResultUI.ptc.bOz()) {
                BindCardOrder bindCardOrder = walletBindCardResultUI.ptk;
                walletBindCardResultUI.a(new m(bindCardOrder, bindCardOrder.pmM.pji, bindCardOrder.pmM.poC, bindCardOrder.pmM.poD, bindCardOrder.pmM.poE, bindCardOrder.pmM.poF, bindCardOrder.pmM.poB, walletBindCardResultUI.ptc.lMV, walletBindCardResultUI.ptc.pmJ, walletBindCardResultUI.ptc.pmK, walletBindCardResultUI.ptc.pmL), true, false);
            } else if (!walletBindCardResultUI.ptc.bOy() || bi.oW(walletBindCardResultUI.ptk.pmN.url)) {
                x.e("MicroMsg.WalletBindCardResultUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
            } else if (walletBindCardResultUI.pti.containsKey(walletBindCardResultUI.ptk.pmM.pji)) {
                WalletOrderInfoNewUI.a aVar = (WalletOrderInfoNewUI.a) walletBindCardResultUI.pti.get(walletBindCardResultUI.ptk.pmM.pji);
                x.i("MicroMsg.WalletBindCardResultUI", "go to new url %s", new Object[]{aVar.url});
                if (bi.oW(aVar.url)) {
                    walletBindCardResultUI.Ps(walletBindCardResultUI.ptk.pmN.url);
                } else {
                    walletBindCardResultUI.Ps(aVar.url);
                }
            } else {
                walletBindCardResultUI.ptj = walletBindCardResultUI.ptk.pmN.url;
                String str3 = walletBindCardResultUI.ptk.pmN.url;
                WalletOrderInfoNewUI.b bVar = new WalletOrderInfoNewUI.b(walletBindCardResultUI.ptk.pmM.pji, walletBindCardResultUI.ptk.pmM.poC, walletBindCardResultUI.ptk.pmM.poD, walletBindCardResultUI.ptk.pmM.poE, walletBindCardResultUI.bNs(), walletBindCardResultUI.mBW, walletBindCardResultUI.ptk.pmM.poF, walletBindCardResultUI.ptk.pmM.poB);
                walletBindCardResultUI.bQb();
                walletBindCardResultUI.pth = bVar;
                e.r(walletBindCardResultUI, str3, 1);
            }
        }
    }

    public void onCreate(Bundle bundle) {
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
        com.tencent.mm.wallet_core.a.af(this);
        this.mCn = (PayInfo) this.sy.getParcelable("key_pay_info");
        this.sy.getInt("key_pay_type", -1);
        BindCardOrder bindCardOrder = (BindCardOrder) this.sy.getParcelable("key_bindcard_value_result");
        if (bindCardOrder == null) {
            bindCardOrder = new BindCardOrder();
        }
        this.ptc = bindCardOrder;
        ux(0);
        initView();
        this.pty = cDK();
        bPZ();
        gP(1);
        jr(1979);
        com.tencent.mm.sdk.b.a.sFg.b(this.lLY);
        this.ptx = true;
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", new Object[]{Boolean.valueOf(this.ptx), this.ptk, Boolean.valueOf(this.ptv), Boolean.valueOf(this.ptw), this.ptg});
        if (this.ptx) {
            this.ptx = false;
        } else if (this.ptk != null && this.ptw) {
            a(new com.tencent.mm.plugin.wallet_core.c.x(this.ptk.pmM.pji, this.ptk.pmM.poC, this.ptk.pmM.poD, this.ptk.pmM.poE, this.ptk.pmM.poB, this.ptk.pmM.poF, this.ptc.lMV, this.ptc.pmJ, this.ptc.pmK, this.ptc.pmK), true, true);
        } else if (this.ptv && this.ptg != null) {
            a(new com.tencent.mm.plugin.wallet_core.c.x(this.ptc.pmM.pji, this.ptc.pmM.poC, this.ptc.pmM.poD, this.ptc.pmM.poE, this.ptc.pmM.poF, this.ptc.pmM.poB, this.ptc.lMV, this.ptc.pmJ, this.ptc.pmK, this.ptc.pmK), true, true);
        }
    }

    protected final void initView() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.ptn = (ImageView) findViewById(f.wxpay_logo_iv);
        this.mDd = (TextView) findViewById(f.pay_succ_wording);
        this.ptm = (Button) findViewById(f.pay_finish_button);
        showHomeBtn(false);
        enableBackMenu(false);
        CharSequence string = getString(a$i.app_finish);
        if (this.ptc == null || bi.oW(this.ptc.pmF)) {
            this.ptm.setText(string);
        } else {
            this.ptm.setText(this.ptc.pmF);
        }
        this.ptm.setOnClickListener(new 2(this));
        this.ptu = (ViewGroup) findViewById(f.wallet_order_info_bottom_layout);
        this.pto = (ViewGroup) findViewById(f.tinyapp_info_layout);
        this.ptp = (CdnImageView) findViewById(f.tinyapp_logo_iv);
        this.ptp.setUseSdcardCache(true);
        this.ptq = (TextView) findViewById(f.tinyapp_desc_tv);
        this.ptr = (TextView) findViewById(f.tinyapp_name_tv);
        this.ptt = (Button) findViewById(f.tinyapp_button);
        this.pts = findViewById(f.tinyapp_info_touch_mask);
        this.ptu.setVisibility(4);
        bPZ();
        bQa();
        bPY();
        if (!bi.oW(this.ptc.pmH) && !bi.oW(this.ptc.pmI)) {
            ((TextView) findViewById(f.pay_succ_wording_tip)).setText(getString(a$i.wallet_bind_card_info_tip, new Object[]{this.ptc.pmH, this.ptc.pmI}));
        }
    }

    private void bPY() {
        this.ptu.setVisibility(0);
    }

    private void bPZ() {
        this.mDd.setText(this.ptc.pmG);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bQa() {
        /*
        r10 = this;
        r9 = 15;
        r8 = 9;
        r7 = 8;
        r2 = 1;
        r3 = 0;
        r0 = r10.pto;
        r1 = 4;
        r0.setVisibility(r1);
        r10.ptw = r3;
        r10.ptv = r3;
        r0 = r10.ptc;
        if (r0 == 0) goto L_0x016e;
    L_0x0016:
        r0 = r10.ptc;
        r0 = r0.pmM;
        if (r0 == 0) goto L_0x015c;
    L_0x001c:
        r0 = "MicroMsg.WalletBindCardResultUI";
        r1 = "activityPromotions: %s";
        r4 = new java.lang.Object[r2];
        r5 = r10.ptk;
        r4[r3] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r4);
        r0 = r10.ptc;
        if (r0 == 0) goto L_0x0224;
    L_0x002f:
        r0 = r10.ptc;
        r0 = r0.bOy();
        if (r0 != 0) goto L_0x003f;
    L_0x0037:
        r0 = r10.ptc;
        r0 = r0.bOz();
        if (r0 == 0) goto L_0x0224;
    L_0x003f:
        r0 = r10.ptc;
        r0 = r0.pmM;
        r0 = r0.pji;
        r4 = 0;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0224;
    L_0x004b:
        r0 = r10.ptc;
        r0 = r0.pmN;
        r0 = r0.poG;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x0224;
    L_0x0057:
        r0 = r10.ptc;
        r10.ptk = r0;
        r0 = r10.pts;
        r0.setVisibility(r7);
        r0 = r10.ptp;
        r0.setRoundCorner(r2);
        r0 = r10.ptt;
        r0.setEnabled(r2);
        r0 = r10.ptt;
        r1 = com.tencent.mm.plugin.wxpay.a.e.btn_solid_green;
        r0.setBackgroundResource(r1);
        r0 = r10.ptr;
        r1 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r0.setCompoundDrawables(r1, r4, r5, r6);
        r0 = r10.pti;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = r10.ptk;
        r4 = r4.pmM;
        r4 = r4.pji;
        r1 = r1.append(r4);
        r1 = r1.toString();
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.a) r0;
        if (r0 == 0) goto L_0x018c;
    L_0x0097:
        r1 = r0.bWP;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x00a6;
    L_0x009f:
        r1 = r10.ptp;
        r4 = r0.bWP;
        r1.setUrl(r4);
    L_0x00a6:
        r1 = r0.bSc;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x00b5;
    L_0x00ae:
        r1 = r10.ptq;
        r4 = r0.bSc;
        r1.setText(r4);
    L_0x00b5:
        r1 = r0.pwk;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x00cb;
    L_0x00bd:
        r1 = r10.ptt;
        r4 = r0.pwk;
        r1.setText(r4);
        r1 = r10.ptt;
        r4 = com.tencent.mm.plugin.wxpay.a.e.wallet_order_info_solid_green_disabled;
        r1.setBackgroundResource(r4);
    L_0x00cb:
        r1 = r10.ptr;
        r1 = r1.getLayoutParams();
        r1 = (android.widget.RelativeLayout.LayoutParams) r1;
        if (r0 == 0) goto L_0x01af;
    L_0x00d5:
        r4 = r0.title;
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r4 != 0) goto L_0x01af;
    L_0x00dd:
        r4 = r10.ptr;
        r0 = r0.title;
        r4.setText(r0);
        r1.addRule(r9, r3);
    L_0x00e7:
        r0 = r10.ptr;
        r0.setLayoutParams(r1);
        r0 = r10.ptt;
        r0.setVisibility(r3);
        r0 = r10.ptt;
        r1 = new com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$3;
        r1.<init>(r10);
        r0.setOnClickListener(r1);
        r0 = r10.ptk;
        r0 = r0.pmM;
        r0 = r0.poB;
        r4 = 1;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x0111;
    L_0x0107:
        r0 = r10.pto;
        r1 = new com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$4;
        r1.<init>(r10);
        r0.setOnClickListener(r1);
    L_0x0111:
        r1 = r10.ptl;
        r0 = -1;
        r4 = r1.hashCode();
        switch(r4) {
            case 48: goto L_0x01d6;
            case 49: goto L_0x0211;
            case 50: goto L_0x0205;
            case 51: goto L_0x01ed;
            case 52: goto L_0x01f9;
            case 1444: goto L_0x01e2;
            default: goto L_0x011b;
        };
    L_0x011b:
        r2 = r0;
    L_0x011c:
        switch(r2) {
            case 0: goto L_0x021d;
            default: goto L_0x011f;
        };
    L_0x011f:
        r0 = r10.ptq;
        r0 = r0.getText();
        r1 = com.tencent.mm.sdk.platformtools.bi.K(r0);
        if (r1 != 0) goto L_0x0142;
    L_0x012b:
        r1 = r0.length();
        if (r1 <= r8) goto L_0x0142;
    L_0x0131:
        r1 = r10.ptq;
        r0 = r0.subSequence(r3, r8);
        r1.setText(r0);
        r0 = r10.ptq;
        r1 = "...";
        r0.append(r1);
    L_0x0142:
        r0 = r10.pto;
        r0 = r0.getLayoutParams();
        r0 = (android.view.ViewGroup.MarginLayoutParams) r0;
        r1 = 50;
        r1 = com.tencent.mm.bp.a.fromDPToPix(r10, r1);
        r0.topMargin = r1;
        r1 = r10.pto;
        r1.setLayoutParams(r0);
    L_0x0157:
        r0 = r10.pto;
        r0.setVisibility(r3);
    L_0x015c:
        r0 = r10.ptq;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x016e;
    L_0x0164:
        r0 = r10.ptq;
        r1 = new com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$6;
        r1.<init>(r10);
        r0.post(r1);
    L_0x016e:
        r0 = r10.pto;
        r0 = r0.getVisibility();
        if (r0 != r7) goto L_0x018b;
    L_0x0176:
        r0 = r10.ptn;
        r0 = r0.getLayoutParams();
        r0 = (android.view.ViewGroup.MarginLayoutParams) r0;
        r1 = 91;
        r1 = com.tencent.mm.bp.a.fromDPToPix(r10, r1);
        r0.topMargin = r1;
        r1 = r10.ptn;
        r1.setLayoutParams(r0);
    L_0x018b:
        return;
    L_0x018c:
        r1 = r10.ptp;
        r4 = r10.ptc;
        r4 = r4.pmN;
        r4 = r4.lRX;
        r1.setUrl(r4);
        r1 = r10.ptq;
        r4 = r10.ptc;
        r4 = r4.pmN;
        r4 = r4.name;
        r1.setText(r4);
        r1 = r10.ptt;
        r4 = r10.ptc;
        r4 = r4.pmN;
        r4 = r4.poG;
        r1.setText(r4);
        goto L_0x00cb;
    L_0x01af:
        r0 = r10.ptc;
        r0 = r0.pmN;
        r0 = r0.title;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x01cb;
    L_0x01bb:
        r0 = r10.ptr;
        r4 = r10.ptc;
        r4 = r4.pmN;
        r4 = r4.title;
        r0.setText(r4);
        r1.addRule(r9, r3);
        goto L_0x00e7;
    L_0x01cb:
        r0 = r10.ptr;
        r0.setVisibility(r7);
        r0 = -1;
        r1.addRule(r9, r0);
        goto L_0x00e7;
    L_0x01d6:
        r2 = "0";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x011b;
    L_0x01df:
        r2 = r3;
        goto L_0x011c;
    L_0x01e2:
        r4 = "-1";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x011b;
    L_0x01eb:
        goto L_0x011c;
    L_0x01ed:
        r2 = "3";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x011b;
    L_0x01f6:
        r2 = 2;
        goto L_0x011c;
    L_0x01f9:
        r2 = "4";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x011b;
    L_0x0202:
        r2 = 3;
        goto L_0x011c;
    L_0x0205:
        r2 = "2";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x011b;
    L_0x020e:
        r2 = 4;
        goto L_0x011c;
    L_0x0211:
        r2 = "1";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x011b;
    L_0x021a:
        r2 = 5;
        goto L_0x011c;
    L_0x021d:
        r0 = r10.ptt;
        r0.setEnabled(r3);
        goto L_0x011f;
    L_0x0224:
        r0 = r10.ptc;
        r0 = r0.pmO;
        if (r0 == 0) goto L_0x015c;
    L_0x022a:
        r0 = r10.ptc;
        r0 = r0.pmO;
        r0 = r0.paD;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x015c;
    L_0x0236:
        r0 = r10.ptc;
        r1 = r0.jumpType;
        r4 = com.tencent.mm.plugin.wallet_core.model.BindCardOrder.pmC;
        if (r1 != r4) goto L_0x0374;
    L_0x023e:
        r0 = r0.pmO;
        if (r0 == 0) goto L_0x0374;
    L_0x0242:
        r0 = r2;
    L_0x0243:
        if (r0 == 0) goto L_0x015c;
    L_0x0245:
        r0 = r10.ptc;
        r0 = r0.pmO;
        r0 = r0.paD;
        r10.pte = r0;
        r0 = r10.ptc;
        r0 = r0.pmO;
        r0 = r0.paE;
        r10.ptf = r0;
        r0 = r10.ptc;
        r0 = r0.pmO;
        r0 = r0.poM;
        r10.poM = r0;
        r0 = r10.ptc;
        r0 = r0.pmO;
        r10.ptg = r0;
        r0 = r10.ptp;
        r1 = r10.ptc;
        r1 = r1.pmO;
        r1 = r1.poJ;
        r0.setUrl(r1);
        r0 = r10.ptq;
        r1 = r10.ptc;
        r1 = r1.pmO;
        r1 = r1.poK;
        r0.setText(r1);
        r0 = r10.ptr;
        r1 = com.tencent.mm.plugin.wxpay.a$i.wallet_app_brand_entrance;
        r1 = r10.getString(r1);
        r0.setText(r1);
        r0 = r10.ptr;
        r0.setVisibility(r3);
        r0 = r10.ptp;
        r0.setRoundCorner(r2);
        r0 = r10.ptt;
        r0.setEnabled(r2);
        r0 = r10.ptt;
        r1 = com.tencent.mm.plugin.wxpay.a.e.btn_solid_green;
        r0.setBackgroundResource(r1);
        r0 = r10.ptr;
        r0 = r0.getLayoutParams();
        r0 = (android.widget.RelativeLayout.LayoutParams) r0;
        r0.addRule(r9, r3);
        r1 = r10.ptr;
        r1.setLayoutParams(r0);
        r0 = r10.ptc;
        r0 = r0.pmM;
        r0 = r0.pji;
        r4 = 0;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0377;
    L_0x02b6:
        r0 = r10.ptc;
        r0 = r0.pmO;
        r0 = r0.poL;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x02d7;
    L_0x02c2:
        r0 = r10.ptt;
        r0.setVisibility(r3);
        r0 = r10.ptt;
        r1 = r10.ptc;
        r1 = r1.pmO;
        r1 = r1.poL;
        r0.setText(r1);
        r0 = r10.pts;
        r0.setVisibility(r7);
    L_0x02d7:
        r0 = r10.pti;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r10.ptc;
        r2 = r2.pmM;
        r4 = r2.pji;
        r1 = r1.append(r4);
        r1 = r1.toString();
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.a) r0;
        if (r0 == 0) goto L_0x0340;
    L_0x02f4:
        r1 = r0.poJ;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x0303;
    L_0x02fc:
        r1 = r10.ptp;
        r2 = r0.poJ;
        r1.setUrl(r2);
    L_0x0303:
        r1 = r0.poK;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x0312;
    L_0x030b:
        r1 = r10.ptq;
        r2 = r0.poK;
        r1.setText(r2);
    L_0x0312:
        r1 = r0.poL;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x0328;
    L_0x031a:
        r1 = r10.ptt;
        r2 = r0.poL;
        r1.setText(r2);
        r1 = r10.ptt;
        r2 = com.tencent.mm.plugin.wxpay.a.e.wallet_order_info_solid_green_disabled;
        r1.setBackgroundResource(r2);
    L_0x0328:
        r1 = r0.paD;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x0334;
    L_0x0330:
        r1 = r0.paD;
        r10.pte = r1;
    L_0x0334:
        r1 = r0.paE;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x0340;
    L_0x033c:
        r0 = r0.paE;
        r10.ptf = r0;
    L_0x0340:
        r0 = new com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$5;
        r0.<init>(r10);
        r1 = r10.pto;
        r1.setOnClickListener(r0);
        r1 = r10.ptt;
        r1.setOnClickListener(r0);
        r0 = r10.ptq;
        r0 = r0.getText();
        r1 = com.tencent.mm.sdk.platformtools.bi.K(r0);
        if (r1 != 0) goto L_0x0157;
    L_0x035b:
        r1 = r0.length();
        if (r1 <= r8) goto L_0x0157;
    L_0x0361:
        r1 = r10.ptq;
        r0 = r0.subSequence(r3, r8);
        r1.setText(r0);
        r0 = r10.ptq;
        r1 = "...";
        r0.append(r1);
        goto L_0x0157;
    L_0x0374:
        r0 = r3;
        goto L_0x0243;
    L_0x0377:
        r0 = r10.ptt;
        r0.setVisibility(r7);
        r0 = r10.pts;
        r0.setVisibility(r7);
        goto L_0x0340;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.bQa():void");
    }

    private void Ps(String str) {
        bQb();
        e.l(this, str, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletBindCardResultUI", "onActivityResult %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            x.i("MicroMsg.WalletBindCardResultUI", "do query pay arawrd");
            a(new com.tencent.mm.plugin.wallet_core.c.x(this.pth.pjF, this.pth.pwm, this.pth.pwn, this.pth.pwo, this.pth.pqh, this.pth.pwp, this.ptc.lMV, this.ptc.pmJ, this.ptc.pmK, this.ptc.pmK), true, true);
        }
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return h.a(this.mController.tml, getString(a$i.wallet_order_info_phone), getResources().getStringArray(com.tencent.mm.plugin.wxpay.a.b.wallet_phone_call), "", new h.c() {
            public final void ju(int i) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + WalletBindCardResultUI.this.lPn));
                        intent.addFlags(268435456);
                        WalletBindCardResultUI.this.startActivity(intent);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    protected final int getLayoutId() {
        return g.wallet_bind_card_result_ui;
    }

    public final void done() {
        Bundle bundle = new Bundle();
        if (this.pty != null) {
            this.pty.a(this, 0, bundle);
        } else {
            finish();
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
        com.tencent.mm.sdk.b.a.sFg.c(this.lLY);
        js(1979);
    }

    private void bQb() {
        int i = 0;
        if (!this.ptd) {
            io ioVar = new io();
            ioVar.bRY.bRZ = 4;
            io$a io_a = ioVar.bRY;
            if (this.sy.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            io_a.bjW = i;
            com.tencent.mm.sdk.b.a.sFg.m(ioVar);
            this.ptd = true;
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.x) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_core.c.x xVar = (com.tencent.mm.plugin.wallet_core.c.x) lVar;
                WalletOrderInfoNewUI.a aVar = new WalletOrderInfoNewUI.a(xVar.fFc);
                if (this.pth != null) {
                    this.pti.put(xVar.pjF, aVar);
                    bQa();
                    bPY();
                } else if (this.ptv) {
                    this.pti.put(xVar.pjF, aVar);
                    bQa();
                    bPY();
                }
            }
        } else if (lVar instanceof m) {
            if (i == 0 && i2 == 0) {
                m mVar = (m) lVar;
                String str2 = mVar.pjp;
                if (this.ptk != null && this.ptk.pmM.pji == mVar.pjr.pmM.pji) {
                    x.i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", new Object[]{this.ptk});
                    this.ptl = str2;
                    bQa();
                    bPY();
                    if (!(bi.oW(mVar.hKX) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str2))) {
                        this.ptt.setText(mVar.hKX);
                    }
                }
                if (!"-1".equals(str2) && !"0".equals(str2) && !bi.oW(mVar.pjq)) {
                    h.b(this, mVar.pjq, "", true);
                } else if ("0".equals(str2)) {
                    CharSequence string;
                    if (bi.oW(mVar.pjq)) {
                        string = getString(a$i.wallet_pay_award_got);
                    } else {
                        string = mVar.pjq;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                return true;
            }
            if (bi.oW(str)) {
                str = getString(a$i.wallet_unknown_err);
            }
            h.a(this, str, null, false, new 8(this));
            return true;
        }
        return false;
    }

    public final void ux(int i) {
        this.mController.contentView.setVisibility(i);
    }

    public final void gP(int i) {
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
        Object[] objArr = new Object[4];
        objArr[0] = this.ptc.pmM == null ? "" : bi.aG(this.ptc.pmM.pji, "");
        objArr[1] = this.ptc.pmJ;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = this.ptc.lMV;
        hVar.h(14877, objArr);
    }
}
