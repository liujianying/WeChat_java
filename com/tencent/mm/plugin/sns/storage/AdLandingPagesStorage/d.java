package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class d {
    public static String eH(String str, String str2) {
        return bAz() + eJ(str, str2);
    }

    public static String eI(String str, String str2) {
        FileOp.mL(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages");
        return Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/" + str + "_sight_" + ac.ce(str2);
    }

    private static String eJ(String str, String str2) {
        return str + "_img_" + ac.ce(str2);
    }

    public static Bitmap eK(String str, String str2) {
        if (bi.oW(str2) || bi.oW(str)) {
            return null;
        }
        try {
            String eH = eH(str, str2);
            if (TextUtils.isEmpty(eH) || !new File(eH).exists()) {
                return null;
            }
            return MMBitmapFactory.decodeFile(eH);
        } catch (Throwable e) {
            x.e("AdLandingPagesDownloadResourceHelper", "%s", bi.i(e));
            return null;
        }
    }

    public static void a(String str, int i, a aVar) {
        b("adId", str, false, i, aVar);
    }

    public static void a(String str, a aVar) {
        a("adId", str, false, 41, aVar);
    }

    private static void a(String str, String str2, boolean z, int i, a aVar) {
        x.i("AdLandingPagesDownloadResourceHelper", "start download img for " + str2 + " for adid:" + str);
        String eH = eH(str, str2);
        new b(eH, z, i, new 1(aVar, str2, str, eH)).execute(new String[]{str2});
    }

    public static void b(String str, String str2, boolean z, int i, a aVar) {
        if (bi.oW(str2) || bi.oW(str)) {
            aVar.bxo();
            return;
        }
        AdLandingPagesProxy.nmp.update();
        if (!AdLandingPagesProxy.nmp.nmv || !a(str, str2, z, aVar)) {
            a(str, str2, z, i, aVar);
        }
    }

    private static boolean a(String str, String str2, boolean z, a aVar) {
        if (bi.oW(str2) || bi.oW(str)) {
            aVar.bxo();
            return false;
        }
        x.i("AdLandingPagesDownloadResourceHelper", "start download new img for " + str2 + " for adid:" + str);
        String bAz = bAz();
        String eJ = eJ(str, str2);
        if (!FileOp.cn(bAz + eJ)) {
            try {
                AdLandingPagesProxy.getInstance().downloadLandingPagesImage(bAz, eJ, str2, new 3(aVar, bAz, eJ));
                return true;
            } catch (Throwable e) {
                if (z) {
                    AdLandingPagesProxy.downloadLandingPagesImageMMImpl(bAz, eJ, str2);
                    return true;
                }
                x.i("AdLandingPagesDownloadResourceHelper", "maybe wrong download scene, res[%s], stack[%s]", str2, bi.i(e));
                return false;
            }
        } else if (aVar == null) {
            return true;
        } else {
            ah.A(new 2(aVar, bAz, eJ));
            return true;
        }
    }

    public static void c(String str, String str2, boolean z, int i, a aVar) {
        FileOp.mL(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages");
        ac.ce(str2);
        String eI = eI(str, str2);
        if (FileOp.cn(eI)) {
            ah.A(new 4(aVar, eI));
            return;
        }
        x.i("AdLandingPagesDownloadResourceHelper", "start download sight for " + str2 + " for adid:" + str);
        new b(eI, z, i, new 5(aVar, str2, str, eI)).execute(new String[]{str2});
    }

    public static void a(String str, String str2, boolean z, int i, b bVar) {
        if (bi.oW(str2) || bi.oW(str)) {
            bVar.MY("the res or adId is null");
            return;
        }
        eH(str, str2);
        String str3 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str4 = str + "_stream_" + ac.ce(str2);
        x.i("AdLandingPagesDownloadResourceHelper", "start download video for " + str2 + " for adid:" + str);
        new ae(str3, str4, z, i, new ag(Looper.getMainLooper()), new 6(bVar, str2, str)).execute(new String[]{str2});
    }

    private static String bAz() {
        return Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/";
    }
}
