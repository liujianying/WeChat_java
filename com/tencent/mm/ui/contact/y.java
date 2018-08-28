package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.mm.R;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import java.util.List;

public final class y {
    public static String aaP(String str) {
        j kc = q.KH().kc(str);
        au.HU();
        ab Yg = c.FR().Yg(str);
        String aE;
        if (ab.XR(str)) {
            String str2 = Yg.field_openImAppid;
            String i = ((b) g.l(b.class)).i(Yg.field_openImAppid, "openim_desc_icon", a.euj);
            aE = ((b) g.l(b.class)).aE(Yg.field_openImAppid, Yg.field_descWordingId);
            return String.format(" <msg bigheadimgurl=\"%s\" smallheadimgurl=\"%s\" username=\"%s\" nickname=\"%s\" sex=\"%d\"  openimappid=\"%s\" openimdesc=\"%s\" openimdescicon=\"%s\"/>", new Object[]{bi.WS(kc.Kx()), bi.WS(kc.Ky()), bi.WS(Yg.field_username), bi.WS(Yg.BK()), Integer.valueOf(Yg.sex), str2, bi.WS(aE), bi.WS(i)});
        }
        int i2 = Yg.csA;
        if (kc != null) {
            i2 = kc.csA;
        }
        d kH = Yg.ckW() ? f.kH(Yg.field_username) : null;
        String str3 = "<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>";
        Object[] objArr = new Object[15];
        objArr[0] = bi.WS(Yg.field_username);
        objArr[1] = bi.WS(Yg.BK());
        objArr[2] = bi.WS(Yg.wM());
        objArr[3] = bi.WS(Yg.BK());
        objArr[4] = bi.WS(Yg.wP());
        objArr[5] = Integer.valueOf(i2);
        objArr[6] = bi.WS(Yg.getProvince());
        objArr[7] = bi.WS(Yg.getCity());
        objArr[8] = bi.WS(Yg.signature);
        objArr[9] = Integer.valueOf(Yg.csJ);
        objArr[10] = Integer.valueOf(Yg.sex);
        objArr[11] = Integer.valueOf(Yg.field_verifyFlag);
        objArr[12] = bi.WS(Yg.csP);
        if (kH == null) {
            aE = "";
        } else {
            aE = bi.WS(kH.field_brandIconURL);
        }
        objArr[13] = aE;
        objArr[14] = bi.WS(Yg.csQ);
        return String.format(str3, objArr);
    }

    public static void a(Activity activity, String str, List<String> list) {
        for (String str2 : list) {
            au.DF().a(new i(str, aaP(str2), ab.XR(str2) ? 66 : 42), 0);
        }
        com.tencent.mm.ui.widget.snackbar.b.h(activity, activity.getString(R.l.has_send));
        h.mEJ.h(11003, new Object[]{str, Integer.valueOf(3), Integer.valueOf(list.size())});
        activity.setResult(-1);
        ah.i(new 1(activity), 1800);
    }
}
