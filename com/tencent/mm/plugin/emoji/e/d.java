package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.regex.Pattern;

public class d {
    public static d ifo;
    public boolean ifp = false;
    private Pattern ifq = Pattern.compile("_\\d");

    public static d aDL() {
        if (ifo == null) {
            synchronized (d.class) {
                ifo = new d();
            }
        }
        return ifo;
    }

    public final void zg(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (this.ifp) {
                        if (file2.isDirectory()) {
                            zg(file2.getPath());
                        } else {
                            Object name = file2.getName();
                            if (this.ifq.matcher(name).find() || name.startsWith("temp")) {
                                file2.delete();
                            }
                        }
                        i++;
                    } else {
                        x.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
                        return;
                    }
                }
            }
        }
    }

    public final void zh(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        zh(file2.getPath());
                    } else {
                        file2.getName();
                        file2.delete();
                    }
                }
            }
        }
    }
}
