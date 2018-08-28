package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.mapstructure.BlockRouteCityData;
import com.tencent.map.lib.util.ZipUtil;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class hm extends Thread implements ho {
    private long a = 0;
    private hv b;
    private jg c;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private List<Integer> g;

    public hm(hv hvVar, jg jgVar) {
        this.b = hvVar;
        this.c = jgVar;
    }

    public void a(boolean z) {
        if (this.b != null) {
            this.b.c(z);
            this.d = z;
            if (z) {
                try {
                    start();
                } catch (Exception e) {
                }
            }
            this.b.x();
        }
    }

    public boolean a() {
        return this.d;
    }

    public void b() {
        synchronized (this) {
            notify();
        }
    }

    public void c() {
        this.e = false;
        synchronized (this) {
            notify();
        }
    }

    public void d() {
        this.e = true;
        synchronized (this) {
            notify();
        }
    }

    public void e() {
        this.f = true;
        this.e = true;
        this.d = false;
        synchronized (this) {
            notify();
        }
        interrupt();
    }

    public void run() {
        super.run();
        while (!this.f) {
            if (!this.e && this.d) {
                f();
            }
            synchronized (this) {
                try {
                    wait(300000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    private void f() {
        if (this.b != null && this.b.a() != null && this.b.a().y() != null && this.b.a().m() >= 11) {
            ht a = this.b.a();
            List a2 = this.b.a(a.y(), a.m());
            if (a2 != null && a2.size() != 0) {
                a(a2);
            }
        }
    }

    private void a(List<Integer> list) {
        if (this.c != null) {
            List arrayList = new ArrayList();
            boolean b = b(list);
            if (b || System.currentTimeMillis() - this.a >= 300000) {
                Object obj = null;
                this.g = list;
                int size = list.size() - 1;
                while (size >= 0) {
                    Object obj2;
                    int intValue = ((Integer) list.get(size)).intValue();
                    String num = Integer.toString(intValue);
                    File a = a(num);
                    String a2 = a(num, a);
                    int i;
                    if (a == null || System.currentTimeMillis() - a.lastModified() >= 300000) {
                        Object a3 = this.c.a(a(num, a2));
                        if (a3 != null && a3.length >= 10) {
                            if (a3[4] == (byte) 0) {
                                i = 0;
                                try {
                                    i = Integer.parseInt(a2);
                                } catch (Exception e) {
                                }
                                arrayList.add(new BlockRouteCityData(intValue, i));
                                a.setLastModified(System.currentTimeMillis());
                                obj2 = obj;
                            } else {
                                byte[] bArr = new byte[4];
                                System.arraycopy(a3, 0, bArr, 0, 4);
                                int a4 = (int) a(bArr);
                                System.arraycopy(a3, 5, bArr, 0, 4);
                                int a5 = (int) a(bArr);
                                if (a(a4, a5, a3)) {
                                    b(num, a2);
                                    arrayList.add(new BlockRouteCityData(a4, a5));
                                    obj2 = 1;
                                } else {
                                    i = 0;
                                    try {
                                        i = Integer.parseInt(a2);
                                    } catch (Exception e2) {
                                    }
                                    arrayList.add(new BlockRouteCityData(intValue, i));
                                }
                            }
                        }
                        obj2 = obj;
                    } else {
                        i = 0;
                        try {
                            i = Integer.parseInt(a2);
                        } catch (Exception e3) {
                        }
                        arrayList.add(new BlockRouteCityData(intValue, i));
                        obj2 = obj;
                    }
                    size--;
                    obj = obj2;
                }
                if (b || obj != null) {
                    this.b.a(arrayList);
                    this.b.x();
                }
                this.a = System.currentTimeMillis();
            }
        }
    }

    private boolean b(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        if (this.g == null) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!this.g.contains(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    private String a(String str, String str2) {
        if (this.b == null || this.b.B() == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.B());
        stringBuilder.append("&citycode=" + str);
        stringBuilder.append("&version=" + str2);
        return stringBuilder.toString();
    }

    private String a(String str, File file) {
        if (file == null) {
            return "0";
        }
        String[] split = file.getName().split("_|\\.");
        if (split.length <= 1 || !str.equals(split[0])) {
            return "0";
        }
        return split[1];
    }

    private File a(String str) {
        File g = g();
        if (g == null) {
            return null;
        }
        try {
            File[] listFiles = g.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return null;
            }
            for (int i = 0; i < listFiles.length; i++) {
                String[] split = listFiles[i].getName().split("_|\\.");
                if (split.length > 1 && str.equals(split[0])) {
                    return listFiles[i];
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private File g() {
        if (this.b == null || this.b.F() == null) {
            return null;
        }
        String e = this.b.F().e();
        if (e == null) {
            return null;
        }
        File file = new File(e);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e2) {
                return null;
            }
        }
        return file;
    }

    private long a(byte[] bArr) {
        return (long) ((((bArr[0] & b.CTRL_BYTE) | ((bArr[1] << 8) & 65280)) | ((bArr[2] << 16) & 16711680)) | ((bArr[3] << 24) & -16777216));
    }

    private boolean a(int i, int i2, byte[] bArr) {
        Throwable th;
        if (bArr == null || bArr.length < 10) {
            return false;
        }
        File g = g();
        if (g == null) {
            return false;
        }
        File file = new File(g.getAbsolutePath() + File.separator + c(Integer.toString(i), Integer.toString(i2)));
        if (file.exists() && !file.delete()) {
            file.deleteOnExit();
        }
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = null;
            FileOutputStream fileOutputStream2;
            try {
                byte[] inflate = ZipUtil.inflate(bArr, 10, bArr.length - 10);
                if (inflate == null) {
                    return false;
                }
                fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(inflate);
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e) {
                    }
                    return true;
                } catch (FileNotFoundException e2) {
                    if (fileOutputStream2 != null) {
                        return false;
                    }
                    try {
                        fileOutputStream2.close();
                        return false;
                    } catch (IOException e3) {
                        return false;
                    }
                } catch (IOException e4) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e5) {
                        return false;
                    }
                } catch (Exception e6) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e7) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e9) {
                fileOutputStream2 = null;
                if (fileOutputStream2 != null) {
                    return false;
                }
                try {
                    fileOutputStream2.close();
                    return false;
                } catch (IOException e32) {
                    return false;
                }
            } catch (IOException e10) {
                if (fileOutputStream != null) {
                    return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                } catch (IOException e52) {
                    return false;
                }
            } catch (Exception e11) {
                if (fileOutputStream != null) {
                    return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                } catch (IOException e72) {
                    return false;
                }
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e82) {
                    }
                }
                throw th;
            }
        } catch (IOException e12) {
            return false;
        }
    }

    private void b(String str, String str2) {
        File g = g();
        if (g != null) {
            File file = new File(g.getAbsolutePath() + File.separator + c(str, str2));
            if (file.exists() && !file.delete()) {
                file.deleteOnExit();
            }
        }
    }

    private String c(String str, String str2) {
        return str + "_" + str2 + ".kml";
    }
}
