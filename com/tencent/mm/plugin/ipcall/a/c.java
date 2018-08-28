package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.ipcall.a.g.i;
import com.tencent.mm.plugin.ipcall.a.g.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static c koi;
    public boolean huc = false;
    private ArrayList<Integer> koj = new ArrayList();
    ArrayList<Integer> kok = new ArrayList();

    private c() {
    }

    public static c aXb() {
        if (koi == null) {
            koi = new c();
        }
        return koi;
    }

    public final void fM(boolean z) {
        Throwable e;
        InputStream inputStream = null;
        if (!this.huc || z) {
            aXd();
            try {
                File file = new File(e.duN + "ipcallCountryCodeConfig.cfg");
                String str;
                if (file.exists()) {
                    InputStream fileInputStream = new FileInputStream(file);
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                        str = "";
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                str = str + readLine;
                            } else {
                                x.d("MicroMsg.IPCallCountryCodeConfig", "config file content: %s", new Object[]{str});
                                EM(str);
                                this.huc = true;
                                com.tencent.mm.a.e.f(fileInputStream);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = fileInputStream;
                        try {
                            x.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                            x.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", new Object[]{e.getMessage()});
                            com.tencent.mm.a.e.f(inputStream);
                        } catch (Throwable th) {
                            e = th;
                            com.tencent.mm.a.e.f(inputStream);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream = fileInputStream;
                        com.tencent.mm.a.e.f(inputStream);
                        throw e;
                    }
                }
                x.d("MicroMsg.IPCallCountryCodeConfig", "initConfig, file: %s not exist!", new Object[]{str});
                this.huc = true;
                com.tencent.mm.a.e.f(null);
            } catch (Exception e3) {
                e = e3;
                x.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                x.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", new Object[]{e.getMessage()});
                com.tencent.mm.a.e.f(inputStream);
            }
        }
    }

    private void EM(String str) {
        if (!bi.oW(str)) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("restriction");
                x.d("MicroMsg.IPCallCountryCodeConfig", "restrictionCountryCode: %d", new Object[]{Integer.valueOf(jSONArray.length())});
                this.kok.clear();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.kok.add(Integer.valueOf(jSONArray.getInt(i)));
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                x.e("MicroMsg.IPCallCountryCodeConfig", "initConfigFromContent error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private void aXc() {
        this.koj.clear();
        String value = g.AT().getValue("WeChatOutTopCountryCode");
        x.d("MicroMsg.IPCallCountryCodeConfig", "popularCountryConfig: %s", new Object[]{value});
        if (!bi.oW(value)) {
            String[] split = value.trim().split(",");
            int length = split.length;
            try {
                for (String str : split) {
                    Integer valueOf = Integer.valueOf(bi.getInt(str, 0));
                    this.koj.add(valueOf);
                    i.aXx().y(valueOf.intValue(), (long) length);
                    length--;
                }
            } catch (NumberFormatException e) {
                x.e("MicroMsg.IPCallCountryCodeConfig", "initPopularCountryFromDynamicConfig error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final void aXd() {
        j aXx = i.aXx();
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ORDER BY IPCallPopularCountry.callTimeCount DESC,IPCallPopularCountry.lastCallTime DESC");
        Cursor b = aXx.diF.b("SELECT IPCallPopularCountry.countryCode,IPCallPopularCountry.callTimeCount,IPCallPopularCountry.lastCallTime FROM IPCallPopularCountry  " + stringBuilder.toString(), null, 2);
        if (b == null || !b.moveToFirst()) {
            if (b != null) {
                b.close();
            }
            if (arrayList.size() <= 0) {
                this.koj = arrayList;
            } else {
                aXc();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        do {
            i iVar = new i();
            iVar.d(b);
            arrayList.add(Integer.valueOf(iVar.field_countryCode));
        } while (b.moveToNext());
        if (b != null) {
            b.close();
        }
        if (arrayList.size() <= 0) {
            aXc();
        } else {
            this.koj = arrayList;
        }
    }

    public final List<Integer> aXe() {
        if (!this.huc) {
            fM(false);
        }
        return this.koj;
    }

    public final boolean ru(int i) {
        if (!this.huc) {
            fM(false);
        }
        if (this.kok == null || this.kok.size() <= 0) {
            return false;
        }
        return this.kok.contains(Integer.valueOf(i));
    }
}
