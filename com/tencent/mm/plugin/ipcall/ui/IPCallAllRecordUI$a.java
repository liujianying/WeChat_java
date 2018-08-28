package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.r;

class IPCallAllRecordUI$a extends r<k> {
    final /* synthetic */ IPCallAllRecordUI kuu;

    class a {
        TextView eBR;
        TextView kuv;
        TextView kuw;

        a() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        k kVar = (k) obj;
        if (kVar == null) {
            kVar = new k();
        }
        kVar.d(cursor);
        return kVar;
    }

    public IPCallAllRecordUI$a(IPCallAllRecordUI iPCallAllRecordUI, Context context) {
        this.kuu = iPCallAllRecordUI;
        super(context, null);
        lB(true);
    }

    public final void WT() {
        Cursor cursor = null;
        if (!bi.oW(IPCallAllRecordUI.a(this.kuu))) {
            String a = IPCallAllRecordUI.a(this.kuu);
            if (!bi.oW(a)) {
                c EP = i.aXv().EP(a);
                if (!(EP == null || EP.sKx == -1)) {
                    cursor = i.aXw().dQ(EP.sKx);
                }
            }
        } else if (!bi.oW(IPCallAllRecordUI.b(this.kuu))) {
            cursor = i.aXw().ET(IPCallAllRecordUI.b(this.kuu));
        }
        setCursor(cursor);
    }

    protected final void WS() {
        aYc();
        WT();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.kuu.getLayoutInflater().inflate(R.i.ipcall_allrecord_item, viewGroup, false);
            aVar = new a();
            aVar.kuv = (TextView) view.findViewById(R.h.profile_record_calltime_tv);
            aVar.kuw = (TextView) view.findViewById(R.h.profile_record_phonenumber_tv);
            aVar.eBR = (TextView) view.findViewById(R.h.profile_record_status_duration_tv);
            view.setTag(aVar);
        }
        k kVar = (k) getItem(i);
        aVar = (a) view.getTag();
        aVar.kuw.setText(com.tencent.mm.plugin.ipcall.b.a.Ft(kVar.field_phonenumber));
        if (kVar.field_duration > 0) {
            aVar.eBR.setText(com.tencent.mm.plugin.ipcall.b.c.dT(kVar.field_duration));
        } else {
            aVar.eBR.setText(com.tencent.mm.plugin.ipcall.b.c.rL(kVar.field_status));
        }
        aVar.kuv.setText(com.tencent.mm.plugin.ipcall.b.c.dR(kVar.field_calltime));
        return view;
    }
}
