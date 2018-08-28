package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.platformtools.h;
import com.tencent.mm.sdk.platformtools.x;
import f.a.a.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bk.a {
    String mbY;
    private boolean mbZ;
    LinkedList<i> mca = new LinkedList();
    private boolean mcb;

    public final a JN(String str) {
        this.mbY = str;
        this.mbZ = true;
        return this;
    }

    public final a uT(int i) {
        boolean z = false;
        if (i >= 0 && i < this.mca.size()) {
            if (i >= 10) {
                this.mca.remove(i);
            } else {
                this.mca.remove(i);
                Iterator it = this.mca.iterator();
                int i2 = -1;
                int i3 = Integer.MIN_VALUE;
                int i4 = 0;
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    int i5 = i4 + 1;
                    if (i4 >= 10) {
                        int i6;
                        if (i3 < iVar.mcC) {
                            i3 = iVar.mcC;
                            i6 = i5;
                        } else {
                            i6 = i2;
                        }
                        i2 = i6;
                        i4 = i5;
                    } else {
                        i4 = i5;
                    }
                }
                if (i2 != -1 && i2 < this.mca.size()) {
                    try {
                        a((i) this.mca.remove(i2));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AddrBook", e, "size:%d, idx:%d", new Object[]{Integer.valueOf(this.mca.size()), Integer.valueOf(i2)});
                    }
                }
            }
            if (this.mca.size() > 0) {
                z = true;
            }
            this.mcb = z;
        }
        return this;
    }

    public final a a(i iVar) {
        i iVar2;
        int i = 0;
        if (!this.mcb) {
            this.mcb = true;
        }
        Iterator it = this.mca.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iVar2 = (i) it.next();
            if (i2 >= 10) {
                if (a(iVar, iVar2)) {
                    break;
                }
            } else if (iVar.mcC > iVar2.mcC) {
                break;
            }
            i2++;
        }
        if (i2 >= this.mca.size()) {
            this.mca.add(iVar);
        } else {
            this.mca.add(i2, iVar);
            if (i2 < 10 && this.mca.size() > 10) {
                iVar2 = (i) this.mca.remove(10);
                it = this.mca.iterator();
                while (it.hasNext()) {
                    i iVar3 = (i) it.next();
                    if (i >= 10 && a(iVar2, iVar3)) {
                        break;
                    }
                    i++;
                }
                if (i >= this.mca.size()) {
                    this.mca.add(iVar2);
                } else {
                    this.mca.add(i, iVar2);
                }
            }
        }
        return this;
    }

    private static boolean a(i iVar, i iVar2) {
        if (iVar == null || iVar2 == null) {
            return false;
        }
        int compareTo = b(iVar).compareTo(b(iVar2));
        if (compareTo == 0) {
            if (iVar.kCs.compareTo(iVar2.kCs) > 0) {
                return false;
            }
            return true;
        } else if (compareTo >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static String b(i iVar) {
        String str = iVar.mcD;
        if (str == null || "".equals(str)) {
            str = JO(h.oI(iVar.name.trim()).toLowerCase());
        } else {
            str = JO(str);
        }
        iVar.mcD = str;
        return str;
    }

    public static String JO(String str) {
        if (str == null || str.length() <= 0) {
            x.d("MicroMsg.getAdjustFullSpell", "%s", new Object[]{"srcName is null or empty, adjust full spell = ~"});
            return "~";
        }
        char[] toCharArray = str.toCharArray();
        int i = 0;
        while (i < toCharArray.length) {
            char c = toCharArray[i];
            if (c >= '0' && c <= '9') {
                return String.format("{%c%s", new Object[]{Character.valueOf(c), str});
            } else if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                if (c == '{' && i == 0 && toCharArray.length > 1 && toCharArray[i + 1] >= '0' && toCharArray[i + 1] <= '9') {
                    return str;
                }
                i++;
            } else if (i == 0) {
                return str;
            } else {
                return String.format("%c%s", new Object[]{Character.valueOf(c), str});
            }
        }
        x.d("MicroMsg.getAdjustFullSpell", "%s is not ok, return '~'", new Object[]{str});
        return "~";
    }

    public final String toString() {
        return ((("" + getClass().getName() + "(") + "syncInfo = " + this.mbY + "   ") + "addrs = " + this.mca + "   ") + ")";
    }

    private a boh() {
        if (this.mbZ) {
            return this;
        }
        throw new b("Not all required fields were included (false = not included in message),  syncInfo:" + this.mbZ);
    }

    public final int boi() {
        return (f.a.a.b.b.a.h(1, this.mbY) + 0) + (f.a.a.a.c(2, 8, this.mca) + 0);
    }

    public final byte[] toByteArray() {
        boh();
        return super.toByteArray();
    }

    public final void a(f.a.a.c.a aVar) {
        aVar.g(1, this.mbY);
        aVar.d(2, 8, this.mca);
    }

    /* renamed from: aF */
    public final a aG(byte[] bArr) {
        f.a.a.a.a aVar = new f.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a(aVar); a > 0; a = a(aVar)) {
            boolean z;
            switch (a) {
                case 1:
                    JN(aVar.vHC.readString());
                    z = true;
                    break;
                case 2:
                    int i;
                    LinkedList IC = aVar.IC(2);
                    for (i = 0; i < IC.size(); i++) {
                        byte[] bArr2 = (byte[]) IC.get(i);
                        i iVar = new i();
                        f.a.a.a.a aVar2 = new f.a.a.a.a(bArr2, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar2, iVar, a(aVar2))) {
                        }
                        if (!this.mcb) {
                            this.mcb = true;
                        }
                        this.mca.add(iVar);
                    }
                    i[] iVarArr = (i[]) this.mca.toArray(new i[1]);
                    Arrays.sort(iVarArr, new 1(this));
                    if (10 <= iVarArr.length) {
                        Arrays.sort(iVarArr, 10, iVarArr.length, new 2(this));
                    }
                    this.mca.clear();
                    for (Object add : iVarArr) {
                        this.mca.add(add);
                    }
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (!z) {
                aVar.cJS();
            }
        }
        return boh();
    }
}
