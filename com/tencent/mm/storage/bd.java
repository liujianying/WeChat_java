package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.c.f;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.o;
import com.tencent.wcdb.FileUtils;
import java.util.Map;
import junit.framework.Assert;

public final class bd extends o {
    public static String tbx = "voip_content_voice";
    public static String tby = "voip_content_video";
    private String tbA;
    public boolean tbz = false;

    public static final class a {
        private String bhd = "";
        public String cCR = "";
        private String csK;
        private String csL;
        public String csP = "";
        private String csQ = "";
        public String eHT = "";
        public String eLA = "";
        public String eLB = "";
        public String eLE = "";
        public String eLz = "";
        public String lUI = "";
        public long lWQ = 0;
        public String nickname = "";
        public String otZ = "";
        public int pOR = 0;
        public String qOy = "";
        public int scene = 0;
        public int sex;
        public String signature;
        public int tbD = 0;
        public String tbE = "";
        public String tbF = "";
        public String tbG = "";
        public String tbH = "";
        public String tbI = "";
        public String tbJ = "";
        public String tbK = "";
        public String tbL = "";

        private a() {
        }

        public static a YV(String str) {
            a aVar = new a();
            String trim = bi.aG(str, "").trim();
            if (!trim.startsWith("<")) {
                int indexOf = trim.indexOf(":");
                if (indexOf != -1) {
                    trim = trim.substring(indexOf + 1);
                }
            }
            Map z = bl.z(trim, "msg");
            if (z != null) {
                try {
                    if (z.get(".msg.$fromusername") == null) {
                        aVar.otZ = (String) z.get(".msg.$username");
                    } else {
                        aVar.otZ = (String) z.get(".msg.$fromusername");
                    }
                    if (z.get(".msg.$fromnickname") == null) {
                        aVar.nickname = (String) z.get(".msg.$nickname");
                    } else {
                        aVar.nickname = (String) z.get(".msg.$fromnickname");
                    }
                    aVar.cCR = (String) z.get(".msg.$alias");
                    aVar.eLA = (String) z.get(".msg.$fullpy");
                    aVar.eLz = (String) z.get(".msg.$shortpy");
                    aVar.bhd = (String) z.get(".msg.$source");
                    aVar.tbD = bi.getInt((String) z.get(".msg.$imagestatus"), 0);
                    aVar.scene = bi.getInt((String) z.get(".msg.$scene"), 0);
                    aVar.tbE = (String) z.get(".msg.$mobileidentify");
                    aVar.tbF = (String) z.get(".msg.$mobilelongidentify");
                    if (z.get(".msg.$qqnum") != null && ((String) z.get(".msg.$qqnum")).length() > 0) {
                        aVar.lWQ = bi.getLong((String) z.get(".msg.$qqnum"), 0);
                    }
                    aVar.signature = (String) z.get(".msg.$sign");
                    if (z.get(".msg.$sex") != null && ((String) z.get(".msg.$sex")).length() > 0) {
                        aVar.sex = bi.getInt((String) z.get(".msg.$sex"), 0);
                    }
                    aVar.csL = (String) z.get(".msg.$city");
                    aVar.csK = (String) z.get(".msg.$province");
                    aVar.eLB = (String) z.get(".msg.$qqnickname");
                    aVar.eLE = (String) z.get(".msg.$qqremark");
                    aVar.pOR = bi.getInt(TextUtils.isEmpty((CharSequence) z.get(".msg.$certflag")) ? "0" : (String) z.get(".msg.$certflag"), 0);
                    aVar.csP = bi.oV((String) z.get(".msg.$certinfo"));
                    aVar.lUI = bi.oV((String) z.get(".msg.$brandIconUrl"));
                    aVar.csQ = bi.oV((String) z.get(".msg.$regionCode"));
                    aVar.tbG = bi.oV((String) z.get(".msg.$bigheadimgurl"));
                    aVar.tbH = bi.oV((String) z.get(".msg.$smallheadimgurl"));
                    aVar.eHT = bi.oV((String) z.get(".msg.$googlecontact"));
                    aVar.qOy = bi.oV((String) z.get(".msg.$antispamticket"));
                    aVar.tbI = bi.oV((String) z.get(".msg.$openimappid"));
                    aVar.tbJ = bi.oV((String) z.get(".msg.$openimdesc"));
                    aVar.tbK = bi.oV((String) z.get(".msg.$openimdescicon"));
                    aVar.tbL = bi.oV((String) z.get(".msg.$openimcustominfo"));
                    if (ab.XR(aVar.otZ)) {
                        aVar.qOy = bi.oV((String) z.get(".msg.$ticket"));
                    }
                    x.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", aVar.otZ, aVar.qOy, aVar.tbG, aVar.tbH);
                } catch (Throwable e) {
                    x.e("MicroMsg.MsgInfo", "exception:%s", bi.i(e));
                }
            }
            return aVar;
        }

