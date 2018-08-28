package com.tencent.mm.plugin.ai;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends ContentObserver {
    private boolean dJO = false;
    public String[] eNC;
    private ContentResolver eNn;
    private boolean eNo = false;
    private boolean eNp = false;
    private Context mContext;
    public a ngW;
    private long ngX = 0;

    public a(Context context) {
        super(ag.fetchFreeHandler());
        this.mContext = context;
    }

    public final void start() {
        this.eNo = false;
        this.eNp = false;
        this.dJO = false;
        boolean a = com.tencent.mm.pluginsdk.permission.a.a((Activity) this.mContext, "android.permission.READ_SMS", 128, "", "");
        x.i("MicroMsg.SmsVerifyObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bi.cjd(), this.mContext});
        try {
            long j;
            Uri parse = Uri.parse("content://sms/inbox");
            this.eNn = this.mContext.getContentResolver();
            String str = "( ";
            if (this.eNC != null) {
                int i = 0;
                while (i < this.eNC.length) {
                    String str2 = i == this.eNC.length + -1 ? str + " body like \"%" + this.eNC[i] + "%\" ) " : str + "body like \"%" + this.eNC[i] + "%\" or ";
                    i++;
                    str = str2;
                }
                x.v("MicroMsg.SmsVerifyObserver", "sql where:" + str);
            } else {
                str = "";
            }
            Cursor query = this.eNn.query(parse, new String[]{"date"}, str, null, "date desc limit 1");
            if (query == null || query.getCount() <= 0) {
                j = 0;
            } else {
                query.moveToFirst();
                j = query.getLong(0);
            }
            if (query != null) {
                query.close();
            }
            this.ngX = j;
            this.mContext.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
        }
    }

    public final void stop() {
        if (this.mContext != null) {
            try {
                this.mContext.getContentResolver().unregisterContentObserver(this);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
            }
        }
        this.dJO = true;
    }

    public final void onChange(boolean z) {
        String str = null;
        super.onChange(z);
        try {
            if (!this.eNo && !this.dJO && !this.eNp) {
                Uri parse = Uri.parse("content://sms/inbox");
                this.eNn = this.mContext.getContentResolver();
                String[] strArr = new String[]{"body", "_id", "date"};
                String str2 = "( ";
                if (this.eNC != null) {
                    int i = 0;
                    while (i < this.eNC.length) {
                        str2 = i == this.eNC.length + -1 ? str2 + " body like \"%" + this.eNC[i] + "%\" ) " : str2 + "body like \"%" + this.eNC[i] + "%\" or ";
                        i++;
                    }
                    str = str2 + " and date > " + this.ngX + " ";
                    x.v("MicroMsg.SmsVerifyObserver", "sql where:" + str);
                }
                if (str != null && !str.equals("")) {
                    Cursor query = this.eNn.query(parse, strArr, str, null, "date desc");
                    if (query != null) {
                        int i2 = -1;
                        long j = 0;
                        while (query.moveToNext()) {
                            long j2 = query.getLong(2);
                            if (j2 > j) {
                                i2 = query.getPosition();
                            } else {
                                j2 = j;
                            }
                            j = j2;
                        }
                        if (i2 >= 0) {
                            query.moveToPosition(i2);
                            str2 = aD(0, query.getString(query.getColumnIndex("body")));
                            if (!bi.oW(str2) && str2.length() == 6) {
                                if (this.ngW != null) {
                                    this.ngW.to(str2);
                                }
                                this.eNp = true;
                            }
                        }
                        query.close();
                    }
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
        }
    }

    private static String aD(int i, String str) {
        while (i < str.length()) {
            while (i < str.length() && !Character.isDigit(str.charAt(i))) {
                i++;
            }
            int i2 = i + 1;
            while (i2 < str.length() && Character.isDigit(str.charAt(i2))) {
                i2++;
            }
            String substring = str.substring(i, i2);
            x.v("MicroMsg.SmsVerifyObserver", "verify number from sms:" + substring);
            if (substring.length() == 6) {
                return substring;
            }
            i = i2 + 1;
        }
        return null;
    }
}
