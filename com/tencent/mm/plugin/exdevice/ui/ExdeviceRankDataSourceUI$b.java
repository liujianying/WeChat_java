package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

final class ExdeviceRankDataSourceUI$b extends BaseAdapter {
    private c iAs;
    List<a> iFi = new LinkedList();

    public ExdeviceRankDataSourceUI$b() {
        c.a aVar = new c.a();
        aVar.dXN = R.g.exdevice_wechat_sport_default_icon;
        this.iAs = aVar.Pt();
    }

    public final synchronized a Aw(String str) {
        a aVar;
        if (!bi.oW(str)) {
            for (a aVar2 : this.iFi) {
                if (str.equals(aVar2.mac)) {
                    break;
                }
            }
        }
        aVar2 = null;
        return aVar2;
    }

    public final synchronized a cD(String str, String str2) {
        a aVar;
        for (a aVar2 : this.iFi) {
            if (aVar2 != null && ExdeviceRankDataSourceUI.a(str, str2, aVar2.iFg)) {
                break;
            }
        }
        aVar2 = null;
        return aVar2;
    }

    public final int getCount() {
        return this.iFi.size();
    }

    private a pm(int i) {
        return (a) this.iFi.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a pm = pm(i);
        if (view == null) {
            a aVar2 = new a((byte) 0);
            view = View.inflate(viewGroup.getContext(), R.i.exdevice_rank_data_source_item, null);
            aVar2.eMe = (TextView) view.findViewById(R.h.nameTV);
            aVar2.gmn = (ImageView) view.findViewById(R.h.iconIV);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        x.d("MicroMsg.ExdeviceRankDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[]{Integer.valueOf(i), ExdeviceRankDataSourceUI.a(pm), pm.mac});
        aVar.eMe.setText(r1);
        o.Pj().a(pm.iFg.jPG, aVar.gmn, this.iAs);
        return view;
    }
}
