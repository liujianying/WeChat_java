package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.storage.aa.a;

class SightSettingsUI$b {
    final /* synthetic */ SightSettingsUI lqC;
    public String lqF;
    String[] lqG;
    int[] lqH;
    a lqI;

    public SightSettingsUI$b(SightSettingsUI sightSettingsUI, String str, a aVar, String[] strArr, int[] iArr) {
        this.lqC = sightSettingsUI;
        this.lqF = str;
        this.lqG = strArr;
        this.lqI = aVar;
        this.lqH = iArr;
    }

    final String te(int i) {
        int i2 = 0;
        while (i2 < this.lqH.length) {
            if (i == this.lqH[i2] && i2 < this.lqG.length) {
                return this.lqG[i2];
            }
            i2++;
        }
        return this.lqG[0];
    }
}
