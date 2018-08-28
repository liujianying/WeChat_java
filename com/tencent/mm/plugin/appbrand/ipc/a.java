package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<String, Class<? extends AppBrandTaskProxyUI>> fDC;

    public static void a(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3) {
        AppBrandProcessProxyUI.a(context, AppBrandProcessProxyUI.class, str, str2, str3, str4, onClickListener, onClickListener2, onClickListener3);
    }

    public static <_Req extends ProcessRequest, _Result extends ProcessResult> void a(Context context, _Req _req, b<_Result> bVar) {
        AppBrandProcessProxyUI.a(context, AppBrandProcessProxyUI.class, _req, bVar);
    }

    public static <_Req extends ProcessRequest, _Result extends ProcessResult> void b(Context context, _Req _req, b<_Result> bVar) {
        Class cls = (Class) fDC.get(ad.getProcessName().replaceFirst(ad.getPackageName(), ""));
        Class cls2 = AppBrandProcessProxyUI.class;
        if (cls == null) {
            cls = cls2;
        }
        AppBrandProcessProxyUI.a(context, cls, _req, bVar);
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put(":appbrand0", AppBrandTaskProxyUI.class);
        hashMap.put(":appbrand1", AppBrandTaskProxyUI1.class);
        hashMap.put(":appbrand2", AppBrandTaskProxyUI2.class);
        hashMap.put(":appbrand3", AppBrandTaskProxyUI3.class);
        hashMap.put(":appbrand4", AppBrandTaskProxyUI4.class);
        hashMap.put(":tools", AppBrandTaskInToolsProxyUI.class);
        fDC = Collections.unmodifiableMap(hashMap);
    }
}