        public final String getDisplayName() {
            if (!TextUtils.isEmpty(this.nickname)) {
                return this.nickname;
            }
            if (!TextUtils.isEmpty(this.cCR)) {
                return this.cCR;
            }
            x.f("MicroMsg.MsgInfo", "username is nullOrNil");
            return bi.oV(this.otZ);
        }

        public final String cmJ() {
            if (this.eLE != null && this.eLE.length() > 0) {
                return this.eLE;
            }
            if (this.eLB == null || this.eLB.length() <= 0) {
                return Long.toString(this.lWQ);
            }
            return this.eLB;
        }

        public final String getCity() {
            if (!bi.oW(this.csQ)) {
                String[] split = this.csQ.split("_");
                if (split.length > 0) {
                    if (split.length > 2) {
                        RegionCodeDecoder.cmS();
                        this.csL = RegionCodeDecoder.ar(split[0], split[1], split[2]);
                    } else if (split.length == 2) {
                        RegionCodeDecoder.cmS();
                        this.csL = RegionCodeDecoder.ga(split[0], split[1]);
                    } else {
                        this.csL = "";
                    }
                }
            }
            return this.csL;
        }

        public final String getProvince() {
            if (!bi.oW(this.csQ)) {
                String[] split = this.csQ.split("_");
                if (split.length > 0) {
                    if (split.length <= 2 || !RegionCodeDecoder.Zh(split[0])) {
                        RegionCodeDecoder.cmS();
                        this.csK = RegionCodeDecoder.Zi(split[0]);
                    } else {
                        RegionCodeDecoder.cmS();
                        this.csK = RegionCodeDecoder.ga(split[0], split[1]);
                    }
                }
            }
            return this.csK;
        }
    }

    public static final class b {
        public int bSz = 0;
        public double kCw = 0.0d;
        public double kCx = 0.0d;
        public String kFa = "";
        public String label = "";
        public String otZ = "";
        public String qyA = "";
        public String tbM = "";
        public String tbN = null;
        public String tbO = null;
        public String tbP = null;

        public final String toString() {
            return String.format("%d-%d-%d", new Object[]{Integer.valueOf((int) (this.kCw * 1000000.0d)), Integer.valueOf((int) (this.kCx * 1000000.0d)), Integer.valueOf(this.bSz)});
        }

        public static b YW(String str) {
            b bVar = new b();
            Map z = bl.z(str, "msg");
            if (z != null) {
                bVar.otZ = bi.aG((String) z.get(".msg.location.$fromusername"), "");
                bVar.kCw = bi.WW((String) z.get(".msg.location.$x"));
                bVar.kCx = bi.WW((String) z.get(".msg.location.$y"));
                bVar.label = bi.aG((String) z.get(".msg.location.$label"), "");
                bVar.tbM = bi.aG((String) z.get(".msg.location.$maptype"), "");
                bVar.bSz = bi.WU((String) z.get(".msg.location.$scale"));
                bVar.tbP = bi.aG((String) z.get(".msg.location.$localLocationen"), "");
                bVar.tbN = bi.aG((String) z.get(".msg.location.$localLocationcn"), "");
                bVar.tbO = bi.aG((String) z.get(".msg.location.$localLocationtw"), "");
                bVar.kFa = bi.aG((String) z.get(".msg.location.$poiname"), "");
                bVar.qyA = bi.aG((String) z.get(".msg.location.$infourl"), "");
            }
            return bVar;
        }

