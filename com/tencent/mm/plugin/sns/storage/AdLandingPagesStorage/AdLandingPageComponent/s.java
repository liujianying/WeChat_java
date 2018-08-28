package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public abstract class s implements Serializable {
    public int bID;
    public float height;
    public String nAW;
    public int nAX;
    public float nAY;
    public float nAZ;
    public float nBa;
    public float nBb;
    public float nBc = -2.0f;
    public float nBd = -2.0f;
    public boolean nBe;
    public String nBf = "";
    public int nBg;
    public int nBh;
    public boolean nBi;
    public boolean nBj;
    public int nBk;
    public boolean nBl;
    public int nBm;
    public String ntU;
    public int type;
    public String uin;
    public float width;

    public final void wL(int i) {
        this.nBk = i;
        for (s wL : bzF()) {
            wL.wL(i);
        }
    }

    public final void ii(boolean z) {
        this.nBl = z;
        for (s ii : bzF()) {
            ii.ii(z);
        }
    }

    public final void MV(String str) {
        this.ntU = str;
        for (s MV : bzF()) {
            MV.MV(str);
        }
    }

    public final void MW(String str) {
        this.uin = str;
        for (s MW : bzF()) {
            MW.MW(str);
        }
    }

    public final void wM(int i) {
        this.nBm = i;
        for (s wM : bzF()) {
            wM.wM(i);
        }
    }

    protected List<s> bzF() {
        return Collections.emptyList();
    }
}
