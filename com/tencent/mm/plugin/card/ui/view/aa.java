package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ak.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;

public final class aa implements c {
    protected LinkedList<CardTagTextView> hAD = new LinkedList();
    private BaseAdapter hAv;
    private int hAz;
    private int hGH;
    int hGI;
    int hGJ;
    private Context mContext;

    public aa(Context context, BaseAdapter baseAdapter) {
        this.mContext = context;
        this.hAv = baseAdapter;
        this.hGH = this.mContext.getResources().getDimensionPixelSize(b.SmallestPadding);
        this.hAz = this.mContext.getResources().getDimensionPixelSize(b.MiddlePadding);
        this.hGI = this.mContext.getResources().getDimensionPixelOffset(b.card_item_bg_corner);
        this.hGJ = this.mContext.getResources().getDimensionPixelOffset(b.card_item_height);
    }

    public final void release() {
        this.mContext = null;
        this.hAv = null;
        if (this.hAD != null) {
            this.hAD.clear();
        }
    }

    public final View a(int i, View view, com.tencent.mm.plugin.card.base.b bVar) {
        a aVar;
        if (view == null) {
            View inflate;
            switch (this.hAv.getItemViewType(i)) {
                case 0:
                    inflate = View.inflate(this.mContext, e.card_list_group_header, null);
                    TextView textView;
                    if (!bVar.awq().equals("PRIVATE_TICKET_TITLE")) {
                        if (bVar.awq().equals("PRIVATE_INVOICE_TITLE")) {
                            textView = (TextView) inflate.findViewById(d.card_list_header_text);
                            if (textView != null) {
                                textView.setText(this.mContext.getString(g.card_invoice_list_title));
                                break;
                            }
                        }
                    }
                    textView = (TextView) inflate.findViewById(d.card_list_header_text);
                    if (textView != null) {
                        textView.setText(this.mContext.getString(g.card_ticket_list_title));
                        break;
                    }
                    break;
                case 1:
                    inflate = View.inflate(this.mContext, e.card_item, null);
                    break;
                case 2:
                    inflate = View.inflate(this.mContext, e.card_list_invoice_item, null);
                    break;
                default:
                    inflate = View.inflate(this.mContext, e.card_item, null);
                    break;
            }
            a aVar2 = new a(this);
            if (bVar.awq().equals("PRIVATE_TICKET_TITLE") || bVar.awq().equals("PRIVATE_INVOICE_TITLE")) {
                aVar2.hIq = (TextView) inflate.findViewById(d.card_list_header_text);
            } else if (bVar.avX()) {
                aVar2.hIr = (TextView) inflate.findViewById(d.card_list_invoice_title);
                aVar2.hIs = (TextView) inflate.findViewById(d.card_list_invoice_date);
                aVar2.hIt = (TextView) inflate.findViewById(d.card_list_invoice_name);
                aVar2.hIu = (TextView) inflate.findViewById(d.card_list_invoice_sum);
            } else {
                aVar2.hAH = (RelativeLayout) inflate.findViewById(d.card_container_parent);
                aVar2.hAI = (ImageView) inflate.findViewById(d.card_img);
                aVar2.hFU = inflate.findViewById(d.card_type_img_layout);
                aVar2.hFV = (ImageView) inflate.findViewById(d.card_type_img);
                aVar2.hAJ = (TextView) inflate.findViewById(d.card_brand_name);
                aVar2.hAK = (TextView) inflate.findViewById(d.card_name);
                aVar2.hAN = (TextView) inflate.findViewById(d.card_not_support_tip);
                aVar2.hGK = (ImageView) inflate.findViewById(d.card_add_img);
                aVar2.hGM = (ImageView) inflate.findViewById(d.card_bg_img);
                aVar2.hGN = (ImageView) inflate.findViewById(d.card_bg_shadow_img);
                aVar2.hGO = (ImageView) inflate.findViewById(d.card_bg_pattern_img);
                aVar2.hGL = (LinearLayout) inflate.findViewById(d.card_right_tag_layout);
            }
            inflate.setTag(aVar2);
            aVar = aVar2;
            view = inflate;
        } else {
            a aVar3 = (a) view.getTag();
            if (aVar3.hIq != null) {
                if (bVar.awq().equals("PRIVATE_TICKET_TITLE")) {
                    aVar3.hIq.setText(this.mContext.getString(g.card_ticket_list_title));
                    aVar = aVar3;
                } else {
                    aVar3.hIq.setText(this.mContext.getString(g.card_invoice_list_title));
                }
            }
            aVar = aVar3;
        }
        if (aVar.hAK != null) {
            aVar.hAK.setTextSize(0, this.mContext.getResources().getDimension(b.BigerTextSize));
        }
        if (bVar.avY()) {
            if (bVar.awq().equals("PRIVATE_TICKET_TITLE")) {
                aVar.hIq.setText(this.mContext.getString(g.card_ticket_list_title));
            } else if (bVar.awq().equals("PRIVATE_INVOICE_TITLE")) {
                aVar.hIq.setText(this.mContext.getString(g.card_invoice_list_title));
            } else if (bVar.avX()) {
                LinkedList linkedList = bVar.awm().rnG;
                aVar.hIr.setText(((pr) linkedList.get(0)).huX);
                aVar.hIt.setText(((pr) linkedList.get(1)).huX);
                linkedList = bVar.awn().rnd;
                aVar.hIu.setText(String.format(this.mContext.getString(g.card_list_invoice_sum), new Object[]{((pr) linkedList.get(0)).huX}));
                if (linkedList.size() >= 2) {
                    aVar.hIs.setText(((pr) linkedList.get(1)).huX);
                }
            } else {
                if (this.hAv.getItem(i) instanceof CardInfo) {
                    CardInfo cardInfo = (CardInfo) this.hAv.getItem(i);
                    if (!(cardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE") || cardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE"))) {
                        boolean z;
                        CharSequence a;
                        if (cardInfo.field_stickyIndex % 10 != 0) {
                            if (cardInfo.field_stickyIndex > 0) {
                                z = true;
                                a = j.a(this.mContext, cardInfo.field_stickyIndex, cardInfo);
                            }
                            z = false;
                            a = null;
                        } else {
                            if (!bi.oW(cardInfo.field_label_wording)) {
                                z = true;
                                Object a2 = cardInfo.field_label_wording;
                            }
                            z = false;
                            a2 = null;
                        }
                        if (z) {
                            for (int i2 = 0; i2 < aVar.hGL.getChildCount(); i2++) {
                                this.hAD.add((CardTagTextView) aVar.hGL.getChildAt(i2));
                            }
                            aVar.hGL.removeAllViews();
                            aVar.hGL.setVisibility(0);
                            CardTagTextView cardTagTextView = this.hAD.size() == 0 ? new CardTagTextView(this.mContext) : (CardTagTextView) this.hAD.removeFirst();
                            cardTagTextView.setPadding(this.hAz, this.hGH, this.hAz, this.hGH);
                            cardTagTextView.setGravity(17);
                            cardTagTextView.setMinWidth(this.mContext.getResources().getDimensionPixelSize(b.card_item_tag_width));
                            cardTagTextView.setMinHeight(this.mContext.getResources().getDimensionPixelSize(b.card_item_tag_height));
                            if (cardInfo.avT()) {
                                cardTagTextView.setTextColor(a.g(this.mContext, com.tencent.mm.plugin.card.a.a.white));
                                cardTagTextView.setFillColor(a.g(this.mContext, com.tencent.mm.plugin.card.a.a.card_member_card_fill_color));
                            } else {
                                cardTagTextView.setTextColor(a.g(this.mContext, com.tencent.mm.plugin.card.a.a.link_color));
                                cardTagTextView.setFillColor(0);
                            }
                            cardTagTextView.setText(a2);
                            cardTagTextView.setTextSize(1, 10.0f);
                            aVar.hGL.addView(cardTagTextView);
                        } else {
                            aVar.hGL.setVisibility(8);
                        }
                    }
                }
                aVar.hAH.setVisibility(0);
                aVar.hAI.setVisibility(0);
                aVar.hAK.setVisibility(0);
                aVar.hAN.setVisibility(8);
                aVar.hAJ.setVisibility(0);
                aVar.hAJ.setText(bVar.awm().hwh);
                aVar.hAK.setText(bVar.awm().title);
                if (bVar.avV()) {
                    aVar.hFU.setVisibility(0);
                    aVar.hAI.setVisibility(4);
                    ImageView imageView = aVar.hFV;
                    if (TextUtils.isEmpty(bVar.awm().rnO)) {
                        m.a(imageView, com.tencent.mm.plugin.card.a.c.card_ticket_normal_icon, l.xV(bVar.awm().dxh));
                    } else {
                        m.a(this.mContext, imageView, bVar.awm().rnO, this.mContext.getResources().getDimensionPixelSize(b.card_list_logo_height), com.tencent.mm.plugin.card.a.c.card_ticket_normal_icon, l.xV(bVar.awm().dxh));
                    }
                } else {
                    aVar.hFU.setVisibility(8);
                    aVar.hAI.setVisibility(0);
                    m.a(aVar.hAI, bVar.awm().huW, this.mContext.getResources().getDimensionPixelSize(b.card_list_logo_height), com.tencent.mm.plugin.card.a.c.my_card_package_defaultlogo, true);
                }
                if (bVar.avT()) {
                    if (bi.oW(bVar.awn().rnn)) {
                        aVar.hAH.setBackgroundDrawable(l.cm(l.xV(bVar.awm().dxh), this.hGI));
                        aVar.hGM.setVisibility(8);
                        aVar.hGN.setVisibility(8);
                        aVar.hGO.setVisibility(0);
                    } else {
                        aVar.hAH.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.tencent.mm.plugin.card.a.c.card_item_bg_selector));
                        aVar.hGM.setVisibility(0);
                        aVar.hGN.setVisibility(0);
                        ImageView imageView2 = aVar.hGM;
                        String str = bVar.awn().rnn;
                        com.tencent.mm.ak.a.a.c.a aVar4 = new com.tencent.mm.ak.a.a.c.a();
                        aVar4.dXB = com.tencent.mm.compatible.util.e.bnE;
                        o.Pk();
                        aVar4.dXU = null;
                        aVar4.dXA = com.tencent.mm.plugin.card.model.m.xr(str);
                        aVar4.dXy = true;
                        aVar4.dXY = true;
                        aVar4.dXw = true;
                        aVar4.dXN = com.tencent.mm.plugin.card.a.c.card_item_bg_selector;
                        aVar4.dXF = a.ad(this.mContext, b.card_item_height);
                        aVar4.dXE = a.fk(this.mContext);
                        o.Pj().a(str, imageView2, aVar4.Pt());
                        imageView2.setImageMatrix(new Matrix());
                        aVar.hGO.setVisibility(8);
                    }
                    aVar.hAJ.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.white));
                    aVar.hAK.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.white));
                } else {
                    aVar.hGO.setVisibility(8);
                    aVar.hGM.setVisibility(8);
                    aVar.hGN.setVisibility(8);
                    aVar.hAH.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.tencent.mm.plugin.card.a.c.card_item_bg_selector));
                    aVar.hAK.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.card_black_color));
                    aVar.hAJ.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.card_black_color));
                }
            }
        } else if (!(bVar.awq().equals("PRIVATE_TICKET_TITLE") || bVar.awq().equals("PRIVATE_INVOICE_TITLE") || bVar.avX())) {
            aVar.hAI.setVisibility(8);
            aVar.hAK.setVisibility(8);
            aVar.hAJ.setVisibility(8);
            aVar.hGL.setVisibility(8);
            aVar.hAN.setVisibility(0);
            aVar.hAH.setBackgroundDrawable(l.cm(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.card_list_item_not_support_type_bg), this.hGI));
            aVar.hAN.setText(this.mContext.getResources().getString(g.card_not_support_card_type));
        }
        if (!(bVar.awq().equals("PRIVATE_TICKET_TITLE") || bVar.awq().equals("PRIVATE_INVOICE_TITLE") || bVar.avX())) {
            int i3 = bVar.awm().huV;
            LayoutParams layoutParams;
            if (i != this.hAv.getCount() - 1 || aVar.hAH == null) {
                layoutParams = (LayoutParams) aVar.hAH.getLayoutParams();
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    aVar.hAH.setLayoutParams(layoutParams);
                }
            } else {
                layoutParams = (LayoutParams) aVar.hAH.getLayoutParams();
                if (layoutParams.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(b.LittlePadding)) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(b.LittlePadding);
                    aVar.hAH.setLayoutParams(layoutParams);
                }
            }
        }
        return view;
    }

    public final void v(View view, int i) {
        ((com.tencent.mm.plugin.card.ui.l.a) view.getTag()).hGK.setImageResource(i);
    }

    public final void w(View view, int i) {
        ((com.tencent.mm.plugin.card.ui.l.a) view.getTag()).hGK.setVisibility(i);
    }

    public final void a(View view, int i, OnClickListener onClickListener) {
        CardInfo cardInfo = (CardInfo) this.hAv.getItem(i);
        if (!cardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE") && !cardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")) {
            a aVar = (a) view.getTag();
            aVar.hGK.setTag(Integer.valueOf(i));
            aVar.hGK.setOnClickListener(onClickListener);
        }
    }
}
