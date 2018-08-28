package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a$e;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class w extends i {
    private View hIb;
    private View hIc;

    public final void initView() {
    }

    public final void update() {
        b ayu = this.hHF.ayu();
        g ayz = this.hHF.ayz();
        pr prVar;
        if (ayu.awn().rnd != null && ayu.awn().rnd.size() > 1) {
            if (this.hIb == null) {
                this.hIb = ((ViewStub) findViewById(d.card_secondary_field_stub)).inflate();
            }
            if (this.hIc != null) {
                this.hIc.setVisibility(8);
            }
            MMActivity ayx = this.hHF.ayx();
            View view = this.hIb;
            OnClickListener ayy = this.hHF.ayy();
            LinkedList linkedList = ayu.awn().rnd;
            int xV = l.xV(ayu.awm().dxh);
            ((ViewGroup) view).removeAllViews();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                prVar = (pr) it.next();
                View inflate = y.gq(ayx).inflate(a$e.card_secondary_field_layout_item, (ViewGroup) view, false);
                inflate.setId(d.card_secondary_field_view);
                inflate.setTag(Integer.valueOf(linkedList.indexOf(prVar)));
                inflate.setOnClickListener(ayy);
                if (TextUtils.isEmpty(prVar.url)) {
                    inflate.setEnabled(false);
                }
                ((TextView) inflate.findViewById(d.secondary_field_title)).setText(prVar.title);
                TextView textView = (TextView) inflate.findViewById(d.secondary_field_subtitle);
                textView.setText(prVar.huX);
                textView.setTextColor(xV);
                ((ViewGroup) view).addView(inflate);
                if (linkedList.indexOf(prVar) + 1 != linkedList.size()) {
                    ((ViewGroup) view).addView(y.gq(ayx).inflate(a$e.card_secondary_field_layout_item_seperator, (ViewGroup) view, false));
                }
            }
            if (!(!ayu.avT() || ayu.awn().rnk == null || TextUtils.isEmpty(ayu.awn().rnk.title))) {
                this.hIb.setBackgroundResource(c.mm_trans);
            }
            if (!ayu.avT() && ayz.azv()) {
                this.hIb.setBackgroundResource(c.mm_trans);
            }
        } else if (ayu.awn().rnd == null || ayu.awn().rnd.size() != 1) {
            if (this.hIb != null) {
                this.hIb.setVisibility(8);
            }
            if (this.hIc != null) {
                this.hIc.setVisibility(8);
            }
        } else {
            if (this.hIc == null) {
                this.hIc = ((ViewStub) findViewById(d.card_secondary_field_single_stub)).inflate();
            }
            if (this.hIb != null) {
                this.hIb.setVisibility(8);
            }
            View view2 = this.hIc;
            OnClickListener ayy2 = this.hHF.ayy();
            LinkedList linkedList2 = ayu.awn().rnd;
            if (linkedList2.size() == 1) {
                view2.findViewById(d.card_secondary_field_view_1).setVisibility(0);
                prVar = (pr) linkedList2.get(0);
                ((TextView) view2.findViewById(d.secondary_field_title_1)).setText(prVar.title);
                ((TextView) view2.findViewById(d.secondary_field_subtitle_1)).setText(prVar.huX);
                ((TextView) view2.findViewById(d.secondary_field_subtitle_1)).setTextColor(l.xV(ayu.awm().dxh));
                view2.findViewById(d.card_secondary_field_view_1).setOnClickListener(ayy2);
                if (TextUtils.isEmpty(prVar.url)) {
                    view2.findViewById(d.card_secondary_field_view_1).setEnabled(false);
                }
            }
            if (!(!ayu.avT() || ayu.awn().rnk == null || TextUtils.isEmpty(ayu.awn().rnk.title))) {
                this.hIc.setBackgroundResource(c.mm_trans);
            }
            if (!ayu.avT() && ayz.azv()) {
                this.hIc.setBackgroundResource(c.mm_trans);
            }
        }
    }

    public final void azI() {
        if (this.hIb != null) {
            this.hIb.setVisibility(8);
        }
        if (this.hIc != null) {
            this.hIc.setVisibility(8);
        }
    }
}
