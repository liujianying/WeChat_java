package com.tencent.mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.extqlauncher.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class ExtControlProviderQLauncher extends ExtContentProviderBase {
    private static final UriMatcher iJT;
    private static final String[] iJr = new String[]{"retCode"};
    private static final String[] iLN = new String[]{"id", "count"};
    private Context context;
    private String[] iJE;
    private int iLO = -1;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        iJT = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
        iJT.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
        iJT.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
    }

    public ExtControlProviderQLauncher(String[] strArr, int i, Context context) {
        this.iJE = strArr;
        this.iLO = i;
        this.context = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.d("MicroMsg.ExtControlProviderQLauncher", "query()");
        a(uri, this.context, this.iLO, this.iJE);
        if (uri == null) {
            pr(3);
            return null;
        } else if (bi.oW(this.iJN) || bi.oW(aIW())) {
            pr(3);
            return null;
        } else if (!atA()) {
            pr(1);
            return this.hdQ;
        } else if (df(this.context)) {
            Cursor matrixCursor;
            switch (this.iLO) {
                case 18:
                    x.d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
                    if (this.context == null) {
                        pr(4);
                        return null;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                    matrixCursor = new MatrixCursor(iJr);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(1)});
                    pr(0);
                    return matrixCursor;
                case 19:
                    x.d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
                    if (this.context == null) {
                        pr(4);
                        return null;
                    }
                    d.b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", new Intent());
                    matrixCursor = new MatrixCursor(iJr);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(1)});
                    pr(0);
                    return matrixCursor;
                case 20:
                    return t(strArr2);
                default:
                    pr(3);
                    return null;
            }
        } else {
            x.w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
            pr(2);
            return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor t(String[] strArr) {
        x.d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
        if (this.context == null) {
            pr(4);
            return null;
        } else if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
            pr(3);
            return null;
        } else {
            MatrixCursor matrixCursor = new MatrixCursor(iLN);
            int i = 0;
            while (i < strArr.length && i < 10) {
                try {
                    if (!bi.oW(strArr[i])) {
                        if (strArr[i].equals("0")) {
                            Object[] objArr = new Object[2];
                            objArr[0] = strArr[i];
                            b.aJl();
                            objArr[1] = Integer.valueOf(b.aJm());
                            matrixCursor.addRow(objArr);
                        } else {
                            String wL = com.tencent.mm.plugin.base.model.b.wL(strArr[i]);
                            if (bi.oW(wL)) {
                                continue;
                            } else {
                                au.HU();
                                if (c.FW().Yq(wL) != null) {
                                    matrixCursor.addRow(new Object[]{strArr[i], Integer.valueOf(c.FW().Yq(wL).field_unReadCount)});
                                } else {
                                    matrixCursor.addRow(new Object[]{strArr[i], Integer.valueOf(0)});
                                }
                            }
                        }
                    }
                    i++;
                } catch (Exception e) {
                    x.e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", new Object[]{e.getMessage()});
                    pr(4);
                    matrixCursor.close();
                    return null;
                }
            }
            pr(0);
            return matrixCursor;
        }
    }
}
