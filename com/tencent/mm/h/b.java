package com.tencent.mm.h;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b {
    public a cZN;
    public Map<Integer, Long> cZO = new HashMap();
    public Map<Long, a> cZP = new HashMap();
    public c cZQ = new 1(this);

    final boolean a(ah ahVar) {
        String str = ahVar.bHy.bHA;
        String str2 = "MicroMsg.BroadcastController";
        String str3 = "summerdiz handleNewDisaster xml len[%d]";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(str == null ? -1 : str.length());
        x.i(str2, str3, objArr);
        Map z = bl.z(str, "e");
        if (z == null) {
            x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster this is not errmsg");
            return false;
        }
        x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster values[%s]", new Object[]{z});
        long j = bi.getLong((String) z.get(".e.NoticeId"), 0);
        if (j <= 0) {
            x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeID null");
        }
        if (!af.eyn) {
            try {
                if (bi.bG(bi.getLong((String) z.get(".e.ExpiredTime"), 0)) > 0) {
                    x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster expiredTime is too small, drop id:%d", new Object[]{Long.valueOf(bi.getLong((String) z.get(".e.ExpiredTime"), 0))});
                    return false;
                }
            } catch (Exception e) {
                x.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[]{e});
            }
        }
        a aVar = new a();
        aVar.cZU = String.valueOf(j);
        String string = ad.getContext().getSharedPreferences("disaster_pref", 4).getString("disaster_noticeid_list_key", "");
        if (af.eyo || !string.contains(aVar.cZU)) {
            a aVar2;
            if (this.cZP.size() > 0) {
                a aVar3 = (a) this.cZP.get(Long.valueOf(j));
                if (aVar3 != null) {
                    x.i("MicroMsg.BroadcastController", "summerdiz  handleNewDisaster found info in map[%s]", new Object[]{aVar3});
                    aVar2 = aVar3;
                } else {
                    this.cZP.put(Long.valueOf(j), aVar);
                    aVar2 = aVar;
                }
            } else {
                this.cZP.put(Long.valueOf(j), aVar);
                aVar2 = aVar;
            }
            string = (String) z.get(".e.Position");
            if (bi.oW(string)) {
                x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr is null!");
                return false;
            }
            ArrayList arrayList = new ArrayList();
            String[] split = string.split(",");
            if (split == null || split.length <= 0) {
                x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr id invaild!");
                return false;
            }
            Object obj = null;
            int length = split.length;
            int i = 0;
            while (i < length) {
                Object obj2;
                int i2 = bi.getInt(split[i], 0);
                if (i2 > 0) {
                    if (i2 == 1) {
                        obj2 = 1;
                        x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster found tonyTips[%d]", new Object[]{Integer.valueOf(i2)});
                        i++;
                        obj = obj2;
                    } else {
                        arrayList.add(Integer.valueOf(i2));
                    }
                }
                obj2 = obj;
                i++;
                obj = obj2;
            }
            if (obj == null && arrayList.size() == 0) {
                x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positions size is 0!");
                return false;
            }
            x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster curLang[%s]", new Object[]{w.fD(ad.getContext())});
            String str4 = null;
            String str5 = null;
            String str6 = null;
            int i3 = 0;
            while (true) {
                str2 = ".e.Item" + (i3 == 0 ? "" : Integer.valueOf(i3));
                string = (String) z.get(str2 + ".Language");
                if (string == null && i3 > 3) {
                    str = null;
                    string = null;
                    str2 = null;
                    break;
                } else if (r18.equalsIgnoreCase(string)) {
                    string = (String) z.get(str2 + ".Content");
                    str = (String) z.get(str2 + ".Url");
                    str2 = (String) z.get(str2 + ".Tips");
                    break;
                } else {
                    if ("en".equalsIgnoreCase(string)) {
                        string = (String) z.get(str2 + ".Content");
                        str = (String) z.get(str2 + ".Url");
                        str2 = (String) z.get(str2 + ".Tips");
                    } else {
                        str2 = str6;
                        str = str5;
                        string = str4;
                    }
                    i3++;
                    str6 = str2;
                    str5 = str;
                    str4 = string;
                }
            }
            x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster content[%s] tips[%s]", new Object[]{string, str2});
            if (bi.oW(string)) {
                x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster cann't hit curLang");
            } else {
                str5 = str;
                str4 = string;
                str6 = str2;
            }
            if (bi.oW(str5)) {
                str5 = ad.getContext().getString(R.l.disaster_default_url);
            }
            if (obj != null) {
                if (bi.oW(str4)) {
                    str4 = ad.getContext().getString(R.l.disaster_default_content_login);
                }
                if (bi.oW(str6)) {
                    str6 = ad.getContext().getString(R.l.disaster_default_tips_login);
                }
                ahVar.bHz.desc = str4;
                ahVar.bHz.bHB = 30;
                ahVar.bHz.showType = 0;
                ahVar.bHz.url = str5;
                ahVar.bHz.YN = true;
                ahVar.bHz.bHE = 0;
                ahVar.bHz.bHC = 6;
                ahVar.bHz.bHD = "";
                ahVar.bHz.bHF = String.valueOf(j);
                ahVar.bHz.position = 1;
            }
            if (arrayList.size() == 0) {
                x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
                return false;
            } else if (aVar2.cZV == 0 || bi.bI(aVar2.cZV) >= 1800000) {
                aVar2.cZV = bi.VG();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    Long valueOf = Long.valueOf(bi.a((Long) this.cZO.get(num), 0));
                    if (valueOf.longValue() <= 0 || valueOf.longValue() < j) {
                        ry ryVar;
                        ry ryVar2 = (ry) aVar2.cZX.get(num);
                        if (ryVar2 == null) {
                            ryVar2 = new ry();
                            ryVar2.ccN.showType = 0;
                            ryVar2.ccN.bHB = 30;
                            ryVar2.ccN.bHD = "";
                            ryVar2.ccN.bHE = R.i.mmnotify_view;
                            ryVar2.ccN.position = num.intValue();
                            aVar2.cZX.put(num, ryVar2);
                            ryVar = ryVar2;
                        } else {
                            ryVar = ryVar2;
                        }
                        if (bi.oW(str6)) {
                            str = str4;
                        } else {
                            str = str6;
                        }
                        if (bi.oW(str)) {
                            i = R.l.disaster_default_tips_default;
                            switch (num.intValue()) {
                                case 2:
                                    i = R.l.disaster_default_tips_moment;
                                    break;
                                case 3:
                                case 4:
                                    i = R.l.disaster_default_tips_chat;
                                    break;
                            }
                            str = ad.getContext().getString(i);
                        }
                        ryVar.ccN.desc = str;
                        ryVar.ccN.url = str5;
                        ryVar.ccN.YN = true;
                        ryVar.ccN.bHC = 2;
                        ryVar.ccN.bHF = aVar2.cZU;
                        this.cZO.put(num, Long.valueOf(j));
                        if (obj == null) {
                            ahVar.bHz.desc = str;
                            ahVar.bHz.bHB = 30;
                            ahVar.bHz.showType = 0;
                            ahVar.bHz.url = str5;
                            ahVar.bHz.YN = true;
                            ahVar.bHz.bHE = R.i.mmnotify_view;
                            ahVar.bHz.bHC = 2;
                            ahVar.bHz.bHD = "";
                            ahVar.bHz.bHF = String.valueOf(j);
                            ahVar.bHz.position = num.intValue();
                        }
                        com.tencent.mm.sdk.platformtools.ah.A(new 2(this, ryVar));
                        str6 = str;
                    } else {
                        x.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", new Object[]{num, valueOf, Long.valueOf(j)});
                    }
                }
                return true;
            } else {
                x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
                return false;
            }
        }
        x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", new Object[]{string, aVar.cZU});
        return false;
    }

    final boolean eW(String str) {
        x.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", new Object[]{this.cZN, str});
        if (bi.oW(str) || str.indexOf("<") < 0) {
            return false;
        }
        Map z = bl.z(str, "e");
        if (z == null) {
            x.e("MicroMsg.BroadcastController", "this is not errmsg");
            return false;
        }
        ry ryVar;
        if (this.cZN == null) {
            this.cZN = new a();
            ryVar = new ry();
            this.cZN.cZX.put(Integer.valueOf(0), ryVar);
            ryVar.ccN.desc = "";
            ryVar.ccN.url = "";
            ryVar.ccN.showType = 0;
            ryVar.ccN.bHB = 30;
            ryVar.ccN.YN = false;
            ryVar.ccN.bHD = "";
            ryVar.ccN.bHC = 0;
            ryVar.ccN.bHE = R.i.mmnotify_view;
            ryVar.ccN.bHF = "";
            ryVar.ccN.position = 0;
        }
        if (!af.eym) {
            if (this.cZN.cZV == 0 || bi.bI(this.cZN.cZV) >= 1800000) {
                this.cZN.cZV = bi.VG();
            } else {
                x.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
                return false;
            }
        }
        if (!af.eyn) {
            try {
                if (bi.bG(bi.getLong((String) z.get(".e.ExpiredTime"), 0)) > 0) {
                    x.i("MicroMsg.BroadcastController", "expiredTime is too small, drop id:%d", new Object[]{Long.valueOf(bi.getLong((String) z.get(".e.ExpiredTime"), 0))});
                    return false;
                }
            } catch (Exception e) {
                x.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[]{e});
            }
        }
        this.cZN.cZU = (String) z.get(".e.NoticeId");
        String string = ad.getContext().getSharedPreferences("disaster_pref", 4).getString("disaster_noticeid_list_key", "");
        if (af.eyo || !string.contains(this.cZN.cZU)) {
            String str2;
            String str3;
            String fD = w.fD(ad.getContext());
            String str4 = null;
            String str5 = null;
            String str6 = null;
            int i = 0;
            while (true) {
                str2 = ".e.Item" + (i == 0 ? "" : Integer.valueOf(i));
                string = (String) z.get(str2 + ".Language");
                if (string == null && i > 3) {
                    str3 = null;
                    string = null;
                    str2 = null;
                    break;
                } else if (fD.equalsIgnoreCase(string)) {
                    string = (String) z.get(str2 + ".Content");
                    str3 = (String) z.get(str2 + ".Url");
                    str2 = (String) z.get(str2 + ".Tips");
                    break;
                } else {
                    if ("en".equalsIgnoreCase(string)) {
                        string = (String) z.get(str2 + ".Content");
                        str3 = (String) z.get(str2 + ".Url");
                        str2 = (String) z.get(str2 + ".Tips");
                    } else {
                        str2 = str4;
                        str3 = str5;
                        string = str6;
                    }
                    i++;
                    str4 = str2;
                    str5 = str3;
                    str6 = string;
                }
            }
            if (bi.oW(string)) {
                x.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
            } else {
                str5 = str3;
                str6 = string;
                str4 = str2;
            }
            if (bi.oW(str5)) {
                str5 = ad.getContext().getString(R.l.disaster_default_url);
            }
            if (bi.oW(str6)) {
                x.i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
                str6 = ad.getContext().getString(R.l.disaster_default_content_default);
            }
            if (bi.oW(str4)) {
                if (bi.oW(str6)) {
                    str4 = ad.getContext().getString(R.l.disaster_default_tips_default);
                } else {
                    str4 = str6;
                }
            }
            ryVar = (ry) this.cZN.cZX.get(Integer.valueOf(0));
            ryVar.ccN.desc = str4;
            ryVar.ccN.url = str5;
            ryVar.ccN.YN = true;
            ryVar.ccN.bHC = 2;
            ryVar.ccN.bHF = this.cZN.cZU;
            com.tencent.mm.sdk.platformtools.ah.A(new 3(this, ryVar));
            this.cZN.cZW = str6;
            if (au.DF().foreground) {
                ym();
            }
            return true;
        }
        x.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", new Object[]{string, this.cZN.cZU});
        return false;
    }

    final void ym() {
        if (this.cZN != null && this.cZN.cZX.get(Integer.valueOf(0)) != null && !bi.oW(this.cZN.cZW)) {
            x.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", new Object[]{this.cZN.cZW});
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", this.cZN.cZW);
            intent.putExtra("key_disaster_url", ((ry) this.cZN.cZX.get(Integer.valueOf(0))).ccN.url);
            intent.setClass(ad.getContext(), DisasterUI.class).addFlags(268435456);
            ad.getContext().startActivity(intent);
            this.cZN.cZW = null;
        }
    }
}
