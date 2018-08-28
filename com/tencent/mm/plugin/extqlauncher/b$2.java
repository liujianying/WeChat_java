package com.tencent.mm.plugin.extqlauncher;

import android.content.pm.ApplicationInfo;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$2 implements Runnable {
    final /* synthetic */ b iLM;

    b$2(b bVar) {
        this.iLM = bVar;
    }

    public final void run() {
        try {
            this.iLM.iLG = System.currentTimeMillis();
            List installedApplications = ad.getContext().getPackageManager().getInstalledApplications(MapRouteSectionWithName.kMaxRoadNameLength);
            if (installedApplications == null) {
                x.e("MicroMsg.SubCoreExtQLauncher", "getInstalledApplications return null");
                this.iLM.iLF = false;
                return;
            }
            for (int i = 0; i < installedApplications.size(); i++) {
                ApplicationInfo applicationInfo = (ApplicationInfo) installedApplications.get(i);
                if (applicationInfo != null && ((bi.oV(applicationInfo.packageName).startsWith("com.tencent.qlauncher") || bi.oV(applicationInfo.packageName).startsWith("com.tencent.qqlauncher") || bi.oV(applicationInfo.packageName).startsWith("com.tencent.launcher")) && applicationInfo.metaData != null)) {
                    String string = applicationInfo.metaData.getString("qlauncher_wx_coop");
                    if (string == null || string.length() <= 0) {
                        x.w("MicroMsg.SubCoreExtQLauncher", "qlauncher_wx_coop not found, %s, costTime = %s", new Object[]{applicationInfo.packageName, Long.valueOf(System.currentTimeMillis() - this.iLM.iLG)});
                        this.iLM.iLF = false;
                    } else {
                        String[] split = string.split(",");
                        if (split != null) {
                            for (String oV : split) {
                                if (bi.oV(oV).trim().equalsIgnoreCase("fun1")) {
                                    x.d("MicroMsg.SubCoreExtQLauncher", "founded qlauncher, %s", new Object[]{applicationInfo.packageName});
                                    this.iLM.iLF = true;
                                    return;
                                }
                            }
                        }
                        this.iLM.iLF = false;
                    }
                }
            }
            x.d("MicroMsg.SubCoreExtQLauncher", "qlauncher not founded, costTime = %s", new Object[]{Long.valueOf(System.currentTimeMillis() - this.iLM.iLG)});
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreExtQLauncher", "exception in getApplicationInfo, %s", new Object[]{e.getMessage()});
            this.iLM.iLF = false;
        }
    }

    public final String toString() {
        return super.toString() + "|isPluginInstall";
    }
}
