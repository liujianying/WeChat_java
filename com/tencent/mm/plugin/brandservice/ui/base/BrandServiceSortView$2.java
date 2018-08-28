package com.tencent.mm.plugin.brandservice.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.b;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

class BrandServiceSortView$2 implements a {
    final /* synthetic */ BrandServiceSortView hqt;

    BrandServiceSortView$2(BrandServiceSortView brandServiceSortView) {
        this.hqt = brandServiceSortView;
    }

    public final View a(d dVar, View view, int i, boolean z, boolean z2) {
        b bVar;
        long VG = bi.VG();
        Context context = this.hqt.getContext();
        if (view == null) {
            view = LayoutInflater.from(context).inflate(e.brand_service_lv_item, null);
            bVar = new b();
            bVar.hoc = (TextView) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.catalogTV);
            bVar.contentView = view.findViewById(com.tencent.mm.plugin.brandservice.b.d.contentView);
            bVar.eCl = (ImageView) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.app_avatar_iv);
            bVar.hpA = (ImageView) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.new_iv);
            bVar.eTm = (TextView) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.brand_service_nickname);
            bVar.hpB = view.findViewById(com.tencent.mm.plugin.brandservice.b.d.selector);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        ix ixVar = (ix) dVar.data;
        if (ixVar == null) {
            x.e("MicroMsg.BrandServiceSortView", "should not be empty");
        } else {
            if (this.hqt.tDL && z) {
                bVar.hoc.setText(dVar.tDT);
                bVar.hoc.setVisibility(0);
            } else {
                bVar.hoc.setVisibility(8);
            }
            bVar.username = ixVar.userName;
            bVar.iconUrl = ixVar.lUs.field_brandIconURL;
            bVar.eCl.setTag(ixVar.userName);
            bVar.ave();
            BrandServiceSortView.a(this.hqt, bVar.eTm, context, ixVar.guS.BL(), (int) bVar.eTm.getTextSize());
            x.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", new Object[]{Integer.valueOf(ixVar.lUs.field_status)});
            ImageView imageView = bVar.hpA;
            int i2 = (BrandServiceSortView.c(this.hqt) && ixVar.lUs.field_status == 1) ? 0 : 8;
            imageView.setVisibility(i2);
            if (this.hqt.getMode() == 0 && z2) {
                bVar.hpB.setBackgroundResource(c.comm_list_item_selector_no_divider);
            } else {
                bVar.hpB.setBackgroundResource(c.list_item_normal);
            }
            if (this.hqt.tDM) {
                bVar.contentView.setPadding(bVar.contentView.getPaddingLeft(), bVar.contentView.getPaddingTop(), (int) this.hqt.getContext().getResources().getDimension(com.tencent.mm.plugin.brandservice.b.b.AddressScrollBarWidth), bVar.contentView.getPaddingBottom());
            } else {
                bVar.contentView.setPadding(bVar.contentView.getPaddingLeft(), bVar.contentView.getPaddingTop(), (int) this.hqt.getContext().getResources().getDimension(com.tencent.mm.plugin.brandservice.b.b.NormalPadding), bVar.contentView.getPaddingBottom());
            }
            x.v("MicroMsg.BrandServiceSortView", "get view use %d ms", new Object[]{Long.valueOf(bi.bI(VG))});
        }
        return view;
    }
}
