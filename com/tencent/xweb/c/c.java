package com.tencent.xweb.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.xweb.WebView.d;
import java.util.Date;
import org.xwalk.core.XWalkEnvironment;

public final class c {
    public static boolean vCE = false;
    static String vCF = "";
    public SharedPreferences vCB;
    public int vCC;
    public String vCD;

    public c(String str, d dVar, int i) {
        SharedPreferences sharedPreferences = null;
        if (dVar == d.vAP || dVar == d.vAR) {
            String str2 = "INIT_SP_TAG_" + dVar.toString() + str;
            if (!str2.equals(vCF)) {
                vCF = str2;
                XWalkEnvironment.getApplicationContext();
                sharedPreferences = XWalkEnvironment.getProcessSafePreferences("INIT_SP_TAG_" + dVar.toString(), 4);
            }
        }
        this.vCB = sharedPreferences;
        this.vCD = str;
        this.vCC = i;
    }

    public final void cIE() {
        if (!vCE && this.vCB != null) {
            long time = new Date().getTime();
            Editor edit = this.vCB.edit();
            edit.putLong("INIT_START_TIME", time);
            edit.putLong("INIT_START_TIME" + this.vCD, time).commit();
        }
    }

    public final void cIF() {
        if (this.vCB != null) {
            this.vCB.edit().putLong("INIT_END_TIME", new Date().getTime()).commit();
        }
    }
}
