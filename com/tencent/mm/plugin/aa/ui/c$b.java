package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.contact.a.a.b;

public class c$b extends b {
    final /* synthetic */ c eCp;

    public c$b(c cVar) {
        this.eCp = cVar;
        super(cVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate;
        if (a.fi(context)) {
            inflate = LayoutInflater.from(context).inflate(a$g.select_ui_listcontactitem_large, viewGroup, false);
        } else {
            inflate = LayoutInflater.from(context).inflate(a$g.select_ui_listcontactitem, viewGroup, false);
        }
        c.a aVar = this.eCp.eCk;
        aVar.eCl = (ImageView) inflate.findViewById(a$f.avatar_iv);
        aVar.eCm = (TextView) inflate.findViewById(a$f.title_tv);
        aVar.eCn = (TextView) inflate.findViewById(a$f.desc_tv);
        aVar.contentView = inflate.findViewById(a$f.select_item_content_layout);
        aVar.eCo = (CheckBox) inflate.findViewById(a$f.select_cb);
        LayoutParams layoutParams = (LayoutParams) aVar.eCo.getLayoutParams();
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(d.aa_select_contact_cb_left_margin);
        layoutParams.rightMargin = context.getResources().getDimensionPixelSize(d.aa_select_contact_cb_right_margin);
        aVar.eCo.setLayoutParams(layoutParams);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
        c.a aVar3 = (c.a) aVar;
        c cVar = (c) aVar2;
        if (cVar.username == null || cVar.username.length() <= 0) {
            aVar3.eCl.setImageResource(e.default_avatar);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.eCl, cVar.username);
        }
        if (bi.K(cVar.eCh)) {
            aVar3.eCm.setVisibility(8);
        } else {
            aVar3.eCm.setText(cVar.eCh);
            aVar3.eCm.setVisibility(0);
        }
        if (bi.K(cVar.eCi)) {
            aVar3.eCn.setVisibility(8);
        } else {
            aVar3.eCn.setText(cVar.eCi);
            aVar3.eCn.setVisibility(0);
        }
        if (this.eCp.ujX) {
            if (z) {
                aVar3.eCo.setChecked(true);
                aVar3.eCo.setEnabled(false);
            } else {
                aVar3.eCo.setChecked(z2);
                aVar3.eCo.setEnabled(true);
            }
            aVar3.eCo.setVisibility(0);
        } else {
            aVar3.eCo.setVisibility(8);
        }
        if (this.eCp.hoR) {
            aVar3.contentView.setBackgroundResource(e.comm_list_item_selector_no_divider);
        } else {
            aVar3.contentView.setBackgroundResource(e.comm_list_item_selector);
        }
        if (cVar.guS.field_deleteFlag == 1) {
            aVar3.eCn.setVisibility(0);
            aVar3.eCn.setText(context.getString(i.aa_address_account_deleted));
        }
    }

    public final boolean Wi() {
        return false;
    }
}
