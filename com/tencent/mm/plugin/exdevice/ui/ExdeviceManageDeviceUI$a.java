package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.k;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

final class ExdeviceManageDeviceUI$a extends BaseAdapter implements e {
    private d hqs;
    private List<b> iAe;
    private c iAs;
    boolean iDm;
    private WeakReference<Context> iDn;
    private OnClickListener iDo;
    private k iDp;
    private volatile int iDq = -1;
    private p tipDialog = null;

    public ExdeviceManageDeviceUI$a(Context context) {
        this.iDn = new WeakReference(context);
        this.iAe = new LinkedList();
        this.iDp = new k(context);
        a aVar = new a();
        aVar.dXN = R.g.exdevice_my_device_default_icon;
        this.iAs = aVar.Pt();
        this.hqs = new 1(this);
        this.iDo = new 2(this);
        aQ(ad.aHe().aHJ());
    }

    public final void aQ(List<b> list) {
        this.iAe.clear();
        if (list != null && list.size() != 0) {
            this.iAe.addAll(list);
        }
    }

    public final int getCount() {
        return this.iAe.size();
    }

    /* renamed from: pk */
    public final b getItem(int i) {
        return (b) this.iAe.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        b pk = getItem(i);
        if (view == null) {
            aVar = new a((byte) 0);
            view = View.inflate(viewGroup.getContext(), R.i.exdevice_manage_device_item, null);
            aVar.iDt = view.findViewById(R.h.container);
            aVar.eMe = (TextView) view.findViewById(R.h.nameTV);
            aVar.iDu = view.findViewById(R.h.deleteV);
            aVar.gmn = (ImageView) view.findViewById(R.h.iconIV);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (pk == null) {
            charSequence = "";
        } else {
            String cY = !bi.oW(pk.cCR) ? pk.cCR : !bi.oW(pk.cCS) ? pk.cCS : pk.field_mac != 0 ? com.tencent.mm.plugin.exdevice.j.b.cY(pk.field_mac) : !bi.oW(pk.field_deviceID) ? pk.field_deviceID : null;
            charSequence = bi.oV(cY);
        }
        x.d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", new Object[]{Integer.valueOf(i), charSequence, Long.valueOf(pk.field_mac)});
        aVar.eMe.setText(charSequence);
        o.Pj().a(pk.iconUrl, aVar.gmn, this.iAs);
        aVar.iDu.setTag(Integer.valueOf(i));
        if (this.iDm) {
            aVar.iDu.setVisibility(0);
        } else {
            aVar.iDu.setVisibility(8);
        }
        aVar.iDt.setTag(Integer.valueOf(i));
        aVar.iDt.setOnClickListener(this.iDo);
        return view;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar == null) {
            x.e("MicroMsg.ExdeviceManageDeviceUI", "scene is null.");
        } else if (lVar instanceof com.tencent.mm.plugin.exdevice.model.x) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (i == 0 && i2 == 0 && this.iDq >= 0 && this.iDq < this.iAe.size()) {
                ah.A(new 6(this));
            }
        }
    }
}
