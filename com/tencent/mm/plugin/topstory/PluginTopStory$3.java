package com.tencent.mm.plugin.topstory;

import android.content.res.Resources;
import com.tencent.mm.svg.a.e;
import java.util.Map;
import org.xwalk.core.WebViewExtensionListener;

class PluginTopStory$3 extends WebViewExtensionListener {
    final /* synthetic */ PluginTopStory oyB;

    PluginTopStory$3(PluginTopStory pluginTopStory) {
        this.oyB = pluginTopStory;
    }

    public final Object onMiscCallBack(String str, Object... objArr) {
        if ("AddFilterResources".equals(str)) {
            e.a((Resources) objArr[0], (Map) objArr[1]);
        }
        return null;
    }
}
