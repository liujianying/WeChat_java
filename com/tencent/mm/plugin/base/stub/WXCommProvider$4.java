package com.tencent.mm.plugin.base.stub;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.x;

class WXCommProvider$4 extends bd<Cursor> {
    final /* synthetic */ WXCommProvider hdU;
    final /* synthetic */ Uri hdW;
    final /* synthetic */ int hdX;
    final /* synthetic */ String[] hdY;
    final /* synthetic */ MatrixCursor hdZ;

    WXCommProvider$4(WXCommProvider wXCommProvider, Uri uri, int i, String[] strArr, MatrixCursor matrixCursor) {
        this.hdU = wXCommProvider;
        this.hdW = uri;
        this.hdX = i;
        this.hdY = strArr;
        this.hdZ = matrixCursor;
        super(2000, null, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        x.d("MicroMsg.WXCommProvider", "query, uri = %s, code = %d", new Object[]{this.hdW.toString(), Integer.valueOf(this.hdX)});
        if (this.hdX != 1) {
            x.e("MicroMsg.WXCommProvider", "query fail, invalid code = %d", new Object[]{Integer.valueOf(this.hdX)});
            return null;
        }
        for (String string : this.hdY) {
            String string2 = WXCommProvider.a(this.hdU).getString(string, "");
            this.hdZ.addRow(new String[]{string, string2});
        }
        x.d("MicroMsg.WXCommProvider", "query size = %d", new Object[]{Integer.valueOf(this.hdZ.getCount())});
        return this.hdZ;
    }
}
