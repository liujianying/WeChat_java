package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.encode.ui.c.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.a.d.b;

public class c$a$b extends b {
    final /* synthetic */ a nfU;

    public c$a$b(a aVar) {
        this.nfU = aVar;
        super(aVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.i.sight_select_contact_item, viewGroup, false);
        a.a aVar = (a.a) this.nfU.Wh();
        aVar.eCl = (ImageView) inflate.findViewById(R.h.avatar_iv);
        aVar.eCm = (TextView) inflate.findViewById(R.h.title_tv);
        aVar.eCn = (TextView) inflate.findViewById(R.h.desc_tv);
        aVar.contentView = inflate.findViewById(R.h.select_item_content_layout);
        aVar.eCo = (CheckBox) inflate.findViewById(R.h.select_cb);
        aVar.neM = inflate.findViewById(R.h.item_shadow);
        aVar.nfT = inflate.findViewById(R.h.search_view);
        inflate.setTag(aVar);
        aVar.eCm.setTextColor(-1);
        LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
        layoutParams.width = -1;
        inflate.setLayoutParams(layoutParams);
        inflate.setBackgroundResource(R.e.black);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
        ab abVar = aVar2.guS;
        a.a aVar3 = (a.a) aVar;
        aVar3.contentView.setVisibility(0);
        aVar3.nfT.setVisibility(8);
        aVar3.neM.setVisibility(8);
        c cVar;
        ViewGroup.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        if (c.Lt(abVar.field_username)) {
            aVar3.eCl.setImageResource(R.k.sight_icon_draft_item);
            aVar3.eCm.setText(R.l.sight_draft_title);
            aVar3.eCn.setText(R.l.sight_draft_subtitle);
            aVar3.eCn.setVisibility(0);
            aVar3.eCo.setEnabled(false);
            if (c.nfR) {
                aVar3.contentView.setBackgroundResource(R.g.sight_list_divider);
                aVar3.eCo.setVisibility(0);
                aVar3.eCo.setBackgroundResource(R.k.sight_list_checkbox_selected);
                aVar3.neM.setVisibility(0);
            } else {
                aVar3.contentView.setBackgroundResource(R.g.sight_select_contact_item_bg);
                aVar3.eCo.setVisibility(8);
                aVar3.eCo.setBackgroundResource(R.k.sight_list_checkbox_unselected);
                aVar3.neM.setVisibility(8);
            }
            cVar = this.nfU.nfS;
            c.d(context, aVar3.contentView);
            layoutParams = aVar3.eCl.getLayoutParams();
            layoutParams.width = com.tencent.mm.bp.a.ad(context, R.f.sight_avatar_size);
            layoutParams.height = com.tencent.mm.bp.a.ad(context, R.f.sight_avatar_size);
            aVar3.eCl.setLayoutParams(layoutParams);
            layoutParams2 = (LinearLayout.LayoutParams) aVar3.eCo.getLayoutParams();
            layoutParams2.height = com.tencent.mm.bp.a.ad(context, R.f.sight_checkbox_size);
            layoutParams2.width = com.tencent.mm.bp.a.ad(context, R.f.sight_checkbox_size);
            layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, 0, layoutParams2.bottomMargin);
            aVar3.eCo.setLayoutParams(layoutParams2);
            return;
        }
        if (c.Lr(abVar.field_username)) {
            aVar3.eCl.setImageResource(R.k.sight_item_sns_icon);
            aVar3.eCo.setVisibility(8);
            aVar3.eCm.setText(context.getString(R.l.sight_share_sns));
            aVar3.eCn.setVisibility(8);
            if (c.nfQ) {
                aVar3.contentView.setBackgroundResource(R.g.sight_select_contact_item_bg);
                aVar3.neM.setVisibility(8);
            } else {
                aVar3.contentView.setBackgroundResource(R.g.sight_list_divider);
                aVar3.neM.setVisibility(0);
            }
            cVar = this.nfU.nfS;
            c.d(context, aVar3.contentView);
        } else if (c.Ls(abVar.field_username)) {
            aVar3.contentView.setVisibility(8);
            aVar3.nfT.setVisibility(0);
            return;
        } else {
            super.a(context, aVar, aVar2, z, z2);
            aVar3.contentView.setBackgroundResource(R.g.sight_select_contact_item_bg);
            cVar = this.nfU.nfS;
            c.d(context, aVar3.contentView);
        }
        layoutParams = aVar3.eCl.getLayoutParams();
        layoutParams.width = com.tencent.mm.bp.a.ad(context, R.f.sight_avatar_size);
        layoutParams.height = com.tencent.mm.bp.a.ad(context, R.f.sight_avatar_size);
        aVar3.eCl.setLayoutParams(layoutParams);
        layoutParams2 = (LinearLayout.LayoutParams) aVar3.eCo.getLayoutParams();
        layoutParams2.height = com.tencent.mm.bp.a.ad(context, R.f.sight_checkbox_size);
        layoutParams2.width = com.tencent.mm.bp.a.ad(context, R.f.sight_checkbox_size);
        layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, 0, layoutParams2.bottomMargin);
        aVar3.eCo.setLayoutParams(layoutParams2);
        aVar3.eCo.setBackgroundResource(R.g.sight_list_checkbox);
    }
}
