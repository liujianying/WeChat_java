package com.tencent.mm.plugin.expt.roomexpt;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.g.b.a.g;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class a implements c, d {
    private static final float[] iIa = new float[]{0.0f, 0.3f, 0.45f, 0.55f, 0.67f, 0.75f, 0.85f, 1.0f};
    private static final float[] iIb = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.1f, 0.2f, 0.3f, 0.4f};
    private static final float[] iIc = new float[]{0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    private static final int[] iId = new int[]{15, 35, 83, 140, 209, 297, 417, 599, 926, 1720};
    private static final float[] iIe = new float[]{0.0f, 0.3f, 0.5f, 0.6f, 0.7f, 0.7f, 0.8f, 0.8f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 1.0f};
    private static final float[] iIf = new float[]{0.0f, 0.3f, 0.45f, 0.55f, 0.6f, 0.7f, 0.7f, 0.8f, 0.8f, 0.8f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 1.0f};
    private static final float[] iIg = new float[]{0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    private static final int[] iIh = new int[]{2400, 7500, 13000, 21500, 41000, 65000, 116000, 215000, 455000};
    private static final float[] iIi = new float[]{0.0f, 0.35f, 0.5f, 0.6f, 0.7f, 0.7f, 0.8f, 0.8f, 0.8f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 1.0f};
    private static a iIk;
    private SimpleDateFormat iIj = null;
    public b iIl;
    g iIm;
    private String[] iIn;
    private boolean iIo = false;
    int iIp = 0;

    static /* synthetic */ void aq(String str, boolean z) {
        String string;
        String string2;
        if (z) {
            string = ad.getResources().getString(d.chatroom_notify_need_nomute_msg);
            string2 = ad.getResources().getString(d.chatroom_notify_need_momute_url_tips);
        } else {
            string = ad.getResources().getString(d.chatroom_notify_need_mute_msg);
            string2 = ad.getResources().getString(d.chatroom_notify_need_mute_url_tips);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<sysmsg type=\"chatroommuteexpt\">");
        stringBuffer.append("<chatroommuteexpt>");
        stringBuffer.append("<text><![CDATA[").append(string).append("]]></text>");
        stringBuffer.append("<link>");
        stringBuffer.append("<scene>chatroommuteexpt</scene>");
        stringBuffer.append("<text><![CDATA[").append(string2).append("]]></text>");
        stringBuffer.append("</link>");
        stringBuffer.append("</chatroommuteexpt>");
        stringBuffer.append("</sysmsg>");
        bd bdVar = new bd();
        bdVar.ep(str);
        bdVar.eX(2);
        bdVar.setType(10002);
        bdVar.ay(com.tencent.mm.model.bd.Ik());
        bdVar.setContent(stringBuffer.toString());
        com.tencent.mm.model.bd.i(bdVar);
        h.mEJ.e(869, z ? 11 : 10, 1);
    }

    static /* synthetic */ String e(a aVar) {
        if (aVar.iIj == null) {
            aVar.iIj = new SimpleDateFormat("yyyyMMdd");
        }
        return aVar.iIj.format(new Date(bi.VF()));
    }

    static /* synthetic */ boolean n(long j, int i) {
        return i <= 0 && j <= 5000;
    }

    public static a aIx() {
        if (iIk == null) {
            iIk = new a();
        }
        return iIk;
    }

    private void aIy() {
        if (this.iIm != null) {
            com.tencent.mm.kernel.g.Ei().DT().a(com.tencent.mm.storage.aa.a.sZZ, this.iIm.wE());
            x.i("MicroMsg.ChatRoomExptService", "save expt info[%s]", new Object[]{this.iIm.wF()});
        }
    }

    public final void r(Context context, Intent intent) {
        intent.setClass(context, RoomExptDebugUI.class);
        context.startActivity(intent);
    }

    public final void eB(boolean z) {
        e.post(new 1(this, z), "click_room_mute_msg");
    }

    public final void ap(final String str, final boolean z) {
        x.d("MicroMsg.ChatRoomExptService", "enter chat room [%s] isMute[%b]", new Object[]{str, Boolean.valueOf(z)});
        if (this.iIp > 0) {
            this.iIp--;
            com.tencent.mm.kernel.g.Em().H(new Runnable() {
                public final void run() {
                    a.aq(str, z);
                }
            });
        } else if (this.iIn == null || this.iIn.length <= 0) {
            x.d("MicroMsg.ChatRoomExptService", "roomname list is null");
        } else if (this.iIm == null) {
        } else {
            if (this.iIm.chJ >= 5) {
                x.d("MicroMsg.ChatRoomExptService", "exptInfo is finish [%d]", new Object[]{Long.valueOf(this.iIm.chJ)});
                return;
            }
            com.tencent.mm.kernel.g.Em().H(new 3(this, str, z));
        }
    }

    public final void a(String str, String str2, long j, int i, int i2, boolean z) {
        boolean z2;
        Object obj;
        com.tencent.mm.plugin.expt.a.a aVar = (com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.expt.a.a.class);
        com.tencent.mm.plugin.expt.a.a.a aVar2 = com.tencent.mm.plugin.expt.a.a.a.iHN;
        if (this.iIm != null) {
            z2 = this.iIm.chM;
        } else {
            z2 = false;
        }
        if (aVar.a(aVar2, z2)) {
            h.mEJ.e(869, 1, 1);
            long j2 = this.iIm.chJ;
            if (j2 >= 3) {
                x.d("MicroMsg.ChatRoomExptService", "room expt already finish");
                obj = null;
            } else {
                Object obj2 = j2 == 0 ? 1 : null;
                long j3 = z ? 1 | j2 : 2 | j2;
                this.iIm.chJ = j3;
                if (j3 >= 3) {
                    x.d("MicroMsg.ChatRoomExptService", "user already enter mute room and unmute room, don't expt");
                    h.mEJ.e(869, 2, 1);
                    aIy();
                    obj = null;
                } else {
                    if (obj2 != null) {
                        if (this.iIm.chK <= 0) {
                            this.iIm.wG();
                        }
                        aIy();
                    }
                    obj = 1;
                }
            }
        } else {
            obj = null;
        }
        if (obj != null) {
            final long j4 = j;
            final int i3 = i2;
            final String str3 = str;
            final int i4 = i;
            final boolean z3 = z;
            final String str4 = str2;
            com.tencent.mm.kernel.g.Em().H(new Runnable() {
                public final void run() {
                    e eVar;
                    boolean z;
                    boolean c;
                    long VG = bi.VG();
                    long VE = bi.VE();
                    if (a.this.iIm.chK <= 0) {
                        a.this.iIm.wG();
                        a.this.aIy();
                    } else if (VE - a.this.iIm.chK >= 604800) {
                        a.this.d();
                        return;
                    }
                    String e = a.e(a.this);
                    boolean n = a.n(j4, i3);
                    e cG = a.this.iIl.cG(str3, e);
                    String str = "MicroMsg.ChatRoomExptService";
                    String str2 = "get db [%s %s] item [%s]";
                    Object[] objArr = new Object[3];
                    objArr[0] = str3;
                    objArr[1] = e;
                    objArr[2] = cG != null ? cG : "null";
                    x.i(str, str2, objArr);
                    if (cG != null) {
                        cG.field_sendCount += i3;
                        cG.field_unReadCount += i4;
                        cG.field_disRedDotCount = (n ? 1 : 0) + cG.field_disRedDotCount;
                        cG.field_enterCount = (n ? 0 : 1) + cG.field_enterCount;
                        cG.field_stayTime += j4;
                        cG.field_isMute = z3 ? 1 : 0;
                        eVar = cG;
                        z = true;
                    } else {
                        cG = new e();
                        cG.field_chatroom = str3;
                        cG.field_nickname = str4;
                        cG.field_daySec = e;
                        cG.field_sendCount = i3;
                        cG.field_isMute = z3 ? 1 : 0;
                        cG.field_unReadCount = i4;
                        cG.field_disRedDotCount = n ? 1 : 0;
                        cG.field_enterCount = n ? 0 : 1;
                        cG.field_stayTime = j4;
                        eVar = cG;
                        z = false;
                    }
                    a.a(eVar);
                    if (z) {
                        c = a.this.iIl.c(eVar);
                    } else {
                        c = a.this.iIl.b(eVar);
                    }
                    if (!c) {
                        h.mEJ.e(869, 32, 1);
                    }
                    x.i("MicroMsg.ChatRoomExptService", "noteroominfo isUpdate[%b] dbOpRet[%b] cost[%d] item[%s]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(c), Long.valueOf(bi.bI(VG)), eVar});
                }
            });
        }
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        if (this.iIm == null) {
            String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(com.tencent.mm.storage.aa.a.sZZ, "");
            if (bi.oW(str)) {
                this.iIm = new g();
                this.iIm.chM = false;
            } else {
                this.iIm = new g(str);
                if (!bi.oW(this.iIm.chL)) {
                    this.iIn = this.iIm.chL.split(";");
                }
            }
            x.i("MicroMsg.ChatRoomExptService", "load expt roomnameList[%s] info[%s]", new Object[]{this.iIn, this.iIm.wF()});
        }
    }

    public final void onAccountRelease() {
        this.iIm = null;
        this.iIl = null;
    }

    private static float a(float[] fArr, int[] iArr, long j) {
        if (fArr == null || fArr.length <= 0 || iArr == null || iArr.length <= 0) {
            return 0.0f;
        }
        int length = fArr.length - 1;
        int min = Math.min(fArr.length, iArr.length);
        int i = 0;
        while (i < min) {
            if (j < ((long) iArr[i])) {
                break;
            }
            i++;
        }
        i = length;
        return fArr[i];
    }

    private static float c(float[] fArr, int i) {
        if (fArr == null || fArr.length <= 0) {
            return 0.0f;
        }
        if (i >= fArr.length) {
            return fArr[fArr.length - 1];
        }
        if (i <= 0) {
            return fArr[0];
        }
        return fArr[i];
    }

    private static float b(float f, int i, int i2) {
        float f2 = 0.0f;
        if (i > 0) {
            if ((i2 == 1 ? 1 : 0) != 0) {
                try {
                    f2 = (((f / ((float) i)) + (f / 7.0f)) / 2.0f) - c(iIb, i);
                } catch (Exception e) {
                    x.e("MicroMsg.ChatRoomExptService", "calc finish score error[%s]", new Object[]{e.toString()});
                }
            } else {
                f2 = c(iIa, i) + (((f / ((float) i)) + (f / 7.0f)) / 2.0f);
            }
            x.d("MicroMsg.ChatRoomExptService", "calc finish score result[%f] day[%d] isMute[%d] score[%f]", new Object[]{Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)});
        }
        return f2;
    }

    /* renamed from: aIz */
    final List<c> d() {
        Throwable e;
        Cursor cursor;
        if (this.iIm == null) {
            x.w("MicroMsg.ChatRoomExptService", "calc expt result but expt info is null");
            return null;
        } else if (this.iIm.chJ >= 3) {
            x.i("MicroMsg.ChatRoomExptService", "user already enter mute chatroom and unmute room. exptFlag [%d]", new Object[]{Long.valueOf(this.iIm.chJ)});
            return null;
        } else {
            if (!((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.iHN, this.iIm != null ? this.iIm.chM : false)) {
                x.i("MicroMsg.ChatRoomExptService", "user no expt user");
                return null;
            } else if (this.iIn != null && this.iIn.length > 0) {
                x.i("MicroMsg.ChatRoomExptService", "user already had expt result");
                return null;
            } else if (this.iIo) {
                x.d("MicroMsg.ChatRoomExptService", "it is calc expt now");
                return null;
            } else {
                long VG = bi.VG();
                this.iIo = true;
                Cursor aIC;
                try {
                    h.mEJ.e(869, 21, 1);
                    aIC = this.iIl.aIC();
                    float f = 0.0f;
                    try {
                        float f2;
                        String string;
                        String string2;
                        float b;
                        List<c> arrayList = new ArrayList();
                        if (aIC != null) {
                            while (aIC.moveToNext()) {
                                if (aIC.getColumnCount() < 5) {
                                    x.w("MicroMsg.ChatRoomExptService", "columnCount less than 5");
                                    f2 = f;
                                    break;
                                }
                                string = aIC.getString(0);
                                string2 = aIC.getString(1);
                                b = b(aIC.getFloat(4), aIC.getInt(3), aIC.getInt(2));
                                c cVar = new c();
                                cVar.bIY = string;
                                cVar.nickname = string2;
                                cVar.iIx = b;
                                arrayList.add(cVar);
                                f += b;
                            }
                        }
                        f2 = f;
                        Collections.sort(arrayList);
                        f = 0.0f;
                        if (arrayList.size() > 0) {
                            f = f2 / ((float) arrayList.size());
                        }
                        b = Math.max(f, 0.0f);
                        com.tencent.mm.g.b.a.a aVar = new com.tencent.mm.g.b.a.a();
                        StringBuffer stringBuffer = null;
                        int min = Math.min(arrayList.size(), 5);
                        int i = 0;
                        while (i < min) {
                            c cVar2 = (c) arrayList.get(i);
                            if (cVar2.iIx > b) {
                                if (stringBuffer != null) {
                                    stringBuffer.append(";").append(cVar2.bIY);
                                } else {
                                    stringBuffer = new StringBuffer();
                                    stringBuffer.append(cVar2.bIY);
                                }
                                aVar.cgb = cVar2.bIY;
                                aVar.cgc = cVar2.iIx;
                                aVar.cgd = (int) this.iIm.chJ;
                                aVar.RD();
                            }
                            i++;
                            stringBuffer = stringBuffer;
                        }
                        if (stringBuffer != null) {
                            this.iIm.chL = stringBuffer.toString();
                            this.iIm.chJ = 4;
                            this.iIn = this.iIm.chL.split(";");
                            h.mEJ.e(869, 22, 1);
                        } else {
                            this.iIm.chJ = 5;
                            this.iIm.chL = "";
                            this.iIn = null;
                            h.mEJ.e(869, 23, 1);
                        }
                        aIy();
                        this.iIo = false;
                        string = "MicroMsg.ChatRoomExptService";
                        string2 = "calcExptResult [%s] roomnameList [%s] cost[%d]";
                        Object[] objArr = new Object[3];
                        objArr[0] = this.iIm.wF();
                        objArr[1] = this.iIn != null ? Arrays.toString(this.iIn) : "null";
                        objArr[2] = Long.valueOf(bi.bI(VG));
                        x.i(string, string2, objArr);
                        if (aIC != null) {
                            aIC.close();
                        }
                        return arrayList;
                    } catch (Exception e2) {
                        e = e2;
                        cursor = aIC;
                    } catch (Throwable th) {
                        e = th;
                        if (aIC != null) {
                            aIC.close();
                        }
                        throw e;
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                    try {
                        x.printErrStackTrace("MicroMsg.ChatRoomExptService", e, "calcExptResult error", new Object[0]);
                        if (cursor != null) {
                            cursor.close();
                        }
                        x.w("MicroMsg.ChatRoomExptService", "default return null?");
                        return null;
                    } catch (Throwable th2) {
                        e = th2;
                        aIC = cursor;
                        if (aIC != null) {
                            aIC.close();
                        }
                        throw e;
                    }
                } catch (Throwable th3) {
                    e = th3;
                    aIC = null;
                    if (aIC != null) {
                        aIC.close();
                    }
                    throw e;
                }
            }
        }
    }

    protected final void aIA() {
        try {
            this.iIl.diF.delete("RoomMuteExpt", null, null);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChatRoomExptStorage", e, "deleteAll", new Object[0]);
        }
        aIB();
    }

    protected final void aIB() {
        if (this.iIm != null) {
            this.iIm = new g();
            this.iIm.chM = true;
            aIy();
        }
        this.iIn = null;
    }
}
