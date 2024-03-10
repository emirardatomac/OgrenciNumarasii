public class Main {
    public static void main(String[] args) {
        Ogrenci ogrenci1 = new Ogrenci("Gökhan", "Bilgisayar Müh", 1985);
        Ogrenci ogrenci2 = new Ogrenci("Ayşe", "Makine Müh", 1985);
        Ogrenci ogrenci3 = new Ogrenci("Elif", "Elektrik-Elektronik Müh", 2020);

        System.out.println("Öğrenci Bilgileri:");
        System.out.println("OGR-1 " + ogrenci1.getAd() + " " + ogrenci1.getBolum() + " " +
                ogrenci1.getGirisYili() + ogrenci1.getOgrNo() + " " + ogrenci1.getGano());

        System.out.println("OGR-2 " + ogrenci2.getAd() + " " + ogrenci2.getBolum() + " " +
                ogrenci2.getGirisYili() + ogrenci2.getOgrNo() + " " + ogrenci2.getGano());

        System.out.println("OGR-3 " + ogrenci3.getAd() + " " + ogrenci3.getBolum() + " " +
                ogrenci3.getGirisYili() + ogrenci3.getOgrNo() + " " + ogrenci3.getGano());

        double harc3 = ogrenci3.harcHesapla(4); // 4 ders
        double harc4 = ogrenci3.harcHesapla(8, 2); // 8 ders, 2 yıl uzatma

        System.out.println("3. öğrencinin ödeyeceği harç: " + harc3 + " TL");
        System.out.println("4. öğrencinin ödeyeceği harç: " + harc4 + " TL");
    }
}

class Ogrenci {
    private String ad;
    private String bolum;
    private int girisYili;
    private String ogrNo;
    private double gano;

    public Ogrenci() {

    }

    public Ogrenci(String ad, String bolum, int girisYili, double gano) {
        this.ad = ad;
        this.bolum = bolum;
        this.girisYili = girisYili;
        setGano(gano);
        this.ogrNo = hesaplaOgrNo();
    }

    public Ogrenci(String ad, String bolum, int girisYili) {
        this(ad, bolum, girisYili, 0.0);
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getGirisYili() {
        return girisYili;
    }

    public void setGirisYili(int girisYili) {
        this.girisYili = girisYili;
    }

    public String getOgrNo() {
        return ogrNo;
    }

    public double getGano() {
        return gano;
    }

    public void setGano(double gano) {
        if (gano >= 0 && gano <= 4) {
            this.gano = gano;
        } else {
            throw new IllegalArgumentException("Gano 0 ile 4 arasında olmalıdır.");
        }
    }

    private String hesaplaOgrNo() {
        String yil = Integer.toString(girisYili % 100);
        String sira = Integer.toString(1001); // Başlangıç sırası 1001

        return String.format("%02d%s%s", girisYili % 100, sira, yil);
    }

    public double harcHesapla(int dersSayisi) {
        double dersUcreti = 1000;
        return dersUcreti * dersSayisi;
    }

    public double harcHesapla(int dersSayisi, int uzatilanYil) {
        double dersUcreti = 1000;
        return dersUcreti * dersSayisi + (uzatilanYil * 500);
    }
}