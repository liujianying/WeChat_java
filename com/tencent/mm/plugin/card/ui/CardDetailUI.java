package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.a.pf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.card.b.c.a;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.i;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.aa;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.plugin.card.ui.e.1;
import com.tencent.mm.plugin.card.ui.e.5;
import com.tencent.mm.plugin.card.ui.j.2;
import com.tencent.mm.plugin.card.ui.j.3;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bmv;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bqs;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.protocal.c.lg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class CardDetailUI extends CardDetailBaseUI implements e, a, d.a, j.a, aw.a {
    private final String TAG = "MicroMsg.CardDetailUI";
    private float cXm = -85.0f;
    private float cXn = -1000.0f;
    private com.tencent.mm.modelgeo.a.a cXs = new 1(this);
    private c dMm;
    private String dxx = "";
    private p fUo = null;
    private boolean hAj = false;
    e hBC;
    private String hBD = "";
    private String hBE = "";
    private String hBF = "";
    private boolean hBG = false;
    private boolean hBH = false;
    private boolean hBI = false;
    private String hBJ = "";
    private e.a hBK;
    private boolean hBL = false;
    private boolean hBM = true;
    private boolean hBN = false;
    private boolean hBO = false;
    private String hBP = "";
    private i hBQ = new i();
    private int hBg = 0;
    private String hBh = "";
    private String hBi = "";
    private String hBj = "";
    private Vibrator hni;
    private int hop = 3;
    private String htC = "";
    private b htQ;
    private ArrayList<la> htW;
    private String huQ = "";
    private boolean hvg = false;
    private int hza = -1;
    private boolean hzn = false;
    ag mHandler = new ag();
    private long mStartTime = 0;

    static /* synthetic */ void i(CardDetailUI cardDetailUI) {
        int i;
        cardDetailUI.dO(true);
        bmv bmv = new bmv();
        if (cardDetailUI.hop == 3) {
            bmv.cac = cardDetailUI.htC;
            i = 1;
        } else {
            bmv.huU = cardDetailUI.htC;
            i = 0;
        }
        bmv.cad = cardDetailUI.hBF;
        bmv.qZO = cardDetailUI.hBh;
        bmv.qZN = cardDetailUI.hBi;
        bmv.qZP = cardDetailUI.hBg;
        LinkedList linkedList = new LinkedList();
        linkedList.add(bmv);
        bnk f = l.f(cardDetailUI.hBC.hzB, cardDetailUI.hBC.hzE, cardDetailUI.hBC.hzF);
        bqs bqs = new bqs();
        bqs.soQ = cardDetailUI.dxx;
        bqs.hwj = cardDetailUI.hBJ;
        x.i("MicroMsg.CardDetailUI", "ShareCardItem upload templateId:%s", new Object[]{cardDetailUI.dxx});
        g.Eh().dpP.a(new com.tencent.mm.plugin.card.sharecard.model.g(i, linkedList, cardDetailUI.htQ.awm().rnD, cardDetailUI.hBj, f, cardDetailUI.hop, bqs), 0);
    }

    static /* synthetic */ void j(CardDetailUI cardDetailUI) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(cardDetailUI.htC);
        cardDetailUI.dO(true);
        g.Eh().dpP.a(new r(linkedList), 0);
    }

    static /* synthetic */ void k(CardDetailUI cardDetailUI) {
        cardDetailUI.dO(true);
        String awr = (cardDetailUI.hop == 6 || TextUtils.isEmpty(cardDetailUI.htQ.awr())) ? cardDetailUI.htC : cardDetailUI.htQ.awr();
        int ayE = cardDetailUI.hBC.ayE();
        bqs bqs = new bqs();
        bqs.soQ = cardDetailUI.dxx;
        bqs.hwj = cardDetailUI.hBJ;
        x.i("MicroMsg.CardDetailUI", "AcceptItemInfo templateId:%s", new Object[]{cardDetailUI.dxx});
        g.Eh().dpP.a(new o(awr, cardDetailUI.hop, cardDetailUI.hBD, cardDetailUI.hBF, cardDetailUI.hBh, cardDetailUI.hBi, cardDetailUI.hBg, ayE, bqs), 0);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.card.a.e.card_detail_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        ayh();
        d axt = am.axt();
        ActionBarActivity actionBarActivity = this.mController.tml;
        g.Eh().dpP.a(910, axt);
        am.axp().a(axt);
        com.tencent.mm.plugin.card.b.b axh = am.axh();
        if (axh.htB == null) {
            axh.htB = new ArrayList();
        }
        if (axt != null) {
            axh.htB.add(new WeakReference(axt));
        }
        axt.Wv = new WeakReference(actionBarActivity);
        am.axt().a(this);
        am.axu().a(this);
        com.tencent.mm.plugin.card.b.c axv = am.axv();
        g.Eh().dpP.a(577, axv);
        axv.htD.clear();
        axv.htE = 0;
        am.axv().a(this);
        initView();
    }

    protected void onResume() {
        super.onResume();
        ayh();
        if (this.dMm != null) {
            this.dMm.a(this.cXs, true);
        }
        this.hBC.bPd = false;
        aw.a(this, this);
        am.axt().a(this, true);
        if ((this.hBG || this.hBH) && this.htQ.avS()) {
            if (this.htQ.awf()) {
                am.axu().aX(this.htC, 2);
                Boolean bool = (Boolean) am.axt().htP.get(this.htC);
                boolean z = bool != null && bool.booleanValue();
                if (!z || TextUtils.isEmpty(am.axt().htS)) {
                    x.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
                } else {
                    x.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
                    xe(am.axt().htS);
                }
                this.hBC.hCa.d(com.tencent.mm.plugin.card.d.c.hIz);
            } else {
                am.axu().aX(this.htC, 1);
                com.tencent.mm.plugin.card.ui.view.g gVar = this.hBC.hCa;
                if (gVar != null) {
                    gVar.d(com.tencent.mm.plugin.card.d.c.hIz);
                }
            }
        }
        if (this.hBQ.huc) {
            this.hBQ.start();
        }
    }

    protected void onPause() {
        ayi();
        super.onPause();
        this.hBC.bPd = true;
        am.axt().a(this, false);
        aw.a(this, null);
        i iVar = this.hBQ;
        if (iVar.awQ()) {
            x.i("MicroMsg.CardLbsOrBluetooth", "stop");
            if (iVar.huk != null) {
                iVar.huk.awT();
            }
            iVar.awO();
            g.Eh().dpP.b(2574, iVar);
        }
    }

    public final void aou() {
        com.tencent.mm.plugin.card.ui.view.g gVar = this.hBC.hCa;
        if (gVar != null) {
            gVar.azM();
        }
    }

    protected void onDestroy() {
        am.axt().c(this);
        ayi();
        am.axt().b(this);
        am.axt().release();
        am.axu().b(this);
        am.axv().b(this);
        am.axv().release();
        e eVar = this.hBC;
        f fVar = eVar.hCo;
        fVar.htQ = null;
        fVar.htU.clear();
        eVar.hCo = null;
        j jVar = eVar.hCm;
        l.x(jVar.hGf);
        for (int size = jVar.hGm.size() - 1; size >= 0; size--) {
            l.x((Bitmap) jVar.hGm.remove(size));
        }
        jVar.hGm.clear();
        if (jVar.eZB.isShowing()) {
            jVar.eZB.dismiss();
        }
        jVar.eZB = null;
        jVar.ayT();
        jVar.fcq = null;
        jVar.htQ = null;
        eVar.hCm = null;
        if (eVar.hBZ != null) {
            eVar.hBZ.release();
        }
        eVar.hBT.geJ = null;
        com.tencent.mm.sdk.b.a.sFg.c(eVar.hCx);
        eVar.hBV.destroy();
        eVar.hBY.destroy();
        eVar.hBX.destroy();
        eVar.hCk.destroy();
        if (eVar.hCl != null) {
            eVar.hCl.destroy();
        }
        if (eVar.hCd != null) {
            eVar.hCd.destroy();
        }
        if (eVar.hCc != null) {
            eVar.hCc.destroy();
        }
        if (eVar.hCe != null) {
            eVar.hCe.destroy();
        }
        if (eVar.hCf != null) {
            eVar.hCf.destroy();
        }
        if (eVar.hCg != null) {
            eVar.hCg.destroy();
        }
        if (eVar.hCh != null) {
            eVar.hCh.destroy();
        }
        if (eVar.hCi != null) {
            eVar.hCi.destroy();
        }
        if (eVar.hCj != null) {
            eVar.hCj.destroy();
        }
        if (eVar.hCa != null) {
            eVar.hCa.destroy();
        }
        eVar.hBU = null;
        com.tencent.mm.plugin.card.b.g axy = am.axy();
        if (axy.htB != null && eVar != null) {
            for (int i = 0; i < axy.htB.size(); i++) {
                WeakReference weakReference = (WeakReference) axy.htB.get(i);
                if (weakReference != null) {
                    com.tencent.mm.plugin.card.b.g.a aVar = (com.tencent.mm.plugin.card.b.g.a) weakReference.get();
                    if (aVar != null && aVar.equals(eVar)) {
                        axy.htB.remove(weakReference);
                        break;
                    }
                }
            }
        }
        am.axy().release();
        this.hni.cancel();
        avL();
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (this.htQ != null) {
            h.mEJ.h(13219, new Object[]{"CardDetailView", Integer.valueOf(this.hop), this.htQ.awr(), this.htQ.awq(), Long.valueOf(currentTimeMillis)});
        } else {
            h.mEJ.h(13219, new Object[]{"CardDetailView", Integer.valueOf(this.hop), this.htC, this.htC, Long.valueOf(currentTimeMillis)});
        }
        if ((this.hBG || this.hBH) && this.htQ != null && this.htQ.avS()) {
            if (this.htQ.awf()) {
                am.axu().aX(this.htC, 2);
            } else {
                am.axu().aX(this.htC, 1);
            }
        }
        i iVar = this.hBQ;
        x.i("MicroMsg.CardLbsOrBluetooth", "uninit");
        if (iVar.huk != null) {
            i.a aVar2 = iVar.huk;
            if (aVar2.fKZ == null) {
                x.e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
            } else {
                ad.getContext().unregisterReceiver(aVar2.fKZ);
                aVar2.fKZ = null;
            }
            iVar.huk = null;
        }
        iVar.awO();
        iVar.hup = null;
        iVar.hub = null;
        super.onDestroy();
    }

    private void ayh() {
        g.Eh().dpP.a(645, this);
        g.Eh().dpP.a(651, this);
        g.Eh().dpP.a(563, this);
        g.Eh().dpP.a(652, this);
        g.Eh().dpP.a(560, this);
        g.Eh().dpP.a(699, this);
        g.Eh().dpP.a(902, this);
        g.Eh().dpP.a(904, this);
        g.Eh().dpP.a(1163, this);
    }

    private void ayi() {
        g.Eh().dpP.b(645, this);
        g.Eh().dpP.b(651, this);
        g.Eh().dpP.b(563, this);
        g.Eh().dpP.b(652, this);
        g.Eh().dpP.b(560, this);
        g.Eh().dpP.b(699, this);
        g.Eh().dpP.b(902, this);
        g.Eh().dpP.b(904, this);
        g.Eh().dpP.b(1163, this);
    }

    protected final void initView() {
        boolean z;
        setBackBtn(new 2(this));
        this.hni = (Vibrator) getSystemService("vibrator");
        if (this.hBC == null) {
            this.hBC = new e(this, this.mController.contentView);
            e eVar = this.hBC;
            eVar.hCm = new j(eVar.hBT);
            j jVar = eVar.hCm;
            jVar.hyW = jVar.fcq.getWindow().getAttributes().screenBrightness;
            if (jVar.eZB == null) {
                View inflate = View.inflate(jVar.fcq, com.tencent.mm.plugin.card.a.e.card_popup_window, null);
                jVar.eZD = inflate.findViewById(com.tencent.mm.plugin.card.a.d.popupwd_qrcode_layout);
                jVar.eZC = (ImageView) inflate.findViewById(com.tencent.mm.plugin.card.a.d.popupwd_qrcode_iv);
                jVar.hGg = (TextView) inflate.findViewById(com.tencent.mm.plugin.card.a.d.popupwd_qrcode_tv);
                jVar.hGh = (TextView) inflate.findViewById(com.tencent.mm.plugin.card.a.d.popupwd_qrcode_tips_tv);
                jVar.hGi = inflate.findViewById(com.tencent.mm.plugin.card.a.d.popupwd_barcode_layout);
                jVar.hGj = (ImageView) inflate.findViewById(com.tencent.mm.plugin.card.a.d.popupwd_barcode_iv);
                jVar.hGk = (MMVerticalTextView) inflate.findViewById(com.tencent.mm.plugin.card.a.d.vertical_barcode_text);
                jVar.hGl = (MMVerticalTextView) inflate.findViewById(com.tencent.mm.plugin.card.a.d.vertical_barcode_tips_text);
                inflate.setOnClickListener(new 2(jVar));
                jVar.eZB = new com.tencent.mm.ui.base.o(inflate, -1, -1, true);
                jVar.eZB.update();
                jVar.eZB.setBackgroundDrawable(new ColorDrawable(16777215));
                jVar.eZB.setOnDismissListener(new 3(jVar));
            }
            eVar.hCo = new f(eVar.hBT);
            eVar.hBT.geJ = eVar;
            com.tencent.mm.sdk.b.a.sFg.b(eVar.hCx);
            eVar = this.hBC;
            if (eVar.hBV == null) {
                eVar.hBV = new com.tencent.mm.plugin.card.ui.view.x();
                eVar.hBV.a(eVar);
            }
            if (eVar.hBX == null) {
                eVar.hBX = new com.tencent.mm.plugin.card.ui.view.o();
                eVar.hBX.a(eVar);
            }
            if (eVar.hBY == null) {
                eVar.hBY = new com.tencent.mm.plugin.card.ui.view.a();
                eVar.hBY.a(eVar);
            }
            eVar.CU = (ListView) eVar.findViewById(com.tencent.mm.plugin.card.a.d.cell_list);
            eVar.hCb = new m(eVar.hBT.mController.tml);
            eVar.hCb.hGS = eVar.eZF;
            eVar.CU.setAdapter(eVar.hCb);
            eVar.hCb.notifyDataSetChanged();
            eVar.CU.setOnItemClickListener(new 1(eVar));
            x.i("MicroMsg.CardDetailUIContoller", "initMenu");
            eVar.hBT.hBw.setOnClickListener(new 5(eVar));
            eVar.bo = (LinearLayout) eVar.findViewById(com.tencent.mm.plugin.card.a.d.header_view);
            eVar.hCk = new com.tencent.mm.plugin.card.ui.view.d();
            eVar.hCk.a(eVar);
            eVar.hCm.htQ = eVar.htQ;
        }
        int intExtra = getIntent().getIntExtra("key_from_scene", -1);
        x.i("MicroMsg.CardDetailUI", "scene:%d", new Object[]{Integer.valueOf(intExtra)});
        String stringExtra;
        com.tencent.mm.plugin.card.model.d xQ;
        if (intExtra == 2 || intExtra == 6 || intExtra == 5) {
            this.hop = intExtra;
            stringExtra = getIntent().getStringExtra("key_card_app_msg");
            xQ = com.tencent.mm.plugin.card.d.g.xQ(stringExtra);
            if (xQ != null) {
                this.htC = xQ.cac;
                this.hBD = xQ.hwf;
                this.hBF = xQ.cad;
                int i = xQ.hwi;
                x.i("MicroMsg.CardDetailUI", "scene is " + intExtra + ", isRecommend is " + i);
                if (i == 1 && intExtra == 2) {
                    this.hop = 23;
                }
                this.hBJ = xQ.hwj;
                x.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.hBJ);
            }
            this.hBE = com.tencent.mm.plugin.card.d.g.xR(stringExtra);
        } else if (l.oa(intExtra) || intExtra == 0 || intExtra == 1 || intExtra == 3 || intExtra == 4 || intExtra == 9 || intExtra == 12 || intExtra == 15 || intExtra == 17 || intExtra == 21) {
            this.hop = intExtra;
            this.htC = getIntent().getStringExtra("key_card_id");
            this.hBF = getIntent().getStringExtra("key_card_ext");
            this.hvg = getIntent().getBooleanExtra("key_is_share_card", false);
            this.hBg = getIntent().getIntExtra("key_stastic_scene", 0);
            this.hBj = getIntent().getStringExtra("key_consumed_card_id");
            if (intExtra == 7 || intExtra == 16) {
                this.hBh = getIntent().getStringExtra("src_username");
                this.hBi = getIntent().getStringExtra("js_url");
                this.dxx = getIntent().getStringExtra("key_template_id");
            } else if (this.hvg && intExtra == 3) {
                this.huQ = getIntent().getStringExtra("key_card_tp_id");
                this.htC = com.tencent.mm.plugin.card.sharecard.a.b.cd(this.htC, this.huQ);
            } else if (intExtra == 8) {
                this.hBL = getIntent().getBooleanExtra("key_is_sms_add_card", false);
            }
        } else if (intExtra == 50 || intExtra == 27) {
            this.hop = getIntent().getIntExtra("key_previous_scene", 50);
            if (!(this.hop == 26 || this.hop == 27)) {
                this.hop = 3;
            }
            this.dxx = getIntent().getStringExtra("key_template_id");
            if (this.hop == 27) {
                b bVar = (b) getIntent().getParcelableExtra("key_card_info");
                if (bVar != null) {
                    this.htQ = bVar;
                    this.htC = this.htQ.awq();
                    ayj();
                    aym();
                    if (this.htQ.awg()) {
                        am.axv().xc(this.htQ.awq());
                    }
                    axM();
                }
                ayk();
                l.azQ();
            } else {
                LinkedList bb = k.bb(getIntent().getStringExtra("card_list"), this.hop);
                if (bb == null || bb.size() == 0) {
                    x.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
                    dS(true);
                } else {
                    dO(true);
                    this.htC = ((lg) bb.get(0)).huU;
                    intExtra = getIntent().getIntExtra("key_previous_scene", 51);
                    bqs bqs = new bqs();
                    bqs.soQ = this.dxx;
                    x.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[]{this.dxx});
                    g.Eh().dpP.a(new t(bb, bqs, intExtra), 0);
                }
                ayj();
            }
            this.hBC.a(this.htQ, this.hBK, this.htW);
            this.hBC.hCu = new 3(this);
            x.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
            this.hAj = z;
            if (!this.hAj) {
                this.dMm = c.OB();
                avJ();
            }
        } else if (intExtra == 51) {
            if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {
                this.hop = 26;
            } else {
                this.hop = 3;
            }
            this.htC = getIntent().getStringExtra("key_card_id");
            this.htQ = am.axn().hts;
            if (this.htQ == null) {
                this.htQ = am.axi().xm(this.htC);
            }
            ayj();
            if (this.htQ == null) {
                x.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
                dS(true);
            } else {
                aym();
                axM();
                ayk();
                if (this.htQ.awg()) {
                    am.axv().xc(this.htQ.awq());
                }
            }
            this.hBC.a(this.htQ, this.hBK, this.htW);
            this.hBC.hCu = new 3(this);
            x.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
            this.hAj = z;
            if (!this.hAj) {
                this.dMm = c.OB();
                avJ();
            }
        } else if (intExtra == 26) {
            this.hop = intExtra;
            this.htC = getIntent().getStringExtra("key_card_id");
            this.hBF = getIntent().getStringExtra("key_card_ext");
        } else {
            this.hop = intExtra;
            stringExtra = getIntent().getStringExtra("key_card_app_msg");
            xQ = com.tencent.mm.plugin.card.d.g.xQ(stringExtra);
            if (xQ != null) {
                this.htC = xQ.cac;
                this.hBD = xQ.hwf;
                this.hBF = xQ.cad;
            }
            this.hBE = com.tencent.mm.plugin.card.d.g.xR(stringExtra);
        }
        ayj();
        if (TextUtils.isEmpty(this.htC)) {
            x.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
            dS(true);
        } else {
            if (intExtra == 2 || intExtra == 6 || ((intExtra == 4 && !this.hvg) || intExtra == 5 || intExtra == 17 || intExtra == 21 || intExtra == 23)) {
                z = true;
            } else if (intExtra == 15) {
                Object value = am.axn().getValue("key_accept_card_info");
                if (value == null || !(value instanceof CardInfo)) {
                    z = true;
                } else {
                    this.htQ = (CardInfo) value;
                    z = false;
                }
            } else if (this.hvg) {
                this.htQ = am.axq().xC(this.htC);
                z = false;
            } else {
                this.htQ = am.axi().xm(this.htC);
                z = false;
            }
            if (z || this.htQ == null) {
                x.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.htC + " isShareCard is " + this.hvg);
                dO(true);
                if (this.hvg) {
                    ayn();
                } else {
                    ayl();
                }
            } else {
                x.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.htC);
                la awp = this.htQ.awp();
                if (awp != null) {
                    this.htW = new ArrayList();
                    this.htW.add(awp);
                }
                axM();
                if (this.htQ.awg()) {
                    am.axv().xc(this.htQ.awq());
                }
                if (this.hvg) {
                    this.hBM = true;
                    z = true;
                } else {
                    if (((long) ((int) (System.currentTimeMillis() / 1000))) - this.htQ.awt() >= 86400) {
                        this.hBM = true;
                        z = true;
                    } else if (this.htQ.awd()) {
                        this.hBM = true;
                        z = true;
                    }
                }
                if (z) {
                    x.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.htC + " isShareCard is " + this.hvg);
                    if (this.hvg) {
                        ayn();
                    } else {
                        ayl();
                    }
                } else {
                    aym();
                }
                ayk();
            }
        }
        this.hBC.a(this.htQ, this.hBK, this.htW);
        this.hBC.hCu = new 3(this);
        x.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.hAj = z;
        if (!this.hAj) {
            this.dMm = c.OB();
            avJ();
        }
    }

    private void ayj() {
        this.hza = this.hop;
        this.hBK = new e.a();
        this.hBK.hop = this.hop;
        this.hBK.hza = this.hza;
        this.hBK.htC = this.htC;
        this.hBK.hBD = this.hBD;
        this.hBK.hBF = this.hBF;
        this.hBK.hBE = this.hBE;
        this.hBK.hBh = this.hBh;
        this.hBK.hBi = this.hBi;
        this.hBK.hvg = this.hvg;
        this.hBK.hCB = getIntent().getIntExtra("key_from_appbrand_type", 0);
    }

    private void ayk() {
        int i = 1;
        if (!this.hBN && this.htQ != null) {
            this.hBN = true;
            h hVar;
            Object[] objArr;
            if (this.hvg) {
                hVar = h.mEJ;
                objArr = new Object[9];
                objArr[0] = "ShareCardDetailUI";
                objArr[1] = Integer.valueOf(this.htQ.awm().huV);
                objArr[2] = this.htQ.awr();
                objArr[3] = this.htQ.awq();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(this.hza);
                objArr[6] = this.hBD;
                if (!this.htQ.awk()) {
                    i = 0;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = "";
                hVar.h(11324, objArr);
                return;
            }
            hVar = h.mEJ;
            objArr = new Object[9];
            objArr[0] = "CardDetailView";
            objArr[1] = Integer.valueOf(this.htQ.awm().huV);
            objArr[2] = this.htQ.awr();
            objArr[3] = this.htQ.awq();
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(this.hza);
            objArr[6] = this.hBD;
            if (!this.htQ.awk()) {
                i = 0;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "";
            hVar.h(11324, objArr);
        }
    }

    private void axM() {
        this.hBK.hop = this.hop;
        this.hBK.hza = this.hza;
        this.hBK.htC = this.htC;
        this.hBC.a(this.htQ, this.hBK, this.htW);
        this.hBC.axM();
        am.axt().htQ = this.htQ;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + i + " errCode = " + i2);
        int i3;
        if (i == 0 && i2 == 0) {
            dO(false);
            b bVar;
            CardInfo cardInfo;
            Object obj;
            int i4;
            String str2;
            Integer num;
            Intent intent;
            ShareCardInfo xC;
            if (lVar instanceof aa) {
                Object obj2 = ((aa) lVar).hwU;
                if (TextUtils.isEmpty(obj2)) {
                    x.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
                    return;
                }
                bVar = this.htQ;
                cardInfo = new CardInfo();
                com.tencent.mm.plugin.card.d.f.a(cardInfo, obj2);
                if (!TextUtils.isEmpty(cardInfo.awq())) {
                    this.htC = cardInfo.awq();
                } else if (TextUtils.isEmpty(cardInfo.awq()) && !this.htC.equals(cardInfo.awr())) {
                    x.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[]{this.htC, cardInfo.awr()});
                    return;
                }
                this.htQ = cardInfo;
                aym();
                if (this.hop == 3) {
                    if (bVar != null) {
                        ((CardInfo) this.htQ).field_stickyAnnouncement = ((CardInfo) bVar).field_stickyAnnouncement;
                        ((CardInfo) this.htQ).field_stickyEndTime = ((CardInfo) bVar).field_stickyEndTime;
                        ((CardInfo) this.htQ).field_stickyIndex = ((CardInfo) bVar).field_stickyIndex;
                        ((CardInfo) this.htQ).field_label_wording = ((CardInfo) bVar).field_label_wording;
                        this.htQ.a(bVar.awp());
                    }
                    if (this.hBM) {
                        l.j(this.htQ);
                    } else {
                        x.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
                    }
                }
                axM();
                ayk();
                if (this.htQ.awg()) {
                    am.axv().xc(this.htQ.awq());
                }
                this.hBQ.a(this, this.htC, this.htQ, this.cXm, this.cXn);
                return;
            } else if (lVar instanceof o) {
                if (this.hza == 26) {
                    dO(false);
                }
                obj = ((o) lVar).hwU;
                i4 = ((o) lVar).hwV;
                str2 = ((o) lVar).hwW;
                if (i4 != 0) {
                    b(i2, str, i4, str2);
                } else {
                    com.tencent.mm.ui.base.h.bA(this, getResources().getString(com.tencent.mm.plugin.card.a.g.card_add_card_pack));
                }
                if (TextUtils.isEmpty(obj)) {
                    x.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
                    return;
                }
                this.hop = 3;
                if (this.htQ == null) {
                    this.htQ = new CardInfo();
                }
                com.tencent.mm.plugin.card.d.f.a((CardInfo) this.htQ, obj);
                if (!TextUtils.isEmpty(this.htQ.awq())) {
                    this.htC = this.htQ.awq();
                }
                if (this.hBC.ayE() == 1) {
                    e eVar = this.hBC;
                    if (eVar.hCo != null) {
                        f fVar = eVar.hCo;
                        if (fVar.htV != null) {
                            fVar.htV.hvj = false;
                        }
                    }
                }
                if (this.hza != 26) {
                    aym();
                    axM();
                }
                l.azQ();
                b bVar2 = this.htQ;
                if (bVar2.avT()) {
                    num = (Integer) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sQf, Integer.valueOf(0));
                    if (num == null || num.intValue() != 1) {
                        g.Ei().DT().a(com.tencent.mm.storage.aa.a.sQf, Integer.valueOf(1));
                    }
                    this.hBP = this.htQ.aww();
                    if (this.hza != 7 || this.hza == 16) {
                        intent = new Intent();
                        intent.putExtra("key_code", this.hBP);
                        setResult(-1, intent);
                        nT(-1);
                    } else if (!this.hBL && this.hza == 8) {
                        dS(true);
                    } else if (this.hza == 26 && i4 == 0) {
                        dS(true);
                    }
                    if (this.htQ.awg()) {
                        am.axv().xc(this.htQ.awq());
                    }
                    this.hBQ.a(this, this.htC, this.htQ, this.cXm, this.cXn);
                    return;
                }
                num = (Integer) g.Ei().DT().get(282884, null);
                if (num == null || num.intValue() != 1) {
                    g.Ei().DT().set(282884, Integer.valueOf(1));
                }
                this.hBP = this.htQ.aww();
                if (this.hza != 7) {
                }
                intent = new Intent();
                intent.putExtra("key_code", this.hBP);
                setResult(-1, intent);
                nT(-1);
                if (this.htQ.awg()) {
                    am.axv().xc(this.htQ.awq());
                }
                this.hBQ.a(this, this.htC, this.htQ, this.cXm, this.cXn);
                return;
                if (l.azT()) {
                    com.tencent.mm.plugin.card.d.d.c(this, com.tencent.mm.plugin.card.a.e.card_show_accepted_tips_for_share, com.tencent.mm.plugin.card.a.g.card_accepted_title_for_share, bVar2.awm().hwg);
                } else {
                    com.tencent.mm.plugin.card.d.d.c(this, com.tencent.mm.plugin.card.a.e.card_show_accepted_tips, com.tencent.mm.plugin.card.a.g.card_accepted_title, bVar2.awm().hwg);
                }
                this.hBP = this.htQ.aww();
                if (this.hza != 7) {
                }
                intent = new Intent();
                intent.putExtra("key_code", this.hBP);
                setResult(-1, intent);
                nT(-1);
                if (this.htQ.awg()) {
                    am.axv().xc(this.htQ.awq());
                }
                this.hBQ.a(this, this.htC, this.htQ, this.cXm, this.cXn);
                return;
            } else if (lVar instanceof v) {
                this.htW = ((v) lVar).hxd;
                if (this.htQ != null && this.htW != null && this.htW.size() > 0) {
                    this.htQ.a((la) this.htW.get(0));
                    axM();
                    if (this.htQ.avS()) {
                        ShareCardInfo xC2 = am.axq().xC(this.htC);
                        if (xC2 != null) {
                            xC2.a((la) this.htW.get(0));
                            am.axq().c(xC2, new String[]{this.htC});
                            return;
                        }
                        return;
                    }
                    cardInfo = am.axi().xm(this.htC);
                    if (cardInfo != null) {
                        cardInfo.a((la) this.htW.get(0));
                        am.axi().c(cardInfo, new String[]{this.htC});
                        return;
                    }
                    return;
                } else if (this.htQ != null && this.htW == null) {
                    this.htQ.a(null);
                    axM();
                    if (this.htQ.avS()) {
                        xC = am.axq().xC(this.htC);
                        if (xC != null) {
                            xC.a(null);
                            am.axq().c(xC, new String[]{this.htC});
                            return;
                        }
                        return;
                    }
                    CardInfo xm = am.axi().xm(this.htC);
                    if (xm != null) {
                        xm.a(null);
                        am.axi().c(xm, new String[]{this.htC});
                        return;
                    }
                    return;
                } else {
                    return;
                }
            } else if (lVar instanceof af) {
                i3 = ((af) lVar).hwV;
                str2 = ((af) lVar).hwW;
                if (i3 == 10000) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = getString(com.tencent.mm.plugin.card.a.g.card_gift_failed_tips);
                    }
                    com.tencent.mm.plugin.card.d.d.b(this, str2);
                    return;
                }
                this.hBF = ((af) lVar).cad;
                dR(true);
                kx awn = this.htQ.awn();
                awn.status = 3;
                this.htQ.a(awn);
                l.j(this.htQ);
                axM();
                if (this.hza == 3) {
                    dS(true);
                    return;
                } else if (this.hza == 15) {
                    com.tencent.mm.sdk.b.a.sFg.m(new pf());
                    return;
                } else {
                    return;
                }
            } else if (lVar instanceof r) {
                com.tencent.mm.ui.base.h.bA(this, getResources().getString(com.tencent.mm.plugin.card.a.g.card_delete_success_tips));
                am.axh();
                com.tencent.mm.plugin.card.b.b.nG(4);
                dS(true);
                return;
            } else if (lVar instanceof t) {
                LinkedList linkedList = ((t) lVar).hxb;
                if (linkedList != null && linkedList.size() > 0) {
                    b bVar3 = (b) linkedList.get(0);
                    if (bVar3 == null || this.htC.equals(bVar3.awr())) {
                        this.htQ = bVar3;
                        if (this.htQ != null) {
                            this.htC = this.htQ.awq();
                            aym();
                            if (this.htQ.awg()) {
                                am.axv().xc(this.htQ.awq());
                            }
                        }
                        if (this.hop == 26) {
                            this.hop = 3;
                        }
                        axM();
                    } else {
                        x.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[]{this.htC, bVar3.awr()});
                        return;
                    }
                }
                ayk();
                l.azQ();
                return;
            } else if (lVar instanceof com.tencent.mm.plugin.card.sharecard.model.g) {
                obj = ((com.tencent.mm.plugin.card.sharecard.model.g) lVar).hwU;
                i4 = ((com.tencent.mm.plugin.card.sharecard.model.g) lVar).hwV;
                str2 = ((com.tencent.mm.plugin.card.sharecard.model.g) lVar).hwW;
                if (i4 != 0) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = getString(com.tencent.mm.plugin.card.a.g.card_accept_fail_tips);
                    }
                    com.tencent.mm.plugin.card.d.d.b(this, str2);
                    x.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", new Object[]{str2});
                    return;
                }
                com.tencent.mm.ui.base.h.bA(this, getResources().getString(com.tencent.mm.plugin.card.a.g.card_accept_success_tips));
                if (TextUtils.isEmpty(obj)) {
                    x.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
                    return;
                }
                this.hop = 3;
                if (this.htQ == null) {
                    this.htQ = new ShareCardInfo();
                } else if (this.htQ instanceof CardInfo) {
                    this.htQ = new ShareCardInfo();
                }
                com.tencent.mm.plugin.card.d.f.a((ShareCardInfo) this.htQ, obj);
                xC = (ShareCardInfo) this.htQ;
                if (TextUtils.isEmpty(obj)) {
                    x.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
                } else {
                    try {
                        JSONArray optJSONArray = new JSONObject(obj).optJSONArray("card_list");
                        if (optJSONArray != null) {
                            xC.huZ = optJSONArray.optJSONObject(0).optString("encrypt_code");
                            x.i("MicroMsg.CardInfoParser", "encrypt_code:" + xC.huZ);
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                        x.e("MicroMsg.CardInfoParser", e.getMessage());
                    }
                }
                if (!TextUtils.isEmpty(this.htQ.awq())) {
                    this.htC = this.htQ.awq();
                }
                if (TextUtils.isEmpty(this.htQ.aws())) {
                    ((ShareCardInfo) this.htQ).field_from_username = q.GF();
                }
                l.a((ShareCardInfo) this.htQ);
                aym();
                axM();
                l.azS();
                am.axp().auM();
                this.hBP = this.htQ.aww();
                if (this.hza == 7 || this.hza == 16) {
                    intent = new Intent();
                    intent.putExtra("key_code", this.hBP);
                    setResult(-1, intent);
                    nT(-1);
                } else if (!this.hBL && this.hza == 8) {
                    dS(true);
                }
                num = (Integer) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sQd, Integer.valueOf(0));
                if (num == null || num.intValue() != 1) {
                    g.Ei().DT().a(com.tencent.mm.storage.aa.a.sQd, Integer.valueOf(1));
                    com.tencent.mm.plugin.card.d.d.c(this, com.tencent.mm.plugin.card.a.e.card_show_share_card_tips, com.tencent.mm.plugin.card.a.g.card_share_card_tips_title, "");
                }
                if (this.htQ.awg()) {
                    am.axv().xc(this.htQ.awq());
                    return;
                }
                return;
            } else if (lVar instanceof com.tencent.mm.plugin.card.sharecard.model.c) {
                obj = ((com.tencent.mm.plugin.card.sharecard.model.c) lVar).hwU;
                if (TextUtils.isEmpty(obj)) {
                    x.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
                    return;
                }
                bVar = this.htQ;
                this.htQ = new ShareCardInfo();
                xC = (ShareCardInfo) this.htQ;
                if (TextUtils.isEmpty(obj)) {
                    x.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
                } else {
                    try {
                        com.tencent.mm.plugin.card.d.f.a(xC, new JSONObject(obj));
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
                    }
                }
                if (bVar != null) {
                    if (!TextUtils.isEmpty(bVar.aws())) {
                        ((ShareCardInfo) this.htQ).field_from_username = ((ShareCardInfo) bVar).field_from_username;
                    }
                    ((ShareCardInfo) this.htQ).field_app_id = ((ShareCardInfo) bVar).field_app_id;
                    ((ShareCardInfo) this.htQ).field_consumer = ((ShareCardInfo) bVar).field_consumer;
                    ((ShareCardInfo) this.htQ).field_share_time = ((ShareCardInfo) bVar).field_share_time;
                    ((ShareCardInfo) this.htQ).field_updateTime = ((ShareCardInfo) bVar).field_updateTime;
                    ((ShareCardInfo) this.htQ).field_begin_time = ((ShareCardInfo) bVar).field_begin_time;
                    ((ShareCardInfo) this.htQ).field_end_time = ((ShareCardInfo) bVar).field_end_time;
                    ((ShareCardInfo) this.htQ).field_block_mask = ((ShareCardInfo) bVar).field_block_mask;
                    this.htQ.a(bVar.awp());
                    ((ShareCardInfo) this.htQ).field_categoryType = ((ShareCardInfo) bVar).field_categoryType;
                    ((ShareCardInfo) this.htQ).field_itemIndex = ((ShareCardInfo) bVar).field_itemIndex;
                    if (((ShareCardInfo) bVar).field_status != ((ShareCardInfo) this.htQ).field_status) {
                        x.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo) this.htQ).field_status);
                        com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.htQ);
                    }
                }
                if (!TextUtils.isEmpty(this.htQ.awq())) {
                    this.htC = this.htQ.awq();
                }
                axM();
                aym();
                ayk();
                if (this.hop == 3) {
                    if (this.hBM) {
                        l.j(this.htQ);
                    } else {
                        x.e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
                    }
                }
                if (this.htQ.awg()) {
                    am.axv().xc(this.htQ.awq());
                    return;
                }
                return;
            } else if (!(lVar instanceof com.tencent.mm.plugin.card.sharecard.model.a)) {
                return;
            } else {
                if (((com.tencent.mm.plugin.card.sharecard.model.a) lVar).hwV != 0) {
                    com.tencent.mm.plugin.card.d.d.b(this, getString(com.tencent.mm.plugin.card.a.g.card_delete_fail_tips));
                    return;
                }
                x.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.htQ.awq());
                com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.htQ);
                com.tencent.mm.ui.base.h.bA(this, getResources().getString(com.tencent.mm.plugin.card.a.g.card_delete_success_tips));
                am.axp().axD();
                dS(true);
                return;
            }
        }
        CharSequence charSequence;
        x.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + i + " errCode = " + i2 + " cmd:" + lVar.getType());
        dO(false);
        Object charSequence2;
        if (lVar instanceof af) {
            dR(false);
            i3 = ((af) lVar).hwV;
            charSequence2 = ((af) lVar).hwW;
            if (i3 == 10000) {
                if (TextUtils.isEmpty(charSequence2)) {
                    charSequence2 = getString(com.tencent.mm.plugin.card.a.g.card_gift_failed_tips);
                }
            }
            charSequence2 = str;
        } else if (lVar instanceof o) {
            nT(0);
            b(i2, str, ((o) lVar).hwV, ((o) lVar).hwW);
            return;
        } else {
            if (lVar instanceof v) {
                return;
            }
            charSequence2 = str;
        }
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = getString(com.tencent.mm.plugin.card.a.g.card_wallet_unknown_err);
        }
        Toast.makeText(this.mController.tml, charSequence2, 0).show();
    }

    private void b(int i, String str, int i2, String str2) {
        x.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + i + " errMsg = " + str + " ret_code:" + i2 + " ret_msg:" + str2);
        if (i2 == 10000) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(com.tencent.mm.plugin.card.a.g.card_accept_late);
            }
            this.htQ.awn().status = 4;
            axM();
        } else if (i2 == 10001) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(com.tencent.mm.plugin.card.a.g.card_accept_time_out);
            }
            this.htQ.awn().status = 5;
            axM();
        } else if (i2 == 10002) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(com.tencent.mm.plugin.card.a.g.card_no_stock);
            }
        } else if (TextUtils.isEmpty(str2)) {
            str2 = getString(com.tencent.mm.plugin.card.a.g.card_accept_fail);
        }
        com.tencent.mm.plugin.card.d.d.b(this, str2);
    }

    private void dO(boolean z) {
        if (z) {
            this.fUo = p.b(this, getString(com.tencent.mm.plugin.card.a.g.loading_tips), true, 0, null);
        } else if (this.fUo != null && this.fUo.isShowing()) {
            this.fUo.dismiss();
            this.fUo = null;
        }
    }

    private void dR(boolean z) {
        if (z) {
            l.ck(this.hBC.hCq, this.hBC.hCp);
        }
    }

    private void ayl() {
        bqs bqs = new bqs();
        bqs.soQ = this.dxx;
        bqs.hwj = this.hBJ;
        x.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", new Object[]{this.dxx});
        g.Eh().dpP.a(new aa(this.htC, this.hop, this.hBD, this.hBF, this.hBh, this.hBi, this.hBg, this.hBj, bqs), 0);
    }

    private void aym() {
        String awr;
        if (!TextUtils.isEmpty(this.htQ.awr())) {
            awr = this.htQ.awr();
        } else if (TextUtils.isEmpty(this.htC)) {
            x.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
            return;
        } else {
            awr = this.htC;
        }
        if (this.htQ != null && this.htQ.awm().rnK == 1) {
            float f = this.cXm;
            float f2 = this.cXn;
            if (f == -85.0f || f2 == -1000.0f) {
                f = am.axo().cXm;
                f2 = am.axo().cXn;
            }
            g.Eh().dpP.a(new v(awr, f2, f, this.htQ.awq()), 0);
        } else if (this.htQ == null || this.htQ.awm().rnK <= 1) {
            if (this.htQ != null) {
                this.htQ.a(null);
                axM();
                if (this.htQ.avS()) {
                    ShareCardInfo xC = am.axq().xC(this.htC);
                    if (xC != null) {
                        xC.a(null);
                        am.axq().c(xC, new String[]{this.htC});
                        return;
                    }
                    return;
                }
                CardInfo xm = am.axi().xm(this.htC);
                if (xm != null) {
                    xm.a(null);
                    am.axi().c(xm, new String[]{this.htC});
                }
            }
        } else if (this.cXm != -85.0f && this.cXn != -1000.0f) {
            this.hBO = false;
            g.Eh().dpP.a(new v(awr, this.cXn, this.cXm, this.htQ.awq()), 0);
        } else if (!this.hBO) {
            this.hBO = true;
            if (this.hAj) {
                avJ();
            }
        }
    }

    private void ayn() {
        g.Eh().dpP.a(new com.tencent.mm.plugin.card.sharecard.model.c(this.htC), 0);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
            dS(false);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void dS(boolean z) {
        if ((this.hza == 7 || this.hza == 8 || this.hza == 16 || this.hza == 26) && this.hop == 3) {
            Intent intent = new Intent();
            intent.putExtra("key_code", this.hBP);
            setResult(-1, intent);
            if (z) {
                finish();
            }
        } else if ((this.hza == 7 && this.hop == 7) || ((this.hza == 16 && this.hop == 16) || ((this.hza == 8 && this.hop == 8) || (this.hza == 26 && this.hop == 26)))) {
            setResult(0);
            if (z) {
                finish();
            }
        } else if (z) {
            finish();
        }
    }

    private void nT(int i) {
        if (this.hza == 7 || this.hza == 16) {
            LinkedList linkedList = new LinkedList();
            com.tencent.mm.plugin.card.model.e eVar = new com.tencent.mm.plugin.card.model.e();
            eVar.huU = this.htQ.awr();
            eVar.cad = this.hBF;
            eVar.code = this.hBP;
            linkedList.add(eVar);
            com.tencent.mm.g.a.b bVar = new com.tencent.mm.g.a.b();
            bVar.bFZ.bjW = i;
            if (i == -1) {
                bVar.bFZ.bGa = com.tencent.mm.plugin.card.d.h.a(linkedList, true, this.hza);
            } else {
                bVar.bFZ.bGa = com.tencent.mm.plugin.card.d.h.a(linkedList, false, this.hza);
            }
            com.tencent.mm.sdk.b.a.sFg.m(bVar);
            return;
        }
        x.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
    }

    private void avJ() {
        if (this.dMm == null) {
            this.dMm = c.OB();
        }
        this.dMm.a(this.cXs, true);
    }

    private void avL() {
        if (this.dMm != null) {
            this.dMm.c(this.cXs);
        }
    }

    private void axV() {
        this.dMm = c.OB();
        avJ();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.CardDetailUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case s$l.AppCompatTheme_listPreferredItemHeight /*69*/:
                if (iArr[0] == 0) {
                    x.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.hAj);
                    if (!this.hAj) {
                        this.hAj = true;
                        axV();
                        return;
                    }
                    return;
                }
                com.tencent.mm.ui.base.h.a(this, getString(com.tencent.mm.plugin.card.a.g.permission_location_request_again_msg), getString(com.tencent.mm.plugin.card.a.g.permission_tips_title), getString(com.tencent.mm.plugin.card.a.g.jump_to_settings), getString(com.tencent.mm.plugin.card.a.g.confirm_dialog_cancel), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        CardDetailUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, null);
                return;
            default:
                return;
        }
    }

    private synchronized void xd(String str) {
        if (this.hzn) {
            x.e("MicroMsg.CardDetailUI", "has start CardConsumeSuccessUI!");
        } else {
            x.i("MicroMsg.CardDetailUI", "startConsumedSuccUI() ");
            this.hzn = true;
            Intent intent = new Intent(this, CardConsumeSuccessUI.class);
            intent.putExtra("KEY_CARD_ID", this.htQ.awq());
            intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
            intent.putExtra("KEY_CARD_COLOR", this.htQ.awm().dxh);
            intent.putExtra("key_stastic_scene", this.hop);
            intent.putExtra("key_from_scene", 0);
            startActivity(intent);
        }
    }

    public final void f(b bVar) {
        if (bVar == null) {
            x.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
        } else if (this.htQ == null || !this.htQ.awq().equals(bVar.awq())) {
            x.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
        } else if (this.hBC.ayF()) {
            x.i("MicroMsg.CardDetailUI", "onDataChange");
            this.htQ = bVar;
            this.htC = this.htQ.awq();
            if (this.htQ.awg() && am.axv().isEmpty()) {
                am.axv().xc(this.htQ.awq());
            }
            axM();
        } else {
            x.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
        }
    }

    public final void awJ() {
        x.i("MicroMsg.CardDetailUI", "onVibrate");
        this.hni.vibrate(300);
    }

    public final void awK() {
        x.i("MicroMsg.CardDetailUI", "onFinishUI");
    }

    public final void xe(final String str) {
        if (this.hBC.ayF()) {
            x.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
            this.mHandler.post(new Runnable() {
                public final void run() {
                    CardDetailUI.this.xd(str);
                }
            });
            return;
        }
        x.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
    }

    public final void b(String str, j.b bVar) {
        if (TextUtils.isEmpty(str) || str.equals(this.htC)) {
            dO(false);
            x.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
            x.i("MicroMsg.CardDetailUI", "markSucc:" + bVar.huI + " markCardId: " + bVar.huJ);
            this.hBH = false;
            if (bVar.huI != 1) {
                this.hBG = false;
                com.tencent.mm.plugin.card.d.d.b(this, getString(com.tencent.mm.plugin.card.a.g.card_mark_used));
                return;
            } else if (TextUtils.isEmpty(bVar.huJ) || this.htQ.awq().equals(bVar.huJ)) {
                x.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
                this.hBG = true;
                a(bVar);
                return;
            } else {
                x.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
                if (this.htQ.avS()) {
                    ShareCardInfo xC = am.axq().xC(bVar.huJ);
                    if (xC != null) {
                        this.htQ = xC;
                        this.htC = bVar.huJ;
                        axM();
                        am.axt().d(this.htQ);
                        x.i("MicroMsg.CardDetailUI", "update the mCardInfo");
                        this.hBG = true;
                        a(bVar);
                        return;
                    }
                    x.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
                    com.tencent.mm.plugin.card.d.d.b(this, getString(com.tencent.mm.plugin.card.a.g.card_mark_failed_tips));
                    this.hBG = false;
                    return;
                }
                return;
            }
        }
        x.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
    }

    public final void bZ(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.equals(this.htC)) {
            x.i("MicroMsg.CardDetailUI", "onMarkFail()");
            this.hBG = false;
            this.hBH = false;
            dO(false);
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(com.tencent.mm.plugin.card.a.g.card_mark_failed_tips);
            }
            com.tencent.mm.plugin.card.d.d.b(this, str2);
            return;
        }
        x.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
    }

    public final void xh(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.htC)) {
            this.hBG = false;
        } else {
            x.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
        }
    }

    private void a(j.b bVar) {
        if (this.hBC.bPd) {
            x.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
            return;
        }
        x.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
        this.hBC.a(this.hBI, bVar, true);
    }

    public final void awE() {
        x.i("MicroMsg.CardDetailUI", "code change");
        if (this.hBC.hCa instanceof com.tencent.mm.plugin.card.ui.view.q) {
            ((com.tencent.mm.plugin.card.ui.view.q) this.hBC.hCa).hGn = am.axv().getCode();
            this.hBC.axM();
        }
    }

    public final void xb(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.tencent.mm.plugin.card.d.d.a(this, str, true);
        }
    }

    public final void onSuccess() {
        if (this.hBC.hCa instanceof com.tencent.mm.plugin.card.ui.view.q) {
            ((com.tencent.mm.plugin.card.ui.view.q) this.hBC.hCa).hGn = am.axv().getCode();
            this.hBC.axM();
        }
        x.i("MicroMsg.CardDetailUI", "code get success");
    }
}
