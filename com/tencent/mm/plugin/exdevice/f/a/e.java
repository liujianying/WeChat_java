package com.tencent.mm.plugin.exdevice.f.a;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class e {
    public static void a(Context context, ImageView imageView, String str, int i) {
        Assert.assertTrue(imageView != null);
        if (ah.isMainThread()) {
            b(imageView, str, i);
        } else {
            ah.A(new 1(context, imageView, str, i));
        }
    }

    static void b(ImageView imageView, String str, int i) {
        if (bi.oW(str) || "#".equals(str)) {
            x.d("MicroMsg.ExdeviceRankUtil", "hy: url is null or nill. set to default picture resource");
            imageView.setImageResource(i);
            return;
        }
        x.d("MicroMsg.ExdeviceRankUtil", "hy: set url to %s", new Object[]{str});
        ad.aHh().a(str, imageView, ad.Aa(str));
    }

    public static void e(MMActivity mMActivity) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(mMActivity.getString(R.l.exdevice_change_cover));
        linkedList2.add(Integer.valueOf(0));
        h.a(mMActivity, "", linkedList, linkedList2, null, true, new 2(mMActivity));
    }

    public static boolean a(MMActivity mMActivity, int i, int i2, Intent intent, String str) {
        if (i == 1001 && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                return false;
            }
            String str2 = (String) stringArrayListExtra.get(0);
            Intent intent2 = new Intent();
            intent2.putExtra("CropImageMode", 1);
            intent2.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.dgt + "temp.cover");
            intent2.putExtra("CropImage_ImgPath", str2);
            d.b(mMActivity, ".ui.tools.CropImageNewUI", intent2, 1002);
            return true;
        } else if (i != 1002 || i2 != -1) {
            return false;
        } else {
            String Ac = d.Ac(com.tencent.mm.compatible.util.e.dgt + "temp.cover");
            c aHo = ad.aHo();
            aHo.appName = str;
            long currentTimeMillis = System.currentTimeMillis();
            aHo.ixo = com.tencent.mm.modelcdntran.d.a("uploadexdeivce", currentTimeMillis, q.Hl().field_username, String.valueOf(currentTimeMillis));
            String str3 = aHo.ixo;
            i iVar = new i();
            iVar.dPV = aHo;
            iVar.field_mediaId = str3;
            iVar.field_fullpath = Ac;
            iVar.field_thumbpath = "";
            iVar.field_fileType = b.dOu;
            iVar.field_talker = "";
            iVar.field_priority = b.dOj;
            iVar.field_needStorage = true;
            iVar.field_isStreamMedia = false;
            iVar.field_appType = 200;
            iVar.field_bzScene = 2;
            if (!g.ND().c(iVar)) {
                x.e("MicroMsg.ExdevicePictureUploader", "hy: cdntra addSendTask failed. clientid:%s", new Object[]{str3});
            }
            return true;
        }
    }
}
