package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n extends s {
    public LinkedList<m> nAH = new LinkedList();
    public int nAJ = 0;
    public boolean nAK = true;

    protected final List<s> bzF() {
        List<s> arrayList = new ArrayList(super.bzF());
        if (this.nAH != null) {
            Iterator it = this.nAH.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                if (mVar.nAH != null) {
                    arrayList.addAll(mVar.nAH);
                }
            }
        }
        return arrayList;
    }
}
