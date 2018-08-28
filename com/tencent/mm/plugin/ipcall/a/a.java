package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class a {
    private static a koe = null;
    private boolean acT = false;
    private long endTime = -1;
    ag handler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            long currentTimeMillis = System.currentTimeMillis();
            d aXv = i.aXv();
            ArrayList<c> arrayList = (ArrayList) message.obj;
            if (arrayList != null && arrayList.size() > 0) {
                long dO = aXv.dO(Thread.currentThread().getId());
                x.i("MicroMsg.IPCallAddressStorage", "getContactIdMap start");
                Cursor a = aXv.diF.a("IPCallAddressItem", new String[]{"contactId"}, null, null, null, null, null, 2);
                Map hashMap = new HashMap();
                if (a == null || !a.moveToFirst()) {
                    if (a != null) {
                        a.close();
                    }
                    x.i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
                    for (c cVar : arrayList) {
                        if (!hashMap.containsKey(cVar.field_contactId)) {
                            aXv.b(cVar);
                        }
                    }
                    aXv.dP(dO);
                } else {
                    do {
                        String string = a.getString(0);
                        if (!hashMap.containsKey(string)) {
                            hashMap.put(string, Boolean.valueOf(true));
                        }
                    } while (a.moveToNext());
                    if (a != null) {
                        a.close();
                    }
                    x.i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
                    for (c cVar2 : arrayList) {
                        if (!hashMap.containsKey(cVar2.field_contactId)) {
                            aXv.b(cVar2);
                        }
                    }
                    aXv.dP(dO);
                }
            }
            x.d("MicroMsg.IPCallAddressBookLoader", "batchInsert, used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            a.this.endTime = System.currentTimeMillis();
            x.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, used: %dms", new Object[]{Long.valueOf(a.this.endTime - a.this.startTime)});
            a.this.acT = false;
            a.this.endTime = -1;
            a.this.startTime = -1;
            Iterator it = a.this.kod.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.amF();
                }
            }
            a.this.kod.clear();
        }
    };
    public ArrayList<a> kod = new ArrayList();
    private long startTime = -1;

    public interface a {
        void amF();
    }

    private a() {
    }

    public static a aXa() {
        if (koe == null) {
            koe = new a();
        }
        return koe;
    }

    public final void a(a aVar, boolean z) {
        if (aVar != null) {
            this.kod.add(aVar);
        }
        if (this.acT) {
            x.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, isLoading is true, ignore");
            return;
        }
        this.startTime = System.currentTimeMillis();
        if (b.aXV().size() == 0 || !z) {
            x.d("MicroMsg.IPCallAddressBookLoader", "loadFromSystemAddressBook");
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = new b();
            ArrayList aXU = b.aXU();
            x.d("MicroMsg.IPCallAddressBookLoader", "getAllAddressItemFromSystemPhoneBook, used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.obj = aXU;
            this.handler.sendMessage(obtainMessage);
            this.acT = true;
        }
    }
}
