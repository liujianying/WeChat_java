package com.tencent.mm.plugin.exdevice.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.k;
import com.tencent.mm.aa.q;
import com.tencent.mm.plugin.exdevice.model.f.AnonymousClass1;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bi;

class ExdeviceProfileAffectedUserView$a extends BaseAdapter {
    final /* synthetic */ ExdeviceProfileAffectedUserView iDP;
    private Runnable iDQ;

    class a {
        ImageView eKk;

        a() {
        }
    }

    private ExdeviceProfileAffectedUserView$a(ExdeviceProfileAffectedUserView exdeviceProfileAffectedUserView) {
        this.iDP = exdeviceProfileAffectedUserView;
        this.iDQ = new 1(this);
    }

    /* synthetic */ ExdeviceProfileAffectedUserView$a(ExdeviceProfileAffectedUserView exdeviceProfileAffectedUserView, byte b) {
        this(exdeviceProfileAffectedUserView);
    }

    public final int getCount() {
        return ExdeviceProfileAffectedUserView.d(this.iDP) == null ? 0 : ExdeviceProfileAffectedUserView.d(this.iDP).size();
    }

    private String jl(int i) {
        return (String) ExdeviceProfileAffectedUserView.d(this.iDP).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        String jl = jl(i);
        if (view == null) {
            view = LayoutInflater.from(this.iDP.getContext()).inflate(R.i.exdevice_profile_view_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.eKk = (ImageView) view.findViewById(R.h.avatar);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        Runnable runnable = this.iDQ;
        k KH = q.KH();
        if (KH != null) {
            j kc = KH.kc(jl);
            if (kc == null || bi.oW(kc.Ky())) {
                com.tencent.mm.model.am.a.dBr.a(jl, "", new AnonymousClass1(bi.VF(), runnable));
            }
        }
        b.o(aVar.eKk, jl);
        return view;
    }
}
