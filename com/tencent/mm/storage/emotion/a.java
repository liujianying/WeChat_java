package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.bt.g;
import com.tencent.mm.bt.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class a extends i<EmojiGroupInfo> implements com.tencent.mm.bt.g.a {
    public static final String[] diD = new String[]{i.a(EmojiGroupInfo.dhO, "EmojiGroupInfo")};
    public e diF;

    public a(e eVar) {
        super(eVar, EmojiGroupInfo.dhO, "EmojiGroupInfo", null);
        this.diF = eVar;
    }

    public final String getTableName() {
        return "EmojiGroupInfo";
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.diF = gVar;
        }
        return 0;
    }

    public final boolean gg(Context context) {
        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init start.");
        gh(context);
        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init end.");
        return true;
    }

    private ArrayList<EmojiGroupInfo> gh(Context context) {
        InputStream inputStream = null;
        Object arrayList = new ArrayList();
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml start.");
            inputStream = context.getAssets().open("custom_emoji/manifest.xml");
            NodeList elementsByTagName = newInstance.newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("catalog");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                Element element = (Element) elementsByTagName.item(i);
                int intValue = Integer.decode(element.getAttribute("id")).intValue();
                if (!TextUtils.isEmpty(element.getAttribute("sort"))) {
                    x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "Set Sort id:%d,sort:%d", new Object[]{Integer.valueOf(intValue), Integer.decode(element.getAttribute("sort"))});
                    int i2 = EmojiGroupInfo.tcz;
                    if ((intValue & i2) == i2) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0 || (cnd() <= 0 && !cnl())) {
                        emojiGroupInfo.field_sort = i + 1;
                    } else {
                        emojiGroupInfo.field_sort = -1;
                        com.tencent.mm.kernel.g.Ei().DT().set(208912, Boolean.valueOf(true));
                        x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "moveCustomEmojiTabToSecond");
                    }
                }
                emojiGroupInfo.field_productID = String.valueOf(intValue);
                emojiGroupInfo.field_packName = element.getAttribute("name");
                if (!TextUtils.isEmpty(element.getAttribute("type"))) {
                    emojiGroupInfo.field_type = Integer.decode(element.getAttribute("type")).intValue();
                }
                if (!TextUtils.isEmpty(element.getAttribute("free"))) {
                    emojiGroupInfo.field_packType = Integer.decode(element.getAttribute("free")).intValue();
                }
                if (emojiGroupInfo.field_type == EmojiGroupInfo.TYPE_SYSTEM || emojiGroupInfo.field_type == EmojiGroupInfo.TYPE_CUSTOM) {
                    arrayList.add(emojiGroupInfo);
                }
            }
            if (arrayList.size() > 0) {
                ds(arrayList);
            }
            x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml end.");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e, "", new Object[0]);
                }
            }
        } catch (Throwable e2) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[]{bi.i(e2)});
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "init emoji group db error." + e2.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e22, "", new Object[0]);
                }
            }
        } catch (Throwable e222) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[]{bi.i(e222)});
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "parse xml error; " + e222.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e2222) {
                    x.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e2222, "", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e3, "", new Object[0]);
                }
            }
        }
        return arrayList;
    }

    public final EmojiGroupInfo br(String str, boolean z) {
        EmojiGroupInfo emojiGroupInfo;
        Exception e;
        EmojiGroupInfo emojiGroupInfo2;
        Throwable th;
        String str2 = "select * from EmojiGroupInfo where productID= ?";
        Cursor b;
        try {
            b = this.diF.b(str2, new String[]{str}, 2);
            if (b != null) {
                try {
                    if (b.moveToFirst()) {
                        emojiGroupInfo = new EmojiGroupInfo();
                        try {
                            emojiGroupInfo.d(b);
                            if (b == null) {
                                return emojiGroupInfo;
                            }
                            b.close();
                            return emojiGroupInfo;
                        } catch (Exception e2) {
                            e = e2;
                            emojiGroupInfo2 = emojiGroupInfo;
                            try {
                                x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get getEmojiGroupInof fail. product id is" + str + " " + e.getMessage());
                                if (b == null) {
                                    emojiGroupInfo = emojiGroupInfo2;
                                } else {
                                    b.close();
                                    emojiGroupInfo = emojiGroupInfo2;
                                }
                                if (emojiGroupInfo == null) {
                                    return emojiGroupInfo;
                                }
                                if (z) {
                                    return null;
                                }
                                return new EmojiGroupInfo();
                            } catch (Throwable th2) {
                                th = th2;
                                if (b != null) {
                                    b.close();
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    emojiGroupInfo2 = null;
                    x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get getEmojiGroupInof fail. product id is" + str + " " + e.getMessage());
                    if (b == null) {
                        b.close();
                        emojiGroupInfo = emojiGroupInfo2;
                    } else {
                        emojiGroupInfo = emojiGroupInfo2;
                    }
                    if (emojiGroupInfo == null) {
                        return emojiGroupInfo;
                    }
                    if (z) {
                        return null;
                    }
                    return new EmojiGroupInfo();
                }
            }
            if (b != null) {
                b.close();
                emojiGroupInfo = null;
            } else {
                emojiGroupInfo = null;
            }
        } catch (Exception e32) {
            e = e32;
            b = null;
            emojiGroupInfo2 = null;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            throw th;
        }
        if (emojiGroupInfo == null) {
            return emojiGroupInfo;
        }
        if (z) {
            return null;
        }
        return new EmojiGroupInfo();
    }

    private int cnd() {
        int i = 0;
        Cursor cursor = null;
        String str = "select  count(*) from EmojiInfo where catalog=?";
        try {
            cursor = this.diF.b(str, new String[]{EmojiGroupInfo.tcA}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public final boolean cne() {
        boolean z = true;
        Cursor cursor = null;
        try {
            cursor = this.diF.b("select * from EmojiGroupInfo where type=?", new String[]{EmojiGroupInfo.TYPE_SYSTEM}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
            EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
            emojiGroupInfo.d(cursor);
            if ((emojiGroupInfo.field_flag & ab.CTRL_BYTE) > 0) {
                z = false;
            }
            if (cursor == null) {
                return z;
            }
            cursor.close();
            return z;
        } catch (Exception e) {
            x.d("MicroMsg.emoji.EmojiGroupInfoStorage", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final List<EmojiGroupInfo> cnf() {
        Cursor cursor = null;
        List<EmojiGroupInfo> arrayList = new ArrayList();
        try {
            cursor = this.diF.b("select * from EmojiGroupInfo where " + Dq(EmojiGroupInfo.TYPE_SYSTEM) + " or " + Dq(EmojiGroupInfo.TYPE_CUSTOM) + " order by sort ASC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.d(cursor);
                arrayList.add(emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get system group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final List<EmojiGroupInfo> cng() {
        Cursor cursor = null;
        List<EmojiGroupInfo> arrayList = new ArrayList();
        try {
            cursor = this.diF.b("select * from EmojiGroupInfo where " + cno() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.d(cursor);
                arrayList.add(emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final HashMap<String, EmojiGroupInfo> cnh() {
        Cursor cursor = null;
        HashMap<String, EmojiGroupInfo> hashMap = new HashMap();
        try {
            cursor = this.diF.b("select * from EmojiGroupInfo where " + cno() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return hashMap;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.d(cursor);
                hashMap.put(emojiGroupInfo.field_productID, emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final ArrayList<EmojiGroupInfo> cni() {
        Cursor cursor = null;
        ArrayList<EmojiGroupInfo> arrayList = new ArrayList();
        try {
            cursor = this.diF.b("select * from EmojiGroupInfo where " + cnp() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.d(cursor);
                arrayList.add(emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final int cnj() {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = this.diF.b("select count(*) from EmojiGroupInfo where " + cnp() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getDownloadGroupListCount fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public final HashMap<String, ao> cnk() {
        Cursor cursor = null;
        HashMap<String, ao> hashMap = new HashMap();
        try {
            cursor = this.diF.b("select * from EmojiGroupInfo where " + cnp() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return hashMap;
            }
            ao aoVar = new ao();
            int columnIndex = cursor.getColumnIndex("productID");
            int columnIndex2 = cursor.getColumnIndex("packName");
            do {
                String string = cursor.getString(columnIndex);
                aoVar.bKk = string;
                aoVar.ioy = cursor.getString(columnIndex2);
                aoVar.Dl(7);
                hashMap.put(string, aoVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get download group map failed." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final boolean Zt(String str) {
        Cursor cursor = null;
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "product id is null.");
        }
        try {
            cursor = this.diF.b("select count(*) from EmojiGroupInfo where productID = '" + str + "' AND  ( status = '7' ) " + " AND ( ( ( flag & 256 ) = 0 )  or ( flag is null ) ) ", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            }
            if (cursor.getInt(0) > 0) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
            return z;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static boolean cnl() {
        return ((Boolean) com.tencent.mm.kernel.g.Ei().DT().get(208912, Boolean.valueOf(false))).booleanValue();
    }

    /* renamed from: c */
    public final boolean b(EmojiGroupInfo emojiGroupInfo) {
        if (emojiGroupInfo == null) {
            x.f("MicroMsg.emoji.EmojiGroupInfoStorage", "insert assertion!,invalid emojigroup info.");
            return false;
        }
        emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        emojiGroupInfo.field_sort = 1;
        x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks insert: packname: %s, lasttime: %d", new Object[]{emojiGroupInfo.field_packName, Long.valueOf(emojiGroupInfo.field_lastUseTime)});
        emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        if (emojiGroupInfo != null) {
            emojiGroupInfo.field_flag &= -257;
        }
        boolean a = a(emojiGroupInfo);
        if (a) {
            b("event_update_group", 0, bi.cjd().toString());
        }
        return a;
    }

    public final boolean ds(List<EmojiGroupInfo> list) {
        if (list == null || list.size() <= 0) {
            x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "updateList . list is null.");
            return false;
        }
        long dO;
        h hVar = null;
        if (this.diF instanceof h) {
            h hVar2 = (h) this.diF;
            dO = hVar2.dO(Thread.currentThread().getId());
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround updateList in a transaction, ticket = %d", new Object[]{Long.valueOf(dO)});
            hVar = hVar2;
        } else {
            dO = -1;
        }
        for (int i = 0; i < list.size(); i++) {
            x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks packname: productid: %s, lasttime: %d, sort: %d", new Object[]{r0.field_productID, Long.valueOf(r0.field_lastUseTime), Integer.valueOf(((EmojiGroupInfo) list.get(i)).field_sort)});
            a(r0);
        }
        if (hVar != null) {
            hVar.gp(dO);
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
        }
        b("event_update_group", 0, bi.cjd().toString());
        return true;
    }

    public final boolean Zu(String str) {
        boolean z;
        if (!bi.oW(str)) {
            try {
                if (str.equals("com.tencent.xin.emoticon.tusiji")) {
                    str = EmojiGroupInfo.tcy;
                }
                EmojiGroupInfo br = br(str, true);
                if (br == null) {
                    z = false;
                } else {
                    if (br != null) {
                        if (br.field_type == EmojiGroupInfo.TYPE_CUSTOM) {
                            x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks refuse delete custom emoji");
                        } else {
                            br.field_flag |= ab.CTRL_BYTE;
                            br.field_status = -1;
                            br.field_sort = 1;
                            br.field_recommand = 0;
                            br.field_sync = 0;
                        }
                    }
                    br.field_lastUseTime = System.currentTimeMillis();
                    br.field_recommand = 0;
                    br.field_sync = 0;
                    z = a(br);
                }
            } catch (Exception e) {
                x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Delete By ProductId fail." + e.getMessage());
            }
            if (z) {
                b("event_update_group", 0, bi.cjd().toString());
                Xp("delete_group");
            }
            return z;
        }
        z = false;
        if (z) {
            b("event_update_group", 0, bi.cjd().toString());
            Xp("delete_group");
        }
        return z;
    }

    public final void ac(ArrayList<String> arrayList) {
        long dO;
        h hVar = null;
        if (this.diF instanceof h) {
            h hVar2 = (h) this.diF;
            dO = hVar2.dO(Thread.currentThread().getId());
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround deleteByGroupIdList in a transaction, ticket = %d", new Object[]{Long.valueOf(dO)});
            hVar = hVar2;
        } else {
            dO = -1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Zu((String) it.next());
            }
        }
        if (hVar != null) {
            hVar.gp(dO);
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end deleteByGroupIdList transaction");
        }
    }

    public final void cnm() {
        if (this.diF.fV("EmojiGroupInfo", "UPDATE EmojiGroupInfo SET sort=-1,lastUseTime=" + System.currentTimeMillis() + " WHERE type=" + (EmojiGroupInfo.TYPE_CUSTOM))) {
            b("event_update_group", 0, bi.cjd().toString());
        }
        com.tencent.mm.kernel.g.Ei().DT().set(208912, Boolean.valueOf(true));
    }

    public final ArrayList<EmojiGroupInfo> cnn() {
        Cursor cursor = null;
        ArrayList<EmojiGroupInfo> arrayList = new ArrayList();
        try {
            cursor = this.diF.b("select * from EmojiGroupInfo where " + cnp() + " or " + Dq(EmojiGroupInfo.TYPE_SYSTEM) + " or " + Dq(EmojiGroupInfo.TYPE_CUSTOM) + " or  ( recommand = '1' ) " + " order by sort ASC,idx ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.d(cursor);
                arrayList.add(emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static String cno() {
        return Dp(EmojiGroupInfo.TYPE_SYSTEM) + " or " + Dp(EmojiGroupInfo.TYPE_CUSTOM) + " or " + Dp(EmojiGroupInfo.tcv) + " or " + Dp(EmojiGroupInfo.tcx);
    }

    private static final String cnp() {
        return " ( " + Dp(EmojiGroupInfo.tcv) + " and  ( status = '7' ) " + " ) ";
    }

    private static final String Dp(int i) {
        return " ( type = '" + i + "' ) ";
    }

    private static final String Dq(int i) {
        return " ( " + Dp(i) + " and ( ( ( flag & 256 ) = 0 )  or ( flag is null ) )  ) ";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cnq() {
        /*
        r7 = this;
        r6 = 2;
        r0 = 1;
        r1 = 0;
        r3 = "select sync from EmojiGroupInfo where (type= ? or type= ? ) and sync=? and status=?";
        r2 = 4;
        r4 = new java.lang.String[r2];
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = com.tencent.mm.storage.emotion.EmojiGroupInfo.TYPE_SYSTEM;
        r2 = r2.append(r5);
        r2 = r2.toString();
        r4[r1] = r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = com.tencent.mm.storage.emotion.EmojiGroupInfo.tcv;
        r2 = r2.append(r5);
        r2 = r2.toString();
        r4[r0] = r2;
        r2 = "0";
        r4[r6] = r2;
        r2 = 3;
        r5 = "7";
        r4[r2] = r5;
        r2 = "MicroMsg.emoji.EmojiGroupInfoStorage";
        r5 = "checkStoreEmojiSync:%s";
        r6 = new java.lang.Object[r0];
        r6[r1] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r2, r5, r6);
        r2 = 0;
        r5 = r7.diF;	 Catch:{ Exception -> 0x0060, all -> 0x0071 }
        r6 = 2;
        r2 = r5.b(r3, r4, r6);	 Catch:{ Exception -> 0x0060, all -> 0x0071 }
        if (r2 == 0) goto L_0x0059;
    L_0x004d:
        r3 = r2.moveToFirst();	 Catch:{ Exception -> 0x007c, all -> 0x0071 }
        if (r3 == 0) goto L_0x0059;
    L_0x0053:
        if (r2 == 0) goto L_0x0058;
    L_0x0055:
        r2.close();
    L_0x0058:
        return r0;
    L_0x0059:
        if (r2 == 0) goto L_0x005e;
    L_0x005b:
        r2.close();
    L_0x005e:
        r0 = r1;
        goto L_0x0058;
    L_0x0060:
        r0 = move-exception;
        r0 = r2;
    L_0x0062:
        r2 = "MicroMsg.emoji.EmojiGroupInfoStorage";
        r3 = "checkStoreEmojiSync fail.";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ all -> 0x0079 }
        if (r0 == 0) goto L_0x005e;
    L_0x006d:
        r0.close();
        goto L_0x005e;
    L_0x0071:
        r0 = move-exception;
        r1 = r0;
    L_0x0073:
        if (r2 == 0) goto L_0x0078;
    L_0x0075:
        r2.close();
    L_0x0078:
        throw r1;
    L_0x0079:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0073;
    L_0x007c:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.a.cnq():boolean");
    }

    public final List<String> cnr() {
        List arrayList = new ArrayList();
        String[] strArr = new String[]{EmojiGroupInfo.tcv, "1"};
        Cursor cursor = null;
        try {
            cursor = this.diF.b("select productID from EmojiGroupInfo where type=? and sync=?", strArr, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getNeedToSyncStoreEmojiProductList. exception.%s", new Object[]{bi.cjd()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final List<String> cns() {
        List arrayList = new ArrayList();
        String[] strArr = new String[]{"0", EmojiGroupInfo.tcv, "7", EmojiGroupInfo.TYPE_SYSTEM, "0"};
        Cursor cursor = null;
        try {
            cursor = this.diF.b("select productID from EmojiGroupInfo where sync=? and (type=?  and status=?) or (type=? and flag=?)", strArr, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getNeedToUploadStoreEmojiProductList. exception.%s", new Object[]{bi.cjd()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final ArrayList<EmojiGroupInfo> cnt() {
        ArrayList<EmojiGroupInfo> arrayList = new ArrayList();
        String[] strArr = new String[]{EmojiGroupInfo.tcv, "7", EmojiGroupInfo.TYPE_SYSTEM, "0"};
        Cursor cursor = null;
        try {
            cursor = this.diF.b("select * from EmojiGroupInfo where  (type=?  and status=?) or (type=? and flag=?)  order by sort ASC,idx ASC,lastUseTime DESC", strArr, 2);
            x.v("MicroMsg.emoji.EmojiGroupInfoStorage", "getNewMineGroupList : ===========");
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.d(cursor);
                arrayList.add(emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final void cnu() {
        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart begin");
        EmojiGroupInfo br = br(String.valueOf(EmojiGroupInfo.tcz), false);
        if (br == null) {
            br = new EmojiGroupInfo();
        } else {
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "EmojiGroupInfo:%s", new Object[]{br.toString()});
        }
        br.field_productID = String.valueOf(EmojiGroupInfo.tcz);
        br.field_packName = "emoji_custom_group";
        br.field_type = EmojiGroupInfo.TYPE_CUSTOM;
        br.field_status = 0;
        br.field_packStatus = 1;
        br.field_flag = 0;
        a(br);
        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart end");
    }

    public final int zs(String str) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor cursor = null;
        try {
            cursor = this.diF.b("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{str, "0"}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                i = 0;
            } else {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[]{bi.i(e)});
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
                i = 0;
            } else {
                i = 0;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "count product id use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return i;
    }
}
