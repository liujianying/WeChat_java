package com.tencent.tencentmap.mapsdk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.hardcoder.HardCoderJNI;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class dz {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public fm f;

    public dz(fg fgVar) {
        this.a = fgVar.a;
        this.b = fgVar.b;
        this.c = fgVar.c;
        this.d = fgVar.d;
        this.e = fgVar.e;
        this.f = fgVar.f;
    }

    private void c() {
        if (this.a < 10000 || this.a > 30000) {
            this.a = HardCoderJNI.sHCENCODEVIDEOTIMEOUT;
        }
        if (this.b < 10000 || this.b > 30000) {
            this.b = HardCoderJNI.sHCENCODEVIDEOTIMEOUT;
        }
        if (this.c < 3 || this.c > 15) {
            this.c = 8;
        }
        if (this.d <= 0 || this.d > 5) {
            this.d = 2;
        }
        if (this.e < 5 || this.e > 240) {
            this.e = 60;
        }
    }

    public final void a() {
        fm fmVar = null;
        SharedPreferences sharedPreferences = em.a().getSharedPreferences("Access_Preferences", 0);
        this.a = sharedPreferences.getInt("connectTimeout", HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
        this.b = sharedPreferences.getInt("readTimeout", HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
        this.c = sharedPreferences.getInt("apnCachedNum", 8);
        this.d = sharedPreferences.getInt("parallelNum", 2);
        this.e = sharedPreferences.getInt("expireTime", 30);
        String string = sharedPreferences.getString("samplingInfo", null);
        if (string != null) {
            String[] split = string.split(";");
            fm fmVar2 = new fm();
            Map hashMap = new HashMap();
            for (int i = 0; i < split.length - 1; i++) {
                String[] split2 = split[i].split(",");
                hashMap.put(Integer.valueOf(Integer.parseInt(split2[0])), Byte.valueOf(Byte.parseByte(split2[1])));
            }
            fmVar2.a = hashMap;
            fmVar2.b = Byte.parseByte(split[split.length - 1]);
            fmVar = fmVar2;
        }
        this.f = fmVar;
        c();
    }

    public final void b() {
        String stringBuilder;
        SharedPreferences sharedPreferences = em.a().getSharedPreferences("Access_Preferences", 0);
        c();
        sharedPreferences.edit().putInt("connectTimeout", this.a).commit();
        sharedPreferences.edit().putInt("readTimeout", this.b).commit();
        sharedPreferences.edit().putInt("apnCachedNum", this.c).commit();
        sharedPreferences.edit().putInt("parallelNum", this.d).commit();
        sharedPreferences.edit().putInt("expireTime", this.e).commit();
        Editor edit = sharedPreferences.edit();
        String str = "samplingInfo";
        fm fmVar = this.f;
        StringBuilder stringBuilder2 = new StringBuilder();
        if (fmVar.a != null) {
            for (Entry entry : fmVar.a.entrySet()) {
                stringBuilder2.append(entry.getKey() + "," + entry.getValue() + ";");
            }
            stringBuilder2.append(fmVar.b);
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = null;
        }
        edit.putString(str, stringBuilder).commit();
    }

    public final String toString() {
        return "connectTimeout:" + this.a + ",readTimeout:" + this.b + ",apnCachedNum:" + this.c + ",parallelNum:" + this.d + ",expireTime:" + this.e;
    }
}
