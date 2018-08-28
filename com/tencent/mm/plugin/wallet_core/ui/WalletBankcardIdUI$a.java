package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class WalletBankcardIdUI$a extends BaseAdapter {
    private LayoutInflater Bc = null;
    private Context mContext = null;
    List<q> psX = new LinkedList();

    public WalletBankcardIdUI$a(Context context, List<q> list) {
        this.Bc = LayoutInflater.from(context);
        this.psX = list;
        this.mContext = context;
    }

    public final int getCount() {
        if (this.psX == null) {
            return 0;
        }
        return this.psX.size();
    }

    public final Object getItem(int i) {
        return this.psX.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.Bc.inflate(g.wallet_bankfavor_item, viewGroup, false);
            aVar = new a(this);
            aVar.psY = (ImageView) view.findViewById(f.wallet_bankfavor_logo);
            aVar.muz = (TextView) view.findViewById(f.wallet_bankfavor_bankname);
            aVar.psZ = (TextView) view.findViewById(f.wallet_bankfavor_name);
            aVar.pta = (TextView) view.findViewById(f.wallet_bankfavor_manual);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        q qVar = (q) getItem(i);
        if (bi.oW(qVar.lNT)) {
            aVar.muz.setVisibility(8);
        } else {
            aVar.muz.setText(qVar.lNT);
            aVar.muz.setVisibility(0);
        }
        if (bi.oW(qVar.peM)) {
            aVar.psZ.setVisibility(8);
        } else {
            aVar.psZ.setText(qVar.peM);
            aVar.psZ.setVisibility(0);
        }
        if (bi.oW(qVar.pdT)) {
            aVar.pta.setVisibility(8);
        } else {
            aVar.pta.setText(qVar.pdT);
            aVar.pta.setVisibility(0);
        }
        String str = qVar.peS;
        x.v("Micromsg.WalletInputCardIDUI", "bankType:" + qVar.peR + ", logurl:" + str);
        aVar.psY.setImageBitmap(null);
        if (!bi.oW(str)) {
            a aVar2 = new a();
            o.Pk();
            aVar2.dXU = null;
            aVar2.dXB = e.bnE;
            aVar2.dXA = b.JC(str);
            aVar2.dXy = true;
            aVar2.dXV = true;
            o.Pj().a(str, aVar.psY, aVar2.Pt());
        }
        return view;
    }
}
