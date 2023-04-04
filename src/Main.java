
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Graph graph = new Graph();

		graph.readFile("bus_routes.txt");

		while (true) {
			System.out.println("Seciminizi yapiniz: ");
			System.out.println("1-Komsuluk listesinin icerigini listele.\n"
        			+ "2-Istenilen sehrin dugumunun giris ve cikis derecelerini hesapla.\n"
        			+ "3-Graftaki toplam kenar sayisini hesapla.\n"
        			+ "4-Plakadan hangi sehirlere gidildigini yazdir.\n"
        			+ "5-Plakadan hangi sehirlerden gelindigini yazdir.\n");

			int secim = scan.nextInt();

			switch (secim) {
			case 1:
				graph.printAdjacencyList();
				break;
			case 2:
				System.out.println("Hangi sehrin giris ve cikis derecelerini ogrenmek istiyorsunuz(plakasini giriniz): ");
				int plate = scan.nextInt();
				String city = change(plate);
				graph.printInOutDegrees(city);
			case 3:
				System.out.println("Toplam kenar sayisi: " + graph.totalEdges());
				break;
			case 4:
				System.out.println("Gidebileceginiz sehirler icin plakayi giriniz:  ");
				int plate2 = scan.nextInt();
				String city2 = change(plate2);
				graph.printDestinations(city2);
				break;
			case 5:
				System.out.println("bulundugunuz sehire giden sehirleri bulmak icin plakasini giriniz: ");
				int plate3 = scan.nextInt();
				String city3 = change(plate3);
				graph.printSources(city3);
				break;
			default:
				System.out.println("Hatali secim yaptiniz");
			}
		}

	}
    
    static String change(int plate) {
		String city = "";
		if (plate == 42)
			city = "Konya/42";
		else if (plate == 07)
			city = "Antalya/07";
		else if (plate == 33)
			city = "Mersin/33";
		else if (plate == 34)
			city = "İstanbul/34";
		else if (plate == 52)
			city = "Ordu/52";
		else if (plate == 38)
			city = "Kayseri/38";
		else if (plate == 02)
			city = "Adıyaman/02";
		return city;
	}

}