        public final boolean cmK() {
            return (this.kFa == null || this.kFa.equals("")) ? false : true;
        }
    }

    public static final class c {
        public String content = "";
        public String eeZ = "";
        public boolean jff = false;
        public String mcf;
        public String tbQ = "";
        public String title = "";

        private c() {
        }

        public static c YX(String str) {
            c cVar = new c();
            Map z = bl.z(str, "msg");
            if (z != null) {
                try {
                    cVar.title = (String) z.get(".msg.pushmail.content.subject");
                    cVar.content = (String) z.get(".msg.pushmail.content.digest");
                    cVar.eeZ = (String) z.get(".msg.pushmail.content.sender");
                    cVar.tbQ = (String) z.get(".msg.pushmail.waplink");
                    cVar.jff = bi.oV((String) z.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
                    cVar.mcf = (String) z.get(".msg.pushmail.mailid");
                } catch (Throwable e) {
                    x.e("MicroMsg.MsgInfo", "exception:%s", bi.i(e));
                }
            }
            return cVar;
        }
    }

    public static final class d {
        public int bOh;
        public String cCR = "";
        public String chatroomName = "";
        public String content = "";
        private String countryCode;
        private String dDe;
        private String dDf;
        public String eHT;
        public String eLA = "";
        public String eLB = "";
        private String eLE = "";
        public String eLz = "";
        public String juZ;
        public long lWQ = 0;
        public String nickname = "";
        public String otZ = "";
        public String qIb;
        public String qIc;
        public int scene = 0;
        public int sex;
        public String signature;
        public int tbD = 0;
        public String tbE = "";
        public String tbF = "";
        public String tbG = "";
        public String tbH = "";
        public int tbR = 0;
        public String tbS;
        public String tbT;
        public int tbU;
        public String tbV;
        public String tbW;

        private d() {
        }

