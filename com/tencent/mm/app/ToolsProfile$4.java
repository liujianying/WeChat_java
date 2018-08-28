package com.tencent.mm.app;

import android.content.res.Resources;
import com.tencent.mm.svg.a.e;
import java.util.Map;
import org.xwalk.core.WebViewExtensionListener;

class ToolsProfile$4 extends WebViewExtensionListener {
    final /* synthetic */ ToolsProfile bzj;

    ToolsProfile$4(ToolsProfile toolsProfile) {
        this.bzj = toolsProfile;
    }

    public final Object onMiscCallBack(String str, Object... objArr) {
        if ("AddFilterResources".equals(str)) {
            e.a((Resources) objArr[0], (Map) objArr[1]);
        }
        return null;
    }
}
