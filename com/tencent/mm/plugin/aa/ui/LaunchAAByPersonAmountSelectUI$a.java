package com.tencent.mm.plugin.aa.ui;

import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class LaunchAAByPersonAmountSelectUI$a extends BaseAdapter {
    List<LaunchAAByPersonAmountSelectUI$b> dataList;
    final /* synthetic */ LaunchAAByPersonAmountSelectUI eDf;

    public LaunchAAByPersonAmountSelectUI$a(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI, List<String> list, Map<String, Double> map) {
        this.eDf = launchAAByPersonAmountSelectUI;
        this.dataList = null;
        this.dataList = new ArrayList();
        for (String str : list) {
            LaunchAAByPersonAmountSelectUI$b launchAAByPersonAmountSelectUI$b = new LaunchAAByPersonAmountSelectUI$b(launchAAByPersonAmountSelectUI, (byte) 0);
            launchAAByPersonAmountSelectUI$b.username = str;
            if (map == null || !map.containsKey(str)) {
                launchAAByPersonAmountSelectUI$b.eDm = "";
            } else {
                launchAAByPersonAmountSelectUI$b.eDm = launchAAByPersonAmountSelectUI.getString(i.aa_amount_format, new Object[]{map.get(str)});
            }
            this.dataList.add(launchAAByPersonAmountSelectUI$b);
        }
    }

    public final int getCount() {
        return this.dataList.size();
    }

    private LaunchAAByPersonAmountSelectUI$b iX(int i) {
        return (LaunchAAByPersonAmountSelectUI$b) this.dataList.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        LaunchAAByPersonAmountSelectUI$b iX = iX(i);
        if (!(iX == null || bi.oW(iX.username))) {
            if (view == null) {
                view = y.gq(this.eDf).inflate(g.launch_aa_by_person_amount_select_row, viewGroup, false);
                a aVar = new a(this, (byte) 0);
                aVar.eBM = (ImageView) view.findViewById(f.avatar);
                aVar.eCM = (TextView) view.findViewById(f.username);
                aVar.eCN = (WalletFormView) view.findViewById(f.money_edit);
                aVar.eDl = new LaunchAAByPersonAmountSelectUI$c(this.eDf, iX.username);
                aVar.eCN.a(aVar.eDl);
                aVar.eBM.setOnTouchListener(new 1(this, aVar));
                aVar.eCM.setOnTouchListener(new 2(this, aVar));
                view.setTag(aVar);
                this.eDf.a(aVar.eCN, 2, false, true);
            }
            a aVar2 = (a) view.getTag();
            if (!bi.oW(iX.username)) {
                aVar2.eDl.username = iX.username;
                b.a(aVar2.eBM, iX.username);
                aVar2.eCM.setText(j.a(this.eDf.mController.tml, ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(iX.username, LaunchAAByPersonAmountSelectUI.n(this.eDf)), aVar2.eCM.getTextSize()));
            }
            if (!(iX.eDm == null || aVar2.eCN.getText() == null || iX.eDm.equals(aVar2.eCN.getText().toLowerCase()))) {
                WalletFormView walletFormView = aVar2.eCN;
                TextWatcher textWatcher = aVar2.eDl;
                if (walletFormView.uZy != null) {
                    walletFormView.uZy.removeTextChangedListener(textWatcher);
                }
                aVar2.eCN.setText(iX.eDm);
                aVar2.eCN.a(aVar2.eDl);
            }
        }
        return view;
    }
}
