package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper.ClipBoardDataWrapper;
import com.tencent.mm.sdk.platformtools.x;

final class WebViewClipBoardHelper$a implements a<ClipBoardDataWrapper, Object> {
    private WebViewClipBoardHelper$a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        ClipBoardDataWrapper clipBoardDataWrapper = (ClipBoardDataWrapper) obj;
        if (clipBoardDataWrapper != null) {
            int i = com.tencent.mm.plugin.secinforeport.a.a.mOt;
            com.tencent.mm.plugin.secinforeport.a.a.f(3, clipBoardDataWrapper.url, clipBoardDataWrapper.length);
            return;
        }
        x.e("MicroMsg.WebViewClipBoardHelper", "InvokeTask, mm received invalid data");
    }
}
