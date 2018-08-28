package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

@com.tencent.mm.ui.base.a(7)
public class AppBrandProcessProxyUI extends MMActivity implements b {
    private int fDQ = 0;
    private AppBrandProxyUIProcessTask fDR;
    private ProcessRequest fDS;
    private boolean fDT = false;
    private volatile boolean fDU = false;
    private c fDV;
    private a fDW;

    private class a implements OnClickListener, OnDismissListener {
        private boolean fEe;

        private a() {
            this.fEe = false;
        }

        /* synthetic */ a(AppBrandProcessProxyUI appBrandProcessProxyUI, byte b) {
            this();
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            kw(i);
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            kw(-2);
            AppBrandProcessProxyUI.this.a(null);
        }

        private void kw(int i) {
            if (!this.fEe) {
                this.fEe = true;
                ResultReceiver resultReceiver = (ResultReceiver) AppBrandProcessProxyUI.this.getIntent().getParcelableExtra("key_result_receiver");
                if (resultReceiver != null) {
                    resultReceiver.send(i, null);
                }
            }
        }
    }

    public static boolean t(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            if (intent.getComponent() != null && intent.getComponent().getShortClassName().equals(".plugin.appbrand.ipc.AppBrandProcessProxyUI") && intent.getIntExtra("key_running_mode", -1) == 10000) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void m(Context context, Intent intent) {
        if (!(context instanceof AppBrandUI) || (context instanceof AppBrandPluginUI)) {
            context.startActivity(intent);
        } else {
            context.startActivity(new Intent(context, AppBrandProcessProxyUI.class).putExtra("key_running_mode", 10000).putExtra("key_proxy_launch_target_intent", intent).putExtra("key_proxy_launch_appbrand_ui_class", context.getClass()).addFlags(268435456));
        }
    }

    static <_Req extends ProcessRequest, _Result extends ProcessResult> void a(Context context, Class<? extends AppBrandProcessProxyUI> cls, _Req _req, b<_Result> bVar) {
        Context context2;
        Class cls2;
        Parcelable parcelable;
        if (context == null) {
            context2 = ad.getContext();
        } else {
            context2 = context;
        }
        String name = _req.ahF().getName();
        if (cls == null) {
            cls2 = AppBrandProcessProxyUI.class;
        } else {
            Class<? extends AppBrandProcessProxyUI> cls22 = cls;
        }
        Intent putExtra = new Intent(context2, cls22).putExtra("key_model_class_name", name);
        String str = "key_result_receiver";
        if (bVar == null) {
            parcelable = null;
        } else {
            parcelable = new 1(ag.fetchFreeHandler(Looper.getMainLooper()), bVar);
        }
        putExtra = putExtra.putExtra(str, parcelable).putExtra("appbrand_report_key_target_activity", _req.ahE()).putExtra("key_running_mode", 1);
        putExtra.putExtra("key_request_parcel", _req);
        if (context2 instanceof Activity) {
            putExtra.putExtra("key_need_light_status", j.c(((Activity) context2).getWindow()));
        } else {
            putExtra.addFlags(268435456);
        }
        if (AppBrandProcessProxyUI.class == cls || !(context2 instanceof Activity)) {
            context2.startActivity(putExtra);
        } else {
            ((Activity) context2).startActivityForResult(putExtra, 0);
        }
    }

    static void a(Context context, Class<? extends AppBrandProcessProxyUI> cls, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3) {
        if (context == null) {
            context = ad.getContext();
        }
        Intent putExtra = new Intent(context, cls).putExtra("key_running_mode", 2).putExtra("key_result_receiver", new 2(ag.fetchFreeHandler(Looper.getMainLooper()), onClickListener, onClickListener2, onClickListener3)).putExtra("key_alert_message", str).putExtra("key_alert_title", str2).putExtra("key_alert_confirm", str3).putExtra("key_alert_deny", str4);
        if (!(context instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        context.startActivity(putExtra);
    }

    public final int getLayoutId() {
        return -1;
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(1);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        j.a(getWindow());
        j.a(getWindow(), getIntent().getBooleanExtra("key_need_light_status", false));
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getIntent() == null) {
            finish();
            return;
        }
        String stringExtra;
        switch (getIntent().getIntExtra("key_running_mode", 0)) {
            case 1:
                getIntent().setExtrasClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
                stringExtra = getIntent().getStringExtra("key_model_class_name");
                x.i("MicroMsg.AppBrandProcessProxyUI", "onCreate, modelClass = %s", new Object[]{stringExtra});
                if (!bi.oW(stringExtra)) {
                    this.fDR = com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.a.tf(stringExtra);
                    if (this.fDR == null) {
                        x.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown model class = %s", new Object[]{stringExtra});
                    } else if (getIntent().getBooleanExtra("key_request_need_params", true)) {
                        this.fDS = (ProcessRequest) getIntent().getParcelableExtra("key_request_parcel");
                        if (this.fDS == null) {
                            x.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown request class = %s", new Object[]{stringExtra});
                        } else {
                            this.fDR.fEn = this;
                            this.fDR.a(this.fDS);
                            z = true;
                        }
                    } else {
                        this.fDS = null;
                    }
                }
                if (!z) {
                    finish();
                    return;
                }
                return;
            case 2:
                String nilAs = nilAs(getIntent().getStringExtra("key_alert_title"), "");
                stringExtra = nilAs(getIntent().getStringExtra("key_alert_message"), getString(s.j.app_tip));
                String nilAs2 = nilAs(getIntent().getStringExtra("key_alert_confirm"), "");
                String nilAs3 = nilAs(getIntent().getStringExtra("key_alert_deny"), "");
                this.fDW = new a(this, (byte) 0);
                this.fDV = h.a(this, stringExtra, nilAs, nilAs2, nilAs3, false, this.fDW, this.fDW);
                this.fDV.setOnDismissListener(this.fDW);
                this.fDV.setOnKeyListener(new 3(this, nilAs3));
                return;
            case 10000:
                Intent intent = (Intent) getIntent().getParcelableExtra("key_proxy_launch_target_intent");
                if (intent != null) {
                    if (intent.getComponent() != null) {
                        try {
                            Class.forName(intent.getComponent().getClassName());
                        } catch (Exception e) {
                            x.e("MicroMsg.AppBrandProcessProxyUI", "proxyLaunch, Class.forName %s, e = %s", new Object[]{intent.getComponent().getClassName(), e});
                        }
                    }
                    try {
                        startActivity(intent);
                        return;
                    } catch (Exception e2) {
                        try {
                            x.e("MicroMsg.AppBrandProcessProxyUI", "start targetActivity, %s, e = %s", new Object[]{intent, e2});
                            return;
                        } catch (Exception e3) {
                            return;
                        }
                    }
                }
                finish();
                return;
            default:
                finish();
                return;
        }
    }

    private static String nilAs(String str, String str2) {
        return bi.oW(str) ? str2 : str;
    }

    protected void onResume() {
        super.onResume();
        int intExtra = getIntent().getIntExtra("key_running_mode", 0);
        if (intExtra == 10000) {
            intExtra = this.fDQ + 1;
            this.fDQ = intExtra;
            if (intExtra > 1) {
                try {
                    Class cls = (Class) getIntent().getSerializableExtra("key_proxy_launch_appbrand_ui_class");
                    if (cls == null) {
                        finish();
                        return;
                    }
                    startActivity(new Intent(this, cls).putExtra("key_appbrand_bring_ui_to_front", true).addFlags(268435456));
                    finish();
                } catch (Exception e) {
                    finish();
                }
            }
        } else if (intExtra == 2) {
            x.d("MicroMsg.AppBrandProcessProxyUI", "onResume, RUNNING_MODE_SHOW_ALERT");
        } else {
            x.d("MicroMsg.AppBrandProcessProxyUI", "onResume, mFinishOnNextResume = %b, finishing = %b, request = %s", new Object[]{Boolean.valueOf(this.fDT), Boolean.valueOf(ahx()), this.fDS.getClass().getName()});
            if (this.fDT && this.fDS.ahD() && !r0) {
                a(null);
            }
            this.fDT = true;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.fDV != null && this.fDV.isShowing()) {
            this.fDV.dismiss();
            this.fDV = null;
            this.fDW = null;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, requestCode = %d, resultCode = %d, request = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), this.fDS.getClass().getName()});
        this.fDT = false;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if (this.fDR != null) {
            this.fDR.ahC();
        }
    }

    public final MMActivity ahw() {
        return this;
    }

    public final void a(ProcessResult processResult) {
        this.fDU = true;
        runOnUiThread(new 4(this, processResult));
    }

    public final boolean ahx() {
        return this.tlP || isFinishing() || this.fDU;
    }

    public final void b(ProcessResult processResult) {
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("key_result_receiver");
        if (resultReceiver != null && processResult != null) {
            Bundle bundle = new Bundle(2);
            bundle.putParcelable("key_result_parcel", processResult);
            resultReceiver.send(0, bundle);
        }
    }
}
