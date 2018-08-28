package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a$a;
import com.tencent.mm.plugin.card.a$e;
import com.tencent.mm.plugin.card.a$g;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.protocal.c.pr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a extends BaseAdapter {
    HashMap<String, Integer> hAR = new HashMap();
    List<CardInfo> hzT = new ArrayList();
    Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.hzT.size();
    }

    /* renamed from: nQ */
    public final CardInfo getItem(int i) {
        return (CardInfo) this.hzT.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CardInfo nQ = getItem(i);
        if (view == null) {
            view = View.inflate(this.mContext, a$e.card_accept_card_list_item, null);
            aVar = new a(this);
            aVar.hAH = (RelativeLayout) view.findViewById(d.card_container_parent);
            aVar.hAS = (LinearLayout) view.findViewById(d.card_top_container);
            aVar.hAI = (ImageView) view.findViewById(d.card_img);
            aVar.hAJ = (TextView) view.findViewById(d.card_brand_name);
            aVar.hAK = (TextView) view.findViewById(d.card_name);
            aVar.hAL = (TextView) view.findViewById(d.subtitle);
            aVar.hAN = (TextView) view.findViewById(d.card_not_support_tip);
            aVar.hAT = (ImageView) view.findViewById(d.card_lucky_icon);
            aVar.hAU = (TextView) view.findViewById(d.card_count);
            aVar.hAV = (TextView) view.findViewById(d.card_status);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (nQ.avY()) {
            aVar.hAI.setVisibility(0);
            aVar.hAK.setVisibility(0);
            aVar.hAL.setVisibility(0);
            aVar.hAN.setVisibility(8);
            aVar.hAJ.setVisibility(0);
            aVar.hAJ.setText(nQ.awm().hwh);
            if (!nQ.avV()) {
                aVar.hAK.setText(nQ.awm().title);
            } else if (nQ.awm().rnG != null && nQ.awm().rnG.size() == 1) {
                aVar.hAK.setText(((pr) nQ.awm().rnG.get(0)).title);
            } else if (nQ.awm().rnG != null && nQ.awm().rnG.size() == 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(((pr) nQ.awm().rnG.get(0)).title);
                stringBuilder.append("-");
                stringBuilder.append(((pr) nQ.awm().rnG.get(1)).title);
                aVar.hAK.setText(stringBuilder.toString());
            }
            if (nQ.awm().rof == 1) {
                aVar.hAT.setVisibility(0);
            } else {
                aVar.hAT.setVisibility(8);
            }
            long j = nQ.field_begin_time;
            if (nQ.getEndTime() > 0 && j > 0) {
                aVar.hAL.setText(this.mContext.getString(a$g.card_validate_to_format_day, new Object[]{l.bx(j) + "  -  " + l.bx(nQ.getEndTime())}));
                aVar.hAL.setVisibility(0);
            } else if (nQ.getEndTime() > 0) {
                aVar.hAL.setText(this.mContext.getString(a$g.card_validate_to, new Object[]{l.bx(nQ.getEndTime())}));
                aVar.hAL.setVisibility(0);
            } else {
                aVar.hAL.setText("");
                aVar.hAL.setVisibility(8);
            }
            m.a(aVar.hAI, nQ.awm().huW, this.mContext.getResources().getDimensionPixelSize(b.card_list_logo_height), c.my_card_package_defaultlogo, true);
            if (nQ.awm().rod == 1) {
                aVar.hAI.setAlpha(255);
                aVar.hAV.setVisibility(8);
                aVar.hAK.setTextColor(this.mContext.getResources().getColor(a$a.card_black_color));
                aVar.hAJ.setTextColor(this.mContext.getResources().getColor(a$a.card_black_color));
                aVar.hAL.setTextColor(this.mContext.getResources().getColor(a$a.grey_background_text_color));
            } else {
                aVar.hAV.setText(nQ.awm().roe);
                aVar.hAI.setAlpha(90);
                aVar.hAV.setVisibility(0);
                aVar.hAK.setTextColor(this.mContext.getResources().getColor(a$a.grey_background_text_color));
                aVar.hAJ.setTextColor(this.mContext.getResources().getColor(a$a.grey_background_text_color));
                aVar.hAL.setTextColor(this.mContext.getResources().getColor(a$a.grey_background_text_color));
            }
            int intValue = ((Integer) this.hAR.get(nQ.awr())).intValue();
            if (intValue == 1) {
                aVar.hAU.setText("");
                aVar.hAU.setVisibility(8);
            } else {
                aVar.hAU.setText("x" + intValue);
                aVar.hAU.setVisibility(0);
            }
        } else {
            aVar.hAI.setVisibility(8);
            aVar.hAK.setVisibility(8);
            aVar.hAJ.setVisibility(8);
            aVar.hAL.setVisibility(8);
            aVar.hAV.setVisibility(8);
            aVar.hAU.setVisibility(8);
            aVar.hAN.setVisibility(0);
            aVar.hAH.setBackgroundColor(this.mContext.getResources().getColor(a$a.card_list_item_not_support_type_bg));
            aVar.hAN.setText(this.mContext.getResources().getString(a$g.card_not_support_card_type));
        }
        return view;
    }
}
