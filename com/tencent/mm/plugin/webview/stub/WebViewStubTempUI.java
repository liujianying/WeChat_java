package com.tencent.mm.plugin.webview.stub;

import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mm.plugin.webview.ui.tools.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.ArrayList;

@a(7)
public class WebViewStubTempUI extends MMActivity implements android.support.v4.app.a.a, MMActivity.a {
    private int pUX = 0;
    private boolean pUY = false;
    private Dialog pUZ = null;

    public static void a(Context context, String str, String str2, Intent intent, int i) {
        Intent intent2 = new Intent(context, WebViewStubTempUI.class);
        if (context instanceof Service) {
            intent2.addFlags(268435456);
        }
        intent2.putExtra("key_action_code", 2);
        StartActivityForResultTask startActivityForResultTask = new StartActivityForResultTask();
        startActivityForResultTask.mOg = str;
        startActivityForResultTask.pVe = str2;
        startActivityForResultTask.pVf = intent;
        startActivityForResultTask.bRZ = 15;
        startActivityForResultTask.pVg = false;
        startActivityForResultTask.pSV = i;
        intent2.putExtra("key_activity_result_task", startActivityForResultTask);
        context.startActivity(intent2);
    }

    public static void a(Context context, e eVar, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        Intent intent = new Intent(context, WebViewStubTempUI.class);
        if (context instanceof Service) {
            intent.addFlags(268435456);
        }
        intent.putExtra("key_action_code", 0);
        intent.putExtra("key_alert_cancelable", false);
        intent.putExtra("key_alert_message", str);
        intent.putExtra("key_alert_title", str2);
        intent.putExtra("key_alert_yes", str3);
        intent.putExtra("key_alert_no", str4);
        intent.putExtra("key_alert_result_receiver", new 1(ag.fetchFreeHandler(), onClickListener, onClickListener2));
        d.a(intent.getExtras(), "webview", ".stub.WebViewStubTempUI", eVar, null);
    }

    public static boolean a(Context context, e eVar, String[] strArr, int i, int i2) {
        if (context == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 <= 0; i3++) {
            String str = strArr[0];
            if (android.support.v4.content.a.f(context, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == 0) {
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_action_code", 1);
        bundle.putStringArray("key_permission_types", (String[]) arrayList.toArray(new String[arrayList.size()]));
        bundle.putInt("key_permission_request_code", i);
        bundle.putInt("key_binder_id", i2);
        d.a(bundle, "webview", ".stub.WebViewStubTempUI", eVar, null);
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        switch (getIntent().getIntExtra("key_action_code", -1)) {
            case 0:
                ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("key_alert_result_receiver");
                if (resultReceiver == null) {
                    finish();
                    return;
                }
                this.pUZ = h.a(this, getIntent().getBooleanExtra("key_alert_cancelable", false), getIntent().getStringExtra("key_alert_message"), getIntent().getStringExtra("key_alert_title"), getIntent().getStringExtra("key_alert_yes"), getIntent().getStringExtra("key_alert_no"), new 2(this, resultReceiver), new 3(this, resultReceiver));
                this.pUZ.setOnCancelListener(new 4(this));
                return;
            case 1:
                android.support.v4.app.a.a(this, getIntent().getStringArrayExtra("key_permission_types"), getIntent().getIntExtra("key_permission_request_code", 0));
                return;
            case 2:
                StartActivityForResultTask startActivityForResultTask = (StartActivityForResultTask) getIntent().getParcelableExtra("key_activity_result_task");
                this.pUX = startActivityForResultTask.pSV;
                this.pUY = true;
                this.geJ = this;
                com.tencent.mm.bg.d.a(this, startActivityForResultTask.mOg, startActivityForResultTask.pVe, startActivityForResultTask.pVf, startActivityForResultTask.bRZ, startActivityForResultTask.pVg);
                return;
            default:
                finish();
                return;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.pUZ != null) {
            this.pUZ.dismiss();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int intExtra = getIntent().getIntExtra("key_binder_id", 0);
        switch (i) {
            case 72:
            case TbsListener$ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH /*113*/:
            case 115:
            case 116:
            case 117:
            case 118:
                if (iArr[0] != 0) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(intExtra).b(i, 0, null);
                    break;
                } else {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(intExtra).b(i, -1, null);
                    break;
                }
        }
        finish();
    }

    public final void b(int i, int i2, Intent intent) {
        if (this.pUY) {
            g Bh = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(this.pUX);
            if (Bh != null) {
                Bh.b(i, i2, intent);
            }
        }
        finish();
    }

    public final int getLayoutId() {
        return -1;
    }
}
