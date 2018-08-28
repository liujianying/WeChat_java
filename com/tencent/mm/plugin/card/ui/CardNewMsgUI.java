package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.h;
import com.tencent.mm.protocal.c.kv;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.y;
import java.util.List;

public class CardNewMsgUI extends MMActivity implements com.tencent.mm.plugin.card.b.k.a {
    private ListView CU;
    OnClickListener eZF = new 9(this);
    private View gQd;
    private View gvO;
    private a hFK;
    private View hFL = null;
    private boolean hFM = false;

    class a extends r<g> {
        private int edl = this.hFO;
        private int hFO = 10;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            g gVar = (g) obj;
            if (gVar == null) {
                gVar = new g();
            }
            gVar.d(cursor);
            return gVar;
        }

        public a() {
            super(CardNewMsgUI.this, new g());
            lB(true);
        }

        public final void WT() {
            if (am.axk().axd() > 0) {
                setCursor(am.axk().diF.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[]{"1"}));
            } else {
                this.edl = am.axk().getCount();
                h axk = am.axk();
                setCursor(axk.diF.rawQuery("select * from CardMsgInfo order by time desc LIMIT " + this.hFO, null));
            }
            notifyDataSetChanged();
        }

        protected final void WS() {
            aYc();
            WT();
        }

        public final boolean ayQ() {
            return this.hFO >= this.edl;
        }

        public final int ayR() {
            if (ayQ()) {
                if (CardNewMsgUI.this.hFL.getParent() != null) {
                    CardNewMsgUI.this.CU.removeFooterView(CardNewMsgUI.this.hFL);
                }
                return 0;
            }
            this.hFO += 10;
            if (this.hFO <= this.edl) {
                return 10;
            }
            this.hFO = this.edl;
            return this.edl % 10;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            g gVar = (g) getItem(i);
            if (view == null) {
                view = View.inflate(CardNewMsgUI.this.mController.tml, e.card_msg_item, null);
                b bVar2 = new b(CardNewMsgUI.this, (byte) 0);
                bVar2.hFT = (ImageView) view.findViewById(d.logo);
                bVar2.hFU = view.findViewById(d.card_type_img_layout);
                bVar2.hFV = (ImageView) view.findViewById(d.card_type_img);
                bVar2.hFW = (TextView) view.findViewById(d.title_tv);
                bVar2.hFX = (TextView) view.findViewById(d.time_tv);
                bVar2.hFY = (TextView) view.findViewById(d.description_tv);
                bVar2.hFZ = (TextView) view.findViewById(d.extent_tv);
                bVar2.hGa = (TextView) view.findViewById(d.split_line);
                bVar2.hGb = view.findViewById(d.oper_layout);
                bVar2.hGc = (TextView) view.findViewById(d.oper_text);
                bVar2.hGd = (LinearLayout) view.findViewById(d.accept_buttons);
                bVar2.hGe = (LinearLayout) view.findViewById(d.accept_buttons_area);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.hFW.setText(gVar.field_title);
            bVar.hFX.setText(com.tencent.mm.pluginsdk.f.h.c(CardNewMsgUI.this, ((long) gVar.field_time) * 1000, true));
            bVar.hFY.setText(gVar.field_description);
            int dimensionPixelSize = CardNewMsgUI.this.getResources().getDimensionPixelSize(b.card_newmsg_list_logo_height);
            x.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i + " logo_url :  " + gVar.field_logo_url);
            if (TextUtils.isEmpty(gVar.field_logo_color)) {
                bVar.hFU.setVisibility(8);
                bVar.hFT.setVisibility(0);
                bVar.hFT.setImageResource(c.my_card_package_defaultlogo);
                m.a(bVar.hFT, gVar.field_logo_url, dimensionPixelSize, c.my_card_package_defaultlogo, true);
            } else {
                x.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i + " field_logo_color :  " + gVar.field_logo_color);
                bVar.hFU.setVisibility(0);
                bVar.hFT.setVisibility(8);
                if (TextUtils.isEmpty(gVar.field_logo_url)) {
                    m.a(bVar.hFV, c.card_ticket_normal_icon, l.xV(gVar.field_logo_color));
                } else {
                    m.a(CardNewMsgUI.this, bVar.hFV, gVar.field_logo_url, dimensionPixelSize, c.card_ticket_normal_icon, l.xV(gVar.field_logo_color));
                }
            }
            kv awX = gVar.awX();
            if (awX == null || TextUtils.isEmpty(awX.text)) {
                bVar.hFZ.setVisibility(8);
            } else {
                bVar.hFZ.setText(awX.text);
                bVar.hFZ.setTag(gVar);
                bVar.hFZ.setVisibility(0);
                bVar.hFZ.setOnClickListener(CardNewMsgUI.this.eZF);
            }
            kz awY = gVar.awY();
            if (awY == null || TextUtils.isEmpty(awY.text)) {
                bVar.hGb.setVisibility(8);
                bVar.hGa.setVisibility(8);
            } else {
                bVar.hGc.setText(awY.text);
                bVar.hGb.setVisibility(0);
                bVar.hGb.setOnClickListener(CardNewMsgUI.this.eZF);
                bVar.hGb.setTag(gVar);
                bVar.hGa.setVisibility(0);
            }
            gVar.awZ();
            gVar.axa();
            a(gVar.hww, gVar.hwx, bVar, gVar);
            return view;
        }

        private void a(List<com.tencent.mm.plugin.card.model.g.a> list, List<g.b> list2, b bVar, g gVar) {
            bVar.hGd.removeAllViews();
            if ((list == null || list.size() == 0) && (list2 == null || list2.size() == 0)) {
                bVar.hGe.setVisibility(8);
                return;
            }
            int i;
            View inflate;
            Button button;
            if (!bi.cX(list)) {
                for (i = 0; i < list.size(); i++) {
                    com.tencent.mm.plugin.card.model.g.a aVar = (com.tencent.mm.plugin.card.model.g.a) list.get(i);
                    inflate = View.inflate(CardNewMsgUI.this.mController.tml, e.card_accept_button_item, null);
                    if (i == 0) {
                        inflate.findViewById(d.card_accept_button_divider).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(d.card_accept_button_title)).setText(aVar.title);
                    ((TextView) inflate.findViewById(d.card_accept_button_subtitle)).setText(aVar.hwC);
                    button = (Button) inflate.findViewById(d.card_accept_button);
                    button.setOnClickListener(new 1(this, aVar, gVar));
                    if (aVar.hwF == 0) {
                        button.setText(com.tencent.mm.plugin.card.a.g.card_accept_button_title);
                    } else if (aVar.hwF == 1) {
                        button.setText(com.tencent.mm.plugin.card.a.g.card_accept_button_title_for_consumed);
                    }
                    bVar.hGd.addView(inflate);
                }
            }
            if (!bi.cX(list2)) {
                for (i = 0; i < list2.size(); i++) {
                    final g.b bVar2 = (g.b) list2.get(i);
                    inflate = View.inflate(CardNewMsgUI.this.mController.tml, e.card_accept_button_item, null);
                    if (i == 0 && bi.cX(list)) {
                        inflate.findViewById(d.card_accept_button_divider).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(d.card_accept_button_title)).setText(bVar2.title);
                    ((TextView) inflate.findViewById(d.card_accept_button_subtitle)).setText(bVar2.description);
                    button = (Button) inflate.findViewById(d.card_accept_button);
                    button.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (TextUtils.isEmpty(bVar2.hwI)) {
                                x.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                            } else {
                                com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, bVar2.hwI, 2);
                            }
                        }
                    });
                    button.setText(bVar2.hwH);
                    bVar.hGd.addView(inflate);
                }
            }
            bVar.hGe.setVisibility(0);
        }
    }

    static /* synthetic */ void a(CardNewMsgUI cardNewMsgUI, int i) {
        g gVar = (g) cardNewMsgUI.hFK.getItem(i);
        if (gVar != null) {
            if (gVar.field_jump_type == 3) {
                if (!TextUtils.isEmpty(gVar.field_card_id)) {
                    cardNewMsgUI.ag(gVar.field_card_id, false);
                } else if (TextUtils.isEmpty(gVar.field_card_tp_id)) {
                    x.e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                } else {
                    cardNewMsgUI.ag(gVar.field_card_tp_id, false);
                }
            } else if (gVar.field_jump_type == 2) {
                if (TextUtils.isEmpty(gVar.field_url)) {
                    x.e("MicroMsg.CardNewMsgUI", "field_url is null");
                } else {
                    com.tencent.mm.plugin.card.d.b.a(cardNewMsgUI, gVar.field_url, 4);
                }
            } else if (gVar.field_jump_type == 1) {
                x.i("MicroMsg.CardNewMsgUI", "field_jump_type is MM_CARD_ITEM_XML_MSG_JUMP_TYPE_NO");
            } else if (gVar.field_jump_type == 4) {
                if (!TextUtils.isEmpty(gVar.field_card_id)) {
                    cardNewMsgUI.ag(gVar.field_card_id, true);
                } else if (TextUtils.isEmpty(gVar.field_card_tp_id)) {
                    x.e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                } else {
                    cardNewMsgUI.ag(gVar.field_card_tp_id, true);
                }
            }
            int i2 = cardNewMsgUI.getIntent().getBooleanExtra("from_menu", false) ? 7 : 1;
            com.tencent.mm.plugin.report.service.h.mEJ.h(11941, new Object[]{Integer.valueOf(i2), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, ""});
        }
    }

    protected final int getLayoutId() {
        return e.card_msg_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        am.axm().a(this);
        am.axm().awU();
    }

    protected void onDestroy() {
        this.hFK.aYc();
        am.axm().b(this);
        if (am.axk().axd() > 0) {
            am.axk().axe();
        }
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(com.tencent.mm.plugin.card.a.g.card_msg_center);
        setBackBtn(new 1(this));
        this.CU = (ListView) findViewById(d.card_msg_list);
        this.hFK = new a();
        this.CU.setAdapter(this.hFK);
        this.CU.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == CardNewMsgUI.this.hFK.getCount()) {
                    int i2 = 1;
                    if (am.axk().axd() > 0) {
                        am.axk().axe();
                    } else {
                        i2 = CardNewMsgUI.this.hFK.ayR();
                    }
                    CardNewMsgUI.this.hFK.a(null, null);
                    if (!CardNewMsgUI.this.hFM) {
                        if (CardNewMsgUI.this.gvO.getParent() != null) {
                            x.d("MicroMsg.CardNewMsgUI", "remove footer");
                            CardNewMsgUI.this.CU.removeFooterView(CardNewMsgUI.this.gvO);
                        }
                        if (!CardNewMsgUI.this.hFK.ayQ() && CardNewMsgUI.this.hFL.getParent() == null && i2 > 0) {
                            CardNewMsgUI.this.CU.addFooterView(CardNewMsgUI.this.hFL);
                            x.i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
                        }
                    }
                    CardNewMsgUI.this.hFM = true;
                    CardNewMsgUI.this.gvO.setVisibility(8);
                    return;
                }
                CardNewMsgUI.a(CardNewMsgUI.this, i);
            }
        });
        this.CU.setOnItemLongClickListener(new 3(this));
        this.CU.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (CardNewMsgUI.this.hFM && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    if (am.axk().axd() > 0) {
                        am.axk().axe();
                    } else {
                        CardNewMsgUI.this.hFK.ayR();
                    }
                    CardNewMsgUI.this.hFK.a(null, null);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.hFK.tlG = new 5(this);
        addTextOptionMenu(0, getString(com.tencent.mm.plugin.card.a.g.card_clear), new 6(this));
        this.gQd = findViewById(d.content_no_data);
        axM();
        this.gvO = y.gq(this).inflate(e.card_msg_footer, null);
        this.hFL = y.gq(this).inflate(e.mm_footerview, null);
        int axd = am.axk().axd();
        if (axd > 0) {
            this.CU.addFooterView(this.gvO);
        } else if (!this.hFK.ayQ() && axd == 0 && am.axk().getCount() > 0) {
            this.CU.addFooterView(this.hFL);
            this.hFM = true;
        } else if (this.hFK.ayQ() && axd == 0) {
            am.axk().getCount();
        }
    }

    private void axM() {
        k axm = am.axm();
        int size = (axm.huM == null || axm.huM.isEmpty()) ? 0 : axm.huM.size();
        if (size > 0) {
            this.CU.setVisibility(0);
            this.gQd.setVisibility(8);
            enableOptionMenu(true);
        } else {
            this.CU.setVisibility(8);
            this.gQd.setVisibility(0);
            enableOptionMenu(false);
        }
        this.hFK.notifyDataSetChanged();
    }

    private void ag(String str, boolean z) {
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_is_share_card", z);
        intent.putExtra("key_from_scene", 4);
        startActivity(intent);
    }

    public final void a(g gVar) {
        if ((gVar.field_msg_type & 1) != 0 && (gVar.field_msg_type & 3) != 0) {
            axM();
            this.hFK.a(null, null);
        }
    }

    public final void auM() {
    }
}
