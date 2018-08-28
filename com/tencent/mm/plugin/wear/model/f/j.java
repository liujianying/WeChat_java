package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.mm.bk.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.cen;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends b {
    private int bGz;
    private boolean bUB;
    private String talker;

    public j(String str, int i, boolean z) {
        this.talker = str;
        this.bGz = i;
        this.bUB = z;
    }

    private static String i(String str, ArrayList<bd> arrayList) {
        x.d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", new Object[]{str, Integer.valueOf(arrayList.size())});
        StringBuffer stringBuffer = new StringBuffer();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            stringBuffer.append(c(str, (bd) arrayList.get(size)));
            stringBuffer.append("​​");
        }
        return stringBuffer.toString().trim();
    }

    private static String R(ArrayList<bd> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bd bdVar = (bd) it.next();
            stringBuffer.append(bdVar.field_msgId);
            stringBuffer.append(bdVar.field_talker);
            stringBuffer.append(bdVar.field_content);
            stringBuffer.append(bdVar.getType());
            stringBuffer.append(bdVar.field_createTime);
        }
        return ac.ce(stringBuffer.toString());
    }

    public final String getName() {
        return "WearNotificationCreateTask";
    }

    protected final void send() {
        x.d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
        f PK = a.bSl().pIO.PK(this.talker);
        ArrayList arrayList = new ArrayList();
        int i = this.bGz - PK.pJw;
        if (i < 0) {
            i = 0;
        }
        x.d("MicroMsg.WearNotificationCreateTask", "limit=%d", new Object[]{Integer.valueOf(i)});
        au.HU();
        for (bd bdVar : c.FT().by(this.talker, i)) {
            if ((bdVar.isSystem() ? 0 : 1) != 0) {
                arrayList.add(bdVar);
            }
        }
        x.i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        if (arrayList.size() != 0) {
            String R = R(arrayList);
            if (PK.bKg.equals(R)) {
                x.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
                return;
            }
            PK.bKg = R;
            cen cen = new cen();
            cen.jTt = PK.id;
            cen.szk = PK.talker;
            cen.bHD = h.PP(PK.talker);
            cen.jSA = i(PK.talker, arrayList);
            cen.szw = this.bGz;
            cen.szy = this.bUB;
            cen.szx = !bk.cjj();
            Bitmap PO = h.PO(PK.talker);
            if (PO != null) {
                cen.szc = new b(h.N(PO));
            }
            x.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
            try {
                a.bSl();
                r.b(20003, cen.toByteArray(), true);
            } catch (IOException e) {
            }
            x.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
            a.bSl().pIO.a(PK);
            a.bSl().pIO.PN(this.talker);
            com.tencent.mm.plugin.wear.model.c.a.ee(6, 0);
            com.tencent.mm.plugin.wear.model.c.a.zC(1);
        }
    }
}
