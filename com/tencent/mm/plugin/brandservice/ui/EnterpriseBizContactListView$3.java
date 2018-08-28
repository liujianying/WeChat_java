package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.g;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.c;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

class EnterpriseBizContactListView$3 implements a {
    final /* synthetic */ EnterpriseBizContactListView hpt;

    EnterpriseBizContactListView$3(EnterpriseBizContactListView enterpriseBizContactListView) {
        this.hpt = enterpriseBizContactListView;
    }

    public final View a(d dVar, View view, int i, boolean z, boolean z2) {
        c cVar;
        long VG = bi.VG();
        Context context = this.hpt.getContext();
        if (view == null) {
            view = LayoutInflater.from(context).inflate(e.enterprise_biz_list_item_sort, null);
            cVar = new c();
            cVar.hoc = (TextView) view.findViewById(b.d.catalogTV);
            cVar.contentView = view.findViewById(b.d.contentView);
            cVar.eCl = (ImageView) view.findViewById(b.d.app_avatar_iv);
            cVar.hpA = (ImageView) view.findViewById(b.d.new_iv);
            cVar.eTm = (TextView) view.findViewById(b.d.brand_service_nickname);
            cVar.hpB = view.findViewById(b.d.selector);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        ix ixVar = (ix) dVar.data;
        if (ixVar == null) {
            x.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
        } else {
            Object obj = null;
            if (ixVar.lUs.Ma()) {
                obj = 1;
            }
            if (this.hpt.tDL && z) {
                if (dVar.tDT.equals("!2")) {
                    cVar.hoc.setText(this.hpt.getContext().getString(h.enterprise_sub_placetop));
                    cVar.hoc.setVisibility(0);
                } else if (!dVar.tDT.equals("!1")) {
                    cVar.hoc.setText(dVar.tDT);
                    cVar.hoc.setVisibility(0);
                }
                if (obj == null) {
                    cVar.username = ixVar.userName;
                    cVar.eCl.setImageResource(g.enterprise_chat_entry_avatar);
                    EnterpriseBizContactListView.a(cVar.eTm, context, this.hpt.getResources().getString(h.enterprise_chat_entry_title), (int) cVar.eTm.getTextSize());
                } else {
                    cVar.username = ixVar.userName;
                    cVar.iconUrl = ixVar.lUs.field_brandIconURL;
                    cVar.eCl.setTag(ixVar.userName);
                    com.tencent.mm.pluginsdk.ui.a.b.a(cVar.eCl, cVar.username);
                    EnterpriseBizContactListView.a(cVar.eTm, context, ixVar.guS.BL(), (int) cVar.eTm.getTextSize());
                }
                x.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[]{Integer.valueOf(ixVar.lUs.field_status)});
                cVar.hpA.setVisibility(ixVar.lUs.field_status != 1 ? 0 : 8);
                if (this.hpt.getMode() == 0 || !z2) {
                    cVar.hpB.setBackgroundResource(b.c.list_item_normal);
                } else {
                    cVar.hpB.setBackgroundResource(b.c.comm_list_item_selector_no_divider);
                }
                if (this.hpt.tDM) {
                    cVar.contentView.setPadding(cVar.contentView.getPaddingLeft(), cVar.contentView.getPaddingTop(), (int) this.hpt.getContext().getResources().getDimension(b.b.NormalPadding), cVar.contentView.getPaddingBottom());
                } else {
                    cVar.contentView.setPadding(cVar.contentView.getPaddingLeft(), cVar.contentView.getPaddingTop(), (int) this.hpt.getContext().getResources().getDimension(b.b.AddressScrollBarWidth), cVar.contentView.getPaddingBottom());
                }
                x.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[]{Long.valueOf(bi.bI(VG))});
            }
            cVar.hoc.setVisibility(8);
            if (obj == null) {
                cVar.username = ixVar.userName;
                cVar.iconUrl = ixVar.lUs.field_brandIconURL;
                cVar.eCl.setTag(ixVar.userName);
                com.tencent.mm.pluginsdk.ui.a.b.a(cVar.eCl, cVar.username);
                EnterpriseBizContactListView.a(cVar.eTm, context, ixVar.guS.BL(), (int) cVar.eTm.getTextSize());
            } else {
                cVar.username = ixVar.userName;
                cVar.eCl.setImageResource(g.enterprise_chat_entry_avatar);
                EnterpriseBizContactListView.a(cVar.eTm, context, this.hpt.getResources().getString(h.enterprise_chat_entry_title), (int) cVar.eTm.getTextSize());
            }
            x.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[]{Integer.valueOf(ixVar.lUs.field_status)});
            if (ixVar.lUs.field_status != 1) {
            }
            cVar.hpA.setVisibility(ixVar.lUs.field_status != 1 ? 0 : 8);
            if (this.hpt.getMode() == 0) {
            }
            cVar.hpB.setBackgroundResource(b.c.list_item_normal);
            if (this.hpt.tDM) {
                cVar.contentView.setPadding(cVar.contentView.getPaddingLeft(), cVar.contentView.getPaddingTop(), (int) this.hpt.getContext().getResources().getDimension(b.b.NormalPadding), cVar.contentView.getPaddingBottom());
            } else {
                cVar.contentView.setPadding(cVar.contentView.getPaddingLeft(), cVar.contentView.getPaddingTop(), (int) this.hpt.getContext().getResources().getDimension(b.b.AddressScrollBarWidth), cVar.contentView.getPaddingBottom());
            }
            x.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[]{Long.valueOf(bi.bI(VG))});
        }
        return view;
    }
}
