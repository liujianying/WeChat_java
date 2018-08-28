package com.tencent.mm.plugin.offline.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.bw;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.te;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.offline.a.j;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.q;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s$f;
import com.tencent.mm.plugin.offline.b;
import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.offline.ui.OfflineAlertView.2;
import com.tencent.mm.plugin.offline.ui.OfflineAlertView.8;
import com.tencent.mm.plugin.offline.ui.b.4;
import com.tencent.mm.plugin.offline.ui.c.1;
import com.tencent.mm.plugin.offline.ui.c.11;
import com.tencent.mm.plugin.offline.ui.c.12;
import com.tencent.mm.plugin.offline.ui.c.13;
import com.tencent.mm.plugin.offline.ui.c.14;
import com.tencent.mm.plugin.offline.ui.c.15;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw$a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.c;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WalletOfflineCoinPurseUI extends WalletBaseUI implements a, s.a, b, a, aw$a {
    private static int gEm = 0;
    private boolean bts;
    private int eLd = -1;
    private OnClickListener eZF = new 14(this);
    private boolean hCn = true;
    private int hop;
    private int iMP;
    private String lIF = "";
    private String lJi = "";
    private m lJk;
    private int lJm = 60000;
    private al lJn = new al(new 30(this), false);
    private ImageView lLA;
    RelativeLayout lLB;
    private LinearLayout lLC;
    private LinearLayout lLD;
    private LinearLayout lLE;
    private LinearLayout lLF;
    private LinearLayout lLG;
    private Dialog lLH;
    private String lLI = "";
    private boolean lLJ = false;
    private g lLK;
    private boolean lLL = false;
    private ArrayList<Bitmap> lLM = new ArrayList();
    private ArrayList<Bitmap> lLN = new ArrayList();
    private c lLO;
    private c lLP;
    OfflineAlertView lLQ;
    private boolean lLR = false;
    com.tencent.mm.sdk.b.c<te> lLS = new 1(this);
    private com.tencent.mm.sdk.b.c<ci> lLT = new 12(this);
    private com.tencent.mm.sdk.b.c<lf> lLU = new 23(this);
    private com.tencent.mm.sdk.b.c<kr> lLV = new 34(this);
    private com.tencent.mm.sdk.b.c<ks> lLW = new 35(this);
    private com.tencent.mm.sdk.b.c lLX = new 36(this);
    private com.tencent.mm.sdk.b.c lLY = new 37(this);
    private com.tencent.mm.sdk.b.c lLZ = new 38(this);
    private HashMap<String, View> lLj = new HashMap();
    private HashMap<String, Integer> lLk = new HashMap();
    Bitmap lLl = null;
    Bitmap lLm = null;
    private a lLn;
    private boolean lLo = false;
    private boolean lLp = false;
    private ArrayList<String> lLq = new ArrayList();
    private ArrayList<String> lLr = new ArrayList();
    private ArrayList<Boolean> lLs = new ArrayList();
    View lLt;
    private ImageView lLu;
    private ImageView lLv;
    private TextView lLw;
    private String lLx;
    private View lLy;
    private TextView lLz;
    public boolean lMa = false;
    private HashMap<String, Integer> lMb = new HashMap();
    private al lMc = new al(new 31(this), false);
    private al lMd = new al(new al.a() {
        public final boolean vD() {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", new Object[]{Boolean.valueOf(WalletOfflineCoinPurseUI.this.bts)});
            if (WalletOfflineCoinPurseUI.this.bts) {
                bw bwVar = new bw();
                bwVar.bJn.bjW = 0;
                com.tencent.mm.sdk.b.a.sFg.m(bwVar);
            }
            WalletOfflineCoinPurseUI.this.finish();
            return false;
        }
    }, false);
    private long mLastTime = 0;
    private int mState = 3;

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        View inflate = getLayoutInflater().inflate(com.tencent.mm.plugin.wxpay.a.g.wallet_list_dialog, null);
        ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(f.address_contactlist);
        if (this.lLn == null) {
            this.lLn = new a(this);
        }
        if (i == 1) {
            a aVar = this.lLn;
            Collection collection = this.lLq;
            Collection collection2 = this.lLs;
            if (collection != null) {
                aVar.gBc.clear();
                aVar.gBc.addAll(collection);
            }
            if (collection2 != null) {
                aVar.lMB.clear();
                aVar.lMB.addAll(collection2);
            }
        }
        listViewInScrollView.setAdapter(this.lLn);
        this.lLn.notifyDataSetChanged();
        listViewInScrollView.setOnItemClickListener(new 18(this, i));
        com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(this);
        if (i == 1) {
            aVar2.Gq(i.wallet_wx_offline_change_bankcard_title);
        }
        aVar2.dR(inflate);
        aVar2.e(null);
        return aVar2.anj();
    }

    public void onCreate(Bundle bundle) {
        this.tlN = true;
        super.onCreate(bundle);
        k.lJx = true;
        e.He(41);
        Intent intent = getIntent();
        this.lLL = intent.getBooleanExtra("is_offline_create", false);
        if (intent != null && intent.hasExtra("key_entry_scene")) {
            this.eLd = intent.getIntExtra("key_entry_scene", this.eLd);
        }
        this.hop = intent.getIntExtra("key_from_scene", 0);
        this.lLx = bi.aG(intent.getStringExtra("key_business_attach"), "");
        this.iMP = 1;
        if (this.eLd == 2) {
            this.iMP = 1;
        } else if (this.eLd == 1) {
            this.iMP = 2;
        } else if (this.eLd == 8) {
            this.iMP = 4;
        } else if (this.eLd == 4) {
            this.iMP = 6;
        } else {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", new Object[]{Integer.valueOf(this.iMP)});
        }
        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
        ux(0);
        lF(getResources().getColor(a$c.wallet_offline_bg_color));
        cqh();
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        setBackBtn(new 33(this));
        e.cDO();
        if (!q.isEnabled()) {
            a(new y(null, 8), false, false);
        }
        if (o.bOW().bPr()) {
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
        } else if (o.bOW().bPp()) {
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
            com.tencent.mm.plugin.offline.c.a.blJ();
            k.bkO();
            k.aw(196648, "0");
        } else if (o.bOW().bPs() && com.tencent.mm.plugin.offline.c.a.bly()) {
            blv();
        }
        initView();
        com.tencent.mm.platformtools.y.a(this);
        k.bkO();
        k.bkP().a(this);
        jr(606);
        jr(609);
        jr(1501);
        k.bkO();
        k.bkQ().bN(this);
        com.tencent.mm.sdk.b.a.sFg.b(this.lLZ);
        com.tencent.mm.plugin.offline.c.a.blK();
        com.tencent.mm.sdk.b.a.sFg.a(this.lLX);
        com.tencent.mm.sdk.b.a.sFg.a(this.lLV);
        com.tencent.mm.sdk.b.a.sFg.a(this.lLS);
        this.lLT.cht();
        this.lLU.cht();
        this.lLK = new g();
        ks ksVar = new ks();
        ksVar.bVf.aeo = hashCode();
        com.tencent.mm.sdk.b.a.sFg.m(ksVar);
        this.lLW.cht();
    }

    private void blg() {
        blr();
        blt();
        bls();
        blp();
    }

    public void onResume() {
        boolean z;
        super.onResume();
        com.tencent.mm.sdk.b.a.sFg.b(this.lLY);
        aw.a(this, this);
        if (!this.lLR) {
            blg();
            this.lLR = true;
        }
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
        this.bts = true;
        com.tencent.mm.plugin.walletlock.a.b bVar = (com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.walletlock.a.b.class);
        bVar.a(this, bVar.bRo(), null);
        if (ao.isNetworkConnected(getBaseContext())) {
            if (o.bOW().bPr()) {
                a(new y(null, 8), true, false);
            }
            if (com.tencent.mm.plugin.offline.c.a.bly()) {
                k.bkO();
                k.bkR().gW(false);
                if (!c.ble()) {
                    if (q.isEnabled()) {
                        a(new q(com.tencent.mm.plugin.offline.c.a.lMM), false, false);
                    } else {
                        bln();
                    }
                }
            }
        }
        blj();
        Bankcard blA = com.tencent.mm.plugin.offline.c.a.blA();
        if (blA == null || blA.field_bindSerial == null || blA.field_bindSerial.equals(this.lIF)) {
            z = false;
        } else {
            this.lIF = blA.field_bindSerial;
            k.bkO();
            k.bkQ().lIF = this.lIF;
            z = true;
        }
        if (z || (this.lLp && this.lLo)) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
            this.lLp = false;
            this.lLo = false;
            blo();
            um(0);
            gX(true);
        }
        g gVar = this.lLK;
        if (com.tencent.mm.plugin.offline.c.a.bma()) {
            x.i(g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + gVar.lIZ.ciq());
            if (gVar.lIZ == null || gVar.lIZ.ciq()) {
                gVar.status = 1;
                h.mEJ.a(135, 61, 1, true);
                long j;
                int i;
                if (gVar.lIY) {
                    g.bkK();
                    j = (long) g.lII;
                    gVar.lIZ.J(j, j);
                    i = g.lII;
                    return;
                }
                j = (long) g.lIW;
                gVar.lIZ.J(j, j);
                i = g.lIW;
                return;
            }
            return;
        }
        x.i(g.TAG, "OfflineGetMsg is not in abtest");
    }

    private void blh() {
        e.He(32);
        com.tencent.mm.pluginsdk.wallet.h.Z(this, this.iMP);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on new intent");
        this.lLo = true;
    }

    public void onPause() {
        k.bkO();
        com.tencent.mm.plugin.offline.i bkR = k.bkR();
        bkR.mHandler.removeCallbacks(bkR.lJl);
        aw.a(this, null);
        this.bts = false;
        com.tencent.mm.sdk.b.a.sFg.c(this.lLY);
        this.lLK.stop();
        super.onPause();
    }

    public void onDestroy() {
        k.lJx = false;
        e.x(this.lLl);
        e.x(this.lLm);
        e.ai(this.lLM);
        e.ai(this.lLN);
        this.lLM.clear();
        this.lLN.clear();
        this.lLq.clear();
        this.lLr.clear();
        this.lLs.clear();
        com.tencent.mm.platformtools.y.c(this);
        k.bkO();
        k.bkP().b(this);
        js(606);
        js(609);
        js(1501);
        k.bkO();
        k.bkQ().bO(this);
        com.tencent.mm.sdk.b.a.sFg.c(this.lLZ);
        com.tencent.mm.sdk.b.a.sFg.c(this.lLX);
        com.tencent.mm.sdk.b.a.sFg.c(this.lLS);
        if (!this.lJn.ciq()) {
            this.lJn.SO();
        }
        if (!this.lMd.ciq()) {
            this.lMd.SO();
        }
        if (this.lLO != null) {
            this.lLO.release();
        }
        if (this.lLP != null) {
            c cVar = this.lLP;
            cVar.hni.cancel();
            cVar.mActivity = null;
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.lLV);
        this.lLT.dead();
        this.lLU.dead();
        g gVar = this.lLK;
        gVar.stop();
        g.bkK();
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(385, gVar.lIX);
        gVar.lIZ = null;
        this.lLW.dead();
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + i + "  errCode" + i2 + " errMsg:" + str + " scene: " + lVar);
        if ((lVar instanceof com.tencent.mm.plugin.offline.a.f) && ((i == 0 && i2 == 0) || i != 0)) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            this.lJk.bkV();
            this.lJk = null;
        }
        if (i == 0 && i2 == 0) {
            if (lVar instanceof y) {
                if (com.tencent.mm.plugin.offline.c.a.bly()) {
                    if (com.tencent.mm.plugin.offline.c.a.blB() != null) {
                        bln();
                    }
                    blv();
                }
                blt();
            } else if (lVar instanceof m) {
                this.lJk = (m) lVar;
                String str2 = this.lJk.lKk;
                k.bkO();
                com.tencent.mm.plugin.offline.a.f fVar = new com.tencent.mm.plugin.offline.a.f(str2, k.uk(196617));
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Eh().dpP.a(fVar, 0);
            } else if (lVar instanceof j) {
                blj();
                blg();
            } else if (lVar instanceof n) {
                n nVar = (n) lVar;
                if ("1".equals(nVar.lKp)) {
                    x.w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. showFirstPostTip alert to finish");
                    com.tencent.mm.ui.base.h.a(this, bi.oW(nVar.lKq) ? getString(i.wallet_data_err) : nVar.lKq, "", false, new 2(this));
                } else if (nVar.lJK == 0) {
                    c cVar = this.lLP;
                    cVar.lLb = (float) com.tencent.mm.plugin.offline.c.a.blF();
                    cVar.lLb = cVar.lLb;
                    if ("1".equals(nVar.lKo)) {
                        x.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
                        a(new m(((int) (System.currentTimeMillis() / 1000)), 8), false, false);
                    }
                } else if (nVar.lJK != 0) {
                    this.lLP.a(nVar, nVar.lJK, nVar.lJL);
                }
            } else if (!(lVar instanceof com.tencent.mm.plugin.offline.a.a)) {
                if (lVar instanceof com.tencent.mm.plugin.offline.a.e) {
                    this.lLP.d(i, i2, str, lVar);
                } else if (lVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.f) {
                    if (this.lLH != null && this.lLH.isShowing()) {
                        this.lLH.dismiss();
                    }
                    com.tencent.mm.plugin.wallet_core.id_verify.model.f fVar2 = (com.tencent.mm.plugin.wallet_core.id_verify.model.f) lVar;
                    if ("1".equals(fVar2.pkN) || ("2".equals(fVar2.pkN) && !bi.oW(fVar2.pkO))) {
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOfflineCoinPurseUI");
                        bundle.putString("realname_verify_process_jump_plugin", "offline");
                        String str3 = fVar2.pkO;
                        str3 = fVar2.pkP;
                        str3 = fVar2.pkQ;
                        com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, 1006);
                    } else if ("collect".equals(fVar2.pkR)) {
                        blh();
                    } else if ("reward".equals(fVar2.pkR)) {
                        d.A(this.mController.tml, "collect", ".reward.ui.QrRewardMainUI");
                    } else {
                        x.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[]{fVar2.pkR});
                    }
                } else if (lVar instanceof q) {
                    q qVar = (q) lVar;
                    d(qVar.lKv.errType, qVar.lKv.errCode, qVar.lKv.Yy, qVar.lKt);
                    d(qVar.lKu.errType, qVar.lKu.errCode, qVar.lKu.Yy, qVar.lKs);
                }
            }
            if ((lVar instanceof y) || (lVar instanceof n) || (lVar instanceof com.tencent.mm.plugin.offline.a.a) || (lVar instanceof com.tencent.mm.plugin.offline.a.e)) {
                blj();
                y(false, true);
            } else if (lVar instanceof com.tencent.mm.plugin.offline.a.f) {
                blj();
                y(true, true);
            }
        } else if (lVar instanceof n) {
            blj();
            y(false, true);
            if (411 == i2) {
                this.lLP.a(lVar, i2, str);
            }
        } else if (lVar instanceof com.tencent.mm.plugin.offline.a.e) {
            this.lLP.d(i, i2, str, lVar);
        } else if (!(lVar instanceof j)) {
            if (lVar instanceof com.tencent.mm.plugin.offline.a.f) {
                this.lJk = null;
            } else if (lVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.f) {
                if (this.lLH != null && this.lLH.isShowing()) {
                    this.lLH.dismiss();
                }
            } else if (lVar instanceof q) {
                blj();
                y(false, true);
                if (411 == i2) {
                    this.lLP.a(lVar, i2, str);
                }
            }
        }
        return true;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.wallet_offline_coin_purse_ui;
    }

    protected final void initView() {
        this.lLQ = (OfflineAlertView) findViewById(f.offline_alert_view);
        this.lLQ.dismiss();
        this.lLQ.setDialogState(new 3(this));
        com.tencent.mm.wallet_core.c.a.cCW();
        com.tencent.mm.wallet_core.c.a.init(getApplicationContext());
        if (this.eLd == 3 || this.eLd == 10 || this.eLd == 11 || this.eLd == 12) {
            setMMTitle(i.wallet_wx_offline_coin_purse_card_title);
        } else {
            setMMTitle(i.wallet_wx_offline_coin_purse_title);
        }
        this.lLP = new c(this, this);
        c cVar = this.lLP;
        cVar.hni = (Vibrator) cVar.mActivity.getSystemService("vibrator");
        this.lLO = new c(this, true);
        this.lLO.init();
        this.lLt = findViewById(f.wallet_qrcode_layout);
        this.lLu = (ImageView) findViewById(f.wallet_qrcode_iv);
        this.lLv = (ImageView) findViewById(f.wallet_barcode_iv);
        this.lLw = (TextView) findViewById(f.wallet_barcode_tv);
        this.lLy = findViewById(f.wallet_wx_offline_change_bankcard_layout);
        this.lLz = (TextView) findViewById(f.wallet_wx_offline_change_bankcard_tv);
        this.lLA = (ImageView) findViewById(f.wallet_wx_offline_bank_logo);
        this.lLB = (RelativeLayout) findViewById(f.wallet_offline_menu_layout);
        this.lLB.setOnClickListener(new 11(this));
        this.lLu.setOnClickListener(this.eZF);
        this.lLv.setOnClickListener(this.eZF);
        this.lLw.setOnClickListener(this.eZF);
        this.lLy.setClickable(true);
        this.lLy.setOnClickListener(new 13(this));
        this.mLastTime = System.currentTimeMillis();
        this.lLC = (LinearLayout) findViewById(f.wallet_offline_collect_btn_layout);
        this.lLD = (LinearLayout) findViewById(f.wallet_offline_aa_btn_layout);
        this.lLE = (LinearLayout) findViewById(f.wallet_offline_f2f_lucky_btn_layout);
        this.lLF = (LinearLayout) findViewById(f.wallet_offline_qr_reward_layout);
        this.lLG = (LinearLayout) findViewById(f.wallet_offline_bank_remit_layout);
        if (this.eLd == 3 || this.eLd == 10 || this.eLd == 11 || this.eLd == 12) {
            this.lLC.setVisibility(8);
            this.lLD.setVisibility(8);
            this.lLE.setVisibility(8);
            this.lLF.setVisibility(8);
        } else {
            this.lLF.setVisibility(0);
            this.lLG.setVisibility(0);
            boolean b = com.tencent.mm.s.c.Cp().b(aa.a.sZc, aa.a.sYe);
            boolean b2 = com.tencent.mm.s.c.Cp().b(aa.a.sZd, aa.a.sYe);
            boolean b3 = com.tencent.mm.s.c.Cp().b(aa.a.sZe, aa.a.sYe);
            boolean b4 = com.tencent.mm.s.c.Cp().b(aa.a.sZf, aa.a.sYe);
            boolean b5 = com.tencent.mm.s.c.Cp().b(aa.a.sZg, aa.a.sYe);
            ImageView imageView = (ImageView) this.lLD.findViewById(f.aa_new_dot);
            ImageView imageView2 = (ImageView) this.lLC.findViewById(f.f2f_recv_new_dot);
            ImageView imageView3 = (ImageView) this.lLE.findViewById(f.f2f_hb_new_dot);
            ImageView imageView4 = (ImageView) this.lLF.findViewById(f.qr_reward_new_dot);
            TextView textView = (TextView) this.lLC.findViewById(f.f2f_recv_red_wording);
            ImageView imageView5 = (ImageView) this.lLC.findViewById(f.f2f_recv_red_dot);
            final ImageView imageView6 = (ImageView) this.lLG.findViewById(f.bank_remit_new_dot);
            if (b) {
                imageView.setVisibility(0);
            }
            if (b2) {
                com.tencent.mm.kernel.g.Ek();
                String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sYu, "");
                if (bi.oW(str)) {
                    imageView2.setVisibility(0);
                } else {
                    textView.setText(str);
                    textView.setVisibility(0);
                    imageView5.setVisibility(0);
                }
            }
            if (b3) {
                imageView3.setVisibility(0);
            }
            if (b4) {
                imageView4.setVisibility(0);
            }
            if (b5) {
                imageView6.setVisibility(0);
            }
            if (((Boolean) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sZh, Boolean.valueOf(false))).booleanValue()) {
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "no need scroll");
            } else {
                getWindow().getDecorView().post(new 5(this, b2, b4, b, b3, b5));
            }
            this.lLC.setOnClickListener(new 6(this, imageView2, textView, imageView5));
            this.lLD.setOnClickListener(new 7(this, imageView));
            this.lLE.setOnClickListener(new 8(this, imageView3));
            this.lLF.setOnClickListener(new 9(this, imageView4));
            this.lLG.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    d.A(WalletOfflineCoinPurseUI.this.mController.tml, "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
                    if (com.tencent.mm.s.c.Cp().b(aa.a.sZg, aa.a.sYe)) {
                        com.tencent.mm.s.c.Cp().c(aa.a.sZg, aa.a.sYe);
                        imageView6.setVisibility(8);
                    }
                }
            });
        }
        if (com.tencent.mm.plugin.offline.c.a.bly() && c.ble()) {
            c cVar2 = this.lLP;
            k.bkO();
            cVar2.a(k.bkP().lKw);
        }
        blj();
        y(true, false);
        long j = (long) this.lJm;
        this.lJn.J(j, j);
        if (com.tencent.mm.plugin.offline.c.a.lMM == 3 && com.tencent.mm.plugin.offline.c.a.lMP) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
            int i = com.tencent.mm.plugin.offline.c.a.lMN;
            j = com.tencent.mm.plugin.offline.c.a.lMO;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = (((long) (i * 1000)) + j) - currentTimeMillis;
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + j + " now:" + currentTimeMillis + " interval:" + j2);
            if (com.tencent.mm.plugin.offline.c.a.lMN <= 0 || com.tencent.mm.plugin.offline.c.a.lMO <= 0 || j2 <= 0) {
                x.e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
            } else {
                if (!this.lMd.ciq()) {
                    this.lMd.SO();
                }
                this.lMd.J(j2, j2);
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
            }
        } else if (com.tencent.mm.plugin.offline.c.a.lMM == 3) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
        } else {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", new Object[]{Integer.valueOf(com.tencent.mm.plugin.offline.c.a.lMM)});
        }
        bli();
        sy syVar = new sy();
        syVar.cdO.buF = "5";
        syVar.bJX = new 4(this, syVar);
        com.tencent.mm.sdk.b.a.sFg.m(syVar);
    }

    private void y(boolean z, boolean z2) {
        if (com.tencent.mm.plugin.offline.c.a.gY(true).size() > 0) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
            blo();
            Bankcard blA = com.tencent.mm.plugin.offline.c.a.blA();
            if (blA != null) {
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard");
                com.tencent.mm.plugin.offline.c.a.Ja(blA.field_bindSerial);
                this.lIF = blA.field_bindSerial;
                k.bkO();
                k.bkQ().lIF = this.lIF;
            } else {
                x.e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
            }
            this.lLy.setVisibility(0);
        } else {
            this.lLy.setVisibility(8);
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
        }
        if (z) {
            um(0);
        }
        gX(z2);
        if (com.tencent.mm.plugin.offline.c.a.bly()) {
            this.lLB.setVisibility(0);
        } else {
            this.lLB.setVisibility(4);
        }
        bli();
    }

    private void bli() {
        if (!this.lMa && !ao.isNetworkConnected(getBaseContext())) {
            k.bkO();
            k.bkQ();
            if (com.tencent.mm.plugin.offline.e.bkH() == 0) {
                this.lMa = true;
                x.e("MicroMsg.OfflineErrorHelper", "offline code size is 0, show check network error dialog");
                com.tencent.mm.ui.base.h.a(this, getString(i.wallet_wx_offline_check_network_connect_tips), null, false, new 4(this));
                x.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
            }
        }
    }

    private void blj() {
        int blD = com.tencent.mm.plugin.offline.c.a.blD();
        Bankcard blB = com.tencent.mm.plugin.offline.c.a.blB();
        if (c.ble()) {
            this.mState = 7;
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FREEZE");
        } else if (!ao.isNetworkConnected(getBaseContext())) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_DISCONNECT_NETWORK");
            this.mState = 6;
        } else if (com.tencent.mm.plugin.offline.c.a.bly()) {
            if (blD == 0) {
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount == 0");
                this.mState = 1;
            } else if (blD == 0 || blB != null) {
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
                this.mState = 5;
            } else {
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount != 0 && bankcard == null");
                this.mState = 2;
            }
        } else if (blD == 0) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount == 0");
            this.mState = 1;
        } else if (blD == 0 || blB != null) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
            this.mState = 5;
        } else {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount != 0 && bankcard == null");
            this.mState = 2;
        }
    }

    public final boolean bbU() {
        return false;
    }

    private void gX(boolean z) {
        Bitmap bitmap;
        long currentTimeMillis = System.currentTimeMillis();
        if (z && (bi.oW(this.lLI) || bi.oW(this.lJi))) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
            if (this.lLQ.ul(5)) {
                if (this.lLQ.lKQ == 5) {
                    this.lLQ.dismiss();
                }
                OfflineAlertView offlineAlertView = this.lLQ;
                View view = this.lLt;
                24 24 = new 24(this);
                offlineAlertView.lKQ = 5;
                offlineAlertView.setVisibility(0);
                offlineAlertView.lKS = false;
                offlineAlertView.lKR.removeAllViews();
                View inflate = LayoutInflater.from(offlineAlertView.getContext()).inflate(com.tencent.mm.plugin.wxpay.a.g.wallet_offline_unopened_layout, null);
                offlineAlertView.lKR.addView(inflate);
                ((TextView) inflate.findViewById(f.alert_title)).setText(i.offline_empty_code_text);
                Button button = (Button) inflate.findViewById(f.i_know_btn);
                button.setText(i.offline_empty_code_btn_text);
                button.setOnClickListener(24);
                view.post(new 8(offlineAlertView, view));
                h.mEJ.a(135, 73, 1, true);
            }
        } else if (this.lLQ.isShowing() && this.lLQ.lKQ == 5) {
            this.lLQ.dismiss();
        }
        Bitmap bitmap2 = this.lLl;
        if (TextUtils.isEmpty(this.lLI)) {
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
            bitmap = null;
        } else {
            bitmap = com.tencent.mm.bm.a.a.b(this, this.lLI, 0, 3);
        }
        this.lLl = bitmap;
        this.lLu.setImageBitmap(this.lLl);
        if (blk()) {
            this.lLu.setAlpha(10);
        } else {
            this.lLu.setAlpha(255);
        }
        this.lLM.add(0, bitmap2);
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - currentTimeMillis));
        bitmap2 = this.lLm;
        if (TextUtils.isEmpty(this.lJi)) {
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
            bitmap = null;
        } else {
            bitmap = com.tencent.mm.bm.a.a.b(this, this.lJi, 5, 0);
        }
        this.lLm = bitmap;
        this.lLv.setImageBitmap(this.lLm);
        if (blk()) {
            this.lLv.setAlpha(10);
        } else {
            this.lLv.setAlpha(255);
        }
        this.lLN.add(0, bitmap2);
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - currentTimeMillis));
        ayU();
        bll();
        com.tencent.mm.wallet_core.c.q.fu(10, 0);
        h hVar = h.mEJ;
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(3);
        objArr[1] = Integer.valueOf(com.tencent.mm.plugin.offline.c.a.dE(ad.getContext()) ? 0 : 1);
        objArr[2] = Integer.valueOf(ao.isNetworkConnected(ad.getContext()) ? 1 : 0);
        k.bkO();
        k.bkQ();
        objArr[3] = Integer.valueOf(com.tencent.mm.plugin.offline.e.bkH());
        hVar.h(14163, objArr);
        h.mEJ.a(135, 67, 1, true);
        if (ao.isNetworkConnected(ad.getContext())) {
            h.mEJ.a(135, 32, 1, true);
        } else {
            h.mEJ.a(135, 33, 1, true);
        }
        if (com.tencent.mm.plugin.offline.c.a.dE(this)) {
            h.mEJ.a(135, 34, 1, true);
        } else {
            h.mEJ.a(135, 35, 1, true);
        }
    }

    private boolean blk() {
        return this.mState == 2 || this.mState == 1 || this.mState == 7;
    }

    private void bll() {
        if (this.lLO != null) {
            this.lLO.gn(this.lLI, this.lJi);
            this.lLO.lLl = this.lLl;
            this.lLO.lLm = this.lLm;
            this.lLO.cDE();
        }
    }

    private void ayU() {
        int size;
        if (this.lLM.size() >= 2) {
            for (size = this.lLM.size() - 1; size > 1; size--) {
                e.x((Bitmap) this.lLM.remove(size));
            }
        }
        if (this.lLN.size() >= 2) {
            for (size = this.lLN.size() - 1; size > 1; size--) {
                e.x((Bitmap) this.lLN.remove(size));
            }
        }
    }

    private void um(int i) {
        int i2 = 0;
        if (com.tencent.mm.plugin.offline.c.a.bly()) {
            k.bkO();
            com.tencent.mm.plugin.offline.e bkQ = k.bkQ();
            int i3 = this.eLd;
            String str = this.lLx;
            x.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i), bi.cjd().toString()});
            String k = bkQ.k(i3, i, str);
            this.lJi = k;
            this.lLI = k;
            x.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", new Object[]{Integer.valueOf(i), this.lJi, this.lLI, bi.cjd().toString()});
            com.tencent.mm.protocal.c.aw bOL = com.tencent.mm.plugin.wallet_core.model.i.bOL();
            StringBuilder append = new StringBuilder().append(this.lLI);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eg();
            str = ac.ce(append.append(com.tencent.mm.a.o.getString(com.tencent.mm.kernel.a.Df())).toString());
            if (bOL != null) {
                h.mEJ.h(13444, new Object[]{bOL.raZ, bOL.rba, Long.valueOf(bOL.raY), str, bOL.rbb, bOL.rbc});
            }
            if (bi.oW(k)) {
                int i4;
                h hVar = h.mEJ;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(1);
                if (com.tencent.mm.plugin.offline.c.a.dE(ad.getContext())) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                objArr[1] = Integer.valueOf(i4);
                if (ao.isNetworkConnected(getBaseContext())) {
                    i2 = 1;
                }
                objArr[2] = Integer.valueOf(i2);
                hVar.h(14163, objArr);
                h.mEJ.a(135, 26, 1, true);
                if (ao.isNetworkConnected(getBaseContext())) {
                    h.mEJ.a(135, 28, 1, true);
                    return;
                } else {
                    h.mEJ.a(135, 27, 1, true);
                    return;
                }
            }
            return;
        }
        x.w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
    }

    public final boolean a(s.c cVar) {
        if (cVar == null) {
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msg == null");
            return false;
        }
        boolean z;
        blm();
        this.lLO.dismiss();
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "msgtype=" + cVar.lKD);
        if (4 == cVar.lKD) {
            this.lLJ = false;
            z = false;
        } else {
            if (5 == cVar.lKD) {
                this.lLJ = false;
                if (!this.lMc.ciq()) {
                    this.lMc.SO();
                }
                if (cVar instanceof s.e) {
                    z = ((s.e) cVar).lKJ;
                }
            } else if (6 == cVar.lKD) {
                this.lLJ = false;
                if (!this.lMc.ciq()) {
                    this.lMc.SO();
                }
                if (com.tencent.mm.plugin.offline.c.a.blz()) {
                    z = false;
                }
            } else if (8 != cVar.lKD) {
                if (23 == cVar.lKD) {
                    if (!this.lMc.ciq()) {
                        this.lMc.SO();
                        z = false;
                    }
                } else if (20 == cVar.lKD) {
                    this.lLJ = false;
                    if (!this.lMc.ciq()) {
                        this.lMc.SO();
                        z = false;
                    }
                } else if (24 == cVar.lKD) {
                    if (com.tencent.mm.plugin.offline.c.a.bma()) {
                        this.lLJ = true;
                        if (com.tencent.mm.plugin.offline.c.a.bma()) {
                            if (this.lLH == null) {
                                this.lLH = com.tencent.mm.wallet_core.ui.g.a(this.mController.tml, false, new 16(this));
                            } else if (!this.lLH.isShowing()) {
                                this.lLH.show();
                            }
                        }
                        long bkJ = (long) g.bkJ();
                        this.lMc.J(bkJ, bkJ);
                    }
                }
                z = false;
            } else if (!this.lMc.ciq()) {
                this.lMc.SO();
                z = true;
            }
            z = true;
        }
        c cVar2 = this.lLP;
        if (cVar == null) {
            x.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
        } else {
            x.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + cVar.lKD);
            if (cVar.lKD == 24) {
                cVar2.hni.vibrate(50);
            }
            if (4 == cVar.lKD) {
                cVar2.a((s.b) cVar);
                g.bkK();
            } else if (5 == cVar.lKD) {
                s.e eVar = (s.e) cVar;
                if (eVar != null) {
                    x.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + eVar.lKG + " msg.wxRetMsg:" + eVar.lKH + " msg.cftRetCode:" + eVar.lKG + " msg.cftRetMsg:" + eVar.lKF);
                    if (!(TextUtils.isEmpty(eVar.lKG) && TextUtils.isEmpty(eVar.lKH) && TextUtils.isEmpty(eVar.lKE) && TextUtils.isEmpty(eVar.lKF))) {
                        if (TextUtils.isEmpty(eVar.lKG) && TextUtils.isEmpty(eVar.lKH) && !TextUtils.isEmpty(eVar.lKE) && !TextUtils.isEmpty(eVar.lKF)) {
                            b.b(cVar2.mActivity, eVar.lKF);
                        } else if (TextUtils.isEmpty(eVar.lKG) || !com.tencent.mm.plugin.offline.c.a.xW(eVar.lKG)) {
                            b.b(cVar2.mActivity, eVar.lKH);
                        } else {
                            cVar2.a(null, Integer.valueOf(eVar.lKG).intValue(), eVar.lKH, eVar.lKI);
                        }
                    }
                }
                g.bkK();
                h.mEJ.a(135, 0, 1, true);
            } else if (6 == cVar.lKD) {
                s$f s_f = (s$f) cVar;
                if (s_f != null) {
                    x.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + s_f.lKK);
                    k.bkO();
                    r IX = k.bkS().IX(s_f.lKL.bOd);
                    boolean z2 = IX != null ? IX.field_status == g.lIT : false;
                    if (!z2) {
                        g.bR(s_f.lKL.bOd, g.lIT);
                        com.tencent.mm.plugin.offline.c.a.a(cVar2.mActivity, s_f);
                        cVar2.mActivity.setResult(-1);
                        cVar2.mActivity.finish();
                    }
                }
                g.bkK();
                h.mEJ.a(135, 7, 1, true);
                if (com.tencent.mm.plugin.offline.c.a.lMM == 4) {
                    x.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
                    h.mEJ.h(13412, new Object[0]);
                }
            } else if (8 == cVar.lKD) {
                s.g gVar = (s.g) cVar;
                x.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + gVar.id);
                if (gVar.lKO == 0) {
                    View inflate = cVar2.mActivity.getLayoutInflater().inflate(com.tencent.mm.plugin.wxpay.a.g.wallet_offline_payconfirm_layout, null);
                    TextView textView = (TextView) inflate.findViewById(f.pay_good_name);
                    ((TextView) inflate.findViewById(f.pay_fee)).setText(gVar.lKN);
                    textView.setText(gVar.lKM);
                    g.bR(gVar.bQa, g.lIV);
                    com.tencent.mm.ui.base.h.a(cVar2.mActivity, "", inflate, cVar2.getString(i.wallet_wx_offline_pay_confirm_enter), cVar2.getString(i.app_cancel), new 11(cVar2, gVar), new 12(cVar2, gVar));
                } else if (gVar.lKO == 1) {
                    if (cVar2.lLa != null) {
                        cVar2.lLa.show();
                    }
                    h.mEJ.h(13955, new Object[]{Integer.valueOf(1)});
                    x.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + gVar.id);
                    g.bR(gVar.bQa, g.lIV);
                    cVar2.lLa = com.tencent.mm.plugin.wallet_core.ui.o.a(cVar2.mActivity, gVar.lKM, gVar.lKN, new 13(cVar2, gVar), new 14(cVar2), new 15(cVar2, gVar));
                    cVar2.lLa.mHZ.setVisibility(0);
                    cVar2.lLa.mBQ.setVisibility(8);
                }
            } else if (23 == cVar.lKD) {
                s.d dVar = (s.d) cVar;
                PayInfo payInfo = new PayInfo();
                payInfo.bOd = dVar.bQa;
                payInfo.bVY = 8;
                payInfo.qUR = 1;
                payInfo.qUL = new Bundle();
                payInfo.qUL.putLong("extinfo_key_9", System.currentTimeMillis());
                com.tencent.mm.sdk.b.a.sFg.a(new 1(cVar2, payInfo));
                com.tencent.mm.pluginsdk.wallet.h.a(cVar2.mActivity, false, "", cVar2.lKZ == null ? "" : cVar2.lKZ.blb(), payInfo, "", new Intent(), 1);
            } else if (20 == cVar.lKD) {
                g.bkK();
            }
        }
        if (z) {
            um(0);
            gX(true);
        }
        return true;
    }

    private void blm() {
        if (this.lLH != null && this.lLH.isShowing()) {
            this.lLH.dismiss();
        }
    }

    private void bln() {
        a(new n(System.currentTimeMillis(), com.tencent.mm.plugin.offline.c.a.lMM), false, false);
    }

    public final void m(String str, Bitmap bitmap) {
        if (!TextUtils.isEmpty(str) && bitmap != null && !bitmap.isRecycled()) {
            ImageView imageView = (ImageView) this.lLj.get(str);
            Integer num = (Integer) this.lLk.get(str);
            if (imageView != null && num != null) {
                new ag(getMainLooper()).post(new 17(this, num, bitmap, imageView));
            }
        }
    }

    public final void aou() {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
        um(1);
        gX(true);
        e.He(40);
        h.mEJ.a(135, 21, 1, true);
        if (this.lLO.eZB.isShowing()) {
            if (this.lLO.hCn) {
                this.lLO.cDF();
                return;
            }
            this.lLO.dismiss();
        }
        blq();
    }

    public final void blo() {
        boolean z;
        Object obj;
        Bankcard blA = com.tencent.mm.plugin.offline.c.a.blA();
        findViewById(f.wallet_wx_offline_change_bankcard_tip).setVisibility(0);
        this.lLz.setTextSize(0, (float) getResources().getDimensionPixelSize(com.tencent.mm.plugin.wxpay.a.d.NormalTextSize));
        if (this.lLz == null || blA == null) {
            if (blA == null) {
                x.e("MicroMsg.WalletOfflineCoinPurseUI", "setChangeBankcardText bankcard == null");
            }
            z = false;
        } else {
            CharSequence obj2;
            String string = getString(i.wallet_wx_offline_change_bankcard_tips, new Object[]{blA.field_desc});
            List<com.tencent.mm.plugin.wallet_core.model.c> bPE = o.bOW().bPE();
            if (!(bPE == null || bi.oW(blA.field_forbidWord))) {
                for (com.tencent.mm.plugin.wallet_core.model.c cVar : bPE) {
                    if (cVar.lMW.equals(blA.field_bindSerial)) {
                        break;
                    }
                }
            }
            com.tencent.mm.plugin.wallet_core.model.c cVar2 = null;
            if (cVar2 == null || bi.oW(cVar2.plH)) {
                obj2 = string;
                z = false;
            } else {
                obj2 = blA.field_desc + cVar2.plH;
                findViewById(f.wallet_wx_offline_change_bankcard_tip).setVisibility(8);
                h.mEJ.h(14515, new Object[]{Integer.valueOf(2)});
                this.lLz.setTextSize(0, (float) getResources().getDimensionPixelSize(com.tencent.mm.plugin.wxpay.a.d.HintTextSize));
                z = true;
            }
            this.lLz.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mController.tml, obj2, this.lLz.getTextSize()));
        }
        if (blA != null) {
            if (TextUtils.isEmpty(this.lIF)) {
                x.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
            } else if (blA.bOw()) {
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "show local hy logo");
                this.lLA.setImageDrawable(com.tencent.mm.svg.a.a.c(this.mController.tml.getResources(), com.tencent.mm.plugin.wxpay.a.h.honey_pay_bank_logo));
            } else {
                obj2 = com.tencent.mm.plugin.offline.c.a.Jh(this.lIF);
                if (blA.bOt() && blA.pmc != null) {
                    obj2 = blA.pmc.lCU;
                }
                if (TextUtils.isEmpty(obj2)) {
                    x.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
                } else {
                    ImageView imageView = this.lLA;
                    int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.tencent.mm.plugin.wxpay.a.d.wallet_offline_bank_logo_width);
                    if (!(imageView == null || TextUtils.isEmpty(obj2))) {
                        Bitmap a = com.tencent.mm.platformtools.y.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(obj2));
                        if (a != null) {
                            imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a(a, dimensionPixelOffset, dimensionPixelOffset, true, false));
                        }
                        this.lLj.put(obj2, imageView);
                        this.lLk.put(obj2, Integer.valueOf(dimensionPixelOffset));
                    }
                }
            }
        }
        if (z) {
            this.lLA.setImageResource(com.tencent.mm.plugin.wxpay.a.h.error_offline_info);
        }
    }

    private void blp() {
        if (!this.lLL && this.lLQ.ul(4)) {
            com.tencent.mm.kernel.g.Ek();
            if (!((Boolean) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sUp, Boolean.valueOf(false))).booleanValue() && !this.lLQ.isShowing()) {
                blq();
            }
        }
    }

    private void blq() {
        if (this.lLQ.ul(4)) {
            OfflineAlertView offlineAlertView = this.lLQ;
            View view = this.lLt;
            offlineAlertView.setVisibility(0);
            offlineAlertView.lKR.removeAllViews();
            offlineAlertView.lKR.addView(LayoutInflater.from(offlineAlertView.getContext()).inflate(com.tencent.mm.plugin.wxpay.a.g.wallet_offline_first_guide, null));
            h.mEJ.h(13750, new Object[]{Integer.valueOf(1)});
            view.post(new 2(offlineAlertView, view));
        }
    }

    private void blr() {
        if (this.lLQ.ul(1)) {
            if (this.lLQ.lKQ == 1) {
                this.lLQ.dismiss();
            }
            boolean bPp = o.bOW().bPp();
            boolean bPt = o.bOW().bPt();
            if (bPp || bPt) {
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B", new Object[]{Boolean.valueOf(bPp), Boolean.valueOf(bPt)});
                this.lLQ.a(this.lLt, new OnClickListener() {
                    public final void onClick(View view) {
                        com.tencent.mm.plugin.offline.c.a.blJ();
                        k.bkO();
                        k.aw(196648, "0");
                        com.tencent.mm.ui.base.h.a(WalletOfflineCoinPurseUI.this, false, WalletOfflineCoinPurseUI.this.getString(i.wallet_wx_offline_add_bank_card_tip), "", WalletOfflineCoinPurseUI.this.getString(i.wallet_wx_offline_check_user_info_btn_text), WalletOfflineCoinPurseUI.this.getString(i.app_cancel), new 19(WalletOfflineCoinPurseUI.this), new 20(WalletOfflineCoinPurseUI.this));
                    }
                }, 1);
            }
        }
    }

    private void bls() {
        if (this.lLQ.ul(3)) {
            if (this.lLQ.lKQ == 3) {
                this.lLQ.dismiss();
            }
            k.bkO();
            String uk = k.uk(196617);
            com.tencent.mm.wallet_core.c.a.cCW();
            boolean isCertExist = com.tencent.mm.wallet_core.c.a.isCertExist(uk);
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", new Object[]{Boolean.valueOf(isCertExist), Boolean.valueOf(com.tencent.mm.plugin.offline.c.a.bly())});
            if (!isCertExist || !r2) {
                if (!isCertExist) {
                    com.tencent.mm.kernel.g.Ek();
                    String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sOy, "");
                    if (str == null || !str.equals(com.tencent.mm.compatible.e.q.zy())) {
                        x.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
                    } else {
                        x.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
                    }
                    x.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + uk + " ,recreate offline");
                    com.tencent.mm.plugin.offline.c.a.blJ();
                }
                this.lLQ.a(this.lLt, new 22(this), 3);
            }
        }
    }

    private boolean blt() {
        if (!this.lLQ.ul(2)) {
            return false;
        }
        if (this.lLQ.lKQ == 2) {
            this.lLQ.dismiss();
        }
        List blE = com.tencent.mm.plugin.offline.c.a.blE();
        if (blE.size() <= 0) {
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
            return false;
        }
        for (int i = 0; i < blE.size(); i++) {
            Bankcard bankcard = (Bankcard) blE.get(i);
            if (bankcard != null && bankcard.field_support_micropay && bi.oW(bankcard.field_forbidWord)) {
                return true;
            }
        }
        this.lLQ.dismiss();
        OfflineAlertView offlineAlertView = this.lLQ;
        View view = this.lLt;
        26 26 = new 26(this);
        27 27 = new 27(this);
        offlineAlertView.setVisibility(0);
        offlineAlertView.lKR.removeAllViews();
        offlineAlertView.lKR.addView(LayoutInflater.from(offlineAlertView.getContext()).inflate(com.tencent.mm.plugin.wxpay.a.g.wallet_offline_nosupport_tip, null));
        view.post(new OfflineAlertView.1(offlineAlertView, view, 26, 27));
        return false;
    }

    private static Bankcard f(List<Bankcard> list, String str) {
        for (Bankcard bankcard : list) {
            if (str.equals(bankcard.field_bindSerial)) {
                list.remove(bankcard);
                return bankcard;
            }
        }
        return null;
    }

    private void blu() {
        List gY = com.tencent.mm.plugin.offline.c.a.gY(false);
        if (gY.size() <= 0) {
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
            this.lLz.setVisibility(8);
            return;
        }
        Bankcard bankcard;
        List<Bankcard> arrayList = new ArrayList();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        Bankcard bankcard2 = null;
        Object obj = null;
        while (i < gY.size()) {
            if (((Bankcard) gY.get(i)).bOs()) {
                i3 = i;
                obj = (Bankcard) gY.get(i);
            }
            if (((Bankcard) gY.get(i)).bOt()) {
                bankcard = (Bankcard) gY.get(i);
                i2 = i;
            } else {
                bankcard = bankcard2;
            }
            i++;
            bankcard2 = bankcard;
        }
        if (obj != null) {
            arrayList.add(obj);
        }
        if (bankcard2 != null) {
            arrayList.add(bankcard2);
        }
        int i4 = 0;
        while (i4 < gY.size()) {
            if (!(i4 == i2 || i4 == i3)) {
                arrayList.add(gY.get(i4));
            }
            i4++;
        }
        com.tencent.mm.plugin.offline.c.a.Jc(com.tencent.mm.plugin.offline.c.a.blO());
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "showChangeBankcardDialog() bankcard size is " + arrayList.size());
        List<com.tencent.mm.plugin.wallet_core.model.c> bPE = o.bOW().bPE();
        if (bPE != null && bPE.size() > 0) {
            List<Bankcard> linkedList = new LinkedList();
            for (Bankcard bankcard3 : arrayList) {
                linkedList.add(bankcard3);
            }
            arrayList.clear();
            for (com.tencent.mm.plugin.wallet_core.model.c cVar : bPE) {
                bankcard3 = f(linkedList, cVar.lMW);
                if (bankcard3 != null) {
                    arrayList.add(bankcard3);
                }
            }
            for (Bankcard bankcard32 : linkedList) {
                arrayList.add(bankcard32);
            }
        }
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(this, 2, true);
        i = 0;
        for (i2 = 0; i2 < arrayList.size(); i2++) {
            bankcard32 = (Bankcard) arrayList.get(i2);
            if (!bi.oW(bankcard32.field_bindSerial) && this.lIF.equals(bankcard32.field_bindSerial)) {
                i = i2;
            }
        }
        dVar.ofp = new 28(this, arrayList, dVar);
        dVar.ofq = new 29(this, dVar, arrayList);
        View inflate = View.inflate(this, com.tencent.mm.plugin.wxpay.a.g.wallet_offline_coin_bankcard_header, null);
        dVar.mqO = true;
        dVar.uKk = i;
        dVar.uKi = true;
        dVar.dS(inflate);
        dVar.bXO();
        h.mEJ.h(13955, new Object[]{Integer.valueOf(3)});
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private static void blv() {
        if (!com.tencent.mm.plugin.offline.c.a.blS()) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
            k.bkO();
            k.bkR().df(3, 3);
        }
    }

    public final void awE() {
        um(0);
        gX(true);
    }

    public final void o(int i, String str, String str2) {
        a(new com.tencent.mm.plugin.offline.a.e(i, str, str2), com.tencent.mm.plugin.offline.c.a.blz(), false);
    }

    public final void bkZ() {
        blu();
    }

    public final void bla() {
        a(new j(""), false, false);
    }

    public final String blb() {
        return this.lIF;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.lLQ == null || this.lLQ.getVisibility() != 0 || !this.lLQ.lKS) {
            return super.onKeyUp(i, keyEvent);
        }
        this.lLQ.dismiss();
        return true;
    }

    public final void blc() {
        if (!this.lJn.ciq()) {
            this.lJn.SO();
        }
        um(0);
        gX(true);
        long j = (long) this.lJm;
        this.lJn.J(j, j);
    }
}
