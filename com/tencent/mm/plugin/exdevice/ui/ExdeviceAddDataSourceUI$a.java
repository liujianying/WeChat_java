package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

final class ExdeviceAddDataSourceUI$a extends BaseAdapter {
    private List<b> iAe = new LinkedList();
    private c iAs;

    private static class a {
        TextView eMe;
        ImageView gmn;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public ExdeviceAddDataSourceUI$a() {
        com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
        aVar.dXN = R.g.exdevice_wechat_sport_default_icon;
        this.iAs = aVar.Pt();
    }

    public final void aQ(List<b> list) {
        this.iAe.clear();
        if (list != null && list.size() != 0) {
            this.iAe.addAll(list);
        }
    }

    public final b Aq(String str) {
        if (!bi.oW(str)) {
            for (b bVar : this.iAe) {
                if (str.equalsIgnoreCase(bVar.mac)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public final int getCount() {
        return this.iAe.size();
    }

    /* renamed from: pd */
    public final b getItem(int i) {
        return (b) this.iAe.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        b pd = getItem(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(viewGroup.getContext(), R.i.exdevice_add_data_source_item, null);
            aVar2.gmn = (ImageView) view.findViewById(R.h.iconIV);
            aVar2.eMe = (TextView) view.findViewById(R.h.nameTV);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        x.d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[]{Integer.valueOf(i), pd.name, pd.mac});
        aVar.eMe.setText(pd.name);
        o.Pj().a(pd.iconUrl, aVar.gmn, this.iAs);
        return view;
    }
}
