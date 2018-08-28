package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.bt.a.e;
import com.tencent.mm.bt.a.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.d.d;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.OpenIMAddressUI.a;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class t extends a {
    private HashSet<String> ulc = new HashSet();
    private String uld;
    a ule;

    public t(Context context, String str, String str2) {
        super(context, str, null, 2);
        this.uld = str2;
    }

    protected final Cursor cxV() {
        long currentTimeMillis = System.currentTimeMillis();
        g.Ek();
        d appIdInfoStg = ((PluginOpenIM) g.n(PluginOpenIM.class)).getAppIdInfoStg();
        String str = this.uld;
        List linkedList = new LinkedList();
        Cursor b = appIdInfoStg.diF.b("select distinct appid from OpenIMAppIdInfo where acctTypeId=? ", new String[]{str}, 2);
        if (b.moveToFirst()) {
            do {
                str = b.getString(0);
                if (!bi.oW(str)) {
                    linkedList.add(str);
                }
            } while (b.moveToNext());
        }
        b.close();
        au.HU();
        Cursor a = c.FR().a(this.gRN, w.fD(ad.getContext()), linkedList);
        if (a instanceof f) {
            a = new e(new com.tencent.mm.bt.a.d[]{(com.tencent.mm.bt.a.d) com.tencent.mm.bt.d.cnR(), (f) a});
        }
        x.d("OpenIMContactAdapter", "createNewCursor : " + (System.currentTimeMillis() - currentTimeMillis));
        return a;
    }

    protected final int a(com.tencent.mm.storage.f fVar, int i) {
        if (fVar == null) {
            x.e("OpenIMContactAdapter", "contact is null, position:%d", new Object[]{Integer.valueOf(i)});
            return -1;
        } else if (bi.oW(fVar.field_descWording)) {
            return -1;
        } else {
            return fVar.field_descWording.hashCode();
        }
    }

    protected final String b(com.tencent.mm.storage.f fVar, int i) {
        String str = fVar.field_descWording;
        return bi.oW(str) ? "#" : str;
    }

    protected final void a(com.tencent.mm.storage.f fVar, a$b a_b) {
        String str = fVar.field_descWordingId;
        if (!this.ulc.contains(str)) {
            this.ulc.add(str);
            ((b) g.l(b.class)).aE(fVar.field_openImAppid, str);
        }
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("OpenIMContactAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        au.HU();
        if (mVar != c.FR()) {
            return;
        }
        if (ab.XR((String) obj)) {
            this.ule.uhx = true;
        } else {
            x.d("OpenIMContactAdapter", "newcursor is not openim ，return");
        }
    }
}
