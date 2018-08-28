package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class k extends i<ShareCardInfo> {
    public static final String[] diD = new String[]{i.a(ShareCardInfo.dhO, "ShareCardInfo")};
    public e diF;

    public static String nM(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList nJ = b.nJ(i);
        if (nJ == null || nJ.size() <= 0) {
            return "";
        }
        stringBuilder.append(" (");
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < nJ.size()) {
                if (i3 != 0) {
                    stringBuilder.append(" OR ");
                }
                stringBuilder.append("card_id").append(" = '" + ((String) nJ.get(i3)) + "' ");
                i2 = i3 + 1;
            } else {
                stringBuilder.append(") AND ");
                return stringBuilder.toString();
            }
        }
    }

    public k(e eVar) {
        super(eVar, ShareCardInfo.dhO, "ShareCardInfo", null);
        this.diF = eVar;
    }

    public final ArrayList<String> xy(String str) {
        ArrayList<String> arrayList = null;
        x.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), limit is 99");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 99");
        Cursor b = this.diF.b("select ShareCardInfo.from_username from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (b == null) {
            x.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), cursor == null");
        } else {
            int columnIndex = b.getColumnIndex("from_username");
            if (columnIndex == -1) {
                x.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), index is wrong");
                b.close();
            } else {
                arrayList = new ArrayList();
                while (b.moveToNext()) {
                    CharSequence string = b.getString(columnIndex);
                    if (TextUtils.isEmpty(string) || arrayList.contains(string)) {
                        x.e("MicroMsg.ShareCardInfoStorage", "the field_from_username is empty or username is added!, the card id is " + str);
                    } else {
                        arrayList.add(string);
                    }
                    if (arrayList.size() >= 99) {
                        break;
                    }
                }
                b.close();
            }
        }
        return arrayList;
    }

    public final int xz(String str) {
        int i = 0;
        x.i("MicroMsg.ShareCardInfoStorage", "getNormalCount()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        Cursor b = this.diF.b("select count(*) from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (b == null) {
            x.i("MicroMsg.ShareCardInfoStorage", "getNormalCount(), cursor == null");
        } else {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            b.close();
        }
        return i;
    }

    public final String xA(String str) {
        x.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 1");
        Cursor b = this.diF.b("select ShareCardInfo.card_id from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (b == null) {
            x.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), cursor == null");
            return "";
        }
        int columnIndex = b.getColumnIndex("card_id");
        if (columnIndex == -1) {
            x.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), index is wrong");
            b.close();
            return "";
        }
        String str2 = "";
        if (b.moveToFirst()) {
            str2 = b.getString(columnIndex);
        }
        b.close();
        return str2;
    }

    public final String ce(String str, String str2) {
        x.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str2 + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 2");
        Cursor b = this.diF.b("select ShareCardInfo.card_id from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (b == null) {
            x.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), cursor == null");
            return "";
        }
        int columnIndex = b.getColumnIndex("card_id");
        if (columnIndex == -1) {
            x.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), index is wrong");
            b.close();
            return "";
        }
        String str3 = "";
        while (b.moveToNext()) {
            str3 = b.getString(columnIndex);
            if (str != null && !str.equals(str3)) {
                break;
            }
        }
        b.close();
        return str3;
    }

    public final boolean nN(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (");
        stringBuilder.append("categoryType").append(" = '" + i + "'");
        stringBuilder.append(")");
        boolean fV = this.diF.fV("ShareCardInfo", "update ShareCardInfo set categoryType = '0' , itemIndex = '0' " + stringBuilder.toString());
        x.i("MicroMsg.ShareCardInfoStorage", "resetCategoryInfo updateRet is " + (fV ? 1 : 0));
        return fV;
    }

    public final boolean I(String str, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        boolean fV = this.diF.fV("ShareCardInfo", "update ShareCardInfo set categoryType = '" + i + "', itemIndex = '" + i2 + "' " + stringBuilder.toString());
        x.i("MicroMsg.ShareCardInfoStorage", "updateCategoryInfo updateRet is " + (fV ? 1 : 0));
        return fV;
    }

    public final void xB(String str) {
        this.diF.fV("ShareCardInfo", "delete from ShareCardInfo where card_id = '" + str + "'");
    }

    public final ShareCardInfo xC(String str) {
        ShareCardInfo shareCardInfo = new ShareCardInfo();
        shareCardInfo.field_card_id = str;
        return super.b(shareCardInfo, new String[0]) ? shareCardInfo : null;
    }
}
