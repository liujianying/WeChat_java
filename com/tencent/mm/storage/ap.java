package com.tencent.mm.storage;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class ap {
    public String aeskey;
    public String bKg;
    public String bKk;
    public String bOt;
    public long bYu;
    public int cqa;
    public String cqb = "";
    public long createTime;
    public int dYP;
    public String dwA;
    public String dwu;
    public String enF;
    public int height;
    public String id;
    public String knh;
    public int taZ;
    public String talker;
    public int tba;
    public int tbb;
    public int tbc;
    public String tbd = "";
    public String tbe;
    public String tbf;
    public String tbg;
    public boolean tbh = true;
    public String tbi;
    public String thumbUrl;
    public int width;

    public static ap a(Map<String, String> map, String str, String str2, String str3) {
        if (map == null) {
            return null;
        }
        ap apVar = new ap();
        apVar.tbd = str2;
        apVar.talker = str;
        apVar.id = (String) map.get(".msg.emoji.$idbuffer");
        apVar.enF = (String) map.get(".msg.emoji.$fromusername");
        String str4 = (String) map.get(".msg.emoji.$androidmd5");
        apVar.bKg = str4;
        if (str4 == null) {
            apVar.bKg = (String) map.get(".msg.emoji.$md5");
        }
        if (!bi.oW(apVar.bKg)) {
            apVar.bKg = apVar.bKg.toLowerCase();
        }
        try {
            apVar.taZ = Integer.valueOf((String) map.get(".msg.emoji.$type")).intValue();
            if (map.get(".msg.emoji.$androidlen") != null) {
                apVar.tba = Integer.valueOf((String) map.get(".msg.emoji.$androidlen")).intValue();
            } else if (map.get(".msg.emoji.$len") != null) {
                apVar.tba = Integer.valueOf((String) map.get(".msg.emoji.$len")).intValue();
            }
            if (map.get(".msg.gameext.$type") != null) {
                apVar.tbb = Integer.valueOf((String) map.get(".msg.gameext.$type")).intValue();
            }
            if (map.get(".msg.gameext.$content") != null) {
                apVar.tbc = Integer.valueOf((String) map.get(".msg.gameext.$content")).intValue();
            }
            if (map.get(".msg.emoji.$productid") != null) {
                apVar.bKk = (String) map.get(".msg.emoji.$productid");
            }
            if (map.get(".msg.emoji.$cdnurl") != null) {
                apVar.knh = (String) map.get(".msg.emoji.$cdnurl");
            }
            if (map.get(".msg.emoji.$tpurl") != null) {
                apVar.dwu = (String) map.get(".msg.emoji.$tpurl");
            }
            if (map.get(".msg.emoji.$tpauthkey") != null) {
                apVar.dwA = (String) map.get(".msg.emoji.$tpauthkey");
            }
            if (map.get(".msg.emoji.$designerid") != null) {
                apVar.tbe = (String) map.get(".msg.emoji.$designerid");
            }
            if (map.get(".msg.emoji.$thumburl") != null) {
                apVar.thumbUrl = (String) map.get(".msg.emoji.$thumburl");
            }
            if (map.get(".msg.emoji.$encrypturl") != null) {
                apVar.bOt = (String) map.get(".msg.emoji.$encrypturl");
            }
            if (map.get(".msg.emoji.$aeskey") != null) {
                apVar.aeskey = (String) map.get(".msg.emoji.$aeskey");
            }
            if (map.get(".msg.emoji.$width") != null) {
                apVar.width = Integer.valueOf((String) map.get(".msg.emoji.$width")).intValue();
            }
            if (map.get(".msg.emoji.$height") != null) {
                apVar.height = Integer.valueOf((String) map.get(".msg.emoji.$height")).intValue();
            }
            if (map.get(".msg.emoji.$externurl") != null) {
                apVar.tbf = (String) map.get(".msg.emoji.$externurl");
            }
            if (map.get(".msg.emoji.$externmd5") != null) {
                apVar.tbg = (String) map.get(".msg.emoji.$externmd5");
            }
            if (map.get(".msg.emoji.$activityid") != null) {
                apVar.tbi = (String) map.get(".msg.emoji.$activityid");
            }
            if (!bi.oW(str3)) {
                apVar.cqb = str3;
            }
            x.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s tpUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", new Object[]{apVar.id, apVar.bKg, Integer.valueOf(apVar.taZ), Integer.valueOf(apVar.tba), Integer.valueOf(apVar.tbb), Integer.valueOf(apVar.tbc), apVar.bKk, apVar.knh, apVar.dwu, apVar.tbe, apVar.thumbUrl, apVar.bOt, Integer.valueOf(apVar.width), Integer.valueOf(apVar.height), apVar.tbf, apVar.tbg});
            return apVar;
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }
}
