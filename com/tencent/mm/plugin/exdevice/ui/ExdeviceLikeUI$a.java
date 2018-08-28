package com.tencent.mm.plugin.exdevice.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.NoMeasuredTextView;

class ExdeviceLikeUI$a extends BaseAdapter {
    final /* synthetic */ ExdeviceLikeUI iDa;

    ExdeviceLikeUI$a(ExdeviceLikeUI exdeviceLikeUI) {
        this.iDa = exdeviceLikeUI;
    }

    public final int getCount() {
        return ExdeviceLikeUI.c(this.iDa) == null ? 0 : ExdeviceLikeUI.c(this.iDa).size();
    }

    public final Object getItem(int i) {
        return ExdeviceLikeUI.c(this.iDa).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        a aVar;
        e eVar = (e) ExdeviceLikeUI.c(this.iDa).get(i);
        if (view == null) {
            if (ExdeviceLikeUI.d(this.iDa)) {
                inflate = LayoutInflater.from(this.iDa).inflate(R.i.exdevice_like_item_readonly, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(this.iDa).inflate(R.i.exdevice_like_item, viewGroup, false);
            }
            a aVar2 = new a(this);
            aVar2.eBM = (ImageView) inflate.findViewById(R.h.exdevice_avatar);
            aVar2.iDb = (NoMeasuredTextView) inflate.findViewById(R.h.exdevice_username);
            aVar2.eYC = (TextView) inflate.findViewById(R.h.exdevice_tip);
            aVar2.hrV = (TextView) inflate.findViewById(R.h.exdevice_time);
            aVar2.iDb.setTextSize(0, this.iDa.getResources().getDimension(R.f.NormalTextSize));
            aVar2.iDb.setTextColor(this.iDa.getResources().getColor(R.e.black));
            aVar2.iDb.setSingleLine(true);
            aVar2.iDb.setShouldEllipsize(true);
            inflate.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
            inflate = view;
        }
        b.o(aVar.eBM, eVar.field_username);
        aVar.iDb.setText(j.a(this.iDa, r.gT(eVar.field_username), aVar.iDb.getTextSize()));
        if (!bi.oW(eVar.field_liketips) && aVar.eYC != null) {
            aVar.eYC.setVisibility(0);
            aVar.eYC.setText(eVar.field_liketips);
        } else if (aVar.eYC != null) {
            aVar.eYC.setVisibility(8);
        }
        if (((int) ((((System.currentTimeMillis() / 1000) - ((long) eVar.field_timestamp)) / 60) + 1)) <= 30) {
            aVar.hrV.setText(this.iDa.getString(R.l.exdevice_like_time_ago, new Object[]{Integer.valueOf(r3)}));
        } else {
            aVar.hrV.setText(h.c(this.iDa, ((long) eVar.field_timestamp) * 1000, true));
        }
        return inflate;
    }
}
