package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.support.design.a$i;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.bt.h;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends j {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS massendinfo ( clientid text  PRIMARY KEY , status int  , createtime long  , lastmodifytime long  , filename text  , thumbfilename text  , tolist text  , tolistcount int  , msgtype int  , mediatime int  , datanetoffset int  , datalen int  , thumbnetoffset int  , thumbtotallen int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  massendinfostatus_index ON massendinfo ( status )"};
    public h dCZ;

    public b(h hVar) {
        this.dCZ = hVar;
    }

    public static Bitmap d(String str, float f) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        Bitmap e = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.e(stringBuilder.append(c.Gb()).append(trim).toString(), f);
        if (e != null) {
            return Bitmap.createScaledBitmap(e, (int) (((float) e.getWidth()) * f), (int) (((float) e.getHeight()) * f), true);
        }
        return e;
    }

    public static Bitmap Gh(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        return y.oQ(stringBuilder.append(c.Gb()).append(trim).toString());
    }

    public static a i(String str, String str2, int i, int i2) {
        if (!e.cn(str)) {
            return null;
        }
        au.HU();
        String Gb = c.Gb();
        int VX = ExifHelper.VX(str);
        String u = g.u((str + System.currentTimeMillis()).getBytes());
        x.d("MicroMsg.MasSendInfoStorage", "insert : original img path = " + str);
        Options VZ = com.tencent.mm.sdk.platformtools.c.VZ(str);
        if (i2 != 0 || (e.cm(str) <= 204800 && (VZ == null || (VZ.outHeight <= 960 && VZ.outWidth <= 960)))) {
            e.a(Gb, u, ".jpg", e.e(str, 0, e.cm(str)));
        } else {
            if (!com.tencent.mm.sdk.platformtools.c.a(str, 960, 960, CompressFormat.JPEG, 70, Gb, u)) {
                return null;
            }
            e.i(Gb, u, u + ".jpg");
        }
        String str3 = u + ".jpg";
        x.d("MicroMsg.MasSendInfoStorage", "insert: compressed bigImgPath = " + str3);
        if (i2 == 0 && VX != 0 && !com.tencent.mm.sdk.platformtools.c.a(Gb + str3, VX, CompressFormat.JPEG, Gb, u + ".jpg")) {
            return null;
        }
        u = g.u((str3 + System.currentTimeMillis()).getBytes());
        if (!com.tencent.mm.sdk.platformtools.c.a(Gb + str3, 120, 120, CompressFormat.JPEG, 90, Gb, u)) {
            return null;
        }
        x.d("MicroMsg.MasSendInfoStorage", "insert: thumbName = " + u);
        a aVar = new a();
        aVar.msgType = 3;
        aVar.laj = str2;
        aVar.lak = i;
        aVar.lai = u;
        aVar.filename = str3;
        return aVar;
    }

    public static String a(a aVar) {
        switch (aVar.msgType) {
            case 1:
                return aVar.bch();
            case 3:
                return ad.getContext().getResources().getString(R.l.app_pic);
            case a$i.AppCompatTheme_actionModePasteDrawable /*34*/:
                return ad.getContext().getResources().getString(R.l.app_voice);
            case a$i.AppCompatTheme_dialogPreferredPadding /*43*/:
                return ad.getContext().getResources().getString(R.l.app_video);
            default:
                return ad.getContext().getResources().getString(R.l.contact_info_masssend_tip);
        }
    }

    public final a Gi(String str) {
        a aVar = null;
        Cursor b = this.dCZ.b("select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   where massendinfo.clientid = \"" + bi.oU(str) + "\"", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                aVar = new a();
                aVar.d(b);
            }
            b.close();
        }
        return aVar;
    }
}
