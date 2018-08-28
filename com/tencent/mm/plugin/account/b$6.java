package com.tencent.mm.plugin.account;

import android.database.Cursor;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class b$6 extends c<hb> {
    final /* synthetic */ b eEO;

    b$6(b bVar) {
        this.eEO = bVar;
        this.sFo = hb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hb hbVar = (hb) bVar;
        if (hbVar instanceof hb) {
            String str = hbVar.bQl.bQn;
            if (bi.oW(str)) {
                x.e("MicroMsg.SubCoreFriend", "hy: mobile number is null");
            } else {
                Cursor b = b.getAddrUploadStg().dCZ.b("select addr_upload2.username from addr_upload2 where addr_upload2.moblie = " + str, null, 2);
                List linkedList = new LinkedList();
                while (b.moveToNext()) {
                    linkedList.add(b.getString(0));
                }
                b.close();
                x.i("MicroMsg.SubCoreFriend", "hy: username: %s", new Object[]{linkedList.size() == 0 ? "" : (String) linkedList.get(0)});
                hbVar.bQm.userName = str;
            }
        }
        return false;
    }
}
