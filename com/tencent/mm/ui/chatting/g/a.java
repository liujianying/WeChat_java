package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.appbrand.q.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.a.b$e;

public final class a extends b {
    private int gBh = -1;
    private c tXU;

    public a(Context context) {
        super(context);
        com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
        aVar.dXN = R.k.app_brand_app_default_icon_for_tail;
        aVar.bg(com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 50), com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 50)).dXw = true;
        this.tXU = aVar.Pt();
    }

    public final int getType() {
        return 33;
    }

    public final void cwG() {
        x.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", new Object[]{Boolean.valueOf(true)});
        this.tXZ.cwK();
        b.a(this.gBf, new 1(this));
    }

    public final String Wm() {
        return "";
    }

    public final String cwJ() {
        return "";
    }

    public final b$e cwH() {
        return new 2(this);
    }

    public final t m(ViewGroup viewGroup) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.appbrand_history_list_item, viewGroup, false));
    }

    public final void a(com.tencent.mm.ui.chatting.a.b.a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) EZ(i);
        if (bi.oW(aVar2.desc)) {
            bVar.eCn.setVisibility(8);
        } else {
            bVar.eCn.setVisibility(0);
            bVar.eCn.setText(bi.aG(aVar2.desc, ""));
        }
        o.Pj().a(aVar2.imagePath, bVar.eCl, this.tXU);
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            f bl = g.bl(str, true);
            if (bl == null) {
                Object str22 = packageInfo;
            } else {
                str22 = bl.field_packageName;
            }
        }
        if (str22 == null) {
            return packageInfo;
        }
        try {
            return context.getPackageManager().getPackageInfo(str22, 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandHistoryListPresenter", e, "", new Object[0]);
            return packageInfo;
        }
    }
}
