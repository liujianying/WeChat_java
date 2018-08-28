package com.tencent.mm.ar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.design.a$i;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.a.e;
import com.tencent.mm.bt.h;
import com.tencent.mm.plugin.m.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import junit.framework.Assert;

public final class n extends j {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS packageinfo ( id int  PRIMARY KEY, version int  , name text  , size int  , packname text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE TABLE IF NOT EXISTS packageinfo2 ( localId text  PRIMARY KEY , id int  , version int  , name text  , size int  , packname text  , status int  , type int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    public h dCZ;

    public n(h hVar) {
        this.dCZ = hVar;
    }

    public final boolean a(m mVar) {
        if (mVar == null) {
            return false;
        }
        mVar.bWA = -1;
        if (((int) this.dCZ.insert("packageinfo2", "localId", mVar.wH())) == -1) {
            return false;
        }
        doNotify();
        return true;
    }

    public final boolean b(m mVar) {
        Assert.assertTrue(mVar != null);
        ContentValues wH = mVar.wH();
        if (wH.size() > 0) {
            if (this.dCZ.update("packageinfo2", wH, "id= ? and type =?", new String[]{mVar.id, mVar.bPh}) > 0) {
                doNotify();
                return true;
            }
        }
        doNotify();
        return false;
    }

    public final boolean ii(int i) {
        boolean fV = this.dCZ.fV("packageinfo2", "update packageinfo2 set status = 2 where status = 1 and type = " + i + ";");
        doNotify();
        return fV;
    }

    public final m bi(int i, int i2) {
        m mVar = null;
        Cursor b = this.dCZ.b("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.id = \"" + bi.oU(String.valueOf(i)) + "\" and packageinfo2.type = \"" + bi.oU(String.valueOf(i2)) + "\"", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                mVar = new m();
                mVar.d(b);
            }
            b.close();
        }
        return mVar;
    }

    public final boolean ij(int i) {
        if (this.dCZ.delete("packageinfo2", "type =?", new String[]{String.valueOf(i)}) <= 0) {
            return false;
        }
        doNotify();
        return true;
    }

    public final m[] ik(int i) {
        Cursor b = this.dCZ.b("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=" + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (b.moveToNext()) {
            m mVar = new m();
            mVar.d(b);
            arrayList.add(mVar);
        }
        b.close();
        return (m[]) arrayList.toArray(new m[arrayList.size()]);
    }

    public static String Qm() {
        return a.Gj();
    }

    public static String bj(int i, int i2) {
        return i + "_" + i2 + "_thumb.jpg";
    }

    public final String bk(int i, int i2) {
        switch (i2) {
            case 0:
                return "";
            case 1:
                return i + "_session_bg.zip";
            case 2:
                return i + "_emoji_art.temp";
            case 5:
                return "brand_i18n.apk";
            case 7:
                return i + "_configlist.cfg";
            case 8:
                return i + "_regiondata.temp";
            case 9:
                return "_speex_upload.cfg";
            case 12:
                return "_rcpt_addr";
            case 18:
                return bi(i, i2).version + "_feature.zip";
            case 19:
                return "_report_reason.temp";
            case 20:
                return "_pluginDesc.cfg";
            case 21:
                return "_trace_config.cfg";
            case 23:
                return "permissioncfg.cfg";
            case 26:
                return "ipcallCountryCodeConfig.cfg";
            case a$i.AppCompatTheme_actionModeShareDrawable /*36*/:
                return i + "_sensewhere.xml";
            default:
                return "";
        }
    }

    public final String bl(int i, int i2) {
        switch (i2) {
            case 0:
                return "";
            case 1:
                String str = a.Gj() + i + "_session_bg/";
                try {
                    File file = new File(str);
                    if (file.exists()) {
                        return str;
                    }
                    file.mkdirs();
                    return str;
                } catch (Throwable e) {
                    x.e("MicroMsg.PackageInfoStorage", "exception:%s", new Object[]{bi.i(e)});
                    x.e("MicroMsg.PackageInfoStorage", "can not create dir, dir = " + str);
                    return str;
                }
            case 2:
                return "";
            case 18:
                return a.Gj() + bk(i, i2).replace(".zip", "");
            default:
                return "";
        }
    }

    public final void bm(int i, int i2) {
        e.deleteFile(a.Gj() + bk(i, i2));
        m bi = bi(i, i2);
        if (bi != null) {
            bi.status = 5;
            r.Qp().b(bi);
        }
    }

    public static int bP(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels > displayMetrics.widthPixels ? 1 : 0;
        if (displayMetrics.density <= 1.0f) {
            if (i != 0) {
                return 4;
            }
            return 2;
        } else if (i != 0) {
            return 3;
        } else {
            return 1;
        }
    }

    public static String G(String str, boolean z) {
        if (z) {
            return a.Gj() + str + "_chatting_bg_vertical.jpg";
        }
        return a.Gj() + str + "_chatting_bg_horizontal.jpg";
    }

    public static String Q(String str, int i) {
        switch (i) {
            case 1:
            case 2:
                return G(str, false);
            case 3:
            case 4:
                return G(str, true);
            default:
                return null;
        }
    }
}
