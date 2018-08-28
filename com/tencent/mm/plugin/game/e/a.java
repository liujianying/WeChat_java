package com.tencent.mm.plugin.game.e;

import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private Map<String, com.tencent.mm.plugin.game.ui.GameRegionPreference.a> kbB;
    public boolean kdd;
    private Map<String, Boolean> kde;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.kdd = false;
        this.kde = new ConcurrentHashMap();
    }

    public final synchronized void clearCache() {
        if (this.kbB != null) {
            this.kbB.clear();
        }
        this.kdd = false;
    }

    public final synchronized void aVe() {
        if (this.kbB != null) {
            for (com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar : this.kbB.values()) {
                aVar.eQK = false;
            }
        }
    }

    public final synchronized void aVf() {
        if (this.kbB == null) {
            this.kbB = new LinkedHashMap();
        }
        if (this.kbB.size() <= 0) {
            String str;
            InputStream inputStream = null;
            String str2 = "";
            try {
                inputStream = ad.getContext().getAssets().open("game_region_data.txt");
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                str = new String(bArr);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e) {
                        x.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[]{bi.i(e)});
                    }
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[]{bi.i(e2)});
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        str = str2;
                    } catch (Throwable e22) {
                        x.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[]{bi.i(e22)});
                        str = str2;
                    }
                } else {
                    str = str2;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3) {
                        x.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[]{bi.i(e3)});
                    }
                }
            }
            String[] split = str.trim().split("\n|\r\n|\r");
            for (String trim : split) {
                String[] split2 = trim.trim().split("\\|");
                if (split2.length < 4) {
                    x.e("MicroMsg.GameCacheUtil", "this GameRegion item has problem %s", new Object[]{split[r0]});
                } else {
                    com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar = new com.tencent.mm.plugin.game.ui.GameRegionPreference.a();
                    aVar.kby = split2[0];
                    aVar.kbz = split2[1];
                    aVar.kbA = split2[2];
                    aVar.csQ = split2[3];
                    aVar.eQK = false;
                    aVar.isDefault = false;
                    this.kbB.put(aVar.csQ, aVar);
                }
            }
            com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar2 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) this.kbB.get(f.aTA());
            if (aVar2 != null) {
                aVar2.kby = f.aTB();
                aVar2.kbz = f.aTC();
                aVar2.kbA = f.aTD();
                aVar2.isDefault = true;
            }
        }
    }

    public final synchronized Map<String, com.tencent.mm.plugin.game.ui.GameRegionPreference.a> aVg() {
        aVf();
        return this.kbB;
    }

    public final synchronized boolean DN(String str) {
        boolean z;
        if (bi.oW(str)) {
            z = false;
        } else if (this.kde.containsKey(str) && ((Boolean) this.kde.get(str)).booleanValue()) {
            z = false;
        } else {
            x.i("MicroMsg.GameCacheUtil", "download entrance image start : %s", new Object[]{str});
            this.kde.put(str, Boolean.valueOf(true));
            z = true;
        }
        return z;
    }

    public final synchronized void DO(String str) {
        if (!bi.oW(str) && this.kde.containsKey(str)) {
            x.i("MicroMsg.GameCacheUtil", "download entrance image finish : %s", new Object[]{str});
            this.kde.remove(str);
        }
    }
}
