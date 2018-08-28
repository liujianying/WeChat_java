package com.tencent.mm.z;

public final class a {
    public String appId = "";
    public String bGW = "";
    public int bGX = 0;
    public String cfD = "";
    public int dGs = 0;
    public int dGt = 0;
    public boolean dGu = false;
    public boolean dGv = false;
    public long dGw = 0;
    public double dGx = 1.0d;
    public d dGy;
    public String filePath = "";
    public int fromScene = 0;
    public String processName = "";

    public final boolean a(a aVar) {
        if (aVar == null || this.bGW == null || !this.bGW.equalsIgnoreCase(aVar.bGW) || this.cfD == null || !this.cfD.equalsIgnoreCase(aVar.cfD)) {
            return false;
        }
        return true;
    }
}
