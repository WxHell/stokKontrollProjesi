    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.Scanner;

    public class Main {
        static String userName="root";
        static String password="1234";
       static Scanner sc =new Scanner(System.in);
       static HashMap<String, Integer>db=new HashMap<String, Integer>();
       static boolean deneme=true;
       static boolean bitir=true;

        public static void main(String[] args) {
            db.put("Kitap".toUpperCase(),23);
            db.put("Lastik".toUpperCase(),10);
            db.put("Bardak".toUpperCase(),50);
            show();
            secımEkranı();
        }

        public static void show(){
            while (deneme) {
                System.out.println("Kullanıcı Adını Giriniz ");
                String userInput = sc.nextLine();
                System.out.println("Şİfreyi giriniz ");
                String userPassword=sc.nextLine();
                if (userInput.equals(userName) && userPassword.equals(password)){
                    System.out.println("Giriş Başarılı");
                    break;

                }else {
                    System.out.println("Kullanıcı adı veya şfiresi yanlış ");
                }
                }
            }

        public static void secımEkranı(){
           while (bitir){
               System.out.println("""
                        \nYapmak İstediğiniz İşlemi Seçin
                        1->Ürün Ekleme
                        2->Ürün Satın Alma
                        3->Ürünleri Göster
                        4->Ürün Sorgula
                        5->Çık
                        """);
                int secim=sc.nextInt();
               switch (secim){
                   case 1 -> urunEkleme();
                   case 2 ->urunAl();
                   case 3 ->urunuYazdır();
                   case 4 ->stokSorgulama();
                   case 5-> {
                       System.out.println("Bay Bay");
                       bitir = false;
                       break;
                   }
                   default -> System.out.println("Hatalı Giriş");
               }
           }

        }


        public static void urunuYazdır(){
            for (Map.Entry<String,Integer>entry :db.entrySet()){
                System.out.println("Product: "+entry.getKey()+" Adet: "+entry.getValue());
            }
            //Map, Java Collections Framework 'un bir üyesidir. Map (gönderim) anahtarları değerlere eşleştiren
            //bir nesnedir.Unutma bu kısımı!!
        }

        public static void urunAl(){
            String urunGir=sc.nextLine().toUpperCase();
            Integer urunDeger=db.get(urunGir);
            int aldıgıAdet=sc.nextInt();
            sc.nextLine();
            if (urunDeger!=null){
                urunDeger-=aldıgıAdet;
                if (urunDeger<=0){
                    System.out.println(urunGir+" stoklarda kalmamıştır");
                }else {
                    db.put(urunGir,urunDeger);
                }
            }else {
                System.out.println("ürün bulunamadı");
            }

        }

        public static void urunEkleme(){

            System.out.println("Eklemek İstediğiniz Ürünü Giriniz");
            String urunGir=sc.nextLine();
            System.out.println("Eklemek İstediğiniz Adet Sayısını giriniz");
            Integer urunAdet=sc.nextInt();
            sc.nextLine();
            Integer urunDeger=db.get(urunAdet);
            if (urunDeger == null) {
                urunDeger = 0;
            }
            urunDeger=urunDeger+urunAdet;
            System.out.println("Başarıyla Eklendi");
            db.put(urunGir.toUpperCase(),urunDeger);
        }

        public static void stokSorgulama(){
            System.out.println("Sorgulamak İstediğiniz Ürünü Yazınız");
            String sorgu=sc.nextLine();
            Integer urunAdet=db.get(sorgu.toUpperCase());
            if (urunAdet!=null){
                System.out.println("Ürünümüz: "+sorgu.toUpperCase()+" Adeti: "+urunAdet);
                if (urunAdet==0){
                    System.out.println("Ürünümüz: "+sorgu.toUpperCase()+" Stokta kalmamıştır");
                }
            }else {
                System.out.println("Ürünümüz Bulunmamaktadır");
            }
        }

    }
