package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.mm.pluginsdk.model.h.a;
import java.util.ArrayList;

class h$1 extends AsyncTask<Void, Void, Cursor> {
    final /* synthetic */ String[] qyN;
    final /* synthetic */ a qyO;
    final /* synthetic */ Context val$context;

    h$1(Context context, String[] strArr, a aVar) {
        this.val$context = context;
        this.qyN = strArr;
        this.qyO = aVar;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.val$context.getContentResolver().query(Uri.parse("content://com.tencent.mm.plugin.gwallet.queryprovider"), null, null, this.qyN, null);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Cursor cursor = (Cursor) obj;
        if (cursor == null || cursor.getCount() <= 0) {
            ArrayList arrayList = new ArrayList();
            for (String nVar : this.qyN) {
                arrayList.add(new n(-1, nVar, "", "", "", 10237));
            }
            this.qyO.u(arrayList);
        } else {
            cursor.moveToFirst();
            ArrayList m = h.m(cursor);
            cursor.close();
            this.qyO.u(m);
        }
        super.onPostExecute(cursor);
    }
}
