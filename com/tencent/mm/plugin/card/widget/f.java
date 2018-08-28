package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class f extends a {
    protected TextView eCm;
    private View hJF;
    private ImageView hJG;
    private TextView hJH;
    private TextView hJI;
    private View hJJ;
    private TextView hJK;
    private TextView hJL;
    private ImageView hJM;
    private TextView hJN;
    public ArrayList<la> htW;

    public f(Context context) {
        super(context);
    }

    protected final void azZ() {
        this.eCm = (TextView) azY().findViewById(d.card_title);
        this.hJF = azY().findViewById(d.card_bottom_dash_divider);
        this.hJG = (ImageView) azY().findViewById(d.ticket_icon);
        this.hJH = (TextView) azY().findViewById(d.ticket_content_title);
        this.hJI = (TextView) azY().findViewById(d.ticket_content_sub_title);
        this.hJJ = azY().findViewById(d.ticket_shop_layout);
        this.hJK = (TextView) azY().findViewById(d.ticket_shop_title);
        this.hJL = (TextView) azY().findViewById(d.ticket_shop_sub_title);
        this.hJM = (ImageView) azY().findViewById(d.ticket_place_icon);
        this.hJN = (TextView) azY().findViewById(d.ticket_check_more_adapted_stores);
    }

    protected final void aAa() {
        if (this.htQ.awm().roi != null && !TextUtils.isEmpty(this.htQ.awm().roi.title)) {
            this.hJd.setText(this.htQ.awm().roi.title);
        } else if (TextUtils.isEmpty(this.htQ.awm().hwh)) {
            this.hJd.setText("");
        } else {
            this.hJd.setText(this.htQ.awm().hwh);
        }
        if (this.htQ.awm().roi == null || TextUtils.isEmpty(this.htQ.awm().roi.huX)) {
            this.eCm.setText("");
            this.eCm.setVisibility(8);
        } else {
            this.eCm.setText(this.htQ.awm().roi.huX);
            this.eCm.setVisibility(0);
        }
        x.i("MicroMsg.CardWidgetTicket", "updateContentView()");
        if (bi.oW(this.htQ.awm().rnO)) {
            m.a(this.hJG, c.card_ticket_normal_icon, l.xV(this.htQ.awm().dxh));
        } else {
            m.a(this.mContext, this.hJG, this.htQ.awm().rnO, this.mContext.getResources().getDimensionPixelSize(b.card_ticket_widget_logo_size), c.card_ticket_normal_icon, l.xV(this.htQ.awm().dxh));
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        pr prVar;
        if (this.htQ.awm().rnG != null && this.htQ.awm().rnG.size() >= 2) {
            x.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
            prVar = (pr) this.htQ.awm().rnG.get(0);
            pr prVar2 = (pr) this.htQ.awm().rnG.get(1);
            stringBuilder.append(prVar.title).append(" - ").append(prVar2.title);
            if (!(TextUtils.isEmpty(prVar.huY) || TextUtils.isEmpty(prVar2.huY))) {
                stringBuilder2.append(prVar.huY).append(" ").append(prVar.huX);
                stringBuilder2.append(" - ");
                stringBuilder2.append(prVar2.huY).append(" ").append(prVar2.huX);
            }
        } else if (this.htQ.awm().rnG != null && this.htQ.awm().rnG.size() == 1) {
            x.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
            prVar = (pr) this.htQ.awm().rnG.get(0);
            stringBuilder.append(prVar.title);
            stringBuilder2.append(prVar.huX);
        }
        if (TextUtils.isEmpty(stringBuilder.toString())) {
            this.hJH.setText("");
        } else {
            this.hJH.setText(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(stringBuilder2.toString())) {
            x.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
            this.hJI.setText(stringBuilder2.toString());
            this.hJI.setVisibility(0);
        } else if (TextUtils.isEmpty(this.htQ.awm().rnW)) {
            this.hJI.setVisibility(8);
        } else {
            x.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
            this.hJI.setText(this.htQ.awm().rnW);
            this.hJI.setVisibility(0);
        }
        x.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.htQ.awm().rnK);
        if (this.htQ.awm().rnK <= 0) {
            this.hJJ.setVisibility(8);
            this.hJN.setVisibility(8);
        } else {
            la laVar;
            this.hJJ.setVisibility(0);
            this.hJJ.setOnClickListener(this.eZF);
            m.a(this.hJM, c.card_ticket_place_icon, l.xV(this.htQ.awm().dxh));
            if (this.htW == null || this.htW.size() <= 0) {
                laVar = null;
            } else {
                laVar = (la) this.htW.get(0);
            }
            if (this.htQ.awm().rnK == 1 && laVar != null) {
                this.hJK.setText(laVar.name);
                this.hJL.setText(this.mContext.getString(g.card_shop_distance_address, new Object[]{l.f(this.mContext, laVar.rnu), laVar.dRH}));
                this.hJN.setVisibility(8);
                this.hJJ.setTag(laVar.name);
            } else if (this.htQ.awm().rnK > 1 && laVar != null) {
                this.hJK.setText(laVar.name);
                this.hJL.setText(this.mContext.getString(g.card_shop_distance_address, new Object[]{l.f(this.mContext, laVar.rnu), laVar.dRH}));
                this.hJN.setVisibility(0);
                this.hJN.setOnClickListener(this.eZF);
                this.hJJ.setTag(laVar.name);
            } else if (this.htQ.awm().rnK > 0) {
                this.hJK.setText(g.card_check_all_adapted_stores);
                this.hJL.setText(this.mContext.getString(g.card_total_adapted_stores, new Object[]{Integer.valueOf(this.htQ.awm().rnK)}));
                this.hJN.setVisibility(8);
                this.hJN.setOnClickListener(null);
                this.hJJ.setTag(this.mContext.getString(g.card_check_all_adapted_stores));
            }
        }
        if (this.htQ.awl()) {
            this.hJF.setVisibility(8);
        } else {
            this.hJF.setVisibility(0);
        }
    }
}
