package com.tencent.mm.protocal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class y {
    public String qXe;
    public String qXf;
    public int ver;

    public static void J(String str, String str2, int i) {
        x.d("MicroMsg.RsaInfo", "summercert dkcert saveRsaInfo ver:%d keye:%s keyn:%s  ", Integer.valueOf(i), str, str2);
        Editor edit = ad.getContext().getSharedPreferences("rsa_public_key_prefs", 4).edit();
        edit.putString("keye", str);
        edit.putString("keyn", str2);
        edit.putInt("version", i);
        edit.putInt("client_version", d.qVN);
        edit.commit();
    }

    public static y cgr() {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("rsa_public_key_prefs", 4);
        y yVar = new y(sharedPreferences.getString("keye", ""), sharedPreferences.getString("keyn", ""), sharedPreferences.getInt("version", 0));
        int i = sharedPreferences.getInt("client_version", 0);
        if (!yVar.cgu()) {
            if (i > 637665843) {
                return yVar;
            }
            boolean commit = sharedPreferences.edit().clear().commit();
            f.mDy.a(148, 38, 1, false);
            x.i("MicroMsg.RsaInfo", "summercert clear old rsa lastClientVer[%d] nowVer[%d], commit[%b]", Integer.valueOf(i), Integer.valueOf(d.qVN), Boolean.valueOf(commit));
        }
        f.mDy.a(148, 39, 1, false);
        x.d("MicroMsg.RsaInfo", "summercert default req keye[%s], keyn[%s], ver[%d]", "010001", "D153E8A2B314D2110250A0A550DDACDCD77F5801F3D1CC21CB1B477E4F2DE8697D40F10265D066BE8200876BB7135EDC74CDBC7C4428064E0CDCBE1B6B92D93CEAD69EC27126DEBDE564AAE1519ACA836AA70487346C85931273E3AA9D24A721D0B854A7FCB9DED49EE03A44C189124FBEB8B17BB1DBE47A534637777D33EEC88802CD56D0C7683A796027474FEBF237FA5BF85C044ADC63885A70388CD3696D1F2E466EB6666EC8EFE1F91BC9353F8F0EAC67CC7B3281F819A17501E15D03291A2A189F6A35592130DE2FE5ED8E3ED59F65C488391E2D9557748D4065D00CBEA74EB8CA19867C65B3E57237BAA8BF0C0F79EBFC72E78AC29621C8AD61A2B79B".substring(0, 4) + "_" + "D153E8A2B314D2110250A0A550DDACDCD77F5801F3D1CC21CB1B477E4F2DE8697D40F10265D066BE8200876BB7135EDC74CDBC7C4428064E0CDCBE1B6B92D93CEAD69EC27126DEBDE564AAE1519ACA836AA70487346C85931273E3AA9D24A721D0B854A7FCB9DED49EE03A44C189124FBEB8B17BB1DBE47A534637777D33EEC88802CD56D0C7683A796027474FEBF237FA5BF85C044ADC63885A70388CD3696D1F2E466EB6666EC8EFE1F91BC9353F8F0EAC67CC7B3281F819A17501E15D03291A2A189F6A35592130DE2FE5ED8E3ED59F65C488391E2D9557748D4065D00CBEA74EB8CA19867C65B3E57237BAA8BF0C0F79EBFC72E78AC29621C8AD61A2B79B".substring(507, 511), Integer.valueOf(174));
        return new y("010001", "D153E8A2B314D2110250A0A550DDACDCD77F5801F3D1CC21CB1B477E4F2DE8697D40F10265D066BE8200876BB7135EDC74CDBC7C4428064E0CDCBE1B6B92D93CEAD69EC27126DEBDE564AAE1519ACA836AA70487346C85931273E3AA9D24A721D0B854A7FCB9DED49EE03A44C189124FBEB8B17BB1DBE47A534637777D33EEC88802CD56D0C7683A796027474FEBF237FA5BF85C044ADC63885A70388CD3696D1F2E466EB6666EC8EFE1F91BC9353F8F0EAC67CC7B3281F819A17501E15D03291A2A189F6A35592130DE2FE5ED8E3ED59F65C488391E2D9557748D4065D00CBEA74EB8CA19867C65B3E57237BAA8BF0C0F79EBFC72E78AC29621C8AD61A2B79B", 174);
    }

    public static y cgs() {
        return new y("010001", "D8D2AE73FF601B93B1471B35870A1B59D7649EEA815CDD8CE5496BBD0C6CFE19C0E082F4E513B615C6030CCFCE3153E25AA00E8156D0311AF72ABBB9BBEC8B1D3751592234B1A621CA774E2EC50047A93FA0BC60DF0C10E8A65C3B29D13167EC217FC6A29034494870705CBF4AC929FBA0E1E656A8F8B50E779AD89BB4EEF6FF", 125);
    }

    public static y cgt() {
        x.d("MicroMsg.RsaInfo", "summercert default base keye[%s], keyn[%s], ver[%d]", "010001", "D55D10C78FAE31AEEA46BFF785E3CCD0144084E3E426D7A5CAABB8943E815EC235FD86CC426C537C2B6E5E99301FBD0ACB50B562E1867A9C92222F9BFD8F2359AD32A36D0F7D8BCDECCE523EBB4115DE250F5BEC19A11D563AD3FBB45E1A0E49B2D64DECEFE22DC01FC575CEA1A129A5765293168C0CDA1467873B91229ED398F417EB43671D87C41A2D713095F379F22FC4578FB8DB77A9F1897C014F4B5AAF06626AC970811098516FD82B4A84E2960B2F039C463C36DB4CFF46DB0C3E0392172C7022591EE6495AFBE759828F713899994E138897A027F60D104C6A90EE08C9C3FBAE3C2BF7EB0CB613FD1DB2BFC34A677E8FB31EF780957F3D5FD9A4C41D".substring(0, 4) + "_" + "D55D10C78FAE31AEEA46BFF785E3CCD0144084E3E426D7A5CAABB8943E815EC235FD86CC426C537C2B6E5E99301FBD0ACB50B562E1867A9C92222F9BFD8F2359AD32A36D0F7D8BCDECCE523EBB4115DE250F5BEC19A11D563AD3FBB45E1A0E49B2D64DECEFE22DC01FC575CEA1A129A5765293168C0CDA1467873B91229ED398F417EB43671D87C41A2D713095F379F22FC4578FB8DB77A9F1897C014F4B5AAF06626AC970811098516FD82B4A84E2960B2F039C463C36DB4CFF46DB0C3E0392172C7022591EE6495AFBE759828F713899994E138897A027F60D104C6A90EE08C9C3FBAE3C2BF7EB0CB613FD1DB2BFC34A677E8FB31EF780957F3D5FD9A4C41D".substring(507, 511), Integer.valueOf(173));
        return new y("010001", "D55D10C78FAE31AEEA46BFF785E3CCD0144084E3E426D7A5CAABB8943E815EC235FD86CC426C537C2B6E5E99301FBD0ACB50B562E1867A9C92222F9BFD8F2359AD32A36D0F7D8BCDECCE523EBB4115DE250F5BEC19A11D563AD3FBB45E1A0E49B2D64DECEFE22DC01FC575CEA1A129A5765293168C0CDA1467873B91229ED398F417EB43671D87C41A2D713095F379F22FC4578FB8DB77A9F1897C014F4B5AAF06626AC970811098516FD82B4A84E2960B2F039C463C36DB4CFF46DB0C3E0392172C7022591EE6495AFBE759828F713899994E138897A027F60D104C6A90EE08C9C3FBAE3C2BF7EB0CB613FD1DB2BFC34A677E8FB31EF780957F3D5FD9A4C41D", 173);
    }

    public final boolean cgu() {
        return this.ver == 0 || bi.oW(this.qXe) || bi.oW(this.qXf);
    }

    y(String str, String str2, int i) {
        this.qXe = str;
        this.qXf = str2;
        this.ver = i;
    }

    public static boolean cgv() {
        Throwable e;
        Throwable th;
        boolean z = false;
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(e.bnE + "DefaultRSA.java");
            try {
                fileWriter.write("package com.tencent.mm.protocal;\n\n");
                fileWriter.write("/**\n *\n * @ClientVersion: " + d.CLIENT_VERSION + "\n");
                fileWriter.write(" * @DumpTime: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " \n */\n");
                fileWriter.write("public final class DefaultRSA {\n");
                fileWriter.write("\n\tpublic final static int BASE_RSA_PUBLIC_VERSION = 173;");
                fileWriter.write("\n\tpublic final static String BASE_RSA_PUBLIC_KEYN = \"D55D10C78FAE31AEEA46BFF785E3CCD0144084E3E426D7A5CAABB8943E815EC235FD86CC426C537C2B6E5E99301FBD0ACB50B562E1867A9C92222F9BFD8F2359AD32A36D0F7D8BCDECCE523EBB4115DE250F5BEC19A11D563AD3FBB45E1A0E49B2D64DECEFE22DC01FC575CEA1A129A5765293168C0CDA1467873B91229ED398F417EB43671D87C41A2D713095F379F22FC4578FB8DB77A9F1897C014F4B5AAF06626AC970811098516FD82B4A84E2960B2F039C463C36DB4CFF46DB0C3E0392172C7022591EE6495AFBE759828F713899994E138897A027F60D104C6A90EE08C9C3FBAE3C2BF7EB0CB613FD1DB2BFC34A677E8FB31EF780957F3D5FD9A4C41D\";");
                fileWriter.write("\n\tpublic final static String BASE_RSA_PUBLIC_KEYE = \"010001\";\n");
                fileWriter.write("\n\tpublic final static int REQ_RSA_PUBLIC_VERSION = 174;");
                fileWriter.write("\n\tpublic final static String REQ_RSA_PUBLIC_KEYN = \"D153E8A2B314D2110250A0A550DDACDCD77F5801F3D1CC21CB1B477E4F2DE8697D40F10265D066BE8200876BB7135EDC74CDBC7C4428064E0CDCBE1B6B92D93CEAD69EC27126DEBDE564AAE1519ACA836AA70487346C85931273E3AA9D24A721D0B854A7FCB9DED49EE03A44C189124FBEB8B17BB1DBE47A534637777D33EEC88802CD56D0C7683A796027474FEBF237FA5BF85C044ADC63885A70388CD3696D1F2E466EB6666EC8EFE1F91BC9353F8F0EAC67CC7B3281F819A17501E15D03291A2A189F6A35592130DE2FE5ED8E3ED59F65C488391E2D9557748D4065D00CBEA74EB8CA19867C65B3E57237BAA8BF0C0F79EBFC72E78AC29621C8AD61A2B79B\";");
                fileWriter.write("\n\tpublic final static String REQ_RSA_PUBLIC_KEYE = \"010001\";\n\n}\n");
                z = true;
                try {
                    fileWriter.close();
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.RsaInfo", e, "", new Object[0]);
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e4) {
                        }
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileWriter = null;
            x.printErrStackTrace("MicroMsg.RsaInfo", e, "", new Object[0]);
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e42) {
                }
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileWriter = null;
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e52) {
                }
            }
            throw th;
        }
        return z;
    }
}
