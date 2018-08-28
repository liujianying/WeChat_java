package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.i;
import com.tencent.xweb.g.a;
import org.xwalk.core.XWalkEnvironment;

public final class k {
    private static k vAo = null;
    public Context vAp;
    d vAq = d.vAO;
    public boolean vAr = false;
    public boolean vAs = false;
    boolean vAt = false;
    public a vAu = a.vAc;
    public boolean vAv = false;
    String vAw = "";

    public static void ik(Context context) {
        boolean z = false;
        if (vAo == null) {
            k kVar = new k();
            vAo = kVar;
            kVar.vAp = context;
            XWalkEnvironment.init(context);
            vAo.vAs = context.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
            String string = context.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO");
            try {
                vAo.vAu = a.valueOf(string);
            } catch (Exception e) {
            }
            vAo.vAr = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
            string = XWalkEnvironment.getTestDownLoadUrl(context);
            k kVar2 = vAo;
            if (!(string == null || string.isEmpty())) {
                z = true;
            }
            kVar2.vAv = z;
        }
    }

    public static k cIn() {
        return vAo;
    }

    public final d adC(String str) {
        if (this.vAw.equals(str)) {
            return this.vAq;
        }
        if (str == null || str.isEmpty() || this.vAp == null) {
            return d.vAO;
        }
        this.vAw = str;
        SharedPreferences sharedPreferences = this.vAp.getSharedPreferences("wcwebview", 0);
        if (sharedPreferences == null) {
            return d.vAO;
        }
        String string = sharedPreferences.getString("HardCodeWebView" + str, "");
        if (string == null || string.isEmpty() || string.equals(d.vAO.toString())) {
            string = sharedPreferences.getString("ABTestWebView" + str, "");
        }
        if (string == null || string.isEmpty()) {
            this.vAq = d.vAO;
        } else {
            try {
                this.vAq = d.valueOf(string);
            } catch (Exception e) {
                this.vAq = d.vAO;
            }
        }
        return this.vAq;
    }

    public final void a(String str, d dVar) {
        if (this.vAp != null && str != null && !str.isEmpty()) {
            this.vAw = str;
            this.vAq = dVar;
            this.vAp.getSharedPreferences("wcwebview", 0).edit().putString("HardCodeWebView" + str, dVar.toString()).commit();
        }
    }

    public final void mV(boolean z) {
        if (z != this.vAr) {
            this.vAr = z;
            XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", z).commit();
        }
    }

    public final void a(a aVar) {
        if (this.vAu != aVar) {
            this.vAu = aVar;
            this.vAp.getSharedPreferences("wcwebview", 0).edit().putString("V8type", aVar.toString()).commit();
        }
    }

    public final void mW(boolean z) {
        if (z != this.vAv) {
            this.vAv = z;
            Editor edit;
            if (this.vAv) {
                XWalkEnvironment.setTestDownLoadUrl(this.vAp, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
                edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
                edit.putLong("nLastFetchConfigTime", 0);
                edit.commit();
                i.b(d.vAP).excute("STR_CMD_CLEAR_SCHEDULER", null);
                return;
            }
            XWalkEnvironment.setTestDownLoadUrl(this.vAp, "");
            edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
            edit.putLong("nLastFetchConfigTime", 0);
            edit.commit();
            i.b(d.vAP).excute("STR_CMD_CLEAR_SCHEDULER", null);
        }
    }
}
