package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.modelappbrand.b.a;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes$WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class WxaBindBizInfoUI$a extends RecyclerView$a {
    private LayoutInflater Bc;
    private final List<WxaAttributes$WxaEntryInfo> gxb;
    boolean gxc = true;

    public WxaBindBizInfoUI$a(LayoutInflater layoutInflater) {
        this.Bc = layoutInflater;
        this.gxb = new LinkedList();
    }

    public final t a(ViewGroup viewGroup, int i) {
        return new b(this.Bc.inflate(h.app_brand_launcher_recents_item_as_normal, viewGroup, false));
    }

    public final void a(t tVar, int i) {
        int i2 = 0;
        WxaAttributes$WxaEntryInfo lJ = lJ(i);
        if (lJ == null) {
            x.i("MicroMsg.WxaBindBizInfoUI", "onBindViewHolder failed, getItem(%d) return null", new Object[]{Integer.valueOf(i)});
            return;
        }
        b bVar = (b) tVar;
        com.tencent.mm.modelappbrand.b.b.Ka().a(bVar.gxd, lJ.iconUrl, a.JZ(), f.dGr);
        bVar.eBO.setText(bi.oV(lJ.title));
        if (this.gxc) {
            View view = bVar.eCO;
            if (this.gxb.size() - 1 == i) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
    }

    public final int getItemCount() {
        return this.gxb.size();
    }

    public final WxaAttributes$WxaEntryInfo lJ(int i) {
        if (i < 0 || i >= getItemCount()) {
            return null;
        }
        return (WxaAttributes$WxaEntryInfo) this.gxb.get(i);
    }

    protected final void ap(List<WxaAttributes$WxaEntryInfo> list) {
        if (list != null && !list.isEmpty()) {
            Collection linkedList = new LinkedList();
            for (WxaAttributes$WxaEntryInfo wxaAttributes$WxaEntryInfo : list) {
                if (!contains(wxaAttributes$WxaEntryInfo.username)) {
                    linkedList.add(wxaAttributes$WxaEntryInfo);
                }
            }
            this.gxb.addAll(linkedList);
            X(this.gxb.size() - list.size(), list.size());
        }
    }

    private boolean contains(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (WxaAttributes$WxaEntryInfo wxaAttributes$WxaEntryInfo : this.gxb) {
            if (str.equals(wxaAttributes$WxaEntryInfo.username)) {
                return true;
            }
        }
        return false;
    }
}
