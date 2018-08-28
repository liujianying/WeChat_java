package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.b;
import com.tencent.mm.protocal.c.bxh;
import java.util.List;

class ExdeviceRankDataSourceUI$3 implements Runnable {
    final /* synthetic */ ExdeviceRankDataSourceUI iFe;
    final /* synthetic */ List iFf;

    ExdeviceRankDataSourceUI$3(ExdeviceRankDataSourceUI exdeviceRankDataSourceUI, List list) {
        this.iFe = exdeviceRankDataSourceUI;
        this.iFf = list;
    }

    public final void run() {
        b b = ExdeviceRankDataSourceUI.b(this.iFe);
        List<bxh> list = this.iFf;
        b.iFi.clear();
        if (!(list == null || list.size() == 0)) {
            for (bxh bxh : list) {
                if (bxh != null) {
                    b.iFi.add(ExdeviceRankDataSourceUI.a(bxh));
                }
            }
        }
        ExdeviceRankDataSourceUI.b(this.iFe).notifyDataSetChanged();
    }
}