        public static d YY(String str) {
            d dVar = new d();
            Map z = bl.z(str, "msg");
            if (z != null) {
                try {
                    dVar.otZ = (String) z.get(".msg.$fromusername");
                    dVar.cCR = (String) z.get(".msg.$alias");
                    dVar.nickname = (String) z.get(".msg.$fromnickname");
                    dVar.eLA = (String) z.get(".msg.$fullpy");
                    dVar.eLz = (String) z.get(".msg.$shortpy");
                    dVar.content = (String) z.get(".msg.$content");
                    dVar.tbD = bi.getInt((String) z.get(".msg.$imagestatus"), 0);
                    dVar.scene = bi.getInt((String) z.get(".msg.$scene"), 0);
                    dVar.tbE = (String) z.get(".msg.$mhash");
                    dVar.tbF = (String) z.get(".msg.$mfullhash");
                    if (z.get(z.get(".msg.$qqnum")) != null && ((String) z.get(z.get(".msg.$qqnum"))).length() > 0) {
                        dVar.lWQ = bi.getLong((String) z.get(".msg.$qqnum"), 0);
                    }
                    dVar.eLB = (String) z.get(".msg.$qqnickname");
                    dVar.eLE = (String) z.get(".msg.$qqremark");
                    dVar.signature = (String) z.get(".msg.$sign");
                    if (z.get(".msg.$sex") != null && ((String) z.get(".msg.$sex")).length() > 0) {
                        dVar.sex = bi.getInt((String) z.get(".msg.$sex"), 0);
                    }
                    dVar.dDe = (String) z.get(".msg.$city");
                    dVar.dDf = (String) z.get(".msg.$province");
                    dVar.countryCode = (String) z.get(".msg.$country");
                    if (z.get(".msg.$snsflag") != null) {
                        dVar.tbR = bi.getInt((String) z.get(".msg.$snsflag"), 0);
                        dVar.tbS = (String) z.get(".msg.$snsbgimgid");
                    }
                    dVar.juZ = (String) z.get(".msg.$ticket");
                    x.d("MicroMsg.MsgInfo", "dkverify ticket:%s", dVar.juZ);
                    dVar.tbG = bi.oV((String) z.get(".msg.$bigheadimgurl"));
                    dVar.tbH = bi.oV((String) z.get(".msg.$smallheadimgurl"));
                    dVar.bOh = bi.getInt((String) z.get(".msg.$opcode"), 0);
                    dVar.tbT = bi.oV((String) z.get(".msg.$encryptusername"));
                    dVar.eHT = bi.oV((String) z.get(".msg.$googlecontact"));
                    x.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", dVar.otZ, dVar.tbG, dVar.tbH);
                    dVar.chatroomName = bi.oV((String) z.get(".msg.$chatroomusername"));
                    dVar.qIb = (String) z.get(".msg.$sourceusername");
                    dVar.qIc = (String) z.get(".msg.$sourcenickname");
                    dVar.tbU = bi.getInt((String) z.get(".msg.Antispam.$isSuspiciousUser"), 0);
                    if (dVar.tbU == 1) {
                        dVar.tbV = (String) z.get(".msg.Antispam.safetyWarning");
                        dVar.tbW = (String) z.get(".msg.Antispam.safetyWarningDetail");
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MsgInfo", e, "", new Object[0]);
                }
            }
            return dVar;
        }

        public final String cmL() {
            return this.juZ;
        }

        public final String wM() {
            return this.cCR;
        }

        public final String cmM() {
            return this.otZ;
        }

        public final String wO() {
            return this.nickname;
        }

        public final String getDisplayName() {
            if (this.nickname != null && this.nickname.length() > 0) {
                return this.nickname;
            }
            x.f("MicroMsg.MsgInfo", "username is nullOrNil");
            return this.otZ;
        }

        public final String wQ() {
            return this.eLA;
        }

        public final String wP() {
            return this.eLz;
        }

        public final int cmN() {
            return this.sex;
        }

        public final String cmO() {
            return this.signature;
        }

        public final String getCity() {
            if (bi.oW(this.countryCode) || bi.oW(this.dDf)) {
                return this.dDe;
            }
            if (bi.oW(this.dDe)) {
                RegionCodeDecoder.cmS();
                return RegionCodeDecoder.ga(this.countryCode, this.dDf);
            }
            RegionCodeDecoder.cmS();
            return RegionCodeDecoder.ar(this.countryCode, this.dDf, this.dDe);
        }

        public final String getProvince() {
            if (bi.oW(this.countryCode)) {
                return this.dDf;
            }
            if (bi.oW(this.dDf) || bi.oW(this.dDe) || !RegionCodeDecoder.Zh(this.countryCode)) {
                RegionCodeDecoder.cmS();
                return RegionCodeDecoder.Zi(this.countryCode);
            }
            RegionCodeDecoder.cmS();
            return RegionCodeDecoder.ga(this.countryCode, this.dDf);
        }

        public final String cmP() {
            return this.tbT;
        }
    }

    public bd(String str) {
        super.ep(str);
    }

    public final boolean aQm() {
        return (getType() & 65535) == 49;
    }

    public final boolean cky() {
        return getType() == 285212721;
    }

    public final boolean ckz() {
        return getType() == 34;
    }

    public final boolean cmb() {
        return getType() == 436207665;
    }

    public final boolean cmc() {
        return getType() == 469762097;
    }

    public final boolean cmd() {
        return getType() == 301989937;
    }

    public final boolean cme() {
        return getType() == 50 || getType() == 53;
    }

    public final boolean cmf() {
        return getType() == 52;
    }

    public final boolean cmg() {
        return getType() == 318767153;
    }

    public final boolean cmh() {
        return getType() == 10002;
    }

    public final boolean ckA() {
        switch (getType()) {
            case 3:
            case 13:
            case 23:
            case 33:
            case 39:
                return true;
            default:
                return false;
        }
    }

    public final boolean cmi() {
        return getType() == 42 || getType() == 66;
    }

    public final boolean aQo() {
        return getType() == 48;
    }

    public final boolean isText() {
        switch (getType()) {
            case 1:
            case 11:
            case 21:
            case 31:
            case 36:
                return true;
            default:
                return false;
        }
    }

    public final boolean isSystem() {
        return getType() == 10000;
    }

    public final boolean cmj() {
        return getType() == 43;
    }

    public final boolean cmk() {
        return getType() == 62;
    }

