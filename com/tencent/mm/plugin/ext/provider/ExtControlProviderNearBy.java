package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.bt.e;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public final class ExtControlProviderNearBy extends ExtContentProviderBase implements c {
    private static final UriMatcher iKq;
    private static boolean iKs = false;
    private static al iKt = new al(new a() {
        public final boolean vD() {
            ExtControlProviderNearBy.iKs = false;
            return false;
        }
    }, false);
    private static final String[] qP = new String[]{"nickname", "avatar", "distance", "signature", "sex"};
    private boolean bgN;
    private com.tencent.mm.modelgeo.a.a cXs = new 4(this);
    private com.tencent.mm.modelgeo.c dMm;
    private b hLU = new 3(this);
    private int iKj;
    private List<aqp> iKk;
    private e iKl;
    private Set<String> iKm;
    private CountDownLatch iKn;
    private CountDownLatch iKo;
    private aqp iKp;
    private boolean iKr = false;

    static /* synthetic */ void e(ExtControlProviderNearBy extControlProviderNearBy) {
        q.Kp().a(extControlProviderNearBy);
        if (extControlProviderNearBy.iKl == null) {
            extControlProviderNearBy.iKl = new e(qP, (byte) 0);
        }
        for (aqp a : extControlProviderNearBy.iKk) {
            extControlProviderNearBy.a(a);
        }
        extControlProviderNearBy.iKo.countDown();
    }

    static /* synthetic */ void f(ExtControlProviderNearBy extControlProviderNearBy) {
        boolean z = true;
        x.v("MicroMsg.ExtControlProviderNearBy", "stop()");
        if (au.HX()) {
            b.b(jz.class.getName(), extControlProviderNearBy.hLU);
            String str = "MicroMsg.ExtControlProviderNearBy";
            String str2 = "releaseLbsManager(), lbsManager == null ? [%s]";
            Object[] objArr = new Object[1];
            if (extControlProviderNearBy.dMm != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.v(str, str2, objArr);
            if (extControlProviderNearBy.dMm != null) {
                extControlProviderNearBy.dMm.c(extControlProviderNearBy.cXs);
                return;
            }
            return;
        }
        x.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        iKq = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.NearBy", "male", 1);
        iKq.addURI("com.tencent.mm.plugin.ext.NearBy", "female", 2);
        iKq.addURI("com.tencent.mm.plugin.ext.NearBy", "all", 0);
    }

    private static void cz(boolean z) {
        if (z) {
            iKs = true;
            iKt.J(15000, 15000);
            return;
        }
        iKt.J(0, 0);
    }

    public final boolean onCreate() {
        return true;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlProviderNearBy", "query() " + uri);
        a(uri, getContext(), 15);
        if (uri == null) {
            pr(3);
            return null;
        } else if (bi.oW(this.iJN) || bi.oW(aIW())) {
            pr(3);
            return null;
        } else if (iKs) {
            x.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
            pr(5);
            return null;
        } else {
            cz(true);
            if (!atA()) {
                cz(false);
                pr(1);
                return this.hdQ;
            } else if (df(getContext())) {
                x.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.iKj);
                getType(uri);
                if (this.iKj < 0) {
                    x.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
                    cz(false);
                    pr(3);
                    return null;
                }
                try {
                    this.iKk = new ArrayList();
                    this.iKl = new e(qP, (byte) 0);
                    this.iKn = new CountDownLatch(1);
                    this.iKo = null;
                    this.iKm = new HashSet();
                    this.iKk = new ArrayList();
                    this.bgN = false;
                    x.v("MicroMsg.ExtControlProviderNearBy", "start()");
                    if (au.HX()) {
                        b.a(jz.class.getName(), this.hLU);
                        ah.A(new 2(this));
                    } else {
                        x.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
                    }
                    x.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
                    if (!this.iKn.await(15000, TimeUnit.MILLISECONDS)) {
                        x.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
                    }
                    if (this.iKo != null) {
                        x.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
                        if (!this.iKo.await(15000, TimeUnit.MILLISECONDS)) {
                            x.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
                        }
                    } else {
                        x.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
                    }
                } catch (Throwable e) {
                    x.w("MicroMsg.ExtControlProviderNearBy", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", e, "", new Object[0]);
                    pr(4);
                }
                cz(false);
                q.Kp().b(this);
                this.bgN = true;
                aJa();
                if (this.iKl == null || this.iKl.getCount() <= 0) {
                    pr(4);
                } else {
                    pr(0);
                }
                x.i("MicroMsg.ExtControlProviderNearBy", "return now");
                return this.iKl;
            } else {
                x.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
                cz(false);
                pr(2);
                return null;
            }
        }
    }

    private aqp AI(String str) {
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
            return null;
        }
        for (aqp aqp : this.iKk) {
            if (aqp.hbL.equals(str)) {
                return aqp;
            }
        }
        return null;
    }

    private void a(aqp aqp) {
        if (aqp == null || aqp.hbL == null) {
            x.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
            return;
        }
        this.iKm.add(aqp.hbL);
        Bitmap a = com.tencent.mm.aa.c.a(aqp.hbL, false, -1);
        x.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.iKo.getCount());
        if (a != null) {
            x.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[0];
            if (a.compress(CompressFormat.PNG, 100, byteArrayOutputStream)) {
                bArr = byteArrayOutputStream.toByteArray();
            }
            this.iKm.remove(aqp.hbL);
            this.iKl.addRow(new Object[]{aqp.hcS, bArr, aqp.rTd, aqp.eJK, Integer.valueOf(aqp.eJH)});
            x.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", new Object[]{a});
            a.recycle();
        }
    }

    public final void jX(String str) {
        x.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: " + str);
        if (this.bgN) {
            x.i("MicroMsg.ExtControlProviderNearBy", "has finished");
            return;
        }
        a(AI(str));
        this.iKo.countDown();
    }

    private void aJa() {
        if (this.iKm.size() > 0) {
            for (String str : this.iKm) {
                x.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: " + str);
                this.iKp = AI(str);
                if (!(this.iKp == null || this.iKp.hbL == null)) {
                    this.iKl.addRow(new Object[]{this.iKp.hcS, null, this.iKp.rTd, this.iKp.eJK, Integer.valueOf(this.iKp.eJH)});
                }
            }
            return;
        }
        x.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
    }

    public final String getType(Uri uri) {
        this.iKj = -1;
        switch (iKq.match(uri)) {
            case 0:
                this.iKj = 1;
                break;
            case 1:
                this.iKj = 3;
                break;
            case 2:
                this.iKj = 4;
                break;
            default:
                this.iKj = -1;
                break;
        }
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
