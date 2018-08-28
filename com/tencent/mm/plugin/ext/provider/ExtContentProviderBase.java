package com.tencent.mm.plugin.ext.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ac.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtContentProviderBase extends ContentProvider {
    protected static boolean hdT = false;
    private static HashMap<String, Long> iJQ = new HashMap();
    public MatrixCursor hdQ = new MatrixCursor(new String[0]);
    private long iJL = bi.VG();
    private String iJM;
    public String iJN = "";
    private String[] iJO;
    private int iJP = 0;

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
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

    public final void pr(int i) {
        x.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[]{aIW(), this.iJN, Integer.valueOf(this.iJP), Integer.valueOf(i), Integer.valueOf(aIV())});
        h.mEJ.h(10505, new Object[]{aIW(), this.iJN, Integer.valueOf(this.iJP), Integer.valueOf(i), Integer.valueOf(aIV())});
    }

    public final void cw(int i, int i2) {
        x.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[]{aIW(), this.iJN, Integer.valueOf(this.iJP), Integer.valueOf(i), Integer.valueOf(aIV())});
        h.mEJ.h(10505, new Object[]{aIW(), this.iJN, Integer.valueOf(this.iJP), Integer.valueOf(i), Integer.valueOf(aIV()), Integer.valueOf(i2)});
    }

    public final void H(int i, int i2, int i3) {
        x.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[]{aIW(), this.iJN, Integer.valueOf(this.iJP), Integer.valueOf(i2), Integer.valueOf(aIV())});
        h.mEJ.h(10505, new Object[]{aIW(), this.iJN, Integer.valueOf(this.iJP), Integer.valueOf(i2), Integer.valueOf(aIV()), Integer.valueOf(i3)});
        h.mEJ.a(300, (long) i, 1, false);
    }

    private int aIV() {
        return (int) bi.bI(this.iJL);
    }

    protected final void a(Uri uri, Context context, UriMatcher uriMatcher) {
        this.iJN = h(uri);
        dg(context);
        if (uriMatcher != null) {
            this.iJP = uriMatcher.match(uri);
            if (this.iJP < 0) {
                this.iJP = 0;
            }
        }
        this.iJL = bi.VG();
    }

    protected final void a(Uri uri, Context context, int i) {
        this.iJN = h(uri);
        dg(context);
        this.iJP = i;
        this.iJL = bi.VG();
    }

    public final void a(Uri uri, Context context, int i, String[] strArr) {
        this.iJN = h(uri);
        if (strArr == null) {
            dg(context);
        } else {
            this.iJO = strArr;
        }
        this.iJP = i;
        this.iJL = bi.VG();
    }

    public final String aIW() {
        if (!bi.oW(this.iJM)) {
            return this.iJM;
        }
        if (this.iJO == null || this.iJO.length <= 0) {
            return "";
        }
        return this.iJO[0];
    }

    public final boolean atA() {
        try {
            x.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
            if (!hdT) {
                b bVar = new b();
                bVar.b(4000, new 1(this, bVar));
            }
            if (au.HX() && au.HW() && !au.Dr()) {
                hdT = true;
            } else {
                hdT = false;
            }
            x.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + hdT);
            return hdT;
        } catch (Throwable e) {
            x.w("MicroMsg.ExtContentProviderBase", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
            return false;
        }
    }

    private static String h(Uri uri) {
        if (uri == null) {
            return "";
        }
        return bi.oV(uri.getQueryParameter("appid"));
    }

    public final boolean df(Context context) {
        boolean z;
        Throwable e;
        boolean z2;
        if (context == null) {
            x.w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
            return false;
        } else if (bi.oW(this.iJN)) {
            x.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
            return false;
        } else if (this.iJO == null || this.iJO.length <= 0) {
            x.e("MicroMsg.ExtContentProviderBase", "packageList is null");
            return false;
        } else {
            try {
                f bl = g.bl(this.iJN, true);
                if (bl == null) {
                    x.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
                    return false;
                }
                boolean z3;
                if (bl.field_status == 3) {
                    x.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[]{bl.field_packageName});
                    z3 = false;
                } else {
                    for (String str : this.iJO) {
                        if (str.equals(bl.field_packageName) && p.c(ad.getContext(), bl, str)) {
                            x.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[]{str});
                            try {
                                this.iJM = str;
                                z = true;
                                break;
                            } catch (Throwable e2) {
                                e = e2;
                                z2 = true;
                                x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[]{e.getMessage()});
                                x.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                                return z2;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        try {
                            Integer num = (Integer) com.tencent.mm.pluginsdk.b.b.qxY.get(Integer.valueOf(this.iJP));
                            if (num == null) {
                                num = Integer.valueOf(64);
                            }
                            if (g.a(bl, num.intValue())) {
                                x.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
                            } else {
                                z3 = false;
                            }
                        } catch (Throwable e22) {
                            e = e22;
                            z2 = z;
                            x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[]{e.getMessage()});
                            x.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                            return z2;
                        }
                    }
                    z3 = z;
                }
                try {
                    x.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[]{Long.valueOf(bi.a((Long) iJQ.get(this.iJN), 0)), Long.valueOf(System.currentTimeMillis())});
                    if (System.currentTimeMillis() - Long.valueOf(bi.a((Long) iJQ.get(this.iJN), 0)).longValue() > 3600000) {
                        x.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[]{this.iJN});
                        a.bmm().Jp(this.iJN);
                        iJQ.put(this.iJN, Long.valueOf(System.currentTimeMillis()));
                    }
                    return z3;
                } catch (Exception e3) {
                    e = e3;
                    z2 = z3;
                    x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[]{e.getMessage()});
                    x.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                    return z2;
                }
            } catch (Throwable e222) {
                e = e222;
                z2 = false;
                x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                return z2;
            }
        }
    }

    public final int aIX() {
        int i;
        Throwable e;
        if (bi.oW(this.iJN)) {
            x.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
            return 7;
        } else if (this.iJO == null || this.iJO.length <= 0) {
            x.e("MicroMsg.ExtContentProviderBase", "packageList is null");
            return 6;
        } else {
            int i2;
            try {
                f bl = g.bl(this.iJN, true);
                if (bl == null) {
                    x.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
                    return 13;
                }
                int i3;
                if (bl.field_status == 3) {
                    x.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[]{bl.field_packageName});
                    i3 = 10;
                } else {
                    for (String str : this.iJO) {
                        if (str.equals(bl.field_packageName) && p.c(ad.getContext(), bl, str)) {
                            x.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[]{str});
                            try {
                                this.iJM = str;
                                i = 1;
                                break;
                            } catch (Throwable e2) {
                                e = e2;
                                i2 = 1;
                                x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[]{e.getMessage()});
                                x.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                                return i2;
                            }
                        }
                    }
                    i = 0;
                    if (i == 1) {
                        try {
                            Integer num = (Integer) com.tencent.mm.pluginsdk.b.b.qxY.get(Integer.valueOf(this.iJP));
                            if (num == null) {
                                cw(5, 16);
                                x.i("MicroMsg.ExtContentProviderBase", "api flag = null");
                                num = Integer.valueOf(64);
                            }
                            if (g.a(bl, num.intValue())) {
                                x.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
                            } else {
                                i3 = 11;
                            }
                        } catch (Throwable e22) {
                            e = e22;
                            i2 = i;
                            x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[]{e.getMessage()});
                            x.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                            return i2;
                        }
                    }
                    i3 = i;
                }
                try {
                    x.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[]{Long.valueOf(bi.a((Long) iJQ.get(this.iJN), 0)), Long.valueOf(System.currentTimeMillis())});
                    if (System.currentTimeMillis() - Long.valueOf(bi.a((Long) iJQ.get(this.iJN), 0)).longValue() > 3600000) {
                        x.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[]{this.iJN});
                        a.bmm().Jp(this.iJN);
                        iJQ.put(this.iJN, Long.valueOf(System.currentTimeMillis()));
                    }
                    return i3;
                } catch (Exception e3) {
                    e = e3;
                    i2 = i3;
                    x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[]{e.getMessage()});
                    x.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                    return i2;
                }
            } catch (Throwable e222) {
                e = e222;
                i2 = 0;
                x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                return i2;
            }
        }
    }

    private void dg(Context context) {
        if (context == null) {
            x.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
            return;
        }
        x.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
        this.iJO = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (this.iJO == null) {
            x.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
        }
    }
}
