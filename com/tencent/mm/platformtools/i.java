package com.tencent.mm.platformtools;

import android.accounts.Account;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i implements Runnable {
    private String bSm;
    private Account evK;
    private a evL;
    private Looper evM;
    private Context mContext;
    private String username;

    public i(Context context, Account account) {
        this(context, account, null, null);
    }

    public i(Context context, Account account, String str) {
        this(context, account, str, null);
    }

    public i(Context context, Account account, String str, String str2) {
        this.mContext = context;
        this.evK = account;
        this.username = str;
        this.bSm = str2;
        x.i("MicroMsg.ContactsOperations", "username = " + str + ", " + str2);
    }

    public final void run() {
        Looper.prepare();
        this.evM = Looper.myLooper();
        x.i("MicroMsg.ContactsOperations", "start time:" + System.currentTimeMillis());
        a pp;
        if (bi.oW(this.username) && bi.oW(this.bSm)) {
            Vr();
        } else if (bi.oW(this.bSm)) {
            pp = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pp(this.username);
            if (!(pp == null || bi.oW(pp.eJG))) {
                oK(pp.eJG);
            }
            quit();
        } else {
            pp = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pp(this.username);
            a pp2 = (pp == null || bi.oW(pp.eJG)) ? ((b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pp(this.bSm) : pp;
            if (pp2 == null || bi.oW(pp2.eJG)) {
                x.d("MicroMsg.ContactsOperations", "query addrupload is null " + this.username);
            } else {
                try {
                    if (com.tencent.mm.pluginsdk.permission.a.bj(this.mContext, "android.permission.READ_CONTACTS")) {
                        Cursor query = this.mContext.getContentResolver().query(RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.evK.name).appendQueryParameter("account_type", this.evK.type).build(), new String[]{"sync1", "_id"}, "deleted=\"0\" AND sync1=\"" + pp2.eJG + "\"", null, null);
                        if (query == null || query.getCount() == 0) {
                            String Xm = bi.oW(pp2.Xj()) ? pp2.Xm() : pp2.Xj();
                            this.evL = new a(this, this.mContext.getContentResolver());
                            e(Xm, pp2.Xp(), pp2.eJG, this.username);
                            this.evL.execute();
                        }
                        if (query != null) {
                            query.close();
                        }
                    } else {
                        x.e("MicroMsg.ContactsOperations", "no contact permission");
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ContactsOperations", e, "", "");
                }
            }
            quit();
        }
        x.i("MicroMsg.ContactsOperations", "end time:" + System.currentTimeMillis());
        Looper.loop();
    }

    private void quit() {
        if (this.evM != null) {
            this.evM.quit();
        }
    }

    private synchronized void Vr() {
        Throwable e;
        Object obj;
        if (g.Eg().Dx()) {
            List<a> pr = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pr("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.status!=\"0\" AND addr_upload2.username!=\"" + bi.oU("") + "\" )");
            if (pr.size() == 0) {
                x.e("MicroMsg.ContactsOperations", "there is no wechat friend in this phone");
                quit();
            } else {
                Map hashMap = new HashMap();
                Uri build = RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.evK.name).appendQueryParameter("account_type", this.evK.type).build();
                if (com.tencent.mm.pluginsdk.permission.a.bj(this.mContext, "android.permission.READ_CONTACTS")) {
                    Cursor query;
                    try {
                        query = this.mContext.getContentResolver().query(build, new String[]{"sync1", "_id"}, "deleted=\"0\"", null, null);
                        if (query == null) {
                            try {
                                x.e("MicroMsg.ContactsOperations", "query get no user");
                            } catch (Exception e2) {
                                e = e2;
                                x.printErrStackTrace("MicroMsg.ContactsOperations", e, "", "");
                                if (query != null) {
                                    query.close();
                                }
                                if (!oL("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                                }
                                obj = null;
                                this.evL = new a(this, this.mContext.getContentResolver());
                                for (a aVar : pr) {
                                    String username = aVar.getUsername();
                                    ai Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(username);
                                    if (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type)) {
                                        oK(aVar.eJG);
                                    } else {
                                        String Xm = bi.oW(aVar.Xj()) ? aVar.Xm() : aVar.Xj();
                                        String Xp = aVar.Xp();
                                        String str = aVar.eJG;
                                        String str2 = Yg.signature;
                                        if (hashMap.get(str) == null || obj != null) {
                                            if (hashMap.get(str) != null) {
                                                oK(str);
                                            }
                                            e(Xm, Xp, str, username);
                                        }
                                        this.evL.execute();
                                    }
                                }
                                this.evL.execute();
                                quit();
                            }
                            if (query != null) {
                                query.close();
                            }
                            if (oL("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video") || oL("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip")) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            this.evL = new a(this, this.mContext.getContentResolver());
                            for (a aVar2 : pr) {
                                String username2 = aVar2.getUsername();
                                ai Yg2 = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(username2);
                                if (Yg2 == null || !com.tencent.mm.l.a.gd(Yg2.field_type)) {
                                    oK(aVar2.eJG);
                                } else {
                                    String Xm2 = bi.oW(aVar2.Xj()) ? aVar2.Xm() : aVar2.Xj();
                                    String Xp2 = aVar2.Xp();
                                    String str3 = aVar2.eJG;
                                    String str22 = Yg2.signature;
                                    if (hashMap.get(str3) == null || obj != null) {
                                        if (hashMap.get(str3) != null) {
                                            oK(str3);
                                        }
                                        e(Xm2, Xp2, str3, username2);
                                    }
                                    this.evL.execute();
                                }
                            }
                            this.evL.execute();
                            quit();
                        } else {
                            if (query.moveToFirst()) {
                                do {
                                    hashMap.put(query.getString(0), Long.valueOf(query.getLong(1)));
                                } while (query.moveToNext());
                            }
                            if (query != null) {
                                query.close();
                            }
                            if (oL("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                            }
                            obj = null;
                            this.evL = new a(this, this.mContext.getContentResolver());
                            for (a aVar22 : pr) {
                                String username22 = aVar22.getUsername();
                                ai Yg22 = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(username22);
                                if (Yg22 == null || !com.tencent.mm.l.a.gd(Yg22.field_type)) {
                                    oK(aVar22.eJG);
                                } else {
                                    String Xm22 = bi.oW(aVar22.Xj()) ? aVar22.Xm() : aVar22.Xj();
                                    String Xp22 = aVar22.Xp();
                                    String str32 = aVar22.eJG;
                                    String str222 = Yg22.signature;
                                    if (hashMap.get(str32) == null || obj != null) {
                                        if (hashMap.get(str32) != null) {
                                            oK(str32);
                                        }
                                        e(Xm22, Xp22, str32, username22);
                                    }
                                    this.evL.execute();
                                }
                            }
                            this.evL.execute();
                            quit();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        query = null;
                    }
                } else {
                    x.e("MicroMsg.ContactsOperations", "no contact permission");
                }
            }
        } else {
            x.d("MicroMsg.ContactsOperations", "account not ready, quit this operation");
            quit();
        }
    }

    private void e(String str, String str2, String str3, String str4) {
        x.d("MicroMsg.ContactsOperations", "add wechat contact: displayname:" + str + ", phoneNum:" + str2 + ", " + str3 + ", username:" + str4);
        Builder newInsert = ContentProviderOperation.newInsert(RawContacts.CONTENT_URI);
        newInsert.withValue("account_name", this.evK.name);
        newInsert.withValue("account_type", this.evK.type);
        newInsert.withValue("sync1", str3);
        this.evL.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/name");
        newInsert.withValue("data1", str);
        this.evL.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(j.app_name));
        newInsert.withValue("data3", this.mContext.getString(j.contact_sync_action_chat));
        newInsert.withValue("data4", str3);
        this.evL.a(newInsert.build());
        if ("1".equals(com.tencent.mm.k.g.AT().getValue("VOIPCallType"))) {
            newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", 0);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video");
            newInsert.withValue("data1", str2);
            newInsert.withValue("data2", this.mContext.getString(j.app_name));
            newInsert.withValue("data3", this.mContext.getString(j.contact_sync_action_chat_voip_video));
            newInsert.withValue("data4", str3);
            this.evL.a(newInsert.build());
        } else {
            newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", 0);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip");
            newInsert.withValue("data1", str2);
            newInsert.withValue("data2", this.mContext.getString(j.app_name));
            newInsert.withValue("data3", this.mContext.getString(j.contact_sync_action_chat_voip));
            newInsert.withValue("data4", str3);
            this.evL.a(newInsert.build());
        }
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(j.app_name));
        newInsert.withValue("data3", this.mContext.getString(j.contact_sync_action_view_timeline));
        newInsert.withValue("data4", str3);
        this.evL.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(j.app_name));
        newInsert.withValue("data3", "");
        newInsert.withValue("data4", str3);
        this.evL.a(newInsert.build());
    }

    private void oK(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.ContactsOperations", "delete wechat contact fail, phoneNum5 is null");
        } else if (com.tencent.mm.pluginsdk.permission.a.bj(this.mContext, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = this.mContext.getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id", "_id"}, "(mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ?) AND data4 = ?", new String[]{"vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction", str}, null);
            } catch (Throwable e) {
                x.e("MicroMsg.ContactsOperations", "query fail, match error %s \n %s", e.getMessage(), bi.i(e));
                query = null;
            }
            if (query == null) {
                x.e("MicroMsg.ContactsOperations", "get null cursor");
                return;
            }
            try {
                if (query.moveToFirst()) {
                    do {
                        int columnIndex = query.getColumnIndex("contact_id");
                        String string = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        columnIndex = query.getColumnIndex("_id");
                        String string2 = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        if (!(bi.oW(string) || bi.oW(string2))) {
                            this.mContext.getContentResolver().delete(Data.CONTENT_URI, "_id = ?", new String[]{string2});
                            this.mContext.getContentResolver().delete(RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[]{string, "com.tencent.mm.account"});
                        }
                    } while (query.moveToNext());
                }
            } catch (Exception e2) {
                x.e("MicroMsg.ContactsOperations", "delete wechat contact failed : " + e2.getMessage());
            }
            query.close();
        } else {
            x.e("MicroMsg.ContactsOperations", "no contact permission");
        }
    }

    private boolean oL(String str) {
        Exception e;
        boolean z = false;
        if (com.tencent.mm.pluginsdk.permission.a.bj(this.mContext, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                boolean z2;
                query = this.mContext.getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id"}, "mimetype= ?", new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            x.d("MicroMsg.ContactsOperations", "has minetype:" + str);
                            z2 = true;
                            z = z2;
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        x.e("MicroMsg.ContactsOperations", "hasMIMEType search failed : " + e.getMessage());
                        z = true;
                        if (query != null) {
                            query.close();
                        }
                        return z;
                    }
                }
                z2 = false;
                z = z2;
            } catch (Exception e3) {
                e = e3;
                query = null;
            }
            if (query != null) {
                query.close();
            }
        } else {
            x.e("MicroMsg.ContactsOperations", "no contact permission");
        }
        return z;
    }
}
