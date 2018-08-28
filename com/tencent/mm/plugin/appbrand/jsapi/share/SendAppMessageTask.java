package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.v;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cgm;
import com.tencent.mm.protocal.c.cgn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SendAppMessageTask extends MainProcessTask {
    public static final Creator<SendAppMessageTask> CREATOR = new 2();
    public String appId;
    public String bGG;
    public int bPh;
    public int dCn;
    public String description;
    public String dxx;
    public Runnable fFC;
    public boolean fPt;
    public String fYU;
    public String fYV;
    public String fYW;
    public int fYX;
    public String fYY;
    public String fYZ;
    public String fZa;
    public boolean fZb;
    public boolean fZc;
    public String fZd;
    public ArrayList<ShareInfo> fZe;
    public String fso;
    public String fwS;
    public String iconUrl;
    public String nickname;
    public String path;
    public int scene = BaseReportManager.MAX_READ_COUNT;
    public String title;
    public String toUser;
    public int type;
    public String url;
    public String userName;
    public int version;
    public boolean withShareTicket;

    public final void aai() {
        Bitmap a;
        x.i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", new Object[]{this.userName, this.fYV});
        byte[] bArr = new byte[0];
        if (!bi.oW(this.fYV) && (this.fYV.startsWith("http://") || this.fYV.startsWith("https://"))) {
            a = b.Ka().a(this.fYV, null);
        } else if (bi.oW(this.fYW)) {
            a = null;
        } else {
            a = c.Wb(this.fYW);
            if (this.fPt) {
                boolean deleteFile = e.deleteFile(this.fYW);
                x.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[]{this.fYW, Boolean.valueOf(deleteFile)});
            } else {
                x.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s)", new Object[]{this.fYW});
            }
        }
        if (a == null || a.isRecycled()) {
            x.e("MicroMsg.SendAppMessageTask", "thumb image is null");
        } else {
            x.i("MicroMsg.SendAppMessageTask", "thumb image is not null ");
            Bitmap createBitmap = Bitmap.createBitmap(a.getWidth(), a.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(-1);
            canvas.drawBitmap(a, 0.0f, 0.0f, null);
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            createBitmap.recycle();
        }
        x.i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", new Object[]{this.appId, this.title, this.description, this.userName, this.path, this.fYV});
        u.Hx().v(u.ic("wxapp_" + this.appId + this.path), true).p("prePublishId", "wxapp_" + this.appId + this.path);
        a aVar = new a();
        aVar.title = this.title;
        aVar.description = this.description;
        aVar.type = 33;
        aVar.dyS = this.userName;
        aVar.dyR = this.path;
        aVar.dyT = this.appId;
        aVar.dyZ = this.bPh;
        aVar.dza = this.version;
        aVar.dyV = this.fso;
        aVar.dyU = this.type;
        aVar.url = this.url;
        aVar.dzb = this.iconUrl;
        aVar.bZM = "wxapp_" + this.appId + this.path;
        aVar.bZG = this.userName;
        aVar.bZH = this.nickname;
        com.tencent.mm.y.a aVar2 = new com.tencent.mm.y.a();
        aVar2.dvC = this.fZb;
        aVar2.dvD = this.fwS;
        aVar2.dvE = this.dCn;
        aVar2.dvF = this.fZc;
        aVar.a(aVar2);
        StringBuilder stringBuilder = new StringBuilder("1_");
        stringBuilder.append(this.appId);
        stringBuilder.append("_");
        g.Eg();
        stringBuilder.append(o.getString(com.tencent.mm.kernel.a.Df()));
        stringBuilder.append("_");
        stringBuilder.append(bi.VE());
        stringBuilder.append("_");
        stringBuilder.append(this.fYX);
        aVar.dyX = stringBuilder.toString();
        x.i("MicroMsg.SendAppMessageTask", "doSendMessage isUpdateMsg:%b, withShareTicket:%b", new Object[]{Boolean.valueOf(this.fZc), Boolean.valueOf(this.withShareTicket)});
        if (this.fZc && this.withShareTicket) {
            a(aVar, bArr, stringBuilder, this.scene, this.fZc, this.dxx);
        } else if (this.withShareTicket) {
            a(aVar, bArr, stringBuilder, this.scene, this.fZc, this.dxx);
        } else {
            Iterator it = new LinkedList(bi.F(this.toUser.split(","))).iterator();
            while (it.hasNext()) {
                a(aVar, bArr, (String) it.next(), stringBuilder, this.scene);
            }
        }
    }

    public final void aaj() {
        if (this.fFC != null) {
            this.fFC.run();
        }
    }

    private void a(a aVar, byte[] bArr, StringBuilder stringBuilder, int i, boolean z, String str) {
        com.tencent.mm.ab.b.a aVar2 = new com.tencent.mm.ab.b.a();
        aVar2.dIF = 1118;
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
        cgm cgm = new cgm();
        cgm.bPS = this.appId;
        LinkedList linkedList = new LinkedList(bi.F(this.toUser.split(",")));
        cgm.sAI = linkedList;
        cgm.sAK = str;
        cgm.sAJ = z;
        aVar2.dIG = cgm;
        aVar2.dIH = new cgn();
        v.a(aVar2.KT(), new 1(this, linkedList, aVar, bArr, stringBuilder, i));
    }

    private void a(a aVar, byte[] bArr, String str, StringBuilder stringBuilder, int i) {
        ((com.tencent.mm.plugin.appbrand.compat.a.a) g.l(com.tencent.mm.plugin.appbrand.compat.a.a.class)).a(aVar, this.appId, this.title, str, bArr);
        if (!bi.oW(this.fYU)) {
            ow owVar = new ow();
            owVar.bZQ.bZR = str;
            owVar.bZQ.content = this.fYU;
            owVar.bZQ.type = s.hQ(str);
            owVar.bZQ.flags = 0;
            com.tencent.mm.sdk.b.a.sFg.m(owVar);
        }
        int i2 = 1;
        if (str.toLowerCase().endsWith("@chatroom")) {
            List il = ((com.tencent.mm.plugin.chatroom.b.b) g.l(com.tencent.mm.plugin.chatroom.b.b.class)).Ga().il(str);
            i2 = il != null ? il.size() : 0;
        }
        String str2 = this.appId;
        String str3 = this.bGG;
        String str4 = this.fYY;
        String str5 = this.title;
        String str6 = this.path;
        String str7 = this.fYZ;
        String str8 = this.fZa;
        String stringBuilder2 = stringBuilder.toString();
        String str9 = this.fZd;
        if (bi.oW(str2)) {
            x.e("MicroMsg.SendAppMessageTask", "appId is Null!");
            return;
        }
        String str10 = "";
        try {
            str10 = p.encode(bi.oV(str6), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.SendAppMessageTask", "encode share page path error!");
        }
        String str11 = "";
        try {
            str11 = p.encode(bi.oV(str7), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            x.e("MicroMsg.SendAppMessageTask", "encode current page path error!");
        }
        String str12 = "";
        try {
            str12 = p.encode(bi.oV(str9), "UTF-8");
        } catch (UnsupportedEncodingException e3) {
            x.e("MicroMsg.SendAppMessageTask", "encode current html url error!");
        }
        x.d("MicroMsg.SendAppMessageTask", "stev report(%s), appId %s, scene %s, sceneNote %s, sessionId %s, currentPath %s, currentTitle %s,shareTitle %s, sharePath %s, shareActionId %s, destinationUserCount %s, destinationUserName %s", new Object[]{Integer.valueOf(14077), str2, Integer.valueOf(i), str3, str4, str7, str8, str5, str6, stringBuilder2, Integer.valueOf(i2), str});
        h.mEJ.h(14077, new Object[]{str2, Integer.valueOf(i), str3, str4, str11, str8, str5, str10, stringBuilder2, "", Integer.valueOf(i2), str, str12});
    }

    public final void g(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.appId = parcel.readString();
        this.userName = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.fYU = parcel.readString();
        this.toUser = parcel.readString();
        this.url = parcel.readString();
        this.path = parcel.readString();
        this.type = parcel.readInt();
        this.fYV = parcel.readString();
        this.iconUrl = parcel.readString();
        this.fYW = parcel.readString();
        this.fPt = parcel.readInt() == 1;
        this.bPh = parcel.readInt();
        this.fso = parcel.readString();
        this.version = parcel.readInt();
        this.nickname = parcel.readString();
        this.fYX = parcel.readInt();
        this.scene = parcel.readInt();
        this.bGG = parcel.readString();
        this.fYY = parcel.readString();
        this.fYZ = parcel.readString();
        this.fZa = parcel.readString();
        this.withShareTicket = parcel.readByte() == (byte) 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.fZb = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.fZc = z2;
        this.dxx = parcel.readString();
        this.fwS = parcel.readString();
        this.dCn = parcel.readInt();
        this.fZd = parcel.readString();
        this.fZe = parcel.readArrayList(SendAppMessageTask.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        super.writeToParcel(parcel, i);
        parcel.writeString(this.appId);
        parcel.writeString(this.userName);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.fYU);
        parcel.writeString(this.toUser);
        parcel.writeString(this.url);
        parcel.writeString(this.path);
        parcel.writeInt(this.type);
        parcel.writeString(this.fYV);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.fYW);
        parcel.writeInt(this.fPt ? 1 : 0);
        parcel.writeInt(this.bPh);
        parcel.writeString(this.fso);
        parcel.writeInt(this.version);
        parcel.writeString(this.nickname);
        parcel.writeInt(this.fYX);
        parcel.writeInt(this.scene);
        parcel.writeString(this.bGG);
        parcel.writeString(this.fYY);
        parcel.writeString(this.fYZ);
        parcel.writeString(this.fZa);
        parcel.writeByte((byte) (this.withShareTicket ? 1 : 0));
        if (this.fZb) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.fZc) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.dxx);
        parcel.writeString(this.fwS);
        parcel.writeInt(this.dCn);
        parcel.writeString(this.fZd);
        parcel.writeList(this.fZe);
    }

    protected SendAppMessageTask(Parcel parcel) {
        g(parcel);
    }
}
