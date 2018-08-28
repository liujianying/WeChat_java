package com.tencent.mm.model;

import android.content.Intent;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.d.b;
import com.tencent.mm.ac.d.b.a;
import com.tencent.mm.ac.z;
import com.tencent.mm.api.h;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.e;
import java.util.ArrayList;

public final class j implements h {
    public final boolean cB(String str) {
        if (z.MY().kA(str).LS()) {
            return true;
        }
        return false;
    }

    public final ArrayList<String> cC(String str) {
        try {
            b bG = z.MY().kA(str).bG(false);
            if (bG.dLv == null && bG.dKT != null) {
                bG.dLv = a.kt(bG.dKT.optString("AcctTransferInfo"));
            }
            return bG.dLv.dLx;
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    public final void a(Intent intent, bja bja, int i) {
        String a = ab.a(bja.rvi);
        intent.putExtra("Contact_User", a);
        intent.putExtra("Contact_Nick", ab.a(bja.rQz));
        intent.putExtra("Contact_PyInitial", ab.a(bja.ruT));
        intent.putExtra("Contact_QuanPin", ab.a(bja.ruU));
        intent.putExtra("Contact_Alias", bja.eJM);
        intent.putExtra("Contact_Sex", bja.eJH);
        intent.putExtra("Contact_VUser_Info", bja.rTf);
        intent.putExtra("Contact_VUser_Info_Flag", bja.rTe);
        intent.putExtra("Contact_KWeibo_flag", bja.rTi);
        intent.putExtra("Contact_KWeibo", bja.rTg);
        intent.putExtra("Contact_KWeiboNick", bja.rTh);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aq(bja.eJQ, bja.eJI, bja.eJJ));
        intent.putExtra("Contact_Signature", bja.eJK);
        intent.putExtra("Contact_BrandList", bja.eJR);
        intent.putExtra("Contact_KSnsIFlag", bja.rTk.eJS);
        intent.putExtra("Contact_KSnsBgId", bja.rTk.eJU);
        intent.putExtra("Contact_KSnsBgUrl", bja.rTk.eJT);
        intent.putExtra("Contact_BIZ_KF_WORKER_ID", bja.sjm);
        intent.putExtra(e.a.ths, bja.rEJ);
        intent.putExtra("Contact_BIZ_PopupInfoMsg", bja.sjn);
        x.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[]{bja.rEJ});
        d dVar = new d();
        dVar.field_username = a;
        dVar.field_brandList = bja.eJR;
        dVar.field_kfWorkerId = bja.sjm;
        qt qtVar = bja.rTl;
        if (qtVar != null) {
            dVar.field_brandFlag = qtVar.eJV;
            dVar.field_brandInfo = qtVar.eJX;
            dVar.field_extInfo = qtVar.eJW;
            dVar.field_brandIconURL = qtVar.eJY;
        }
        if (!z.MY().e(dVar)) {
            z.MY().d(dVar);
        }
    }

    public final void a(Intent intent, biy biy, int i) {
        String a = ab.a(biy.rvi);
        intent.putExtra("Contact_User", a);
        intent.putExtra("Contact_Nick", ab.a(biy.rQz));
        intent.putExtra("Contact_PyInitial", ab.a(biy.ruT));
        intent.putExtra("Contact_QuanPin", ab.a(biy.ruU));
        intent.putExtra("Contact_Alias", biy.eJM);
        intent.putExtra("Contact_Sex", biy.eJH);
        intent.putExtra("Contact_VUser_Info", biy.rTf);
        intent.putExtra("Contact_VUser_Info_Flag", biy.rTe);
        intent.putExtra("Contact_KWeibo_flag", biy.rTi);
        intent.putExtra("Contact_KWeibo", biy.rTg);
        intent.putExtra("Contact_KWeiboNick", biy.rTh);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aq(biy.eJQ, biy.eJI, biy.eJJ));
        intent.putExtra("Contact_Signature", biy.eJK);
        intent.putExtra("Contact_BrandList", biy.eJR);
        intent.putExtra("Contact_KSnsIFlag", biy.rTk.eJS);
        intent.putExtra("Contact_KSnsBgId", biy.rTk.eJU);
        intent.putExtra("Contact_KSnsBgUrl", biy.rTk.eJT);
        intent.putExtra(e.a.ths, biy.rEJ);
        x.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[]{biy.rEJ});
        d dVar = new d();
        dVar.field_username = a;
        dVar.field_brandList = biy.eJR;
        qt qtVar = biy.rTl;
        if (qtVar != null) {
            dVar.field_brandFlag = qtVar.eJV;
            dVar.field_brandInfo = qtVar.eJX;
            dVar.field_extInfo = qtVar.eJW;
            dVar.field_brandIconURL = qtVar.eJY;
        }
        if (!z.MY().e(dVar)) {
            z.MY().d(dVar);
        }
    }
}
