package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.google.a.a.e;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.t;
import com.tencent.pb.common.c.c;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TalkRoom extends MultiTalkGroup {
    at vwX;
    Map<String, d> vwY = new ConcurrentHashMap();

    public static TalkRoom a(String str, String str2, Integer num, int i, long j, at atVar, av[] avVarArr, aw[] awVarArr) {
        c.d("tagorewang:TalkRoom:create", new Object[]{"create groupId: ", str, " tmpId: ", str2});
        TalkRoom talkRoom = new TalkRoom(str, num, atVar);
        talkRoom.ade(str2);
        Io(i);
        gX(j);
        int length = avVarArr == null ? 0 : avVarArr.length;
        int length2 = awVarArr == null ? 0 : awVarArr.length;
        for (int i2 = 0; i2 != length; i2++) {
            av avVar = avVarArr[i2];
            if (avVar == null) {
                c.x("tagorewang:TalkRoom:create", new Object[]{"null member info, index: ", Integer.valueOf(i2)});
            } else {
                aw awVar = null;
                for (int i3 = 0; i3 != length2; i3++) {
                    awVar = awVarArr[i3];
                    if (awVar != null && awVar.qXJ == avVar.qXJ) {
                        c.d("tagorewang:TalkRoom:create", new Object[]{"member info: ", avVar, " profile: ", awVar});
                        break;
                    }
                    awVar = null;
                }
                talkRoom.a(new d(avVar, awVar));
            }
        }
        c.d("tagorewang:TalkRoom:create", new Object[]{"did create"});
        return talkRoom;
    }

    public static TalkRoom a(TalkRoom talkRoom, String str, String str2, Integer num, int i, long j, at atVar, av[] avVarArr, aw[] awVarArr) {
        if (talkRoom == null) {
            c.x("tagorewang:TalkRoom:update", new Object[]{"updateAll null"});
            return null;
        }
        c.d("tagorewang:TalkRoom:update", new Object[]{"updateAll groupId: ", str, " tmpId: ", str2});
        talkRoom.b(str, num);
        talkRoom.ade(str2);
        Io(i);
        gX(j);
        talkRoom.b(atVar);
        int length = avVarArr == null ? 0 : avVarArr.length;
        int length2 = awVarArr == null ? 0 : awVarArr.length;
        if (length == 0 && length2 == 0) {
            c.x("tagorewang:TalkRoom:update", new Object[]{"updateAll null VoiceGroupMem or VoiceGroupUsrProfile array."});
            return talkRoom;
        }
        Set<String> hashSet = new HashSet(talkRoom.vwY.keySet());
        hashSet.remove(a.cEG());
        for (int i2 = 0; i2 != length; i2++) {
            av avVar = avVarArr[i2];
            if (avVar == null) {
                c.x("tagorewang:TalkRoom:update", new Object[]{"null member info, index: ", Integer.valueOf(i2)});
            } else {
                d adf = talkRoom.adf(avVar.vez);
                if (adf == null) {
                    c.d("tagorewang:TalkRoom:update", new Object[]{"add new member"});
                    adf = new d(avVar);
                    talkRoom.a(adf);
                } else {
                    adf.a(avVar);
                }
                hashSet.remove(adf.cHI());
            }
        }
        for (String str3 : hashSet) {
            c.d("tagorewang:TalkRoom:update", new Object[]{"keyset", str3});
            c.d("tagorewang:TalkRoom", new Object[]{"remove", talkRoom.vwY.remove(str3)});
        }
        if (hashSet.size() > 0) {
            c.x("tagorewang:TalkRoom:update", new Object[]{"updateAll not update uuid keyset.size(): ", Integer.valueOf(hashSet.size())});
        }
        c.d("tagorewang:TalkRoom:update", new Object[]{"did updateAll"});
        return talkRoom;
    }

    public TalkRoom(String str, Integer num, at atVar) {
        b(str, num);
        b(atVar);
    }

    public static boolean cHw() {
        return false;
    }

    private void ade(String str) {
        if (j.ads(str)) {
            this.vgn = str;
        }
    }

    public final int cHx() {
        return this.vcc == 0 ? 0 : this.vcc;
    }

    private void b(String str, Integer num) {
        if (!TextUtils.isEmpty(str)) {
            if (j.ads(str)) {
                this.vgn = str;
            } else {
                this.vgm = str;
            }
            if (num != null) {
                this.vcc = num.intValue();
            }
        }
    }

    public static int cHy() {
        return j.cIc();
    }

    private static void Io(int i) {
        c.d("tagorewang:TalkRoom", new Object[]{"setRoomId: ", Integer.valueOf(i)});
    }

    public static long bKT() {
        return j.cId();
    }

    private static void gX(long j) {
        c.d("tagorewang:TalkRoom", new Object[]{"setRoomKey: ", Long.valueOf(j)});
    }

    private static t a(at atVar) {
        if (atVar != null) {
            try {
                if (atVar.veW != null) {
                    byte[] bArr = atVar.veW;
                    return (t) e.a(new t(), bArr, bArr.length);
                }
            } catch (Exception e) {
                c.x("tagorewang:TalkRoom", new Object[]{"toPlayItemInfo err: ", e});
                return null;
            }
        }
        return null;
    }

    private String cHz() {
        if (this.vwX == null || TextUtils.isEmpty(this.vwX.name)) {
            List arrayList = new ArrayList(this.vwY.values());
            arrayList.remove(this.vwY.get(a.cEG()));
            List el = el(arrayList);
            c.w("tagorewang:TalkRoom", new Object[]{"getOtherMembers size: ", Integer.valueOf(el.size()), " all size: ", Integer.valueOf(this.vwY.size())});
            StringBuilder stringBuilder = new StringBuilder();
            if (el != null) {
                int size = el.size();
                for (int i = 0; i != size; i++) {
                    try {
                        stringBuilder.append(((d) el.get(i)).getDisplayName());
                        if (i != size - 1) {
                            stringBuilder.append(12289);
                        }
                    } catch (Exception e) {
                        c.x("tagorewang:TalkRoom", new Object[]{"updateRoomNameIfEmpty err and continue: ", e});
                    }
                }
            }
            if (stringBuilder.toString().length() > 0) {
                return stringBuilder.toString();
            }
        }
        if (this.vwX != null && !TextUtils.isEmpty(this.vwX.name)) {
            return this.vwX.name;
        }
        c.x("tagorewang:TalkRoom", new Object[]{"updateRoomNameIfEmpty still empty, groupId: ", this.vgm, " tmpId: ", this.vgn});
        return null;
    }

    private void b(at atVar) {
        if (atVar != null) {
            try {
                this.vgo = atVar.vfd;
                this.vgp = atVar.vfc;
                if (!(this.vwX == null || atVar.bOS == 0)) {
                    t a = a(atVar);
                    t a2 = a(this.vwX);
                    if (a == null) {
                        atVar.veW = this.vwX.veW;
                    } else if (a.vdE == 0 || a.vdE != a2.vdE) {
                        c.x("tagorewang:TalkRoom", new Object[]{"setRoomInfo bad id: ", Integer.valueOf(a2.vdE), " -> ", Integer.valueOf(a.vdE)});
                        atVar.veW = this.vwX.veW;
                    }
                }
                this.vwX = atVar;
            } catch (Exception e) {
                c.x("tagorewang:TalkRoom", new Object[]{"setRoomInfo assert failed: ", e});
                this.vwX = atVar;
            }
        }
    }

    public final void a(d dVar) {
        this.vwY.put(dVar.cHI(), dVar);
    }

    public final List<d> cHA() {
        List<d> el = el(new ArrayList(this.vwY.values()));
        d cHC = cHC();
        el.remove(cHC);
        el.add(0, cHC);
        cHC = (d) this.vwY.get(Integer.valueOf(90100));
        if (cHC != null) {
            el.remove(cHC);
            el.add(cHC);
        }
        return el;
    }

    public final List<d> cHB() {
        return new ArrayList(this.vwY.values());
    }

    private static List<d> el(List<d> list) {
        if (!list.isEmpty()) {
            Collections.sort(list, new a());
        }
        return list;
    }

    public final d adf(String str) {
        return (d) this.vwY.get(str);
    }

    public final d cHC() {
        return (d) this.vwY.get(a.cEG());
    }

    public final List<av> cHD() {
        List<av> arrayList = new ArrayList();
        for (Entry value : this.vwY.entrySet()) {
            arrayList.add(((d) value.getValue()).vxf);
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String cHz;
            stringBuilder.append("groupId: ").append(this.vgm);
            stringBuilder.append(" tmpId: ").append(this.vgn);
            stringBuilder.append(" routeId: ").append(this.vcc);
            StringBuilder append = stringBuilder.append(" room name: ");
            if (this.vwX == null || TextUtils.isEmpty(this.vwX.name)) {
                cHz = cHz();
            } else {
                cHz = this.vwX.name;
            }
            append.append(cHz);
        } catch (Exception e) {
            stringBuilder.append(" broken by " + e.getMessage());
        }
        return stringBuilder.toString();
    }
}
