package com.tencent.mm.pluginsdk.model.app;

import android.net.Uri;

public final class aq {
    public static aq qBc = null;
    public static long qBd = -1;
    public int code = -1;
    public String[] projection = null;
    public String qBa = "";
    public String[] qBb = null;
    public String selection = "";
    public String[] selectionArgs = null;
    public Uri uri = null;

    public aq(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i, String[] strArr3) {
        this.uri = uri;
        this.projection = strArr;
        this.selection = str;
        this.selectionArgs = strArr2;
        this.qBa = str2;
        this.code = i;
        this.qBb = strArr3;
    }
}
