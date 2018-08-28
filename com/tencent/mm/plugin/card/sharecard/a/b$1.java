package com.tencent.mm.plugin.card.sharecard.a;

import android.database.Cursor;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class b$1 implements Runnable {
    final /* synthetic */ String hyg;
    final /* synthetic */ ag hyh;

    b$1(String str, ag agVar) {
        this.hyg = str;
        this.hyh = agVar;
    }

    public final void run() {
        ArrayList arrayList = null;
        x.i("MicroMsg.ShareCardDataMgr", "begin to getShareUserInfo()");
        k axq = am.axq();
        String str = this.hyg;
        x.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        stringBuilder.append(" order by share_time desc ");
        Cursor b = axq.diF.b("select * from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (b == null) {
            x.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo(), cursor == null");
        } else {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            while (b.moveToNext()) {
                ShareCardInfo shareCardInfo = new ShareCardInfo();
                shareCardInfo.d(b);
                r rVar;
                if (arrayList3.contains(shareCardInfo.field_from_username)) {
                    int i = 0;
                    rVar = null;
                    while (i < arrayList2.size()) {
                        rVar = (r) arrayList2.get(i);
                        if (shareCardInfo.field_from_username != null && shareCardInfo.field_from_username.equals(rVar.hyG)) {
                            break;
                        }
                        i++;
                    }
                    i = 0;
                    if (rVar != null) {
                        rVar.hyH.add(0, shareCardInfo.field_card_id);
                        rVar.share_count++;
                        arrayList2.set(i, rVar);
                    }
                } else {
                    rVar = new r();
                    rVar.huU = shareCardInfo.field_card_tp_id;
                    rVar.hyG = shareCardInfo.field_from_username;
                    rVar.hyH = new ArrayList();
                    rVar.hyH.add(shareCardInfo.field_card_id);
                    rVar.share_count = 1;
                    arrayList2.add(rVar);
                    arrayList3.add(shareCardInfo.field_from_username);
                }
            }
            b.close();
            arrayList = arrayList2;
        }
        x.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 1");
        if (arrayList == null || arrayList.size() == 0) {
            x.e("MicroMsg.ShareCardDataMgr", "getShareUserInfo(), share_user_list is null");
            return;
        }
        if (arrayList.get(0) != null) {
            ((r) arrayList.get(0)).hyI = true;
        }
        x.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 2");
        this.hyh.post(new 1(this, arrayList));
    }
}