    public final boolean cml() {
        return getType() == 47;
    }

    public final boolean cmm() {
        return getType() == 1048625;
    }

    public final boolean cmn() {
        return getType() == 16777265;
    }

    public final boolean cmo() {
        return getType() == 268435505;
    }

    public final boolean cmp() {
        return getType() == -1879048191;
    }

    public final boolean cmq() {
        return getType() == -1879048190;
    }

    public final boolean cmr() {
        return getType() == -1879048189;
    }

    public final boolean cms() {
        switch (getType()) {
            case 55:
            case 57:
                return true;
            default:
                return false;
        }
    }

    public final boolean cmt() {
        Object obj;
        String value = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("TranslateMsgOff");
        if (bi.oW(value) || bi.WU(value) == 0) {
            int obj2 = 1;
        } else {
            x.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
            obj2 = null;
        }
        return (obj2 == null || bi.oW(this.field_transContent)) ? false : true;
    }

    public static bd al(bd bdVar) {
        if (bdVar == null) {
            x.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
            return null;
        }
        bd bdVar2 = new bd();
        bdVar2.setMsgId(bdVar.field_msgId);
        bdVar2.ax(bdVar.field_msgSvrId);
        bdVar2.setType(bdVar.getType());
        bdVar2.setStatus(bdVar.field_status);
        bdVar2.eX(bdVar.field_isSend);
        bdVar2.field_isShowTimer = bdVar.field_isShowTimer;
        bdVar2.cGp = true;
        bdVar2.ay(bdVar.field_createTime);
        bdVar2.ep(bdVar.field_talker);
        bdVar2.setContent(bdVar.field_content);
        bdVar2.eq(bdVar.field_imgPath);
        bdVar2.er(bdVar.field_reserved);
        bdVar2.C(bdVar.field_lvbuffer);
        bdVar2.es(bdVar.field_transContent);
        bdVar2.eu(bdVar.cGB);
        bdVar2.eC(bdVar.cqa);
        bdVar2.dt(bdVar.cqb);
        return bdVar2;
    }

    public final void setStatus(int i) {
        com.tencent.mm.sdk.b.b oxVar;
        super.setStatus(i);
        if (this.field_isSend == 1) {
            int i2 = (isText() || aQo() || cmi()) ? 0 : 1;
            if (i2 != 0) {
                if (this.field_status == 5) {
                    x.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", Long.valueOf(this.field_msgId), Integer.valueOf(getType()), this.field_talker, bi.cjd());
                    oxVar = new ox();
                    oxVar.bZS.bGS = this;
                    com.tencent.mm.sdk.b.a.sFg.m(oxVar);
                    return;
                } else if (this.field_status == 2) {
                    x.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", Long.valueOf(this.field_msgId), Integer.valueOf(getType()));
                    oxVar = new oz();
                    oxVar.bZU.bGS = this;
                    com.tencent.mm.sdk.b.a.sFg.m(oxVar);
                    return;
                } else {
                    return;
                }
            }
        }
        if (this.field_isSend == 0) {
            oxVar = new mo();
            oxVar.bXx.bGS = this;
            com.tencent.mm.sdk.b.a.sFg.m(oxVar);
        }
    }

    public final boolean cmu() {
        return (this.cGE & 1) > 0;
    }

    public final void cmv() {
        this.cGE |= 1;
        this.cpN = true;
    }

    public final void cmw() {
        if (cmx()) {
            eC(this.cqa & -33);
        }
    }

    public final boolean cmx() {
        return (this.cqa & 32) > 0;
    }

    public final boolean cmy() {
        return cmt() && (this.cqa & 16) > 0;
    }

    public final void cmz() {
        if (cmt()) {
            eC(this.cqa | 16);
        }
    }

    public final boolean cmA() {
        return cmt() && (this.cqa & 1024) > 0;
    }

    public final void cmB() {
        eC(this.cqa | FileUtils.S_IWUSR);
    }

    public final boolean cmC() {
        return ((this.cqa & FileUtils.S_IWUSR) == 0 && (this.cqa & 768) == 0) ? false : true;
    }

