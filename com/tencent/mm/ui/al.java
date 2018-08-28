package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.ArrayList;
import java.util.List;

public final class al {
    public static List<String> cqV() {
        int GJ = q.GJ();
        List<String> arrayList = new ArrayList();
        if ((GJ & 32768) == 0) {
            arrayList.add("floatbottle");
            x.d("MicroMsg.LauncherUI", "add bottle into show unread count blacklist.");
        }
        au.HU();
        if (!c.DT().getBoolean(a.sUk, true)) {
            arrayList.add("notifymessage");
            x.d("MicroMsg.UnreadCountHelper", "add service notify message into show unread count blacklist.");
        }
        au.HU();
        if (!c.DT().getBoolean(a.sUl, true)) {
            arrayList.add("appbrandcustomerservicemsg");
            x.d("MicroMsg.UnreadCountHelper", "add wxa custom session notify message into show unread count blacklist.");
        }
        x.d("MicroMsg.LauncherUI", "getShowUnreadCountBlacklist unread count blacklist(size : %s).", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }
}
