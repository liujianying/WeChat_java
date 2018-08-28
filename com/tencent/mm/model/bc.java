package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.model.a.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class bc {
    private static bc dBZ;
    public b dBY;

    public interface b {
        void Ij();
    }

    public static bc Ig() {
        synchronized (bc.class) {
            if (dBZ == null) {
                dBZ = new bc();
            }
        }
        return dBZ;
    }

    private bc() {
    }

    public final boolean a(bb bbVar) {
        boolean z = true;
        if (bbVar.type == 10000) {
            au.HU();
            SharedPreferences gh = c.gh("banner");
            if (gh != null) {
                gh.edit().clear().commit();
            }
            if (this.dBY == null) {
                return true;
            }
            this.dBY.Ij();
            return true;
        } else if (bbVar.type == 57005) {
            return false;
        } else {
            au.HU();
            SharedPreferences gh2 = c.gh("banner");
            if (gh2 == null) {
                return false;
            }
            Editor edit = gh2.edit();
            bb Ih = Ih();
            if (iz("HistoryInfo").contains(Integer.valueOf(bbVar.type))) {
                z = false;
            }
            if (Ih != null && Ih.showType == 2) {
                List iz = iz("HistoryInfo");
                if (!iz.contains(Integer.valueOf(Ih.type))) {
                    iz.add(Integer.valueOf(Ih.type));
                }
                c("HistoryInfo", iz);
            }
            if (z) {
                edit.putInt("CurrentType", bbVar.type).putInt("CurrentShowType", bbVar.showType).putString("CurrentData", bbVar.data).commit();
            }
            if (this.dBY == null) {
                return z;
            }
            this.dBY.Ij();
            return z;
        }
    }

    public static bb Ih() {
        au.HU();
        SharedPreferences gh = c.gh("banner");
        if (gh == null) {
            return null;
        }
        int i = gh.getInt("CurrentType", -1);
        int i2 = gh.getInt("CurrentShowType", -1);
        String string = gh.getString("CurrentData", "");
        if (i == -1) {
            return null;
        }
        switch (i) {
            case 1:
                int Ii = Ii();
                if (Ii == a.dCc || Ii == a.dCd || g.IW().IU()) {
                    if (g.IW().IU()) {
                        x.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind bind contacts banner.");
                        return null;
                    }
                    x.i("MicorMsg.MainFrameBannerStorage", "already Bind the Mobile");
                    return null;
                }
            case 2:
                if (Ii() == a.dCc || g.IW().IU()) {
                    if (g.IW().IU()) {
                        x.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind upload contacts banner.");
                        return null;
                    }
                    x.i("MicorMsg.MainFrameBannerStorage", "already upload the contacts");
                    return null;
                }
            case 3:
                x.i("MicorMsg.MainFrameBannerStorage", "avatar already existed");
                return null;
            case 11:
            case 10000:
            case 57005:
                return null;
        }
        return new bb(i, i2, string);
    }

    public final void ba(int i, int i2) {
        au.HU();
        SharedPreferences gh = c.gh("banner");
        if (gh != null) {
            Editor edit = gh.edit();
            switch (i2) {
                case 1:
                    edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                    break;
                case 2:
                    edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                    List iz = iz("HistoryInfo");
                    if (!iz.contains(Integer.valueOf(i))) {
                        iz.add(Integer.valueOf(i));
                    }
                    c("HistoryInfo", iz);
                    break;
                case 3:
                    if (i == 3) {
                        edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                        break;
                    }
                    break;
            }
            if (this.dBY != null) {
                this.dBY.Ij();
            }
        }
    }

    private static boolean c(String str, List<Integer> list) {
        boolean z = false;
        au.HU();
        SharedPreferences gh = c.gh("banner");
        if (gh == null) {
            return false;
        }
        Editor edit = gh.edit();
        edit.putInt(str + "ArraySize", list.size());
        while (true) {
            boolean z2 = z;
            if (z2 >= list.size()) {
                return edit.commit();
            }
            edit.putInt(str + z2, ((Integer) list.get(z2)).intValue());
            z = z2 + 1;
        }
    }

    private static List<Integer> iz(String str) {
        au.HU();
        SharedPreferences gh = c.gh("banner");
        if (gh == null) {
            return null;
        }
        int i = gh.getInt(str + "ArraySize", 0);
        List<Integer> arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Integer.valueOf(gh.getInt(str + i2, 0)));
        }
        return arrayList;
    }

    public static int Ii() {
        try {
            au.HU();
            String str = (String) c.DT().get(4097, "");
            au.HU();
            String str2 = (String) c.DT().get(6, "");
            boolean Hi = q.Hi();
            x.d("MicorMsg.MainFrameBannerStorage", "isUpload " + Hi + " stat " + q.GJ());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && str2 == null) {
                return a.dCa;
            }
            if (str != null && str2 == null) {
                return a.dCb;
            }
            if (Hi) {
                return a.dCc;
            }
            return a.dCd;
        } catch (Exception e) {
            return a.dCa;
        }
    }
}
