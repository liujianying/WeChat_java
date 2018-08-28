package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.ax.a;
import com.tencent.mm.ax.b;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.c.bsm;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class e implements b {
    private ag handler;
    private com.tencent.mm.plugin.talkroom.a.b owi;
    private HashSet<a> owj = new HashSet();
    private final String path;

    public e() {
        File file = new File(b.bGV());
        if (!file.exists()) {
            file.mkdirs();
        }
        this.path = b.bGV() + "talkroomMemberList.info";
        this.handler = new ag(Looper.getMainLooper());
        if (this.owi != null) {
            return;
        }
        if (com.tencent.mm.a.e.cn(this.path)) {
            try {
                this.owi = (com.tencent.mm.plugin.talkroom.a.b) new com.tencent.mm.plugin.talkroom.a.b().aG(com.tencent.mm.a.e.f(this.path, 0, -1));
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", e, "", new Object[0]);
                this.owi = new com.tencent.mm.plugin.talkroom.a.b();
                return;
            }
        }
        this.owi = new com.tencent.mm.plugin.talkroom.a.b();
    }

    public final synchronized void a(a aVar) {
        this.owj.add(aVar);
    }

    public final synchronized void b(a aVar) {
        this.owj.remove(aVar);
    }

    public final synchronized boolean nq(String str) {
        boolean z;
        Iterator it = this.owi.ovV.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.talkroom.a.a aVar = (com.tencent.mm.plugin.talkroom.a.a) it.next();
            if (aVar.username.equals(str) && aVar.sceneType == 0) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public final synchronized boolean Sm() {
        boolean z;
        Iterator it = this.owi.ovV.iterator();
        loop0:
        while (it.hasNext()) {
            com.tencent.mm.plugin.talkroom.a.a aVar = (com.tencent.mm.plugin.talkroom.a.a) it.next();
            if (aVar.sceneType == 0) {
                Iterator it2 = aVar.bUb.iterator();
                while (it2.hasNext()) {
                    if (q.GF().equals(((bsm) it2.next()).hbL)) {
                        z = true;
                        break loop0;
                    }
                }
                continue;
            }
        }
        z = false;
        return z;
    }

    public final synchronized LinkedList<bsm> np(String str) {
        LinkedList<bsm> linkedList;
        Iterator it = this.owi.ovV.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.talkroom.a.a aVar = (com.tencent.mm.plugin.talkroom.a.a) it.next();
            if (aVar.username.equals(str)) {
                linkedList = (LinkedList) aVar.bUb.clone();
                break;
            }
        }
        linkedList = new LinkedList();
        return linkedList;
    }

    public final synchronized void a(String str, LinkedList<bsm> linkedList, String str2, String str3, int i) {
        LinkedList linkedList2;
        com.tencent.mm.plugin.talkroom.a.a aVar;
        if (linkedList2 == null) {
            linkedList2 = new LinkedList();
        }
        x.i("MicroMsg.TalkRoomInfoListMgr", "updateList talk: %s,  size: %d", new Object[]{str, Integer.valueOf(linkedList2.size())});
        LinkedList linkedList3 = (LinkedList) linkedList2.clone();
        boolean isEmpty = linkedList3.isEmpty();
        Iterator it = this.owi.ovV.iterator();
        while (it.hasNext()) {
            aVar = (com.tencent.mm.plugin.talkroom.a.a) it.next();
            if (aVar.username.equals(str)) {
                if (isEmpty) {
                    this.owi.ovV.remove(aVar);
                } else {
                    aVar.bUb = linkedList3;
                    aVar.sceneType = i;
                }
                aZw();
                T(str, str2, str3);
            }
        }
        if (!isEmpty) {
            aVar = new com.tencent.mm.plugin.talkroom.a.a();
            aVar.username = str;
            aVar.bUb = linkedList3;
            aVar.sceneType = i;
            this.owi.ovV.add(aVar);
        }
        aZw();
        T(str, str2, str3);
    }

    private void T(String str, String str2, String str3) {
        Iterator it = this.owj.iterator();
        while (it.hasNext()) {
            this.handler.post(new 1(this, (a) it.next(), str, str2, str3));
        }
    }

    private boolean aZw() {
        if (this.owi.ovV.isEmpty()) {
            com.tencent.mm.a.e.deleteFile(this.path);
            return true;
        }
        try {
            byte[] toByteArray = this.owi.toByteArray();
            com.tencent.mm.a.e.b(this.path, toByteArray, toByteArray.length);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", e, "", new Object[0]);
            return false;
        }
    }
}
