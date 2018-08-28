package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class c extends i<CardInfo> {
    public static final String[] diD = new String[]{i.a(CardInfo.dhO, "UserCardInfo"), "CREATE INDEX IF NOT EXISTS  stickyIndexIndex ON UserCardInfo ( stickyIndex ) "};
    public e diF;

    public c(e eVar) {
        super(eVar, CardInfo.dhO, "UserCardInfo", null);
        this.diF = eVar;
    }

    public final Cursor nH(int i) {
        this.diF.fV("UserCardInfo", "update UserCardInfo set stickyIndex=0, stickyEndTime=0 where stickyIndex>0 and (" + bi.VE() + ">stickyEndTime and stickyEndTime<>0)");
        StringBuilder stringBuilder = new StringBuilder("select * from UserCardInfo");
        switch (1.hwe[i - 1]) {
            case 1:
                stringBuilder.append(" where (status=0 OR status=5)");
                break;
            case 2:
            case 3:
                stringBuilder.append(" where (status=0 OR status=5) AND card_type=10");
                break;
            case 4:
                stringBuilder.append(" where (status=0 OR status=5) AND card_type!=10");
                break;
            case 5:
                stringBuilder.append(" where (status=1 OR status=2 OR status=3 OR status=4 OR status=6)");
                break;
            case 6:
                stringBuilder.append(" where (status=0 OR status=5) and (block_mask= '1' OR block_mask= '0' )");
                break;
        }
        stringBuilder.append(" order by stickyIndex desc, status asc , updateTime desc");
        if (i == a.hwS) {
            stringBuilder.append(" LIMIT 3");
        }
        return this.diF.rawQuery(stringBuilder.toString(), null);
    }

    public final CardInfo xm(String str) {
        CardInfo cardInfo = new CardInfo();
        cardInfo.field_card_id = str;
        return super.b(cardInfo, new String[0]) ? cardInfo : null;
    }

    public final List<CardInfo> awW() {
        Cursor rawQuery = this.diF.rawQuery("select * from UserCardInfo where is_dynamic=?", new String[]{"1"});
        if (rawQuery == null) {
            x.e("MicroMsg.CardInfoStorage", "getCardInfoList by is_dynamic is failure! cu is null!");
            return null;
        }
        List<CardInfo> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            try {
                CardInfo cardInfo = new CardInfo();
                cardInfo.d(rawQuery);
                arrayList.add(cardInfo);
            } catch (Exception e) {
                x.e("MicroMsg.CardInfoStorage", "getCardInfoList by is_dynamic is failure! is_dynamic = true", new Object[]{e.getMessage()});
                return arrayList;
            } finally {
                rawQuery.close();
            }
        }
        return arrayList;
    }
}
