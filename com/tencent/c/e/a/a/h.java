package com.tencent.c.e.a.a;

import android.content.Context;
import com.qq.taf.jce.JceInputStream;
import com.tencent.c.e.a.b.a;
import com.tencent.c.f.b;
import com.tencent.c.f.c;
import com.tencent.c.f.f;
import com.tencent.c.f.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h {
    private static final j<h> vjB = new j<h>() {
        protected final /* synthetic */ Object cEE() {
            return new h();
        }
    };
    public Context mContext;
    public boolean mInit = false;

    public static h cFs() {
        return (h) vjB.get();
    }

    public final void init(Context context) {
        this.mContext = context;
        this.mInit = true;
    }

    public final String fE(int i, int i2) {
        String fF = fF(i, i2);
        File dir = this.mContext.getDir("turingmm", 0);
        if (dir == null) {
            return "";
        }
        File[] listFiles = dir.listFiles();
        if (listFiles == null) {
            return "";
        }
        List<File> arrayList = new ArrayList();
        for (File file : listFiles) {
            if (file.getName().startsWith(fF)) {
                arrayList.add(file);
            }
        }
        if (arrayList.size() <= 2) {
            return "";
        }
        List arrayList2 = new ArrayList();
        for (File name : arrayList) {
            String[] split = name.getName().split("_");
            if (split.length == 2 && split[0].equals(fF)) {
                arrayList2.add(Long.valueOf(Long.parseLong(split[1])));
            }
        }
        if (arrayList2.size() <= 2) {
            return "";
        }
        Collections.sort(arrayList2);
        return dir.getAbsolutePath() + File.separator + fF + "_" + arrayList2.get(0);
    }

    public final Map<String, a> cFt() {
        Map hashMap = new HashMap();
        File dir = this.mContext.getDir("turingmm", 0);
        if (dir != null) {
            File[] listFiles = dir.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file = listFiles[i];
                    try {
                        Object obj;
                        byte[] k = c.k(f.Z(new File(file.getAbsolutePath())), c.k());
                        if (k == null) {
                            obj = null;
                        } else {
                            byte[] bM = b.bM(k);
                            if (bM == null) {
                                obj = null;
                            } else {
                                obj = new a();
                                obj.readFrom(new JceInputStream(bM));
                            }
                        }
                        if (obj == null) {
                            throw new NullPointerException("csGroupRecord is null.");
                        }
                        hashMap.put(file.getAbsolutePath(), obj);
                        i++;
                    } catch (Throwable th) {
                        file.deleteOnExit();
                    }
                }
            }
        }
        return hashMap;
    }

    public static a d(Map<String, a> map, int i) {
        if (map == null) {
            return null;
        }
        List arrayList = new ArrayList();
        a aVar = null;
        for (String str : map.keySet()) {
            a aVar2 = (a) map.get(str);
            if (aVar2 != null && aVar2.requestType == i) {
                arrayList.add(str);
                if (aVar == null) {
                    aVar = aVar2;
                } else {
                    aVar.vko.addAll(aVar2.vko);
                }
            }
        }
        if (aVar == null) {
            return null;
        }
        a aVar3 = new a((byte) 0);
        aVar3.vke = aVar;
        aVar3.vkf = arrayList;
        return aVar3;
    }

    public static String fF(int i, int i2) {
        return i + "00" + i2;
    }
}
