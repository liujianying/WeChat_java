package com.tencent.mm.plugin.ac;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.a.e;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.w;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.ac.a.a;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.pluginsdk.model.app.ae;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.cu;
import com.tencent.mm.protocal.c.cv;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class a$1 implements a {
    final /* synthetic */ a lNi;

    a$1(a aVar) {
        this.lNi = aVar;
    }

    public final f Jn(String str) {
        return a.bmf().SW(str);
    }

    public final f Jo(String str) {
        a.bme();
        if (str == null || str.length() == 0) {
            return null;
        }
        List linkedList = new LinkedList();
        linkedList.add(str);
        ae aeVar = new ae(linkedList);
        b.a aVar = new b.a();
        aVar.dIG = new cu();
        aVar.dIH = new cv();
        aVar.uri = "/cgi-bin/micromsg-bin/appcenter";
        aVar.dIF = 452;
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        cu cuVar = (cu) KT.dID.dIL;
        byte[] cbx = aeVar.cbx();
        if (cbx != null) {
            cuVar.rcT = new bhy().bq(cbx);
        }
        cuVar.hcE = 7;
        com.tencent.mm.ab.a.a b = w.b(KT);
        x.e("MicroMsg.AppInfoService", "call getAppInfoList cgi result, errType = %d, errCode = %d", new Object[]{Integer.valueOf(b.errType), Integer.valueOf(b.errCode)});
        if (b.errType != 0 || b.errCode != 0) {
            return null;
        }
        aeVar.bg(ab.a(((cv) b.dIv).rcU));
        aeVar.a(0, b.errType, b.errCode, b.Yy, KT, new byte[0]);
        a bmm = a.a.bmm();
        if (bmm != null) {
            return bmm.Jn(str);
        }
        x.e("MicroMsg.AppInfoService", "getISubCorePluginBase() == null");
        return null;
    }

    public final Cursor bmj() {
        Cursor rawQuery = a.bmf().rawQuery("select * from AppInfo where status = 5 order by modifyTime asc", new String[0]);
        if (rawQuery != null) {
            return rawQuery;
        }
        x.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
        return null;
    }

    public final Cursor n(int[] iArr) {
        i bmf = a.bmf();
        String str = "select * from AppInfo where ";
        for (int i = 0; i <= 0; i++) {
            str = str + " status = " + iArr[0];
        }
        Cursor rawQuery = bmf.rawQuery(str + " order by status desc, modifyTime asc", new String[0]);
        if (rawQuery != null) {
            return rawQuery;
        }
        x.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
        return null;
    }

    public final Bitmap a(String str, int i, float f) {
        a.bmf();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
            return null;
        } else if (str.equals("wx7fa037cc7dfabad5")) {
            return BitmapFactory.decodeResource(ad.getContext().getResources(), d.app_icon);
        } else {
            String cQ = i.cQ(str, i);
            if (e.cn(cQ)) {
                return BackwardSupportUtil.b.e(cQ, f);
            }
            x.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + cQ + ", iconType = " + i);
            return null;
        }
    }

    public final void bS(String str, int i) {
        a.bmd().cO(str, i);
    }

    public final void Jp(String str) {
        a.bme().SU(str);
    }

    public final void c(f fVar) {
        i bmf = a.bmf();
        if (fVar != null && fVar.field_status != 5) {
            fVar.field_status = 3;
            x.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", new Object[]{fVar.field_packageName});
            bmf.a(fVar, new String[0]);
        }
    }

    public final void d(f fVar) {
        i bmf = a.bmf();
        if (fVar != null && fVar.field_status == 3) {
            fVar.field_status = 4;
            bmf.a(fVar, new String[0]);
        }
    }

    public final void e(f fVar) {
        a.bmf().a(fVar, new String[0]);
    }

    public final i bmk() {
        return a.bmf();
    }

    public final void X(LinkedList<String> linkedList) {
        a.bme().ap(linkedList);
    }

    public final Cursor dh(int i, int i2) {
        return a.bmf().dh(i, i2);
    }

    public final Cursor bml() {
        i bmf = a.bmf();
        StringBuilder stringBuilder = new StringBuilder(GLIcon.TOP);
        stringBuilder.append("select * from AppInfo");
        stringBuilder.append(" where ");
        stringBuilder.append("serviceAppType > 0");
        Cursor rawQuery = bmf.rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
            return null;
        }
        x.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", new Object[]{Integer.valueOf(rawQuery.getCount())});
        return rawQuery;
    }
}
