package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bqs;
import com.tencent.mm.protocal.c.lg;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftReceiveUI extends DrawStatusBarActivity implements OnClickListener, e {
    private int dxI;
    private String dxJ;
    private TextView hDA;
    private ImageView hDB;
    private TextView hDC;
    private TextView hDD;
    private TextView hDE;
    private ImageView hDF;
    private ImageView hDG;
    private View hDH;
    private TextView hDI;
    private LinearLayout hDJ;
    private ListView hDK;
    private RelativeLayout hDL;
    private LinearLayout hDM;
    private ImageView hDN;
    private TextView hDO;
    private LinearLayout hDP;
    private TextView hDQ;
    private RelativeLayout hDR;
    private RelativeLayout hDS;
    private ImageView hDT;
    private ImageView hDU;
    private TextView hDV;
    private TextView hDW;
    private ListView hDX;
    private RelativeLayout hDY;
    private TextView hDZ;
    private CardGiftInfo hDa;
    private ProgressBar hDe;
    private ag hDf = new ag(Looper.getMainLooper());
    private ScrollView hDq;
    private LinearLayout hDr;
    private ImageView hDs;
    private TextView hDt;
    private TextView hDu;
    private ImageView hDv;
    private ImageView hDw;
    private LinearLayout hDx;
    private RelativeLayout hDy;
    private RelativeLayout hDz;
    private TextView hEa;
    private View hEb;
    a hEc = new 4(this);
    private p tipDialog = null;

    static /* synthetic */ void a(CardGiftReceiveUI cardGiftReceiveUI, boolean z) {
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(cardGiftReceiveUI, com.tencent.mm.plugin.card.a.e.card_gift_bootom_layout, null);
        cardGiftReceiveUI.hEb = relativeLayout.findViewById(d.bottom_separate_line);
        cardGiftReceiveUI.hDZ = (TextView) relativeLayout.findViewById(d.tv_gift_card_operate);
        cardGiftReceiveUI.hEa = (TextView) relativeLayout.findViewById(d.tv_gift_card_footer);
        cardGiftReceiveUI.hDZ.setOnClickListener(cardGiftReceiveUI);
        cardGiftReceiveUI.hEa.setOnClickListener(cardGiftReceiveUI);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (z) {
            if (cardGiftReceiveUI.hDY.getVisibility() == 0) {
                layoutParams.addRule(3, d.accepter_list_view);
            } else {
                layoutParams.addRule(3, d.card_gift_content_layout);
            }
            layoutParams.bottomMargin = cardGiftReceiveUI.J(30);
            layoutParams.topMargin = cardGiftReceiveUI.J(40);
        } else {
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = cardGiftReceiveUI.J(30);
            layoutParams.topMargin = cardGiftReceiveUI.J(40);
        }
        LayoutParams layoutParams2;
        if (cardGiftReceiveUI.hDY.getVisibility() == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            if (cardGiftReceiveUI.hDR.getVisibility() == 0) {
                layoutParams2.topMargin = cardGiftReceiveUI.J(0);
                cardGiftReceiveUI.hDY.setLayoutParams(layoutParams2);
            } else {
                layoutParams2.topMargin = cardGiftReceiveUI.J(60);
            }
            cardGiftReceiveUI.hDY.setLayoutParams(layoutParams2);
            cardGiftReceiveUI.hDY.addView(relativeLayout, layoutParams);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams2.topMargin = cardGiftReceiveUI.J(60);
            cardGiftReceiveUI.hDL.setLayoutParams(layoutParams2);
            cardGiftReceiveUI.hDL.addView(relativeLayout, layoutParams);
        }
        if (bi.oW(cardGiftReceiveUI.hDa.hvL)) {
            cardGiftReceiveUI.hDZ.setVisibility(8);
        } else {
            cardGiftReceiveUI.hDZ.setVisibility(0);
            cardGiftReceiveUI.hDZ.setText(cardGiftReceiveUI.hDa.hvL);
        }
        if (bi.oW(cardGiftReceiveUI.hDa.hvy)) {
            cardGiftReceiveUI.hEb.setVisibility(8);
            cardGiftReceiveUI.hEa.setVisibility(8);
        } else {
            cardGiftReceiveUI.hEb.setVisibility(0);
            cardGiftReceiveUI.hEa.setVisibility(0);
            cardGiftReceiveUI.hEa.setText(cardGiftReceiveUI.hDa.hvy);
        }
        if (bi.oW(cardGiftReceiveUI.hDa.hvn)) {
            cardGiftReceiveUI.hDL.setVisibility(8);
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.card.a.e.card_gift_receive_ui_new;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dxJ = getIntent().getStringExtra("key_order_id");
        this.dxI = getIntent().getIntExtra("key_biz_uin", -1);
        this.hDa = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        x.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", new Object[]{this.dxJ, Integer.valueOf(this.dxI)});
        initView();
        g.Eh().dpP.a(1165, this);
        g.Eh().dpP.a(699, this);
        com.tencent.mm.plugin.card.d.a.a(this.hEc);
        if (this.hDa == null) {
            x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
            if (this.dxI == -1) {
                x.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
                return;
            }
            if (this.dxJ == null) {
                x.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
            }
            x.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
            g.Eh().dpP.a(new z(this.dxI, this.dxJ), 0);
            this.tipDialog = h.a(this.mController.tml, getString(com.tencent.mm.plugin.card.a.g.loading_tips), true, new 3(this));
            if (this.tipDialog != null) {
                this.tipDialog.show();
                return;
            }
            return;
        }
        axM();
    }

    protected void onDestroy() {
        super.onDestroy();
        g.Eh().dpP.b(1165, this);
        g.Eh().dpP.b(699, this);
        com.tencent.mm.plugin.card.d.a.b(this.hEc);
    }

    private void axM() {
        if (this.hDa == null) {
            x.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
            return;
        }
        x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", new Object[]{Integer.valueOf(this.hDa.hvF)});
        c.a aVar;
        if (this.hDa.hvF == 1 || this.hDa.hvF != 2) {
            this.hDr.setVisibility(8);
            this.hDx.setVisibility(0);
            this.hDC.setText(this.hDa.hvw);
            if (this.hDa.hvS == 1) {
                this.hDF.setAlpha(0.5f);
                this.hDD.setVisibility(8);
                this.hDE.setVisibility(8);
                this.hDz.setVisibility(8);
                this.hDy.setVisibility(8);
            } else {
                this.hDD.setVisibility(0);
                this.hDE.setVisibility(0);
                this.hDz.setVisibility(0);
                this.hDy.setVisibility(0);
                this.hDD.setText(this.hDa.hvx);
                this.hDE.setText(com.tencent.mm.plugin.card.a.g.card_gift_price_rmb_uint);
                if (bi.oW(this.hDa.hvx)) {
                    this.hDD.setVisibility(8);
                    this.hDE.setVisibility(8);
                }
                if (bi.oW(this.hDa.hvJ)) {
                    x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
                } else {
                    this.hDD.setTextColor(bi.bc(this.hDa.hvJ, getResources().getColor(com.tencent.mm.plugin.card.a.a.black)));
                }
            }
            if (bi.oW(this.hDa.hvE)) {
                this.hDB.setVisibility(8);
                x.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
            } else {
                this.hDB.setVisibility(0);
                aVar = new c.a();
                aVar.dXB = com.tencent.mm.compatible.util.e.bnE;
                o.Pk();
                aVar.dXU = null;
                aVar.dXA = m.xr(this.hDa.hvE);
                aVar.dXy = true;
                aVar.dXw = true;
                o.Pj().a(this.hDa.hvE, this.hDB, aVar.Pt());
            }
            if (bi.oW(this.hDa.hvD)) {
                this.hDA.setVisibility(8);
                x.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
            } else {
                this.hDA.setVisibility(0);
                this.hDA.setText(this.hDa.hvD);
                if (bi.oW(this.hDa.hvH)) {
                    x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
                } else {
                    this.hDA.setTextColor(bi.bc(this.hDa.hvH, getResources().getColor(com.tencent.mm.plugin.card.a.a.black)));
                }
            }
            if (bi.oW(this.hDa.hvI)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
            } else {
                this.hDC.setTextColor(bi.bc(this.hDa.hvI, getResources().getColor(com.tencent.mm.plugin.card.a.a.black)));
            }
            if (bi.oW(this.hDa.hvv)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
            } else {
                aVar = new c.a();
                aVar.dXB = com.tencent.mm.compatible.util.e.bnE;
                o.Pk();
                aVar.dXU = null;
                aVar.dXA = m.xr(this.hDa.hvv);
                aVar.dXW = true;
                aVar.dXy = true;
                aVar.dXw = true;
                aVar.dXO = new ColorDrawable(l.xV("#CCCCCC"));
                o.Pj().a(this.hDa.hvv, this.hDG, aVar.Pt());
            }
            if (bi.oW(this.hDa.hvu)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
            } else {
                aVar = new c.a();
                aVar.dXB = com.tencent.mm.compatible.util.e.bnE;
                o.Pk();
                aVar.dXU = null;
                aVar.dXA = m.xr(this.hDa.hvu);
                aVar.dXy = true;
                aVar.dXw = true;
                aVar.dXO = new ColorDrawable(l.xV("#CCCCCC"));
                aVar.dXW = true;
                aVar.dXX = (float) com.tencent.mm.bp.a.fromDPToPix(this, 8);
                o.Pj().a(this.hDa.hvu, this.hDF, aVar.Pt());
            }
        } else {
            this.hDx.setVisibility(8);
            this.hDr.setVisibility(0);
            this.hDt.setText(this.hDa.hvD);
            this.hDu.setText(this.hDa.hvw + "     " + this.hDa.hvx + this.mController.tml.getString(com.tencent.mm.plugin.card.a.g.card_gift_price_rmb_uint));
            if (bi.oW(this.hDa.hvE)) {
                this.hDs.setVisibility(8);
            } else {
                this.hDs.setVisibility(0);
                aVar = new c.a();
                aVar.dXB = com.tencent.mm.compatible.util.e.bnE;
                o.Pk();
                aVar.dXU = null;
                aVar.dXA = m.xr(this.hDa.hvE);
                aVar.dXy = true;
                aVar.dXw = true;
                o.Pj().a(this.hDa.hvE, this.hDs, aVar.Pt());
            }
            if (bi.oW(this.hDa.hvH)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
            } else {
                this.hDt.setTextColor(bi.bc(this.hDa.hvH, getResources().getColor(com.tencent.mm.plugin.card.a.a.black)));
            }
            if (bi.oW(this.hDa.hvI)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
            } else {
                this.hDu.setTextColor(bi.bc(this.hDa.hvI, getResources().getColor(com.tencent.mm.plugin.card.a.a.black)));
            }
            if (bi.oW(this.hDa.hvv)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
            } else {
                aVar = new c.a();
                aVar.dXB = com.tencent.mm.compatible.util.e.bnE;
                o.Pk();
                aVar.dXU = null;
                aVar.dXA = m.xr(this.hDa.hvv);
                aVar.dXW = true;
                aVar.dXy = true;
                aVar.dXw = true;
                aVar.dXO = new ColorDrawable(l.xV("#CCCCCC"));
                o.Pj().a(this.hDa.hvv, this.hDw, aVar.Pt());
            }
            if (bi.oW(this.hDa.hvu)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
            } else {
                aVar = new c.a();
                aVar.dXB = com.tencent.mm.compatible.util.e.bnE;
                o.Pk();
                aVar.dXU = null;
                aVar.dXA = m.xr(this.hDa.hvu);
                aVar.dXy = true;
                aVar.dXw = true;
                aVar.dXO = new ColorDrawable(l.xV("#CCCCCC"));
                aVar.dXW = true;
                aVar.dXX = (float) com.tencent.mm.bp.a.fromDPToPix(this, 8);
                o.Pj().a(this.hDa.hvu, this.hDv, aVar.Pt());
            }
        }
        if (this.hDa.hvS == 1) {
            this.hDM.setVisibility(0);
            this.hDP.setVisibility(8);
            this.hDL.setVisibility(8);
            this.hDO.setText(j.a(this, this.hDa.bYo, this.hDO.getTextSize()));
            a(this.hDN);
        } else {
            this.hDM.setVisibility(8);
            this.hDP.setVisibility(0);
            this.hDL.setVisibility(0);
            a(this.hDU);
            this.hDV.setText(j.a(this, this.hDa.bYo, this.hDV.getTextSize()));
            if ((bi.oW(this.hDa.hvo) || "undefined".equals(this.hDa.hvo)) && (bi.oW(this.hDa.hvp) || "undefined".equals(this.hDa.hvp))) {
                this.hDR.setVisibility(8);
                x.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
            } else {
                this.hDR.setVisibility(0);
            }
            if (this.hDa == null || bi.oW(this.hDa.hvo)) {
                x.e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
            } else {
                com.tencent.mm.plugin.card.d.a.g(this.hDa.hvo, this.hDa.hvr, this.hDa.hvA, 2);
            }
            if (this.hDa == null || bi.oW(this.hDa.hvq)) {
                x.e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
            } else {
                com.tencent.mm.plugin.card.d.a.g(this.hDa.hvq, this.hDa.hvt, this.hDa.hvC, 2);
            }
            if (!bi.oW(this.hDa.hvn)) {
                this.hDQ.setText(j.a(this, this.hDa.hvn, this.hDQ.getTextSize()));
            }
        }
        axX();
        if (this.hDa.hvQ.size() > 0) {
            this.hDY.setVisibility(0);
            this.hDX.setVisibility(0);
            this.hDX.setAdapter(new a(this));
            b(this.hDX);
            if (!bi.oW(this.hDa.hvR)) {
                this.hDW.setVisibility(0);
                this.hDW.setText(this.hDa.hvR);
            }
        } else {
            this.hDY.setVisibility(0);
            this.hDX.setVisibility(0);
            this.hDW.setVisibility(0);
            if (!bi.oW(this.hDa.hvR)) {
                this.hDW.setVisibility(0);
                this.hDW.setText(this.hDa.hvR);
            }
        }
        if (bi.oW(this.hDa.hvL) && bi.oW(this.hDa.hvy)) {
            this.hDq.setFillViewport(true);
        } else {
            this.hDq.getViewTreeObserver().addOnGlobalLayoutListener(new 1(this));
        }
    }

    private int J(int i) {
        return com.tencent.mm.bp.a.fromDPToPix(this.mController.tml, i);
    }

    private void a(ImageView imageView) {
        if (bi.oW(this.hDa.hvm)) {
            x.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
            return;
        }
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(this, 20);
        c.a aVar = new c.a();
        aVar.dXB = com.tencent.mm.compatible.util.e.bnE;
        o.Pk();
        aVar.dXU = null;
        aVar.dXA = m.xr(this.hDa.hvm);
        aVar.dXy = true;
        aVar.dXW = true;
        aVar.dXX = 3.0f;
        aVar.dXw = true;
        aVar.dXF = fromDPToPix;
        aVar.dXE = fromDPToPix;
        aVar.dXO = new ColorDrawable(l.xV("#CCCCCC"));
        o.Pj().a(this.hDa.hvm, imageView, aVar.Pt());
    }

    private void axX() {
        int i = 0;
        if (this.hDa.hvP.size() > 0) {
            this.hDH.setVisibility(0);
            this.hDK.setVisibility(8);
            if (this.hDa.hvP.size() <= 2) {
                this.hDI.setVisibility(8);
                I(this.hDa.hvP);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.hDa.hvP.get(0));
            linkedList.add(this.hDa.hvP.get(1));
            I(linkedList);
            this.hDI.setVisibility(0);
            this.hDI.setOnClickListener(this);
            linkedList = new LinkedList();
            while (i < this.hDa.hvP.size()) {
                if (!(i == 0 || i == 1)) {
                    linkedList.add(this.hDa.hvP.get(i));
                }
                i++;
            }
            this.hDK.setAdapter(new c(this, linkedList));
            b(this.hDK);
            return;
        }
        this.hDH.setVisibility(8);
        this.hDI.setVisibility(8);
        this.hDK.setVisibility(8);
    }

    private void I(LinkedList<AcceptedCardItem> linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            AcceptedCardItem acceptedCardItem = (AcceptedCardItem) it.next();
            View inflate = View.inflate(this, com.tencent.mm.plugin.card.a.e.card_gift_accepter_card_item, null);
            TextView textView = (TextView) inflate.findViewById(d.tv_card_price);
            ((TextView) inflate.findViewById(d.tv_card_title)).setText(acceptedCardItem.hvV);
            textView.setText(acceptedCardItem.hvW + this.mController.tml.getString(com.tencent.mm.plugin.card.a.g.card_gift_price_rmb_uint));
            this.hDJ.addView(inflate);
        }
    }

    private static void b(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int count = adapter.getCount();
            int i = 0;
            for (int i2 = 0; i2 < count; i2++) {
                View view = adapter.getView(i2, null, listView);
                view.measure(0, 0);
                i += view.getMeasuredHeight();
            }
            LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i;
            listView.setLayoutParams(layoutParams);
        }
    }

    protected final void initView() {
        this.hDq = (ScrollView) findViewById(d.card_git_receive_root);
        this.hDr = (LinearLayout) findViewById(d.card_title_sender_layout);
        this.hDs = (ImageView) findViewById(d.iv_sender_icon);
        this.hDt = (TextView) findViewById(d.tv_sender_title);
        this.hDu = (TextView) findViewById(d.tv_sender_price);
        this.hDv = (ImageView) findViewById(d.iv_sender_gift_card);
        this.hDw = (ImageView) findViewById(d.iv_sender_gift_logo);
        this.hDv.setOnClickListener(this);
        this.hDx = (LinearLayout) findViewById(d.card_title_layout_2);
        this.hDy = (RelativeLayout) findViewById(d.bg_left_layout);
        this.hDz = (RelativeLayout) findViewById(d.bg_right_layout);
        this.hDA = (TextView) findViewById(d.tv_desc_title);
        this.hDC = (TextView) findViewById(d.tv_second_title);
        this.hDB = (ImageView) findViewById(d.iv_second_icon);
        this.hDD = (TextView) findViewById(d.tv_third_title);
        this.hDE = (TextView) findViewById(d.tv_third_title_unit);
        this.hDF = (ImageView) findViewById(d.iv_gift_card);
        this.hDG = (ImageView) findViewById(d.iv_gift_card_logo);
        this.hDF.setOnClickListener(this);
        this.hDH = findViewById(d.card_list_separate_line);
        this.hDI = (TextView) findViewById(d.tv_show_all);
        this.hDJ = (LinearLayout) findViewById(d.card_list_layout);
        this.hDK = (ListView) findViewById(d.card_list_view);
        this.hDL = (RelativeLayout) findViewById(d.card_gift_content_bg_layout);
        this.hDM = (LinearLayout) findViewById(d.give_small_layout);
        this.hDN = (ImageView) findViewById(d.iv_give_avatar_small);
        this.hDO = (TextView) findViewById(d.tv_give_name_small);
        this.hDP = (LinearLayout) findViewById(d.give_layout);
        this.hDU = (ImageView) findViewById(d.iv_give_avatar);
        this.hDV = (TextView) findViewById(d.tv_give_name);
        this.hDQ = (TextView) findViewById(d.tv_give_content);
        this.hDR = (RelativeLayout) findViewById(d.card_img_layout);
        this.hDS = (RelativeLayout) findViewById(d.img_video);
        this.hDT = (ImageView) findViewById(d.tv_img);
        this.hDR.setOnClickListener(this);
        this.hDS.setOnClickListener(this);
        this.hDW = (TextView) findViewById(d.tv_accepter_list_title);
        this.hDX = (ListView) findViewById(d.accepter_list_view);
        this.hDY = (RelativeLayout) findViewById(d.card_gift_accpeter_layout);
        this.hDe = (ProgressBar) findViewById(d.image_loading);
        com.tencent.mm.plugin.card.d.m.d(this);
        com.tencent.mm.ui.statusbar.a.c(this.mController.contentView, -1, true);
        setMMTitle("");
        setBackBtn(new 2(this));
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (lVar instanceof z) {
                x.i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
                this.hDa = ((z) lVar).hwX;
                axM();
            } else if (lVar instanceof t) {
                Intent intent = new Intent(this, CardDetailUI.class);
                LinkedList linkedList = ((t) lVar).hxb;
                if (linkedList == null || linkedList.size() == 0) {
                    x.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardinfo list  size is null or empty!");
                    return;
                }
                b bVar = (b) linkedList.get(0);
                if (bVar == null || !(bVar instanceof CardInfo)) {
                    x.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardInfo  is null!");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add((CardInfo) it.next());
                }
                intent.putExtra("key_card_info", (CardInfo) bVar);
                intent.putExtra("key_previous_scene", 27);
                intent.putExtra("key_from_scene", 27);
                intent.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
                intent.putExtra("key_card_git_info", this.hDa);
                startActivity(intent);
            }
        } else if (lVar instanceof z) {
            x.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            com.tencent.mm.plugin.card.d.d.a(this, str, true);
        } else if (lVar instanceof t) {
            x.e("MicroMsg.CardGiftReceiveUI", ", NetSceneBatchGetCardItemByTpInfo onSceneEnd fail return!  errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
    }

    public void onClick(View view) {
        Intent intent;
        if (view.getId() == d.img_video) {
            if (!bi.oW(this.hDa.hvp)) {
                intent = new Intent(this, CardGiftVideoUI.class);
                intent.putExtra("key_gift_into", this.hDa);
                intent.putExtra("key_is_mute", false);
                startActivity(intent);
                overridePendingTransition(0, 0);
                com.tencent.mm.plugin.report.service.h.mEJ.h(13866, new Object[]{Integer.valueOf(3), this.dxJ, com.tencent.mm.a.o.getString(this.dxI)});
            }
        } else if (view.getId() == d.card_img_layout) {
            if (this.hDe.getVisibility() != 0 && !bi.oW(this.hDa.hvo)) {
                intent = new Intent(this, CardGiftImageUI.class);
                intent.putExtra("key_gift_into", this.hDa);
                startActivity(intent);
                overridePendingTransition(0, 0);
                com.tencent.mm.plugin.report.service.h.mEJ.h(13866, new Object[]{Integer.valueOf(4), this.dxJ, com.tencent.mm.a.o.getString(this.dxI)});
            }
        } else if (view.getId() == d.tv_gift_card_footer) {
            if (this.hDa != null && this.hDa.hvz) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(13866, new Object[]{Integer.valueOf(7), this.dxJ, com.tencent.mm.a.o.getString(this.dxI)});
                intent = new Intent(this, CardHomePageUI.class);
                intent.putExtra("key_home_page_from_scene", 2);
                startActivity(intent);
                x.i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
                finish();
                overridePendingTransition(0, 0);
            }
        } else if (view.getId() == d.tv_gift_card_operate) {
            if (!TextUtils.isEmpty(this.hDa.hvT) && !TextUtils.isEmpty(this.hDa.hvU)) {
                com.tencent.mm.plugin.card.d.b.e(this.hDa.hvK, this.hDa.hvT, this.hDa.hvU, 1062, getIntent().getIntExtra("key_from_appbrand_type", 0));
                com.tencent.mm.plugin.report.service.h.mEJ.h(13866, new Object[]{Integer.valueOf(8), this.dxJ, com.tencent.mm.a.o.getString(this.dxI)});
            } else if (!bi.oW(this.hDa.hvM)) {
                com.tencent.mm.plugin.card.d.b.a(this, this.hDa.hvM, 0);
                com.tencent.mm.plugin.report.service.h.mEJ.h(13866, new Object[]{Integer.valueOf(8), this.dxJ, com.tencent.mm.a.o.getString(this.dxI)});
            }
        } else if (view.getId() == d.iv_gift_card || view.getId() == d.iv_sender_gift_card) {
            if (bi.oW(this.hDa.hvN) || bi.oW(this.hDa.hvO)) {
                x.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
                return;
            }
            LinkedList linkedList = new LinkedList();
            lg lgVar = new lg();
            lgVar.huU = this.hDa.hvN;
            lgVar.code = this.hDa.hvO;
            linkedList.add(lgVar);
            String stringExtra = getIntent().getStringExtra("key_template_id");
            bqs bqs = new bqs();
            bqs.soQ = stringExtra;
            x.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[]{stringExtra});
            g.Eh().dpP.a(new t(linkedList, bqs, 27), 0);
            com.tencent.mm.plugin.report.service.h.mEJ.h(13866, new Object[]{Integer.valueOf(9), this.dxJ, com.tencent.mm.a.o.getString(this.dxI)});
        } else if (view.getId() != d.tv_show_all) {
        } else {
            if (this.hDK.getVisibility() == 0) {
                this.hDK.setVisibility(8);
                this.hDI.setText("查看全部");
                return;
            }
            this.hDK.setVisibility(0);
            this.hDI.setText("收起");
        }
    }
}
