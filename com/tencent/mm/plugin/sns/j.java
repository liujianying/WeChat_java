package com.tencent.mm.plugin.sns;

import android.database.Cursor;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends c<mr> {
    public j() {
        this.sFo = mr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mr mrVar = (mr) bVar;
        if (mrVar instanceof mr) {
            List linkedList = new LinkedList();
            mrVar.bXD.bXE = null;
            mrVar.bXD.bXF = null;
            mrVar.bXD.bXG = null;
            x.i("MicroMsg.RecentlySnsMediaObjListener", "recently username " + mrVar.bXC.username);
            if (!bi.oW(mrVar.bXC.username)) {
                g.Ek();
                boolean z = mrVar.bXC.username.equals((String) g.Ei().DT().get(2, null));
                o byo = af.byo();
                String str = ("select *,rowid from SnsInfo " + o.aU(mrVar.bXC.username, z)) + " AND type in ( 1 , 15)" + o.nJs + " limit 3";
                x.d("MicroMsg.SnsInfoStorage", "getUserNewerInfo " + str);
                Cursor rawQuery = byo.diF.rawQuery(str, null);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        int i = 0;
                        do {
                            n nVar = new n();
                            nVar.d(rawQuery);
                            if (nVar.field_type != 21) {
                                Iterator it = nVar.bAJ().sqc.ruA.iterator();
                                while (it.hasNext()) {
                                    ate ate = (ate) it.next();
                                    if (ate.hcE == 2 || ate.hcE == 6) {
                                        i++;
                                        linkedList.add(ate);
                                        if (i >= 3) {
                                            break;
                                        }
                                    }
                                    i = i;
                                }
                            }
                        } while (rawQuery.moveToNext());
                        rawQuery.close();
                        if (linkedList.size() > 0) {
                            mrVar.bXD.bXE = (ate) linkedList.get(0);
                        }
                        if (linkedList.size() > 1) {
                            mrVar.bXD.bXF = (ate) linkedList.get(1);
                        }
                        if (linkedList.size() > 2) {
                            mrVar.bXD.bXG = (ate) linkedList.get(2);
                        }
                    } else {
                        rawQuery.close();
                    }
                }
            }
            return true;
        }
        x.f("MicroMsg.RecentlySnsMediaObjListener", "mismatched event");
        return false;
    }
}
