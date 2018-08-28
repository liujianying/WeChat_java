package com.tencent.mm.pluginsdk.ui.tools;

import android.os.AsyncTask;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.c;

class AppChooserUI$d extends AsyncTask<c, Void, c> {
    final /* synthetic */ AppChooserUI qRB;

    AppChooserUI$d(AppChooserUI appChooserUI) {
        this.qRB = appChooserUI;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        c cVar = ((c[]) objArr)[0];
        if (cVar.qRH == null) {
            cVar.qRH = AppChooserUI.a(this.qRB, cVar.qRF);
        }
        return cVar;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        AppChooserUI.a(this.qRB).notifyDataSetChanged();
    }
}
