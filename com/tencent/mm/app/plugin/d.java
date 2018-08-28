package com.tencent.mm.app.plugin;

import android.content.Context;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.PRIORITY;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.b;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public final class d implements b {
    private static d bAo = null;
    URISpanHandlerSet bAp;
    ArrayList<BaseUriSpanHandler> bAq = new ArrayList();
    ArrayList<BaseUriSpanHandler> bAr = new ArrayList();
    ArrayList<BaseUriSpanHandler> bAs = new ArrayList();
    Context mContext = null;

    public static d vA() {
        if (bAo == null) {
            bAo = new d();
        }
        return bAo;
    }

    private d() {
        long VF = bi.VF();
        x.d("MicroMsg.URISpanHandler", "init URISpanHandler");
        this.mContext = ad.getContext();
        this.bAp = new URISpanHandlerSet(this.mContext);
        for (Class cls : URISpanHandlerSet.class.getDeclaredClasses()) {
            if (cls != null && cls.getSuperclass() != null && cls.isAnnotationPresent(a.class) && cls.getSuperclass().getName().equals(BaseUriSpanHandler.class.getName())) {
                try {
                    a aVar = (a) cls.getAnnotation(a.class);
                    Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{URISpanHandlerSet.class});
                    if (declaredConstructor != null) {
                        BaseUriSpanHandler baseUriSpanHandler = (BaseUriSpanHandler) BaseUriSpanHandler.class.cast(declaredConstructor.newInstance(new Object[]{this.bAp}));
                        PRIORITY vC = aVar.vC();
                        if (vC == PRIORITY.LOW) {
                            this.bAs.add(baseUriSpanHandler);
                        } else if (vC == PRIORITY.NORMAL) {
                            this.bAr.add(baseUriSpanHandler);
                        } else if (vC == PRIORITY.HIGH) {
                            this.bAq.add(baseUriSpanHandler);
                        }
                        x.d("MicroMsg.URISpanHandler", "successfully add: %s", new Object[]{cls.getName()});
                    } else {
                        x.d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", new Object[]{cls.getName()});
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.URISpanHandler", e, "", new Object[0]);
                    x.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", new Object[]{cls.getName(), e.getMessage(), e.getClass().getName()});
                }
            }
        }
        x.d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", new Object[]{Long.valueOf(bi.VF() - VF)});
    }

    public final m u(Context context, String str) {
        x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", new Object[]{str, Integer.valueOf(this.bAq.size()), Integer.valueOf(this.bAr.size()), Integer.valueOf(this.bAs.size())});
        if (context == null) {
            x.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
            this.bAp.mContext = null;
            return null;
        }
        this.mContext = context;
        this.bAp.mContext = this.mContext;
        if (bi.oW(str)) {
            x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
            this.mContext = null;
            this.bAp.mContext = null;
            return null;
        }
        m db;
        Iterator it = this.bAq.iterator();
        while (it.hasNext()) {
            db = ((BaseUriSpanHandler) it.next()).db(str);
            if (db != null) {
                x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[]{Integer.valueOf(db.type)});
                this.mContext = null;
                this.bAp.mContext = null;
                return db;
            }
        }
        it = this.bAr.iterator();
        while (it.hasNext()) {
            db = ((BaseUriSpanHandler) it.next()).db(str);
            if (db != null) {
                x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[]{Integer.valueOf(db.type)});
                this.mContext = null;
                this.bAp.mContext = null;
                return db;
            }
        }
        it = this.bAs.iterator();
        while (it.hasNext()) {
            db = ((BaseUriSpanHandler) it.next()).db(str);
            if (db != null) {
                x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[]{Integer.valueOf(db.type)});
                this.mContext = null;
                this.bAp.mContext = null;
                return db;
            }
        }
        this.mContext = null;
        this.bAp.mContext = null;
        x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
        return null;
    }

    public final boolean a(Context context, m mVar, g gVar) {
        if (mVar == null) {
            x.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
            return false;
        }
        boolean z;
        String str = "MicroMsg.URISpanHandler";
        String str2 = "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(mVar.type);
        if (gVar == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(this.bAq.size());
        objArr[3] = Integer.valueOf(this.bAr.size());
        objArr[4] = Integer.valueOf(this.bAs.size());
        x.d(str, str2, objArr);
        if (context == null) {
            x.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
            this.bAp.mContext = null;
            return false;
        }
        BaseUriSpanHandler baseUriSpanHandler;
        this.mContext = context;
        this.bAp.mContext = this.mContext;
        Iterator it = this.bAq.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (c(baseUriSpanHandler.vB(), mVar.type) && baseUriSpanHandler.a(mVar, gVar)) {
                x.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[]{baseUriSpanHandler.getClass().getName()});
                this.mContext = null;
                this.bAp.mContext = null;
                return true;
            }
        }
        it = this.bAr.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (c(baseUriSpanHandler.vB(), mVar.type) && baseUriSpanHandler.a(mVar, gVar)) {
                x.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[]{baseUriSpanHandler.getClass().getName()});
                this.mContext = null;
                this.bAp.mContext = null;
                return true;
            }
        }
        it = this.bAs.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (c(baseUriSpanHandler.vB(), mVar.type) && baseUriSpanHandler.a(mVar, gVar)) {
                x.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[]{baseUriSpanHandler.getClass().getName()});
                this.mContext = null;
                this.bAp.mContext = null;
                return true;
            }
        }
        this.mContext = null;
        this.bAp.mContext = null;
        x.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
        return false;
    }

    private static boolean c(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
