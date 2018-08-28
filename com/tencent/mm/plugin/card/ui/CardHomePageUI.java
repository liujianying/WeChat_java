package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.ui.i.2;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.ArrayList;

public class CardHomePageUI extends CardBaseUI implements d, a {
    private int fromScene = 0;
    private boolean hAb = true;
    private boolean hAd = false;
    private String hAe = "";
    private boolean hAf = false;
    private boolean hAg = false;
    private long hAk = 0;
    boolean hAl = false;
    private i hEC;
    private f hED;
    private f hEE;
    private f hEF;
    private boolean hEG = true;
    private boolean hEH = false;
    private TextView hEI;
    private b hzM;
    private boolean hzZ = false;
    private long mStartTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartTime = currentTimeMillis;
        this.hAk = currentTimeMillis;
        initView();
        am.axm().a(this.hEC);
        g.Eh().dpP.a(1164, this);
        g.Eh().dpP.a(984, this);
        am.axp().axD();
        am.axh();
        com.tencent.mm.plugin.card.b.b.nG(1);
        aya();
        Looper.myQueue().addIdleHandler(new 9(this));
        am.axp().a(this);
        am.axi().c(this);
    }

    protected final int getLayoutId() {
        return e.card_home_page_ui;
    }

    protected void onDestroy() {
        if (this.hEH) {
            avL();
        }
        am.axm().b(this.hEC);
        this.hzM.hye = null;
        g.Eh().dpP.b(1164, this);
        g.Eh().dpP.b(984, this);
        am.axp().b(this);
        am.axi().d(this);
        k.awV();
        b.axJ();
        long currentTimeMillis = System.currentTimeMillis() - this.hAk;
        h.mEJ.h(13219, new Object[]{"CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis)});
        super.onDestroy();
    }

    protected void onResume() {
        x.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", new Object[]{Boolean.valueOf(this.hEH), Boolean.valueOf(this.hAl), Boolean.valueOf(this.hzZ)});
        if (this.hEH && this.hAl && this.hzZ) {
            this.hAe = "";
            this.hAf = false;
            avK();
        } else if (this.hzZ) {
            this.hAe = "";
            axY();
        }
        this.hzZ = false;
        aL();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime != 0) {
            int i = (int) (currentTimeMillis - this.mStartTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(0);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(1);
            iDKey2.SetValue((long) i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.mEJ.b(arrayList, true);
            this.mStartTime = 0;
        }
        g.Em().H(new 1(this));
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final void initView() {
        x.i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.hEH = r0;
        if (this.hEH) {
            axV();
        } else {
            x.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
            axY();
        }
        super.initView();
    }

    protected final void avD() {
        setMMTitle(com.tencent.mm.plugin.card.a.g.card_home_page_title);
        addTextOptionMenu(0, getString(com.tencent.mm.plugin.card.a.g.card_msg_center), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, true);
                h.mEJ.h(11582, new Object[]{"CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", ""});
                return true;
            }
        });
        this.hzM = new b(this);
        this.hzM.init();
        if (this.hEC == null) {
            this.hEC = new i(this, this.mController.contentView);
            i iVar = this.hEC;
            iVar.hFD = View.inflate(iVar.gKS, e.card_msg_tip_header, null);
            iVar.hFD.setVisibility(8);
            iVar.hFE = (TextView) iVar.hFD.findViewById(com.tencent.mm.plugin.card.a.d.card_index_new_msg_tv);
            iVar.hFF = (ImageView) iVar.hFD.findViewById(com.tencent.mm.plugin.card.a.d.card_index_new_msg_img);
            iVar.hFD.setOnClickListener(new i$1(iVar));
            iVar.ayP();
            if (iVar.hFG == null) {
                iVar.hFG = ((ViewStub) iVar.hyK.findViewById(com.tencent.mm.plugin.card.a.d.card_msg_layout_stub)).inflate();
                iVar.hFG.setVisibility(8);
                iVar.hFH = (TextView) iVar.hFG.findViewById(com.tencent.mm.plugin.card.a.d.card_index_new_msg_tv);
                iVar.hFI = (ImageView) iVar.hFG.findViewById(com.tencent.mm.plugin.card.a.d.card_index_new_msg_img);
                iVar.hFG.setOnClickListener(new 2(iVar));
            }
            this.hEC.hAu = true;
        }
        if (this.hED == null) {
            this.hED = new f(this, findViewById(com.tencent.mm.plugin.card.a.d.card_member_card_item), 1, this.hzM);
        }
        if (this.hEE == null) {
            this.hEE = new f(this, findViewById(com.tencent.mm.plugin.card.a.d.card_share_card_item), 2, this.hzM);
        }
        if (this.hEF == null) {
            this.hEF = new f(this, findViewById(com.tencent.mm.plugin.card.a.d.card_ticket_item), 3, this.hzM);
        }
        if (this.hED != null) {
            this.hED.setOnClickListener(new 6(this));
        }
        if (this.hEE != null) {
            this.hEE.setOnClickListener(new 7(this));
        }
        if (this.hEF != null) {
            this.hEF.setOnClickListener(new 8(this));
        }
        setBackBtn(new 3(this));
    }

    protected final int avE() {
        return n.a.hwS;
    }

    private void axV() {
        x.d("MicroMsg.CardHomePageUI", "initLocation");
        g.Em().H(new Runnable() {
            public final void run() {
                CardHomePageUI.this.dMm = c.OB();
                CardHomePageUI.this.avJ();
                CardHomePageUI.this.hAl = true;
                x.d("MicroMsg.CardHomePageUI", "initLocation end");
            }
        });
    }

    protected final void avO() {
        x.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.hEH);
        if (!this.hEH) {
            this.hEH = true;
            axV();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        aya();
        this.hzZ = true;
        this.hEG = true;
    }

    private void aL() {
        x.i("MicroMsg.CardHomePageUI", "updateView()");
        this.hEC.ayP();
        ayK();
        this.hEE.aL();
        this.hEF.aL();
    }

    private void ayK() {
        x.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
        c cVar = (c) this.htl;
        if (this.hEI == null) {
            this.hEI = (TextView) findViewById(com.tencent.mm.plugin.card.a.d.member_card_show_all_tv);
            this.hEI.setOnClickListener(new 5(this));
        }
        if (cVar.getCount() > 0) {
            this.hEI.setVisibility(0);
            this.hEI.setText(getString(com.tencent.mm.plugin.card.a.g.card_show_all_member_card, new Object[]{Integer.valueOf(b.axE())}));
        } else {
            this.hEI.setVisibility(0);
            this.hEI.setText(getString(com.tencent.mm.plugin.card.a.g.card_show_all_member_card, new Object[]{Integer.valueOf(0)}));
            LinearLayout linearLayout = (LinearLayout) findViewById(com.tencent.mm.plugin.card.a.d.card_home_page_header);
            if (linearLayout != null) {
                LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = com.tencent.mm.bp.a.fromDPToPix(this, 29);
                layoutParams.bottomMargin = com.tencent.mm.bp.a.fromDPToPix(this, 29);
                linearLayout.setLayoutParams(layoutParams);
            }
        }
        this.hED.hyK.setVisibility(8);
    }

    protected final void avP() {
        ayK();
    }

    protected final void avM() {
        if (this.hAf) {
            x.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
            if (this.hEH) {
                avL();
                return;
            }
            return;
        }
        x.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
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
        x.i("MicroMsg.CardHomePageUI", "onLocationFail()");
        axY();
    }

    private void axY() {
        x.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
        if (!this.hEG) {
            x.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
        } else if (this.hAd) {
            x.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
        } else {
            if (this.hAb && !bi.oW(this.hAe)) {
                this.hAe = "";
            }
            this.hAd = true;
            this.hEG = false;
            g.Eh().dpP.a(new com.tencent.mm.plugin.card.sharecard.model.b((double) am.axo().cXm, (double) am.axo().cXn, this.hAe), 0);
        }
        if (l.azR()) {
            int intValue = ((Integer) g.Ei().DT().get(aa.a.sPY, Integer.valueOf(1))).intValue();
            x.i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is " + intValue);
            g.Eh().dpP.a(new ad((double) am.axo().cXm, (double) am.axo().cXn, intValue), 0);
        } else {
            x.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
        }
        am.axo().p("", "", 4);
    }

    protected final boolean avG() {
        return super.avG();
    }

    protected final boolean avH() {
        return true;
    }

    protected final void b(com.tencent.mm.plugin.card.base.b bVar) {
        super.b(bVar);
    }

    protected final void c(com.tencent.mm.plugin.card.base.b bVar) {
        super.c(bVar);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        super.a(i, i2, str, lVar);
        if (i != 0 || i2 != 0) {
            if (lVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
                this.hAd = false;
            }
            x.i("MicroMsg.CardHomePageUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (lVar instanceof ad) {
            ayK();
            this.htr.Ij();
            this.hEF.aL();
        } else if (lVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
            com.tencent.mm.plugin.card.sharecard.model.b bVar = (com.tencent.mm.plugin.card.sharecard.model.b) lVar;
            this.hAd = false;
            this.hAe = bVar.hym;
            this.hzM.af(bVar.hwU, this.hAb);
            if (!(b.axK() && b.axL())) {
                this.hAb = false;
            }
            x.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
            aL();
        }
    }

    private void aya() {
        int intExtra = getIntent().getIntExtra("key_from_scene", 22);
        boolean aT = com.tencent.mm.s.c.Cp().aT(262152, 266256);
        boolean aU = com.tencent.mm.s.c.Cp().aU(262152, 266256);
        boolean a = com.tencent.mm.s.c.Cp().a(aa.a.sPM, aa.a.sPO);
        boolean a2 = com.tencent.mm.s.c.Cp().a(aa.a.sPN, aa.a.sPP);
        String oV = bi.oV((String) g.Ei().DT().get(aa.a.sPS, null));
        if (aT) {
            h.mEJ.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(intExtra), "", Integer.valueOf(0), oV});
        } else if (aU) {
            h.mEJ.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(intExtra), "", Integer.valueOf(0), oV});
        } else if (a && !a2) {
            h.mEJ.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(intExtra), "", Integer.valueOf(0), oV});
        } else if (a && a2) {
            h.mEJ.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(intExtra), "", Integer.valueOf(0), oV});
        } else if (a2) {
            h.mEJ.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(intExtra), "", Integer.valueOf(0), oV});
        } else {
            h.mEJ.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(intExtra), "", Integer.valueOf(0), oV});
        }
    }

    public final void awx() {
        this.hzZ = true;
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        this.hzZ = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fromScene == 1 || this.fromScene == 2) {
                ayL();
            } else {
                finish();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void ayL() {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 3);
        com.tencent.mm.bg.d.e(this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
    }
}
