package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.plugin.account.a$b;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class s extends ContentObserver {
    private final Context context;
    private final String[] eNC;
    private ContentResolver eNn;
    private final a eXr;
    private Pattern eXs = Pattern.compile("\\d{4,8}");

    public s(Context context, a aVar) {
        super(ag.fetchFreeHandler());
        if (context == null || aVar == null) {
            throw new NullPointerException("SmsContentObserver Construction");
        }
        this.context = context;
        this.eNC = context.getResources().getStringArray(a$b.sms_content);
        this.eXr = aVar;
    }

    public final void Zr() {
        this.context.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
    }

    public final void Zs() {
        this.context.getContentResolver().unregisterContentObserver(this);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        if (this.context instanceof Activity) {
            x.i("MicroMsg.SmsContentObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a((Activity) this.context, "android.permission.READ_SMS", 128, "", "")), bi.cjd(), this.context});
            if (!a.a((Activity) this.context, "android.permission.READ_SMS", 128, "", "")) {
                return;
            }
        }
        Yh();
    }

    public final void Yh() {
        Exception e;
        Cursor cursor;
        Throwable th;
        String str = null;
        Uri parse = Uri.parse("content://sms/inbox");
        this.eNn = this.context.getContentResolver();
        String[] strArr = new String[]{"body", "_id", "date"};
        String str2 = "( ";
        int i = 0;
        while (i < this.eNC.length) {
            String str3 = i == this.eNC.length + -1 ? str2 + " body like \"%" + this.eNC[i] + "%\" ) " : str2 + "body like \"%" + this.eNC[i] + "%\" or ";
            i++;
            str2 = str3;
        }
        String str4 = str2 + " and date > " + (System.currentTimeMillis() - 300000) + " ";
        x.v("MicroMsg.SmsContentObserver", "sql where:" + str4);
        if (str4 != null && !str4.equals("")) {
            Cursor query;
            try {
                query = this.eNn.query(parse, strArr, str4, null, null);
                int i2 = -1;
                long j = 0;
                while (query.moveToNext()) {
                    try {
                        long j2 = query.getLong(2);
                        if (j2 > j) {
                            i2 = query.getPosition();
                        } else {
                            j2 = j;
                        }
                        j = j2;
                    } catch (Exception e2) {
                        e = e2;
                        cursor = query;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!(query == null || query.isClosed())) {
                            query.close();
                        }
                        throw th;
                    }
                }
                if (i2 >= 0) {
                    query.moveToPosition(i2);
                    Matcher matcher = this.eXs.matcher(query.getString(query.getColumnIndex("body")));
                    if (matcher.find()) {
                        str = matcher.group();
                    }
                    this.eXr.pP(str);
                } else {
                    this.eXr.YZ();
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
                try {
                    x.e("MicroMsg.SmsContentObserver", e.toString());
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    query = cursor;
                    query.close();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                query = null;
                query.close();
                throw th;
            }
        }
    }
}
