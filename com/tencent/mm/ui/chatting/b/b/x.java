package com.tencent.mm.ui.chatting.b.b;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.u;

public interface x extends u {
    void A(String str, int i, String str2);

    void a(ContextMenu contextMenu, int i, bd bdVar);

    void a(SightCaptureResult sightCaptureResult);

    boolean a(MenuItem menuItem, bd bdVar);

    boolean aS(bd bdVar);

    boolean f(int i, int i2, Intent intent);

    void t(int i, int i2, String str);
}
