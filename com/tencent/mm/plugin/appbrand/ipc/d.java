package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static final HashMap<String, MMToClientEvent> fEx = new HashMap();

    public static void a(MMToClientEvent mMToClientEvent) {
        x.i("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId:%s, MMToClientEvent.hash:%d", new Object[]{mMToClientEvent.appId, Integer.valueOf(mMToClientEvent.hashCode())});
        if (mMToClientEvent.appId == null) {
            x.e("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId is null!!!");
            return;
        }
        synchronized (fEx) {
            if (fEx.get(mMToClientEvent.appId) == null) {
                fEx.put(mMToClientEvent.appId, mMToClientEvent);
            } else {
                x.d("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
                fEx.remove(mMToClientEvent.appId);
                fEx.put(mMToClientEvent.appId, mMToClientEvent);
            }
        }
    }

    public static void b(MMToClientEvent mMToClientEvent) {
        x.i("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", new Object[]{mMToClientEvent.appId});
        synchronized (fEx) {
            fEx.remove(mMToClientEvent.appId);
        }
    }

    public static void k(String str, int i, String str2) {
        MMToClientEvent mMToClientEvent;
        x.i("MicroMsg.MMToClientEventCenter", "notify appId:%s, type:%d, config:%s", new Object[]{str, Integer.valueOf(i), str2});
        synchronized (fEx) {
            mMToClientEvent = (MMToClientEvent) fEx.get(str);
        }
        if (mMToClientEvent != null) {
            synchronized (mMToClientEvent) {
                mMToClientEvent.fEp = 3;
                mMToClientEvent.appId = str;
                mMToClientEvent.type = i;
                mMToClientEvent.bNC = str2;
                mMToClientEvent.ahH();
            }
            return;
        }
        x.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    }

    public static void aB(String str, int i) {
        MMToClientEvent mMToClientEvent;
        x.i("MicroMsg.MMToClientEventCenter", "notify unread:%d", new Object[]{Integer.valueOf(i)});
        synchronized (fEx) {
            mMToClientEvent = (MMToClientEvent) fEx.get(str);
        }
        if (mMToClientEvent != null) {
            synchronized (mMToClientEvent) {
                mMToClientEvent.fEp = 4;
                mMToClientEvent.bGz = i;
                mMToClientEvent.ahH();
            }
            return;
        }
        x.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    }

    public static <T extends Parcelable> void c(T t) {
        MMToClientEvent mMToClientEvent;
        LinkedList linkedList = new LinkedList();
        synchronized (fEx) {
            for (MMToClientEvent mMToClientEvent2 : fEx.values()) {
                linkedList.add(mMToClientEvent2);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            mMToClientEvent2 = (MMToClientEvent) it.next();
            synchronized (mMToClientEvent2) {
                mMToClientEvent2.fEp = 5;
                mMToClientEvent2.fEq = t.getClass().getName();
                mMToClientEvent2.fEr = t;
                mMToClientEvent2.ahH();
            }
        }
    }
}
