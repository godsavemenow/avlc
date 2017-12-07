package avlc;
import java.util.*;
	import Jama.Matrix;
	import Jama.util.*;

public class avlc {
	public static String mod(String s, int m) {

			if (s.length() % m == 0) {
			}

			if (s.length() % m != 0) {

				while (s.length() % m != 0) {
					s = s + s.charAt(s.length() - 1);
				}

			}

			return s;
		}

	
	
	
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("1 - codificar \n"
				+ "2 - decodificar");
		int option =in.nextInt();
		if(option==2) {
			
			in.nextLine();
			
			System.out.println("informe a frase a ser decodificada"); 
			String frase = in.nextLine();


			System.out.println("Informe a Matriz");
			int tamatrizd=2;

			int m = tamatrizd;
			int n = m;
			double matriz[][] = new double[m][n];
		
			for (int a = 0; a < m; a++) {
				for (int b = 0; b < n; b++) {
					matriz[a][b] = in.nextInt();
				}
			}
			
			double determinante = matriz[0][0]*matriz[1][1] - matriz[0][1]*matriz[1][0];
			determinante= determinante%26;
			
			double invdet=1;
			
			if (determinante%2== 1 & determinante != 13) {
				
				if (determinante==3) {
					invdet=9;
					}
				
				else if(determinante==5) {
					invdet=21;
					}
				else if(determinante==7) {
					invdet=15;
					}
				else if(determinante==9) {
					invdet=3;
					}
				
				else if(determinante==11) {
					invdet=19;
					}
				
				else if(determinante==15) {
					invdet=7;
					}
				
				else if(determinante==17) {
					invdet=23;
					}
				
				else if(determinante==19) {
					invdet=11;
					}
				
				else if(determinante==21) {
					invdet=5;
					}
				
				else if(determinante==23) {
					invdet=17;
					}
				
				}
			 else {
				System.out.println("Matriz Inválida");
				System.exit(0);
			}
			
			
			matriz[0][0]=matriz[0][0]*invdet;
			matriz[0][1]=matriz[0][1]*invdet;
			matriz[1][0]=matriz[1][0]*invdet;
			matriz[1][1]=matriz[1][1]*invdet;
			
			
			double traderprin;
			
			
			traderprin=matriz[0][0];
			matriz[0][0]=matriz[1][1];
			matriz[1][1]=traderprin;
			
			
			matriz[1][0]=-1*matriz[1][0];
			matriz[0][1]=-1*matriz[0][1];
			
			
			while(matriz[0][0]<0){
				
				matriz[0][0]=matriz[0][0]+26;
					
			}
			
			matriz[0][0] = matriz[0][0]%26;
			
			while (matriz[1][0] < 0) {

				matriz[1][0] = matriz[1][0] + 26;

			}
			matriz[1][0] = matriz[1][0]%26;
			
			while (matriz[0][1] < 0) {

				matriz[0][1] = matriz[0][1] + 26;

			}
			matriz[0][1] = matriz[0][1]%26;
			
			while (matriz[1][1] < 0) {

				matriz[1][1] = (matriz[1][1] + 26);

			}
			matriz[1][1] = (matriz[1][1])%26;
			
			
			
			double a, b, c;

int cont=0;
			if (tamatrizd == 2) {
				while (cont < frase.length() / 2) {
					double[] letters = new double[tamatrizd];

					letters[0] = frase.charAt(0 + cont * 2) - 96;
					letters[1] = frase.charAt(1 + cont * 2) - 96;

					cont++;
					/*
					 * System.out.println(matriz[0][0]+" "+matriz[0][1]);
					 * System.out.println(matriz[1][0]+" "+matriz[1][1]);
					 */
					a = matriz[0][0] * letters[0] + matriz[0][1] * letters[1];
					b = matriz[1][0] * letters[0] + matriz[1][1] * letters[1];

					if (a >= 26) {

						a = a % 26;
					}
					if (b >= 26) {

						b = b % 26;
					}

					char chara = (char) (a + 96);
					char charb = (char) (b + 96);

					if (a != 0) {
						System.out.print(chara);
					} else if (a == 0) {
						System.out.print("z");
					}

					if (b != 0) {
						System.out.print(charb);
					} else if (b == 0) {
						System.out.print("z");
					}

				}

			}

		
	}

		
		//// CODIFICA
		
		
		if(option==1) {
			
			
			
			in.nextLine();
			System.out.println("Informe a frase a ser codificada:");

			String lul = in.nextLine();
			String Trocar = lul.toLowerCase().replaceAll(" ", "");
			// System.out.println(Replacelul);
			
			int cont = 0;
			System.out.println("Informe a Matriz");
			int tamatriz=2;
			int m = tamatriz;
			int n = m;
			double matriz[][] = new double[m][n];
			Trocar = mod(Trocar, tamatriz);
			for (int a = 0; a < m; a++) {
				for (int b = 0; b < n; b++) {
					matriz[a][b] = in.nextInt();
				}
			}
			
			
			double a, b, c;

			if (tamatriz == 3) {
				while (cont < Trocar.length() / tamatriz) {
					double[] letters = new double[tamatriz];

					letters[0] = Trocar.charAt(0 + cont * 3) - 96;
					letters[1] = Trocar.charAt(1 + cont * 3) - 96;
					letters[2] = Trocar.charAt(2 + cont * 3) - 96;
					cont++;

					a = matriz[0][0] * letters[0] + matriz[0][1] * letters[1]
							+ matriz[0][2] * letters[2];
					b = matriz[1][0] * letters[0] + matriz[1][1] * letters[1]
							+ matriz[1][2] * letters[2];
					c = matriz[2][0] * letters[0] + matriz[2][1] * letters[1]
							+ matriz[2][2] * letters[2];

					if (a >= 26) {

						a = a % 26;
					}
					if (b >= 26) {

						b = b % 26;
					}
					if (c >= 26) {

						c = c % 26;
					}

					char chara3 = (char) (a + 96);
					char charb3 = (char) (b + 96);
					char charc3 = (char) (c + 96);

					if (a != 0) {
						System.out.print(chara3);
					} else if (a == 0) {
						System.out.print("z");
					}

					if (b != 0) {
						System.out.print(charb3);
					} else if (b == 0) {
						System.out.print("z");
					}

					if (c != 0) {
						System.out.print(charc3);
					} else if (c == 0) {
						System.out.print("z");
					}
				}

			}

			if (tamatriz == 2) {
				while (cont < Trocar.length() / 2) {
					double[] letters = new double[tamatriz];

					letters[0] = Trocar.charAt(0 + cont * 2) - 96;
					letters[1] = Trocar.charAt(1 + cont * 2) - 96;

					cont++;
					/*
					 * System.out.println(matriz[0][0]+" "+matriz[0][1]);
					 * System.out.println(matriz[1][0]+" "+matriz[1][1]);
					 */
					a = matriz[0][0] * letters[0] + matriz[0][1] * letters[1];
					b = matriz[1][0] * letters[0] + matriz[1][1] * letters[1];

					if (a >= 26) {

						a = a % 26;
					}
					if (b >= 26) {

						b = b % 26;
					}

					char chara = (char) (a + 96);
					char charb = (char) (b + 96);

					if (a != 0) {
						System.out.print(chara);
					} else if (a == 0) {
						System.out.print("z");
					}

					if (b != 0) {
						System.out.print(charb);
					} else if (b == 0) {
						System.out.print("z");
					}

				}

			}

		}
		}
		
		
		
		
		
	}