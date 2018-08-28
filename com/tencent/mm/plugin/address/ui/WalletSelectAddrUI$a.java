package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.d.b;
import java.util.ArrayList;
import java.util.List;

public class WalletSelectAddrUI$a extends BaseAdapter {
    private final Context context;
    List<b> dEw = new ArrayList();
    final /* synthetic */ WalletSelectAddrUI fae;

    public WalletSelectAddrUI$a(WalletSelectAddrUI walletSelectAddrUI, Context context) {
        this.fae = walletSelectAddrUI;
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2 = new a(this);
        if (view == null) {
            view = View.inflate(this.context, R.i.wallet_addr_select_item, null);
            aVar2.eZk = (ImageView) view.findViewById(R.h.check_state);
            aVar2.eZj = (TextView) view.findViewById(R.h.address_content_tv);
            aVar2.eHU = (TextView) view.findViewById(R.h.address_name_tv);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        b jx = jx(i);
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(jx.eXY)) {
            stringBuilder.append(jx.eXY);
        }
        if (!TextUtils.isEmpty(jx.eXZ)) {
            stringBuilder.append(" ");
            stringBuilder.append(jx.eXZ);
        }
        if (!TextUtils.isEmpty(jx.eYa)) {
            stringBuilder.append(" ");
            stringBuilder.append(jx.eYa);
        }
        if (!TextUtils.isEmpty(jx.eYc)) {
            stringBuilder.append(" ");
            stringBuilder.append(jx.eYc);
        }
        aVar.eZj.setText(stringBuilder.toString());
        aVar.eHU.setText(jx.eYd + "，" + jx.eYe);
        if (WalletSelectAddrUI.e(this.fae) && WalletSelectAddrUI.f(this.fae) != null && WalletSelectAddrUI.f(this.fae).id == jx.id) {
            aVar.eZk.setImageResource(R.k.radio_on);
        } else {
            aVar.eZk.setImageBitmap(null);
        }
        return view;
    }

    public final int getCount() {
        return this.dEw.size();
    }

    private b jx(int i) {
        return (b) this.dEw.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
