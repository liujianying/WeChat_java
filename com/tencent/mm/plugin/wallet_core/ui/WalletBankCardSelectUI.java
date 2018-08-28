package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.ab.l;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.wallet_core.e.a;
import com.tencent.mm.plugin.wallet_core.e.a.9;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WalletBankCardSelectUI extends WalletBaseUI {
    private boolean hoX = false;
    private o hol;
    private BankCardSelectSortView psJ;
    private List<ElementQuery> psK;
    private List<d> psL;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.bank_remit_select_bank_title);
        this.psK = com.tencent.mm.plugin.wallet_core.model.o.bPe().pjy;
        initView();
        this.psL = new ArrayList();
        S(null);
        a aVar = new a();
        List<ElementQuery> list = com.tencent.mm.plugin.wallet_core.model.o.bPe().pjy;
        List linkedList = new LinkedList();
        for (ElementQuery elementQuery : list) {
            Bankcard bankcard = new Bankcard();
            bankcard.field_bankName = elementQuery.knE;
            bankcard.field_bankcardType = elementQuery.lMV;
            linkedList.add(bankcard);
        }
        ActionBarActivity actionBarActivity = this.mController.tml;
        3 3 = new 3(this);
        Map hashMap = new HashMap();
        if (linkedList.isEmpty()) {
            x.w("MicroMsg.BankcardLogoHelper", "req is null");
            3.T(hashMap);
        } else {
            g.cx(linkedList).d(new 9(aVar)).d(new a$8(aVar, linkedList, hashMap, 3));
        }
        a(this.hol);
    }

    protected final void initView() {
        this.psJ = (BankCardSelectSortView) findViewById(f.bankcard_sort_view);
        this.psJ.setOnItemClickListener(new 1(this));
        this.hol = new o((byte) 0);
        this.hol.uBw = new 2(this);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.wallet_bankcard_select_ui;
    }

    private void S(Map<String, e> map) {
        String str = "WalletBankCardSelectUI";
        String str2 = "refresh data: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(map != null);
        x.d(str, str2, objArr);
        this.psL.clear();
        for (ElementQuery elementQuery : this.psK) {
            d dVar;
            int i;
            for (d dVar2 : this.psL) {
                if (((BankCardSelectSortView.a) dVar2.data).lNT.equals(elementQuery.knE)) {
                    i = 1;
                    break;
                }
            }
            byte i2 = (byte) 0;
            if (i2 == 0) {
                dVar2 = new d();
                BankCardSelectSortView.a aVar = new BankCardSelectSortView.a();
                aVar.lNT = elementQuery.knE;
                if (map != null) {
                    e eVar = (e) map.get(elementQuery.lMV);
                    if (eVar != null) {
                        aVar.bWP = eVar.lCU;
                        aVar.pzm = eVar.pmp;
                        aVar.mcD = eVar.mcD;
                    }
                }
                if (bi.oW(aVar.mcD)) {
                    aVar.mcD = ag(aVar.lNT, "#", "_");
                } else {
                    x.d("WalletBankCardSelectUI", "have pinyin：%s", new Object[]{aVar.mcD});
                }
                dVar2.tDT = aVar.mcD.toUpperCase().charAt(0);
                dVar2.data = aVar;
                this.psL.add(dVar2);
            }
        }
        Collections.sort(this.psL, new a((byte) 0));
        runOnUiThread(new 4(this));
    }

    public static String ag(String str, String str2, String str3) {
        if (bi.oW(str)) {
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            String g = SpellMap.g(str.charAt(i));
            if (!bi.oW(g)) {
                stringBuilder.append(g.toUpperCase());
                if (i != length - 1) {
                    stringBuilder.append(str3);
                }
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        x.d("WalletBankCardSelectUI", "full py: %s", new Object[]{stringBuilder2});
        if (bi.oW(stringBuilder2)) {
            return str2;
        }
        return stringBuilder2;
    }
}
