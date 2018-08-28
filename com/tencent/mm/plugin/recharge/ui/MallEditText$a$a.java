package com.tencent.mm.plugin.recharge.ui;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.recharge.ui.MallEditText.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class MallEditText$a$a extends Filter {
    final /* synthetic */ a mpr;

    private MallEditText$a$a(a aVar) {
        this.mpr = aVar;
    }

    protected final synchronized FilterResults performFiltering(CharSequence charSequence) {
        FilterResults filterResults;
        FilterResults filterResults2 = new FilterResults();
        List arrayList = new ArrayList();
        String pK = charSequence != null ? b.pK(charSequence.toString()) : "";
        if (pK.equals(a.a(this.mpr))) {
            MallEditText.a(this.mpr.mpl).post(new Runnable() {
                public final void run() {
                    MallEditText.a(MallEditText$a$a.this.mpr.mpl).dismissDropDown();
                }
            });
            filterResults = filterResults2;
        } else {
            com.tencent.mm.plugin.recharge.model.a aVar;
            boolean z;
            boolean z2;
            a.a(this.mpr, pK);
            if (this.mpr.mpl.ZF()) {
                long currentTimeMillis = System.currentTimeMillis();
                x.d("MicroMsg.MallEditText", "performFiltering " + charSequence);
                for (com.tencent.mm.plugin.recharge.model.a aVar2 : a.b(this.mpr)) {
                    if (aVar2.mov.equals(a.a(this.mpr))) {
                        aVar2.mox = com.tencent.mm.plugin.recharge.model.a.mot;
                        arrayList.clear();
                        arrayList.add(aVar2);
                    }
                }
                if (arrayList.size() <= 0) {
                    if (MallEditText.f(this.mpr.mpl) == null) {
                        try {
                            MallEditText.a(this.mpr.mpl, com.tencent.mm.pluginsdk.a.cz(this.mpr.mpl.getContext()));
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.MallEditText", e, "", new Object[0]);
                        }
                    }
                    if (MallEditText.f(this.mpr.mpl) != null) {
                        for (String[] strArr : MallEditText.f(this.mpr.mpl)) {
                            String pK2 = b.pK(strArr[2]);
                            Object ej = ej(a.a(this.mpr), pK2);
                            if (com.tencent.mm.plugin.recharge.model.a.mot.equals(ej)) {
                                com.tencent.mm.plugin.recharge.model.a aVar3 = new com.tencent.mm.plugin.recharge.model.a(pK2, strArr[1], 1);
                                aVar3.mox = com.tencent.mm.plugin.recharge.model.a.mot;
                                arrayList.clear();
                                arrayList.add(aVar3);
                                break;
                            } else if (!com.tencent.mm.plugin.recharge.model.a.mou.equals(ej) && arrayList.size() < 5) {
                                com.tencent.mm.plugin.recharge.model.a aVar4 = new com.tencent.mm.plugin.recharge.model.a(pK2, strArr[1], 1);
                                aVar4.mox = ej;
                                arrayList.add(aVar4);
                            }
                        }
                    }
                }
                x.d("MicroMsg.MallEditText", " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                z = true;
            } else if (bi.oW(a.a(this.mpr))) {
                arrayList.addAll(a.b(this.mpr));
                z = false;
            } else {
                x.d("MicroMsg.MallEditText", "performFiltering " + charSequence);
                for (com.tencent.mm.plugin.recharge.model.a aVar22 : a.b(this.mpr)) {
                    if (aVar22.mov.startsWith(a.a(this.mpr))) {
                        arrayList.add(aVar22);
                    }
                }
                z = false;
            }
            if (arrayList.size() == 0) {
                MallEditText.a(this.mpr.mpl).post(new Runnable() {
                    public final void run() {
                        MallEditText.a(MallEditText$a$a.this.mpr.mpl).dismissDropDown();
                    }
                });
                z2 = false;
            } else {
                if (arrayList.size() == 1 && this.mpr.mpl.ZF()) {
                    aVar22 = (com.tencent.mm.plugin.recharge.model.a) arrayList.get(0);
                    if (com.tencent.mm.plugin.recharge.model.a.mot.equals(aVar22.mox)) {
                        MallEditText.a(this.mpr.mpl).post(new 3(this, aVar22));
                        z2 = false;
                    }
                }
                z2 = z;
            }
            List list = this.mpr.mpm;
            this.mpr.mpm = arrayList;
            this.mpr.mpn = z2;
            filterResults2.count = this.mpr.mpm.size();
            filterResults2.values = this.mpr.mpm;
            x.d("MicroMsg.MallEditText", "results.count " + filterResults2.count);
            list.clear();
            filterResults = filterResults2;
        }
        return filterResults;
    }

    protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
    }

    private static int[] ej(String str, String str2) {
        if (str.equals(str2)) {
            return com.tencent.mm.plugin.recharge.model.a.mot;
        }
        if (str2 != null && str.length() == str2.length()) {
            int i = 0;
            int[] iArr = new int[]{-1, -1};
            for (int length = str.length() - 1; length > 0; length--) {
                if (str2.charAt(length) != str.charAt(length)) {
                    i++;
                    if (i > 2) {
                        break;
                    }
                    iArr[i - 1] = length;
                }
            }
            if (i <= 2) {
                return iArr;
            }
        }
        return com.tencent.mm.plugin.recharge.model.a.mou;
    }
}
