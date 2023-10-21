import java.net.*;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class UdpServer {

  private static final java.text.DateFormat DF = java.text.DateFormat.getDateTimeInstance();

  private static String getTime() {
    return DF.format(new java.util.Date());
  }
  
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
  
  public static void main(String[] args) {
	  System.out.println("Server Start ..");
	  
	//initializare tabla
        int[][] a = new int[5][5];
        int[] b = new int[17];
        int x = 0, y = 0, v, n, aux, option;
        char ch, m = (char) 254;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 16; i++)
            b[i] = 0;

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                do {
                    v = 1 + rand.nextInt(16);
                } while (b[v] == 1);
                b[v] = 1;
                a[i][j] = v;
                if (a[i][j] == 16) {
                    x = i;
                    y = j;
                }
            }
        }
        
      n = 1000; //exista 1000 de incercari valide pt a realiza puzzle-ul

  	try {
      DatagramSocket ds = new DatagramSocket(55000);
      DatagramPacket dp = new DatagramPacket(new byte[120], 120);
      String resp;
      
      while (true) {
        ds.receive(dp);
        String strPrimit = new String(dp.getData()).trim();
        System.out.println("Am primit de la client " + "   " + strPrimit + " von Port " + dp.getPort());
       
        while (n > 0) {
            clearScreen();
            System.out.println("-------------------------------------------------------");
            System.out.println("*  Instructiuni  *");
            System.out.println("Cu ajutorul sagetilor din tastatura, mutati patratelele");
            System.out.println("punand numerele in ordine.");
            System.out.println("BAFTA");
            System.out.println("--------------------------------------------------------\n");
            for (int i = 1; i <= 4; i++) {
                for (int j = 1; j <= 4; j++)
                    if (a[i][j] == 16)
                        System.out.printf("%3c", m);
                    else
                        System.out.printf("%3d", a[i][j]);
                System.out.println();
            }
            System.out.println("pozitia libera este (" + x + "," + y + ")");

            ch = scanner.next().charAt(0);

            switch (ch) {
                case 'w':
                    if (x > 1) {
                        aux = a[x][y];
                        a[x][y] = a[x - 1][y];
                        a[x - 1][y] = aux;
                        x--;
                    }
                    break;
                case 's':
                    if (x < 4) {
                        aux = a[x][y];
                        a[x][y] = a[x + 1][y];
                        a[x + 1][y] = aux;
                        x++;
                    }
                    break;
                case 'd':
                    if (y < 4) {
                        aux = a[x][y];
                        a[x][y] = a[x][y + 1];
                        a[x][y + 1] = aux;
                        y++;
                    }
                    break;
                case 'a':
                    if (y > 1) {
                        aux = a[x][y];
                        a[x][y] = a[x][y - 1];
                        a[x][y - 1] = aux;
                        y--;
                    }
                    break;
                default:
                    System.out.println("Invalid input!");
            }

            n--;
       
            // Verificam daca jocul a fost terminat cu succes
            boolean gameWon = true;
            for (int i = 1; i <= 4; i++) {
                for (int j = 1; j <= 4; j++) {
                    int expectedValue = (i - 1) * 4 + j;
                    if (a[i][j] != expectedValue) {
                        gameWon = false;
                        break;
                    }
                }
            }
          
            if (gameWon) {
                System.out.println("Ai castigat!");
                break;
            }
        }
        
        
    
        System.out.println("Timp trimitere: " +  getTime()); 
      //  dp.setData(s.getBytes());
        ds.send(dp);        
      }

      
    } catch (SocketException e) { e.printStackTrace();}
	  catch (IOException e) { e.printStackTrace();}
  }
}
