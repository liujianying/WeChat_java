package com.tencent.smtt.export.external;

import android.content.Intent;
import java.util.ArrayList;
import java.util.TimerTask;

final class DexClassLoaderProvider$1 extends TimerTask {
    final /* synthetic */ String val$dexName;
    final /* synthetic */ String val$dexPath;
    final /* synthetic */ String val$libraryPath;
    final /* synthetic */ String val$optimizedDirectory;

    DexClassLoaderProvider$1(String str, String str2, String str3, String str4) {
        this.val$dexName = str;
        this.val$dexPath = str2;
        this.val$optimizedDirectory = str3;
        this.val$libraryPath = str4;
    }

    public final void run() {
        try {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(0, this.val$dexName);
            arrayList.add(1, this.val$dexPath);
            arrayList.add(2, this.val$optimizedDirectory);
            arrayList.add(3, this.val$libraryPath);
            Intent intent = new Intent(DexClassLoaderProvider.access$000(), DexClassLoaderProviderService.class);
            intent.putStringArrayListExtra("dex2oat", arrayList);
            DexClassLoaderProvider.access$000().startService(intent);
        } catch (SecurityException e) {
        } catch (Throwable th) {
            new StringBuilder("after shouldUseDexLoaderService exception: ").append(th);
        }
    }
}
