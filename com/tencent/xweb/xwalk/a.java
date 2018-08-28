package com.tencent.xweb.xwalk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.e;
import com.tencent.xweb.g;
import com.tencent.xweb.k;
import com.tencent.xweb.xwalk.a.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.xwalk.core.Log;
import org.xwalk.core.R;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkUpdater;

public final class a implements e {
    Context vAp;
    WebView vEe;
    ScrollView vEf = null;
    TextView vEg = null;
    TextView vEh = null;
    TextView vEi = null;
    View vEj;
    boolean vEk = false;
    String vEl = "tools";

    public a(WebView webView) {
        this.vAp = webView.getContext();
        this.vEe = webView;
        cJk();
    }

    public final void cIy() {
        if (k.cIn().vAr) {
            a(k.cIn().vAr, null, false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean adD(java.lang.String r11) {
        /*
        r10 = this;
        r5 = -1;
        r2 = 0;
        r4 = 1;
        r0 = "debugmm.qq.com";
        r0 = r11.contains(r0);
        if (r0 == 0) goto L_0x00b6;
    L_0x000c:
        r1 = android.net.Uri.parse(r11);
        r0 = r1.getQueryParameterNames();
        if (r0 == 0) goto L_0x00b6;
    L_0x0016:
        r3 = r0.size();
        if (r3 <= 0) goto L_0x00b6;
    L_0x001c:
        r3 = r0.iterator();
    L_0x0020:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x00b6;
    L_0x0026:
        r0 = r3.next();
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x0020;
    L_0x002e:
        r6 = r0.hashCode();
        switch(r6) {
            case -677737752: goto L_0x0077;
            default: goto L_0x0035;
        };
    L_0x0035:
        r0 = r5;
    L_0x0036:
        switch(r0) {
            case 0: goto L_0x003a;
            default: goto L_0x0039;
        };
    L_0x0039:
        goto L_0x0020;
    L_0x003a:
        r0 = "forcex5";
        r0 = r1.getBooleanQueryParameter(r0, r2);
        if (r0 == 0) goto L_0x0082;
    L_0x0043:
        r0 = com.tencent.xweb.k.cIn();
        r1 = "tools";
        r2 = com.tencent.xweb.WebView.d.vAQ;
        r0.a(r1, r2);
        r0 = com.tencent.xweb.k.cIn();
        r1 = "appbrand";
        r2 = com.tencent.xweb.WebView.d.vAQ;
        r0.a(r1, r2);
        r0 = com.tencent.xweb.k.cIn();
        r1 = "support";
        r2 = com.tencent.xweb.WebView.d.vAQ;
        r0.a(r1, r2);
        r0 = com.tencent.xweb.k.cIn();
        r1 = com.tencent.xweb.g.a.vAh;
        r0.a(r1);
        r0 = "force use x5 switch is on ";
        r10.adI(r0);
    L_0x0076:
        return r4;
    L_0x0077:
        r6 = "forcex5";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x0035;
    L_0x0080:
        r0 = r2;
        goto L_0x0036;
    L_0x0082:
        r0 = com.tencent.xweb.k.cIn();
        r1 = "tools";
        r2 = com.tencent.xweb.WebView.d.vAO;
        r0.a(r1, r2);
        r0 = com.tencent.xweb.k.cIn();
        r1 = "appbrand";
        r2 = com.tencent.xweb.WebView.d.vAO;
        r0.a(r1, r2);
        r0 = com.tencent.xweb.k.cIn();
        r1 = "support";
        r2 = com.tencent.xweb.WebView.d.vAO;
        r0.a(r1, r2);
        r0 = com.tencent.xweb.k.cIn();
        r1 = com.tencent.xweb.g.a.vAc;
        r0.a(r1);
        r0 = "force use x5 switch is off ";
        r10.adI(r0);
        goto L_0x0076;
    L_0x00b6:
        r0 = "public.debugxweb.qq.com";
        r0 = r11.contains(r0);
        if (r0 == 0) goto L_0x011b;
    L_0x00bf:
        r1 = android.net.Uri.parse(r11);
        r0 = r1.getQueryParameterNames();
        if (r0 == 0) goto L_0x0076;
    L_0x00c9:
        r3 = r0.size();
        if (r3 <= 0) goto L_0x0076;
    L_0x00cf:
        r3 = r0.iterator();
    L_0x00d3:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0076;
    L_0x00d9:
        r0 = r3.next();
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x00d3;
    L_0x00e1:
        r6 = r0.hashCode();
        switch(r6) {
            case -1157057597: goto L_0x0110;
            default: goto L_0x00e8;
        };
    L_0x00e8:
        r0 = r5;
    L_0x00e9:
        switch(r0) {
            case 0: goto L_0x00ed;
            default: goto L_0x00ec;
        };
    L_0x00ec:
        goto L_0x00d3;
    L_0x00ed:
        r0 = com.tencent.xweb.k.cIn();
        r6 = "enable_local_debug";
        r6 = r1.getBooleanQueryParameter(r6, r2);
        r0 = r0.vAp;
        r7 = "wcwebview";
        r0 = r0.getSharedPreferences(r7, r2);
        r0 = r0.edit();
        r7 = "m_bEnableLocalDebug";
        r0 = r0.putBoolean(r7, r6);
        r0.commit();
        goto L_0x00d3;
    L_0x0110:
        r6 = "enable_local_debug";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x00e8;
    L_0x0119:
        r0 = r2;
        goto L_0x00e9;
    L_0x011b:
        r0 = com.tencent.xweb.k.cIn();
        r0 = r0.vAp;
        r1 = "wcwebview";
        r0 = r0.getSharedPreferences(r1, r2);
        r1 = "m_bEnableLocalDebug";
        r6 = r0.getBoolean(r1, r2);
        r0 = "debugxweb.qq.com";
        r0 = r11.contains(r0);
        if (r0 == 0) goto L_0x021d;
    L_0x0138:
        r7 = android.net.Uri.parse(r11);
        r0 = r7.getQueryParameterNames();
        if (r0 == 0) goto L_0x0148;
    L_0x0142:
        r1 = r0.size();
        if (r1 != 0) goto L_0x014f;
    L_0x0148:
        if (r6 == 0) goto L_0x0076;
    L_0x014a:
        r10.cJl();
        goto L_0x0076;
    L_0x014f:
        r8 = r0.iterator();
        r1 = r2;
        r3 = r2;
    L_0x0155:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x0207;
    L_0x015b:
        r0 = r8.next();
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x016e;
    L_0x0163:
        r9 = r0.hashCode();
        switch(r9) {
            case -604633792: goto L_0x0192;
            case -82035977: goto L_0x0171;
            case 386281809: goto L_0x0187;
            case 724449292: goto L_0x017c;
            default: goto L_0x016a;
        };
    L_0x016a:
        r0 = r5;
    L_0x016b:
        switch(r0) {
            case 0: goto L_0x019d;
            case 1: goto L_0x01b1;
            case 2: goto L_0x01d0;
            case 3: goto L_0x0200;
            default: goto L_0x016e;
        };
    L_0x016e:
        r0 = r1;
    L_0x016f:
        r1 = r0;
        goto L_0x0155;
    L_0x0171:
        r9 = "inspector";
        r0 = r0.equals(r9);
        if (r0 == 0) goto L_0x016a;
    L_0x017a:
        r0 = r2;
        goto L_0x016b;
    L_0x017c:
        r9 = "use_testconfig";
        r0 = r0.equals(r9);
        if (r0 == 0) goto L_0x016a;
    L_0x0185:
        r0 = r4;
        goto L_0x016b;
    L_0x0187:
        r9 = "set_grayvalue";
        r0 = r0.equals(r9);
        if (r0 == 0) goto L_0x016a;
    L_0x0190:
        r0 = 2;
        goto L_0x016b;
    L_0x0192:
        r9 = "kill_all";
        r0 = r0.equals(r9);
        if (r0 == 0) goto L_0x016a;
    L_0x019b:
        r0 = 3;
        goto L_0x016b;
    L_0x019d:
        r0 = "inspector";
        r0 = r7.getBooleanQueryParameter(r0, r2);
        r3 = com.tencent.xweb.k.cIn();
        r3.mV(r0);
        r3 = 0;
        r10.a(r0, r3, r4);
        r3 = r4;
        goto L_0x0155;
    L_0x01b1:
        r0 = "use_testconfig";
        r0 = r7.getBooleanQueryParameter(r0, r2);
        r3 = com.tencent.xweb.k.cIn();
        r3.mW(r0);
        if (r0 == 0) goto L_0x01c9;
    L_0x01c1:
        r0 = "使用测试config";
        r10.bG(r0, r4);
    L_0x01c7:
        r3 = r4;
        goto L_0x0155;
    L_0x01c9:
        r0 = "使用正式config";
        r10.bG(r0, r4);
        goto L_0x01c7;
    L_0x01d0:
        r0 = "set_grayvalue";
        r0 = r7.getQueryParameter(r0);	 Catch:{ Exception -> 0x01f6 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x01f6 }
        org.xwalk.core.XWalkEnvironment.setGrayValueForTest(r0);
        r3 = new java.lang.StringBuilder;
        r9 = "灰度值设为";
        r3.<init>(r9);
        r0 = r0 % 10000;
        r0 = r3.append(r0);
        r0 = r0.toString();
        r10.bG(r0, r4);
        r3 = r4;
        goto L_0x0155;
    L_0x01f6:
        r0 = move-exception;
        r0 = "灰度值设置失败，参数解析错误";
        r10.bG(r0, r4);
        r3 = r4;
        goto L_0x0155;
    L_0x0200:
        r10.afv();
        r0 = r4;
        r3 = r4;
        goto L_0x016f;
    L_0x0207:
        r0 = r3;
    L_0x0208:
        if (r6 == 0) goto L_0x021b;
    L_0x020a:
        if (r0 != 0) goto L_0x0212;
    L_0x020c:
        r0 = r10.adH(r11);
        if (r0 == 0) goto L_0x0213;
    L_0x0212:
        r2 = r4;
    L_0x0213:
        r4 = r2;
    L_0x0214:
        if (r1 == 0) goto L_0x0076;
    L_0x0216:
        r10.afv();
        goto L_0x0076;
    L_0x021b:
        r4 = r0;
        goto L_0x0214;
    L_0x021d:
        r1 = r2;
        r0 = r2;
        goto L_0x0208;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.a.adD(java.lang.String):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean adH(java.lang.String r9) {
        /*
        r8 = this;
        r3 = -1;
        r2 = 0;
        r1 = 1;
        r0 = "debugxweb.qq.com";
        r0 = r9.contains(r0);
        if (r0 == 0) goto L_0x01bb;
    L_0x000c:
        r4 = android.net.Uri.parse(r9);
        r0 = r4.getQueryParameterNames();
        if (r0 == 0) goto L_0x001c;
    L_0x0016:
        r5 = r0.size();
        if (r5 != 0) goto L_0x0021;
    L_0x001c:
        r8.cJl();
        r0 = r1;
    L_0x0020:
        return r0;
    L_0x0021:
        r5 = r0.iterator();
    L_0x0025:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x01b8;
    L_0x002b:
        r0 = r5.next();
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x0025;
    L_0x0033:
        r6 = r0.hashCode();
        switch(r6) {
            case -974615216: goto L_0x0064;
            case -748036674: goto L_0x0059;
            case 368659514: goto L_0x006f;
            case 603805332: goto L_0x0043;
            case 989541982: goto L_0x0085;
            case 1874228874: goto L_0x004e;
            case 2135256815: goto L_0x007a;
            default: goto L_0x003a;
        };
    L_0x003a:
        r0 = r3;
    L_0x003b:
        switch(r0) {
            case 0: goto L_0x003f;
            case 1: goto L_0x0090;
            case 2: goto L_0x00be;
            case 3: goto L_0x014a;
            case 4: goto L_0x0180;
            case 5: goto L_0x0189;
            case 6: goto L_0x01b3;
            default: goto L_0x003e;
        };
    L_0x003e:
        goto L_0x0025;
    L_0x003f:
        r8.mZ(r2);
        goto L_0x0025;
    L_0x0043:
        r6 = "load_local_xwalk";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x003a;
    L_0x004c:
        r0 = r2;
        goto L_0x003b;
    L_0x004e:
        r6 = "set_web_config";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x003a;
    L_0x0057:
        r0 = r1;
        goto L_0x003b;
    L_0x0059:
        r6 = "set_appbrand_config";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x003a;
    L_0x0062:
        r0 = 2;
        goto L_0x003b;
    L_0x0064:
        r6 = "show_webview_version";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x003a;
    L_0x006d:
        r0 = 3;
        goto L_0x003b;
    L_0x006f:
        r6 = "clear_commands";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x003a;
    L_0x0078:
        r0 = 4;
        goto L_0x003b;
    L_0x007a:
        r6 = "set_config_url";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x003a;
    L_0x0083:
        r0 = 5;
        goto L_0x003b;
    L_0x0085:
        r6 = "check_xwalk_update";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x003a;
    L_0x008e:
        r0 = 6;
        goto L_0x003b;
    L_0x0090:
        r0 = "set_web_config";
        r0 = r4.getQueryParameter(r0);	 Catch:{ Exception -> 0x00bb }
        r0 = com.tencent.xweb.WebView.d.valueOf(r0);	 Catch:{ Exception -> 0x00bb }
        r6 = com.tencent.xweb.k.cIn();	 Catch:{ Exception -> 0x00bb }
        r7 = "tools";
        r6.a(r7, r0);	 Catch:{ Exception -> 0x00bb }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bb }
        r7 = "打开网页将使用:";
        r6.<init>(r7);	 Catch:{ Exception -> 0x00bb }
        r0 = r6.append(r0);	 Catch:{ Exception -> 0x00bb }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00bb }
        r6 = 1;
        r8.bG(r0, r6);	 Catch:{ Exception -> 0x00bb }
        goto L_0x0025;
    L_0x00bb:
        r0 = move-exception;
        goto L_0x0025;
    L_0x00be:
        r0 = "set_appbrand_config";
        r0 = r4.getQueryParameter(r0);	 Catch:{ Exception -> 0x0109 }
        r0 = com.tencent.xweb.WebView.d.valueOf(r0);	 Catch:{ Exception -> 0x0109 }
        r6 = com.tencent.xweb.k.cIn();	 Catch:{ Exception -> 0x0109 }
        r7 = "appbrand";
        r6.a(r7, r0);	 Catch:{ Exception -> 0x0109 }
        r6 = com.tencent.xweb.k.cIn();	 Catch:{ Exception -> 0x0109 }
        r7 = "support";
        r6.a(r7, r0);	 Catch:{ Exception -> 0x0109 }
        r6 = com.tencent.xweb.xwalk.a.18.vDq;	 Catch:{ Exception -> 0x0109 }
        r7 = r0.ordinal();	 Catch:{ Exception -> 0x0109 }
        r6 = r6[r7];	 Catch:{ Exception -> 0x0109 }
        switch(r6) {
            case 1: goto L_0x00ea;
            case 2: goto L_0x010c;
            case 3: goto L_0x012b;
            default: goto L_0x00e8;
        };	 Catch:{ Exception -> 0x0109 }
    L_0x00e8:
        goto L_0x0025;
    L_0x00ea:
        r6 = com.tencent.xweb.k.cIn();	 Catch:{ Exception -> 0x0109 }
        r7 = com.tencent.xweb.g.a.vAk;	 Catch:{ Exception -> 0x0109 }
        r6.a(r7);	 Catch:{ Exception -> 0x0109 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0109 }
        r7 = "打开小程序将使用:";
        r6.<init>(r7);	 Catch:{ Exception -> 0x0109 }
        r0 = r6.append(r0);	 Catch:{ Exception -> 0x0109 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0109 }
        r6 = 1;
        r8.bG(r0, r6);	 Catch:{ Exception -> 0x0109 }
        goto L_0x0025;
    L_0x0109:
        r0 = move-exception;
        goto L_0x0025;
    L_0x010c:
        r6 = com.tencent.xweb.k.cIn();	 Catch:{ Exception -> 0x0109 }
        r7 = com.tencent.xweb.g.a.vAh;	 Catch:{ Exception -> 0x0109 }
        r6.a(r7);	 Catch:{ Exception -> 0x0109 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0109 }
        r7 = "打开小程序将使用:";
        r6.<init>(r7);	 Catch:{ Exception -> 0x0109 }
        r0 = r6.append(r0);	 Catch:{ Exception -> 0x0109 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0109 }
        r6 = 1;
        r8.bG(r0, r6);	 Catch:{ Exception -> 0x0109 }
        goto L_0x0025;
    L_0x012b:
        r6 = com.tencent.xweb.k.cIn();	 Catch:{ Exception -> 0x0109 }
        r7 = com.tencent.xweb.g.a.vAk;	 Catch:{ Exception -> 0x0109 }
        r6.a(r7);	 Catch:{ Exception -> 0x0109 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0109 }
        r7 = "打开小程序将使用:";
        r6.<init>(r7);	 Catch:{ Exception -> 0x0109 }
        r0 = r6.append(r0);	 Catch:{ Exception -> 0x0109 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0109 }
        r6 = 1;
        r8.bG(r0, r6);	 Catch:{ Exception -> 0x0109 }
        goto L_0x0025;
    L_0x014a:
        r0 = r8.vEi;
        if (r0 != 0) goto L_0x0025;
    L_0x014e:
        r0 = new android.widget.ScrollView;
        r6 = r8.vAp;
        r0.<init>(r6);
        r6 = new android.widget.TextView;
        r7 = r8.vAp;
        r6.<init>(r7);
        r8.vEi = r6;
        r6 = r8.vEi;
        r6.setBackgroundColor(r3);
        r6 = r8.vEi;
        r0.addView(r6);
        r6 = r8.vEi;
        r7 = new com.tencent.xweb.xwalk.a$1;
        r7.<init>(r8);
        r6.setOnClickListener(r7);
        r8.cJj();
        r6 = r8.vEe;
        r6 = r6.getTopView();
        r6.addView(r0);
        goto L_0x0025;
    L_0x0180:
        r0 = 0;
        r6 = "0";
        com.tencent.xweb.a.a(r0, r6);
        goto L_0x0025;
    L_0x0189:
        r0 = "set_config_url";
        r0 = r4.getQueryParameter(r0);	 Catch:{ Exception -> 0x01aa }
        r6 = r8.vAp;
        org.xwalk.core.XWalkEnvironment.setTestDownLoadUrl(r6, r0);
        r6 = new java.lang.StringBuilder;
        r7 = "测试连接设置为:";
        r6.<init>(r7);
        r0 = r6.append(r0);
        r0 = r0.toString();
        r8.bG(r0, r1);
        goto L_0x0025;
    L_0x01aa:
        r0 = move-exception;
        r0 = "测试连接设置失败，格式错误";
        r8.bG(r0, r1);
        goto L_0x0025;
    L_0x01b3:
        r8.cJm();
        goto L_0x0025;
    L_0x01b8:
        r0 = r1;
        goto L_0x0020;
    L_0x01bb:
        r0 = r2;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.a.adH(java.lang.String):boolean");
    }

    final void cJj() {
        if (this.vEi != null) {
            String xWalkUpdateConfigUrl = XWalkEnvironment.getXWalkUpdateConfigUrl();
            String str = "\n\n" + this.vEe.getAbstractInfo();
            if (WebView.getCurWebType() != d.vAP) {
                str = str + "\n xwebsdk is = 21 apk ver is " + XWalkEnvironment.getAvailableVersion();
            }
            StringBuilder append = new StringBuilder().append(str).append("\n\n current js engine: =  ").append(g.cIl()).append("\n prefered js engine =  ").append(g.b(com.tencent.xweb.g.a.vAc, "appbrand", this.vAp)).append("\n isWaitingForUpdate = ");
            c.cJo();
            CharSequence stringBuilder = append.append(c.cJp()).append("\n local gray value = ").append(XWalkEnvironment.getGrayValue()).append("\n config url = ").append(xWalkUpdateConfigUrl).append("\n\n apilevel = ").append(VERSION.SDK_INT).append("\n device is  ").append(Build.BRAND).append(" ").append(Build.MODEL).toString();
            xWalkUpdateConfigUrl = com.tencent.xweb.a.getAbstractInfo();
            if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
                stringBuilder = stringBuilder + "\n\n ------dump commands start:------\n" + xWalkUpdateConfigUrl + "\n ------dump commands end------";
            }
            xWalkUpdateConfigUrl = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (c.cJq()) {
                    xWalkUpdateConfigUrl = (((((xWalkUpdateConfigUrl + "going to update to apk ver = " + c.cJv().vFr) + "\n update time is = " + simpleDateFormat.format(new Date(c.cJv().vFA))) + "\n is patch update = " + c.cJv().vFz) + "\n can use cellular = " + c.cJv().vFq) + "\n try count = " + c.cJv().vFC) + "\n";
                }
                xWalkUpdateConfigUrl = xWalkUpdateConfigUrl + " last fetch config time = " + simpleDateFormat.format(new Date(c.cJv().vFy));
            } catch (Exception e) {
            }
            if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
                stringBuilder = stringBuilder + "\n\n ------dump schedule updateInfo start:------\n" + xWalkUpdateConfigUrl + "\n ------dump schedule updateInfo end------";
            }
            xWalkUpdateConfigUrl = XWalkEnvironment.getXWalkInitializeLog();
            if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
                stringBuilder = stringBuilder + "\n\n ------dump xweb log------\n" + xWalkUpdateConfigUrl;
            }
            this.vEi.setText(stringBuilder);
        }
    }

    final void cJk() {
        if (k.cIn().vAs && this.vEh == null) {
            this.vEh = new TextView(this.vAp);
            this.vEh.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    a.this.cJl();
                    return true;
                }
            });
            if (this.vEh != null) {
                CharSequence versionInfo = this.vEe.getVersionInfo();
                int indexOf = versionInfo.indexOf(",apkversion");
                if (indexOf > 0) {
                    versionInfo = versionInfo.substring(0, indexOf);
                }
                this.vEh.setText(versionInfo);
            }
            this.vEe.getTopView().addView(this.vEh);
        }
    }

    final void f(d dVar) {
        switch (18.vDq[dVar.ordinal()]) {
            case 1:
                ((RadioButton) this.vEj.findViewById(R.id.WV_XWALK)).setChecked(true);
                return;
            case 2:
                ((RadioButton) this.vEj.findViewById(R.id.WV_X5)).setChecked(true);
                return;
            case 3:
                ((RadioButton) this.vEj.findViewById(R.id.WV_SYS)).setChecked(true);
                return;
            case 4:
                ((RadioButton) this.vEj.findViewById(R.id.WV_AUTO)).setChecked(true);
                return;
            default:
                return;
        }
    }

    final boolean cJl() {
        if (this.vEj != null) {
            this.vEj.setVisibility(0);
        } else {
            this.vEj = ((LayoutInflater) this.vAp.getSystemService("layout_inflater")).inflate(R.layout.debug_menu, this.vEe.getTopView(), true).findViewById(R.id.view_root);
            ((Button) this.vEj.findViewById(R.id.button_close_menu)).setOnClickListener(new 19(this));
            CheckBox checkBox = (CheckBox) this.vEj.findViewById(R.id.checked_show_version);
            checkBox.setChecked(k.cIn().vAs);
            checkBox.setOnCheckedChangeListener(new 20(this));
            ((TextView) this.vEj.findViewById(R.id.check_text)).setOnClickListener(new 21(this, checkBox));
            final EditText editText = (EditText) this.vEj.findViewById(R.id.txtin_grayvalue);
            if (editText != null) {
                editText.setInputType(2);
                editText.setText(XWalkEnvironment.getGrayValue());
                editText.addTextChangedListener(new TextWatcher() {
                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        int i = 0;
                        try {
                            i = Integer.parseInt(editText.getText().toString());
                        } catch (Exception e) {
                        }
                        XWalkEnvironment.setGrayValueForTest(i);
                    }
                });
            }
            ((Spinner) this.vEj.findViewById(R.id.selector_webviewmodule)).setOnItemSelectedListener(new 23(this));
            ((RadioGroup) this.vEj.findViewById(R.id.web_select)).setOnCheckedChangeListener(new 24(this));
            switch (18.vAb[k.cIn().vAu.ordinal()]) {
                case 1:
                    ((RadioButton) this.vEj.findViewById(R.id.v8_auto)).setChecked(true);
                    break;
                case 2:
                    ((RadioButton) this.vEj.findViewById(R.id.v8_sys)).setChecked(true);
                    break;
                case 3:
                    ((RadioButton) this.vEj.findViewById(R.id.v8_x5)).setChecked(true);
                    break;
                case 4:
                    ((RadioButton) this.vEj.findViewById(R.id.v8_nativescript)).setChecked(true);
                    break;
                case 5:
                    ((RadioButton) this.vEj.findViewById(R.id.v8_mmv8)).setChecked(true);
                    break;
            }
            ((RadioGroup) this.vEj.findViewById(R.id.v8_select)).setOnCheckedChangeListener(new 25(this));
            ((Button) this.vEj.findViewById(R.id.button_kill)).setOnClickListener(new 2(this));
            Button button = (Button) this.vEj.findViewById(R.id.btn_debug);
            a(k.cIn().vAr, button, false);
            button.setOnClickListener(new 3(this, button));
            ((Button) this.vEj.findViewById(R.id.button_clear)).setOnClickListener(new 4(this));
            ((Button) this.vEj.findViewById(R.id.button_refreshLog)).setOnClickListener(new 5(this));
            ((Button) this.vEj.findViewById(R.id.button_loadLocalApk)).setOnClickListener(new 6(this));
            button = (Button) this.vEj.findViewById(R.id.button_config);
            button.setText(k.cIn().vAv ? "使用正式版config" : "使用测试config");
            button.setOnClickListener(new 7(this, button));
            ((Button) this.vEj.findViewById(R.id.button_update)).setOnClickListener(new 8(this));
            ((TextView) this.vEj.findViewById(R.id.txtVersion)).setText(this.vEe.getVersionInfo() + "\n" + XWalkInitializer.getXWalkInitializeLog());
            ((LinearLayout) this.vEj.findViewById(R.id.config_memu)).setVisibility(8);
            ((Button) this.vEj.findViewById(R.id.button_change_to_xweb)).setOnClickListener(new 9(this));
            ((Button) this.vEj.findViewById(R.id.button_change_to_x5)).setOnClickListener(new 10(this));
            ((Button) this.vEj.findViewById(R.id.button_change_to_sys)).setOnClickListener(new 11(this));
            ((Button) this.vEj.findViewById(R.id.button_change_to_auto)).setOnClickListener(new 13(this));
            ((Button) this.vEj.findViewById(R.id.button_advanced)).setOnClickListener(new 14(this));
        }
        return true;
    }

    final void cJm() {
        com.tencent.xweb.a.a(null, "0");
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", 0);
        edit.putBoolean("bCanUseCellular", true);
        edit.putLong("nTimeToUpdate", 100);
        edit.commit();
        c.cJv().vFy = 100;
        c.cJv().vFq = true;
        c.cJv().vFA = 100;
        new b(this, this.vAp).p(null);
    }

    final void afv() {
        im(this.vAp);
    }

    protected static void im(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.uid == myUid && runningAppProcessInfo.pid != myPid) {
                String str = runningAppProcessInfo.processName;
                if (str == null || !str.contains("com.tencent.mm") || runningAppProcessInfo.processName.contains("tools") || runningAppProcessInfo.processName.contains("appbrand") || runningAppProcessInfo.processName.contains("support")) {
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        }
        Process.killProcess(myPid);
    }

    public final void a(boolean z, Button button, boolean z2) {
        try {
            XWalkPreferences.setValue("remote-debugging", z);
        } catch (Exception e) {
        }
        try {
            if (VERSION.SDK_INT >= 19) {
                android.webkit.WebView.setWebContentsDebuggingEnabled(z);
            }
        } catch (Exception e2) {
        }
        try {
            com.tencent.smtt.sdk.WebView.setWebContentsDebuggingEnabled(z);
        } catch (Exception e3) {
        }
        if (z2 && this.vEe.getX5WebViewExtension() != null) {
            if (z) {
                this.vEe.loadUrl("http://debugx5.qq.com/?inspector=true");
            } else {
                this.vEe.loadUrl("http://debugx5.qq.com/?inspector=false");
            }
        }
        if (button == null) {
            return;
        }
        if (z) {
            button.setText("关闭远程调试模式");
        } else {
            button.setText("打开远程调试模式");
        }
    }

    final void mZ(boolean z) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            bG("请确认应用权限，在权限管理打开应用的读写存储权限", true);
        } else if (externalStorageDirectory.listFiles() == null) {
            bG("请确认应用权限，在权限管理打开应用的读写存储权限", true);
        } else {
            externalStorageDirectory.toString();
            try {
                File[] listFiles = new File(externalStorageDirectory.getPath() + "/apkxwebtest").listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    bG("apkxwebtest目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
                    return;
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].getName().endsWith(".zip")) {
                        String absolutePath = listFiles[i].getAbsolutePath();
                        String name = listFiles[i].getName();
                        if (z) {
                            new Builder(this.vAp).setTitle("提示").setMessage("确定加载:" + name + "?").setPositiveButton("确定", new 16(this, absolutePath, name, z)).setNegativeButton("取消", new 15(this)).show();
                            return;
                        } else {
                            x(absolutePath, name, z);
                            return;
                        }
                    }
                }
                bG("apkxwebtest目录下没有.zip文件", true);
            } catch (Exception e) {
                bG("没有找到apkxwebtest目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
            }
        }
    }

    final void x(String str, String str2, boolean z) {
        a aVar = new a(str, str2);
        try {
            File file = new File(XWalkEnvironment.getDownloadZipDir(aVar.apkVer));
            if (file.exists()) {
                file.delete();
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
        }
        try {
            Integer onHandleFile = XWalkUpdater.onHandleFile(aVar);
            if (onHandleFile.intValue() == 0) {
                bG("安装" + str2 + "成功", z);
            } else {
                bG("安装" + str2 + "失败,错误码=" + onHandleFile, true);
            }
        } catch (Exception e2) {
            bG("安装失败", true);
            Log.e("WebDebugPage", "install local apk failed : " + e2.getMessage());
        }
    }

    final void bG(String str, boolean z) {
        if (z) {
            Builder builder = new Builder(this.vAp);
            builder.setMessage(str);
            builder.create().show();
            return;
        }
        Log.e("WebDebugPage", str);
    }

    final void adI(String str) {
        Builder builder = new Builder(this.vAp);
        builder.setMessage(str);
        builder.create();
        builder.setCancelable(true);
        builder.setOnCancelListener(new 17(this));
        builder.show();
    }
}
