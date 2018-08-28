package com.tencent.mm.plugin.multitalk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class l {
    public volatile Map<String, a> luz = Collections.synchronizedMap(new HashMap());

    public final synchronized boolean a(MultiTalkVideoView multiTalkVideoView, int[] iArr, int i, int i2, int i3) {
        boolean z = false;
        synchronized (this) {
            if (multiTalkVideoView == null) {
                x.e("MicroMsg.MT.MultiTalkViewManager", "drawVideo view is null");
            } else if (iArr == null) {
                x.e("MicroMsg.MT.MultiTalkViewManager", "renderVideoBitmap img is null");
            } else if (iArr.length < i * i2) {
                x.e("MicroMsg.MT.MultiTalkViewManager", "img length error %d %d", new Object[]{Integer.valueOf(iArr.length), Integer.valueOf(i * i2)});
            } else if (i != i2) {
                x.e("MicroMsg.MT.MultiTalkViewManager", "imgW != imgH");
            } else {
                a aVar;
                a aVar2 = (a) this.luz.get(multiTalkVideoView.getUsername());
                if (aVar2 == null) {
                    aVar2 = new a(this, (byte) 0);
                    this.luz.put(multiTalkVideoView.getUsername(), aVar2);
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
                aVar.luk = 0;
                aVar.angle = i3;
                if (aVar.luC == null || aVar.luC.getWidth() != i2) {
                    aVar.luC = Bitmap.createBitmap(i2, i2, Config.ARGB_8888);
                }
                aVar.luC.setPixels(iArr, 0, i2, 0, 0, i2, i2);
                multiTalkVideoView.c(aVar.luC, aVar.angle, aVar.luk);
                z = true;
            }
        }
        return z;
    }

    public final boolean a(MultiTalkVideoView multiTalkVideoView, boolean z) {
        if (multiTalkVideoView == null) {
            x.e("MicroMsg.MT.MultiTalkViewManager", "drawAvatar view is null");
            return false;
        }
        a aVar;
        if (this.luz.containsKey(multiTalkVideoView.getUsername())) {
            aVar = (a) this.luz.get(multiTalkVideoView.getUsername());
        } else {
            aVar = new a(this, (byte) 0);
            aVar.username = multiTalkVideoView.getUsername();
            this.luz.put(multiTalkVideoView.getUsername(), aVar);
        }
        Bitmap b;
        if (aVar.luA == null) {
            b = b.ccZ().b(multiTalkVideoView.getUsername(), multiTalkVideoView.getMeasuredWidth(), multiTalkVideoView.getMeasuredHeight(), 1);
            if (b != null && b.getHeight() < b.getWidth()) {
                b = Bitmap.createBitmap(b, 0, 0, b.getHeight(), b.getHeight());
            }
            aVar.luA = b;
        } else if (z) {
            b = b.ccZ().b(multiTalkVideoView.getUsername(), multiTalkVideoView.getMeasuredWidth(), multiTalkVideoView.getMeasuredHeight(), 1);
            if (b != null && b.getHeight() < b.getWidth()) {
                b = Bitmap.createBitmap(b, 0, 0, b.getHeight(), b.getHeight());
            }
            aVar.luA = b;
        }
        if (aVar.luA != null) {
            multiTalkVideoView.c(aVar.luA, 0, 0);
            return true;
        }
        if (aVar.luB == null) {
            aVar.luB = BitmapFactory.decodeResource(multiTalkVideoView.getResources(), R.g.multitalk_default_avatar);
        }
        multiTalkVideoView.c(aVar.luB, 0, 0);
        return true;
    }

    public final void bgH() {
        this.luz.clear();
    }
}
