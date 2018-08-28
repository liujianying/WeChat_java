package com.tencent.mm.plugin.freewifi.ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FreeWifiManufacturerLoadingUI extends MMActivity {
    private al bAZ;
    private String bssid;
    private final int jnA = 3;
    private int[] jnB = new int[]{R.g.free_wifi_loading_1, R.g.free_wifi_loading_2, R.g.free_wifi_loading_3, R.g.free_wifi_loading_4, R.g.free_wifi_loading_5};
    ag jnC = new 1(this);
    ag jnD = new ag();
    private ImageView jnv;
    private TextView jnw;
    private Button jnx;
    private final int jny = 1;
    private final int jnz = 2;
    private String ssid;

    static /* synthetic */ void b(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, String str) {
        freeWifiManufacturerLoadingUI.ak(0, "");
        freeWifiManufacturerLoadingUI.Cj(freeWifiManufacturerLoadingUI.getString(R.l.free_wifi_manufacturer_loading_opening_portal_url));
        freeWifiManufacturerLoadingUI.aPE();
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "opening url : " + str);
        ah.A(new 7(freeWifiManufacturerLoadingUI, str));
    }

    static /* synthetic */ void f(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_channel_id", 10);
        intent.setClass(freeWifiManufacturerLoadingUI, FreeWifiSuccUI.class);
        freeWifiManufacturerLoadingUI.startActivity(intent);
        freeWifiManufacturerLoadingUI.finish();
        freeWifiManufacturerLoadingUI.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
    }

    static /* synthetic */ boolean g(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        String bQ = bQ(ad.getContext());
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "topActivityName : " + bQ);
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "getClas().getName()=" + freeWifiManufacturerLoadingUI.getClass().getName());
        boolean z = bQ != null && bQ.equals(freeWifiManufacturerLoadingUI.getClass().getName());
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ret = " + z);
        return z;
    }

    static /* synthetic */ String r(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readLine = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(readLine);
        while (true) {
            String readLine2 = bufferedReader.readLine();
            if (readLine2 != null) {
                stringBuilder.append(readLine2);
            } else {
                x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "response body=" + stringBuilder.toString());
                return m.BR(readLine);
            }
        }
    }

    private void aPE() {
        if (this.bAZ != null) {
            this.bAZ.SO();
        }
        this.jnC.sendEmptyMessage(2);
    }

    protected final int getLayoutId() {
        return R.i.free_wifi_manufacturer_loading;
    }

    public void finish() {
        aPE();
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.free_wifi_title);
        this.ssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid");
        this.bssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid");
        this.jnv = (ImageView) findViewById(R.h.free_wifi_manufacturer_app_logo_iv);
        this.jnw = (TextView) findViewById(R.h.free_wifi_manufacturer_hint);
        this.jnx = (Button) findViewById(R.h.free_wifi_manufacturer_reconnect_btn);
        this.jnx.setOnClickListener(new 2(this));
        setBackBtn(new 3(this));
        aPF();
    }

    public final void aPF() {
        this.jnC.sendEmptyMessage(1);
        if (this.bAZ != null) {
            this.bAZ.SO();
        }
        this.bAZ = new al(new 4(this), true);
        this.bAZ.J(200, 200);
        j.aON().aOv().post(new 5(this, this.ssid));
    }

    private void ak(int i, String str) {
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "errcode=%d, errmsg=%s", new Object[]{Integer.valueOf(i), str});
        if (i != 0) {
            aPE();
            if (i == 1154) {
                Cj(getString(R.l.free_wifi_manufacturer_loading_getting_portal_url_unsupported) + "(031" + b.jiO.jiQ + "-" + Math.abs(i) + ")");
                return;
            }
            Cj(getString(R.l.free_wifi_manufacturer_loading_getting_portal_url_fail) + "(031" + b.jiO.jiQ + "-" + Math.abs(i) + ")");
            this.jnD.postDelayed(new 6(this), 0);
        }
    }

    private void Cj(String str) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = str;
        this.jnC.sendMessage(obtain);
    }

    private static String bQ(Context context) {
        try {
            String className = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "top activity name =" + className);
            return className;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", e, "", new Object[0]);
            return "(null)";
        }
    }
}
