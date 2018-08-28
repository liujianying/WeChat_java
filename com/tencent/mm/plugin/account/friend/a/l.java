package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class l {
    private static Map<String, String> eKq = null;

    public static void Xz() {
        g.Ei().DT().set(12322, Boolean.valueOf(true));
    }

    public static boolean XA() {
        if (g.Ei() != null && g.Ei().DT() != null) {
            return bi.a((Boolean) g.Ei().DT().get(12322, Boolean.valueOf(true)), true);
        }
        x.e("MicroMsg.FriendLogic", "[arthurdan.UploadPhone] Notice!!!! MMKernel.storage() is null!!!");
        return false;
    }

    public static boolean XB() {
        x.i("MicroMsg.FriendLogic", "isTipInMobileFriend, state %s", new Object[]{XC().toString()});
        if (XC() != a.eKt) {
            return false;
        }
        x.i("MicroMsg.FriendLogic", "USERINFO_UPLOAD_ADDR_LOOK_UP %B", new Object[]{Boolean.valueOf(bi.a((Boolean) g.Ei().DT().get(12322, Boolean.valueOf(false)), false))});
        if (bi.a((Boolean) g.Ei().DT().get(12322, Boolean.valueOf(false)), false)) {
            return false;
        }
        return true;
    }

    public static a XC() {
        try {
            String str = (String) g.Ei().DT().get(4097, "");
            String str2 = (String) g.Ei().DT().get(6, "");
            boolean Hi = q.Hi();
            x.i("MicroMsg.FriendLogic", "isUpload " + Hi + " stat " + q.GJ());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && str2 == null) {
                return a.eKr;
            }
            if (str != null && str2 == null) {
                return a.eKs;
            }
            if (Hi) {
                return a.eKt;
            }
            return a.eKu;
        } catch (Exception e) {
            return a.eKr;
        }
    }

    public static void XD() {
        g.Ei().DT().set(4097, "");
        g.Ei().DT().set(6, "");
    }

    public static String XE() {
        return (String) g.Ei().DT().get(6, "");
    }

    public static boolean XF() {
        if (g.Eg().Dx()) {
            int i;
            if (XC() == a.eKt) {
                i = 1;
            } else {
                boolean i2 = false;
            }
            if (i2 == 0) {
                x.i("MicroMsg.FriendLogic", "canSyncAddrBook userBindOpMobile: %b", new Object[]{Boolean.valueOf(false)});
                return false;
            }
            if (XA()) {
                return true;
            }
            x.i("MicroMsg.FriendLogic", "canSyncAddrBook isUploadContact: %b", new Object[]{Boolean.valueOf(XA())});
            return false;
        }
        x.i("MicroMsg.FriendLogic", "canSyncAddrBook isAccHasReady: %b", new Object[]{Boolean.valueOf(g.Eg().Dx())});
        return false;
    }

    public static Bitmap b(String str, Context context) {
        return a.a(str, context, false);
    }

    public static boolean a(String str, Context context, byte[] bArr) {
        return a.b(str, context, bArr);
    }

    public static void XG() {
        b bVar = (b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
        int delete = bVar.dCZ.delete("addr_upload2", null, null);
        x.d("MicroMsg.AddrUploadStorage", "delete addr_upload2");
        if (delete > 0) {
            bVar.b(5, bVar, null);
        }
    }

    public static void XH() {
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) ((i) g.l(i.class)).bcX().bdb()).iterator();
        while (it.hasNext()) {
            at atVar = (at) it.next();
            bd.a GR = ((i) g.l(i.class)).bcY().GR(atVar.field_msgContent);
            if (GR != null && (GR.scene == 10 || GR.scene == 11)) {
                hashSet.add(atVar.field_talker);
            }
        }
        x.d("MicroMsg.FriendLogic", "deleteMobileFMessage, delete fmsg and fconv, talker size = " + hashSet.size());
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            pw((String) it2.next());
        }
    }

    private static void pw(String str) {
        x.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", new Object[]{Long.valueOf(0), str});
        x.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = " + ((i) g.l(i.class)).bcW().m(0, str));
        x.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = " + ((i) g.l(i.class)).bcX().Gy(str));
    }

    public static void ab(List<String> list) {
        if (list.size() != 0) {
            HashSet hashSet = new HashSet();
            Iterator it = ((ArrayList) ((i) g.l(i.class)).bcX().bdb()).iterator();
            while (it.hasNext()) {
                at atVar = (at) it.next();
                bd.a GR = ((i) g.l(i.class)).bcY().GR(atVar.field_msgContent);
                if (GR != null) {
                    String str = GR.tbF;
                    String str2 = GR.tbE;
                    if ((GR.scene == 10 || GR.scene == 11) && (list.contains(str) || list.contains(str2))) {
                        hashSet.add(atVar.field_talker);
                    }
                }
            }
            x.d("MicroMsg.FriendLogic", "deleteMobileFMessage(md5List), delete fmsg and fconv, talker size = " + hashSet.size());
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                pw((String) it2.next());
            }
        }
    }

    public static String px(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        b bVar = (b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
        Cursor b = bVar.dCZ.b("select addr_upload2.realname from addr_upload2 where addr_upload2.id = \"" + a.pn(str) + "\"", null, 2);
        if (b == null) {
            return "";
        }
        String str2 = "";
        if (b.moveToFirst()) {
            str2 = b.getString(0);
        }
        b.close();
        return str2;
    }

    public static void ac(List<a> list) {
        if (list == null) {
            x.e("MicroMsg.FriendLogic", "sync address book failed, null info list");
        } else {
            ((b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).L(list);
        }
    }

    public static void ad(List<String> list) {
        if (list == null) {
            x.e("MicroMsg.FriendLogic", "set uploaded mobile contact failed, null info list");
        } else {
            ((b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aa(list);
        }
    }

    public static List<String> XI() {
        Cursor b = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).dCZ.b("select addr_upload2.md5 from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 1", null, 2);
        List<String> arrayList = new ArrayList();
        while (b.moveToNext()) {
            arrayList.add(b.getString(0));
        }
        b.close();
        return arrayList;
    }

    public static List<String> XJ() {
        Cursor b = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).dCZ.b("select addr_upload2.moblie from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 0", null, 2);
        List<String> arrayList = new ArrayList();
        while (b.moveToNext()) {
            String pK = a.pK(b.getString(0));
            if (a.Sx(pK)) {
                arrayList.add(pK);
            }
        }
        b.close();
        return arrayList;
    }

    public static boolean je(int i) {
        am jf = ((an) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).jf(i);
        boolean jg = ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).jg(i);
        if (jf == null) {
            return false;
        }
        return jf.eLt == 1 || jg;
    }
}
