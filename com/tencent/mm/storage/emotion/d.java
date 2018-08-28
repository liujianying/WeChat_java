package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mm.bt.g;
import com.tencent.mm.bt.g.a;
import com.tencent.mm.bt.h;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class d extends i<EmojiInfo> implements a {
    public static final String[] diD = new String[]{i.a(EmojiInfo.dhO, "EmojiInfo"), "CREATE INDEX IF NOT EXISTS emojiinfogrouptempindex  on EmojiInfo  (  groupId,temp )", "CREATE INDEX IF NOT EXISTS emojiinfogatalogindex  on EmojiInfo  (  catalog )"};
    private static int[] tcY = new int[]{2, 4, 8};
    public e diF;

    public d(e eVar) {
        super(eVar, EmojiInfo.dhO, "EmojiInfo", null);
        this.diF = eVar;
    }

    public final String getTableName() {
        return "EmojiInfo";
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.diF = gVar;
        }
        return 0;
    }

    public final boolean gg(Context context) {
        x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init");
        EmojiInfo Zy = Zy("86cb157e9c44b2c9934e4e430790776d");
        EmojiInfo Zy2 = Zy("68f9864ca5c0a5d823ed7184e113a4aa");
        x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,group art custom catalog count:%d", new Object[]{Integer.valueOf(Dt(EmojiInfo.tcE))});
        if (Zy != null || ((Zy2 != null && Zy2.getContent().length() == 0) || r2 <= 2)) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for very old version");
            Dv(EmojiInfo.tcD);
            Dv(EmojiInfo.tcG);
            Dv(EmojiInfo.tcF);
        }
        Zy = Zy("9bd1281af3a31710a45b84d736363691");
        if (Zy != null && Zy.field_catalog == EmojiInfo.tcD) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.0");
            Dv(EmojiInfo.tcD);
            Dv(EmojiInfo.tcG);
            Dv(EmojiInfo.tcF);
        }
        InputStream bt = EmojiInfo.bt(context, "icon_002_cover.png");
        if (bt != null) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.1,update emoji tuzi  for 4.4");
            Dv(EmojiInfo.tcD);
            Dv(EmojiInfo.tcG);
            Dv(EmojiInfo.tcF);
        }
        if (bt != null) {
            try {
                bt.close();
            } catch (Exception e) {
            }
        }
        if (Dt(EmojiInfo.tcD) != 0) {
            return true;
        }
        InputStream inputStream = null;
        try {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml start.");
            long currentTimeMillis = System.currentTimeMillis();
            inputStream = context.getAssets().open("custom_emoji/manifest.xml");
            List<EmojiInfo> a = a(new InputStream[]{inputStream});
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]parse xml time: %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a.size() > 0 && a.size() > 0) {
                h hVar;
                currentTimeMillis = -1;
                if (this.diF instanceof h) {
                    h hVar2 = (h) this.diF;
                    currentTimeMillis = hVar2.dO(Thread.currentThread().getId());
                    hVar = hVar2;
                } else {
                    hVar = null;
                }
                for (EmojiInfo Zy3 : a) {
                    if (this.diF.replace("EmojiInfo", "md5", Zy3.wH()) < 0) {
                        if (hVar != null) {
                            hVar.gp(currentTimeMillis);
                        }
                    }
                }
                if (hVar != null) {
                    hVar.gp(currentTimeMillis);
                }
            }
            x.i("MicroMsg.emoji.EmojiInfoStorage", "insert time: %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
            x.d("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml end.");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e2) {
                    x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bi.i(e2)});
                }
            }
        } catch (IOException e3) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init, db error. " + e3.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e22) {
                    x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bi.i(e22)});
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e4) {
                    x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bi.i(e4)});
                }
            }
        }
        return true;
    }

    public final EmojiInfo n(EmojiInfo emojiInfo) {
        if (bi.oW(emojiInfo.Xh()) || emojiInfo.Xh().length() <= 0) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            return null;
        } else if (!b(emojiInfo)) {
            return null;
        } else {
            Xp("create_emoji_info_notify");
            return emojiInfo;
        }
    }

    public final EmojiInfo b(String str, String str2, int i, int i2, int i3, String str3) {
        return b(str, str2, i, i2, i3, null, str3);
    }

    public final EmojiInfo c(String str, String str2, int i, int i2, int i3, String str3) {
        return b(str, str2, i, i2, i3, null, str3);
    }

    public final EmojiInfo a(String str, String str2, int i, int i2, int i3, String str3, String str4) {
        return b(str, str2, i, i2, i3, str3, str4);
    }

    private EmojiInfo b(String str, String str2, int i, int i2, int i3, String str3, String str4) {
        if (str == null || str.length() <= 0) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            return null;
        }
        EmojiInfo emojiInfo;
        if (str == null || str.length() <= 0) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            emojiInfo = null;
        } else {
            emojiInfo = Zy(str);
            if (emojiInfo == null) {
                com.tencent.mm.plugin.emoji.d.aDh();
                emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aDi());
                emojiInfo.field_catalog = i;
            }
            emojiInfo.field_md5 = str;
            emojiInfo.field_svrid = str2;
            emojiInfo.field_type = i2;
            emojiInfo.field_size = i3;
            emojiInfo.field_state = EmojiInfo.tcN;
            emojiInfo.field_reserved1 = null;
            emojiInfo.field_reserved2 = null;
            emojiInfo.field_app_id = str3;
            emojiInfo.field_temp = 1;
            emojiInfo.field_reserved4 = 0;
            if (!TextUtils.isEmpty(str4)) {
                emojiInfo.field_groupId = str4;
            }
        }
        emojiInfo.field_state = EmojiInfo.tcP;
        if (!b(emojiInfo)) {
            return null;
        }
        Xp("create_emoji_info_notify");
        return emojiInfo;
    }

    /* renamed from: o */
    public final boolean b(EmojiInfo emojiInfo) {
        if (emojiInfo == null || !emojiInfo.cnB()) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        long replace = this.diF.replace("EmojiInfo", "md5", emojiInfo.wH());
        if (replace != -1) {
            Xp(emojiInfo.Xh());
        }
        if (replace >= 0) {
            return true;
        }
        return false;
    }

    public final boolean p(EmojiInfo emojiInfo) {
        if (emojiInfo == null || !emojiInfo.cnB()) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        int update = this.diF.update("EmojiInfo", emojiInfo.wH(), "md5=?", new String[]{emojiInfo.Xh()});
        if (update > 0) {
            Xp(emojiInfo.Xh());
            Xp("event_update_emoji");
        }
        if (update <= 0) {
            return false;
        }
        return true;
    }

    public final boolean q(EmojiInfo emojiInfo) {
        if (emojiInfo == null || !emojiInfo.cnB()) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        if (this.diF.update("EmojiInfo", emojiInfo.wH(), "md5=?", new String[]{emojiInfo.Xh()}) <= 0) {
            return false;
        }
        return true;
    }

    public final EmojiInfo Zy(String str) {
        Exception e;
        Throwable th;
        if (bi.oW(str) || str.length() != 32) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "md5 is null or invalue. md5:%s", new Object[]{str});
            return null;
        }
        Cursor a;
        EmojiInfo emojiInfo;
        try {
            a = this.diF.a("EmojiInfo", null, "md5=?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        com.tencent.mm.plugin.emoji.d.aDh();
                        emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aDi());
                        try {
                            emojiInfo.d(a);
                            if (a != null) {
                                return emojiInfo;
                            }
                            a.close();
                            return emojiInfo;
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                x.e("MicroMsg.emoji.EmojiInfoStorage", "[getByMd5]Exception:%s", new Object[]{e.toString()});
                                if (a != null) {
                                    return emojiInfo;
                                }
                                a.close();
                                return emojiInfo;
                            } catch (Throwable th2) {
                                th = th2;
                                if (a != null) {
                                    a.close();
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    emojiInfo = null;
                    x.e("MicroMsg.emoji.EmojiInfoStorage", "[getByMd5]Exception:%s", new Object[]{e.toString()});
                    if (a != null) {
                        return emojiInfo;
                    }
                    a.close();
                    return emojiInfo;
                }
            }
            emojiInfo = null;
            if (a != null) {
                return emojiInfo;
            }
            a.close();
            return emojiInfo;
        } catch (Exception e4) {
            e = e4;
            a = null;
            emojiInfo = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    private int Dt(int i) {
        int i2 = 0;
        Cursor cursor = null;
        try {
            cursor = this.diF.b("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{String.valueOf(i), "0"}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i2 = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bi.i(e)});
            x.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i2;
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
            x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bi.i(e)});
            x.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
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
        x.d("MicroMsg.emoji.EmojiInfoStorage", "count product id use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return i;
    }

    public final int ln(boolean z) {
        int i = 0;
        Cursor cursor = null;
        String str = "select count(*)  from EmojiInfo where catalog=? ";
        String[] strArr = new String[]{EmojiGroupInfo.tcA};
        if (z) {
            str = "select  count(*) from EmojiInfo where catalog IN (?,?)";
            strArr = new String[]{String.valueOf(EmojiGroupInfo.tcz), String.valueOf(EmojiGroupInfo.tcA)};
        }
        try {
            cursor = this.diF.b(str, strArr, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bi.i(e)});
            x.e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", new Object[]{e.toString()});
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

    public final List<EmojiInfo> cnG() {
        List<EmojiInfo> arrayList = new ArrayList();
        String[] strArr = new String[]{String.valueOf(EmojiGroupInfo.tcz), String.valueOf(EmojiGroupInfo.tcA), String.valueOf(EmojiInfo.tcQ)};
        Cursor b = this.diF.b("select  * from EmojiInfo where catalog=?  or catalog=? and state!=? order by reserved3 asc", strArr, 2);
        if (b.moveToFirst()) {
            do {
                com.tencent.mm.plugin.emoji.d.aDh();
                EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aDi());
                emojiInfo.d(b);
                arrayList.add(emojiInfo);
            } while (b.moveToNext());
        }
        b.close();
        return arrayList;
    }

    public final List<String> cnH() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.diF.b("select md5 from EmojiInfo where catalog=?  order by reserved3 asc", new String[]{EmojiGroupInfo.tcA}, 2);
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
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", new Object[]{bi.i(e)});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final List<String> cnI() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.diF.b("select md5 from EmojiInfo where catalog=? and source=?", new String[]{EmojiGroupInfo.tcA, EmojiInfo.tcT}, 2);
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
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", new Object[]{bi.i(e)});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final Cursor Du(int i) {
        return this.diF.query("EmojiInfo", null, "catalog=? and temp=?", new String[]{String.valueOf(i), "0"}, null, null, null);
    }

    private boolean Dv(int i) {
        if (this.diF.delete("EmojiInfo", "catalog=?", new String[]{String.valueOf(i)}) >= 0) {
            return true;
        }
        return false;
    }

    public final void a(Context context, EmojiInfo emojiInfo) {
        int available;
        if (emojiInfo.field_catalog == EmojiInfo.tcD || emojiInfo.field_catalog == EmojiInfo.tcG || emojiInfo.field_catalog == EmojiInfo.tcF) {
            InputStream inputStream = null;
            try {
                inputStream = EmojiInfo.bt(context, emojiInfo.getName());
                if (inputStream != null) {
                    available = inputStream.available();
                } else {
                    available = 0;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e) {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bi.i(e)});
                    }
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bi.i(e2)});
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        available = 0;
                    } catch (Throwable e22) {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bi.i(e22)});
                        available = 0;
                    }
                } else {
                    available = 0;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3) {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bi.i(e3)});
                    }
                }
            }
        } else {
            available = com.tencent.mm.a.e.cm(emojiInfo.mcn + emojiInfo.Xh());
        }
        if (available != 0 && available != emojiInfo.field_size) {
            emojiInfo.field_size = available;
            p(emojiInfo);
        }
    }

    private static List<EmojiInfo> a(InputStream[] inputStreamArr) {
        List<EmojiInfo> arrayList = new ArrayList();
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            for (int i = 0; i <= 0; i++) {
                InputStream inputStream = inputStreamArr[i];
                if (inputStream != null) {
                    NodeList elementsByTagName = newDocumentBuilder.parse(inputStream).getDocumentElement().getElementsByTagName("catalog");
                    for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                        Element element = (Element) elementsByTagName.item(i2);
                        int intValue = Integer.decode(element.getAttribute("id")).intValue();
                        NodeList elementsByTagName2 = element.getElementsByTagName("emoji");
                        for (int i3 = 0; i3 < elementsByTagName2.getLength(); i3++) {
                            com.tencent.mm.plugin.emoji.d.aDh();
                            EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aDi());
                            element = (Element) elementsByTagName2.item(i3);
                            emojiInfo.field_md5 = element.getAttribute("md5");
                            if (emojiInfo.cnB()) {
                                String str;
                                emojiInfo.field_catalog = intValue;
                                emojiInfo.field_groupId = String.valueOf(intValue);
                                emojiInfo.field_name = element.getAttribute("name");
                                emojiInfo.field_type = Integer.decode(element.getAttribute(DownloadSettingTable$Columns.TYPE)).intValue();
                                Node firstChild = element.getFirstChild();
                                String data = firstChild instanceof CharacterData ? ((CharacterData) firstChild).getData() : "";
                                if (emojiInfo.field_type == EmojiInfo.TYPE_TEXT) {
                                    str = new String(Base64.decode(data, 0));
                                } else {
                                    str = data;
                                }
                                emojiInfo.field_content = str;
                                arrayList.add(emojiInfo);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "parse xml error; " + e.getMessage());
        }
        return arrayList;
    }

    public final EmojiInfo Zz(String str) {
        EmojiInfo emojiInfo;
        Exception e;
        Throwable th;
        Cursor b;
        try {
            b = this.diF.b("select * from EmojiInfo where +groupId = ? and temp=? limit 1 ", new String[]{str, "0"}, 2);
            try {
                if (b.moveToFirst()) {
                    com.tencent.mm.plugin.emoji.d.aDh();
                    emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aDi());
                    try {
                        emojiInfo.d(b);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            x.e("MicroMsg.emoji.EmojiInfoStorage", "getFirstEmojiByGroupId fail." + e.getMessage());
                            if (b != null) {
                                b.close();
                            }
                            return emojiInfo;
                        } catch (Throwable th2) {
                            th = th2;
                            if (b != null) {
                                b.close();
                            }
                            throw th;
                        }
                    }
                }
                emojiInfo = null;
                if (b != null) {
                    b.close();
                }
            } catch (Exception e3) {
                e = e3;
                emojiInfo = null;
                x.e("MicroMsg.emoji.EmojiInfoStorage", "getFirstEmojiByGroupId fail." + e.getMessage());
                if (b != null) {
                    b.close();
                }
                return emojiInfo;
            }
        } catch (Exception e4) {
            e = e4;
            b = null;
            emojiInfo = null;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            throw th;
        }
        return emojiInfo;
    }

    public final List<EmojiInfo> zk(String str) {
        List<EmojiInfo> arrayList = new ArrayList();
        String str2 = "select * from EmojiInfo where groupId=? and temp=? order by idx asc";
        Cursor cursor = null;
        try {
            cursor = this.diF.b(str2, new String[]{str, "0"}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                com.tencent.mm.plugin.emoji.d.aDh();
                EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aDi());
                emojiInfo.d(cursor);
                arrayList.add(emojiInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.w("MicroMsg.emoji.EmojiInfoStorage", "[getEmojiListByGroupId] Exception:%s", new Object[]{e.toString()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final boolean dt(List<String> list) {
        boolean z = false;
        if (list == null || list.size() <= 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE");
        stringBuilder.append(" EmojiInfo ");
        stringBuilder.append(" SET ");
        stringBuilder.append("catalog");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.tcB);
        stringBuilder.append(",");
        stringBuilder.append("source");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.tcS);
        stringBuilder.append(",");
        stringBuilder.append("needupload");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.tcU);
        stringBuilder.append(" where ");
        stringBuilder.append("md5");
        stringBuilder.append(" IN (");
        while (true) {
            boolean z2 = z;
            if (z2 >= list.size()) {
                break;
            }
            stringBuilder.append("'" + ((String) list.get(z2)) + "'");
            if (z2 < list.size() - 1) {
                stringBuilder.append(",");
            }
            z = z2 + 1;
        }
        stringBuilder.append(")");
        x.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
        if (this.diF.fV("EmojiInfo", stringBuilder.toString())) {
            Xp("delete_emoji_info_notify");
        }
        return true;
    }

    public final boolean du(List<String> list) {
        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin topCustomEmojiByMd5");
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] topCustomEmojiByMd5 failed. list is null");
            return false;
        }
        long dO;
        List<String> cnH = cnH();
        h hVar = null;
        if (this.diF instanceof h) {
            h hVar2 = (h) this.diF;
            dO = hVar2.dO(Thread.currentThread().getId());
            hVar = hVar2;
        } else {
            dO = -1;
        }
        int i = 1;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            String str;
            if (it.hasNext()) {
                str = (String) it.next();
                EmojiInfo Zy = Zy(str);
                if (!(Zy == null || bi.oW(Zy.Xh()))) {
                    Zy.field_reserved3 = i2;
                    if (!cnH.isEmpty()) {
                        cnH.remove(str);
                    }
                    i2++;
                    if (this.diF.replace("EmojiInfo", "md5", Zy.wH()) < 0) {
                        if (hVar != null) {
                            hVar.gp(dO);
                        }
                        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        return false;
                    }
                }
                i = i2;
            } else {
                if (!cnH.isEmpty()) {
                    for (String str2 : cnH) {
                        EmojiInfo Zy2 = Zy(str2);
                        if (!(Zy2 == null || bi.oW(Zy2.Xh()))) {
                            Zy2.field_reserved3 = i2;
                            i2++;
                            if (this.diF.replace("EmojiInfo", "md5", Zy2.wH()) < 0) {
                                if (hVar != null) {
                                    hVar.gp(dO);
                                }
                                x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                return false;
                            }
                        }
                    }
                }
                if (hVar != null) {
                    hVar.gp(dO);
                }
                String str3 = "MicroMsg.emoji.EmojiInfoStorage";
                String str4 = "[cpan] end topCustomEmojiByMd5 user time:%d succes. size:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                objArr[1] = Integer.valueOf(list == null ? 0 : list.size());
                x.i(str3, str4, objArr);
                return true;
            }
        }
    }

    public final boolean j(List<EmojiInfo> list, String str) {
        if (list.size() <= 0) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "insert emoji list faild. list is null or size is 0.");
            return false;
        }
        long dO;
        EmojiInfo emojiInfo;
        x.i("MicroMsg.emoji.EmojiInfoStorage", "insertEmojiList groupId:%s size:%d", new Object[]{str, Integer.valueOf(list.size())});
        h hVar = null;
        if (this.diF instanceof h) {
            h hVar2 = (h) this.diF;
            dO = hVar2.dO(Thread.currentThread().getId());
            hVar = hVar2;
        } else {
            dO = -1;
        }
        List<EmojiInfo> zk = zk(str);
        Map hashMap = new HashMap();
        for (EmojiInfo emojiInfo2 : zk) {
            hashMap.put(emojiInfo2.Xh(), emojiInfo2);
        }
        for (int i = 0; i < list.size(); i++) {
            emojiInfo2 = (EmojiInfo) list.get(i);
            emojiInfo2.field_temp = 0;
            this.diF.replace("EmojiInfo", "md5", emojiInfo2.wH());
            hashMap.remove(emojiInfo2.Xh());
        }
        for (Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            emojiInfo2 = (EmojiInfo) entry.getValue();
            emojiInfo2.field_temp = 1;
            this.diF.update("EmojiInfo", emojiInfo2.wH(), "md5=?", new String[]{str2});
            x.d("MicroMsg.emoji.EmojiInfoStorage", "jacks modify excess emoji to %s", new Object[]{emojiInfo2.field_groupId});
        }
        if (hVar != null) {
            hVar.gp(dO);
        }
        return true;
    }

    public final boolean ZA(String str) {
        boolean z = false;
        String str2 = "select * from EmojiInfo where md5=?";
        Cursor cursor = null;
        try {
            cursor = this.diF.b(str2, new String[]{str}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get judge is Exist EmojiInfo fail. md5 id is %s, err: %s", new Object[]{str, e.getMessage()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return z;
    }

    public final boolean ZB(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.diF.delete("EmojiInfo", "groupId = '" + str + "'", null) >= 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "Delete By ProductId fail." + e.getMessage());
            return false;
        }
    }

    public final List<String> cnJ() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.diF.b("select md5 from EmojiInfo where catalog=? or temp=?", new String[]{"85", "2"}, 2);
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
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", new Object[]{bi.i(e)});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final int cnK() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = this.diF.rawQuery("select md5 from EmojiInfo where catalog=? or temp=?", new String[]{"85", "2"});
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getCount();
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", new Object[]{bi.i(e)});
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

    public final boolean at(LinkedList<String> linkedList) {
        boolean z = false;
        if (linkedList == null || linkedList.size() <= 0) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList failed. list is null");
            return false;
        }
        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList list size :%d.", new Object[]{Integer.valueOf(linkedList.size())});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE");
        stringBuilder.append(" EmojiInfo ");
        stringBuilder.append(" SET ");
        stringBuilder.append("needupload");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.tcV);
        stringBuilder.append(" where ");
        stringBuilder.append("md5");
        stringBuilder.append(" IN (");
        while (true) {
            boolean z2 = z;
            if (z2 < linkedList.size()) {
                stringBuilder.append("'" + ((String) linkedList.get(z2)) + "'");
                if (z2 < linkedList.size() - 1) {
                    stringBuilder.append(",");
                }
                z = z2 + 1;
            } else {
                stringBuilder.append(")");
                x.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
                return this.diF.fV("EmojiInfo", stringBuilder.toString());
            }
        }
    }

    public final ArrayList<String> cnL() {
        ArrayList<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.diF.b("select md5 from EmojiInfo where needupload=? and catalog=?", new String[]{String.valueOf(EmojiInfo.tcV), String.valueOf(EmojiGroupInfo.tcA)}, 2);
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
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get need upload emoji MD5 list failed :%s", new Object[]{bi.i(e)});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final int cnM() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = this.diF.b("select reserved3 from EmojiInfo where catalog=? order by reserved3 desc limit 1", new String[]{String.valueOf(EmojiGroupInfo.tcA)}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "getCustomEmojiMaxIndex :%s", new Object[]{bi.i(e)});
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

    public final ArrayList<EmojiInfo> cnN() {
        Throwable e;
        Cursor b;
        try {
            b = this.diF.b("SELECT * FROM EmojiInfo WHERE catalog =?  OR catalog=? OR groupId IS NOT NULL", new String[]{String.valueOf(EmojiGroupInfo.tcA), String.valueOf(EmojiGroupInfo.tcB)}, 2);
            if (b != null) {
                try {
                    if (b.moveToFirst()) {
                        ArrayList<EmojiInfo> arrayList = new ArrayList();
                        do {
                            EmojiInfo emojiInfo = new EmojiInfo();
                            emojiInfo.d(b);
                            if ((emojiInfo.field_reserved4 & EmojiInfo.tcW) != EmojiInfo.tcW) {
                                arrayList.add(emojiInfo);
                            }
                        } while (b.moveToNext());
                        if (b == null) {
                            return arrayList;
                        }
                        b.close();
                        return arrayList;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "getAllStoreAndCustomEmoji :%s", new Object[]{bi.i(e)});
                        if (b != null) {
                            b.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (b != null) {
                            b.close();
                        }
                        throw e;
                    }
                }
            }
            if (b != null) {
                b.close();
            }
        } catch (Exception e3) {
            e = e3;
            b = null;
        } catch (Throwable th2) {
            e = th2;
            b = null;
            if (b != null) {
                b.close();
            }
            throw e;
        }
        return null;
    }

    public final String getKey() {
        String string;
        Throwable e;
        EmojiInfo emojiInfo;
        Cursor b;
        try {
            b = this.diF.b("SELECT md5 FROM EmojiInfo WHERE catalog =?", new String[]{"153"}, 2);
            if (b != null) {
                try {
                    if (b.moveToFirst()) {
                        string = b.getString(0);
                        x.i("MicroMsg.emoji.EmojiInfoStorage", "had key :%s" + bi.Xf(string));
                        if (b == null) {
                            return string;
                        }
                        b.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "createKey :%s", new Object[]{bi.i(e)});
                        if (b != null) {
                            b.close();
                        }
                        string = bi.fP(ad.getContext());
                        if (bi.oW(string)) {
                            string = com.tencent.mm.a.g.u("com.tencent.mm.key.MicroMsg.Wechat".getBytes());
                        } else {
                            string = com.tencent.mm.a.g.u(string.getBytes());
                        }
                        x.i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + bi.Xf(string));
                        emojiInfo = new EmojiInfo();
                        emojiInfo.field_md5 = string;
                        emojiInfo.field_catalog = 153;
                        if (b(emojiInfo)) {
                            return string;
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (b != null) {
                            b.close();
                        }
                        throw e;
                    }
                }
            }
            if (b != null) {
                b.close();
            }
        } catch (Exception e3) {
            e = e3;
            b = null;
        } catch (Throwable th2) {
            e = th2;
            b = null;
            if (b != null) {
                b.close();
            }
            throw e;
        }
        string = bi.fP(ad.getContext());
        if (bi.oW(string)) {
            string = com.tencent.mm.a.g.u(string.getBytes());
        } else {
            string = com.tencent.mm.a.g.u("com.tencent.mm.key.MicroMsg.Wechat".getBytes());
        }
        x.i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + bi.Xf(string));
        emojiInfo = new EmojiInfo();
        emojiInfo.field_md5 = string;
        emojiInfo.field_catalog = 153;
        if (b(emojiInfo)) {
            return null;
        }
        return string;
    }

    public final boolean dv(List<ta> list) {
        if (list == null || list.isEmpty()) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL failed. empty list");
            return false;
        }
        long dO;
        x.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL size:%d", new Object[]{Integer.valueOf(list.size())});
        h hVar = null;
        if (this.diF instanceof h) {
            h hVar2 = (h) this.diF;
            dO = hVar2.dO(Thread.currentThread().getId());
            x.i("MicroMsg.emoji.EmojiInfoStorage", "surround updateEmojiURL in a transaction, ticket = %d", new Object[]{Long.valueOf(dO)});
            hVar = hVar2;
        } else {
            dO = -1;
        }
        for (int i = 0; i < list.size(); i++) {
            ta taVar = (ta) list.get(i);
            EmojiInfo Zy = Zy(taVar.rwk);
            if (Zy == null) {
                Zy = new EmojiInfo();
                Zy.field_md5 = taVar.rwk;
                Zy.field_catalog = EmojiInfo.tcB;
                x.i("MicroMsg.emoji.EmojiInfoStorage", "new emoji as received when updateEmoji url");
            }
            Zy.field_cdnUrl = taVar.jPK;
            Zy.field_encrypturl = taVar.rwm;
            Zy.field_aeskey = taVar.rwn;
            Zy.field_designerID = taVar.rwl;
            Zy.field_thumbUrl = taVar.lPl;
            Zy.field_groupId = taVar.rem;
            p(Zy);
        }
        if (hVar != null) {
            hVar.gp(dO);
            x.i("MicroMsg.emoji.EmojiInfoStorage", "end updateList transaction");
        }
        return true;
    }
}
