package com.tencent.mm.plugin.account.model;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.DataUsageFeedback;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.mm.a.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class VoiceActionService extends SearchActionVerificationClientService {
    public final boolean a(Intent intent, boolean z) {
        if (z) {
            String stringExtra = intent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_CHAT_ID");
            String stringExtra2 = intent.getStringExtra("android.intent.extra.TEXT");
            String username = b.getAddrUploadStg().pq(g.u(a.pK(stringExtra).getBytes())).getUsername();
            com.tencent.mm.plugin.messenger.a.g.bcT().D(username, stringExtra2, s.hQ(username));
            try {
                String[] split = intent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_URI").split("/");
                String str = (split == null || split.length <= 0) ? "" : split[split.length - 1];
                if (bi.oW(str)) {
                    x.e("MicroMsg.VoiceActionService", "extract contact Id error, %s %s", new Object[]{username, stringExtra});
                } else if (com.tencent.mm.pluginsdk.permission.a.bj(this, "android.permission.READ_CONTACTS")) {
                    Cursor query = getContentResolver().query(Data.CONTENT_URI, new String[]{"_id"}, "contact_id=? AND data1=? AND account_type=? AND mimetype=?", new String[]{str, stringExtra, "com.tencent.mm.account", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction"}, null);
                    if (query == null || query.getCount() <= 0) {
                        x.i("MicroMsg.VoiceActionService", "updateContactMarked: false");
                    } else {
                        query.moveToNext();
                        boolean z2 = getContentResolver().update(DataUsageFeedback.FEEDBACK_URI.buildUpon().appendPath(String.valueOf(query.getLong(0))).appendQueryParameter("type", "short_text").build(), new ContentValues(), null, null) > 0;
                        x.i("MicroMsg.VoiceActionService", "updateContactMarked: %b", new Object[]{Boolean.valueOf(z2)});
                    }
                    if (query != null) {
                        query.close();
                    }
                } else {
                    x.e("MicroMsg.VoiceActionService", "no contacts permission");
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoiceActionService", e, "updateContactMarked error", new Object[0]);
            }
            return true;
        }
        x.i("MicroMsg.VoiceActionService", "Action is not verified");
        return false;
    }
}
