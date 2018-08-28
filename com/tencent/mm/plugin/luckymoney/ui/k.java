package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.k.a;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    public static void I(Context context, int i) {
        a aVar = a.kXR;
        if (context == null || aVar == null) {
            x.e("MicroMsg.LuckySoundUtil", "play Err context:%s pathId:%d speekeron:%s looping:%b", new Object[]{context, Integer.valueOf(i), aVar, Boolean.valueOf(false)});
        } else if (a.Aj() && a.Am()) {
            String string = context.getString(i);
            j jVar = new j();
            if (aVar != a.kXR) {
                jVar.setAudioStreamType(aVar == a.kXS ? 5 : 0);
            }
            x.i("MicroMsg.LuckySoundUtil", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b ", new Object[]{Integer.valueOf(jVar.hashCode()), string, context, Integer.valueOf(i), aVar, Boolean.valueOf(false)});
            try {
                AssetFileDescriptor openFd = context.getAssets().openFd(string);
                jVar.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                openFd.close();
                jVar.setLooping(false);
                jVar.prepare();
                jVar.start();
                jVar.setOnErrorListener(new 1());
                jVar.setOnCompletionListener(new 2(string));
            } catch (Throwable e) {
                x.e("MicroMsg.LuckySoundUtil", "play failed pathId:%d e:%s", new Object[]{Integer.valueOf(i), e.getMessage()});
                x.printErrStackTrace("MicroMsg.LuckySoundUtil", e, "", new Object[0]);
            }
        }
    }
}
