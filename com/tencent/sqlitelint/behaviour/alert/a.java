package com.tencent.sqlitelint.behaviour.alert;

import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;

public final class a extends com.tencent.sqlitelint.behaviour.a {
    private static Handler vnJ = new Handler(Looper.getMainLooper());
    private final Context mContext;
    private long vnI;
    private final String vnk;

    public a(Context context, String str) {
        this.mContext = context;
        this.vnk = str;
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.android.launcher2.settings/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{"SQLiteLint"}, null);
        if (query != null) {
            int count = query.getCount();
            query.close();
            if (count > 0) {
                return;
            }
        }
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", "SQLiteLint");
        intent.putExtra("duplicate", false);
        Parcelable intent2 = new Intent("android.intent.action.MAIN");
        intent2.setClassName(context, CheckedDatabaseListActivity.class.getName());
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, com.tencent.sqlitelint.d.a.sqlite_lint_icon));
        context.sendBroadcast(intent);
    }

    public final void eh(List<SQLiteLintIssue> list) {
        if (list != null && !list.isEmpty()) {
            long cGi = com.tencent.sqlitelint.behaviour.a.a.cGi();
            if (cGi == this.vnI) {
                SLog.v("Matrix.IssueAlertBehaviour", "no new issue", new Object[0]);
                return;
            }
            this.vnI = cGi;
            vnJ.post(new Runnable() {
                public final void run() {
                    Intent intent = new Intent();
                    intent.setClass(a.this.mContext, CheckResultActivity.class);
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.putExtra("db_label", a.this.vnk);
                    a.this.mContext.startActivity(intent);
                }
            });
        }
    }
}