    public final void Dn(int i) {
        switch (i) {
            case 0:
            case 1:
                eC(this.cqa | i);
                return;
            default:
                x.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
                return;
        }
    }

    public final void cmD() {
        eC(this.cqa & -65);
    }

    public final void cmE() {
        eC(this.cqa | 64);
    }

    public final boolean cmF() {
        return (this.cqa & 64) != 0;
    }

    public final boolean YU(String str) {
        if (!(bi.oW(this.cqb) || bi.oW(str))) {
            Map z = bl.z(this.cqb, "msgsource");
            if (z == null) {
                return false;
            }
            String str2 = (String) z.get(".msgsource.atuserlist");
            if (!bi.oW(str2)) {
                for (String trim : str2.split(",")) {
                    if (trim.trim().equals(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean cmG() {
        boolean z;
        if (bi.oW(this.cqb) || !(this.cqb.contains("announcement@all") || this.cqb.contains("notify@all"))) {
            z = false;
        } else {
            z = true;
        }
        x.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", Boolean.valueOf(z));
        return z;
    }

    public static boolean av(Map<String, String> map) {
        boolean z;
        if (map != null && map.containsKey(".sysmsg.$type") && ((String) map.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", Boolean.valueOf(z));
        return z;
    }

    public static boolean aw(Map<String, String> map) {
        boolean z;
        if (map != null && map.containsKey(".sysmsg.$type") && ((String) map.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", Boolean.valueOf(z));
        return z;
    }

    public final void d(Cursor cursor) {
        super.d(cursor);
        String str = this.field_content;
        if (str != null && str.length() > 2097152) {
            final long j = this.field_msgId;
            StringBuilder stringBuilder = new StringBuilder(1024);
            stringBuilder.append("Very big message: \nmsgId = ").append(j).append(10).append("msgSvrId = ").append(this.field_msgSvrId).append(10).append("type = ").append(getType()).append(10).append("createTime = ").append(this.field_createTime).append(10).append("talker = ").append(this.field_talker).append(10).append("flag = ").append(this.field_flag).append(10).append("content.length() = ").append(str.length()).append(10).append("content = ").append(str.substring(0, 256));
            x.e("MicroMsg.MsgInfo", stringBuilder.toString());
            setType(1);
            setContent("");
            final bd al = al(this);
            g.Em().H(new Runnable() {
                public final void run() {
                    ((i) g.l(i.class)).bcY().a(j, al);
                }
            });
        }
        gn(this.field_msgId);
    }

    public static void gn(long j) {
        String str = "msgId not in the reasonable scope";
        boolean z = 100000000 > j && -10 < j;
        Assert.assertTrue(str, z);
    }

    public final ContentValues wH() {
        gn(this.field_msgId);
        return super.wH();
    }

    public final String cmH() {
        if (!cmh()) {
            return "";
        }
        if (this.tbA == null) {
            cmI();
        }
        return this.tbA;
    }

    public final com.tencent.mm.ap.a cmI() {
        x.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
        com.tencent.mm.ap.a b = com.tencent.mm.ap.a.a.b(f.z(this.field_content, "sysmsg"), this);
        if (b != null) {
            x.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", b);
            if (b.values == null || b.values.size() <= 0) {
                x.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
            } else {
                if (b.values.containsKey(".sysmsg.$type")) {
                    b.TYPE = (String) b.values.get(".sysmsg.$type");
                }
                com.tencent.mm.ap.a.ebD = ".sysmsg." + b.TYPE + ".text";
                if (b.values.containsKey(com.tencent.mm.ap.a.ebD)) {
                    b.TEXT = (String) b.values.get(com.tencent.mm.ap.a.ebD);
                }
                com.tencent.mm.ap.a.ebE = ".sysmsg." + b.TYPE + ".link.scene";
                if (b.values.containsKey(com.tencent.mm.ap.a.ebE)) {
                    b.ebG = (String) b.values.get(com.tencent.mm.ap.a.ebE);
                }
                b.Qi();
            }
            this.tbA = b.TEXT;
        } else {
            x.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
        }
        return b;
    }

    public final int getType() {
        int type = super.getType();
        if (type == 486539313) {
            return 285212721;
        }
        return type;
    }
}
