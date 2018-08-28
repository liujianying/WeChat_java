package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.k.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r;

public final class c extends r<ShareCardInfo> {
    private final String TAG = "MicroMsg.ShareCardAdatper";
    long beginTime = 0;
    long endTime = 0;
    private int hzH = 0;
    com.tencent.mm.plugin.card.base.c hzI;
    int hzJ = -1;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ShareCardInfo shareCardInfo = (ShareCardInfo) obj;
        if (shareCardInfo == null) {
            shareCardInfo = new ShareCardInfo();
        }
        if (cursor.isClosed()) {
            x.e("MicroMsg.ShareCardAdatper", "cursor is closed!");
        } else {
            shareCardInfo.d(cursor);
        }
        return shareCardInfo;
    }

    public c(Context context) {
        super(context, new ShareCardInfo());
        lB(true);
        this.hzI = new j(context, this);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.hzI.a(i, view, (ShareCardInfo) getItem(i));
    }

    public final void WT() {
        Cursor rawQuery;
        this.beginTime = System.currentTimeMillis();
        if (this.hzJ == -1) {
            k axq = am.axq();
            int i = a.hwN;
            StringBuilder stringBuilder = new StringBuilder();
            switch (1.hwe[i - 1]) {
                case 1:
                    stringBuilder.append(" where (status=0 OR status=5)");
                    break;
                case 2:
                    stringBuilder.append(" where (status=1 OR status=2 OR status=3 OR status=4 OR status=6)");
                    break;
                case 3:
                    stringBuilder.append(" where (status=0 OR status=5) and (block_mask= '1' OR block_mask= '0' )");
                    break;
            }
            rawQuery = axq.diF.rawQuery("select * from ShareCardInfo" + stringBuilder.toString() + " order by status asc , share_time desc", null);
        } else {
            k axq2 = am.axq();
            int i2 = this.hzJ;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" where ( status=0) ");
            String str = "";
            switch (i2) {
                case 1:
                    stringBuilder2.append(" AND ");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(k.nM(1));
                    stringBuilder2.append(" categoryType= '10' ");
                    stringBuilder2.append(") ");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 2:
                    stringBuilder2.append(" AND (");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(k.nM(1));
                    stringBuilder2.append(" categoryType= '10' ");
                    stringBuilder2.append(") ");
                    stringBuilder2.append(" OR (");
                    stringBuilder2.append(k.nM(2));
                    stringBuilder2.append(" categoryType= '0' ");
                    stringBuilder2.append(") ");
                    stringBuilder2.append(" )");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 3:
                    stringBuilder2.append(" AND ");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(k.nM(2));
                    stringBuilder2.append(" categoryType= '0' ");
                    stringBuilder2.append(") ");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 4:
                    stringBuilder2.append(" AND 1 != 1 ");
                    break;
            }
            rawQuery = axq2.diF.rawQuery("select * from ShareCardInfo" + stringBuilder2.toString() + str, null);
        }
        if (rawQuery != null) {
            this.hzH = rawQuery.getCount();
            x.i("MicroMsg.ShareCardAdatper", "resetCursor showType %s, card count:%s", new Object[]{Integer.valueOf(this.hzJ), Integer.valueOf(this.hzH)});
        } else {
            x.e("MicroMsg.ShareCardAdatper", "resetCursor cursor is null, showType %s", new Object[]{Integer.valueOf(this.hzJ)});
        }
        setCursor(rawQuery);
        this.endTime = System.currentTimeMillis();
        notifyDataSetChanged();
    }

    protected final void WS() {
        aYc();
        WT();
    }
}
