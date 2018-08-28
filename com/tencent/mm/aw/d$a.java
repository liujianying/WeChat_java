package com.tencent.mm.aw;

import com.tencent.mm.a.e;
import com.tencent.mm.ar.n;
import com.tencent.mm.ar.r;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class d$a {
    public List<String> ehA = null;
    public String ehp = "BeiJing;GuangZhou;ShangHai;";
    public int ehq = 0;
    public int ehr = 2;
    public int ehs = 2;
    public int eht = 2;
    public int ehu = 10240;
    public int ehv = 10240000;
    public int ehw = 100;
    public int ehx = 100;
    public int ehy = 100;
    public Random ehz = new Random();
    public int sex = 0;

    public final boolean RM() {
        ab Hl = q.Hl();
        x.d("upload", new StringBuilder("  getRegionCode ").append(Hl).toString() != null ? Hl.csQ : "");
        String str = Hl.csQ;
        if (str == null || str.length() <= 0 || this.ehA == null || this.ehA.size() <= 0) {
            return false;
        }
        String[] split = str.split("_");
        if (split == null || split.length <= 0) {
            return false;
        }
        int i = 0;
        while (i < split.length) {
            if (split[i] != null && split[i].length() > 0) {
                for (String str2 : this.ehA) {
                    if (str2.trim().toLowerCase().equals(split[i].trim().toLowerCase())) {
                        x.d("upload", "isInRegion");
                        return true;
                    }
                }
                continue;
            }
            i++;
        }
        return false;
    }

    public final int RN() {
        switch (d.chatType) {
            case 0:
                return this.ehr;
            case 1:
                return this.ehs;
            case 2:
                return this.eht;
            default:
                return this.ehr;
        }
    }

    public final int RO() {
        switch (d.chatType) {
            case 0:
                return this.ehw;
            case 1:
                return this.ehx;
            case 2:
                return this.ehy;
            default:
                return this.ehw;
        }
    }

    public static d$a RP() {
        x.d("upload", "parseFromFile");
        String str = n.Qm() + r.Qp().bk(1, 9);
        int cm = e.cm(str);
        if (cm == -1) {
            x.e("upload", "read file failed " + cm + str);
            return null;
        }
        byte[] e = e.e(str, 0, cm);
        if (e == null) {
            x.e("upload", "read file failed " + cm + str);
            return null;
        }
        str = new String(e);
        if (bi.oW(str)) {
            return null;
        }
        String substring;
        cm = str.indexOf(60);
        if (cm > 0) {
            substring = str.substring(cm);
        } else {
            substring = str;
        }
        int hashCode = substring.hashCode();
        d$a d_a = (d$a) d.RL().get(Integer.valueOf(hashCode));
        if (d_a != null) {
            return d_a;
        }
        Map z = bl.z(substring, "Config");
        if (z == null) {
            x.e("upload", "parse msg failed");
            return null;
        }
        try {
            d$a d_a2 = new d$a();
            int i = 0;
            while (true) {
                str = (String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i)) + ".$key");
                x.d("upload", "key " + str);
                if (str != null) {
                    StringBuilder stringBuilder;
                    Object obj;
                    if (str.equals("region")) {
                        d_a2.ehp = (String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i)));
                        if (d_a2.ehp != null && d_a2.ehp.length() > 0) {
                            String[] split = d_a2.ehp.split(";");
                            d_a2.ehA = new ArrayList();
                            if (split != null && split.length > 0) {
                                int i2 = 0;
                                while (i2 < split.length) {
                                    if (split[i2] != null && split[i2].length() > 0) {
                                        d_a2.ehA.add(split[i2]);
                                    }
                                    i2++;
                                }
                            }
                        }
                    } else if (str.equals("sex")) {
                        stringBuilder = new StringBuilder(".Config.Item");
                        if (i == 0) {
                            obj = "";
                        } else {
                            obj = Integer.valueOf(i);
                        }
                        d_a2.sex = bi.getInt((String) z.get(stringBuilder.append(obj).toString()), 0);
                    } else if (str.equals("rate")) {
                        stringBuilder = new StringBuilder(".Config.Item");
                        if (i == 0) {
                            obj = "";
                        } else {
                            obj = Integer.valueOf(i);
                        }
                        d_a2.ehq = bi.getInt((String) z.get(stringBuilder.append(obj).toString()), 0);
                    } else if (str.equals("minsize")) {
                        d_a2.ehu = bi.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    } else if (str.equals("maxsize")) {
                        d_a2.ehv = bi.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    } else if (str.equals("daycount_single")) {
                        d_a2.ehw = bi.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    } else if (str.equals("daycount_chatroom")) {
                        d_a2.ehx = bi.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    } else if (str.equals("daycount_app")) {
                        d_a2.ehy = bi.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    } else if (str.equals("rate_single")) {
                        d_a2.ehr = bi.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    } else if (str.equals("rate_chatroom")) {
                        d_a2.ehs = bi.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    } else if (str.equals("rate_app")) {
                        d_a2.eht = bi.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    }
                    i++;
                } else {
                    x.d("upload", "sex " + d_a2.sex);
                    x.d("upload", "rate_single " + d_a2.ehr);
                    x.d("upload", "rate_chatroom " + d_a2.ehs);
                    x.d("upload", "rate_app " + d_a2.eht);
                    x.d("upload", "rate " + d_a2.ehq);
                    x.d("upload", "minsize " + d_a2.ehu);
                    x.d("upload", "maxsize " + d_a2.ehv);
                    x.d("upload", "daycount_single " + d_a2.ehw);
                    x.d("upload", "daycount_chatroom " + d_a2.ehx);
                    x.d("upload", "daycount_app " + d_a2.ehy);
                    x.d("upload", "region " + d_a2.ehp);
                    d.RL().m(Integer.valueOf(hashCode), d_a2);
                    return d_a2;
                }
            }
        } catch (Throwable e2) {
            x.e("upload", "exception:%s", new Object[]{bi.i(e2)});
            return null;
        }
    }
}
