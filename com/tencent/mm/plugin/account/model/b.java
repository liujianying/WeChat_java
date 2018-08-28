package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.widget.Toast;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.su;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {

    public static final class b implements a {
        private String eNQ;
        private int toScene;
        private Uri uri;

        public b(int i, String str, Uri uri) {
            this.toScene = i;
            this.eNQ = str;
            this.uri = uri;
        }

        public final int cm(Context context) {
            if (context == null) {
                x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null context");
                return 1;
            }
            g.Eg();
            if (!a.Dw() || a.Dr()) {
                x.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not login, start bind login");
                return 3;
            } else if (bi.oW((String) g.Ei().DT().get(6, ""))) {
                x.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not bind mobile, start bind mobie");
                return 2;
            } else if (!com.tencent.mm.pluginsdk.permission.a.bj(context, "android.permission.READ_CONTACTS")) {
                x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contacts permission");
                return 1;
            } else if (this.uri != null) {
                Cursor query = context.getContentResolver().query(this.uri, new String[]{"contact_id", "_id", "data4"}, null, null, null);
                if (query == null) {
                    x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err");
                    return 1;
                } else if (query.moveToFirst()) {
                    int columnIndex = query.getColumnIndex("data4");
                    if (columnIndex == -1) {
                        x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no data4 segment exist");
                        query.close();
                        return 1;
                    }
                    String str = "";
                    String str2 = "";
                    String str3 = "";
                    try {
                        str = query.getString(columnIndex);
                        columnIndex = query.getColumnIndex("contact_id");
                        str2 = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        columnIndex = query.getColumnIndex("_id");
                        String string = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        query.close();
                        if (!bi.oW(str)) {
                            return e(context, str, string, str2);
                        }
                        x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null friendmobile");
                        return 1;
                    } catch (Throwable e) {
                        x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "match error, %s\n%s", new Object[]{e.getMessage(), bi.i(e)});
                        x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "result friendMobileMd5 %s contact_id %s data_id %s", new Object[]{str, str2, str3});
                        query.close();
                        return 1;
                    } catch (Throwable e2) {
                        query.close();
                        throw e2;
                    }
                } else {
                    x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err, move to first fail");
                    query.close();
                    return 1;
                }
            } else if (!bi.oW(this.eNQ)) {
                return e(context, com.tencent.mm.a.g.u(com.tencent.mm.pluginsdk.a.pK(this.eNQ).getBytes()), null, null);
            } else {
                x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "uri is null and the phone num is null");
                return 1;
            }
        }

        private int e(Context context, String str, String str2, String str3) {
            com.tencent.mm.plugin.account.friend.a.a pq = com.tencent.mm.plugin.account.b.getAddrUploadStg().pq(str);
            if (context == null) {
                x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null context");
                return 1;
            } else if (pq == null) {
                x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "this user is not my friend");
                return 1;
            } else {
                String username = pq.getUsername();
                if (bi.oW(username)) {
                    x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "get username failed, phonenum md5 is " + str);
                    return 1;
                }
                if (((i) g.l(i.class)).FR().Yc(username)) {
                    h.mEJ.h(11157, new Object[]{Integer.valueOf(this.toScene)});
                    Intent intent;
                    su suVar;
                    switch (this.toScene) {
                        case 1:
                            intent = new Intent();
                            intent.putExtra("Chat_User", username);
                            intent.putExtra("finish_direct", true);
                            intent.addFlags(67108864);
                            com.tencent.mm.plugin.account.a.a.ezn.e(intent, context);
                            return 0;
                        case 2:
                            intent = new Intent();
                            intent.putExtra("sns_userName", username);
                            intent.addFlags(67108864);
                            d.b(context, "sns", ".ui.SnsUserUI", intent);
                            return 0;
                        case 3:
                            suVar = new su();
                            suVar.cdE.bOh = 5;
                            suVar.cdE.talker = username;
                            suVar.cdE.context = context;
                            suVar.cdE.cdz = 3;
                            com.tencent.mm.sdk.b.a.sFg.m(suVar);
                            return 0;
                        case 4:
                            suVar = new su();
                            suVar.cdE.bOh = 5;
                            suVar.cdE.talker = username;
                            suVar.cdE.context = context;
                            suVar.cdE.cdz = 2;
                            com.tencent.mm.sdk.b.a.sFg.m(suVar);
                            return 0;
                    }
                } else if (!(bi.oW(str3) || bi.oW(str2))) {
                    if (com.tencent.mm.pluginsdk.permission.a.bj(context, "android.permission.READ_CONTACTS")) {
                        Toast.makeText(context, context.getString(j.contact_sync_chat_not_friend), 1).show();
                        context.getContentResolver().delete(Data.CONTENT_URI, "_id = ?", new String[]{str2});
                        context.getContentResolver().delete(RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[]{str3, "com.tencent.mm.account"});
                    } else {
                        x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contact permission");
                        return 1;
                    }
                }
                return 1;
            }
        }
    }
}
