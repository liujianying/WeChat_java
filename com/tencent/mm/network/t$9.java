package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.sdk.platformtools.bd;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

class t$9 extends bd<Object> {
    final /* synthetic */ Map esE;
    final /* synthetic */ Map esF;
    final /* synthetic */ int[] esG;
    final /* synthetic */ int[] esH;
    final /* synthetic */ t esu;

    t$9(t tVar, Object obj, Map map, Map map2, int[] iArr, int[] iArr2) {
        this.esu = tVar;
        this.esE = map;
        this.esF = map2;
        this.esG = iArr;
        this.esH = iArr2;
        super(3000, obj, (byte) 0);
    }

    public final Object run() {
        for (Entry entry : this.esE.entrySet()) {
            MMLogic.saveAuthLongIPs((String) entry.getKey(), (String[]) ((ArrayList) entry.getValue()).toArray(new String[0]));
        }
        for (Entry entry2 : this.esF.entrySet()) {
            MMLogic.saveAuthShortIPs((String) entry2.getKey(), (String[]) ((ArrayList) entry2.getValue()).toArray(new String[0]));
        }
        MMLogic.saveAuthPorts(this.esG, this.esH);
        BaseEvent.onNetworkChange();
        return null;
    }
}
