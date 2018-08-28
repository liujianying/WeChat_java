package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class d extends a {
    private View hJo;
    private TextView hJp;
    private TextView hJq;
    private View hJr;
    private TextView hJs;
    private TextView hJt;
    private View hJu;
    private View hJv;
    private View hJw;

    public d(Context context) {
        super(context);
    }

    protected final void azZ() {
        this.hJo = this.hJb.findViewById(com.tencent.mm.plugin.card.a.d.payer_layout);
        this.hJp = (TextView) this.hJb.findViewById(com.tencent.mm.plugin.card.a.d.payer_title);
        this.hJq = (TextView) this.hJb.findViewById(com.tencent.mm.plugin.card.a.d.payer_sub_title);
        this.hJr = this.hJb.findViewById(com.tencent.mm.plugin.card.a.d.billto_layout);
        this.hJs = (TextView) this.hJb.findViewById(com.tencent.mm.plugin.card.a.d.billto_title);
        this.hJt = (TextView) this.hJb.findViewById(com.tencent.mm.plugin.card.a.d.billto_sub_title);
        this.hJv = this.hJb.findViewById(com.tencent.mm.plugin.card.a.d.card_widget_status_layout);
        this.hJw = this.hJb.findViewById(com.tencent.mm.plugin.card.a.d.card_bottom_dash_divider_2);
    }

    protected final void aAa() {
        pr prVar;
        if (this.htQ.awm().rnG == null || this.htQ.awm().rnG.size() <= 0) {
            x.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
        } else {
            LinkedList linkedList = this.htQ.awm().rnG;
            pr prVar2 = null;
            if (linkedList.size() == 1) {
                prVar = (pr) linkedList.get(0);
            } else {
                prVar = (pr) linkedList.get(0);
                prVar2 = (pr) linkedList.get(1);
            }
            if (prVar != null) {
                this.hJo.setVisibility(0);
                this.hJp.setText(prVar.title);
                this.hJq.setText(prVar.huX);
                if (!TextUtils.isEmpty(prVar.roM)) {
                    this.hJp.setTextColor(l.xV(prVar.roM));
                }
                if (!TextUtils.isEmpty(prVar.roN)) {
                    this.hJq.setTextColor(l.xV(prVar.roN));
                }
            }
            if (prVar2 != null) {
                this.hJr.setVisibility(0);
                this.hJs.setText(prVar2.title);
                this.hJt.setText(prVar2.huX);
                if (!TextUtils.isEmpty(prVar2.roM)) {
                    this.hJs.setTextColor(l.xV(prVar2.roM));
                }
                if (!TextUtils.isEmpty(prVar2.roN)) {
                    this.hJt.setTextColor(l.xV(prVar2.roN));
                }
            }
        }
        if (this.htQ.avR() && !this.htQ.avX()) {
            x.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        } else if (this.htQ.awn().rnd == null || this.htQ.awn().rnd.size() <= 0) {
            if (this.hJu != null) {
                this.hJu.setVisibility(8);
            }
            this.hJb.findViewById(com.tencent.mm.plugin.card.a.d.card_bottom_dash_divider_2).setVisibility(8);
        } else {
            if (this.hJu == null) {
                this.hJu = ((ViewStub) this.hJb.findViewById(com.tencent.mm.plugin.card.a.d.card_secondary_field_list_stub)).inflate();
            }
            this.hJb.findViewById(com.tencent.mm.plugin.card.a.d.card_bottom_dash_divider_2).setVisibility(8);
            View view = this.hJu;
            b bVar = this.htQ;
            OnClickListener onClickListener = this.eZF;
            LinkedList linkedList2 = bVar.awn().rnd;
            if (linkedList2.size() == 1) {
                view.findViewById(com.tencent.mm.plugin.card.a.d.card_secondary_field_view_1).setVisibility(0);
                prVar = (pr) linkedList2.get(0);
                ((TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.secondary_field_title_1)).setText(prVar.title);
                ((TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.secondary_field_subtitle_1)).setText(prVar.huX);
                view.findViewById(com.tencent.mm.plugin.card.a.d.card_secondary_field_view_1).setOnClickListener(onClickListener);
                if (!TextUtils.isEmpty(prVar.roM)) {
                    ((TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.secondary_field_title_1)).setTextColor(l.xV(prVar.roM));
                }
                if (!TextUtils.isEmpty(prVar.roN)) {
                    ((TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.secondary_field_subtitle_1)).setTextColor(l.xV(prVar.roN));
                }
                view.findViewById(com.tencent.mm.plugin.card.a.d.card_secondary_field_view_2).setVisibility(8);
            } else if (linkedList2.size() >= 2) {
                prVar = (pr) linkedList2.get(0);
                ((TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.secondary_field_title_1)).setText(prVar.title);
                ((TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.secondary_field_subtitle_1)).setText(prVar.huX);
                if (!TextUtils.isEmpty(prVar.roM)) {
                    ((TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.secondary_field_title_1)).setTextColor(l.xV(prVar.roM));
                }
                if (!TextUtils.isEmpty(prVar.roN)) {
                    ((TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.secondary_field_subtitle_1)).setTextColor(l.xV(prVar.roN));
                }
                prVar = (pr) linkedList2.get(1);
                ((TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.secondary_field_title_2)).setText(prVar.title);
                ((TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.secondary_field_subtitle_2)).setText(prVar.huX);
                if (!TextUtils.isEmpty(prVar.roM)) {
                    ((TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.secondary_field_title_2)).setTextColor(l.xV(prVar.roM));
                }
                if (!TextUtils.isEmpty(prVar.roN)) {
                    ((TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.secondary_field_subtitle_2)).setTextColor(l.xV(prVar.roN));
                }
                view.findViewById(com.tencent.mm.plugin.card.a.d.card_secondary_field_view_1).setOnClickListener(onClickListener);
                view.findViewById(com.tencent.mm.plugin.card.a.d.card_secondary_field_view_2).setOnClickListener(onClickListener);
            }
        }
        if (this.htQ.awi()) {
            this.hJv.setVisibility(8);
        } else {
            this.hJv.setVisibility(0);
            TextView textView = (TextView) this.hJv.findViewById(com.tencent.mm.plugin.card.a.d.card_status_tv);
            if (TextUtils.isEmpty(this.htQ.awm().roe)) {
                m.b(textView, this.htQ.awn().status);
            } else {
                textView.setText(this.htQ.awm().roe);
            }
        }
        if (this.htQ.awn().rnm == null && this.htQ.awi()) {
            this.hJw.setVisibility(0);
        } else {
            this.hJw.setVisibility(8);
        }
    }
}
