package com.tencent.mm.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class b$a implements Runnable {
    public static boolean dRw = false;
    private static byte[] dsN = new byte[0];
    private static final ag evC = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (g.Eg().Dx()) {
                a aVar = new a();
                int size = b.evt.size();
                boolean parseBoolean = Boolean.parseBoolean(message.obj.toString());
                Iterator it = b.evt.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).bK(parseBoolean);
                }
                b.evt.clear();
                x.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", new Object[]{Integer.valueOf(size), Long.valueOf(aVar.Ad())});
            }
        }
    };
    private List<com.tencent.mm.plugin.account.friend.a.a> evA;
    private bg evB;
    private List<String[]> evx;
    private List<String[]> evy;
    private List<com.tencent.mm.plugin.account.friend.a.a> evz;

    private b$a() {
    }

    /* synthetic */ b$a(byte b) {
        this();
    }

    private static List<com.tencent.mm.plugin.account.friend.a.a> a(List<com.tencent.mm.plugin.account.friend.a.a> list, int i, int i2) {
        List<com.tencent.mm.plugin.account.friend.a.a> linkedList = new LinkedList();
        while (i < i2) {
            linkedList.add(list.get(i));
            i++;
        }
        return linkedList;
    }

    public final void run() {
        int i = 0;
        synchronized (dsN) {
            this.evB = new bg("MicroMsg.AddrBookSyncHelper", "sync addrBook");
            this.evB.addSplit("sync begin");
            x.d("MicroMsg.AddrBookSyncHelper", "reading email info");
            this.evx = com.tencent.mm.pluginsdk.a.eH(ad.getContext());
            if (this.evx != null) {
                x.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.evx.size());
            }
            this.evA = b(1, this.evx);
            x.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
            this.evy = com.tencent.mm.pluginsdk.a.eG(ad.getContext());
            if (this.evy != null) {
                x.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.evy.size());
            }
            this.evz = b(0, this.evy);
            x.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
            if (this.evx != null && this.evA.size() > 0) {
                for (int i2 = 0; i2 < this.evA.size(); i2 += 100) {
                    List a;
                    x.i("MicroMsg.AddrBookSyncHelper", "sync email index: " + i2);
                    if (i2 + 100 < this.evA.size()) {
                        a = a(this.evA, i2, i2 + 100);
                    } else {
                        a = a(this.evA, i2, this.evA.size());
                    }
                    x.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + a.size());
                    l.ac(a);
                }
            }
            Message obtainMessage;
            if (this.evz == null || this.evz.size() == 0) {
                x.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
                obtainMessage = evC.obtainMessage();
                obtainMessage.obj = Boolean.valueOf(false);
                evC.sendMessage(obtainMessage);
                return;
            }
            while (true) {
                int i3 = i;
                if (i3 < this.evz.size()) {
                    x.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: " + i3);
                    if (g.Eg().Dx()) {
                        List a2;
                        if (i3 + 100 < this.evz.size()) {
                            a2 = a(this.evz, i3, i3 + 100);
                        } else {
                            a2 = a(this.evz, i3, this.evz.size());
                        }
                        x.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + a2.size());
                        l.ac(a2);
                        i = i3 + 100;
                    } else {
                        x.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
                        obtainMessage = evC.obtainMessage();
                        obtainMessage.obj = Boolean.valueOf(false);
                        evC.sendMessage(obtainMessage);
                        return;
                    }
                }
                x.i("MicroMsg.AddrBookSyncHelper", "sync ok");
                if (g.Eg().Dx()) {
                    Vq();
                    System.currentTimeMillis();
                    this.evB.addSplit("sync ok");
                    this.evB.dumpToLog();
                    obtainMessage = evC.obtainMessage();
                    obtainMessage.obj = Boolean.valueOf(true);
                    evC.sendMessage(obtainMessage);
                    return;
                }
                x.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
                obtainMessage = evC.obtainMessage();
                obtainMessage.obj = Boolean.valueOf(false);
                evC.sendMessage(obtainMessage);
                return;
            }
        }
    }

    private static void Vq() {
        bg bgVar = new bg("MicroMsg.AddrBookSyncHelper", "delete");
        List arrayList = new ArrayList();
        List eI = com.tencent.mm.pluginsdk.a.eI(ad.getContext());
        for (String[] strArr : ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Xt()) {
            String oV = bi.oV(strArr[0]);
            String oV2 = bi.oV(strArr[1]);
            if (!(oV.equals("") || eI.contains(oV))) {
                arrayList.add(oV2);
            }
        }
        if (arrayList.size() > 0) {
            ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Z(arrayList);
            l.ab(arrayList);
        }
        bgVar.addSplit("end");
        bgVar.dumpToLog();
    }

    private static List<com.tencent.mm.plugin.account.friend.a.a> b(int i, List<String[]> list) {
        if (list == null) {
            x.e("MicroMsg.AddrBookSyncHelper", "sync address book failed, null info list");
            return new LinkedList();
        }
        List<com.tencent.mm.plugin.account.friend.a.a> arrayList = new ArrayList();
        for (String[] strArr : list) {
            if (strArr != null) {
                String str = strArr[0];
                String str2 = strArr[1];
                String str3 = strArr[2];
                String str4 = strArr[3];
                long WV = bi.WV(strArr[4]);
                if (!(str3 == null || str3.equals(""))) {
                    String str5 = "";
                    if (i == 1) {
                        str5 = com.tencent.mm.a.g.u(str3.getBytes());
                    }
                    if (i == 0) {
                        str5 = com.tencent.mm.pluginsdk.a.pK(str3);
                        if (bi.oW(str5)) {
                            x.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
                        } else {
                            str5 = com.tencent.mm.a.g.u(str5.getBytes());
                        }
                    }
                    com.tencent.mm.plugin.account.friend.a.a aVar = new com.tencent.mm.plugin.account.friend.a.a();
                    aVar.dia = str2;
                    aVar.eJy = h.oJ(str2);
                    aVar.eJz = h.oI(str2);
                    aVar.eJw = str;
                    aVar.dHL = str4;
                    aVar.po(str5);
                    aVar.eJZ = WV;
                    aVar.eJF = aVar.AY();
                    if (i == 1) {
                        aVar.csD = str3;
                    }
                    if (i == 0) {
                        aVar.eJC = str3;
                    }
                    aVar.type = i;
                    aVar.bWA = 1095798;
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }
}
