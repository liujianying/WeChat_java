package com.tencent.mm.plugin.profile.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.b.a;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;

class BizBindWxaInfoUI$a extends BaseAdapter {
    private LayoutInflater Bc;
    private List<WxaEntryInfo> gxb = new LinkedList();

    public BizBindWxaInfoUI$a(LayoutInflater layoutInflater, List<WxaEntryInfo> list) {
        this.Bc = layoutInflater;
        if (list != null) {
            this.gxb.addAll(list);
        }
    }

    public final int getCount() {
        return this.gxb.size();
    }

    private WxaEntryInfo lJ(int i) {
        return (WxaEntryInfo) this.gxb.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.Bc.inflate(h.app_brand_launcher_recents_item_as_normal, viewGroup, false);
            a aVar2 = new a((byte) 0);
            aVar2.gxd = (ImageView) view.findViewById(g.icon);
            aVar2.eBO = (TextView) view.findViewById(g.primary_text);
            aVar2.eCO = view.findViewById(g.divider);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        WxaEntryInfo lJ = lJ(i);
        b.Ka().a(aVar.gxd, lJ.iconUrl, a.JZ(), f.dGr);
        aVar.eBO.setText(bi.oV(lJ.title));
        if (this.gxb != null) {
            int i2;
            View view2 = aVar.eCO;
            if (this.gxb.size() - 1 == i) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            view2.setVisibility(i2);
        }
        return view;
    }
}
