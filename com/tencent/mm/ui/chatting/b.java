package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

final class b extends BaseAdapter {
    private Context context;
    private c iAs;
    private List<ab> tGU;
    boolean tGV = false;

    public b(Context context) {
        this.context = context;
        this.tGU = new ArrayList();
        a aVar = new a();
        aVar.dXN = R.g.my_device_default_icon;
        this.iAs = aVar.Pt();
        aQ(null);
    }

    public final void aQ(List<ab> list) {
        List list2;
        ab abVar;
        this.tGU.clear();
        if (!(list == null || list.size() == 0)) {
            this.tGU.addAll(list);
        }
        if (this.tGV) {
            list2 = this.tGU;
            abVar = new ab();
            abVar.jxE = R.g.send_data_system_open;
            abVar.daA = this.context.getString(R.l.chatting_send_system_open);
            list2.add(abVar);
        }
        list2 = this.tGU;
        abVar = new ab();
        abVar.jxE = R.g.send_data_settings;
        abVar.daA = this.context.getString(R.l.settings_title);
        list2.add(abVar);
        x.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", new Object[]{Integer.valueOf(this.tGU.size())});
    }

    public final int getCount() {
        return this.tGU.size();
    }

    private ab EF(int i) {
        return (ab) this.tGU.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        aq aqVar;
        ab EF = EF(i);
        if (view == null) {
            aq aqVar2 = new aq();
            view = View.inflate(viewGroup.getContext(), R.i.send_data_to_device_item, null);
            aqVar2.iDt = view.findViewById(R.h.container);
            aqVar2.eMe = (TextView) view.findViewById(R.h.nameTV);
            aqVar2.gmn = (ImageView) view.findViewById(R.h.iconIV);
            aqVar2.tLN = (TextView) view.findViewById(R.h.sendStateTV);
            aqVar2.tNv = (SendDataToDeviceProgressBar) view.findViewById(R.h.sendProgress);
            aqVar2.tNv.setVisibility(4);
            view.setTag(aqVar2);
            aqVar = aqVar2;
        } else {
            aqVar = (aq) view.getTag();
        }
        aqVar.eMe.setText(EF.daA);
        x.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", new Object[]{Integer.valueOf(i), EF.daA});
        if (EF.jxE != 0) {
            aqVar.gmn.setImageResource(EF.jxE);
        } else {
            Bitmap b = g.b(EF.appId, 1, com.tencent.mm.bp.a.getDensity(this.context));
            if (b == null || b.isRecycled()) {
                o.Pj().a(EF.iconUrl, aqVar.gmn, this.iAs);
            } else {
                aqVar.gmn.setImageBitmap(b);
            }
        }
        aqVar.iDt.setTag(Integer.valueOf(i));
        return view;
    }
}
