package org.example;

import java.util.ArrayList;
import java.util.List;

// Ana sınıf
public class Main {
    public static void main(String[] args) {
        TeamLead lider = new TeamLead("Ahmet", "Yılmaz", "01.01.1980");
        Departman departman = new Departman(lider);

        Personel personel1 = new Erkek("Mehmet", "Demir", "15.06.1990");
        Personel personel2 = new Kadın("Ayşe", "Kaya", "20.03.1985");

        departman.çalışanEkle(personel1);
        departman.çalışanEkle(personel2);

        departman.görevEkle("Proje yönetimi");
        departman.görevEkle("Test senaryolarını hazırlama");

        System.out.println("Emeklilik yaşı - Mehmet: " + personel1.emeklilikYaşıHesapla());
        System.out.println("Emeklilik yaşı - Ayşe: " + personel2.emeklilikYaşıHesapla());
    }
}

// Departman sınıfı
class Departman {
    private TeamLead teamLead;
    private List<Personel> personelListesi;
    private List<String> görevListesi;

    public Departman(TeamLead teamLead) {
        this.teamLead = teamLead;
        this.personelListesi = new ArrayList<>();
        this.görevListesi = new ArrayList<>();
    }

    public void çalışanEkle(Personel personel) {
        personelListesi.add(personel);
    }

    public void çalışanÇıkar(Personel personel) {
        personelListesi.remove(personel);
    }

    public void görevEkle(String görev) {
        görevListesi.add(görev);
    }

    public void görevTamamlandı(String tamamlananGörev) {
        görevListesi.remove(tamamlananGörev);
    }
}

// TeamLead sınıfı
class TeamLead extends Personel {
    public TeamLead(String ad, String soyad, String doğumTarihi) {
        super(ad, soyad, doğumTarihi);
    }

    @Override
    public int emeklilikYaşıHesapla() {
        return 65;
    }
}

// Personel sınıfı (abstract)
abstract class Personel {
    private String ad;
    private String soyad;
    private String doğumTarihi;

    public Personel(String ad, String soyad, String doğumTarihi) {
        this.ad = ad;
        this.soyad = soyad;
        this.doğumTarihi = doğumTarihi;
    }

    public abstract int emeklilikYaşıHesapla();
}

// Kadın sınıfı
class Kadın extends Personel {
    public Kadın(String ad, String soyad, String doğumTarihi) {
        super(ad, soyad, doğumTarihi);
    }

    @Override
    public int emeklilikYaşıHesapla() {
        return 60;
    }
}

// Erkek sınıfı
class Erkek extends Personel {
    public Erkek(String ad, String soyad, String doğumTarihi) {
        super(ad, soyad, doğumTarihi);
    }

    @Override
    public int emeklilikYaşıHesapla() {
        return 65;
    }
}
