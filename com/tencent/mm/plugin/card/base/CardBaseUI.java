package com.tencent.mm.plugin.card.base;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.card.sharecard.model.b;
import com.tencent.mm.plugin.card.sharecard.ui.h;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI extends DrawStatusBarActivity implements e, a {
    private float cXm = -85.0f;
    private float cXn = -1000.0f;
    private com.tencent.mm.modelgeo.a.a cXs = new 7(this);
    public c dMm;
    private boolean dMp = false;
    private p fUo = null;
    public ListView htk = null;
    public BaseAdapter htl = null;
    public RelativeLayout htm = null;
    public LinearLayout htn;
    public LinearLayout hto;
    public boolean htp = false;
    public boolean htq = true;
    public a htr = null;
    public CardInfo hts;

    public abstract void avD();

    static /* synthetic */ void c(CardBaseUI cardBaseUI, String str) {
        cardBaseUI.dO(true);
        g.Eh().dpP.a(new af(cardBaseUI.hts.field_card_id, str, 17), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        super.onResume();
        this.htq = true;
        g.Eh().dpP.a(652, this);
    }

    public void onPause() {
        super.onPause();
        this.htq = false;
        g.Eh().dpP.b(652, this);
    }

    public void initView() {
        setBackBtn(new 1(this));
        this.htk = (ListView) findViewById(16908298);
        this.htm = (RelativeLayout) findViewById(d.content_no_data);
        if (this.htm != null) {
            this.htk.setEmptyView(this.htm);
        }
        this.htn = (LinearLayout) View.inflate(getBaseContext(), com.tencent.mm.plugin.card.a.e.card_list_header_view, null);
        this.hto = (LinearLayout) View.inflate(getBaseContext(), com.tencent.mm.plugin.card.a.e.card_list_footer_view, null);
        this.htk.addHeaderView(this.htn);
        this.htk.addFooterView(this.hto);
        this.htl = avF();
        this.htk.setAdapter(this.htl);
        this.htk.setOnItemClickListener(new 2(this));
        this.htk.setOnItemLongClickListener(new 3(this));
        g.Eh().dpP.a(560, this);
        g.Eh().dpP.a(692, this);
        BaseAdapter baseAdapter = this.htl;
        a dVar = baseAdapter instanceof com.tencent.mm.plugin.card.ui.c ? new com.tencent.mm.plugin.card.ui.d((com.tencent.mm.plugin.card.ui.c) baseAdapter) : baseAdapter instanceof com.tencent.mm.plugin.card.sharecard.ui.c ? new com.tencent.mm.plugin.card.sharecard.ui.d((com.tencent.mm.plugin.card.sharecard.ui.c) baseAdapter) : baseAdapter instanceof com.tencent.mm.plugin.card.sharecard.ui.g ? new h((com.tencent.mm.plugin.card.sharecard.ui.g) baseAdapter) : new com.tencent.mm.plugin.card.ui.h((com.tencent.mm.plugin.card.ui.g) baseAdapter);
        this.htr = dVar;
        this.htr.onCreate();
        avD();
    }

    public int getLayoutId() {
        return com.tencent.mm.plugin.card.a.e.card_index_ui;
    }

    public void onDestroy() {
        g.Eh().dpP.b(560, this);
        g.Eh().dpP.b(692, this);
        if (this.htr != null) {
            this.htr.onDestroy();
        }
        super.onDestroy();
    }

    public void a(b bVar) {
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", bVar.awq());
        intent.addFlags(131072);
        intent.putExtra("key_from_scene", 3);
        startActivity(intent);
        if (avE() == n.a.hwS) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(11324, new Object[]{"ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0)});
        } else if (avE() == n.a.hwR) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(11324, new Object[]{"ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0)});
        }
    }

    public final void dO(boolean z) {
        if (z) {
            this.fUo = p.b(this, getString(com.tencent.mm.plugin.card.a.g.app_waiting), true, 0, null);
        } else if (this.fUo != null && this.fUo.isShowing()) {
            this.fUo.dismiss();
            this.fUo = null;
        }
    }

    public final void E(LinkedList<String> linkedList) {
        dO(true);
        g.Eh().dpP.a(new r(linkedList), 0);
    }

    public void a(int i, int i2, String str, l lVar) {
        int i3;
        if (i != 0 || i2 != 0) {
            dO(false);
            if (lVar instanceof af) {
                i3 = ((af) lVar).hwV;
                CharSequence charSequence = ((af) lVar).hwW;
                if (i3 == 10000) {
                    if (TextUtils.isEmpty(charSequence)) {
                        charSequence = getString(com.tencent.mm.plugin.card.a.g.card_gift_failed_tips);
                    }
                    str = charSequence;
                }
            }
            if (!(lVar instanceof x) && !(lVar instanceof ad) && !(lVar instanceof b) && this.htq) {
                com.tencent.mm.plugin.card.d.d.b(this, str, i2);
            }
        } else if (lVar instanceof r) {
            dO(false);
            com.tencent.mm.ui.base.h.bA(this, getResources().getString(com.tencent.mm.plugin.card.a.g.card_delete_success_tips));
            am.axh();
            com.tencent.mm.plugin.card.b.b.nG(4);
            this.htr.Ij();
            avP();
        } else if (lVar instanceof af) {
            dO(false);
            i3 = ((af) lVar).hwV;
            String str2 = ((af) lVar).hwW;
            if (i3 == 10000) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(com.tencent.mm.plugin.card.a.g.card_gift_failed_tips);
                }
                com.tencent.mm.plugin.card.d.d.b(this, str2, i3);
                return;
            }
            if (this.hts != null) {
                kx awn = this.hts.awn();
                awn.status = 3;
                this.hts.a(awn);
                if (!am.axi().c(this.hts, new String[0])) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", new Object[]{this.hts.field_card_id});
                }
            }
            this.htr.Ij();
            avP();
        }
    }

    public int avE() {
        return n.a.hwN;
    }

    public BaseAdapter avF() {
        return new com.tencent.mm.plugin.card.ui.c(this, avE());
    }

    public boolean avG() {
        return true;
    }

    public boolean avH() {
        return true;
    }

    public void avI() {
    }

    public void b(b bVar) {
        if (!avG()) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (bVar == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.CardBaseUI", "onListItemClick  item == null");
        } else if (!bVar.awq().equals("PRIVATE_TICKET_TITLE") && !bVar.awq().equals("PRIVATE_INVOICE_TITLE")) {
            if (bVar.avY()) {
                a(bVar);
            } else if (!TextUtils.isEmpty(bVar.awm().rnM)) {
                com.tencent.mm.plugin.card.d.b.a(this, bVar.awm().rnM, 0);
            }
        }
    }

    public void c(b bVar) {
        if (!avH()) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (bVar == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.CardBaseUI", "onListItemLongClick  item == null");
        } else {
            ArrayList arrayList = new ArrayList();
            if (bVar.avZ()) {
                arrayList.add(getResources().getString(com.tencent.mm.plugin.card.a.g.card_menu_gift_card));
            }
            arrayList.add(getResources().getString(com.tencent.mm.plugin.card.a.g.app_delete));
            String awq = bVar.awq();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bVar.awm().hwg);
            com.tencent.mm.ui.base.h.a(this, stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), null, new 5(this, bVar, awq));
        }
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            i(intent.getStringExtra("Select_Conv_User"), 0, false);
        }
    }

    public void a(CardInfo cardInfo) {
        this.hts = cardInfo;
        com.tencent.mm.plugin.card.d.b.a(this, 0, this);
    }

    public final void i(String str, int i, boolean z) {
        if (this.hts == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
        } else if (this.hts.awm() == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            if (i == 0) {
                if (TextUtils.isEmpty(this.hts.awo().sli)) {
                    stringBuilder.append(getString(com.tencent.mm.plugin.card.a.g.sns_post_to));
                } else {
                    stringBuilder.append(this.hts.awo().sli);
                }
                com.tencent.mm.plugin.report.service.h.mEJ.h(11582, new Object[]{"OperGift", Integer.valueOf(2), Integer.valueOf(this.hts.awm().huV), this.hts.field_card_tp_id, this.hts.field_card_id, str});
            } else if (i == 1) {
                stringBuilder.append(getString(com.tencent.mm.plugin.card.a.g.card_gift_card_dialog_title, new Object[]{this.hts.awm().hwg}));
                com.tencent.mm.plugin.report.service.h.mEJ.h(11582, new Object[]{"OperGift", Integer.valueOf(3), Integer.valueOf(this.hts.awm().huV), this.hts.field_card_tp_id, this.hts.field_card_id, str});
            }
            t.a.qJO.a(this.mController, stringBuilder.toString(), this.hts.awm().huW, this.hts.awm().title + "\n" + this.hts.awm().hwh, false, getResources().getString(com.tencent.mm.plugin.card.a.g.app_send), new 6(this, str, z));
        }
    }

    public final void avJ() {
        if (this.dMm == null) {
            this.dMm = c.OB();
        }
        if (this.dMm != null) {
            this.dMm.a(this.cXs, true);
        }
    }

    public final void avK() {
        if (this.dMm != null) {
            this.dMm.a(this.cXs, true);
        }
    }

    public final void avL() {
        if (this.dMm != null) {
            this.dMm.c(this.cXs);
        }
    }

    public void avM() {
    }

    public void avN() {
    }

    public void avO() {
    }

    public void avP() {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.CardBaseUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case s$l.AppCompatTheme_listPreferredItemHeight /*69*/:
                if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this, getString(com.tencent.mm.plugin.card.a.g.permission_location_request_again_msg), getString(com.tencent.mm.plugin.card.a.g.permission_tips_title), getString(com.tencent.mm.plugin.card.a.g.jump_to_settings), getString(com.tencent.mm.plugin.card.a.g.confirm_dialog_cancel), false, new 8(this), null);
                    return;
                } else {
                    avO();
                    return;
                }
            default:
                return;
        }
    }
}
