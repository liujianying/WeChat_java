package com.tencent.mm.ui.chatting.e;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.mm.bg.d.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public final class b implements com.tencent.mm.bg.d.b {
    private static WeakHashMap<Fragment, HashMap<Integer, a>> tXP = new WeakHashMap();
    private WeakReference<com.tencent.mm.ui.chatting.c.a> tXQ;

    public b(com.tencent.mm.ui.chatting.c.a aVar) {
        this.tXQ = new WeakReference(aVar);
    }

    public static a b(Fragment fragment, int i) {
        HashMap hashMap = (HashMap) tXP.get(fragment);
        if (hashMap != null) {
            return (a) hashMap.remove(Integer.valueOf(i));
        }
        return null;
    }

    public final Fragment cxF() {
        com.tencent.mm.ui.chatting.c.a aVar = (com.tencent.mm.ui.chatting.c.a) this.tXQ.get();
        if (aVar != null) {
            return aVar.tTq;
        }
        return null;
    }

    public final void a(Intent intent, int i, a aVar) {
        Fragment cxF = cxF();
        if (cxF != null) {
            HashMap hashMap = (HashMap) tXP.get(cxF);
            if (hashMap == null) {
                hashMap = new HashMap();
                tXP.put(cxF, hashMap);
            }
            hashMap.put(Integer.valueOf(i), aVar);
            cxF.startActivityForResult(intent, i);
        }
    }

    public final Context getContext() {
        return cxF().getActivity();
    }
}
