package com.tencent.smtt.export.external;

import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.TimerTask;

final class DexClassLoaderProvider$2 extends TimerTask {
    final /* synthetic */ String val$dexName;
    final /* synthetic */ String val$dexPath;
    final /* synthetic */ String val$libraryPath;
    final /* synthetic */ String val$optimizedDirectory;
    final /* synthetic */ ClassLoader val$parent;

    DexClassLoaderProvider$2(String str, String str2, String str3, ClassLoader classLoader, String str4) {
        this.val$dexPath = str;
        this.val$optimizedDirectory = str2;
        this.val$libraryPath = str3;
        this.val$parent = classLoader;
        this.val$dexName = str4;
    }

    public final void run() {
        boolean z = true;
        try {
            File file = new File(this.val$dexPath.replace(".jar", ".dex"));
            if (!file.exists() || file.length() == 0) {
                z = false;
            }
            File file2 = new File(this.val$optimizedDirectory);
            File file3 = new File(this.val$dexPath);
            boolean exists = file2.exists();
            boolean isDirectory = file2.isDirectory();
            boolean exists2 = file3.exists();
            if (exists && isDirectory && exists2) {
                long currentTimeMillis = System.currentTimeMillis();
                DexClassLoader dexClassLoader = new DexClassLoader(this.val$dexPath, this.val$optimizedDirectory, this.val$libraryPath, this.val$parent);
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                String.format("load_dex completed -- cl_cost: %d, existed: %b", new Object[]{Long.valueOf(currentTimeMillis), Boolean.valueOf(z)});
                if (DexClassLoaderProvider.access$100() && "tbs_jars_fusion_dex.jar".equals(this.val$dexName) && DexClassLoaderProvider.mService != null) {
                    DexClassLoaderProvider.mService.stopSelf();
                    return;
                }
                return;
            }
            new StringBuilder("dex loading exception(").append(exists).append(", ").append(isDirectory).append(", ").append(exists2).append(")");
        } catch (Throwable th) {
            new StringBuilder("@AsyncDexLoad task exception: ").append(th);
        }
    }
}
