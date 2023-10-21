C.	READ ME
Pentru a refacerea aplicației, urmați acești pași:
Instalați Java. --> Versiunea recomandată este Java 11.0.11. --> Pentru a instala Java, accesați site-ul oficial Java (Download Java for Windows) și descărcați versiunea potrivită pentru sistemul de operare folosit.
Instalați un editor de text. -- > Un editor recomandat este IntelliJ IDEA, dar puteți folosi și altele, cum ar fi Eclipse sau NetBeans.
Modificați fișierele de configurare ale aplicației pentru a se potrivi cu setările dorite, cum ar fi adresa IP și portul serverului.
După ce ați finalizat modificările dorite, compilați și construiți aplicația.

PASI DE RULARE A APLICAȚIEI
Pentru a rula aplicația, urmați acești pași:
•	Asigurați-vă că ați efectuat toți pașii de refacere a aplicației.
•	Porniți serverul folosind comanda java UdpServer [parametrii de start].
•	Porniți clientul folosind comanda java UdpClient [parametrii de start].
•	Folosiți aplicația conform instrucțiunilor specifice.

Exemplu rulare server
"C:\Program Files\Java\jdk-19\bin\javac.exe" -version
cd Desktop
cd PUZZLE
"C:\Program Files\Java\jdk-19\bin\javac.exe" UdpServer.java
java UdpServer 

a
s
d
w
----------------------
Rulare Client
"C:\Program Files\Java\jdk-19\bin\javac.exe" -version
cd Desktop
cd PUZZLE
"C:\Program Files\Java\jdk-19\bin\javac.exe" UdpClient.java
java UdpClient a
Apoi se termina rezolvarea in server 


PARAMETRII DE START
Pentru a specifica parametrii de start pentru server și client, puteți utiliza următoarele argumente:
-prima mutare se face in client cu ajutorul comenzii java UdpServer a/s/d/w
-apoi se continua rezolvarea puzzle-ului in server unde se muta piesele cu ajutorul butoanelor a/s/d/w
	a --> mutare la stanga
	s --> mutare in jos
	d --> mutare la dreapta
	w --> mutare in sus

ENUNTARE PROBLEMA SI METODA DE UTILIZARE
Jocul este în totalitate că cel din realitate, doar că se regăsește în spațiul online, pe calculator. 
Jocul are un singur jucător, care trebuie să reușească să dezlege metoda pentru aranjare a pieselor, astfel încât numerele să fie ordonate crescător de la 1 la 15, la final fiind un spațiu liber. De fiecare data, matricea în care se regăsesc piesele jocului va fi rearanjată random pentru a face jocul mai interactiv si mai distractiv. 
Astfel, pașii care trebuie urmați sunt simpli:
1.	se muta cu ajutorul săgeților tastaturii pătrățelele, în sus, în jos, în stangă sau în dreapta până se poziționează corect pentru a realiza următorul model:
		1    2    3    4    
		5    6    7    8     
		9    10  11  12
		13   14  15   ◙
2.	permanent vă fi specificata poziția libera sub forma unui element al unui tablou bidimensional definit prin numărul liniei și al coloanei corespunzătoare
3.	se mentioneza faptul că poate dura ceva timp  realizarea acestuia, iar jucatorul are un număr limitat de mutări.
4.	jocul se termina atunci când ori ai reușit sa rezolvi puzzle-ul, ori când ai ramas fara mutari valabile.
Dupa conexiunea cu clientul, toate modificarile jocului se intampla in server. Astfel, se alege mutarea pe care ti-o doresti, (exemplu a-->mutare la stanga), apoi se apasa ENTER pentru a se efectua mutarea.


VERSIUNI SOFTWARE UTILIZATE
Pentru dezvoltarea și testarea aplicației noastre, am utilizat următoarele versiuni software:
Java 11.0.11
Spring Boot 2.5.0
Maven 3.6.3
Hibernate 5.4.31

