package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.c.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$b extends a {
    private String filePath;
    private long fileSize;
    final /* synthetic */ c hRa;
    int hRb = 0;

    public c$b(c cVar, String str) {
        this.hRa = cVar;
        super(cVar);
        this.filePath = str;
        this.fileSize = 0;
    }

    public final String SR() {
        return "filePath[" + this.filePath + "] scanCount[" + this.hRb + "]" + super.SR();
    }

    public final void execute() {
        String str;
        int[] l;
        if (yy(this.filePath) && c.k(this.hRa)) {
            x.i("MicroMsg.CleanController", "Delete[%b] temp folder: %s ", new Object[]{Boolean.valueOf(c.k(this.hRa)), this.filePath});
            deleteFile(this.filePath);
            File parentFile = new File(this.filePath).getParentFile();
            if (parentFile.list() == null || parentFile.list().length == 0) {
                parentFile.delete();
            }
        } else {
            yz(this.filePath);
        }
        if (c.a(this.hRa, this.filePath)) {
            c.a(this.hRa, c.d(this.hRa) + this.fileSize);
        } else {
            str = this.filePath;
            au.HU();
            if (str.startsWith(c.Gq())) {
                c.b(this.hRa, c.c(this.hRa) + this.fileSize);
            }
        }
        if (yy(this.filePath)) {
            l = c.l(this.hRa);
            l[1] = (int) (((long) l[1]) + this.fileSize);
        } else {
            str = this.filePath;
            au.HU();
            if (str.startsWith(c.Gq())) {
                l = c.l(this.hRa);
                l[0] = (int) (((long) l[0]) + this.fileSize);
            } else {
                l = c.l(this.hRa);
                l[2] = (int) (((long) l[2]) + this.fileSize);
            }
        }
        if (this.filePath.endsWith(File.separator + "image2")) {
            l = c.l(this.hRa);
            l[3] = (int) (((long) l[3]) + this.fileSize);
        }
        if (this.filePath.endsWith(File.separator + "image")) {
            l = c.l(this.hRa);
            l[4] = (int) (((long) l[4]) + this.fileSize);
        }
        if (this.filePath.endsWith(File.separator + "video")) {
            l = c.l(this.hRa);
            l[5] = (int) (((long) l[5]) + this.fileSize);
        }
        if (this.filePath.endsWith(File.separator + "voice2")) {
            l = c.l(this.hRa);
            l[6] = (int) (((long) l[6]) + this.fileSize);
        }
        if (this.filePath.endsWith(File.separator + "WeiXin")) {
            l = c.l(this.hRa);
            l[7] = (int) (((long) l[7]) + this.fileSize);
        }
        if (this.filePath.endsWith(File.separator + "WeChat")) {
            l = c.l(this.hRa);
            l[8] = (int) (((long) l[8]) + this.fileSize);
        }
        if (this.filePath.endsWith(File.separator + "xlog")) {
            l = c.l(this.hRa);
            l[9] = (int) (((long) l[9]) + this.fileSize);
        }
    }

    private void deleteFile(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str2 : list) {
                    deleteFile(str + File.separator + str2);
                }
            }
            x.v("MicroMsg.CleanController", "delete file rootFile: %s", new Object[]{str});
            file.delete();
            return;
        }
        x.v("MicroMsg.CleanController", "delete file rootFile: %s", new Object[]{str});
        c.c(this.hRa, c.a(this.hRa) + file.length());
        file.delete();
    }

    private static boolean yy(String str) {
        if (str.length() <= c.aBd() || str.substring(c.aBd()).indexOf("temp") != 0) {
            return false;
        }
        return true;
    }

    private void yz(String str) {
        int i = 0;
        this.hRb++;
        if (str.endsWith(File.separator + "sns")) {
            x.i("MicroMsg.CleanController", "Scan sns folder: rootPath=%s", new Object[]{str});
            yA(str);
        } else if (str.endsWith(File.separator + "music")) {
            x.i("MicroMsg.CleanController", "Scan music folder: rootPath=%s", new Object[]{str});
            yB(str);
        } else {
            File file = new File(str);
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    int length = list.length;
                    while (i < length) {
                        yz(str + "/" + list[i]);
                        i++;
                    }
                    return;
                }
                return;
            }
            i = e.cm(str);
            c.d(this.hRa, (long) i);
            this.fileSize = ((long) i) + this.fileSize;
        }
    }

    private void yA(String str) {
        int i = 0;
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    yA(str + "/" + list[i]);
                    i++;
                }
            }
        } else if (System.currentTimeMillis() - file.lastModified() <= c.aBe().longValue() || !c.k(this.hRa)) {
            i = e.cm(str);
            c.d(this.hRa, (long) i);
            this.fileSize = ((long) i) + this.fileSize;
        } else {
            x.v("MicroMsg.CleanController", "Clean 7 days file in sns rootPath=%s", new Object[]{str});
            file.delete();
        }
    }

    private void yB(String str) {
        int i = 0;
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    yB(str + "/" + list[i]);
                    i++;
                }
            }
        } else if (System.currentTimeMillis() - file.lastModified() <= c.aBf().longValue() || !c.k(this.hRa)) {
            i = e.cm(str);
            c.d(this.hRa, (long) i);
            this.fileSize = ((long) i) + this.fileSize;
        } else {
            x.v("MicroMsg.CleanController", "Clean 90 days file in music rootPath=%s", new Object[]{str});
            file.delete();
        }
    }
}
