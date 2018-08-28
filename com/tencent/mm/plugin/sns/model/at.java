package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.protocal.c.bsu;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class at implements e {
    public List<WeakReference<e>> nrS = new LinkedList();

    public final void a(e eVar) {
        for (WeakReference weakReference : this.nrS) {
            if (weakReference != null && weakReference.get() != null && ((e) weakReference.get()).equals(eVar)) {
                return;
            }
        }
        this.nrS.add(new WeakReference(eVar));
    }

    public final void a(int i, String str, long j, String str2, bsu bsu, boolean z, bf bfVar) {
        for (WeakReference weakReference : this.nrS) {
            if (!(weakReference == null || weakReference.get() == null)) {
                ((e) weakReference.get()).a(i, str, j, str2, bsu, z, bfVar);
            }
        }
    }

    public final void a(int i, String str, long j, String str2, bsu bsu, boolean z) {
        for (WeakReference weakReference : this.nrS) {
            if (!(weakReference == null || weakReference.get() == null)) {
                ((e) weakReference.get()).a(i, str, j, str2, bsu, z);
            }
        }
    }
}
