package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.ArrayList;

public class ShareCardListUI extends CardBaseUI implements d, a {
    private boolean hAa = false;
    private boolean hAb = true;
    private boolean hAc = true;
    private boolean hAd = false;
    private String hAe = "";
    private boolean hAf = false;
    private boolean hAg = false;
    private boolean hAh = false;
    private int hAi = 0;
    private boolean hAj = false;
    private long hAk = 0;
    boolean hAl = false;
    private long hAm = 0;
    private final long hAn = 500;
    private boolean hAo = false;
    private boolean hAp = false;
    private String hvN = null;
    private b.a hye = null;
    private b hzM;
    private f hzV;
    private e hzW;
    private i hzX;
    private boolean hzY = false;
    private boolean hzZ = true;
    private long mStartTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartTime = currentTimeMillis;
        this.hAk = currentTimeMillis;
        initView();
        g.Eh().dpP.a(1164, this);
        am.axp().a(this);
        aya();
        am.axq().c(this);
    }

    protected void onDestroy() {
        if (this.hAj) {
            avL();
        }
        this.hzV.hzM = null;
        this.hzW.hzM = null;
        this.hzM.hye = null;
        g.Eh().dpP.b(1164, this);
        am.axp().b(this);
        b.axJ();
        am.axq().d(this);
        long currentTimeMillis = System.currentTimeMillis() - this.hAk;
        if (TextUtils.isEmpty(this.hvN)) {
            h.mEJ.h(13219, new Object[]{"ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(currentTimeMillis)});
        } else {
            h.mEJ.h(13219, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(currentTimeMillis)});
        }
        super.onDestroy();
    }

    protected void onResume() {
        dP(true);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime != 0) {
            int i = (int) (currentTimeMillis - this.mStartTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(56);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(57);
            iDKey2.SetValue((long) i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.mEJ.b(arrayList, true);
            this.mStartTime = 0;
        }
        super.onResume();
    }

    private void dP(boolean z) {
        x.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", new Object[]{Boolean.valueOf(this.hzZ), Boolean.valueOf(z)});
        if (this.hzZ) {
            this.hzZ = false;
            this.hAf = false;
            this.hAb = true;
            this.hAe = "";
            x.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
            if (!z) {
                axZ();
            } else if (this.hAj && this.hAl) {
                avK();
            }
        }
        axW();
    }

    protected void onPause() {
        super.onPause();
        this.hzZ = false;
        this.hAa = true;
    }

    protected final BaseAdapter avF() {
        return new c(this.mController.tml);
    }

    protected final void initView() {
        super.initView();
        x.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.hAj = r0;
        if (this.hAj) {
            axV();
            return;
        }
        x.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
        axY();
    }

    private void axV() {
        x.d("MicroMsg.ShareCardListUI", "initLocation");
        g.Em().H(new 1(this));
    }

    protected final void avO() {
        x.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.hAj);
        if (!this.hAj) {
            this.hAj = true;
            axV();
        }
    }

    protected final void avD() {
        setMMTitle(com.tencent.mm.plugin.card.a.g.card_share_card_list_ui_title);
        this.hzM = new b(this);
        this.hye = new b.a() {
        };
        this.hzM.hye = this.hye;
        this.hzM.init();
        this.hAi = b.axG();
        if (this.hzX == null) {
            this.hzX = new i(this, this.mController.contentView);
            i iVar = this.hzX;
            iVar.hAr = View.inflate(iVar.gKS, e.card_share_no_local_city_item, null);
            iVar.hAs = (TextView) iVar.hAr.findViewById(com.tencent.mm.plugin.card.a.d.card_item_category_title);
            iVar.hAt = (TextView) iVar.hAr.findViewById(com.tencent.mm.plugin.card.a.d.card_item_subcategory_title);
            iVar.aL();
        }
        if (this.hzV == null) {
            this.hzV = new f(this, this.mController.contentView);
            f fVar = this.hzV;
            fVar.hzQ = (ImageView) fVar.hyK.findViewById(com.tencent.mm.plugin.card.a.d.no_card_tip_img);
            fVar.hzS = (TextView) fVar.hyK.findViewById(com.tencent.mm.plugin.card.a.d.no_card_tip_text);
            fVar.hzR = (TextView) fVar.hyK.findViewById(com.tencent.mm.plugin.card.a.d.no_card_tip_title);
            this.hzV.hzM = this.hzM;
        }
        if (this.hzW == null) {
            View view = this.mController.contentView;
            this.hzW = new e(this);
            this.hzW.hzM = this.hzM;
            this.hzW.axQ();
            e eVar = this.hzW;
            3 3 = new 3(this);
            if (eVar.hzL != null) {
                eVar.hzL.setOnClickListener(3);
            }
        }
        if (this.htn != null) {
            this.htn.addView(this.hzX.hAr);
        }
        if (this.hto != null) {
            this.hto.addView(this.hzW.hzL);
        }
        this.htk.setVisibility(0);
        this.htk.setOnScrollListener(new 4(this));
        Integer num;
        if (getIntent() == null || !getIntent().getBooleanExtra("KEY_IS_SHOW_SHARE_CARD_ENTRANCE_TIPS", true)) {
            num = (Integer) g.Ei().DT().get(aa.a.sQe, Integer.valueOf(0));
            if (!(num == null || num.intValue() == 1)) {
                g.Ei().DT().a(aa.a.sQe, Integer.valueOf(1));
            }
        } else {
            num = (Integer) g.Ei().DT().get(aa.a.sQe, Integer.valueOf(0));
            if (num == null || num.intValue() != 1) {
                g.Ei().DT().a(aa.a.sQe, Integer.valueOf(1));
                com.tencent.mm.plugin.card.d.d.c(this, e.card_show_share_card_entrance_tips, com.tencent.mm.plugin.card.a.g.card_share_card_tips_title, "");
            }
        }
        this.hvN = getIntent().getStringExtra("KEY_CARD_TP_ID");
        this.hAe = getIntent().getStringExtra("key_layout_buff");
        if (!bi.oW(this.hAe)) {
            this.hzZ = false;
        }
        if (!bi.oW(this.hvN)) {
            this.hzY = true;
            this.hAa = true;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        aya();
        if (intent != null) {
            this.hvN = intent.getStringExtra("KEY_CARD_TP_ID");
            if (!bi.oW(this.hvN)) {
                this.hzY = true;
                this.hAa = true;
            }
        }
    }

    private void axW() {
        long currentTimeMillis = System.currentTimeMillis() - this.hAm;
        if (!this.hAo || currentTimeMillis >= 1000) {
            x.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", new Object[]{Boolean.valueOf(this.hAo), Long.valueOf(currentTimeMillis)});
            this.hAo = true;
            if (currentTimeMillis < 500) {
                ah.i(new 5(this), 500);
                return;
            }
            if (this.hAi == 0 || this.hAi == 4 || ((this.hAi == 2 && !(b.axI() && b.axH())) || ((this.hAi == 1 && (!b.axI() || b.axH())) || (this.hAi == 3 && (!b.axH() || b.axI()))))) {
                this.hAi = b.axG();
            }
            am.axn().putValue("key_share_card_show_type", Integer.valueOf(this.hAi));
            x.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", new Object[]{Integer.valueOf(this.hAi), Boolean.valueOf(b.axI()), Boolean.valueOf(b.axH())});
            f fVar = this.hzV;
            fVar.hzR.setVisibility(0);
            fVar.hzQ.setImageDrawable(fVar.gKS.getResources().getDrawable(c.card_has_card_entrance_bg));
            fVar.hzR.setText(com.tencent.mm.plugin.card.a.g.card_share_card_list_has_card_tips_title);
            fVar.hzS.setText(com.tencent.mm.plugin.card.a.g.card_share_card_list_has_card_tips);
            LayoutParams layoutParams = (LayoutParams) fVar.hzQ.getLayoutParams();
            layoutParams.topMargin = fVar.gKS.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.card_no_card_tip_img_top_margin_for_share_card_ui);
            fVar.hzQ.setLayoutParams(layoutParams);
            fVar.hzQ.invalidate();
            if (b.axI() || b.axH()) {
                this.hzW.aL();
                this.hzX.aL();
                if (this.hAi == 4 && this.htk.getEmptyView() != null) {
                    this.htk.setEmptyView(null);
                    this.htk.invalidate();
                }
            } else {
                this.hzW.axU();
                this.hzX.hAr.setVisibility(8);
                if (this.htk.getEmptyView() != this.htm) {
                    this.htk.setEmptyView(this.htm);
                    this.htk.invalidate();
                }
            }
            axX();
            this.hAm = System.currentTimeMillis();
            this.hAo = false;
            return;
        }
        x.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
    }

    private void axX() {
        if (this.htl instanceof c) {
            c cVar = (c) this.htl;
            cVar.hzJ = this.hAi;
            cVar.a(null, null);
        }
    }

    protected final void avM() {
        this.hAh = true;
        if (this.hAf) {
            x.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
            if (this.hAj) {
                avL();
                return;
            }
            return;
        }
        x.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
        this.hAf = true;
        axY();
        avL();
    }

    protected final void avN() {
        if (this.hAg || this.hAf) {
            avL();
            return;
        }
        this.hAg = true;
        x.i("MicroMsg.ShareCardListUI", "onLocationFail()");
        axY();
    }

    private void axY() {
        if (b.axK() && b.axL()) {
            x.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
            this.hAc = true;
            return;
        }
        if (!(b.axK() && b.axL())) {
            this.hAb = false;
        }
        x.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
        axZ();
        am.axo().p("", "", 4);
    }

    private void axZ() {
        if (this.hAd) {
            x.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
            return;
        }
        if (!(!bi.oW(this.hAe) || b.axI() || b.axH() || b.axI() || b.axH())) {
            this.hzW.axR();
            this.htk.setEmptyView(null);
            this.htk.invalidate();
            this.hAp = true;
        }
        if (this.hAb && !bi.oW(this.hAe)) {
            this.hAe = "";
        }
        this.hAd = true;
        g.Eh().dpP.a(new com.tencent.mm.plugin.card.sharecard.model.b((double) am.axo().cXm, (double) am.axo().cXn, this.hAe), 0);
    }

    protected final boolean avG() {
        return super.avG();
    }

    protected final boolean avH() {
        return false;
    }

    protected final void b(com.tencent.mm.plugin.card.base.b bVar) {
        if (bVar != null) {
            b.xs(bVar.awr());
        }
        super.b(bVar);
    }

    protected final void c(com.tencent.mm.plugin.card.base.b bVar) {
        super.c(bVar);
    }

    protected final void a(com.tencent.mm.plugin.card.base.b bVar) {
        Intent intent = new Intent(this, CardDetailUI.class);
        x.i("MicroMsg.ShareCardListUI", "card tp id:" + bVar.awr());
        x.i("MicroMsg.ShareCardListUI", "card id:" + bVar.awq());
        intent.putExtra("key_card_id", am.axq().xA(bVar.awr()));
        intent.putExtra("key_card_tp_id", bVar.awr());
        intent.putExtra("key_is_share_card", true);
        intent.putExtra("key_from_scene", 3);
        startActivity(intent);
        b.xx(bVar.awr());
    }

    public final void a(int i, int i2, String str, l lVar) {
        boolean z = true;
        super.a(i, i2, str, lVar);
        if (i != 0 || i2 != 0) {
            if (lVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
                if (this.hAp) {
                    this.hAp = false;
                    this.hzW.axS();
                    this.htk.setEmptyView(this.htm);
                    this.htk.invalidate();
                }
                this.hAd = false;
                this.hAc = true;
            }
            x.i("MicroMsg.ShareCardListUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (lVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
            com.tencent.mm.plugin.card.sharecard.model.b bVar = (com.tencent.mm.plugin.card.sharecard.model.b) lVar;
            this.hAd = false;
            this.hAe = bVar.hym;
            this.hzM.af(bVar.hwU, this.hAb);
            if (!(b.axK() && b.axL())) {
                this.hAb = false;
            }
            if (!(b.axK() && b.axL())) {
                z = false;
            }
            this.hAc = z;
            x.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
            axW();
        }
    }

    public final void awx() {
        b.axF();
        this.hzZ = true;
        x.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", new Object[]{Boolean.valueOf(this.hAa), Boolean.valueOf(this.htq), Boolean.valueOf(this.hAh)});
        if (this.hAa && this.htq && this.hAh) {
            dP(false);
        } else {
            axW();
        }
        this.hAa = false;
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        x.d("MicroMsg.ShareCardListUI", "onNotifyChange");
        this.hzZ = true;
    }

    private void aya() {
        int intExtra = getIntent().getIntExtra("key_from_scene", 22);
        boolean aT = com.tencent.mm.s.c.Cp().aT(262152, 266256);
        boolean aU = com.tencent.mm.s.c.Cp().aU(262152, 266256);
        boolean a = com.tencent.mm.s.c.Cp().a(aa.a.sPM, aa.a.sPO);
        boolean a2 = com.tencent.mm.s.c.Cp().a(aa.a.sPN, aa.a.sPP);
        String oV = bi.oV((String) g.Ei().DT().get(aa.a.sPS, null));
        if (aT) {
            h.mEJ.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(intExtra), "", Integer.valueOf(0), oV});
        } else if (aU) {
            h.mEJ.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(intExtra), "", Integer.valueOf(0), oV});
        } else if (a && !a2) {
            h.mEJ.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(intExtra), "", Integer.valueOf(0), oV});
        } else if (a && a2) {
            h.mEJ.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(intExtra), "", Integer.valueOf(0), oV});
        } else if (a2) {
            h.mEJ.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(intExtra), "", Integer.valueOf(0), oV});
        } else {
            h.mEJ.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(intExtra), "", Integer.valueOf(0), oV});
        }
    }
}
