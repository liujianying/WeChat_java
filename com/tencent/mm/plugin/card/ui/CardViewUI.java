package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bqs;
import com.tencent.mm.protocal.c.lg;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.LinkedList;

public class CardViewUI extends CardBaseUI {
    private int Xe = 1;
    private String dxx = "";
    private LinkedList<lg> hBf = new LinkedList();
    private int hCB;
    private String hGQ;
    private View hGR;
    private int hop;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.CardViewUI", "onCreate intent is null");
            finish();
            return;
        }
        this.hop = intent.getIntExtra("key_previous_scene", 7);
        this.hCB = intent.getIntExtra("key_from_appbrand_type", 0);
        this.Xe = intent.getIntExtra("view_type", 0);
        this.hGQ = intent.getStringExtra("user_name");
        Object stringExtra = intent.getStringExtra("card_list");
        this.dxx = getIntent().getStringExtra("key_template_id");
        if (this.Xe == 0) {
            if (TextUtils.isEmpty(stringExtra)) {
                x.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
                finish();
                return;
            }
            Collection bb = k.bb(stringExtra, this.hop);
            if (bb != null && bb.size() > 0) {
                this.hBf.clear();
                this.hBf.addAll(bb);
            }
        }
        initView();
    }

    protected void onDestroy() {
        g.Eh().dpP.b(699, this);
        super.onDestroy();
    }

    public void onSwipeBack() {
        super.onSwipeBack();
        if (this.hop == 26) {
            overridePendingTransition(0, 0);
        }
    }

    protected final void avD() {
        int i;
        if (this.Xe == 0) {
            setMMTitle(a.g.card_view_ui_title);
        } else if (this.Xe == 1) {
            setMMTitle(a.g.card_gift_ui_title);
        }
        g.Eh().dpP.a(699, this);
        int i2 = a.g.card_accept_card_list_no_card_tips;
        if (this.Xe == 0) {
            dO(true);
            bqs bqs = new bqs();
            bqs.soQ = this.dxx;
            x.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[]{this.dxx});
            g.Eh().dpP.a(new t(this.hBf, bqs, this.hop), 0);
            i = a.g.card_accept_card_list_no_card_tips;
        } else if (this.Xe == 1) {
            this.hGR = View.inflate(this, e.card_list_header_tip_layout, null);
            if (this.htn != null) {
                this.htn.addView(this.hGR);
            }
            i = a.g.card_show_none_gift_card;
        } else {
            i = i2;
        }
        findViewById(d.no_card_tip_img).setVisibility(8);
        ((TextView) findViewById(d.no_card_tip_text)).setText(i);
    }

    protected final int avE() {
        return n.a.hwP;
    }

    protected final BaseAdapter avF() {
        if (this.Xe == 0) {
            return new g(getApplicationContext());
        }
        return super.avF();
    }

    protected final boolean avH() {
        if (this.Xe == 1) {
            return false;
        }
        return super.avH();
    }

    protected final void b(b bVar) {
        if (this.Xe == 1) {
            a((CardInfo) bVar);
        } else {
            super.b(bVar);
        }
    }

    protected final void avI() {
    }

    protected final void a(CardInfo cardInfo) {
        if (this.Xe == 1) {
            this.hts = cardInfo;
            i(this.hGQ, 1, true);
            return;
        }
        super.a(cardInfo);
        if (this.hts != null) {
            h.mEJ.h(11582, new Object[]{"OperGift", Integer.valueOf(4), Integer.valueOf(this.hts.awm().huV), this.hts.field_card_tp_id, this.hts.field_card_id, this.hGQ});
        }
    }

    protected final void a(b bVar) {
        if (this.Xe == 0) {
            am.axn().hts = (CardInfo) bVar;
            Intent intent = new Intent(this, CardDetailUI.class);
            intent.putExtra("key_card_id", ((CardInfo) bVar).field_card_id);
            intent.putExtra("key_from_scene", 51);
            intent.putExtra("key_from_appbrand_type", this.hCB);
            startActivity(intent);
            return;
        }
        super.a(bVar);
    }

    public final void a(int i, int i2, String str, l lVar) {
        int i3 = 0;
        if (lVar instanceof t) {
            dO(false);
            if (i == 0 && i2 == 0) {
                Object obj = ((t) lVar).hxb;
                if (obj != null && obj.size() > 0) {
                    if (this.htl instanceof g) {
                        g gVar = (g) this.htl;
                        if (obj != null) {
                            gVar.hzT.clear();
                            gVar.hzT.addAll(obj);
                            gVar.hEV.clear();
                            while (i3 < obj.size()) {
                                gVar.hEV.add(new Boolean(true));
                                i3++;
                            }
                        }
                    }
                    this.htl.notifyDataSetChanged();
                    return;
                }
                return;
            }
            com.tencent.mm.plugin.card.d.d.b(this, str, i2);
            return;
        }
        super.a(i, i2, str, lVar);
    }
}
