package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.sj;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.protocal.c.bps;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p extends c<sj> {
    public p() {
        this.sFo = sj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 0;
        sj sjVar = (sj) bVar;
        if (sjVar instanceof sj) {
            if (sjVar.cde.cdg instanceof v) {
                v vVar = (v) sjVar.cde.cdg;
                int i2 = vVar.noH;
                LinkedList linkedList = vVar.noG;
                sjVar.cdf.state = i2;
                if (i2 == 2) {
                    if (linkedList != null && linkedList.size() > 0) {
                        af.byu().fl(7);
                    }
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            bps bps = (bps) it.next();
                            if (bps.snO == 7) {
                                t tVar = new t();
                                v.a(tVar, bps);
                                af.byu().a(tVar);
                            }
                        }
                    }
                }
                if (i2 != 1) {
                    t fk = af.byu().fk(7);
                    sj.b bVar2 = sjVar.cdf;
                    List linkedList2 = new LinkedList();
                    if (fk.field_memberList != null) {
                        String[] split = fk.field_memberList.split(",");
                        int length = split.length;
                        while (i < length) {
                            linkedList2.add(split[i]);
                            i++;
                        }
                    }
                    bVar2.cdh = linkedList2;
                }
            }
            return true;
        }
        x.f("MicroMsg.UpdateSnsTagListListener", "mismatched event");
        return false;
    }
}
